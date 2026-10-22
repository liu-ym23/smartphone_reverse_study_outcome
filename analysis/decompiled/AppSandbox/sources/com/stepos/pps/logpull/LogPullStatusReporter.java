package com.stepos.pps.logpull;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.stepos.pps.data.util.DeviceUtils;
import com.stepos.pps.reflect.BuildExtStepOS;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import kotlin.io.ConstantsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LogPullStatusReporter {
    private static final String API_PREFIX = "/v1/logpull";
    private static final String TAG = "LogPull.Reporter";
    public static final String UPLOAD_TYPE_MULTIPART = "multipart";
    public static final String UPLOAD_TYPE_NORMAL = "normal";
    private final Supplier<String> baseUrlSupplier;
    private final Context context;

    public LogPullStatusReporter(Context context, Supplier<String> supplier) {
        this.context = context != null ? context.getApplicationContext() : null;
        this.baseUrlSupplier = supplier;
    }

    private String baseUrl() {
        Supplier<String> supplier = this.baseUrlSupplier;
        return trimTrailingSlash(supplier != null ? supplier.get() : null);
    }

    public List<LogPullConfig> check(String str) {
        List<LogPullConfig> list;
        long jNowMs;
        String nonceKey;
        String strForCheck;
        String str2 = baseUrl() + "/v1/logpull/config/check";
        try {
            jNowMs = LogPullNonce.nowMs();
            try {
                nonceKey = LogPullNonce.getNonceKey();
                strForCheck = LogPullNonce.forCheck(str, jNowMs);
                list = null;
            } catch (Exception e) {
                e = e;
                list = null;
            }
        } catch (Exception e2) {
            e = e2;
            list = null;
            jNowMs = 0;
        }
        try {
            StringBuilder sb = new StringBuilder("config/check 请求准备 url=");
            sb.append(str2);
            sb.append(" oaidLen=");
            sb.append(str == null ? 0 : str.length());
            sb.append(" timestamp=");
            sb.append(jNowMs);
            sb.append(" nonceKeyEmpty=");
            sb.append(nonceKey == null || nonceKey.isEmpty());
            Log.i(TAG, sb.toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LogPullAuthActivity.EXTRA_OAID, str);
            jSONObject.put("timestamp", jNowMs);
            jSONObject.put("nonce", strForCheck);
            JSONObject jSONObjectPostJson = postJson("/v1/logpull/config/check", jSONObject);
            if (jSONObjectPostJson == null) {
                Log.w(TAG, "config/check 返回 null（连接失败或空响应），url=" + str2);
                return null;
            }
            int iOptInt = jSONObjectPostJson.optInt("code", -1);
            if (iOptInt != 200) {
                Log.w(TAG, "config/check 业务失败: code=" + iOptInt + " msg=" + jSONObjectPostJson.optString("message") + " raw=" + truncate(jSONObjectPostJson.toString(), ConstantsKt.MINIMUM_BLOCK_SIZE));
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectPostJson.optJSONArray(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                int i = 0;
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject == null) {
                        i++;
                    } else {
                        try {
                            arrayList.add(parseConfig(jSONObjectOptJSONObject));
                        } catch (Exception e3) {
                            i++;
                            Log.w(TAG, "config/check 跳过异常条目 index=" + i2 + " ex=" + e3.getClass().getSimpleName() + " msg=" + e3.getMessage());
                        }
                    }
                }
                if (i > 0) {
                    Log.w(TAG, "config/check 有 " + i + " 条配置解析失败已跳过");
                }
                if (arrayList.isEmpty()) {
                    Log.w(TAG, "config/check 所有条目解析失败 count=" + jSONArrayOptJSONArray.length());
                    return null;
                }
                Log.i(TAG, "config/check 成功，有待办任务 count=" + arrayList.size());
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    LogPullConfig logPullConfig = (LogPullConfig) arrayList.get(i3);
                    Log.i(TAG, "config/check 待办[" + i3 + "] configId=" + logPullConfig.configId + " types=" + Arrays.toString(logPullConfig.logTypes) + " range=" + logPullConfig.logStartTime + "~" + logPullConfig.logEndTime);
                }
                return arrayList;
            }
            Log.i(TAG, "config/check 成功，无待办任务 data=[]");
            return Collections.EMPTY_LIST;
        } catch (Exception e4) {
            e = e4;
            Throwable thRootCause = rootCause(e);
            Log.e(TAG, "config/check 异常 url=" + str2 + " timestamp=" + jNowMs + " ex=" + e.getClass().getName() + " msg=" + e.getMessage() + " rootEx=" + thRootCause.getClass().getName() + " rootMsg=" + thRootCause.getMessage(), e);
            return list;
        }
    }

    public boolean reportStatus(long j, String str, int i, String str2) {
        return reportStatusResult(j, str, i, str2).ok;
    }

    public ReportResult reportStatusResult(long j, String str, int i, String str2) throws JSONException {
        try {
            long jNowMs = LogPullNonce.nowMs();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LogPullAuthActivity.EXTRA_OAID, str);
            jSONObject.put("configId", j);
            jSONObject.put("status", i);
            jSONObject.put("timestamp", jNowMs);
            jSONObject.put("nonce", LogPullNonce.forStatus(str, j, i, jNowMs));
            if (str2 != null) {
                jSONObject.put("reason", str2);
            }
            putDeviceInfo(jSONObject);
            JSONObject jSONObjectPostJson = postJson("/v1/logpull/status/report", jSONObject);
            if (jSONObjectPostJson == null) {
                return new ReportResult(false, -1, "空响应");
            }
            int iOptInt = jSONObjectPostJson.optInt("code", -1);
            String strOptString = jSONObjectPostJson.optString("message", "");
            if (iOptInt == 200) {
                Log.i(TAG, "状态上报成功: configId=" + j + " status=" + i);
                return new ReportResult(true, iOptInt, strOptString);
            }
            Log.w(TAG, "状态上报失败: code=" + iOptInt + " msg=" + strOptString);
            return new ReportResult(false, iOptInt, strOptString);
        } catch (Exception e) {
            Log.e(TAG, "状态上报异常", e);
            return new ReportResult(false, -1, e.getMessage());
        }
    }

    public static class ReportResult {
        public final int code;
        public final String message;
        public final boolean ok;

        public ReportResult(boolean z, int i, String str) {
            this.ok = z;
            this.code = i;
            this.message = str;
        }
    }

    public UploadUrlResult requestUploadUrl(long j, String str, long j2) {
        return requestUploadUrl(j, str, j2, UPLOAD_TYPE_NORMAL, 0L, null, null);
    }

    public UploadUrlResult requestUploadUrl(long j, String str, long j2, String str2, long j3, String str3, String str4) throws JSONException {
        String str5;
        UploadUrlResult uploadUrlResult = new UploadUrlResult();
        try {
            long jNowMs = LogPullNonce.nowMs();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LogPullAuthActivity.EXTRA_OAID, str);
            jSONObject.put("configId", j);
            jSONObject.put("size", j2);
            jSONObject.put("timestamp", jNowMs);
            jSONObject.put("nonce", LogPullNonce.forUploadUrl(str, j, j2, jNowMs));
            if (UPLOAD_TYPE_MULTIPART.equals(str2)) {
                jSONObject.put("uploadType", UPLOAD_TYPE_MULTIPART);
                str5 = TAG;
                try {
                    jSONObject.put("partSize", j3);
                    if (str3 != null && !str3.isEmpty() && str4 != null && !str4.isEmpty()) {
                        jSONObject.put("uploadId", str3);
                        jSONObject.put("objectKey", str4);
                    }
                } catch (Exception e) {
                    e = e;
                    Log.e(str5, "requestUploadUrl 异常", e);
                    uploadUrlResult.message = e.getMessage();
                    return uploadUrlResult;
                }
            } else {
                str5 = TAG;
            }
            JSONObject jSONObjectPostJson = postJson("/v1/logpull/upload/url", jSONObject);
            if (jSONObjectPostJson == null) {
                uploadUrlResult.message = "空响应";
                return uploadUrlResult;
            }
            uploadUrlResult.code = jSONObjectPostJson.optInt("code", -1);
            uploadUrlResult.message = jSONObjectPostJson.optString("message", "");
            if (uploadUrlResult.code != 200) {
                Log.w(str5, "upload/url 失败: code=" + uploadUrlResult.code + " msg=" + uploadUrlResult.message + " size=" + j2 + " type=" + str2);
                return uploadUrlResult;
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectPostJson.optJSONObject(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA);
            if (jSONObjectOptJSONObject == null) {
                uploadUrlResult.message = "data 为空";
                return uploadUrlResult;
            }
            uploadUrlResult.uploadType = jSONObjectOptJSONObject.optString("uploadType", UPLOAD_TYPE_NORMAL);
            uploadUrlResult.uploadUrl = jSONObjectOptJSONObject.optString("uploadUrl", null);
            uploadUrlResult.objectKey = jSONObjectOptJSONObject.getString("objectKey");
            uploadUrlResult.expireAt = jSONObjectOptJSONObject.optLong("expireAt", 0L);
            uploadUrlResult.uploadId = jSONObjectOptJSONObject.optString("uploadId", null);
            uploadUrlResult.partSize = jSONObjectOptJSONObject.optLong("partSize", 0L);
            if (!uploadUrlResult.isMultipart()) {
                if (uploadUrlResult.uploadUrl != null) {
                    if (uploadUrlResult.uploadUrl.isEmpty()) {
                    }
                }
                uploadUrlResult.message = "normal 未返回 uploadUrl";
                return uploadUrlResult;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("partUrls");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    uploadUrlResult.partUrls.add(new PartUrl(jSONObject2.getInt("partNumber"), jSONObject2.getString("url")));
                }
                if (uploadUrlResult.uploadId != null && !uploadUrlResult.uploadId.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("upload/url multipart: parts=");
                    sb.append(uploadUrlResult.partUrls.size());
                    sb.append(" partSize=");
                    sb.append(uploadUrlResult.partSize);
                    sb.append(" resume=");
                    sb.append(str3 != null);
                    Log.i(str5, sb.toString());
                }
                uploadUrlResult.message = "multipart 未返回 uploadId";
                return uploadUrlResult;
            }
            uploadUrlResult.message = "multipart 未返回 partUrls";
            return uploadUrlResult;
            uploadUrlResult.ok = true;
            return uploadUrlResult;
        } catch (Exception e2) {
            e = e2;
            str5 = TAG;
        }
    }

    public int completeUpload(long j, String str, String str2, long j2) {
        return completeUpload(j, str, str2, j2, null, null);
    }

    public int completeUpload(long j, String str, String str2, long j2, String str3, List<CompletedPart> list) throws JSONException {
        try {
            long jNowMs = LogPullNonce.nowMs();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LogPullAuthActivity.EXTRA_OAID, str);
            jSONObject.put("configId", j);
            jSONObject.put("objectKey", str2);
            jSONObject.put("size", j2);
            jSONObject.put("timestamp", jNowMs);
            jSONObject.put("nonce", LogPullNonce.forComplete(str, j, str2, j2, jNowMs));
            if (str3 != null && !str3.isEmpty() && list != null && !list.isEmpty()) {
                jSONObject.put("uploadId", str3);
                JSONArray jSONArray = new JSONArray();
                for (CompletedPart completedPart : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("partNumber", completedPart.partNumber);
                    jSONObject2.put("etag", completedPart.etag);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("parts", jSONArray);
                Log.i(TAG, "upload/complete multipart: parts=" + list.size());
            }
            JSONObject jSONObjectPostJson = postJson("/v1/logpull/upload/complete", jSONObject);
            if (jSONObjectPostJson == null) {
                return -1;
            }
            int iOptInt = jSONObjectPostJson.optInt("code", -1);
            if (iOptInt != 200) {
                Log.w(TAG, "upload/complete 失败: code=" + iOptInt + " msg=" + jSONObjectPostJson.optString("message"));
                return -1;
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectPostJson.optJSONObject(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA);
            if (jSONObjectOptJSONObject == null) {
                return -1;
            }
            return jSONObjectOptJSONObject.optInt("status", -1);
        } catch (Exception e) {
            Log.e(TAG, "completeUpload 异常", e);
            return -1;
        }
    }

    public static class UploadUrlResult {
        public long expireAt;
        public String message;
        public String objectKey;
        public boolean ok;
        public long partSize;
        public String uploadId;
        public String uploadUrl;
        public int code = -1;
        public String uploadType = LogPullStatusReporter.UPLOAD_TYPE_NORMAL;
        public List<PartUrl> partUrls = new ArrayList();

        public boolean isMultipart() {
            return LogPullStatusReporter.UPLOAD_TYPE_MULTIPART.equals(this.uploadType);
        }
    }

    public static class PartUrl {
        public int partNumber;
        public String url;

        public PartUrl(int i, String str) {
            this.partNumber = i;
            this.url = str;
        }
    }

    public static class CompletedPart {
        public final String etag;
        public final int partNumber;

        public CompletedPart(int i, String str) {
            this.partNumber = i;
            this.etag = str;
        }
    }

    private LogPullConfig parseConfig(JSONObject jSONObject) throws Exception {
        LogPullConfig logPullConfig = new LogPullConfig();
        logPullConfig.configId = jSONObject.getLong("configId");
        logPullConfig.oaid = jSONObject.optString(LogPullAuthActivity.EXTRA_OAID, null);
        JSONArray jSONArray = jSONObject.getJSONArray("logTypes");
        logPullConfig.logTypes = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            logPullConfig.logTypes[i] = jSONArray.getString(i);
        }
        logPullConfig.logStartTime = jSONObject.getString("logStartTime");
        logPullConfig.logEndTime = jSONObject.getString("logEndTime");
        logPullConfig.deadlineTime = jSONObject.optString("deadlineTime", null);
        logPullConfig.maxLimit = jSONObject.optLong("maxLimit", 0L);
        logPullConfig.fileType = jSONObject.optString("fileType", "zip");
        return logPullConfig;
    }

    private JSONObject postJson(String str, JSONObject jSONObject) throws Exception {
        HttpURLConnection httpURLConnection;
        String str2 = baseUrl() + str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.i(TAG, "HTTP POST begin url=" + str2 + " bodyBytes=" + jSONObject.toString().getBytes(StandardCharsets.UTF_8).length);
        try {
            URL url = new URL(str2);
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(30000);
                Log.d(TAG, "HTTP 连接属性 protocol=" + url.getProtocol() + " host=" + url.getHost());
                byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bytes);
                    outputStream.flush();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    String contentType = httpURLConnection.getContentType();
                    String fully = readFully(responseCode >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream());
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    StringBuilder sb = new StringBuilder("HTTP POST end url=");
                    sb.append(str2);
                    sb.append(" http=");
                    sb.append(responseCode);
                    sb.append(" contentType=");
                    sb.append(contentType);
                    sb.append(" costMs=");
                    sb.append(jCurrentTimeMillis2);
                    sb.append(" respLen=");
                    sb.append(fully == null ? -1 : fully.length());
                    Log.i(TAG, sb.toString());
                    if (fully != null && !fully.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject(fully);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return jSONObject2;
                    }
                    Log.w(TAG, "空响应: http=" + responseCode + " url=" + str2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable th2) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection2 = httpURLConnection;
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                Throwable thRootCause = rootCause(e);
                Log.e(TAG, "HTTP POST 失败 url=" + str2 + " costMs=" + jCurrentTimeMillis3 + " ex=" + e.getClass().getName() + " msg=" + e.getMessage() + " rootEx=" + thRootCause.getClass().getName() + " rootMsg=" + thRootCause.getMessage(), e);
                throw e;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e3) {
            Log.e(TAG, "URL 非法: " + str2, e3);
            throw e3;
        }
    }

    private static String readFully(InputStream inputStream) throws Exception {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
        }
    }

    private void putDeviceInfo(JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.put("brand", Build.BRAND != null ? Build.BRAND : "step");
            jSONObject.put("device", BuildExtStepOS.DEVICE != null ? BuildExtStepOS.DEVICE : Build.DEVICE);
            jSONObject.put("osVersion", DeviceUtils.getOsVersion());
            jSONObject.put("deviceName", resolveDeviceName());
            jSONObject.put("versionType", DeviceUtils.getPublishType());
            jSONObject.put("moduleInfo", "com.stepos.pps");
        } catch (Exception unused) {
        }
    }

    private String resolveDeviceName() {
        Context context = this.context;
        if (context == null) {
            return Build.MODEL != null ? Build.MODEL : "";
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "device_name");
            if (string != null) {
                if (!string.isEmpty()) {
                    return string;
                }
            }
        } catch (Exception unused) {
        }
        return Build.MODEL != null ? Build.MODEL : "";
    }

    private static String trimTrailingSlash(String str) {
        if (str == null) {
            return "";
        }
        while (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    private static String truncate(String str, int i) {
        if (str == null) {
            return "null";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i) + "...(truncated)";
    }

    private static Throwable rootCause(Throwable th) {
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }
}

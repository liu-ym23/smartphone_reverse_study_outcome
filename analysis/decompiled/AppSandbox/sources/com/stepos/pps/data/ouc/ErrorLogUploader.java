package com.stepos.pps.data.ouc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.stepos.pps.data.net.OkHttpHelper;
import com.stepos.pps.data.util.DeviceUtils;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.data.util.Utils;
import com.stepos.pps.reflect.BuildExtStepOS;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import com.stepos.pps.reflect.SystemProperties;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class ErrorLogUploader {
    private static final String HOST_PROD = "mic-collect.stepaos.com";
    private static final String HOST_TEST = "mic-collect.t-stepos.com";
    private static final String PARAMS_BASE_BAND_CDMA_VER = "basebandCdmaVersion";
    private static final String PARAMS_BASE_BAND_GSM_VER = "basebandGsmVersion";
    private static final String PARAMS_BUILD_MASK = "buildMask";
    private static final String PARAMS_BUILD_TYPE = "buildType";
    private static final String PARAMS_CELL_ID = "cellId";
    private static final String PARAMS_COUNTRY = "country";
    private static final String PARAMS_CPU_INFO = "cpuInfo";
    private static final String PARAMS_DEVICE = "device";
    private static final String PARAMS_DEVICE_ID = "deviceId";
    private static final String PARAMS_DNS = "dns";
    private static final String PARAMS_EXCEPTION_TYPE = "exceptionType";
    private static final String PARAMS_EXP_LOG_ID = "expLogId";
    private static final String PARAMS_FILEINFOS = "fileInfos";
    private static final String PARAMS_IMEI = "imei";
    private static final String PARAMS_INSIDE_ID = "insideId";
    private static final String PARAMS_IP = "ip";
    private static final String PARAMS_LOCATION = "location";
    private static final String PARAMS_MAC_ADDR = "macAddr";
    private static final String PARAMS_MEM_INFO = "memInfo";
    private static final String PARAMS_NETWORK = "network";
    private static final String PARAMS_OCCUR_TIME = "crashTime";
    private static final String PARAMS_OPERATOR = "operator";
    private static final String PARAMS_OS_VERSION = "osVersion";
    private static final String PARAMS_PACKAGE_NAME = "packageName";
    private static final String PARAMS_PACKAGE_VER = "packageVer";
    private static final String PARAMS_PACKAGE_VERSION_NAME = "packageVerName";
    private static final String PARAMS_PRODUCT = "productName";
    private static final String PARAMS_PROJECT = "projectId";
    private static final String PARAMS_PUBLISHED_TYPE = "publishType";
    private static final String PARAMS_ROOT = "root";
    private static final String PARAMS_SECURE_FLAG = "secureFlag";
    private static final String PARAMS_SN = "sn";
    private static final String PARAMS_STEPOS_UID = "steposUid";
    private static final String PARAMS_STEPOS_VER = "steposVer";
    private static final String PARAMS_STEPOS_VERSION = "steposVersion";
    private static final String PARAMS_UUID = "crashUuid";
    private static final String PARAMS_VERSION = "version";
    private final String TAG = "PPS:ErrorLogUploader";
    private Context mContext;
    private ErrorDatabaseHelper mDatabaseHelper;

    private static String applyUrl(String str) {
        return "https://" + str + "/v1/crash/apply";
    }

    private static String uploadUrl(String str) {
        return "https://" + str + "/crash/upload/v1";
    }

    public ErrorLogUploader(Context context) {
        this.mContext = context;
        this.mDatabaseHelper = ErrorDatabaseHelper.getInstance(context);
    }

    public boolean upload(Map<String, ErrorInfo> map) {
        if (!Utils.canLogCollect(this.mContext)) {
            if (map != null) {
                Iterator<ErrorInfo> it = map.values().iterator();
                while (it.hasNext()) {
                    EmsLogDropReporter.report(this.mContext, 4, EmsLogDropReporter.R_UPLOAD_PRIVACY_OFF, it.next(), null);
                }
            }
            clearNeedlessFiles(map);
            LogUtil.w("PPS:ErrorLogUploader", "Ignore upload for user privacy!!!");
            return false;
        }
        if (map == null || map.size() == 0 || !Utils.isWiFiWorking(this.mContext)) {
            LogUtil.d("PPS:ErrorLogUploader", "upload fail. 0, no errorInfo");
            return false;
        }
        boolean zEqualsIgnoreCase = "prd".equalsIgnoreCase(SystemProperties.get("persist.stepos.pps.env", ""));
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (Map.Entry<String, ErrorInfo> entry : map.entrySet()) {
            String str = entry.getValue() == null ? null : entry.getValue().versionType;
            if (zEqualsIgnoreCase || "beta".equals(str) || "mp".equals(str)) {
                map3.put(entry.getKey(), entry.getValue());
            } else {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        LogUtil.i("PPS:ErrorLogUploader", "upload split: test(dev)=" + map2.size() + ", prod(beta/mp)=" + map3.size() + ", forceProd=" + zEqualsIgnoreCase);
        boolean zUploadToHost = map2.isEmpty() ? false : uploadToHost(map2, HOST_TEST);
        return !map3.isEmpty() ? uploadToHost(map3, HOST_PROD) | zUploadToHost : zUploadToHost;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x02e8 A[Catch: Exception -> 0x02f5, JSONException -> 0x02f7, TRY_LEAVE, TryCatch #16 {JSONException -> 0x02f7, Exception -> 0x02f5, blocks: (B:119:0x02e4, B:120:0x02e8), top: B:170:0x02e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01fe A[Catch: Exception -> 0x02f9, JSONException -> 0x02fb, TryCatch #17 {JSONException -> 0x02fb, Exception -> 0x02f9, blocks: (B:73:0x01b4, B:78:0x01c9, B:81:0x01d4, B:83:0x01d8, B:85:0x01e0, B:93:0x020b, B:94:0x0211, B:96:0x0227, B:98:0x023f, B:105:0x027d, B:107:0x0283, B:113:0x029f, B:115:0x02d2, B:117:0x02df, B:88:0x01fe, B:76:0x01c3), top: B:168:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0207 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0227 A[Catch: Exception -> 0x02f9, JSONException -> 0x02fb, TryCatch #17 {JSONException -> 0x02fb, Exception -> 0x02f9, blocks: (B:73:0x01b4, B:78:0x01c9, B:81:0x01d4, B:83:0x01d8, B:85:0x01e0, B:93:0x020b, B:94:0x0211, B:96:0x0227, B:98:0x023f, B:105:0x027d, B:107:0x0283, B:113:0x029f, B:115:0x02d2, B:117:0x02df, B:88:0x01fe, B:76:0x01c3), top: B:168:0x01b4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean uploadToHost(java.util.Map<java.lang.String, com.stepos.pps.data.ouc.ErrorInfo> r21, java.lang.String r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.ouc.ErrorLogUploader.uploadToHost(java.util.Map, java.lang.String):boolean");
    }

    private void clearNeedlessFiles(Map<String, ErrorInfo> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (ErrorInfo errorInfo : map.values()) {
            try {
                this.mDatabaseHelper.deleteErrorInfo(errorInfo.uuid);
                errorInfo.deleteFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isUploadSuccess(String str) {
        LogUtil.d("PPS:ErrorLogUploader", "isUploadSuccess result:" + str);
        if (str != null && str.length() > 0) {
            try {
                if (200 == new JSONObject(str).getInt("code")) {
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean isPermanentReject(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            return 400 == new JSONObject(str).getInt("code");
        } catch (JSONException unused) {
            return false;
        }
    }

    private JSONArray applyUpload(Map<String, ErrorInfo> map, String str, String str2) {
        String strPost = OkHttpHelper.get(this.mContext).post(applyUrl(str), generateApplyBody(map, str2));
        LogUtil.d("PPS:ErrorLogUploader", "applyUpload res=" + strPost);
        if (TextUtils.isEmpty(strPost)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strPost);
            if (200 != jSONObject.getInt("code")) {
                return null;
            }
            return jSONObject.getJSONArray(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA);
        } catch (JSONException unused) {
            return null;
        }
    }

    private RequestBody generateApplyBody(Map<String, ErrorInfo> map, String str) throws JSONException {
        FormBody.Builder builder = new FormBody.Builder();
        if (str == null) {
            str = "";
        }
        builder.addEncoded(PARAMS_DEVICE_ID, str);
        builder.addEncoded(PARAMS_VERSION, "1.0");
        builder.addEncoded(PARAMS_STEPOS_VERSION, DeviceUtils.getOsVersion());
        JSONArray jSONArray = new JSONArray();
        try {
            for (ErrorInfo errorInfo : map.values()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PARAMS_UUID, errorInfo.uuid != null ? errorInfo.uuid : "");
                jSONObject.put(PARAMS_OCCUR_TIME, errorInfo.time);
                jSONObject.put("crashSign", errorInfo.tagSign != null ? errorInfo.tagSign : "");
                jSONObject.put("dumpSign", errorInfo.dumpSign != null ? errorInfo.dumpSign : "");
                jSONObject.put(PARAMS_PACKAGE_NAME, errorInfo.packageName != null ? errorInfo.packageName : "");
                jSONObject.put("extSign", errorInfo.extFileSign != null ? errorInfo.extFileSign : "");
                jSONObject.put("causeType", errorInfo.type);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray.length() < 1) {
            return null;
        }
        builder.addEncoded(PARAMS_FILEINFOS, jSONArray.toString());
        return builder.build();
    }

    private void generateUploadBody(MultipartBody.Builder builder, ErrorInfo errorInfo, String str) {
        addUploadBodyDataPart(builder, PARAMS_UUID, errorInfo.uuid);
        addUploadBodyDataPart(builder, PARAMS_DEVICE_ID, str);
        addUploadBodyDataPart(builder, PARAMS_DEVICE, BuildExtStepOS.DEVICE);
        addUploadBodyDataPart(builder, PARAMS_OCCUR_TIME, String.valueOf(errorInfo.time));
        addUploadBodyDataPart(builder, PARAMS_PACKAGE_NAME, errorInfo.packageName);
        addUploadBodyDataPart(builder, PARAMS_EXP_LOG_ID, errorInfo.expLogId);
        addUploadBodyDataPart(builder, PARAMS_PACKAGE_VER, String.valueOf(errorInfo.version));
        addUploadBodyDataPart(builder, PARAMS_PACKAGE_VERSION_NAME, errorInfo.versionName);
        addUploadBodyDataPart(builder, PARAMS_STEPOS_UID, Utils.getStepOSUid(this.mContext));
        addUploadBodyDataPart(builder, PARAMS_STEPOS_VER, TextUtils.isEmpty(errorInfo.steposVersion) ? DeviceUtils.getOsVersion() : errorInfo.steposVersion);
        addUploadBodyDataPart(builder, PARAMS_OS_VERSION, Build.VERSION.RELEASE);
        addUploadBodyDataPart(builder, PARAMS_ROOT, Boolean.toString(Utils.isRoot(this.mContext)));
        addUploadBodyDataPart(builder, PARAMS_OPERATOR, Utils.getOperator(this.mContext));
        addUploadBodyDataPart(builder, PARAMS_COUNTRY, Utils.getCountry(this.mContext));
        addUploadBodyDataPart(builder, PARAMS_NETWORK, errorInfo.network);
        addUploadBodyDataPart(builder, PARAMS_LOCATION, errorInfo.location);
        addUploadBodyDataPart(builder, PARAMS_EXCEPTION_TYPE, errorInfo.type);
        if ("EMS_KE".equals(errorInfo.type)) {
            String str2 = SystemProperties.get("ro.boot.securetype", "");
            addUploadBodyDataPart(builder, PARAMS_SECURE_FLAG, ("STAGE_2".equals(str2) || "STAGE_1".equals(str2)) ? "1" : "0");
        }
        addUploadBodyDataPart(builder, PARAMS_PUBLISHED_TYPE, TextUtils.isEmpty(errorInfo.versionType) ? Utils.getPublishedType() : errorInfo.versionType);
        addUploadBodyDataPart(builder, PARAMS_BUILD_TYPE, Utils.BUILD_TYPE);
        addUploadBodyDataPart(builder, PARAMS_PROJECT, Utils.getProjectID());
        addUploadBodyDataPart(builder, PARAMS_INSIDE_ID, Utils.BUILD_MASK);
        addUploadBodyDataPart(builder, PARAMS_BASE_BAND_CDMA_VER, "");
        addUploadBodyDataPart(builder, PARAMS_BASE_BAND_GSM_VER, "");
        addUploadBodyDataPart(builder, PARAMS_PRODUCT, Utils.getProductName());
    }

    private void addUploadBodyDataPart(MultipartBody.Builder builder, String str, String str2) {
        if (str2 == null) {
            builder.addFormDataPart(str, "");
        } else {
            builder.addFormDataPart(str, str2);
        }
        LogUtil.d("PPS:ErrorLogUploader", "upload body data part name:" + str + ", value:" + str2);
    }
}

package com.stepos.logreport.sdk;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.stepos.logreport.ILogPullService;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class LogPullQueryClient {
    private static final String SERVICE_NAME = "logreportd_logpull";
    private static final String TAG = "LogPull.Query";

    private LogPullQueryClient() {
    }

    public static final class LogdFileInfo {
        public long boundedSize;
        public long contentEndMs;
        public long contentStartMs;
        public boolean isActive;
        public String path;
        public int rotateIndex;
        public String type;

        public boolean isKernel() {
            return "kernel".equals(this.type);
        }
    }

    public static final class QueryResult {
        public long bootWallMs;
        public int code = -1;
        public List<LogdFileInfo> files = Collections.EMPTY_LIST;
        public boolean spansReboot;

        public boolean isSuccess() {
            return this.code == 0;
        }

        public boolean isEmpty() {
            return this.code == 0 && this.files.isEmpty();
        }

        public long totalBoundedBytes() {
            long j = 0;
            for (LogdFileInfo logdFileInfo : this.files) {
                if (logdFileInfo.boundedSize > 0) {
                    j += logdFileInfo.boundedSize;
                }
            }
            return j;
        }
    }

    private static ILogPullService getService() {
        IBinder service = ServiceManager.getService(SERVICE_NAME);
        if (service == null) {
            return null;
        }
        return ILogPullService.Stub.asInterface(service);
    }

    public static boolean isAvailable() {
        return getService() != null;
    }

    public static QueryResult query(long j, long j2, List<String> list) {
        QueryResult queryResult = new QueryResult();
        ILogPullService service = getService();
        if (service == null) {
            Log.w(TAG, "logreportd_logpull 不可用（daemon 版本不匹配）");
            return queryResult;
        }
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (String str : list) {
                if (str != null && !str.isEmpty()) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append(str);
                }
            }
        }
        try {
            return parse(service.queryLogFiles(j, j2, sb.toString()), queryResult);
        } catch (RemoteException e) {
            Log.e(TAG, "queryLogFiles 失败", e);
            return queryResult;
        }
    }

    private static QueryResult parse(String str, QueryResult queryResult) {
        if (str == null || str.isEmpty()) {
            Log.e(TAG, "queryLogFiles 返回空");
            return queryResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            queryResult.code = jSONObject.optInt("code", -1);
            queryResult.bootWallMs = jSONObject.optLong("bootWallMs", 0L);
            queryResult.spansReboot = jSONObject.optBoolean("spansReboot", false);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("files");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        LogdFileInfo logdFileInfo = new LogdFileInfo();
                        logdFileInfo.path = jSONObjectOptJSONObject.optString(ExceptionManagerStepOS.EXCEPTION_LOG_PATH, null);
                        logdFileInfo.type = jSONObjectOptJSONObject.optString("type", "logcat");
                        logdFileInfo.boundedSize = jSONObjectOptJSONObject.optLong("boundedSize", -1L);
                        logdFileInfo.isActive = jSONObjectOptJSONObject.optBoolean("isActive", false);
                        logdFileInfo.contentStartMs = jSONObjectOptJSONObject.optLong("contentStartMs", 0L);
                        logdFileInfo.contentEndMs = jSONObjectOptJSONObject.optLong("contentEndMs", 0L);
                        logdFileInfo.rotateIndex = jSONObjectOptJSONObject.optInt("rotateIndex", -1);
                        if (logdFileInfo.path != null && !logdFileInfo.path.isEmpty()) {
                            arrayList.add(logdFileInfo);
                        }
                    }
                }
            }
            queryResult.files = arrayList;
            return queryResult;
        } catch (Exception e) {
            Log.e(TAG, "解析 queryLogFiles 结果失败", e);
            queryResult.code = -1;
            queryResult.files = Collections.EMPTY_LIST;
            return queryResult;
        }
    }
}

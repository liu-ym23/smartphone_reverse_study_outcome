package com.bytedance.apm.alog;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.util.StackUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AlogMonitor {
    public static final String ALOG_RESULT = "success";
    public static final String ALOG_RESULT_CODE = "code";
    public static final int ALOG_RESULT_CODE_CONTEXT = 0;
    public static final int ALOG_RESULT_CODE_FILE_NULL = 2;
    public static final int ALOG_RESULT_CODE_IO_FAIL = 8;
    public static final int ALOG_RESULT_CODE_JSON_FAIL = 7;
    public static final int ALOG_RESULT_CODE_NET_FAIL = 6;
    public static final int ALOG_RESULT_CODE_NET_FAIL_NULL_RESPONSE = 11;
    public static final int ALOG_RESULT_CODE_NOT_ALLOW_ALOG = 9;
    public static final int ALOG_RESULT_CODE_NO_ALOG = 4;
    public static final int ALOG_RESULT_CODE_NO_ALOG_UPLOAD_STRATEGY = 12;
    public static final int ALOG_RESULT_CODE_NO_CONFIG_FILE = 1;
    public static final int ALOG_RESULT_CODE_NO_FLUSH = 3;
    public static final int ALOG_RESULT_CODE_NO_PARAM = 5;
    public static final int ALOG_RESULT_CODE_RESTRICT_BY_SERVER = 13;
    public static final int ALOG_RESULT_CODE_SUCCESS = -1;
    public static final int ALOG_RESULT_CODE_UNKNOWN_FAIL = 10;
    public static final String ALOG_RESULT_EXCEPTION = "exception";
    public static final String ALOG_RESULT_EXCEPTION_OBJECT = "exception_object";
    public static final String ALOG_RESULT_INFO = "info";
    public static final String ALOG_UPLOAD = "AlogUploadTag";

    public AlogMonitor() {
    }

    public static void log(String r2, Throwable r3) {
        if (ApmContext.isDebugMode() == false) goto L10;
        String[] r0 = new String[2];
        r0[0] = r2;
        if (r3 == null) goto L7;
        String r4 = r3.getMessage();
    L8:
        r0[1] = r4;
        Logger.i(ALOG_UPLOAD, r0);
        return;
    L7:
        r4 = "";
        goto L8
    }

    public static void log(String r1) {
        log(r1, null);
    }

    public static JSONObject getResult(boolean r1, int r2, Exception r3, JSONObject r4) {
        if (r4 != null) goto L11;
        r4 = new JSONObject();
    L11:
        r4.put("success", r1);     // Catch: Exception -> L8
        r4.put("code", r2);     // Catch: Exception -> L8
        if (r3 == null) goto L10;
        r4.put("exception", r3.getMessage() + StackUtils.getStack(r3));     // Catch: Exception -> L8
        r4.put(ALOG_RESULT_EXCEPTION_OBJECT, r3);     // Catch: Exception -> L8
    L10:
        return r4;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}

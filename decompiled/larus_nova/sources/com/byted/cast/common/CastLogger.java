package com.byted.cast.common;

import android.text.TextUtils;
import com.byted.cast.common.api.ILogger;

/* JADX INFO: loaded from: classes39.dex */
public class CastLogger {
    private static int NO_LOG = 10;
    private static String TAG = "ByteCast";
    private static volatile CastLogger sInstance;
    private int logLevel;
    private ILogger logger;
    private ContextManager.CastContext mCastContext;

    private static int transNativeLogLevelToJava(int r100) {
        if (r100 == (-1)) goto L19;
        if (r100 != 0) goto L6;
        return 6;
    L6:
        if (r100 != 1) goto L8;
        return 5;
    L8:
        if (r100 != 3) goto L10;
        return 3;
    L10:
        if (r100 == 4) goto L12;
        return 4;
    L12:
        return 2;
    L19:
        return 7;
    }

    public static CastLogger getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(CastLogger.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CastLogger(null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CastLogger.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    private CastLogger(ContextManager.CastContext r100) {
        this.logLevel = 3;
        this.mCastContext = r100;
    }

    public static CastLogger createInstance(ContextManager.CastContext r100) {
        if (r100 != null) goto L6;
        return getInstance();
    L6:
        return new CastLogger(r100);
    }

    private String prefix(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r102 = "" + r100 + ":";
    L6:
        ContextManager.CastContext r103 = this.mCastContext;
        if (r103 != null) goto L9;
        return r102;
    L9:
        if (TextUtils.isEmpty(r103.getProjectId()) == false) goto L11;
        int r104 = -2;
    L12:
        StringBuilder r105 = new StringBuilder();
        r105.append(r102);
        if (r104 == (-2)) goto L20;
        StringBuilder r106 = new StringBuilder();
        if (r104 <= 0) goto L18;
        String r107 = this.mCastContext.getProjectId().substring(0, r104);
    L19:
        r106.append(r107);
        r106.append(":");
        r101 = r106.toString();
        goto L20
    L18:
        r107 = this.mCastContext.getProjectId();
    L20:
        r105.append(r101);
        return r105.toString();
    L11:
        r104 = this.mCastContext.getProjectId().indexOf("-");
        goto L12
    L5:
        r102 = "";
        goto L6
    }

    public void d(String r100) {
        d(TAG, r100);
    }

    public void e(String r100) {
        e(TAG, r100);
    }

    public void i(String r100) {
        i(TAG, r100);
    }

    public void setEnable(boolean r100) {
        if (r100 == false) goto L4;
        setLogLevel(this.logLevel);
        return;
    L4:
        setLogLevel(NO_LOG);
    }

    public void setLogLevel(int r100) {
        this.logLevel = r100;
    }

    public void setLogger(ILogger r100) {
        this.logger = r100;
    }

    public void v(String r100) {
        v(TAG, r100);
    }

    public void w(String r100) {
        w(TAG, r100);
    }

    public void d(String r100, String r101) {
        String r102 = prefix(r100) + r101;
        if (this.logLevel <= 3) goto L5;
        return;
    L5:
        ILogger r103 = this.logger;
        if (r103 == null) goto L9;
        r103.onDebug(TAG, r102);
        return;
    }

    public void e(String r100, String r101) {
        String r102 = prefix(r100) + r101;
        if (this.logLevel <= 6) goto L5;
        return;
    L5:
        ILogger r103 = this.logger;
        if (r103 == null) goto L9;
        r103.onError(TAG, r102);
        return;
    }

    public void i(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        String r102 = prefix(r100) + r101;
        if (this.logLevel <= 4) goto L10;
        return;
    L10:
        ILogger r103 = this.logger;
        if (r103 == null) goto L14;
        r103.onInfo(TAG, r102);
        return;
    L14:
        return;
    L5:
        if (r101.length() >= 4) goto L7;
    }

    public void v(String r100, String r101) {
        String r102 = prefix(r100) + r101;
        if (this.logLevel <= 2) goto L5;
        return;
    L5:
        ILogger r103 = this.logger;
        if (r103 == null) goto L9;
        r103.onVerbose(TAG, r102);
        return;
    }

    public void w(String r100, String r101) {
        String r102 = prefix(r100) + r101;
        if (this.logLevel <= 5) goto L5;
        return;
    L5:
        ILogger r103 = this.logger;
        if (r103 == null) goto L9;
        r103.onWarn(TAG, r102);
        return;
    }

    public void e(String r100, String r101, Throwable r102) {
        String r103 = prefix(r100) + r101;
        if (this.logLevel <= 6) goto L5;
        return;
    L5:
        ILogger r104 = this.logger;
        if (r104 == null) goto L9;
        r104.onError(TAG, r103, r102);
        return;
    }

    public static void logger(String r100, int r101, String r102, String r103) {
        if (TextUtils.equals("bytelink_sink", r100) == false) goto L5;
        ContextManager.CastContext r104 = null;
    L6:
        CastLogger r105 = ContextManager.getLogger(r104);
        switch(transNativeLogLevelToJava(r101)) {
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L13;
            default: goto L19;
        };
    L9:
        r105.e(r102, r103);
        return;
    L10:
        r105.w(r102, r103);
        return;
    L11:
        r105.i(r102, r103);
        return;
    L12:
        r105.d(r102, r103);
        return;
    L13:
        r105.v(r102, r103);
        return;
    L19:
        return;
    L5:
        r104 = new ContextManager.CastContext(r100);
        goto L6
    }
}

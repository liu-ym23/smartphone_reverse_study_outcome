package com.byted.cast.sdk.log;

import android.text.TextUtils;
import com.byted.cast.common.api.ILogger;

/* JADX INFO: loaded from: classes43.dex */
public class Logger {
    private static String TAG = "BYTELINK";
    private int LOG_LEVEL;
    private ILogger mLogger;
    private String mMirrorId;

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

    public Logger(String r100) {
        this.LOG_LEVEL = 4;
        this.mMirrorId = r100;
    }

    private String prefix(String r100) {
        String r101 = this.mMirrorId + ":";
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        return r101 + r100 + ":";
    }

    public void setLogLevel(int r100) {
        this.LOG_LEVEL = r100;
    }

    public void setLogger(ILogger r100) {
        this.mLogger = r100;
    }

    public void d(String r100, String r101) {
        if (this.LOG_LEVEL <= 3) goto L5;
        return;
    L5:
        String r102 = prefix(r100) + r101;
        ILogger r103 = this.mLogger;
        if (r103 == null) goto L9;
        r103.onDebug(TAG, r102);
        return;
    }

    public void e(String r100, String r101) {
        if (this.LOG_LEVEL <= 6) goto L5;
        return;
    L5:
        String r102 = prefix(r100) + r101;
        ILogger r103 = this.mLogger;
        if (r103 == null) goto L9;
        r103.onError(TAG, r102);
        return;
    }

    public void i(String r100, String r101) {
        if (this.LOG_LEVEL <= 4) goto L5;
        return;
    L5:
        String r102 = prefix(r100) + r101;
        ILogger r103 = this.mLogger;
        if (r103 == null) goto L9;
        r103.onInfo(TAG, r102);
        return;
    }

    public void v(String r100, String r101) {
        if (this.LOG_LEVEL <= 2) goto L5;
        return;
    L5:
        String r102 = prefix(r100) + r101;
        ILogger r103 = this.mLogger;
        if (r103 == null) goto L9;
        r103.onVerbose(TAG, r102);
        return;
    }

    public void w(String r100, String r101) {
        if (this.LOG_LEVEL <= 5) goto L5;
        return;
    L5:
        String r102 = prefix(r100) + r101;
        ILogger r103 = this.mLogger;
        if (r103 == null) goto L9;
        r103.onWarn(TAG, r102);
        return;
    }

    public static void logger(String r100, int r101, String r102, String r103) {
        Logger r104 = LoggerManager.getLogger(r100);
        switch(transNativeLogLevelToJava(r101)) {
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L9;
            default: goto L15;
        };
    L5:
        r104.e(r102, r103);
        return;
    L6:
        r104.w(r102, r103);
        return;
    L7:
        r104.i(r102, r103);
        return;
    L8:
        r104.d(r102, r103);
        return;
    L9:
        r104.v(r102, r103);
        return;
    }
}

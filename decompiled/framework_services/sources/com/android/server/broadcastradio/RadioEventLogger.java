package com.android.server.broadcastradio;

import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.LocalLog;
import android.util.Log;
import com.android.server.utils.Slogf;

/* JADX INFO: loaded from: classes.dex */
public final class RadioEventLogger {
    private final boolean mDebug;
    private final LocalLog mEventLogger;
    private final String mTag;

    public RadioEventLogger(String tag, int loggerQueueSize) {
        this.mTag = tag;
        this.mDebug = Log.isLoggable(this.mTag, 3);
        this.mEventLogger = new LocalLog(loggerQueueSize);
    }

    public void logRadioEvent(String logFormat, Object... args) {
        String log = TextUtils.formatSimple(logFormat, args);
        this.mEventLogger.log(log);
        if (this.mDebug == false) goto L6;
        Slogf.d(this.mTag, logFormat, args);
        return;
    }

    public void dump(IndentingPrintWriter pw) {
        this.mEventLogger.dump(pw);
    }
}

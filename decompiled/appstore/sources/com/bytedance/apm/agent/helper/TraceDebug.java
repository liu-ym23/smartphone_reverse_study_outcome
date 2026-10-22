package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.tracing.Trace;

/* JADX INFO: loaded from: classes.dex */
public class TraceDebug {
    private static OnLogListener mOnLogListener;

    public interface OnLogListener {
        void log(String r10, long r11);
    }

    public TraceDebug() {
    }

    public static OnLogListener getLogListener() {
        return mOnLogListener;
    }

    public static void notifyLogListener(Trace r10, long r11) {
        OnLogListener r12 = mOnLogListener;
        if (r12 == null) goto L6;
        r12.log(r10.methodName, r11);
        return;
    }

    public static void setLogListener(OnLogListener r10) {
        mOnLogListener = r10;
    }
}

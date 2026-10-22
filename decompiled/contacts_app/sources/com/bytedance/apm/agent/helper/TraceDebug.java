package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.tracing.Trace;

/* JADX INFO: loaded from: classes2.dex */
public class TraceDebug {
    private static OnLogListener mOnLogListener;

    public interface OnLogListener {
        void log(String r1, long r2);
    }

    public TraceDebug() {
    }

    public static void setLogListener(OnLogListener r0) {
        mOnLogListener = r0;
    }

    public static OnLogListener getLogListener() {
        return mOnLogListener;
    }

    public static void notifyLogListener(Trace r1, long r2) {
        OnLogListener r0 = mOnLogListener;
        if (r0 == null) goto L6;
        r0.log(r1.methodName, r2);
        return;
    }
}

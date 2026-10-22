package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.tracing.Trace;

/* JADX INFO: loaded from: classes14.dex */
public class TraceDebug {
    private static OnLogListener mOnLogListener;

    public interface OnLogListener {
        void log(String r100, long r101);
    }

    public TraceDebug() {
    }

    public static OnLogListener getLogListener() {
        return mOnLogListener;
    }

    public static void setLogListener(OnLogListener r100) {
        mOnLogListener = r100;
    }

    public static void notifyLogListener(Trace r100, long r101) {
        OnLogListener r102 = mOnLogListener;
        if (r102 == null) goto L6;
        r102.log(r100.methodName, r101);
        return;
    }
}

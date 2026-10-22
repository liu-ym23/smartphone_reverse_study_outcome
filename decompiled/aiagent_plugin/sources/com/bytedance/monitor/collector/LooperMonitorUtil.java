package com.bytedance.monitor.collector;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class LooperMonitorUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Message f8942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f8943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f8944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ProxyH f8945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ProxyFrameHandler f8946e;

    static class ProxyFrameHandler extends Handler {
        ProxyFrameHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            LooperMonitorUtil.a().handleMessage(r1);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r1, long r2) {
            return super.sendMessageAtTime(r1, r2);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message r2) {
            if (r2.getCallback() == null) goto L5;
            super.dispatchMessage(r2);
            return;
        L5:
            super.dispatchMessage(r2);
        }
    }

    static class ProxyH extends Handler {
        ProxyH() {
        }

        String codeToString(int r1) {
            return Integer.toString(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            LooperMonitorUtil.b().handleMessage(r1);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message r1) {
            super.dispatchMessage(r1);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r1, long r2) {
            return super.sendMessageAtTime(r1, r2);
        }
    }

    static /* synthetic */ Handler a() {
        return f8944c;
    }

    static /* synthetic */ Handler b() {
        return f8943b;
    }

    static {
        f8945d = new ProxyH();
        f8946e = new ProxyFrameHandler();
        f8942a = Message.obtain();
    }
}

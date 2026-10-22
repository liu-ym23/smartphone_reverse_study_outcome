package com.bytedance.bdturing;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class VerifyTaskHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HandlerThread f6485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MessageHandler f6486b;

    /* JADX INFO: renamed from: com.bytedance.bdturing.VerifyTaskHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class MessageHandler extends Handler {
        final /* synthetic */ VerifyTaskHandler this$0;

        /* synthetic */ MessageHandler(VerifyTaskHandler r1, Looper r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private MessageHandler(VerifyTaskHandler r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            int r0 = r3.what;
            if (r0 != 1) goto L5;
            VerifyTaskHandler.a(this.this$0, r3);
            return;
        L5:
            if (r0 != 2) goto L7;
            k.a((com.bytedance.bdturing.b.c) ZeusTransformUtils.preCheckCast(r3.obj, com.bytedance.bdturing.b.c.class, "com.obric.aiagent.plugin"));
            return;
        L7:
            if (r0 != 3) goto L15;
            k.a();
            return;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static VerifyTaskHandler f6487a;

        static /* synthetic */ VerifyTaskHandler a() {
            return f6487a;
        }

        static {
            f6487a = new VerifyTaskHandler(null);
        }
    }

    /* synthetic */ VerifyTaskHandler(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ void a(VerifyTaskHandler r0, Message r1) {
        r0.a(r1);
    }

    private VerifyTaskHandler() {
    }

    public static VerifyTaskHandler a() {
        return a.a();
    }

    public Looper b() {
        return this.f6485a.getLooper();
    }

    public void a(int r2, Object r3) {
        MessageHandler r0 = this.f6486b;
        if (r0 == null) goto L6;
        Message r4 = r0.obtainMessage(r2, r3);
        this.f6486b.sendMessage(r4);
        return;
    }

    public void a(int r2, Object r3, long r4) {
        MessageHandler r0 = this.f6486b;
        if (r0 == null) goto L6;
        Message r5 = r0.obtainMessage(r2, r3);
        this.f6486b.sendMessageDelayed(r5, r4);
        return;
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        MessageHandler r2 = this.f6486b;
        if (r2 == null) goto L6;
        r2.post(r4);
        return;
    }

    public void a(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        MessageHandler r2 = this.f6486b;
        if (r2 == null) goto L7;
        if (r5 == null) goto L8;
        r2.postDelayed(r5, r4);
        return;
    L8:
        return;
    }

    public void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        MessageHandler r2 = this.f6486b;
        if (r2 == null) goto L7;
        if (r4 == null) goto L8;
        r2.removeCallbacks(r4);
        return;
    L8:
        return;
    }

    private void a(Message r2) {
        if (r2.obj == null) goto L6;
        ((VerifyDialog) ZeusTransformUtils.preCheckCast(r2.obj, VerifyDialog.class, "com.obric.aiagent.plugin")).clearResource();
        return;
    }
}

package com.ttnet.org.chromium.base.task;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PostTaskJni.java */
/* JADX INFO: loaded from: classes4.dex */
class f implements PostTask.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<PostTask.a> f37756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PostTask.a f37757b;

    f() {
    }

    static {
        f37756a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.task.PostTask.a
    public void a(int r11, boolean r12, boolean r13, byte r14, byte[] r15, Runnable r16, long r17, String r19) {
        com.ttnet.org.chromium.base.b.a.a(r11, r12, r13, r14, r15, (Runnable) ZeusTransformUtils.wrapperContextForParams(r16, Runnable.class, "com.obric.aiagent.plugin"), r17, r19);
    }

    public static PostTask.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        PostTask.a r0 = f37757b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.PostTask.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new f();
    }
}

package com.ttnet.org.chromium.base.task;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TaskRunnerImplJni.java */
/* JADX INFO: loaded from: classes4.dex */
class m implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<l.a> f37768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static l.a f37769b;

    m() {
    }

    static {
        f37768a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.task.l.a
    public long a(int r1, int r2, boolean r3, boolean r4, byte r5, byte[] r6) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r2, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.base.task.l.a
    public void a(long r1) {
        com.ttnet.org.chromium.base.b.a.b(r1);
    }

    @Override // com.ttnet.org.chromium.base.task.l.a
    public void a(long r7, Runnable r9, long r10, String r12) {
        com.ttnet.org.chromium.base.b.a.a(r7, (Runnable) ZeusTransformUtils.wrapperContextForParams(r9, Runnable.class, "com.obric.aiagent.plugin"), r10, r12);
    }

    public static l.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        l.a r0 = f37769b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new m();
    }
}

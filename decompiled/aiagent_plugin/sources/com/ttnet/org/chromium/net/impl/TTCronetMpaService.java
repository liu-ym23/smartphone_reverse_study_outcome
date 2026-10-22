package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class TTCronetMpaService extends com.ttnet.org.chromium.net.ab {
    private static final String TAG = "TTCronetMpaService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CronetUrlRequestContext f38044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f38045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f38046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ttnet.org.chromium.net.ab.a f38047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.ttnet.org.chromium.net.ab.a f38048e;

    static {
    }

    private native void nativeCommand(long r1, String r3, String r4);

    private native long nativeCreateMpaServiceAdapter(long r1);

    private native void nativeInit(long r1);

    private native void nativeSetAccAddress(long r1, String[] r3);

    private native void nativeStart(long r1);

    private native void nativeStop(long r1);

    static /* synthetic */ com.ttnet.org.chromium.net.ab.a a(TTCronetMpaService r0) {
        return r0.f38047d;
    }

    static /* synthetic */ com.ttnet.org.chromium.net.ab.a b(TTCronetMpaService r0) {
        return r0.f38048e;
    }

    static /* synthetic */ String c() {
        return TAG;
    }

    public TTCronetMpaService(CronetUrlRequestContext r2) {
        this.f38046c = new Object();
        this.f38044a = r2;
    }

    @Override // com.ttnet.org.chromium.net.ab
    public void a(com.ttnet.org.chromium.net.ab.a r6) {
        com.ttnet.org.chromium.net.ab.a r7 = (com.ttnet.org.chromium.net.ab.a) ZeusTransformUtils.wrapperContextForParams(r6, com.ttnet.org.chromium.net.ab.a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f38046c;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f38045b != 0) goto L7;
        this.f38045b = nativeCreateMpaServiceAdapter(this.f38044a.t());     // Catch: Throwable -> L10
    L7:
        this.f38047d = r7;     // Catch: Throwable -> L10
        nativeInit(this.f38045b);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    @Override // com.ttnet.org.chromium.net.ab
    public void a(List<String> r6, com.ttnet.org.chromium.net.ab.a r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        com.ttnet.org.chromium.net.ab.a r9 = (com.ttnet.org.chromium.net.ab.a) ZeusTransformUtils.wrapperContextForParams(r7, com.ttnet.org.chromium.net.ab.a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f38046c;
        monitor-enter(r0);
        long r1 = this.f38045b;     // Catch: Throwable -> L11
        if (r1 != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.f38048e = r9;     // Catch: Throwable -> L11
        nativeSetAccAddress(r1, (String[]) ZeusTransformUtils.preCheckCast(r8.toArray(new String[r8.size()]), String[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ab
    public void a() {
        Object r0 = this.f38046c;
        monitor-enter(r0);
        long r1 = this.f38045b;     // Catch: Throwable -> L11
        if (r1 != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStart(r1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ab
    public void b() {
        Object r0 = this.f38046c;
        monitor-enter(r0);
        long r1 = this.f38045b;     // Catch: Throwable -> L11
        if (r1 != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStop(r1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ab
    public void a(String r6, String r7) {
        Object r0 = this.f38046c;
        monitor-enter(r0);
        long r1 = this.f38045b;     // Catch: Throwable -> L11
        if (r1 != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        nativeCommand(r1, r6, r7);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void onInitFinish(final boolean r2, final String r3) {
        a(new AnonymousClass1(this, r2, r3));
    }

    private void onSetAccAddressFinish(final boolean r2, final String r3) {
        a(new AnonymousClass2(this, r2, r3));
    }

    private void a(Runnable r2) {
        Thread r3 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"));
        r3.setName("TTCronetMpaService_Thread");
        r3.start();
    }
}

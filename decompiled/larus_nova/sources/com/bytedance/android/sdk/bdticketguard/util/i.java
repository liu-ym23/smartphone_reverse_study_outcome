package com.bytedance.android.sdk.bdticketguard.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SerialAsyncRetryExecutor f164067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f164068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f164069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f164070d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f164071a;

        public a(i r100) {
            this.f164071a = r100;
        }

        public final void a() {
            i r100 = this.f164071a;
            if (r100.f164068b != r100.f164067a.f164039c.get()) goto L5;
            this.f164071a.f164067a.f164039c.incrementAndGet();
        L5:
            this.f164071a.f164067a.f164040d.set(false);
            SerialAsyncRetryExecutor.a(this.f164071a.f164067a);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.util.b.a
    public final void onFailure() {
        SerialAsyncRetryExecutor r100 = this.f164067a;
        b r101 = this.f164069c;
        int r102 = this.f164070d;
        int r103 = this.f164068b;
        r100.getClass();
        long r104 = r101.b(r102 + 1);
        r100.b().execute(new f(r100, r104, r103, r101, r102));
    }

    @Override // com.bytedance.android.sdk.bdticketguard.util.b.a
    public final void onSuccess() {
        this.f164067a.b().execute(new a(this));
    }

    public i(SerialAsyncRetryExecutor r100, int r101, b r102, int r103) {
        this.f164067a = r100;
        this.f164068b = r101;
        this.f164069c = r102;
        this.f164070d = r103;
    }
}

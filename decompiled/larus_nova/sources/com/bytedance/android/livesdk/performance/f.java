package com.bytedance.android.livesdk.performance;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f154595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f154596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f154597c;

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f154595a, this.f154596b, this.f154597c);     // Catch: Throwable -> L4
        return;
    }

    public f(String r100, String r101, boolean r102) {
        this.f154595a = r100;
        this.f154596b = r101;
        this.f154597c = r102;
    }
}

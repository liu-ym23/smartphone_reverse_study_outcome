package com.bytedance.android.latch.internal;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f58288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f58289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f58290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f58291e;

    public b(int r100, a r101, String r102, int r103, int r104) {
        this.f58287a = r100;
        this.f58288b = r101;
        this.f58289c = r102;
        this.f58290d = r103;
        this.f58291e = r104;
    }

    public final void a() {
        if (this.f58287a != (-3)) goto L5;
        String r100 = this.f58288b.f58282i.invoke();
    L6:
        int r101 = this.f58287a;
        int r102 = this.f58290d;
        String r103 = this.f58288b.f58278e.f58333q.getDisplayName();
        dx.c r104 = new dx.c(r101, r102, r103, r100, this.f58291e, this.f58288b.f58276c);
        this.f58288b.f58281h.invoke(r104);
        a r105 = this.f58288b;
        hx.a r106 = r105.f58280g;
        if (r106 == null) goto L10;
        r106.e(r105.f58274a, r104);
        return;
    L10:
        return;
    L5:
        r100 = this.f58289c;
        goto L6
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

package com.bytedance.android.ecom.arch.slice.render.elements;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSlcViewManager f50405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uq.a f50406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ uq.a f50407c;

    public d(BaseSlcViewManager r100, uq.a r101, uq.a r102) {
        this.f50405a = r100;
        this.f50406b = r101;
        this.f50407c = r102;
    }

    public final void a() {
        BaseSlcViewManager r100 = this.f50405a;
        uq.a r101 = this.f50406b;
        r100.getClass();
        int r102 = r101.f551168b;
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L6;
        float r103 = (r100.getView().getWidth() * 1.0f) / 2;
    L8:
        BaseSlcViewManager r104 = this.f50405a;
        uq.a r105 = this.f50407c;
        r104.getClass();
        int r106 = r105.f551168b;
        if (r106 == 1) goto L13;
        if (r106 == 2) goto L12;
        float r107 = (r104.getView().getHeight() * 1.0f) / 2;
    L14:
        r100.X0(r103, r107);
        return;
    L12:
        r107 = r104.f50272f.getLayoutHeight() * (r105.f551167a / 100);
        goto L14
    L13:
        r107 = r105.f551167a;
        goto L14
    L6:
        r103 = (r101.f551167a / 100) * r100.f50272f.getLayoutWidth();
        goto L8
    L7:
        r103 = r101.f551167a;
        goto L8
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

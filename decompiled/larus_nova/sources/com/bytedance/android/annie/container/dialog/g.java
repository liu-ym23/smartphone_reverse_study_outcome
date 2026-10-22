package com.bytedance.android.annie.container.dialog;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupHybridParamVoNew f39264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseDialogFragment f39265b;

    public g(PopupHybridParamVoNew r100, BaseDialogFragment r101) {
        this.f39264a = r100;
        this.f39265b = r101;
    }

    public final void a() {
        if (this.f39264a.l3() <= 0) goto L7;
        BaseDialogFragment r100 = this.f39265b;
        int r101 = this.f39264a.l3();
        int r102 = BaseDialogFragment.f39240r;
        HybridFragment r103 = r100.f39243f;
        if (r103 == null) goto L11;
        r103.setRadius(r100.da0(r101));
        return;
    L11:
        return;
    L7:
        BaseDialogFragment r104 = this.f39265b;
        int r105 = this.f39264a.o3();
        int r106 = this.f39264a.p3();
        int r107 = this.f39264a.n3();
        int r108 = this.f39264a.m3();
        HybridFragment r109 = r104.f39243f;
        if (r109 == null) goto L13;
        r109.setRadius(r104.da0(r105), r104.da0(r106), r104.da0(r107), r104.da0(r108));
        return;
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

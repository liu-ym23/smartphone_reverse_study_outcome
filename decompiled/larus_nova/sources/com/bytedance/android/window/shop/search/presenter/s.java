package com.bytedance.android.window.shop.search.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.ec.window.base.status.WindowSearchProductLoadingStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f189756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f189757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WindowLazyStatusView f189758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f189759d;

    public s(t r100, ViewGroup r101, WindowLazyStatusView r102, Context r103) {
        this.f189756a = r100;
        this.f189757b = r101;
        this.f189758c = r102;
        this.f189759d = r103;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        WindowLoadStatus r101 = (WindowLoadStatus) r100;
        this.f189757b.setVisibility(0);
        if (this.f189756a.f189761g == false) goto L6;
        WindowLazyStatusView r102 = this.f189758c;
        Map<? extends com.bytedance.android.ec.window.base.status.c, com.bytedance.android.ec.window.base.status.d<? extends View>> r103 = new WindowSearchProductLoadingStatusView(this.f189759d).a();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "viewCreators");
        r102.removeAllViews();
        ((LinkedHashMap) r102.f49691b).clear();
        r102.f49690a.putAll(r103);
    L6:
        if (r101 == null) goto L16;
        int r104 = q.f189754a[r101.ordinal()];
        if (r104 != 1) goto L11;
        this.f189758c.b(com.bytedance.android.ec.window.base.status.c.d.f49705a);
    L21:
        this.f189756a.f189761g = true;
        return;
    L11:
        if (r104 != 2) goto L13;
        this.f189757b.setVisibility(8);
        goto L21
    L13:
        if (r104 != 3) goto L15;
        this.f189758c.b(com.bytedance.android.ec.window.base.status.c.C0852c.f49704a);
        goto L21
    L15:
        if (r104 != 4) goto L16;
        this.f189758c.b(com.bytedance.android.ec.window.base.status.c.b.f49703a);
    L16:
        this.f189757b.setVisibility(8);
        goto L21
    }
}

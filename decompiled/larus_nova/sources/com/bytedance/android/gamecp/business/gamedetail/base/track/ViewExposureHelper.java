package com.bytedance.android.gamecp.business.gamedetail.base.track;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import xr.c;

/* JADX INFO: loaded from: classes44.dex */
public final class ViewExposureHelper<T> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f53493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f53494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Boolean, ? super T, Unit> f53495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.common.track.monitor.a f53496d;

    @Override // xr.c
    public final void attachViewAppearObserver(View r100, Function2<? super Boolean, ? super Float, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "appearObserver");
        this.f53496d.attachViewAppearObserver(r100, r101);
    }

    @Override // xr.c
    public final void detachViewAppearObserver() {
        this.f53496d.detachViewAppearObserver();
    }

    @Override // xr.c
    public final boolean viewIsWillDetached() {
        return this.f53496d.viewIsWillDetached();
    }

    public ViewExposureHelper() {
        this.f53496d = new com.bytedance.android.gamecp.common.track.monitor.a(50, false, 0.0f, false, null, 62);
    }

    public final void a(View r100, Function2<? super Boolean, ? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f53494b = r100;
        this.f53495c = r101;
        attachViewAppearObserver(this.f53494b, new ViewExposureHelper$observe$1(this));
    }
}

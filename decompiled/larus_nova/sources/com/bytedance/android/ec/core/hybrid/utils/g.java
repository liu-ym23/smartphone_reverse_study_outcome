package com.bytedance.android.ec.core.hybrid.utils;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements pd.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ti.k f44307a;

    @Override // pd.h
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        ti.k r100 = this.f44307a;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public g(ti.k r100) {
        this.f44307a = r100;
    }

    @Override // pd.h
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        ti.k r101 = this.f44307a;
        if (r101 == null) goto L6;
        r101.onFirstScreen(r100);
        return;
    }

    @Override // pd.h
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        ti.k r101 = this.f44307a;
        if (r101 == null) goto L6;
        r101.onLoadSuccess(r100);
        return;
    }

    @Override // pd.h
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        ti.k r101 = this.f44307a;
        if (r101 == null) goto L6;
        r101.onRuntimeReady(r100);
        return;
    }

    @Override // pd.h
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        ti.k r102 = this.f44307a;
        if (r102 == null) goto L6;
        r102.onLoadFailed(r100, r101);
        return;
    }

    @Override // pd.h
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        ti.k r102 = this.f44307a;
        if (r102 == null) goto L6;
        r102.onPageStart(r100, r101);
        return;
    }

    @Override // pd.h
    public final void onReceivedError(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        ti.k r102 = this.f44307a;
        if (r102 == null) goto L6;
        r102.s(r100, r101, "");
        return;
    }
}

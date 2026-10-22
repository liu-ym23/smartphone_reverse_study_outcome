package com.bytedance.android.gamecp.business.imagechoose;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageChooseAdapter f56072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageChooseAdapter.ViewHolder f56073b;

    public b(ImageChooseAdapter r100, ImageChooseAdapter.ViewHolder r101) {
        this.f56072a = r100;
        this.f56073b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<Integer, Unit> r101 = this.f56072a.f56022p;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(Integer.valueOf(this.f56073b.getLayoutPosition()));
        return;
    }
}

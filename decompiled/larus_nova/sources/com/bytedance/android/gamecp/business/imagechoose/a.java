package com.bytedance.android.gamecp.business.imagechoose;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageChooseAdapter f56071a;

    public a(ImageChooseAdapter r100) {
        this.f56071a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f56071a.f56016j;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }
}

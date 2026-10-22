package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewItemAdapter f139975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f139976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f139977c;

    public d(PreviewItemAdapter r100, k r101, int r102) {
        this.f139975a = r100;
        this.f139976b = r101;
        this.f139977c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        k r101 = this.f139976b;
        if (r101 == null) goto L8;
        Function2<? super Integer, ? super k, Unit> r102 = this.f139975a.f139969b;
        if (r102 == null) goto L9;
        Unit r103 = r102.invoke(Integer.valueOf(this.f139977c), r101);
        return;
    L9:
        return;
    }
}

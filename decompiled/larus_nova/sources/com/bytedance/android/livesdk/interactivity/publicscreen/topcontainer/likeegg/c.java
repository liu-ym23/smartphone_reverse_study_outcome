package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompositeImagePreviewDialog f139923a;

    public c(CompositeImagePreviewDialog r100) {
        this.f139923a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f139923a.f139888k0.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L11;
        CompositeImagePreviewDialog r102 = this.f139923a;
        Function1<? super String, Unit> r103 = r102.B;
        if (r103 == null) goto L12;
        Unit r104 = r103.invoke(r102.f139888k0);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = false;
        goto L6
    }
}

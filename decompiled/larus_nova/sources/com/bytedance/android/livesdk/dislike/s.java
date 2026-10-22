package com.bytedance.android.livesdk.dislike;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LongPressGuideView f122226a;

    public s(LongPressGuideView r100) {
        this.f122226a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LongPressGuideView r101 = this.f122226a;
        Function1<? super View, Unit> r102 = r101.f122013b;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r101);
        return;
    }
}

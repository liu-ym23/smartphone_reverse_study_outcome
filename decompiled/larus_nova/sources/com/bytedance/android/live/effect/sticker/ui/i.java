package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecommendKeywordView f68586a;

    public i(RecommendKeywordView r100) {
        this.f68586a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f68586a.f68454b;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }
}

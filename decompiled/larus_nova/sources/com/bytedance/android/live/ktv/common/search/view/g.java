package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchContainer f70307a;

    public g(CommonSearchContainer r100) {
        this.f70307a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.live.ktv.common.search.viewmodel.a r101 = CommonSearchContainer.a(this.f70307a);
        if (r101 == null) goto L10;
        com.bytedance.android.live.ktv.common.ordersong.feedback.a r102 = r101.getCurPredicateContent();
        if (r102 == null) goto L11;
        Function1<? super com.bytedance.android.live.ktv.common.ordersong.feedback.a, Unit> r103 = this.f70307a.f70258g;
        if (r103 == null) goto L12;
        Unit r104 = r103.invoke(r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}

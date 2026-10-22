package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;

/* JADX INFO: loaded from: classes47.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PKRivalsSearchHistoryView f97052a;

    public m(PKRivalsSearchHistoryView r100) {
        this.f97052a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PKRivalsSearchHistoryView r101 = this.f97052a;
        Object r102 = r100.getTag();
        if (r102 == null) goto L9;
        String r103 = (String) r102;
        PKRivalsSearchHistoryView.a r104 = r101.f96922c;
        if (r104 == null) goto L10;
        r104.v8(r103);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}

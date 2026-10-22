package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonHotWordHistoryView f70302a;

    public b(CommonHotWordHistoryView r100) {
        this.f70302a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L4;
        Object r101 = r100.getTag();
    L6:
        if ((r101 instanceof String) == false) goto L12;
        Object r102 = r100.getTag();
        if (r102 == null) goto L11;
        String r103 = (String) r102;
    L13:
        Function1<? super String, Unit> r104 = this.f70302a.f70250d;
        if (r104 == null) goto L17;
        Unit r105 = r104.invoke(r103);
        return;
    L17:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L12:
        r103 = "";
        goto L13
    L4:
        r101 = null;
        goto L6
    }
}

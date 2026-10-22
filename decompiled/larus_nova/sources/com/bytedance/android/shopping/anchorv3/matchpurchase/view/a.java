package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.view.View;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuideTagView f165232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FloatingTagLayout f165233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p63.c f165234c;

    public a(GuideTagView r100, FloatingTagLayout r101, p63.c r102) {
        this.f165232a = r100;
        this.f165233b = r101;
        this.f165234c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        o63.a r101 = this.f165233b.f165185a;
        if (r101 == null) goto L5;
        r101.b(this.f165234c.f527885e);
    L5:
        Map<String, String> r102 = t63.a.f544661a;
        t63.a.a(this.f165232a.getContext(), com.bytedance.android.ec.core.btm.c.c(this.f165234c.f527884d, r100, "a1.b7324.c04535.d21086", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "product")}));
    }
}

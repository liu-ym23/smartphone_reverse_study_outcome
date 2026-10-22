package com.bytedance.android.shopping.anchorv3.view;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH;
import java.util.HashSet;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3GuessULikeFeedbackView f165522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.guess.f f165523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j63.c f165524c;

    public a(AnchorV3GuessULikeFeedbackView r100, AnchorV4GuessBaseVH.a r101, j63.c r102) {
        this.f165522a = r100;
        this.f165523b = r101;
        this.f165524c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnchorV3GuessULikeFeedbackView r101 = this.f165522a;
        int r102 = AnchorV3GuessULikeFeedbackView.f165391w;
        r101.S5();
        com.bytedance.android.shopping.anchorv4.voavhs.guess.f r103 = this.f165523b;
        if (r103 == null) goto L12;
        AnchorV3GuessULikeFeedbackView r104 = this.f165522a;
        String r105 = r104.f165396e;
        Function0<String> r106 = r104.f165395d;
        if (r106 == null) goto L7;
        String r107 = r106.invoke();
    L8:
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        String r108 = r107;
        HashSet<String> r109 = l63.a.f507661a;
        r103.w("", r105, r108, l63.a.b(this.f165524c.getType()), "close", this.f165524c);
        return;
    L7:
        r107 = null;
        goto L8
    }
}

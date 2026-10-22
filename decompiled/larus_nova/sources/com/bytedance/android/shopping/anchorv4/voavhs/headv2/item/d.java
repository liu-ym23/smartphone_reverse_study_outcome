package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadMultiPreview f169613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f169614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f169615c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        HeadMultiPreview r101 = this.f169613a;
        r101.f169580g = false;
        r101.requestLayout();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f169613a.f169581h.tB(Boolean.TRUE);
        int r101 = k83.b.f502093a;
        k83.b.c(this.f169613a.f169581h.getRecyclerView());
        this.f169613a.o(this.f169614b);
        Function0 r102 = this.f169615c;
        if (r102 == null) goto L5;
        Unit r103 = (Unit) r102.invoke();
    L5:
        LinearLayout r104 = this.f169613a.f169574a;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.width = -1;
        r105.height = -1;
        Unit r106 = Unit.INSTANCE;
        r104.setLayoutParams(r105);
        HeadMultiPreview r107 = this.f169613a;
        r107.f169580g = false;
        r107.r();
    }

    public d(HeadMultiPreview r100, View r101, Function0 r102) {
        this.f169613a = r100;
        this.f169614b = r101;
        this.f169615c = r102;
    }
}

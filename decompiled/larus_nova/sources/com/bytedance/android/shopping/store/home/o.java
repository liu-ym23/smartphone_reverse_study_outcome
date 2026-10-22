package com.bytedance.android.shopping.store.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopGroupAnimation f183794a;

    public o(ECShopGroupAnimation r100) {
        this.f183794a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Iterator<T> r101 = this.f183794a.f183538e.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        ECShopGroupAnimation.a r102 = (ECShopGroupAnimation.a) r101.next();
        if (this.f183794a.f183535b == false) goto L8;
        ECShopGroupAnimation.Direction r103 = ECShopGroupAnimation.Direction.REVERSE;
    L9:
        r102.c(r103);
        goto L4
    L8:
        r103 = ECShopGroupAnimation.Direction.FORWARD;
        goto L9
    }
}

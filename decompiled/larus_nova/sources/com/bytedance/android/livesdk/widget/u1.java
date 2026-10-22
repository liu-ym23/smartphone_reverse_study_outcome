package com.bytedance.android.livesdk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveThumbProcessViewHolder f162153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f162154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f162155c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        LiveThumbProcessViewHolder.b(this.f162153a).setText(this.f162155c);
        UtilityKotlinExtentionsKt.w(LiveThumbProcessViewHolder.b(this.f162153a));
        View r101 = (View) this.f162153a.f161103f.getValue();
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.z(r101, this.f162154b);
        return;
    }

    public u1(LiveThumbProcessViewHolder r100, boolean r101, String r102) {
        this.f162153a = r100;
        this.f162154b = r101;
        this.f162155c = r102;
    }
}

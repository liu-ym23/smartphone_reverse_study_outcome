package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LikeEggView f140008a;

    public e(LikeEggView r100) {
        this.f140008a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        HSImageView r101 = this.f140008a.f139987b;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r101, false);
    L5:
        HSImageView r102 = this.f140008a.f139987b;
        if (r102 == null) goto L8;
        r102.setController(null);
    L8:
        HSImageView r103 = this.f140008a.f139988c;
        if (r103 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r103, false);
    L11:
        HSImageView r104 = this.f140008a.f139988c;
        if (r104 == null) goto L14;
        r104.setController(null);
    L14:
        super.onAnimationStart(r100);
    }
}

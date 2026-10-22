package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f75784a;

    public f(h r100) {
        this.f75784a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LinearLayout r101 = this.f75784a.C;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        TextView r102 = this.f75784a.E;
        if (r102 == null) goto L9;
        r102.setText("");
        return;
    }
}

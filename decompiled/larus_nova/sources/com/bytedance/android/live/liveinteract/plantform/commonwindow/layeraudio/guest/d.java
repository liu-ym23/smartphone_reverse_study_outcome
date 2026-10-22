package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f75782a;

    public d(h r100) {
        this.f75782a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TextView r101 = this.f75782a.B;
        if (r101 == null) goto L5;
        CharSequence r102 = r101.getText();
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        LinearLayout r103 = this.f75782a.f75786z;
        if (r103 == null) goto L11;
        r103.setVisibility(0);
    L11:
        LinearLayout r104 = this.f75782a.f75786z;
        if (r104 == null) goto L16;
        r104.setAlpha(0.0f);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L7
    }
}

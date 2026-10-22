package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.interactivity.api.like.utils.DiggABHelper;
import com.bytedance.android.livesdk.utils.q4;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSelfDiggOptimizeView.b f137914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f137915b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        BottomSelfDiggOptimizeView.b r101 = this.f137914a;
        ImageView r102 = r101.f137776e;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r101.f137779h.f137766b == false) goto L9;
        r102.setLayerType(0, null);
    L9:
        if (this.f137914a.f137779h.f137767c.b(r102) == true) goto L11;
        this.f137914a.f137779h.removeView(r102);
    L11:
        BottomSelfDiggOptimizeView.b r103 = this.f137914a;
        ((LinkedList) r103.f137779h.f137765a).remove(r103);
        if (this.f137915b.element < 5) goto L14;
        this.f137914a.f137779h.f137769e = 0;
        return;
    L14:
        if (this.f137914a.f137779h.f137769e < DiggABHelper.a().d()) goto L16;
        q4.f159129j.getClass();
        q4.f159128i = true;
        g32.d.b("BottomSelfDiggOptimizeView");
        return;
    L16:
        this.f137914a.f137779h.f137769e++;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        BottomSelfDiggOptimizeView.b r101 = this.f137914a;
        if (r101.f137779h.f137766b == false) goto L7;
        ImageView r102 = r101.f137776e;
        if (r102 == null) goto L7;
        r102.setLayerType(2, null);
    L7:
        ImageView r103 = this.f137914a.f137776e;
        if (r103 == null) goto L11;
        r103.setVisibility(0);
        return;
    }

    public c(BottomSelfDiggOptimizeView.b r100, Ref.IntRef r101) {
        this.f137914a = r100;
        this.f137915b = r101;
    }
}

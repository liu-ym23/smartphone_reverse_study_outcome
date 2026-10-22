package com.bytedance.android.live.room.share.summersinging;

import android.animation.ValueAnimator;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GroupPhotoDialogFragment f100345a;

    public d(GroupPhotoDialogFragment r100) {
        this.f100345a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ConstraintLayout r101 = this.f100345a.f100326e;
        if (r101 == null) goto L40;
        Object r102 = r100.getAnimatedValue("xOffset");
        Object r103 = null;
        if ((r102 instanceof Float) == true) goto L7;
        r102 = null;
    L7:
        Float r104 = (Float) r102;
        float r105 = 0.0f;
        if (r104 == null) goto L10;
        float r106 = r104.floatValue();
    L11:
        r101.setTranslationX(r106);
        Object r107 = r100.getAnimatedValue("yOffset");
        if ((r107 instanceof Float) == true) goto L14;
        r107 = null;
    L14:
        Float r108 = (Float) r107;
        if (r108 == null) goto L17;
        float r109 = r108.floatValue();
    L18:
        r101.setTranslationY(r109);
        Object r110 = r100.getAnimatedValue("scale");
        if ((r110 instanceof Float) == true) goto L21;
        r110 = null;
    L21:
        Float r111 = (Float) r110;
        if (r111 == null) goto L24;
        float r112 = r111.floatValue();
        r101.setScaleX(r112);
        r101.setScaleY(r112);
    L24:
        Object r113 = r100.getAnimatedValue("rotation");
        if ((r113 instanceof Float) == true) goto L27;
        r113 = null;
    L27:
        Float r114 = (Float) r113;
        if (r114 == null) goto L30;
        float r115 = r114.floatValue();
    L31:
        r101.setRotation(r115);
        Object r116 = r100.getAnimatedValue("alpha");
        if ((r116 instanceof Float) == false) goto L35;
        r103 = r116;
    L35:
        Float r117 = (Float) r103;
        if (r117 == null) goto L38;
        r105 = r117.floatValue();
    L38:
        r101.setAlpha(r105);
        return;
    L30:
        r115 = 0.0f;
        goto L31
    L17:
        r109 = 0.0f;
        goto L18
    L10:
        r106 = 0.0f;
        goto L11
    }
}

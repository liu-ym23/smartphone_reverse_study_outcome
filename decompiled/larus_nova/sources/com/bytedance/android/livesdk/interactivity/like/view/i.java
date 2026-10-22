package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomDiggTapView.c f137942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f137943b;

    public i(CustomDiggTapView.c r100, Ref.IntRef r101) {
        this.f137942a = r100;
        this.f137943b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        CustomDiggTapView.c r101 = this.f137942a;
        Object r102 = r100.getAnimatedValue("scale");
        Object r103 = null;
        if ((r102 instanceof Float) == true) goto L5;
        r102 = null;
    L5:
        Float r104 = (Float) r102;
        if (r104 == null) goto L8;
        float r105 = r104.floatValue();
    L9:
        r101.f137806c = r105;
        ImageView r106 = r101.f137807d;
        if (r106 == null) goto L12;
        r106.setScaleX(r105);
        r106.setScaleY(r105);
    L12:
        long r107 = r100.getCurrentPlayTime();
        if (0 <= r107) goto L16;
    L27:
        long r108 = r100.getCurrentPlayTime();
        if (400 <= r108) goto L31;
    L43:
        this.f137943b.element++;
        return;
    L31:
        if (650 < r108) goto L43;
        CustomDiggTapView.c r109 = this.f137942a;
        Object r110 = r100.getAnimatedValue("alpha");
        if ((r110 instanceof Integer) == false) goto L36;
        r103 = r110;
    L36:
        Integer r111 = (Integer) r103;
        if (r111 == null) goto L39;
        int r112 = r111.intValue();
    L40:
        r109.f137804a = r112;
        CustomDiggTapView.c r113 = this.f137942a;
        ImageView r114 = r113.f137807d;
        if (r114 == null) goto L43;
        r114.setAlpha(r113.f137804a / 255.0f);
        goto L43
    L39:
        r112 = this.f137942a.f137804a;
        goto L40
    L16:
        if (400 < r107) goto L27;
        CustomDiggTapView.c r115 = this.f137942a;
        Object r116 = r100.getAnimatedValue("rotate");
        if ((r116 instanceof Float) == true) goto L20;
        r116 = null;
    L20:
        Float r117 = (Float) r116;
        if (r117 == null) goto L23;
        float r118 = r117.floatValue();
    L24:
        r115.f137805b = r118;
        CustomDiggTapView.c r119 = this.f137942a;
        ImageView r120 = r119.f137807d;
        if (r120 == null) goto L27;
        r120.setRotation(r119.f137805b);
        goto L27
    L23:
        r118 = this.f137942a.f137805b;
        goto L24
    L8:
        r105 = this.f137942a.f137806c;
        goto L9
    }
}

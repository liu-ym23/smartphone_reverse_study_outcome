package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeQuickShotObserveWidget f119105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f119106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f119107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f119108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f119114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f119115k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119116l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119117m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f119118n;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f119106b.element = r100.getAnimatedFraction();
        Ref.FloatRef r101 = this.f119107c;
        float r102 = 1;
        float r103 = r102 - this.f119108d;
        Ref.FloatRef r104 = this.f119106b;
        float r105 = r102 - (r103 * r104.element);
        r101.element = r105;
        this.f119109e.element = (int) (this.f119110f.element * r105);
        Ref.IntRef r106 = this.f119111g;
        r106.element = (int) (this.f119112h.element * r105);
        Ref.IntRef r107 = this.f119113i;
        float r108 = this.f119114j.element;
        float r109 = ((int) this.f119115k.element) - r108;
        float r110 = r104.element;
        r107.element = (int) (r108 + (r109 * r110));
        Ref.IntRef r111 = this.f119116l;
        int r112 = this.f119117m.element;
        r111.element = (int) ((r112 + ((this.f119118n - r112) * r110)) - r106.element);
        HSImageView r113 = this.f119105a.f118955c;
        if (r113 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L5:
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L14;
        r114.width = this.f119109e.element;
        r114.height = this.f119111g.element;
        r113.setLayoutParams(r114);
        View r115 = this.f119105a.contentView;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L12;
        r116.width = -2;
        r116.height = -2;
        r115.setLayoutParams(r116);
        r115.setX(this.f119113i.element);
        r115.setY(this.f119116l.element);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public o(LandscapeQuickShotObserveWidget r100, Ref.FloatRef r101, Ref.FloatRef r102, float r103, Ref.IntRef r104, Ref.IntRef r105, Ref.IntRef r106, Ref.IntRef r107, Ref.IntRef r108, Ref.FloatRef r110, Ref.FloatRef r111, Ref.IntRef r112, Ref.IntRef r113, int r114) {
        this.f119105a = r100;
        this.f119106b = r101;
        this.f119107c = r102;
        this.f119108d = r103;
        this.f119109e = r104;
        this.f119110f = r105;
        this.f119111g = r106;
        this.f119112h = r107;
        this.f119113i = r108;
        this.f119114j = r110;
        this.f119115k = r111;
        this.f119116l = r112;
        this.f119117m = r113;
        this.f119118n = r114;
    }
}

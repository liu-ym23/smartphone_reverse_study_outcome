package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeQuickShotLayerWidget f119084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f119085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f119086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f119087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f119088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f119094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ float f119095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119096m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f119097n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f119098o;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if ((!Intrinsics.areEqual(this.f119085b, this.f119084a.f118942e)) == false) goto L5;
        return;
    L5:
        this.f119086c.element = r100.getAnimatedFraction();
        Ref.FloatRef r101 = this.f119087d;
        float r102 = 1;
        float r103 = r102 - this.f119088e;
        Ref.FloatRef r104 = this.f119086c;
        float r105 = r102 - (r103 * r104.element);
        r101.element = r105;
        this.f119089f.element = (int) (this.f119090g.element * r105);
        Ref.IntRef r106 = this.f119091h;
        r106.element = (int) (this.f119092i.element * r105);
        Ref.IntRef r107 = this.f119093j;
        float r108 = this.f119094k.element;
        float r109 = ((int) this.f119095l) - r108;
        float r110 = r104.element;
        r107.element = (int) (r108 + (r109 * r110));
        Ref.IntRef r111 = this.f119096m;
        int r112 = this.f119097n.element;
        r111.element = (int) ((r112 + ((this.f119098o - r112) * r110)) - r106.element);
        ImageView r113 = this.f119084a.f118939b;
        if (r113 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L8:
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L17;
        r114.width = this.f119089f.element;
        r114.height = this.f119091h.element;
        r113.setLayoutParams(r114);
        View r115 = this.f119084a.contentView;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L15;
        r116.width = -2;
        r116.height = -2;
        r115.setLayoutParams(r116);
        r115.setX(this.f119093j.element);
        r115.setY(this.f119096m.element);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public j(LandscapeQuickShotLayerWidget r100, Bitmap r101, Ref.FloatRef r102, Ref.FloatRef r103, float r104, Ref.IntRef r105, Ref.IntRef r106, Ref.IntRef r107, Ref.IntRef r108, Ref.IntRef r110, Ref.FloatRef r111, float r112, Ref.IntRef r113, Ref.IntRef r114, int r115) {
        this.f119084a = r100;
        this.f119085b = r101;
        this.f119086c = r102;
        this.f119087d = r103;
        this.f119088e = r104;
        this.f119089f = r105;
        this.f119090g = r106;
        this.f119091h = r107;
        this.f119092i = r108;
        this.f119093j = r110;
        this.f119094k = r111;
        this.f119095l = r112;
        this.f119096m = r113;
        this.f119097n = r114;
        this.f119098o = r115;
    }
}

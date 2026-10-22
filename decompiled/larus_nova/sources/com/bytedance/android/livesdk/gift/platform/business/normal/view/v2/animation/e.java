package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f129939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f129940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f129941c;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        b r102 = this.f129939a;
        HSImageView r103 = r102.f129926c;
        if (r103 == null) goto L5;
        r103.setVisibility(8);
    L5:
        r102.a(false);
        AnimatedDrawable2 r104 = r102.f129924a;
        if (r104 == null) goto L8;
        r104.stop();
    L8:
        r102.f129924a = null;
        this.f129940b.element = true;
    }

    public e(b r100, Ref.BooleanRef r101, Long r102) {
        this.f129939a = r100;
        this.f129940b = r101;
        this.f129941c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        r102 = null;
    L5:
        AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
        if (r104 == null) goto L21;
        final Ref.BooleanRef r105 = new Ref.BooleanRef();
        r105.element = false;
        this.f129940b.element = true;
        this.f129939a.f129924a = r104;
        com.bytedance.android.live.core.utils.fresco.c.c(r104);
        AnimatedDrawable2 r106 = this.f129939a.f129924a;
        if (r106 == null) goto L10;
        j.a(r106, new EntryAnimationTask$startAnim$listener$1$onFinalImageSet$$inlined$let$lambda$1(r105, this), EntryAnimationTask$startAnim$listener$1$onFinalImageSet$1$2.INSTANCE);
    L10:
        AnimatedDrawable2 r107 = this.f129939a.f129924a;
        if (r107 == null) goto L13;
        r107.start();
    L13:
        ViewGroup r108 = this.f129939a.f129927d;
        if (r108 == null) goto L22;
        d r109 = new d(this);
        Long r110 = this.f129941c;
        if (r110 == null) goto L18;
        long r111 = r110.longValue();
    L19:
        r108.postDelayed(r109, r111);
        return;
    L18:
        r111 = 2250;
        goto L19
    L22:
        return;
    }
}

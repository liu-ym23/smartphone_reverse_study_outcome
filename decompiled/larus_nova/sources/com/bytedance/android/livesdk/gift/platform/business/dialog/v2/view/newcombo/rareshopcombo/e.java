package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboView f126925a;

    public e(GiftRareShopComboView r100) {
        this.f126925a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        r102 = null;
    L5:
        AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
        if (r104 == null) goto L9;
        this.f126925a.f126906s = r104;
        return;
    }
}

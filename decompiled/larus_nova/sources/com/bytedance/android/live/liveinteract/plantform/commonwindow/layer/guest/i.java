package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f75741a;

    public i(g r100) {
        this.f75741a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        HSImageView r104 = this.f75741a.f75726h;
        if (r104 == null) goto L8;
        Drawable r105 = r104.getBackground();
        if (r105 == null) goto L9;
        r105.setAlpha(0);
        return;
    L9:
        return;
    }
}

package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f170310a;

    public e(SimpleDraweeView r100) {
        this.f170310a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if (r103 == null) goto L22;
        int r104 = r103.getHeight();     // Catch: Exception -> L15
        int r105 = (int) ((this.f170310a.getWidth() * r104) / r103.getWidth());     // Catch: Exception -> L15
        if (r105 > 0) goto L8;
        r105 = this.f170310a.getWidth();     // Catch: Exception -> L15
    L8:
        ViewGroup.LayoutParams r106 = this.f170310a.getLayoutParams();     // Catch: Exception -> L15
        if (r106 != null) goto L12;
        return;
    L12:
        if (r106.height == r105) goto L21;
        r106.height = r105;     // Catch: Exception -> L15
        this.f170310a.requestLayout();     // Catch: Exception -> L15
        return;
    L21:
        return;
    L15:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return;
    }
}

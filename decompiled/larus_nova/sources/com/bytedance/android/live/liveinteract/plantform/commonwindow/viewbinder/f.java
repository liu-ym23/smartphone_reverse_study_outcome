package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkPaidViewBinder.ItemViewHolder f76009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ILinkPlayerInfoBridge f76010b;

    public f(MultiLinkPaidViewBinder.ItemViewHolder r100, ILinkPlayerInfoBridge r101) {
        this.f76009a = r100;
        this.f76010b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        MultiLinkPaidViewBinder.ItemViewHolder r104 = this.f76009a;
        int r105 = MultiLinkPaidViewBinder.ItemViewHolder.f75965h;
        boolean r106 = true;
        if (r104.f75972g == true) goto L10;
        HSImageView r107 = r104.f75969d;
        if (r107 != null) goto L7;
    L9:
        r106 = false;
        goto L10
    L7:
        if (r107.isAnimating() != true) goto L9;
    L10:
        if (r106 == false) goto L13;
        return;
    L13:
        if ((r102 instanceof AnimatedDrawable2) == false) goto L16;
        je0.b.a((AnimatedDrawable2) r102, new MultiLinkPaidViewBinder$ItemViewHolder$bind$2$onFinalImageSet$1(this));
        return;
    }
}

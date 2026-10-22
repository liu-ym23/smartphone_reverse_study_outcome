package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkBizHybridCardController$updateAnim$1$controller$1 extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HSImageView f76792a;

    public MultiLinkBizHybridCardController$updateAnim$1$controller$1(HSImageView r100) {
        this.f76792a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        HSImageView r102 = this.f76792a;
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        ViewParent r103 = this.f76792a.getParent();
        if (r103 == null) goto L9;
        ((ViewGroup) r103).removeView(this.f76792a);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
        je0.b.a((AnimatedDrawable2) r102, new MultiLinkBizHybridCardController$updateAnim$1$controller$1$onFinalImageSet$1(this));
        return;
    }
}

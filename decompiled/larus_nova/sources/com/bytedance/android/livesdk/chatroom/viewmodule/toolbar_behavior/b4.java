package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes8.dex */
public final class b4 extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c4 f117093a;

    public b4(c4 r100) {
        this.f117093a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        HSImageView r104 = this.f117093a.f117107g;
        if (r104 == null) goto L6;
        r104.setVisibility(8);
        return;
    }
}

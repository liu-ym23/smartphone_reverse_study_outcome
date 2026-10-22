package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.depend.model.live.ToolBarCouponExtraData;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a2 extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f117079a;

    public a2(z1 r100) {
        this.f117079a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        z1 r103 = this.f117079a;
        ToolBarCouponExtraData r104 = r103.f117520a;
        if (r104 == null) goto L5;
        Integer r105 = Integer.valueOf(r104.getCouponPrice());
    L7:
        if (r105 != null) goto L9;
    L14:
        String r106 = "¥";
    L16:
        if (Intrinsics.areEqual("¥", r106) == false) goto L20;
        TextView r107 = r103.f117524e;
        if (r107 == null) goto L23;
        r107.setTextSize(1, 14.0f);
    L23:
        TextView r108 = r103.f117524e;
        if (r108 == null) goto L27;
        r108.setText(r106);
        return;
    L27:
        return;
    L20:
        TextView r109 = r103.f117524e;
        if (r109 == null) goto L23;
        r109.setTextSize(1, 9.0f);
        goto L23
    L9:
        if (r105.intValue() <= 0) goto L14;
        if (r105.intValue() >= 100) goto L14;
        r106 = "¥" + r105;
        goto L16
    L5:
        r105 = null;
        goto L7
    }
}

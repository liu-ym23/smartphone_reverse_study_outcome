package com.bytedance.android.livesdk.gift.fastgift;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupGiftDialogFragment f126134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f126135b;

    public c0(PopupGiftDialogFragment r100, Ref.IntRef r101) {
        this.f126134a = r100;
        this.f126135b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        Ref.IntRef r104 = this.f126135b;
        int r105 = r104.element + 1;
        r104.element = r105;
        if (r105 != 2) goto L19;
        HSImageView r106 = (HSImageView) this.f126134a.S90(R.id.pop_up_image);
        if (r106 == null) goto L11;
        DraweeController r107 = r106.getController();
        if (r107 == null) goto L11;
        Animatable r108 = r107.getAnimatable();
        if (r108 == null) goto L11;
        r108.start();
    L11:
        HSImageView r109 = (HSImageView) this.f126134a.S90(R.id.pop_up_button_image);
        if (r109 == null) goto L20;
        DraweeController r110 = r109.getController();
        if (r110 == null) goto L21;
        Animatable r111 = r110.getAnimatable();
        if (r111 == null) goto L22;
        r111.start();
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }
}

package com.bytedance.android.shopping.deepfeed.ui.view;

import android.graphics.drawable.Animatable;
import android.view.ViewPropertyAnimator;
import androidx.cardview.widget.CardView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f173949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f173950b;

    public i(g r100) {
        this.f173949a = r100;
        this.f173950b = "deep_feed_swipe_show_time";
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        g r103 = this.f173949a;
        CardView r104 = r103.f173941b;
        if (r104 == null) goto L6;
        String r105 = this.f173950b;
        ViewPropertyAnimator r106 = r104.animate().alpha(1.0f);
        int r107 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r106.translationY(-com.bytedance.android.ec.hybrid.list.util.c.d(10)).setDuration(280).setInterpolator(PathInterpolatorCompat.create(0.2f, 0.0f, 0.2f, 1.0f)).setListener(new h(r103, r105)).start();
        return;
    }
}

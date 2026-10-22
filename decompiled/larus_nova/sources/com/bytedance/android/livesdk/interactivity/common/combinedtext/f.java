package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.graphics.drawable.Animatable;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClipImageView f136501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py.k f136502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DisplayImageListView.b f136503c;

    public f(ClipImageView r100, py.k r101, DisplayImageListView.b r102) {
        this.f136501a = r100;
        this.f136502b = r101;
        this.f136503c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        r102 = null;
    L5:
        AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
        if (r104 == null) goto L11;
        com.bytedance.android.live.core.utils.fresco.c.b(r104);
        ClipImageView r105 = this.f136501a;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.height = UtilityKotlinExtentionsKt.i(this.f136502b.getHeight());
        r106.width = UtilityKotlinExtentionsKt.i(this.f136502b.getWidth());
        Unit r107 = Unit.INSTANCE;
        r105.setLayoutParams(r106);
        DisplayImageListView.b r108 = this.f136503c;
        int r109 = r108.f136469a + 1;
        r108.f136469a = r109;
        if (r109 != r108.f136470b) goto L12;
        r108.f136471c.invoke();
        return;
    L12:
        return;
    }
}

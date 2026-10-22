package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f79756a;

    public e(Function0 r100) {
        this.f79756a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
        je0.b.a((AnimatedDrawable2) r102, new ThemedCompetitionUtilKt$loadWebp$1$onFinalImageSet$1(this));
        return;
    }
}

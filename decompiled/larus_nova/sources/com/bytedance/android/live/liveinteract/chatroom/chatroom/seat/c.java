package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuestBattleSeatAnimTask f72222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f72223b;

    public c(GuestBattleSeatAnimTask r100, Function0 r101) {
        this.f72222a = r100;
        this.f72223b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        ALogger.e("GuestBattleSeatAnimTask", "playGuestBattleSeatAnimation.onFailure:", r101);
        Function0 r102 = this.f72223b;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke();
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
        je0.b.a((AnimatedDrawable2) r102, new GuestBattleSeatAnimTask$playGuestBattleSeatAnimation$1$onFinalImageSet$1(this));
        return;
    }
}

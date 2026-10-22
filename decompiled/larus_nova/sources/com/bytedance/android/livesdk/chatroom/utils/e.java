package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f114434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f114435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f114436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f114437d;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f114438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f114439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Animatable f114440c;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationRepeat(AnimatedDrawable2 r100) {
            super.onAnimationRepeat(r100);
            if (r100 == null) goto L6;
            r100.stop();
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            super.onAnimationStart(r100);
            Function0 r101 = this.f114438a.f114436c;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            super.onAnimationStop(r100);
            Function0 r101 = this.f114438a.f114437d;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "drawable2");
            ALogger.i("renaoyingwebp", String.valueOf(r101));
            if (r101 >= this.f114438a.f114434a) goto L5;
        L6:
            this.f114440c.stop();
        L7:
            this.f114438a.f114434a = r101;
            return;
        L5:
            if (r101 < (this.f114439b - 1)) goto L7;
            goto L6
        }

        public a(e r100, int r101, Animatable r102) {
            this.f114438a = r100;
            this.f114439b = r101;
            this.f114440c = r102;
        }
    }

    public e(boolean r100, Function0 r101, Function0 r102) {
        this.f114435b = r100;
        this.f114436c = r101;
        this.f114437d = r102;
        this.f114434a = -1;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        return;
    L5:
        if (this.f114435b == false) goto L7;
        int r103 = o2.f114570a;
        AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
        Intrinsics.checkNotNullParameter(r104, "animatable");
        r104.setPrivateFrameSchedulerFactory(n2.f114563a);
    L7:
        AnimatedDrawable2 r105 = (AnimatedDrawable2) r102;
        r105.setAnimationListener(new a(this, r105.getFrameCount(), r102));
    }
}

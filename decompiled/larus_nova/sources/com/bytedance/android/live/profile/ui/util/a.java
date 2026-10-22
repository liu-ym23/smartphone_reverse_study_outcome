package com.bytedance.android.live.profile.ui.util;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f86927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f86928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f86929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f86930d;

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.util.a$a, reason: collision with other inner class name */
    public static final class C1331a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f86931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f86932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Animatable f86933c;

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
            Function0 r101 = this.f86931a.f86929c;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            super.onAnimationStop(r100);
            Function0 r101 = this.f86931a.f86930d;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "drawable2");
            ALogger.i("renaoyingwebp", String.valueOf(r101));
            if (r101 >= this.f86931a.f86927a) goto L5;
        L6:
            this.f86933c.stop();
        L7:
            this.f86931a.f86927a = r101;
            return;
        L5:
            if (r101 < (this.f86932b - 1)) goto L7;
            goto L6
        }

        public C1331a(a r100, int r101, Animatable r102) {
            this.f86931a = r100;
            this.f86932b = r101;
            this.f86933c = r102;
        }
    }

    public a(boolean r100, Function0 r101, Function0 r102) {
        this.f86928b = r100;
        this.f86929c = r101;
        this.f86930d = r102;
        this.f86927a = -1;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        return;
    L5:
        if (this.f86928b == false) goto L7;
        int r103 = p.f86958a;
        AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
        Intrinsics.checkNotNullParameter(r104, "animatable");
        r104.setPrivateFrameSchedulerFactory(o.f86957a);
    L7:
        AnimatedDrawable2 r105 = (AnimatedDrawable2) r102;
        r105.setAnimationListener(new C1331a(this, r105.getFrameCount(), r102));
    }
}

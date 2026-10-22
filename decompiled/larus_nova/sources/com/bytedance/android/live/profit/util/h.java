package com.bytedance.android.live.profit.util;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f89098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f89099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f89100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f89101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f89102e;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f89103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animatable f89104b;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationRepeat(AnimatedDrawable2 r100) {
            this.f89104b.stop();
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            Intrinsics.checkNotNullParameter(r100, "drawable2");
            this.f89103a.f89099b.invoke();
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            Intrinsics.checkNotNullParameter(r100, "drawable2");
            this.f89103a.f89100c.invoke();
        }

        public a(h r100, Animatable r101) {
            this.f89103a = r100;
            this.f89104b = r101;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "drawable2");
            if (r101 < this.f89103a.f89098a) goto L7;
            if (r101 >= (r100.getFrameCount() - 1)) goto L7;
        L10:
            this.f89103a.f89098a = r101;
            return;
        L7:
            if (this.f89103a.f89101d == false) goto L9;
            ((AnimatedDrawable2) this.f89104b).jumpToFrame(r100.getFrameCount() - 1);
        L9:
            this.f89104b.stop();
            goto L10
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
        new WeakReference(r102);
        AnimatedDrawable2 r103 = (AnimatedDrawable2) r102;
        r103.setLoopCount(1);
        r103.setAnimationListener(new a(this, r102));
    L6:
        if (this.f89102e == false) goto L10;
        if (r102 == null) goto L11;
        r102.start();
        return;
    L11:
        return;
    }

    public h(Function0 r100, Function0 r101, boolean r102, boolean r103) {
        this.f89099b = r100;
        this.f89100c = r101;
        this.f89101d = r102;
        this.f89102e = r103;
        this.f89098a = -1;
        new WeakReference(null);
    }
}

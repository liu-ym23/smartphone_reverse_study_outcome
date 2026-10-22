package com.bytedance.android.gamecp.common.utils;

import android.graphics.drawable.Animatable;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class u1 extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f57309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f57310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f57311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f57312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0 f57313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function1 f57314f;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f57315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u1 f57316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Animatable f57317c;

        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.bytedance.android.gamecp.common.utils.AnimationStatus] */
        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            u1 r101 = this.f57316b;
            Ref.ObjectRef r102 = r101.f57309a;
            r102.element = AnimationStatus.START;
            r101.f57312d.invoke();
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.bytedance.android.gamecp.common.utils.AnimationStatus] */
        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            u1 r101 = this.f57316b;
            Ref.ObjectRef r102 = r101.f57309a;
            r102.element = AnimationStatus.END;
            HSImageView r103 = r101.f57310b;
            if (r103 == null) goto L5;
            r103.setController(null);
        L5:
            this.f57316b.f57313e.invoke();
        }

        public a(u1 r100, Animatable r101) {
            this.f57316b = r100;
            this.f57317c = r101;
            this.f57315a = -1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.android.gamecp.common.utils.AnimationStatus] */
        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            Ref.ObjectRef r102 = this.f57316b.f57309a;
            r102.element = AnimationStatus.ANIMATION;
            if (r101 >= this.f57315a) goto L5;
            this.f57317c.stop();
        L5:
            Function1 r103 = this.f57316b.f57314f;
            if (r103 == null) goto L8;
            Unit r104 = (Unit) r103.invoke(Integer.valueOf(r101));
        L8:
            this.f57315a = r101;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.bytedance.android.gamecp.common.utils.AnimationStatus] */
    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        Ref.ObjectRef r102 = this.f57309a;
        r102.element = AnimationStatus.FAIL;
        HSImageView r103 = this.f57310b;
        if (r103 == null) goto L5;
        r103.setController(null);
    L5:
        this.f57311c.invoke();
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if ((r102 instanceof AnimatedDrawable2) == false) goto L5;
        ((AnimatedDrawable2) r102).setAnimationListener(new a(this, r102));
    L5:
        if (r102 == null) goto L8;
        r102.start();
        return;
    }

    public u1(Ref.ObjectRef r100, HSImageView r101, Function0 r102, Function0 r103, Function0 r104, Function1 r105) {
        this.f57309a = r100;
        this.f57310b = r101;
        this.f57311c = r102;
        this.f57312d = r103;
        this.f57313e = r104;
        this.f57314f = r105;
    }
}

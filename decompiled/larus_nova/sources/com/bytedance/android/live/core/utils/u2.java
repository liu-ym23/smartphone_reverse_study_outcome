package com.bytedance.android.live.core.utils;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class u2 extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f66410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f66411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f66412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f66413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0 f66414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function1 f66415f;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f66416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u2 f66417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Animatable f66418c;

        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.bytedance.android.live.core.utils.AnimationStatus] */
        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            u2 r101 = this.f66417b;
            Ref.ObjectRef r102 = r101.f66410a;
            r102.element = AnimationStatus.START;
            r101.f66413d.invoke();
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.bytedance.android.live.core.utils.AnimationStatus] */
        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            u2 r101 = this.f66417b;
            Ref.ObjectRef r102 = r101.f66410a;
            r102.element = AnimationStatus.END;
            HSImageView r103 = r101.f66411b;
            if (r103 == null) goto L5;
            r103.setController(null);
        L5:
            this.f66417b.f66414e.invoke();
        }

        public a(u2 r100, Animatable r101) {
            this.f66417b = r100;
            this.f66418c = r101;
            this.f66416a = -1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.android.live.core.utils.AnimationStatus] */
        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            Ref.ObjectRef r102 = this.f66417b.f66410a;
            r102.element = AnimationStatus.ANIMATION;
            if (r101 >= this.f66416a) goto L5;
            this.f66418c.stop();
        L5:
            Function1 r103 = this.f66417b.f66415f;
            if (r103 == null) goto L8;
            Unit r104 = (Unit) r103.invoke(Integer.valueOf(r101));
        L8:
            this.f66416a = r101;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.bytedance.android.live.core.utils.AnimationStatus] */
    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        Ref.ObjectRef r102 = this.f66410a;
        r102.element = AnimationStatus.FAIL;
        HSImageView r103 = this.f66411b;
        if (r103 == null) goto L5;
        r103.setController(null);
    L5:
        this.f66412c.invoke();
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

    public u2(Ref.ObjectRef r100, HSImageView r101, Function0 r102, Function0 r103, Function0 r104, Function1 r105) {
        this.f66410a = r100;
        this.f66411b = r101;
        this.f66412c = r102;
        this.f66413d = r103;
        this.f66414e = r104;
        this.f66415f = r105;
    }
}

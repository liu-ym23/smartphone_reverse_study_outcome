package b02;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboEffectAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComboEffectAnimationView f16824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f16825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f16826c;

    public static final class a extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f16827a;

        public a(b r100) {
            this.f16827a = r100;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            b r101 = this.f16827a;
            if (r101.f16824a.indexOfChild(r101.f16825b) < 0) goto L6;
            b r102 = this.f16827a;
            r102.f16824a.removeView(r102.f16825b);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100, r101);
            b r102 = this.f16827a;
            if (r102.f16824a.indexOfChild(r102.f16825b) < 0) goto L6;
            b r103 = this.f16827a;
            r103.f16824a.removeView(r103.f16825b);
            return;
        }
    }

    public b(ComboEffectAnimationView r100, LottieAnimationView r101, Ref.ObjectRef r102) {
        this.f16824a = r100;
        this.f16825b = r101;
        this.f16826c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        this.f16825b.setAnimation((String) this.f16826c.element);     // Catch: Throwable -> L4
        this.f16825b.addAnimatorListener(new a(this));     // Catch: Throwable -> L4
        this.f16825b.playAnimation();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

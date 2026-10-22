package bj4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.creativex.mediaimport.preview.internal.main.y;
import com.bytedance.creativex.mediaimport.widget.gesture.ScaleGestureLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class s extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScaleGestureLayout f19237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f19238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f19239c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        FLogger.f375446a.i("effect_platform", "animateDisappear Step3 appearOrDisAppearAnimator end");
        this.f19237a.f204209v = null;
        this.f19238b.element = true;
        this.f19239c.invoke();
    }

    public s(ScaleGestureLayout r100, Ref.BooleanRef r101, y r102) {
        this.f19237a = r100;
        this.f19238b = r101;
        this.f19239c = r102;
    }
}

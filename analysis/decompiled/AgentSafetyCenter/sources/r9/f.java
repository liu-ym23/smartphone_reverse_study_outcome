package r9;

import com.stepos.common.animator.StepOSPressAnimationDrawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements z3.f {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ StepOSPressAnimationDrawable f10502a;

    @Override // z3.f
    public final void a(float f5) {
        StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.f10502a;
        stepOSPressAnimationDrawable.i = f5 / 100.0f;
        stepOSPressAnimationDrawable.invalidateSelf();
    }
}

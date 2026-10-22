package aj4;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.transition.EmptyTransition;
import com.ss.android.ugc.aweme.transition.InitiativeTransition;
import com.ss.android.ugc.aweme.transition.TransitionListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j extends TransitionListener.DefaultTransitionListener implements InitiativeTransition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f3914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Interpolator f3916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f3917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TransitionListener f3920g;

    public static final class a {
    }

    static {
    }

    public j(View r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f3914a = r100;
        this.f3915b = true;
        this.f3916c = null;
        this.f3917d = null;
        this.f3918e = 200;
        this.f3919f = 200;
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void a(TransitionListener.DefaultTransitionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f3920g = r100;
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void d(final EmptyTransition r100) {
        this.f3914a.post(new g(this, r100));
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void g(final EmptyTransition r100) {
        TransitionListener r101 = this.f3920g;
        if (r101 == null) goto L5;
        r101.f();
    L5:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.f3919f);
        Interpolator r103 = this.f3917d;
        if (r103 == null) goto L8;
        r102.setInterpolator(r103);
    L8:
        final int r104 = this.f3914a.getMeasuredWidth();
        r102.addUpdateListener(new h(r104, this, r100));
        r102.addListener(new k(this, r100));
        r102.start();
    }
}

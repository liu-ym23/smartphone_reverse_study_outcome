package com.stepos.widget.searchbar;

import android.app.Activity;
import android.transition.Transition;
import android.view.View;
import com.stepos.widget.searchbar.StepOSSearchTransition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"com/stepos/widget/searchbar/StepOSSearchTransition$ReleaseSearchBackdropOnResume$onActivityResumed$listener$1", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "t", "LY8/t;", "onTransitionStart", "(Landroid/transition/Transition;)V", "onTransitionEnd", "onTransitionCancel", "onTransitionPause", "onTransitionResume", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSSearchTransition$ReleaseSearchBackdropOnResume$onActivityResumed$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ StepOSSearchTransition.ReleaseSearchBackdropOnResume this$0;

    public StepOSSearchTransition$ReleaseSearchBackdropOnResume$onActivityResumed$listener$1(StepOSSearchTransition.ReleaseSearchBackdropOnResume releaseSearchBackdropOnResume, Activity activity) {
        this.this$0 = releaseSearchBackdropOnResume;
        this.$activity = activity;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition t10) {
        kotlin.jvm.internal.p.i(t10, "t");
        onTransitionEnd(t10);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition t10) {
        kotlin.jvm.internal.p.i(t10, "t");
        t10.removeListener(this);
        this.this$0.release();
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition t10) {
        kotlin.jvm.internal.p.i(t10, "t");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition t10) {
        kotlin.jvm.internal.p.i(t10, "t");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition t10) {
        kotlin.jvm.internal.p.i(t10, "t");
        this.this$0.returnStarted = true;
        View decorView = this.$activity.getWindow().getDecorView();
        final StepOSSearchTransition.ReleaseSearchBackdropOnResume releaseSearchBackdropOnResume = this.this$0;
        decorView.postDelayed(new Runnable() { // from class: com.stepos.widget.searchbar.s
            @Override // java.lang.Runnable
            public final void run() {
                StepOSSearchTransition.ReleaseSearchBackdropOnResume.access$release(releaseSearchBackdropOnResume);
            }
        }, 800L);
    }
}

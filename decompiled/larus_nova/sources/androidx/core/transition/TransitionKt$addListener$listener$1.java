package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1<Transition, Unit> $onCancel;
    final /* synthetic */ Function1<Transition, Unit> $onEnd;
    final /* synthetic */ Function1<Transition, Unit> $onPause;
    final /* synthetic */ Function1<Transition, Unit> $onResume;
    final /* synthetic */ Function1<Transition, Unit> $onStart;

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition r100) {
        this.$onCancel.invoke(r100);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition r100) {
        this.$onEnd.invoke(r100);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition r100) {
        this.$onPause.invoke(r100);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition r100) {
        this.$onResume.invoke(r100);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition r100) {
        this.$onStart.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> r100, Function1<? super Transition, Unit> r101, Function1<? super Transition, Unit> r102, Function1<? super Transition, Unit> r103, Function1<? super Transition, Unit> r104) {
        this.$onEnd = r100;
        this.$onResume = r101;
        this.$onPause = r102;
        this.$onCancel = r103;
        this.$onStart = r104;
    }
}

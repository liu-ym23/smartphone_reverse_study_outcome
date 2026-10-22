package com.obric.anim;

import androidx.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OEAAnim.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\f\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\r\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/anim/TransitionCallback;", "Landroidx/transition/Transition$TransitionListener;", "()V", "onTransitionCancel", "Lkotlin/Function0;", "", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "onCancel", "block", "onEnd", "onPause", "onResume", "onStart", "transition", "Landroidx/transition/Transition;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransitionCallback implements Transition.TransitionListener {
    private Function0<Unit> onTransitionCancel;
    private Function0<Unit> onTransitionEnd;
    private Function0<Unit> onTransitionPause;
    private Function0<Unit> onTransitionResume;
    private Function0<Unit> onTransitionStart;

    public TransitionCallback() {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionStart(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        Function0<Unit> r1 = this.onTransitionStart;
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        Function0<Unit> r1 = this.onTransitionEnd;
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        Function0<Unit> r1 = this.onTransitionCancel;
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionPause(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        Function0<Unit> r1 = this.onTransitionPause;
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionResume(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        Function0<Unit> r1 = this.onTransitionResume;
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }

    public final TransitionCallback onEnd(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.onTransitionEnd = r2;
        return this;
    }

    public final TransitionCallback onStart(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.onTransitionStart = r2;
        return this;
    }

    public final TransitionCallback onCancel(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.onTransitionCancel = r2;
        return this;
    }

    public final TransitionCallback onPause(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.onTransitionPause = r2;
        return this;
    }

    public final TransitionCallback onResume(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.onTransitionResume = r2;
        return this;
    }
}

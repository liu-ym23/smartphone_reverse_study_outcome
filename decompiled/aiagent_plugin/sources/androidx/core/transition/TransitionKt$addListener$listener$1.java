package androidx.core.transition;

import android.transition.Transition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.x;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ b<Transition, x> $onCancel;
    final /* synthetic */ b<Transition, x> $onEnd;
    final /* synthetic */ b<Transition, x> $onPause;
    final /* synthetic */ b<Transition, x> $onResume;
    final /* synthetic */ b<Transition, x> $onStart;

    public TransitionKt$addListener$listener$1(b<? super Transition, x> r3, b<? super Transition, x> r4, b<? super Transition, x> r5, b<? super Transition, x> r6, b<? super Transition, x> r7) {
        b<Transition, x> r8 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        b<Transition, x> r9 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        b<Transition, x> r10 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        b<Transition, x> r11 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        b<Transition, x> r12 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        this.$onEnd = r8;
        this.$onResume = r9;
        this.$onPause = r10;
        this.$onCancel = r11;
        this.$onStart = r12;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition r1) {
        this.$onEnd.invoke(r1);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition r1) {
        this.$onResume.invoke(r1);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition r1) {
        this.$onPause.invoke(r1);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition r1) {
        this.$onCancel.invoke(r1);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition r1) {
        this.$onStart.invoke(r1);
    }
}

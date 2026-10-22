package androidx.core.transition;

import android.transition.Transition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt$doOnCancel$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ b $onCancel;

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition r1) {
    }

    public TransitionKt$doOnCancel$$inlined$addListener$default$1(b r3) {
        this.$onCancel = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition r1) {
        this.$onCancel.invoke(r1);
    }
}

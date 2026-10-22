package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
public abstract class TransitionPropagation {
    public TransitionPropagation() {
    }

    public abstract void captureValues(TransitionValues r100);

    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(ViewGroup r100, Transition r101, TransitionValues r102, TransitionValues r103);
}

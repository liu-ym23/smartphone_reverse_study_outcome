package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        M();
    }

    public final void M() {
        J(1);
        x(new Fade(2)).x(new ChangeBounds()).x(new Fade(1));
    }

    public AutoTransition(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        M();
    }
}

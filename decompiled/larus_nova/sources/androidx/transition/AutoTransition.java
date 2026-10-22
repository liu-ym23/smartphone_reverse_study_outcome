package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes17.dex */
public class AutoTransition extends TransitionSet {
    private void init() {
        setOrdering(1);
        addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
    }

    public AutoTransition() {
        init();
    }

    public AutoTransition(Context r100, AttributeSet r101) {
        super(r100, r101);
        init();
    }
}

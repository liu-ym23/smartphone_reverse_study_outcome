package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: loaded from: classes17.dex */
public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public TransitionBuilder() {
    }

    public static void validate(MotionLayout r100) {
        MotionScene r101 = r100.mScene;
        if (r101 == null) goto L16;
        if (r101.validateLayout(r100) == false) goto L14;
        if (r101.mCurrentTransition == null) goto L12;
        if (r101.getDefinedTransitions().isEmpty() == true) goto L12;
        return;
    L12:
        throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
    L14:
        throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
    L16:
        throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
    }

    private static void updateConstraintSetInMotionScene(MotionScene r100, MotionScene.Transition r101, ConstraintSet r102, ConstraintSet r103) {
        int r104 = r101.getStartConstraintSetId();
        int r105 = r101.getEndConstraintSetId();
        r100.setConstraintSet(r104, r102);
        r100.setConstraintSet(r105, r103);
    }

    public static MotionScene.Transition buildTransition(MotionScene r100, int r101, int r102, ConstraintSet r103, int r104, ConstraintSet r105) {
        MotionScene.Transition r106 = new MotionScene.Transition(r101, r100, r102, r104);
        updateConstraintSetInMotionScene(r100, r106, r103, r105);
        return r106;
    }
}

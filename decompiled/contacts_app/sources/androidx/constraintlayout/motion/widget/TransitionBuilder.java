package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: loaded from: classes.dex */
public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public TransitionBuilder() {
    }

    public static void validate(MotionLayout layout) {
        if (layout.mScene == null) goto L16;
        MotionScene r0 = layout.mScene;
        if (r0.validateLayout(layout) == false) goto L14;
        if (r0.mCurrentTransition == null) goto L12;
        if (r0.getDefinedTransitions().isEmpty() == true) goto L12;
        return;
    L12:
        throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
    L14:
        throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
    L16:
        throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
    }

    public static MotionScene.Transition buildTransition(MotionScene scene, int transitionId, int startConstraintSetId, ConstraintSet startConstraintSet, int endConstraintSetId, ConstraintSet endConstraintSet) {
        MotionScene.Transition r0 = new MotionScene.Transition(transitionId, scene, startConstraintSetId, endConstraintSetId);
        updateConstraintSetInMotionScene(scene, r0, startConstraintSet, endConstraintSet);
        return r0;
    }

    private static void updateConstraintSetInMotionScene(MotionScene scene, MotionScene.Transition transition, ConstraintSet startConstraintSet, ConstraintSet endConstraintSet) {
        int r0 = transition.getStartConstraintSetId();
        int r2 = transition.getEndConstraintSetId();
        scene.setConstraintSet(r0, startConstraintSet);
        scene.setConstraintSet(r2, endConstraintSet);
    }
}

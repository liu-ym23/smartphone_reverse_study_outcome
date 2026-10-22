package androidx.transition;

/* JADX INFO: loaded from: classes.dex */
class Styleable {
    static final int[] ARC_MOTION = null;
    static final int[] CHANGE_BOUNDS = null;
    static final int[] CHANGE_TRANSFORM = null;
    static final int[] FADE = null;
    static final int[] PATTERN_PATH_MOTION = null;
    static final int[] SLIDE = null;
    static final int[] TRANSITION = null;
    static final int[] TRANSITION_MANAGER = null;
    static final int[] TRANSITION_SET = null;
    static final int[] TRANSITION_TARGET = null;
    static final int[] VISIBILITY_TRANSITION = null;

    interface ArcMotion {
        public static final int MAXIMUM_ANGLE = 2;
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    interface ChangeBounds {
        public static final int RESIZE_CLIP = 0;
    }

    interface ChangeTransform {
        public static final int REPARENT = 0;
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    interface Fade {
        public static final int FADING_MODE = 0;
    }

    interface PatternPathMotion {
        public static final int PATTERN_PATH_DATA = 0;
    }

    interface Slide {
        public static final int SLIDE_EDGE = 0;
    }

    interface Transition {
        public static final int DURATION = 1;
        public static final int INTERPOLATOR = 0;
        public static final int MATCH_ORDER = 3;
        public static final int START_DELAY = 2;
    }

    interface TransitionManager {
        public static final int FROM_SCENE = 0;
        public static final int TO_SCENE = 1;
        public static final int TRANSITION = 2;
    }

    interface TransitionSet {
        public static final int TRANSITION_ORDERING = 0;
    }

    interface TransitionTarget {
        public static final int EXCLUDE_CLASS = 3;
        public static final int EXCLUDE_ID = 2;
        public static final int EXCLUDE_NAME = 5;
        public static final int TARGET_CLASS = 0;
        public static final int TARGET_ID = 1;
        public static final int TARGET_NAME = 4;
    }

    interface VisibilityTransition {
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    static {
        TRANSITION_TARGET = new int[]{android.R.attr.targetClass, android.R.attr.targetId, android.R.attr.excludeId, android.R.attr.excludeClass, android.R.attr.targetName, android.R.attr.excludeName};
        TRANSITION_MANAGER = new int[]{android.R.attr.fromScene, android.R.attr.toScene, android.R.attr.transition};
        TRANSITION = new int[]{android.R.attr.interpolator, android.R.attr.duration, android.R.attr.startDelay, android.R.attr.matchOrder};
        CHANGE_BOUNDS = new int[]{android.R.attr.resizeClip};
        VISIBILITY_TRANSITION = new int[]{android.R.attr.transitionVisibilityMode};
        FADE = new int[]{android.R.attr.fadingMode};
        CHANGE_TRANSFORM = new int[]{android.R.attr.reparent, android.R.attr.reparentWithOverlay};
        SLIDE = new int[]{android.R.attr.slideEdge};
        TRANSITION_SET = new int[]{android.R.attr.transitionOrdering};
        ARC_MOTION = new int[]{android.R.attr.minimumHorizontalAngle, android.R.attr.minimumVerticalAngle, android.R.attr.maximumAngle};
        PATTERN_PATH_MOTION = new int[]{android.R.attr.patternPathData};
    }

    private Styleable() {
    }
}

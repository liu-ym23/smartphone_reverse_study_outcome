package androidx.transition;

import android.R;

/* JADX INFO: loaded from: classes17.dex */
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

    public interface ArcMotion {
        public static final int MAXIMUM_ANGLE = 2;
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    public interface ChangeBounds {
        public static final int RESIZE_CLIP = 0;
    }

    public interface ChangeTransform {
        public static final int REPARENT = 0;
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    public interface Fade {
        public static final int FADING_MODE = 0;
    }

    public interface PatternPathMotion {
        public static final int PATTERN_PATH_DATA = 0;
    }

    public interface Slide {
        public static final int SLIDE_EDGE = 0;
    }

    public interface Transition {
        public static final int DURATION = 1;
        public static final int INTERPOLATOR = 0;
        public static final int MATCH_ORDER = 3;
        public static final int START_DELAY = 2;
    }

    public interface TransitionManager {
        public static final int FROM_SCENE = 0;
        public static final int TO_SCENE = 1;
        public static final int TRANSITION = 2;
    }

    public interface TransitionSet {
        public static final int TRANSITION_ORDERING = 0;
    }

    public interface TransitionTarget {
        public static final int EXCLUDE_CLASS = 3;
        public static final int EXCLUDE_ID = 2;
        public static final int EXCLUDE_NAME = 5;
        public static final int TARGET_CLASS = 0;
        public static final int TARGET_ID = 1;
        public static final int TARGET_NAME = 4;
    }

    public interface VisibilityTransition {
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    static {
        TRANSITION_TARGET = new int[]{R.attr.targetClass, R.attr.targetId, R.attr.excludeId, R.attr.excludeClass, R.attr.targetName, R.attr.excludeName};
        TRANSITION_MANAGER = new int[]{R.attr.fromScene, R.attr.toScene, R.attr.transition};
        TRANSITION = new int[]{R.attr.interpolator, R.attr.duration, R.attr.startDelay, R.attr.matchOrder};
        CHANGE_BOUNDS = new int[]{R.attr.resizeClip};
        VISIBILITY_TRANSITION = new int[]{R.attr.transitionVisibilityMode};
        FADE = new int[]{R.attr.fadingMode};
        CHANGE_TRANSFORM = new int[]{R.attr.reparent, R.attr.reparentWithOverlay};
        SLIDE = new int[]{R.attr.slideEdge};
        TRANSITION_SET = new int[]{R.attr.transitionOrdering};
        ARC_MOTION = new int[]{R.attr.minimumHorizontalAngle, R.attr.minimumVerticalAngle, R.attr.maximumAngle};
        PATTERN_PATH_MOTION = new int[]{R.attr.patternPathData};
    }

    private Styleable() {
    }
}

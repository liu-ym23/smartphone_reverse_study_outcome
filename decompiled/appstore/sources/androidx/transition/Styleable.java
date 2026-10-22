package androidx.transition;

import android.R;
import androidx.annotation.StyleableRes;

/* JADX INFO: loaded from: classes.dex */
public abstract class Styleable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f4994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f4995b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f4996c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f4997d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f4998e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f4999f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f5000g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f5001h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f5002i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f5003j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f5004k = null;

    public interface ArcMotion {

        @StyleableRes
        public static final int MAXIMUM_ANGLE = 2;

        @StyleableRes
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;

        @StyleableRes
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    public interface ChangeBounds {

        @StyleableRes
        public static final int RESIZE_CLIP = 0;
    }

    public interface ChangeTransform {

        @StyleableRes
        public static final int REPARENT = 0;

        @StyleableRes
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    public interface Fade {

        @StyleableRes
        public static final int FADING_MODE = 0;
    }

    public interface PatternPathMotion {

        @StyleableRes
        public static final int PATTERN_PATH_DATA = 0;
    }

    public interface Slide {

        @StyleableRes
        public static final int SLIDE_EDGE = 0;
    }

    public interface Transition {

        @StyleableRes
        public static final int DURATION = 1;

        @StyleableRes
        public static final int INTERPOLATOR = 0;

        @StyleableRes
        public static final int MATCH_ORDER = 3;

        @StyleableRes
        public static final int START_DELAY = 2;
    }

    public interface TransitionManager {

        @StyleableRes
        public static final int FROM_SCENE = 0;

        @StyleableRes
        public static final int TO_SCENE = 1;

        @StyleableRes
        public static final int TRANSITION = 2;
    }

    public interface TransitionSet {

        @StyleableRes
        public static final int TRANSITION_ORDERING = 0;
    }

    public interface TransitionTarget {

        @StyleableRes
        public static final int EXCLUDE_CLASS = 3;

        @StyleableRes
        public static final int EXCLUDE_ID = 2;

        @StyleableRes
        public static final int EXCLUDE_NAME = 5;

        @StyleableRes
        public static final int TARGET_CLASS = 0;

        @StyleableRes
        public static final int TARGET_ID = 1;

        @StyleableRes
        public static final int TARGET_NAME = 4;
    }

    public interface VisibilityTransition {

        @StyleableRes
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    static {
        f4994a = new int[]{R.attr.targetClass, R.attr.targetId, R.attr.excludeId, R.attr.excludeClass, R.attr.targetName, R.attr.excludeName};
        f4995b = new int[]{R.attr.fromScene, R.attr.toScene, R.attr.transition};
        f4996c = new int[]{R.attr.interpolator, R.attr.duration, R.attr.startDelay, R.attr.matchOrder};
        f4997d = new int[]{R.attr.resizeClip};
        f4998e = new int[]{R.attr.transitionVisibilityMode};
        f4999f = new int[]{R.attr.fadingMode};
        f5000g = new int[]{R.attr.reparent, R.attr.reparentWithOverlay};
        f5001h = new int[]{R.attr.slideEdge};
        f5002i = new int[]{R.attr.transitionOrdering};
        f5003j = new int[]{R.attr.minimumHorizontalAngle, R.attr.minimumVerticalAngle, R.attr.maximumAngle};
        f5004k = new int[]{R.attr.patternPathData};
    }
}

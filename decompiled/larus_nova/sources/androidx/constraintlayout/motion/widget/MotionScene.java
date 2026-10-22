package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.StateSet;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public class MotionScene {
    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private boolean DEBUG_DESKTOP;
    private ArrayList<Transition> mAbstractTransitionList;
    private HashMap<String, Integer> mConstraintSetIdMap;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    Transition mCurrentTransition;
    private int mDefaultDuration;
    private Transition mDefaultTransition;
    private SparseIntArray mDeriveMap;
    private boolean mDisableAutoTransition;
    private boolean mIgnoreTouch;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private int mLayoutDuringTransition;
    private final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion;
    private boolean mRtl;
    StateSet mStateSet;
    private ArrayList<Transition> mTransitionList;
    private MotionLayout.MotionTracker mVelocityTracker;

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            @Override // android.view.View.OnClickListener
            public void onClick(View r100) {
                MotionLayout r101 = MotionScene.access$800(Transition.access$700(this.mTransition));
                if (r101.isInteractionEnabled() == true) goto L6;
                return;
            L6:
                if (Transition.access$100(this.mTransition) != (-1)) goto L13;
                int r102 = r101.getCurrentState();
                if (r102 != (-1)) goto L11;
                r101.transitionToState(Transition.access$000(this.mTransition));
                return;
            L11:
                Transition r103 = new Transition(Transition.access$700(this.mTransition), this.mTransition);
                Transition.access$102(r103, r102);
                Transition.access$002(r103, Transition.access$000(this.mTransition));
                r101.setTransition(r103);
                r101.transitionToEnd();
                return;
            L13:
                Transition r104 = Transition.access$700(this.mTransition).mCurrentTransition;
                int r105 = this.mMode;
                boolean r106 = false;
                if ((r105 & 1) == 0) goto L16;
            L19:
                boolean r107 = true;
            L21:
                if ((r105 & 16) == 0) goto L23;
            L26:
                boolean r108 = true;
            L27:
                if (r107 == false) goto L30;
                if (r108 == false) goto L30;
                boolean r109 = true;
            L31:
                if (r109 == false) goto L41;
                Transition r110 = Transition.access$700(this.mTransition).mCurrentTransition;
                Transition r111 = this.mTransition;
                if (r110 == r111) goto L36;
                r101.setTransition(r111);
            L36:
                if (r101.getCurrentState() == r101.getEndState()) goto L43;
                if (r101.getProgress() > 0.5f) goto L43;
                r106 = r107;
                r108 = false;
            L43:
                if (isTransitionViable(r104, r101) == false) goto L61;
                if (r106 == true) goto L46;
            L48:
                if (r108 == true) goto L50;
            L52:
                if (r106 == true) goto L54;
            L56:
                if (r108 == true) goto L58;
                return;
            L58:
                if ((this.mMode & 4096) == 0) goto L66;
                r101.setTransition(this.mTransition);
                r101.setProgress(0.0f);
                return;
            L66:
                return;
            L54:
                if ((this.mMode & 256) == 0) goto L56;
                r101.setTransition(this.mTransition);
                r101.setProgress(1.0f);
                return;
            L50:
                if ((this.mMode & 16) == 0) goto L52;
                r101.setTransition(this.mTransition);
                r101.transitionToStart();
                return;
            L46:
                if ((this.mMode & 1) == 0) goto L48;
                r101.setTransition(this.mTransition);
                r101.transitionToEnd();
                return;
            L61:
                return;
            L41:
                r106 = r107;
            L30:
                r109 = false;
                goto L31
            L23:
                if ((r105 & 4096) != 0) goto L26;
                r108 = false;
                goto L27
            L16:
                if ((r105 & 256) != 0) goto L19;
                r107 = false;
                goto L21
            }

            public void removeOnClickListeners(MotionLayout r100) {
                int r101 = this.mTargetId;
                if (r101 != (-1)) goto L5;
                return;
            L5:
                View r102 = r100.findViewById(r101);
                if (r102 == null) goto L8;
                r102.setOnClickListener(null);
                return;
            }

            public boolean isTransitionViable(Transition r100, MotionLayout r101) {
                Transition r102 = this.mTransition;
                if (r102 != r100) goto L5;
                return true;
            L5:
                int r103 = Transition.access$000(r102);
                int r104 = Transition.access$100(this.mTransition);
                if (r104 == (-1)) goto L8;
                int r105 = r101.mCurrentState;
                if (r105 == r104) goto L19;
                if (r105 == r103) goto L20;
                return false;
            L20:
                return true;
            L19:
                return true;
            L8:
                if (r101.mCurrentState != r103) goto L18;
                return false;
            L18:
                return true;
            }

            public TransitionOnClick(Context r100, Transition r101, XmlPullParser r102) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r101;
                TypedArray r103 = r100.obtainStyledAttributes(Xml.asAttributeSet(r102), new int[]{R.attr.clickAction, R.attr.targetId});
                int r104 = r103.getIndexCount();
                int r105 = 0;
            L3:
                if (r105 >= r104) goto L10;
                int r106 = r103.getIndex(r105);
                if (r106 != 1) goto L7;
                this.mTargetId = r103.getResourceId(r106, this.mTargetId);
            L9:
                r105 = r105 + 1;
                goto L3
            L7:
                if (r106 != 0) goto L9;
                this.mMode = r103.getInt(r106, this.mMode);
                goto L9
            L10:
                r103.recycle();
            }

            public void addOnClickListeners(MotionLayout r100, int r101, Transition r102) {
                int r103 = this.mTargetId;
                View r104 = r100;
                if (r103 == (-1)) goto L6;
                r104 = r100.findViewById(r103);
            L6:
                if (r104 == null) goto L8;
                int r105 = Transition.access$100(r102);
                int r106 = Transition.access$000(r102);
                if (r105 != (-1)) goto L13;
                r104.setOnClickListener(this);
                return;
            L13:
                int r107 = this.mMode;
                boolean r108 = false;
                if ((r107 & 1) == 0) goto L17;
                if (r101 != r105) goto L17;
                boolean r109 = true;
            L19:
                if ((r107 & 256) == 0) goto L22;
                if (r101 != r105) goto L22;
                boolean r110 = true;
            L23:
                boolean r111 = r109 | r110;
                if ((r107 & 1) == 0) goto L27;
                if (r101 != r105) goto L27;
                boolean r112 = true;
            L28:
                boolean r113 = r112 | r111;
                if ((r107 & 16) == 0) goto L32;
                if (r101 != r106) goto L32;
                boolean r114 = true;
            L33:
                boolean r115 = r113 | r114;
                if ((r107 & 4096) == 0) goto L38;
                if (r101 != r106) goto L38;
                r108 = true;
            L38:
                if ((r115 | r108) == false) goto L41;
                r104.setOnClickListener(this);
                return;
            L41:
                return;
            L32:
                r114 = false;
            L27:
                r112 = false;
            L22:
                r110 = false;
            L17:
                r109 = false;
                goto L19
            }
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public static /* synthetic */ int access$000(Transition r100) {
            return r100.mConstraintSetEnd;
        }

        public static /* synthetic */ int access$100(Transition r100) {
            return r100.mConstraintSetStart;
        }

        public static /* synthetic */ boolean access$1200(Transition r100) {
            return r100.mIsAbstract;
        }

        public static /* synthetic */ ArrayList access$1300(Transition r100) {
            return r100.mKeyFramesList;
        }

        public static /* synthetic */ int access$1400(Transition r100) {
            return r100.mDefaultInterpolator;
        }

        public static /* synthetic */ String access$1500(Transition r100) {
            return r100.mDefaultInterpolatorString;
        }

        public static /* synthetic */ int access$1600(Transition r100) {
            return r100.mDefaultInterpolatorID;
        }

        public static /* synthetic */ int access$1700(Transition r100) {
            return r100.mDuration;
        }

        public static /* synthetic */ int access$1800(Transition r100) {
            return r100.mPathMotionArc;
        }

        public static /* synthetic */ float access$1900(Transition r100) {
            return r100.mStagger;
        }

        public static /* synthetic */ TouchResponse access$200(Transition r100) {
            return r100.mTouchResponse;
        }

        public static /* synthetic */ int access$300(Transition r100) {
            return r100.mId;
        }

        public static /* synthetic */ ArrayList access$400(Transition r100) {
            return r100.mOnClicks;
        }

        public static /* synthetic */ boolean access$500(Transition r100) {
            return r100.mDisable;
        }

        public static /* synthetic */ int access$600(Transition r100) {
            return r100.mAutoTransition;
        }

        public static /* synthetic */ MotionScene access$700(Transition r100) {
            return r100.mMotionScene;
        }

        public String debugString(Context r100) {
            if (this.mConstraintSetStart != (-1)) goto L5;
            String r101 = "null";
        L7:
            if (this.mConstraintSetEnd != (-1)) goto L10;
            return r101 + " -> null";
        L10:
            return r101 + " -> " + r100.getResources().getResourceEntryName(this.mConstraintSetEnd);
        L5:
            r101 = r100.getResources().getResourceEntryName(this.mConstraintSetStart);
            goto L7
        }

        public boolean isTransitionFlag(int r100) {
            if ((r100 & this.mTransitionFlags) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void setAutoTransition(int r100) {
            this.mAutoTransition = r100;
        }

        public void setDuration(int r100) {
            this.mDuration = r100;
        }

        public void setEnable(boolean r100) {
            this.mDisable = !r100;
        }

        public void setPathMotionArc(int r100) {
            this.mPathMotionArc = r100;
        }

        public void setStagger(float r100) {
            this.mStagger = r100;
        }

        public Transition(MotionScene r100, Transition r101) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = r100;
            if (r101 == null) goto L6;
            this.mPathMotionArc = r101.mPathMotionArc;
            this.mDefaultInterpolator = r101.mDefaultInterpolator;
            this.mDefaultInterpolatorString = r101.mDefaultInterpolatorString;
            this.mDefaultInterpolatorID = r101.mDefaultInterpolatorID;
            this.mDuration = r101.mDuration;
            this.mKeyFramesList = r101.mKeyFramesList;
            this.mStagger = r101.mStagger;
            this.mLayoutDuringTransition = r101.mLayoutDuringTransition;
            return;
        }

        public static /* synthetic */ int access$002(Transition r100, int r101) {
            r100.mConstraintSetEnd = r101;
            return r101;
        }

        public static /* synthetic */ int access$102(Transition r100, int r101) {
            r100.mConstraintSetStart = r101;
            return r101;
        }

        public static /* synthetic */ TouchResponse access$202(Transition r100, TouchResponse r101) {
            r100.mTouchResponse = r101;
            return r101;
        }

        public void addOnClick(Context r100, XmlPullParser r101) {
            this.mOnClicks.add(new TransitionOnClick(r100, this, r101));
        }

        public Transition(MotionScene r100, Context r101, XmlPullParser r102) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = MotionScene.access$900(r100);
            this.mLayoutDuringTransition = MotionScene.access$1000(r100);
            this.mMotionScene = r100;
            fillFromAttributeList(r100, r101, Xml.asAttributeSet(r102));
        }

        private void fill(MotionScene r110, Context r111, TypedArray r112) {
            int r100 = r112.getIndexCount();
            int r101 = 0;
        L4:
            if (r101 >= r100) goto L52;
            int r102 = r112.getIndex(r101);
            if (r102 != 2) goto L11;
            this.mConstraintSetEnd = r112.getResourceId(r102, this.mConstraintSetEnd);
            if ("layout".equals(r111.getResources().getResourceTypeName(this.mConstraintSetEnd)) == false) goto L50;
            ConstraintSet r103 = new ConstraintSet();
            r103.load(r111, this.mConstraintSetEnd);
            MotionScene.access$1100(r110).append(this.mConstraintSetEnd, r103);
        L50:
            r101 = r101 + 1;
            goto L4
        L11:
            if (r102 != 3) goto L16;
            this.mConstraintSetStart = r112.getResourceId(r102, this.mConstraintSetStart);
            if ("layout".equals(r111.getResources().getResourceTypeName(this.mConstraintSetStart)) == false) goto L50;
            ConstraintSet r104 = new ConstraintSet();
            r104.load(r111, this.mConstraintSetStart);
            MotionScene.access$1100(r110).append(this.mConstraintSetStart, r104);
            goto L50
        L16:
            if (r102 != 6) goto L29;
            int r105 = r112.peekValue(r102).type;
            if (r105 != 1) goto L22;
            int r106 = r112.getResourceId(r102, -1);
            this.mDefaultInterpolatorID = r106;
            if (r106 == (-1)) goto L50;
            this.mDefaultInterpolator = -2;
            goto L50
        L22:
            if (r105 != 3) goto L27;
            String r107 = r112.getString(r102);
            this.mDefaultInterpolatorString = r107;
            if (r107.indexOf(HTTP.URL_DEFAULT) <= 0) goto L26;
            this.mDefaultInterpolatorID = r112.getResourceId(r102, -1);
            this.mDefaultInterpolator = -2;
            goto L50
        L26:
            this.mDefaultInterpolator = -1;
            goto L50
        L27:
            this.mDefaultInterpolator = r112.getInteger(r102, this.mDefaultInterpolator);
            goto L50
        L29:
            if (r102 != 4) goto L32;
            this.mDuration = r112.getInt(r102, this.mDuration);
            goto L50
        L32:
            if (r102 != 8) goto L34;
            this.mStagger = r112.getFloat(r102, this.mStagger);
            goto L50
        L34:
            if (r102 != 1) goto L36;
            this.mAutoTransition = r112.getInteger(r102, this.mAutoTransition);
            goto L50
        L36:
            if (r102 != 0) goto L39;
            this.mId = r112.getResourceId(r102, this.mId);
            goto L50
        L39:
            if (r102 != 9) goto L42;
            this.mDisable = r112.getBoolean(r102, this.mDisable);
            goto L50
        L42:
            if (r102 != 7) goto L45;
            this.mPathMotionArc = r112.getInteger(r102, -1);
            goto L50
        L45:
            if (r102 != 5) goto L48;
            this.mLayoutDuringTransition = r112.getInteger(r102, 0);
            goto L50
        L48:
            if (r102 != 10) goto L50;
            this.mTransitionFlags = r112.getInteger(r102, 0);
            goto L50
        L52:
            if (this.mConstraintSetStart != (-1)) goto L74;
            this.mIsAbstract = true;
            return;
        }

        private void fillFromAttributeList(MotionScene r100, Context r101, AttributeSet r102) {
            TypedArray r103 = r101.obtainStyledAttributes(r102, new int[]{android.R.attr.id, R.attr.autoTransition, R.attr.constraintSetEnd, R.attr.constraintSetStart, R.attr.duration, R.attr.layoutDuringTransition, R.attr.motionInterpolator, R.attr.pathMotionArc, R.attr.staggered, R.attr.transitionDisable, R.attr.transitionFlags});
            fill(r100, r101, r103);
            r103.recycle();
        }

        public Transition(int r100, MotionScene r101, int r102, int r103) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = r100;
            this.mMotionScene = r101;
            this.mConstraintSetStart = r102;
            this.mConstraintSetEnd = r103;
            this.mDuration = MotionScene.access$900(r101);
            this.mLayoutDuringTransition = MotionScene.access$1000(r101);
        }
    }

    public float getPathPercent(View r100, int r101) {
        return 0.0f;
    }

    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int gatPathMotionArc() {
        Transition r100 = this.mCurrentTransition;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return Transition.access$1800(r100);
    }

    public int[] getConstraintSetIds() {
        int r100 = this.mConstraintSetMap.size();
        int[] r101 = new int[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = this.mConstraintSetMap.keyAt(r102);
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public int getDuration() {
        Transition r100 = this.mCurrentTransition;
        if (r100 == null) goto L7;
        return Transition.access$1700(r100);
    L7:
        return this.mDefaultDuration;
    }

    public int getEndId() {
        Transition r100 = this.mCurrentTransition;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return Transition.access$000(r100);
    }

    public Interpolator getInterpolator() {
        int r100 = Transition.access$1400(this.mCurrentTransition);
        if (r100 == (-2)) goto L30;
        if (r100 == (-1)) goto L27;
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 4) goto L20;
        if (r100 == 5) goto L18;
        return null;
    L18:
        return new BounceInterpolator();
    L20:
        return new AnticipateInterpolator();
    L22:
        return new DecelerateInterpolator();
    L24:
        return new AccelerateInterpolator();
    L26:
        return new AccelerateDecelerateInterpolator();
    L27:
        final Easing r101 = Easing.getInterpolator(Transition.access$1500(this.mCurrentTransition));
        return new AnonymousClass1(this, r101);
    L30:
        return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), Transition.access$1600(this.mCurrentTransition));
    }

    public float getMaxAcceleration() {
        Transition r100 = this.mCurrentTransition;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r100) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    public float getMaxVelocity() {
        Transition r100 = this.mCurrentTransition;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r100) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    public boolean getMoveWhenScrollAtTop() {
        Transition r100 = this.mCurrentTransition;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (Transition.access$200(r100) != null) goto L7;
        return false;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    public float getStaggered() {
        Transition r100 = this.mCurrentTransition;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return Transition.access$1900(r100);
    }

    public int getStartId() {
        Transition r100 = this.mCurrentTransition;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return Transition.access$100(r100);
    }

    public void setupTouch() {
        Transition r100 = this.mCurrentTransition;
        if (r100 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r100) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setupTouch();
        return;
    }

    public boolean supportTouch() {
        Iterator<Transition> r100 = this.mTransitionList.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        if (Transition.access$200(r100.next()) == null) goto L4;
        return true;
    L8:
        Transition r101 = this.mCurrentTransition;
        if (r101 != null) goto L11;
    L13:
        return false;
    L11:
        if (Transition.access$200(r101) == null) goto L13;
        return true;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public MotionScene(MotionLayout r100) {
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = r100;
    }

    public static /* synthetic */ int access$1000(MotionScene r100) {
        return r100.mLayoutDuringTransition;
    }

    public static /* synthetic */ SparseArray access$1100(MotionScene r100) {
        return r100.mConstraintSetMap;
    }

    public static /* synthetic */ MotionLayout access$800(MotionScene r100) {
        return r100.mMotionLayout;
    }

    public static /* synthetic */ int access$900(MotionScene r100) {
        return r100.mDefaultDuration;
    }

    private int getIndex(Transition r100) {
        int r101 = Transition.access$300(r100);
        if (r101 == (-1)) goto L13;
        int r102 = 0;
    L6:
        if (r102 >= this.mTransitionList.size()) goto L11;
        if (Transition.access$300((Transition) ListProtector.get(this.mTransitionList, r102)) == r101) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return r102;
    L11:
        return -1;
    L13:
        throw new IllegalArgumentException("The transition must have an id");
    }

    private int getRealID(int r100) {
        StateSet r101 = this.mStateSet;
        if (r101 == null) goto L7;
        int r102 = r101.stateGetConstraintID(r100, -1, -1);
        if (r102 == (-1)) goto L7;
        return r102;
    L7:
        return r100;
    }

    private boolean hasCycleDependency(int r100) {
        int r101 = this.mDeriveMap.get(r100);
        int r102 = this.mDeriveMap.size();
    L3:
        if (r101 <= 0) goto L11;
        if (r101 == r100) goto L6;
        int r103 = r102 - 1;
        if (r102 < 0) goto L9;
        r101 = this.mDeriveMap.get(r101);
        r102 = r103;
        goto L3
    L9:
        return true;
    L6:
        return true;
    L11:
        return false;
    }

    private void readConstraintChain(int r100) {
        int r101 = this.mDeriveMap.get(r100);
        if (r101 <= 0) goto L10;
        readConstraintChain(this.mDeriveMap.get(r100));
        ConstraintSet r102 = this.mConstraintSetMap.get(r100);
        ConstraintSet r103 = this.mConstraintSetMap.get(r101);
        if (r103 != null) goto L8;
        Debug.getName(this.mMotionLayout.getContext(), r101);
        return;
    L8:
        r102.readFallback(r103);
        this.mDeriveMap.put(r100, -1);
        return;
    }

    public static String stripID(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        int r101 = r100.indexOf(47);
        if (r101 >= 0) goto L9;
        return r100;
    L9:
        return r100.substring(r101 + 1);
    }

    public void addTransition(Transition r100) {
        int r101 = getIndex(r100);
        if (r101 != (-1)) goto L5;
        this.mTransitionList.add(r100);
        return;
    L5:
        ListProtector.set(this.mTransitionList, r101, r100);
    }

    public void disableAutoTransition(boolean r100) {
        this.mDisableAutoTransition = r100;
    }

    public ConstraintSet getConstraintSet(int r100) {
        return getConstraintSet(r100, -1, -1);
    }

    public void getKeyFrames(MotionController r100) {
        Transition r101 = this.mCurrentTransition;
        if (r101 != null) goto L11;
        Transition r102 = this.mDefaultTransition;
        if (r102 == null) goto L10;
        Iterator r103 = Transition.access$1300(r102).iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        ((KeyFrames) r103.next()).addFrames(r100);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r104 = Transition.access$1300(r101).iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        ((KeyFrames) r104.next()).addFrames(r100);
        goto L13
    }

    public Transition getTransitionById(int r100) {
        Iterator<Transition> r101 = this.mTransitionList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Transition r102 = r101.next();
        if (Transition.access$300(r102) != r100) goto L4;
        return r102;
    L8:
        return null;
    }

    public int getTransitionDirection(int r100) {
        Iterator<Transition> r101 = this.mTransitionList.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Transition.access$100(r101.next()) != r100) goto L4;
        return 0;
    L9:
        return 1;
    }

    public List<Transition> getTransitionsWithState(int r100) {
        int r101 = getRealID(r100);
        ArrayList r102 = new ArrayList();
        Iterator<Transition> r103 = this.mTransitionList.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        Transition r104 = r103.next();
        if (Transition.access$100(r104) == r101) goto L9;
        if (Transition.access$000(r104) != r101) goto L4;
    L9:
        r102.add(r104);
        goto L4
    L10:
        return r102;
    }

    public int lookUpConstraintId(String r100) {
        return this.mConstraintSetIdMap.get(r100).intValue();
    }

    public String lookUpConstraintName(int r100) {
        Iterator<Map.Entry<String, Integer>> r101 = this.mConstraintSetIdMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r102 = r101.next();
        if (r102.getValue().intValue() != r100) goto L4;
        return r102.getKey();
    L9:
        return null;
    }

    public void readFallback(MotionLayout r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= this.mConstraintSetMap.size()) goto L10;
        int r103 = this.mConstraintSetMap.keyAt(r102);
        if (hasCycleDependency(r103) == true) goto L7;
        readConstraintChain(r103);
        r102 = r102 + 1;
        goto L4
    L7:
        return;
    L10:
        if (r101 >= this.mConstraintSetMap.size()) goto L12;
        this.mConstraintSetMap.valueAt(r101).readFallback(r100);
        r101 = r101 + 1;
        goto L10
    }

    public void removeTransition(Transition r100) {
        int r101 = getIndex(r100);
        if (r101 == (-1)) goto L6;
        ListProtector.remove(this.mTransitionList, r101);
        return;
    }

    public void setDuration(int r100) {
        Transition r101 = this.mCurrentTransition;
        if (r101 == null) goto L5;
        r101.setDuration(r100);
        return;
    L5:
        this.mDefaultDuration = r100;
    }

    public void setRtl(boolean r100) {
        this.mRtl = r100;
        Transition r101 = this.mCurrentTransition;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r101) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    public void setTransition(Transition r100) {
        this.mCurrentTransition = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r100) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    public boolean validateLayout(MotionLayout r100) {
        if (r100 == this.mMotionLayout) goto L5;
    L7:
        return false;
    L5:
        if (r100.mScene != this) goto L7;
        return true;
    }

    private int getId(Context r100, String r101) {
        if (r101.contains(HTTP.URL_DEFAULT) == false) goto L7;
        int r102 = r100.getResources().getIdentifier(r101.substring(r101.indexOf(47) + 1), "id", r100.getPackageName());
        if (this.DEBUG_DESKTOP == false) goto L8;
        System.out.println("id getMap res = " + r102);
    L8:
        if (r102 == (-1)) goto L10;
        return r102;
    L10:
        if (r101.length() > 1) goto L12;
        return r102;
    L12:
        return CastIntegerProtector.parseInt(r101.substring(1));
    L7:
        r102 = -1;
        goto L8
    }

    private void load(Context r100, int r110) {
        XmlResourceParser r101 = r100.getResources().getXml(r110);
        int r102 = r101.getEventType();     // Catch: IOException -> L66 XmlPullParserException -> L68
        Transition r103 = null;
    L4:
        byte r104 = 1;
        if (r102 == 1) goto L87;
        if (r102 != 0) goto L8;
        r101.getName();     // Catch: IOException -> L66 XmlPullParserException -> L68
    L64:
        r102 = r101.next();     // Catch: IOException -> L66 XmlPullParserException -> L68
    L8:
        if (r102 != 2) goto L64;
        String r105 = r101.getName();     // Catch: IOException -> L66 XmlPullParserException -> L68
        if (this.DEBUG_DESKTOP == false) goto L14;
        System.out.println("parsing = " + r105);     // Catch: IOException -> L66 XmlPullParserException -> L68
    L14:
        switch(r105.hashCode()) {
            case -1349929691: goto L35;
            case -1239391468: goto L32;
            case 269306229: goto L29;
            case 312750793: goto L26;
            case 327855227: goto L23;
            case 793277014: goto L20;
            case 1382829617: goto L17;
            default: goto L37;
        };     // Catch: IOException -> L66 XmlPullParserException -> L68
    L37:
        r104 = -1;
    L38:
        switch(r104) {
            case 0: goto L61;
            case 1: goto L47;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            default: goto L64;
        };     // Catch: IOException -> L66 XmlPullParserException -> L68
    L40:
        Transition.access$1300(r103).add(new KeyFrames(r100, r101));     // Catch: IOException -> L66 XmlPullParserException -> L68
        goto L64
    L41:
        parseConstraintSet(r100, r101);     // Catch: IOException -> L66 XmlPullParserException -> L68
        goto L64
    L42:
        this.mStateSet = new StateSet(r100, r101);     // Catch: IOException -> L66 XmlPullParserException -> L68
        goto L64
    L43:
        r103.addOnClick(r100, r101);     // Catch: IOException -> L66 XmlPullParserException -> L68
        goto L64
    L44:
        if (r103 != null) goto L46;
        r100.getResources().getResourceEntryName(r110);     // Catch: IOException -> L66 XmlPullParserException -> L68
        r101.getLineNumber();     // Catch: IOException -> L66 XmlPullParserException -> L68
    L46:
        Transition.access$202(r103, new TouchResponse(r100, this.mMotionLayout, r101));     // Catch: IOException -> L66 XmlPullParserException -> L68
        goto L64
    L47:
        ArrayList<Transition> r106 = this.mTransitionList;     // Catch: IOException -> L66 XmlPullParserException -> L68
        r103 = new Transition(this, r100, r101);     // Catch: IOException -> L66 XmlPullParserException -> L68
        r106.add(r103);     // Catch: IOException -> L66 XmlPullParserException -> L68
        if (this.mCurrentTransition != null) goto L55;
        if (Transition.access$1200(r103) == true) goto L55;
        this.mCurrentTransition = r103;     // Catch: IOException -> L66 XmlPullParserException -> L68
        if (Transition.access$200(r103) == null) goto L55;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);     // Catch: IOException -> L66 XmlPullParserException -> L68
    L55:
        if (Transition.access$1200(r103) == false) goto L64;
        if (Transition.access$000(r103) != (-1)) goto L59;
        this.mDefaultTransition = r103;     // Catch: IOException -> L66 XmlPullParserException -> L68
    L60:
        this.mTransitionList.remove(r103);     // Catch: IOException -> L66 XmlPullParserException -> L68
        goto L64
    L59:
        this.mAbstractTransitionList.add(r103);     // Catch: IOException -> L66 XmlPullParserException -> L68
        goto L60
    L61:
        parseMotionSceneTags(r100, r101);     // Catch: IOException -> L66 XmlPullParserException -> L68
        goto L64
    L17:
        if (r105.equals("StateSet") == false) goto L37;
        r104 = 4;
        goto L38
    L20:
        if (r105.equals(TAG) == false) goto L37;
        r104 = 0;
        goto L38
    L23:
        if (r105.equals("OnSwipe") == false) goto L37;
        r104 = 2;
        goto L38
    L26:
        if (r105.equals("OnClick") == false) goto L37;
        r104 = 3;
        goto L38
    L29:
        if (r105.equals("Transition") == false) goto L37;
    L32:
        if (r105.equals("KeyFrameSet") == false) goto L37;
        r104 = 6;
        goto L38
    L35:
        if (r105.equals("ConstraintSet") == false) goto L37;
        r104 = 5;
        goto L38
    L87:
        return;
    L66:
        e = move-exception;
        e.printStackTrace();
        return;
    L68:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseConstraintSet(Context r110, XmlPullParser r111) {
        ConstraintSet r100 = new ConstraintSet();
        int r101 = 0;
        r100.setForceId(false);
        int r102 = r111.getAttributeCount();
        int r103 = -1;
        int r104 = -1;
    L3:
        if (r101 >= r102) goto L15;
        String r105 = r111.getAttributeName(r101);
        String r106 = r111.getAttributeValue(r101);
        if (this.DEBUG_DESKTOP == false) goto L7;
        System.out.println("id string = " + r106);
    L7:
        r105.getClass();
        if (r105.equals("deriveConstraintsFrom") == false) goto L10;
        r104 = getId(r110, r106);
    L14:
        r101 = r101 + 1;
        goto L3
    L10:
        if (r105.equals("id") == false) goto L14;
        r103 = getId(r110, r106);
        this.mConstraintSetIdMap.put(stripID(r106), Integer.valueOf(r103));
        goto L14
    L15:
        if (r103 != (-1)) goto L17;
        return;
    L17:
        if (this.mMotionLayout.mDebugPath == 0) goto L19;
        r100.setValidateOnParse(true);
    L19:
        r100.load(r110, r111);
        if (r104 == (-1)) goto L22;
        this.mDeriveMap.put(r103, r104);
    L22:
        this.mConstraintSetMap.put(r103, r100);
    }

    private void parseMotionSceneTags(Context r100, XmlPullParser r101) {
        TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{R.attr.defaultDuration, R.attr.layoutDuringTransition});
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        int r105 = r102.getIndex(r104);
        if (r105 != 0) goto L8;
        this.mDefaultDuration = r102.getInt(r105, this.mDefaultDuration);
    L10:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r105 != 1) goto L10;
        this.mLayoutDuringTransition = r102.getInteger(r105, 0);
        goto L10
    L11:
        r102.recycle();
    }

    public void addOnClickListeners(MotionLayout r100, int r101) {
        Iterator<Transition> r102 = this.mTransitionList.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Transition r103 = r102.next();
        if (Transition.access$400(r103).size() <= 0) goto L4;
        Iterator r104 = Transition.access$400(r103).iterator();
    L9:
        if (r104.hasNext() == false) goto L4;
        ((Transition.TransitionOnClick) r104.next()).removeOnClickListeners(r100);
        goto L9
    L11:
        Iterator<Transition> r105 = this.mAbstractTransitionList.iterator();
    L13:
        if (r105.hasNext() == false) goto L20;
        Transition r106 = r105.next();
        if (Transition.access$400(r106).size() <= 0) goto L13;
        Iterator r107 = Transition.access$400(r106).iterator();
    L18:
        if (r107.hasNext() == false) goto L13;
        ((Transition.TransitionOnClick) r107.next()).removeOnClickListeners(r100);
        goto L18
    L20:
        Iterator<Transition> r108 = this.mTransitionList.iterator();
    L22:
        if (r108.hasNext() == false) goto L29;
        Transition r109 = r108.next();
        if (Transition.access$400(r109).size() <= 0) goto L22;
        Iterator r110 = Transition.access$400(r109).iterator();
    L27:
        if (r110.hasNext() == false) goto L22;
        ((Transition.TransitionOnClick) r110.next()).addOnClickListeners(r100, r101, r109);
        goto L27
    L29:
        Iterator<Transition> r111 = this.mAbstractTransitionList.iterator();
    L31:
        if (r111.hasNext() == false) goto L38;
        Transition r112 = r111.next();
        if (Transition.access$400(r112).size() <= 0) goto L31;
        Iterator r113 = Transition.access$400(r112).iterator();
    L36:
        if (r113.hasNext() == false) goto L31;
        ((Transition.TransitionOnClick) r113.next()).addOnClickListeners(r100, r101, r112);
        goto L36
    }

    public boolean autoTransition(MotionLayout r100, int r101) {
        if (isProcessingTouch() == false) goto L6;
        return false;
    L6:
        if (this.mDisableAutoTransition == false) goto L8;
        return false;
    L8:
        Iterator<Transition> r102 = this.mTransitionList.iterator();
    L10:
        if (r102.hasNext() == false) goto L39;
        Transition r103 = r102.next();
        if (Transition.access$600(r103) == 0) goto L10;
        if (this.mCurrentTransition == r103) goto L10;
        if (r101 != Transition.access$100(r103)) goto L29;
        if (Transition.access$600(r103) == 4) goto L23;
        if (Transition.access$600(r103) != 2) goto L29;
    L23:
        MotionLayout.TransitionState r104 = MotionLayout.TransitionState.FINISHED;
        r100.setState(r104);
        r100.setTransition(r103);
        if (Transition.access$600(r103) != 4) goto L26;
        r100.transitionToEnd();
        r100.setState(MotionLayout.TransitionState.SETUP);
        r100.setState(MotionLayout.TransitionState.MOVING);
    L27:
        return true;
    L26:
        r100.setProgress(1.0f);
        r100.evaluate(true);
        r100.setState(MotionLayout.TransitionState.SETUP);
        r100.setState(MotionLayout.TransitionState.MOVING);
        r100.setState(r104);
        r100.onNewStateAttachHandlers();
    L29:
        if (r101 != Transition.access$000(r103)) goto L10;
        if (Transition.access$600(r103) == 3) goto L34;
        if (Transition.access$600(r103) != 1) goto L10;
    L34:
        MotionLayout.TransitionState r105 = MotionLayout.TransitionState.FINISHED;
        r100.setState(r105);
        r100.setTransition(r103);
        if (Transition.access$600(r103) != 3) goto L37;
        r100.transitionToStart();
        r100.setState(MotionLayout.TransitionState.SETUP);
        r100.setState(MotionLayout.TransitionState.MOVING);
    L38:
        return true;
    L37:
        r100.setProgress(0.0f);
        r100.evaluate(true);
        r100.setState(MotionLayout.TransitionState.SETUP);
        r100.setState(MotionLayout.TransitionState.MOVING);
        r100.setState(r105);
        r100.onNewStateAttachHandlers();
        goto L38
    L39:
        return false;
    }

    public ConstraintSet getConstraintSet(Context r100, String r101) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        System.out.println("id " + r101);
        System.out.println("size " + this.mConstraintSetMap.size());
    L5:
        int r102 = 0;
    L7:
        if (r102 >= this.mConstraintSetMap.size()) goto L16;
        int r103 = this.mConstraintSetMap.keyAt(r102);
        String r104 = r100.getResources().getResourceName(r103);
        if (this.DEBUG_DESKTOP == false) goto L12;
        System.out.println("Id for <" + r102 + "> is <" + r104 + "> looking for <" + r101 + ">");
    L12:
        if (r101.equals(r104) == true) goto L14;
        r102 = r102 + 1;
        goto L7
    L14:
        return this.mConstraintSetMap.get(r103);
    L16:
        return null;
    }

    public float getProgressDirection(float r100, float r101) {
        Transition r102 = this.mCurrentTransition;
        if (r102 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r102) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getProgressDirection(r100, r101);
    }

    public boolean hasKeyFramePosition(View r100, int r101) {
        Transition r102 = this.mCurrentTransition;
        if (r102 != null) goto L5;
        return false;
    L5:
        Iterator r103 = Transition.access$1300(r102).iterator();
    L7:
        if (r103.hasNext() == false) goto L15;
        Iterator<Key> r104 = ((KeyFrames) r103.next()).getKeyFramesForView(r100.getId()).iterator();
    L10:
        if (r104.hasNext() == false) goto L7;
        if (r104.next().mFramePosition != r101) goto L10;
        return true;
    L15:
        return false;
    }

    public void processScrollMove(float r100, float r101) {
        Transition r102 = this.mCurrentTransition;
        if (r102 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r102) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollMove(r100, r101);
        return;
    }

    public void processScrollUp(float r100, float r101) {
        Transition r102 = this.mCurrentTransition;
        if (r102 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r102) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollUp(r100, r101);
        return;
    }

    public void setConstraintSet(int r100, ConstraintSet r101) {
        this.mConstraintSetMap.put(r100, r101);
    }

    public void setTransition(int r100, int r101) {
        StateSet r102 = this.mStateSet;
        if (r102 == null) goto L11;
        int r103 = r102.stateGetConstraintID(r100, -1, -1);
        if (r103 != (-1)) goto L8;
        r103 = r100;
    L8:
        int r104 = this.mStateSet.stateGetConstraintID(r101, -1, -1);
        if (r104 != (-1)) goto L13;
    L12:
        r104 = r101;
    L13:
        Iterator<Transition> r105 = this.mTransitionList.iterator();
    L15:
        if (r105.hasNext() == false) goto L30;
        Transition r106 = r105.next();
        if (Transition.access$000(r106) != r104) goto L21;
        if (Transition.access$100(r106) != r103) goto L21;
    L24:
        this.mCurrentTransition = r106;
        if (r106 != null) goto L27;
        return;
    L27:
        if (Transition.access$200(r106) == null) goto L54;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    L54:
        return;
    L21:
        if (Transition.access$000(r106) != r101) goto L15;
        if (Transition.access$100(r106) != r100) goto L15;
    L30:
        Transition r107 = this.mDefaultTransition;
        Iterator<Transition> r108 = this.mAbstractTransitionList.iterator();
    L32:
        if (r108.hasNext() == false) goto L36;
        Transition r109 = r108.next();
        if (Transition.access$000(r109) != r101) goto L32;
        r107 = r109;
        goto L32
    L36:
        Transition r110 = new Transition(this, r107);
        Transition.access$102(r110, r103);
        Transition.access$002(r110, r104);
        if (r103 == (-1)) goto L39;
        this.mTransitionList.add(r110);
    L39:
        this.mCurrentTransition = r110;
        return;
    L11:
        r103 = r100;
        goto L12
    }

    public MotionScene(Context r100, MotionLayout r101, int r102) {
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = r101;
        load(r100, r102);
        this.mConstraintSetMap.put(R.id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    public ConstraintSet getConstraintSet(int r100, int r101, int r102) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        System.out.println("id " + r100);
        System.out.println("size " + this.mConstraintSetMap.size());
    L5:
        StateSet r103 = this.mStateSet;
        if (r103 == null) goto L11;
        int r104 = r103.stateGetConstraintID(r100, r101, r102);
        if (r104 == (-1)) goto L11;
        r100 = r104;
    L11:
        if (this.mConstraintSetMap.get(r100) != null) goto L15;
        Debug.getName(this.mMotionLayout.getContext(), r100);
        SparseArray<ConstraintSet> r105 = this.mConstraintSetMap;
        return r105.get(r105.keyAt(0));
    L15:
        return this.mConstraintSetMap.get(r100);
    }

    public void processTouchEvent(MotionEvent r110, int r111, MotionLayout r112) {
        RectF r100 = new RectF();
        if (this.mVelocityTracker != null) goto L5;
        this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
    L5:
        this.mVelocityTracker.addMovement(r110);
        if (r111 == (-1)) goto L47;
        int r101 = r110.getAction();
        boolean r102 = false;
        if (r101 != 0) goto L10;
        this.mLastTouchX = r110.getRawX();
        this.mLastTouchY = r110.getRawY();
        this.mLastTouchDown = r110;
        this.mIgnoreTouch = false;
        if (Transition.access$200(this.mCurrentTransition) == null) goto L65;
        RectF r113 = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, r100);
        if (r113 != null) goto L35;
    L38:
        RectF r114 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r100);
        if (r114 != null) goto L41;
    L43:
        this.mMotionOutsideRegion = false;
    L44:
        Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
        return;
    L41:
        if (r114.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L43;
        this.mMotionOutsideRegion = true;
        goto L44
    L35:
        if (r113.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L38;
        this.mLastTouchDown = null;
        this.mIgnoreTouch = true;
        return;
    L65:
        return;
    L10:
        if (r101 != 2) goto L47;
        if (this.mIgnoreTouch == true) goto L47;
        float r103 = r110.getRawY() - this.mLastTouchY;
        float r104 = r110.getRawX() - this.mLastTouchX;
        if (r104 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
    L19:
        MotionEvent r105 = this.mLastTouchDown;
        if (r105 == null) goto L64;
        Transition r106 = bestTransitionFor(r111, r104, r103, r105);
        if (r106 == null) goto L47;
        r112.setTransition(r106);
        RectF r107 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r100);
        if (r107 != null) goto L27;
    L29:
        this.mMotionOutsideRegion = r102;
        Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
        goto L47
    L27:
        if (r107.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L29;
        r102 = true;
        goto L29
    L64:
        return;
    L18:
        if (r103 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        return;
    L47:
        if (this.mIgnoreTouch == false) goto L49;
        return;
    L49:
        Transition r108 = this.mCurrentTransition;
        if (r108 != null) goto L52;
    L56:
        this.mLastTouchX = r110.getRawX();
        this.mLastTouchY = r110.getRawY();
        if (r110.getAction() != 1) goto L66;
        MotionLayout.MotionTracker r115 = this.mVelocityTracker;
        if (r115 == null) goto L67;
        r115.recycle();
        this.mVelocityTracker = null;
        int r116 = r112.mCurrentState;
        if (r116 == (-1)) goto L68;
        autoTransition(r112, r116);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L52:
        if (Transition.access$200(r108) == null) goto L56;
        if (this.mMotionOutsideRegion == true) goto L56;
        Transition.access$200(this.mCurrentTransition).processTouchEvent(r110, this.mVelocityTracker, r111, this);
        goto L56
    }

    public Transition bestTransitionFor(int r100, float r110, float r111, MotionEvent r112) {
        if (r100 == (-1)) goto L33;
        List<Transition> r101 = getTransitionsWithState(r100);
        RectF r102 = new RectF();
        Iterator<Transition> r103 = r101.iterator();
        float r104 = 0.0f;
        Transition r105 = null;
    L6:
        if (r103.hasNext() == false) goto L31;
        Transition r106 = r103.next();
        if (Transition.access$500(r106) == true) goto L6;
        if (Transition.access$200(r106) == null) goto L6;
        Transition.access$200(r106).setRTL(this.mRtl);
        RectF r107 = Transition.access$200(r106).getTouchRegion(this.mMotionLayout, r102);
        if (r107 == null) goto L18;
        if (r112 == null) goto L18;
        if (r107.contains(r112.getX(), r112.getY()) == false) goto L6;
    L18:
        RectF r108 = Transition.access$200(r106).getTouchRegion(this.mMotionLayout, r102);
        if (r108 == null) goto L24;
        if (r112 == null) goto L24;
        if (r108.contains(r112.getX(), r112.getY()) == false) goto L6;
    L24:
        float r109 = Transition.access$200(r106).dot(r110, r111);
        if (Transition.access$000(r106) != r100) goto L27;
        float r113 = -1.0f;
    L28:
        float r114 = r109 * r113;
        if (r114 <= r104) goto L6;
        r105 = r106;
        r104 = r114;
        goto L6
    L27:
        r113 = 1.1f;
        goto L28
    L31:
        return r105;
    L33:
        return this.mCurrentTransition;
    }

    public Key getKeyFrame(Context r100, int r101, int r102, int r110) {
        Transition r103 = this.mCurrentTransition;
        if (r103 != null) goto L5;
        return null;
    L5:
        Iterator r104 = Transition.access$1300(r103).iterator();
    L7:
        if (r104.hasNext() == false) goto L21;
        KeyFrames r105 = (KeyFrames) r104.next();
        Iterator<Integer> r106 = r105.getKeys().iterator();
    L10:
        if (r106.hasNext() == false) goto L7;
        Integer r107 = r106.next();
        if (r102 != r107.intValue()) goto L10;
        Iterator<Key> r108 = r105.getKeyFramesForView(r107.intValue()).iterator();
    L15:
        if (r108.hasNext() == false) goto L10;
        Key r109 = r108.next();
        if (r109.mFramePosition != r110) goto L15;
        if (r109.mType != r101) goto L15;
        return r109;
    L21:
        return null;
    }

    public void setKeyframe(View r100, int r101, String r102, Object r103) {
        Transition r104 = this.mCurrentTransition;
        if (r104 != null) goto L5;
        return;
    L5:
        Iterator r105 = Transition.access$1300(r104).iterator();
    L7:
        if (r105.hasNext() == false) goto L16;
        Iterator<Key> r106 = ((KeyFrames) r105.next()).getKeyFramesForView(r100.getId()).iterator();
    L10:
        if (r106.hasNext() == false) goto L7;
        if (r106.next().mFramePosition != r101) goto L10;
        if (r103 == null) goto L15;
        ((Float) r103).floatValue();
    L15:
        r102.equalsIgnoreCase("app:PerpendicularPath_percent");
        goto L10
    }
}

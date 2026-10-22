package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
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
import android.view.animation.OvershootInterpolator;
import com.GlobalProxyLancet;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.widget.ConstraintSet;
import com.obric.oui.constraintlayout.widget.R;
import com.obric.oui.constraintlayout.widget.StateSet;
import com.obric.oui.material.MaterialConfigBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DESKTOP = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
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
    final ViewTransitionController mViewTransitionController;

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTERCEPT_TOUCH = 4;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
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

            public TransitionOnClick(Context r3, Transition r4, XmlPullParser r5) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r4;
                TypedArray r6 = r3.obtainStyledAttributes(Xml.asAttributeSet(r5), R.styleable.OnClick);
                int r7 = r6.getIndexCount();
                int r8 = 0;
            L3:
                if (r8 >= r7) goto L11;
                int r0 = r6.getIndex(r8);
                if (r0 != R.styleable.OnClick_targetId) goto L8;
                this.mTargetId = r6.getResourceId(r0, this.mTargetId);
            L10:
                r8 = r8 + 1;
                goto L3
            L8:
                if (r0 != R.styleable.OnClick_clickAction) goto L10;
                this.mMode = r6.getInt(r0, this.mMode);
                goto L10
            L11:
                r6.recycle();
            }

            public TransitionOnClick(Transition r1, int r2, int r3) {
                this.mTransition = r1;
                this.mTargetId = r2;
                this.mMode = r3;
            }

            public void addOnClickListeners(MotionLayout r7, int r8, Transition r9) {
                int r0 = this.mTargetId;
                MotionLayout r10 = r7;
                if (r0 == (-1)) goto L6;
                r10 = r7.findViewById(r0);
            L6:
                if (r10 != null) goto L9;
                GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "OnClick could not find id " + this.mTargetId);
                return;
            L9:
                int r1 = Transition.access$100(r9);
                int r11 = Transition.access$000(r9);
                if (r1 != (-1)) goto L13;
                r10.setOnClickListener(this);
                return;
            L13:
                int r2 = this.mMode;
                boolean r3 = false;
                if ((r2 & 1) == 0) goto L17;
                if (r8 != r1) goto L17;
                boolean r4 = true;
            L19:
                if ((r2 & 256) == 0) goto L22;
                if (r8 != r1) goto L22;
                boolean r5 = true;
            L23:
                boolean r6 = r4 | r5;
                if ((r2 & 1) == 0) goto L27;
                if (r8 != r1) goto L27;
                boolean r12 = true;
            L28:
                boolean r13 = r12 | r6;
                if ((r2 & 16) == 0) goto L32;
                if (r8 != r11) goto L32;
                boolean r14 = true;
            L33:
                boolean r15 = r13 | r14;
                if ((r2 & 4096) == 0) goto L38;
                if (r8 != r11) goto L38;
                r3 = true;
            L38:
                if ((r15 | r3) == false) goto L41;
                r10.setOnClickListener(this);
                return;
            L41:
                return;
            L32:
                r14 = false;
            L27:
                r12 = false;
            L22:
                r5 = false;
            L17:
                r4 = false;
                goto L19
            }

            public void removeOnClickListeners(MotionLayout r3) {
                int r0 = this.mTargetId;
                if (r0 != (-1)) goto L5;
                return;
            L5:
                View r4 = r3.findViewById(r0);
                if (r4 != null) goto L9;
                GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", " (*)  could not find id " + this.mTargetId);
                return;
            L9:
                r4.setOnClickListener(null);
            }

            boolean isTransitionViable(Transition r4, MotionLayout r5) {
                Transition r0 = this.mTransition;
                if (r0 != r4) goto L5;
                return true;
            L5:
                int r6 = Transition.access$000(r0);
                int r3 = Transition.access$100(this.mTransition);
                if (r3 != (-1)) goto L13;
                if (r5.mCurrentState == r6) goto L11;
                return true;
            L11:
                return false;
            L13:
                if (r5.mCurrentState != r3) goto L15;
                return true;
            L15:
                if (r5.mCurrentState != r6) goto L18;
                return true;
            L18:
                return false;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r8) {
                MotionLayout r9 = MotionScene.access$700(Transition.access$800(this.mTransition));
                if (r9.isInteractionEnabled() == true) goto L6;
                return;
            L6:
                if (Transition.access$100(this.mTransition) != (-1)) goto L13;
                int r0 = r9.getCurrentState();
                if (r0 != (-1)) goto L11;
                r9.transitionToState(Transition.access$000(this.mTransition));
                return;
            L11:
                Transition r1 = new Transition(Transition.access$800(this.mTransition), this.mTransition);
                Transition.access$102(r1, r0);
                Transition.access$002(r1, Transition.access$000(this.mTransition));
                r9.setTransition(r1);
                r9.transitionToEnd();
                return;
            L13:
                Transition r2 = Transition.access$800(this.mTransition).mCurrentTransition;
                int r3 = this.mMode;
                boolean r4 = false;
                if ((r3 & 1) == 0) goto L16;
            L19:
                boolean r5 = true;
            L21:
                if ((r3 & 16) == 0) goto L23;
            L26:
                boolean r6 = true;
            L27:
                if (r5 == false) goto L30;
                if (r6 == false) goto L30;
                boolean r7 = true;
            L31:
                if (r7 == false) goto L41;
                Transition r10 = Transition.access$800(this.mTransition).mCurrentTransition;
                Transition r11 = this.mTransition;
                if (r10 == r11) goto L36;
                r9.setTransition(r11);
            L36:
                if (r9.getCurrentState() == r9.getEndState()) goto L43;
                if (r9.getProgress() > 0.5f) goto L43;
                r6 = false;
            L43:
                if (isTransitionViable(r2, r9) == false) goto L61;
                if (r4 == true) goto L46;
            L48:
                if (r6 == true) goto L50;
            L52:
                if (r4 == true) goto L54;
            L56:
                if (r6 == true) goto L58;
                return;
            L58:
                if ((this.mMode & 4096) == 0) goto L66;
                r9.setTransition(this.mTransition);
                r9.setProgress(0.0f);
                return;
            L66:
                return;
            L54:
                if ((this.mMode & 256) == 0) goto L56;
                r9.setTransition(this.mTransition);
                r9.setProgress(1.0f);
                return;
            L50:
                if ((this.mMode & 16) == 0) goto L52;
                r9.setTransition(this.mTransition);
                r9.transitionToStart();
                return;
            L46:
                if ((this.mMode & 1) == 0) goto L48;
                r9.setTransition(this.mTransition);
                r9.transitionToEnd();
                return;
            L61:
                return;
            L41:
                r4 = r5;
            L30:
                r7 = false;
                goto L31
            L23:
                if ((r3 & 4096) != 0) goto L26;
                r6 = false;
                goto L27
            L16:
                if ((r3 & 256) != 0) goto L19;
                r5 = false;
                goto L21
            }
        }

        static /* synthetic */ int access$000(Transition r0) {
            return r0.mConstraintSetEnd;
        }

        static /* synthetic */ int access$002(Transition r0, int r1) {
            r0.mConstraintSetEnd = r1;
            return r1;
        }

        static /* synthetic */ int access$100(Transition r0) {
            return r0.mConstraintSetStart;
        }

        static /* synthetic */ int access$102(Transition r0, int r1) {
            r0.mConstraintSetStart = r1;
            return r1;
        }

        static /* synthetic */ boolean access$1300(Transition r0) {
            return r0.mIsAbstract;
        }

        static /* synthetic */ ArrayList access$1400(Transition r0) {
            return r0.mKeyFramesList;
        }

        static /* synthetic */ int access$1500(Transition r0) {
            return r0.mDefaultInterpolator;
        }

        static /* synthetic */ String access$1600(Transition r0) {
            return r0.mDefaultInterpolatorString;
        }

        static /* synthetic */ int access$1700(Transition r0) {
            return r0.mDefaultInterpolatorID;
        }

        static /* synthetic */ int access$1800(Transition r0) {
            return r0.mDuration;
        }

        static /* synthetic */ int access$1900(Transition r0) {
            return r0.mPathMotionArc;
        }

        static /* synthetic */ TouchResponse access$200(Transition r0) {
            return r0.mTouchResponse;
        }

        static /* synthetic */ float access$2000(Transition r0) {
            return r0.mStagger;
        }

        static /* synthetic */ TouchResponse access$202(Transition r0, TouchResponse r1) {
            r0.mTouchResponse = r1;
            return r1;
        }

        static /* synthetic */ int access$300(Transition r0) {
            return r0.mId;
        }

        static /* synthetic */ ArrayList access$400(Transition r0) {
            return r0.mOnClicks;
        }

        static /* synthetic */ boolean access$500(Transition r0) {
            return r0.mDisable;
        }

        static /* synthetic */ int access$600(Transition r0) {
            return r0.mAutoTransition;
        }

        static /* synthetic */ MotionScene access$800(Transition r0) {
            return r0.mMotionScene;
        }

        public void setOnSwipe(OnSwipe r3) {
            if (r3 != null) goto L4;
            TouchResponse r4 = null;
        L5:
            this.mTouchResponse = r4;
            return;
        L4:
            r4 = new TouchResponse(MotionScene.access$700(this.mMotionScene), r3);
            goto L5
        }

        public void addOnClick(int r4, int r5) {
            Iterator<TransitionOnClick> r0 = this.mOnClicks.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            TransitionOnClick r1 = r0.next();
            if (r1.mTargetId != r4) goto L4;
            r1.mMode = r5;
            return;
        L9:
            TransitionOnClick r2 = new TransitionOnClick(this, r4, r5);
            this.mOnClicks.add(r2);
        }

        public void removeOnClick(int r4) {
            Iterator<TransitionOnClick> r0 = this.mOnClicks.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            TransitionOnClick r1 = r0.next();
            if (r1.mTargetId != r4) goto L4;
        L9:
            if (r1 == null) goto L15;
            this.mOnClicks.remove(r1);
            return;
        L15:
            return;
        L8:
            r1 = null;
            goto L9
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public void setLayoutDuringTransition(int r1) {
            this.mLayoutDuringTransition = r1;
        }

        public void addOnClick(Context r3, XmlPullParser r4) {
            this.mOnClicks.add(new TransitionOnClick(r3, this, r4));
        }

        public void setAutoTransition(int r1) {
            this.mAutoTransition = r1;
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getId() {
            return this.mId;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public void setDuration(int r2) {
            this.mDuration = Math.max(r2, 8);
        }

        public int getDuration() {
            return this.mDuration;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public void addKeyFrame(KeyFrames r1) {
            this.mKeyFramesList.add(r1);
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public void setStagger(float r1) {
            this.mStagger = r1;
        }

        public void setPathMotionArc(int r1) {
            this.mPathMotionArc = r1;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public void setEnabled(boolean r1) {
            this.mDisable = !r1;
        }

        public String debugString(Context r4) {
            if (this.mConstraintSetStart != (-1)) goto L5;
            String r0 = "null";
        L7:
            if (this.mConstraintSetEnd != (-1)) goto L10;
            return r0 + " -> null";
        L10:
            return r0 + " -> " + r4.getResources().getResourceEntryName(this.mConstraintSetEnd);
        L5:
            r0 = r4.getResources().getResourceEntryName(this.mConstraintSetStart);
            goto L7
        }

        public boolean isTransitionFlag(int r1) {
            if ((this.mTransitionFlags & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void setTransitionFlag(int r1) {
            this.mTransitionFlags = r1;
        }

        public void setOnTouchUp(int r1) {
            TouchResponse r0 = getTouchResponse();
            if (r0 == null) goto L6;
            r0.setTouchUpMode(r1);
            return;
        }

        Transition(MotionScene r5, Transition r6) {
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
            this.mMotionScene = r5;
            this.mDuration = MotionScene.access$900(r5);
            if (r6 == null) goto L6;
            this.mPathMotionArc = r6.mPathMotionArc;
            this.mDefaultInterpolator = r6.mDefaultInterpolator;
            this.mDefaultInterpolatorString = r6.mDefaultInterpolatorString;
            this.mDefaultInterpolatorID = r6.mDefaultInterpolatorID;
            this.mDuration = r6.mDuration;
            this.mKeyFramesList = r6.mKeyFramesList;
            this.mStagger = r6.mStagger;
            this.mLayoutDuringTransition = r6.mLayoutDuringTransition;
            return;
        }

        public Transition(int r5, MotionScene r6, int r7, int r8) {
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
            this.mId = r5;
            this.mMotionScene = r6;
            this.mConstraintSetStart = r7;
            this.mConstraintSetEnd = r8;
            this.mDuration = MotionScene.access$900(r6);
            this.mLayoutDuringTransition = MotionScene.access$1000(r6);
        }

        Transition(MotionScene r5, Context r6, XmlPullParser r7) {
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
            this.mDuration = MotionScene.access$900(r5);
            this.mLayoutDuringTransition = MotionScene.access$1000(r5);
            this.mMotionScene = r5;
            fillFromAttributeList(r5, r6, Xml.asAttributeSet(r7));
        }

        public void setInterpolatorInfo(int r1, String r2, int r3) {
            this.mDefaultInterpolator = r1;
            this.mDefaultInterpolatorString = r2;
            this.mDefaultInterpolatorID = r3;
        }

        private void fillFromAttributeList(MotionScene r2, Context r3, AttributeSet r4) {
            TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.Transition);
            fill(r2, r3, r5);
            r5.recycle();
        }

        private void fill(MotionScene r10, Context r11, TypedArray r12) {
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L65;
            int r5 = r12.getIndex(r2);
            if (r5 != R.styleable.Transition_constraintSetEnd) goto L14;
            this.mConstraintSetEnd = r12.getResourceId(r5, -1);
            String r3 = r11.getResources().getResourceTypeName(this.mConstraintSetEnd);
            if ("layout".equals(r3) == false) goto L11;
            ConstraintSet r4 = new ConstraintSet();
            r4.load(r11, this.mConstraintSetEnd);
            MotionScene.access$1100(r10).append(this.mConstraintSetEnd, r4);
        L63:
            r2 = r2 + 1;
            goto L4
        L11:
            if (MaterialConfigBuilder.SERIALIZATION_FORMAT_XML.equals(r3) == false) goto L63;
            this.mConstraintSetEnd = MotionScene.access$1200(r10, r11, this.mConstraintSetEnd);
            goto L63
        L14:
            if (r5 != R.styleable.Transition_constraintSetStart) goto L22;
            this.mConstraintSetStart = r12.getResourceId(r5, this.mConstraintSetStart);
            String r6 = r11.getResources().getResourceTypeName(this.mConstraintSetStart);
            if ("layout".equals(r6) == false) goto L19;
            ConstraintSet r7 = new ConstraintSet();
            r7.load(r11, this.mConstraintSetStart);
            MotionScene.access$1100(r10).append(this.mConstraintSetStart, r7);
            goto L63
        L19:
            if (MaterialConfigBuilder.SERIALIZATION_FORMAT_XML.equals(r6) == false) goto L63;
            this.mConstraintSetStart = MotionScene.access$1200(r10, r11, this.mConstraintSetStart);
            goto L63
        L22:
            if (r5 != R.styleable.Transition_motionInterpolator) goto L38;
            TypedValue r8 = r12.peekValue(r5);
            if (r8.type != 1) goto L29;
            int r9 = r12.getResourceId(r5, -1);
            this.mDefaultInterpolatorID = r9;
            if (r9 == (-1)) goto L63;
            this.mDefaultInterpolator = -2;
            goto L63
        L29:
            if (r8.type != 3) goto L36;
            String r13 = r12.getString(r5);
            this.mDefaultInterpolatorString = r13;
            if (r13 == null) goto L63;
            if (r13.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L35;
            this.mDefaultInterpolatorID = r12.getResourceId(r5, -1);
            this.mDefaultInterpolator = -2;
            goto L63
        L35:
            this.mDefaultInterpolator = -1;
            goto L63
        L36:
            this.mDefaultInterpolator = r12.getInteger(r5, this.mDefaultInterpolator);
            goto L63
        L38:
            if (r5 != R.styleable.Transition_duration) goto L43;
            int r14 = r12.getInt(r5, this.mDuration);
            this.mDuration = r14;
            if (r14 >= 8) goto L63;
            this.mDuration = 8;
            goto L63
        L43:
            if (r5 != R.styleable.Transition_staggered) goto L46;
            this.mStagger = r12.getFloat(r5, this.mStagger);
            goto L63
        L46:
            if (r5 != R.styleable.Transition_autoTransition) goto L49;
            this.mAutoTransition = r12.getInteger(r5, this.mAutoTransition);
            goto L63
        L49:
            if (r5 != R.styleable.Transition_android_id) goto L52;
            this.mId = r12.getResourceId(r5, this.mId);
            goto L63
        L52:
            if (r5 != R.styleable.Transition_transitionDisable) goto L55;
            this.mDisable = r12.getBoolean(r5, this.mDisable);
            goto L63
        L55:
            if (r5 != R.styleable.Transition_pathMotionArc) goto L58;
            this.mPathMotionArc = r12.getInteger(r5, -1);
            goto L63
        L58:
            if (r5 != R.styleable.Transition_layoutDuringTransition) goto L61;
            this.mLayoutDuringTransition = r12.getInteger(r5, 0);
            goto L63
        L61:
            if (r5 != R.styleable.Transition_transitionFlags) goto L63;
            this.mTransitionFlags = r12.getInteger(r5, 0);
            goto L63
        L65:
            if (this.mConstraintSetStart != (-1)) goto L91;
            this.mIsAbstract = true;
            return;
        }
    }

    public float getPathPercent(View r1, int r2) {
        return 0.0f;
    }

    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    static /* synthetic */ int access$1000(MotionScene r0) {
        return r0.mLayoutDuringTransition;
    }

    static /* synthetic */ SparseArray access$1100(MotionScene r0) {
        return r0.mConstraintSetMap;
    }

    static /* synthetic */ int access$1200(MotionScene r0, Context r1, int r2) {
        return r0.parseInclude(r1, r2);
    }

    static /* synthetic */ MotionLayout access$700(MotionScene r0) {
        return r0.mMotionLayout;
    }

    static /* synthetic */ int access$900(MotionScene r0) {
        return r0.mDefaultDuration;
    }

    void setTransition(int r7, int r8) {
        StateSet r0 = this.mStateSet;
        if (r0 == null) goto L11;
        int r1 = r0.stateGetConstraintID(r7, -1, -1);
        if (r1 != (-1)) goto L8;
        r1 = r7;
    L8:
        int r2 = this.mStateSet.stateGetConstraintID(r8, -1, -1);
        if (r2 != (-1)) goto L13;
    L12:
        r2 = r8;
    L13:
        Transition r3 = this.mCurrentTransition;
        if (r3 != null) goto L16;
    L20:
        Iterator<Transition> r4 = this.mTransitionList.iterator();
    L22:
        if (r4.hasNext() == false) goto L37;
        Transition r5 = r4.next();
        if (Transition.access$000(r5) != r2) goto L28;
        if (Transition.access$100(r5) != r1) goto L28;
    L31:
        this.mCurrentTransition = r5;
        if (r5 != null) goto L34;
        return;
    L34:
        if (Transition.access$200(r5) == null) goto L61;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    L61:
        return;
    L28:
        if (Transition.access$000(r5) != r8) goto L22;
        if (Transition.access$100(r5) != r7) goto L22;
    L37:
        Transition r9 = this.mDefaultTransition;
        Iterator<Transition> r6 = this.mAbstractTransitionList.iterator();
    L39:
        if (r6.hasNext() == false) goto L43;
        Transition r10 = r6.next();
        if (Transition.access$000(r10) != r8) goto L39;
        r9 = r10;
        goto L39
    L43:
        Transition r11 = new Transition(this, r9);
        Transition.access$102(r11, r1);
        Transition.access$002(r11, r2);
        if (r1 == (-1)) goto L46;
        this.mTransitionList.add(r11);
    L46:
        this.mCurrentTransition = r11;
        return;
    L16:
        if (Transition.access$000(r3) != r8) goto L20;
        if (Transition.access$100(this.mCurrentTransition) != r7) goto L20;
        return;
    L11:
        r1 = r7;
        goto L12
    }

    public void addTransition(Transition r3) {
        int r0 = getIndex(r3);
        if (r0 != (-1)) goto L5;
        this.mTransitionList.add(r3);
        return;
    L5:
        this.mTransitionList.set(r0, r3);
    }

    public void removeTransition(Transition r2) {
        int r3 = getIndex(r2);
        if (r3 == (-1)) goto L6;
        this.mTransitionList.remove(r3);
        return;
    }

    private int getIndex(Transition r4) {
        int r5 = Transition.access$300(r4);
        if (r5 == (-1)) goto L13;
        int r1 = 0;
    L6:
        if (r1 >= this.mTransitionList.size()) goto L11;
        if (Transition.access$300(this.mTransitionList.get(r1)) == r5) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return r1;
    L11:
        return -1;
    L13:
        throw new IllegalArgumentException("The transition must have an id");
    }

    public boolean validateLayout(MotionLayout r2) {
        if (r2 == this.mMotionLayout) goto L5;
    L7:
        return false;
    L5:
        if (r2.mScene != this) goto L7;
        return true;
    }

    public void setTransition(Transition r1) {
        this.mCurrentTransition = r1;
        if (r1 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r1) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    private int getRealID(int r2) {
        StateSet r1 = this.mStateSet;
        if (r1 == null) goto L7;
        int r3 = r1.stateGetConstraintID(r2, -1, -1);
        if (r3 == (-1)) goto L7;
        return r3;
    L7:
        return r2;
    }

    public List<Transition> getTransitionsWithState(int r4) {
        int r5 = getRealID(r4);
        ArrayList r0 = new ArrayList();
        Iterator<Transition> r3 = this.mTransitionList.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        Transition r1 = r3.next();
        if (Transition.access$100(r1) == r5) goto L9;
        if (Transition.access$000(r1) != r5) goto L4;
    L9:
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }

    public void addOnClickListeners(MotionLayout r5, int r6) {
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Transition r1 = r0.next();
        if (Transition.access$400(r1).size() <= 0) goto L4;
        Iterator r2 = Transition.access$400(r1).iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        ((Transition.TransitionOnClick) r2.next()).removeOnClickListeners(r5);
        goto L9
    L11:
        Iterator<Transition> r3 = this.mAbstractTransitionList.iterator();
    L13:
        if (r3.hasNext() == false) goto L20;
        Transition r4 = r3.next();
        if (Transition.access$400(r4).size() <= 0) goto L13;
        Iterator r7 = Transition.access$400(r4).iterator();
    L18:
        if (r7.hasNext() == false) goto L13;
        ((Transition.TransitionOnClick) r7.next()).removeOnClickListeners(r5);
        goto L18
    L20:
        Iterator<Transition> r8 = this.mTransitionList.iterator();
    L22:
        if (r8.hasNext() == false) goto L29;
        Transition r9 = r8.next();
        if (Transition.access$400(r9).size() <= 0) goto L22;
        Iterator r10 = Transition.access$400(r9).iterator();
    L27:
        if (r10.hasNext() == false) goto L22;
        ((Transition.TransitionOnClick) r10.next()).addOnClickListeners(r5, r6, r9);
        goto L27
    L29:
        Iterator<Transition> r11 = this.mAbstractTransitionList.iterator();
    L31:
        if (r11.hasNext() == false) goto L38;
        Transition r12 = r11.next();
        if (Transition.access$400(r12).size() <= 0) goto L31;
        Iterator r13 = Transition.access$400(r12).iterator();
    L36:
        if (r13.hasNext() == false) goto L31;
        ((Transition.TransitionOnClick) r13.next()).addOnClickListeners(r5, r6, r12);
        goto L36
    }

    public Transition bestTransitionFor(int r17, float r18, float r19, MotionEvent r20) {
        if (r17 == (-1)) goto L37;
        List<Transition> r4 = getTransitionsWithState(r17);
        RectF r5 = new RectF();
        Iterator<Transition> r6 = r4.iterator();
        float r7 = 0.0f;
        Transition r8 = null;
    L6:
        if (r6.hasNext() == false) goto L35;
        Transition r9 = r6.next();
        if (Transition.access$500(r9) == true) goto L6;
        if (Transition.access$200(r9) == null) goto L6;
        Transition.access$200(r9).setRTL(this.mRtl);
        RectF r10 = Transition.access$200(r9).getTouchRegion(this.mMotionLayout, r5);
        if (r10 == null) goto L18;
        if (r20 == null) goto L18;
        if (r10.contains(r20.getX(), r20.getY()) == false) goto L6;
    L18:
        RectF r11 = Transition.access$200(r9).getLimitBoundsTo(this.mMotionLayout, r5);
        if (r11 == null) goto L24;
        if (r20 == null) goto L24;
        if (r11.contains(r20.getX(), r20.getY()) == false) goto L6;
    L24:
        float r12 = Transition.access$200(r9).dot(r18, r19);
        if (Transition.access$200(r9).mIsRotateMode == false) goto L29;
        if (r20 == null) goto L29;
        float r13 = r20.getX() - Transition.access$200(r9).mRotateCenterX;
        float r14 = r20.getY() - Transition.access$200(r9).mRotateCenterY;
        r12 = ((float) (Math.atan2(r19 + r14, r18 + r13) - Math.atan2(r13, r14))) * 10.0f;
    L29:
        if (Transition.access$000(r9) != r17) goto L31;
        float r15 = -1.0f;
    L32:
        float r16 = r12 * r15;
        if (r16 <= r7) goto L6;
        r8 = r9;
        r7 = r16;
        goto L6
    L31:
        r15 = 1.1f;
        goto L32
    L35:
        return r8;
    L37:
        return this.mCurrentTransition;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public Transition getTransitionById(int r3) {
        Iterator<Transition> r2 = this.mTransitionList.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Transition r0 = r2.next();
        if (Transition.access$300(r0) != r3) goto L4;
        return r0;
    L8:
        return null;
    }

    public int[] getConstraintSetIds() {
        int r0 = this.mConstraintSetMap.size();
        int[] r1 = new int[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.mConstraintSetMap.keyAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public int[] getMatchingStateLabels(String... r8) {
        int r0 = this.mConstraintSetMap.size();
        int[] r1 = new int[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L9;
        ConstraintSet r4 = this.mConstraintSetMap.valueAt(r2);
        int r5 = this.mConstraintSetMap.keyAt(r2);
        if (r4.matchesLabels(r8) == false) goto L7;
        r4.getStateLabels();
        r1[r3] = r5;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return Arrays.copyOf(r1, r3);
    }

    boolean autoTransition(MotionLayout r8, int r9) {
        if (isProcessingTouch() == false) goto L6;
        return false;
    L6:
        if (this.mDisableAutoTransition == false) goto L8;
        return false;
    L8:
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L10:
        if (r0.hasNext() == false) goto L41;
        Transition r2 = r0.next();
        if (Transition.access$600(r2) == 0) goto L10;
        Transition r3 = this.mCurrentTransition;
        if (r3 != r2) goto L20;
        if (r3.isTransitionFlag(2) == true) goto L10;
    L20:
        if (r9 != Transition.access$100(r2)) goto L31;
        if (Transition.access$600(r2) == 4) goto L25;
        if (Transition.access$600(r2) != 2) goto L31;
    L25:
        r8.setState(MotionLayout.TransitionState.FINISHED);
        r8.setTransition(r2);
        if (Transition.access$600(r2) != 4) goto L28;
        r8.transitionToEnd();
        r8.setState(MotionLayout.TransitionState.SETUP);
        r8.setState(MotionLayout.TransitionState.MOVING);
    L29:
        return true;
    L28:
        r8.setProgress(1.0f);
        r8.evaluate(true);
        r8.setState(MotionLayout.TransitionState.SETUP);
        r8.setState(MotionLayout.TransitionState.MOVING);
        r8.setState(MotionLayout.TransitionState.FINISHED);
        r8.onNewStateAttachHandlers();
    L31:
        if (r9 != Transition.access$000(r2)) goto L10;
        if (Transition.access$600(r2) == 3) goto L36;
        if (Transition.access$600(r2) != 1) goto L10;
    L36:
        r8.setState(MotionLayout.TransitionState.FINISHED);
        r8.setTransition(r2);
        if (Transition.access$600(r2) != 3) goto L39;
        r8.transitionToStart();
        r8.setState(MotionLayout.TransitionState.SETUP);
        r8.setState(MotionLayout.TransitionState.MOVING);
    L40:
        return true;
    L39:
        r8.setProgress(0.0f);
        r8.evaluate(true);
        r8.setState(MotionLayout.TransitionState.SETUP);
        r8.setState(MotionLayout.TransitionState.MOVING);
        r8.setState(MotionLayout.TransitionState.FINISHED);
        r8.onNewStateAttachHandlers();
        goto L40
    L41:
        return false;
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setRtl(boolean r1) {
        this.mRtl = r1;
        Transition r2 = this.mCurrentTransition;
        if (r2 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r2) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    public void viewTransition(int r1, View... r2) {
        this.mViewTransitionController.viewTransition(r1, r2);
    }

    public void enableViewTransition(int r1, boolean r2) {
        this.mViewTransitionController.enableViewTransition(r1, r2);
    }

    public boolean isViewTransitionEnabled(int r1) {
        return this.mViewTransitionController.isViewTransitionEnabled(r1);
    }

    public boolean applyViewTransition(int r1, MotionController r2) {
        return this.mViewTransitionController.applyViewTransition(r1, r2);
    }

    public MotionScene(MotionLayout r4) {
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = r4;
        this.mViewTransitionController = new ViewTransitionController(r4);
    }

    MotionScene(Context r4, MotionLayout r5, int r6) {
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = r5;
        this.mViewTransitionController = new ViewTransitionController(r5);
        load(r4, r6);
        this.mConstraintSetMap.put(R.id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    private void load(Context r10, int r11) {
        XmlResourceParser r2 = r10.getResources().getXml(r11);
        int r3 = r2.getEventType();     // Catch: IOException -> L77 XmlPullParserException -> L79
        Transition r4 = null;
    L4:
        byte r5 = 1;
        if (r3 == 1) goto L103;
        if (r3 != 2) goto L75;
        String r6 = r2.getName();     // Catch: IOException -> L77 XmlPullParserException -> L79
        switch(r6.hashCode()) {
            case -1349929691: goto L40;
            case -1239391468: goto L37;
            case -687739768: goto L34;
            case 61998586: goto L31;
            case 269306229: goto L28;
            case 312750793: goto L25;
            case 327855227: goto L22;
            case 793277014: goto L19;
            case 1382829617: goto L16;
            case 1942574248: goto L13;
            default: goto L42;
        };     // Catch: IOException -> L77 XmlPullParserException -> L79
    L42:
        r5 = -1;
    L43:
        switch(r5) {
            case 0: goto L74;
            case 1: goto L60;
            case 2: goto L56;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L49;
            case 7: goto L49;
            case 8: goto L46;
            case 9: goto L45;
            default: goto L75;
        };     // Catch: IOException -> L77 XmlPullParserException -> L79
    L45:
        this.mViewTransitionController.add(new ViewTransition(r10, r2));     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L46:
        KeyFrames r7 = new KeyFrames(r10, r2);     // Catch: IOException -> L77 XmlPullParserException -> L79
        if (r4 == null) goto L75;
        Transition.access$1400(r4).add(r7);     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L49:
        parseInclude(r10, r2);     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L50:
        parseConstraintSet(r10, r2);     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L51:
        this.mStateSet = new StateSet(r10, r2);     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L52:
        if (r4 == null) goto L75;
        if (this.mMotionLayout.isInEditMode() == true) goto L75;
        r4.addOnClick(r10, r2);     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L56:
        if (r4 != null) goto L58;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("MotionScene", " OnSwipe (" + r10.getResources().getResourceEntryName(r11) + ".xml:" + r2.getLineNumber() + ")");     // Catch: IOException -> L77 XmlPullParserException -> L79
    L58:
        if (r4 == null) goto L75;
        Transition.access$202(r4, new TouchResponse(r10, this.mMotionLayout, r2));     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L60:
        ArrayList<Transition> r8 = this.mTransitionList;     // Catch: IOException -> L77 XmlPullParserException -> L79
        r4 = new Transition(this, r10, r2);     // Catch: IOException -> L77 XmlPullParserException -> L79
        r8.add(r4);     // Catch: IOException -> L77 XmlPullParserException -> L79
        if (this.mCurrentTransition != null) goto L68;
        if (Transition.access$1300(r4) == true) goto L68;
        this.mCurrentTransition = r4;     // Catch: IOException -> L77 XmlPullParserException -> L79
        if (Transition.access$200(r4) == null) goto L68;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);     // Catch: IOException -> L77 XmlPullParserException -> L79
    L68:
        if (Transition.access$1300(r4) == false) goto L75;
        if (Transition.access$000(r4) != (-1)) goto L72;
        this.mDefaultTransition = r4;     // Catch: IOException -> L77 XmlPullParserException -> L79
    L73:
        this.mTransitionList.remove(r4);     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L72:
        this.mAbstractTransitionList.add(r4);     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L73
    L74:
        parseMotionSceneTags(r10, r2);     // Catch: IOException -> L77 XmlPullParserException -> L79
        goto L75
    L13:
        if (r6.equals(INCLUDE_TAG) == false) goto L42;
        r5 = 6;
        goto L43
    L16:
        if (r6.equals(STATESET_TAG) == false) goto L42;
        r5 = 4;
        goto L43
    L19:
        if (r6.equals("MotionScene") == false) goto L42;
        r5 = 0;
        goto L43
    L22:
        if (r6.equals(ONSWIPE_TAG) == false) goto L42;
        r5 = 2;
        goto L43
    L25:
        if (r6.equals(ONCLICK_TAG) == false) goto L42;
        r5 = 3;
        goto L43
    L28:
        if (r6.equals(TRANSITION_TAG) == false) goto L42;
    L31:
        if (r6.equals("ViewTransition") == false) goto L42;
        r5 = 9;
        goto L43
    L34:
        if (r6.equals(INCLUDE_TAG_UC) == false) goto L42;
        r5 = 7;
        goto L43
    L37:
        if (r6.equals("KeyFrameSet") == false) goto L42;
        r5 = 8;
        goto L43
    L40:
        if (r6.equals(CONSTRAINTSET_TAG) == false) goto L42;
        r5 = 5;
    L75:
        r3 = r2.next();     // Catch: IOException -> L77 XmlPullParserException -> L79
    L103:
        return;
    L77:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "Error parsing resource: " + r11, e);
        return;
    L79:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "Error parsing resource: " + r11, e);
    }

    private void parseMotionSceneTags(Context r5, XmlPullParser r6) {
        TypedArray r7 = r5.obtainStyledAttributes(Xml.asAttributeSet(r6), R.styleable.MotionScene);
        int r8 = r7.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L13;
        int r2 = r7.getIndex(r1);
        if (r2 != R.styleable.MotionScene_defaultDuration) goto L10;
        int r3 = r7.getInt(r2, this.mDefaultDuration);
        this.mDefaultDuration = r3;
        if (r3 >= 8) goto L12;
        this.mDefaultDuration = 8;
    L12:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r2 != R.styleable.MotionScene_layoutDuringTransition) goto L12;
        this.mLayoutDuringTransition = r7.getInteger(r2, 0);
        goto L12
    L13:
        r7.recycle();
    }

    private int getId(Context r5, String r6) {
        if (r6.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L5;
        int r4 = r5.getResources().getIdentifier(r6.substring(r6.indexOf(47) + 1), "id", r5.getPackageName());
    L6:
        if (r4 != (-1)) goto L13;
        if (r6 != null) goto L9;
    L11:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "error in parsing id");
        return r4;
    L9:
        if (r6.length() <= 1) goto L11;
        return Integer.parseInt(r6.substring(1));
    L13:
        return r4;
    L5:
        r4 = -1;
        goto L6
    }

    private void parseInclude(Context r5, XmlPullParser r6) {
        TypedArray r7 = r5.obtainStyledAttributes(Xml.asAttributeSet(r6), R.styleable.include);
        int r0 = r7.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r7.getIndex(r1);
        if (r2 != R.styleable.include_constraintSet) goto L7;
        parseInclude(r5, r7.getResourceId(r2, -1));
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        r7.recycle();
    }

    private int parseInclude(Context r7, int r8) {
        XmlResourceParser r2 = r7.getResources().getXml(r8);
        int r3 = r2.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L5:
        if (r3 == 1) goto L27;
        String r4 = r2.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (2 != r3) goto L12;
        if (CONSTRAINTSET_TAG.equals(r4) == false) goto L12;
        return parseConstraintSet(r7, r2);
    L12:
        r3 = r2.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L5
    L27:
        return -1;
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "Error parsing resource: " + r8, e);
        return -1;
    L16:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "Error parsing resource: " + r8, e);
        return -1;
    }

    private int parseConstraintSet(Context r14, XmlPullParser r15) {
        ConstraintSet r0 = new ConstraintSet();
        r0.setForceId(false);
        int r2 = r15.getAttributeCount();
        int r4 = 0;
        int r5 = -1;
        int r6 = -1;
    L4:
        if (r4 >= r2) goto L62;
        String r8 = r15.getAttributeName(r4);
        String r9 = r15.getAttributeValue(r4);
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1496482599: goto L21;
            case -1153153640: goto L17;
            case 3355: goto L13;
            case 973381616: goto L9;
            default: goto L7;
        };
    L7:
        byte r10 = -1;
    L24:
        switch(r10) {
            case 0: goto L60;
            case 1: goto L71;
            case 2: goto L27;
            case 3: goto L26;
            default: goto L61;
        };
    L26:
        r0.setStateLabels(r9);
        goto L61
    L27:
        r5 = getId(r14, r9);
        this.mConstraintSetIdMap.put(stripID(r9), Integer.valueOf(r5));
        r0.mIdString = Debug.getName(r14, r5);
        goto L61
    L60:
        r6 = getId(r14, r9);
        goto L61
    L71:
        r0.mRotate = Integer.parseInt(r9);     // Catch: NumberFormatException -> L30
    L30:
        r9.hashCode();
        switch(r9.hashCode()) {
            case -768416914: goto L50;
            case 3317767: goto L46;
            case 3387192: goto L42;
            case 108511772: goto L38;
            case 1954540437: goto L34;
            default: goto L32;
        };
    L32:
        byte r11 = -1;
    L53:
        switch(r11) {
            case 0: goto L59;
            case 1: goto L58;
            case 2: goto L57;
            case 3: goto L56;
            case 4: goto L55;
            default: goto L61;
        };
    L55:
        r0.mRotate = 3;
        goto L61
    L56:
        r0.mRotate = 1;
        goto L61
    L57:
        r0.mRotate = 0;
        goto L61
    L58:
        r0.mRotate = 2;
        goto L61
    L59:
        r0.mRotate = 4;
        goto L61
    L34:
        if (r9.equals("x_right") == false) goto L89;
        r11 = 4;
        goto L53
    L89:
        r11 = -1;
        goto L53
    L38:
        if (r9.equals("right") == false) goto L90;
        r11 = 3;
        goto L53
    L90:
        r11 = -1;
        goto L53
    L42:
        if (r9.equals("none") == false) goto L91;
        r11 = 2;
        goto L53
    L91:
        r11 = -1;
        goto L53
    L46:
        if (r9.equals("left") == false) goto L92;
        r11 = 1;
        goto L53
    L92:
        r11 = -1;
        goto L53
    L50:
        if (r9.equals("x_left") == false) goto L93;
        r11 = 0;
        goto L53
    L93:
        r11 = -1;
    L61:
        r4 = r4 + 1;
        goto L4
    L9:
        if (r8.equals("stateLabels") == false) goto L85;
        r10 = 3;
        goto L24
    L85:
        r10 = -1;
        goto L24
    L13:
        if (r8.equals("id") == false) goto L86;
        r10 = 2;
        goto L24
    L86:
        r10 = -1;
        goto L24
    L17:
        if (r8.equals("constraintRotate") == false) goto L87;
        r10 = 1;
        goto L24
    L87:
        r10 = -1;
        goto L24
    L21:
        if (r8.equals("deriveConstraintsFrom") == false) goto L88;
        r10 = 0;
        goto L24
    L88:
        r10 = -1;
        goto L24
    L62:
        if (r5 != (-1)) goto L64;
    L70:
        return r5;
    L64:
        if (this.mMotionLayout.mDebugPath == 0) goto L66;
        r0.setValidateOnParse(true);
    L66:
        r0.load(r14, r15);
        if (r6 == (-1)) goto L69;
        this.mDeriveMap.put(r5, r6);
    L69:
        this.mConstraintSetMap.put(r5, r0);
        goto L70
    }

    public ConstraintSet getConstraintSet(Context r4, String r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mConstraintSetMap.size()) goto L10;
        int r1 = this.mConstraintSetMap.keyAt(r0);
        if (r5.equals(r4.getResources().getResourceName(r1)) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return this.mConstraintSetMap.get(r1);
    L10:
        return null;
    }

    ConstraintSet getConstraintSet(int r2) {
        return getConstraintSet(r2, -1, -1);
    }

    ConstraintSet getConstraintSet(int r2, int r3, int r4) {
        StateSet r0 = this.mStateSet;
        if (r0 == null) goto L8;
        int r5 = r0.stateGetConstraintID(r2, r3, r4);
        if (r5 == (-1)) goto L8;
        r2 = r5;
    L8:
        if (this.mConstraintSetMap.get(r2) != null) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), r2) + " In MotionScene");
        SparseArray<ConstraintSet> r1 = this.mConstraintSetMap;
        return r1.get(r1.keyAt(0));
    L12:
        return this.mConstraintSetMap.get(r2);
    }

    public void setConstraintSet(int r1, ConstraintSet r2) {
        this.mConstraintSetMap.put(r1, r2);
    }

    public void getKeyFrames(MotionController r2) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L11;
        Transition r1 = this.mDefaultTransition;
        if (r1 == null) goto L10;
        Iterator r3 = Transition.access$1400(r1).iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        ((KeyFrames) r3.next()).addFrames(r2);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r4 = Transition.access$1400(r0).iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        ((KeyFrames) r4.next()).addFrames(r2);
        goto L13
    }

    Key getKeyFrame(Context r6, int r7, int r8, int r9) {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator r10 = Transition.access$1400(r5).iterator();
    L7:
        if (r10.hasNext() == false) goto L21;
        KeyFrames r0 = (KeyFrames) r10.next();
        Iterator<Integer> r1 = r0.getKeys().iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        Integer r2 = r1.next();
        if (r8 != r2.intValue()) goto L10;
        Iterator<Key> r3 = r0.getKeyFramesForView(r2.intValue()).iterator();
    L15:
        if (r3.hasNext() == false) goto L10;
        Key r4 = r3.next();
        if (r4.mFramePosition != r9) goto L15;
        if (r4.mType != r7) goto L15;
        return r4;
    L21:
        return null;
    }

    int getTransitionDirection(int r2) {
        Iterator<Transition> r1 = this.mTransitionList.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (Transition.access$100(r1.next()) != r2) goto L4;
        return 0;
    L9:
        return 1;
    }

    boolean hasKeyFramePosition(View r4, int r5) {
        Transition r3 = this.mCurrentTransition;
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator r6 = Transition.access$1400(r3).iterator();
    L7:
        if (r6.hasNext() == false) goto L15;
        Iterator<Key> r1 = ((KeyFrames) r6.next()).getKeyFramesForView(r4.getId()).iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        if (r1.next().mFramePosition != r5) goto L10;
        return true;
    L15:
        return false;
    }

    public void setKeyframe(View r2, int r3, String r4, Object r5) {
        Transition r1 = this.mCurrentTransition;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator r6 = Transition.access$1400(r1).iterator();
    L7:
        if (r6.hasNext() == false) goto L15;
        Iterator<Key> r7 = ((KeyFrames) r6.next()).getKeyFramesForView(r2.getId()).iterator();
    L10:
        if (r7.hasNext() == false) goto L7;
        if (r7.next().mFramePosition != r3) goto L10;
        if (r5 == null) goto L10;
        ((Float) r5).floatValue();
        goto L10
    }

    boolean supportTouch() {
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Transition.access$200(r0.next()) == null) goto L4;
        return true;
    L8:
        Transition r3 = this.mCurrentTransition;
        if (r3 != null) goto L11;
    L13:
        return false;
    L11:
        if (Transition.access$200(r3) == null) goto L13;
        return true;
    }

    void processTouchEvent(MotionEvent r12, int r13, MotionLayout r14) {
        RectF r0 = new RectF();
        if (this.mVelocityTracker != null) goto L5;
        this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
    L5:
        this.mVelocityTracker.addMovement(r12);
        if (r13 == (-1)) goto L47;
        int r4 = r12.getAction();
        boolean r5 = false;
        if (r4 != 0) goto L10;
        this.mLastTouchX = r12.getRawX();
        this.mLastTouchY = r12.getRawY();
        this.mLastTouchDown = r12;
        this.mIgnoreTouch = false;
        if (Transition.access$200(this.mCurrentTransition) == null) goto L65;
        RectF r15 = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, r0);
        if (r15 != null) goto L35;
    L38:
        RectF r16 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r0);
        if (r16 != null) goto L41;
    L43:
        this.mMotionOutsideRegion = false;
    L44:
        Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
        return;
    L41:
        if (r16.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L43;
        this.mMotionOutsideRegion = true;
        goto L44
    L35:
        if (r15.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L38;
        this.mLastTouchDown = null;
        this.mIgnoreTouch = true;
        return;
    L65:
        return;
    L10:
        if (r4 != 2) goto L47;
        if (this.mIgnoreTouch == true) goto L47;
        float r6 = r12.getRawY() - this.mLastTouchY;
        float r7 = r12.getRawX() - this.mLastTouchX;
        if (r7 == 0.0d) goto L18;
    L19:
        MotionEvent r8 = this.mLastTouchDown;
        if (r8 == null) goto L64;
        Transition r9 = bestTransitionFor(r13, r7, r6, r8);
        if (r9 == null) goto L47;
        r14.setTransition(r9);
        RectF r1 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r0);
        if (r1 != null) goto L27;
    L29:
        this.mMotionOutsideRegion = r5;
        Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
        goto L47
    L27:
        if (r1.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L29;
        r5 = true;
        goto L29
    L64:
        return;
    L18:
        if (r6 != 0.0d) goto L19;
        return;
    L47:
        if (this.mIgnoreTouch == false) goto L49;
        return;
    L49:
        Transition r2 = this.mCurrentTransition;
        if (r2 != null) goto L52;
    L56:
        this.mLastTouchX = r12.getRawX();
        this.mLastTouchY = r12.getRawY();
        if (r12.getAction() != 1) goto L66;
        MotionLayout.MotionTracker r17 = this.mVelocityTracker;
        if (r17 == null) goto L67;
        r17.recycle();
        this.mVelocityTracker = null;
        if (r14.mCurrentState == (-1)) goto L68;
        autoTransition(r14, r14.mCurrentState);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L52:
        if (Transition.access$200(r2) == null) goto L56;
        if (this.mMotionOutsideRegion == true) goto L56;
        Transition.access$200(this.mCurrentTransition).processTouchEvent(r12, this.mVelocityTracker, r13, this);
        goto L56
    }

    void processScrollMove(float r2, float r3) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollMove(r2, r3);
        return;
    }

    void processScrollUp(float r2, float r3) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollUp(r2, r3);
        return;
    }

    float getProgressDirection(float r2, float r3) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getProgressDirection(r2, r3);
    }

    int getStartId() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$100(r0);
    }

    int getEndId() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$000(r0);
    }

    public Interpolator getInterpolator() {
        int r0 = Transition.access$1500(this.mCurrentTransition);
        if (r0 == (-2)) goto L34;
        if (r0 == (-1)) goto L31;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L28;
        if (r0 == 2) goto L26;
        if (r0 == 4) goto L24;
        if (r0 == 5) goto L22;
        if (r0 == 6) goto L20;
        return null;
    L20:
        return new AnticipateInterpolator();
    L22:
        return new OvershootInterpolator();
    L24:
        return new BounceInterpolator();
    L26:
        return new DecelerateInterpolator();
    L28:
        return new AccelerateInterpolator();
    L30:
        return new AccelerateDecelerateInterpolator();
    L31:
        final Easing r1 = Easing.getInterpolator(Transition.access$1600(this.mCurrentTransition));
        return new AnonymousClass1(this, r1);
    L34:
        return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), Transition.access$1700(this.mCurrentTransition));
    }

    public int getDuration() {
        Transition r0 = this.mCurrentTransition;
        if (r0 == null) goto L7;
        return Transition.access$1800(r0);
    L7:
        return this.mDefaultDuration;
    }

    public void setDuration(int r2) {
        Transition r0 = this.mCurrentTransition;
        if (r0 == null) goto L5;
        r0.setDuration(r2);
        return;
    L5:
        this.mDefaultDuration = r2;
    }

    public int gatPathMotionArc() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$1900(r0);
    }

    public float getStaggered() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        return Transition.access$2000(r0);
    }

    float getMaxAcceleration() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    float getMaxVelocity() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    float getSpringStiffiness() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringStiffness();
    }

    float getSpringMass() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringMass();
    }

    float getSpringDamping() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringDamping();
    }

    float getSpringStopThreshold() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringStopThreshold();
    }

    int getSpringBoundary() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringBoundary();
    }

    int getAutoCompleteMode() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.access$200(this.mCurrentTransition).getAutoCompleteMode();
    }

    void setupTouch() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setupTouch();
        return;
    }

    boolean getMoveWhenScrollAtTop() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return false;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    void readFallback(MotionLayout r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mConstraintSetMap.size()) goto L10;
        int r1 = this.mConstraintSetMap.keyAt(r0);
        if (hasCycleDependency(r1) == true) goto L7;
        readConstraintChain(r1, r4);
        r0 = r0 + 1;
        goto L4
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "Cannot be derived from yourself");
        return;
    }

    private boolean hasCycleDependency(int r5) {
        int r0 = this.mDeriveMap.get(r5);
        int r1 = this.mDeriveMap.size();
    L3:
        if (r0 <= 0) goto L11;
        if (r0 == r5) goto L6;
        int r3 = r1 - 1;
        if (r1 < 0) goto L9;
        r0 = this.mDeriveMap.get(r0);
        r1 = r3;
        goto L3
    L9:
        return true;
    L6:
        return true;
    L11:
        return false;
    }

    private void readConstraintChain(int r3, MotionLayout r4) {
        ConstraintSet r0 = this.mConstraintSetMap.get(r3);
        r0.derivedState = r0.mIdString;
        int r5 = this.mDeriveMap.get(r3);
        if (r5 <= 0) goto L9;
        readConstraintChain(r5, r4);
        ConstraintSet r6 = this.mConstraintSetMap.get(r5);
        if (r6 != null) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), r5));
        return;
    L8:
        r0.derivedState += LibrarianImpl.Constants.SEPARATOR + r6.derivedState;
        r0.readFallback(r6);
    L10:
        r0.applyDeltaFrom(r0);
        return;
    L9:
        r0.derivedState += "  layout";
        r0.readFallback(r4);
        goto L10
    }

    public static String stripID(String r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        int r0 = r1.indexOf(47);
        if (r0 >= 0) goto L9;
        return r1;
    L9:
        return r1.substring(r0 + 1);
    }

    public int lookUpConstraintId(String r1) {
        Integer r0 = this.mConstraintSetIdMap.get(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public String lookUpConstraintName(int r3) {
        Iterator<Map.Entry<String, Integer>> r2 = this.mConstraintSetIdMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<String, Integer> r0 = r2.next();
        Integer r1 = r0.getValue();
        if (r1 == null) goto L4;
        if (r1.intValue() != r3) goto L4;
        return r0.getKey();
    L12:
        return null;
    }

    public void disableAutoTransition(boolean r1) {
        this.mDisableAutoTransition = r1;
    }

    static String getLine(Context r2, int r3, XmlPullParser r4) {
        return ".(" + Debug.getName(r2, r3) + ".xml:" + r4.getLineNumber() + ") \"" + r4.getName() + "\"";
    }
}

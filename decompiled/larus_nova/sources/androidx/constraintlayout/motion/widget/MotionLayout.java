package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private DecelerateInterpolator mDecelerateLogic;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    private View mRegionView;
    MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private ArrayList<TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = null;

        static {
            int[] r100 = new int[TransitionState.values().length];
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = r100;
            r100[TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class DecelerateInterpolator extends MotionInterpolator {
        float currentP;
        float initalV;
        float maxA;
        final /* synthetic */ MotionLayout this$0;

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return this.this$0.mLastVelocity;
        }

        public DecelerateInterpolator(MotionLayout r100) {
            this.this$0 = r100;
            this.initalV = 0.0f;
            this.currentP = 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float r100) {
            float r101 = this.initalV;
            if (r101 <= 0.0f) goto L10;
            float r102 = this.maxA;
            if ((r101 / r102) >= r100) goto L7;
            r100 = r101 / r102;
        L7:
            float r103 = r101 - (r102 * r100);
            this.this$0.mLastVelocity = r103;
            float r104 = (r101 * r100) - (((r102 * r100) * r100) / 2.0f);
            float r105 = this.currentP;
        L9:
            return r104 + r105;
        L10:
            float r106 = this.maxA;
            if (((-r101) / r106) >= r100) goto L13;
            r100 = (-r101) / r106;
        L13:
            float r107 = (r106 * r100) + r101;
            this.this$0.mLastVelocity = r107;
            r104 = (r101 * r100) + (((r106 * r100) * r100) / 2.0f);
            r105 = this.currentP;
            goto L9
        }

        public void config(float r100, float r101, float r102) {
            this.initalV = r100;
            this.currentP = r101;
            this.maxA = r102;
        }
    }

    public class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        final int DIAMOND_SIZE;
        final int GRAPH_COLOR;
        final int KEYFRAME_COLOR;
        final int RED_COLOR;
        final int SHADOW_COLOR;
        Rect mBounds;
        DashPathEffect mDashPathEffect;
        Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        boolean mPresentationMode;
        private float[] mRectangle;
        int mShadowTranslate;
        Paint mTextPaint;
        final /* synthetic */ MotionLayout this$0;

        public DevModeDraw(MotionLayout r100) {
            this.this$0 = r100;
            this.RED_COLOR = -21965;
            this.KEYFRAME_COLOR = -2067046;
            this.GRAPH_COLOR = -13391360;
            this.SHADOW_COLOR = 1996488704;
            this.DIAMOND_SIZE = 10;
            this.mBounds = new Rect();
            this.mPresentationMode = false;
            this.mShadowTranslate = 1;
            Paint r101 = new Paint();
            this.mPaint = r101;
            r101.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(Paint.Style.STROKE);
            Paint r102 = new Paint();
            this.mPaintKeyframes = r102;
            r102.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
            Paint r103 = new Paint();
            this.mPaintGraph = r103;
            r103.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(Paint.Style.STROKE);
            Paint r104 = new Paint();
            this.mTextPaint = r104;
            r104.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(INVOKEVIRTUAL_androidx_constraintlayout_motion_widget_MotionLayout$DevModeDraw_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getContext().getResources()).density * 12.0f);
            this.mRectangle = new float[8];
            Paint r105 = new Paint();
            this.mFillPaint = r105;
            r105.setAntiAlias(true);
            DashPathEffect r106 = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = r106;
            this.mPaintGraph.setPathEffect(r106);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode == false) goto L6;
            this.mPaint.setStrokeWidth(8.0f);
            this.mFillPaint.setStrokeWidth(8.0f);
            this.mPaintKeyframes.setStrokeWidth(8.0f);
            this.mShadowTranslate = 4;
            return;
        }

        public static DisplayMetrics INVOKEVIRTUAL_androidx_constraintlayout_motion_widget_MotionLayout$DevModeDraw_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        private void drawBasicPath(Canvas r100) {
            r100.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas r100) {
            int r101 = 0;
            boolean r102 = false;
            boolean r103 = false;
        L4:
            if (r101 >= this.mKeyFrameCount) goto L12;
            int r104 = this.mPathMode[r101];
            if (r104 != 1) goto L9;
            r102 = true;
        L9:
            if (r104 != 2) goto L11;
            r103 = true;
        L11:
            r101 = r101 + 1;
            goto L4
        L12:
            if (r102 == false) goto L14;
            drawPathRelative(r100);
        L14:
            if (r103 == false) goto L20;
            drawPathCartesian(r100);
            return;
        }

        private void drawPathCartesian(Canvas r110) {
            float[] r100 = this.mPoints;
            float r101 = r100[0];
            float r102 = r100[1];
            float r103 = r100[r100.length - 2];
            float r104 = r100[r100.length - 1];
            r110.drawLine(Math.min(r101, r103), Math.max(r102, r104), Math.max(r101, r103), Math.max(r102, r104), this.mPaintGraph);
            r110.drawLine(Math.min(r101, r103), Math.min(r102, r104), Math.min(r101, r103), Math.max(r102, r104), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas r100) {
            float[] r101 = this.mPoints;
            r100.drawLine(r101[0], r101[1], r101[r101.length - 2], r101[r101.length - 1], this.mPaintGraph);
        }

        private void drawRectangle(Canvas r100, MotionController r101) {
            this.mPath.reset();
            int r102 = 0;
        L4:
            if (r102 > 50) goto L6;
            r101.buildRect(r102 / 50, this.mRectangle, 0);
            Path r103 = this.mPath;
            float[] r104 = this.mRectangle;
            r103.moveTo(r104[0], r104[1]);
            Path r105 = this.mPath;
            float[] r106 = this.mRectangle;
            r105.lineTo(r106[2], r106[3]);
            Path r107 = this.mPath;
            float[] r108 = this.mRectangle;
            r107.lineTo(r108[4], r108[5]);
            Path r109 = this.mPath;
            float[] r110 = this.mRectangle;
            r109.lineTo(r110[6], r110[7]);
            this.mPath.close();
            r102 = r102 + 1;
            goto L4
        L6:
            this.mPaint.setColor(1140850688);
            r100.translate(2.0f, 2.0f);
            r100.drawPath(this.mPath, this.mPaint);
            r100.translate(-2.0f, -2.0f);
            this.mPaint.setColor(-65536);
            r100.drawPath(this.mPath, this.mPaint);
        }

        public void getTextBounds(String r100, Paint r101) {
            r101.getTextBounds(r100, 0, r100.length(), this.mBounds);
        }

        private void drawPathCartesianTicks(Canvas r110, float r210, float r211) {
            float[] r100 = this.mPoints;
            float r101 = r100[0];
            float r102 = r100[1];
            float r103 = r100[r100.length - 2];
            float r104 = r100[r100.length - 1];
            float r105 = Math.min(r101, r103);
            float r111 = Math.max(r102, r104);
            float r106 = r210 - Math.min(r101, r103);
            float r112 = Math.max(r102, r104) - r211;
            String r107 = "" + (((int) (((double) ((r106 * 100.0f) / Math.abs(r103 - r101))) + 0.5d)) / 100.0f);
            getTextBounds(r107, this.mTextPaint);
            r110.drawText(r107, ((r106 / 2.0f) - (this.mBounds.width() / 2)) + r105, r211 - 20.0f, this.mTextPaint);
            r110.drawLine(r210, r211, Math.min(r101, r103), r211, this.mPaintGraph);
            String r108 = "" + (((int) (((double) ((r112 * 100.0f) / Math.abs(r104 - r102))) + 0.5d)) / 100.0f);
            getTextBounds(r108, this.mTextPaint);
            r110.drawText(r108, r210 + 5.0f, r111 - ((r112 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            r110.drawLine(r210, r211, r210, Math.max(r102, r104), this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas r110, float r111, float r112) {
            float[] r100 = this.mPoints;
            float r101 = r100[0];
            float r102 = r100[1];
            float r103 = r100[r100.length - 2];
            float r104 = r100[r100.length - 1];
            float r105 = (float) Math.hypot(r101 - r103, r102 - r104);
            float r106 = r103 - r101;
            float r107 = r104 - r102;
            float r108 = (((r111 - r101) * r106) + ((r112 - r102) * r107)) / (r105 * r105);
            float r109 = r101 + (r106 * r108);
            float r113 = r102 + (r108 * r107);
            Path r114 = new Path();
            r114.moveTo(r111, r112);
            r114.lineTo(r109, r113);
            float r115 = (float) Math.hypot(r109 - r111, r113 - r112);
            String r116 = "" + (((int) ((r115 * 100.0f) / r105)) / 100.0f);
            getTextBounds(r116, this.mTextPaint);
            r110.drawTextOnPath(r116, r114, (r115 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            r110.drawLine(r111, r112, r109, r113, this.mPaintGraph);
        }

        private void drawTicks(Canvas r210, int r211, int r212, MotionController r213) {
            View r100 = r213.mView;
            if (r100 == null) goto L5;
            int r110 = r100.getWidth();
            int r111 = r213.mView.getHeight();
        L6:
            int r112 = 1;
        L8:
            if (r112 >= (r212 - 1)) goto L35;
            if (r211 == 4) goto L12;
        L14:
            float[] r101 = this.mKeyFramePoints;
            int r102 = r112 * 2;
            float r103 = r101[r102];
            float r104 = r101[r102 + 1];
            this.mPath.reset();
            this.mPath.moveTo(r103, r104 + 10.0f);
            this.mPath.lineTo(r103 + 10.0f, r104);
            this.mPath.lineTo(r103, r104 - 10.0f);
            this.mPath.lineTo(r103 - 10.0f, r104);
            this.mPath.close();
            int r105 = r112 - 1;
            r213.getKeyFrame(r105);
            if (r211 != 4) goto L25;
            int r106 = this.mPathMode[r105];
            if (r106 != 1) goto L20;
            drawPathRelativeTicks(r210, r103 - 0.0f, r104 - 0.0f);
        L19:
            int r113 = 3;
        L24:
            r210.drawPath(this.mPath, this.mFillPaint);
        L26:
            if (r211 != 2) goto L28;
            drawPathRelativeTicks(r210, r103 - 0.0f, r104 - 0.0f);
        L28:
            if (r211 != r113) goto L31;
            drawPathCartesianTicks(r210, r103 - 0.0f, r104 - 0.0f);
        L31:
            if (r211 != 6) goto L33;
            drawPathScreenTicks(r210, r103 - 0.0f, r104 - 0.0f, r110, r111);
        L33:
            r210.drawPath(this.mPath, this.mFillPaint);
        L34:
            r112 = r112 + 1;
            goto L8
        L20:
            if (r106 != 2) goto L22;
            drawPathCartesianTicks(r210, r103 - 0.0f, r104 - 0.0f);
            goto L19
        L22:
            if (r106 != 3) goto L19;
            r113 = 3;
            drawPathScreenTicks(r210, r103 - 0.0f, r104 - 0.0f, r110, r111);
            goto L24
        L25:
            r104 = r104;
            r103 = r103;
            r113 = 3;
            goto L26
        L12:
            if (this.mPathMode[r112 - 1] != 0) goto L14;
        L35:
            float[] r107 = this.mPoints;
            if (r107.length <= 1) goto L42;
            r210.drawCircle(r107[0], r107[1], 8.0f, this.mPaintKeyframes);
            float[] r108 = this.mPoints;
            r210.drawCircle(r108[r108.length - 2], r108[r108.length - 1], 8.0f, this.mPaintKeyframes);
            return;
        L42:
            return;
        L5:
            r110 = 0;
            r111 = 0;
            goto L6
        }

        public void draw(Canvas r100, HashMap<View, MotionController> r101, int r102, int r103) {
            if (r101 != null) goto L4;
            return;
        L4:
            if (r101.size() == 0) goto L42;
            r100.save();
            if (this.this$0.isInEditMode() == false) goto L9;
        L11:
            Iterator<MotionController> r104 = r101.values().iterator();
        L13:
            if (r104.hasNext() == false) goto L30;
            MotionController r105 = r104.next();
            int r106 = r105.getDrawPath();
            if (r103 <= 0) goto L18;
            if (r106 != 0) goto L18;
            r106 = 1;
        L18:
            if (r106 == 0) goto L13;
            this.mKeyFrameCount = r105.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
            if (r106 < 1) goto L13;
            int r107 = r102 / 16;
            float[] r108 = this.mPoints;
            if (r108 != null) goto L25;
        L26:
            this.mPoints = new float[r107 * 2];
            this.mPath = new Path();
        L27:
            int r109 = this.mShadowTranslate;
            r100.translate(r109, r109);
            this.mPaint.setColor(1996488704);
            this.mFillPaint.setColor(1996488704);
            this.mPaintKeyframes.setColor(1996488704);
            this.mPaintGraph.setColor(1996488704);
            r105.buildPath(this.mPoints, r107);
            drawAll(r100, r106, this.mKeyFrameCount, r105);
            this.mPaint.setColor(-21965);
            this.mPaintKeyframes.setColor(-2067046);
            this.mFillPaint.setColor(-2067046);
            this.mPaintGraph.setColor(-13391360);
            int r110 = this.mShadowTranslate;
            r100.translate(-r110, -r110);
            drawAll(r100, r106, this.mKeyFrameCount, r105);
            if (r106 != 5) goto L13;
            drawRectangle(r100, r105);
            goto L13
        L25:
            if (r108.length == (r107 * 2)) goto L27;
        L30:
            r100.restore();
            return;
        L9:
            if ((r103 & 1) != 2) goto L11;
            String r111 = this.this$0.getContext().getResources().getResourceName(MotionLayout.access$000(this.this$0)) + ":" + this.this$0.getProgress();
            r100.drawText(r111, 10.0f, this.this$0.getHeight() - 30, this.mTextPaint);
            r100.drawText(r111, 11.0f, this.this$0.getHeight() - 29, this.mPaint);
            goto L11
        }

        public void drawAll(Canvas r100, int r101, int r102, MotionController r103) {
            if (r101 != 4) goto L6;
            drawPathAsConfigured(r100);
        L6:
            if (r101 != 2) goto L9;
            drawPathRelative(r100);
        L9:
            if (r101 != 3) goto L11;
            drawPathCartesian(r100);
        L11:
            drawBasicPath(r100);
            drawTicks(r100, r101, r102, r103);
        }

        private void drawPathScreenTicks(Canvas r110, float r111, float r112, int r113, int r210) {
            String r100 = "" + (((int) (((double) (((r111 - (r113 / 2)) * 100.0f) / (this.this$0.getWidth() - r113))) + 0.5d)) / 100.0f);
            getTextBounds(r100, this.mTextPaint);
            r110.drawText(r100, ((r111 / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, r112 - 20.0f, this.mTextPaint);
            r110.drawLine(r111, r112, Math.min(0.0f, 1.0f), r112, this.mPaintGraph);
            String r101 = "" + (((int) (((double) (((r112 - (r210 / 2)) * 100.0f) / (this.this$0.getHeight() - r210))) + 0.5d)) / 100.0f);
            getTextBounds(r101, this.mTextPaint);
            r110.drawText(r101, r111 + 5.0f, 0.0f - ((r112 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            r110.drawLine(r111, r112, r111, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawTranslation(Canvas r110, float r111, float r112, float r113, float r114) {
            r110.drawRect(r111, r112, r113, r114, this.mPaintGraph);
            r110.drawLine(r111, r112, r113, r114, this.mPaintGraph);
        }
    }

    public class Model {
        ConstraintSet mEnd;
        int mEndId;
        ConstraintWidgetContainer mLayoutEnd;
        ConstraintWidgetContainer mLayoutStart;
        ConstraintSet mStart;
        int mStartId;
        final /* synthetic */ MotionLayout this$0;

        public void build() {
            int r100 = this.this$0.getChildCount();
            this.this$0.mFrameArrayList.clear();
            int r101 = 0;
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L5;
            View r103 = this.this$0.getChildAt(r102);
            MotionController r104 = new MotionController(r103);
            this.this$0.mFrameArrayList.put(r103, r104);
            r102 = r102 + 1;
        L5:
            if (r101 >= r100) goto L26;
            View r105 = this.this$0.getChildAt(r101);
            MotionController r106 = this.this$0.mFrameArrayList.get(r105);
            if (r106 == null) goto L25;
            if (this.mStart == null) goto L18;
            ConstraintWidget r107 = getWidget(this.mLayoutStart, r105);
            if (r107 == null) goto L15;
            r106.setStartState(r107, this.mStart);
            goto L18
        L15:
            if (this.this$0.mDebugPath == 0) goto L18;
            Debug.getLocation();
            Debug.getName(r105);
            r105.getClass();
        L18:
            if (this.mEnd == null) goto L25;
            ConstraintWidget r108 = getWidget(this.mLayoutEnd, r105);
            if (r108 == null) goto L23;
            r106.setEndState(r108, this.mEnd);
            goto L25
        L23:
            if (this.this$0.mDebugPath == 0) goto L25;
            Debug.getLocation();
            Debug.getName(r105);
            r105.getClass();
        L25:
            r101 = r101 + 1;
            goto L5
        }

        public void reEvaluateState() {
            measure(MotionLayout.access$900(this.this$0), MotionLayout.access$1000(this.this$0));
            MotionLayout.access$1100(this.this$0);
        }

        public Model(MotionLayout r100) {
            this.this$0 = r100;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mStart = null;
            this.mEnd = null;
        }

        private void debugLayout(String r100, ConstraintWidgetContainer r101) {
            String r102 = r100 + " " + Debug.getName((View) r101.getCompanionWidget());
            r101.toString();
            int r103 = r101.getChildren().size();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L24;
            StringBuilder r105 = new StringBuilder();
            r105.append(r102);
            r105.append("[");
            r105.append(r104);
            r105.append("] ");
            ConstraintWidget r106 = (ConstraintWidget) ListProtector.get(r101.getChildren(), r104);
            String r107 = "_";
            if (r106.mTop.mTarget == null) goto L7;
            String r108 = ExifInterface.GPS_DIRECTION_TRUE;
        L8:
            StringBuilder r109 = new StringBuilder();
            r109.append(r108);
            if (r106.mBottom.mTarget == null) goto L11;
            String r110 = "B";
        L12:
            r109.append(r110);
            String r111 = r109.toString();
            StringBuilder r112 = new StringBuilder();
            r112.append(r111);
            if (r106.mLeft.mTarget == null) goto L15;
            String r113 = "L";
        L16:
            r112.append(r113);
            String r114 = r112.toString();
            StringBuilder r115 = new StringBuilder();
            r115.append(r114);
            if (r106.mRight.mTarget == null) goto L19;
            r107 = "R";
        L19:
            r115.append(r107);
            View r116 = (View) r106.getCompanionWidget();
            String r117 = Debug.getName(r116);
            if ((r116 instanceof TextView) == false) goto L22;
            StringBuilder r118 = new StringBuilder();
            r118.append(r117);
            r118.append("(");
            r118.append(((TextView) r116).getText());
            r118.append(")");
        L22:
            r106.toString();
            r104 = r104 + 1;
            goto L3
        L15:
            r113 = "_";
            goto L16
        L11:
            r110 = "_";
            goto L12
        L7:
            r108 = "_";
            goto L8
        }

        private void debugLayoutParam(String r100, ConstraintLayout.LayoutParams r101) {
            if (r101.startToStart == (-1)) goto L5;
            String r102 = "SS";
        L6:
            String r103 = " ".concat(r102);
            StringBuilder r104 = new StringBuilder();
            r104.append(r103);
            String r105 = "|__";
            if (r101.startToEnd == (-1)) goto L9;
            String r106 = "|SE";
        L10:
            r104.append(r106);
            String r107 = r104.toString();
            StringBuilder r108 = new StringBuilder();
            r108.append(r107);
            if (r101.endToStart == (-1)) goto L13;
            String r109 = "|ES";
        L14:
            r108.append(r109);
            String r110 = r108.toString();
            StringBuilder r111 = new StringBuilder();
            r111.append(r110);
            if (r101.endToEnd == (-1)) goto L17;
            String r112 = "|EE";
        L18:
            r111.append(r112);
            String r113 = r111.toString();
            StringBuilder r114 = new StringBuilder();
            r114.append(r113);
            if (r101.leftToLeft == (-1)) goto L21;
            String r115 = "|LL";
        L22:
            r114.append(r115);
            String r116 = r114.toString();
            StringBuilder r117 = new StringBuilder();
            r117.append(r116);
            if (r101.leftToRight == (-1)) goto L25;
            String r118 = "|LR";
        L26:
            r117.append(r118);
            String r119 = r117.toString();
            StringBuilder r120 = new StringBuilder();
            r120.append(r119);
            if (r101.rightToLeft == (-1)) goto L29;
            String r121 = "|RL";
        L30:
            r120.append(r121);
            String r122 = r120.toString();
            StringBuilder r123 = new StringBuilder();
            r123.append(r122);
            if (r101.rightToRight == (-1)) goto L33;
            String r124 = "|RR";
        L34:
            r123.append(r124);
            String r125 = r123.toString();
            StringBuilder r126 = new StringBuilder();
            r126.append(r125);
            if (r101.topToTop == (-1)) goto L37;
            String r127 = "|TT";
        L38:
            r126.append(r127);
            String r128 = r126.toString();
            StringBuilder r129 = new StringBuilder();
            r129.append(r128);
            if (r101.topToBottom == (-1)) goto L41;
            String r130 = "|TB";
        L42:
            r129.append(r130);
            String r131 = r129.toString();
            StringBuilder r132 = new StringBuilder();
            r132.append(r131);
            if (r101.bottomToTop == (-1)) goto L45;
            String r133 = "|BT";
        L46:
            r132.append(r133);
            String r134 = r132.toString();
            StringBuilder r135 = new StringBuilder();
            r135.append(r134);
            if (r101.bottomToBottom == (-1)) goto L49;
            r105 = "|BB";
        L49:
            r135.append(r105);
            return;
        L45:
            r133 = "|__";
            goto L46
        L41:
            r130 = "|__";
            goto L42
        L37:
            r127 = "|__";
            goto L38
        L33:
            r124 = "|__";
            goto L34
        L29:
            r121 = "|__";
            goto L30
        L25:
            r118 = "|__";
            goto L26
        L21:
            r115 = "|__";
            goto L22
        L17:
            r112 = "|__";
            goto L18
        L13:
            r109 = "|__";
            goto L14
        L9:
            r106 = "|__";
            goto L10
        L5:
            r102 = "__";
            goto L6
        }

        private void debugWidget(String r100, ConstraintWidget r101) {
            StringBuilder r102 = new StringBuilder(" ");
            ConstraintAnchor r103 = r101.mTop.mTarget;
            String r104 = ExifInterface.GPS_DIRECTION_TRUE;
            String r105 = "__";
            if (r103 != null) goto L5;
            String r106 = "__";
        L10:
            r102.append(r106);
            String r107 = r102.toString();
            StringBuilder r108 = new StringBuilder();
            r108.append(r107);
            ConstraintAnchor r109 = r101.mBottom.mTarget;
            if (r109 != null) goto L13;
            String r110 = "__";
        L18:
            r108.append(r110);
            String r111 = r108.toString();
            StringBuilder r112 = new StringBuilder();
            r112.append(r111);
            ConstraintAnchor r113 = r101.mLeft.mTarget;
            String r114 = "L";
            if (r113 != null) goto L21;
            String r115 = "__";
        L26:
            r112.append(r115);
            String r116 = r112.toString();
            StringBuilder r117 = new StringBuilder();
            r117.append(r116);
            ConstraintAnchor r118 = r101.mRight.mTarget;
            if (r118 != null) goto L29;
        L33:
            r117.append(r105);
            r101.toString();
            return;
        L29:
            if (r118.mType == ConstraintAnchor.Type.LEFT) goto L32;
            r114 = "R";
        L32:
            r105 = "R".concat(r114);
            goto L33
        L21:
            if (r113.mType != ConstraintAnchor.Type.LEFT) goto L23;
            String r119 = "L";
        L24:
            r115 = "L".concat(r119);
            goto L26
        L23:
            r119 = "R";
            goto L24
        L13:
            if (r109.mType == ConstraintAnchor.Type.TOP) goto L16;
            r104 = "B";
        L16:
            r110 = "B".concat(r104);
            goto L18
        L5:
            if (r103.mType != ConstraintAnchor.Type.TOP) goto L7;
            String r120 = ExifInterface.GPS_DIRECTION_TRUE;
        L8:
            r106 = ExifInterface.GPS_DIRECTION_TRUE.concat(r120);
            goto L10
        L7:
            r120 = "B";
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(ConstraintWidgetContainer r110, ConstraintSet r111) {
            SparseArray<ConstraintWidget> r100 = new SparseArray();
            Constraints.LayoutParams r101 = new Constraints.LayoutParams(-2, -2);
            r100.clear();
            r100.put(0, r110);
            r100.put(this.this$0.getId(), r110);
            Iterator<ConstraintWidget> r102 = r110.getChildren().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ConstraintWidget r103 = r102.next();
            r100.put(((View) r103.getCompanionWidget()).getId(), r103);
            goto L4
        L6:
            Iterator<ConstraintWidget> r104 = r110.getChildren().iterator();
        L8:
            if (r104.hasNext() == false) goto L18;
            ConstraintWidget r105 = r104.next();
            View r112 = (View) r105.getCompanionWidget();
            r111.applyToLayoutParams(r112.getId(), r101);
            r105.setWidth(r111.getWidth(r112.getId()));
            r105.setHeight(r111.getHeight(r112.getId()));
            if ((r112 instanceof ConstraintHelper) == false) goto L14;
            r111.applyToHelper((ConstraintHelper) r112, r105, r101, r100);
            if ((r112 instanceof Barrier) == false) goto L14;
            ((Barrier) r112).validateParams();
        L14:
            r101.resolveLayoutDirection(this.this$0.getLayoutDirection());
            MotionLayout.access$800(this.this$0, false, r112, r105, r101, r100);
            if (r111.getVisibilityMode(r112.getId()) == 1) goto L16;
            r105.setVisibility(r111.getVisibility(r112.getId()));
            goto L8
        L16:
            r105.setVisibility(r112.getVisibility());
            goto L8
        L18:
            Iterator<ConstraintWidget> r113 = r110.getChildren().iterator();
        L20:
            if (r113.hasNext() == false) goto L24;
            ConstraintWidget r106 = r113.next();
            if ((r106 instanceof VirtualLayout) == false) goto L20;
            ConstraintHelper r107 = (ConstraintHelper) r106.getCompanionWidget();
            Helper r108 = (Helper) r106;
            r107.updatePreLayout(r110, r108, r100);
            ((VirtualLayout) r108).captureWidgets();
            goto L20
        }

        public void copy(ConstraintWidgetContainer r100, ConstraintWidgetContainer r101) {
            ArrayList<ConstraintWidget> r102 = r100.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> r103 = new HashMap();
            r103.put(r100, r101);
            r101.getChildren().clear();
            r101.copy(r100, r103);
            Iterator<ConstraintWidget> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L19;
            ConstraintWidget r105 = r104.next();
            if ((r105 instanceof androidx.constraintlayout.solver.widgets.Barrier) == false) goto L9;
            ConstraintWidget r106 = new androidx.constraintlayout.solver.widgets.Barrier();
        L18:
            r101.add(r106);
            r103.put(r105, r106);
            goto L4
        L9:
            if ((r105 instanceof Guideline) == false) goto L12;
            r106 = new Guideline();
            goto L18
        L12:
            if ((r105 instanceof Flow) == false) goto L15;
            r106 = new Flow();
            goto L18
        L15:
            if ((r105 instanceof Helper) == false) goto L17;
            r106 = new HelperWidget();
            goto L18
        L17:
            r106 = new ConstraintWidget();
            goto L18
        L19:
            Iterator<ConstraintWidget> r107 = r102.iterator();
        L21:
            if (r107.hasNext() == false) goto L23;
            ConstraintWidget r108 = r107.next();
            r103.get(r108).copy(r108, r103);
            goto L21
        }

        public ConstraintWidget getWidget(ConstraintWidgetContainer r100, View r101) {
            if (r100.getCompanionWidget() != r101) goto L5;
            return r100;
        L5:
            ArrayList<ConstraintWidget> r102 = r100.getChildren();
            int r103 = r102.size();
            int r104 = 0;
        L6:
            if (r104 >= r103) goto L11;
            ConstraintWidget r105 = (ConstraintWidget) ListProtector.get(r102, r104);
            if (r105.getCompanionWidget() == r101) goto L9;
            r104 = r104 + 1;
            goto L6
        L9:
            return r105;
        L11:
            return null;
        }

        public boolean isNotConfiguredWith(int r100, int r101) {
            if (r100 == this.mStartId) goto L5;
        L8:
            return true;
        L5:
            if (r101 != this.mEndId) goto L8;
            return false;
        }

        public void measure(int r110, int r111) {
            int r100 = View.MeasureSpec.getMode(r110);
            int r101 = View.MeasureSpec.getMode(r111);
            MotionLayout r102 = this.this$0;
            r102.mWidthMeasureMode = r100;
            r102.mHeightMeasureMode = r101;
            int r103 = r102.getOptimizationLevel();
            MotionLayout r104 = this.this$0;
            if (r104.mCurrentState != r104.getStartState()) goto L8;
            MotionLayout.access$1200(this.this$0, this.mLayoutEnd, r103, r110, r111);
            if (this.mStart == null) goto L11;
            MotionLayout.access$1300(this.this$0, this.mLayoutStart, r103, r110, r111);
        L11:
            boolean r105 = false;
            if ((this.this$0.getParent() instanceof MotionLayout) == true) goto L14;
        L17:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L36;
            MotionLayout r107 = this.this$0;
            r107.mWidthMeasureMode = r100;
            r107.mHeightMeasureMode = r101;
            if (r107.mCurrentState != r107.getStartState()) goto L25;
            MotionLayout.access$1600(this.this$0, this.mLayoutEnd, r103, r110, r111);
            if (this.mStart == null) goto L28;
            MotionLayout.access$1700(this.this$0, this.mLayoutStart, r103, r110, r111);
        L28:
            this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
            this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
            this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
            this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
            MotionLayout r108 = this.this$0;
            if (r108.mStartWrapWidth == r108.mEndWrapWidth) goto L31;
        L34:
            boolean r109 = true;
        L35:
            r108.mMeasureDuringTransition = r109;
            goto L36
        L31:
            if (r108.mStartWrapHeight != r108.mEndWrapHeight) goto L34;
            r109 = false;
            goto L35
        L25:
            if (this.mStart == null) goto L27;
            MotionLayout.access$1800(this.this$0, this.mLayoutStart, r103, r110, r111);
        L27:
            MotionLayout.access$1900(this.this$0, this.mLayoutEnd, r103, r110, r111);
        L36:
            MotionLayout r112 = this.this$0;
            int r113 = r112.mStartWrapWidth;
            int r114 = r112.mStartWrapHeight;
            int r115 = r112.mWidthMeasureMode;
            if (r115 == Integer.MIN_VALUE) goto L39;
            if (r115 == 0) goto L39;
        L40:
            int r116 = r112.mHeightMeasureMode;
            if (r116 == Integer.MIN_VALUE) goto L43;
            if (r116 == 0) goto L43;
        L45:
            if (this.mLayoutStart.isWidthMeasuredTooSmall() == false) goto L47;
        L50:
            boolean r117 = true;
        L52:
            if (this.mLayoutStart.isHeightMeasuredTooSmall() == false) goto L54;
        L55:
            r105 = true;
        L56:
            MotionLayout.access$2000(this.this$0, r110, r111, r113, r114, r117, r105);
            return;
        L54:
            if (this.mLayoutEnd.isHeightMeasuredTooSmall() == false) goto L56;
        L47:
            if (this.mLayoutEnd.isWidthMeasuredTooSmall() == true) goto L50;
            r117 = false;
        L43:
            r114 = (int) (r114 + (r112.mPostInterpolationPosition * (r112.mEndWrapHeight - r114)));
        L39:
            r113 = (int) (r113 + (r112.mPostInterpolationPosition * (r112.mEndWrapWidth - r113)));
            goto L40
        L14:
            if (r100 != 1073741824) goto L17;
            if (r101 != 1073741824) goto L17;
            r106 = false;
            goto L18
        L8:
            if (this.mStart == null) goto L10;
            MotionLayout.access$1400(this.this$0, this.mLayoutStart, r103, r110, r111);
        L10:
            MotionLayout.access$1500(this.this$0, this.mLayoutEnd, r103, r110, r111);
            goto L11
        }

        public void setMeasuredId(int r100, int r101) {
            this.mStartId = r100;
            this.mEndId = r101;
        }

        public void initFrom(ConstraintWidgetContainer r100, ConstraintSet r101, ConstraintSet r102) {
            this.mStart = r101;
            this.mEnd = r102;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.access$200(this.this$0).getMeasurer());
            this.mLayoutEnd.setMeasurer(MotionLayout.access$300(this.this$0).getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(MotionLayout.access$400(this.this$0), this.mLayoutStart);
            copy(MotionLayout.access$500(this.this$0), this.mLayoutEnd);
            if (this.this$0.mTransitionLastPosition <= 0.5d) goto L7;
            if (r101 == null) goto L6;
            setupConstraintWidget(this.mLayoutStart, r101);
        L6:
            setupConstraintWidget(this.mLayoutEnd, r102);
        L10:
            this.mLayoutStart.setRtl(MotionLayout.access$600(this.this$0));
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.access$700(this.this$0));
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams r103 = this.this$0.getLayoutParams();
            if (r103 != null) goto L13;
            return;
        L13:
            if (r103.width != (-2)) goto L16;
            ConstraintWidgetContainer r104 = this.mLayoutStart;
            ConstraintWidget.DimensionBehaviour r105 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r104.setHorizontalDimensionBehaviour(r105);
            this.mLayoutEnd.setHorizontalDimensionBehaviour(r105);
        L16:
            if (r103.height != (-2)) goto L20;
            ConstraintWidgetContainer r106 = this.mLayoutStart;
            ConstraintWidget.DimensionBehaviour r107 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r106.setVerticalDimensionBehaviour(r107);
            this.mLayoutEnd.setVerticalDimensionBehaviour(r107);
            return;
        L20:
            return;
        L7:
            setupConstraintWidget(this.mLayoutEnd, r102);
            if (r101 == null) goto L10;
            setupConstraintWidget(this.mLayoutStart, r101);
            goto L10
        }
    }

    public interface MotionTracker {
        void addMovement(MotionEvent r100);

        void clear();

        void computeCurrentVelocity(int r100);

        void computeCurrentVelocity(int r100, float r101);

        float getXVelocity();

        float getXVelocity(int r100);

        float getYVelocity();

        float getYVelocity(int r100);

        void recycle();
    }

    public static class MyTracker implements MotionTracker {

        /* JADX INFO: renamed from: me, reason: collision with root package name */
        private static MyTracker f15329me;
        VelocityTracker tracker;

        private MyTracker() {
        }

        static {
            f15329me = new MyTracker();
        }

        public static MyTracker obtain() {
            MyTracker r100 = f15329me;
            r100.tracker = VelocityTracker.obtain();
            return f15329me;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker r100 = this.tracker;
            if (r100 == null) goto L6;
            r100.clear();
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker r100 = this.tracker;
            if (r100 != null) goto L5;
            return 0.0f;
        L5:
            return r100.getXVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker r100 = this.tracker;
            if (r100 != null) goto L5;
            return 0.0f;
        L5:
            return r100.getYVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker r100 = this.tracker;
            if (r100 == null) goto L6;
            r100.recycle();
            this.tracker = null;
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent r100) {
            VelocityTracker r101 = this.tracker;
            if (r101 == null) goto L6;
            r101.addMovement(r100);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r100) {
            VelocityTracker r101 = this.tracker;
            if (r101 == null) goto L6;
            r101.computeCurrentVelocity(r100);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int r100) {
            VelocityTracker r101 = this.tracker;
            if (r101 != null) goto L5;
            return 0.0f;
        L5:
            return r101.getXVelocity(r100);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int r100) {
            if (this.tracker != null) goto L5;
            return 0.0f;
        L5:
            return getYVelocity(r100);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r100, float r101) {
            VelocityTracker r102 = this.tracker;
            if (r102 == null) goto L6;
            r102.computeCurrentVelocity(r100, r101);
            return;
        }
    }

    public class StateCache {
        final String KeyEndState;
        final String KeyProgress;
        final String KeyStartState;
        final String KeyVelocity;
        int endState;
        float mProgress;
        float mVelocity;
        int startState;
        final /* synthetic */ MotionLayout this$0;

        public void apply() {
            int r100 = this.startState;
            if (r100 == (-1)) goto L5;
        L6:
            if (r100 != (-1)) goto L8;
            this.this$0.transitionToState(this.endState);
        L12:
            this.this$0.setState(TransitionState.SETUP);
        L14:
            if (Float.isNaN(this.mVelocity) == true) goto L16;
            this.this$0.setProgress(this.mProgress, this.mVelocity);
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
            return;
        L16:
            if (Float.isNaN(this.mProgress) == false) goto L18;
            return;
        L18:
            this.this$0.setProgress(this.mProgress);
            return;
        L8:
            int r101 = this.endState;
            if (r101 != (-1)) goto L11;
            this.this$0.setState(r100, -1, -1);
            goto L12
        L11:
            this.this$0.setTransition(r100, r101);
            goto L12
        L5:
            if (this.endState == (-1)) goto L14;
            goto L6
        }

        public Bundle getTransitionState() {
            Bundle r100 = new Bundle();
            r100.putFloat("motion.progress", this.mProgress);
            r100.putFloat("motion.velocity", this.mVelocity);
            r100.putInt("motion.StartState", this.startState);
            r100.putInt("motion.EndState", this.endState);
            return r100;
        }

        public void recordState() {
            this.endState = MotionLayout.access$000(this.this$0);
            this.startState = MotionLayout.access$100(this.this$0);
            this.mVelocity = this.this$0.getVelocity();
            this.mProgress = this.this$0.getProgress();
        }

        public StateCache(MotionLayout r100) {
            this.this$0 = r100;
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
            this.KeyProgress = "motion.progress";
            this.KeyVelocity = "motion.velocity";
            this.KeyStartState = "motion.StartState";
            this.KeyEndState = "motion.EndState";
        }

        public void setEndState(int r100) {
            this.endState = r100;
        }

        public void setProgress(float r100) {
            this.mProgress = r100;
        }

        public void setStartState(int r100) {
            this.startState = r100;
        }

        public void setTransitionState(Bundle r100) {
            this.mProgress = r100.getFloat("motion.progress");
            this.mVelocity = r100.getFloat("motion.velocity");
            this.startState = r100.getInt("motion.StartState");
            this.endState = r100.getInt("motion.EndState");
        }

        public void setVelocity(float r100) {
            this.mVelocity = r100;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout r100, int r101, int r102, float r103);

        void onTransitionCompleted(MotionLayout r100, int r101);

        void onTransitionStarted(MotionLayout r100, int r101, int r102);

        void onTransitionTrigger(MotionLayout r100, int r101, boolean r102, float r103);
    }

    public static final enum TransitionState extends Enum<TransitionState> {
        private static final /* synthetic */ TransitionState[] $VALUES = null;
        public static final TransitionState FINISHED = null;
        public static final TransitionState MOVING = null;
        public static final TransitionState SETUP = null;
        public static final TransitionState UNDEFINED = null;

        static {
            TransitionState r100 = new TransitionState("UNDEFINED", 0);
            UNDEFINED = r100;
            TransitionState r101 = new TransitionState("SETUP", 1);
            SETUP = r101;
            TransitionState r102 = new TransitionState("MOVING", 2);
            MOVING = r102;
            TransitionState r103 = new TransitionState("FINISHED", 3);
            FINISHED = r103;
            $VALUES = new TransitionState[]{r100, r101, r102, r103};
        }

        public static TransitionState[] values() {
            return (TransitionState[]) $VALUES.clone();
        }

        public static TransitionState valueOf(String r100) {
            return (TransitionState) a.a(TransitionState.class, r100);
        }

        private TransitionState(String r100, int r101) {
            super(r100, r101);
        }
    }

    private void debugPos() {
        int r100 = 0;
    L4:
        if (r100 >= getChildCount()) goto L6;
        View r101 = getChildAt(r100);
        Debug.getLocation();
        Debug.getName(this);
        Debug.getName(getContext(), this.mCurrentState);
        Debug.getName(r101);
        r101.getLeft();
        r101.getTop();
        r100 = r100 + 1;
        goto L4
    }

    private static boolean willJump(float r100, float r101, float r102) {
        if (r100 <= 0.0f) goto L9;
        float r103 = r100 / r102;
        if ((r101 + ((r100 * r103) - (((r102 * r103) * r103) / 2.0f))) > 1.0f) goto L14;
        return false;
    L14:
        return true;
    L9:
        float r104 = (-r100) / r102;
        if ((r101 + ((r100 * r104) + (((r102 * r104) * r104) / 2.0f))) < 0.0f) goto L15;
        return false;
    L15:
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r100, float r101, float r102) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    private void checkStructure() {
        MotionScene r100 = this.mScene;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getStartId();
        MotionScene r102 = this.mScene;
        checkStructure(r101, r102.getConstraintSet(r102.getStartId()));
        SparseIntArray r103 = new SparseIntArray();
        SparseIntArray r104 = new SparseIntArray();
        Iterator<MotionScene.Transition> r105 = this.mScene.getDefinedTransitions().iterator();
    L7:
        if (r105.hasNext() == false) goto L20;
        MotionScene.Transition r106 = r105.next();
        MotionScene.Transition r107 = this.mScene.mCurrentTransition;
        checkStructure(r106);
        int r108 = r106.getStartConstraintSetId();
        int r109 = r106.getEndConstraintSetId();
        Debug.getName(getContext(), r108);
        Debug.getName(getContext(), r109);
        if (r103.get(r108) == r109) goto L12;
    L12:
        if (r104.get(r109) == r108) goto L14;
    L14:
        r103.put(r108, r109);
        r104.put(r109, r108);
        if (this.mScene.getConstraintSet(r108) == null) goto L18;
    L18:
        if (this.mScene.getConstraintSet(r109) != null) goto L7;
        goto L7
    }

    private void evaluateLayout() {
        float r100 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long r101 = getNanoTime();
        Interpolator r102 = this.mInterpolator;
        if ((r102 instanceof StopLogic) == true) goto L5;
        float r103 = (((r101 - this.mTransitionLastTime) * r100) * 1.0E-9f) / this.mTransitionDuration;
    L6:
        float r104 = this.mTransitionLastPosition + r103;
        if (this.mTransitionInstantly == false) goto L9;
        r104 = this.mTransitionGoalPosition;
    L9:
        int r105 = 0;
        if (r100 <= 0.0f) goto L14;
        if (r104 < this.mTransitionGoalPosition) goto L14;
    L17:
        r104 = this.mTransitionGoalPosition;
        boolean r106 = true;
    L19:
        if (r102 == null) goto L25;
        if (r106 == true) goto L25;
        if (this.mTemporalInterpolator == false) goto L24;
        r104 = r102.getInterpolation((r101 - this.mAnimationStartTime) * 1.0E-9f);
        goto L25
    L24:
        r104 = r102.getInterpolation(r104);
    L25:
        if (r100 <= 0.0f) goto L29;
        if (r104 < this.mTransitionGoalPosition) goto L29;
    L32:
        r104 = this.mTransitionGoalPosition;
    L33:
        this.mPostInterpolationPosition = r104;
        int r107 = getChildCount();
        long r108 = getNanoTime();
    L34:
        if (r105 >= r107) goto L40;
        View r109 = getChildAt(r105);
        MotionController r110 = this.mFrameArrayList.get(r109);
        if (r110 == null) goto L38;
        r110.interpolate(r109, r104, r108, this.mKeyCache);
    L38:
        r105 = r105 + 1;
        goto L34
    L40:
        if (this.mMeasureDuringTransition == false) goto L46;
        requestLayout();
        return;
    L46:
        return;
    L29:
        if (r100 > 0.0f) goto L33;
        if (r104 > this.mTransitionGoalPosition) goto L33;
    L14:
        if (r100 <= 0.0f) goto L16;
    L18:
        r106 = false;
        goto L19
    L16:
        if (r104 > this.mTransitionGoalPosition) goto L18;
    L5:
        r103 = 0.0f;
        goto L6
    }

    private void fireTransitionChange() {
        if (this.mTransitionListener != null) goto L9;
        ArrayList<TransitionListener> r100 = this.mTransitionListeners;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.mListenerPosition != this.mTransitionPosition) goto L11;
        return;
    L11:
        if (this.mListenerState == (-1)) goto L22;
        TransitionListener r101 = this.mTransitionListener;
        if (r101 == null) goto L15;
        r101.onTransitionStarted(this, this.mBeginState, this.mEndState);
    L15:
        ArrayList<TransitionListener> r102 = this.mTransitionListeners;
        if (r102 == null) goto L21;
        Iterator<TransitionListener> r103 = r102.iterator();
    L19:
        if (r103.hasNext() == false) goto L21;
        r103.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
    L21:
        this.mIsAnimating = true;
    L22:
        this.mListenerState = -1;
        float r104 = this.mTransitionPosition;
        this.mListenerPosition = r104;
        TransitionListener r105 = this.mTransitionListener;
        if (r105 == null) goto L25;
        r105.onTransitionChange(this, this.mBeginState, this.mEndState, r104);
    L25:
        ArrayList<TransitionListener> r106 = this.mTransitionListeners;
        if (r106 == null) goto L31;
        Iterator<TransitionListener> r107 = r106.iterator();
    L29:
        if (r107.hasNext() == false) goto L31;
        r107.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
    L31:
        this.mIsAnimating = true;
    }

    private void processTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        ArrayList<TransitionListener> r100 = this.mTransitionListeners;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        this.mIsAnimating = false;
        Iterator<Integer> r101 = this.mTransitionCompleted.iterator();
    L11:
        if (r101.hasNext() == false) goto L21;
        Integer r102 = r101.next();
        TransitionListener r103 = this.mTransitionListener;
        if (r103 == null) goto L15;
        r103.onTransitionCompleted(this, r102.intValue());
    L15:
        ArrayList<TransitionListener> r104 = this.mTransitionListeners;
        if (r104 == null) goto L11;
        Iterator<TransitionListener> r105 = r104.iterator();
    L19:
        if (r105.hasNext() == false) goto L11;
        r105.next().onTransitionCompleted(this, r102.intValue());
        goto L19
    L21:
        this.mTransitionCompleted.clear();
    }

    public void fireTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        ArrayList<TransitionListener> r100 = this.mTransitionListeners;
        if (r100 != null) goto L7;
    L18:
        processTransitionCompleted();
        return;
    L7:
        if (r100.isEmpty() == true) goto L18;
    L9:
        if (this.mListenerState != (-1)) goto L18;
        this.mListenerState = this.mCurrentState;
        if (this.mTransitionCompleted.isEmpty() == true) goto L13;
        ArrayList<Integer> r101 = this.mTransitionCompleted;
        int r102 = ((Integer) ListProtector.get(r101, r101.size() - 1)).intValue();
    L14:
        int r103 = this.mCurrentState;
        if (r102 == r103) goto L18;
        if (r103 == (-1)) goto L18;
        this.mTransitionCompleted.add(Integer.valueOf(r103));
        goto L18
    L13:
        r102 = -1;
        goto L14
    }

    public int[] getConstraintSetIds() {
        MotionScene r100 = this.mScene;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getConstraintSetIds();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene r100 = this.mScene;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool != null) goto L6;
        this.mDesignTool = new DesignTool(this);
    L6:
        return this.mDesignTool;
    }

    public Bundle getTransitionState() {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new StateCache(this);
    L5:
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene r100 = this.mScene;
        if (r100 == null) goto L6;
        this.mTransitionDuration = r100.getDuration() / 1000.0f;
    L6:
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public void onNewStateAttachHandlers() {
        MotionScene r100 = this.mScene;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.autoTransition(this, this.mCurrentState) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r101 = this.mCurrentState;
        if (r101 == (-1)) goto L13;
        this.mScene.addOnClickListeners(this, r101);
    L13:
        if (this.mScene.supportTouch() == false) goto L16;
        this.mScene.setupTouch();
        return;
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mMeasureDuringTransition == false) goto L5;
    L13:
        super.requestLayout();
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L13;
        MotionScene r100 = this.mScene;
        if (r100 == null) goto L13;
        MotionScene.Transition r101 = r100.mCurrentTransition;
        if (r101 == null) goto L13;
        if (r101.getLayoutDuringTransition() != 0) goto L13;
    }

    public void transitionToEnd() {
        animateTo(1.0f);
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    private void computeCurrentPositions() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        View r102 = getChildAt(r101);
        MotionController r103 = this.mFrameArrayList.get(r102);
        if (r103 == null) goto L8;
        r103.setStartCurrentState(r102);
    L8:
        r101 = r101 + 1;
        goto L3
    }

    private void setupMotionViews() {
        int r100 = getChildCount();
        this.mModel.build();
        boolean r101 = true;
        this.mInTransition = true;
        int r102 = getWidth();
        int r103 = getHeight();
        int r104 = this.mScene.gatPathMotionArc();
        int r110 = 0;
        if (r104 == (-1)) goto L10;
        int r105 = 0;
    L5:
        if (r105 >= r100) goto L10;
        MotionController r106 = this.mFrameArrayList.get(getChildAt(r105));
        if (r106 == null) goto L9;
        r106.setPathMotionArc(r104);
    L9:
        r105 = r105 + 1;
    L10:
        int r111 = 0;
    L11:
        if (r111 >= r100) goto L16;
        MotionController r107 = this.mFrameArrayList.get(getChildAt(r111));
        if (r107 == null) goto L15;
        this.mScene.getKeyFrames(r107);
        r107.setup(r102, r103, this.mTransitionDuration, getNanoTime());
    L15:
        r111 = r111 + 1;
        goto L11
    L16:
        float r108 = this.mScene.getStaggered();
        if (r108 != 0.0f) goto L19;
        return;
    L19:
        if (r108 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
        boolean r109 = true;
    L22:
        float r112 = Math.abs(r108);
        float r113 = -3.4028235E38f;
        float r114 = Float.MAX_VALUE;
        int r115 = 0;
        float r116 = Float.MAX_VALUE;
        float r117 = -3.4028235E38f;
    L23:
        if (r115 >= r100) goto L32;
        MotionController r118 = this.mFrameArrayList.get(getChildAt(r115));
        if (Float.isNaN(r118.mMotionStagger) == false) goto L34;
        float r119 = r118.getFinalX();
        float r120 = r118.getFinalY();
        if (r109 == false) goto L30;
        float r121 = r120 - r119;
    L31:
        r116 = Math.min(r116, r121);
        r117 = Math.max(r117, r121);
        r115 = r115 + 1;
        goto L23
    L30:
        r121 = r120 + r119;
    L34:
        if (r101 == false) goto L49;
        int r122 = 0;
    L36:
        if (r122 >= r100) goto L41;
        MotionController r123 = this.mFrameArrayList.get(getChildAt(r122));
        if (Float.isNaN(r123.mMotionStagger) == true) goto L40;
        r114 = Math.min(r114, r123.mMotionStagger);
        r113 = Math.max(r113, r123.mMotionStagger);
    L40:
        r122 = r122 + 1;
    L41:
        if (r110 >= r100) goto L76;
        MotionController r124 = this.mFrameArrayList.get(getChildAt(r110));
        if (Float.isNaN(r124.mMotionStagger) == true) goto L48;
        r124.mStaggerScale = 1.0f / (1.0f - r112);
        if (r109 == false) goto L47;
        r124.mStaggerOffset = r112 - (((r113 - r124.mMotionStagger) / (r113 - r114)) * r112);
        goto L48
    L47:
        r124.mStaggerOffset = r112 - (((r124.mMotionStagger - r114) * r112) / (r113 - r114));
    L48:
        r110 = r110 + 1;
        goto L41
    L76:
        return;
    L49:
        if (r110 >= r100) goto L77;
        MotionController r125 = this.mFrameArrayList.get(getChildAt(r110));
        float r126 = r125.getFinalX();
        float r127 = r125.getFinalY();
        if (r109 == false) goto L53;
        float r128 = r127 - r126;
    L54:
        r125.mStaggerScale = 1.0f / (1.0f - r112);
        r125.mStaggerOffset = r112 - (((r128 - r116) * r112) / (r117 - r116));
        r110 = r110 + 1;
        goto L49
    L53:
        r128 = r127 + r126;
        goto L54
    L77:
        return;
    L32:
        r101 = false;
        goto L34
    L21:
        r109 = false;
        goto L22
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MotionScene r100 = this.mScene;
        if (r100 == null) goto L10;
        int r101 = this.mCurrentState;
        if (r101 == (-1)) goto L10;
        ConstraintSet r102 = r100.getConstraintSet(r101);
        this.mScene.readFallback(this);
        if (r102 == null) goto L9;
        r102.applyTo(this);
    L9:
        this.mBeginState = this.mCurrentState;
    L10:
        onNewStateAttachHandlers();
        StateCache r103 = this.mStateCache;
        if (r103 == null) goto L13;
        r103.apply();
        return;
    L13:
        MotionScene r104 = this.mScene;
        if (r104 == null) goto L22;
        MotionScene.Transition r105 = r104.mCurrentTransition;
        if (r105 != null) goto L18;
        return;
    L18:
        if (r105.getAutoTransition() != 4) goto L24;
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L24:
        return;
    }

    @Override // android.view.View
    public String toString() {
        Context r100 = getContext();
        return Debug.getName(r100, this.mBeginState) + "->" + Debug.getName(r100, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public void rebuildMotion() {
        rebuildScene();
    }

    public MotionLayout(Context r100) {
        super(r100);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        init(null);
    }

    public static /* synthetic */ int access$000(MotionLayout r100) {
        return r100.mEndState;
    }

    public static /* synthetic */ int access$100(MotionLayout r100) {
        return r100.mBeginState;
    }

    public static /* synthetic */ int access$1000(MotionLayout r100) {
        return r100.mLastHeightMeasureSpec;
    }

    public static /* synthetic */ void access$1100(MotionLayout r100) {
        r100.setupMotionViews();
    }

    public static /* synthetic */ ConstraintWidgetContainer access$200(MotionLayout r100) {
        return r100.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer access$300(MotionLayout r100) {
        return r100.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer access$400(MotionLayout r100) {
        return r100.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer access$500(MotionLayout r100) {
        return r100.mLayoutWidget;
    }

    public static /* synthetic */ boolean access$600(MotionLayout r100) {
        return r100.isRtl();
    }

    public static /* synthetic */ boolean access$700(MotionLayout r100) {
        return r100.isRtl();
    }

    public static /* synthetic */ int access$900(MotionLayout r100) {
        return r100.mLastWidthMeasureSpec;
    }

    private void checkStructure(MotionScene.Transition r100) {
        r100.debugString(getContext());
        r100.getDuration();
        r100.getStartConstraintSetId();
        r100.getEndConstraintSetId();
    }

    private void init(AttributeSet r110) {
        IS_IN_EDIT_MODE = isInEditMode();
        if (r110 == null) goto L33;
        TypedArray r111 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.applyMotionScene, R.attr.currentState, R.attr.layoutDescription, R.attr.motionDebug, R.attr.motionProgress, R.attr.showPaths});
        int r100 = r111.getIndexCount();
        int r101 = 0;
        boolean r102 = true;
    L5:
        if (r101 >= r100) goto L29;
        int r103 = r111.getIndex(r101);
        int r104 = 2;
        if (r103 != 2) goto L9;
        int r105 = r111.getResourceId(r103, -1);
        this.mScene = new MotionScene(getContext(), this, r105);
    L28:
        r101 = r101 + 1;
        goto L5
    L9:
        if (r103 != 1) goto L12;
        this.mCurrentState = r111.getResourceId(r103, -1);
        goto L28
    L12:
        if (r103 != 4) goto L14;
        this.mTransitionGoalPosition = r111.getFloat(r103, 0.0f);
        this.mInTransition = true;
        goto L28
    L14:
        if (r103 != 0) goto L17;
        r102 = r111.getBoolean(r103, r102);
        goto L28
    L17:
        if (r103 != 5) goto L26;
        if (this.mDebugPath != 0) goto L28;
        if (r111.getBoolean(r103, false) == true) goto L24;
        r104 = 0;
    L24:
        this.mDebugPath = r104;
        goto L28
    L26:
        if (r103 != 3) goto L28;
        this.mDebugPath = r111.getInt(r103, 0);
        goto L28
    L29:
        r111.recycle();
        if (r102 == true) goto L33;
        this.mScene = null;
    L33:
        if (this.mDebugPath == 0) goto L36;
        checkStructure();
    L36:
        if (this.mCurrentState != (-1)) goto L50;
        MotionScene r112 = this.mScene;
        if (r112 == null) goto L51;
        this.mCurrentState = r112.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
        return;
    L51:
        return;
    }

    public void addTransitionListener(TransitionListener r100) {
        if (this.mTransitionListeners != null) goto L5;
        this.mTransitionListeners = new ArrayList();
    L5:
        this.mTransitionListeners.add(r100);
    }

    public void animateTo(float r100) {
        MotionScene r101 = this.mScene;
        if (r101 != null) goto L5;
        return;
    L5:
        float r102 = this.mTransitionLastPosition;
        float r103 = this.mTransitionPosition;
        if (r102 != r103) goto L8;
    L10:
        float r104 = this.mTransitionLastPosition;
        if (r104 != r100) goto L13;
        return;
    L13:
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = r100;
        this.mTransitionDuration = r101.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = r104;
        this.mTransitionLastPosition = r104;
        invalidate();
        return;
    L8:
        if (this.mTransitionInstantly == false) goto L10;
        this.mTransitionLastPosition = r103;
        goto L10
    }

    public void disableAutoTransition(boolean r100) {
        MotionScene r101 = this.mScene;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.disableAutoTransition(r100);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r110) {
        evaluate(false);
        super.dispatchDraw(r110);
        if (this.mScene != null) goto L6;
        return;
    L6:
        if ((this.mDebugPath & 1) != 1) goto L21;
        if (isInEditMode() == true) goto L21;
        this.mFrames++;
        long r100 = getNanoTime();
        long r101 = this.mLastDrawTime;
        if (r101 == (-1)) goto L14;
        long r102 = r100 - r101;
        if (r102 <= 200000000) goto L15;
        this.mLastFps = ((int) ((this.mFrames / (r102 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.mFrames = 0;
        this.mLastDrawTime = r100;
    L15:
        Paint r103 = new Paint();
        r103.setTextSize(42.0f);
        float r104 = ((int) (getProgress() * 1000.0f)) / 10.0f;
        String r105 = this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ";
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        r106.append(Debug.getState(this, this.mEndState));
        r106.append(" (progress: ");
        r106.append(r104);
        r106.append(" ) state=");
        int r107 = this.mCurrentState;
        if (r107 != (-1)) goto L18;
        String r108 = "undefined";
    L19:
        r106.append(r108);
        String r109 = r106.toString();
        r103.setColor(-16777216);
        r110.drawText(r109, 11.0f, getHeight() - 29, r103);
        r103.setColor(-7864184);
        r110.drawText(r109, 10.0f, getHeight() - 30, r103);
        goto L21
    L18:
        r108 = Debug.getState(this, r107);
        goto L19
    L14:
        this.mLastDrawTime = r100;
    L21:
        if (this.mDebugPath > 1) goto L23;
        return;
    L23:
        if (this.mDevModeDraw != null) goto L25;
        this.mDevModeDraw = new DevModeDraw(this);
    L25:
        this.mDevModeDraw.draw(r110, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
    }

    public void evaluate(boolean r210) {
        if (this.mTransitionLastTime != (-1)) goto L5;
        this.mTransitionLastTime = getNanoTime();
    L5:
        float r100 = this.mTransitionLastPosition;
        if (r100 > 0.0f) goto L8;
    L10:
        boolean r101 = true;
        boolean r102 = false;
        if (this.mKeepAnimating == false) goto L13;
    L17:
        float r103 = Math.signum(this.mTransitionGoalPosition - r100);
        long r104 = getNanoTime();
        Interpolator r105 = this.mInterpolator;
        if ((r105 instanceof MotionInterpolator) == true) goto L20;
        float r110 = (((r104 - this.mTransitionLastTime) * r103) * 1.0E-9f) / this.mTransitionDuration;
        this.mLastVelocity = r110;
    L21:
        float r111 = this.mTransitionLastPosition + r110;
        if (this.mTransitionInstantly == false) goto L25;
        r111 = this.mTransitionGoalPosition;
    L25:
        if (r103 <= 0.0f) goto L29;
        if (r111 < this.mTransitionGoalPosition) goto L29;
    L32:
        r111 = this.mTransitionGoalPosition;
        this.mInTransition = false;
        boolean r112 = true;
    L34:
        this.mTransitionLastPosition = r111;
        this.mTransitionPosition = r111;
        this.mTransitionLastTime = r104;
        if (r105 == null) goto L60;
        if (r112 == true) goto L60;
        if (this.mTemporalInterpolator == false) goto L54;
        float r106 = r105.getInterpolation((r104 - this.mAnimationStartTime) * 1.0E-9f);
        this.mTransitionLastPosition = r106;
        this.mTransitionLastTime = r104;
        Interpolator r107 = this.mInterpolator;
        if ((r107 instanceof MotionInterpolator) == false) goto L58;
        float r108 = ((MotionInterpolator) r107).getVelocity();
        this.mLastVelocity = r108;
        if ((Math.abs(r108) * this.mTransitionDuration) > EPSILON) goto L45;
        this.mInTransition = false;
    L45:
        if (r108 <= 0.0f) goto L50;
        if (r106 < 1.0f) goto L50;
        this.mTransitionLastPosition = 1.0f;
        this.mInTransition = false;
        r106 = 1.0f;
    L50:
        if (r108 >= 0.0f) goto L58;
        if (r106 > 0.0f) goto L58;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = false;
        r111 = 0.0f;
    L58:
        r111 = r106;
        goto L60
    L54:
        r106 = r105.getInterpolation(r111);
        Interpolator r109 = this.mInterpolator;
        if ((r109 instanceof MotionInterpolator) == false) goto L57;
        this.mLastVelocity = ((MotionInterpolator) r109).getVelocity();
        goto L58
    L57:
        this.mLastVelocity = ((r109.getInterpolation(r111 + r110) - r106) * r103) / r110;
    L60:
        if (Math.abs(this.mLastVelocity) <= EPSILON) goto L62;
        setState(TransitionState.MOVING);
    L62:
        if (r103 <= 0.0f) goto L66;
        if (r111 < this.mTransitionGoalPosition) goto L66;
    L69:
        r111 = this.mTransitionGoalPosition;
        this.mInTransition = false;
    L71:
        if (r111 < 1.0f) goto L73;
    L74:
        this.mInTransition = false;
        setState(TransitionState.FINISHED);
    L75:
        int r113 = getChildCount();
        this.mKeepAnimating = false;
        long r114 = getNanoTime();
        this.mPostInterpolationPosition = r111;
        int r115 = 0;
    L76:
        if (r115 >= r113) goto L81;
        View r116 = getChildAt(r115);
        MotionController r117 = this.mFrameArrayList.get(r116);
        if (r117 == null) goto L80;
        this.mKeepAnimating = r117.interpolate(r116, r111, r114, this.mKeyCache) | this.mKeepAnimating;
    L80:
        r115 = r115 + 1;
        goto L76
    L81:
        if (r103 <= 0.0f) goto L85;
        if (r111 < this.mTransitionGoalPosition) goto L85;
    L88:
        boolean r118 = true;
    L91:
        if (this.mKeepAnimating == true) goto L97;
        if (this.mInTransition == true) goto L97;
        if (r118 == false) goto L97;
        setState(TransitionState.FINISHED);
    L97:
        if (this.mMeasureDuringTransition == false) goto L99;
        requestLayout();
    L99:
        this.mKeepAnimating = (!r118) | this.mKeepAnimating;
        if (r111 > 0.0f) goto L107;
        int r119 = this.mBeginState;
        if (r119 == (-1)) goto L107;
        if (this.mCurrentState == r119) goto L107;
        this.mCurrentState = r119;
        this.mScene.getConstraintSet(r119).applyCustomAttributes(this);
        setState(TransitionState.FINISHED);
        r102 = true;
    L107:
        if (r111 < 1.0d) goto L112;
        int r120 = this.mCurrentState;
        int r121 = this.mEndState;
        if (r120 == r121) goto L112;
        this.mCurrentState = r121;
        this.mScene.getConstraintSet(r121).applyCustomAttributes(this);
        setState(TransitionState.FINISHED);
        r102 = true;
    L112:
        if (this.mKeepAnimating == false) goto L114;
    L123:
        invalidate();
    L125:
        if (this.mKeepAnimating == true) goto L131;
        if (this.mInTransition == false) goto L131;
        if (r103 <= 0.0f) goto L131;
        if (r111 != 1.0f) goto L131;
    L134:
        onNewStateAttachHandlers();
    L135:
        float r122 = this.mTransitionLastPosition;
        if (r122 < 1.0f) goto L144;
        int r123 = this.mCurrentState;
        int r124 = this.mEndState;
        if (r123 != r124) goto L141;
        r101 = r102;
    L141:
        this.mCurrentState = r124;
    L142:
        r102 = r101;
    L150:
        this.mNeedsFireTransitionCompleted |= r102;
        if (r102 == true) goto L153;
    L155:
        this.mTransitionPosition = this.mTransitionLastPosition;
        return;
    L153:
        if (this.mInLayout == true) goto L155;
        requestLayout();
        goto L155
    L144:
        if (r122 > 0.0f) goto L150;
        int r125 = this.mCurrentState;
        int r126 = this.mBeginState;
        if (r125 != r126) goto L149;
        r101 = r102;
    L149:
        this.mCurrentState = r126;
    L131:
        if (r103 >= 0.0f) goto L135;
        if (r111 != 0.0f) goto L135;
    L114:
        if (this.mInTransition == true) goto L123;
        if (r103 <= 0.0f) goto L119;
        if (r111 != 1.0f) goto L119;
    L122:
        setState(TransitionState.FINISHED);
    L119:
        if (r103 >= 0.0f) goto L125;
        if (r111 != 0.0f) goto L125;
    L85:
        if (r103 <= 0.0f) goto L87;
    L89:
        r118 = false;
        goto L91
    L87:
        if (r111 > this.mTransitionGoalPosition) goto L89;
    L73:
        if (r111 > 0.0f) goto L75;
    L66:
        if (r103 > 0.0f) goto L71;
        if (r111 > this.mTransitionGoalPosition) goto L71;
    L29:
        if (r103 <= 0.0f) goto L31;
    L33:
        r112 = false;
        goto L34
    L31:
        if (r111 > this.mTransitionGoalPosition) goto L33;
    L20:
        r110 = 0.0f;
        goto L21
    L13:
        if (this.mInTransition == false) goto L135;
        if (r210 == true) goto L17;
        if (this.mTransitionGoalPosition == r100) goto L135;
    L8:
        if (r100 >= 1.0f) goto L10;
        this.mCurrentState = -1;
        goto L10
    }

    public ConstraintSet getConstraintSet(int r100) {
        MotionScene r101 = this.mScene;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getConstraintSet(r100);
    }

    public String getConstraintSetNames(int r100) {
        MotionScene r101 = this.mScene;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.lookUpConstraintName(r100);
    }

    public void getDebugMode(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 2;
    L5:
        this.mDebugPath = r101;
        invalidate();
        return;
    L4:
        r101 = 1;
        goto L5
    }

    public MotionScene.Transition getTransition(int r100) {
        return this.mScene.getTransitionById(r100);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int r100) {
        if (r100 != 0) goto L12;
        this.mScene = null;
        return;
    L12:
        this.mScene = new MotionScene(getContext(), this, r100);     // Catch: Exception -> L7
        if (isAttachedToWindow() == false) goto L14;
        this.mScene.readFallback(this);     // Catch: Exception -> L7
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));     // Catch: Exception -> L7
        rebuildScene();     // Catch: Exception -> L7
        this.mScene.setRtl(isRtl());     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);
    }

    public int lookUpConstraintId(String r100) {
        MotionScene r101 = this.mScene;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.lookUpConstraintId(r100);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        MotionScene r101 = this.mScene;
        if (r101 != null) goto L5;
    L35:
        return false;
    L5:
        if (this.mInteractionEnabled == false) goto L35;
        MotionScene.Transition r102 = r101.mCurrentTransition;
        if (r102 == null) goto L35;
        if (r102.isEnabled() == false) goto L35;
        TouchResponse r103 = r102.getTouchResponse();
        if (r103 == null) goto L35;
        if (r100.getAction() != 0) goto L20;
        RectF r104 = r103.getTouchRegion(this, new RectF());
        if (r104 == null) goto L20;
        if (r104.contains(r100.getX(), r100.getY()) == true) goto L20;
        return false;
    L20:
        int r105 = r103.getTouchRegionId();
        if (r105 == (-1)) goto L35;
        View r106 = this.mRegionView;
        if (r106 != null) goto L25;
    L26:
        this.mRegionView = findViewById(r105);
    L27:
        View r107 = this.mRegionView;
        if (r107 == null) goto L35;
        this.mBoundsCheck.set(r107.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
        if (this.mBoundsCheck.contains(r100.getX(), r100.getY()) == false) goto L35;
        if (handlesTouchEvent(0.0f, 0.0f, this.mRegionView, r100) == true) goto L35;
        return onTouchEvent(r100);
    L25:
        if (r106.getId() == r105) goto L27;
        goto L26
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r100) {
        MotionScene r101 = this.mScene;
        if (r101 == null) goto L6;
        r101.setRtl(isRtl());
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        MotionScene r101 = this.mScene;
        if (r101 == null) goto L17;
        if (this.mInteractionEnabled == false) goto L17;
        if (r101.supportTouch() == false) goto L17;
        MotionScene.Transition r102 = this.mScene.mCurrentTransition;
        if (r102 != null) goto L11;
    L14:
        this.mScene.processTouchEvent(r100, getCurrentState(), this);
        return true;
    L11:
        if (r102.isEnabled() == true) goto L14;
        return super.onTouchEvent(r100);
    L17:
        return super.onTouchEvent(r100);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View r100) {
        super.onViewAdded(r100);
        if ((r100 instanceof MotionHelper) == false) goto L20;
        MotionHelper r101 = (MotionHelper) r100;
        if (this.mTransitionListeners != null) goto L7;
        this.mTransitionListeners = new ArrayList();
    L7:
        this.mTransitionListeners.add(r101);
        if (r101.isUsedOnShow() == false) goto L14;
        if (this.mOnShowHelpers != null) goto L12;
        this.mOnShowHelpers = new ArrayList();
    L12:
        this.mOnShowHelpers.add(r101);
    L14:
        if (r101.isUseOnHide() == true) goto L16;
        return;
    L16:
        if (this.mOnHideHelpers != null) goto L18;
        this.mOnHideHelpers = new ArrayList();
    L18:
        this.mOnHideHelpers.add(r101);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        ArrayList<MotionHelper> r101 = this.mOnShowHelpers;
        if (r101 == null) goto L5;
        r101.remove(r100);
    L5:
        ArrayList<MotionHelper> r102 = this.mOnHideHelpers;
        if (r102 == null) goto L9;
        r102.remove(r100);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int r100) {
        this.mConstraintLayoutSpec = null;
    }

    public boolean removeTransitionListener(TransitionListener r100) {
        ArrayList<TransitionListener> r101 = this.mTransitionListeners;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.remove(r100);
    }

    public void setDebugMode(int r100) {
        this.mDebugPath = r100;
        invalidate();
    }

    public void setInteractionEnabled(boolean r100) {
        this.mInteractionEnabled = r100;
    }

    public void setInterpolatedProgress(float r100) {
        if (this.mScene == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r101 = this.mScene.getInterpolator();
        if (r101 == null) goto L8;
        setProgress(r101.getInterpolation(r100));
        return;
    L8:
        setProgress(r100);
    }

    public void setOnHide(float r100) {
        ArrayList<MotionHelper> r101 = this.mOnHideHelpers;
        if (r101 == null) goto L7;
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        ((MotionHelper) ListProtector.get(this.mOnHideHelpers, r103)).setProgress(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r100) {
        ArrayList<MotionHelper> r101 = this.mOnShowHelpers;
        if (r101 == null) goto L7;
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        ((MotionHelper) ListProtector.get(this.mOnShowHelpers, r103)).setProgress(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setProgress(float r100) {
        if (r100 < 0.0f) goto L6;
        int r101 = (r100 > 1.0f ? 1 : (r100 == 1.0f ? 0 : -1));
    L6:
        if (isAttachedToWindow() == false) goto L8;
        if (r100 > 0.0f) goto L17;
        this.mCurrentState = this.mBeginState;
        if (this.mTransitionLastPosition != 0.0f) goto L23;
        setState(TransitionState.FINISHED);
    L23:
        if (this.mScene != null) goto L25;
        return;
    L25:
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = r100;
        this.mTransitionPosition = r100;
        this.mTransitionLastTime = -1;
        this.mAnimationStartTime = -1;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
        return;
    L17:
        if (r100 < 1.0f) goto L21;
        this.mCurrentState = this.mEndState;
        if (this.mTransitionLastPosition != 1.0f) goto L23;
        setState(TransitionState.FINISHED);
        goto L23
    L21:
        this.mCurrentState = -1;
        setState(TransitionState.MOVING);
        goto L23
    L8:
        if (this.mStateCache != null) goto L10;
        this.mStateCache = new StateCache(this);
    L10:
        this.mStateCache.setProgress(r100);
    }

    public void setScene(MotionScene r100) {
        this.mScene = r100;
        r100.setRtl(isRtl());
        rebuildScene();
    }

    public void setState(TransitionState r100) {
        TransitionState r101 = TransitionState.FINISHED;
        if (r100 == r101) goto L5;
    L7:
        TransitionState r102 = this.mTransitionState;
        this.mTransitionState = r100;
        TransitionState r103 = TransitionState.MOVING;
        if (r102 != r103) goto L11;
        if (r100 != r103) goto L11;
        fireTransitionChange();
    L11:
        int r104 = AnonymousClass2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[r102.ordinal()];
        if (r104 != 1) goto L14;
    L20:
        if (r100 != r103) goto L22;
        fireTransitionChange();
    L22:
        if (r100 != r101) goto L27;
        fireTransitionCompleted();
        return;
    L27:
        return;
    L14:
        if (r104 == 2) goto L20;
        if (r104 != 3) goto L28;
        if (r100 != r101) goto L25;
        fireTransitionCompleted();
        return;
    L25:
        return;
    L28:
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L7;
    }

    public void setTransition(int r100) {
        if (this.mScene == null) goto L27;
        MotionScene.Transition r101 = getTransition(r100);
        this.mBeginState = r101.getStartConstraintSetId();
        this.mEndState = r101.getEndConstraintSetId();
        if (isAttachedToWindow() == false) goto L7;
        int r102 = this.mCurrentState;
        float r103 = 0.0f;
        if (r102 != this.mBeginState) goto L15;
        float r104 = 0.0f;
    L18:
        this.mScene.setTransition(r101);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
        if (Float.isNaN(r104) == true) goto L22;
        r103 = r104;
    L22:
        this.mTransitionLastPosition = r103;
        if (Float.isNaN(r104) == false) goto L25;
        Debug.getLocation();
        transitionToStart();
        return;
    L25:
        setProgress(r104);
        return;
    L15:
        if (r102 != this.mEndState) goto L17;
        r104 = 1.0f;
        goto L18
    L17:
        r104 = Float.NaN;
        goto L18
    L7:
        if (this.mStateCache != null) goto L9;
        this.mStateCache = new StateCache(this);
    L9:
        this.mStateCache.setStartState(this.mBeginState);
        this.mStateCache.setEndState(this.mEndState);
        return;
    }

    public void setTransitionDuration(int r100) {
        MotionScene r101 = this.mScene;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDuration(r100);
    }

    public void setTransitionListener(TransitionListener r100) {
        this.mTransitionListener = r100;
    }

    public void setTransitionState(Bundle r100) {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new StateCache(this);
    L5:
        this.mStateCache.setTransitionState(r100);
        if (isAttachedToWindow() == false) goto L9;
        this.mStateCache.apply();
        return;
    }

    public void transitionToState(int r100) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r100, -1, -1);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setEndState(r100);
    }

    public void setTransition(MotionScene.Transition r100) {
        this.mScene.setTransition(r100);
        setState(TransitionState.SETUP);
        if (this.mCurrentState != this.mScene.getEndId()) goto L5;
        this.mTransitionLastPosition = 1.0f;
        this.mTransitionPosition = 1.0f;
        this.mTransitionGoalPosition = 1.0f;
    L7:
        if (r100.isTransitionFlag(1) == false) goto L9;
        long r101 = -1;
    L10:
        this.mTransitionLastTime = r101;
        int r102 = this.mScene.getStartId();
        int r103 = this.mScene.getEndId();
        if (r102 == this.mBeginState) goto L13;
    L15:
        this.mBeginState = r102;
        this.mEndState = r103;
        this.mScene.setTransition(r102, r103);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
        return;
    L13:
        if (r103 != this.mEndState) goto L15;
        return;
    L9:
        r101 = getNanoTime();
        goto L10
    L5:
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        goto L7
    }

    public MotionLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        init(r101);
    }

    private void checkStructure(int r100, ConstraintSet r101) {
        Debug.getName(getContext(), r100);
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L12;
        View r105 = getChildAt(r104);
        int r106 = r105.getId();
        if (r106 == (-1)) goto L9;
    L9:
        if (r101.getConstraint(r106) != null) goto L11;
        Debug.getName(r105);
    L11:
        r104 = r104 + 1;
        goto L4
    L12:
        int[] r107 = r101.getKnownIds();
    L14:
        if (r103 >= r107.length) goto L25;
        int r108 = r107[r103];
        Debug.getName(getContext(), r108);
        if (findViewById(r107[r103]) == null) goto L19;
    L19:
        if (r101.getHeight(r108) == (-1)) goto L22;
    L22:
        if (r101.getWidth(r108) == (-1)) goto L24;
    L24:
        r103 = r103 + 1;
        goto L14
    }

    public void enableTransition(int r100, boolean r101) {
        MotionScene.Transition r102 = getTransition(r100);
        if (r101 == false) goto L6;
        r102.setEnable(true);
        return;
    L6:
        MotionScene r103 = this.mScene;
        if (r102 != r103.mCurrentTransition) goto L14;
        Iterator<MotionScene.Transition> r104 = r103.getTransitionsWithState(this.mCurrentState).iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        MotionScene.Transition r105 = r104.next();
        if (r105.isEnabled() == false) goto L10;
        this.mScene.mCurrentTransition = r105;
    L14:
        r102.setEnable(false);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.mScene != null) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        boolean r102 = false;
        if (this.mLastWidthMeasureSpec == r100) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (this.mNeedsFireTransitionCompleted == false) goto L17;
        this.mNeedsFireTransitionCompleted = false;
        onNewStateAttachHandlers();
        processTransitionCompleted();
        r103 = true;
    L17:
        if (this.mDirtyHierarchy == false) goto L19;
        r103 = true;
    L19:
        this.mLastWidthMeasureSpec = r100;
        this.mLastHeightMeasureSpec = r101;
        int r104 = this.mScene.getStartId();
        int r105 = this.mScene.getEndId();
        if (r103 == true) goto L24;
        if (this.mModel.isNotConfiguredWith(r104, r105) == true) goto L24;
    L26:
        r102 = true;
    L28:
        if (this.mMeasureDuringTransition == true) goto L30;
        if (r102 == true) goto L30;
    L39:
        evaluateLayout();
        return;
    L30:
        int r106 = getPaddingTop() + getPaddingBottom();
        int r107 = this.mLayoutWidget.getWidth() + (getPaddingLeft() + getPaddingRight());
        int r108 = this.mLayoutWidget.getHeight() + r106;
        int r109 = this.mWidthMeasureMode;
        if (r109 == Integer.MIN_VALUE) goto L33;
        if (r109 == 0) goto L33;
    L34:
        int r110 = this.mHeightMeasureMode;
        if (r110 == Integer.MIN_VALUE) goto L37;
        if (r110 == 0) goto L37;
    L38:
        setMeasuredDimension(r107, r108);
    L37:
        int r111 = this.mStartWrapHeight;
        r108 = (int) (r111 + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r111)));
        requestLayout();
    L33:
        int r112 = this.mStartWrapWidth;
        r107 = (int) (r112 + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r112)));
        requestLayout();
    L24:
        if (this.mBeginState == (-1)) goto L26;
        super.onMeasure(r100, r101);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(r104), this.mScene.getConstraintSet(r105));
        this.mModel.reEvaluateState();
        this.mModel.setMeasuredId(r104, r105);
        goto L28
    L9:
        if (this.mLastHeightMeasureSpec != r101) goto L12;
        r103 = false;
        goto L14
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r100, int r101) {
        MotionScene r102 = this.mScene;
        if (r102 != null) goto L5;
        return;
    L5:
        float r103 = this.mScrollTargetDX;
        float r104 = this.mScrollTargetDT;
        r102.processScrollUp(r103 / r104, this.mScrollTargetDY / r104);
    }

    public void setProgress(float r100, float r101) {
        if (isAttachedToWindow() == false) goto L5;
        setProgress(r100);
        setState(TransitionState.MOVING);
        this.mLastVelocity = r101;
        animateTo(1.0f);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setProgress(r100);
        this.mStateCache.setVelocity(r101);
    }

    public void setTransition(int r100, int r101) {
        if (isAttachedToWindow() == false) goto L5;
        MotionScene r102 = this.mScene;
        if (r102 == null) goto L13;
        this.mBeginState = r100;
        this.mEndState = r101;
        r102.setTransition(r100, r101);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(r100), this.mScene.getConstraintSet(r101));
        rebuildScene();
        this.mTransitionLastPosition = 0.0f;
        transitionToStart();
        return;
    L13:
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setStartState(r100);
        this.mStateCache.setEndState(r101);
    }

    public void updateState(int r100, ConstraintSet r101) {
        MotionScene r102 = this.mScene;
        if (r102 == null) goto L5;
        r102.setConstraintSet(r100, r101);
    L5:
        updateState();
        if (this.mCurrentState != r100) goto L9;
        r101.applyTo(this);
        return;
    }

    public MotionLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        init(r101);
    }

    private void fireTransitionStarted(MotionLayout r100, int r101, int r102) {
        TransitionListener r103 = this.mTransitionListener;
        if (r103 == null) goto L5;
        r103.onTransitionStarted(this, r101, r102);
    L5:
        ArrayList<TransitionListener> r104 = this.mTransitionListeners;
        if (r104 == null) goto L11;
        Iterator<TransitionListener> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        r105.next().onTransitionStarted(r100, r101, r102);
        goto L9
    L13:
        return;
    }

    public void fireTrigger(int r100, boolean r101, float r102) {
        TransitionListener r103 = this.mTransitionListener;
        if (r103 == null) goto L5;
        r103.onTransitionTrigger(this, r100, r101, r102);
    L5:
        ArrayList<TransitionListener> r104 = this.mTransitionListeners;
        if (r104 == null) goto L11;
        Iterator<TransitionListener> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        r105.next().onTransitionTrigger(this, r100, r101, r102);
        goto L9
    L13:
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int r100, int r101, int r102) {
        setState(TransitionState.SETUP);
        this.mCurrentState = r100;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates r103 = this.mConstraintLayoutSpec;
        if (r103 == null) goto L5;
        r103.updateConstraints(r100, r101, r102);
        return;
    L5:
        MotionScene r104 = this.mScene;
        if (r104 == null) goto L10;
        r104.getConstraintSet(r100).applyTo(this);
        return;
    }

    public void touchAnimateTo(int r110, float r111, float r112) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mTransitionLastPosition != r111) goto L8;
        return;
    L8:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        float r100 = this.mScene.getDuration() / 1000.0f;
        this.mTransitionDuration = r100;
        this.mTransitionGoalPosition = r111;
        this.mInTransition = true;
        if (r110 == 0) goto L22;
        if (r110 == 1) goto L22;
        if (r110 == 2) goto L22;
        if (r110 != 4) goto L15;
        this.mDecelerateLogic.config(r112, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
        this.mInterpolator = this.mDecelerateLogic;
    L27:
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
        return;
    L15:
        if (r110 != 5) goto L27;
        if (willJump(r112, this.mTransitionLastPosition, this.mScene.getMaxAcceleration()) == false) goto L20;
        this.mDecelerateLogic.config(r112, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
        this.mInterpolator = this.mDecelerateLogic;
        goto L27
    L20:
        this.mStopLogic.config(this.mTransitionLastPosition, r111, r112, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
        this.mLastVelocity = 0.0f;
        int r113 = this.mCurrentState;
        this.mTransitionGoalPosition = r111;
        this.mCurrentState = r113;
        this.mInterpolator = this.mStopLogic;
    L22:
        if (r110 != 1) goto L24;
        r111 = 0.0f;
    L26:
        this.mStopLogic.config(this.mTransitionLastPosition, r111, r112, r100, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
        int r114 = this.mCurrentState;
        this.mTransitionGoalPosition = r111;
        this.mCurrentState = r114;
        this.mInterpolator = this.mStopLogic;
        goto L27
    L24:
        if (r110 != 2) goto L26;
        r111 = 1.0f;
        goto L26
    }

    public void transitionToState(int r110, int r111, int r112) {
        MotionScene r100 = this.mScene;
        if (r100 == null) goto L9;
        StateSet r101 = r100.mStateSet;
        if (r101 == null) goto L9;
        int r113 = r101.convertToConstraintSet(this.mCurrentState, r110, r111, r112);
        if (r113 == (-1)) goto L9;
        r110 = r113;
    L9:
        int r114 = this.mCurrentState;
        if (r114 != r110) goto L13;
        return;
    L13:
        if (this.mBeginState != r110) goto L17;
        animateTo(0.0f);
        return;
    L17:
        if (this.mEndState != r110) goto L20;
        animateTo(1.0f);
        return;
    L20:
        this.mEndState = r110;
        if (r114 == (-1)) goto L24;
        setTransition(r114, r110);
        animateTo(1.0f);
        this.mTransitionLastPosition = 0.0f;
        transitionToEnd();
        return;
    L24:
        int r115 = 0;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        this.mScene.getStartId();
        int r102 = getChildCount();
        this.mFrameArrayList.clear();
        int r103 = 0;
    L25:
        if (r103 >= r102) goto L27;
        View r104 = getChildAt(r103);
        this.mFrameArrayList.put(r104, new MotionController(r104));
        r103 = r103 + 1;
        goto L25
    L27:
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(r110));
        rebuildScene();
        this.mModel.build();
        computeCurrentPositions();
        int r116 = getWidth();
        int r117 = getHeight();
        int r118 = 0;
    L28:
        if (r118 >= r102) goto L30;
        MotionController r105 = this.mFrameArrayList.get(getChildAt(r118));
        this.mScene.getKeyFrames(r105);
        r105.setup(r116, r117, this.mTransitionDuration, getNanoTime());
        r118 = r118 + 1;
        goto L28
    L30:
        float r119 = this.mScene.getStaggered();
        if (r119 == 0.0f) goto L37;
        float r120 = Float.MAX_VALUE;
        float r106 = -3.4028235E38f;
        int r107 = 0;
    L33:
        if (r107 >= r102) goto L35;
        MotionController r108 = this.mFrameArrayList.get(getChildAt(r107));
        float r109 = r108.getFinalY() + r108.getFinalX();
        r120 = Math.min(r120, r109);
        r106 = Math.max(r106, r109);
        r107 = r107 + 1;
    L35:
        if (r115 >= r102) goto L37;
        MotionController r121 = this.mFrameArrayList.get(getChildAt(r115));
        float r122 = r121.getFinalX();
        float r123 = r121.getFinalY();
        r121.mStaggerScale = 1.0f / (1.0f - r119);
        r121.mStaggerOffset = r119 - ((((r122 + r123) - r120) * r119) / (r106 - r120));
        r115 = r115 + 1;
    L37:
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
    }

    private boolean handlesTouchEvent(float r100, float r110, View r111, MotionEvent r112) {
        if ((r111 instanceof ViewGroup) == false) goto L10;
        ViewGroup r101 = (ViewGroup) r111;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        if (handlesTouchEvent(r111.getLeft() + r100, r111.getTop() + r110, r101.getChildAt(r103), r112) == true) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return true;
    L10:
        this.mBoundsCheck.set(r111.getLeft() + r100, r111.getTop() + r110, r100 + r111.getRight(), r110 + r111.getBottom());
        if (r112.getAction() != 0) goto L18;
        if (this.mBoundsCheck.contains(r112.getX(), r112.getY()) == true) goto L15;
    L20:
        return false;
    L15:
        if (r111.onTouchEvent(r112) == false) goto L20;
        return true;
    L18:
        if (r111.onTouchEvent(r112) == false) goto L20;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        MotionScene r104 = this.mScene;
        if (r104 == null) goto L13;
        MotionScene.Transition r105 = r104.mCurrentTransition;
        if (r105 != null) goto L7;
        return false;
    L7:
        if (r105.getTouchResponse() != null) goto L9;
        return false;
    L9:
        if ((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    L13:
        return false;
    }

    public static /* synthetic */ void access$1200(MotionLayout r100, ConstraintWidgetContainer r101, int r102, int r103, int r104) {
        r100.resolveSystem(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$1300(MotionLayout r100, ConstraintWidgetContainer r101, int r102, int r103, int r104) {
        r100.resolveSystem(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$1400(MotionLayout r100, ConstraintWidgetContainer r101, int r102, int r103, int r104) {
        r100.resolveSystem(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$1500(MotionLayout r100, ConstraintWidgetContainer r101, int r102, int r103, int r104) {
        r100.resolveSystem(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$1600(MotionLayout r100, ConstraintWidgetContainer r101, int r102, int r103, int r104) {
        r100.resolveSystem(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$1700(MotionLayout r100, ConstraintWidgetContainer r101, int r102, int r103, int r104) {
        r100.resolveSystem(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$1800(MotionLayout r100, ConstraintWidgetContainer r101, int r102, int r103, int r104) {
        r100.resolveSystem(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$1900(MotionLayout r100, ConstraintWidgetContainer r101, int r102, int r103, int r104) {
        r100.resolveSystem(r101, r102, r103, r104);
    }

    public void getAnchorDpDt(int r100, float r101, float r102, float r103, float[] r104) {
        HashMap<View, MotionController> r105 = this.mFrameArrayList;
        View r106 = getViewById(r100);
        MotionController r107 = r105.get(r106);
        if (r107 == null) goto L5;
        r107.getDpDt(r101, r102, r103, r104);
        float r108 = r106.getY();
        this.lastPos = r101;
        this.lastY = r108;
        return;
    L5:
        if (r106 != null) goto L7;
        new StringBuilder("").append(r100);
    L9:
        return;
    L7:
        r106.getContext().getResources().getResourceName(r100);
        goto L9
    }

    public void getViewVelocity(View r100, float r110, float r111, float[] r112, int r113) {
        float r101 = this.mLastVelocity;
        float r102 = this.mTransitionLastPosition;
        if (this.mInterpolator == null) goto L5;
        float r103 = Math.signum(this.mTransitionGoalPosition - r102);
        float r104 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
        float r105 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
        r101 = (r103 * ((r104 - r105) / EPSILON)) / this.mTransitionDuration;
    L6:
        Interpolator r106 = this.mInterpolator;
        if ((r106 instanceof MotionInterpolator) == false) goto L9;
        r101 = ((MotionInterpolator) r106).getVelocity();
    L9:
        MotionController r107 = this.mFrameArrayList.get(r100);
        if ((r113 & 1) != 0) goto L12;
        r107.getPostLayoutDvDp(r105, r100.getWidth(), r100.getHeight(), r110, r111, r112);
    L14:
        if (r113 >= 2) goto L17;
        r112[0] = r112[0] * r101;
        r112[1] = r112[1] * r101;
        return;
    L17:
        return;
    L12:
        r107.getDpDt(r105, r110, r111, r112);
        goto L14
    L5:
        r105 = r102;
        goto L6
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        this.mInLayout = true;
    L17:
        th = move-exception;
        this.mInLayout = false;
        throw th;
    L4:
        if (this.mScene != null) goto L8;
        super.onLayout(r100, r101, r102, r103, r104);     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L8:
        int r105 = r103 - r101;
        int r106 = r104 - r102;
        if (this.mLastLayoutWidth == r105) goto L12;
    L13:
        rebuildScene();     // Catch: Throwable -> L17
        evaluate(true);     // Catch: Throwable -> L17
    L14:
        this.mLastLayoutWidth = r105;     // Catch: Throwable -> L17
        this.mLastLayoutHeight = r106;     // Catch: Throwable -> L17
        this.mOldWidth = r105;     // Catch: Throwable -> L17
        this.mOldHeight = r106;     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L12:
        if (this.mLastLayoutHeight == r106) goto L14;
        goto L13
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View r110, int r111, int r112, int[] r113, int r114) {
        MotionScene r115 = this.mScene;
        if (r115 == null) goto L55;
        MotionScene.Transition r116 = r115.mCurrentTransition;
        if (r116 != null) goto L8;
        return;
    L8:
        if (r116.isEnabled() == true) goto L10;
        return;
    L10:
        MotionScene.Transition r117 = this.mScene.mCurrentTransition;
        if (r117 != null) goto L13;
    L21:
        MotionScene r100 = this.mScene;
        if (r100 == null) goto L33;
        if (r100.getMoveWhenScrollAtTop() == false) goto L33;
        float r101 = this.mTransitionPosition;
        if (r101 == 1.0f) goto L30;
        if (r101 != 0.0f) goto L33;
    L30:
        if (r110.canScrollVertically(-1) == false) goto L33;
        return;
    L33:
        if (r117.getTouchResponse() != null) goto L35;
    L46:
        float r118 = this.mTransitionPosition;
        long r102 = getNanoTime();
        float r119 = r111;
        this.mScrollTargetDX = r119;
        float r103 = r112;
        this.mScrollTargetDY = r103;
        this.mScrollTargetDT = (float) ((r102 - this.mScrollTargetTime) * 1.0E-9d);
        this.mScrollTargetTime = r102;
        this.mScene.processScrollMove(r119, r103);
        if (r118 == this.mTransitionPosition) goto L49;
        r113[0] = r111;
        r113[1] = r112;
    L49:
        evaluate(false);
        if (r113[0] == 0) goto L52;
    L53:
        this.mUndergoingMotion = true;
        return;
    L52:
        if (r113[1] != 0) goto L53;
        return;
    L35:
        if ((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) == 0) goto L46;
        float r120 = this.mScene.getProgressDirection(r111, r112);
        float r104 = this.mTransitionLastPosition;
        if (r104 > 0.0f) goto L41;
        if (r120 >= 0.0f) goto L41;
    L44:
        r110.setNestedScrollingEnabled(false);
        r110.post(new AnonymousClass1(this, r110));
        return;
    L41:
        if (r104 < 1.0f) goto L46;
        if (r120 <= 0.0f) goto L46;
    L13:
        if (r117.isEnabled() == false) goto L21;
        TouchResponse r105 = r117.getTouchResponse();
        if (r105 == null) goto L21;
        int r106 = r105.getTouchRegionId();
        if (r106 == (-1)) goto L21;
        if (r110.getId() == r106) goto L21;
        return;
    }

    public static /* synthetic */ void access$800(MotionLayout r100, boolean r101, View r102, ConstraintWidget r103, ConstraintLayout.LayoutParams r104, SparseArray r105) {
        r100.applyConstraintsFromLayoutParams(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void access$2000(MotionLayout r100, int r101, int r102, int r103, int r104, boolean r105, boolean r106) {
        r100.resolveMeasuredDimension(r101, r102, r103, r104, r105, r106);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        if (this.mUndergoingMotion == true) goto L6;
        if (r101 != 0) goto L6;
        if (r102 != 0) goto L6;
    L7:
        this.mUndergoingMotion = false;
        return;
    L6:
        r106[0] = r106[0] + r103;
        r106[1] = r106[1] + r104;
        goto L7
    }
}

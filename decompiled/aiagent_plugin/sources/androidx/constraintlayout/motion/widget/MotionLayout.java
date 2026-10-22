package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements androidx.core.view.r {
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
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
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
    private ArrayList<MotionHelper> mDecoratorsHelpers;
    private boolean mDelayedApply;
    private androidx.constraintlayout.motion.widget.b mDesignTool;
    a mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, m> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    private boolean mInRotation;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    private Matrix mInverseMatrix;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private androidx.constraintlayout.a.a.a.d mKeyCache;
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
    b mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private Runnable mOnComplete;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    HashMap<View, androidx.constraintlayout.motion.utils.d> mPreRotate;
    private int mPreRotateHeight;
    private int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator;
    private View mRegionView;
    int mRotatMode;
    MotionScene mScene;
    private int[] mScheduledTransitionTo;
    int mScheduledTransitions;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private e mStateCache;
    private StopLogic mStopLogic;
    Rect mTempRect;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private f mTransitionListener;
    private CopyOnWriteArrayList<f> mTransitionListeners;
    float mTransitionPosition;
    g mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f840a = null;

        static {
            int[] r0 = new int[g.values().length];
            f840a = r0;
            r0[g.f858a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f840a[g.f859b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f840a[g.f860c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f840a[g.f861d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    class DecelerateInterpolator extends MotionInterpolator {
        float currentP;
        float initalV;
        float maxA;
        final /* synthetic */ MotionLayout this$0;

        DecelerateInterpolator(MotionLayout r1) {
            this.this$0 = r1;
            this.initalV = 0.0f;
            this.currentP = 0.0f;
        }

        public void config(float r1, float r2, float r3) {
            this.initalV = r1;
            this.currentP = r2;
            this.maxA = r3;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float r5) {
            float r0 = this.initalV;
            if (r0 <= 0.0f) goto L10;
            float r1 = this.maxA;
            if ((r0 / r1) >= r5) goto L7;
            r5 = r0 / r1;
        L7:
            float r2 = r0 - (r1 * r5);
            this.this$0.mLastVelocity = r2;
            float r3 = (this.initalV * r5) - (((this.maxA * r5) * r5) / 2.0f);
            float r4 = this.currentP;
        L9:
            return r3 + r4;
        L10:
            float r6 = this.maxA;
            if (((-r0) / r6) >= r5) goto L13;
            r5 = (-r0) / r6;
        L13:
            float r7 = r0 + (r6 * r5);
            this.this$0.mLastVelocity = r7;
            r3 = (this.initalV * r5) + (((this.maxA * r5) * r5) / 2.0f);
            r4 = this.currentP;
            goto L9
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return this.this$0.mLastVelocity;
        }
    }

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float[] f841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int[] f842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float[] f843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Path f844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f845e;
        Paint f;
        Paint g;
        Paint h;
        Paint i;
        final int j;
        final int k;
        final int l;
        final int m;
        final int n;
        DashPathEffect o;
        int p;
        Rect q;
        boolean r;
        int s;
        final /* synthetic */ MotionLayout t;
        private float[] u;

        public a(MotionLayout r7) {
            this.t = r7;
            this.j = -21965;
            this.k = -2067046;
            this.l = -13391360;
            this.m = 1996488704;
            this.n = 10;
            this.q = new Rect();
            this.r = false;
            this.s = 1;
            Paint r4 = new Paint();
            this.f845e = r4;
            r4.setAntiAlias(true);
            this.f845e.setColor(-21965);
            this.f845e.setStrokeWidth(2.0f);
            this.f845e.setStyle(Paint.Style.STROKE);
            Paint r0 = new Paint();
            this.f = r0;
            r0.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(Paint.Style.STROKE);
            Paint r1 = new Paint();
            this.g = r1;
            r1.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(Paint.Style.STROKE);
            Paint r2 = new Paint();
            this.h = r2;
            r2.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density * 12.0f);
            this.u = new float[8];
            Paint r8 = new Paint();
            this.i = r8;
            r8.setAntiAlias(true);
            DashPathEffect r9 = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.o = r9;
            this.g.setPathEffect(r9);
            this.f843c = new float[100];
            this.f842b = new int[50];
            if (this.r == false) goto L6;
            this.f845e.setStrokeWidth(8.0f);
            this.i.setStrokeWidth(8.0f);
            this.f.setStrokeWidth(8.0f);
            this.s = 4;
            return;
        }

        public void a(Canvas r7, HashMap<View, m> r8, int r9, int r10) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (r8.size() == 0) goto L42;
            r7.save();
            if (this.t.isInEditMode() == false) goto L9;
        L11:
            Iterator<m> r11 = r8.values().iterator();
        L13:
            if (r11.hasNext() == false) goto L30;
            m r0 = (m) ZeusTransformUtils.preCheckCast(r11.next(), m.class, "com.obric.aiagent.plugin");
            int r2 = r0.j();
            if (r10 <= 0) goto L18;
            if (r2 != 0) goto L18;
            r2 = 1;
        L18:
            if (r2 == 0) goto L13;
            this.p = r0.a(this.f843c, this.f842b);
            if (r2 < 1) goto L13;
            int r3 = r9 / 16;
            float[] r4 = this.f841a;
            if (r4 != null) goto L25;
        L26:
            this.f841a = new float[r3 * 2];
            this.f844d = new Path();
        L27:
            int r5 = this.s;
            r7.translate(r5, r5);
            this.f845e.setColor(1996488704);
            this.i.setColor(1996488704);
            this.f.setColor(1996488704);
            this.g.setColor(1996488704);
            r0.a(this.f841a, r3);
            a(r7, r2, this.p, r0);
            this.f845e.setColor(-21965);
            this.f.setColor(-2067046);
            this.i.setColor(-2067046);
            this.g.setColor(-13391360);
            int r6 = this.s;
            r7.translate(-r6, -r6);
            a(r7, r2, this.p, r0);
            if (r2 != 5) goto L13;
            a(r7, r0);
            goto L13
        L25:
            if (r4.length == (r3 * 2)) goto L27;
        L30:
            r7.restore();
            return;
        L9:
            if ((r10 & 1) != 2) goto L11;
            String r1 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.t.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getResourceName(MotionLayout.access$100(this.t)) + ":" + this.t.getProgress();
            r7.drawText(r1, 10.0f, this.t.getHeight() - 30, this.h);
            r7.drawText(r1, 11.0f, this.t.getHeight() - 29, this.f845e);
            goto L11
        }

        public void a(Canvas r2, int r3, int r4, m r5) {
            if (r3 != 4) goto L6;
            c(r2);
        L6:
            if (r3 != 2) goto L9;
            b(r2);
        L9:
            if (r3 != 3) goto L11;
            d(r2);
        L11:
            a(r2);
            b(r2, r3, r4, r5);
        }

        private void a(Canvas r2) {
            r2.drawLines(this.f841a, this.f845e);
        }

        private void b(Canvas r20, int r21, int r22, m r23) {
            if (r23.f897b == null) goto L5;
            int r11 = r23.f897b.getWidth();
            int r12 = r23.f897b.getHeight();
        L6:
            int r14 = 1;
        L8:
            if (r14 >= (r22 - 1)) goto L38;
            if (r21 == 4) goto L12;
        L14:
            float[] r1 = this.f843c;
            int r2 = r14 * 2;
            float r5 = r1[r2];
            float r4 = r1[r2 + 1];
            this.f844d.reset();
            this.f844d.moveTo(r5, r4 + 10.0f);
            this.f844d.lineTo(r5 + 10.0f, r4);
            this.f844d.lineTo(r5, r4 - 10.0f);
            this.f844d.lineTo(r5 - 10.0f, r4);
            this.f844d.close();
            int r3 = r14 - 1;
            r23.a(r3);
            if (r21 != 4) goto L27;
            int[] r0 = this.f842b;
            if (r0[r3] != 1) goto L21;
            a(r20, r5 - 0.0f, r4 - 0.0f);
        L26:
            r20.drawPath(this.f844d, this.i);
        L28:
            if (r21 != 2) goto L31;
            a(r20, r5 - 0.0f, r4 - 0.0f);
        L31:
            if (r21 != 3) goto L34;
            b(r20, r5 - 0.0f, r4 - 0.0f);
        L34:
            if (r21 != 6) goto L36;
            a(r20, r5 - 0.0f, r4 - 0.0f, r11, r12);
        L36:
            r20.drawPath(this.f844d, this.i);
        L37:
            r14 = r14 + 1;
            goto L8
        L21:
            if (r0[r3] != 0) goto L24;
            b(r20, r5 - 0.0f, r4 - 0.0f);
            goto L26
        L24:
            if (r0[r3] != 2) goto L26;
            a(r20, r5 - 0.0f, r4 - 0.0f, r11, r12);
            goto L26
        L27:
            r4 = r4;
            r5 = r5;
            goto L28
        L12:
            if (this.f842b[r14 - 1] != 0) goto L14;
        L38:
            float[] r6 = this.f841a;
            if (r6.length <= 1) goto L45;
            r20.drawCircle(r6[0], r6[1], 8.0f, this.f);
            float[] r7 = this.f841a;
            r20.drawCircle(r7[r7.length - 2], r7[r7.length - 1], 8.0f, this.f);
            return;
        L45:
            return;
        L5:
            r11 = 0;
            r12 = 0;
            goto L6
        }

        private void a(Canvas r8, float r9, float r10, float r11, float r12) {
            r8.drawRect(r9, r10, r11, r12, this.g);
            r8.drawLine(r9, r10, r11, r12, this.g);
        }

        private void b(Canvas r9) {
            float[] r0 = this.f841a;
            r9.drawLine(r0[0], r0[1], r0[r0.length - 2], r0[r0.length - 1], this.g);
        }

        private void c(Canvas r7) {
            int r0 = 0;
            boolean r1 = false;
            boolean r2 = false;
        L4:
            if (r0 >= this.p) goto L12;
            int[] r3 = this.f842b;
            if (r3[r0] != 1) goto L9;
            r1 = true;
        L9:
            if (r3[r0] != 0) goto L11;
            r2 = true;
        L11:
            r0 = r0 + 1;
            goto L4
        L12:
            if (r1 == false) goto L14;
            b(r7);
        L14:
            if (r2 == false) goto L20;
            d(r7);
            return;
        }

        private void a(Canvas r13, float r14, float r15) {
            float[] r0 = this.f841a;
            float r1 = r0[0];
            float r3 = r0[1];
            float r4 = r0[r0.length - 2];
            float r2 = r0[r0.length - 1];
            float r5 = (float) Math.hypot(r1 - r4, r3 - r2);
            float r6 = r4 - r1;
            float r7 = r2 - r3;
            float r8 = (((r14 - r1) * r6) + ((r15 - r3) * r7)) / (r5 * r5);
            float r9 = r1 + (r6 * r8);
            float r10 = r3 + (r8 * r7);
            Path r11 = new Path();
            r11.moveTo(r14, r15);
            r11.lineTo(r9, r10);
            float r12 = (float) Math.hypot(r9 - r14, r10 - r15);
            String r16 = "" + (((int) ((r12 * 100.0f) / r5)) / 100.0f);
            a(r16, this.h);
            r13.drawTextOnPath(r16, r11, (r12 / 2.0f) - (this.q.width() / 2), -20.0f, this.h);
            r13.drawLine(r14, r15, r9, r10, this.g);
        }

        void a(String r3, Paint r4) {
            r4.getTextBounds(r3, 0, r3.length(), this.q);
        }

        private void d(Canvas r19) {
            float[] r1 = this.f841a;
            float r2 = r1[0];
            float r4 = r1[1];
            float r5 = r1[r1.length - 2];
            float r3 = r1[r1.length - 1];
            r19.drawLine(Math.min(r2, r5), Math.max(r4, r3), Math.max(r2, r5), Math.max(r4, r3), this.g);
            r19.drawLine(Math.min(r2, r5), Math.min(r4, r3), Math.min(r2, r5), Math.max(r4, r3), this.g);
        }

        private void b(Canvas r19, float r20, float r21) {
            float[] r1 = this.f841a;
            float r2 = r1[0];
            float r8 = r1[1];
            float r4 = r1[r1.length - 2];
            float r9 = r1[r1.length - 1];
            float r3 = Math.min(r2, r4);
            float r10 = Math.max(r8, r9);
            float r5 = r20 - Math.min(r2, r4);
            float r11 = Math.max(r8, r9) - r21;
            String r6 = "" + (((int) (((double) ((r5 * 100.0f) / Math.abs(r4 - r2))) + 0.5d)) / 100.0f);
            a(r6, this.h);
            r19.drawText(r6, ((r5 / 2.0f) - (this.q.width() / 2)) + r3, r21 - 20.0f, this.h);
            r19.drawLine(r20, r21, Math.min(r2, r4), r21, this.g);
            String r7 = "" + (((int) (((double) ((r11 * 100.0f) / Math.abs(r9 - r8))) + 0.5d)) / 100.0f);
            a(r7, this.h);
            r19.drawText(r7, r20 + 5.0f, r10 - ((r11 / 2.0f) - (this.q.height() / 2)), this.h);
            r19.drawLine(r20, r21, r20, Math.max(r8, r9), this.g);
        }

        private void a(Canvas r16, float r17, float r18, int r19, int r20) {
            String r1 = "" + (((int) (((double) (((r17 - (r19 / 2)) * 100.0f) / (this.t.getWidth() - r19))) + 0.5d)) / 100.0f);
            a(r1, this.h);
            r16.drawText(r1, ((r17 / 2.0f) - (this.q.width() / 2)) + 0.0f, r18 - 20.0f, this.h);
            r16.drawLine(r17, r18, Math.min(0.0f, 1.0f), r18, this.g);
            String r2 = "" + (((int) (((double) (((r18 - (r20 / 2)) * 100.0f) / (this.t.getHeight() - r20))) + 0.5d)) / 100.0f);
            a(r2, this.h);
            r16.drawText(r2, r17 + 5.0f, 0.0f - ((r18 / 2.0f) - (this.q.height() / 2)), this.h);
            r16.drawLine(r17, r18, r17, Math.max(0.0f, 1.0f), this.g);
        }

        private void a(Canvas r7, m r8) {
            this.f844d.reset();
            int r1 = 0;
        L4:
            if (r1 > 50) goto L6;
            r8.a(r1 / 50, this.u, 0);
            Path r2 = this.f844d;
            float[] r3 = this.u;
            r2.moveTo(r3[0], r3[1]);
            Path r4 = this.f844d;
            float[] r5 = this.u;
            r4.lineTo(r5[2], r5[3]);
            Path r6 = this.f844d;
            float[] r9 = this.u;
            r6.lineTo(r9[4], r9[5]);
            Path r10 = this.f844d;
            float[] r11 = this.u;
            r10.lineTo(r11[6], r11[7]);
            this.f844d.close();
            r1 = r1 + 1;
            goto L4
        L6:
            this.f845e.setColor(1140850688);
            r7.translate(2.0f, 2.0f);
            r7.drawPath(this.f844d, this.f845e);
            r7.translate(-2.0f, -2.0f);
            this.f845e.setColor(-65536);
            r7.drawPath(this.f844d, this.f845e);
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.constraintlayout.a.c.f f846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.constraintlayout.a.c.f f847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        androidx.constraintlayout.widget.c f848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        androidx.constraintlayout.widget.c f849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f850e;
        int f;
        final /* synthetic */ MotionLayout g;

        b(MotionLayout r1) {
            this.g = r1;
            this.f846a = new androidx.constraintlayout.a.c.f();
            this.f847b = new androidx.constraintlayout.a.c.f();
            this.f848c = null;
            this.f849d = null;
        }

        void a(androidx.constraintlayout.a.c.f r5, androidx.constraintlayout.a.c.f r6) {
            ArrayList<androidx.constraintlayout.a.c.e> r4 = r5.ak();
            HashMap<androidx.constraintlayout.a.c.e, androidx.constraintlayout.a.c.e> r0 = new HashMap();
            r0.put(r5, r6);
            r6.ak().clear();
            r6.a(r5, r0);
            Iterator<androidx.constraintlayout.a.c.e> r7 = r4.iterator();
        L4:
            if (r7.hasNext() == false) goto L22;
            androidx.constraintlayout.a.c.e r1 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r7.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, androidx.constraintlayout.a.c.a.class) == false) goto L9;
            androidx.constraintlayout.a.c.e r2 = new androidx.constraintlayout.a.c.a();
        L21:
            r6.b(r2);
            r0.put(r1, r2);
            goto L4
        L9:
            if (ZeusTransformUtils.instanceOf(r1, androidx.constraintlayout.a.c.h.class) == false) goto L12;
            r2 = new androidx.constraintlayout.a.c.h();
            goto L21
        L12:
            if (ZeusTransformUtils.instanceOf(r1, androidx.constraintlayout.a.c.g.class) == false) goto L15;
            r2 = new androidx.constraintlayout.a.c.g();
            goto L21
        L15:
            if (ZeusTransformUtils.instanceOf(r1, androidx.constraintlayout.a.c.l.class) == false) goto L18;
            r2 = new androidx.constraintlayout.a.c.l();
            goto L21
        L18:
            if (ZeusTransformUtils.instanceOf(r1, androidx.constraintlayout.a.c.i.class) == false) goto L20;
            r2 = new androidx.constraintlayout.a.c.j();
            goto L21
        L20:
            r2 = new androidx.constraintlayout.a.c.e();
            goto L21
        L22:
            Iterator<androidx.constraintlayout.a.c.e> r8 = r4.iterator();
        L24:
            if (r8.hasNext() == false) goto L26;
            androidx.constraintlayout.a.c.e r9 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r8.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
            ((androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.get(r9), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).a(r9, r0);
            goto L24
        }

        void a(androidx.constraintlayout.a.c.f r5, androidx.constraintlayout.widget.c r6, androidx.constraintlayout.widget.c r7) {
            this.f848c = r6;
            this.f849d = r7;
            this.f846a = new androidx.constraintlayout.a.c.f();
            this.f847b = new androidx.constraintlayout.a.c.f();
            this.f846a.a(MotionLayout.access$400(this.g).g());
            this.f847b.a(MotionLayout.access$500(this.g).g());
            this.f846a.al();
            this.f847b.al();
            a(MotionLayout.access$600(this.g), this.f846a);
            a(MotionLayout.access$700(this.g), this.f847b);
            if (this.g.mTransitionLastPosition <= 0.5d) goto L7;
            if (r6 == null) goto L6;
            a(this.f846a, r6);
        L6:
            a(this.f847b, r7);
        L10:
            this.f846a.h(MotionLayout.access$800(this.g));
            this.f846a.f();
            this.f847b.h(MotionLayout.access$900(this.g));
            this.f847b.f();
            ViewGroup.LayoutParams r8 = this.g.getLayoutParams();
            if (r8 != null) goto L13;
            return;
        L13:
            if (r8.width != (-2)) goto L16;
            this.f846a.a(androidx.constraintlayout.a.c.e.a.f776b);
            this.f847b.a(androidx.constraintlayout.a.c.e.a.f776b);
        L16:
            if (r8.height != (-2)) goto L20;
            this.f846a.b(androidx.constraintlayout.a.c.e.a.f776b);
            this.f847b.b(androidx.constraintlayout.a.c.e.a.f776b);
            return;
        L20:
            return;
        L7:
            a(this.f847b, r7);
            if (r6 == null) goto L10;
            a(this.f846a, r6);
            goto L10
        }

        private void a(androidx.constraintlayout.a.c.f r18, androidx.constraintlayout.widget.c r19) {
            SparseArray<androidx.constraintlayout.a.c.e> r9 = new SparseArray();
            Constraints.LayoutParams r10 = new Constraints.LayoutParams(-2, -2);
            r9.clear();
            r9.put(0, r18);
            r9.put(this.g.getId(), r18);
            if (r19 != null) goto L5;
        L7:
            Iterator<androidx.constraintlayout.a.c.e> r3 = r18.ak().iterator();
        L9:
            if (r3.hasNext() == false) goto L11;
            androidx.constraintlayout.a.c.e r4 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r3.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
            r4.f(true);
            r9.put(((View) ZeusTransformUtils.preCheckCast(r4.T(), View.class, "com.obric.aiagent.plugin")).getId(), r4);
            goto L9
        L11:
            Iterator<androidx.constraintlayout.a.c.e> r14 = r18.ak().iterator();
        L13:
            if (r14.hasNext() == false) goto L27;
            androidx.constraintlayout.a.c.e r15 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r14.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
            View r8 = (View) ZeusTransformUtils.preCheckCast(r15.T(), View.class, "com.obric.aiagent.plugin");
            r19.a(r8.getId(), r10);
            r15.q(r19.e(r8.getId()));
            r15.r(r19.d(r8.getId()));
            if (ZeusTransformUtils.instanceOf(r8, ConstraintHelper.class) == false) goto L20;
            r19.a((ConstraintHelper) ZeusTransformUtils.preCheckCast(r8, ConstraintHelper.class, "com.obric.aiagent.plugin"), r15, r10, r9);
            if (ZeusTransformUtils.instanceOf(r8, Barrier.class) == false) goto L20;
            ((Barrier) ZeusTransformUtils.preCheckCast(r8, Barrier.class, "com.obric.aiagent.plugin")).validateParams();
        L20:
            if (Build.VERSION.SDK_INT < 17) goto L22;
            r10.resolveLayoutDirection(this.g.getLayoutDirection());
        L23:
            MotionLayout.access$1100(this.g, false, r8, r15, r10, r9);
            if (r19.b(r8.getId()) == 1) goto L25;
            r15.l(r19.c(r8.getId()));
            goto L13
        L25:
            r15.l(r8.getVisibility());
            goto L13
        L22:
            r10.resolveLayoutDirection(0);
            goto L23
        L27:
            Iterator<androidx.constraintlayout.a.c.e> r0 = r18.ak().iterator();
        L29:
            if (r0.hasNext() == false) goto L33;
            androidx.constraintlayout.a.c.e r2 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r2, androidx.constraintlayout.a.c.m.class) == false) goto L29;
            ConstraintHelper r5 = (ConstraintHelper) ZeusTransformUtils.preCheckCast(r2.T(), ConstraintHelper.class, "com.obric.aiagent.plugin");
            androidx.constraintlayout.a.c.i r6 = (androidx.constraintlayout.a.c.i) ZeusTransformUtils.preCheckCast(r2, androidx.constraintlayout.a.c.i.class, "com.obric.aiagent.plugin");
            r5.updatePreLayout(r18, r6, r9);
            ((androidx.constraintlayout.a.c.m) ZeusTransformUtils.preCheckCast(r6, androidx.constraintlayout.a.c.m.class, "com.obric.aiagent.plugin")).i();
            goto L29
        L33:
            return;
        L5:
            if (r19.f970c == 0) goto L7;
            MotionLayout r7 = this.g;
            MotionLayout.access$1000(r7, this.f847b, r7.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(this.g.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.g.getWidth(), 1073741824));
            goto L7
        }

        androidx.constraintlayout.a.c.e a(androidx.constraintlayout.a.c.f r5, View r6) {
            if (r5.T() != r6) goto L5;
            return r5;
        L5:
            ArrayList<androidx.constraintlayout.a.c.e> r4 = r5.ak();
            int r7 = r4.size();
            int r0 = 0;
        L6:
            if (r0 >= r7) goto L11;
            androidx.constraintlayout.a.c.e r1 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r0), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
            if (r1.T() == r6) goto L9;
            r0 = r0 + 1;
            goto L6
        L9:
            return r1;
        L11:
            return null;
        }

        public void a() {
            a(MotionLayout.access$1200(this.g), MotionLayout.access$1300(this.g));
            MotionLayout.access$1400(this.g);
        }

        public void a(int r14, int r15) {
            int r0 = View.MeasureSpec.getMode(r14);
            int r1 = View.MeasureSpec.getMode(r15);
            this.g.mWidthMeasureMode = r0;
            this.g.mHeightMeasureMode = r1;
            this.g.getOptimizationLevel();
            d(r14, r15);
            if (ZeusTransformUtils.instanceOf(this.g.getParent(), MotionLayout.class) == true) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L18;
            d(r14, r15);
            this.g.mStartWrapWidth = this.f846a.F();
            this.g.mStartWrapHeight = this.f846a.G();
            this.g.mEndWrapWidth = this.f847b.F();
            this.g.mEndWrapHeight = this.f847b.G();
            MotionLayout r3 = this.g;
            if (r3.mStartWrapWidth == this.g.mEndWrapWidth) goto L13;
        L16:
            boolean r4 = true;
        L17:
            r3.mMeasureDuringTransition = r4;
            goto L18
        L13:
            if (this.g.mStartWrapHeight != this.g.mEndWrapHeight) goto L16;
            r4 = false;
        L18:
            int r5 = this.g.mStartWrapWidth;
            int r6 = this.g.mStartWrapHeight;
            if (this.g.mWidthMeasureMode != Integer.MIN_VALUE) goto L21;
        L22:
            r5 = (int) (this.g.mStartWrapWidth + (this.g.mPostInterpolationPosition * (this.g.mEndWrapWidth - this.g.mStartWrapWidth)));
        L23:
            int r9 = r5;
            if (this.g.mHeightMeasureMode != Integer.MIN_VALUE) goto L26;
        L27:
            r6 = (int) (this.g.mStartWrapHeight + (this.g.mPostInterpolationPosition * (this.g.mEndWrapHeight - this.g.mStartWrapHeight)));
        L28:
            int r10 = r6;
            if (this.f846a.i() == false) goto L31;
        L34:
            boolean r11 = true;
        L36:
            if (this.f846a.af() == false) goto L38;
        L41:
            boolean r12 = true;
        L42:
            MotionLayout.access$1500(this.g, r14, r15, r9, r10, r11, r12);
            return;
        L38:
            if (this.f847b.af() == true) goto L41;
            r12 = false;
            goto L42
        L31:
            if (this.f847b.i() == true) goto L34;
            r11 = false;
            goto L36
        L26:
            if (this.g.mHeightMeasureMode != 0) goto L28;
        L21:
            if (this.g.mWidthMeasureMode != 0) goto L23;
        L5:
            if (r0 != 1073741824) goto L8;
            if (r1 != 1073741824) goto L8;
            r2 = false;
            goto L9
        }

        private void d(int r6, int r7) {
            int r0 = this.g.getOptimizationLevel();
            if (this.g.mCurrentState != this.g.getStartState()) goto L28;
            MotionLayout r1 = this.g;
            androidx.constraintlayout.a.c.f r2 = this.f847b;
            androidx.constraintlayout.widget.c r3 = this.f849d;
            if (r3 != null) goto L7;
        L10:
            int r4 = r6;
        L11:
            androidx.constraintlayout.widget.c r5 = this.f849d;
            if (r5 != null) goto L14;
        L17:
            int r8 = r7;
        L18:
            MotionLayout.access$1600(r1, r2, r0, r4, r8);
            androidx.constraintlayout.widget.c r9 = this.f848c;
            if (r9 == null) goto L53;
            MotionLayout r10 = this.g;
            androidx.constraintlayout.a.c.f r11 = this.f846a;
            if (r9.f970c != 0) goto L23;
            int r12 = r6;
        L25:
            if (this.f848c.f970c != 0) goto L27;
            r6 = r7;
        L27:
            MotionLayout.access$1700(r10, r11, r0, r12, r6);
            return;
        L23:
            r12 = r7;
            goto L25
        L53:
            return;
        L14:
            if (r5.f970c == 0) goto L17;
            r8 = r6;
            goto L18
        L7:
            if (r3.f970c == 0) goto L10;
            r4 = r7;
            goto L11
        L28:
            androidx.constraintlayout.widget.c r13 = this.f848c;
            if (r13 == null) goto L39;
            MotionLayout r14 = this.g;
            androidx.constraintlayout.a.c.f r15 = this.f846a;
            if (r13.f970c != 0) goto L33;
            int r16 = r6;
        L35:
            if (this.f848c.f970c != 0) goto L37;
            int r17 = r7;
        L38:
            MotionLayout.access$1800(r14, r15, r0, r16, r17);
            goto L39
        L37:
            r17 = r6;
            goto L38
        L33:
            r16 = r7;
        L39:
            MotionLayout r18 = this.g;
            androidx.constraintlayout.a.c.f r19 = this.f847b;
            androidx.constraintlayout.widget.c r20 = this.f849d;
            if (r20 != null) goto L42;
        L45:
            int r21 = r6;
        L46:
            androidx.constraintlayout.widget.c r22 = this.f849d;
            if (r22 != null) goto L49;
        L50:
            r6 = r7;
        L51:
            MotionLayout.access$1900(r18, r19, r0, r21, r6);
            return;
        L49:
            if (r22.f970c != 0) goto L51;
        L42:
            if (r20.f970c == 0) goto L45;
            r21 = r7;
            goto L46
        }

        public void b() {
            int r1 = this.g.getChildCount();
            this.g.mFrameArrayList.clear();
            SparseArray r2 = new SparseArray();
            int[] r3 = new int[r1];
            int r5 = 0;
        L3:
            if (r5 >= r1) goto L5;
            View r6 = this.g.getChildAt(r5);
            m r7 = new m(r6);
            int r8 = r6.getId();
            r3[r5] = r8;
            r2.put(r8, r7);
            this.g.mFrameArrayList.put(r6, r7);
            r5 = r5 + 1;
            goto L3
        L5:
            int r9 = 0;
        L7:
            if (r9 >= r1) goto L32;
            View r10 = this.g.getChildAt(r9);
            m r14 = (m) ZeusTransformUtils.preCheckCast(this.g.mFrameArrayList.get(r10), m.class, "com.obric.aiagent.plugin");
            if (r14 != null) goto L12;
            r2 = r2;
        L31:
            r9 = r9 + 1;
            r2 = r2;
            goto L7
        L12:
            if (this.f848c == null) goto L20;
            androidx.constraintlayout.a.c.e r11 = a(this.f846a, r10);
            if (r11 == null) goto L17;
            r14.a(MotionLayout.access$2000(this.g, r11), this.f848c, this.g.getWidth(), this.g.getHeight());
        L24:
            if (this.f849d == null) goto L31;
            androidx.constraintlayout.a.c.e r12 = a(this.f847b, r10);
            if (r12 == null) goto L29;
            r14.b(MotionLayout.access$2000(this.g, r12), this.f849d, this.g.getWidth(), this.g.getHeight());
            goto L31
        L29:
            if (this.g.mDebugPath == 0) goto L31;
            a(MotionLayout.TAG, androidx.constraintlayout.motion.widget.a.a() + "no widget for  " + androidx.constraintlayout.motion.widget.a.a(r10) + " (" + r10.getClass().getName() + ")");
            goto L31
        L17:
            if (this.g.mDebugPath == 0) goto L24;
            a(MotionLayout.TAG, androidx.constraintlayout.motion.widget.a.a() + "no widget for  " + androidx.constraintlayout.motion.widget.a.a(r10) + " (" + r10.getClass().getName() + ")");
            goto L24
        L20:
            if (MotionLayout.access$300(this.g) == false) goto L24;
            r14.a((androidx.constraintlayout.motion.utils.d) ZeusTransformUtils.preCheckCast(this.g.mPreRotate.get(r10), androidx.constraintlayout.motion.utils.d.class, "com.obric.aiagent.plugin"), r10, this.g.mRotatMode, MotionLayout.access$2100(this.g), MotionLayout.access$2200(this.g));
            goto L24
        L32:
            SparseArray r16 = r2;
            int r4 = 0;
        L33:
            if (r4 >= r1) goto L38;
            SparseArray r13 = r16;
            m r0 = (m) ZeusTransformUtils.preCheckCast(r13.get(r3[r4]), m.class, "com.obric.aiagent.plugin");
            int r15 = r0.e();
            if (r15 == (-1)) goto L37;
            r0.a((m) ZeusTransformUtils.preCheckCast(r13.get(r15), m.class, "com.obric.aiagent.plugin"));
        L37:
            r4 = r4 + 1;
            r16 = r13;
            goto L33
        }

        public void b(int r1, int r2) {
            this.f850e = r1;
            this.f = r2;
        }

        public boolean c(int r2, int r3) {
            if (r2 == this.f850e) goto L5;
        L8:
            return true;
        L5:
            if (r3 != this.f) goto L8;
            return false;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    protected interface c {
        void a();

        void a(int r1);

        void a(MotionEvent r1);

        float b();

        float c();
    }

    private static class d implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static d f851b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        VelocityTracker f852a;

        private d() {
        }

        static {
            f851b = new d();
        }

        public static d d() {
            d r0 = f851b;
            r0.f852a = VelocityTracker.obtain();
            return f851b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.c
        public void a() {
            VelocityTracker r0 = this.f852a;
            if (r0 == null) goto L6;
            r0.recycle();
            this.f852a = null;
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.c
        public void a(MotionEvent r1) {
            VelocityTracker r0 = this.f852a;
            if (r0 == null) goto L6;
            r0.addMovement(r1);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.c
        public void a(int r1) {
            VelocityTracker r0 = this.f852a;
            if (r0 == null) goto L6;
            r0.computeCurrentVelocity(r1);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.c
        public float b() {
            VelocityTracker r0 = this.f852a;
            if (r0 != null) goto L5;
            return 0.0f;
        L5:
            return r0.getXVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.c
        public float c() {
            VelocityTracker r0 = this.f852a;
            if (r0 != null) goto L5;
            return 0.0f;
        L5:
            return r0.getYVelocity();
        }
    }

    class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final String f857e;
        final String f;
        final String g;
        final String h;
        final /* synthetic */ MotionLayout i;

        e(MotionLayout r1) {
            this.i = r1;
            this.f853a = Float.NaN;
            this.f854b = Float.NaN;
            this.f855c = -1;
            this.f856d = -1;
            this.f857e = "motion.progress";
            this.f = "motion.velocity";
            this.g = "motion.StartState";
            this.h = "motion.EndState";
        }

        void a() {
            int r0 = this.f855c;
            if (r0 == (-1)) goto L5;
        L6:
            if (r0 != (-1)) goto L8;
            this.i.transitionToState(this.f856d);
        L12:
            this.i.setState(g.f859b);
        L14:
            if (Float.isNaN(this.f854b) == true) goto L16;
            this.i.setProgress(this.f853a, this.f854b);
            this.f853a = Float.NaN;
            this.f854b = Float.NaN;
            this.f855c = -1;
            this.f856d = -1;
            return;
        L16:
            if (Float.isNaN(this.f853a) == false) goto L18;
            return;
        L18:
            this.i.setProgress(this.f853a);
            return;
        L8:
            int r2 = this.f856d;
            if (r2 != (-1)) goto L11;
            this.i.setState(r0, -1, -1);
            goto L12
        L11:
            this.i.setTransition(r0, r2);
            goto L12
        L5:
            if (this.f856d == (-1)) goto L14;
            goto L6
        }

        public Bundle b() {
            Bundle r0 = new Bundle();
            r0.putFloat("motion.progress", this.f853a);
            r0.putFloat("motion.velocity", this.f854b);
            r0.putInt("motion.StartState", this.f855c);
            r0.putInt("motion.EndState", this.f856d);
            return r0;
        }

        public void a(Bundle r2) {
            this.f853a = r2.getFloat("motion.progress");
            this.f854b = r2.getFloat("motion.velocity");
            this.f855c = r2.getInt("motion.StartState");
            this.f856d = r2.getInt("motion.EndState");
        }

        public void a(float r1) {
            this.f853a = r1;
        }

        public void a(int r1) {
            this.f856d = r1;
        }

        public void b(float r1) {
            this.f854b = r1;
        }

        public void b(int r1) {
            this.f855c = r1;
        }

        public void c() {
            this.f856d = MotionLayout.access$100(this.i);
            this.f855c = MotionLayout.access$200(this.i);
            this.f854b = this.i.getVelocity();
            this.f853a = this.i.getProgress();
        }
    }

    public interface f {
        void onTransitionChange(MotionLayout r1, int r2, int r3, float r4);

        void onTransitionCompleted(MotionLayout r1, int r2);

        void onTransitionStarted(MotionLayout r1, int r2, int r3);

        void onTransitionTrigger(MotionLayout r1, int r2, boolean r3, float r4);
    }

    static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f858a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f859b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f860c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final g f861d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ g[] f862e = null;

        private g(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ g[] a() {
            return new g[]{f858a, f859b, f860c, f861d};
        }

        public static g valueOf(String r2) {
            return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
        }

        public static g[] values() {
            return (g[]) ZeusTransformUtils.preCheckCast(f862e.clone(), g[].class, "com.obric.aiagent.plugin");
        }

        static {
            f858a = new g("UNDEFINED", 0);
            f859b = new g("SETUP", 1);
            f860c = new g("MOVING", 2);
            f861d = new g("FINISHED", 3);
            f862e = a();
        }
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.v(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.e(r0, r1);
    }

    private static boolean willJump(float r5, float r6, float r7) {
        if (r5 <= 0.0f) goto L9;
        float r0 = r5 / r7;
        if ((r6 + ((r5 * r0) - (((r7 * r0) * r0) / 2.0f))) <= 1.0f) goto L8;
        return true;
    L8:
        return false;
    L9:
        float r1 = (-r5) / r7;
        if ((r6 + ((r5 * r1) + (((r7 * r1) * r1) / 2.0f))) >= 0.0f) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        return false;
    }

    @Override // androidx.core.view.q
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
    }

    static /* synthetic */ e access$000(MotionLayout r0) {
        return r0.mStateCache;
    }

    static /* synthetic */ int access$100(MotionLayout r0) {
        return r0.mEndState;
    }

    static /* synthetic */ void access$1000(MotionLayout r0, androidx.constraintlayout.a.c.f r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1100(MotionLayout r0, boolean r1, View r2, androidx.constraintlayout.a.c.e r3, ConstraintLayout.LayoutParams r4, SparseArray r5) {
        r0.applyConstraintsFromLayoutParams(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ int access$1200(MotionLayout r0) {
        return r0.mLastWidthMeasureSpec;
    }

    static /* synthetic */ int access$1300(MotionLayout r0) {
        return r0.mLastHeightMeasureSpec;
    }

    static /* synthetic */ void access$1400(MotionLayout r0) {
        r0.setupMotionViews();
    }

    static /* synthetic */ void access$1500(MotionLayout r0, int r1, int r2, int r3, int r4, boolean r5, boolean r6) {
        r0.resolveMeasuredDimension(r1, r2, r3, r4, r5, r6);
    }

    static /* synthetic */ void access$1600(MotionLayout r0, androidx.constraintlayout.a.c.f r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1700(MotionLayout r0, androidx.constraintlayout.a.c.f r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1800(MotionLayout r0, androidx.constraintlayout.a.c.f r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1900(MotionLayout r0, androidx.constraintlayout.a.c.f r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ int access$200(MotionLayout r0) {
        return r0.mBeginState;
    }

    static /* synthetic */ Rect access$2000(MotionLayout r0, androidx.constraintlayout.a.c.e r1) {
        return r0.toRect(r1);
    }

    static /* synthetic */ int access$2100(MotionLayout r0) {
        return r0.mPreRotateWidth;
    }

    static /* synthetic */ int access$2200(MotionLayout r0) {
        return r0.mPreRotateHeight;
    }

    static /* synthetic */ boolean access$300(MotionLayout r0) {
        return r0.mInRotation;
    }

    static /* synthetic */ boolean access$302(MotionLayout r0, boolean r1) {
        r0.mInRotation = r1;
        return r1;
    }

    static /* synthetic */ androidx.constraintlayout.a.c.f access$400(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ androidx.constraintlayout.a.c.f access$500(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ androidx.constraintlayout.a.c.f access$600(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ androidx.constraintlayout.a.c.f access$700(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ boolean access$800(MotionLayout r0) {
        return r0.isRtl();
    }

    static /* synthetic */ boolean access$900(MotionLayout r0) {
        return r0.isRtl();
    }

    m getMotionController(int r2) {
        return (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(findViewById(r2)), m.class, "com.obric.aiagent.plugin");
    }

    public MotionLayout(Context r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"));
        this.mProgressInterpolator = null;
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
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.a.a.a.d();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = g.f858a;
        this.mModel = new b(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(null);
    }

    public MotionLayout(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r8, r9);
        this.mProgressInterpolator = null;
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
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.a.a.a.d();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = g.f858a;
        this.mModel = new b(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(r9);
    }

    public MotionLayout(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r8, r9, r7);
        this.mProgressInterpolator = null;
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
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.a.a.a.d();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = g.f858a;
        this.mModel = new b(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(r9);
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public c obtainVelocityTracker() {
        return d.d();
    }

    public void enableTransition(int r4, boolean r5) {
        MotionScene.Transition r6 = getTransition(r4);
        if (r5 == false) goto L7;
        r6.a(true);
        return;
    L7:
        if (r6 != this.mScene.f864b) goto L14;
        Iterator<MotionScene.Transition> r7 = this.mScene.a(this.mCurrentState).iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        MotionScene.Transition r0 = (MotionScene.Transition) ZeusTransformUtils.preCheckCast(r7.next(), MotionScene.Transition.class, "com.obric.aiagent.plugin");
        if (r0.f() == false) goto L10;
        this.mScene.f864b = r0;
    L14:
        r6.a(false);
    }

    void setState(g r3) {
        if (r3 == g.f861d) goto L5;
    L7:
        g r0 = this.mTransitionState;
        this.mTransitionState = r3;
        if (r0 == g.f860c) goto L10;
    L12:
        int r1 = AnonymousClass5.f840a[r0.ordinal()];
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L20;
        return;
    L20:
        if (r3 != g.f861d) goto L29;
        fireTransitionCompleted();
        return;
    L29:
        return;
    L23:
        if (r3 != g.f860c) goto L26;
        fireTransitionChange();
    L26:
        if (r3 != g.f861d) goto L31;
        fireTransitionCompleted();
        return;
    L31:
        return;
    L10:
        if (r3 != g.f860c) goto L12;
        fireTransitionChange();
        goto L12
    L5:
        if (this.mCurrentState != (-1)) goto L7;
    }

    void setStartState(int r2) {
        if (isAttachedToWindow() == false) goto L5;
        this.mCurrentState = r2;
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new e(this);
    L7:
        this.mStateCache.b(r2);
        this.mStateCache.a(r2);
    }

    public void setTransition(int r4, int r5) {
        if (isAttachedToWindow() == false) goto L5;
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L13;
        this.mBeginState = r4;
        this.mEndState = r5;
        r0.a(r4, r5);
        this.mModel.a(this.mLayoutWidget, this.mScene.d(r4), this.mScene.d(r5));
        rebuildScene();
        this.mTransitionLastPosition = 0.0f;
        transitionToStart();
        return;
    L13:
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new e(this);
    L7:
        this.mStateCache.b(r4);
        this.mStateCache.a(r5);
    }

    public void setTransition(int r8) {
        if (this.mScene == null) goto L34;
        MotionScene.Transition r9 = getTransition(r8);
        this.mBeginState = r9.d();
        this.mEndState = r9.c();
        if (isAttachedToWindow() == false) goto L7;
        float r0 = Float.NaN;
        int r1 = this.mCurrentState;
        float r4 = 0.0f;
        if (r1 != this.mBeginState) goto L15;
        r0 = 0.0f;
    L17:
        this.mScene.a(r9);
        this.mModel.a(this.mLayoutWidget, this.mScene.d(this.mBeginState), this.mScene.d(this.mEndState));
        rebuildScene();
        if (this.mTransitionLastPosition == r0) goto L26;
        if (r0 != 0.0f) goto L23;
        endTrigger(true);
        this.mScene.d(this.mBeginState).c(this);
        goto L26
    L23:
        if (r0 != 1.0f) goto L26;
        endTrigger(false);
        this.mScene.d(this.mEndState).c(this);
    L26:
        if (Float.isNaN(r0) == true) goto L29;
        r4 = r0;
    L29:
        this.mTransitionLastPosition = r4;
        if (Float.isNaN(r0) == false) goto L32;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, androidx.constraintlayout.motion.widget.a.a() + " transitionToStart ");
        transitionToStart();
        return;
    L32:
        setProgress(r0);
        return;
    L15:
        if (r1 != this.mEndState) goto L17;
        r0 = 1.0f;
        goto L17
    L7:
        if (this.mStateCache != null) goto L9;
        this.mStateCache = new e(this);
    L9:
        this.mStateCache.b(this.mBeginState);
        this.mStateCache.a(this.mEndState);
        return;
    }

    public void setTransition(MotionScene.Transition r5) {
        this.mScene.a(r5);
        setState(g.f859b);
        if (this.mCurrentState != this.mScene.e()) goto L5;
        this.mTransitionLastPosition = 1.0f;
        this.mTransitionPosition = 1.0f;
        this.mTransitionGoalPosition = 1.0f;
    L7:
        if (r5.c(1) == false) goto L9;
        long r0 = -1;
    L10:
        this.mTransitionLastTime = r0;
        int r6 = this.mScene.d();
        int r1 = this.mScene.e();
        if (r6 == this.mBeginState) goto L13;
    L15:
        this.mBeginState = r6;
        this.mEndState = r1;
        this.mScene.a(r6, r1);
        this.mModel.a(this.mLayoutWidget, this.mScene.d(this.mBeginState), this.mScene.d(this.mEndState));
        this.mModel.b(this.mBeginState, this.mEndState);
        this.mModel.a();
        rebuildScene();
        return;
    L13:
        if (r1 != this.mEndState) goto L15;
        return;
    L9:
        r0 = getNanoTime();
        goto L10
    L5:
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        goto L7
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int r7) {
        if (r7 != 0) goto L56;
        this.mScene = null;
        return;
    L56:
        MotionScene r3 = new MotionScene((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, r7);     // Catch: Exception -> L50
        this.mScene = r3;     // Catch: Exception -> L50
        if (this.mCurrentState != (-1)) goto L9;
        if (r3 == null) goto L9;
        this.mCurrentState = r3.d();     // Catch: Exception -> L50
        this.mBeginState = this.mScene.d();     // Catch: Exception -> L50
        this.mEndState = this.mScene.e();     // Catch: Exception -> L50
    L9:
        if (Build.VERSION.SDK_INT >= 19) goto L11;
    L55:
    L47:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);     // Catch: Exception -> L50
    L16:
        if (Build.VERSION.SDK_INT < 17) goto L22;
        Display r8 = getDisplay();     // Catch: Exception -> L47
        if (r8 != null) goto L20;
        int r9 = 0;
    L21:
        this.mPreviouseRotation = r9;     // Catch: Exception -> L47
        goto L22
    L20:
        r9 = r8.getRotation();     // Catch: Exception -> L47
    L22:
        MotionScene r10 = this.mScene;     // Catch: Exception -> L47
        if (r10 == null) goto L33;
        androidx.constraintlayout.widget.c r11 = r10.d(this.mCurrentState);     // Catch: Exception -> L47
        this.mScene.a(this);     // Catch: Exception -> L47
        ArrayList<MotionHelper> r2 = this.mDecoratorsHelpers;     // Catch: Exception -> L47
        if (r2 == null) goto L30;
        Iterator<MotionHelper> r4 = r2.iterator();     // Catch: Exception -> L47
    L28:
        if (r4.hasNext() == false) goto L30;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r4.next(), MotionHelper.class, "com.obric.aiagent.plugin")).onFinishedMotionScene(this);     // Catch: Exception -> L47
    L30:
        if (r11 == null) goto L32;
        r11.c(this);     // Catch: Exception -> L47
    L32:
        this.mBeginState = this.mCurrentState;     // Catch: Exception -> L47
    L33:
        onNewStateAttachHandlers();     // Catch: Exception -> L47
        e r12 = this.mStateCache;     // Catch: Exception -> L47
        if (r12 != null) goto L36;
        MotionScene r13 = this.mScene;     // Catch: Exception -> L47
        if (r13 != null) goto L42;
        return;
    L42:
        if (r13.f864b != null) goto L44;
        return;
    L44:
        if (this.mScene.f864b.b() != 4) goto L62;
        transitionToEnd();     // Catch: Exception -> L47
        setState(g.f859b);     // Catch: Exception -> L47
        setState(g.f860c);     // Catch: Exception -> L47
        return;
    L62:
        return;
    L36:
        if (this.mDelayedApply == false) goto L38;
        post(new AnonymousClass1(this));     // Catch: Exception -> L47
        return;
    L38:
        r12.a();     // Catch: Exception -> L47
        return;
    L11:
        if (isAttachedToWindow() == true) goto L55;
        this.mScene = null;     // Catch: Exception -> L50
        return;
    L50:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return super.isAttachedToWindow();
    L7:
        if (getWindowToken() == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int r2, int r3, int r4) {
        setState(g.f859b);
        this.mCurrentState = r2;
        this.mBeginState = -1;
        this.mEndState = -1;
        if (this.mConstraintLayoutSpec == null) goto L5;
        this.mConstraintLayoutSpec.a(r2, r3, r4);
        return;
    L5:
        MotionScene r5 = this.mScene;
        if (r5 == null) goto L10;
        r5.d(r2).c(this);
        return;
    }

    public void setInterpolatedProgress(float r2) {
        if (this.mScene == null) goto L8;
        setState(g.f860c);
        Interpolator r0 = this.mScene.f();
        if (r0 == null) goto L8;
        setProgress(r0.getInterpolation(r2));
        return;
    L8:
        setProgress(r2);
    }

    public void setProgress(float r3, float r4) {
        if (isAttachedToWindow() == false) goto L5;
        setProgress(r3);
        setState(g.f860c);
        this.mLastVelocity = r4;
        float r0 = 0.0f;
        if (r4 == 0.0f) goto L15;
        if (r4 <= 0.0f) goto L13;
        r0 = 1.0f;
    L13:
        animateTo(r0);
        return;
    L15:
        if (r3 != 0.0f) goto L17;
        return;
    L17:
        if (r3 != 1.0f) goto L19;
        return;
    L19:
        if (r3 <= 0.5f) goto L21;
        r0 = 1.0f;
    L21:
        animateTo(r0);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new e(this);
    L7:
        this.mStateCache.a(r3);
        this.mStateCache.b(r4);
    }

    public void setTransitionState(Bundle r2) {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new e(this);
    L5:
        this.mStateCache.a(r2);
        if (isAttachedToWindow() == false) goto L9;
        this.mStateCache.a();
        return;
    }

    public Bundle getTransitionState() {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new e(this);
    L5:
        this.mStateCache.c();
        return this.mStateCache.b();
    }

    public void setProgress(float r6) {
        if (r6 >= 0.0f) goto L5;
    L6:
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    L8:
        if (isAttachedToWindow() == false) goto L10;
        if (r6 > 0.0f) goto L24;
        if (this.mTransitionLastPosition == 1.0f) goto L18;
    L20:
        this.mCurrentState = this.mBeginState;
        if (this.mTransitionLastPosition != 0.0f) goto L35;
        setState(g.f861d);
    L35:
        if (this.mScene != null) goto L37;
        return;
    L37:
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = r6;
        this.mTransitionPosition = r6;
        this.mTransitionLastTime = -1;
        this.mAnimationStartTime = -1;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
        return;
    L18:
        if (this.mCurrentState != this.mEndState) goto L20;
        setState(g.f860c);
        goto L20
    L24:
        if (r6 >= 1.0f) goto L26;
        this.mCurrentState = -1;
        setState(g.f860c);
        goto L35
    L26:
        if (this.mTransitionLastPosition == 0.0f) goto L28;
    L30:
        this.mCurrentState = this.mEndState;
        if (this.mTransitionLastPosition != 1.0f) goto L35;
        setState(g.f861d);
        goto L35
    L28:
        if (this.mCurrentState != this.mBeginState) goto L30;
        setState(g.f860c);
        goto L30
    L10:
        if (this.mStateCache != null) goto L12;
        this.mStateCache = new e(this);
    L12:
        this.mStateCache.a(r6);
        return;
    L5:
        if (r6 <= 1.0f) goto L8;
        goto L6
    }

    private void setupMotionViews() {
        int r1 = getChildCount();
        this.mModel.b();
        boolean r2 = true;
        this.mInTransition = true;
        SparseArray r3 = new SparseArray();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r5 >= r1) goto L6;
        View r7 = getChildAt(r5);
        r3.put(r7.getId(), (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r7), m.class, "com.obric.aiagent.plugin"));
        r5 = r5 + 1;
        goto L4
    L6:
        int r6 = getWidth();
        int r8 = getHeight();
        int r9 = this.mScene.h();
        if (r9 == (-1)) goto L14;
        int r10 = 0;
    L9:
        if (r10 >= r1) goto L14;
        m r11 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r10)), m.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L13;
        r11.b(r9);
    L13:
        r10 = r10 + 1;
    L14:
        SparseBooleanArray r13 = new SparseBooleanArray();
        int[] r14 = new int[this.mFrameArrayList.size()];
        int r12 = 0;
        int r15 = 0;
    L15:
        if (r12 >= r1) goto L21;
        m r16 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r12)), m.class, "com.obric.aiagent.plugin");
        if (r16.e() == (-1)) goto L19;
        r13.put(r16.e(), true);
        r14[r15] = r16.e();
        r15 = r15 + 1;
    L19:
        r12 = r12 + 1;
        goto L15
    L21:
        if (this.mDecoratorsHelpers == null) goto L40;
        int r17 = 0;
    L23:
        if (r17 >= r15) goto L29;
        m r18 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(findViewById(r14[r17])), m.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L28;
        this.mScene.a(r18);
    L28:
        r17 = r17 + 1;
        goto L23
    L29:
        Iterator<MotionHelper> r19 = this.mDecoratorsHelpers.iterator();
    L31:
        if (r19.hasNext() == false) goto L33;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r19.next(), MotionHelper.class, "com.obric.aiagent.plugin")).onPreSetup(this, this.mFrameArrayList);
        goto L31
    L33:
        int r110 = 0;
    L34:
        if (r110 >= r15) goto L47;
        m r20 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(findViewById(r14[r110])), m.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L39;
        r20.a(r6, r8, this.mTransitionDuration, getNanoTime());
    L39:
        r110 = r110 + 1;
    L47:
        int r111 = 0;
    L48:
        if (r111 >= r1) goto L55;
        View r21 = getChildAt(r111);
        m r22 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r21), m.class, "com.obric.aiagent.plugin");
        if (r13.get(r21.getId()) == true) goto L54;
        if (r22 == null) goto L54;
        this.mScene.a(r22);
        r22.a(r6, r8, this.mTransitionDuration, getNanoTime());
    L54:
        r111 = r111 + 1;
        goto L48
    L55:
        float r23 = this.mScene.i();
        if (r23 != 0.0f) goto L58;
        return;
    L58:
        if (r23 >= 0.0d) goto L60;
        boolean r24 = true;
    L61:
        float r25 = Math.abs(r23);
        float r26 = -3.4028235E38f;
        float r27 = Float.MAX_VALUE;
        int r28 = 0;
        float r112 = -3.4028235E38f;
        float r113 = Float.MAX_VALUE;
    L62:
        if (r28 >= r1) goto L71;
        m r114 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r28)), m.class, "com.obric.aiagent.plugin");
        if (Float.isNaN(r114.f) == false) goto L73;
        float r115 = r114.c();
        float r116 = r114.d();
        if (r24 == false) goto L69;
        float r117 = r116 - r115;
    L70:
        r113 = Math.min(r113, r117);
        r112 = Math.max(r112, r117);
        r28 = r28 + 1;
        goto L62
    L69:
        r117 = r116 + r115;
    L73:
        if (r2 == false) goto L88;
        int r29 = 0;
    L75:
        if (r29 >= r1) goto L80;
        m r118 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r29)), m.class, "com.obric.aiagent.plugin");
        if (Float.isNaN(r118.f) == true) goto L79;
        r27 = Math.min(r27, r118.f);
        r26 = Math.max(r26, r118.f);
    L79:
        r29 = r29 + 1;
    L80:
        if (r4 >= r1) goto L130;
        m r30 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r4)), m.class, "com.obric.aiagent.plugin");
        if (Float.isNaN(r30.f) == true) goto L87;
        r30.h = 1.0f / (1.0f - r25);
        if (r24 == false) goto L86;
        r30.g = r25 - (((r26 - r30.f) / (r26 - r27)) * r25);
        goto L87
    L86:
        r30.g = r25 - (((r30.f - r27) * r25) / (r26 - r27));
    L87:
        r4 = r4 + 1;
        goto L80
    L130:
        return;
    L88:
        if (r4 >= r1) goto L131;
        m r31 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r4)), m.class, "com.obric.aiagent.plugin");
        float r32 = r31.c();
        float r33 = r31.d();
        if (r24 == false) goto L92;
        float r34 = r33 - r32;
    L93:
        r31.h = 1.0f / (1.0f - r25);
        r31.g = r25 - (((r34 - r113) * r25) / (r112 - r113));
        r4 = r4 + 1;
        goto L88
    L92:
        r34 = r33 + r32;
        goto L93
    L131:
        return;
    L71:
        r2 = false;
        goto L73
    L60:
        r24 = false;
        goto L61
    L40:
        int r119 = 0;
    L41:
        if (r119 >= r15) goto L47;
        m r35 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(findViewById(r14[r119])), m.class, "com.obric.aiagent.plugin");
        if (r35 == null) goto L46;
        this.mScene.a(r35);
        r35.a(r6, r8, this.mTransitionDuration, getNanoTime());
    L46:
        r119 = r119 + 1;
        goto L41
    }

    public void touchAnimateTo(int r10, float r11, float r12) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mTransitionLastPosition != r11) goto L8;
        return;
    L8:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.g() / 1000.0f;
        this.mTransitionGoalPosition = r11;
        this.mInTransition = true;
        if (r10 == 0) goto L24;
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L24;
        if (r10 != 4) goto L15;
        this.mDecelerateLogic.config(r12, this.mTransitionLastPosition, this.mScene.j());
        this.mInterpolator = this.mDecelerateLogic;
    L36:
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
        return;
    L15:
        if (r10 == 5) goto L20;
        if (r10 == 6) goto L24;
        if (r10 == 7) goto L24;
    L20:
        if (willJump(r12, this.mTransitionLastPosition, this.mScene.j()) == false) goto L22;
        this.mDecelerateLogic.config(r12, this.mTransitionLastPosition, this.mScene.j());
        this.mInterpolator = this.mDecelerateLogic;
        goto L36
    L22:
        this.mStopLogic.config(this.mTransitionLastPosition, r11, r12, this.mTransitionDuration, this.mScene.j(), this.mScene.k());
        this.mLastVelocity = 0.0f;
        int r13 = this.mCurrentState;
        this.mTransitionGoalPosition = r11;
        this.mCurrentState = r13;
        this.mInterpolator = this.mStopLogic;
    L24:
        if (r10 == 1) goto L30;
        if (r10 == 7) goto L30;
        if (r10 == 2) goto L29;
        if (r10 == 6) goto L29;
    L32:
        if (this.mScene.q() != 0) goto L34;
        this.mStopLogic.config(this.mTransitionLastPosition, r11, r12, this.mTransitionDuration, this.mScene.j(), this.mScene.k());
    L35:
        int r14 = this.mCurrentState;
        this.mTransitionGoalPosition = r11;
        this.mCurrentState = r14;
        this.mInterpolator = this.mStopLogic;
        goto L36
    L34:
        this.mStopLogic.springConfig(this.mTransitionLastPosition, r11, r12, this.mScene.m(), this.mScene.l(), this.mScene.n(), this.mScene.o(), this.mScene.p());
    L29:
        r11 = 1.0f;
    L30:
        r11 = 0.0f;
        goto L32
    }

    public void touchSpringTo(float r12, float r13) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mTransitionLastPosition != r12) goto L8;
        return;
    L8:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.g() / 1000.0f;
        this.mTransitionGoalPosition = r12;
        this.mInTransition = true;
        this.mStopLogic.springConfig(this.mTransitionLastPosition, r12, r13, this.mScene.m(), this.mScene.l(), this.mScene.n(), this.mScene.o(), this.mScene.p());
        int r14 = this.mCurrentState;
        this.mTransitionGoalPosition = r12;
        this.mCurrentState = r14;
        this.mInterpolator = this.mStopLogic;
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    void animateTo(float r5) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = this.mTransitionLastPosition;
        float r2 = this.mTransitionPosition;
        if (r1 != r2) goto L8;
    L10:
        float r3 = this.mTransitionLastPosition;
        if (r3 != r5) goto L13;
        return;
    L13:
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = r5;
        this.mTransitionDuration = r0.g() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = null;
        this.mProgressInterpolator = this.mScene.f();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = r3;
        this.mTransitionLastPosition = r3;
        invalidate();
        return;
    L8:
        if (this.mTransitionInstantly == false) goto L10;
        this.mTransitionLastPosition = r2;
        goto L10
    }

    private void computeCurrentPositions() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = getChildAt(r1);
        m r3 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r2), m.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        r3.b(r2);
    L8:
        r1 = r1 + 1;
        goto L3
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToEnd(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        animateTo(1.0f);
        this.mOnComplete = r4;
    }

    public void transitionToState(int r2) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r2, -1, -1);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new e(this);
    L7:
        this.mStateCache.a(r2);
    }

    public void transitionToState(int r2, int r3) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r2, -1, -1, r3);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new e(this);
    L7:
        this.mStateCache.a(r2);
    }

    public void transitionToState(int r2, int r3, int r4) {
        transitionToState(r2, r3, r4, -1);
    }

    public void rotateTo(int r7, int r8) {
        int r0 = 1;
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int r1 = getDisplay().getRotation();
        if (((r1 + 1) % 4) > ((this.mPreviouseRotation + 1) % 4)) goto L6;
        r0 = 2;
    L6:
        this.mRotatMode = r0;
        this.mPreviouseRotation = r1;
        int r2 = getChildCount();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        View r4 = getChildAt(r3);
        androidx.constraintlayout.motion.utils.d r5 = (androidx.constraintlayout.motion.utils.d) ZeusTransformUtils.preCheckCast(this.mPreRotate.get(r4), androidx.constraintlayout.motion.utils.d.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L11;
        r5 = new androidx.constraintlayout.motion.utils.d();
        this.mPreRotate.put(r4, r5);
    L11:
        r5.a(r4);
        r3 = r3 + 1;
        goto L7
    L12:
        this.mBeginState = -1;
        this.mEndState = r7;
        this.mScene.a(-1, r7);
        this.mModel.a(this.mLayoutWidget, null, this.mScene.d(this.mEndState));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new AnonymousClass2(this));
        if (r8 <= 0) goto L19;
        this.mTransitionDuration = r8 / 1000.0f;
        return;
    }

    public boolean isInRotation() {
        return this.mInRotation;
    }

    public void jumpToState(int r2) {
        if (isAttachedToWindow() == true) goto L6;
        this.mCurrentState = r2;
    L6:
        if (this.mBeginState != r2) goto L9;
        setProgress(0.0f);
        return;
    L9:
        if (this.mEndState != r2) goto L11;
        setProgress(1.0f);
        return;
    L11:
        setTransition(r2, r2);
    }

    public void transitionToState(int r12, int r13, int r14, int r15) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
    L9:
        int r16 = this.mCurrentState;
        if (r16 != r12) goto L13;
        return;
    L13:
        if (this.mBeginState != r12) goto L19;
        animateTo(0.0f);
        if (r15 <= 0) goto L91;
        this.mTransitionDuration = r15 / 1000.0f;
        return;
    L91:
        return;
    L19:
        if (this.mEndState != r12) goto L24;
        animateTo(1.0f);
        if (r15 <= 0) goto L92;
        this.mTransitionDuration = r15 / 1000.0f;
        return;
    L92:
        return;
    L24:
        this.mEndState = r12;
        if (r16 == (-1)) goto L30;
        setTransition(r16, r12);
        animateTo(1.0f);
        this.mTransitionLastPosition = 0.0f;
        transitionToEnd();
        if (r15 <= 0) goto L93;
        this.mTransitionDuration = r15 / 1000.0f;
        return;
    L93:
        return;
    L30:
        int r17 = 0;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        if (r15 != (-1)) goto L33;
        this.mTransitionDuration = this.mScene.g() / 1000.0f;
    L33:
        this.mBeginState = -1;
        this.mScene.a(-1, this.mEndState);
        SparseArray r1 = new SparseArray();
        if (r15 != 0) goto L36;
        this.mTransitionDuration = this.mScene.g() / 1000.0f;
    L38:
        int r18 = getChildCount();
        this.mFrameArrayList.clear();
        int r2 = 0;
    L40:
        if (r2 >= r18) goto L42;
        View r5 = getChildAt(r2);
        this.mFrameArrayList.put(r5, new m(r5));
        r1.put(r5.getId(), (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r5), m.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L40
    L42:
        this.mInTransition = true;
        this.mModel.a(this.mLayoutWidget, null, this.mScene.d(r12));
        rebuildScene();
        this.mModel.b();
        computeCurrentPositions();
        int r19 = getWidth();
        int r110 = getHeight();
        if (this.mDecoratorsHelpers == null) goto L62;
        int r3 = 0;
    L45:
        if (r3 >= r18) goto L51;
        m r6 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r3)), m.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L50;
        this.mScene.a(r6);
    L50:
        r3 = r3 + 1;
        goto L45
    L51:
        Iterator<MotionHelper> r4 = this.mDecoratorsHelpers.iterator();
    L53:
        if (r4.hasNext() == false) goto L55;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r4.next(), MotionHelper.class, "com.obric.aiagent.plugin")).onPreSetup(this, this.mFrameArrayList);
        goto L53
    L55:
        int r7 = 0;
    L56:
        if (r7 >= r18) goto L69;
        m r8 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r7)), m.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L61;
        r8.a(r19, r110, this.mTransitionDuration, getNanoTime());
    L61:
        r7 = r7 + 1;
    L69:
        float r111 = this.mScene.i();
        if (r111 == 0.0f) goto L76;
        float r112 = Float.MAX_VALUE;
        float r9 = -3.4028235E38f;
        int r10 = 0;
    L72:
        if (r10 >= r18) goto L74;
        m r11 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r10)), m.class, "com.obric.aiagent.plugin");
        float r20 = r11.d() + r11.c();
        r112 = Math.min(r112, r20);
        r9 = Math.max(r9, r20);
        r10 = r10 + 1;
    L74:
        if (r17 >= r18) goto L76;
        m r21 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r17)), m.class, "com.obric.aiagent.plugin");
        float r22 = r21.c();
        float r23 = r21.d();
        r21.h = 1.0f / (1.0f - r111);
        r21.g = r111 - ((((r22 + r23) - r112) * r111) / (r9 - r112));
        r17 = r17 + 1;
    L76:
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
        return;
    L62:
        int r24 = 0;
    L63:
        if (r24 >= r18) goto L69;
        m r25 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r24)), m.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L68;
        this.mScene.a(r25);
        r25.a(r19, r110, this.mTransitionDuration, getNanoTime());
    L68:
        r24 = r24 + 1;
        goto L63
    L36:
        if (r15 <= 0) goto L38;
        this.mTransitionDuration = r15 / 1000.0f;
        goto L38
    L5:
        if (r0.f863a == null) goto L9;
        int r113 = this.mScene.f863a.a(this.mCurrentState, r12, r13, r14);
        if (r113 == (-1)) goto L9;
        r12 = r113;
        goto L9
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View r9, float r10, float r11, float[] r12, int r13) {
        float r0 = this.mLastVelocity;
        float r1 = this.mTransitionLastPosition;
        if (this.mInterpolator == null) goto L5;
        float r2 = Math.signum(this.mTransitionGoalPosition - r1);
        float r3 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
        float r4 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
        r0 = (r2 * ((r3 - r4) / EPSILON)) / this.mTransitionDuration;
        float r5 = r4;
    L7:
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, MotionInterpolator.class) == false) goto L9;
        r0 = ((MotionInterpolator) ZeusTransformUtils.preCheckCast(this.mInterpolator, MotionInterpolator.class, "com.obric.aiagent.plugin")).getVelocity();
    L9:
        m r6 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r9), m.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) != 0) goto L12;
        r6.a(r5, r9.getWidth(), r9.getHeight(), r10, r11, r12);
    L14:
        if (r13 >= 2) goto L17;
        r12[0] = r12[0] * r0;
        r12[1] = r12[1] * r0;
        return;
    L17:
        return;
    L12:
        r6.a(r5, r10, r11, r12);
        goto L14
    L5:
        r5 = r1;
        goto L7
    }

    private Rect toRect(androidx.constraintlayout.a.c.e r4) {
        Rect r0 = this.mTempRect;
        r0.top = r4.E();
        Rect r1 = this.mTempRect;
        r1.left = r4.D();
        Rect r2 = this.mTempRect;
        r2.right = r4.F() + this.mTempRect.left;
        Rect r3 = this.mTempRect;
        r3.bottom = r4.G() + this.mTempRect.top;
        return this.mTempRect;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mMeasureDuringTransition == false) goto L5;
    L19:
        super.requestLayout();
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L19;
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L19;
        if (r0.f864b == null) goto L19;
        int r1 = this.mScene.f864b.a();
        if (r1 != 0) goto L14;
        return;
    L14:
        if (r1 != 2) goto L19;
        int r2 = getChildCount();
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L18;
        View r4 = getChildAt(r3);
        ((m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r4), m.class, "com.obric.aiagent.plugin")).h();
        r3 = r3 + 1;
        goto L16
    }

    @Override // android.view.View
    public String toString() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        return androidx.constraintlayout.motion.widget.a.a(r0, this.mBeginState) + "->" + androidx.constraintlayout.motion.widget.a.a(r0, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        if (this.mScene != null) goto L6;
        super.onMeasure(r8, r9);
        return;
    L6:
        boolean r1 = false;
        if (this.mLastWidthMeasureSpec == r8) goto L9;
    L12:
        boolean r0 = true;
    L14:
        if (this.mNeedsFireTransitionCompleted == false) goto L17;
        this.mNeedsFireTransitionCompleted = false;
        onNewStateAttachHandlers();
        processTransitionCompleted();
        r0 = true;
    L17:
        if (this.mDirtyHierarchy == false) goto L19;
        r0 = true;
    L19:
        this.mLastWidthMeasureSpec = r8;
        this.mLastHeightMeasureSpec = r9;
        int r3 = this.mScene.d();
        int r4 = this.mScene.e();
        if (r0 == true) goto L24;
        if (this.mModel.c(r3, r4) == true) goto L24;
    L26:
        if (r0 == false) goto L28;
        super.onMeasure(r8, r9);
    L28:
        r1 = true;
    L30:
        if (this.mMeasureDuringTransition == true) goto L32;
        if (r1 == true) goto L32;
    L41:
        evaluateLayout();
        return;
    L32:
        int r10 = getPaddingTop() + getPaddingBottom();
        int r2 = this.mLayoutWidget.F() + (getPaddingLeft() + getPaddingRight());
        int r11 = this.mLayoutWidget.G() + r10;
        int r12 = this.mWidthMeasureMode;
        if (r12 == Integer.MIN_VALUE) goto L35;
        if (r12 == 0) goto L35;
    L36:
        int r13 = this.mHeightMeasureMode;
        if (r13 == Integer.MIN_VALUE) goto L39;
        if (r13 == 0) goto L39;
    L40:
        setMeasuredDimension(r2, r11);
    L39:
        int r14 = this.mStartWrapHeight;
        r11 = (int) (r14 + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r14)));
        requestLayout();
    L35:
        int r15 = this.mStartWrapWidth;
        r2 = (int) (r15 + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r15)));
        requestLayout();
    L24:
        if (this.mBeginState == (-1)) goto L26;
        super.onMeasure(r8, r9);
        this.mModel.a(this.mLayoutWidget, this.mScene.d(r3), this.mScene.d(r4));
        this.mModel.a();
        this.mModel.b(r3, r4);
        goto L30
    L9:
        if (this.mLastHeightMeasureSpec != r9) goto L12;
        r0 = false;
        goto L14
    }

    @Override // androidx.core.view.q
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        MotionScene r5 = this.mScene;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.f864b != null) goto L7;
        return false;
    L7:
        if (this.mScene.f864b.e() != null) goto L9;
        return false;
    L9:
        if ((this.mScene.f864b.e().g() & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // androidx.core.view.q
    public void onNestedScrollAccepted(View r1, View r2, int r3, int r4) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    @Override // androidx.core.view.q
    public void onStopNestedScroll(View r2, int r3) {
        MotionScene r4 = this.mScene;
        if (r4 == null) goto L9;
        float r5 = this.mScrollTargetDT;
        if (r5 == 0.0f) goto L10;
        r4.b(this.mScrollTargetDX / r5, this.mScrollTargetDY / r5);
        return;
    L10:
        return;
    }

    @Override // androidx.core.view.r
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        if (this.mUndergoingMotion == true) goto L6;
        if (r2 != 0) goto L6;
        if (r3 != 0) goto L6;
    L7:
        this.mUndergoingMotion = false;
        return;
    L6:
        r7[0] = r7[0] + r4;
        r7[1] = r7[1] + r5;
        goto L7
    }

    @Override // androidx.core.view.q
    public void onNestedPreScroll(final View r11, int r12, int r13, int[] r14, int r15) {
        MotionScene r16 = this.mScene;
        if (r16 != null) goto L5;
        return;
    L5:
        MotionScene.Transition r0 = r16.f864b;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.f() == false) goto L61;
        int r2 = -1;
        if (r0.f() == false) goto L20;
        p r1 = r0.e();
        if (r1 == null) goto L20;
        int r3 = r1.f();
        if (r3 == (-1)) goto L20;
        if (r11.getId() == r3) goto L20;
        return;
    L20:
        if (r16.s() == false) goto L34;
        p r4 = r0.e();
        if (r4 != null) goto L24;
    L26:
        float r5 = this.mTransitionPosition;
        if (r5 == 1.0f) goto L31;
        if (r5 != 0.0f) goto L34;
    L31:
        if (r11.canScrollVertically(r2) == false) goto L34;
        return;
    L24:
        if ((r4.g() & 4) == 0) goto L26;
        r2 = r13;
    L34:
        if (r0.e() != null) goto L36;
    L49:
        float r17 = this.mTransitionPosition;
        long r6 = getNanoTime();
        float r7 = r12;
        this.mScrollTargetDX = r7;
        float r8 = r13;
        this.mScrollTargetDY = r8;
        this.mScrollTargetDT = (float) ((r6 - this.mScrollTargetTime) * 1.0E-9d);
        this.mScrollTargetTime = r6;
        r16.a(r7, r8);
        if (r17 == this.mTransitionPosition) goto L52;
        r14[0] = r12;
        r14[1] = r13;
    L52:
        evaluate(false);
        if (r14[0] == 0) goto L55;
    L56:
        this.mUndergoingMotion = true;
        return;
    L55:
        if (r14[1] != 0) goto L56;
        return;
    L36:
        if ((r0.e().g() & 1) == 0) goto L49;
        float r9 = r16.c(r12, r13);
        float r10 = this.mTransitionLastPosition;
        if (r10 > 0.0f) goto L42;
        if (r9 >= 0.0f) goto L42;
    L46:
        if (Build.VERSION.SDK_INT < 21) goto L58;
        r11.setNestedScrollingEnabled(false);
        r11.post(new AnonymousClass3(this, r11));
        return;
    L58:
        return;
    L42:
        if (r10 < 1.0f) goto L49;
        if (r9 <= 0.0f) goto L49;
    }

    private void debugPos() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L6;
        View r1 = getChildAt(r0);
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, " " + androidx.constraintlayout.motion.widget.a.a() + " " + androidx.constraintlayout.motion.widget.a.a(this) + " " + androidx.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.mCurrentState) + " " + androidx.constraintlayout.motion.widget.a.a(r1) + r1.getLeft() + " " + r1.getTop());
        r0 = r0 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r11) {
        ArrayList<MotionHelper> r0 = this.mDecoratorsHelpers;
        if (r0 == null) goto L8;
        Iterator<MotionHelper> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r1.next(), MotionHelper.class, "com.obric.aiagent.plugin")).onPreDraw(r11);
    L8:
        evaluate(false);
        MotionScene r2 = this.mScene;
        if (r2 != null) goto L11;
    L13:
        super.dispatchDraw(r11);
        if (this.mScene != null) goto L17;
        return;
    L17:
        if ((this.mDebugPath & 1) != 1) goto L32;
        if (isInEditMode() == true) goto L32;
        this.mFrames++;
        long r4 = getNanoTime();
        long r6 = this.mLastDrawTime;
        if (r6 == (-1)) goto L25;
        long r7 = r4 - r6;
        if (r7 <= 200000000) goto L26;
        this.mLastFps = ((int) ((this.mFrames / (r7 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.mFrames = 0;
        this.mLastDrawTime = r4;
    L26:
        Paint r3 = new Paint();
        r3.setTextSize(42.0f);
        StringBuilder r5 = new StringBuilder().append(this.mLastFps + " fps " + androidx.constraintlayout.motion.widget.a.a(this, this.mBeginState) + " -> ").append(androidx.constraintlayout.motion.widget.a.a(this, this.mEndState)).append(" (progress: ").append(((int) (getProgress() * 1000.0f)) / 10.0f).append(" ) state=");
        int r8 = this.mCurrentState;
        if (r8 != (-1)) goto L29;
        String r9 = "undefined";
    L30:
        String r10 = r5.append(r9).toString();
        r3.setColor(-16777216);
        r11.drawText(r10, 11.0f, getHeight() - 29, r3);
        r3.setColor(-7864184);
        r11.drawText(r10, 10.0f, getHeight() - 30, r3);
        goto L32
    L29:
        r9 = androidx.constraintlayout.motion.widget.a.a(this, r8);
        goto L30
    L25:
        this.mLastDrawTime = r4;
    L32:
        if (this.mDebugPath > 1) goto L34;
    L37:
        ArrayList<MotionHelper> r12 = this.mDecoratorsHelpers;
        if (r12 == null) goto L43;
        Iterator<MotionHelper> r13 = r12.iterator();
    L41:
        if (r13.hasNext() == false) goto L46;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r13.next(), MotionHelper.class, "com.obric.aiagent.plugin")).onPostDraw(r11);
        goto L41
    L46:
        return;
    L43:
        return;
    L34:
        if (this.mDevModeDraw != null) goto L36;
        this.mDevModeDraw = new a(this);
    L36:
        this.mDevModeDraw.a(r11, this.mFrameArrayList, this.mScene.g(), this.mDebugPath);
        goto L37
    L11:
        if (r2.f865c == null) goto L13;
        this.mScene.f865c.a();
        goto L13
    }

    private void evaluateLayout() {
        float r0 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long r1 = getNanoTime();
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, StopLogic.class) == true) goto L5;
        float r3 = (((r1 - this.mTransitionLastTime) * r0) * 1.0E-9f) / this.mTransitionDuration;
    L6:
        float r6 = this.mTransitionLastPosition + r3;
        if (this.mTransitionInstantly == false) goto L9;
        r6 = this.mTransitionGoalPosition;
    L9:
        int r7 = 0;
        if (r0 <= 0.0f) goto L14;
        if (r6 < this.mTransitionGoalPosition) goto L14;
    L17:
        r6 = this.mTransitionGoalPosition;
        boolean r8 = true;
    L19:
        Interpolator r9 = this.mInterpolator;
        if (r9 == null) goto L26;
        if (r8 == true) goto L26;
        if (this.mTemporalInterpolator == false) goto L25;
        r6 = r9.getInterpolation((r1 - this.mAnimationStartTime) * 1.0E-9f);
        goto L26
    L25:
        r6 = r9.getInterpolation(r6);
    L26:
        if (r0 <= 0.0f) goto L30;
        if (r6 < this.mTransitionGoalPosition) goto L30;
    L33:
        r6 = this.mTransitionGoalPosition;
    L34:
        this.mPostInterpolationPosition = r6;
        int r2 = getChildCount();
        long r4 = getNanoTime();
        Interpolator r5 = this.mProgressInterpolator;
        if (r5 == null) goto L38;
        r6 = r5.getInterpolation(r6);
    L38:
        if (r7 >= r2) goto L44;
        View r10 = getChildAt(r7);
        m r11 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r10), m.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L42;
        r11.a(r10, r6, r4, this.mKeyCache);
    L42:
        r7 = r7 + 1;
        goto L38
    L44:
        if (this.mMeasureDuringTransition == false) goto L51;
        requestLayout();
        return;
    L51:
        return;
    L30:
        if (r0 > 0.0f) goto L34;
        if (r6 > this.mTransitionGoalPosition) goto L34;
    L14:
        if (r0 <= 0.0f) goto L16;
    L18:
        r8 = false;
        goto L19
    L16:
        if (r6 > this.mTransitionGoalPosition) goto L18;
    L5:
        r3 = 0.0f;
        goto L6
    }

    void endTrigger(boolean r6) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = getChildAt(r1);
        m r3 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r2), m.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r3.a(r6);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    void evaluate(boolean r24) {
        if (this.mTransitionLastTime != (-1)) goto L5;
        this.mTransitionLastTime = getNanoTime();
    L5:
        float r1 = this.mTransitionLastPosition;
        if (r1 > 0.0f) goto L8;
    L10:
        boolean r7 = false;
        if (this.mKeepAnimating == false) goto L13;
    L19:
        float r2 = Math.signum(this.mTransitionGoalPosition - r1);
        long r8 = getNanoTime();
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, MotionInterpolator.class) == true) goto L22;
        float r3 = (((r8 - this.mTransitionLastTime) * r2) * 1.0E-9f) / this.mTransitionDuration;
    L23:
        float r11 = this.mTransitionLastPosition + r3;
        if (this.mTransitionInstantly == false) goto L27;
        r11 = this.mTransitionGoalPosition;
    L27:
        if (r2 <= 0.0f) goto L31;
        if (r11 < this.mTransitionGoalPosition) goto L31;
    L34:
        r11 = this.mTransitionGoalPosition;
        this.mInTransition = false;
        boolean r13 = true;
    L36:
        this.mTransitionLastPosition = r11;
        this.mTransitionPosition = r11;
        this.mTransitionLastTime = r8;
        Interpolator r15 = this.mInterpolator;
        if (r15 == null) goto L70;
        if (r13 == true) goto L70;
        if (this.mTemporalInterpolator == false) goto L65;
        float r4 = r15.getInterpolation((r8 - this.mAnimationStartTime) * 1.0E-9f);
        Interpolator r5 = this.mInterpolator;
        StopLogic r6 = this.mStopLogic;
        if (r5 == r6) goto L44;
        char r9 = 0;
    L48:
        this.mTransitionLastPosition = r4;
        this.mTransitionLastTime = r8;
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, MotionInterpolator.class) == false) goto L64;
        float r10 = ((MotionInterpolator) ZeusTransformUtils.preCheckCast(this.mInterpolator, MotionInterpolator.class, "com.obric.aiagent.plugin")).getVelocity();
        this.mLastVelocity = r10;
        if ((Math.abs(r10) * this.mTransitionDuration) > EPSILON) goto L55;
        if (r9 != 2) goto L55;
        this.mInTransition = false;
    L55:
        if (r10 <= 0.0f) goto L60;
        if (r4 < 1.0f) goto L60;
        this.mTransitionLastPosition = 1.0f;
        this.mInTransition = false;
        r4 = 1.0f;
    L60:
        if (r10 >= 0.0f) goto L64;
        if (r4 > 0.0f) goto L64;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = false;
        r11 = 0.0f;
    L73:
        if (Math.abs(this.mLastVelocity) <= EPSILON) goto L76;
        setState(g.f860c);
    L76:
        if (r9 == 1) goto L90;
        if (r2 <= 0.0f) goto L81;
        if (r11 < this.mTransitionGoalPosition) goto L81;
    L84:
        r11 = this.mTransitionGoalPosition;
        this.mInTransition = false;
    L86:
        if (r11 < 1.0f) goto L88;
    L89:
        this.mInTransition = false;
        setState(g.f861d);
        goto L90
    L88:
        if (r11 > 0.0f) goto L90;
    L81:
        if (r2 > 0.0f) goto L86;
        if (r11 > this.mTransitionGoalPosition) goto L86;
    L90:
        int r12 = getChildCount();
        this.mKeepAnimating = false;
        long r14 = getNanoTime();
        this.mPostInterpolationPosition = r11;
        Interpolator r16 = this.mProgressInterpolator;
        if (r16 != null) goto L93;
        float r17 = r11;
    L94:
        Interpolator r18 = this.mProgressInterpolator;
        if (r18 == null) goto L97;
        float r19 = r18.getInterpolation((r2 / this.mTransitionDuration) + r11);
        this.mLastVelocity = r19;
        this.mLastVelocity = r19 - this.mProgressInterpolator.getInterpolation(r11);
    L97:
        int r20 = 0;
    L98:
        if (r20 >= r12) goto L103;
        View r110 = getChildAt(r20);
        m r111 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r110), m.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L102;
        this.mKeepAnimating = r111.a(r110, r17, r14, this.mKeyCache) | this.mKeepAnimating;
    L102:
        r20 = r20 + 1;
        goto L98
    L103:
        if (r2 <= 0.0f) goto L107;
        if (r11 < this.mTransitionGoalPosition) goto L107;
    L110:
        boolean r21 = true;
    L113:
        if (this.mKeepAnimating == true) goto L119;
        if (this.mInTransition == true) goto L119;
        if (r21 == false) goto L119;
        setState(g.f861d);
    L119:
        if (this.mMeasureDuringTransition == false) goto L121;
        requestLayout();
    L121:
        boolean r22 = true;
        this.mKeepAnimating = (!r21) | this.mKeepAnimating;
        if (r11 > 0.0f) goto L129;
        int r23 = this.mBeginState;
        if (r23 == (-1)) goto L129;
        if (this.mCurrentState == r23) goto L129;
        this.mCurrentState = r23;
        this.mScene.d(r23).d(this);
        setState(g.f861d);
        r7 = true;
    L129:
        if (r11 < 1.0d) goto L134;
        int r25 = this.mCurrentState;
        int r26 = this.mEndState;
        if (r25 == r26) goto L134;
        this.mCurrentState = r26;
        this.mScene.d(r26).d(this);
        setState(g.f861d);
        r7 = true;
    L134:
        if (this.mKeepAnimating == false) goto L136;
    L146:
        invalidate();
    L148:
        if (this.mKeepAnimating == false) goto L150;
    L159:
        float r27 = this.mTransitionLastPosition;
        if (r27 < 1.0f) goto L168;
        int r28 = this.mCurrentState;
        int r29 = this.mEndState;
        if (r28 == r29) goto L164;
        boolean r30 = r22;
    L165:
        this.mCurrentState = r29;
    L166:
        r7 = r30;
    L174:
        this.mNeedsFireTransitionCompleted |= r7;
        if (r7 == true) goto L177;
    L179:
        this.mTransitionPosition = this.mTransitionLastPosition;
        return;
    L177:
        if (this.mInLayout == true) goto L179;
        requestLayout();
        goto L179
    L164:
        r30 = r7;
        goto L165
    L168:
        if (r27 > 0.0f) goto L174;
        int r31 = this.mCurrentState;
        int r32 = this.mBeginState;
        if (r31 == r32) goto L172;
        r30 = r22;
    L173:
        this.mCurrentState = r32;
        goto L166
    L172:
        r30 = r7;
        goto L173
    L150:
        if (this.mInTransition == true) goto L159;
        if (r2 <= 0.0f) goto L155;
        if (r11 != 1.0f) goto L155;
    L158:
        onNewStateAttachHandlers();
    L155:
        if (r2 >= 0.0f) goto L159;
        if (r11 != 0.0f) goto L159;
    L136:
        if (this.mInTransition == true) goto L146;
        if (r2 <= 0.0f) goto L142;
        if (r11 != 1.0f) goto L142;
    L145:
        setState(g.f861d);
    L142:
        if (r2 >= 0.0f) goto L148;
        if (r11 != 0.0f) goto L148;
    L107:
        if (r2 <= 0.0f) goto L109;
    L111:
        r21 = false;
        goto L113
    L109:
        if (r11 > this.mTransitionGoalPosition) goto L111;
    L93:
        r17 = r16.getInterpolation(r11);
    L64:
        r11 = r4;
        goto L73
    L44:
        if (r6.isStopped() == false) goto L46;
        r9 = 2;
        goto L48
    L46:
        r9 = 1;
        goto L48
    L65:
        float r33 = r15.getInterpolation(r11);
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, MotionInterpolator.class) == false) goto L68;
        this.mLastVelocity = ((MotionInterpolator) ZeusTransformUtils.preCheckCast(this.mInterpolator, MotionInterpolator.class, "com.obric.aiagent.plugin")).getVelocity();
    L69:
        r11 = r33;
    L71:
        r9 = 0;
        goto L73
    L68:
        this.mLastVelocity = ((this.mInterpolator.getInterpolation(r11 + r3) - r33) * r2) / r3;
    L70:
        this.mLastVelocity = r3;
    L31:
        if (r2 <= 0.0f) goto L33;
    L35:
        r13 = false;
        goto L36
    L33:
        if (r11 > this.mTransitionGoalPosition) goto L35;
    L22:
        r3 = 0.0f;
        goto L23
    L13:
        if (this.mInTransition == false) goto L18;
        if (r24 == true) goto L19;
        if (this.mTransitionGoalPosition != r1) goto L19;
    L18:
        r22 = true;
        goto L159
    L8:
        if (r1 >= 1.0f) goto L10;
        this.mCurrentState = -1;
        goto L10
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        this.mInLayout = true;
    L17:
        th = move-exception;
        this.mInLayout = false;
        throw th;
    L4:
        if (this.mScene != null) goto L8;
        super.onLayout(r4, r5, r6, r7, r8);     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L8:
        int r9 = r7 - r5;
        int r10 = r8 - r6;
        if (this.mLastLayoutWidth == r9) goto L12;
    L13:
        rebuildScene();     // Catch: Throwable -> L17
        evaluate(true);     // Catch: Throwable -> L17
    L14:
        this.mLastLayoutWidth = r9;     // Catch: Throwable -> L17
        this.mLastLayoutHeight = r10;     // Catch: Throwable -> L17
        this.mOldWidth = r9;     // Catch: Throwable -> L17
        this.mOldHeight = r10;     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L12:
        if (this.mLastLayoutHeight == r10) goto L14;
        goto L13
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int r1) {
        this.mConstraintLayoutSpec = null;
    }

    private void init(AttributeSet r12) {
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        IS_IN_EDIT_MODE = isInEditMode();
        if (r13 == null) goto L37;
        TypedArray r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r13, R.styleable.MotionLayout);
        int r2 = r14.getIndexCount();
        boolean r6 = true;
        int r5 = 0;
    L5:
        if (r5 >= r2) goto L31;
        int r7 = r14.getIndex(r5);
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_layoutDescription, "styleable", "MotionLayout_layoutDescription")) goto L10;
        this.mScene = new MotionScene((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, r14.getResourceId(r7, -1));
    L30:
        r5 = r5 + 1;
        goto L5
    L10:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_currentState, "styleable", "MotionLayout_currentState")) goto L13;
        this.mCurrentState = r14.getResourceId(r7, -1);
        goto L30
    L13:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_motionProgress, "styleable", "MotionLayout_motionProgress")) goto L16;
        this.mTransitionGoalPosition = r14.getFloat(r7, 0.0f);
        this.mInTransition = true;
        goto L30
    L16:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_applyMotionScene, "styleable", "MotionLayout_applyMotionScene")) goto L19;
        r6 = r14.getBoolean(r7, r6);
        goto L30
    L19:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_showPaths, "styleable", "MotionLayout_showPaths")) goto L28;
        if (this.mDebugPath != 0) goto L30;
        if (r14.getBoolean(r7, false) == false) goto L25;
        int r8 = 2;
    L26:
        this.mDebugPath = r8;
        goto L30
    L25:
        r8 = 0;
        goto L26
    L28:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_motionDebug, "styleable", "MotionLayout_motionDebug")) goto L30;
        this.mDebugPath = r14.getInt(r7, 0);
        goto L30
    L31:
        r14.recycle();
        if (this.mScene != null) goto L34;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "WARNING NO app:layoutDescription tag");
    L34:
        if (r6 == true) goto L37;
        this.mScene = null;
    L37:
        if (this.mDebugPath == 0) goto L40;
        checkStructure();
    L40:
        if (this.mCurrentState != (-1)) goto L54;
        MotionScene r15 = this.mScene;
        if (r15 == null) goto L55;
        this.mCurrentState = r15.d();
        this.mBeginState = this.mScene.d();
        this.mEndState = this.mScene.e();
        return;
    L55:
        return;
    }

    public void setScene(MotionScene r2) {
        this.mScene = r2;
        r2.a(isRtl());
        rebuildScene();
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    private void checkStructure() {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L6;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
        return;
    L6:
        int r1 = r0.d();
        MotionScene r2 = this.mScene;
        checkStructure(r1, r2.d(r2.d()));
        SparseIntArray r3 = new SparseIntArray();
        SparseIntArray r4 = new SparseIntArray();
        Iterator<MotionScene.Transition> r5 = this.mScene.a().iterator();
    L8:
        if (r5.hasNext() == false) goto L24;
        MotionScene.Transition r6 = (MotionScene.Transition) ZeusTransformUtils.preCheckCast(r5.next(), MotionScene.Transition.class, "com.obric.aiagent.plugin");
        if (r6 != this.mScene.f864b) goto L12;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, "CHECK: CURRENT");
    L12:
        checkStructure(r6);
        int r7 = r6.d();
        int r8 = r6.c();
        String r9 = androidx.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7);
        String r10 = androidx.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8);
        if (r3.get(r7) != r8) goto L16;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "CHECK: two transitions with the same start and end " + r9 + "->" + r10);
    L16:
        if (r4.get(r8) != r7) goto L18;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "CHECK: you can't have reverse transitions" + r9 + "->" + r10);
    L18:
        r3.put(r7, r8);
        r4.put(r8, r7);
        if (this.mScene.d(r7) != null) goto L22;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, " no such constraintSetStart " + r9);
    L22:
        if (this.mScene.d(r8) != null) goto L8;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, " no such constraintSetEnd " + r9);
        goto L8
    }

    private void checkStructure(int r12, androidx.constraintlayout.widget.c r13) {
        String r14 = androidx.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12);
        int r0 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L12;
        View r7 = getChildAt(r3);
        int r8 = r7.getId();
        if (r8 != (-1)) goto L9;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "CHECK: " + r14 + " ALL VIEWS SHOULD HAVE ID's " + r7.getClass().getName() + " does not!");
    L9:
        if (r13.f(r8) != null) goto L11;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "CHECK: " + r14 + " NO CONSTRAINTS for " + androidx.constraintlayout.motion.widget.a.a(r7));
    L11:
        r3 = r3 + 1;
        goto L4
    L12:
        int[] r1 = r13.a();
    L14:
        if (r2 >= r1.length) goto L25;
        int r4 = r1[r2];
        String r9 = androidx.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        if (findViewById(r1[r2]) != null) goto L19;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "CHECK: " + r14 + " NO View matches id " + r9);
    L19:
        if (r13.d(r4) != (-1)) goto L22;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "CHECK: " + r14 + "(" + r9 + ") no LAYOUT_HEIGHT");
    L22:
        if (r13.e(r4) != (-1)) goto L24;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "CHECK: " + r14 + "(" + r9 + ") no LAYOUT_HEIGHT");
    L24:
        r2 = r2 + 1;
        goto L14
    }

    private void checkStructure(MotionScene.Transition r1) {
        if (r1.d() != r1.c()) goto L6;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "CHECK: start and end constraint set should not be the same!");
        return;
    }

    public void setDebugMode(int r1) {
        this.mDebugPath = r1;
        invalidate();
    }

    public void getDebugMode(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 2;
    L5:
        this.mDebugPath = r2;
        invalidate();
        return;
    L4:
        r2 = 1;
        goto L5
    }

    private boolean callTransformedTouchEvent(View r3, MotionEvent r4, float r5, float r6) {
        Matrix r0 = r3.getMatrix();
        if (r0.isIdentity() == false) goto L6;
        r4.offsetLocation(r5, r6);
        boolean r2 = r3.onTouchEvent(r4);
        r4.offsetLocation(-r5, -r6);
        return r2;
    L6:
        MotionEvent r7 = MotionEvent.obtain(r4);
        r7.offsetLocation(r5, r6);
        if (this.mInverseMatrix != null) goto L9;
        this.mInverseMatrix = new Matrix();
    L9:
        r0.invert(this.mInverseMatrix);
        r7.transform(this.mInverseMatrix);
        boolean r8 = r3.onTouchEvent(r7);
        r7.recycle();
        return r8;
    }

    private boolean handlesTouchEvent(float r8, float r9, View r10, MotionEvent r11) {
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.class) == false) goto L10;
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.aiagent.plugin");
        int r2 = r0.getChildCount() - 1;
    L5:
        if (r2 < 0) goto L10;
        View r3 = r0.getChildAt(r2);
        if (handlesTouchEvent((r3.getLeft() + r8) - r10.getScrollX(), (r3.getTop() + r9) - r10.getScrollY(), r3, r11) == true) goto L8;
        r2 = r2 - 1;
        goto L5
    L8:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L20;
        this.mBoundsCheck.set(r8, r9, (r10.getRight() + r8) - r10.getLeft(), (r10.getBottom() + r9) - r10.getTop());
        if (r11.getAction() != 0) goto L17;
        if (this.mBoundsCheck.contains(r11.getX(), r11.getY()) == false) goto L20;
    L17:
        if (callTransformedTouchEvent(r10, r11, -r8, -r9) == false) goto L20;
        return true;
    L20:
        return r1;
    L10:
        r1 = false;
        goto L11
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
    L38:
        return false;
    L5:
        if (this.mInteractionEnabled == false) goto L38;
        if (r0.f865c == null) goto L10;
        this.mScene.f865c.a(r7);
    L10:
        MotionScene.Transition r1 = this.mScene.f864b;
        if (r1 == null) goto L38;
        if (r1.f() == false) goto L38;
        p r2 = r1.e();
        if (r2 == null) goto L38;
        if (r7.getAction() != 0) goto L23;
        RectF r3 = r2.a(this, new RectF());
        if (r3 == null) goto L23;
        if (r3.contains(r7.getX(), r7.getY()) == true) goto L23;
        return false;
    L23:
        int r4 = r2.f();
        if (r4 == (-1)) goto L38;
        View r5 = this.mRegionView;
        if (r5 != null) goto L28;
    L29:
        this.mRegionView = findViewById(r4);
    L30:
        View r6 = this.mRegionView;
        if (r6 == null) goto L38;
        this.mBoundsCheck.set(r6.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
        if (this.mBoundsCheck.contains(r7.getX(), r7.getY()) == false) goto L38;
        if (handlesTouchEvent(this.mRegionView.getLeft(), this.mRegionView.getTop(), this.mRegionView, r7) == true) goto L38;
        return onTouchEvent(r7);
    L28:
        if (r5.getId() == r4) goto L30;
        goto L29
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L21;
        if (this.mInteractionEnabled == false) goto L21;
        if (r0.c() == false) goto L21;
        MotionScene.Transition r1 = this.mScene.f864b;
        if (r1 != null) goto L11;
    L14:
        this.mScene.a(r3, getCurrentState(), this);
        if (this.mScene.f864b.c(4) == true) goto L17;
        return true;
    L17:
        return this.mScene.f864b.e().m();
    L11:
        if (r1.f() == true) goto L14;
        return super.onTouchEvent(r3);
    L21:
        return super.onTouchEvent(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT < 17) goto L7;
        Display r0 = getDisplay();
        if (r0 == null) goto L7;
        this.mPreviouseRotation = r0.getRotation();
    L7:
        MotionScene r1 = this.mScene;
        if (r1 == null) goto L20;
        int r2 = this.mCurrentState;
        if (r2 == (-1)) goto L20;
        androidx.constraintlayout.widget.c r3 = r1.d(r2);
        this.mScene.a(this);
        ArrayList<MotionHelper> r4 = this.mDecoratorsHelpers;
        if (r4 == null) goto L17;
        Iterator<MotionHelper> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r5.next(), MotionHelper.class, "com.obric.aiagent.plugin")).onFinishedMotionScene(this);
    L17:
        if (r3 == null) goto L19;
        r3.c(this);
    L19:
        this.mBeginState = this.mCurrentState;
    L20:
        onNewStateAttachHandlers();
        e r6 = this.mStateCache;
        if (r6 != null) goto L23;
        MotionScene r7 = this.mScene;
        if (r7 != null) goto L29;
        return;
    L29:
        if (r7.f864b != null) goto L31;
        return;
    L31:
        if (this.mScene.f864b.b() != 4) goto L39;
        transitionToEnd();
        setState(g.f859b);
        setState(g.f860c);
        return;
    L39:
        return;
    L23:
        if (this.mDelayedApply == false) goto L25;
        post(new AnonymousClass4(this));
        return;
    L25:
        r6.a();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r1) {
        MotionScene r2 = this.mScene;
        if (r2 == null) goto L6;
        r2.a(isRtl());
        return;
    }

    void onNewStateAttachHandlers() {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.b(this, this.mCurrentState) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r1 = this.mCurrentState;
        if (r1 == (-1)) goto L13;
        this.mScene.a(this, r1);
    L13:
        if (this.mScene.c() == false) goto L16;
        this.mScene.r();
        return;
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    void getAnchorDpDt(int r5, float r6, float r7, float r8, float[] r9) {
        HashMap<View, m> r0 = this.mFrameArrayList;
        View r1 = getViewById(r5);
        m r2 = (m) ZeusTransformUtils.preCheckCast(r0.get(r1), m.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        r2.a(r6, r7, r8, r9);
        float r10 = r1.getY();
        int r11 = ((r6 - this.lastPos) > 0.0f ? 1 : ((r6 - this.lastPos) == 0.0f ? 0 : -1));
        this.lastPos = r6;
        this.lastY = r10;
        return;
    L5:
        if (r1 != null) goto L7;
        String r4 = "" + r5;
    L8:
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "WARNING could not find view id " + r4);
        return;
    L7:
        r4 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getResourceName(r5);
        goto L8
    }

    public long getTransitionTimeMs() {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L6;
        this.mTransitionDuration = r0.g() / 1000.0f;
    L6:
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public void setTransitionListener(f r3) {
        this.mTransitionListener = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
    }

    public void addTransitionListener(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        if (this.mTransitionListeners != null) goto L5;
        this.mTransitionListeners = new CopyOnWriteArrayList();
    L5:
        this.mTransitionListeners.add(r4);
    }

    public boolean removeTransitionListener(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        CopyOnWriteArrayList<f> r2 = this.mTransitionListeners;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.remove(r4);
    }

    public void fireTrigger(int r5, boolean r6, float r7) {
        f r0 = this.mTransitionListener;
        if (r0 == null) goto L5;
        r0.onTransitionTrigger(this, r5, r6, r7);
    L5:
        CopyOnWriteArrayList<f> r1 = this.mTransitionListeners;
        if (r1 == null) goto L11;
        Iterator<f> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        ((f) ZeusTransformUtils.preCheckCast(r2.next(), f.class, "com.obric.aiagent.plugin")).onTransitionTrigger(this, r5, r6, r7);
        goto L9
    L13:
        return;
    }

    private void fireTransitionChange() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<f> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.mListenerPosition != this.mTransitionPosition) goto L11;
        return;
    L11:
        if (this.mListenerState == (-1)) goto L22;
        f r1 = this.mTransitionListener;
        if (r1 == null) goto L15;
        r1.onTransitionStarted(this, this.mBeginState, this.mEndState);
    L15:
        CopyOnWriteArrayList<f> r2 = this.mTransitionListeners;
        if (r2 == null) goto L21;
        Iterator<f> r3 = r2.iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        ((f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.aiagent.plugin")).onTransitionStarted(this, this.mBeginState, this.mEndState);
    L21:
        this.mIsAnimating = true;
    L22:
        this.mListenerState = -1;
        float r4 = this.mTransitionPosition;
        this.mListenerPosition = r4;
        f r5 = this.mTransitionListener;
        if (r5 == null) goto L25;
        r5.onTransitionChange(this, this.mBeginState, this.mEndState, r4);
    L25:
        CopyOnWriteArrayList<f> r6 = this.mTransitionListeners;
        if (r6 == null) goto L31;
        Iterator<f> r7 = r6.iterator();
    L29:
        if (r7.hasNext() == false) goto L31;
        ((f) ZeusTransformUtils.preCheckCast(r7.next(), f.class, "com.obric.aiagent.plugin")).onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
    L31:
        this.mIsAnimating = true;
    }

    public void fireTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<f> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
    L18:
        processTransitionCompleted();
        Runnable r1 = this.mOnComplete;
        if (r1 == null) goto L21;
        r1.run();
    L21:
        int[] r2 = this.mScheduledTransitionTo;
        if (r2 != null) goto L24;
        return;
    L24:
        if (this.mScheduledTransitions <= 0) goto L28;
        transitionToState(r2[0]);
        int[] r3 = this.mScheduledTransitionTo;
        System.arraycopy(r3, 1, r3, 0, r3.length - 1);
        this.mScheduledTransitions--;
        return;
    L28:
        return;
    L7:
        if (r0.isEmpty() == true) goto L18;
    L9:
        if (this.mListenerState != (-1)) goto L18;
        this.mListenerState = this.mCurrentState;
        if (this.mTransitionCompleted.isEmpty() == true) goto L13;
        ArrayList<Integer> r4 = this.mTransitionCompleted;
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r4.get(r4.size() - 1), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L14:
        int r6 = this.mCurrentState;
        if (r5 == r6) goto L18;
        if (r6 == (-1)) goto L18;
        this.mTransitionCompleted.add(Integer.valueOf(r6));
        goto L18
    L13:
        r5 = -1;
        goto L14
    }

    private void processTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<f> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return;
    L9:
        this.mIsAnimating = false;
        Iterator<Integer> r1 = this.mTransitionCompleted.iterator();
    L11:
        if (r1.hasNext() == false) goto L21;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.aiagent.plugin");
        f r3 = this.mTransitionListener;
        if (r3 == null) goto L15;
        r3.onTransitionCompleted(this, r2.intValue());
    L15:
        CopyOnWriteArrayList<f> r4 = this.mTransitionListeners;
        if (r4 == null) goto L11;
        Iterator<f> r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L11;
        ((f) ZeusTransformUtils.preCheckCast(r5.next(), f.class, "com.obric.aiagent.plugin")).onTransitionCompleted(this, r2.intValue());
        goto L19
    L21:
        this.mTransitionCompleted.clear();
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.mDesignTool != null) goto L6;
        this.mDesignTool = new androidx.constraintlayout.motion.widget.b(this);
    L6:
        return this.mDesignTool;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View r3) {
        super.onViewAdded(r3);
        if (ZeusTransformUtils.instanceOf(r3, MotionHelper.class) == false) goto L26;
        MotionHelper r4 = (MotionHelper) ZeusTransformUtils.preCheckCast(r3, MotionHelper.class, "com.obric.aiagent.plugin");
        if (this.mTransitionListeners != null) goto L7;
        this.mTransitionListeners = new CopyOnWriteArrayList();
    L7:
        this.mTransitionListeners.add(r4);
        if (r4.isUsedOnShow() == false) goto L14;
        if (this.mOnShowHelpers != null) goto L12;
        this.mOnShowHelpers = new ArrayList();
    L12:
        this.mOnShowHelpers.add(r4);
    L14:
        if (r4.isUseOnHide() == false) goto L20;
        if (this.mOnHideHelpers != null) goto L18;
        this.mOnHideHelpers = new ArrayList();
    L18:
        this.mOnHideHelpers.add(r4);
    L20:
        if (r4.isDecorator() == true) goto L22;
        return;
    L22:
        if (this.mDecoratorsHelpers != null) goto L24;
        this.mDecoratorsHelpers = new ArrayList();
    L24:
        this.mDecoratorsHelpers.add(r4);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r2) {
        super.onViewRemoved(r2);
        ArrayList<MotionHelper> r0 = this.mOnShowHelpers;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        ArrayList<MotionHelper> r1 = this.mOnHideHelpers;
        if (r1 == null) goto L9;
        r1.remove(r2);
        return;
    }

    public void setOnShow(float r6) {
        ArrayList<MotionHelper> r0 = this.mOnShowHelpers;
        if (r0 == null) goto L7;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(this.mOnShowHelpers.get(r2), MotionHelper.class, "com.obric.aiagent.plugin")).setProgress(r6);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnHide(float r6) {
        ArrayList<MotionHelper> r0 = this.mOnHideHelpers;
        if (r0 == null) goto L7;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(this.mOnHideHelpers.get(r2), MotionHelper.class, "com.obric.aiagent.plugin")).setProgress(r6);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public int[] getConstraintSetIds() {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public androidx.constraintlayout.widget.c getConstraintSet(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d(r1);
    }

    public androidx.constraintlayout.widget.c cloneConstraintSet(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L6;
        return null;
    L6:
        androidx.constraintlayout.widget.c r2 = r0.d(r1);
        androidx.constraintlayout.widget.c r3 = new androidx.constraintlayout.widget.c();
        r3.c(r2);
        return r3;
    }

    @Deprecated
    public void rebuildMotion() {
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.a();
        invalidate();
    }

    public void updateState(int r2, androidx.constraintlayout.widget.c r3) {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L5;
        r0.a(r2, r3);
    L5:
        updateState();
        if (this.mCurrentState != r2) goto L9;
        r3.c(this);
        return;
    }

    public void updateStateAnimate(int r6, androidx.constraintlayout.widget.c r7, int r8) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mCurrentState != r6) goto L9;
        updateState(ZeusTransformUtils.mapRes(R.id.view_transition, DbHelper.COL_ID, "view_transition"), getConstraintSet(r6));
        setState(ZeusTransformUtils.mapRes(R.id.view_transition, DbHelper.COL_ID, "view_transition"), -1, -1);
        updateState(r6, r7);
        MotionScene.Transition r9 = new MotionScene.Transition(-1, this.mScene, ZeusTransformUtils.mapRes(R.id.view_transition, DbHelper.COL_ID, "view_transition"), r6);
        r9.a(r8);
        setTransition(r9);
        transitionToEnd();
        return;
    }

    public void scheduleTransitionTo(int r4) {
        if (getCurrentState() != (-1)) goto L5;
        transitionToState(r4);
        return;
    L5:
        int[] r0 = this.mScheduledTransitionTo;
        if (r0 != null) goto L9;
        this.mScheduledTransitionTo = new int[4];
    L11:
        int[] r1 = this.mScheduledTransitionTo;
        int r2 = this.mScheduledTransitions;
        this.mScheduledTransitions = r2 + 1;
        r1[r2] = r4;
        return;
    L9:
        if (r0.length > this.mScheduledTransitions) goto L11;
        this.mScheduledTransitionTo = Arrays.copyOf(r0, r0.length * 2);
        goto L11
    }

    public void updateState() {
        this.mModel.a(this.mLayoutWidget, this.mScene.d(this.mBeginState), this.mScene.d(this.mEndState));
        rebuildScene();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public void setTransitionDuration(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L6;
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "MotionScene not defined");
        return;
    L6:
        r0.e(r1);
    }

    public MotionScene.Transition getTransition(int r1) {
        return this.mScene.b(r1);
    }

    int lookUpConstraintId(String r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b(r1);
    }

    String getConstraintSetNames(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f(r1);
    }

    void disableAutoTransition(boolean r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r1);
    }

    public void setInteractionEnabled(boolean r1) {
        this.mInteractionEnabled = r1;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    private void fireTransitionStarted(MotionLayout r4, int r5, int r6) {
        f r0 = this.mTransitionListener;
        if (r0 == null) goto L5;
        r0.onTransitionStarted(this, r5, r6);
    L5:
        CopyOnWriteArrayList<f> r3 = this.mTransitionListeners;
        if (r3 == null) goto L11;
        Iterator<f> r7 = r3.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        ((f) ZeusTransformUtils.preCheckCast(r7.next(), f.class, "com.obric.aiagent.plugin")).onTransitionStarted(r4, r5, r6);
        goto L9
    L13:
        return;
    }

    public void viewTransition(int r1, View... r2) {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L5;
        r0.a(r1, r2);
        return;
    L5:
        INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, " no motionScene");
    }

    public void enableViewTransition(int r1, boolean r2) {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public boolean isViewTransitionEnabled(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.c(r1);
    }

    public boolean applyViewTransition(int r1, m r2) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a(r1, r2);
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.mDelayedApply;
    }

    public void setDelayedApplicationOfInitialState(boolean r1) {
        this.mDelayedApply = r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}

package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
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
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.q;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.d;
import androidx.core.view.InterfaceC1336y;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import m0.C4891d;
import o0.C4994b;
import o0.InterfaceC4993a;
import q0.C5138b;
import q0.C5141e;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements InterfaceC1336y {
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
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private d mDecelerateLogic;
    private ArrayList<n> mDecoratorsHelpers;
    private boolean mDelayedApply;
    private androidx.constraintlayout.motion.widget.b mDesignTool;
    e mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    boolean mFirstDown;
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
    private C4891d mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    private float mLastPos;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mLastY;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    f mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private Runnable mOnComplete;
    private ArrayList<n> mOnHideHelpers;
    private ArrayList<n> mOnShowHelpers;
    float mPostInterpolationPosition;
    HashMap<View, C5141e> mPreRotate;
    private int mPreRotateHeight;
    private int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator;
    private View mRegionView;
    int mRotatMode;
    q mScene;
    private int[] mScheduledTransitionTo;
    int mScheduledTransitions;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private i mStateCache;
    private C5138b mStopLogic;
    Rect mTempRect;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private j mTransitionListener;
    private CopyOnWriteArrayList<j> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.mStateCache.a();
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12184a;

        public b(View view) {
            this.f12184a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12184a.setNestedScrollingEnabled(true);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.mStateCache.a();
        }
    }

    public class d extends o {

        /* renamed from: a, reason: collision with root package name */
        public float f12187a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f12188b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f12189c;

        public d() {
        }

        @Override // androidx.constraintlayout.motion.widget.o
        public float a() {
            return MotionLayout.this.mLastVelocity;
        }

        public void b(float f10, float f11, float f12) {
            this.f12187a = f10;
            this.f12188b = f11;
            this.f12189c = f12;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11;
            float f12;
            float f13 = this.f12187a;
            if (f13 > 0.0f) {
                float f14 = this.f12189c;
                if (f13 / f14 < f10) {
                    f10 = f13 / f14;
                }
                MotionLayout.this.mLastVelocity = f13 - (f14 * f10);
                f11 = (f13 * f10) - (((f14 * f10) * f10) / 2.0f);
                f12 = this.f12188b;
            } else {
                float f15 = this.f12189c;
                if ((-f13) / f15 < f10) {
                    f10 = (-f13) / f15;
                }
                MotionLayout.this.mLastVelocity = (f15 * f10) + f13;
                f11 = (f13 * f10) + (((f15 * f10) * f10) / 2.0f);
                f12 = this.f12188b;
            }
            return f11 + f12;
        }
    }

    public class e {

        /* renamed from: a, reason: collision with root package name */
        public float[] f12191a;

        /* renamed from: b, reason: collision with root package name */
        public int[] f12192b;

        /* renamed from: c, reason: collision with root package name */
        public float[] f12193c;

        /* renamed from: d, reason: collision with root package name */
        public Path f12194d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f12195e;

        /* renamed from: f, reason: collision with root package name */
        public Paint f12196f;

        /* renamed from: g, reason: collision with root package name */
        public Paint f12197g;

        /* renamed from: h, reason: collision with root package name */
        public Paint f12198h;

        /* renamed from: i, reason: collision with root package name */
        public Paint f12199i;

        /* renamed from: j, reason: collision with root package name */
        public float[] f12200j;

        /* renamed from: p, reason: collision with root package name */
        public DashPathEffect f12206p;

        /* renamed from: q, reason: collision with root package name */
        public int f12207q;

        /* renamed from: t, reason: collision with root package name */
        public int f12210t;

        /* renamed from: k, reason: collision with root package name */
        public final int f12201k = -21965;

        /* renamed from: l, reason: collision with root package name */
        public final int f12202l = -2067046;

        /* renamed from: m, reason: collision with root package name */
        public final int f12203m = -13391360;

        /* renamed from: n, reason: collision with root package name */
        public final int f12204n = 1996488704;

        /* renamed from: o, reason: collision with root package name */
        public final int f12205o = 10;

        /* renamed from: r, reason: collision with root package name */
        public Rect f12208r = new Rect();

        /* renamed from: s, reason: collision with root package name */
        public boolean f12209s = false;

        public e() {
            this.f12210t = 1;
            Paint paint = new Paint();
            this.f12195e = paint;
            paint.setAntiAlias(true);
            this.f12195e.setColor(-21965);
            this.f12195e.setStrokeWidth(2.0f);
            Paint paint2 = this.f12195e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f12196f = paint3;
            paint3.setAntiAlias(true);
            this.f12196f.setColor(-2067046);
            this.f12196f.setStrokeWidth(2.0f);
            this.f12196f.setStyle(style);
            Paint paint4 = new Paint();
            this.f12197g = paint4;
            paint4.setAntiAlias(true);
            this.f12197g.setColor(-13391360);
            this.f12197g.setStrokeWidth(2.0f);
            this.f12197g.setStyle(style);
            Paint paint5 = new Paint();
            this.f12198h = paint5;
            paint5.setAntiAlias(true);
            this.f12198h.setColor(-13391360);
            this.f12198h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f12200j = new float[8];
            Paint paint6 = new Paint();
            this.f12199i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f12206p = dashPathEffect;
            this.f12197g.setPathEffect(dashPathEffect);
            this.f12193c = new float[100];
            this.f12192b = new int[50];
            if (this.f12209s) {
                this.f12195e.setStrokeWidth(8.0f);
                this.f12199i.setStrokeWidth(8.0f);
                this.f12196f.setStrokeWidth(8.0f);
                this.f12210t = 4;
            }
        }

        public void a(Canvas canvas, HashMap<View, m> map, int i10, int i11) {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i11 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ServerSentEventKt.COLON + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f12198h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f12195e);
            }
            for (m mVar : map.values()) {
                int iM = mVar.m();
                if (i11 > 0 && iM == 0) {
                    iM = 1;
                }
                if (iM != 0) {
                    this.f12207q = mVar.c(this.f12193c, this.f12192b);
                    if (iM >= 1) {
                        int i12 = i10 / 16;
                        float[] fArr = this.f12191a;
                        if (fArr == null || fArr.length != i12 * 2) {
                            this.f12191a = new float[i12 * 2];
                            this.f12194d = new Path();
                        }
                        int i13 = this.f12210t;
                        canvas.translate(i13, i13);
                        this.f12195e.setColor(1996488704);
                        this.f12199i.setColor(1996488704);
                        this.f12196f.setColor(1996488704);
                        this.f12197g.setColor(1996488704);
                        mVar.d(this.f12191a, i12);
                        b(canvas, iM, this.f12207q, mVar);
                        this.f12195e.setColor(-21965);
                        this.f12196f.setColor(-2067046);
                        this.f12199i.setColor(-2067046);
                        this.f12197g.setColor(-13391360);
                        int i14 = this.f12210t;
                        canvas.translate(-i14, -i14);
                        b(canvas, iM, this.f12207q, mVar);
                        if (iM == 5) {
                            j(canvas, mVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int i10, int i11, m mVar) {
            if (i10 == 4) {
                d(canvas);
            }
            if (i10 == 2) {
                g(canvas);
            }
            if (i10 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i10, i11, mVar);
        }

        public final void c(Canvas canvas) {
            canvas.drawLines(this.f12191a, this.f12195e);
        }

        public final void d(Canvas canvas) {
            boolean z10 = false;
            boolean z11 = false;
            for (int i10 = 0; i10 < this.f12207q; i10++) {
                int i11 = this.f12192b[i10];
                if (i11 == 1) {
                    z10 = true;
                }
                if (i11 == 0) {
                    z11 = true;
                }
            }
            if (z10) {
                g(canvas);
            }
            if (z11) {
                e(canvas);
            }
        }

        public final void e(Canvas canvas) {
            float[] fArr = this.f12191a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f10, f12), Math.max(f11, f13), Math.max(f10, f12), Math.max(f11, f13), this.f12197g);
            canvas.drawLine(Math.min(f10, f12), Math.min(f11, f13), Math.min(f10, f12), Math.max(f11, f13), this.f12197g);
        }

        public final void f(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f12191a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float fMin = Math.min(f12, f14);
            float fMax = Math.max(f13, f15);
            float fMin2 = f10 - Math.min(f12, f14);
            float fMax2 = Math.max(f13, f15) - f11;
            String str = "" + (((int) (((fMin2 * 100.0f) / Math.abs(f14 - f12)) + 0.5d)) / 100.0f);
            l(str, this.f12198h);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.f12208r.width() / 2)) + fMin, f11 - 20.0f, this.f12198h);
            canvas.drawLine(f10, f11, Math.min(f12, f14), f11, this.f12197g);
            String str2 = "" + (((int) (((fMax2 * 100.0f) / Math.abs(f15 - f13)) + 0.5d)) / 100.0f);
            l(str2, this.f12198h);
            canvas.drawText(str2, f10 + 5.0f, fMax - ((fMax2 / 2.0f) - (this.f12208r.height() / 2)), this.f12198h);
            canvas.drawLine(f10, f11, f10, Math.max(f13, f15), this.f12197g);
        }

        public final void g(Canvas canvas) {
            float[] fArr = this.f12191a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f12197g);
        }

        public final void h(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f12191a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f12 - f14, f13 - f15);
            float f16 = f14 - f12;
            float f17 = f15 - f13;
            float f18 = (((f10 - f12) * f16) + ((f11 - f13) * f17)) / (fHypot * fHypot);
            float f19 = f12 + (f16 * f18);
            float f20 = f13 + (f18 * f17);
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f19, f20);
            float fHypot2 = (float) Math.hypot(f19 - f10, f20 - f11);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            l(str, this.f12198h);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.f12208r.width() / 2), -20.0f, this.f12198h);
            canvas.drawLine(f10, f11, f19, f20, this.f12197g);
        }

        public final void i(Canvas canvas, float f10, float f11, int i10, int i11) {
            String str = "" + (((int) ((((f10 - (i10 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i10)) + 0.5d)) / 100.0f);
            l(str, this.f12198h);
            canvas.drawText(str, ((f10 / 2.0f) - (this.f12208r.width() / 2)) + 0.0f, f11 - 20.0f, this.f12198h);
            canvas.drawLine(f10, f11, Math.min(0.0f, 1.0f), f11, this.f12197g);
            String str2 = "" + (((int) ((((f11 - (i11 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i11)) + 0.5d)) / 100.0f);
            l(str2, this.f12198h);
            canvas.drawText(str2, f10 + 5.0f, 0.0f - ((f11 / 2.0f) - (this.f12208r.height() / 2)), this.f12198h);
            canvas.drawLine(f10, f11, f10, Math.max(0.0f, 1.0f), this.f12197g);
        }

        public final void j(Canvas canvas, m mVar) {
            this.f12194d.reset();
            for (int i10 = 0; i10 <= 50; i10++) {
                mVar.e(i10 / 50, this.f12200j, 0);
                Path path = this.f12194d;
                float[] fArr = this.f12200j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f12194d;
                float[] fArr2 = this.f12200j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f12194d;
                float[] fArr3 = this.f12200j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f12194d;
                float[] fArr4 = this.f12200j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f12194d.close();
            }
            this.f12195e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f12194d, this.f12195e);
            canvas.translate(-2.0f, -2.0f);
            this.f12195e.setColor(-65536);
            canvas.drawPath(this.f12194d, this.f12195e);
        }

        public final void k(Canvas canvas, int i10, int i11, m mVar) {
            int width;
            int height;
            View view = mVar.f12382b;
            if (view != null) {
                width = view.getWidth();
                height = mVar.f12382b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i12 = 1; i12 < i11 - 1; i12++) {
                if (i10 != 4 || this.f12192b[i12 - 1] != 0) {
                    float[] fArr = this.f12193c;
                    int i13 = i12 * 2;
                    float f10 = fArr[i13];
                    float f11 = fArr[i13 + 1];
                    this.f12194d.reset();
                    this.f12194d.moveTo(f10, f11 + 10.0f);
                    this.f12194d.lineTo(f10 + 10.0f, f11);
                    this.f12194d.lineTo(f10, f11 - 10.0f);
                    this.f12194d.lineTo(f10 - 10.0f, f11);
                    this.f12194d.close();
                    int i14 = i12 - 1;
                    mVar.q(i14);
                    if (i10 == 4) {
                        int i15 = this.f12192b[i14];
                        if (i15 == 1) {
                            h(canvas, f10 - 0.0f, f11 - 0.0f);
                        } else if (i15 == 0) {
                            f(canvas, f10 - 0.0f, f11 - 0.0f);
                        } else if (i15 == 2) {
                            i(canvas, f10 - 0.0f, f11 - 0.0f, width, height);
                        }
                        canvas.drawPath(this.f12194d, this.f12199i);
                    }
                    if (i10 == 2) {
                        h(canvas, f10 - 0.0f, f11 - 0.0f);
                    }
                    if (i10 == 3) {
                        f(canvas, f10 - 0.0f, f11 - 0.0f);
                    }
                    if (i10 == 6) {
                        i(canvas, f10 - 0.0f, f11 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.f12194d, this.f12199i);
                }
            }
            float[] fArr2 = this.f12191a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f12196f);
                float[] fArr3 = this.f12191a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f12196f);
            }
        }

        public void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f12208r);
        }
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        public androidx.constraintlayout.core.widgets.d f12212a = new androidx.constraintlayout.core.widgets.d();

        /* renamed from: b, reason: collision with root package name */
        public androidx.constraintlayout.core.widgets.d f12213b = new androidx.constraintlayout.core.widgets.d();

        /* renamed from: c, reason: collision with root package name */
        public androidx.constraintlayout.widget.c f12214c = null;

        /* renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.c f12215d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f12216e;

        /* renamed from: f, reason: collision with root package name */
        public int f12217f;

        public f() {
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0133 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 341
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.f.a():void");
        }

        public final void b(int i10, int i11) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.mCurrentState == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar = this.f12213b;
                androidx.constraintlayout.widget.c cVar = this.f12215d;
                motionLayout2.resolveSystem(dVar, optimizationLevel, (cVar == null || cVar.f12717e == 0) ? i10 : i11, (cVar == null || cVar.f12717e == 0) ? i11 : i10);
                androidx.constraintlayout.widget.c cVar2 = this.f12214c;
                if (cVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f12212a;
                    int i12 = cVar2.f12717e;
                    int i13 = i12 == 0 ? i10 : i11;
                    if (i12 == 0) {
                        i10 = i11;
                    }
                    motionLayout3.resolveSystem(dVar2, optimizationLevel, i13, i10);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.c cVar3 = this.f12214c;
            if (cVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar3 = this.f12212a;
                int i14 = cVar3.f12717e;
                motionLayout4.resolveSystem(dVar3, optimizationLevel, i14 == 0 ? i10 : i11, i14 == 0 ? i11 : i10);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            androidx.constraintlayout.core.widgets.d dVar4 = this.f12213b;
            androidx.constraintlayout.widget.c cVar4 = this.f12215d;
            int i15 = (cVar4 == null || cVar4.f12717e == 0) ? i10 : i11;
            if (cVar4 == null || cVar4.f12717e == 0) {
                i10 = i11;
            }
            motionLayout5.resolveSystem(dVar4, optimizationLevel, i15, i10);
        }

        public void c(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.core.widgets.d dVar2) {
            ArrayList<ConstraintWidget> arrayListW1 = dVar.w1();
            HashMap<ConstraintWidget, ConstraintWidget> map = new HashMap<>();
            map.put(dVar, dVar2);
            dVar2.w1().clear();
            dVar2.n(dVar, map);
            Iterator<ConstraintWidget> it = arrayListW1.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                ConstraintWidget aVar = next instanceof androidx.constraintlayout.core.widgets.a ? new androidx.constraintlayout.core.widgets.a() : next instanceof androidx.constraintlayout.core.widgets.f ? new androidx.constraintlayout.core.widgets.f() : next instanceof androidx.constraintlayout.core.widgets.e ? new androidx.constraintlayout.core.widgets.e() : next instanceof androidx.constraintlayout.core.widgets.h ? new androidx.constraintlayout.core.widgets.h() : next instanceof InterfaceC4993a ? new C4994b() : new ConstraintWidget();
                dVar2.a(aVar);
                map.put(next, aVar);
            }
            Iterator<ConstraintWidget> it2 = arrayListW1.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                map.get(next2).n(next2, map);
            }
        }

        public ConstraintWidget d(androidx.constraintlayout.core.widgets.d dVar, View view) {
            if (dVar.u() == view) {
                return dVar;
            }
            ArrayList<ConstraintWidget> arrayListW1 = dVar.w1();
            int size = arrayListW1.size();
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget = arrayListW1.get(i10);
                if (constraintWidget.u() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void e(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.widget.c cVar, androidx.constraintlayout.widget.c cVar2) {
            this.f12214c = cVar;
            this.f12215d = cVar2;
            this.f12212a = new androidx.constraintlayout.core.widgets.d();
            this.f12213b = new androidx.constraintlayout.core.widgets.d();
            this.f12212a.b2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.O1());
            this.f12213b.b2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.O1());
            this.f12212a.z1();
            this.f12213b.z1();
            c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f12212a);
            c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f12213b);
            if (MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (cVar != null) {
                    j(this.f12212a, cVar);
                }
                j(this.f12213b, cVar2);
            } else {
                j(this.f12213b, cVar2);
                if (cVar != null) {
                    j(this.f12212a, cVar);
                }
            }
            this.f12212a.e2(MotionLayout.this.isRtl());
            this.f12212a.g2();
            this.f12213b.e2(MotionLayout.this.isRtl());
            this.f12213b.g2();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f12212a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar2.U0(dimensionBehaviour);
                    this.f12213b.U0(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.core.widgets.d dVar3 = this.f12212a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar3.l1(dimensionBehaviour2);
                    this.f12213b.l1(dimensionBehaviour2);
                }
            }
        }

        public boolean f(int i10, int i11) {
            return (i10 == this.f12216e && i11 == this.f12217f) ? false : true;
        }

        public void g(int i10, int i11) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            b(i10, i11);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                b(i10, i11);
                MotionLayout.this.mStartWrapWidth = this.f12212a.Y();
                MotionLayout.this.mStartWrapHeight = this.f12212a.z();
                MotionLayout.this.mEndWrapWidth = this.f12213b.Y();
                MotionLayout.this.mEndWrapHeight = this.f12213b.z();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.mMeasureDuringTransition = (motionLayout2.mStartWrapWidth == motionLayout2.mEndWrapWidth && motionLayout2.mStartWrapHeight == motionLayout2.mEndWrapHeight) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i12 = motionLayout3.mStartWrapWidth;
            int i13 = motionLayout3.mStartWrapHeight;
            int i14 = motionLayout3.mWidthMeasureMode;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                i12 = (int) (i12 + (motionLayout3.mPostInterpolationPosition * (motionLayout3.mEndWrapWidth - i12)));
            }
            int i15 = i12;
            int i16 = motionLayout3.mHeightMeasureMode;
            if (i16 == Integer.MIN_VALUE || i16 == 0) {
                i13 = (int) (i13 + (motionLayout3.mPostInterpolationPosition * (motionLayout3.mEndWrapHeight - i13)));
            }
            MotionLayout.this.resolveMeasuredDimension(i10, i11, i15, i13, this.f12212a.W1() || this.f12213b.W1(), this.f12212a.U1() || this.f12213b.U1());
        }

        public void h() {
            g(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.Z();
        }

        public void i(int i10, int i11) {
            this.f12216e = i10;
            this.f12217f = i11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void j(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.widget.c cVar) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            d.a aVar = new d.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, dVar);
            sparseArray.put(MotionLayout.this.getId(), dVar);
            if (cVar != null && cVar.f12717e != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.f12213b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<ConstraintWidget> it = dVar.w1().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.E0(true);
                sparseArray.put(((View) next.u()).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = dVar.w1().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.u();
                cVar.l(view.getId(), aVar);
                next2.p1(cVar.I(view.getId()));
                next2.Q0(cVar.D(view.getId()));
                if (view instanceof androidx.constraintlayout.widget.a) {
                    cVar.j((androidx.constraintlayout.widget.a) view, next2, aVar, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).w();
                    }
                }
                aVar.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, aVar, sparseArray);
                if (cVar.H(view.getId()) == 1) {
                    next2.o1(view.getVisibility());
                } else {
                    next2.o1(cVar.G(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it3 = dVar.w1().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof androidx.constraintlayout.core.widgets.i) {
                    androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) next3.u();
                    InterfaceC4993a interfaceC4993a = (InterfaceC4993a) next3;
                    aVar2.u(dVar, interfaceC4993a, sparseArray);
                    ((androidx.constraintlayout.core.widgets.i) interfaceC4993a).z1();
                }
            }
        }
    }

    public interface g {
        void a(MotionEvent motionEvent);

        float b();

        float c();

        void d(int i10);

        void recycle();
    }

    public static class h implements g {

        /* renamed from: b, reason: collision with root package name */
        public static h f12219b = new h();

        /* renamed from: a, reason: collision with root package name */
        public VelocityTracker f12220a;

        public static h e() {
            f12219b.f12220a = VelocityTracker.obtain();
            return f12219b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f12220a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public float b() {
            VelocityTracker velocityTracker = this.f12220a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public float c() {
            VelocityTracker velocityTracker = this.f12220a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void d(int i10) {
            VelocityTracker velocityTracker = this.f12220a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i10);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void recycle() {
            VelocityTracker velocityTracker = this.f12220a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f12220a = null;
            }
        }
    }

    public class i {

        /* renamed from: a, reason: collision with root package name */
        public float f12221a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        public float f12222b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        public int f12223c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f12224d = -1;

        /* renamed from: e, reason: collision with root package name */
        public final String f12225e = "motion.progress";

        /* renamed from: f, reason: collision with root package name */
        public final String f12226f = "motion.velocity";

        /* renamed from: g, reason: collision with root package name */
        public final String f12227g = "motion.StartState";

        /* renamed from: h, reason: collision with root package name */
        public final String f12228h = "motion.EndState";

        public i() {
        }

        public void a() {
            int i10 = this.f12223c;
            if (i10 != -1 || this.f12224d != -1) {
                if (i10 == -1) {
                    MotionLayout.this.f0(this.f12224d);
                } else {
                    int i11 = this.f12224d;
                    if (i11 == -1) {
                        MotionLayout.this.setState(i10, -1, -1);
                    } else {
                        MotionLayout.this.Y(i10, i11);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.f12222b)) {
                if (Float.isNaN(this.f12221a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f12221a);
            } else {
                MotionLayout.this.X(this.f12221a, this.f12222b);
                this.f12221a = Float.NaN;
                this.f12222b = Float.NaN;
                this.f12223c = -1;
                this.f12224d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f12221a);
            bundle.putFloat("motion.velocity", this.f12222b);
            bundle.putInt("motion.StartState", this.f12223c);
            bundle.putInt("motion.EndState", this.f12224d);
            return bundle;
        }

        public void c() {
            this.f12224d = MotionLayout.this.mEndState;
            this.f12223c = MotionLayout.this.mBeginState;
            this.f12222b = MotionLayout.this.getVelocity();
            this.f12221a = MotionLayout.this.getProgress();
        }

        public void d(int i10) {
            this.f12224d = i10;
        }

        public void e(float f10) {
            this.f12221a = f10;
        }

        public void f(int i10) {
            this.f12223c = i10;
        }

        public void g(Bundle bundle) {
            this.f12221a = bundle.getFloat("motion.progress");
            this.f12222b = bundle.getFloat("motion.velocity");
            this.f12223c = bundle.getInt("motion.StartState");
            this.f12224d = bundle.getInt("motion.EndState");
        }

        public void h(float f10) {
            this.f12222b = f10;
        }
    }

    public interface j {
        void a(MotionLayout motionLayout, int i10, int i11, float f10);

        void b(MotionLayout motionLayout, int i10);

        void c(MotionLayout motionLayout, int i10, int i11);

        void d(MotionLayout motionLayout, int i10, boolean z10, float f10);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new C5138b();
        this.mDecelerateLogic = new d();
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new C4891d();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new f();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList<>();
        R(attributeSet);
    }

    public static boolean l0(float f10, float f11, float f12) {
        if (f10 > 0.0f) {
            float f13 = f10 / f12;
            return f11 + ((f10 * f13) - (((f12 * f13) * f13) / 2.0f)) > 1.0f;
        }
        float f14 = (-f10) / f12;
        return f11 + ((f10 * f14) + (((f12 * f14) * f14) / 2.0f)) < 0.0f;
    }

    public final boolean A(View view, MotionEvent motionEvent, float f10, float f11) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f10, f11);
            boolean zOnTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f10, -f11);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(f10, f11);
        if (this.mInverseMatrix == null) {
            this.mInverseMatrix = new Matrix();
        }
        matrix.invert(this.mInverseMatrix);
        motionEventObtain.transform(this.mInverseMatrix);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    public final void B() {
        q qVar = this.mScene;
        if (qVar == null) {
            Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int iE = qVar.E();
        q qVar2 = this.mScene;
        C(iE, qVar2.k(qVar2.E()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<q.b> it = this.mScene.n().iterator();
        while (it.hasNext()) {
            q.b next = it.next();
            if (next == this.mScene.f12434c) {
                Log.v(TAG, "CHECK: CURRENT");
            }
            D(next);
            int iA = next.A();
            int iY = next.y();
            String strC = androidx.constraintlayout.motion.widget.a.c(getContext(), iA);
            String strC2 = androidx.constraintlayout.motion.widget.a.c(getContext(), iY);
            if (sparseIntArray.get(iA) == iY) {
                Log.e(TAG, "CHECK: two transitions with the same start and end " + strC + "->" + strC2);
            }
            if (sparseIntArray2.get(iY) == iA) {
                Log.e(TAG, "CHECK: you can't have reverse transitions" + strC + "->" + strC2);
            }
            sparseIntArray.put(iA, iY);
            sparseIntArray2.put(iY, iA);
            if (this.mScene.k(iA) == null) {
                Log.e(TAG, " no such constraintSetStart " + strC);
            }
            if (this.mScene.k(iY) == null) {
                Log.e(TAG, " no such constraintSetEnd " + strC);
            }
        }
    }

    public final void C(int i10, androidx.constraintlayout.widget.c cVar) {
        String strC = androidx.constraintlayout.motion.widget.a.c(getContext(), i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id = childAt.getId();
            if (id == -1) {
                Log.w(TAG, "CHECK: " + strC + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (cVar.C(id) == null) {
                Log.w(TAG, "CHECK: " + strC + " NO CONSTRAINTS for " + androidx.constraintlayout.motion.widget.a.d(childAt));
            }
        }
        int[] iArrE = cVar.E();
        for (int i12 = 0; i12 < iArrE.length; i12++) {
            int i13 = iArrE[i12];
            String strC2 = androidx.constraintlayout.motion.widget.a.c(getContext(), i13);
            if (findViewById(iArrE[i12]) == null) {
                Log.w(TAG, "CHECK: " + strC + " NO View matches id " + strC2);
            }
            if (cVar.D(i13) == -1) {
                Log.w(TAG, "CHECK: " + strC + "(" + strC2 + ") no LAYOUT_HEIGHT");
            }
            if (cVar.I(i13) == -1) {
                Log.w(TAG, "CHECK: " + strC + "(" + strC2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    public final void D(q.b bVar) {
        if (bVar.A() == bVar.y()) {
            Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        }
    }

    public final void E() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            m mVar = this.mFrameArrayList.get(childAt);
            if (mVar != null) {
                mVar.B(childAt);
            }
        }
    }

    public void F(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            m mVar = this.mFrameArrayList.get(getChildAt(i10));
            if (mVar != null) {
                mVar.f(z10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[PHI: r3
      0x00e2: PHI (r3v50 float) = (r3v49 float), (r3v51 float), (r3v51 float) binds: [B:47:0x00ae, B:58:0x00d6, B:60:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(boolean r21) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.G(boolean):void");
    }

    public final void H() {
        boolean z10;
        float fSignum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        float interpolation = this.mTransitionLastPosition + (!(interpolator instanceof C5138b) ? (((nanoTime - this.mTransitionLastTime) * fSignum) * 1.0E-9f) / this.mTransitionDuration : 0.0f);
        if (this.mTransitionInstantly) {
            interpolation = this.mTransitionGoalPosition;
        }
        if ((fSignum <= 0.0f || interpolation < this.mTransitionGoalPosition) && (fSignum > 0.0f || interpolation > this.mTransitionGoalPosition)) {
            z10 = false;
        } else {
            interpolation = this.mTransitionGoalPosition;
            z10 = true;
        }
        if (interpolator != null && !z10) {
            interpolation = this.mTemporalInterpolator ? interpolator.getInterpolation((nanoTime - this.mAnimationStartTime) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.mTransitionGoalPosition) || (fSignum <= 0.0f && interpolation <= this.mTransitionGoalPosition)) {
            interpolation = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.mProgressInterpolator;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        float f10 = interpolation;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            m mVar = this.mFrameArrayList.get(childAt);
            if (mVar != null) {
                mVar.u(childAt, f10, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    public final void I() {
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        if ((this.mTransitionListener == null && ((copyOnWriteArrayList = this.mTransitionListeners) == null || copyOnWriteArrayList.isEmpty())) || this.mListenerPosition == this.mTransitionPosition) {
            return;
        }
        if (this.mListenerState != -1) {
            K();
            this.mIsAnimating = true;
        }
        this.mListenerState = -1;
        float f10 = this.mTransitionPosition;
        this.mListenerPosition = f10;
        j jVar = this.mTransitionListener;
        if (jVar != null) {
            jVar.a(this, this.mBeginState, this.mEndState, f10);
        }
        CopyOnWriteArrayList<j> copyOnWriteArrayList2 = this.mTransitionListeners;
        if (copyOnWriteArrayList2 != null) {
            Iterator<j> it = copyOnWriteArrayList2.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
            }
        }
        this.mIsAnimating = true;
    }

    public void J() {
        int iIntValue;
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (this.mTransitionCompleted.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList<Integer> arrayList = this.mTransitionCompleted;
                iIntValue = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i10 = this.mCurrentState;
            if (iIntValue != i10 && i10 != -1) {
                this.mTransitionCompleted.add(Integer.valueOf(i10));
            }
        }
        V();
        Runnable runnable = this.mOnComplete;
        if (runnable != null) {
            runnable.run();
            this.mOnComplete = null;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr == null || this.mScheduledTransitions <= 0) {
            return;
        }
        f0(iArr[0]);
        int[] iArr2 = this.mScheduledTransitionTo;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.mScheduledTransitions--;
    }

    public final void K() {
        j jVar = this.mTransitionListener;
        if (jVar != null) {
            jVar.c(this, this.mBeginState, this.mEndState);
        }
        CopyOnWriteArrayList<j> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<j> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().c(this, this.mBeginState, this.mEndState);
            }
        }
    }

    public void L(int i10, boolean z10, float f10) {
        j jVar = this.mTransitionListener;
        if (jVar != null) {
            jVar.d(this, i10, z10, f10);
        }
        CopyOnWriteArrayList<j> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<j> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().d(this, i10, z10, f10);
            }
        }
    }

    public void M(int i10, float f10, float f11, float f12, float[] fArr) throws Resources.NotFoundException {
        String resourceName;
        HashMap<View, m> map = this.mFrameArrayList;
        View viewById = getViewById(i10);
        m mVar = map.get(viewById);
        if (mVar != null) {
            mVar.l(f10, f11, f12, fArr);
            float y10 = viewById.getY();
            this.mLastPos = f10;
            this.mLastY = y10;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i10;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i10);
        }
        Log.w(TAG, "WARNING could not find view id " + resourceName);
    }

    public androidx.constraintlayout.widget.c N(int i10) {
        q qVar = this.mScene;
        if (qVar == null) {
            return null;
        }
        return qVar.k(i10);
    }

    public m O(int i10) {
        return this.mFrameArrayList.get(findViewById(i10));
    }

    public q.b P(int i10) {
        return this.mScene.F(i10);
    }

    public final boolean Q(float f10, float f11, View view, MotionEvent motionEvent) {
        boolean z10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (Q((r3.getLeft() + f10) - view.getScrollX(), (r3.getTop() + f11) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.mBoundsCheck.set(f10, f11, (view.getRight() + f10) - view.getLeft(), (view.getBottom() + f11) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY())) && A(view, motionEvent, -f10, -f11)) {
                return true;
            }
        }
        return z10;
    }

    public final void R(AttributeSet attributeSet) {
        q qVar;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z10 = true;
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MotionLayout_layoutDescription) {
                    this.mScene = new q(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R$styleable.MotionLayout_currentState) {
                    this.mCurrentState = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R$styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                    z10 = typedArrayObtainStyledAttributes.getBoolean(index, z10);
                } else if (index == R$styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        this.mDebugPath = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R$styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.mScene == null) {
                Log.e(TAG, "WARNING NO app:layoutDescription tag");
            }
            if (!z10) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            B();
        }
        if (this.mCurrentState != -1 || (qVar = this.mScene) == null) {
            return;
        }
        this.mCurrentState = qVar.E();
        this.mBeginState = this.mScene.E();
        this.mEndState = this.mScene.p();
    }

    public boolean S() {
        return this.mInteractionEnabled;
    }

    public g T() {
        return h.e();
    }

    public void U() {
        q qVar = this.mScene;
        if (qVar == null) {
            return;
        }
        if (qVar.g(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i10 = this.mCurrentState;
        if (i10 != -1) {
            this.mScene.f(this, i10);
        }
        if (this.mScene.a0()) {
            this.mScene.Y();
        }
    }

    public final void V() {
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        if (this.mTransitionListener == null && ((copyOnWriteArrayList = this.mTransitionListeners) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.mIsAnimating = false;
        Iterator<Integer> it = this.mTransitionCompleted.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            j jVar = this.mTransitionListener;
            if (jVar != null) {
                jVar.b(this, next.intValue());
            }
            CopyOnWriteArrayList<j> copyOnWriteArrayList2 = this.mTransitionListeners;
            if (copyOnWriteArrayList2 != null) {
                Iterator<j> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().b(this, next.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    public void W() {
        this.mModel.h();
        invalidate();
    }

    public void X(float f10, float f11) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new i();
            }
            this.mStateCache.e(f10);
            this.mStateCache.h(f11);
            return;
        }
        setProgress(f10);
        setState(TransitionState.MOVING);
        this.mLastVelocity = f11;
        if (f11 != 0.0f) {
            z(f11 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f10 == 0.0f || f10 == 1.0f) {
                return;
            }
            z(f10 > 0.5f ? 1.0f : 0.0f);
        }
    }

    public void Y(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new i();
            }
            this.mStateCache.f(i10);
            this.mStateCache.d(i11);
            return;
        }
        q qVar = this.mScene;
        if (qVar != null) {
            this.mBeginState = i10;
            this.mEndState = i11;
            qVar.W(i10, i11);
            this.mModel.e(this.mLayoutWidget, this.mScene.k(i10), this.mScene.k(i11));
            W();
            this.mTransitionLastPosition = 0.0f;
            e0();
        }
    }

    public final void Z() {
        int childCount = getChildCount();
        this.mModel.a();
        this.mInTransition = true;
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int i12 = this.mScene.i();
        if (i12 != -1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                m mVar = this.mFrameArrayList.get(getChildAt(i13));
                if (mVar != null) {
                    mVar.A(i12);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.mFrameArrayList.size()];
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            m mVar2 = this.mFrameArrayList.get(getChildAt(i15));
            if (mVar2.h() != -1) {
                sparseBooleanArray.put(mVar2.h(), true);
                iArr[i14] = mVar2.h();
                i14++;
            }
        }
        if (this.mDecoratorsHelpers != null) {
            for (int i16 = 0; i16 < i14; i16++) {
                m mVar3 = this.mFrameArrayList.get(findViewById(iArr[i16]));
                if (mVar3 != null) {
                    this.mScene.s(mVar3);
                }
            }
            Iterator<n> it = this.mDecoratorsHelpers.iterator();
            while (it.hasNext()) {
                it.next().D(this, this.mFrameArrayList);
            }
            for (int i17 = 0; i17 < i14; i17++) {
                m mVar4 = this.mFrameArrayList.get(findViewById(iArr[i17]));
                if (mVar4 != null) {
                    mVar4.F(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        } else {
            for (int i18 = 0; i18 < i14; i18++) {
                m mVar5 = this.mFrameArrayList.get(findViewById(iArr[i18]));
                if (mVar5 != null) {
                    this.mScene.s(mVar5);
                    mVar5.F(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        }
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            m mVar6 = this.mFrameArrayList.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && mVar6 != null) {
                this.mScene.s(mVar6);
                mVar6.F(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float fD = this.mScene.D();
        if (fD != 0.0f) {
            boolean z10 = ((double) fD) < 0.0d;
            float fAbs = Math.abs(fD);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            float fMin2 = Float.MAX_VALUE;
            for (int i20 = 0; i20 < childCount; i20++) {
                m mVar7 = this.mFrameArrayList.get(getChildAt(i20));
                if (!Float.isNaN(mVar7.f12393m)) {
                    for (int i21 = 0; i21 < childCount; i21++) {
                        m mVar8 = this.mFrameArrayList.get(getChildAt(i21));
                        if (!Float.isNaN(mVar8.f12393m)) {
                            fMin = Math.min(fMin, mVar8.f12393m);
                            fMax = Math.max(fMax, mVar8.f12393m);
                        }
                    }
                    while (i10 < childCount) {
                        m mVar9 = this.mFrameArrayList.get(getChildAt(i10));
                        if (!Float.isNaN(mVar9.f12393m)) {
                            mVar9.f12395o = 1.0f / (1.0f - fAbs);
                            if (z10) {
                                mVar9.f12394n = fAbs - (((fMax - mVar9.f12393m) / (fMax - fMin)) * fAbs);
                            } else {
                                mVar9.f12394n = fAbs - (((mVar9.f12393m - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i10++;
                    }
                    return;
                }
                float fN = mVar7.n();
                float fO = mVar7.o();
                float f10 = z10 ? fO - fN : fO + fN;
                fMin2 = Math.min(fMin2, f10);
                fMax2 = Math.max(fMax2, f10);
            }
            while (i10 < childCount) {
                m mVar10 = this.mFrameArrayList.get(getChildAt(i10));
                float fN2 = mVar10.n();
                float fO2 = mVar10.o();
                float f11 = z10 ? fO2 - fN2 : fO2 + fN2;
                mVar10.f12395o = 1.0f / (1.0f - fAbs);
                mVar10.f12394n = fAbs - (((f11 - fMin2) * fAbs) / (fMax2 - fMin2));
                i10++;
            }
        }
    }

    public final Rect a0(ConstraintWidget constraintWidget) {
        this.mTempRect.top = constraintWidget.a0();
        this.mTempRect.left = constraintWidget.Z();
        Rect rect = this.mTempRect;
        int iY = constraintWidget.Y();
        Rect rect2 = this.mTempRect;
        rect.right = iY + rect2.left;
        int iZ = constraintWidget.z();
        Rect rect3 = this.mTempRect;
        rect2.bottom = iZ + rect3.top;
        return rect3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b0(int r10, float r11, float r12) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.b0(int, float, float):void");
    }

    public void c0() {
        z(1.0f);
        this.mOnComplete = null;
    }

    public void d0(Runnable runnable) {
        z(1.0f);
        this.mOnComplete = runnable;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        u uVar;
        ArrayList<n> arrayList = this.mDecoratorsHelpers;
        if (arrayList != null) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().C(canvas);
            }
        }
        G(false);
        q qVar = this.mScene;
        if (qVar != null && (uVar = qVar.f12449r) != null) {
            uVar.c();
        }
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
            this.mFrames++;
            long nanoTime = getNanoTime();
            long j10 = this.mLastDrawTime;
            if (j10 != -1) {
                if (nanoTime - j10 > 200000000) {
                    this.mLastFps = ((int) ((this.mFrames / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = nanoTime;
                }
            } else {
                this.mLastDrawTime = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.mLastFps + " fps " + androidx.constraintlayout.motion.widget.a.e(this, this.mBeginState) + " -> ";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(androidx.constraintlayout.motion.widget.a.e(this, this.mEndState));
            sb2.append(" (progress: ");
            sb2.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb2.append(" ) state=");
            int i10 = this.mCurrentState;
            sb2.append(i10 == -1 ? "undefined" : androidx.constraintlayout.motion.widget.a.e(this, i10));
            String string = sb2.toString();
            paint.setColor(-16777216);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.mDebugPath > 1) {
            if (this.mDevModeDraw == null) {
                this.mDevModeDraw = new e();
            }
            this.mDevModeDraw.a(canvas, this.mFrameArrayList, this.mScene.o(), this.mDebugPath);
        }
        ArrayList<n> arrayList2 = this.mDecoratorsHelpers;
        if (arrayList2 != null) {
            Iterator<n> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().B(canvas);
            }
        }
    }

    public void e0() {
        z(0.0f);
    }

    public void f0(int i10) {
        if (isAttachedToWindow()) {
            g0(i10, -1, -1);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new i();
        }
        this.mStateCache.d(i10);
    }

    public void g0(int i10, int i11, int i12) {
        h0(i10, i11, i12, -1);
    }

    public int[] getConstraintSetIds() {
        q qVar = this.mScene;
        if (qVar == null) {
            return null;
        }
        return qVar.m();
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public ArrayList<q.b> getDefinedTransitions() {
        q qVar = this.mScene;
        if (qVar == null) {
            return null;
        }
        return qVar.n();
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public q getScene() {
        return this.mScene;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new i();
        }
        this.mStateCache.c();
        return this.mStateCache.b();
    }

    public long getTransitionTimeMs() {
        if (this.mScene != null) {
            this.mTransitionDuration = r0.o() / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void h0(int i10, int i11, int i12, int i13) {
        androidx.constraintlayout.widget.h hVar;
        int iA;
        q qVar = this.mScene;
        if (qVar != null && (hVar = qVar.f12433b) != null && (iA = hVar.a(this.mCurrentState, i10, i11, i12)) != -1) {
            i10 = iA;
        }
        int i14 = this.mCurrentState;
        if (i14 == i10) {
            return;
        }
        if (this.mBeginState == i10) {
            z(0.0f);
            if (i13 > 0) {
                this.mTransitionDuration = i13 / 1000.0f;
                return;
            }
            return;
        }
        if (this.mEndState == i10) {
            z(1.0f);
            if (i13 > 0) {
                this.mTransitionDuration = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.mEndState = i10;
        if (i14 != -1) {
            Y(i14, i10);
            z(1.0f);
            this.mTransitionLastPosition = 0.0f;
            c0();
            if (i13 > 0) {
                this.mTransitionDuration = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        if (i13 == -1) {
            this.mTransitionDuration = this.mScene.o() / 1000.0f;
        }
        this.mBeginState = -1;
        this.mScene.W(-1, this.mEndState);
        SparseArray sparseArray = new SparseArray();
        if (i13 == 0) {
            this.mTransitionDuration = this.mScene.o() / 1000.0f;
        } else if (i13 > 0) {
            this.mTransitionDuration = i13 / 1000.0f;
        }
        int childCount = getChildCount();
        this.mFrameArrayList.clear();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            this.mFrameArrayList.put(childAt, new m(childAt));
            sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
        }
        this.mInTransition = true;
        this.mModel.e(this.mLayoutWidget, null, this.mScene.k(i10));
        W();
        this.mModel.a();
        E();
        int width = getWidth();
        int height = getHeight();
        if (this.mDecoratorsHelpers != null) {
            for (int i16 = 0; i16 < childCount; i16++) {
                m mVar = this.mFrameArrayList.get(getChildAt(i16));
                if (mVar != null) {
                    this.mScene.s(mVar);
                }
            }
            Iterator<n> it = this.mDecoratorsHelpers.iterator();
            while (it.hasNext()) {
                it.next().D(this, this.mFrameArrayList);
            }
            for (int i17 = 0; i17 < childCount; i17++) {
                m mVar2 = this.mFrameArrayList.get(getChildAt(i17));
                if (mVar2 != null) {
                    mVar2.F(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        } else {
            for (int i18 = 0; i18 < childCount; i18++) {
                m mVar3 = this.mFrameArrayList.get(getChildAt(i18));
                if (mVar3 != null) {
                    this.mScene.s(mVar3);
                    mVar3.F(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        }
        float fD = this.mScene.D();
        if (fD != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i19 = 0; i19 < childCount; i19++) {
                m mVar4 = this.mFrameArrayList.get(getChildAt(i19));
                float fO = mVar4.o() + mVar4.n();
                fMin = Math.min(fMin, fO);
                fMax = Math.max(fMax, fO);
            }
            for (int i20 = 0; i20 < childCount; i20++) {
                m mVar5 = this.mFrameArrayList.get(getChildAt(i20));
                float fN = mVar5.n();
                float fO2 = mVar5.o();
                mVar5.f12395o = 1.0f / (1.0f - fD);
                mVar5.f12394n = fD - ((((fN + fO2) - fMin) * fD) / (fMax - fMin));
            }
        }
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
    }

    public void i0() {
        this.mModel.e(this.mLayoutWidget, this.mScene.k(this.mBeginState), this.mScene.k(this.mEndState));
        W();
    }

    public void j0(int i10, androidx.constraintlayout.widget.c cVar) {
        q qVar = this.mScene;
        if (qVar != null) {
            qVar.T(i10, cVar);
        }
        i0();
        if (this.mCurrentState == i10) {
            cVar.i(this);
        }
    }

    public void k0(int i10, View... viewArr) {
        q qVar = this.mScene;
        if (qVar != null) {
            qVar.b0(i10, viewArr);
        } else {
            Log.e(TAG, " no motionScene");
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i10) {
        q.b bVar;
        if (i10 == 0) {
            this.mScene = null;
            return;
        }
        try {
            q qVar = new q(getContext(), this, i10);
            this.mScene = qVar;
            if (this.mCurrentState == -1) {
                this.mCurrentState = qVar.E();
                this.mBeginState = this.mScene.E();
                this.mEndState = this.mScene.p();
            }
            if (!isAttachedToWindow()) {
                this.mScene = null;
                return;
            }
            try {
                Display display = getDisplay();
                this.mPreviouseRotation = display == null ? 0 : display.getRotation();
                q qVar2 = this.mScene;
                if (qVar2 != null) {
                    androidx.constraintlayout.widget.c cVarK = qVar2.k(this.mCurrentState);
                    this.mScene.S(this);
                    ArrayList<n> arrayList = this.mDecoratorsHelpers;
                    if (arrayList != null) {
                        Iterator<n> it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().A(this);
                        }
                    }
                    if (cVarK != null) {
                        cVarK.i(this);
                    }
                    this.mBeginState = this.mCurrentState;
                }
                U();
                i iVar = this.mStateCache;
                if (iVar != null) {
                    if (this.mDelayedApply) {
                        post(new a());
                        return;
                    } else {
                        iVar.a();
                        return;
                    }
                }
                q qVar3 = this.mScene;
                if (qVar3 == null || (bVar = qVar3.f12434c) == null || bVar.x() != 4) {
                    return;
                }
                c0();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            } catch (Exception e10) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e10);
            }
        } catch (Exception e11) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        q.b bVar;
        int i10;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.mPreviouseRotation = display.getRotation();
        }
        q qVar = this.mScene;
        if (qVar != null && (i10 = this.mCurrentState) != -1) {
            androidx.constraintlayout.widget.c cVarK = qVar.k(i10);
            this.mScene.S(this);
            ArrayList<n> arrayList = this.mDecoratorsHelpers;
            if (arrayList != null) {
                Iterator<n> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().A(this);
                }
            }
            if (cVarK != null) {
                cVarK.i(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        U();
        i iVar = this.mStateCache;
        if (iVar != null) {
            if (this.mDelayedApply) {
                post(new c());
                return;
            } else {
                iVar.a();
                return;
            }
        }
        q qVar2 = this.mScene;
        if (qVar2 == null || (bVar = qVar2.f12434c) == null || bVar.x() != 4) {
            return;
        }
        c0();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        r rVarB;
        int iQ;
        RectF rectFP;
        q qVar = this.mScene;
        if (qVar != null && this.mInteractionEnabled) {
            u uVar = qVar.f12449r;
            if (uVar != null) {
                uVar.g(motionEvent);
            }
            q.b bVar = this.mScene.f12434c;
            if (bVar != null && bVar.C() && (rVarB = bVar.B()) != null && ((motionEvent.getAction() != 0 || (rectFP = rVarB.p(this, new RectF())) == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) && (iQ = rVarB.q()) != -1)) {
                View view = this.mRegionView;
                if (view == null || view.getId() != iQ) {
                    this.mRegionView = findViewById(iQ);
                }
                if (this.mRegionView != null) {
                    this.mBoundsCheck.set(r0.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                    if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !Q(this.mRegionView.getLeft(), this.mRegionView.getTop(), this.mRegionView, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z10, i10, i11, i12, i13);
                this.mInLayout = false;
                return;
            }
            int i14 = i12 - i10;
            int i15 = i13 - i11;
            if (this.mLastLayoutWidth != i14 || this.mLastLayoutHeight != i15) {
                W();
                G(true);
            }
            this.mLastLayoutWidth = i14;
            this.mLastLayoutHeight = i15;
            this.mOldWidth = i14;
            this.mOldHeight = i15;
            this.mInLayout = false;
        } catch (Throwable th) {
            this.mInLayout = false;
            throw th;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mScene == null) {
            super.onMeasure(i10, i11);
            return;
        }
        boolean z10 = false;
        boolean z11 = (this.mLastWidthMeasureSpec == i10 && this.mLastHeightMeasureSpec == i11) ? false : true;
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            U();
            V();
            z11 = true;
        }
        if (this.mDirtyHierarchy) {
            z11 = true;
        }
        this.mLastWidthMeasureSpec = i10;
        this.mLastHeightMeasureSpec = i11;
        int iE = this.mScene.E();
        int iP = this.mScene.p();
        if ((z11 || this.mModel.f(iE, iP)) && this.mBeginState != -1) {
            super.onMeasure(i10, i11);
            this.mModel.e(this.mLayoutWidget, this.mScene.k(iE), this.mScene.k(iP));
            this.mModel.h();
            this.mModel.i(iE, iP);
        } else {
            if (z11) {
                super.onMeasure(i10, i11);
            }
            z10 = true;
        }
        if (this.mMeasureDuringTransition || z10) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int iY = this.mLayoutWidget.Y() + getPaddingLeft() + getPaddingRight();
            int iZ = this.mLayoutWidget.z() + paddingTop;
            int i12 = this.mWidthMeasureMode;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                iY = (int) (this.mStartWrapWidth + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r8)));
                requestLayout();
            }
            int i13 = this.mHeightMeasureMode;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                iZ = (int) (this.mStartWrapHeight + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r8)));
                requestLayout();
            }
            setMeasuredDimension(iY, iZ);
        }
        H();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        q.b bVar;
        r rVarB;
        int iQ;
        q qVar = this.mScene;
        if (qVar == null || (bVar = qVar.f12434c) == null || !bVar.C()) {
            return;
        }
        int i13 = -1;
        if (!bVar.C() || (rVarB = bVar.B()) == null || (iQ = rVarB.q()) == -1 || view.getId() == iQ) {
            if (qVar.v()) {
                r rVarB2 = bVar.B();
                if (rVarB2 != null && (rVarB2.e() & 4) != 0) {
                    i13 = i11;
                }
                float f10 = this.mTransitionPosition;
                if ((f10 == 1.0f || f10 == 0.0f) && view.canScrollVertically(i13)) {
                    return;
                }
            }
            if (bVar.B() != null && (bVar.B().e() & 1) != 0) {
                float fW = qVar.w(i10, i11);
                float f11 = this.mTransitionLastPosition;
                if ((f11 <= 0.0f && fW < 0.0f) || (f11 >= 1.0f && fW > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new b(view));
                    return;
                }
            }
            float f12 = this.mTransitionPosition;
            long nanoTime = getNanoTime();
            float f13 = i10;
            this.mScrollTargetDX = f13;
            float f14 = i11;
            this.mScrollTargetDY = f14;
            this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
            this.mScrollTargetTime = nanoTime;
            qVar.O(f13, f14);
            if (f12 != this.mTransitionPosition) {
                iArr[0] = i10;
                iArr[1] = i11;
            }
            G(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.mUndergoingMotion = true;
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        q qVar = this.mScene;
        if (qVar != null) {
            qVar.V(isRtl());
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        q.b bVar;
        q qVar = this.mScene;
        return (qVar == null || (bVar = qVar.f12434c) == null || bVar.B() == null || (this.mScene.f12434c.B().e() & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View view, int i10) {
        q qVar = this.mScene;
        if (qVar != null) {
            float f10 = this.mScrollTargetDT;
            if (f10 == 0.0f) {
                return;
            }
            qVar.P(this.mScrollTargetDX / f10, this.mScrollTargetDY / f10);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        q qVar = this.mScene;
        if (qVar == null || !this.mInteractionEnabled || !qVar.a0()) {
            return super.onTouchEvent(motionEvent);
        }
        q.b bVar = this.mScene.f12434c;
        if (bVar != null && !bVar.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.Q(motionEvent, getCurrentState(), this);
        if (this.mScene.f12434c.D(4)) {
            return this.mScene.f12434c.B().r();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof n) {
            n nVar = (n) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new CopyOnWriteArrayList<>();
            }
            this.mTransitionListeners.add(nVar);
            if (nVar.z()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(nVar);
            }
            if (nVar.y()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(nVar);
            }
            if (nVar.x()) {
                if (this.mDecoratorsHelpers == null) {
                    this.mDecoratorsHelpers = new ArrayList<>();
                }
                this.mDecoratorsHelpers.add(nVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<n> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<n> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        q qVar;
        q.b bVar;
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && (qVar = this.mScene) != null && (bVar = qVar.f12434c) != null) {
            int iZ = bVar.z();
            if (iZ == 0) {
                return;
            }
            if (iZ == 2) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    this.mFrameArrayList.get(getChildAt(i10)).w();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void setDebugMode(int i10) {
        this.mDebugPath = i10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.mDelayedApply = z10;
    }

    public void setInteractionEnabled(boolean z10) {
        this.mInteractionEnabled = z10;
    }

    public void setInterpolatedProgress(float f10) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolatorR = this.mScene.r();
            if (interpolatorR != null) {
                setProgress(interpolatorR.getInterpolation(f10));
                return;
            }
        }
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<n> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mOnHideHelpers.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<n> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mOnShowHelpers.get(i10).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new i();
            }
            this.mStateCache.e(f10);
            return;
        }
        if (f10 <= 0.0f) {
            if (this.mTransitionLastPosition == 1.0f && this.mCurrentState == this.mEndState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f10 >= 1.0f) {
            if (this.mTransitionLastPosition == 0.0f && this.mCurrentState == this.mBeginState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f10;
        this.mTransitionPosition = f10;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    public void setScene(q qVar) {
        this.mScene = qVar;
        qVar.V(isRtl());
        W();
    }

    public void setStartState(int i10) {
        if (isAttachedToWindow()) {
            this.mCurrentState = i10;
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new i();
        }
        this.mStateCache.f(i10);
        this.mStateCache.d(i10);
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState3 = this.mTransitionState;
        this.mTransitionState = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            I();
        }
        int iOrdinal = transitionState3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && transitionState == transitionState2) {
                J();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            I();
        }
        if (transitionState == transitionState2) {
            J();
        }
    }

    public void setTransition(int i10) {
        if (this.mScene != null) {
            q.b bVarP = P(i10);
            this.mBeginState = bVarP.A();
            this.mEndState = bVarP.y();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new i();
                }
                this.mStateCache.f(this.mBeginState);
                this.mStateCache.d(this.mEndState);
                return;
            }
            int i11 = this.mCurrentState;
            float f10 = i11 == this.mBeginState ? 0.0f : i11 == this.mEndState ? 1.0f : Float.NaN;
            this.mScene.X(bVarP);
            this.mModel.e(this.mLayoutWidget, this.mScene.k(this.mBeginState), this.mScene.k(this.mEndState));
            W();
            if (this.mTransitionLastPosition != f10) {
                if (f10 == 0.0f) {
                    F(true);
                    this.mScene.k(this.mBeginState).i(this);
                } else if (f10 == 1.0f) {
                    F(false);
                    this.mScene.k(this.mEndState).i(this);
                }
            }
            this.mTransitionLastPosition = Float.isNaN(f10) ? 0.0f : f10;
            if (!Float.isNaN(f10)) {
                setProgress(f10);
                return;
            }
            Log.v(TAG, androidx.constraintlayout.motion.widget.a.b() + " transitionToStart ");
            e0();
        }
    }

    public void setTransitionDuration(int i10) {
        q qVar = this.mScene;
        if (qVar == null) {
            Log.e(TAG, "MotionScene not defined");
        } else {
            qVar.U(i10);
        }
    }

    public void setTransitionListener(j jVar) {
        this.mTransitionListener = jVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new i();
        }
        this.mStateCache.g(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.a.c(context, this.mBeginState) + "->" + androidx.constraintlayout.motion.widget.a.c(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void z(float f10) {
        if (this.mScene == null) {
            return;
        }
        float f11 = this.mTransitionLastPosition;
        float f12 = this.mTransitionPosition;
        if (f11 != f12 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f12;
        }
        float f13 = this.mTransitionLastPosition;
        if (f13 == f10) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f10;
        this.mTransitionDuration = r0.o() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = null;
        this.mProgressInterpolator = this.mScene.r();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f13;
        this.mTransitionLastPosition = f13;
        invalidate();
    }

    @Override // androidx.core.view.InterfaceC1336y
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (this.mUndergoingMotion || i10 != 0 || i11 != 0) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.mUndergoingMotion = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i10, int i11, int i12) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i10;
        this.mBeginState = -1;
        this.mEndState = -1;
        androidx.constraintlayout.widget.b bVar = this.mConstraintLayoutSpec;
        if (bVar != null) {
            bVar.d(i10, i11, i12);
            return;
        }
        q qVar = this.mScene;
        if (qVar != null) {
            qVar.k(i10).i(this);
        }
    }

    public void setTransition(q.b bVar) {
        this.mScene.X(bVar);
        setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.p()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = bVar.D(1) ? -1L : getNanoTime();
        int iE = this.mScene.E();
        int iP = this.mScene.p();
        if (iE == this.mBeginState && iP == this.mEndState) {
            return;
        }
        this.mBeginState = iE;
        this.mEndState = iP;
        this.mScene.W(iE, iP);
        this.mModel.e(this.mLayoutWidget, this.mScene.k(this.mBeginState), this.mScene.k(this.mEndState));
        this.mModel.i(this.mBeginState, this.mEndState);
        this.mModel.h();
        W();
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new C5138b();
        this.mDecelerateLogic = new d();
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new C4891d();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new f();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList<>();
        R(attributeSet);
    }
}

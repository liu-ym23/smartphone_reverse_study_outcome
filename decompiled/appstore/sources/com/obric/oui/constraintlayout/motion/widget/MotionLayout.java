package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
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
import androidx.annotation.IdRes;
import androidx.core.view.NestedScrollingParent3;
import com.google.common.primitives.Ints;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Helper;
import com.obric.oui.constraintlayout.widget.Barrier;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.Constraints;
import com.obric.oui.constraintlayout.widget.R$id;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static boolean f13558d1;
    public Interpolator A;
    public boolean A0;
    public Interpolator B;
    public int B0;
    public float C;
    public int C0;
    public int D;
    public int D0;
    public int E;
    public int E0;
    public int F;
    public int F0;
    public int G;
    public int G0;
    public int H;
    public float H0;
    public boolean I;
    public vc.d I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public HashMap f13559J;
    public boolean J0;
    public long K;
    public h K0;
    public float L;
    public Runnable L0;
    public float M;
    public int[] M0;
    public float N;
    public int N0;
    public long O;
    public boolean O0;
    public float P;
    public int P0;
    public boolean Q;
    public HashMap Q0;
    public boolean R;
    public int R0;
    public boolean S;
    public int S0;
    public TransitionListener T;
    public int T0;
    public float U;
    public Rect U0;
    public float V;
    public boolean V0;
    public int W;
    public TransitionState W0;
    public f X0;
    public boolean Y0;
    public RectF Z0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public e f13560a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public View f13561a1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f13562b0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public Matrix f13563b1;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public yc.b f13564c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public ArrayList f13565c1;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public d f13566d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public com.obric.oui.constraintlayout.motion.widget.b f13567e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f13568f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f13569g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f13570h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f13571i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f13572j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f13573k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f13574l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public float f13575m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public long f13576n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f13577o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f13578p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ArrayList f13579q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public ArrayList f13580r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public ArrayList f13581s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public CopyOnWriteArrayList f13582t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f13583u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long f13584v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public float f13585w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f13586x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public float f13587y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public o f13588z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f13589z0;

    public interface MotionTracker {
        void addMovement(MotionEvent r10);

        void clear();

        void computeCurrentVelocity(int r10);

        void computeCurrentVelocity(int r10, float r11);

        float getXVelocity();

        float getXVelocity(int r10);

        float getYVelocity();

        float getYVelocity(int r10);

        void recycle();
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout r10, int r11, int r12, float r13);

        void onTransitionCompleted(MotionLayout r10, int r11);

        void onTransitionStarted(MotionLayout r10, int r11, int r12);

        void onTransitionTrigger(MotionLayout r10, int r11, boolean r12, float r13);
    }

    public static final enum TransitionState extends Enum<TransitionState> {
        private static final /* synthetic */ TransitionState[] $VALUES = null;
        public static final TransitionState FINISHED = null;
        public static final TransitionState MOVING = null;
        public static final TransitionState SETUP = null;
        public static final TransitionState UNDEFINED = null;

        static {
            TransitionState r10 = new TransitionState("UNDEFINED", 0);
            UNDEFINED = r10;
            TransitionState r11 = new TransitionState("SETUP", 1);
            SETUP = r11;
            TransitionState r12 = new TransitionState("MOVING", 2);
            MOVING = r12;
            TransitionState r13 = new TransitionState("FINISHED", 3);
            FINISHED = r13;
            $VALUES = new TransitionState[]{r10, r11, r12, r13};
        }

        private TransitionState(String r10, int r11) {
            super(r10, r11);
        }

        public static TransitionState valueOf(String r10) {
            return (TransitionState) Enum.valueOf(TransitionState.class, r10);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) $VALUES.clone();
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f13590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f13591b;

        public a(MotionLayout r10, View r11) {
            this.f13591b = r10;
            this.f13590a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13590a.setNestedScrollingEnabled(true);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f13592a;

        public b(MotionLayout r10) {
            this.f13592a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.w(this.f13592a).a();
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13593a = null;

        static {
            int[] r10 = new int[TransitionState.values().length];
            f13593a = r10;
            r10[TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f13593a[TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f13593a[TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f13593a[TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class d extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f13594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f13596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f13597d;

        public d(MotionLayout r10) {
            this.f13597d = r10;
            this.f13594a = 0.0f;
            this.f13595b = 0.0f;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.m
        public float a() {
            return this.f13597d.C;
        }

        public void b(float r10, float r11, float r12) {
            this.f13594a = r10;
            this.f13595b = r11;
            this.f13596c = r12;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = this.f13594a;
            if (r11 <= 0.0f) goto L10;
            float r12 = this.f13596c;
            if ((r11 / r12) >= r10) goto L7;
            r10 = r11 / r12;
        L7:
            float r13 = r11 - (r12 * r10);
            this.f13597d.C = r13;
            float r14 = (r11 * r10) - (((r12 * r10) * r10) / 2.0f);
            float r15 = this.f13595b;
        L9:
            return r14 + r15;
        L10:
            float r16 = this.f13596c;
            if (((-r11) / r16) >= r10) goto L13;
            r10 = (-r11) / r16;
        L13:
            float r17 = (r16 * r10) + r11;
            this.f13597d.C = r17;
            r14 = (r11 * r10) + (((r16 * r10) * r10) / 2.0f);
            r15 = this.f13595b;
            goto L9
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f13598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f13599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float[] f13600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Path f13601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f13602e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Paint f13603f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Paint f13604g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Paint f13605h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Paint f13606i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f13607j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f13608k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f13609l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f13610m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f13611n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f13612o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public DashPathEffect f13613p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f13614q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Rect f13615r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f13616s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f13617t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f13618u;

        public e(MotionLayout r10) {
            this.f13618u = r10;
            this.f13608k = -21965;
            this.f13609l = -2067046;
            this.f13610m = -13391360;
            this.f13611n = 1996488704;
            this.f13612o = 10;
            this.f13615r = new Rect();
            this.f13616s = false;
            this.f13617t = 1;
            Paint r11 = new Paint();
            this.f13602e = r11;
            r11.setAntiAlias(true);
            this.f13602e.setColor(-21965);
            this.f13602e.setStrokeWidth(2.0f);
            Paint r12 = this.f13602e;
            Paint.Style r13 = Paint.Style.STROKE;
            r12.setStyle(r13);
            Paint r14 = new Paint();
            this.f13603f = r14;
            r14.setAntiAlias(true);
            this.f13603f.setColor(-2067046);
            this.f13603f.setStrokeWidth(2.0f);
            this.f13603f.setStyle(r13);
            Paint r15 = new Paint();
            this.f13604g = r15;
            r15.setAntiAlias(true);
            this.f13604g.setColor(-13391360);
            this.f13604g.setStrokeWidth(2.0f);
            this.f13604g.setStyle(r13);
            Paint r16 = new Paint();
            this.f13605h = r16;
            r16.setAntiAlias(true);
            this.f13605h.setColor(-13391360);
            this.f13605h.setTextSize(r10.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f13607j = new float[8];
            Paint r17 = new Paint();
            this.f13606i = r17;
            r17.setAntiAlias(true);
            DashPathEffect r18 = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f13613p = r18;
            this.f13604g.setPathEffect(r18);
            this.f13600c = new float[100];
            this.f13599b = new int[50];
            if (this.f13616s == false) goto L6;
            this.f13602e.setStrokeWidth(8.0f);
            this.f13606i.setStrokeWidth(8.0f);
            this.f13603f.setStrokeWidth(8.0f);
            this.f13617t = 4;
            return;
        }

        public void a(Canvas r10, HashMap r11, int r12, int r13) {
            if (r11 != null) goto L4;
            return;
        L4:
            if (r11.size() == 0) goto L42;
            r10.save();
            if (this.f13618u.isInEditMode() == false) goto L9;
        L11:
            Iterator r14 = r11.values().iterator();
        L13:
            if (r14.hasNext() == false) goto L30;
            l r15 = (l) r14.next();
            int r16 = r15.m();
            if (r13 <= 0) goto L18;
            if (r16 != 0) goto L18;
            r16 = 1;
        L18:
            if (r16 == 0) goto L13;
            this.f13614q = r15.c(this.f13600c, this.f13599b);
            if (r16 < 1) goto L13;
            int r17 = r12 / 16;
            float[] r18 = this.f13598a;
            if (r18 != null) goto L25;
        L26:
            this.f13598a = new float[r17 * 2];
            this.f13601d = new Path();
        L27:
            int r19 = this.f13617t;
            r10.translate(r19, r19);
            this.f13602e.setColor(1996488704);
            this.f13606i.setColor(1996488704);
            this.f13603f.setColor(1996488704);
            this.f13604g.setColor(1996488704);
            r15.d(this.f13598a, r17);
            b(r10, r16, this.f13614q, r15);
            this.f13602e.setColor(-21965);
            this.f13603f.setColor(-2067046);
            this.f13606i.setColor(-2067046);
            this.f13604g.setColor(-13391360);
            int r20 = this.f13617t;
            r10.translate(-r20, -r20);
            b(r10, r16, this.f13614q, r15);
            if (r16 != 5) goto L13;
            j(r10, r15);
            goto L13
        L25:
            if (r18.length == (r17 * 2)) goto L27;
        L30:
            r10.restore();
            return;
        L9:
            if ((r13 & 1) != 2) goto L11;
            String r21 = this.f13618u.getContext().getResources().getResourceName(MotionLayout.x(this.f13618u)) + ":" + this.f13618u.getProgress();
            r10.drawText(r21, 10.0f, this.f13618u.getHeight() - 30, this.f13605h);
            r10.drawText(r21, 11.0f, this.f13618u.getHeight() - 29, this.f13602e);
            goto L11
        }

        public void b(Canvas r10, int r11, int r12, l r13) {
            if (r11 != 4) goto L6;
            d(r10);
        L6:
            if (r11 != 2) goto L9;
            g(r10);
        L9:
            if (r11 != 3) goto L11;
            e(r10);
        L11:
            c(r10);
            k(r10, r11, r12, r13);
        }

        public final void c(Canvas r10) {
            r10.drawLines(this.f13598a, this.f13602e);
        }

        public final void d(Canvas r10) {
            int r11 = 0;
            boolean r12 = false;
            boolean r13 = false;
        L4:
            if (r11 >= this.f13614q) goto L11;
            int r14 = this.f13599b[r11];
            if (r14 != 1) goto L8;
            r12 = true;
        L8:
            if (r14 != 0) goto L10;
            r13 = true;
        L10:
            r11 = r11 + 1;
            goto L4
        L11:
            if (r12 == false) goto L13;
            g(r10);
        L13:
            if (r13 == false) goto L19;
            e(r10);
            return;
        }

        public final void e(Canvas r19) {
            float[] r10 = this.f13598a;
            float r11 = r10[0];
            float r12 = r10[1];
            float r13 = r10[r10.length - 2];
            float r14 = r10[r10.length - 1];
            r19.drawLine(Math.min(r11, r13), Math.max(r12, r14), Math.max(r11, r13), Math.max(r12, r14), this.f13604g);
            r19.drawLine(Math.min(r11, r13), Math.min(r12, r14), Math.min(r11, r13), Math.max(r12, r14), this.f13604g);
        }

        public final void f(Canvas r19, float r20, float r21) {
            float[] r10 = this.f13598a;
            float r11 = r10[0];
            float r12 = r10[1];
            float r13 = r10[r10.length - 2];
            float r14 = r10[r10.length - 1];
            float r15 = Math.min(r11, r13);
            float r16 = Math.max(r12, r14);
            float r17 = r20 - Math.min(r11, r13);
            float r18 = Math.max(r12, r14) - r21;
            String r22 = "" + (((int) (((double) ((r17 * 100.0f) / Math.abs(r13 - r11))) + 0.5d)) / 100.0f);
            l(r22, this.f13605h);
            r19.drawText(r22, ((r17 / 2.0f) - (this.f13615r.width() / 2)) + r15, r21 - 20.0f, this.f13605h);
            r19.drawLine(r20, r21, Math.min(r11, r13), r21, this.f13604g);
            String r23 = "" + (((int) (((double) ((r18 * 100.0f) / Math.abs(r14 - r12))) + 0.5d)) / 100.0f);
            l(r23, this.f13605h);
            r19.drawText(r23, r20 + 5.0f, r16 - ((r18 / 2.0f) - (this.f13615r.height() / 2)), this.f13605h);
            r19.drawLine(r20, r21, r20, Math.max(r12, r14), this.f13604g);
        }

        public final void g(Canvas r10) {
            float[] r11 = this.f13598a;
            r10.drawLine(r11[0], r11[1], r11[r11.length - 2], r11[r11.length - 1], this.f13604g);
        }

        public final void h(Canvas r13, float r14, float r15) {
            float[] r10 = this.f13598a;
            float r11 = r10[0];
            float r12 = r10[1];
            float r16 = r10[r10.length - 2];
            float r17 = r10[r10.length - 1];
            float r18 = (float) Math.hypot(r11 - r16, r12 - r17);
            float r19 = r16 - r11;
            float r20 = r17 - r12;
            float r21 = (((r14 - r11) * r19) + ((r15 - r12) * r20)) / (r18 * r18);
            float r22 = r11 + (r19 * r21);
            float r110 = r12 + (r21 * r20);
            Path r23 = new Path();
            r23.moveTo(r14, r15);
            r23.lineTo(r22, r110);
            float r24 = (float) Math.hypot(r22 - r14, r110 - r15);
            String r25 = "" + (((int) ((r24 * 100.0f) / r18)) / 100.0f);
            l(r25, this.f13605h);
            r13.drawTextOnPath(r25, r23, (r24 / 2.0f) - (this.f13615r.width() / 2), -20.0f, this.f13605h);
            r13.drawLine(r14, r15, r22, r110, this.f13604g);
        }

        public final void i(Canvas r16, float r17, float r18, int r19, int r20) {
            String r10 = "" + (((int) (((double) (((r17 - (r19 / 2)) * 100.0f) / (this.f13618u.getWidth() - r19))) + 0.5d)) / 100.0f);
            l(r10, this.f13605h);
            r16.drawText(r10, ((r17 / 2.0f) - (this.f13615r.width() / 2)) + 0.0f, r18 - 20.0f, this.f13605h);
            r16.drawLine(r17, r18, Math.min(0.0f, 1.0f), r18, this.f13604g);
            String r11 = "" + (((int) (((double) (((r18 - (r20 / 2)) * 100.0f) / (this.f13618u.getHeight() - r20))) + 0.5d)) / 100.0f);
            l(r11, this.f13605h);
            r16.drawText(r11, r17 + 5.0f, 0.0f - ((r18 / 2.0f) - (this.f13615r.height() / 2)), this.f13605h);
            r16.drawLine(r17, r18, r17, Math.max(0.0f, 1.0f), this.f13604g);
        }

        public final void j(Canvas r10, l r11) {
            this.f13601d.reset();
            int r12 = 0;
        L4:
            if (r12 > 50) goto L6;
            r11.e(r12 / 50, this.f13607j, 0);
            Path r13 = this.f13601d;
            float[] r14 = this.f13607j;
            r13.moveTo(r14[0], r14[1]);
            Path r15 = this.f13601d;
            float[] r16 = this.f13607j;
            r15.lineTo(r16[2], r16[3]);
            Path r17 = this.f13601d;
            float[] r18 = this.f13607j;
            r17.lineTo(r18[4], r18[5]);
            Path r19 = this.f13601d;
            float[] r20 = this.f13607j;
            r19.lineTo(r20[6], r20[7]);
            this.f13601d.close();
            r12 = r12 + 1;
            goto L4
        L6:
            this.f13602e.setColor(1140850688);
            r10.translate(2.0f, 2.0f);
            r10.drawPath(this.f13601d, this.f13602e);
            r10.translate(-2.0f, -2.0f);
            this.f13602e.setColor(-65536);
            r10.drawPath(this.f13601d, this.f13602e);
        }

        public final void k(Canvas r20, int r21, int r22, l r23) {
            View r10 = r23.f13773b;
            if (r10 == null) goto L5;
            int r11 = r10.getWidth();
            int r12 = r23.f13773b.getHeight();
        L6:
            int r14 = 1;
        L8:
            if (r14 >= (r22 - 1)) goto L36;
            if (r21 == 4) goto L12;
        L14:
            float[] r13 = this.f13600c;
            int r15 = r14 * 2;
            float r16 = r13[r15];
            float r17 = r13[r15 + 1];
            this.f13601d.reset();
            this.f13601d.moveTo(r16, r17 + 10.0f);
            this.f13601d.lineTo(r16 + 10.0f, r17);
            this.f13601d.lineTo(r16, r17 - 10.0f);
            this.f13601d.lineTo(r16 - 10.0f, r17);
            this.f13601d.close();
            int r18 = r14 - 1;
            r23.q(r18);
            if (r21 != 4) goto L25;
            int r19 = this.f13599b[r18];
            if (r19 != 1) goto L20;
            h(r20, r16 - 0.0f, r17 - 0.0f);
        L24:
            r20.drawPath(this.f13601d, this.f13606i);
        L26:
            if (r21 != 2) goto L29;
            h(r20, r16 - 0.0f, r17 - 0.0f);
        L29:
            if (r21 != 3) goto L32;
            f(r20, r16 - 0.0f, r17 - 0.0f);
        L32:
            if (r21 != 6) goto L34;
            i(r20, r16 - 0.0f, r17 - 0.0f, r11, r12);
        L34:
            r20.drawPath(this.f13601d, this.f13606i);
        L35:
            r14 = r14 + 1;
            goto L8
        L20:
            if (r19 != 0) goto L22;
            f(r20, r16 - 0.0f, r17 - 0.0f);
            goto L24
        L22:
            if (r19 != 2) goto L24;
            i(r20, r16 - 0.0f, r17 - 0.0f, r11, r12);
            goto L24
        L25:
            r17 = r17;
            r16 = r16;
            goto L26
        L12:
            if (this.f13599b[r14 - 1] != 0) goto L14;
        L36:
            float[] r24 = this.f13598a;
            if (r24.length <= 1) goto L43;
            r20.drawCircle(r24[0], r24[1], 8.0f, this.f13603f);
            float[] r25 = this.f13598a;
            r20.drawCircle(r25[r25.length - 2], r25[r25.length - 1], 8.0f, this.f13603f);
            return;
        L43:
            return;
        L5:
            r11 = 0;
            r12 = 0;
            goto L6
        }

        public void l(String r10, Paint r11) {
            r11.getTextBounds(r10, 0, r10.length(), this.f13615r);
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.obric.oui.constraintlayout.core.widgets.d f13619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.obric.oui.constraintlayout.core.widgets.d f13620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.obric.oui.constraintlayout.widget.a f13621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.obric.oui.constraintlayout.widget.a f13622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13623e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f13625g;

        public f(MotionLayout r10) {
            this.f13625g = r10;
            this.f13619a = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f13620b = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f13621c = null;
            this.f13622d = null;
        }

        public void a() {
            int r10 = this.f13625g.getChildCount();
            this.f13625g.f13559J.clear();
            SparseArray r11 = new SparseArray();
            int[] r12 = new int[r10];
            int r13 = 0;
        L3:
            if (r13 >= r10) goto L5;
            View r14 = this.f13625g.getChildAt(r13);
            l r15 = new l(r14);
            int r16 = r14.getId();
            r12[r13] = r16;
            r11.put(r16, r15);
            this.f13625g.f13559J.put(r14, r15);
            r13 = r13 + 1;
            goto L3
        L5:
            int r17 = 0;
        L6:
            if (r17 >= r10) goto L31;
            View r18 = this.f13625g.getChildAt(r17);
            l r19 = (l) this.f13625g.f13559J.get(r18);
            if (r19 != null) goto L11;
            r11 = r11;
        L30:
            r17 = r17 + 1;
            r11 = r11;
            goto L6
        L11:
            if (this.f13621c == null) goto L20;
            ConstraintWidget r20 = d(this.f13619a, r18);
            if (r20 == null) goto L16;
            r19.F(MotionLayout.J(this.f13625g, r20), this.f13621c, this.f13625g.getWidth(), this.f13625g.getHeight());
        L23:
            if (this.f13622d == null) goto L30;
            ConstraintWidget r21 = d(this.f13620b, r18);
            if (r21 == null) goto L28;
            r19.C(MotionLayout.J(this.f13625g, r21), this.f13622d, this.f13625g.getWidth(), this.f13625g.getHeight());
            goto L30
        L28:
            if (this.f13625g.W == 0) goto L30;
            Log.e("MotionLayout", com.obric.oui.constraintlayout.motion.widget.a.b() + "no widget for  " + com.obric.oui.constraintlayout.motion.widget.a.d(r18) + " (" + r18.getClass().getName() + ")");
            goto L30
        L16:
            if (this.f13625g.W == 0) goto L23;
            Log.e("MotionLayout", com.obric.oui.constraintlayout.motion.widget.a.b() + "no widget for  " + com.obric.oui.constraintlayout.motion.widget.a.d(r18) + " (" + r18.getClass().getName() + ")");
            goto L23
        L20:
            if (MotionLayout.M(this.f13625g) == false) goto L23;
            androidx.appcompat.widget.p.a(this.f13625g.Q0.get(r18));
            MotionLayout r22 = this.f13625g;
            r19.G(null, r18, r22.P0, MotionLayout.K(r22), MotionLayout.L(this.f13625g));
            goto L23
        L31:
            SparseArray r110 = r11;
            int r23 = 0;
        L32:
            if (r23 >= r10) goto L37;
            SparseArray r24 = r110;
            l r25 = (l) r24.get(r12[r23]);
            int r26 = r25.h();
            if (r26 == (-1)) goto L36;
            r25.J((l) r24.get(r26));
        L36:
            r23 = r23 + 1;
            r110 = r24;
            goto L32
        }

        public final void b(int r10, int r11) {
            int r12 = this.f13625g.getOptimizationLevel();
            MotionLayout r13 = this.f13625g;
            if (r13.E != r13.getStartState()) goto L26;
            MotionLayout r14 = this.f13625g;
            com.obric.oui.constraintlayout.core.widgets.d r15 = this.f13620b;
            com.obric.oui.constraintlayout.widget.a r16 = this.f13622d;
            if (r16 != null) goto L7;
        L10:
            int r17 = r10;
        L11:
            if (r16 != null) goto L13;
        L16:
            int r18 = r11;
        L17:
            MotionLayout.E(r14, r15, r12, r17, r18);
            com.obric.oui.constraintlayout.widget.a r19 = this.f13621c;
            if (r19 == null) goto L49;
            MotionLayout r20 = this.f13625g;
            com.obric.oui.constraintlayout.core.widgets.d r21 = this.f13619a;
            int r22 = r19.f14168e;
            if (r22 != 0) goto L22;
            int r23 = r10;
        L23:
            if (r22 != 0) goto L25;
            r10 = r11;
        L25:
            MotionLayout.F(r20, r21, r12, r23, r10);
            return;
        L22:
            r23 = r11;
            goto L23
        L49:
            return;
        L13:
            if (r16.f14168e == 0) goto L16;
            r18 = r10;
            goto L17
        L7:
            if (r16.f14168e == 0) goto L10;
            r17 = r11;
            goto L11
        L26:
            com.obric.oui.constraintlayout.widget.a r24 = this.f13621c;
            if (r24 == null) goto L36;
            MotionLayout r25 = this.f13625g;
            com.obric.oui.constraintlayout.core.widgets.d r26 = this.f13619a;
            int r27 = r24.f14168e;
            if (r27 != 0) goto L31;
            int r28 = r10;
        L32:
            if (r27 != 0) goto L34;
            int r29 = r11;
        L35:
            MotionLayout.G(r25, r26, r12, r28, r29);
            goto L36
        L34:
            r29 = r10;
            goto L35
        L31:
            r28 = r11;
        L36:
            MotionLayout r30 = this.f13625g;
            com.obric.oui.constraintlayout.core.widgets.d r31 = this.f13620b;
            com.obric.oui.constraintlayout.widget.a r32 = this.f13622d;
            if (r32 != null) goto L39;
        L42:
            int r33 = r10;
        L43:
            if (r32 != null) goto L45;
        L46:
            r10 = r11;
        L47:
            MotionLayout.H(r30, r31, r12, r33, r10);
            return;
        L45:
            if (r32.f14168e != 0) goto L47;
        L39:
            if (r32.f14168e == 0) goto L42;
            r33 = r11;
            goto L43
        }

        public void c(com.obric.oui.constraintlayout.core.widgets.d r10, com.obric.oui.constraintlayout.core.widgets.d r11) {
            ArrayList r12 = r10.t1();
            HashMap r13 = new HashMap();
            r13.put(r10, r11);
            r11.t1().clear();
            r11.k(r10, r13);
            Iterator r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L22;
            ConstraintWidget r15 = (ConstraintWidget) r14.next();
            if ((r15 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L9;
            ConstraintWidget r16 = new com.obric.oui.constraintlayout.core.widgets.a();
        L21:
            r11.add(r16);
            r13.put(r15, r16);
            goto L4
        L9:
            if ((r15 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L12;
            r16 = new com.obric.oui.constraintlayout.core.widgets.f();
            goto L21
        L12:
            if ((r15 instanceof com.obric.oui.constraintlayout.core.widgets.e) == false) goto L15;
            r16 = new com.obric.oui.constraintlayout.core.widgets.e();
            goto L21
        L15:
            if ((r15 instanceof com.obric.oui.constraintlayout.core.widgets.h) == false) goto L18;
            r16 = new com.obric.oui.constraintlayout.core.widgets.h();
            goto L21
        L18:
            if ((r15 instanceof wc.a) == false) goto L20;
            r16 = new wc.a();
            goto L21
        L20:
            r16 = new ConstraintWidget();
            goto L21
        L22:
            Iterator r17 = r12.iterator();
        L24:
            if (r17.hasNext() == false) goto L26;
            ConstraintWidget r18 = (ConstraintWidget) r17.next();
            ((ConstraintWidget) r13.get(r18)).k(r18, r13);
            goto L24
        }

        public ConstraintWidget d(com.obric.oui.constraintlayout.core.widgets.d r10, View r11) {
            if (r10.r() != r11) goto L5;
            return r10;
        L5:
            ArrayList r12 = r10.t1();
            int r13 = r12.size();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L11;
            ConstraintWidget r15 = (ConstraintWidget) r12.get(r14);
            if (r15.r() == r11) goto L9;
            r14 = r14 + 1;
            goto L6
        L9:
            return r15;
        L11:
            return null;
        }

        public void e(com.obric.oui.constraintlayout.core.widgets.d r10, com.obric.oui.constraintlayout.widget.a r11, com.obric.oui.constraintlayout.widget.a r12) {
            this.f13621c = r11;
            this.f13622d = r12;
            this.f13619a = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f13620b = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f13619a.Y1(MotionLayout.N(this.f13625g).L1());
            this.f13620b.Y1(MotionLayout.O(this.f13625g).L1());
            this.f13619a.w1();
            this.f13620b.w1();
            c(MotionLayout.P(this.f13625g), this.f13619a);
            c(MotionLayout.Q(this.f13625g), this.f13620b);
            if (this.f13625g.N <= 0.5d) goto L7;
            if (r11 == null) goto L6;
            j(this.f13619a, r11);
        L6:
            j(this.f13620b, r12);
        L10:
            this.f13619a.b2(MotionLayout.R(this.f13625g));
            this.f13619a.d2();
            this.f13620b.b2(MotionLayout.S(this.f13625g));
            this.f13620b.d2();
            ViewGroup.LayoutParams r13 = this.f13625g.getLayoutParams();
            if (r13 != null) goto L13;
            return;
        L13:
            if (r13.width != (-2)) goto L16;
            com.obric.oui.constraintlayout.core.widgets.d r14 = this.f13619a;
            ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r14.R0(r15);
            this.f13620b.R0(r15);
        L16:
            if (r13.height != (-2)) goto L20;
            com.obric.oui.constraintlayout.core.widgets.d r16 = this.f13619a;
            ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r16.i1(r17);
            this.f13620b.i1(r17);
            return;
        L20:
            return;
        L7:
            j(this.f13620b, r12);
            if (r11 == null) goto L10;
            j(this.f13619a, r11);
            goto L10
        }

        public boolean f(int r10, int r11) {
            if (r10 == this.f13623e) goto L5;
        L8:
            return true;
        L5:
            if (r11 != this.f13624f) goto L8;
            return false;
        }

        public void g(int r16, int r17) {
            int r10 = View.MeasureSpec.getMode(r16);
            int r11 = View.MeasureSpec.getMode(r17);
            MotionLayout r12 = this.f13625g;
            r12.F0 = r10;
            r12.G0 = r11;
            b(r16, r17);
            if ((this.f13625g.getParent() instanceof MotionLayout) == true) goto L5;
        L8:
            b(r16, r17);
            this.f13625g.B0 = this.f13619a.V();
            this.f13625g.C0 = this.f13619a.w();
            this.f13625g.D0 = this.f13620b.V();
            this.f13625g.E0 = this.f13620b.w();
            MotionLayout r13 = this.f13625g;
            if (r13.B0 == r13.D0) goto L11;
        L14:
            boolean r14 = true;
        L15:
            r13.A0 = r14;
        L16:
            MotionLayout r15 = this.f13625g;
            int r18 = r15.B0;
            int r19 = r15.C0;
            int r20 = r15.F0;
            if (r20 == Integer.MIN_VALUE) goto L21;
            if (r20 == 0) goto L21;
        L20:
            int r110 = r18;
            int r21 = r15.G0;
            if (r21 == Integer.MIN_VALUE) goto L27;
            if (r21 == 0) goto L27;
        L26:
            int r111 = r19;
            if (this.f13619a.T1() == false) goto L31;
        L34:
            boolean r112 = true;
        L36:
            if (this.f13619a.R1() == false) goto L38;
        L41:
            boolean r113 = true;
        L42:
            MotionLayout.D(this.f13625g, r16, r17, r110, r111, r112, r113);
            return;
        L38:
            if (this.f13620b.R1() == true) goto L41;
            r113 = false;
            goto L42
        L31:
            if (this.f13620b.T1() == true) goto L34;
            r112 = false;
        L27:
            r19 = (int) (r19 + (r15.H0 * (r15.E0 - r19)));
        L21:
            r18 = (int) (r18 + (r15.H0 * (r15.D0 - r18)));
            goto L20
        L11:
            if (r13.C0 != r13.E0) goto L14;
            r14 = false;
            goto L15
        L5:
            if (r10 != 1073741824) goto L8;
            if (r11 != 1073741824) goto L8;
            goto L8
        }

        public void h() {
            g(MotionLayout.A(this.f13625g), MotionLayout.B(this.f13625g));
            MotionLayout.C(this.f13625g);
        }

        public void i(int r10, int r11) {
            this.f13623e = r10;
            this.f13624f = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void j(com.obric.oui.constraintlayout.core.widgets.d r13, com.obric.oui.constraintlayout.widget.a r14) {
            SparseArray r10 = new SparseArray();
            Constraints.LayoutParams r11 = new Constraints.LayoutParams(-2, -2);
            r10.clear();
            r10.put(0, r13);
            r10.put(this.f13625g.getId(), r13);
            if (r14 != null) goto L5;
        L7:
            Iterator r12 = r13.t1().iterator();
        L9:
            if (r12.hasNext() == false) goto L11;
            ConstraintWidget r15 = (ConstraintWidget) r12.next();
            r15.B0(true);
            r10.put(((View) r15.r()).getId(), r15);
            goto L9
        L11:
            Iterator r16 = r13.t1().iterator();
        L13:
            if (r16.hasNext() == false) goto L23;
            ConstraintWidget r17 = (ConstraintWidget) r16.next();
            View r18 = (View) r17.r();
            r14.l(r18.getId(), r11);
            r17.m1(r14.A(r18.getId()));
            r17.N0(r14.v(r18.getId()));
            if ((r18 instanceof ConstraintHelper) == false) goto L19;
            r14.j((ConstraintHelper) r18, r17, r11, r10);
            if ((r18 instanceof Barrier) == false) goto L19;
            ((Barrier) r18).s();
        L19:
            r11.resolveLayoutDirection(this.f13625g.getLayoutDirection());
            MotionLayout.z(this.f13625g, false, r18, r17, r11, r10);
            if (r14.z(r18.getId()) == 1) goto L21;
            r17.l1(r14.y(r18.getId()));
            goto L13
        L21:
            r17.l1(r18.getVisibility());
            goto L13
        L23:
            Iterator r19 = r13.t1().iterator();
        L25:
            if (r19.hasNext() == false) goto L29;
            ConstraintWidget r110 = (ConstraintWidget) r19.next();
            if ((r110 instanceof com.obric.oui.constraintlayout.core.widgets.i) == false) goto L25;
            ConstraintHelper r20 = (ConstraintHelper) r110.r();
            Helper r111 = (Helper) r110;
            r20.q(r13, r111, r10);
            ((com.obric.oui.constraintlayout.core.widgets.i) r111).w1();
            goto L25
        L29:
            return;
        L5:
            if (r14.f14168e == 0) goto L7;
            MotionLayout r21 = this.f13625g;
            MotionLayout.y(r21, this.f13620b, r21.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(this.f13625g.getHeight(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(this.f13625g.getWidth(), Ints.MAX_POWER_OF_TWO));
            goto L7
        }
    }

    public static class g implements MotionTracker {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static g f13626b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VelocityTracker f13627a;

        static {
            f13626b = new g();
        }

        public g() {
        }

        public static g a() {
            g r10 = f13626b;
            r10.f13627a = VelocityTracker.obtain();
            return f13626b;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent r10) {
            VelocityTracker r11 = this.f13627a;
            if (r11 == null) goto L6;
            r11.addMovement(r10);
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker r10 = this.f13627a;
            if (r10 == null) goto L6;
            r10.clear();
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r10) {
            VelocityTracker r11 = this.f13627a;
            if (r11 == null) goto L6;
            r11.computeCurrentVelocity(r10);
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker r10 = this.f13627a;
            if (r10 != null) goto L5;
            return 0.0f;
        L5:
            return r10.getXVelocity();
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker r10 = this.f13627a;
            if (r10 != null) goto L5;
            return 0.0f;
        L5:
            return r10.getYVelocity();
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker r10 = this.f13627a;
            if (r10 == null) goto L6;
            r10.recycle();
            this.f13627a = null;
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r10, float r11) {
            VelocityTracker r12 = this.f13627a;
            if (r12 == null) goto L6;
            r12.computeCurrentVelocity(r10, r11);
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int r10) {
            VelocityTracker r11 = this.f13627a;
            if (r11 != null) goto L5;
            return 0.0f;
        L5:
            return r11.getXVelocity(r10);
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int r10) {
            if (this.f13627a != null) goto L5;
            return 0.0f;
        L5:
            return getYVelocity(r10);
        }
    }

    public class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f13628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f13632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f13633f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f13634g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f13635h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f13636i;

        public h(MotionLayout r10) {
            this.f13636i = r10;
            this.f13628a = Float.NaN;
            this.f13629b = Float.NaN;
            this.f13630c = -1;
            this.f13631d = -1;
            this.f13632e = "motion.progress";
            this.f13633f = "motion.velocity";
            this.f13634g = "motion.StartState";
            this.f13635h = "motion.EndState";
        }

        public void a() {
            int r10 = this.f13630c;
            if (r10 == (-1)) goto L5;
        L6:
            if (r10 != (-1)) goto L8;
            this.f13636i.D0(this.f13631d);
        L12:
            this.f13636i.setState(TransitionState.SETUP);
        L14:
            if (Float.isNaN(this.f13629b) == true) goto L16;
            this.f13636i.u0(this.f13628a, this.f13629b);
            this.f13628a = Float.NaN;
            this.f13629b = Float.NaN;
            this.f13630c = -1;
            this.f13631d = -1;
            return;
        L16:
            if (Float.isNaN(this.f13628a) == false) goto L18;
            return;
        L18:
            this.f13636i.setProgress(this.f13628a);
            return;
        L8:
            int r11 = this.f13631d;
            if (r11 != (-1)) goto L11;
            this.f13636i.v0(r10, -1, -1);
            goto L12
        L11:
            this.f13636i.w0(r10, r11);
            goto L12
        L5:
            if (this.f13631d == (-1)) goto L14;
            goto L6
        }

        public Bundle b() {
            Bundle r10 = new Bundle();
            r10.putFloat("motion.progress", this.f13628a);
            r10.putFloat("motion.velocity", this.f13629b);
            r10.putInt("motion.StartState", this.f13630c);
            r10.putInt("motion.EndState", this.f13631d);
            return r10;
        }

        public void c() {
            this.f13631d = MotionLayout.x(this.f13636i);
            this.f13630c = MotionLayout.I(this.f13636i);
            this.f13629b = this.f13636i.getVelocity();
            this.f13628a = this.f13636i.getProgress();
        }

        public void d(int r10) {
            this.f13631d = r10;
        }

        public void e(float r10) {
            this.f13628a = r10;
        }

        public void f(int r10) {
            this.f13630c = r10;
        }

        public void g(Bundle r10) {
            this.f13628a = r10.getFloat("motion.progress");
            this.f13629b = r10.getFloat("motion.velocity");
            this.f13630c = r10.getInt("motion.StartState");
            this.f13631d = r10.getInt("motion.EndState");
        }

        public void h(float r10) {
            this.f13629b = r10;
        }
    }

    public MotionLayout(Context r10) {
        super(r10);
        this.B = null;
        this.C = 0.0f;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.I = true;
        this.f13559J = new HashMap();
        this.K = 0;
        this.L = 1.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.P = 0.0f;
        this.R = false;
        this.S = false;
        this.W = 0;
        this.f13562b0 = false;
        this.f13564c0 = new yc.b();
        this.f13566d0 = new d(this);
        this.f13568f0 = true;
        this.f13573k0 = false;
        this.f13578p0 = false;
        this.f13579q0 = null;
        this.f13580r0 = null;
        this.f13581s0 = null;
        this.f13582t0 = null;
        this.f13583u0 = 0;
        this.f13584v0 = -1;
        this.f13585w0 = 0.0f;
        this.f13586x0 = 0;
        this.f13587y0 = 0.0f;
        this.f13589z0 = false;
        this.A0 = false;
        this.I0 = new vc.d();
        this.J0 = false;
        this.L0 = null;
        this.M0 = null;
        this.N0 = 0;
        this.O0 = false;
        this.P0 = 0;
        this.Q0 = new HashMap();
        this.U0 = new Rect();
        this.V0 = false;
        this.W0 = TransitionState.UNDEFINED;
        this.X0 = new f(this);
        this.Y0 = false;
        this.Z0 = new RectF();
        this.f13561a1 = null;
        this.f13563b1 = null;
        this.f13565c1 = new ArrayList();
        o0(null);
    }

    public static /* synthetic */ int A(MotionLayout r10) {
        return r10.G;
    }

    public static /* synthetic */ int B(MotionLayout r10) {
        return r10.H;
    }

    public static /* synthetic */ void C(MotionLayout r10) {
        r10.x0();
    }

    public static /* synthetic */ void D(MotionLayout r10, int r11, int r12, int r13, int r14, boolean r15, boolean r16) {
        r10.p(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void E(MotionLayout r10, com.obric.oui.constraintlayout.core.widgets.d r11, int r12, int r13, int r14) {
        r10.q(r11, r12, r13, r14);
    }

    public static /* synthetic */ void F(MotionLayout r10, com.obric.oui.constraintlayout.core.widgets.d r11, int r12, int r13, int r14) {
        r10.q(r11, r12, r13, r14);
    }

    public static /* synthetic */ void G(MotionLayout r10, com.obric.oui.constraintlayout.core.widgets.d r11, int r12, int r13, int r14) {
        r10.q(r11, r12, r13, r14);
    }

    public static /* synthetic */ void H(MotionLayout r10, com.obric.oui.constraintlayout.core.widgets.d r11, int r12, int r13, int r14) {
        r10.q(r11, r12, r13, r14);
    }

    public static /* synthetic */ int I(MotionLayout r10) {
        return r10.D;
    }

    public static /* synthetic */ Rect J(MotionLayout r10, ConstraintWidget r11) {
        return r10.y0(r11);
    }

    public static /* synthetic */ int K(MotionLayout r10) {
        return r10.R0;
    }

    public static /* synthetic */ int L(MotionLayout r10) {
        return r10.S0;
    }

    public static boolean L0(float r10, float r11, float r12) {
        if (r10 <= 0.0f) goto L8;
        float r13 = r10 / r12;
        if ((r11 + ((r10 * r13) - (((r12 * r13) * r13) / 2.0f))) > 1.0f) goto L7;
        return false;
    L7:
        return true;
    L8:
        float r14 = (-r10) / r12;
        if ((r11 + ((r10 * r14) + (((r12 * r14) * r14) / 2.0f))) < 0.0f) goto L11;
        return false;
    L11:
        return true;
    }

    public static /* synthetic */ boolean M(MotionLayout r10) {
        return r10.O0;
    }

    public static /* synthetic */ com.obric.oui.constraintlayout.core.widgets.d N(MotionLayout r10) {
        return r10.f14063c;
    }

    public static /* synthetic */ com.obric.oui.constraintlayout.core.widgets.d O(MotionLayout r10) {
        return r10.f14063c;
    }

    public static /* synthetic */ com.obric.oui.constraintlayout.core.widgets.d P(MotionLayout r10) {
        return r10.f14063c;
    }

    public static /* synthetic */ com.obric.oui.constraintlayout.core.widgets.d Q(MotionLayout r10) {
        return r10.f14063c;
    }

    public static /* synthetic */ boolean R(MotionLayout r10) {
        return r10.m();
    }

    public static /* synthetic */ boolean S(MotionLayout r10) {
        return r10.m();
    }

    public static /* synthetic */ h w(MotionLayout r10) {
        return r10.K0;
    }

    public static /* synthetic */ int x(MotionLayout r10) {
        return r10.F;
    }

    public static /* synthetic */ void y(MotionLayout r10, com.obric.oui.constraintlayout.core.widgets.d r11, int r12, int r13, int r14) {
        r10.q(r11, r12, r13, r14);
    }

    public static /* synthetic */ void z(MotionLayout r10, boolean r11, View r12, ConstraintWidget r13, ConstraintLayout.LayoutParams r14, SparseArray r15) {
        r10.d(r11, r12, r13, r14, r15);
    }

    public void A0() {
        T(1.0f);
        this.L0 = null;
    }

    public void B0(Runnable r10) {
        T(1.0f);
        this.L0 = r10;
    }

    public void C0() {
        T(0.0f);
    }

    public void D0(int r10) {
        if (isAttachedToWindow() == false) goto L5;
        F0(r10, -1, -1);
        return;
    L5:
        if (this.K0 != null) goto L7;
        this.K0 = new h(this);
    L7:
        this.K0.d(r10);
    }

    public void E0(int r10, int r11) {
        if (isAttachedToWindow() == false) goto L5;
        G0(r10, -1, -1, r11);
        return;
    L5:
        if (this.K0 != null) goto L7;
        this.K0 = new h(this);
    L7:
        this.K0.d(r10);
    }

    public void F0(int r10, int r11, int r12) {
        G0(r10, r11, r12, -1);
    }

    public void G0(int r11, int r12, int r13, int r14) {
        o r10 = this.f13588z;
        if (r10 == null) goto L9;
        zc.c r15 = r10.f13820b;
        if (r15 == null) goto L9;
        int r16 = r15.a(this.E, r11, r12, r13);
        if (r16 == (-1)) goto L9;
        r11 = r16;
    L9:
        int r17 = this.E;
        if (r17 != r11) goto L13;
        return;
    L13:
        if (this.D != r11) goto L19;
        T(0.0f);
        if (r14 <= 0) goto L90;
        this.L = r14 / 1000.0f;
        return;
    L90:
        return;
    L19:
        if (this.F != r11) goto L24;
        T(1.0f);
        if (r14 <= 0) goto L91;
        this.L = r14 / 1000.0f;
        return;
    L91:
        return;
    L24:
        this.F = r11;
        if (r17 == (-1)) goto L30;
        w0(r17, r11);
        T(1.0f);
        this.N = 0.0f;
        A0();
        if (r14 <= 0) goto L92;
        this.L = r14 / 1000.0f;
        return;
    L92:
        return;
    L30:
        int r18 = 0;
        this.f13562b0 = false;
        this.P = 1.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = getNanoTime();
        this.K = getNanoTime();
        this.Q = false;
        this.A = null;
        if (r14 != (-1)) goto L33;
        this.L = this.f13588z.p() / 1000.0f;
    L33:
        this.D = -1;
        this.f13588z.X(-1, this.F);
        SparseArray r19 = new SparseArray();
        if (r14 != 0) goto L36;
        this.L = this.f13588z.p() / 1000.0f;
    L38:
        int r110 = getChildCount();
        this.f13559J.clear();
        int r20 = 0;
    L39:
        if (r20 >= r110) goto L41;
        View r21 = getChildAt(r20);
        this.f13559J.put(r21, new l(r21));
        r19.put(r21.getId(), (l) this.f13559J.get(r21));
        r20 = r20 + 1;
        goto L39
    L41:
        this.R = true;
        this.X0.e(this.f14063c, null, this.f13588z.l(r11));
        t0();
        this.X0.a();
        a0();
        int r111 = getWidth();
        int r112 = getHeight();
        if (this.f13581s0 == null) goto L61;
        int r22 = 0;
    L44:
        if (r22 >= r110) goto L50;
        l r23 = (l) this.f13559J.get(getChildAt(r22));
        if (r23 == null) goto L49;
        this.f13588z.t(r23);
    L49:
        r22 = r22 + 1;
        goto L44
    L50:
        Iterator r24 = this.f13581s0.iterator();
    L52:
        if (r24.hasNext() == false) goto L54;
        ((MotionHelper) r24.next()).onPreSetup(this, this.f13559J);
        goto L52
    L54:
        int r25 = 0;
    L55:
        if (r25 >= r110) goto L68;
        l r26 = (l) this.f13559J.get(getChildAt(r25));
        if (r26 == null) goto L60;
        r26.I(r111, r112, this.L, getNanoTime());
    L60:
        r25 = r25 + 1;
    L68:
        float r113 = this.f13588z.E();
        if (r113 == 0.0f) goto L75;
        float r114 = Float.MAX_VALUE;
        float r27 = -3.4028235E38f;
        int r28 = 0;
    L71:
        if (r28 >= r110) goto L73;
        l r29 = (l) this.f13559J.get(getChildAt(r28));
        float r30 = r29.o() + r29.n();
        r114 = Math.min(r114, r30);
        r27 = Math.max(r27, r30);
        r28 = r28 + 1;
    L73:
        if (r18 >= r110) goto L75;
        l r31 = (l) this.f13559J.get(getChildAt(r18));
        float r32 = r31.n();
        float r33 = r31.o();
        r31.f13786o = 1.0f / (1.0f - r113);
        r31.f13785n = r113 - ((((r32 + r33) - r114) * r113) / (r27 - r114));
        r18 = r18 + 1;
    L75:
        this.M = 0.0f;
        this.N = 0.0f;
        this.R = true;
        invalidate();
        return;
    L61:
        int r34 = 0;
    L62:
        if (r34 >= r110) goto L68;
        l r35 = (l) this.f13559J.get(getChildAt(r34));
        if (r35 == null) goto L67;
        this.f13588z.t(r35);
        r35.I(r111, r112, this.L, getNanoTime());
    L67:
        r34 = r34 + 1;
        goto L62
    L36:
        if (r14 <= 0) goto L38;
        this.L = r14 / 1000.0f;
        goto L38
    }

    public void H0() {
        this.X0.e(this.f14063c, this.f13588z.l(this.D), this.f13588z.l(this.F));
        t0();
    }

    public void I0(int r10, com.obric.oui.constraintlayout.widget.a r11) {
        o r12 = this.f13588z;
        if (r12 == null) goto L5;
        r12.U(r10, r11);
    L5:
        H0();
        if (this.E != r10) goto L9;
        r11.i(this);
        return;
    }

    public void J0(int r10, com.obric.oui.constraintlayout.widget.a r11, int r12) {
        if (this.f13588z != null) goto L6;
        return;
    L6:
        if (this.E != r10) goto L9;
        int r13 = R$id.view_transition;
        I0(r13, j0(r10));
        v0(r13, -1, -1);
        I0(r10, r11);
        o.b r14 = new o.b(-1, this.f13588z, r13, r10);
        r14.E(r12);
        setTransition(r14);
        A0();
        return;
    }

    public void K0(int r10, View... r11) {
        o r12 = this.f13588z;
        if (r12 == null) goto L5;
        r12.c0(r10, r11);
        return;
    L5:
        Log.e("MotionLayout", " no motionScene");
    }

    public void T(float r10) {
        o r11 = this.f13588z;
        if (r11 != null) goto L5;
        return;
    L5:
        float r12 = this.N;
        float r13 = this.M;
        if (r12 != r13) goto L8;
    L10:
        float r14 = this.N;
        if (r14 != r10) goto L13;
        return;
    L13:
        this.f13562b0 = false;
        this.P = r10;
        this.L = r11.p() / 1000.0f;
        setProgress(this.P);
        this.A = null;
        this.B = this.f13588z.s();
        this.Q = false;
        this.K = getNanoTime();
        this.R = true;
        this.M = r14;
        this.N = r14;
        invalidate();
        return;
    L8:
        if (this.Q == false) goto L10;
        this.N = r13;
        goto L10
    }

    public boolean U(int r10, l r11) {
        o r12 = this.f13588z;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.g(r10, r11);
    }

    public final boolean V(View r10, MotionEvent r11, float r12, float r13) {
        Matrix r14 = r10.getMatrix();
        if (r14.isIdentity() == false) goto L6;
        r11.offsetLocation(r12, r13);
        boolean r15 = r10.onTouchEvent(r11);
        r11.offsetLocation(-r12, -r13);
        return r15;
    L6:
        MotionEvent r16 = MotionEvent.obtain(r11);
        r16.offsetLocation(r12, r13);
        if (this.f13563b1 != null) goto L9;
        this.f13563b1 = new Matrix();
    L9:
        r14.invert(this.f13563b1);
        r16.transform(this.f13563b1);
        boolean r17 = r10.onTouchEvent(r16);
        r16.recycle();
        return r17;
    }

    public final void W() {
        o r10 = this.f13588z;
        if (r10 != null) goto L6;
        Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
        return;
    L6:
        int r11 = r10.F();
        o r12 = this.f13588z;
        X(r11, r12.l(r12.F()));
        SparseIntArray r13 = new SparseIntArray();
        SparseIntArray r14 = new SparseIntArray();
        Iterator r15 = this.f13588z.o().iterator();
    L8:
        if (r15.hasNext() == false) goto L24;
        o.b r16 = (o.b) r15.next();
        if (r16 != this.f13588z.f13821c) goto L12;
        Log.v("MotionLayout", "CHECK: CURRENT");
    L12:
        Y(r16);
        int r17 = r16.A();
        int r18 = r16.y();
        String r19 = com.obric.oui.constraintlayout.motion.widget.a.c(getContext(), r17);
        String r20 = com.obric.oui.constraintlayout.motion.widget.a.c(getContext(), r18);
        if (r13.get(r17) != r18) goto L16;
        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + r19 + "->" + r20);
    L16:
        if (r14.get(r18) != r17) goto L18;
        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + r19 + "->" + r20);
    L18:
        r13.put(r17, r18);
        r14.put(r18, r17);
        if (this.f13588z.l(r17) != null) goto L22;
        Log.e("MotionLayout", " no such constraintSetStart " + r19);
    L22:
        if (this.f13588z.l(r18) != null) goto L8;
        Log.e("MotionLayout", " no such constraintSetEnd " + r19);
        goto L8
    }

    public final void X(int r11, com.obric.oui.constraintlayout.widget.a r12) {
        String r13 = com.obric.oui.constraintlayout.motion.widget.a.c(getContext(), r11);
        int r10 = getChildCount();
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= r10) goto L12;
        View r16 = getChildAt(r15);
        int r17 = r16.getId();
        if (r17 != (-1)) goto L9;
        Log.w("MotionLayout", "CHECK: " + r13 + " ALL VIEWS SHOULD HAVE ID's " + r16.getClass().getName() + " does not!");
    L9:
        if (r12.u(r17) != null) goto L11;
        Log.w("MotionLayout", "CHECK: " + r13 + " NO CONSTRAINTS for " + com.obric.oui.constraintlayout.motion.widget.a.d(r16));
    L11:
        r15 = r15 + 1;
        goto L4
    L12:
        int[] r18 = r12.w();
    L14:
        if (r14 >= r18.length) goto L25;
        int r19 = r18[r14];
        String r20 = com.obric.oui.constraintlayout.motion.widget.a.c(getContext(), r19);
        if (findViewById(r18[r14]) != null) goto L19;
        Log.w("MotionLayout", "CHECK: " + r13 + " NO View matches id " + r20);
    L19:
        if (r12.v(r19) != (-1)) goto L22;
        Log.w("MotionLayout", "CHECK: " + r13 + "(" + r20 + ") no LAYOUT_HEIGHT");
    L22:
        if (r12.A(r19) != (-1)) goto L24;
        Log.w("MotionLayout", "CHECK: " + r13 + "(" + r20 + ") no LAYOUT_HEIGHT");
    L24:
        r14 = r14 + 1;
        goto L14
    }

    public final void Y(o.b r10) {
        if (r10.A() != r10.y()) goto L6;
        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        return;
    }

    public com.obric.oui.constraintlayout.widget.a Z(int r10) {
        o r11 = this.f13588z;
        if (r11 != null) goto L6;
        return null;
    L6:
        com.obric.oui.constraintlayout.widget.a r12 = r11.l(r10);
        com.obric.oui.constraintlayout.widget.a r13 = new com.obric.oui.constraintlayout.widget.a();
        r13.p(r12);
        return r13;
    }

    public final void a0() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        View r12 = getChildAt(r11);
        l r13 = (l) this.f13559J.get(r12);
        if (r13 == null) goto L8;
        r13.E(r12);
    L8:
        r11 = r11 + 1;
        goto L3
    }

    public void b0(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = getChildAt(r12);
        l r14 = (l) this.f13559J.get(r13);
        if (r14 == null) goto L7;
        r14.f(r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    public void c0(boolean r23) {
        if (this.O != (-1)) goto L5;
        this.O = getNanoTime();
    L5:
        float r10 = this.N;
        if (r10 > 0.0f) goto L8;
    L10:
        boolean r11 = true;
        boolean r12 = false;
        if (this.f13578p0 == false) goto L13;
    L17:
        float r13 = Math.signum(this.P - r10);
        long r14 = getNanoTime();
        Interpolator r15 = this.A;
        if ((r15 instanceof m) == true) goto L20;
        float r16 = (((r14 - this.O) * r13) * 1.0E-9f) / this.L;
    L21:
        float r17 = this.N + r16;
        if (this.Q == false) goto L25;
        r17 = this.P;
    L25:
        if (r13 <= 0.0f) goto L29;
        if (r17 < this.P) goto L29;
    L32:
        r17 = this.P;
        this.R = false;
        boolean r18 = true;
    L34:
        this.N = r17;
        this.M = r17;
        this.O = r14;
        if (r15 == null) goto L69;
        if (r18 == true) goto L69;
        if (this.f13562b0 == false) goto L63;
        float r19 = r15.getInterpolation((r14 - this.K) * 1.0E-9f);
        Interpolator r20 = this.A;
        yc.b r21 = this.f13564c0;
        if (r20 == r21) goto L42;
        char r22 = 0;
    L46:
        this.N = r19;
        this.O = r14;
        Interpolator r24 = this.A;
        if ((r24 instanceof m) == false) goto L62;
        float r25 = ((m) r24).a();
        this.C = r25;
        if ((Math.abs(r25) * this.L) > 1.0E-5f) goto L53;
        if (r22 != 2) goto L53;
        this.R = false;
    L53:
        if (r25 <= 0.0f) goto L58;
        if (r19 < 1.0f) goto L58;
        this.N = 1.0f;
        this.R = false;
        r19 = 1.0f;
    L58:
        if (r25 >= 0.0f) goto L62;
        if (r19 > 0.0f) goto L62;
        this.N = 0.0f;
        this.R = false;
        r17 = 0.0f;
    L71:
        if (Math.abs(this.C) <= 1.0E-5f) goto L73;
        setState(TransitionState.MOVING);
    L73:
        if (r22 == 1) goto L87;
        if (r13 <= 0.0f) goto L78;
        if (r17 < this.P) goto L78;
    L81:
        r17 = this.P;
        this.R = false;
    L83:
        if (r17 < 1.0f) goto L85;
    L86:
        this.R = false;
        setState(TransitionState.FINISHED);
        goto L87
    L85:
        if (r17 > 0.0f) goto L87;
    L78:
        if (r13 > 0.0f) goto L83;
        if (r17 > this.P) goto L83;
    L87:
        int r26 = getChildCount();
        this.f13578p0 = false;
        long r27 = getNanoTime();
        this.H0 = r17;
        Interpolator r28 = this.B;
        if (r28 != null) goto L90;
        float r29 = r17;
    L91:
        Interpolator r30 = this.B;
        if (r30 == null) goto L94;
        float r31 = r30.getInterpolation((r13 / this.L) + r17);
        this.C = r31;
        this.C = r31 - this.B.getInterpolation(r17);
    L94:
        int r32 = 0;
    L95:
        if (r32 >= r26) goto L100;
        View r110 = getChildAt(r32);
        l r111 = (l) this.f13559J.get(r110);
        if (r111 == null) goto L99;
        this.f13578p0 = r111.x(r110, r29, r27, this.I0) | this.f13578p0;
    L99:
        r32 = r32 + 1;
        goto L95
    L100:
        if (r13 <= 0.0f) goto L104;
        if (r17 < this.P) goto L104;
    L107:
        boolean r33 = true;
    L110:
        if (this.f13578p0 == true) goto L116;
        if (this.R == true) goto L116;
        if (r33 == false) goto L116;
        setState(TransitionState.FINISHED);
    L116:
        if (this.A0 == false) goto L118;
        requestLayout();
    L118:
        this.f13578p0 = (!r33) | this.f13578p0;
        if (r17 > 0.0f) goto L126;
        int r34 = this.D;
        if (r34 == (-1)) goto L126;
        if (this.E == r34) goto L126;
        this.E = r34;
        this.f13588z.l(r34).g(this);
        setState(TransitionState.FINISHED);
        r12 = true;
    L126:
        if (r17 < 1.0d) goto L131;
        int r35 = this.E;
        int r36 = this.F;
        if (r35 == r36) goto L131;
        this.E = r36;
        this.f13588z.l(r36).g(this);
        setState(TransitionState.FINISHED);
        r12 = true;
    L131:
        if (this.f13578p0 == false) goto L133;
    L143:
        invalidate();
    L145:
        if (this.f13578p0 == false) goto L147;
    L156:
        float r37 = this.N;
        if (r37 < 1.0f) goto L165;
        int r38 = this.E;
        int r39 = this.F;
        if (r38 != r39) goto L162;
        r11 = r12;
    L162:
        this.E = r39;
    L163:
        r12 = r11;
    L171:
        this.Y0 |= r12;
        if (r12 == true) goto L174;
    L176:
        this.M = this.N;
        return;
    L174:
        if (this.J0 == true) goto L176;
        requestLayout();
        goto L176
    L165:
        if (r37 > 0.0f) goto L171;
        int r40 = this.E;
        int r41 = this.D;
        if (r40 != r41) goto L170;
        r11 = r12;
    L170:
        this.E = r41;
        goto L163
    L147:
        if (this.R == true) goto L156;
        if (r13 <= 0.0f) goto L152;
        if (r17 != 1.0f) goto L152;
    L155:
        r0();
    L152:
        if (r13 >= 0.0f) goto L156;
        if (r17 != 0.0f) goto L156;
    L133:
        if (this.R == true) goto L143;
        if (r13 <= 0.0f) goto L139;
        if (r17 != 1.0f) goto L139;
    L142:
        setState(TransitionState.FINISHED);
    L139:
        if (r13 >= 0.0f) goto L145;
        if (r17 != 0.0f) goto L145;
    L104:
        if (r13 <= 0.0f) goto L106;
    L108:
        r33 = false;
        goto L110
    L106:
        if (r17 > this.P) goto L108;
    L90:
        r29 = r28.getInterpolation(r17);
    L62:
        r17 = r19;
        goto L71
    L42:
        if (r21.c() == false) goto L44;
        r22 = 2;
        goto L46
    L44:
        r22 = 1;
        goto L46
    L63:
        float r42 = r15.getInterpolation(r17);
        Interpolator r43 = this.A;
        if ((r43 instanceof m) == false) goto L66;
        this.C = ((m) r43).a();
    L67:
        r17 = r42;
    L68:
        r22 = 0;
        goto L71
    L66:
        this.C = ((r43.getInterpolation(r17 + r16) - r42) * r13) / r16;
    L69:
        this.C = r16;
    L29:
        if (r13 <= 0.0f) goto L31;
    L33:
        r18 = false;
        goto L34
    L31:
        if (r17 > this.P) goto L33;
    L20:
        r16 = 0.0f;
        goto L21
    L13:
        if (this.R == false) goto L156;
        if (r23 == true) goto L17;
        if (this.P == r10) goto L156;
    L8:
        if (r10 >= 1.0f) goto L10;
        this.E = -1;
        goto L10
    }

    public final void d0() {
        float r10 = Math.signum(this.P - this.N);
        long r11 = getNanoTime();
        Interpolator r12 = this.A;
        if ((r12 instanceof yc.b) == true) goto L5;
        float r13 = (((r11 - this.O) * r10) * 1.0E-9f) / this.L;
    L6:
        float r14 = this.N + r13;
        if (this.Q == false) goto L9;
        r14 = this.P;
    L9:
        int r15 = 0;
        if (r10 <= 0.0f) goto L14;
        if (r14 < this.P) goto L14;
    L17:
        r14 = this.P;
        boolean r16 = true;
    L19:
        if (r12 == null) goto L25;
        if (r16 == true) goto L25;
        if (this.f13562b0 == false) goto L24;
        r14 = r12.getInterpolation((r11 - this.K) * 1.0E-9f);
        goto L25
    L24:
        r14 = r12.getInterpolation(r14);
    L25:
        if (r10 <= 0.0f) goto L29;
        if (r14 < this.P) goto L29;
    L32:
        r14 = this.P;
    L33:
        this.H0 = r14;
        int r17 = getChildCount();
        long r18 = getNanoTime();
        Interpolator r19 = this.B;
        if (r19 == null) goto L37;
        r14 = r19.getInterpolation(r14);
    L37:
        if (r15 >= r17) goto L43;
        View r20 = getChildAt(r15);
        l r21 = (l) this.f13559J.get(r20);
        if (r21 == null) goto L41;
        r21.x(r20, r14, r18, this.I0);
    L41:
        r15 = r15 + 1;
        goto L37
    L43:
        if (this.A0 == false) goto L50;
        requestLayout();
        return;
    L50:
        return;
    L29:
        if (r10 > 0.0f) goto L33;
        if (r14 > this.P) goto L33;
    L14:
        if (r10 <= 0.0f) goto L16;
    L18:
        r16 = false;
        goto L19
    L16:
        if (r14 > this.P) goto L18;
    L5:
        r13 = 0.0f;
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        ArrayList r11 = this.f13581s0;
        if (r11 == null) goto L8;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        ((MotionHelper) r12.next()).onPreDraw(r10);
    L8:
        c0(false);
        o r13 = this.f13588z;
        if (r13 == null) goto L13;
        s r14 = r13.f13836r;
        if (r14 == null) goto L13;
        r14.d();
    L13:
        super.dispatchDraw(r10);
        if (this.f13588z != null) goto L17;
        return;
    L17:
        if ((this.W & 1) != 1) goto L32;
        if (isInEditMode() == true) goto L32;
        this.f13583u0++;
        long r15 = getNanoTime();
        long r16 = this.f13584v0;
        if (r16 == (-1)) goto L25;
        long r17 = r15 - r16;
        if (r17 <= 200000000) goto L26;
        this.f13585w0 = ((int) ((this.f13583u0 / (r17 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.f13583u0 = 0;
        this.f13584v0 = r15;
    L26:
        Paint r18 = new Paint();
        r18.setTextSize(42.0f);
        float r19 = ((int) (getProgress() * 1000.0f)) / 10.0f;
        String r20 = this.f13585w0 + " fps " + com.obric.oui.constraintlayout.motion.widget.a.e(this, this.D) + " -> ";
        StringBuilder r21 = new StringBuilder();
        r21.append(r20);
        r21.append(com.obric.oui.constraintlayout.motion.widget.a.e(this, this.F));
        r21.append(" (progress: ");
        r21.append(r19);
        r21.append(" ) state=");
        int r22 = this.E;
        if (r22 != (-1)) goto L29;
        String r23 = "undefined";
    L30:
        r21.append(r23);
        String r24 = r21.toString();
        r18.setColor(-16777216);
        r10.drawText(r24, 11.0f, getHeight() - 29, r18);
        r18.setColor(-7864184);
        r10.drawText(r24, 10.0f, getHeight() - 30, r18);
        goto L32
    L29:
        r23 = com.obric.oui.constraintlayout.motion.widget.a.e(this, r22);
        goto L30
    L25:
        this.f13584v0 = r15;
    L32:
        if (this.W > 1) goto L34;
    L37:
        ArrayList r25 = this.f13581s0;
        if (r25 == null) goto L43;
        Iterator r26 = r25.iterator();
    L41:
        if (r26.hasNext() == false) goto L46;
        ((MotionHelper) r26.next()).onPostDraw(r10);
        goto L41
    L46:
        return;
    L43:
        return;
    L34:
        if (this.f13560a0 != null) goto L36;
        this.f13560a0 = new e(this);
    L36:
        this.f13560a0.a(r10, this.f13559J, this.f13588z.p(), this.W);
        goto L37
    }

    public final void e0() {
        if (this.T != null) goto L9;
        CopyOnWriteArrayList r10 = this.f13582t0;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f13587y0 != this.M) goto L11;
        return;
    L11:
        if (this.f13586x0 == (-1)) goto L13;
        g0();
        this.f13589z0 = true;
    L13:
        this.f13586x0 = -1;
        float r11 = this.M;
        this.f13587y0 = r11;
        TransitionListener r12 = this.T;
        if (r12 == null) goto L16;
        r12.onTransitionChange(this, this.D, this.F, r11);
    L16:
        CopyOnWriteArrayList r13 = this.f13582t0;
        if (r13 == null) goto L22;
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L22;
        ((TransitionListener) r14.next()).onTransitionChange(this, this.D, this.F, this.M);
    L22:
        this.f13589z0 = true;
    }

    public void f0() {
        if (this.T != null) goto L9;
        CopyOnWriteArrayList r10 = this.f13582t0;
        if (r10 != null) goto L7;
    L18:
        s0();
        Runnable r11 = this.L0;
        if (r11 == null) goto L21;
        r11.run();
        this.L0 = null;
    L21:
        int[] r12 = this.M0;
        if (r12 != null) goto L24;
        return;
    L24:
        if (this.N0 <= 0) goto L28;
        D0(r12[0]);
        int[] r13 = this.M0;
        System.arraycopy(r13, 1, r13, 0, r13.length - 1);
        this.N0--;
        return;
    L28:
        return;
    L7:
        if (r10.isEmpty() == true) goto L18;
    L9:
        if (this.f13586x0 != (-1)) goto L18;
        this.f13586x0 = this.E;
        if (this.f13565c1.isEmpty() == true) goto L13;
        ArrayList r14 = this.f13565c1;
        int r15 = ((Integer) r14.get(r14.size() - 1)).intValue();
    L14:
        int r16 = this.E;
        if (r15 == r16) goto L18;
        if (r16 == (-1)) goto L18;
        this.f13565c1.add(Integer.valueOf(r16));
        goto L18
    L13:
        r15 = -1;
        goto L14
    }

    public final void g0() {
        TransitionListener r10 = this.T;
        if (r10 == null) goto L5;
        r10.onTransitionStarted(this, this.D, this.F);
    L5:
        CopyOnWriteArrayList r11 = this.f13582t0;
        if (r11 == null) goto L11;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        ((TransitionListener) r12.next()).onTransitionStarted(this, this.D, this.F);
        goto L9
    L13:
        return;
    }

    @IdRes
    public int[] getConstraintSetIds() {
        o r10 = this.f13588z;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.n();
    }

    public int getCurrentState() {
        return this.E;
    }

    public ArrayList<o.b> getDefinedTransitions() {
        o r10 = this.f13588z;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.o();
    }

    public com.obric.oui.constraintlayout.motion.widget.b getDesignTool() {
        if (this.f13567e0 != null) goto L6;
        this.f13567e0 = new com.obric.oui.constraintlayout.motion.widget.b(this);
    L6:
        return this.f13567e0;
    }

    public int getEndState() {
        return this.F;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.N;
    }

    public o getScene() {
        return this.f13588z;
    }

    public int getStartState() {
        return this.D;
    }

    public float getTargetPosition() {
        return this.P;
    }

    public Bundle getTransitionState() {
        if (this.K0 != null) goto L5;
        this.K0 = new h(this);
    L5:
        this.K0.c();
        return this.K0.b();
    }

    public long getTransitionTimeMs() {
        o r10 = this.f13588z;
        if (r10 == null) goto L6;
        this.L = r10.p() / 1000.0f;
    L6:
        return (long) (this.L * 1000.0f);
    }

    public float getVelocity() {
        return this.C;
    }

    public void h0(int r10, boolean r11, float r12) {
        TransitionListener r13 = this.T;
        if (r13 == null) goto L5;
        r13.onTransitionTrigger(this, r10, r11, r12);
    L5:
        CopyOnWriteArrayList r14 = this.f13582t0;
        if (r14 == null) goto L11;
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L13;
        ((TransitionListener) r15.next()).onTransitionTrigger(this, r10, r11, r12);
        goto L9
    L13:
        return;
    }

    public void i0(int r10, float r11, float r12, float r13, float[] r14) {
        HashMap r15 = this.f13559J;
        View r16 = j(r10);
        l r17 = (l) r15.get(r16);
        if (r17 == null) goto L5;
        r17.l(r11, r12, r13, r14);
        float r18 = r16.getY();
        this.U = r11;
        this.V = r18;
        return;
    L5:
        if (r16 != null) goto L7;
        String r19 = "" + r10;
    L8:
        Log.w("MotionLayout", "WARNING could not find view id " + r19);
        return;
    L7:
        r19 = r16.getContext().getResources().getResourceName(r10);
        goto L8
    }

    public com.obric.oui.constraintlayout.widget.a j0(int r10) {
        o r11 = this.f13588z;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.l(r10);
    }

    public l k0(int r10) {
        return (l) this.f13559J.get(findViewById(r10));
    }

    public o.b l0(int r10) {
        return this.f13588z.G(r10);
    }

    public void m0(View r10, float r11, float r12, float[] r13, int r14) {
        float r15 = this.C;
        float r16 = this.N;
        if (this.A == null) goto L5;
        float r17 = Math.signum(this.P - r16);
        float r18 = this.A.getInterpolation(this.N + 1.0E-5f);
        float r19 = this.A.getInterpolation(this.N);
        r15 = (r17 * ((r18 - r19) / 1.0E-5f)) / this.L;
    L6:
        Interpolator r20 = this.A;
        if ((r20 instanceof m) == false) goto L9;
        r15 = ((m) r20).a();
    L9:
        l r21 = (l) this.f13559J.get(r10);
        if ((r14 & 1) != 0) goto L12;
        r21.r(r19, r10.getWidth(), r10.getHeight(), r11, r12, r13);
    L14:
        if (r14 >= 2) goto L17;
        r13[0] = r13[0] * r15;
        r13[1] = r13[1] * r15;
        return;
    L17:
        return;
    L12:
        r21.l(r19, r11, r12, r13);
        goto L14
    L5:
        r19 = r16;
        goto L6
    }

    public final boolean n0(float r10, float r11, View r12, MotionEvent r13) {
        if ((r12 instanceof ViewGroup) == false) goto L10;
        ViewGroup r14 = (ViewGroup) r12;
        int r15 = r14.getChildCount() - 1;
    L5:
        if (r15 < 0) goto L10;
        View r16 = r14.getChildAt(r15);
        if (n0((r16.getLeft() + r10) - r12.getScrollX(), (r16.getTop() + r11) - r12.getScrollY(), r16, r13) == true) goto L8;
        r15 = r15 - 1;
        goto L5
    L8:
        boolean r17 = true;
    L11:
        if (r17 == true) goto L20;
        this.Z0.set(r10, r11, (r12.getRight() + r10) - r12.getLeft(), (r12.getBottom() + r11) - r12.getTop());
        if (r13.getAction() != 0) goto L17;
        if (this.Z0.contains(r13.getX(), r13.getY()) == false) goto L20;
    L17:
        if (V(r12, r13, -r10, -r11) == false) goto L20;
        return true;
    L20:
        return r17;
    L10:
        r17 = false;
        goto L11
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    public void o(int r10) {
        this.f14071k = null;
    }

    public final void o0(AttributeSet r10) {
        f13558d1 = isInEditMode();
        if (r10 == null) goto L37;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.MotionLayout);
        int r12 = r11.getIndexCount();
        boolean r13 = true;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L31;
        int r15 = r11.getIndex(r14);
        if (r15 != R$styleable.MotionLayout_layoutDescription) goto L10;
        this.f13588z = new o(getContext(), this, r11.getResourceId(r15, -1));
    L30:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R$styleable.MotionLayout_currentState) goto L13;
        this.E = r11.getResourceId(r15, -1);
        goto L30
    L13:
        if (r15 != R$styleable.MotionLayout_motionProgress) goto L16;
        this.P = r11.getFloat(r15, 0.0f);
        this.R = true;
        goto L30
    L16:
        if (r15 != R$styleable.MotionLayout_applyMotionScene) goto L19;
        r13 = r11.getBoolean(r15, r13);
        goto L30
    L19:
        if (r15 != R$styleable.MotionLayout_showPaths) goto L28;
        if (this.W != 0) goto L30;
        if (r11.getBoolean(r15, false) == false) goto L25;
        int r16 = 2;
    L26:
        this.W = r16;
        goto L30
    L25:
        r16 = 0;
        goto L26
    L28:
        if (r15 != R$styleable.MotionLayout_motionDebug) goto L30;
        this.W = r11.getInt(r15, 0);
        goto L30
    L31:
        r11.recycle();
        if (this.f13588z != null) goto L34;
        Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
    L34:
        if (r13 == true) goto L37;
        this.f13588z = null;
    L37:
        if (this.W == 0) goto L40;
        W();
    L40:
        if (this.E != (-1)) goto L54;
        o r17 = this.f13588z;
        if (r17 == null) goto L55;
        this.E = r17.F();
        this.D = this.f13588z.F();
        this.F = this.f13588z.q();
        return;
    L55:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display r10 = getDisplay();
        if (r10 == null) goto L5;
        this.T0 = r10.getRotation();
    L5:
        o r11 = this.f13588z;
        if (r11 == null) goto L18;
        int r12 = this.E;
        if (r12 == (-1)) goto L18;
        com.obric.oui.constraintlayout.widget.a r13 = r11.l(r12);
        this.f13588z.T(this);
        ArrayList r14 = this.f13581s0;
        if (r14 == null) goto L15;
        Iterator r15 = r14.iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        ((MotionHelper) r15.next()).onFinishedMotionScene(this);
    L15:
        if (r13 == null) goto L17;
        r13.i(this);
    L17:
        this.D = this.E;
    L18:
        r0();
        h r16 = this.K0;
        if (r16 != null) goto L21;
        o r17 = this.f13588z;
        if (r17 == null) goto L35;
        o.b r18 = r17.f13821c;
        if (r18 != null) goto L29;
        return;
    L29:
        if (r18.x() != 4) goto L37;
        A0();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L37:
        return;
    L35:
        return;
    L21:
        if (this.V0 == false) goto L23;
        post(new b(this));
        return;
    L23:
        r16.a();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        o r11 = this.f13588z;
        if (r11 != null) goto L5;
    L38:
        return false;
    L5:
        if (this.I == false) goto L38;
        s r12 = r11.f13836r;
        if (r12 == null) goto L10;
        r12.touchEvent(r10);
    L10:
        o.b r13 = this.f13588z.f13821c;
        if (r13 == null) goto L38;
        if (r13.C() == false) goto L38;
        p r14 = r13.B();
        if (r14 == null) goto L38;
        if (r10.getAction() != 0) goto L23;
        RectF r15 = r14.p(this, new RectF());
        if (r15 == null) goto L23;
        if (r15.contains(r10.getX(), r10.getY()) == true) goto L23;
        return false;
    L23:
        int r16 = r14.q();
        if (r16 == (-1)) goto L38;
        View r17 = this.f13561a1;
        if (r17 != null) goto L28;
    L29:
        this.f13561a1 = findViewById(r16);
    L30:
        View r18 = this.f13561a1;
        if (r18 == null) goto L38;
        this.Z0.set(r18.getLeft(), this.f13561a1.getTop(), this.f13561a1.getRight(), this.f13561a1.getBottom());
        if (this.Z0.contains(r10.getX(), r10.getY()) == false) goto L38;
        if (n0(this.f13561a1.getLeft(), this.f13561a1.getTop(), this.f13561a1, r10) == true) goto L38;
        return onTouchEvent(r10);
    L28:
        if (r17.getId() == r16) goto L30;
        goto L29
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        this.J0 = true;
    L8:
        th = move-exception;
        this.J0 = false;
        throw th;
    L4:
        if (this.f13588z != null) goto L10;
        super.onLayout(r10, r11, r12, r13, r14);     // Catch: Throwable -> L8
        this.J0 = false;
        return;
    L10:
        int r15 = r13 - r11;
        int r16 = r14 - r12;
        if (this.f13571i0 == r15) goto L14;
    L15:
        t0();     // Catch: Throwable -> L8
        c0(true);     // Catch: Throwable -> L8
    L16:
        this.f13571i0 = r15;     // Catch: Throwable -> L8
        this.f13572j0 = r16;     // Catch: Throwable -> L8
        this.f13569g0 = r15;     // Catch: Throwable -> L8
        this.f13570h0 = r16;     // Catch: Throwable -> L8
        this.J0 = false;
        return;
    L14:
        if (this.f13572j0 == r16) goto L16;
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f13588z != null) goto L6;
        super.onMeasure(r10, r11);
        return;
    L6:
        boolean r12 = false;
        if (this.G == r10) goto L9;
    L12:
        boolean r13 = true;
    L14:
        if (this.Y0 == false) goto L17;
        this.Y0 = false;
        r0();
        s0();
        r13 = true;
    L17:
        if (this.f14068h == false) goto L19;
        r13 = true;
    L19:
        this.G = r10;
        this.H = r11;
        int r14 = this.f13588z.F();
        int r15 = this.f13588z.q();
        if (r13 == true) goto L24;
        if (this.X0.f(r14, r15) == true) goto L24;
    L26:
        if (r13 == false) goto L28;
        super.onMeasure(r10, r11);
    L28:
        r12 = true;
    L30:
        if (this.A0 == true) goto L32;
        if (r12 == true) goto L32;
    L41:
        d0();
        return;
    L32:
        int r16 = getPaddingTop() + getPaddingBottom();
        int r17 = this.f14063c.V() + (getPaddingLeft() + getPaddingRight());
        int r18 = this.f14063c.w() + r16;
        int r19 = this.F0;
        if (r19 == Integer.MIN_VALUE) goto L35;
        if (r19 == 0) goto L35;
    L36:
        int r20 = this.G0;
        if (r20 == Integer.MIN_VALUE) goto L39;
        if (r20 == 0) goto L39;
    L40:
        setMeasuredDimension(r17, r18);
    L39:
        int r21 = this.C0;
        r18 = (int) (r21 + (this.H0 * (this.E0 - r21)));
        requestLayout();
    L35:
        int r22 = this.B0;
        r17 = (int) (r22 + (this.H0 * (this.D0 - r22)));
        requestLayout();
    L24:
        if (this.D == (-1)) goto L26;
        super.onMeasure(r10, r11);
        this.X0.e(this.f14063c, this.f13588z.l(r14), this.f13588z.l(r15));
        this.X0.h();
        this.X0.i(r14, r15);
        goto L30
    L9:
        if (this.H != r11) goto L12;
        r13 = false;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r10, float r11, float r12, boolean r13) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r10, float r11, float r12) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r11, int r12, int r13, int[] r14, int r15) {
        o r16 = this.f13588z;
        if (r16 != null) goto L5;
        return;
    L5:
        o.b r10 = r16.f13821c;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.C() == false) goto L58;
        int r17 = -1;
        if (r10.C() == false) goto L20;
        p r18 = r10.B();
        if (r18 == null) goto L20;
        int r19 = r18.q();
        if (r19 == (-1)) goto L20;
        if (r11.getId() == r19) goto L20;
        return;
    L20:
        if (r16.w() == false) goto L34;
        p r20 = r10.B();
        if (r20 != null) goto L24;
    L26:
        float r21 = this.M;
        if (r21 == 1.0f) goto L31;
        if (r21 != 0.0f) goto L34;
    L31:
        if (r11.canScrollVertically(r17) == false) goto L34;
        return;
    L24:
        if ((r20.e() & 4) == 0) goto L26;
        r17 = r13;
    L34:
        if (r10.B() != null) goto L36;
    L47:
        float r110 = this.M;
        long r22 = getNanoTime();
        float r23 = r12;
        this.f13574l0 = r23;
        float r24 = r13;
        this.f13575m0 = r24;
        this.f13577o0 = (float) ((r22 - this.f13576n0) * 1.0E-9d);
        this.f13576n0 = r22;
        r16.P(r23, r24);
        if (r110 == this.M) goto L50;
        r14[0] = r12;
        r14[1] = r13;
    L50:
        c0(false);
        if (r14[0] == 0) goto L53;
    L54:
        this.f13573k0 = true;
        return;
    L53:
        if (r14[1] != 0) goto L54;
        return;
    L36:
        if ((r10.B().e() & 1) == 0) goto L47;
        float r25 = r16.x(r12, r13);
        float r26 = this.N;
        if (r26 > 0.0f) goto L42;
        if (r25 >= 0.0f) goto L42;
    L45:
        r11.setNestedScrollingEnabled(false);
        r11.post(new a(this, r11));
        return;
    L42:
        if (r26 < 1.0f) goto L47;
        if (r25 <= 0.0f) goto L47;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        this.f13576n0 = getNanoTime();
        this.f13577o0 = 0.0f;
        this.f13574l0 = 0.0f;
        this.f13575m0 = 0.0f;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r10) {
        o r11 = this.f13588z;
        if (r11 == null) goto L6;
        r11.W(m());
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r10, View r11, int r12, int r13) {
        o r14 = this.f13588z;
        if (r14 == null) goto L13;
        o.b r15 = r14.f13821c;
        if (r15 != null) goto L7;
        return false;
    L7:
        if (r15.B() != null) goto L9;
        return false;
    L9:
        if ((this.f13588z.f13821c.B().e() & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    L13:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r10, int r11) {
        o r12 = this.f13588z;
        if (r12 == null) goto L9;
        float r13 = this.f13577o0;
        if (r13 == 0.0f) goto L10;
        r12.Q(this.f13574l0 / r13, this.f13575m0 / r13);
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        o r11 = this.f13588z;
        if (r11 == null) goto L21;
        if (this.I == false) goto L21;
        if (r11.b0() == false) goto L21;
        o.b r12 = this.f13588z.f13821c;
        if (r12 != null) goto L11;
    L14:
        this.f13588z.R(r10, getCurrentState(), this);
        if (this.f13588z.f13821c.D(4) == true) goto L17;
        return true;
    L17:
        return this.f13588z.f13821c.B().r();
    L11:
        if (r12.C() == true) goto L14;
        return super.onTouchEvent(r10);
    L21:
        return super.onTouchEvent(r10);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View r10) {
        super.onViewAdded(r10);
        if ((r10 instanceof MotionHelper) == false) goto L26;
        MotionHelper r11 = (MotionHelper) r10;
        if (this.f13582t0 != null) goto L7;
        this.f13582t0 = new CopyOnWriteArrayList();
    L7:
        this.f13582t0.add(r11);
        if (r11.isUsedOnShow() == false) goto L14;
        if (this.f13579q0 != null) goto L12;
        this.f13579q0 = new ArrayList();
    L12:
        this.f13579q0.add(r11);
    L14:
        if (r11.isUseOnHide() == false) goto L20;
        if (this.f13580r0 != null) goto L18;
        this.f13580r0 = new ArrayList();
    L18:
        this.f13580r0.add(r11);
    L20:
        if (r11.isDecorator() == true) goto L22;
        return;
    L22:
        if (this.f13581s0 != null) goto L24;
        this.f13581s0 = new ArrayList();
    L24:
        this.f13581s0.add(r11);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        ArrayList r11 = this.f13579q0;
        if (r11 == null) goto L5;
        r11.remove(r10);
    L5:
        ArrayList r12 = this.f13580r0;
        if (r12 == null) goto L9;
        r12.remove(r10);
        return;
    }

    public boolean p0() {
        return this.I;
    }

    public MotionTracker q0() {
        return g.a();
    }

    public void r0() {
        o r10 = this.f13588z;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.h(this, this.E) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r11 = this.E;
        if (r11 == (-1)) goto L13;
        this.f13588z.f(this, r11);
    L13:
        if (this.f13588z.b0() == false) goto L16;
        this.f13588z.Z();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.A0 == false) goto L5;
    L19:
        super.requestLayout();
        return;
    L5:
        if (this.E != (-1)) goto L19;
        o r10 = this.f13588z;
        if (r10 == null) goto L19;
        o.b r11 = r10.f13821c;
        if (r11 == null) goto L19;
        int r12 = r11.z();
        if (r12 != 0) goto L14;
        return;
    L14:
        if (r12 != 2) goto L19;
        int r13 = getChildCount();
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L18;
        View r15 = getChildAt(r14);
        ((l) this.f13559J.get(r15)).z();
        r14 = r14 + 1;
        goto L16
    }

    public final void s0() {
        if (this.T != null) goto L9;
        CopyOnWriteArrayList r10 = this.f13582t0;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == false) goto L9;
        return;
    L9:
        this.f13589z0 = false;
        Iterator r11 = this.f13565c1.iterator();
    L11:
        if (r11.hasNext() == false) goto L21;
        Integer r12 = (Integer) r11.next();
        TransitionListener r13 = this.T;
        if (r13 == null) goto L15;
        r13.onTransitionCompleted(this, r12.intValue());
    L15:
        CopyOnWriteArrayList r14 = this.f13582t0;
        if (r14 == null) goto L11;
        Iterator r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L11;
        ((TransitionListener) r15.next()).onTransitionCompleted(this, r12.intValue());
        goto L19
    L21:
        this.f13565c1.clear();
    }

    public void setDebugMode(int r10) {
        this.W = r10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean r10) {
        this.V0 = r10;
    }

    public void setInteractionEnabled(boolean r10) {
        this.I = r10;
    }

    public void setInterpolatedProgress(float r10) {
        if (this.f13588z == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r11 = this.f13588z.s();
        if (r11 == null) goto L8;
        setProgress(r11.getInterpolation(r10));
        return;
    L8:
        setProgress(r10);
    }

    public void setOnHide(float r10) {
        ArrayList r11 = this.f13580r0;
        if (r11 == null) goto L7;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        ((MotionHelper) this.f13580r0.get(r13)).setProgress(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r10) {
        ArrayList r11 = this.f13579q0;
        if (r11 == null) goto L7;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        ((MotionHelper) this.f13579q0.get(r13)).setProgress(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setProgress(float r10) {
        if (r10 >= 0.0f) goto L5;
    L6:
        Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    L8:
        if (isAttachedToWindow() == false) goto L10;
        if (r10 > 0.0f) goto L24;
        if (this.N == 1.0f) goto L18;
    L20:
        this.E = this.D;
        if (this.N != 0.0f) goto L35;
        setState(TransitionState.FINISHED);
    L35:
        if (this.f13588z != null) goto L37;
        return;
    L37:
        this.Q = true;
        this.P = r10;
        this.M = r10;
        this.O = -1;
        this.K = -1;
        this.A = null;
        this.R = true;
        invalidate();
        return;
    L18:
        if (this.E != this.F) goto L20;
        setState(TransitionState.MOVING);
        goto L20
    L24:
        if (r10 >= 1.0f) goto L26;
        this.E = -1;
        setState(TransitionState.MOVING);
        goto L35
    L26:
        if (this.N == 0.0f) goto L28;
    L30:
        this.E = this.F;
        if (this.N != 1.0f) goto L35;
        setState(TransitionState.FINISHED);
        goto L35
    L28:
        if (this.E != this.D) goto L30;
        setState(TransitionState.MOVING);
        goto L30
    L10:
        if (this.K0 != null) goto L12;
        this.K0 = new h(this);
    L12:
        this.K0.e(r10);
        return;
    L5:
        if (r10 <= 1.0f) goto L8;
        goto L6
    }

    public void setScene(o r10) {
        this.f13588z = r10;
        r10.W(m());
        t0();
    }

    public void setStartState(int r10) {
        if (isAttachedToWindow() == false) goto L5;
        this.E = r10;
        return;
    L5:
        if (this.K0 != null) goto L7;
        this.K0 = new h(this);
    L7:
        this.K0.f(r10);
        this.K0.d(r10);
    }

    public void setState(TransitionState r10) {
        TransitionState r11 = TransitionState.FINISHED;
        if (r10 == r11) goto L5;
    L7:
        TransitionState r12 = this.W0;
        this.W0 = r10;
        TransitionState r13 = TransitionState.MOVING;
        if (r12 != r13) goto L11;
        if (r10 != r13) goto L11;
        e0();
    L11:
        int r14 = c.f13593a[r12.ordinal()];
        if (r14 != 1) goto L14;
    L20:
        if (r10 != r13) goto L22;
        e0();
    L22:
        if (r10 != r11) goto L27;
        f0();
        return;
    L27:
        return;
    L14:
        if (r14 == 2) goto L20;
        if (r14 != 3) goto L28;
        if (r10 != r11) goto L25;
        f0();
        return;
    L25:
        return;
    L28:
        return;
    L5:
        if (this.E != (-1)) goto L7;
    }

    public void setTransition(int r10) {
        if (this.f13588z == null) goto L35;
        o.b r11 = l0(r10);
        this.D = r11.A();
        this.F = r11.y();
        if (isAttachedToWindow() == false) goto L7;
        int r12 = this.E;
        float r13 = 0.0f;
        if (r12 != this.D) goto L15;
        float r14 = 0.0f;
    L18:
        this.f13588z.Y(r11);
        this.X0.e(this.f14063c, this.f13588z.l(this.D), this.f13588z.l(this.F));
        t0();
        if (this.N == r14) goto L27;
        if (r14 != 0.0f) goto L24;
        b0(true);
        this.f13588z.l(this.D).i(this);
        goto L27
    L24:
        if (r14 != 1.0f) goto L27;
        b0(false);
        this.f13588z.l(this.F).i(this);
    L27:
        if (Float.isNaN(r14) == true) goto L30;
        r13 = r14;
    L30:
        this.N = r13;
        if (Float.isNaN(r14) == false) goto L33;
        Log.v("MotionLayout", com.obric.oui.constraintlayout.motion.widget.a.b() + " transitionToStart ");
        C0();
        return;
    L33:
        setProgress(r14);
        return;
    L15:
        if (r12 != this.F) goto L17;
        r14 = 1.0f;
        goto L18
    L17:
        r14 = Float.NaN;
        goto L18
    L7:
        if (this.K0 != null) goto L9;
        this.K0 = new h(this);
    L9:
        this.K0.f(this.D);
        this.K0.d(this.F);
        return;
    }

    public void setTransitionDuration(int r10) {
        o r11 = this.f13588z;
        if (r11 != null) goto L6;
        Log.e("MotionLayout", "MotionScene not defined");
        return;
    L6:
        r11.V(r10);
    }

    public void setTransitionListener(TransitionListener r10) {
        this.T = r10;
    }

    public void setTransitionState(Bundle r10) {
        if (this.K0 != null) goto L5;
        this.K0 = new h(this);
    L5:
        this.K0.g(r10);
        if (isAttachedToWindow() == false) goto L9;
        this.K0.a();
        return;
    }

    public void t0() {
        this.X0.h();
        invalidate();
    }

    @Override // android.view.View
    public String toString() {
        Context r10 = getContext();
        return com.obric.oui.constraintlayout.motion.widget.a.c(r10, this.D) + "->" + com.obric.oui.constraintlayout.motion.widget.a.c(r10, this.F) + " (pos:" + this.N + " Dpos/Dt:" + this.C;
    }

    public void u0(float r10, float r11) {
        if (isAttachedToWindow() == false) goto L5;
        setProgress(r10);
        setState(TransitionState.MOVING);
        this.C = r11;
        float r12 = 0.0f;
        if (r11 == 0.0f) goto L15;
        if (r11 <= 0.0f) goto L13;
        r12 = 1.0f;
    L13:
        T(r12);
        return;
    L15:
        if (r10 != 0.0f) goto L17;
        return;
    L17:
        if (r10 != 1.0f) goto L19;
        return;
    L19:
        if (r10 <= 0.5f) goto L21;
        r12 = 1.0f;
    L21:
        T(r12);
        return;
    L5:
        if (this.K0 != null) goto L7;
        this.K0 = new h(this);
    L7:
        this.K0.e(r10);
        this.K0.h(r11);
    }

    public void v0(int r10, int r11, int r12) {
        setState(TransitionState.SETUP);
        this.E = r10;
        this.D = -1;
        this.F = -1;
        zc.a r13 = this.f14071k;
        if (r13 == null) goto L5;
        r13.d(r10, r11, r12);
        return;
    L5:
        o r14 = this.f13588z;
        if (r14 == null) goto L10;
        r14.l(r10).i(this);
        return;
    }

    public void w0(int r10, int r11) {
        if (isAttachedToWindow() == false) goto L5;
        o r12 = this.f13588z;
        if (r12 == null) goto L13;
        this.D = r10;
        this.F = r11;
        r12.X(r10, r11);
        this.X0.e(this.f14063c, this.f13588z.l(r10), this.f13588z.l(r11));
        t0();
        this.N = 0.0f;
        C0();
        return;
    L13:
        return;
    L5:
        if (this.K0 != null) goto L7;
        this.K0 = new h(this);
    L7:
        this.K0.f(r10);
        this.K0.d(r11);
    }

    public final void x0() {
        int r10 = getChildCount();
        this.X0.a();
        boolean r11 = true;
        this.R = true;
        SparseArray r12 = new SparseArray();
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L5;
        View r15 = getChildAt(r14);
        r12.put(r15.getId(), (l) this.f13559J.get(r15));
        r14 = r14 + 1;
        goto L3
    L5:
        int r16 = getWidth();
        int r17 = getHeight();
        int r18 = this.f13588z.j();
        if (r18 == (-1)) goto L13;
        int r19 = 0;
    L8:
        if (r19 >= r10) goto L13;
        l r20 = (l) this.f13559J.get(getChildAt(r19));
        if (r20 == null) goto L12;
        r20.D(r18);
    L12:
        r19 = r19 + 1;
    L13:
        SparseBooleanArray r110 = new SparseBooleanArray();
        int[] r111 = new int[this.f13559J.size()];
        int r21 = 0;
        int r112 = 0;
    L14:
        if (r21 >= r10) goto L20;
        l r22 = (l) this.f13559J.get(getChildAt(r21));
        if (r22.h() == (-1)) goto L18;
        r110.put(r22.h(), true);
        r111[r112] = r22.h();
        r112 = r112 + 1;
    L18:
        r21 = r21 + 1;
        goto L14
    L20:
        if (this.f13581s0 == null) goto L39;
        int r23 = 0;
    L22:
        if (r23 >= r112) goto L28;
        l r24 = (l) this.f13559J.get(findViewById(r111[r23]));
        if (r24 == null) goto L27;
        this.f13588z.t(r24);
    L27:
        r23 = r23 + 1;
        goto L22
    L28:
        Iterator r25 = this.f13581s0.iterator();
    L30:
        if (r25.hasNext() == false) goto L32;
        ((MotionHelper) r25.next()).onPreSetup(this, this.f13559J);
        goto L30
    L32:
        int r113 = 0;
    L33:
        if (r113 >= r112) goto L46;
        l r26 = (l) this.f13559J.get(findViewById(r111[r113]));
        if (r26 == null) goto L38;
        r26.I(r16, r17, this.L, getNanoTime());
    L38:
        r113 = r113 + 1;
    L46:
        int r114 = 0;
    L47:
        if (r114 >= r10) goto L54;
        View r27 = getChildAt(r114);
        l r28 = (l) this.f13559J.get(r27);
        if (r110.get(r27.getId()) == true) goto L53;
        if (r28 == null) goto L53;
        this.f13588z.t(r28);
        r28.I(r16, r17, this.L, getNanoTime());
    L53:
        r114 = r114 + 1;
        goto L47
    L54:
        float r29 = this.f13588z.E();
        if (r29 != 0.0f) goto L57;
        return;
    L57:
        if (r29 < 0.0d) goto L60;
        r11 = false;
    L60:
        float r30 = Math.abs(r29);
        float r31 = -3.4028235E38f;
        float r32 = Float.MAX_VALUE;
        int r33 = 0;
        float r34 = -3.4028235E38f;
        float r35 = Float.MAX_VALUE;
    L62:
        if (r33 >= r10) goto L84;
        l r115 = (l) this.f13559J.get(getChildAt(r33));
        if (Float.isNaN(r115.f13784m) == false) goto L65;
        float r36 = r115.n();
        float r116 = r115.o();
        if (r11 == false) goto L82;
        float r117 = r116 - r36;
    L83:
        r35 = Math.min(r35, r117);
        r34 = Math.max(r34, r117);
        r33 = r33 + 1;
        goto L62
    L82:
        r117 = r116 + r36;
        goto L83
    L65:
        int r37 = 0;
    L66:
        if (r37 >= r10) goto L71;
        l r38 = (l) this.f13559J.get(getChildAt(r37));
        if (Float.isNaN(r38.f13784m) == true) goto L70;
        r32 = Math.min(r32, r38.f13784m);
        r31 = Math.max(r31, r38.f13784m);
    L70:
        r37 = r37 + 1;
    L71:
        if (r13 >= r10) goto L126;
        l r39 = (l) this.f13559J.get(getChildAt(r13));
        if (Float.isNaN(r39.f13784m) == true) goto L78;
        r39.f13786o = 1.0f / (1.0f - r30);
        if (r11 == false) goto L77;
        r39.f13785n = r30 - (((r31 - r39.f13784m) / (r31 - r32)) * r30);
        goto L78
    L77:
        r39.f13785n = r30 - (((r39.f13784m - r32) * r30) / (r31 - r32));
    L78:
        r13 = r13 + 1;
        goto L71
    L126:
        return;
    L84:
        if (r13 >= r10) goto L127;
        l r40 = (l) this.f13559J.get(getChildAt(r13));
        float r41 = r40.n();
        float r42 = r40.o();
        if (r11 == false) goto L88;
        float r43 = r42 - r41;
    L89:
        r40.f13786o = 1.0f / (1.0f - r30);
        r40.f13785n = r30 - (((r43 - r35) * r30) / (r34 - r35));
        r13 = r13 + 1;
        goto L84
    L88:
        r43 = r42 + r41;
        goto L89
    L127:
        return;
    L39:
        int r118 = 0;
    L40:
        if (r118 >= r112) goto L46;
        l r44 = (l) this.f13559J.get(findViewById(r111[r118]));
        if (r44 == null) goto L45;
        this.f13588z.t(r44);
        r44.I(r16, r17, this.L, getNanoTime());
    L45:
        r118 = r118 + 1;
        goto L40
    }

    public final Rect y0(ConstraintWidget r10) {
        Rect r11 = this.U0;
        r11.top = r10.X();
        Rect r12 = this.U0;
        r12.left = r10.W();
        Rect r13 = this.U0;
        int r14 = r10.V();
        Rect r15 = this.U0;
        r13.right = r14 + r15.left;
        int r16 = r10.w();
        Rect r17 = this.U0;
        r15.bottom = r16 + r17.top;
        return r17;
    }

    public void z0(int r10, float r11, float r12) {
        if (this.f13588z != null) goto L6;
        return;
    L6:
        if (this.N != r11) goto L8;
        return;
    L8:
        this.f13562b0 = true;
        this.K = getNanoTime();
        this.L = this.f13588z.p() / 1000.0f;
        this.P = r11;
        this.R = true;
        if (r10 == 0) goto L24;
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L24;
        if (r10 != 4) goto L15;
        this.f13566d0.b(r12, this.N, this.f13588z.u());
        this.A = this.f13566d0;
    L36:
        this.Q = false;
        this.K = getNanoTime();
        invalidate();
        return;
    L15:
        if (r10 == 5) goto L20;
        if (r10 == 6) goto L24;
        if (r10 == 7) goto L24;
    L20:
        if (L0(r12, this.N, this.f13588z.u()) == false) goto L22;
        this.f13566d0.b(r12, this.N, this.f13588z.u());
        this.A = this.f13566d0;
        goto L36
    L22:
        this.f13564c0.b(this.N, r11, r12, this.L, this.f13588z.u(), this.f13588z.v());
        this.C = 0.0f;
        int r13 = this.E;
        this.P = r11;
        this.E = r13;
        this.A = this.f13564c0;
    L24:
        if (r10 == 1) goto L30;
        if (r10 == 7) goto L30;
        if (r10 == 2) goto L29;
        if (r10 == 6) goto L29;
    L32:
        if (this.f13588z.k() != 0) goto L34;
        this.f13564c0.b(this.N, r11, r12, this.L, this.f13588z.u(), this.f13588z.v());
    L35:
        int r14 = this.E;
        this.P = r11;
        this.E = r14;
        this.A = this.f13564c0;
        goto L36
    L34:
        this.f13564c0.d(this.N, r11, r12, this.f13588z.B(), this.f13588z.C(), this.f13588z.A(), this.f13588z.D(), this.f13588z.z());
    L29:
        r11 = 1.0f;
    L30:
        r11 = 0.0f;
        goto L32
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15, int[] r16) {
        if (this.f13573k0 == true) goto L6;
        if (r11 != 0) goto L6;
        if (r12 != 0) goto L6;
    L7:
        this.f13573k0 = false;
        return;
    L6:
        r16[0] = r16[0] + r13;
        r16[1] = r16[1] + r14;
        goto L7
    }

    public void setTransition(o.b r10) {
        this.f13588z.Y(r10);
        setState(TransitionState.SETUP);
        if (this.E != this.f13588z.q()) goto L5;
        this.N = 1.0f;
        this.M = 1.0f;
        this.P = 1.0f;
    L7:
        if (r10.D(1) == false) goto L9;
        long r11 = -1;
    L10:
        this.O = r11;
        int r12 = this.f13588z.F();
        int r13 = this.f13588z.q();
        if (r12 == this.D) goto L13;
    L15:
        this.D = r12;
        this.F = r13;
        this.f13588z.X(r12, r13);
        this.X0.e(this.f14063c, this.f13588z.l(this.D), this.f13588z.l(this.F));
        this.X0.i(this.D, this.F);
        this.X0.h();
        t0();
        return;
    L13:
        if (r13 != this.F) goto L15;
        return;
    L9:
        r11 = getNanoTime();
        goto L10
    L5:
        this.N = 0.0f;
        this.M = 0.0f;
        this.P = 0.0f;
        goto L7
    }

    public MotionLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.B = null;
        this.C = 0.0f;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.I = true;
        this.f13559J = new HashMap();
        this.K = 0;
        this.L = 1.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.P = 0.0f;
        this.R = false;
        this.S = false;
        this.W = 0;
        this.f13562b0 = false;
        this.f13564c0 = new yc.b();
        this.f13566d0 = new d(this);
        this.f13568f0 = true;
        this.f13573k0 = false;
        this.f13578p0 = false;
        this.f13579q0 = null;
        this.f13580r0 = null;
        this.f13581s0 = null;
        this.f13582t0 = null;
        this.f13583u0 = 0;
        this.f13584v0 = -1;
        this.f13585w0 = 0.0f;
        this.f13586x0 = 0;
        this.f13587y0 = 0.0f;
        this.f13589z0 = false;
        this.A0 = false;
        this.I0 = new vc.d();
        this.J0 = false;
        this.L0 = null;
        this.M0 = null;
        this.N0 = 0;
        this.O0 = false;
        this.P0 = 0;
        this.Q0 = new HashMap();
        this.U0 = new Rect();
        this.V0 = false;
        this.W0 = TransitionState.UNDEFINED;
        this.X0 = new f(this);
        this.Y0 = false;
        this.Z0 = new RectF();
        this.f13561a1 = null;
        this.f13563b1 = null;
        this.f13565c1 = new ArrayList();
        o0(r11);
    }

    public MotionLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.B = null;
        this.C = 0.0f;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.I = true;
        this.f13559J = new HashMap();
        this.K = 0;
        this.L = 1.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.P = 0.0f;
        this.R = false;
        this.S = false;
        this.W = 0;
        this.f13562b0 = false;
        this.f13564c0 = new yc.b();
        this.f13566d0 = new d(this);
        this.f13568f0 = true;
        this.f13573k0 = false;
        this.f13578p0 = false;
        this.f13579q0 = null;
        this.f13580r0 = null;
        this.f13581s0 = null;
        this.f13582t0 = null;
        this.f13583u0 = 0;
        this.f13584v0 = -1;
        this.f13585w0 = 0.0f;
        this.f13586x0 = 0;
        this.f13587y0 = 0.0f;
        this.f13589z0 = false;
        this.A0 = false;
        this.I0 = new vc.d();
        this.J0 = false;
        this.L0 = null;
        this.M0 = null;
        this.N0 = 0;
        this.O0 = false;
        this.P0 = 0;
        this.Q0 = new HashMap();
        this.U0 = new Rect();
        this.V0 = false;
        this.W0 = TransitionState.UNDEFINED;
        this.X0 = new f(this);
        this.Y0 = false;
        this.Z0 = new RectF();
        this.f13561a1 = null;
        this.f13563b1 = null;
        this.f13565c1 = new ArrayList();
        o0(r11);
    }
}

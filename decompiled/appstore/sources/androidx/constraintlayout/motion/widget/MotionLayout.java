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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.view.NestedScrollingParent3;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static boolean E0;
    public m.b A;
    public RectF A0;
    public e B;
    public View B0;
    public androidx.constraintlayout.motion.widget.b C;
    public Matrix C0;
    public boolean D;
    public ArrayList D0;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f1725J;
    public float K;
    public long L;
    public float M;
    public boolean N;
    public ArrayList O;
    public ArrayList P;
    public ArrayList Q;
    public CopyOnWriteArrayList R;
    public int S;
    public long T;
    public float U;
    public int V;
    public float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f1726a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f1727a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Interpolator f1728b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1729b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f1730c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f1731c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1732d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f1733d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1734e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f1735e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1736f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f1737f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1738g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f1739g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1740h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f1741h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1742i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f1743i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1744j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public p001j.d f1745j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap f1746k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f1747k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1748l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public i f1749l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1750m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public Runnable f1751m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1752n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int[] f1753n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f1754o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f1755o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f1756p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f1757p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f1758q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f1759q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1760r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public HashMap f1761r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1762s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f1763s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1764t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f1765t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TransitionListener f1766u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f1767u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f1768v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public Rect f1769v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f1770w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f1771w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1772x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public TransitionState f1773x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f1774y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public g f1775y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1776z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f1777z0;

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

        private static /* synthetic */ TransitionState[] $values() {
            return new TransitionState[]{UNDEFINED, SETUP, MOVING, FINISHED};
        }

        static {
            UNDEFINED = new TransitionState("UNDEFINED", 0);
            SETUP = new TransitionState("SETUP", 1);
            MOVING = new TransitionState("MOVING", 2);
            FINISHED = new TransitionState("FINISHED", 3);
            $VALUES = $values();
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
        public final /* synthetic */ MotionLayout f1778a;

        public a(MotionLayout r10) {
            this.f1778a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.g(this.f1778a).a();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1779a;

        public b(MotionLayout r10, View r11) {
            this.f1779a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1779a.setNestedScrollingEnabled(true);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f1780a;

        public c(MotionLayout r10) {
            this.f1780a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.g(this.f1780a).a();
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1781a = null;

        static {
            int[] r10 = new int[TransitionState.values().length];
            f1781a = r10;
            r10[TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f1781a[TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f1781a[TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f1781a[TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class e extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f1782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f1785d;

        public e(MotionLayout r10) {
            this.f1785d = r10;
            this.f1782a = 0.0f;
            this.f1783b = 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.m
        public float a() {
            return this.f1785d.f1732d;
        }

        public void b(float r10, float r11, float r12) {
            this.f1782a = r10;
            this.f1783b = r11;
            this.f1784c = r12;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = this.f1782a;
            if (r11 <= 0.0f) goto L10;
            float r12 = this.f1784c;
            if ((r11 / r12) >= r10) goto L7;
            r10 = r11 / r12;
        L7:
            float r13 = r11 - (r12 * r10);
            this.f1785d.f1732d = r13;
            float r14 = (r11 * r10) - (((r12 * r10) * r10) / 2.0f);
            float r15 = this.f1783b;
        L9:
            return r14 + r15;
        L10:
            float r16 = this.f1784c;
            if (((-r11) / r16) >= r10) goto L13;
            r10 = (-r11) / r16;
        L13:
            float r17 = (r16 * r10) + r11;
            this.f1785d.f1732d = r17;
            r14 = (r11 * r10) + (((r16 * r10) * r10) / 2.0f);
            r15 = this.f1783b;
            goto L9
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f1786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f1787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float[] f1788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Path f1789d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f1790e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Paint f1791f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Paint f1792g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Paint f1793h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Paint f1794i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f1795j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f1796k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f1797l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f1798m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f1799n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f1800o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public DashPathEffect f1801p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1802q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Rect f1803r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f1804s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f1805t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f1806u;

        public f(MotionLayout r10) {
            this.f1806u = r10;
            this.f1796k = -21965;
            this.f1797l = -2067046;
            this.f1798m = -13391360;
            this.f1799n = 1996488704;
            this.f1800o = 10;
            this.f1803r = new Rect();
            this.f1804s = false;
            this.f1805t = 1;
            Paint r11 = new Paint();
            this.f1790e = r11;
            r11.setAntiAlias(true);
            this.f1790e.setColor(-21965);
            this.f1790e.setStrokeWidth(2.0f);
            Paint r12 = this.f1790e;
            Paint.Style r13 = Paint.Style.STROKE;
            r12.setStyle(r13);
            Paint r14 = new Paint();
            this.f1791f = r14;
            r14.setAntiAlias(true);
            this.f1791f.setColor(-2067046);
            this.f1791f.setStrokeWidth(2.0f);
            this.f1791f.setStyle(r13);
            Paint r15 = new Paint();
            this.f1792g = r15;
            r15.setAntiAlias(true);
            this.f1792g.setColor(-13391360);
            this.f1792g.setStrokeWidth(2.0f);
            this.f1792g.setStyle(r13);
            Paint r16 = new Paint();
            this.f1793h = r16;
            r16.setAntiAlias(true);
            this.f1793h.setColor(-13391360);
            this.f1793h.setTextSize(r10.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f1795j = new float[8];
            Paint r17 = new Paint();
            this.f1794i = r17;
            r17.setAntiAlias(true);
            DashPathEffect r18 = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f1801p = r18;
            this.f1792g.setPathEffect(r18);
            this.f1788c = new float[100];
            this.f1787b = new int[50];
            if (this.f1804s == false) goto L6;
            this.f1790e.setStrokeWidth(8.0f);
            this.f1794i.setStrokeWidth(8.0f);
            this.f1791f.setStrokeWidth(8.0f);
            this.f1805t = 4;
            return;
        }

        public void a(Canvas r10, HashMap r11, int r12, int r13) {
            if (r11 != null) goto L4;
            return;
        L4:
            if (r11.size() == 0) goto L42;
            r10.save();
            if (this.f1806u.isInEditMode() == false) goto L9;
        L11:
            Iterator r14 = r11.values().iterator();
        L13:
            if (r14.hasNext() == false) goto L30;
            l r15 = (l) r14.next();
            int r16 = r15.n();
            if (r13 <= 0) goto L18;
            if (r16 != 0) goto L18;
            r16 = 1;
        L18:
            if (r16 == 0) goto L13;
            this.f1802q = r15.c(this.f1788c, this.f1787b);
            if (r16 < 1) goto L13;
            int r17 = r12 / 16;
            float[] r18 = this.f1786a;
            if (r18 != null) goto L25;
        L26:
            this.f1786a = new float[r17 * 2];
            this.f1789d = new Path();
        L27:
            int r19 = this.f1805t;
            r10.translate(r19, r19);
            this.f1790e.setColor(1996488704);
            this.f1794i.setColor(1996488704);
            this.f1791f.setColor(1996488704);
            this.f1792g.setColor(1996488704);
            r15.d(this.f1786a, r17);
            b(r10, r16, this.f1802q, r15);
            this.f1790e.setColor(-21965);
            this.f1791f.setColor(-2067046);
            this.f1794i.setColor(-2067046);
            this.f1792g.setColor(-13391360);
            int r20 = this.f1805t;
            r10.translate(-r20, -r20);
            b(r10, r16, this.f1802q, r15);
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
            String r21 = this.f1806u.getContext().getResources().getResourceName(MotionLayout.h(this.f1806u)) + ":" + this.f1806u.getProgress();
            r10.drawText(r21, 10.0f, this.f1806u.getHeight() - 30, this.f1793h);
            r10.drawText(r21, 11.0f, this.f1806u.getHeight() - 29, this.f1790e);
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
            r10.drawLines(this.f1786a, this.f1790e);
        }

        public final void d(Canvas r10) {
            int r11 = 0;
            boolean r12 = false;
            boolean r13 = false;
        L4:
            if (r11 >= this.f1802q) goto L11;
            int r14 = this.f1787b[r11];
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
            float[] r10 = this.f1786a;
            float r11 = r10[0];
            float r12 = r10[1];
            float r13 = r10[r10.length - 2];
            float r14 = r10[r10.length - 1];
            r19.drawLine(Math.min(r11, r13), Math.max(r12, r14), Math.max(r11, r13), Math.max(r12, r14), this.f1792g);
            r19.drawLine(Math.min(r11, r13), Math.min(r12, r14), Math.min(r11, r13), Math.max(r12, r14), this.f1792g);
        }

        public final void f(Canvas r19, float r20, float r21) {
            float[] r10 = this.f1786a;
            float r11 = r10[0];
            float r12 = r10[1];
            float r13 = r10[r10.length - 2];
            float r14 = r10[r10.length - 1];
            float r15 = Math.min(r11, r13);
            float r16 = Math.max(r12, r14);
            float r17 = r20 - Math.min(r11, r13);
            float r18 = Math.max(r12, r14) - r21;
            String r22 = "" + (((int) (((double) ((r17 * 100.0f) / Math.abs(r13 - r11))) + 0.5d)) / 100.0f);
            l(r22, this.f1793h);
            r19.drawText(r22, ((r17 / 2.0f) - (this.f1803r.width() / 2)) + r15, r21 - 20.0f, this.f1793h);
            r19.drawLine(r20, r21, Math.min(r11, r13), r21, this.f1792g);
            String r23 = "" + (((int) (((double) ((r18 * 100.0f) / Math.abs(r14 - r12))) + 0.5d)) / 100.0f);
            l(r23, this.f1793h);
            r19.drawText(r23, r20 + 5.0f, r16 - ((r18 / 2.0f) - (this.f1803r.height() / 2)), this.f1793h);
            r19.drawLine(r20, r21, r20, Math.max(r12, r14), this.f1792g);
        }

        public final void g(Canvas r10) {
            float[] r11 = this.f1786a;
            r10.drawLine(r11[0], r11[1], r11[r11.length - 2], r11[r11.length - 1], this.f1792g);
        }

        public final void h(Canvas r13, float r14, float r15) {
            float[] r10 = this.f1786a;
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
            l(r25, this.f1793h);
            r13.drawTextOnPath(r25, r23, (r24 / 2.0f) - (this.f1803r.width() / 2), -20.0f, this.f1793h);
            r13.drawLine(r14, r15, r22, r110, this.f1792g);
        }

        public final void i(Canvas r16, float r17, float r18, int r19, int r20) {
            String r10 = "" + (((int) (((double) (((r17 - (r19 / 2)) * 100.0f) / (this.f1806u.getWidth() - r19))) + 0.5d)) / 100.0f);
            l(r10, this.f1793h);
            r16.drawText(r10, ((r17 / 2.0f) - (this.f1803r.width() / 2)) + 0.0f, r18 - 20.0f, this.f1793h);
            r16.drawLine(r17, r18, Math.min(0.0f, 1.0f), r18, this.f1792g);
            String r11 = "" + (((int) (((double) (((r18 - (r20 / 2)) * 100.0f) / (this.f1806u.getHeight() - r20))) + 0.5d)) / 100.0f);
            l(r11, this.f1793h);
            r16.drawText(r11, r17 + 5.0f, 0.0f - ((r18 / 2.0f) - (this.f1803r.height() / 2)), this.f1793h);
            r16.drawLine(r17, r18, r17, Math.max(0.0f, 1.0f), this.f1792g);
        }

        public final void j(Canvas r10, l r11) {
            this.f1789d.reset();
            int r12 = 0;
        L4:
            if (r12 > 50) goto L6;
            r11.e(r12 / 50, this.f1795j, 0);
            Path r13 = this.f1789d;
            float[] r14 = this.f1795j;
            r13.moveTo(r14[0], r14[1]);
            Path r15 = this.f1789d;
            float[] r16 = this.f1795j;
            r15.lineTo(r16[2], r16[3]);
            Path r17 = this.f1789d;
            float[] r18 = this.f1795j;
            r17.lineTo(r18[4], r18[5]);
            Path r19 = this.f1789d;
            float[] r20 = this.f1795j;
            r19.lineTo(r20[6], r20[7]);
            this.f1789d.close();
            r12 = r12 + 1;
            goto L4
        L6:
            this.f1790e.setColor(1140850688);
            r10.translate(2.0f, 2.0f);
            r10.drawPath(this.f1789d, this.f1790e);
            r10.translate(-2.0f, -2.0f);
            this.f1790e.setColor(-65536);
            r10.drawPath(this.f1789d, this.f1790e);
        }

        public final void k(Canvas r20, int r21, int r22, l r23) {
            View r10 = r23.f1901b;
            if (r10 == null) goto L5;
            int r11 = r10.getWidth();
            int r12 = r23.f1901b.getHeight();
        L6:
            int r14 = 1;
        L8:
            if (r14 >= (r22 - 1)) goto L36;
            if (r21 == 4) goto L12;
        L14:
            float[] r13 = this.f1788c;
            int r15 = r14 * 2;
            float r16 = r13[r15];
            float r17 = r13[r15 + 1];
            this.f1789d.reset();
            this.f1789d.moveTo(r16, r17 + 10.0f);
            this.f1789d.lineTo(r16 + 10.0f, r17);
            this.f1789d.lineTo(r16, r17 - 10.0f);
            this.f1789d.lineTo(r16 - 10.0f, r17);
            this.f1789d.close();
            int r18 = r14 - 1;
            r23.r(r18);
            if (r21 != 4) goto L25;
            int r19 = this.f1787b[r18];
            if (r19 != 1) goto L20;
            h(r20, r16 - 0.0f, r17 - 0.0f);
        L24:
            r20.drawPath(this.f1789d, this.f1794i);
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
            r20.drawPath(this.f1789d, this.f1794i);
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
            if (this.f1787b[r14 - 1] != 0) goto L14;
        L36:
            float[] r24 = this.f1786a;
            if (r24.length <= 1) goto L43;
            r20.drawCircle(r24[0], r24[1], 8.0f, this.f1791f);
            float[] r25 = this.f1786a;
            r20.drawCircle(r25[r25.length - 2], r25[r25.length - 1], 8.0f, this.f1791f);
            return;
        L43:
            return;
        L5:
            r11 = 0;
            r12 = 0;
            goto L6
        }

        public void l(String r10, Paint r11) {
            r11.getTextBounds(r10, 0, r10.length(), this.f1803r);
        }
    }

    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintWidgetContainer f1807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidgetContainer f1808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ConstraintSet f1809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ConstraintSet f1810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1812f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f1813g;

        public g(MotionLayout r10) {
            this.f1813g = r10;
            this.f1807a = new ConstraintWidgetContainer();
            this.f1808b = new ConstraintWidgetContainer();
            this.f1809c = null;
            this.f1810d = null;
        }

        public void a() {
            int r10 = this.f1813g.getChildCount();
            this.f1813g.f1746k.clear();
            SparseArray r11 = new SparseArray();
            int[] r12 = new int[r10];
            int r13 = 0;
        L3:
            if (r13 >= r10) goto L5;
            View r14 = this.f1813g.getChildAt(r13);
            l r15 = new l(r14);
            int r16 = r14.getId();
            r12[r13] = r16;
            r11.put(r16, r15);
            this.f1813g.f1746k.put(r14, r15);
            r13 = r13 + 1;
            goto L3
        L5:
            int r17 = 0;
        L6:
            if (r17 >= r10) goto L31;
            View r18 = this.f1813g.getChildAt(r17);
            l r19 = (l) this.f1813g.f1746k.get(r18);
            if (r19 != null) goto L11;
            r11 = r11;
        L30:
            r17 = r17 + 1;
            r11 = r11;
            goto L6
        L11:
            if (this.f1809c == null) goto L20;
            ConstraintWidget r20 = d(this.f1807a, r18);
            if (r20 == null) goto L16;
            r19.J(MotionLayout.t(this.f1813g, r20), this.f1809c, this.f1813g.getWidth(), this.f1813g.getHeight());
        L23:
            if (this.f1810d == null) goto L30;
            ConstraintWidget r21 = d(this.f1808b, r18);
            if (r21 == null) goto L28;
            r19.G(MotionLayout.t(this.f1813g, r21), this.f1810d, this.f1813g.getWidth(), this.f1813g.getHeight());
            goto L30
        L28:
            if (this.f1813g.f1772x == 0) goto L30;
            Log.e("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + "no widget for  " + androidx.constraintlayout.motion.widget.a.d(r18) + " (" + r18.getClass().getName() + ")");
            goto L30
        L16:
            if (this.f1813g.f1772x == 0) goto L23;
            Log.e("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + "no widget for  " + androidx.constraintlayout.motion.widget.a.d(r18) + " (" + r18.getClass().getName() + ")");
            goto L23
        L20:
            if (MotionLayout.w(this.f1813g) == false) goto L23;
            androidx.appcompat.widget.p.a(this.f1813g.f1761r0.get(r18));
            MotionLayout r22 = this.f1813g;
            r19.K(null, r18, r22.f1759q0, MotionLayout.u(r22), MotionLayout.v(this.f1813g));
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
            r25.N((l) r24.get(r26));
        L36:
            r23 = r23 + 1;
            r110 = r24;
            goto L32
        }

        public final void b(int r10, int r11) {
            int r12 = this.f1813g.getOptimizationLevel();
            MotionLayout r13 = this.f1813g;
            if (r13.f1736f != r13.getStartState()) goto L26;
            MotionLayout r14 = this.f1813g;
            ConstraintWidgetContainer r15 = this.f1808b;
            ConstraintSet r16 = this.f1810d;
            if (r16 != null) goto L7;
        L10:
            int r17 = r10;
        L11:
            if (r16 != null) goto L13;
        L16:
            int r18 = r11;
        L17:
            MotionLayout.o(r14, r15, r12, r17, r18);
            ConstraintSet r19 = this.f1809c;
            if (r19 == null) goto L49;
            MotionLayout r20 = this.f1813g;
            ConstraintWidgetContainer r21 = this.f1807a;
            int r22 = r19.f2269d;
            if (r22 != 0) goto L22;
            int r23 = r10;
        L23:
            if (r22 != 0) goto L25;
            r10 = r11;
        L25:
            MotionLayout.p(r20, r21, r12, r23, r10);
            return;
        L22:
            r23 = r11;
            goto L23
        L49:
            return;
        L13:
            if (r16.f2269d == 0) goto L16;
            r18 = r10;
            goto L17
        L7:
            if (r16.f2269d == 0) goto L10;
            r17 = r11;
            goto L11
        L26:
            ConstraintSet r24 = this.f1809c;
            if (r24 == null) goto L36;
            MotionLayout r25 = this.f1813g;
            ConstraintWidgetContainer r26 = this.f1807a;
            int r27 = r24.f2269d;
            if (r27 != 0) goto L31;
            int r28 = r10;
        L32:
            if (r27 != 0) goto L34;
            int r29 = r11;
        L35:
            MotionLayout.q(r25, r26, r12, r28, r29);
            goto L36
        L34:
            r29 = r10;
            goto L35
        L31:
            r28 = r11;
        L36:
            MotionLayout r30 = this.f1813g;
            ConstraintWidgetContainer r31 = this.f1808b;
            ConstraintSet r32 = this.f1810d;
            if (r32 != null) goto L39;
        L42:
            int r33 = r10;
        L43:
            if (r32 != null) goto L45;
        L46:
            r10 = r11;
        L47:
            MotionLayout.r(r30, r31, r12, r33, r10);
            return;
        L45:
            if (r32.f2269d != 0) goto L47;
        L39:
            if (r32.f2269d == 0) goto L42;
            r33 = r11;
            goto L43
        }

        public void c(ConstraintWidgetContainer r10, ConstraintWidgetContainer r11) {
            ArrayList r12 = r10.s1();
            HashMap r13 = new HashMap();
            r13.put(r10, r11);
            r11.s1().clear();
            r11.k(r10, r13);
            Iterator r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L22;
            ConstraintWidget r15 = (ConstraintWidget) r14.next();
            if ((r15 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L9;
            ConstraintWidget r16 = new androidx.constraintlayout.core.widgets.a();
        L21:
            r11.add(r16);
            r13.put(r15, r16);
            goto L4
        L9:
            if ((r15 instanceof androidx.constraintlayout.core.widgets.e) == false) goto L12;
            r16 = new androidx.constraintlayout.core.widgets.e();
            goto L21
        L12:
            if ((r15 instanceof androidx.constraintlayout.core.widgets.d) == false) goto L15;
            r16 = new androidx.constraintlayout.core.widgets.d();
            goto L21
        L15:
            if ((r15 instanceof androidx.constraintlayout.core.widgets.g) == false) goto L18;
            r16 = new androidx.constraintlayout.core.widgets.g();
            goto L21
        L18:
            if ((r15 instanceof Helper) == false) goto L20;
            r16 = new k.a();
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

        public ConstraintWidget d(ConstraintWidgetContainer r10, View r11) {
            if (r10.r() != r11) goto L5;
            return r10;
        L5:
            ArrayList r12 = r10.s1();
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

        public void e(ConstraintWidgetContainer r10, ConstraintSet r11, ConstraintSet r12) {
            this.f1809c = r11;
            this.f1810d = r12;
            this.f1807a = new ConstraintWidgetContainer();
            this.f1808b = new ConstraintWidgetContainer();
            this.f1807a.X1(MotionLayout.x(this.f1813g).K1());
            this.f1808b.X1(MotionLayout.y(this.f1813g).K1());
            this.f1807a.v1();
            this.f1808b.v1();
            c(MotionLayout.z(this.f1813g), this.f1807a);
            c(MotionLayout.A(this.f1813g), this.f1808b);
            if (this.f1813g.f1754o <= 0.5d) goto L7;
            if (r11 == null) goto L6;
            j(this.f1807a, r11);
        L6:
            j(this.f1808b, r12);
        L10:
            this.f1807a.a2(MotionLayout.B(this.f1813g));
            this.f1807a.c2();
            this.f1808b.a2(MotionLayout.C(this.f1813g));
            this.f1808b.c2();
            ViewGroup.LayoutParams r13 = this.f1813g.getLayoutParams();
            if (r13 != null) goto L13;
            return;
        L13:
            if (r13.width != (-2)) goto L16;
            ConstraintWidgetContainer r14 = this.f1807a;
            ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r14.Q0(r15);
            this.f1808b.Q0(r15);
        L16:
            if (r13.height != (-2)) goto L20;
            ConstraintWidgetContainer r16 = this.f1807a;
            ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r16.h1(r17);
            this.f1808b.h1(r17);
            return;
        L20:
            return;
        L7:
            j(this.f1808b, r12);
            if (r11 == null) goto L10;
            j(this.f1807a, r11);
            goto L10
        }

        public boolean f(int r10, int r11) {
            if (r10 == this.f1811e) goto L5;
        L8:
            return true;
        L5:
            if (r11 != this.f1812f) goto L8;
            return false;
        }

        public void g(int r16, int r17) {
            int r10 = View.MeasureSpec.getMode(r16);
            int r11 = View.MeasureSpec.getMode(r17);
            MotionLayout r12 = this.f1813g;
            r12.f1739g0 = r10;
            r12.f1741h0 = r11;
            r12.getOptimizationLevel();
            b(r16, r17);
            if ((this.f1813g.getParent() instanceof MotionLayout) == true) goto L5;
        L8:
            b(r16, r17);
            this.f1813g.f1731c0 = this.f1807a.V();
            this.f1813g.f1733d0 = this.f1807a.w();
            this.f1813g.f1735e0 = this.f1808b.V();
            this.f1813g.f1737f0 = this.f1808b.w();
            MotionLayout r13 = this.f1813g;
            if (r13.f1731c0 == r13.f1735e0) goto L11;
        L14:
            boolean r14 = true;
        L15:
            r13.f1729b0 = r14;
        L16:
            MotionLayout r15 = this.f1813g;
            int r18 = r15.f1731c0;
            int r19 = r15.f1733d0;
            int r20 = r15.f1739g0;
            if (r20 == Integer.MIN_VALUE) goto L21;
            if (r20 == 0) goto L21;
        L20:
            int r110 = r18;
            int r21 = r15.f1741h0;
            if (r21 == Integer.MIN_VALUE) goto L27;
            if (r21 == 0) goto L27;
        L26:
            int r111 = r19;
            if (this.f1807a.S1() == false) goto L31;
        L34:
            boolean r112 = true;
        L36:
            if (this.f1807a.Q1() == false) goto L38;
        L41:
            boolean r113 = true;
        L42:
            MotionLayout.n(this.f1813g, r16, r17, r110, r111, r112, r113);
            return;
        L38:
            if (this.f1808b.Q1() == true) goto L41;
            r113 = false;
            goto L42
        L31:
            if (this.f1808b.S1() == true) goto L34;
            r112 = false;
        L27:
            r19 = (int) (r19 + (r15.f1743i0 * (r15.f1737f0 - r19)));
        L21:
            r18 = (int) (r18 + (r15.f1743i0 * (r15.f1735e0 - r18)));
            goto L20
        L11:
            if (r13.f1733d0 != r13.f1737f0) goto L14;
            r14 = false;
            goto L15
        L5:
            if (r10 != 1073741824) goto L8;
            if (r11 != 1073741824) goto L8;
            goto L8
        }

        public void h() {
            g(MotionLayout.k(this.f1813g), MotionLayout.l(this.f1813g));
            MotionLayout.m(this.f1813g);
        }

        public void i(int r10, int r11) {
            this.f1811e = r10;
            this.f1812f = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void j(ConstraintWidgetContainer r13, ConstraintSet r14) {
            SparseArray r10 = new SparseArray();
            Constraints.LayoutParams r11 = new Constraints.LayoutParams(-2, -2);
            r10.clear();
            r10.put(0, r13);
            r10.put(this.f1813g.getId(), r13);
            if (r14 != null) goto L5;
        L7:
            Iterator r12 = r13.s1().iterator();
        L9:
            if (r12.hasNext() == false) goto L11;
            ConstraintWidget r15 = (ConstraintWidget) r12.next();
            r15.A0(true);
            r10.put(((View) r15.r()).getId(), r15);
            goto L9
        L11:
            Iterator r16 = r13.s1().iterator();
        L13:
            if (r16.hasNext() == false) goto L23;
            ConstraintWidget r17 = (ConstraintWidget) r16.next();
            View r18 = (View) r17.r();
            r14.l(r18.getId(), r11);
            r17.l1(r14.H(r18.getId()));
            r17.M0(r14.C(r18.getId()));
            if ((r18 instanceof ConstraintHelper) == false) goto L19;
            r14.j((ConstraintHelper) r18, r17, r11, r10);
            if ((r18 instanceof Barrier) == false) goto L19;
            ((Barrier) r18).s();
        L19:
            r11.resolveLayoutDirection(this.f1813g.getLayoutDirection());
            MotionLayout.j(this.f1813g, false, r18, r17, r11, r10);
            if (r14.G(r18.getId()) == 1) goto L21;
            r17.k1(r14.F(r18.getId()));
            goto L13
        L21:
            r17.k1(r18.getVisibility());
            goto L13
        L23:
            Iterator r19 = r13.s1().iterator();
        L25:
            if (r19.hasNext() == false) goto L29;
            ConstraintWidget r110 = (ConstraintWidget) r19.next();
            if ((r110 instanceof androidx.constraintlayout.core.widgets.h) == false) goto L25;
            ConstraintHelper r20 = (ConstraintHelper) r110.r();
            Helper r111 = (Helper) r110;
            r20.q(r13, r111, r10);
            ((androidx.constraintlayout.core.widgets.h) r111).v1();
            goto L25
        L29:
            return;
        L5:
            if (r14.f2269d == 0) goto L7;
            MotionLayout r21 = this.f1813g;
            MotionLayout.i(r21, this.f1808b, r21.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(this.f1813g.getHeight(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(this.f1813g.getWidth(), Ints.MAX_POWER_OF_TWO));
            goto L7
        }
    }

    public static class h implements MotionTracker {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static h f1814b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VelocityTracker f1815a;

        static {
            f1814b = new h();
        }

        public h() {
        }

        public static h a() {
            h r10 = f1814b;
            r10.f1815a = VelocityTracker.obtain();
            return f1814b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent r10) {
            VelocityTracker r11 = this.f1815a;
            if (r11 == null) goto L6;
            r11.addMovement(r10);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker r10 = this.f1815a;
            if (r10 == null) goto L6;
            r10.clear();
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r10) {
            VelocityTracker r11 = this.f1815a;
            if (r11 == null) goto L6;
            r11.computeCurrentVelocity(r10);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker r10 = this.f1815a;
            if (r10 != null) goto L5;
            return 0.0f;
        L5:
            return r10.getXVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker r10 = this.f1815a;
            if (r10 != null) goto L5;
            return 0.0f;
        L5:
            return r10.getYVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker r10 = this.f1815a;
            if (r10 == null) goto L6;
            r10.recycle();
            this.f1815a = null;
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r10, float r11) {
            VelocityTracker r12 = this.f1815a;
            if (r12 == null) goto L6;
            r12.computeCurrentVelocity(r10, r11);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int r10) {
            VelocityTracker r11 = this.f1815a;
            if (r11 != null) goto L5;
            return 0.0f;
        L5:
            return r11.getXVelocity(r10);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int r10) {
            if (this.f1815a != null) goto L5;
            return 0.0f;
        L5:
            return getYVelocity(r10);
        }
    }

    public class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f1816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1819d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f1820e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f1821f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f1822g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f1823h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f1824i;

        public i(MotionLayout r10) {
            this.f1824i = r10;
            this.f1816a = Float.NaN;
            this.f1817b = Float.NaN;
            this.f1818c = -1;
            this.f1819d = -1;
            this.f1820e = "motion.progress";
            this.f1821f = "motion.velocity";
            this.f1822g = "motion.StartState";
            this.f1823h = "motion.EndState";
        }

        public void a() {
            int r10 = this.f1818c;
            if (r10 == (-1)) goto L5;
        L6:
            if (r10 != (-1)) goto L8;
            this.f1824i.l0(this.f1819d);
        L12:
            this.f1824i.setState(TransitionState.SETUP);
        L14:
            if (Float.isNaN(this.f1817b) == true) goto L16;
            this.f1824i.d0(this.f1816a, this.f1817b);
            this.f1816a = Float.NaN;
            this.f1817b = Float.NaN;
            this.f1818c = -1;
            this.f1819d = -1;
            return;
        L16:
            if (Float.isNaN(this.f1816a) == false) goto L18;
            return;
        L18:
            this.f1824i.setProgress(this.f1816a);
            return;
        L8:
            int r11 = this.f1819d;
            if (r11 != (-1)) goto L11;
            this.f1824i.setState(r10, -1, -1);
            goto L12
        L11:
            this.f1824i.e0(r10, r11);
            goto L12
        L5:
            if (this.f1819d == (-1)) goto L14;
            goto L6
        }

        public Bundle b() {
            Bundle r10 = new Bundle();
            r10.putFloat("motion.progress", this.f1816a);
            r10.putFloat("motion.velocity", this.f1817b);
            r10.putInt("motion.StartState", this.f1818c);
            r10.putInt("motion.EndState", this.f1819d);
            return r10;
        }

        public void c() {
            this.f1819d = MotionLayout.h(this.f1824i);
            this.f1818c = MotionLayout.s(this.f1824i);
            this.f1817b = this.f1824i.getVelocity();
            this.f1816a = this.f1824i.getProgress();
        }

        public void d(int r10) {
            this.f1819d = r10;
        }

        public void e(float r10) {
            this.f1816a = r10;
        }

        public void f(int r10) {
            this.f1818c = r10;
        }

        public void g(Bundle r10) {
            this.f1816a = r10.getFloat("motion.progress");
            this.f1817b = r10.getFloat("motion.velocity");
            this.f1818c = r10.getInt("motion.StartState");
            this.f1819d = r10.getInt("motion.EndState");
        }

        public void h(float r10) {
            this.f1817b = r10;
        }
    }

    public MotionLayout(@NonNull Context r10) {
        super(r10);
        this.f1730c = null;
        this.f1732d = 0.0f;
        this.f1734e = -1;
        this.f1736f = -1;
        this.f1738g = -1;
        this.f1740h = 0;
        this.f1742i = 0;
        this.f1744j = true;
        this.f1746k = new HashMap();
        this.f1748l = 0;
        this.f1750m = 1.0f;
        this.f1752n = 0.0f;
        this.f1754o = 0.0f;
        this.f1758q = 0.0f;
        this.f1762s = false;
        this.f1764t = false;
        this.f1772x = 0;
        this.f1776z = false;
        this.A = new m.b();
        this.B = new e(this);
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1;
        this.U = 0.0f;
        this.V = 0;
        this.W = 0.0f;
        this.f1727a0 = false;
        this.f1729b0 = false;
        this.f1745j0 = new p001j.d();
        this.f1747k0 = false;
        this.f1751m0 = null;
        this.f1753n0 = null;
        this.f1755o0 = 0;
        this.f1757p0 = false;
        this.f1759q0 = 0;
        this.f1761r0 = new HashMap();
        this.f1769v0 = new Rect();
        this.f1771w0 = false;
        this.f1773x0 = TransitionState.UNDEFINED;
        this.f1775y0 = new g(this);
        this.f1777z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        W(null);
    }

    public static /* synthetic */ ConstraintWidgetContainer A(MotionLayout r10) {
        return r10.mLayoutWidget;
    }

    public static /* synthetic */ boolean B(MotionLayout r10) {
        return r10.isRtl();
    }

    public static /* synthetic */ boolean C(MotionLayout r10) {
        return r10.isRtl();
    }

    private boolean F(View r10, MotionEvent r11, float r12, float r13) {
        Matrix r14 = r10.getMatrix();
        if (r14.isIdentity() == false) goto L6;
        r11.offsetLocation(r12, r13);
        boolean r15 = r10.onTouchEvent(r11);
        r11.offsetLocation(-r12, -r13);
        return r15;
    L6:
        MotionEvent r16 = MotionEvent.obtain(r11);
        r16.offsetLocation(r12, r13);
        if (this.C0 != null) goto L9;
        this.C0 = new Matrix();
    L9:
        r14.invert(this.C0);
        r16.transform(this.C0);
        boolean r17 = r10.onTouchEvent(r16);
        r16.recycle();
        return r17;
    }

    private void G() {
        o r10 = this.f1726a;
        if (r10 != null) goto L6;
        Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
        return;
    L6:
        int r11 = r10.F();
        o r12 = this.f1726a;
        H(r11, r12.l(r12.F()));
        SparseIntArray r13 = new SparseIntArray();
        SparseIntArray r14 = new SparseIntArray();
        Iterator r15 = this.f1726a.o().iterator();
    L8:
        if (r15.hasNext() == false) goto L24;
        o.b r16 = (o.b) r15.next();
        if (r16 != this.f1726a.f1949c) goto L12;
        Log.v("MotionLayout", "CHECK: CURRENT");
    L12:
        I(r16);
        int r17 = r16.A();
        int r18 = r16.y();
        String r19 = androidx.constraintlayout.motion.widget.a.c(getContext(), r17);
        String r20 = androidx.constraintlayout.motion.widget.a.c(getContext(), r18);
        if (r13.get(r17) != r18) goto L16;
        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + r19 + "->" + r20);
    L16:
        if (r14.get(r18) != r17) goto L18;
        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + r19 + "->" + r20);
    L18:
        r13.put(r17, r18);
        r14.put(r18, r17);
        if (this.f1726a.l(r17) != null) goto L22;
        Log.e("MotionLayout", " no such constraintSetStart " + r19);
    L22:
        if (this.f1726a.l(r18) != null) goto L8;
        Log.e("MotionLayout", " no such constraintSetEnd " + r19);
        goto L8
    }

    private void K() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        View r12 = getChildAt(r11);
        l r13 = (l) this.f1746k.get(r12);
        if (r13 == null) goto L8;
        r13.I(r12);
    L8:
        r11 = r11 + 1;
        goto L3
    }

    private void N() {
        float r10 = Math.signum(this.f1758q - this.f1754o);
        long r11 = getNanoTime();
        Interpolator r12 = this.f1728b;
        if ((r12 instanceof m.b) == true) goto L5;
        float r13 = (((r11 - this.f1756p) * r10) * 1.0E-9f) / this.f1750m;
    L6:
        float r14 = this.f1754o + r13;
        if (this.f1760r == false) goto L9;
        r14 = this.f1758q;
    L9:
        int r15 = 0;
        if (r10 <= 0.0f) goto L14;
        if (r14 < this.f1758q) goto L14;
    L17:
        r14 = this.f1758q;
        boolean r16 = true;
    L19:
        if (r12 == null) goto L25;
        if (r16 == true) goto L25;
        if (this.f1776z == false) goto L24;
        r14 = r12.getInterpolation((r11 - this.f1748l) * 1.0E-9f);
        goto L25
    L24:
        r14 = r12.getInterpolation(r14);
    L25:
        if (r10 <= 0.0f) goto L29;
        if (r14 < this.f1758q) goto L29;
    L32:
        r14 = this.f1758q;
    L33:
        this.f1743i0 = r14;
        int r17 = getChildCount();
        long r18 = getNanoTime();
        Interpolator r19 = this.f1730c;
        if (r19 == null) goto L37;
        r14 = r19.getInterpolation(r14);
    L37:
        if (r15 >= r17) goto L43;
        View r20 = getChildAt(r15);
        l r21 = (l) this.f1746k.get(r20);
        if (r21 == null) goto L41;
        r21.A(r20, r14, r18, this.f1745j0);
    L41:
        r15 = r15 + 1;
        goto L37
    L43:
        if (this.f1729b0 == false) goto L50;
        requestLayout();
        return;
    L50:
        return;
    L29:
        if (r10 > 0.0f) goto L33;
        if (r14 > this.f1758q) goto L33;
    L14:
        if (r10 <= 0.0f) goto L16;
    L18:
        r16 = false;
        goto L19
    L16:
        if (r14 > this.f1758q) goto L18;
    L5:
        r13 = 0.0f;
        goto L6
    }

    private void O() {
        if (this.f1766u != null) goto L9;
        CopyOnWriteArrayList r10 = this.R;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.W != this.f1752n) goto L11;
        return;
    L11:
        if (this.V == (-1)) goto L22;
        TransitionListener r11 = this.f1766u;
        if (r11 == null) goto L15;
        r11.onTransitionStarted(this, this.f1734e, this.f1738g);
    L15:
        CopyOnWriteArrayList r12 = this.R;
        if (r12 == null) goto L21;
        Iterator r13 = r12.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        ((TransitionListener) r13.next()).onTransitionStarted(this, this.f1734e, this.f1738g);
    L21:
        this.f1727a0 = true;
    L22:
        this.V = -1;
        float r14 = this.f1752n;
        this.W = r14;
        TransitionListener r15 = this.f1766u;
        if (r15 == null) goto L25;
        r15.onTransitionChange(this, this.f1734e, this.f1738g, r14);
    L25:
        CopyOnWriteArrayList r16 = this.R;
        if (r16 == null) goto L31;
        Iterator r17 = r16.iterator();
    L29:
        if (r17.hasNext() == false) goto L31;
        ((TransitionListener) r17.next()).onTransitionChange(this, this.f1734e, this.f1738g, this.f1752n);
    L31:
        this.f1727a0 = true;
    }

    private boolean V(float r10, float r11, View r12, MotionEvent r13) {
        if ((r12 instanceof ViewGroup) == false) goto L10;
        ViewGroup r14 = (ViewGroup) r12;
        int r15 = r14.getChildCount() - 1;
    L5:
        if (r15 < 0) goto L10;
        View r16 = r14.getChildAt(r15);
        if (V((r16.getLeft() + r10) - r12.getScrollX(), (r16.getTop() + r11) - r12.getScrollY(), r16, r13) == true) goto L8;
        r15 = r15 - 1;
        goto L5
    L8:
        boolean r17 = true;
    L11:
        if (r17 == true) goto L20;
        this.A0.set(r10, r11, (r12.getRight() + r10) - r12.getLeft(), (r12.getBottom() + r11) - r12.getTop());
        if (r13.getAction() != 0) goto L17;
        if (this.A0.contains(r13.getX(), r13.getY()) == false) goto L20;
    L17:
        if (F(r12, r13, -r10, -r11) == false) goto L20;
        return true;
    L20:
        return r17;
    L10:
        r17 = false;
        goto L11
    }

    private void W(AttributeSet r10) {
        E0 = isInEditMode();
        if (r10 == null) goto L37;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.MotionLayout);
        int r12 = r11.getIndexCount();
        boolean r13 = true;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L31;
        int r15 = r11.getIndex(r14);
        if (r15 != R$styleable.MotionLayout_layoutDescription) goto L10;
        this.f1726a = new o(getContext(), this, r11.getResourceId(r15, -1));
    L30:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R$styleable.MotionLayout_currentState) goto L13;
        this.f1736f = r11.getResourceId(r15, -1);
        goto L30
    L13:
        if (r15 != R$styleable.MotionLayout_motionProgress) goto L16;
        this.f1758q = r11.getFloat(r15, 0.0f);
        this.f1762s = true;
        goto L30
    L16:
        if (r15 != R$styleable.MotionLayout_applyMotionScene) goto L19;
        r13 = r11.getBoolean(r15, r13);
        goto L30
    L19:
        if (r15 != R$styleable.MotionLayout_showPaths) goto L28;
        if (this.f1772x != 0) goto L30;
        if (r11.getBoolean(r15, false) == false) goto L25;
        int r16 = 2;
    L26:
        this.f1772x = r16;
        goto L30
    L25:
        r16 = 0;
        goto L26
    L28:
        if (r15 != R$styleable.MotionLayout_motionDebug) goto L30;
        this.f1772x = r11.getInt(r15, 0);
        goto L30
    L31:
        r11.recycle();
        if (this.f1726a != null) goto L34;
        Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
    L34:
        if (r13 == true) goto L37;
        this.f1726a = null;
    L37:
        if (this.f1772x == 0) goto L40;
        G();
    L40:
        if (this.f1736f != (-1)) goto L54;
        o r17 = this.f1726a;
        if (r17 == null) goto L55;
        this.f1736f = r17.F();
        this.f1734e = this.f1726a.F();
        this.f1738g = this.f1726a.q();
        return;
    L55:
        return;
    }

    private void b0() {
        if (this.f1766u != null) goto L9;
        CopyOnWriteArrayList r10 = this.R;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == false) goto L9;
        return;
    L9:
        this.f1727a0 = false;
        Iterator r11 = this.D0.iterator();
    L11:
        if (r11.hasNext() == false) goto L21;
        Integer r12 = (Integer) r11.next();
        TransitionListener r13 = this.f1766u;
        if (r13 == null) goto L15;
        r13.onTransitionCompleted(this, r12.intValue());
    L15:
        CopyOnWriteArrayList r14 = this.R;
        if (r14 == null) goto L11;
        Iterator r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L11;
        ((TransitionListener) r15.next()).onTransitionCompleted(this, r12.intValue());
        goto L19
    L21:
        this.D0.clear();
    }

    private void f0() {
        int r10 = getChildCount();
        this.f1775y0.a();
        boolean r11 = true;
        this.f1762s = true;
        SparseArray r12 = new SparseArray();
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L5;
        View r15 = getChildAt(r14);
        r12.put(r15.getId(), (l) this.f1746k.get(r15));
        r14 = r14 + 1;
        goto L3
    L5:
        int r16 = getWidth();
        int r17 = getHeight();
        int r18 = this.f1726a.j();
        if (r18 == (-1)) goto L13;
        int r19 = 0;
    L8:
        if (r19 >= r10) goto L13;
        l r20 = (l) this.f1746k.get(getChildAt(r19));
        if (r20 == null) goto L12;
        r20.H(r18);
    L12:
        r19 = r19 + 1;
    L13:
        SparseBooleanArray r110 = new SparseBooleanArray();
        int[] r111 = new int[this.f1746k.size()];
        int r21 = 0;
        int r112 = 0;
    L14:
        if (r21 >= r10) goto L20;
        l r22 = (l) this.f1746k.get(getChildAt(r21));
        if (r22.h() == (-1)) goto L18;
        r110.put(r22.h(), true);
        r111[r112] = r22.h();
        r112 = r112 + 1;
    L18:
        r21 = r21 + 1;
        goto L14
    L20:
        if (this.Q == null) goto L39;
        int r23 = 0;
    L22:
        if (r23 >= r112) goto L28;
        l r24 = (l) this.f1746k.get(findViewById(r111[r23]));
        if (r24 == null) goto L27;
        this.f1726a.t(r24);
    L27:
        r23 = r23 + 1;
        goto L22
    L28:
        Iterator r25 = this.Q.iterator();
    L30:
        if (r25.hasNext() == false) goto L32;
        ((MotionHelper) r25.next()).onPreSetup(this, this.f1746k);
        goto L30
    L32:
        int r113 = 0;
    L33:
        if (r113 >= r112) goto L46;
        l r26 = (l) this.f1746k.get(findViewById(r111[r113]));
        if (r26 == null) goto L38;
        r26.M(r16, r17, this.f1750m, getNanoTime());
    L38:
        r113 = r113 + 1;
    L46:
        int r114 = 0;
    L47:
        if (r114 >= r10) goto L54;
        View r27 = getChildAt(r114);
        l r28 = (l) this.f1746k.get(r27);
        if (r110.get(r27.getId()) == true) goto L53;
        if (r28 == null) goto L53;
        this.f1726a.t(r28);
        r28.M(r16, r17, this.f1750m, getNanoTime());
    L53:
        r114 = r114 + 1;
        goto L47
    L54:
        float r29 = this.f1726a.E();
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
        l r115 = (l) this.f1746k.get(getChildAt(r33));
        if (Float.isNaN(r115.f1912m) == false) goto L65;
        float r36 = r115.o();
        float r116 = r115.p();
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
        l r38 = (l) this.f1746k.get(getChildAt(r37));
        if (Float.isNaN(r38.f1912m) == true) goto L70;
        r32 = Math.min(r32, r38.f1912m);
        r31 = Math.max(r31, r38.f1912m);
    L70:
        r37 = r37 + 1;
    L71:
        if (r13 >= r10) goto L126;
        l r39 = (l) this.f1746k.get(getChildAt(r13));
        if (Float.isNaN(r39.f1912m) == true) goto L78;
        r39.f1914o = 1.0f / (1.0f - r30);
        if (r11 == false) goto L77;
        r39.f1913n = r30 - (((r31 - r39.f1912m) / (r31 - r32)) * r30);
        goto L78
    L77:
        r39.f1913n = r30 - (((r39.f1912m - r32) * r30) / (r31 - r32));
    L78:
        r13 = r13 + 1;
        goto L71
    L126:
        return;
    L84:
        if (r13 >= r10) goto L127;
        l r40 = (l) this.f1746k.get(getChildAt(r13));
        float r41 = r40.o();
        float r42 = r40.p();
        if (r11 == false) goto L88;
        float r43 = r42 - r41;
    L89:
        r40.f1914o = 1.0f / (1.0f - r30);
        r40.f1913n = r30 - (((r43 - r35) * r30) / (r34 - r35));
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
        l r44 = (l) this.f1746k.get(findViewById(r111[r118]));
        if (r44 == null) goto L45;
        this.f1726a.t(r44);
        r44.M(r16, r17, this.f1750m, getNanoTime());
    L45:
        r118 = r118 + 1;
        goto L40
    }

    public static /* synthetic */ i g(MotionLayout r10) {
        return r10.f1749l0;
    }

    public static /* synthetic */ int h(MotionLayout r10) {
        return r10.f1738g;
    }

    public static /* synthetic */ void i(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    public static /* synthetic */ void j(MotionLayout r10, boolean r11, View r12, ConstraintWidget r13, ConstraintLayout.LayoutParams r14, SparseArray r15) {
        r10.applyConstraintsFromLayoutParams(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ int k(MotionLayout r10) {
        return r10.f1740h;
    }

    public static /* synthetic */ int l(MotionLayout r10) {
        return r10.f1742i;
    }

    public static /* synthetic */ void m(MotionLayout r10) {
        r10.f0();
    }

    public static /* synthetic */ void n(MotionLayout r10, int r11, int r12, int r13, int r14, boolean r15, boolean r16) {
        r10.resolveMeasuredDimension(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void o(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    public static /* synthetic */ void p(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    public static /* synthetic */ void q(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    public static /* synthetic */ void r(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    public static /* synthetic */ int s(MotionLayout r10) {
        return r10.f1734e;
    }

    private static boolean s0(float r10, float r11, float r12) {
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

    public static /* synthetic */ Rect t(MotionLayout r10, ConstraintWidget r11) {
        return r10.g0(r11);
    }

    public static /* synthetic */ int u(MotionLayout r10) {
        return r10.f1763s0;
    }

    public static /* synthetic */ int v(MotionLayout r10) {
        return r10.f1765t0;
    }

    public static /* synthetic */ boolean w(MotionLayout r10) {
        return r10.f1757p0;
    }

    public static /* synthetic */ ConstraintWidgetContainer x(MotionLayout r10) {
        return r10.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer y(MotionLayout r10) {
        return r10.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer z(MotionLayout r10) {
        return r10.mLayoutWidget;
    }

    public void D(float r10) {
        o r11 = this.f1726a;
        if (r11 != null) goto L5;
        return;
    L5:
        float r12 = this.f1754o;
        float r13 = this.f1752n;
        if (r12 != r13) goto L8;
    L10:
        float r14 = this.f1754o;
        if (r14 != r10) goto L13;
        return;
    L13:
        this.f1776z = false;
        this.f1758q = r10;
        this.f1750m = r11.p() / 1000.0f;
        setProgress(this.f1758q);
        this.f1728b = null;
        this.f1730c = this.f1726a.s();
        this.f1760r = false;
        this.f1748l = getNanoTime();
        this.f1762s = true;
        this.f1752n = r14;
        this.f1754o = r14;
        invalidate();
        return;
    L8:
        if (this.f1760r == false) goto L10;
        this.f1754o = r13;
        goto L10
    }

    public boolean E(int r10, l r11) {
        o r12 = this.f1726a;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.g(r10, r11);
    }

    public final void H(int r11, ConstraintSet r12) {
        String r13 = androidx.constraintlayout.motion.widget.a.c(getContext(), r11);
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
        if (r12.B(r17) != null) goto L11;
        Log.w("MotionLayout", "CHECK: " + r13 + " NO CONSTRAINTS for " + androidx.constraintlayout.motion.widget.a.d(r16));
    L11:
        r15 = r15 + 1;
        goto L4
    L12:
        int[] r18 = r12.D();
    L14:
        if (r14 >= r18.length) goto L25;
        int r19 = r18[r14];
        String r20 = androidx.constraintlayout.motion.widget.a.c(getContext(), r19);
        if (findViewById(r18[r14]) != null) goto L19;
        Log.w("MotionLayout", "CHECK: " + r13 + " NO View matches id " + r20);
    L19:
        if (r12.C(r19) != (-1)) goto L22;
        Log.w("MotionLayout", "CHECK: " + r13 + "(" + r20 + ") no LAYOUT_HEIGHT");
    L22:
        if (r12.H(r19) != (-1)) goto L24;
        Log.w("MotionLayout", "CHECK: " + r13 + "(" + r20 + ") no LAYOUT_HEIGHT");
    L24:
        r14 = r14 + 1;
        goto L14
    }

    public final void I(o.b r10) {
        if (r10.A() != r10.y()) goto L6;
        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        return;
    }

    public ConstraintSet J(int r10) {
        o r11 = this.f1726a;
        if (r11 != null) goto L6;
        return null;
    L6:
        ConstraintSet r12 = r11.l(r10);
        ConstraintSet r13 = new ConstraintSet();
        r13.r(r12);
        return r13;
    }

    public void L(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = getChildAt(r12);
        l r14 = (l) this.f1746k.get(r13);
        if (r14 == null) goto L7;
        r14.f(r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    public void M(boolean r23) {
        if (this.f1756p != (-1)) goto L5;
        this.f1756p = getNanoTime();
    L5:
        float r10 = this.f1754o;
        if (r10 > 0.0f) goto L8;
    L10:
        boolean r11 = true;
        boolean r12 = false;
        if (this.N == false) goto L13;
    L17:
        float r13 = Math.signum(this.f1758q - r10);
        long r14 = getNanoTime();
        Interpolator r15 = this.f1728b;
        if ((r15 instanceof m) == true) goto L20;
        float r16 = (((r14 - this.f1756p) * r13) * 1.0E-9f) / this.f1750m;
    L21:
        float r17 = this.f1754o + r16;
        if (this.f1760r == false) goto L25;
        r17 = this.f1758q;
    L25:
        if (r13 <= 0.0f) goto L29;
        if (r17 < this.f1758q) goto L29;
    L32:
        r17 = this.f1758q;
        this.f1762s = false;
        boolean r18 = true;
    L34:
        this.f1754o = r17;
        this.f1752n = r17;
        this.f1756p = r14;
        if (r15 == null) goto L69;
        if (r18 == true) goto L69;
        if (this.f1776z == false) goto L63;
        float r19 = r15.getInterpolation((r14 - this.f1748l) * 1.0E-9f);
        Interpolator r20 = this.f1728b;
        m.b r21 = this.A;
        if (r20 == r21) goto L42;
        char r22 = 0;
    L46:
        this.f1754o = r19;
        this.f1756p = r14;
        Interpolator r24 = this.f1728b;
        if ((r24 instanceof m) == false) goto L62;
        float r25 = ((m) r24).a();
        this.f1732d = r25;
        if ((Math.abs(r25) * this.f1750m) > 1.0E-5f) goto L53;
        if (r22 != 2) goto L53;
        this.f1762s = false;
    L53:
        if (r25 <= 0.0f) goto L58;
        if (r19 < 1.0f) goto L58;
        this.f1754o = 1.0f;
        this.f1762s = false;
        r19 = 1.0f;
    L58:
        if (r25 >= 0.0f) goto L62;
        if (r19 > 0.0f) goto L62;
        this.f1754o = 0.0f;
        this.f1762s = false;
        r17 = 0.0f;
    L71:
        if (Math.abs(this.f1732d) <= 1.0E-5f) goto L73;
        setState(TransitionState.MOVING);
    L73:
        if (r22 == 1) goto L87;
        if (r13 <= 0.0f) goto L78;
        if (r17 < this.f1758q) goto L78;
    L81:
        r17 = this.f1758q;
        this.f1762s = false;
    L83:
        if (r17 < 1.0f) goto L85;
    L86:
        this.f1762s = false;
        setState(TransitionState.FINISHED);
        goto L87
    L85:
        if (r17 > 0.0f) goto L87;
    L78:
        if (r13 > 0.0f) goto L83;
        if (r17 > this.f1758q) goto L83;
    L87:
        int r26 = getChildCount();
        this.N = false;
        long r27 = getNanoTime();
        this.f1743i0 = r17;
        Interpolator r28 = this.f1730c;
        if (r28 != null) goto L90;
        float r29 = r17;
    L91:
        Interpolator r30 = this.f1730c;
        if (r30 == null) goto L94;
        float r31 = r30.getInterpolation((r13 / this.f1750m) + r17);
        this.f1732d = r31;
        this.f1732d = r31 - this.f1730c.getInterpolation(r17);
    L94:
        int r32 = 0;
    L95:
        if (r32 >= r26) goto L100;
        View r110 = getChildAt(r32);
        l r111 = (l) this.f1746k.get(r110);
        if (r111 == null) goto L99;
        this.N = r111.A(r110, r29, r27, this.f1745j0) | this.N;
    L99:
        r32 = r32 + 1;
        goto L95
    L100:
        if (r13 <= 0.0f) goto L104;
        if (r17 < this.f1758q) goto L104;
    L107:
        boolean r33 = true;
    L110:
        if (this.N == true) goto L116;
        if (this.f1762s == true) goto L116;
        if (r33 == false) goto L116;
        setState(TransitionState.FINISHED);
    L116:
        if (this.f1729b0 == false) goto L118;
        requestLayout();
    L118:
        this.N = (!r33) | this.N;
        if (r17 > 0.0f) goto L126;
        int r34 = this.f1734e;
        if (r34 == (-1)) goto L126;
        if (this.f1736f == r34) goto L126;
        this.f1736f = r34;
        this.f1726a.l(r34).g(this);
        setState(TransitionState.FINISHED);
        r12 = true;
    L126:
        if (r17 < 1.0d) goto L131;
        int r35 = this.f1736f;
        int r36 = this.f1738g;
        if (r35 == r36) goto L131;
        this.f1736f = r36;
        this.f1726a.l(r36).g(this);
        setState(TransitionState.FINISHED);
        r12 = true;
    L131:
        if (this.N == false) goto L133;
    L143:
        invalidate();
    L145:
        if (this.N == false) goto L147;
    L156:
        float r37 = this.f1754o;
        if (r37 < 1.0f) goto L165;
        int r38 = this.f1736f;
        int r39 = this.f1738g;
        if (r38 != r39) goto L162;
        r11 = r12;
    L162:
        this.f1736f = r39;
    L163:
        r12 = r11;
    L171:
        this.f1777z0 |= r12;
        if (r12 == true) goto L174;
    L176:
        this.f1752n = this.f1754o;
        return;
    L174:
        if (this.f1747k0 == true) goto L176;
        requestLayout();
        goto L176
    L165:
        if (r37 > 0.0f) goto L171;
        int r40 = this.f1736f;
        int r41 = this.f1734e;
        if (r40 != r41) goto L170;
        r11 = r12;
    L170:
        this.f1736f = r41;
        goto L163
    L147:
        if (this.f1762s == true) goto L156;
        if (r13 <= 0.0f) goto L152;
        if (r17 != 1.0f) goto L152;
    L155:
        a0();
    L152:
        if (r13 >= 0.0f) goto L156;
        if (r17 != 0.0f) goto L156;
    L133:
        if (this.f1762s == true) goto L143;
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
        if (r17 > this.f1758q) goto L108;
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
        Interpolator r43 = this.f1728b;
        if ((r43 instanceof m) == false) goto L66;
        this.f1732d = ((m) r43).a();
    L67:
        r17 = r42;
    L68:
        r22 = 0;
        goto L71
    L66:
        this.f1732d = ((r43.getInterpolation(r17 + r16) - r42) * r13) / r16;
    L69:
        this.f1732d = r16;
    L29:
        if (r13 <= 0.0f) goto L31;
    L33:
        r18 = false;
        goto L34
    L31:
        if (r17 > this.f1758q) goto L33;
    L20:
        r16 = 0.0f;
        goto L21
    L13:
        if (this.f1762s == false) goto L156;
        if (r23 == true) goto L17;
        if (this.f1758q == r10) goto L156;
    L8:
        if (r10 >= 1.0f) goto L10;
        this.f1736f = -1;
        goto L10
    }

    public void P() {
        if (this.f1766u != null) goto L9;
        CopyOnWriteArrayList r10 = this.R;
        if (r10 != null) goto L7;
    L18:
        b0();
        Runnable r11 = this.f1751m0;
        if (r11 == null) goto L21;
        r11.run();
    L21:
        int[] r12 = this.f1753n0;
        if (r12 != null) goto L24;
        return;
    L24:
        if (this.f1755o0 <= 0) goto L28;
        l0(r12[0]);
        int[] r13 = this.f1753n0;
        System.arraycopy(r13, 1, r13, 0, r13.length - 1);
        this.f1755o0--;
        return;
    L28:
        return;
    L7:
        if (r10.isEmpty() == true) goto L18;
    L9:
        if (this.V != (-1)) goto L18;
        this.V = this.f1736f;
        if (this.D0.isEmpty() == true) goto L13;
        ArrayList r14 = this.D0;
        int r15 = ((Integer) r14.get(r14.size() - 1)).intValue();
    L14:
        int r16 = this.f1736f;
        if (r15 == r16) goto L18;
        if (r16 == (-1)) goto L18;
        this.D0.add(Integer.valueOf(r16));
        goto L18
    L13:
        r15 = -1;
        goto L14
    }

    public void Q(int r10, float r11, float r12, float r13, float[] r14) {
        HashMap r15 = this.f1746k;
        View r16 = getViewById(r10);
        l r17 = (l) r15.get(r16);
        if (r17 == null) goto L5;
        r17.m(r11, r12, r13, r14);
        float r18 = r16.getY();
        this.f1768v = r11;
        this.f1770w = r18;
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

    public ConstraintSet R(int r10) {
        o r11 = this.f1726a;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.l(r10);
    }

    public l S(int r10) {
        return (l) this.f1746k.get(findViewById(r10));
    }

    public o.b T(int r10) {
        return this.f1726a.G(r10);
    }

    public void U(View r10, float r11, float r12, float[] r13, int r14) {
        float r15 = this.f1732d;
        float r16 = this.f1754o;
        if (this.f1728b == null) goto L5;
        float r17 = Math.signum(this.f1758q - r16);
        float r18 = this.f1728b.getInterpolation(this.f1754o + 1.0E-5f);
        float r19 = this.f1728b.getInterpolation(this.f1754o);
        r15 = (r17 * ((r18 - r19) / 1.0E-5f)) / this.f1750m;
    L6:
        Interpolator r20 = this.f1728b;
        if ((r20 instanceof m) == false) goto L9;
        r15 = ((m) r20).a();
    L9:
        l r21 = (l) this.f1746k.get(r10);
        if ((r14 & 1) != 0) goto L12;
        r21.u(r19, r10.getWidth(), r10.getHeight(), r11, r12, r13);
    L14:
        if (r14 >= 2) goto L17;
        r13[0] = r13[0] * r15;
        r13[1] = r13[1] * r15;
        return;
    L17:
        return;
    L12:
        r21.m(r19, r11, r12, r13);
        goto L14
    L5:
        r19 = r16;
        goto L6
    }

    public boolean X() {
        return this.f1744j;
    }

    public int Y(String r10) {
        o r11 = this.f1726a;
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.M(r10);
    }

    public MotionTracker Z() {
        return h.a();
    }

    public void a0() {
        o r10 = this.f1726a;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.h(this, this.f1736f) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r11 = this.f1736f;
        if (r11 == (-1)) goto L13;
        this.f1726a.f(this, r11);
    L13:
        if (this.f1726a.e0() == false) goto L16;
        this.f1726a.c0();
        return;
    }

    public void c0() {
        this.f1775y0.h();
        invalidate();
    }

    public void d0(float r10, float r11) {
        if (isAttachedToWindow() == false) goto L5;
        setProgress(r10);
        setState(TransitionState.MOVING);
        this.f1732d = r11;
        float r12 = 0.0f;
        if (r11 == 0.0f) goto L15;
        if (r11 <= 0.0f) goto L13;
        r12 = 1.0f;
    L13:
        D(r12);
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
        D(r12);
        return;
    L5:
        if (this.f1749l0 != null) goto L7;
        this.f1749l0 = new i(this);
    L7:
        this.f1749l0.e(r10);
        this.f1749l0.h(r11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        ArrayList r11 = this.Q;
        if (r11 == null) goto L8;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        ((MotionHelper) r12.next()).onPreDraw(r10);
    L8:
        M(false);
        o r13 = this.f1726a;
        if (r13 == null) goto L13;
        s r14 = r13.f1965s;
        if (r14 == null) goto L13;
        r14.d();
    L13:
        super.dispatchDraw(r10);
        if (this.f1726a != null) goto L17;
        return;
    L17:
        if ((this.f1772x & 1) != 1) goto L32;
        if (isInEditMode() == true) goto L32;
        this.S++;
        long r15 = getNanoTime();
        long r16 = this.T;
        if (r16 == (-1)) goto L25;
        long r17 = r15 - r16;
        if (r17 <= 200000000) goto L26;
        this.U = ((int) ((this.S / (r17 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.S = 0;
        this.T = r15;
    L26:
        Paint r18 = new Paint();
        r18.setTextSize(42.0f);
        float r19 = ((int) (getProgress() * 1000.0f)) / 10.0f;
        String r20 = this.U + " fps " + androidx.constraintlayout.motion.widget.a.e(this, this.f1734e) + " -> ";
        StringBuilder r21 = new StringBuilder();
        r21.append(r20);
        r21.append(androidx.constraintlayout.motion.widget.a.e(this, this.f1738g));
        r21.append(" (progress: ");
        r21.append(r19);
        r21.append(" ) state=");
        int r22 = this.f1736f;
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
        r23 = androidx.constraintlayout.motion.widget.a.e(this, r22);
        goto L30
    L25:
        this.T = r15;
    L32:
        if (this.f1772x > 1) goto L34;
    L37:
        ArrayList r25 = this.Q;
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
        if (this.f1774y != null) goto L36;
        this.f1774y = new f(this);
    L36:
        this.f1774y.a(r10, this.f1746k, this.f1726a.p(), this.f1772x);
        goto L37
    }

    public void e0(int r10, int r11) {
        if (isAttachedToWindow() == false) goto L5;
        o r12 = this.f1726a;
        if (r12 == null) goto L13;
        this.f1734e = r10;
        this.f1738g = r11;
        r12.a0(r10, r11);
        this.f1775y0.e(this.mLayoutWidget, this.f1726a.l(r10), this.f1726a.l(r11));
        c0();
        this.f1754o = 0.0f;
        k0();
        return;
    L13:
        return;
    L5:
        if (this.f1749l0 != null) goto L7;
        this.f1749l0 = new i(this);
    L7:
        this.f1749l0.f(r10);
        this.f1749l0.d(r11);
    }

    public final Rect g0(ConstraintWidget r10) {
        Rect r11 = this.f1769v0;
        r11.top = r10.X();
        Rect r12 = this.f1769v0;
        r12.left = r10.W();
        Rect r13 = this.f1769v0;
        int r14 = r10.V();
        Rect r15 = this.f1769v0;
        r13.right = r14 + r15.left;
        int r16 = r10.w();
        Rect r17 = this.f1769v0;
        r15.bottom = r16 + r17.top;
        return r17;
    }

    public int[] getConstraintSetIds() {
        o r10 = this.f1726a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.n();
    }

    public int getCurrentState() {
        return this.f1736f;
    }

    public ArrayList<o.b> getDefinedTransitions() {
        o r10 = this.f1726a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.o();
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.C != null) goto L6;
        this.C = new androidx.constraintlayout.motion.widget.b(this);
    L6:
        return this.C;
    }

    public int getEndState() {
        return this.f1738g;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f1754o;
    }

    public o getScene() {
        return this.f1726a;
    }

    public int getStartState() {
        return this.f1734e;
    }

    public float getTargetPosition() {
        return this.f1758q;
    }

    public Bundle getTransitionState() {
        if (this.f1749l0 != null) goto L5;
        this.f1749l0 = new i(this);
    L5:
        this.f1749l0.c();
        return this.f1749l0.b();
    }

    public long getTransitionTimeMs() {
        o r10 = this.f1726a;
        if (r10 == null) goto L6;
        this.f1750m = r10.p() / 1000.0f;
    L6:
        return (long) (this.f1750m * 1000.0f);
    }

    public float getVelocity() {
        return this.f1732d;
    }

    public void h0(int r10, float r11, float r12) {
        if (this.f1726a != null) goto L6;
        return;
    L6:
        if (this.f1754o != r11) goto L8;
        return;
    L8:
        this.f1776z = true;
        this.f1748l = getNanoTime();
        this.f1750m = this.f1726a.p() / 1000.0f;
        this.f1758q = r11;
        this.f1762s = true;
        if (r10 == 0) goto L24;
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L24;
        if (r10 != 4) goto L15;
        this.B.b(r12, this.f1754o, this.f1726a.u());
        this.f1728b = this.B;
    L36:
        this.f1760r = false;
        this.f1748l = getNanoTime();
        invalidate();
        return;
    L15:
        if (r10 == 5) goto L20;
        if (r10 == 6) goto L24;
        if (r10 == 7) goto L24;
    L20:
        if (s0(r12, this.f1754o, this.f1726a.u()) == false) goto L22;
        this.B.b(r12, this.f1754o, this.f1726a.u());
        this.f1728b = this.B;
        goto L36
    L22:
        this.A.b(this.f1754o, r11, r12, this.f1750m, this.f1726a.u(), this.f1726a.v());
        this.f1732d = 0.0f;
        int r13 = this.f1736f;
        this.f1758q = r11;
        this.f1736f = r13;
        this.f1728b = this.A;
    L24:
        if (r10 == 1) goto L30;
        if (r10 == 7) goto L30;
        if (r10 == 2) goto L29;
        if (r10 == 6) goto L29;
    L32:
        if (this.f1726a.k() != 0) goto L34;
        this.A.b(this.f1754o, r11, r12, this.f1750m, this.f1726a.u(), this.f1726a.v());
    L35:
        int r14 = this.f1736f;
        this.f1758q = r11;
        this.f1736f = r14;
        this.f1728b = this.A;
        goto L36
    L34:
        this.A.d(this.f1754o, r11, r12, this.f1726a.B(), this.f1726a.C(), this.f1726a.A(), this.f1726a.D(), this.f1726a.z());
    L29:
        r11 = 1.0f;
    L30:
        r11 = 0.0f;
        goto L32
    }

    public void i0() {
        D(1.0f);
        this.f1751m0 = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public void j0(Runnable r10) {
        D(1.0f);
        this.f1751m0 = r10;
    }

    public void k0() {
        D(0.0f);
    }

    public void l0(int r10) {
        if (isAttachedToWindow() == false) goto L5;
        n0(r10, -1, -1);
        return;
    L5:
        if (this.f1749l0 != null) goto L7;
        this.f1749l0 = new i(this);
    L7:
        this.f1749l0.d(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int r10) {
        if (r10 != 0) goto L50;
        this.f1726a = null;
        return;
    L50:
        o r11 = new o(getContext(), this, r10);     // Catch: Exception -> L7
        this.f1726a = r11;     // Catch: Exception -> L7
        if (this.f1736f != (-1)) goto L10;
        this.f1736f = r11.F();     // Catch: Exception -> L7
        this.f1734e = this.f1726a.F();     // Catch: Exception -> L7
        this.f1738g = this.f1726a.q();     // Catch: Exception -> L7
    L10:
        if (isAttachedToWindow() == true) goto L51;
        this.f1726a = null;     // Catch: Exception -> L7
        return;
    L51:
        Display r12 = getDisplay();     // Catch: Exception -> L23
        if (r12 != null) goto L14;
        int r13 = 0;
    L15:
        this.f1767u0 = r13;     // Catch: Exception -> L23
        o r14 = this.f1726a;     // Catch: Exception -> L23
        if (r14 == null) goto L28;
        ConstraintSet r15 = r14.l(this.f1736f);     // Catch: Exception -> L23
        this.f1726a.V(this);     // Catch: Exception -> L23
        ArrayList r16 = this.Q;     // Catch: Exception -> L23
        if (r16 == null) goto L25;
        Iterator r17 = r16.iterator();     // Catch: Exception -> L23
    L21:
        if (r17.hasNext() == false) goto L25;
        ((MotionHelper) r17.next()).onFinishedMotionScene(this);     // Catch: Exception -> L23
    L25:
        if (r15 == null) goto L27;
        r15.i(this);     // Catch: Exception -> L23
    L27:
        this.f1734e = this.f1736f;     // Catch: Exception -> L23
    L28:
        a0();     // Catch: Exception -> L23
        i r18 = this.f1749l0;     // Catch: Exception -> L23
        if (r18 != null) goto L31;
        o r19 = this.f1726a;     // Catch: Exception -> L23
        if (r19 == null) goto L55;
        o.b r20 = r19.f1949c;     // Catch: Exception -> L23
        if (r20 != null) goto L39;
        return;
    L39:
        if (r20.x() != 4) goto L57;
        i0();     // Catch: Exception -> L23
        setState(TransitionState.SETUP);     // Catch: Exception -> L23
        setState(TransitionState.MOVING);     // Catch: Exception -> L23
        return;
    L57:
        return;
    L55:
        return;
    L31:
        if (this.f1771w0 == false) goto L33;
        post(new a(this));     // Catch: Exception -> L23
        return;
    L33:
        r18.a();     // Catch: Exception -> L23
        return;
    L14:
        r13 = r12.getRotation();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);
    }

    public void m0(int r10, int r11) {
        if (isAttachedToWindow() == false) goto L5;
        o0(r10, -1, -1, r11);
        return;
    L5:
        if (this.f1749l0 != null) goto L7;
        this.f1749l0 = new i(this);
    L7:
        this.f1749l0.d(r10);
    }

    public void n0(int r10, int r11, int r12) {
        o0(r10, r11, r12, -1);
    }

    public void o0(int r11, int r12, int r13, int r14) {
        o r10 = this.f1726a;
        if (r10 == null) goto L9;
        androidx.constraintlayout.widget.a r15 = r10.f1948b;
        if (r15 == null) goto L9;
        int r16 = r15.a(this.f1736f, r11, r12, r13);
        if (r16 == (-1)) goto L9;
        r11 = r16;
    L9:
        int r17 = this.f1736f;
        if (r17 != r11) goto L13;
        return;
    L13:
        if (this.f1734e != r11) goto L19;
        D(0.0f);
        if (r14 <= 0) goto L90;
        this.f1750m = r14 / 1000.0f;
        return;
    L90:
        return;
    L19:
        if (this.f1738g != r11) goto L24;
        D(1.0f);
        if (r14 <= 0) goto L91;
        this.f1750m = r14 / 1000.0f;
        return;
    L91:
        return;
    L24:
        this.f1738g = r11;
        if (r17 == (-1)) goto L30;
        e0(r17, r11);
        D(1.0f);
        this.f1754o = 0.0f;
        i0();
        if (r14 <= 0) goto L92;
        this.f1750m = r14 / 1000.0f;
        return;
    L92:
        return;
    L30:
        int r18 = 0;
        this.f1776z = false;
        this.f1758q = 1.0f;
        this.f1752n = 0.0f;
        this.f1754o = 0.0f;
        this.f1756p = getNanoTime();
        this.f1748l = getNanoTime();
        this.f1760r = false;
        this.f1728b = null;
        if (r14 != (-1)) goto L33;
        this.f1750m = this.f1726a.p() / 1000.0f;
    L33:
        this.f1734e = -1;
        this.f1726a.a0(-1, this.f1738g);
        SparseArray r19 = new SparseArray();
        if (r14 != 0) goto L36;
        this.f1750m = this.f1726a.p() / 1000.0f;
    L38:
        int r110 = getChildCount();
        this.f1746k.clear();
        int r20 = 0;
    L39:
        if (r20 >= r110) goto L41;
        View r21 = getChildAt(r20);
        this.f1746k.put(r21, new l(r21));
        r19.put(r21.getId(), (l) this.f1746k.get(r21));
        r20 = r20 + 1;
        goto L39
    L41:
        this.f1762s = true;
        this.f1775y0.e(this.mLayoutWidget, null, this.f1726a.l(r11));
        c0();
        this.f1775y0.a();
        K();
        int r111 = getWidth();
        int r112 = getHeight();
        if (this.Q == null) goto L61;
        int r22 = 0;
    L44:
        if (r22 >= r110) goto L50;
        l r23 = (l) this.f1746k.get(getChildAt(r22));
        if (r23 == null) goto L49;
        this.f1726a.t(r23);
    L49:
        r22 = r22 + 1;
        goto L44
    L50:
        Iterator r24 = this.Q.iterator();
    L52:
        if (r24.hasNext() == false) goto L54;
        ((MotionHelper) r24.next()).onPreSetup(this, this.f1746k);
        goto L52
    L54:
        int r25 = 0;
    L55:
        if (r25 >= r110) goto L68;
        l r26 = (l) this.f1746k.get(getChildAt(r25));
        if (r26 == null) goto L60;
        r26.M(r111, r112, this.f1750m, getNanoTime());
    L60:
        r25 = r25 + 1;
    L68:
        float r113 = this.f1726a.E();
        if (r113 == 0.0f) goto L75;
        float r114 = Float.MAX_VALUE;
        float r27 = -3.4028235E38f;
        int r28 = 0;
    L71:
        if (r28 >= r110) goto L73;
        l r29 = (l) this.f1746k.get(getChildAt(r28));
        float r30 = r29.p() + r29.o();
        r114 = Math.min(r114, r30);
        r27 = Math.max(r27, r30);
        r28 = r28 + 1;
    L73:
        if (r18 >= r110) goto L75;
        l r31 = (l) this.f1746k.get(getChildAt(r18));
        float r32 = r31.o();
        float r33 = r31.p();
        r31.f1914o = 1.0f / (1.0f - r113);
        r31.f1913n = r113 - ((((r32 + r33) - r114) * r113) / (r27 - r114));
        r18 = r18 + 1;
    L75:
        this.f1752n = 0.0f;
        this.f1754o = 0.0f;
        this.f1762s = true;
        invalidate();
        return;
    L61:
        int r34 = 0;
    L62:
        if (r34 >= r110) goto L68;
        l r35 = (l) this.f1746k.get(getChildAt(r34));
        if (r35 == null) goto L67;
        this.f1726a.t(r35);
        r35.M(r111, r112, this.f1750m, getNanoTime());
    L67:
        r34 = r34 + 1;
        goto L62
    L36:
        if (r14 <= 0) goto L38;
        this.f1750m = r14 / 1000.0f;
        goto L38
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display r10 = getDisplay();
        if (r10 == null) goto L5;
        this.f1767u0 = r10.getRotation();
    L5:
        o r11 = this.f1726a;
        if (r11 == null) goto L18;
        int r12 = this.f1736f;
        if (r12 == (-1)) goto L18;
        ConstraintSet r13 = r11.l(r12);
        this.f1726a.V(this);
        ArrayList r14 = this.Q;
        if (r14 == null) goto L15;
        Iterator r15 = r14.iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        ((MotionHelper) r15.next()).onFinishedMotionScene(this);
    L15:
        if (r13 == null) goto L17;
        r13.i(this);
    L17:
        this.f1734e = this.f1736f;
    L18:
        a0();
        i r16 = this.f1749l0;
        if (r16 != null) goto L21;
        o r17 = this.f1726a;
        if (r17 == null) goto L35;
        o.b r18 = r17.f1949c;
        if (r18 != null) goto L29;
        return;
    L29:
        if (r18.x() != 4) goto L37;
        i0();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L37:
        return;
    L35:
        return;
    L21:
        if (this.f1771w0 == false) goto L23;
        post(new c(this));
        return;
    L23:
        r16.a();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        o r11 = this.f1726a;
        if (r11 != null) goto L5;
    L38:
        return false;
    L5:
        if (this.f1744j == false) goto L38;
        s r12 = r11.f1965s;
        if (r12 == null) goto L10;
        r12.touchEvent(r10);
    L10:
        o.b r13 = this.f1726a.f1949c;
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
        View r17 = this.B0;
        if (r17 != null) goto L28;
    L29:
        this.B0 = findViewById(r16);
    L30:
        View r18 = this.B0;
        if (r18 == null) goto L38;
        this.A0.set(r18.getLeft(), this.B0.getTop(), this.B0.getRight(), this.B0.getBottom());
        if (this.A0.contains(r10.getX(), r10.getY()) == false) goto L38;
        if (V(this.B0.getLeft(), this.B0.getTop(), this.B0, r10) == true) goto L38;
        return onTouchEvent(r10);
    L28:
        if (r17.getId() == r16) goto L30;
        goto L29
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        this.f1747k0 = true;
    L8:
        th = move-exception;
        this.f1747k0 = false;
        throw th;
    L4:
        if (this.f1726a != null) goto L10;
        super.onLayout(r10, r11, r12, r13, r14);     // Catch: Throwable -> L8
        this.f1747k0 = false;
        return;
    L10:
        int r15 = r13 - r11;
        int r16 = r14 - r12;
        if (this.G == r15) goto L14;
    L15:
        c0();     // Catch: Throwable -> L8
        M(true);     // Catch: Throwable -> L8
    L16:
        this.G = r15;     // Catch: Throwable -> L8
        this.H = r16;     // Catch: Throwable -> L8
        this.E = r15;     // Catch: Throwable -> L8
        this.F = r16;     // Catch: Throwable -> L8
        this.f1747k0 = false;
        return;
    L14:
        if (this.H == r16) goto L16;
        goto L15
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f1726a != null) goto L6;
        super.onMeasure(r10, r11);
        return;
    L6:
        boolean r12 = false;
        if (this.f1740h == r10) goto L9;
    L12:
        boolean r13 = true;
    L14:
        if (this.f1777z0 == false) goto L17;
        this.f1777z0 = false;
        a0();
        b0();
        r13 = true;
    L17:
        if (this.mDirtyHierarchy == false) goto L19;
        r13 = true;
    L19:
        this.f1740h = r10;
        this.f1742i = r11;
        int r14 = this.f1726a.F();
        int r15 = this.f1726a.q();
        if (r13 == true) goto L24;
        if (this.f1775y0.f(r14, r15) == true) goto L24;
    L26:
        if (r13 == false) goto L28;
        super.onMeasure(r10, r11);
    L28:
        r12 = true;
    L30:
        if (this.f1729b0 == true) goto L32;
        if (r12 == true) goto L32;
    L41:
        N();
        return;
    L32:
        int r16 = getPaddingTop() + getPaddingBottom();
        int r17 = this.mLayoutWidget.V() + (getPaddingLeft() + getPaddingRight());
        int r18 = this.mLayoutWidget.w() + r16;
        int r19 = this.f1739g0;
        if (r19 == Integer.MIN_VALUE) goto L35;
        if (r19 == 0) goto L35;
    L36:
        int r20 = this.f1741h0;
        if (r20 == Integer.MIN_VALUE) goto L39;
        if (r20 == 0) goto L39;
    L40:
        setMeasuredDimension(r17, r18);
    L39:
        int r21 = this.f1733d0;
        r18 = (int) (r21 + (this.f1743i0 * (this.f1737f0 - r21)));
        requestLayout();
    L35:
        int r22 = this.f1731c0;
        r17 = (int) (r22 + (this.f1743i0 * (this.f1735e0 - r22)));
        requestLayout();
    L24:
        if (this.f1734e == (-1)) goto L26;
        super.onMeasure(r10, r11);
        this.f1775y0.e(this.mLayoutWidget, this.f1726a.l(r14), this.f1726a.l(r15));
        this.f1775y0.h();
        this.f1775y0.i(r14, r15);
        goto L30
    L9:
        if (this.f1742i != r11) goto L12;
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
        o r16 = this.f1726a;
        if (r16 != null) goto L5;
        return;
    L5:
        o.b r10 = r16.f1949c;
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
        float r21 = this.f1752n;
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
        float r110 = this.f1752n;
        long r22 = getNanoTime();
        float r23 = r12;
        this.f1725J = r23;
        float r24 = r13;
        this.K = r24;
        this.M = (float) ((r22 - this.L) * 1.0E-9d);
        this.L = r22;
        r16.R(r23, r24);
        if (r110 == this.f1752n) goto L50;
        r14[0] = r12;
        r14[1] = r13;
    L50:
        M(false);
        if (r14[0] == 0) goto L53;
    L54:
        this.I = true;
        return;
    L53:
        if (r14[1] != 0) goto L54;
        return;
    L36:
        if ((r10.B().e() & 1) == 0) goto L47;
        float r25 = r16.x(r12, r13);
        float r26 = this.f1754o;
        if (r26 > 0.0f) goto L42;
        if (r25 >= 0.0f) goto L42;
    L45:
        r11.setNestedScrollingEnabled(false);
        r11.post(new b(this, r11));
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
        this.L = getNanoTime();
        this.M = 0.0f;
        this.f1725J = 0.0f;
        this.K = 0.0f;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r10) {
        o r11 = this.f1726a;
        if (r11 == null) goto L6;
        r11.Z(isRtl());
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r10, View r11, int r12, int r13) {
        o r14 = this.f1726a;
        if (r14 == null) goto L13;
        o.b r15 = r14.f1949c;
        if (r15 != null) goto L7;
        return false;
    L7:
        if (r15.B() != null) goto L9;
        return false;
    L9:
        if ((this.f1726a.f1949c.B().e() & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    L13:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r10, int r11) {
        o r12 = this.f1726a;
        if (r12 == null) goto L9;
        float r13 = this.M;
        if (r13 == 0.0f) goto L10;
        r12.S(this.f1725J / r13, this.K / r13);
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        o r11 = this.f1726a;
        if (r11 == null) goto L21;
        if (this.f1744j == false) goto L21;
        if (r11.e0() == false) goto L21;
        o.b r12 = this.f1726a.f1949c;
        if (r12 != null) goto L11;
    L14:
        this.f1726a.T(r10, getCurrentState(), this);
        if (this.f1726a.f1949c.D(4) == true) goto L17;
        return true;
    L17:
        return this.f1726a.f1949c.B().r();
    L11:
        if (r12.C() == true) goto L14;
        return super.onTouchEvent(r10);
    L21:
        return super.onTouchEvent(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View r10) {
        super.onViewAdded(r10);
        if ((r10 instanceof MotionHelper) == false) goto L26;
        MotionHelper r11 = (MotionHelper) r10;
        if (this.R != null) goto L7;
        this.R = new CopyOnWriteArrayList();
    L7:
        this.R.add(r11);
        if (r11.isUsedOnShow() == false) goto L14;
        if (this.O != null) goto L12;
        this.O = new ArrayList();
    L12:
        this.O.add(r11);
    L14:
        if (r11.isUseOnHide() == false) goto L20;
        if (this.P != null) goto L18;
        this.P = new ArrayList();
    L18:
        this.P.add(r11);
    L20:
        if (r11.isDecorator() == true) goto L22;
        return;
    L22:
        if (this.Q != null) goto L24;
        this.Q = new ArrayList();
    L24:
        this.Q.add(r11);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        ArrayList r11 = this.O;
        if (r11 == null) goto L5;
        r11.remove(r10);
    L5:
        ArrayList r12 = this.P;
        if (r12 == null) goto L9;
        r12.remove(r10);
        return;
    }

    public void p0() {
        this.f1775y0.e(this.mLayoutWidget, this.f1726a.l(this.f1734e), this.f1726a.l(this.f1738g));
        c0();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int r10) {
        this.mConstraintLayoutSpec = null;
    }

    public void q0(int r10, ConstraintSet r11) {
        o r12 = this.f1726a;
        if (r12 == null) goto L5;
        r12.W(r10, r11);
    L5:
        p0();
        if (this.f1736f != r10) goto L9;
        r11.i(this);
        return;
    }

    public void r0(int r10, ConstraintSet r11, int r12) {
        if (this.f1726a != null) goto L6;
        return;
    L6:
        if (this.f1736f != r10) goto L9;
        int r13 = R$id.view_transition;
        q0(r13, R(r10));
        setState(r13, -1, -1);
        q0(r10, r11);
        o.b r14 = new o.b(-1, this.f1726a, r13, r10);
        r14.E(r12);
        setTransition(r14);
        i0();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f1729b0 == false) goto L5;
    L19:
        super.requestLayout();
        return;
    L5:
        if (this.f1736f != (-1)) goto L19;
        o r10 = this.f1726a;
        if (r10 == null) goto L19;
        o.b r11 = r10.f1949c;
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
        ((l) this.f1746k.get(r15)).D();
        r14 = r14 + 1;
        goto L16
    }

    public void setDebugMode(int r10) {
        this.f1772x = r10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean r10) {
        this.f1771w0 = r10;
    }

    public void setInteractionEnabled(boolean r10) {
        this.f1744j = r10;
    }

    public void setInterpolatedProgress(float r10) {
        if (this.f1726a == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r11 = this.f1726a.s();
        if (r11 == null) goto L8;
        setProgress(r11.getInterpolation(r10));
        return;
    L8:
        setProgress(r10);
    }

    public void setOnHide(float r10) {
        ArrayList r11 = this.P;
        if (r11 == null) goto L7;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        ((MotionHelper) this.P.get(r13)).setProgress(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r10) {
        ArrayList r11 = this.O;
        if (r11 == null) goto L7;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        ((MotionHelper) this.O.get(r13)).setProgress(r10);
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
        if (this.f1754o == 1.0f) goto L18;
    L20:
        this.f1736f = this.f1734e;
        if (this.f1754o != 0.0f) goto L35;
        setState(TransitionState.FINISHED);
    L35:
        if (this.f1726a != null) goto L37;
        return;
    L37:
        this.f1760r = true;
        this.f1758q = r10;
        this.f1752n = r10;
        this.f1756p = -1;
        this.f1748l = -1;
        this.f1728b = null;
        this.f1762s = true;
        invalidate();
        return;
    L18:
        if (this.f1736f != this.f1738g) goto L20;
        setState(TransitionState.MOVING);
        goto L20
    L24:
        if (r10 >= 1.0f) goto L26;
        this.f1736f = -1;
        setState(TransitionState.MOVING);
        goto L35
    L26:
        if (this.f1754o == 0.0f) goto L28;
    L30:
        this.f1736f = this.f1738g;
        if (this.f1754o != 1.0f) goto L35;
        setState(TransitionState.FINISHED);
        goto L35
    L28:
        if (this.f1736f != this.f1734e) goto L30;
        setState(TransitionState.MOVING);
        goto L30
    L10:
        if (this.f1749l0 != null) goto L12;
        this.f1749l0 = new i(this);
    L12:
        this.f1749l0.e(r10);
        return;
    L5:
        if (r10 <= 1.0f) goto L8;
        goto L6
    }

    public void setScene(o r10) {
        this.f1726a = r10;
        r10.Z(isRtl());
        c0();
    }

    public void setStartState(int r10) {
        if (isAttachedToWindow() == false) goto L5;
        this.f1736f = r10;
        return;
    L5:
        if (this.f1749l0 != null) goto L7;
        this.f1749l0 = new i(this);
    L7:
        this.f1749l0.f(r10);
        this.f1749l0.d(r10);
    }

    public void setState(TransitionState r10) {
        TransitionState r11 = TransitionState.FINISHED;
        if (r10 == r11) goto L5;
    L7:
        TransitionState r12 = this.f1773x0;
        this.f1773x0 = r10;
        TransitionState r13 = TransitionState.MOVING;
        if (r12 != r13) goto L11;
        if (r10 != r13) goto L11;
        O();
    L11:
        int r14 = d.f1781a[r12.ordinal()];
        if (r14 != 1) goto L14;
    L20:
        if (r10 != r13) goto L22;
        O();
    L22:
        if (r10 != r11) goto L27;
        P();
        return;
    L27:
        return;
    L14:
        if (r14 == 2) goto L20;
        if (r14 != 3) goto L28;
        if (r10 != r11) goto L25;
        P();
        return;
    L25:
        return;
    L28:
        return;
    L5:
        if (this.f1736f != (-1)) goto L7;
    }

    public void setTransition(int r10) {
        if (this.f1726a == null) goto L35;
        o.b r11 = T(r10);
        this.f1734e = r11.A();
        this.f1738g = r11.y();
        if (isAttachedToWindow() == false) goto L7;
        int r12 = this.f1736f;
        float r13 = 0.0f;
        if (r12 != this.f1734e) goto L15;
        float r14 = 0.0f;
    L18:
        this.f1726a.b0(r11);
        this.f1775y0.e(this.mLayoutWidget, this.f1726a.l(this.f1734e), this.f1726a.l(this.f1738g));
        c0();
        if (this.f1754o == r14) goto L27;
        if (r14 != 0.0f) goto L24;
        L(true);
        this.f1726a.l(this.f1734e).i(this);
        goto L27
    L24:
        if (r14 != 1.0f) goto L27;
        L(false);
        this.f1726a.l(this.f1738g).i(this);
    L27:
        if (Float.isNaN(r14) == true) goto L30;
        r13 = r14;
    L30:
        this.f1754o = r13;
        if (Float.isNaN(r14) == false) goto L33;
        Log.v("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + " transitionToStart ");
        k0();
        return;
    L33:
        setProgress(r14);
        return;
    L15:
        if (r12 != this.f1738g) goto L17;
        r14 = 1.0f;
        goto L18
    L17:
        r14 = Float.NaN;
        goto L18
    L7:
        if (this.f1749l0 != null) goto L9;
        this.f1749l0 = new i(this);
    L9:
        this.f1749l0.f(this.f1734e);
        this.f1749l0.d(this.f1738g);
        return;
    }

    public void setTransitionDuration(int r10) {
        o r11 = this.f1726a;
        if (r11 != null) goto L6;
        Log.e("MotionLayout", "MotionScene not defined");
        return;
    L6:
        r11.X(r10);
    }

    public void setTransitionListener(TransitionListener r10) {
        this.f1766u = r10;
    }

    public void setTransitionState(Bundle r10) {
        if (this.f1749l0 != null) goto L5;
        this.f1749l0 = new i(this);
    L5:
        this.f1749l0.g(r10);
        if (isAttachedToWindow() == false) goto L9;
        this.f1749l0.a();
        return;
    }

    @Override // android.view.View
    public String toString() {
        Context r10 = getContext();
        return androidx.constraintlayout.motion.widget.a.c(r10, this.f1734e) + "->" + androidx.constraintlayout.motion.widget.a.c(r10, this.f1738g) + " (pos:" + this.f1754o + " Dpos/Dt:" + this.f1732d;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15, int[] r16) {
        if (this.I == true) goto L6;
        if (r11 != 0) goto L6;
        if (r12 != 0) goto L6;
    L7:
        this.I = false;
        return;
    L6:
        r16[0] = r16[0] + r13;
        r16[1] = r16[1] + r14;
        goto L7
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int r10, int r11, int r12) {
        setState(TransitionState.SETUP);
        this.f1736f = r10;
        this.f1734e = -1;
        this.f1738g = -1;
        ConstraintLayoutStates r13 = this.mConstraintLayoutSpec;
        if (r13 == null) goto L5;
        r13.d(r10, r11, r12);
        return;
    L5:
        o r14 = this.f1726a;
        if (r14 == null) goto L10;
        r14.l(r10).i(this);
        return;
    }

    public void setTransition(o.b r10) {
        this.f1726a.b0(r10);
        setState(TransitionState.SETUP);
        if (this.f1736f != this.f1726a.q()) goto L5;
        this.f1754o = 1.0f;
        this.f1752n = 1.0f;
        this.f1758q = 1.0f;
    L7:
        if (r10.D(1) == false) goto L9;
        long r11 = -1;
    L10:
        this.f1756p = r11;
        int r12 = this.f1726a.F();
        int r13 = this.f1726a.q();
        if (r12 == this.f1734e) goto L13;
    L15:
        this.f1734e = r12;
        this.f1738g = r13;
        this.f1726a.a0(r12, r13);
        this.f1775y0.e(this.mLayoutWidget, this.f1726a.l(this.f1734e), this.f1726a.l(this.f1738g));
        this.f1775y0.i(this.f1734e, this.f1738g);
        this.f1775y0.h();
        c0();
        return;
    L13:
        if (r13 != this.f1738g) goto L15;
        return;
    L9:
        r11 = getNanoTime();
        goto L10
    L5:
        this.f1754o = 0.0f;
        this.f1752n = 0.0f;
        this.f1758q = 0.0f;
        goto L7
    }

    public MotionLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f1730c = null;
        this.f1732d = 0.0f;
        this.f1734e = -1;
        this.f1736f = -1;
        this.f1738g = -1;
        this.f1740h = 0;
        this.f1742i = 0;
        this.f1744j = true;
        this.f1746k = new HashMap();
        this.f1748l = 0;
        this.f1750m = 1.0f;
        this.f1752n = 0.0f;
        this.f1754o = 0.0f;
        this.f1758q = 0.0f;
        this.f1762s = false;
        this.f1764t = false;
        this.f1772x = 0;
        this.f1776z = false;
        this.A = new m.b();
        this.B = new e(this);
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1;
        this.U = 0.0f;
        this.V = 0;
        this.W = 0.0f;
        this.f1727a0 = false;
        this.f1729b0 = false;
        this.f1745j0 = new p001j.d();
        this.f1747k0 = false;
        this.f1751m0 = null;
        this.f1753n0 = null;
        this.f1755o0 = 0;
        this.f1757p0 = false;
        this.f1759q0 = 0;
        this.f1761r0 = new HashMap();
        this.f1769v0 = new Rect();
        this.f1771w0 = false;
        this.f1773x0 = TransitionState.UNDEFINED;
        this.f1775y0 = new g(this);
        this.f1777z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        W(r11);
    }

    public MotionLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f1730c = null;
        this.f1732d = 0.0f;
        this.f1734e = -1;
        this.f1736f = -1;
        this.f1738g = -1;
        this.f1740h = 0;
        this.f1742i = 0;
        this.f1744j = true;
        this.f1746k = new HashMap();
        this.f1748l = 0;
        this.f1750m = 1.0f;
        this.f1752n = 0.0f;
        this.f1754o = 0.0f;
        this.f1758q = 0.0f;
        this.f1762s = false;
        this.f1764t = false;
        this.f1772x = 0;
        this.f1776z = false;
        this.A = new m.b();
        this.B = new e(this);
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1;
        this.U = 0.0f;
        this.V = 0;
        this.W = 0.0f;
        this.f1727a0 = false;
        this.f1729b0 = false;
        this.f1745j0 = new p001j.d();
        this.f1747k0 = false;
        this.f1751m0 = null;
        this.f1753n0 = null;
        this.f1755o0 = 0;
        this.f1757p0 = false;
        this.f1759q0 = 0;
        this.f1761r0 = new HashMap();
        this.f1769v0 = new Rect();
        this.f1771w0 = false;
        this.f1773x0 = TransitionState.UNDEFINED;
        this.f1775y0 = new g(this);
        this.f1777z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        W(r11);
    }
}

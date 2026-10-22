package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class GestureDetectorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1379a;

    static class GestureDetectorCompatImplBase implements a {
        private static final int j = 0;
        private static final int k = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final GestureDetector.OnGestureListener f1380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f1381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        MotionEvent f1384e;
        private int f;
        private int g;
        private int h;
        private int i;
        private final Handler l;
        private boolean m;
        private boolean n;
        private boolean o;
        private MotionEvent p;
        private boolean q;
        private float r;
        private float s;
        private float t;
        private float u;
        private boolean v;
        private VelocityTracker w;

        private class GestureHandler extends Handler {
            final /* synthetic */ GestureDetectorCompatImplBase this$0;

            GestureHandler(GestureDetectorCompatImplBase r1) {
                this.this$0 = r1;
            }

            GestureHandler(GestureDetectorCompatImplBase r1, Handler r2) {
                this.this$0 = r1;
                super(r2.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message r4) {
                int r0 = r4.what;
                if (r0 != 1) goto L5;
                this.this$0.f1380a.onShowPress(this.this$0.f1384e);
                return;
            L5:
                if (r0 != 2) goto L7;
                this.this$0.a();
                return;
            L7:
                if (r0 != 3) goto L15;
                if (this.this$0.f1381b != null) goto L11;
                return;
            L11:
                if (this.this$0.f1382c == true) goto L13;
                this.this$0.f1381b.onSingleTapConfirmed(this.this$0.f1384e);
                return;
            L13:
                this.this$0.f1383d = true;
                return;
            L15:
                throw new RuntimeException("Unknown message " + r4);
            }
        }

        static {
            j = ViewConfiguration.getTapTimeout();
            k = ViewConfiguration.getDoubleTapTimeout();
        }

        GestureDetectorCompatImplBase(Context r3, GestureDetector.OnGestureListener r4, Handler r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            GestureDetector.OnGestureListener r7 = (GestureDetector.OnGestureListener) ZeusTransformUtils.wrapperContextForParams(r4, GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L5;
            this.l = new GestureHandler(this, r5);
        L6:
            this.f1380a = r7;
            if (ZeusTransformUtils.instanceOf(r7, GestureDetector.OnDoubleTapListener.class) == false) goto L9;
            a((GestureDetector.OnDoubleTapListener) ZeusTransformUtils.preCheckCast(r7, GestureDetector.OnDoubleTapListener.class, "com.obric.aiagent.plugin"));
        L9:
            a(r6);
            return;
        L5:
            this.l = new GestureHandler(this);
            goto L6
        }

        private void a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L11;
            if (this.f1380a == null) goto L9;
            this.v = true;
            ViewConfiguration r6 = ViewConfiguration.get(r5);
            int r0 = r6.getScaledTouchSlop();
            int r1 = r6.getScaledDoubleTapSlop();
            this.h = r6.getScaledMinimumFlingVelocity();
            this.i = r6.getScaledMaximumFlingVelocity();
            this.f = r0 * r0;
            this.g = r1 * r1;
            return;
        L9:
            throw new IllegalArgumentException("OnGestureListener must not be null");
        L11:
            throw new IllegalArgumentException("Context must not be null");
        }

        public void a(GestureDetector.OnDoubleTapListener r3) {
            this.f1381b = (GestureDetector.OnDoubleTapListener) ZeusTransformUtils.wrapperContextForParams(r3, GestureDetector.OnDoubleTapListener.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.core.view.GestureDetectorCompat.a
        public boolean a(MotionEvent r13) {
            int r0 = r13.getAction();
            if (this.w != null) goto L5;
            this.w = VelocityTracker.obtain();
        L5:
            this.w.addMovement(r13);
            int r1 = r0 & 255;
            if (r1 != 6) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == false) goto L11;
            int r5 = r13.getActionIndex();
        L12:
            int r6 = r13.getPointerCount();
            int r8 = 0;
            float r9 = 0.0f;
            float r10 = 0.0f;
        L13:
            if (r8 >= r6) goto L18;
            if (r5 == r8) goto L17;
            r9 = r9 + r13.getX(r8);
            r10 = r10 + r13.getY(r8);
        L17:
            r8 = r8 + 1;
            goto L13
        L18:
            if (r4 == false) goto L20;
            int r7 = r6 - 1;
        L21:
            float r11 = r7;
            float r12 = r9 / r11;
            float r14 = r10 / r11;
            if (r1 == 0) goto L91;
            if (r1 == 1) goto L61;
            if (r1 == 2) goto L42;
            if (r1 != 3) goto L28;
            b();
            return false;
        L28:
            if (r1 == 5) goto L39;
            if (r1 != 6) goto L127;
            this.r = r12;
            this.t = r12;
            this.s = r14;
            this.u = r14;
            this.w.computeCurrentVelocity(1000, this.i);
            int r2 = r13.getActionIndex();
            int r3 = r13.getPointerId(r2);
            float r15 = this.w.getXVelocity(r3);
            float r16 = this.w.getYVelocity(r3);
            int r17 = 0;
        L32:
            if (r17 >= r6) goto L129;
            if (r17 == r2) goto L38;
            int r18 = r13.getPointerId(r17);
            if (((this.w.getXVelocity(r18) * r15) + (this.w.getYVelocity(r18) * r16)) >= 0.0f) goto L38;
            this.w.clear();
            return false;
        L38:
            r17 = r17 + 1;
            goto L32
        L129:
            return false;
        L127:
            return false;
        L39:
            this.r = r12;
            this.t = r12;
            this.s = r14;
            this.u = r14;
            c();
            return false;
        L42:
            if (this.m == true) goto L128;
            float r19 = this.r - r12;
            float r20 = this.s - r14;
            if (this.q == false) goto L48;
            return false | this.f1381b.onDoubleTapEvent(r13);
        L48:
            if (this.n == false) goto L57;
            int r21 = (int) (r12 - this.t);
            int r22 = (int) (r14 - this.u);
            int r23 = (r21 * r21) + (r22 * r22);
            if (r23 <= this.f) goto L52;
            boolean r110 = this.f1380a.onScroll(this.f1384e, r13, r19, r20);
            this.r = r12;
            this.s = r14;
            this.n = false;
            this.l.removeMessages(3);
            this.l.removeMessages(1);
            this.l.removeMessages(2);
        L54:
            if (r23 <= this.f) goto L126;
            this.o = false;
        L126:
            return r110;
        L52:
            r110 = false;
            goto L54
        L57:
            if (Math.abs(r19) < 1.0f) goto L59;
        L60:
            boolean r24 = this.f1380a.onScroll(this.f1384e, r13, r19, r20);
            this.r = r12;
            this.s = r14;
            return r24;
        L59:
            if (Math.abs(r20) >= 1.0f) goto L60;
            return false;
        L128:
            return false;
        L61:
            this.f1382c = false;
            MotionEvent r25 = MotionEvent.obtain(r13);
            if (this.q == false) goto L65;
            r110 = this.f1381b.onDoubleTapEvent(r13) | false;
        L82:
            MotionEvent r26 = this.p;
            if (r26 == null) goto L85;
            r26.recycle();
        L85:
            this.p = r25;
            VelocityTracker r27 = this.w;
            if (r27 == null) goto L88;
            r27.recycle();
            this.w = null;
        L88:
            this.q = false;
            this.f1383d = false;
            this.l.removeMessages(1);
            this.l.removeMessages(2);
            goto L126
        L65:
            if (this.m == false) goto L68;
            this.l.removeMessages(3);
            this.m = false;
        L80:
            r110 = false;
            goto L82
        L68:
            if (this.n == false) goto L75;
            boolean r28 = this.f1380a.onSingleTapUp(r13);
            if (this.f1383d == false) goto L74;
            GestureDetector.OnDoubleTapListener r29 = this.f1381b;
            if (r29 == null) goto L74;
            r29.onSingleTapConfirmed(r13);
        L74:
            r110 = r28;
            goto L82
        L75:
            VelocityTracker r30 = this.w;
            int r31 = r13.getPointerId(0);
            r30.computeCurrentVelocity(1000, this.i);
            float r32 = r30.getYVelocity(r31);
            float r33 = r30.getXVelocity(r31);
            if (Math.abs(r32) <= this.h) goto L78;
        L81:
            r110 = this.f1380a.onFling(this.f1384e, r13, r33, r32);
            goto L82
        L78:
            if (Math.abs(r33) <= this.h) goto L80;
        L91:
            if (this.f1381b == null) goto L104;
            boolean r34 = this.l.hasMessages(3);
            if (r34 == false) goto L95;
            this.l.removeMessages(3);
        L95:
            MotionEvent r35 = this.f1384e;
            if (r35 == null) goto L103;
            MotionEvent r36 = this.p;
            if (r36 == null) goto L103;
            if (r34 == false) goto L103;
            if (a(r35, r36, r13) == false) goto L103;
            this.q = true;
            boolean r37 = (this.f1381b.onDoubleTap(this.f1384e) | false) | this.f1381b.onDoubleTapEvent(r13);
        L105:
            this.r = r12;
            this.t = r12;
            this.s = r14;
            this.u = r14;
            MotionEvent r38 = this.f1384e;
            if (r38 == null) goto L108;
            r38.recycle();
        L108:
            this.f1384e = MotionEvent.obtain(r13);
            this.n = true;
            this.o = true;
            this.f1382c = true;
            this.m = false;
            this.f1383d = false;
            if (this.v == false) goto L111;
            this.l.removeMessages(2);
            this.l.sendEmptyMessageAtTime(2, (this.f1384e.getDownTime() + ((long) j)) + ((long) ViewConfiguration.getLongPressTimeout()));
        L111:
            this.l.sendEmptyMessageAtTime(1, this.f1384e.getDownTime() + ((long) j));
            return r37 | this.f1380a.onDown(r13);
        L103:
            this.l.sendEmptyMessageDelayed(3, k);
        L104:
            r37 = false;
            goto L105
        L20:
            r7 = r6;
            goto L21
        L11:
            r5 = -1;
            goto L12
        L8:
            r4 = false;
            goto L9
        }

        private void b() {
            this.l.removeMessages(1);
            this.l.removeMessages(2);
            this.l.removeMessages(3);
            this.w.recycle();
            this.w = null;
            this.q = false;
            this.f1382c = false;
            this.n = false;
            this.o = false;
            this.f1383d = false;
            if (this.m == false) goto L6;
            this.m = false;
            return;
        }

        private void c() {
            this.l.removeMessages(1);
            this.l.removeMessages(2);
            this.l.removeMessages(3);
            this.q = false;
            this.n = false;
            this.o = false;
            this.f1383d = false;
            if (this.m == false) goto L6;
            this.m = false;
            return;
        }

        private boolean a(MotionEvent r7, MotionEvent r8, MotionEvent r9) {
            if (this.o == true) goto L6;
            return false;
        L6:
            if ((r9.getEventTime() - r8.getEventTime()) <= k) goto L8;
            return false;
        L8:
            int r10 = ((int) r7.getX()) - ((int) r9.getX());
            int r11 = ((int) r7.getY()) - ((int) r9.getY());
            if (((r10 * r10) + (r11 * r11)) >= this.g) goto L12;
            return true;
        L12:
            return false;
        }

        void a() {
            this.l.removeMessages(3);
            this.f1383d = false;
            this.m = true;
            this.f1380a.onLongPress(this.f1384e);
        }
    }

    interface a {
        boolean a(MotionEvent r1);
    }

    static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GestureDetector f1385a;

        b(Context r3, GestureDetector.OnGestureListener r4, Handler r5) {
            this.f1385a = new GestureDetector((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (GestureDetector.OnGestureListener) ZeusTransformUtils.wrapperContextForParams(r4, GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // androidx.core.view.GestureDetectorCompat.a
        public boolean a(MotionEvent r1) {
            return this.f1385a.onTouchEvent(r1);
        }
    }

    public GestureDetectorCompat(Context r3, GestureDetector.OnGestureListener r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (GestureDetector.OnGestureListener) ZeusTransformUtils.wrapperContextForParams(r4, GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin"), null);
    }

    public GestureDetectorCompat(Context r3, GestureDetector.OnGestureListener r4, Handler r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        GestureDetector.OnGestureListener r7 = (GestureDetector.OnGestureListener) ZeusTransformUtils.wrapperContextForParams(r4, GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT <= 17) goto L5;
        this.f1379a = new b(r6, r7, r5);
        return;
    L5:
        this.f1379a = new GestureDetectorCompatImplBase(r6, r7, r5);
    }

    public boolean a(MotionEvent r1) {
        return this.f1379a.a(r1);
    }
}

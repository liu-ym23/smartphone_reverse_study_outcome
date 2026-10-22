package com.bytedance.android.shopping.deepfeed.event;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f173295r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f173296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f173297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f173298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f173299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f173300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f173301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d> f173302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f173303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f173304i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<Long, Runnable> f173305j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Runnable f173306k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f173307l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function2<Float, Float, c> f173308m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<DeepFeedProductEventTracker> f173309n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f173310o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f173311p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function1<Integer, Boolean> f173312q;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.event.a$a, reason: collision with other inner class name */
    public static final class C2591a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f173313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f173314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f173315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f173316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f173317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f173318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f173319g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L20;
            b r101 = (b) r100;
            if (this.f173313a == r101.f173313a) goto L8;
            return false;
        L8:
            if (this.f173314b == r101.f173314b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f173315c, r101.f173315c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f173316d, r101.f173316d) == true) goto L14;
            return false;
        L14:
            if (this.f173317e == r101.f173317e) goto L16;
            return false;
        L16:
            if (this.f173318f == r101.f173318f) goto L18;
            return false;
        L18:
            if (this.f173319g == r101.f173319g) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            int r100 = ((this.f173313a * 31) + this.f173314b) * 31;
            String r101 = this.f173315c;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            Integer r105 = this.f173316d;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return ((((((r104 + r102) * 31) + this.f173317e) * 31) + this.f173318f) * 31) + this.f173319g;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "CompletedGesture(dx=" + this.f173313a + ", dy=" + this.f173314b + ", result=" + this.f173315c + ", quadrant=" + this.f173316d + ", xAngle=" + this.f173317e + ", yAngle=" + this.f173318f + ", velocity=" + this.f173319g + ")";
        }

        public b(int r100, int r101, String r102, Integer r103, int r104, int r105, int r106) {
            Intrinsics.checkNotNullParameter(r102, "result");
            this.f173313a = r100;
            this.f173314b = r101;
            this.f173315c = r102;
            this.f173316d = r103;
            this.f173317e = r104;
            this.f173318f = r105;
            this.f173319g = r106;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f173320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f173321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f173322c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f173320a, r101.f173320a) == true) goto L8;
            return false;
        L8:
            if (this.f173321b == r101.f173321b) goto L10;
            return false;
        L10:
            if (this.f173322c == r101.f173322c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f173320a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (((r101 * 31) + this.f173321b) * 31) + this.f173322c;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "DownTarget(area=" + this.f173320a + ", dragPosition=" + this.f173321b + ", snapPosition=" + this.f173322c + ")";
        }

        public c(String r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "area");
            this.f173320a = r100;
            this.f173321b = r101;
            this.f173322c = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f173323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f173324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f173325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f173326d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f173327e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f173328f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f173329g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f173330h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f173331i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f173332j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f173333k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f173334l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f173335m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f173336n;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L34;
            d r101 = (d) r100;
            if (this.f173323a == r101.f173323a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f173324b, r101.f173324b) == true) goto L10;
            return false;
        L10:
            if (this.f173325c == r101.f173325c) goto L12;
            return false;
        L12:
            if (this.f173326d == r101.f173326d) goto L14;
            return false;
        L14:
            if (this.f173327e == r101.f173327e) goto L16;
            return false;
        L16:
            if (Float.compare(this.f173328f, r101.f173328f) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f173329g, r101.f173329g) == 0) goto L20;
            return false;
        L20:
            if (this.f173330h == r101.f173330h) goto L22;
            return false;
        L22:
            if (Float.compare(this.f173331i, r101.f173331i) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f173332j, r101.f173332j) == 0) goto L26;
            return false;
        L26:
            if (Float.compare(this.f173333k, r101.f173333k) == 0) goto L28;
            return false;
        L28:
            if (Float.compare(this.f173334l, r101.f173334l) == 0) goto L30;
            return false;
        L30:
            if (this.f173335m == r101.f173335m) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.f173336n, r101.f173336n) == true) goto L52;
            return false;
        L52:
            return true;
        L34:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v22, types: [int] */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r1v24, types: [int] */
        public final int hashCode() {
            long r100 = this.f173323a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f173324b;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            int r105 = (((((r101 + r104) * 31) + this.f173325c) * 31) + this.f173326d) * 31;
            long r106 = this.f173327e;
            int r107 = (((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + Float.floatToIntBits(this.f173328f)) * 31) + Float.floatToIntBits(this.f173329g)) * 31;
            long r108 = this.f173330h;
            int r109 = (((((((((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + Float.floatToIntBits(this.f173331i)) * 31) + Float.floatToIntBits(this.f173332j)) * 31) + Float.floatToIntBits(this.f173333k)) * 31) + Float.floatToIntBits(this.f173334l)) * 31;
            boolean r110 = this.f173335m;
            ?? r111 = r110;
            if (r110 == false) goto L9;
            r111 = 1;
        L9:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f173336n;
            if (r113 == null) goto L13;
            r103 = r113.hashCode();
        L13:
            return r112 + r103;
        L5:
            r104 = 0;
            goto L6
        }

        public final String toString() {
            return "GestureSession(id=" + this.f173323a + ", area=" + this.f173324b + ", dragPosition=" + this.f173325c + ", startSnapPosition=" + this.f173326d + ", downTimeMs=" + this.f173327e + ", startX=" + this.f173328f + ", startY=" + this.f173329g + ", endTimeMs=" + this.f173330h + ", endX=" + this.f173331i + ", endY=" + this.f173332j + ", velocityX=" + this.f173333k + ", velocityY=" + this.f173334l + ", ended=" + this.f173335m + ", pendingResult=" + this.f173336n + ")";
        }

        public d(long r100, String r101, int r102, int r103, long r104, float r105, float r110) {
            Intrinsics.checkNotNullParameter(r101, "area");
            this.f173323a = r100;
            this.f173324b = r101;
            this.f173325c = r102;
            this.f173326d = r103;
            this.f173327e = r104;
            this.f173328f = r105;
            this.f173329g = r110;
            this.f173330h = 0;
            this.f173331i = 0.0f;
            this.f173332j = 0.0f;
            this.f173333k = 0.0f;
            this.f173334l = 0.0f;
            this.f173335m = false;
            this.f173336n = null;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f173337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f173338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f173339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f173340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f173341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f173342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f173343g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L20;
            e r101 = (e) r100;
            if (this.f173337a == r101.f173337a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f173338b, r101.f173338b) == true) goto L10;
            return false;
        L10:
            if (this.f173339c == r101.f173339c) goto L12;
            return false;
        L12:
            if (this.f173340d == r101.f173340d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f173341e, r101.f173341e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f173342f, r101.f173342f) == true) goto L18;
            return false;
        L18:
            if (this.f173343g == r101.f173343g) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r1v12, types: [int] */
        public final int hashCode() {
            long r100 = this.f173337a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f173338b;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            long r105 = this.f173339c;
            int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            long r107 = this.f173340d;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            String r109 = this.f173341e;
            if (r109 == null) goto L9;
            int r110 = r109.hashCode();
        L10:
            int r111 = (r108 + r110) * 31;
            b r112 = this.f173342f;
            if (r112 == null) goto L13;
            r103 = r112.hashCode();
        L13:
            int r113 = (r111 + r103) * 31;
            boolean r114 = this.f173343g;
            ?? r115 = r114;
            if (r114 == false) goto L17;
            r115 = 1;
        L17:
            return r113 + r115;
        L9:
            r110 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        public final String toString() {
            return "RouteEntry(token=" + this.f173337a + ", enterType=" + this.f173338b + ", enterTimeMs=" + this.f173339c + ", createdElapsedMs=" + this.f173340d + ", gestureType=" + this.f173341e + ", gestureSnapshot=" + this.f173342f + ", confirmed=" + this.f173343g + ")";
        }

        public e(long r100, String r101, long r102, long r103, String r104, b r110) {
            Intrinsics.checkNotNullParameter(r101, "enterType");
            Intrinsics.checkNotNullParameter(r104, "gestureType");
            this.f173337a = r100;
            this.f173338b = r101;
            this.f173339c = r102;
            this.f173340d = r103;
            this.f173341e = r104;
            this.f173342f = r110;
            this.f173343g = false;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f173344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f173345b;

        public f(a r100, long r101) {
            this.f173344a = r100;
            this.f173345b = r101;
        }

        public final void a() {
            this.f173344a.f173305j.remove(Long.valueOf(this.f173345b));
            a r100 = this.f173344a;
            d r101 = r100.f173298c;
            Iterator<T> r102 = r100.f173302g.iterator();
        L4:
            if (r102.hasNext() == false) goto L11;
            Object r103 = r102.next();
            if (((d) r103).f173323a != this.f173345b) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L4;
        L12:
            d r105 = (d) r103;
            if (r101 != null) goto L15;
            r101 = r105;
        L15:
            if (r101 != null) goto L17;
            return;
        L17:
            if (r101.f173335m == true) goto L19;
            return;
        L19:
            if (r101.f173336n == null) goto L21;
            return;
        L21:
            if (this.f173344a.f(r101) == false) goto L32;
            this.f173344a.e(r101, "no_action");
            return;
        L32:
            return;
        L8:
            r104 = false;
            goto L9
        L11:
            r103 = null;
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        Runnable r100 = this.f173306k;
        if (r100 == null) goto L5;
        this.f173303h.removeCallbacks(r100);
    L5:
        this.f173306k = null;
    }

    public final void c() {
        Iterator r100 = CollectionsKt.toList(this.f173302g).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a((d) r100.next());
        goto L4
    L6:
        ((ArrayList) this.f173302g).clear();
        ((LinkedHashMap) this.f173305j).clear();
        a(null);
        b();
        VelocityTracker r101 = this.f173299d;
        if (r101 == null) goto L9;
        r101.recycle();
    L9:
        this.f173299d = null;
        this.f173298c = null;
    }

    public static Map i(b r100) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("pre_drag_dx", Integer.valueOf(r100.f173313a)), TuplesKt.to("pre_drag_dy", Integer.valueOf(r100.f173314b)), TuplesKt.to("pre_user_gesture_result", r100.f173315c), TuplesKt.to("pre_user_scroll_degree_quadrant", r100.f173316d), TuplesKt.to("pre_user_drag_y_angle", Integer.valueOf(r100.f173318f)), TuplesKt.to("pre_user_drag_x_angle", Integer.valueOf(r100.f173317e)), TuplesKt.to("pre_user_scroll_velocity", Integer.valueOf(r100.f173319g))});
    }

    public final void a(d r100) {
        if (r100 != null) goto L4;
    L5:
        f r101 = this.f173304i;
        if (r101 == null) goto L8;
        this.f173303h.removeCallbacks(r101);
    L8:
        this.f173304i = null;
    L9:
        if (r100 != null) goto L15;
        Collection r102 = ((LinkedHashMap) this.f173305j).values();
        Handler r103 = this.f173303h;
        Iterator r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        r103.removeCallbacks((Runnable) r104.next());
        goto L12
    L14:
        ((LinkedHashMap) this.f173305j).clear();
        return;
    L15:
        Runnable r105 = this.f173305j.remove(Long.valueOf(r100.f173323a));
        if (r105 == null) goto L21;
        this.f173303h.removeCallbacks(r105);
        return;
    L21:
        return;
    L4:
        if (this.f173298c != r100) goto L9;
        goto L5
    }

    public final void d(MotionEvent r100) {
        d r101 = this.f173298c;
        if (r101 != null) goto L5;
        return;
    L5:
        VelocityTracker r102 = this.f173299d;
        if (r102 == null) goto L8;
        r102.addMovement(r100);
        r102.computeCurrentVelocity(1000);
        r101.f173333k = r102.getXVelocity();
        r101.f173334l = r102.getYVelocity();
    L8:
        VelocityTracker r103 = this.f173299d;
        if (r103 == null) goto L11;
        r103.recycle();
    L11:
        this.f173299d = null;
        r101.f173330h = System.currentTimeMillis();
        r101.f173331i = r100.getX();
        r101.f173332j = r100.getY();
        r101.f173335m = true;
        if (f(r101) == true) goto L16;
        this.f173298c = null;
        return;
    L16:
        if (this.f173311p == true) goto L18;
    L30:
        String r104 = r101.f173336n;
        if (r104 == null) goto L52;
        if (Intrinsics.areEqual(r104, "enter_detail") == false) goto L39;
        if (this.f173310o == true) goto L39;
        this.f173298c = null;
        return;
    L39:
        if (Intrinsics.areEqual(r104, "enter_detail") == false) goto L46;
        e r105 = this.f173301f;
        if (r105 == null) goto L46;
        if (r105.f173343g != true) goto L46;
        e(r101, r104);
    L46:
        if (Intrinsics.areEqual(r104, "switch_image") == false) goto L49;
        b();
        com.bytedance.android.shopping.deepfeed.event.b r106 = new com.bytedance.android.shopping.deepfeed.event.b(this, r101.f173323a);
        this.f173303h.postDelayed(r106, 500);
        Unit r107 = Unit.INSTANCE;
        this.f173306k = r106;
        goto L52
    L49:
        if ((true ^ Intrinsics.areEqual(r104, "enter_detail")) == false) goto L52;
        e(r101, r104);
    L52:
        if (this.f173298c == r101) goto L55;
        return;
    L55:
        if (r101.f173336n != null) goto L61;
        if (g(r101) == false) goto L61;
        ((ArrayList) this.f173302g).add(r101);
        this.f173298c = null;
        h(r101);
        return;
    L61:
        if (r101.f173336n != null) goto L64;
        h(r101);
        return;
    L64:
        return;
    L18:
        if ((!Intrinsics.areEqual(r101.f173324b, "info")) == true) goto L25;
        float r108 = r101.f173331i - r101.f173328f;
        float r109 = r101.f173332j - r101.f173329g;
        if (r108 >= (-this.f173307l)) goto L25;
        if (Math.abs(r108) <= Math.abs(r109)) goto L25;
        boolean r110 = true;
    L26:
        if (r110 == false) goto L30;
        if (this.f173312q.invoke(Integer.valueOf(r101.f173325c)).booleanValue() == false) goto L30;
        r101.f173336n = "enter_detail";
    L25:
        r110 = false;
        goto L26
    }

    public final boolean f(d r100) {
        if (Math.abs(r100.f173331i - r100.f173328f) <= this.f173307l) goto L5;
    L8:
        return true;
    L5:
        if (Math.abs(r100.f173332j - r100.f173329g) > this.f173307l) goto L8;
        return false;
    }

    public final boolean g(d r100) {
        float r101 = Math.abs(r100.f173331i - r100.f173328f);
        float r102 = Math.abs(r100.f173332j - r100.f173329g);
        if (r102 > this.f173307l) goto L5;
    L7:
        return false;
    L5:
        if (r102 < r101) goto L7;
        return true;
    }

    public final void h(d r100) {
        a(r100);
        long r101 = r100.f173323a;
        f r102 = new f(this, r101);
        if (this.f173298c != r100) goto L5;
        this.f173304i = r102;
    L6:
        this.f173303h.postDelayed(r102, 3000);
        return;
    L5:
        this.f173305j.put(Long.valueOf(r101), r102);
        goto L6
    }

    public final void e(d r210, String r211) {
        if (this.f173310o == true) goto L6;
        return;
    L6:
        if (this.f173298c != r210) goto L8;
    L10:
        a(r210);
        b();
        float r100 = r210.f173331i - r210.f173328f;
        float r101 = r210.f173332j - r210.f173329g;
        int r110 = MathKt.roundToInt(Math.abs(r100));
        int r111 = MathKt.roundToInt(Math.abs(r101));
        int r112 = MathKt.roundToInt(Math.toDegrees(Math.atan2(Math.abs(r101), Math.abs(r100))));
        int r113 = MathKt.roundToInt(Math.toDegrees(Math.atan2(Math.abs(r100), Math.abs(r101))));
        int r114 = MathKt.roundToInt(Math.hypot(r210.f173333k, r210.f173334l));
        if (r100 == 0.0f) goto L13;
    L15:
        float r102 = 0;
        if (r100 >= r102) goto L18;
    L20:
        if (r100 < r102) goto L25;
        if (r101 < r102) goto L25;
        int r103 = 2;
    L30:
        Integer r104 = r103;
    L31:
        Integer r115 = r104;
        b r105 = new b(r110, r111, r211, r104, r112, r113, r114);
        DeepFeedProductEventTracker r106 = this.f173309n.invoke();
        if (r106 == null) goto L40;
        Map<String, ? extends Object> r107 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("user_drag_area", r210.f173324b), TuplesKt.to("user_drag_position", Integer.valueOf(r210.f173325c)), TuplesKt.to("user_drag_time", Long.valueOf(r210.f173327e)), TuplesKt.to("user_drag_touch_x", Integer.valueOf(MathKt.roundToInt(r210.f173328f))), TuplesKt.to("user_drag_touch_y", Integer.valueOf(MathKt.roundToInt(r210.f173329g))), TuplesKt.to("user_drag_end_x", Integer.valueOf(MathKt.roundToInt(r210.f173331i))), TuplesKt.to("user_drag_end_y", Integer.valueOf(MathKt.roundToInt(r210.f173332j))), TuplesKt.to("user_drag_y_angle", Integer.valueOf(r113)), TuplesKt.to("user_drag_x_angle", Integer.valueOf(r112)), TuplesKt.to("user_scroll_velocity", Integer.valueOf(r114)), TuplesKt.to("user_scroll_degree_quadrant", r115), TuplesKt.to("user_gesture_result", r211), TuplesKt.to("user_drag_dx", Integer.valueOf(r110)), TuplesKt.to("user_drag_dy", Integer.valueOf(r111)), TuplesKt.to("user_scroll_duration_ms", Long.valueOf(RangesKt.coerceAtLeast(r210.f173330h - r210.f173327e, 0)))});
        b r108 = this.f173300e;
        if (r108 == null) goto L36;
        Map<? extends String, ? extends Object> r109 = i(r108);
    L37:
        if (r109 != null) goto L39;
        r109 = MapsKt.emptyMap();
    L39:
        r107.putAll(r109);
        Unit r116 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r107, "params");
        r106.doEventAction("ec_deep_feed_slide", r107);
        goto L40
    L36:
        r109 = null;
    L40:
        this.f173300e = r105;
        if (Intrinsics.areEqual(r211, "enter_detail") == false) goto L51;
        e r117 = this.f173301f;
        if (r117 == null) goto L51;
        if (Intrinsics.areEqual(r117.f173338b, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) == true) goto L48;
        r117 = null;
    L48:
        if (r117 == null) goto L51;
        r117.f173342f = r105;
    L51:
        if (this.f173298c != r210) goto L53;
        this.f173298c = null;
        return;
    L53:
        ((ArrayList) this.f173302g).remove(r210);
        return;
    L25:
        if (r100 < r102) goto L27;
    L29:
        r103 = 4;
        goto L30
    L27:
        if (r101 < r102) goto L29;
        r103 = 3;
        goto L30
    L18:
        if (r101 >= r102) goto L20;
        r103 = 1;
        goto L30
    L13:
        if (r101 != 0.0f) goto L15;
        r104 = null;
        goto L31
    L8:
        if (((ArrayList) this.f173302g).contains(r210) == true) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, Function2<? super Float, ? super Float, c> r101, Function0<? extends DeepFeedProductEventTracker> r102, boolean r103, boolean r104, Function1<? super Integer, Boolean> r105) {
        Intrinsics.checkNotNullParameter(r101, "targetResolver");
        Intrinsics.checkNotNullParameter(r102, "trackerProvider");
        Intrinsics.checkNotNullParameter(r105, "onInfoSwipeEnterDetail");
        this.f173307l = r100;
        this.f173308m = r101;
        this.f173309n = r102;
        this.f173310o = r103;
        this.f173311p = r104;
        this.f173312q = r105;
        this.f173302g = new ArrayList();
        this.f173303h = new Handler(Looper.getMainLooper());
        this.f173305j = new LinkedHashMap();
    }
}

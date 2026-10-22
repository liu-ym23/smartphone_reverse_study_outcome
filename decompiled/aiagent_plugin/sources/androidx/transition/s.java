package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class s implements Cloneable {
    private static ThreadLocal<androidx.b.a<Animator, a>> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f2854a = null;
    private static final o i = null;
    private ViewGroup B;
    private int C;
    private boolean D;
    private boolean E;
    private ArrayList<d> F;
    private ArrayList<Animator> G;
    private c H;
    private androidx.b.a<String, String> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private o f2855J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f2856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<Integer> f2857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<View> f2858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    v f2859e;
    boolean f;
    ArrayList<Animator> g;
    u h;
    private String j;
    private long k;
    private TimeInterpolator l;
    private ArrayList<String> m;
    private ArrayList<Class<?>> n;
    private ArrayList<Integer> o;
    private ArrayList<View> p;
    private ArrayList<Class<?>> q;
    private ArrayList<String> r;
    private ArrayList<Integer> s;
    private ArrayList<View> t;
    private ArrayList<Class<?>> u;
    private x v;
    private x w;
    private int[] x;
    private ArrayList<w> y;
    private ArrayList<w> z;

    /* JADX INFO: compiled from: Transition.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f2860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        w f2862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ao f2863d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        s f2864e;

        a(View r3, String r4, s r5, ao r6, w r7) {
            ao r8 = (ao) ZeusTransformUtils.wrapperContextForParams(r6, ao.class, "com.obric.aiagent.plugin");
            this.f2860a = r3;
            this.f2861b = r4;
            this.f2862c = r7;
            this.f2863d = r8;
            this.f2864e = r5;
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    private static class b {
        static <T> ArrayList<T> a(ArrayList<T> r1, T r2) {
            if (r1 != null) goto L5;
            r1 = new ArrayList();
        L5:
            if (r1.contains(r2) == true) goto L7;
            r1.add(r2);
        L7:
            return r1;
        }

        static <T> ArrayList<T> b(ArrayList<T> r0, T r1) {
            if (r0 == null) goto L7;
            r0.remove(r1);
            if (r0.isEmpty() == false) goto L8;
            return null;
        L8:
            return r0;
        L7:
            return r0;
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    public static abstract class c {
    }

    /* JADX INFO: compiled from: Transition.java */
    public interface d {
        void onTransitionCancel(s r1);

        void onTransitionEnd(s r1);

        void onTransitionPause(s r1);

        void onTransitionResume(s r1);

        void onTransitionStart(s r1);
    }

    public Animator a(ViewGroup r1, w r2, w r3) {
        return null;
    }

    public abstract void a(w r1);

    public String[] a() {
        return null;
    }

    public abstract void b(w r1);

    public /* synthetic */ Object clone() {
        return l();
    }

    static {
        f2854a = new int[]{2, 1, 3, 4};
        i = new AnonymousClass1();
        A = new ThreadLocal();
    }

    public s() {
        this.j = getClass().getName();
        this.k = -1;
        this.f2856b = -1;
        this.l = null;
        this.f2857c = new ArrayList();
        this.f2858d = new ArrayList();
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = new x();
        this.w = new x();
        this.f2859e = null;
        this.x = f2854a;
        this.B = null;
        this.f = false;
        this.g = new ArrayList();
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = null;
        this.G = new ArrayList();
        this.f2855J = i;
    }

    public s a(long r1) {
        this.f2856b = r1;
        return this;
    }

    public long b() {
        return this.f2856b;
    }

    public s b(long r1) {
        this.k = r1;
        return this;
    }

    public long c() {
        return this.k;
    }

    public s a(TimeInterpolator r3) {
        this.l = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, TimeInterpolator.class, "com.obric.aiagent.plugin");
        return this;
    }

    public TimeInterpolator d() {
        return this.l;
    }

    private void a(androidx.b.a<View, w> r6, androidx.b.a<View, w> r7) {
        int r0 = r6.size() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r6.b(r0), View.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        if (b(r1) == false) goto L13;
        w r2 = (w) ZeusTransformUtils.preCheckCast(r7.remove(r1), w.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L13;
        if (b(r2.f2870b) == false) goto L13;
        this.y.add((w) ZeusTransformUtils.preCheckCast(r6.d(r0), w.class, "com.obric.aiagent.plugin"));
        this.z.add(r2);
    L13:
        r0 = r0 - 1;
        goto L3
    }

    private void a(androidx.b.a<View, w> r9, androidx.b.a<View, w> r10, androidx.b.d<View> r11, androidx.b.d<View> r12) {
        int r0 = r11.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r11.c(r1), View.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L16;
        if (b(r2) == false) goto L16;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r12.a(r11.b(r1)), View.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        if (b(r3) == false) goto L16;
        w r5 = (w) ZeusTransformUtils.preCheckCast(r9.get(r2), w.class, "com.obric.aiagent.plugin");
        w r4 = (w) ZeusTransformUtils.preCheckCast(r10.get(r3), w.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        if (r4 == null) goto L16;
        this.y.add(r5);
        this.z.add(r4);
        r9.remove(r2);
        r10.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void a(androidx.b.a<View, w> r9, androidx.b.a<View, w> r10, SparseArray<View> r11, SparseArray<View> r12) {
        int r0 = r11.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r11.valueAt(r1), View.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L16;
        if (b(r2) == false) goto L16;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r12.get(r11.keyAt(r1)), View.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        if (b(r3) == false) goto L16;
        w r5 = (w) ZeusTransformUtils.preCheckCast(r9.get(r2), w.class, "com.obric.aiagent.plugin");
        w r4 = (w) ZeusTransformUtils.preCheckCast(r10.get(r3), w.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        if (r4 == null) goto L16;
        this.y.add(r5);
        this.z.add(r4);
        r9.remove(r2);
        r10.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void a(androidx.b.a<View, w> r9, androidx.b.a<View, w> r10, androidx.b.a<String, View> r11, androidx.b.a<String, View> r12) {
        int r0 = r11.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r11.c(r1), View.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L16;
        if (b(r2) == false) goto L16;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r12.get(r11.b(r1)), View.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        if (b(r3) == false) goto L16;
        w r5 = (w) ZeusTransformUtils.preCheckCast(r9.get(r2), w.class, "com.obric.aiagent.plugin");
        w r4 = (w) ZeusTransformUtils.preCheckCast(r10.get(r3), w.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        if (r4 == null) goto L16;
        this.y.add(r5);
        this.z.add(r4);
        r9.remove(r2);
        r10.remove(r3);
    L16:
        r1 = r1 + 1;
        goto L3
    }

    private void b(androidx.b.a<View, w> r7, androidx.b.a<View, w> r8) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= r7.size()) goto L10;
        w r2 = (w) ZeusTransformUtils.preCheckCast(r7.c(r1), w.class, "com.obric.aiagent.plugin");
        if (b(r2.f2870b) == false) goto L8;
        this.y.add(r2);
        this.z.add(null);
    L8:
        r1 = r1 + 1;
    L10:
        if (r0 >= r8.size()) goto L15;
        w r9 = (w) ZeusTransformUtils.preCheckCast(r8.c(r0), w.class, "com.obric.aiagent.plugin");
        if (b(r9.f2870b) == false) goto L14;
        this.z.add(r9);
        this.y.add(null);
    L14:
        r0 = r0 + 1;
        goto L10
    }

    private void a(x r6, x r7) {
        androidx.b.a<View, w> r0 = new androidx.b.a(r6.f2872a);
        androidx.b.a<View, w> r1 = new androidx.b.a(r7.f2872a);
        int r2 = 0;
    L3:
        int[] r3 = this.x;
        if (r2 >= r3.length) goto L19;
        int r4 = r3[r2];
        if (r4 != 1) goto L8;
        a(r0, r1);
    L18:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4 != 2) goto L10;
        a(r0, r1, r6.f2875d, r7.f2875d);
        goto L18
    L10:
        if (r4 != 3) goto L12;
        a(r0, r1, r6.f2873b, r7.f2873b);
        goto L18
    L12:
        if (r4 != 4) goto L18;
        a(r0, r1, r6.f2874c, r7.f2874c);
        goto L18
    L19:
        b(r0, r1);
    }

    public void a(ViewGroup r22, x r23, x r24, ArrayList<w> r25, ArrayList<w> r26) {
        androidx.b.a<Animator, a> r8 = n();
        SparseIntArray r9 = new SparseIntArray();
        int r10 = r25.size();
        long r0 = Long.MAX_VALUE;
        int r12 = 0;
    L4:
        if (r12 >= r10) goto L65;
        w r3 = (w) ZeusTransformUtils.preCheckCast(r25.get(r12), w.class, "com.obric.aiagent.plugin");
        w r4 = (w) ZeusTransformUtils.preCheckCast(r26.get(r12), w.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L8;
    L10:
        if (r4 != null) goto L12;
    L14:
        if (r3 != null) goto L17;
        if (r4 != null) goto L17;
    L16:
        int r16 = r10;
        int r18 = r12;
        long r11 = r0;
    L64:
        r0 = r11;
        r12 = r18 + 1;
        r10 = r16;
    L17:
        if (r3 == null) goto L23;
        if (r4 == null) goto L23;
        if (a(r3, r4) == true) goto L23;
        boolean r15 = false;
    L24:
        if (r15 == false) goto L16;
        Animator r17 = a(r22, r3, r4);
        if (r17 == null) goto L16;
        if (r4 == null) goto L56;
        View r5 = r4.f2870b;
        String[] r13 = a();
        if (r13 == null) goto L53;
        r16 = r10;
        if (r13.length <= 0) goto L54;
        w r14 = new w(r5);
        w r19 = (w) ZeusTransformUtils.preCheckCast(r24.f2872a.get(r5), w.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L39;
        int r110 = 0;
    L36:
        if (r110 >= r13.length) goto L38;
        int r111 = r12;
        long r112 = r0;
        r14.f2869a.put(r13[r110], r19.f2869a.get(r13[r110]));
        r110 = r110 + 1;
        r12 = r111;
        r0 = r112;
        goto L36
    L38:
        r0 = r0;
        r18 = r12;
    L40:
        int r1 = r8.size();
        int r2 = 0;
    L41:
        if (r2 >= r1) goto L55;
        a r113 = (a) ZeusTransformUtils.preCheckCast(r8.get((Animator) ZeusTransformUtils.preCheckCast(r8.b(r2), Animator.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin");
        if (r113.f2862c == null) goto L51;
        if (r113.f2860a != r5) goto L51;
        if (r113.f2861b.equals(m()) == false) goto L51;
        if (r113.f2862c.equals(r14) == false) goto L51;
        r17 = null;
    L51:
        r2 = r2 + 1;
    L55:
        View r6 = r5;
        w r7 = r14;
        r17 = r17;
    L57:
        if (r17 == null) goto L63;
        u r20 = this.h;
        if (r20 == null) goto L61;
        long r21 = r20.a(r22, this, r3, r4);
        r9.put(this.G.size(), (int) r21);
        r11 = Math.min(r21, r0);
    L62:
        r8.put(r17, new a(r6, m(), this, af.b(r22), r7));
        this.G.add(r17);
        goto L64
    L61:
        r11 = r0;
        goto L62
    L63:
        r11 = r0;
        goto L64
    L39:
        r0 = r0;
        r18 = r12;
    L54:
        r18 = r12;
        r17 = r17;
        r14 = null;
        goto L55
    L53:
        r16 = r10;
        goto L54
    L56:
        r0 = r0;
        r16 = r10;
        r18 = r12;
        r6 = r3.f2870b;
        r7 = null;
    L23:
        r15 = true;
        goto L24
    L12:
        if (r4.f2871c.contains(this) == true) goto L14;
        r4 = null;
        goto L14
    L8:
        if (r3.f2871c.contains(this) == true) goto L10;
        r3 = null;
        goto L10
    L65:
        long r114 = r0;
        if (r9.size() == 0) goto L71;
        int r27 = 0;
    L69:
        if (r27 >= r9.size()) goto L84;
        int r28 = r9.keyAt(r27);
        Animator r29 = (Animator) ZeusTransformUtils.preCheckCast(this.G.get(r28), Animator.class, "com.obric.aiagent.plugin");
        r29.setStartDelay((((long) r9.valueAt(r27)) - r114) + r29.getStartDelay());
        r27 = r27 + 1;
        goto L69
    L84:
        return;
    }

    boolean b(View r8) {
        int r0 = r8.getId();
        ArrayList<Integer> r1 = this.o;
        if (r1 != null) goto L5;
    L7:
        ArrayList<View> r2 = this.p;
        if (r2 != null) goto L10;
    L12:
        ArrayList<Class<?>> r3 = this.q;
        if (r3 == null) goto L21;
        int r4 = r3.size();
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L21;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(this.q.get(r5), Class.class, "com.obric.aiagent.plugin"), r8) == true) goto L18;
        r5 = r5 + 1;
        goto L15
    L18:
        return false;
    L21:
        if (this.r == null) goto L28;
        if (ViewCompat.s(r8) == null) goto L28;
        if (this.r.contains(ViewCompat.s(r8)) == false) goto L28;
        return false;
    L28:
        if (this.f2857c.size() != 0) goto L41;
        if (this.f2858d.size() != 0) goto L41;
        ArrayList<Class<?>> r6 = this.n;
        if (r6 != null) goto L34;
    L35:
        ArrayList<String> r7 = this.m;
        if (r7 != null) goto L38;
    L39:
        return true;
    L38:
        if (r7.isEmpty() == false) goto L41;
    L34:
        if (r6.isEmpty() == true) goto L35;
    L41:
        if (this.f2857c.contains(Integer.valueOf(r0)) == false) goto L43;
    L60:
        return true;
    L43:
        if (this.f2858d.contains(r8) == true) goto L60;
        ArrayList<String> r9 = this.m;
        if (r9 == null) goto L51;
        if (r9.contains(ViewCompat.s(r8)) == false) goto L51;
        return true;
    L51:
        if (this.n == null) goto L59;
        int r10 = 0;
    L54:
        if (r10 >= this.n.size()) goto L59;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(this.n.get(r10), Class.class, "com.obric.aiagent.plugin"), r8) == true) goto L57;
        r10 = r10 + 1;
        goto L54
    L57:
        return true;
    L59:
        return false;
    L10:
        if (r2.contains(r8) == false) goto L12;
        return false;
    L5:
        if (r1.contains(Integer.valueOf(r0)) == false) goto L7;
        return false;
    }

    private static androidx.b.a<Animator, a> n() {
        androidx.b.a<Animator, a> r0 = (androidx.b.a) ZeusTransformUtils.preCheckCast(A.get(), androidx.b.a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        androidx.b.a<Animator, a> r1 = new androidx.b.a();
        A.set(r1);
        return r1;
    L6:
        return r0;
    }

    public void e() {
        f();
        androidx.b.a<Animator, a> r0 = n();
        Iterator<Animator> r1 = this.G.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1.next(), Animator.class, "com.obric.aiagent.plugin");
        if (r0.containsKey(r2) == false) goto L4;
        f();
        a(r2, r0);
        goto L4
    L8:
        this.G.clear();
        g();
    }

    private void a(Animator r2, final androidx.b.a<Animator, a> r3) {
        if (r2 == null) goto L5;
        r2.addListener(new Transition$2(this, r3));
        a(r2);
        return;
    }

    public s a(View r2, boolean r3) {
        this.p = a(this.p, r2, r3);
        return this;
    }

    private ArrayList<View> a(ArrayList<View> r1, View r2, boolean r3) {
        if (r2 == null) goto L7;
        if (r3 == false) goto L6;
        return b.a(r1, r2);
    L6:
        return b.b(r1, r2);
    L7:
        return r1;
    }

    void a(ViewGroup r7, boolean r8) {
        a(r8);
        int r1 = 0;
        if (this.f2857c.size() <= 0) goto L5;
    L6:
        ArrayList<String> r0 = this.m;
        if (r0 != null) goto L9;
    L10:
        ArrayList<Class<?>> r2 = this.n;
        if (r2 != null) goto L13;
    L16:
        int r3 = 0;
    L18:
        if (r3 >= this.f2857c.size()) goto L30;
        View r4 = r7.findViewById(((Integer) ZeusTransformUtils.preCheckCast(this.f2857c.get(r3), Integer.class, "com.obric.aiagent.plugin")).intValue());
        if (r4 == null) goto L29;
        w r5 = new w(r4);
        if (r8 == false) goto L24;
        a(r5);
    L25:
        r5.f2871c.add(this);
        c(r5);
        if (r8 == false) goto L28;
        a(this.v, r4, r5);
        goto L29
    L28:
        a(this.w, r4, r5);
        goto L29
    L24:
        b(r5);
    L29:
        r3 = r3 + 1;
        goto L18
    L30:
        int r9 = 0;
    L32:
        if (r9 >= this.f2858d.size()) goto L42;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.f2858d.get(r9), View.class, "com.obric.aiagent.plugin");
        w r10 = new w(r6);
        if (r8 == false) goto L36;
        a(r10);
    L37:
        r10.f2871c.add(this);
        c(r10);
        if (r8 == false) goto L40;
        a(this.v, r6, r10);
    L41:
        r9 = r9 + 1;
        goto L32
    L40:
        a(this.w, r6, r10);
        goto L41
    L36:
        b(r10);
    L42:
        if (r8 == true) goto L53;
        androidx.b.a<String, String> r11 = this.I;
        if (r11 == null) goto L65;
        int r12 = r11.size();
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L46:
        if (r14 >= r12) goto L48;
        r13.add(this.v.f2875d.remove((String) ZeusTransformUtils.preCheckCast(this.I.b(r14), String.class, "com.obric.aiagent.plugin")));
        r14 = r14 + 1;
    L48:
        if (r1 >= r12) goto L66;
        View r15 = (View) ZeusTransformUtils.preCheckCast(r13.get(r1), View.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L52;
        this.v.f2875d.put((String) ZeusTransformUtils.preCheckCast(this.I.c(r1), String.class, "com.obric.aiagent.plugin"), r15);
    L52:
        r1 = r1 + 1;
        goto L48
    L66:
        return;
    L65:
        return;
    L53:
        return;
    L13:
        if (r2.isEmpty() == true) goto L16;
    L15:
        d(r7, r8);
        goto L42
    L9:
        if (r0.isEmpty() == false) goto L15;
    L5:
        if (this.f2858d.size() <= 0) goto L15;
        goto L6
    }

    private static void a(x r5, View r6, w r7) {
        r5.f2872a.put(r6, r7);
        int r8 = r6.getId();
        if (r8 >= 0) goto L5;
    L8:
        String r9 = ViewCompat.s(r6);
        if (r9 == null) goto L15;
        if (r5.f2875d.containsKey(r9) == false) goto L13;
        r5.f2875d.put(r9, null);
        goto L15
    L13:
        r5.f2875d.put(r9, r6);
    L15:
        if (ZeusTransformUtils.instanceOf(r6.getParent(), ListView.class) == false) goto L25;
        ListView r10 = (ListView) ZeusTransformUtils.preCheckCast(r6.getParent(), ListView.class, "com.obric.aiagent.plugin");
        if (r10.getAdapter().hasStableIds() == false) goto L26;
        long r3 = r10.getItemIdAtPosition(r10.getPositionForView(r6));
        if (r5.f2874c.c(r3) < 0) goto L23;
        View r11 = (View) ZeusTransformUtils.preCheckCast(r5.f2874c.a(r3), View.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L27;
        ViewCompat.a(r11, false);
        r5.f2874c.b(r3, null);
        return;
    L27:
        return;
    L23:
        ViewCompat.a(r6, true);
        r5.f2874c.b(r3, r6);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r5.f2873b.indexOfKey(r8) < 0) goto L7;
        r5.f2873b.put(r8, null);
        goto L8
    L7:
        r5.f2873b.put(r8, r6);
        goto L8
    }

    void a(boolean r1) {
        if (r1 == false) goto L4;
        this.v.f2872a.clear();
        this.v.f2873b.clear();
        this.v.f2874c.d();
        return;
    L4:
        this.w.f2872a.clear();
        this.w.f2873b.clear();
        this.w.f2874c.d();
    }

    private void d(View r8, boolean r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r0 = r8.getId();
        ArrayList<Integer> r1 = this.o;
        if (r1 != null) goto L7;
    L9:
        ArrayList<View> r2 = this.p;
        if (r2 != null) goto L12;
    L14:
        ArrayList<Class<?>> r3 = this.q;
        int r4 = 0;
        if (r3 == null) goto L23;
        int r5 = r3.size();
        int r6 = 0;
    L17:
        if (r6 >= r5) goto L23;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(this.q.get(r6), Class.class, "com.obric.aiagent.plugin"), r8) == true) goto L20;
        r6 = r6 + 1;
        goto L17
    L20:
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r8.getParent(), ViewGroup.class) == false) goto L33;
        w r7 = new w(r8);
        if (r9 == false) goto L27;
        a(r7);
    L28:
        r7.f2871c.add(this);
        c(r7);
        if (r9 == false) goto L31;
        a(this.v, r8, r7);
        goto L33
    L31:
        a(this.w, r8, r7);
        goto L33
    L27:
        b(r7);
    L33:
        if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == false) goto L56;
        ArrayList<Integer> r10 = this.s;
        if (r10 != null) goto L37;
    L39:
        ArrayList<View> r11 = this.t;
        if (r11 != null) goto L42;
    L44:
        ArrayList<Class<?>> r12 = this.u;
        if (r12 == null) goto L52;
        int r13 = r12.size();
        int r14 = 0;
    L47:
        if (r14 >= r13) goto L52;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(this.u.get(r14), Class.class, "com.obric.aiagent.plugin"), r8) == true) goto L50;
        r14 = r14 + 1;
        goto L47
    L50:
        return;
    L52:
        ViewGroup r15 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin");
    L54:
        if (r4 >= r15.getChildCount()) goto L62;
        d(r15.getChildAt(r4), r9);
        r4 = r4 + 1;
        goto L54
    L62:
        return;
    L42:
        if (r11.contains(r8) == false) goto L44;
        return;
    L37:
        if (r10.contains(Integer.valueOf(r0)) == false) goto L39;
        return;
    L56:
        return;
    L12:
        if (r2.contains(r8) == false) goto L14;
        return;
    L7:
        if (r1.contains(Integer.valueOf(r0)) == false) goto L9;
    }

    public w b(View r2, boolean r3) {
        v r0 = this.f2859e;
        if (r0 != null) goto L5;
        if (r3 == false) goto L8;
        x r1 = this.v;
    L10:
        return (w) ZeusTransformUtils.preCheckCast(r1.f2872a.get(r2), w.class, "com.obric.aiagent.plugin");
    L8:
        r1 = this.w;
        goto L10
    L5:
        return r0.b(r2, r3);
    }

    w c(View r9, boolean r10) {
        v r0 = this.f2859e;
        if (r0 != null) goto L5;
        if (r10 == false) goto L8;
        ArrayList<w> r1 = this.y;
    L10:
        if (r1 != null) goto L12;
        return null;
    L12:
        int r2 = r1.size();
        int r3 = -1;
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L22;
        w r6 = (w) ZeusTransformUtils.preCheckCast(r1.get(r4), w.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L17;
        if (r6.f2870b == r9) goto L20;
        r4 = r4 + 1;
        goto L14
    L20:
        r3 = r4;
        goto L22
    L17:
        return null;
    L22:
        if (r3 < 0) goto L31;
        if (r10 == false) goto L25;
        ArrayList<w> r8 = this.z;
    L27:
        return (w) ZeusTransformUtils.preCheckCast(r8.get(r3), w.class, "com.obric.aiagent.plugin");
    L25:
        r8 = this.y;
        goto L27
    L31:
        return null;
    L8:
        r1 = this.z;
        goto L10
    L5:
        return r0.c(r9, r10);
    }

    public void c(View r7) {
        if (this.E == true) goto L27;
        androidx.b.a<Animator, a> r0 = n();
        int r1 = r0.size();
        ao r8 = af.b(r7);
        int r2 = r1 - 1;
    L6:
        if (r2 < 0) goto L13;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r0.c(r2), a.class, "com.obric.aiagent.plugin");
        if (r4.f2860a == null) goto L12;
        if (r8.equals(r4.f2863d) == false) goto L12;
        androidx.transition.a.a((Animator) ZeusTransformUtils.preCheckCast(r0.b(r2), Animator.class, "com.obric.aiagent.plugin"));
    L12:
        r2 = r2 - 1;
        goto L6
    L13:
        ArrayList<d> r9 = this.F;
        if (r9 != null) goto L16;
    L20:
        this.D = true;
        return;
    L16:
        if (r9.size() <= 0) goto L20;
        ArrayList r10 = (ArrayList) ZeusTransformUtils.preCheckCast(this.F.clone(), ArrayList.class, "com.obric.aiagent.plugin");
        int r3 = r10.size();
        int r5 = 0;
    L18:
        if (r5 >= r3) goto L20;
        ((d) ZeusTransformUtils.preCheckCast(r10.get(r5), d.class, "com.obric.aiagent.plugin")).onTransitionPause(this);
        r5 = r5 + 1;
        goto L18
    }

    public void d(View r7) {
        if (this.D == true) goto L5;
        return;
    L5:
        if (this.E == true) goto L22;
        androidx.b.a<Animator, a> r0 = n();
        int r2 = r0.size();
        ao r8 = af.b(r7);
    L7:
        r2 = r2 - 1;
        if (r2 < 0) goto L15;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r0.c(r2), a.class, "com.obric.aiagent.plugin");
        if (r4.f2860a == null) goto L7;
        if (r8.equals(r4.f2863d) == false) goto L7;
        androidx.transition.a.b((Animator) ZeusTransformUtils.preCheckCast(r0.b(r2), Animator.class, "com.obric.aiagent.plugin"));
        goto L7
    L15:
        ArrayList<d> r9 = this.F;
        if (r9 == null) goto L22;
        if (r9.size() <= 0) goto L22;
        ArrayList r10 = (ArrayList) ZeusTransformUtils.preCheckCast(this.F.clone(), ArrayList.class, "com.obric.aiagent.plugin");
        int r1 = r10.size();
        int r3 = 0;
    L20:
        if (r3 >= r1) goto L22;
        ((d) ZeusTransformUtils.preCheckCast(r10.get(r3), d.class, "com.obric.aiagent.plugin")).onTransitionResume(this);
        r3 = r3 + 1;
    L22:
        this.D = false;
    }

    void a(ViewGroup r12) {
        this.y = new ArrayList();
        this.z = new ArrayList();
        a(this.v, this.w);
        androidx.b.a<Animator, a> r0 = n();
        int r1 = r0.size();
        ao r2 = af.b(r12);
        int r3 = r1 - 1;
    L3:
        if (r3 < 0) goto L31;
        Animator r4 = (Animator) ZeusTransformUtils.preCheckCast(r0.b(r3), Animator.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L30;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r0.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L30;
        if (r5.f2860a == null) goto L30;
        if (r2.equals(r5.f2863d) == false) goto L30;
        w r7 = r5.f2862c;
        View r8 = r5.f2860a;
        w r9 = b(r8, true);
        w r10 = c(r8, true);
        if (r9 != null) goto L16;
        if (r10 != null) goto L16;
        r10 = (w) ZeusTransformUtils.preCheckCast(this.w.f2872a.get(r8), w.class, "com.obric.aiagent.plugin");
    L16:
        if (r9 != null) goto L19;
        if (r10 != null) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L30;
        if (r4.isRunning() == false) goto L26;
    L29:
        r4.cancel();
        goto L30
    L26:
        if (r4.isStarted() == true) goto L29;
        r0.remove(r4);
    L19:
        if (r5.f2864e.a(r7, r10) == false) goto L21;
        r6 = true;
    L30:
        r3 = r3 - 1;
        goto L3
    L31:
        a(r12, this.v, this.w, this.y, this.z);
        e();
    }

    public boolean a(w r6, w r7) {
        if (r6 == null) goto L25;
        if (r7 == null) goto L26;
        String[] r5 = a();
        if (r5 == null) goto L13;
        int r2 = r5.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L27;
        if (a(r6, r7, r5[r3]) == true) goto L19;
        r3 = r3 + 1;
    L19:
        return true;
    L27:
        return false;
    L13:
        Iterator<String> r8 = r6.f2869a.keySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L28;
        if (a(r6, r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L15;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    private static boolean a(w r0, w r1, String r2) {
        Object r3 = r0.f2869a.get(r2);
        Object r4 = r1.f2869a.get(r2);
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r3 == null) goto L12;
        if (r4 != null) goto L10;
        return true;
    L10:
        return true ^ r3.equals(r4);
    L12:
        return true;
    }

    public void a(Animator r5) {
        if (r5 != null) goto L5;
        g();
        return;
    L5:
        if (b() < 0) goto L8;
        r5.setDuration(b());
    L8:
        if (c() < 0) goto L11;
        r5.setStartDelay(c() + r5.getStartDelay());
    L11:
        if (d() == null) goto L13;
        r5.setInterpolator(d());
    L13:
        r5.addListener(new Transition$3(this));
        r5.start();
    }

    public void f() {
        if (this.C != 0) goto L12;
        ArrayList<d> r0 = this.F;
        if (r0 != null) goto L7;
    L11:
        this.E = false;
        goto L12
    L7:
        if (r0.size() <= 0) goto L11;
        ArrayList r1 = (ArrayList) ZeusTransformUtils.preCheckCast(this.F.clone(), ArrayList.class, "com.obric.aiagent.plugin");
        int r2 = r1.size();
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L11;
        ((d) ZeusTransformUtils.preCheckCast(r1.get(r4), d.class, "com.obric.aiagent.plugin")).onTransitionStart(this);
        r4 = r4 + 1;
    L12:
        this.C++;
    }

    public void g() {
        int r0 = this.C - 1;
        this.C = r0;
        if (r0 != 0) goto L34;
        ArrayList<d> r1 = this.F;
        if (r1 != null) goto L7;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= this.v.f2874c.b()) goto L18;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.v.f2874c.c(r2), View.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L17;
        ViewCompat.a(r4, false);
    L17:
        r2 = r2 + 1;
        goto L13
    L18:
        int r3 = 0;
    L20:
        if (r3 >= this.w.f2874c.b()) goto L25;
        View r5 = (View) ZeusTransformUtils.preCheckCast(this.w.f2874c.c(r3), View.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L24;
        ViewCompat.a(r5, false);
    L24:
        r3 = r3 + 1;
        goto L20
    L25:
        this.E = true;
        return;
    L7:
        if (r1.size() <= 0) goto L11;
        ArrayList r6 = (ArrayList) ZeusTransformUtils.preCheckCast(this.F.clone(), ArrayList.class, "com.obric.aiagent.plugin");
        int r7 = r6.size();
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L11;
        ((d) ZeusTransformUtils.preCheckCast(r6.get(r8), d.class, "com.obric.aiagent.plugin")).onTransitionEnd(this);
        r8 = r8 + 1;
        goto L9
    }

    public void h() {
        int r0 = this.g.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        ((Animator) ZeusTransformUtils.preCheckCast(this.g.get(r0), Animator.class, "com.obric.aiagent.plugin")).cancel();
        goto L3
    L6:
        ArrayList<d> r1 = this.F;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.size() <= 0) goto L16;
        ArrayList r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.F.clone(), ArrayList.class, "com.obric.aiagent.plugin");
        int r3 = r2.size();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L17;
        ((d) ZeusTransformUtils.preCheckCast(r2.get(r4), d.class, "com.obric.aiagent.plugin")).onTransitionCancel(this);
        r4 = r4 + 1;
        goto L11
    L17:
        return;
    }

    public s a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if (this.F != null) goto L5;
        this.F = new ArrayList();
    L5:
        this.F.add(r4);
        return this;
    }

    public s b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        ArrayList<d> r0 = this.F;
        if (r0 != null) goto L5;
        return this;
    L5:
        r0.remove(r4);
        if (this.F.size() != 0) goto L8;
        this.F = null;
    L8:
        return this;
    }

    public void a(o r1) {
        if (r1 != null) goto L4;
        this.f2855J = i;
        return;
    L4:
        this.f2855J = r1;
    }

    public o i() {
        return this.f2855J;
    }

    public void a(c r1) {
        this.H = r1;
    }

    public c j() {
        return this.H;
    }

    public void a(u r1) {
        this.h = r1;
    }

    public u k() {
        return this.h;
    }

    void c(w r6) {
        if (this.h != null) goto L5;
        return;
    L5:
        if (r6.f2869a.isEmpty() == true) goto L23;
        String[] r0 = this.h.a();
        if (r0 != null) goto L9;
        return;
    L9:
        boolean r1 = false;
        int r2 = 0;
    L11:
        if (r2 >= r0.length) goto L16;
        if (r6.f2869a.containsKey(r0[r2]) == false) goto L17;
        r2 = r2 + 1;
    L17:
        if (r1 == true) goto L24;
        this.h.a(r6);
        return;
    L24:
        return;
    L16:
        r1 = true;
        goto L17
    }

    public String toString() {
        return a("");
    }

    public s l() {
        s r3 = (s) ZeusTransformUtils.preCheckCast(super.clone(), s.class, "com.obric.aiagent.plugin");     // Catch: CloneNotSupportedException -> L5
        r3.G = new ArrayList();     // Catch: CloneNotSupportedException -> L5
        r3.v = new x();     // Catch: CloneNotSupportedException -> L5
        r3.w = new x();     // Catch: CloneNotSupportedException -> L5
        r3.y = null;     // Catch: CloneNotSupportedException -> L5
        r3.z = null;     // Catch: CloneNotSupportedException -> L5
        return r3;
    L5:
        return null;
    }

    public String m() {
        return this.j;
    }

    String a(String r7) {
        String r8 = r7 + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2856b == (-1)) goto L6;
        r8 = r8 + "dur(" + this.f2856b + ") ";
    L6:
        if (this.k == (-1)) goto L9;
        r8 = r8 + "dly(" + this.k + ") ";
    L9:
        if (this.l == null) goto L12;
        r8 = r8 + "interp(" + this.l + ") ";
    L12:
        if (this.f2857c.size() <= 0) goto L14;
    L15:
        String r9 = r8 + "tgts(";
        int r2 = 0;
        if (this.f2857c.size() <= 0) goto L24;
        int r0 = 0;
    L19:
        if (r0 >= this.f2857c.size()) goto L24;
        if (r0 <= 0) goto L22;
        r9 = r9 + ", ";
    L22:
        r9 = r9 + this.f2857c.get(r0);
        r0 = r0 + 1;
    L24:
        if (this.f2858d.size() <= 0) goto L31;
    L26:
        if (r2 >= this.f2858d.size()) goto L31;
        if (r2 <= 0) goto L29;
        r9 = r9 + ", ";
    L29:
        r9 = r9 + this.f2858d.get(r2);
        r2 = r2 + 1;
    L31:
        return r9 + ")";
    L14:
        if (this.f2858d.size() > 0) goto L15;
        return r8;
    }
}

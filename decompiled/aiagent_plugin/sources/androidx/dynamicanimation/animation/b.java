package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.dynamicanimation.animation.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: DynamicAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends b<T>> implements androidx.dynamicanimation.animation.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f1590b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f1591c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f1592d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f1593e = null;
    public static final d f = null;
    public static final d g = null;
    public static final d h = null;
    public static final d i = null;
    public static final d j = null;
    public static final d k = null;
    public static final d l = null;
    public static final d m = null;
    public static final d n = null;
    float o;
    float p;
    boolean q;
    final Object r;
    final androidx.dynamicanimation.animation.c s;
    boolean t;
    float u;
    float v;
    private long w;
    private float x;
    private final ArrayList<InterfaceC0048b> y;
    private final ArrayList<c> z;

    /* JADX INFO: compiled from: DynamicAnimation.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f1594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f1595b;

        a() {
        }
    }

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DynamicAnimation.java */
    public interface InterfaceC0048b {
        void a(b r1, boolean r2, float r3, float r4);
    }

    /* JADX INFO: compiled from: DynamicAnimation.java */
    public interface c {
        void a(b r1, float r2, float r3);
    }

    /* JADX INFO: compiled from: DynamicAnimation.java */
    public static abstract class d extends androidx.dynamicanimation.animation.c<View> {
        /* synthetic */ d(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        private d(String r1) {
            super(r1);
        }
    }

    abstract boolean a(float r1, float r2);

    abstract boolean b(long r1);

    static {
        final String r1 = "translationX";
        f1589a = new AnonymousClass1(r1);
        final String r2 = "translationY";
        f1590b = new AnonymousClass7(r2);
        final String r3 = "translationZ";
        f1591c = new AnonymousClass8(r3);
        final String r4 = "scaleX";
        f1592d = new AnonymousClass9(r4);
        final String r5 = "scaleY";
        f1593e = new AnonymousClass10(r5);
        final String r6 = "rotation";
        f = new AnonymousClass11(r6);
        final String r7 = "rotationX";
        g = new AnonymousClass12(r7);
        final String r8 = "rotationY";
        h = new AnonymousClass13(r8);
        final String r9 = "x";
        i = new AnonymousClass14(r9);
        final String r10 = "y";
        j = new AnonymousClass2(r10);
        final String r11 = "z";
        k = new AnonymousClass3(r11);
        final String r12 = "alpha";
        l = new AnonymousClass4(r12);
        final String r13 = "scrollX";
        m = new AnonymousClass5(r13);
        final String r14 = "scrollY";
        n = new AnonymousClass6(r14);
    }

    <K> b(K r3, androidx.dynamicanimation.animation.c<K> r4) {
        this.o = 0.0f;
        this.p = Float.MAX_VALUE;
        this.q = false;
        this.t = false;
        this.u = Float.MAX_VALUE;
        this.v = -Float.MAX_VALUE;
        this.w = 0;
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.r = r3;
        this.s = r4;
        if (r4 != f) goto L5;
    L19:
        this.x = 0.1f;
        return;
    L5:
        if (r4 == g) goto L19;
        if (r4 == h) goto L19;
        if (r4 != l) goto L13;
        this.x = 0.00390625f;
        return;
    L13:
        if (r4 != f1592d) goto L15;
    L18:
        this.x = 0.00390625f;
        return;
    L15:
        if (r4 == f1593e) goto L18;
        this.x = 1.0f;
    }

    public T a(float r1) {
        this.p = r1;
        this.q = true;
        return this;
    }

    public T a(InterfaceC0048b r3) {
        InterfaceC0048b r4 = (InterfaceC0048b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0048b.class, "com.obric.aiagent.plugin");
        if (this.y.contains(r4) == true) goto L5;
        this.y.add(r4);
    L5:
        return this;
    }

    public void b(InterfaceC0048b r3) {
        InterfaceC0048b r4 = (InterfaceC0048b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0048b.class, "com.obric.aiagent.plugin");
        a(this.y, r4);
    }

    private static <T> void a(ArrayList<T> r2) {
        int r0 = r2.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r2.get(r0) != null) goto L7;
        r2.remove(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    private static <T> void a(ArrayList<T> r1, T r2) {
        int r3 = r1.indexOf(r2);
        if (r3 < 0) goto L6;
        r1.set(r3, null);
        return;
    }

    public void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.t == true) goto L10;
        d();
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public boolean b() {
        return this.t;
    }

    private void d() {
        if (this.t == true) goto L14;
        this.t = true;
        if (this.q == true) goto L7;
        this.p = e();
    L7:
        float r0 = this.p;
        if (r0 > this.u) goto L13;
        if (r0 < this.v) goto L13;
        androidx.dynamicanimation.animation.a.a().a(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    @Override // androidx.dynamicanimation.animation.a.b
    public boolean a(long r5) {
        long r0 = this.w;
        if (r0 != 0) goto L6;
        this.w = r5;
        b(this.p);
        return false;
    L6:
        this.w = r5;
        boolean r6 = b(r5 - r0);
        float r7 = Math.min(this.p, this.u);
        this.p = r7;
        float r8 = Math.max(r7, this.v);
        this.p = r8;
        b(r8);
        if (r6 == false) goto L9;
        a(false);
    L9:
        return r6;
    }

    private void a(boolean r5) {
        int r0 = 0;
        this.t = false;
        androidx.dynamicanimation.animation.a.a().a(this);
        this.w = 0;
        this.q = false;
    L4:
        if (r0 >= this.y.size()) goto L9;
        if (this.y.get(r0) == null) goto L8;
        ((InterfaceC0048b) ZeusTransformUtils.preCheckCast(this.y.get(r0), InterfaceC0048b.class, "com.obric.aiagent.plugin")).a(this, r5, this.p, this.o);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        a(this.y);
    }

    void b(float r4) {
        this.s.a(this.r, r4);
        int r5 = 0;
    L4:
        if (r5 >= this.z.size()) goto L9;
        if (this.z.get(r5) == null) goto L8;
        ((c) ZeusTransformUtils.preCheckCast(this.z.get(r5), c.class, "com.obric.aiagent.plugin")).a(this, this.p, this.o);
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        a(this.z);
    }

    float c() {
        return this.x * 0.75f;
    }

    private float e() {
        return this.s.a(this.r);
    }
}

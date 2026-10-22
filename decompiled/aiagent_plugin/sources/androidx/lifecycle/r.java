package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: LifecycleRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public class r extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.a.a.b.a<o, b> f2071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i.b f2072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference<p> f2073e;
    private int f;
    private boolean g;
    private boolean h;
    private ArrayList<i.b> i;

    /* JADX INFO: compiled from: LifecycleRegistry.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final i.b a(i.b r2, i.b r3) {
            d.h.b.o.e(r2, "state1");
            if (r3 != null) goto L5;
            return r2;
        L5:
            if (r3.compareTo((Enum) ZeusTransformUtils.preCheckCast(r2, Enum.class, "com.obric.aiagent.plugin")) < 0) goto L7;
            return r2;
        L7:
            return r3;
        }
    }

    /* JADX INFO: compiled from: LifecycleRegistry.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private i.b f2074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private m f2075b;

        public b(o r3, i.b r4) {
            o r5 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "initialState");
            d.h.b.o.a(r5);
            this.f2075b = t.a(r5);
            this.f2074a = r4;
        }

        public final i.b a() {
            return this.f2074a;
        }

        public final void a(p r4, i.a r5) {
            p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "event");
            i.b r0 = r5.a();
            this.f2074a = r.f2069a.a(this.f2074a, r0);
            m r1 = this.f2075b;
            d.h.b.o.a(r6);
            r1.onStateChanged(r6, r5);
            this.f2074a = r0;
        }
    }

    static {
        f2069a = new a(null);
    }

    private r(p r3, boolean r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        this.f2070b = r4;
        this.f2071c = new androidx.a.a.b.a();
        this.f2072d = i.b.f2055b;
        this.i = new ArrayList();
        this.f2073e = new WeakReference(r5);
    }

    public r(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "provider");
        this(r4, true);
    }

    public void a(i.b r2) {
        d.h.b.o.e(r2, "state");
        a("markState");
        b(r2);
    }

    @Override // androidx.lifecycle.i
    public i.b b() {
        return this.f2072d;
    }

    public void b(i.b r2) {
        d.h.b.o.e(r2, "state");
        a("setCurrentState");
        c(r2);
    }

    public void a(i.a r2) {
        d.h.b.o.e(r2, "event");
        a("handleLifecycleEvent");
        c(r2.a());
    }

    private final void c(i.b r5) {
        i.b r0 = this.f2072d;
        if (r0 != r5) goto L6;
        return;
    L6:
        if (r0 == i.b.f2055b) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L25;
        this.f2072d = r5;
        if (this.g == false) goto L16;
    L22:
        this.h = true;
        return;
    L16:
        if (this.f != 0) goto L22;
        this.g = true;
        e();
        this.g = false;
        if (this.f2072d != i.b.f2054a) goto L26;
        this.f2071c = new androidx.a.a.b.a();
        return;
    L26:
        return;
    L25:
        throw new IllegalStateException(("no event down from " + this.f2072d + " in component " + this.f2073e.get()).toString());
    L8:
        if (r5 != i.b.f2054a) goto L11;
        r1 = false;
        goto L12
    }

    private final boolean c() {
        if (this.f2071c.a() != 0) goto L5;
        return true;
    L5:
        Map.Entry<o, b> r0 = this.f2071c.d();
        d.h.b.o.a(r0);
        i.b r1 = ((b) ZeusTransformUtils.preCheckCast(r0.getValue(), b.class, "com.obric.aiagent.plugin")).a();
        Map.Entry<o, b> r2 = this.f2071c.e();
        d.h.b.o.a(r2);
        i.b r3 = ((b) ZeusTransformUtils.preCheckCast(r2.getValue(), b.class, "com.obric.aiagent.plugin")).a();
        if (r1 == r3) goto L8;
    L10:
        return false;
    L8:
        if (this.f2072d != r3) goto L10;
        return true;
    }

    private final i.b c(o r5) {
        Map.Entry<o, b> r6 = this.f2071c.d((o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.aiagent.plugin"));
        i.b r0 = null;
        if (r6 == null) goto L7;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6.getValue(), b.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L7;
        i.b r8 = r7.a();
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L11;
        ArrayList<i.b> r1 = this.i;
        r0 = (i.b) ZeusTransformUtils.preCheckCast(r1.get(r1.size() - 1), i.b.class, "com.obric.aiagent.plugin");
    L11:
        a r2 = f2069a;
        return r2.a(r2.a(this.f2072d, r8), r0);
    L7:
        r8 = null;
        goto L9
    }

    @Override // androidx.lifecycle.i
    public void a(o r8) {
        o r9 = (o) ZeusTransformUtils.wrapperContextForParams(r8, o.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "observer");
        a("addObserver");
        if (this.f2072d != i.b.f2054a) goto L5;
        i.b r0 = i.b.f2054a;
    L6:
        b r2 = new b(r9, r0);
        if (((b) ZeusTransformUtils.preCheckCast(this.f2071c.a(r9, r2), b.class, "com.obric.aiagent.plugin")) == null) goto L9;
        return;
    L9:
        p r1 = (p) ZeusTransformUtils.preCheckCast(this.f2073e.get(), p.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        return;
    L13:
        if (this.f == 0) goto L15;
    L18:
        boolean r3 = true;
    L19:
        i.b r5 = c(r9);
        this.f++;
    L21:
        if (r2.a().compareTo((Enum) ZeusTransformUtils.preCheckCast(r5, Enum.class, "com.obric.aiagent.plugin")) >= 0) goto L29;
        if (this.f2071c.c(r9) == false) goto L29;
        d(r2.a());
        i.a r4 = i.a.Companion.b(r2.a());
        if (r4 == null) goto L28;
        r2.a(r1, r4);
        d();
        r5 = c(r9);
        goto L21
    L28:
        throw new IllegalStateException("no event up from " + r2.a());
    L29:
        if (r3 == true) goto L31;
        e();
    L31:
        this.f--;
        return;
    L15:
        if (this.g == true) goto L18;
        r3 = false;
        goto L19
    L5:
        r0 = i.b.f2055b;
        goto L6
    }

    private final void d() {
        ArrayList<i.b> r1 = this.i;
        r1.remove(r1.size() - 1);
    }

    private final void d(i.b r1) {
        this.i.add(r1);
    }

    @Override // androidx.lifecycle.i
    public void b(o r3) {
        o r4 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "observer");
        a("removeObserver");
        this.f2071c.b(r4);
    }

    private final void a(p r8) {
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r8, p.class, "com.obric.aiagent.plugin");
        androidx.a.a.b.b<o, b>.d r0 = this.f2071c.c();
        d.h.b.o.c(r0, "observerMap.iteratorWithAdditions()");
        Iterator r1 = (Iterator) ZeusTransformUtils.preCheckCast(r0, Iterator.class, "com.obric.aiagent.plugin");
    L4:
        if (r1.hasNext() == false) goto L19;
        if (this.h == true) goto L27;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o r3 = (o) ZeusTransformUtils.preCheckCast(r2.getKey(), o.class, "com.obric.aiagent.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2.getValue(), b.class, "com.obric.aiagent.plugin");
    L9:
        if (r4.a().compareTo((Enum) ZeusTransformUtils.preCheckCast(this.f2072d, Enum.class, "com.obric.aiagent.plugin")) >= 0) goto L4;
        if (this.h == true) goto L4;
        if (this.f2071c.c(r3) == false) goto L4;
        d(r4.a());
        i.a r5 = i.a.Companion.b(r4.a());
        if (r5 == null) goto L18;
        r4.a(r9, r5);
        d();
        goto L9
    L18:
        throw new IllegalStateException("no event up from " + r4.a());
    L27:
        return;
    }

    private final void b(p r8) {
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r8, p.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<o, b>> r0 = this.f2071c.b();
        d.h.b.o.c(r0, "observerMap.descendingIterator()");
    L4:
        if (r0.hasNext() == false) goto L19;
        if (this.h == true) goto L27;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "next()");
        o r3 = (o) ZeusTransformUtils.preCheckCast(r2.getKey(), o.class, "com.obric.aiagent.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2.getValue(), b.class, "com.obric.aiagent.plugin");
    L9:
        if (r4.a().compareTo((Enum) ZeusTransformUtils.preCheckCast(this.f2072d, Enum.class, "com.obric.aiagent.plugin")) <= 0) goto L4;
        if (this.h == true) goto L4;
        if (this.f2071c.c(r3) == false) goto L4;
        i.a r5 = i.a.Companion.a(r4.a());
        if (r5 == null) goto L18;
        d(r5.a());
        r4.a(r9, r5);
        d();
        goto L9
    L18:
        throw new IllegalStateException("no event down from " + r4.a());
    L27:
        return;
    }

    private final void e() {
        p r0 = (p) ZeusTransformUtils.preCheckCast(this.f2073e.get(), p.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L18;
    L5:
        if (c() == true) goto L15;
        this.h = false;
        i.b r1 = this.f2072d;
        Map.Entry<o, b> r3 = this.f2071c.d();
        d.h.b.o.a(r3);
        if (r1.compareTo((Enum) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(r3.getValue(), b.class, "com.obric.aiagent.plugin")).a(), Enum.class, "com.obric.aiagent.plugin")) >= 0) goto L9;
        b(r0);
    L9:
        Map.Entry<o, b> r2 = this.f2071c.e();
        if (this.h == true) goto L5;
        if (r2 == null) goto L5;
        if (this.f2072d.compareTo((Enum) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(r2.getValue(), b.class, "com.obric.aiagent.plugin")).a(), Enum.class, "com.obric.aiagent.plugin")) <= 0) goto L5;
        a(r0);
        goto L5
    L15:
        this.h = false;
        return;
    L18:
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    private final void a(String r2) {
        if (this.f2070b == true) goto L5;
        return;
    L5:
        if (androidx.a.a.a.a.a().c() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(("Method " + r2 + " must be called on the main thread").toString());
    }
}

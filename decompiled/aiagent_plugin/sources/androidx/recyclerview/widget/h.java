package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ConcatAdapterController.java */
/* JADX INFO: loaded from: classes.dex */
class h implements s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f2492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ad f2493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<WeakReference<RecyclerView>> f2494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IdentityHashMap<RecyclerView.u, s> f2495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<s> f2496e;
    private a f;
    private final g.a.EnumC0074a g;
    private final aa h;

    /* JADX INFO: compiled from: ConcatAdapterController.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        s f2497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2499c;

        a() {
        }
    }

    h(g r2, g.a r3) {
        this.f2494c = new ArrayList();
        this.f2495d = new IdentityHashMap();
        this.f2496e = new ArrayList();
        this.f = new a();
        this.f2492a = r2;
        if (r3.f2486a == false) goto L5;
        this.f2493b = new ad.a();
    L6:
        this.g = r3.f2487b;
        if (r3.f2487b != g.a.EnumC0074a.f2488a) goto L10;
        this.h = new aa.b();
        return;
    L10:
        if (r3.f2487b != g.a.EnumC0074a.f2489b) goto L13;
        this.h = new aa.a();
        return;
    L13:
        if (r3.f2487b != g.a.EnumC0074a.f2490c) goto L17;
        this.h = new aa.c();
        return;
    L17:
        throw new IllegalArgumentException("unknown stable id mode");
    L5:
        this.f2493b = new ad.b();
        goto L6
    }

    private s b(RecyclerView.a<RecyclerView.u> r2) {
        int r3 = c(r2);
        if (r3 != (-1)) goto L7;
        return null;
    L7:
        return (s) ZeusTransformUtils.preCheckCast(this.f2496e.get(r3), s.class, "com.obric.aiagent.plugin");
    }

    private int c(RecyclerView.a<RecyclerView.u> r6) {
        int r0 = this.f2496e.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (((s) ZeusTransformUtils.preCheckCast(this.f2496e.get(r1), s.class, "com.obric.aiagent.plugin")).f2576a == r6) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    boolean a(RecyclerView.a<RecyclerView.u> r2) {
        return a(this.f2496e.size(), r2);
    }

    boolean a(int r5, RecyclerView.a<RecyclerView.u> r6) {
        if (r5 < 0) goto L27;
        if (r5 > this.f2496e.size()) goto L27;
        if (b() == false) goto L9;
        androidx.core.util.g.a(r6.b(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
    L12:
        if (b(r6) == null) goto L15;
        return false;
    L15:
        s r0 = new s(r6, this, this.f2493b, this.h.a());
        this.f2496e.add(r5, r0);
        Iterator<WeakReference<RecyclerView>> r7 = this.f2494c.iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r7.next(), WeakReference.class, "com.obric.aiagent.plugin")).get(), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L17;
        r6.a(r1);
        goto L17
    L22:
        if (r0.a() <= 0) goto L24;
        this.f2492a.c(c(r0), r0.a());
    L24:
        c();
        return true;
    L9:
        if (r6.b() == false) goto L12;
        a("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
    L27:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + this.f2496e.size() + ". Given:" + r5);
    }

    private int c(s r5) {
        Iterator<s> r4 = this.f2496e.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L8;
        s r1 = (s) ZeusTransformUtils.preCheckCast(r4.next(), s.class, "com.obric.aiagent.plugin");
        if (r1 == r5) goto L8;
        r0 = r0 + r1.a();
    L8:
        return r0;
    }

    public long a(int r3) {
        a r4 = c(r3);
        long r0 = r4.f2497a.b(r4.f2498b);
        a(r4);
        return r0;
    }

    @Override // androidx.recyclerview.widget.s.a
    public void a(s r1) {
        this.f2492a.d();
        c();
    }

    @Override // androidx.recyclerview.widget.s.a
    public void a(s r1, int r2, int r3, Object r4) {
        int r5 = c(r1);
        this.f2492a.a(r2 + r5, r3, r4);
    }

    @Override // androidx.recyclerview.widget.s.a
    public void a(s r1, int r2, int r3) {
        int r4 = c(r1);
        this.f2492a.c(r2 + r4, r3);
    }

    @Override // androidx.recyclerview.widget.s.a
    public void b(s r1, int r2, int r3) {
        int r4 = c(r1);
        this.f2492a.d(r2 + r4, r3);
    }

    @Override // androidx.recyclerview.widget.s.a
    public void c(s r1, int r2, int r3) {
        int r4 = c(r1);
        this.f2492a.b(r2 + r4, r3 + r4);
    }

    @Override // androidx.recyclerview.widget.s.a
    public void b(s r1) {
        c();
    }

    private void c() {
        RecyclerView.a.EnumC0069a r0 = d();
        if (r0 == this.f2492a.e()) goto L6;
        this.f2492a.b(r0);
        return;
    }

    private RecyclerView.a.EnumC0069a d() {
        Iterator<s> r3 = this.f2496e.iterator();
    L4:
        if (r3.hasNext() == false) goto L16;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.aiagent.plugin");
        RecyclerView.a.EnumC0069a r1 = r0.f2576a.e();
        if (r1 == RecyclerView.a.EnumC0069a.f2335c) goto L8;
        if (r1 != RecyclerView.a.EnumC0069a.f2334b) goto L4;
        if (r0.a() != 0) goto L4;
        return RecyclerView.a.EnumC0069a.f2335c;
    L8:
        return RecyclerView.a.EnumC0069a.f2335c;
    L16:
        return RecyclerView.a.EnumC0069a.f2333a;
    }

    public int a() {
        Iterator<s> r4 = this.f2496e.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((s) ZeusTransformUtils.preCheckCast(r4.next(), s.class, "com.obric.aiagent.plugin")).a();
        goto L4
    L6:
        return r0;
    }

    public int b(int r3) {
        a r4 = c(r3);
        int r0 = r4.f2497a.a(r4.f2498b);
        a(r4);
        return r0;
    }

    public RecyclerView.u a(ViewGroup r1, int r2) {
        return this.f2493b.a(r2).a(r1, r2);
    }

    private a c(int r6) {
        if (this.f.f2499c == false) goto L5;
        a r0 = new a();
    L6:
        Iterator<s> r5 = this.f2496e.iterator();
        int r1 = r6;
    L8:
        if (r5.hasNext() == false) goto L14;
        s r2 = (s) ZeusTransformUtils.preCheckCast(r5.next(), s.class, "com.obric.aiagent.plugin");
        if (r2.a() > r1) goto L11;
        r1 = r1 - r2.a();
        goto L8
    L11:
        r0.f2497a = r2;
        r0.f2498b = r1;
    L14:
        if (r0.f2497a == null) goto L17;
        return r0;
    L17:
        throw new IllegalArgumentException("Cannot find wrapper for " + r6);
    L5:
        this.f.f2499c = true;
        r0 = this.f;
        goto L6
    }

    private void a(a r2) {
        r2.f2499c = false;
        r2.f2497a = null;
        r2.f2498b = -1;
        this.f = r2;
    }

    public void a(RecyclerView.u r3, int r4) {
        a r5 = c(r4);
        this.f2495d.put(r3, r5.f2497a);
        r5.f2497a.a(r3, r5.f2498b);
        a(r5);
    }

    public void a(RecyclerView.u r1) {
        e(r1).f2576a.b(r1);
    }

    public void b(RecyclerView.u r1) {
        e(r1).f2576a.c(r1);
    }

    public void c(RecyclerView.u r4) {
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.f2495d.get(r4), s.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        r0.f2576a.d(r4);
        this.f2495d.remove(r4);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    public boolean d(RecyclerView.u r4) {
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.f2495d.get(r4), s.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        boolean r1 = r0.f2576a.a(r4);
        this.f2495d.remove(r4);
        return r1;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    private s e(RecyclerView.u r4) {
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.f2495d.get(r4), s.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    private boolean c(RecyclerView r4) {
        Iterator<WeakReference<RecyclerView>> r3 = this.f2494c.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.aiagent.plugin")).get() != r4) goto L4;
        return true;
    L9:
        return false;
    }

    public void a(RecyclerView r4) {
        if (c(r4) == false) goto L5;
        return;
    L5:
        this.f2494c.add(new WeakReference(r4));
        Iterator<s> r3 = this.f2496e.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.aiagent.plugin")).f2576a.a(r4);
        goto L7
    }

    public void b(RecyclerView r5) {
        int r0 = this.f2494c.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L12;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(this.f2494c.get(r0), WeakReference.class, "com.obric.aiagent.plugin");
        if (r2.get() != null) goto L9;
        this.f2494c.remove(r0);
        goto L3
    L9:
        if (r2.get() != r5) goto L3;
        this.f2494c.remove(r0);
    L12:
        Iterator<s> r4 = this.f2496e.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        ((s) ZeusTransformUtils.preCheckCast(r4.next(), s.class, "com.obric.aiagent.plugin")).f2576a.b(r5);
        goto L14
    }

    public int a(RecyclerView.a<? extends RecyclerView.u> r4, RecyclerView.u r5, int r6) {
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.f2495d.get(r5), s.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r7 = r6 - c(r0);
        int r3 = r0.f2576a.a();
        if (r7 < 0) goto L12;
        if (r7 >= r3) goto L12;
        return r0.f2576a.a(r4, r5, r7);
    L12:
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + r7 + " which is out of bounds for the adapter with size " + r3 + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + r5 + "adapter:" + r4);
    }

    public boolean b() {
        if (this.g == g.a.EnumC0074a.f2488a) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}

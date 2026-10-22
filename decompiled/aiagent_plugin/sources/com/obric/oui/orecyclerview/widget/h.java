package com.obric.oui.orecyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ConcatAdapterController.java */
/* JADX INFO: loaded from: classes4.dex */
class h implements r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f35746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ab f35747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<WeakReference<RecyclerView>> f35748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IdentityHashMap<RecyclerView.v, r> f35749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<r> f35750e;
    private a f;
    private final g.a.EnumC0967a g;
    private final y h;

    /* JADX INFO: compiled from: ConcatAdapterController.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        r f35751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f35753c;

        a() {
        }
    }

    h(g r2, g.a r3) {
        this.f35748c = new ArrayList();
        this.f35749d = new IdentityHashMap();
        this.f35750e = new ArrayList();
        this.f = new a();
        this.f35746a = r2;
        if (r3.f35740a == false) goto L5;
        this.f35747b = new ab.a();
    L6:
        this.g = r3.f35741b;
        if (r3.f35741b != g.a.EnumC0967a.f35742a) goto L10;
        this.h = new y.b();
        return;
    L10:
        if (r3.f35741b != g.a.EnumC0967a.f35743b) goto L13;
        this.h = new y.a();
        return;
    L13:
        if (r3.f35741b != g.a.EnumC0967a.f35744c) goto L17;
        this.h = new y.c();
        return;
    L17:
        throw new IllegalArgumentException("unknown stable id mode");
    L5:
        this.f35747b = new ab.b();
        goto L6
    }

    private r b(RecyclerView.a<RecyclerView.v> r2) {
        int r3 = c(r2);
        if (r3 != (-1)) goto L7;
        return null;
    L7:
        return (r) ZeusTransformUtils.preCheckCast(this.f35750e.get(r3), r.class, "com.obric.aiagent.plugin");
    }

    private int c(RecyclerView.a<RecyclerView.v> r6) {
        int r0 = this.f35750e.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (((r) ZeusTransformUtils.preCheckCast(this.f35750e.get(r1), r.class, "com.obric.aiagent.plugin")).f35826a == r6) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    boolean a(RecyclerView.a<RecyclerView.v> r2) {
        return a(this.f35750e.size(), r2);
    }

    boolean a(int r5, RecyclerView.a<RecyclerView.v> r6) {
        if (r5 < 0) goto L27;
        if (r5 > this.f35750e.size()) goto L27;
        if (c() == false) goto L9;
        androidx.core.util.g.a(r6.e(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
    L12:
        if (b(r6) == null) goto L15;
        return false;
    L15:
        r r0 = new r(r6, this, this.f35747b, this.h.a());
        this.f35750e.add(r5, r0);
        Iterator<WeakReference<RecyclerView>> r7 = this.f35748c.iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r7.next(), WeakReference.class, "com.obric.aiagent.plugin")).get(), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L17;
        r6.a(r1);
        goto L17
    L22:
        if (r0.a() <= 0) goto L24;
        this.f35746a.c(c(r0), r0.a());
    L24:
        d();
        return true;
    L9:
        if (r6.e() == false) goto L12;
        a("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
    L27:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + this.f35750e.size() + ". Given:" + r5);
    }

    private int c(r r5) {
        Iterator<r> r4 = this.f35750e.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L8;
        r r1 = (r) ZeusTransformUtils.preCheckCast(r4.next(), r.class, "com.obric.aiagent.plugin");
        if (r1 == r5) goto L8;
        r0 = r0 + r1.a();
    L8:
        return r0;
    }

    public long a(int r3) {
        a r4 = c(r3);
        long r0 = r4.f35751a.b(r4.f35752b);
        a(r4);
        return r0;
    }

    @Override // com.obric.oui.orecyclerview.widget.r.a
    public void a(r r1) {
        this.f35746a.g();
        d();
    }

    @Override // com.obric.oui.orecyclerview.widget.r.a
    public void a(r r1, int r2, int r3, Object r4) {
        int r5 = c(r1);
        this.f35746a.a(r2 + r5, r3, r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.r.a
    public void a(r r1, int r2, int r3) {
        int r4 = c(r1);
        this.f35746a.c(r2 + r4, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.r.a
    public void b(r r1, int r2, int r3) {
        int r4 = c(r1);
        this.f35746a.d(r2 + r4, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.r.a
    public void c(r r1, int r2, int r3) {
        int r4 = c(r1);
        this.f35746a.b(r2 + r4, r3 + r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.r.a
    public void b(r r1) {
        d();
    }

    private void d() {
        RecyclerView.a.EnumC0963a r0 = e();
        if (r0 == this.f35746a.h()) goto L6;
        this.f35746a.b(r0);
        return;
    }

    private RecyclerView.a.EnumC0963a e() {
        Iterator<r> r3 = this.f35750e.iterator();
    L4:
        if (r3.hasNext() == false) goto L16;
        r r0 = (r) ZeusTransformUtils.preCheckCast(r3.next(), r.class, "com.obric.aiagent.plugin");
        RecyclerView.a.EnumC0963a r1 = r0.f35826a.h();
        if (r1 == RecyclerView.a.EnumC0963a.f35607c) goto L8;
        if (r1 != RecyclerView.a.EnumC0963a.f35606b) goto L4;
        if (r0.a() != 0) goto L4;
        return RecyclerView.a.EnumC0963a.f35607c;
    L8:
        return RecyclerView.a.EnumC0963a.f35607c;
    L16:
        return RecyclerView.a.EnumC0963a.f35605a;
    }

    public int a() {
        Iterator<r> r4 = this.f35750e.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((r) ZeusTransformUtils.preCheckCast(r4.next(), r.class, "com.obric.aiagent.plugin")).a();
        goto L4
    L6:
        return r0;
    }

    public int b(int r3) {
        a r4 = c(r3);
        int r0 = r4.f35751a.a(r4.f35752b);
        a(r4);
        return r0;
    }

    public RecyclerView.v a(ViewGroup r1, int r2) {
        return this.f35747b.a(r2).a(r1, r2);
    }

    private a c(int r6) {
        if (this.f.f35753c == false) goto L5;
        a r0 = new a();
    L6:
        Iterator<r> r5 = this.f35750e.iterator();
        int r1 = r6;
    L8:
        if (r5.hasNext() == false) goto L14;
        r r2 = (r) ZeusTransformUtils.preCheckCast(r5.next(), r.class, "com.obric.aiagent.plugin");
        if (r2.a() > r1) goto L11;
        r1 = r1 - r2.a();
        goto L8
    L11:
        r0.f35751a = r2;
        r0.f35752b = r1;
    L14:
        if (r0.f35751a == null) goto L17;
        return r0;
    L17:
        throw new IllegalArgumentException("Cannot find wrapper for " + r6);
    L5:
        this.f.f35753c = true;
        r0 = this.f;
        goto L6
    }

    private void a(a r2) {
        r2.f35753c = false;
        r2.f35751a = null;
        r2.f35752b = -1;
        this.f = r2;
    }

    public void a(RecyclerView.v r3, int r4) {
        a r5 = c(r4);
        this.f35749d.put(r3, r5.f35751a);
        r5.f35751a.a(r3, r5.f35752b);
        a(r5);
    }

    public void a(RecyclerView.v r1) {
        e(r1).f35826a.b(r1);
    }

    public void b(RecyclerView.v r1) {
        e(r1).f35826a.c(r1);
    }

    public void c(RecyclerView.v r4) {
        r r0 = (r) ZeusTransformUtils.preCheckCast(this.f35749d.get(r4), r.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        r0.f35826a.d(r4);
        this.f35749d.remove(r4);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    public boolean d(RecyclerView.v r4) {
        r r0 = (r) ZeusTransformUtils.preCheckCast(this.f35749d.get(r4), r.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        boolean r1 = r0.f35826a.a(r4);
        this.f35749d.remove(r4);
        return r1;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    private r e(RecyclerView.v r4) {
        r r0 = (r) ZeusTransformUtils.preCheckCast(this.f35749d.get(r4), r.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    private boolean c(RecyclerView r4) {
        Iterator<WeakReference<RecyclerView>> r3 = this.f35748c.iterator();
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
        this.f35748c.add(new WeakReference(r4));
        Iterator<r> r3 = this.f35750e.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((r) ZeusTransformUtils.preCheckCast(r3.next(), r.class, "com.obric.aiagent.plugin")).f35826a.a(r4);
        goto L7
    }

    public void b(RecyclerView r5) {
        int r0 = this.f35748c.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L12;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(this.f35748c.get(r0), WeakReference.class, "com.obric.aiagent.plugin");
        if (r2.get() != null) goto L9;
        this.f35748c.remove(r0);
        goto L3
    L9:
        if (r2.get() != r5) goto L3;
        this.f35748c.remove(r0);
    L12:
        Iterator<r> r4 = this.f35750e.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        ((r) ZeusTransformUtils.preCheckCast(r4.next(), r.class, "com.obric.aiagent.plugin")).f35826a.b(r5);
        goto L14
    }

    public int a(RecyclerView.a<? extends RecyclerView.v> r4, RecyclerView.v r5, int r6) {
        r r0 = (r) ZeusTransformUtils.preCheckCast(this.f35749d.get(r5), r.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r7 = r6 - c(r0);
        int r3 = r0.f35826a.a();
        if (r7 < 0) goto L12;
        if (r7 >= r3) goto L12;
        return r0.f35826a.a(r4, r5, r7);
    L12:
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + r7 + " which is out of bounds for the adapter with size " + r3 + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + r5 + "adapter:" + r4);
    }

    public List<RecyclerView.a<? extends RecyclerView.v>> b() {
        if (this.f35750e.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList(this.f35750e.size());
        Iterator<r> r4 = this.f35750e.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(((r) ZeusTransformUtils.preCheckCast(r4.next(), r.class, "com.obric.aiagent.plugin")).f35826a);
        goto L8
    L10:
        return r0;
    L5:
        return Collections.emptyList();
    }

    public boolean c() {
        if (this.g == g.a.EnumC0967a.f35742a) goto L5;
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

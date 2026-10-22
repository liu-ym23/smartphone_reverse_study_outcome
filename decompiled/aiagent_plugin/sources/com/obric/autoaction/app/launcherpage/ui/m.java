package com.obric.autoaction.app.launcherpage.ui;

import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.s;
import d.x;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SortableTaskAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m<T extends h> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<T> f24450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<? extends T> f24451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.h.a.a<x> f24452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f24454e;

    public /* synthetic */ m(RecyclerView r1, boolean r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        this(r1, r2);
    }

    public m(RecyclerView r2, boolean r3) {
        d.h.b.o.e(r2, "recyclerView");
        super(r2, r3);
        this.f24453d = -1;
        this.f24454e = -1;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.d
    public T b(int r4) {
        List<T> r0 = this.f24450a;
        if (r0 == null) goto L7;
        T r1 = (T) ZeusTransformUtils.preCheckCast(r0.get(r4), h.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return r1;
    L7:
        return (T) super.b(r4);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.d, com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        List<T> r0 = this.f24450a;
        if (r0 == null) goto L6;
        return r0.size();
    L6:
        return super.a();
    }

    public final void c(int r4) {
        this.f24450a = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(c(), Collection.class, "com.obric.aiagent.plugin"));
        this.f24453d = r4;
        this.f24454e = r4;
    }

    public final boolean a(int r6, int r7) {
        if (r6 != r7) goto L5;
        return false;
    L5:
        List<T> r1 = this.f24450a;
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r6 >= 0) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L24;
        if (r7 >= 0) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L24;
        r1.add(r7, (T) ((h) ZeusTransformUtils.preCheckCast(r1.remove(r6), h.class, "com.obric.aiagent.plugin")));
        b(r6, r7);
        this.f24454e = r7;
        return true;
    L17:
        if (r7 >= ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).size()) goto L19;
        r5 = true;
    L24:
        return false;
    L11:
        if (r6 >= ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).size()) goto L13;
        r4 = true;
        goto L14
    }

    public final d.m<List<T>, l> d() {
        List<T> r0 = this.f24450a;
        if (r0 == null) goto L6;
        List<? extends T> r1 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L6;
    L7:
        int r2 = this.f24453d;
        if (r2 == (-1)) goto L13;
        int r3 = this.f24454e;
        if (r3 == (-1)) goto L13;
        if (r2 == r3) goto L13;
        l r4 = new l(this.f24453d, this.f24454e);
    L14:
        a(r1);
        j();
        return s.a(r1, r4);
    L13:
        r4 = null;
    L6:
        r1 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(c(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.d
    public void a(List<? extends T> r3, d.h.a.a<x> r4) {
        List<? extends T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (this.f24450a == null) goto L9;
        if (r5 == null) goto L6;
        List<? extends T> r7 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"));
    L7:
        this.f24451b = r7;
        this.f24452c = r6;
        return;
    L6:
        r7 = null;
        goto L7
    L9:
        super.a(r5, r6);
    }

    public final void a(boolean r2) {
        if (r2 == true) goto L6;
        List<? extends T> r3 = this.f24451b;
        if (r3 == null) goto L6;
        super.a(r3, this.f24452c);
    L6:
        this.f24451b = null;
        this.f24452c = null;
    }

    private final void j() {
        this.f24450a = null;
        this.f24453d = -1;
        this.f24454e = -1;
    }
}

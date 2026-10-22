package com.obric.oui.privacy.a;

import android.content.Context;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.k;
import d.l.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PrivacySheetAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends RecyclerView.a<RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36083a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f36084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f36085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f36086d;

    /* JADX INFO: compiled from: PrivacySheetAdapter.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.privacy.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PrivacySheetAdapter.kt */
    static final class C0982b extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f36087a;

        C0982b(b r1) {
            this.f36087a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }

        public final Integer a() {
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(b.a(this.f36087a), Iterable.class, "com.obric.aiagent.plugin");
            int r2 = 0;
            if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
        L7:
            Iterator r5 = r4.iterator();
        L9:
            if (r5.hasNext() == false) goto L16;
            if (ZeusTransformUtils.instanceOf((d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin"), d.b.class) == false) goto L9;
            r2 = r2 + 1;
            if (r2 >= 0) goto L9;
            d.a.p.d();
        L16:
            return Integer.valueOf(r2);
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
            goto L7
        }
    }

    /* JADX INFO: compiled from: PrivacySheetAdapter.kt */
    static final class c extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f36088a;

        c(b r1) {
            this.f36088a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }

        public final Integer a() {
            Iterator r5 = b.a(this.f36088a).iterator();
            int r1 = 0;
        L4:
            if (r5.hasNext() == false) goto L9;
            if (ZeusTransformUtils.instanceOf((d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin"), d.b.class) == true) goto L11;
            r1 = r1 + 1;
        L11:
            return Integer.valueOf(n.c(r1, 0));
        L9:
            r1 = -1;
            goto L11
        }
    }

    static {
        f36083a = new a(null);
    }

    public static final /* synthetic */ List a(b r0) {
        return r0.f36084b;
    }

    public b(List<? extends d> r3) {
        List<d> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "items");
        this.f36084b = r4;
        this.f36085c = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new C0982b(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.f36086d = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final int b() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.f36085c.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    private final int c() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.f36086d.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a(int r2) {
        d r1 = (d) ZeusTransformUtils.preCheckCast(this.f36084b.get(r2), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.b.class) == false) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, d.a.class) == false) goto L10;
        return 1;
    L10:
        throw new k();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public RecyclerView.v b(ViewGroup r3, int r4) {
        o.e(r3, "parent");
        if (r4 != 0) goto L5;
        com.obric.oui.privacy.a.c.a r5 = com.obric.oui.privacy.a.c.f36089a;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "parent.context");
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r5.a(r6), RecyclerView.v.class, "com.obric.aiagent.plugin");
    L5:
        if (r4 != 1) goto L8;
        com.obric.oui.privacy.a.a.C0981a r7 = com.obric.oui.privacy.a.a.f36082a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "parent.context");
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r7.a(r8), RecyclerView.v.class, "com.obric.aiagent.plugin");
    L8:
        throw new IllegalArgumentException(o.a("Unknown viewType: ", Integer.valueOf(r4)));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void a(RecyclerView.v r4, int r5) {
        o.e(r4, "holder");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.privacy.a.c.class) == false) goto L6;
        d.b r0 = (d.b) ZeusTransformUtils.preCheckCast(this.f36084b.get(r5), d.b.class, "com.obric.aiagent.plugin");
        ((com.obric.oui.privacy.a.c) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.privacy.a.c.class, "com.obric.aiagent.plugin")).a(r0, r5, b(), c());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.privacy.a.a.class) == false) goto L10;
        d.a r3 = (d.a) ZeusTransformUtils.preCheckCast(this.f36084b.get(r5), d.a.class, "com.obric.aiagent.plugin");
        ((com.obric.oui.privacy.a.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.privacy.a.a.class, "com.obric.aiagent.plugin")).a(r3);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        return this.f36084b.size();
    }
}

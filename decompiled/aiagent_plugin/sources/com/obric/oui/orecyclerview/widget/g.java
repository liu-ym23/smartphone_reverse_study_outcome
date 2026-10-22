package com.obric.oui.orecyclerview.widget;

import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConcatAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends RecyclerView.a<RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f35738a;

    /* JADX INFO: compiled from: ConcatAdapter.java */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f35739c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f35740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final EnumC0967a f35741b;

        /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConcatAdapter.java */
        public static final enum EnumC0967a extends Enum<EnumC0967a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0967a f35742a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0967a f35743b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0967a f35744c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC0967a[] f35745d = null;

            private EnumC0967a(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumC0967a valueOf(String r2) {
                return (EnumC0967a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0967a.class, r2), EnumC0967a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0967a[] values() {
                return (EnumC0967a[]) ZeusTransformUtils.preCheckCast(f35745d.clone(), EnumC0967a[].class, "com.obric.aiagent.plugin");
            }

            static {
                EnumC0967a r0 = new EnumC0967a("NO_STABLE_IDS", 0);
                f35742a = r0;
                EnumC0967a r1 = new EnumC0967a("ISOLATED_STABLE_IDS", 1);
                f35743b = r1;
                EnumC0967a r3 = new EnumC0967a("SHARED_STABLE_IDS", 2);
                f35744c = r3;
                f35745d = new EnumC0967a[]{r0, r1, r3};
            }
        }

        static {
            f35739c = new a(true, EnumC0967a.f35742a);
        }

        a(boolean r1, EnumC0967a r2) {
            this.f35740a = r1;
            this.f35741b = r2;
        }
    }

    @SafeVarargs
    public g(RecyclerView.a<? extends RecyclerView.v>... r2) {
        this(a.f35739c, r2);
    }

    @SafeVarargs
    public g(a r1, RecyclerView.a<? extends RecyclerView.v>... r2) {
        this(r1, Arrays.asList(r2));
    }

    public g(a r3, List<? extends RecyclerView.a<? extends RecyclerView.v>> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f35738a = new h(this, r3);
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        a((RecyclerView.a) ZeusTransformUtils.preCheckCast(r6.next(), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        super.c_(this.f35738a.c());
    }

    public boolean a(RecyclerView.a<? extends RecyclerView.v> r1) {
        return this.f35738a.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a(int r1) {
        return this.f35738a.b(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public RecyclerView.v b(ViewGroup r1, int r2) {
        return this.f35738a.a(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void a(RecyclerView.v r1, int r2) {
        this.f35738a.a(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void c_(boolean r1) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void a(RecyclerView.a.EnumC0963a r1) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public long a_(int r1) {
        return this.f35738a.a(r1);
    }

    void b(RecyclerView.a.EnumC0963a r1) {
        super.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        return this.f35738a.a();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public boolean a(RecyclerView.v r1) {
        return this.f35738a.d(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void b(RecyclerView.v r1) {
        this.f35738a.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void c(RecyclerView.v r1) {
        this.f35738a.b(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void d(RecyclerView.v r1) {
        this.f35738a.c(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void a(RecyclerView r1) {
        this.f35738a.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void b(RecyclerView r1) {
        this.f35738a.b(r1);
    }

    public List<? extends RecyclerView.a<? extends RecyclerView.v>> b() {
        return Collections.unmodifiableList(this.f35738a.b());
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a(RecyclerView.a<? extends RecyclerView.v> r1, RecyclerView.v r2, int r3) {
        return this.f35738a.a(r1, r2, r3);
    }
}

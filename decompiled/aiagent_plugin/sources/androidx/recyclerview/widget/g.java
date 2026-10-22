package androidx.recyclerview.widget;

import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConcatAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends RecyclerView.a<RecyclerView.u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f2484a;

    /* JADX INFO: compiled from: ConcatAdapter.java */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2485c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final EnumC0074a f2487b;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConcatAdapter.java */
        public static final enum EnumC0074a extends Enum<EnumC0074a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0074a f2488a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0074a f2489b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0074a f2490c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC0074a[] f2491d = null;

            private EnumC0074a(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumC0074a valueOf(String r2) {
                return (EnumC0074a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0074a.class, r2), EnumC0074a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0074a[] values() {
                return (EnumC0074a[]) ZeusTransformUtils.preCheckCast(f2491d.clone(), EnumC0074a[].class, "com.obric.aiagent.plugin");
            }

            static {
                EnumC0074a r0 = new EnumC0074a("NO_STABLE_IDS", 0);
                f2488a = r0;
                EnumC0074a r1 = new EnumC0074a("ISOLATED_STABLE_IDS", 1);
                f2489b = r1;
                EnumC0074a r3 = new EnumC0074a("SHARED_STABLE_IDS", 2);
                f2490c = r3;
                f2491d = new EnumC0074a[]{r0, r1, r3};
            }
        }

        static {
            f2485c = new a(true, EnumC0074a.f2488a);
        }

        a(boolean r1, EnumC0074a r2) {
            this.f2486a = r1;
            this.f2487b = r2;
        }
    }

    @SafeVarargs
    public g(RecyclerView.a<? extends RecyclerView.u>... r2) {
        this(a.f2485c, r2);
    }

    @SafeVarargs
    public g(a r1, RecyclerView.a<? extends RecyclerView.u>... r2) {
        this(r1, Arrays.asList(r2));
    }

    public g(a r3, List<? extends RecyclerView.a<? extends RecyclerView.u>> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f2484a = new h(this, r3);
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        a((RecyclerView.a) ZeusTransformUtils.preCheckCast(r6.next(), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        super.a(this.f2484a.b());
    }

    public boolean a(RecyclerView.a<? extends RecyclerView.u> r1) {
        return this.f2484a.a(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a(int r1) {
        return this.f2484a.b(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public RecyclerView.u a(ViewGroup r1, int r2) {
        return this.f2484a.a(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(RecyclerView.u r1, int r2) {
        this.f2484a.a(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(boolean r1) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(RecyclerView.a.EnumC0069a r1) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long b(int r1) {
        return this.f2484a.a(r1);
    }

    void b(RecyclerView.a.EnumC0069a r1) {
        super.a(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f2484a.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public boolean a(RecyclerView.u r1) {
        return this.f2484a.d(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void b(RecyclerView.u r1) {
        this.f2484a.a(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void c(RecyclerView.u r1) {
        this.f2484a.b(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void d(RecyclerView.u r1) {
        this.f2484a.c(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(RecyclerView r1) {
        this.f2484a.a(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void b(RecyclerView r1) {
        this.f2484a.b(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a(RecyclerView.a<? extends RecyclerView.u> r1, RecyclerView.u r2, int r3) {
        return this.f2484a.a(r1, r2, r3);
    }
}

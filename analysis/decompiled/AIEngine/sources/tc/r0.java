package tc;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;
import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class r0 implements rc.e, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f13038a;

    /* renamed from: b, reason: collision with root package name */
    public final x<?> f13039b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13040c;

    /* renamed from: d, reason: collision with root package name */
    public int f13041d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f13042e;

    /* renamed from: f, reason: collision with root package name */
    public final List<Annotation>[] f13043f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean[] f13044g;
    public Object h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f13045i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f13046j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f13047k;

    public r0(String str, x<?> xVar, int i10) {
        this.f13038a = str;
        this.f13039b = xVar;
        this.f13040c = i10;
        String[] strArr = new String[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = "[UNINITIALIZED]";
        }
        this.f13042e = strArr;
        int i12 = this.f13040c;
        this.f13043f = new List[i12];
        this.f13044g = new boolean[i12];
        this.h = kotlin.collections.b.d0();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f9983a;
        final int i13 = 0;
        this.f13045i = kotlin.b.a(lazyThreadSafetyMode, new zb.a(this) { // from class: tc.q0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f13035b;

            {
                this.f13035b = this;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, lb.d] */
            @Override // zb.a
            public final Object invoke() {
                switch (i13) {
                    case 0:
                        return this.f13035b.f13039b.c();
                    default:
                        r0 r0Var = this.f13035b;
                        return Integer.valueOf(p0.d(r0Var, (rc.e[]) r0Var.f13046j.getValue()));
                }
            }
        });
        this.f13046j = kotlin.b.a(lazyThreadSafetyMode, new com.stepos.cpuset.c(this));
        final int i14 = 1;
        this.f13047k = kotlin.b.a(lazyThreadSafetyMode, new zb.a(this) { // from class: tc.q0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f13035b;

            {
                this.f13035b = this;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, lb.d] */
            @Override // zb.a
            public final Object invoke() {
                switch (i14) {
                    case 0:
                        return this.f13035b.f13039b.c();
                    default:
                        r0 r0Var = this.f13035b;
                        return Integer.valueOf(p0.d(r0Var, (rc.e[]) r0Var.f13046j.getValue()));
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    @Override // tc.k
    public final Set<String> a() {
        return this.h.keySet();
    }

    @Override // rc.e
    public final boolean b() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Map] */
    @Override // rc.e
    public final int c(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        Integer num = (Integer) this.h.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // rc.e
    public final rc.i d() {
        return j.a.f11801a;
    }

    @Override // rc.e
    public final int e() {
        return this.f13040c;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, lb.d] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, lb.d] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r0) {
            rc.e eVar = (rc.e) obj;
            if (this.f13038a.equals(eVar.i()) && Arrays.equals((rc.e[]) this.f13046j.getValue(), (rc.e[]) ((r0) obj).f13046j.getValue())) {
                int iE = eVar.e();
                int i10 = this.f13040c;
                if (i10 == iE) {
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (kotlin.jvm.internal.g.b(h(i11).i(), eVar.h(i11).i()) && kotlin.jvm.internal.g.b(h(i11).d(), eVar.h(i11).d())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // rc.e
    public final String f(int i10) {
        return this.f13042e[i10];
    }

    @Override // rc.e
    public final List<Annotation> g(int i10) {
        List<Annotation> list = this.f13043f[i10];
        return list == null ? EmptyList.f10001a : list;
    }

    @Override // rc.e
    public final List<Annotation> getAnnotations() {
        return EmptyList.f10001a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, lb.d] */
    @Override // rc.e
    public final rc.e h(int i10) {
        return ((pc.a[]) this.f13045i.getValue())[i10].d();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, lb.d] */
    public int hashCode() {
        return ((Number) this.f13047k.getValue()).intValue();
    }

    @Override // rc.e
    public final String i() {
        return this.f13038a;
    }

    @Override // rc.e
    public boolean isInline() {
        return false;
    }

    @Override // rc.e
    public final boolean j(int i10) {
        return this.f13044g[i10];
    }

    public final void k(String str, boolean z) {
        int i10 = this.f13041d + 1;
        this.f13041d = i10;
        String[] strArr = this.f13042e;
        strArr[i10] = str;
        this.f13044g[i10] = z;
        this.f13043f[i10] = null;
        if (i10 == this.f13040c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                map.put(strArr[i11], Integer.valueOf(i11));
            }
            this.h = map;
        }
    }

    public final String toString() {
        return kotlin.collections.a.z0(dc.h.e0(0, this.f13040c), ", ", this.f13038a.concat("("), ")", new androidx.compose.runtime.i(this, 13), 24);
    }
}

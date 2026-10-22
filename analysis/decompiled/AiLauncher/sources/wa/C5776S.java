package wa;

import Z8.C1173v;
import java.util.List;

/* renamed from: wa.S, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5776S {

    /* renamed from: c, reason: collision with root package name */
    public static final a f43174c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final C5776S f43175d = new C5776S(false, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f43176a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f43177b;

    /* renamed from: wa.S$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public C5776S(boolean z10, List<String> poisoningFeatures) {
        kotlin.jvm.internal.p.i(poisoningFeatures, "poisoningFeatures");
        this.f43176a = z10;
        this.f43177b = poisoningFeatures;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5776S)) {
            return false;
        }
        C5776S c5776s = (C5776S) obj;
        return this.f43176a == c5776s.f43176a && kotlin.jvm.internal.p.d(this.f43177b, c5776s.f43177b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f43176a) * 31) + this.f43177b.hashCode();
    }

    public String toString() {
        return "PreReleaseInfo(isInvisible=" + this.f43176a + ", poisoningFeatures=" + this.f43177b + ')';
    }

    public /* synthetic */ C5776S(boolean z10, List list, int i10, kotlin.jvm.internal.i iVar) {
        this(z10, (i10 & 2) != 0 ? C1173v.m() : list);
    }
}

package T9;

import F9.A;
import F9.w;
import java.util.Comparator;
import java.util.TreeSet;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.k;
import okhttp3.logging.HttpLoggingInterceptor$Level;

/* loaded from: classes4.dex */
public final class b implements A {

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f1238a;
    public volatile HttpLoggingInterceptor$Level b;
    public final a c;

    public b(a aVar) {
        this.c = aVar;
        this.f1238a = EmptySet.f4895a;
        this.b = HttpLoggingInterceptor$Level.f5476a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Set] */
    public final void a(w wVar, int i) {
        String strH = this.f1238a.contains(wVar.e(i)) ? "██" : wVar.h(i);
        this.c.log(wVar.e(i) + ": " + strH);
    }

    public final void b(String name) {
        k.f(name, "name");
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        k.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        TreeSet treeSet = new TreeSet(CASE_INSENSITIVE_ORDER);
        D7.A.e0((Iterable) this.f1238a, treeSet);
        treeSet.add(name);
        this.f1238a = treeSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    @Override // F9.A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final F9.M intercept(F9.z r25) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 985
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: T9.b.intercept(F9.z):F9.M");
    }

    public /* synthetic */ b() {
        this(a.f1237H);
    }
}

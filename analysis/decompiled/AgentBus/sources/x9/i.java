package x9;

import d7.z;
import ib.k;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import m.x;
import v9.m0;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f11323a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final c f11324b = c.f11286f;

    /* renamed from: c, reason: collision with root package name */
    public static final a f11325c = new a(e9.f.g(String.format("<Error class: %s>", Arrays.copyOf(new Object[]{"unknown class"}, 1))));

    /* renamed from: d, reason: collision with root package name */
    public static final f f11326d = c(h.f11307m, new String[0]);

    /* renamed from: e, reason: collision with root package name */
    public static final f f11327e = c(h.f11320z, new String[0]);

    /* renamed from: f, reason: collision with root package name */
    public static final Set f11328f = k.S(new d());

    public static final e a(int i2, boolean z4, String... strArr) {
        x.t(i2, "kind");
        q7.k.e(strArr, "formatParams");
        if (!z4) {
            return new e(i2, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        q7.k.e(strArr2, "formatParams");
        return new j(i2, (String[]) Arrays.copyOf(strArr2, strArr2.length));
    }

    public static final e b(int i2, String... strArr) {
        x.t(i2, "kind");
        return a(i2, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final f c(h hVar, String... strArr) {
        q7.k.e(hVar, "kind");
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        q7.k.e(strArr2, "formatParams");
        return e(hVar, z.f2978f, d(hVar, (String[]) Arrays.copyOf(strArr2, strArr2.length)), (String[]) Arrays.copyOf(strArr2, strArr2.length));
    }

    public static g d(h hVar, String... strArr) {
        q7.k.e(hVar, "kind");
        q7.k.e(strArr, "formatParams");
        return new g(hVar, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static f e(h hVar, List list, m0 m0Var, String... strArr) {
        q7.k.e(hVar, "kind");
        q7.k.e(strArr, "formatParams");
        return new f(m0Var, b(7, m0Var.toString()), hVar, list, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final boolean f(f8.j jVar) {
        if (jVar != null) {
            return (jVar instanceof a) || (jVar.p() instanceof a) || jVar == f11324b;
        }
        return false;
    }
}

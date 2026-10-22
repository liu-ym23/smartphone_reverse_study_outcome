package x9;

import d7.z;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import q7.k;
import v9.m0;

/* loaded from: classes.dex */
public final class g implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public final h f11299a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f11300b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11301c;

    public g(h hVar, String... strArr) {
        k.e(hVar, "kind");
        k.e(strArr, "formatParams");
        this.f11299a = hVar;
        this.f11300b = strArr;
        String str = hVar.f11321f;
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        this.f11301c = String.format("[Error type: %s]", Arrays.copyOf(new Object[]{String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length))}, 1));
    }

    @Override // v9.m0
    public final boolean a() {
        return false;
    }

    @Override // v9.m0
    public final f8.g c() {
        i.f11323a.getClass();
        return i.f11325c;
    }

    @Override // v9.m0
    public final Collection d() {
        return z.f2978f;
    }

    @Override // v9.m0
    public final List getParameters() {
        return z.f2978f;
    }

    @Override // v9.m0
    public final c8.h n() {
        c8.e eVar = c8.e.f1994f;
        return c8.e.f1994f;
    }

    public final String toString() {
        return this.f11301c;
    }
}

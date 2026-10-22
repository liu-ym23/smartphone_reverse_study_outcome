package ab;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public boolean f548a = true;

    /* renamed from: b, reason: collision with root package name */
    public String[] f549b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f550c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f551d;

    public final i a() {
        return new i(this.f548a, this.f551d, this.f549b, this.f550c);
    }

    public final void b(g... gVarArr) {
        q7.k.e(gVarArr, "cipherSuites");
        if (!this.f548a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(gVarArr.length);
        for (g gVar : gVarArr) {
            arrayList.add(gVar.f547a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        c((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void c(String... strArr) {
        q7.k.e(strArr, "cipherSuites");
        if (!this.f548a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        this.f549b = (String[]) strArr.clone();
    }

    public final void d(d0... d0VarArr) {
        if (!this.f548a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(d0VarArr.length);
        for (d0 d0Var : d0VarArr) {
            arrayList.add(d0Var.f524f);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        e((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void e(String... strArr) {
        q7.k.e(strArr, "tlsVersions");
        if (!this.f548a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        this.f550c = (String[]) strArr.clone();
    }
}

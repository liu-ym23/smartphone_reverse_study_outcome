package g;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2822a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2823b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2824c;
    public Serializable d;

    public n6.h a() {
        return new n6.h(this.f2822a, this.f2823b, (String[]) this.f2824c, (String[]) this.d);
    }

    public void b(String... cipherSuites) {
        kotlin.jvm.internal.p.e(cipherSuites, "cipherSuites");
        if (!this.f2822a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        if (cipherSuites.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        Object[] objArrCopyOf = Arrays.copyOf(cipherSuites, cipherSuites.length);
        kotlin.jvm.internal.p.d(objArrCopyOf, "copyOf(...)");
        this.f2824c = (String[]) objArrCopyOf;
    }

    public void c(n6.g... cipherSuites) {
        kotlin.jvm.internal.p.e(cipherSuites, "cipherSuites");
        if (!this.f2822a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(cipherSuites.length);
        for (n6.g gVar : cipherSuites) {
            arrayList.add(gVar.f4031a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        b((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Serializable, java.lang.String[]] */
    public void d(String... tlsVersions) {
        kotlin.jvm.internal.p.e(tlsVersions, "tlsVersions");
        if (!this.f2822a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        if (tlsVersions.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        Object[] objArrCopyOf = Arrays.copyOf(tlsVersions, tlsVersions.length);
        kotlin.jvm.internal.p.d(objArrCopyOf, "copyOf(...)");
        this.d = (String[]) objArrCopyOf;
    }

    public void e(n6.y... yVarArr) {
        if (!this.f2822a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(yVarArr.length);
        for (n6.y yVar : yVarArr) {
            arrayList.add(yVar.f4172a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        d((String[]) Arrays.copyOf(strArr, strArr.length));
    }
}

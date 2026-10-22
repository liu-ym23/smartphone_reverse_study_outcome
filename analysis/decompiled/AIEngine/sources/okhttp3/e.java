package okhttp3;

import bd.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import mb.m;
import okhttp3.TlsVersion;
import okhttp3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final List<c> f10964e;

    /* renamed from: f, reason: collision with root package name */
    public static final List<c> f10965f;

    /* renamed from: g, reason: collision with root package name */
    public static final e f10966g;
    public static final e h;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10967a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10968b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f10969c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f10970d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10971a = true;

        /* renamed from: b, reason: collision with root package name */
        public String[] f10972b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f10973c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10974d;

        public final e a() {
            return new e(this.f10971a, this.f10974d, this.f10972b, this.f10973c);
        }

        public final void b(String... cipherSuites) {
            kotlin.jvm.internal.g.f(cipherSuites, "cipherSuites");
            if (!this.f10971a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            if (cipherSuites.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            Object[] objArrCopyOf = Arrays.copyOf(cipherSuites, cipherSuites.length);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            this.f10972b = (String[]) objArrCopyOf;
        }

        public final void c(c... cipherSuites) {
            kotlin.jvm.internal.g.f(cipherSuites, "cipherSuites");
            if (!this.f10971a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (c cVar : cipherSuites) {
                arrayList.add(cVar.f10962a);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            b((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final void d(String... tlsVersions) {
            kotlin.jvm.internal.g.f(tlsVersions, "tlsVersions");
            if (!this.f10971a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            if (tlsVersions.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            Object[] objArrCopyOf = Arrays.copyOf(tlsVersions, tlsVersions.length);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            this.f10973c = (String[]) objArrCopyOf;
        }

        public final void e(TlsVersion... tlsVersionArr) {
            if (!this.f10971a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.f10922a);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            d((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    static {
        c cVar = c.r;
        c cVar2 = c.f10960s;
        c cVar3 = c.f10961t;
        c cVar4 = c.f10954l;
        c cVar5 = c.f10956n;
        c cVar6 = c.f10955m;
        c cVar7 = c.f10957o;
        c cVar8 = c.f10959q;
        c cVar9 = c.f10958p;
        List<c> listB0 = m.b0(cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9);
        f10964e = listB0;
        List<c> listB02 = m.b0(cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9, c.f10952j, c.f10953k, c.h, c.f10951i, c.f10949f, c.f10950g, c.f10948e);
        f10965f = listB02;
        a aVar = new a();
        c[] cVarArr = (c[]) listB0.toArray(new c[0]);
        aVar.c((c[]) Arrays.copyOf(cVarArr, cVarArr.length));
        TlsVersion tlsVersion = TlsVersion.f10917c;
        TlsVersion tlsVersion2 = TlsVersion.f10918d;
        aVar.e(tlsVersion, tlsVersion2);
        aVar.f10974d = true;
        aVar.a();
        a aVar2 = new a();
        c[] cVarArr2 = (c[]) listB02.toArray(new c[0]);
        aVar2.c((c[]) Arrays.copyOf(cVarArr2, cVarArr2.length));
        aVar2.e(tlsVersion, tlsVersion2);
        aVar2.f10974d = true;
        f10966g = aVar2.a();
        a aVar3 = new a();
        c[] cVarArr3 = (c[]) listB02.toArray(new c[0]);
        aVar3.c((c[]) Arrays.copyOf(cVarArr3, cVarArr3.length));
        aVar3.e(tlsVersion, tlsVersion2, TlsVersion.f10919e, TlsVersion.h);
        aVar3.f10974d = true;
        aVar3.a();
        h = new e(false, false, null, null);
    }

    public e(boolean z, boolean z3, String[] strArr, String[] strArr2) {
        this.f10967a = z;
        this.f10968b = z3;
        this.f10969c = strArr;
        this.f10970d = strArr2;
    }

    public final void a(SSLSocket sSLSocket, boolean z) {
        String[] enabledProtocols;
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        kotlin.jvm.internal.g.c(enabledCipherSuites);
        String[] strArr = this.f10969c;
        if (strArr != null) {
            enabledCipherSuites = i.j(strArr, enabledCipherSuites, c.f10946c);
        }
        String[] strArr2 = this.f10970d;
        if (strArr2 != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            kotlin.jvm.internal.g.e(enabledProtocols2, "getEnabledProtocols(...)");
            enabledProtocols = i.j(enabledProtocols2, strArr2, ob.c.f10852a);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        kotlin.jvm.internal.g.c(supportedCipherSuites);
        c.a aVar = c.f10946c;
        byte[] bArr = i.f3230a;
        int length = supportedCipherSuites.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (aVar.compare(supportedCipherSuites[i10], "TLS_FALLBACK_SCSV") == 0) {
                break;
            } else {
                i10++;
            }
        }
        if (z && i10 != -1) {
            String str = supportedCipherSuites[i10];
            kotlin.jvm.internal.g.e(str, "get(...)");
            kotlin.jvm.internal.g.f(enabledCipherSuites, "<this>");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        a aVar2 = new a();
        aVar2.f10971a = this.f10967a;
        aVar2.f10972b = strArr;
        aVar2.f10973c = strArr2;
        aVar2.f10974d = this.f10968b;
        aVar2.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        kotlin.jvm.internal.g.c(enabledProtocols);
        aVar2.d((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        e eVarA = aVar2.a();
        if (eVarA.c() != null) {
            sSLSocket.setEnabledProtocols(eVarA.f10970d);
        }
        if (eVarA.b() != null) {
            sSLSocket.setEnabledCipherSuites(eVarA.f10969c);
        }
    }

    public final ArrayList b() {
        String[] strArr = this.f10969c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(c.f10945b.b(str));
        }
        return arrayList;
    }

    public final ArrayList c() {
        String[] strArr = this.f10970d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            TlsVersion.f10916b.getClass();
            arrayList.add(TlsVersion.a.a(str));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        e eVar = (e) obj;
        boolean z = eVar.f10967a;
        boolean z3 = this.f10967a;
        if (z3 != z) {
            return false;
        }
        if (z3) {
            return Arrays.equals(this.f10969c, eVar.f10969c) && Arrays.equals(this.f10970d, eVar.f10970d) && this.f10968b == eVar.f10968b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f10967a) {
            return 17;
        }
        String[] strArr = this.f10969c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f10970d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f10968b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f10967a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f10968b + ')';
    }
}

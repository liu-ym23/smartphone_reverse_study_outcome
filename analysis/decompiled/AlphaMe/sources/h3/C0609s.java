package h3;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: h3.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0609s {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12963a = true;

    /* renamed from: b, reason: collision with root package name */
    public String[] f12964b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f12965c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12966d;

    public final C0610t a() {
        return new C0610t(this.f12963a, this.f12966d, this.f12964b, this.f12965c);
    }

    public final void b(C0607p... cipherSuites) {
        Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
        if (!this.f12963a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }
        ArrayList arrayList = new ArrayList(cipherSuites.length);
        for (C0607p c0607p : cipherSuites) {
            arrayList.add(c0607p.f12961a);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        String[] strArr = (String[]) array;
        c((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void c(String... cipherSuites) {
        Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
        if (!this.f12963a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }
        if (!(!(cipherSuites.length == 0))) {
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        }
        this.f12964b = (String[]) cipherSuites.clone();
    }

    public final void d() {
        if (!this.f12963a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }
        this.f12966d = true;
    }

    public final void e(h0... tlsVersions) {
        Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
        if (!this.f12963a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }
        ArrayList arrayList = new ArrayList(tlsVersions.length);
        for (h0 h0Var : tlsVersions) {
            arrayList.add(h0Var.f12919a);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        String[] strArr = (String[]) array;
        f((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void f(String... tlsVersions) {
        Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
        if (!this.f12963a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }
        if (!(!(tlsVersions.length == 0))) {
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        }
        this.f12965c = (String[]) tlsVersions.clone();
    }
}

package M9;

import okio.ByteString;
import s2.C1912a;

/* renamed from: M9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0247a {
    public static final ByteString d;
    public static final ByteString e;
    public static final ByteString f;
    public static final ByteString g;
    public static final ByteString h;
    public static final ByteString i;

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f976a;
    public final ByteString b;
    public final int c;

    static {
        ByteString byteString = ByteString.d;
        d = C1912a.i(":");
        e = C1912a.i(":status");
        f = C1912a.i(":method");
        g = C1912a.i(":path");
        h = C1912a.i(":scheme");
        i = C1912a.i(":authority");
    }

    public C0247a(ByteString name, ByteString value) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(value, "value");
        this.f976a = name;
        this.b = value;
        this.c = value.c() + name.c() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0247a)) {
            return false;
        }
        C0247a c0247a = (C0247a) obj;
        return kotlin.jvm.internal.k.b(this.f976a, c0247a.f976a) && kotlin.jvm.internal.k.b(this.b, c0247a.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f976a.hashCode() * 31);
    }

    public final String toString() {
        return this.f976a.j() + ": " + this.b.j();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0247a(String name, String value) {
        this(C1912a.i(name), C1912a.i(value));
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(value, "value");
        ByteString byteString = ByteString.d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0247a(ByteString name, String value) {
        this(name, C1912a.i(value));
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(value, "value");
        ByteString byteString = ByteString.d;
    }
}

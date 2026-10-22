package hd;

import kotlin.jvm.internal.g;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f9406d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f9407e;

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f9408f;

    /* renamed from: g, reason: collision with root package name */
    public static final ByteString f9409g;
    public static final ByteString h;

    /* renamed from: i, reason: collision with root package name */
    public static final ByteString f9410i;

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f9411a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteString f9412b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9413c;

    static {
        ByteString byteString = ByteString.f11312d;
        f9406d = ByteString.a.b(":");
        f9407e = ByteString.a.b(":status");
        f9408f = ByteString.a.b(":method");
        f9409g = ByteString.a.b(":path");
        h = ByteString.a.b(":scheme");
        f9410i = ByteString.a.b(":authority");
    }

    public a(ByteString name, ByteString value) {
        g.f(name, "name");
        g.f(value, "value");
        this.f9411a = name;
        this.f9412b = value;
        this.f9413c = value.d() + name.d() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return g.b(this.f9411a, aVar.f9411a) && g.b(this.f9412b, aVar.f9412b);
    }

    public final int hashCode() {
        return this.f9412b.hashCode() + (this.f9411a.hashCode() * 31);
    }

    public final String toString() {
        return this.f9411a.r() + ": " + this.f9412b.r();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str, String str2) {
        this(ByteString.a.b(str), ByteString.a.b(str2));
        ByteString byteString = ByteString.f11312d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(ByteString name, String value) {
        this(name, ByteString.a.b(value));
        g.f(name, "name");
        g.f(value, "value");
        ByteString byteString = ByteString.f11312d;
    }
}

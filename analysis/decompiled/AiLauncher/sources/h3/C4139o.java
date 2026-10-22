package h3;

import com.autonavi.aps.amapapi.config.Const;

/* renamed from: h3.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4139o {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f32932a;

    /* renamed from: b, reason: collision with root package name */
    public final int f32933b;

    /* renamed from: c, reason: collision with root package name */
    public final int f32934c;

    public C4139o(Class<?> cls, int i10, int i11) {
        this.f32932a = (Class) w.c(cls, "Null dependency anInterface.");
        this.f32933b = i10;
        this.f32934c = i11;
    }

    public static String a(int i10) {
        if (i10 == 0) {
            return "direct";
        }
        if (i10 == 1) {
            return Const.JSON_KEY_PROVIDER;
        }
        if (i10 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i10);
    }

    public static C4139o g(Class<?> cls) {
        return new C4139o(cls, 1, 0);
    }

    public static C4139o h(Class<?> cls) {
        return new C4139o(cls, 1, 1);
    }

    public static C4139o i(Class<?> cls) {
        return new C4139o(cls, 2, 0);
    }

    public Class<?> b() {
        return this.f32932a;
    }

    public boolean c() {
        return this.f32934c == 2;
    }

    public boolean d() {
        return this.f32934c == 0;
    }

    public boolean e() {
        return this.f32933b == 1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C4139o) {
            C4139o c4139o = (C4139o) obj;
            if (this.f32932a == c4139o.f32932a && this.f32933b == c4139o.f32933b && this.f32934c == c4139o.f32934c) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f32933b == 2;
    }

    public int hashCode() {
        return this.f32934c ^ ((((this.f32932a.hashCode() ^ 1000003) * 1000003) ^ this.f32933b) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f32932a);
        sb2.append(", type=");
        int i10 = this.f32933b;
        sb2.append(i10 == 1 ? "required" : i10 == 0 ? "optional" : "set");
        sb2.append(", injection=");
        sb2.append(a(this.f32934c));
        sb2.append("}");
        return sb2.toString();
    }
}

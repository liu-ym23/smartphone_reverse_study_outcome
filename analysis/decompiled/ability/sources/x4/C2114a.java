package x4;

import kotlin.jvm.internal.k;

/* renamed from: x4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2114a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6881a;
    public final String b;
    public final String c;
    public final String d;

    public C2114a(String method, String description, String inputSchema, String packageName) {
        k.f(method, "method");
        k.f(description, "description");
        k.f(inputSchema, "inputSchema");
        k.f(packageName, "packageName");
        this.f6881a = method;
        this.b = description;
        this.c = inputSchema;
        this.d = packageName;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2114a)) {
            return false;
        }
        C2114a c2114a = (C2114a) obj;
        return k.b(this.f6881a, c2114a.f6881a) && k.b(this.b, c2114a.b) && k.b(this.c, c2114a.c) && k.b(this.d, c2114a.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + B7.a.c(B7.a.c(this.f6881a.hashCode() * 31, 31, this.b), 31, this.c);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.p(B7.a.w("AbilityMetaDataInfo(method=", this.f6881a, ", description=", this.b, ", inputSchema="), this.c, ", packageName=", this.d, ")");
    }
}

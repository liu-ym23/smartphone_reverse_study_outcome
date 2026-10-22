package O8;

import O8.h;

/* loaded from: classes4.dex */
public class j implements h.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f5279a;

    public j(String str) {
        this.f5279a = str;
    }

    @Override // O8.h.b
    public int d() {
        return this.f5279a.length();
    }

    @Override // O8.h.b
    public final boolean e() {
        return false;
    }

    @Override // O8.h.e
    public String f() {
        return this.f5279a;
    }

    public String toString() {
        return "TextImpl{literal='" + this.f5279a + "'}";
    }
}

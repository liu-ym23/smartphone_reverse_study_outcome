package E4;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f476a;
    public final int b;
    public final int c;
    public final String d;

    public f(int i, String message, int i6, boolean z10) {
        k.f(message, "message");
        this.f476a = z10;
        this.b = i;
        this.c = i6;
        this.d = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f476a == fVar.f476a && this.b == fVar.b && this.c == fVar.c && k.b(this.d, fVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.c, androidx.constraintlayout.core.dsl.a.a(this.b, Boolean.hashCode(this.f476a) * 31, 31), 31);
    }

    public final String toString() {
        return "VerifyResult(pass=" + this.f476a + ", code=" + this.b + ", confidence=" + this.c + ", message=" + this.d + ")";
    }
}

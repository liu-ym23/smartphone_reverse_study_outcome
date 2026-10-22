package d4;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f4291a;
    public final int b;
    public final int c;

    public c(int i, int i6, int i10) {
        this.f4291a = i;
        this.b = i6;
        this.c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f4291a == cVar.f4291a && this.b == cVar.b && this.c == cVar.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + androidx.constraintlayout.core.dsl.a.a(this.b, Integer.hashCode(this.f4291a) * 31, 31);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.o(androidx.appfunctions.metadata.a.s(this.f4291a, "CloudMergeStats(patched=", this.b, ", inserted=", ", skipped="), ")", this.c);
    }
}

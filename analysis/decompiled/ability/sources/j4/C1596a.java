package j4;

import kotlin.jvm.internal.k;

/* renamed from: j4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1596a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4772a;
    public final int b;

    public C1596a(String toolName, int i) {
        k.f(toolName, "toolName");
        this.f4772a = toolName;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1596a)) {
            return false;
        }
        C1596a c1596a = (C1596a) obj;
        return k.b(this.f4772a, c1596a.f4772a) && this.b == c1596a.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f4772a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.constraintlayout.core.dsl.a.d(this.b, "DocTermFreq(toolName=", this.f4772a, ", freq=", ")");
    }
}

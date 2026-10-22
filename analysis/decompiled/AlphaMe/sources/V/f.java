package V;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f1923a;

    public f(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f1923a = name;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return Intrinsics.areEqual(this.f1923a, ((f) obj).f1923a);
    }

    public final int hashCode() {
        return this.f1923a.hashCode();
    }

    public final String toString() {
        return this.f1923a;
    }
}

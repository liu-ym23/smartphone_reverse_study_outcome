package n5;

import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f10641a;

    public b(String str) {
        this.f10641a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return Objects.equals(this.f10641a, ((b) obj).f10641a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f10641a);
    }

    public final String toString() {
        return ai.onnxruntime.a.o(new StringBuilder("TextCheckResult(decision="), this.f10641a, ")");
    }
}

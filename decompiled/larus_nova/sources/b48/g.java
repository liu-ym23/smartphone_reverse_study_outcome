package b48;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f17619a;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f17619a, ((g) r100).f17619a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f17619a.hashCode();
    }

    public final String toString() {
        return "AccountOperationResult(extra=" + this.f17619a + ')';
    }

    public g(Object r100) {
        Map<String, Object> r101 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f17619a = r101;
    }
}

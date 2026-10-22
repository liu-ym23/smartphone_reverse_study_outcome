package b30;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f17116a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f17116a, ((b0) r100).f17116a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.f17116a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SetStarGraphTaskEvent(args=" + this.f17116a + ")";
    }

    public b0(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        this.f17116a = r100;
    }
}

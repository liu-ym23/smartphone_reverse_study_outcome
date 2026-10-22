package ah;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f3405a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f3405a, ((i) r100).f3405a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        JSONObject r100 = this.f3405a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ShowNormalStateEvent(params=" + this.f3405a + ")";
    }

    public i(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f3405a = r100;
    }
}

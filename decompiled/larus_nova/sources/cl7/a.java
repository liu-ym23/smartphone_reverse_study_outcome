package cl7;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f24112a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f24112a, ((a) r100).f24112a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        JSONObject r100 = this.f24112a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CrossOverGuideInfo(guideInfo=" + this.f24112a + ")";
    }

    public a(JSONObject r100) {
        this.f24112a = r100;
    }
}

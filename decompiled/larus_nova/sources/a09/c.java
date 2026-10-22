package a09;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f1328b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f1327a == r101.f1327a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1328b, r101.f1328b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f1327a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        JSONObject r102 = this.f1328b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommonResponse(success=" + this.f1327a + ", data=" + this.f1328b + ')';
    }

    public c(int r100) {
        JSONObject r101 = new JSONObject();
        this.f1327a = true;
        this.f1328b = r101;
    }
}

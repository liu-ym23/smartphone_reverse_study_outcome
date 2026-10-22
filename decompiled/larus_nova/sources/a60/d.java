package a60;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.core.monitor.trace.e f1934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f1935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f1936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f1937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1938e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f1934a, r101.f1934a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f1935b, r101.f1935b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f1936c, r101.f1936c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1937d, r101.f1937d) == true) goto L14;
        return false;
    L14:
        if (this.f1938e == r101.f1938e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.core.monitor.trace.e r100 = this.f1934a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f1935b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f1936c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.f1937d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return ((r109 + r101) * 31) + this.f1938e;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TraceEvent(traceMeta=" + this.f1934a + ", category=" + this.f1935b + ", metric=" + this.f1936c + ", extra=" + this.f1937d + ", size=" + this.f1938e + ")";
    }

    public d(com.bytedance.android.live.core.monitor.trace.e r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "traceMeta");
        this.f1934a = r100;
        this.f1935b = r101;
        this.f1936c = r102;
        this.f1937d = r103;
        this.f1938e = 0;
    }
}

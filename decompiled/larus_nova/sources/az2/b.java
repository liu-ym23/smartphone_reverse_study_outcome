package az2;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16797d;

    public final py2.b a() {
        Map<String, Object> r100 = MapsKt.mapOf(new Pair[]{TuplesKt.to("container_load_error_code", Integer.valueOf(this.f16794a)), TuplesKt.to("container_load_error_msg", this.f16795b)});
        py2.b r101 = new py2.b(new ArrayList());
        if (r100 == null) goto L5;
        r101.f530980a.add(r100);
    L5:
        return r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L19:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (this.f16794a != r101.f16794a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L18;
        if (Intrinsics.areEqual(this.f16795b, r101.f16795b) == false) goto L18;
        if (Intrinsics.areEqual(this.f16796c, r101.f16796c) == false) goto L18;
        if (Intrinsics.areEqual(this.f16797d, r101.f16797d) == false) goto L18;
    L9:
        r102 = false;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f16794a * 31;
        String r101 = this.f16795b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f16796c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f16797d;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ContainerError(errCode=" + this.f16794a + ", errorMsg=" + this.f16795b + ", virtualAid=" + this.f16796c + ", biz=" + this.f16797d + ")";
    }

    public b(int r100, String r101, String r102) {
        this.f16794a = r100;
        this.f16795b = r101;
        this.f16796c = r102;
        this.f16797d = "";
    }
}

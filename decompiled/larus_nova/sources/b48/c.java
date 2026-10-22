package b48;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f17603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f17605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f17607g;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f17601a == r101.f17601a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17602b, r101.f17602b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17603c, r101.f17603c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17604d, r101.f17604d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f17605e, r101.f17605e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f17606f, r101.f17606f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f17607g, r101.f17607g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f17601a * 31;
        String r101 = this.f17602b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Throwable r105 = this.f17603c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f17604d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f17605e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f17606f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return ((r113 + r102) * 31) + this.f17607g.hashCode();
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccountError(code=" + this.f17601a + ", message=" + this.f17602b + ", throwable=" + this.f17603c + ", profileKey=" + this.f17604d + ", originCode=" + this.f17605e + ", originMessage=" + this.f17606f + ", extra=" + this.f17607g + ')';
    }

    public c(int r100, String r101) {
        Map<String, Object> r102 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f17601a = r100;
        this.f17602b = r101;
        this.f17603c = null;
        this.f17604d = null;
        this.f17605e = null;
        this.f17606f = null;
        this.f17607g = r102;
    }
}

package ae1;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f3073i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L24;
        c r101 = (c) r100;
        if (this.f3065a == r101.f3065a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f3066b, r101.f3066b) == true) goto L10;
        return false;
    L10:
        if (this.f3067c == r101.f3067c) goto L12;
        return false;
    L12:
        if (this.f3068d == r101.f3068d) goto L14;
        return false;
    L14:
        if (this.f3069e == r101.f3069e) goto L16;
        return false;
    L16:
        if (this.f3070f == r101.f3070f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f3071g, r101.f3071g) == true) goto L20;
        return false;
    L20:
        if (this.f3072h == r101.f3072h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f3073i, r101.f3073i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f3065a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f3066b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (((((r101 + r104) * 31) + this.f3067c) * 31) + this.f3068d) * 31;
        long r106 = this.f3069e;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f3070f;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        String r110 = this.f3071g;
        if (r110 == null) goto L9;
        int r111 = r110.hashCode();
    L10:
        int r112 = (((r109 + r111) * 31) + this.f3072h) * 31;
        Object r113 = this.f3073i;
        if (r113 == null) goto L14;
        r103 = r113.hashCode();
    L14:
        return r112 + r103;
    L9:
        r111 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveRemindEvent(eventTime=" + this.f3065a + ", identifier=" + this.f3066b + ", remind=" + this.f3067c + ", rule=" + this.f3068d + ", timeToAlive=" + this.f3069e + ", relaxDuration=" + this.f3070f + ", extraTag=" + this.f3071g + ", remainedTime=" + this.f3072h + ", originEvent=" + this.f3073i + ")";
    }

    public c() {
        Object r100 = new Object();
        Intrinsics.checkNotNullParameter("", LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter("", "extraTag");
        Intrinsics.checkNotNullParameter(r100, "originEvent");
        this.f3065a = 0;
        this.f3066b = "";
        this.f3067c = 0;
        this.f3068d = 0;
        this.f3069e = 0;
        this.f3070f = 0;
        this.f3071g = "";
        this.f3072h = -1;
        this.f3073i = r100;
    }

    public final String getIdentifier() {
        return this.f3066b;
    }
}

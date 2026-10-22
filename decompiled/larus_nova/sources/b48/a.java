package b48;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f17590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17592e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f17588a, r101.f17588a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17589b, r101.f17589b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17590c, r101.f17590c) == true) goto L18;
        return false;
    L18:
        if (this.f17591d == r101.f17591d) goto L21;
        return false;
    L21:
        if (this.f17592e == r101.f17592e) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = ((((this.f17588a.hashCode() * 31) + this.f17589b.hashCode()) * 31) + this.f17590c.hashCode()) * 31;
        long r101 = this.f17591d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        boolean r103 = this.f17592e;
        ?? r104 = r103;
        if (r103 == false) goto L6;
        r104 = 1;
    L6:
        return r102 + r104;
    }

    public final String toString() {
        return "AccountBaseConfig(appName=" + this.f17588a + ", host=" + this.f17589b + ", hostList=" + this.f17590c + ", updateInterval=" + this.f17591d + ", tokenSign=" + this.f17592e + ')';
    }

    public a(String r100, String r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "appName");
        Intrinsics.checkNotNullParameter(r101, "host");
        Intrinsics.checkNotNullParameter(r102, "hostList");
        this.f17588a = r100;
        this.f17589b = r101;
        this.f17590c = r102;
        this.f17591d = 600000;
        this.f17592e = true;
    }
}

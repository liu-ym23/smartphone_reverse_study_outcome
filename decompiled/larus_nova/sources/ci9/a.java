package ci9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23897d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f23894a, r101.f23894a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23895b, r101.f23895b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23896c, r101.f23896c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f23897d, r101.f23897d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f23894a.hashCode() * 31) + this.f23895b.hashCode()) * 31;
        String r101 = this.f23896c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f23897d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LbsTraceContextParam(traceName=" + this.f23894a + ", traceId=" + this.f23895b + ", pageId=" + this.f23896c + ", widgetInstanceId=" + this.f23897d + ')';
    }

    public a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "traceName");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        this.f23894a = r100;
        this.f23895b = r101;
        this.f23896c = r102;
        this.f23897d = r103;
    }
}

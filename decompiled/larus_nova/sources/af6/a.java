package af6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3176d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f3173a, r101.f3173a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3174b, r101.f3174b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3175c, r101.f3175c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f3176d, r101.f3176d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f3173a.hashCode() * 31) + this.f3174b.hashCode()) * 31;
        String r101 = this.f3175c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f3176d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TraceContext(traceName=" + this.f3173a + ", traceId=" + this.f3174b + ", pageId=" + this.f3175c + ", widgetInstanceId=" + this.f3176d + ')';
    }

    public a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "traceName");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        this.f3173a = r100;
        this.f3174b = r101;
        this.f3175c = r102;
        this.f3176d = r103;
    }
}

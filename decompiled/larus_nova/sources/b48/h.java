package b48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17625f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f17620a, r101.f17620a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17621b, r101.f17621b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17622c, r101.f17622c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17623d, r101.f17623d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f17624e, r101.f17624e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f17625f, r101.f17625f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f17620a.hashCode() * 31) + this.f17621b.hashCode()) * 31) + this.f17622c.hashCode()) * 31) + this.f17623d.hashCode()) * 31;
        String r101 = this.f17624e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f17625f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccountShareInfo(providerAppId=" + this.f17620a + ", providerAppName=" + this.f17621b + ", providerPackageName=" + this.f17622c + ", secUserId=" + this.f17623d + ", userName=" + this.f17624e + ", userAvatar=" + this.f17625f + ')';
    }

    public h(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "providerAppId");
        Intrinsics.checkNotNullParameter(r101, "providerAppName");
        Intrinsics.checkNotNullParameter(r102, "providerPackageName");
        Intrinsics.checkNotNullParameter(r103, "secUserId");
        this.f17620a = r100;
        this.f17621b = r101;
        this.f17622c = r102;
        this.f17623d = r103;
        this.f17624e = r104;
        this.f17625f = r105;
    }
}

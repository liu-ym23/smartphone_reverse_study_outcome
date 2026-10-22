package b48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17635c;

    public j() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f17633a, r101.f17633a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17634b, r101.f17634b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17635c, r101.f17635c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f17633a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f17634b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f17635c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AvatarInfo(uri=" + this.f17633a + ", tinyUrl=" + this.f17634b + ", originUrl=" + this.f17635c + ')';
    }

    public j(String r100, String r101, String r102) {
        this.f17633a = r100;
        this.f17634b = r101;
        this.f17635c = r102;
    }
}

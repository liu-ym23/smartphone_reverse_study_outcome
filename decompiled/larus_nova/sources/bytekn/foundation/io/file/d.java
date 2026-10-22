package bytekn.foundation.io.file;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f21791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f21792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Double f21793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f21794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f21795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FileType f21796g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f21790a, r101.f21790a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f21791b, r101.f21791b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f21792c, r101.f21792c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21793d, r101.f21793d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f21794e, r101.f21794e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f21795f, r101.f21795f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f21796g, r101.f21796g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f21790a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f r104 = this.f21791b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        f r107 = this.f21792c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.f21793d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.f21794e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f21795f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        FileType r119 = this.f21796g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "FileMeta(name=" + this.f21790a + ", absolutePath=" + this.f21791b + ", canonicalPath=" + this.f21792c + ", createdAt=" + this.f21793d + ", modifiedAt=" + this.f21794e + ", size=" + this.f21795f + ", type=" + this.f21796g + ")";
    }

    public final FileType getType() {
        return this.f21796g;
    }

    public d(String r100, f r101, f r102, Double r103, Double r104, Long r105, FileType r106) {
        this.f21790a = r100;
        this.f21791b = r101;
        this.f21792c = r102;
        this.f21793d = r103;
        this.f21794e = r104;
        this.f21795f = r105;
        this.f21796g = r106;
    }
}

package bm8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f19624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f19625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f19626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f19627d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f19624a, r101.f19624a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19625b, r101.f19625b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19626c, r101.f19626c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f19627d, r101.f19627d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f19624a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f19625b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f19626c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f19627d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletContainerUIConfig(enableStroke=" + this.f19624a + ", radius=" + this.f19625b + ", strokeColor=" + this.f19626c + ", strokeWidth=" + this.f19627d + ')';
    }

    public a(Boolean r100, Float r101, Integer r102, Integer r103) {
        this.f19624a = r100;
        this.f19625b = r101;
        this.f19626c = r102;
        this.f19627d = r103;
    }
}

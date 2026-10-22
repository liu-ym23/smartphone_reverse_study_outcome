package cg;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECUrlModel f23559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f23562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f23563g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (this.f23557a == r101.f23557a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23558b, r101.f23558b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f23559c, r101.f23559c) == true) goto L12;
        return false;
    L12:
        if (this.f23560d == r101.f23560d) goto L14;
        return false;
    L14:
        if (this.f23561e == r101.f23561e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f23562f, r101.f23562f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f23563g, r101.f23563g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f23557a * 31;
        String r101 = this.f23558b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        ECUrlModel r105 = this.f23559c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f23560d) * 31) + this.f23561e) * 31;
        String r108 = this.f23562f;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f23563g;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ChartEntryOptimizeVO(type=" + this.f23557a + ", text=" + this.f23558b + ", icon=" + this.f23559c + ", iconWidth=" + this.f23560d + ", iconHeight=" + this.f23561e + ", url=" + this.f23562f + ", recommend=" + this.f23563g + ")";
    }

    public final int getType() {
        return this.f23557a;
    }

    public b(String r100, int r101, int r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f23557a = 1;
        this.f23558b = r100;
        this.f23559c = null;
        this.f23560d = r101;
        this.f23561e = r102;
        this.f23562f = r103;
        this.f23563g = r104;
    }
}

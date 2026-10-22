package cg;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECUrlModel f23566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f23569f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (this.f23564a == r101.f23564a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23565b, r101.f23565b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f23566c, r101.f23566c) == true) goto L12;
        return false;
    L12:
        if (this.f23567d == r101.f23567d) goto L14;
        return false;
    L14:
        if (this.f23568e == r101.f23568e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f23569f, r101.f23569f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f23564a * 31;
        String r101 = this.f23565b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        ECUrlModel r105 = this.f23566c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f23567d) * 31) + this.f23568e) * 31;
        String r108 = this.f23569f;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ChartEntryVO(type=" + this.f23564a + ", text=" + this.f23565b + ", icon=" + this.f23566c + ", iconWidth=" + this.f23567d + ", iconHeight=" + this.f23568e + ", url=" + this.f23569f + ")";
    }

    public final int getType() {
        return this.f23564a;
    }

    public c(int r100, String r101, ECUrlModel r102, int r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r105, "url");
        this.f23564a = r100;
        this.f23565b = r101;
        this.f23566c = r102;
        this.f23567d = r103;
        this.f23568e = r104;
        this.f23569f = r105;
    }
}

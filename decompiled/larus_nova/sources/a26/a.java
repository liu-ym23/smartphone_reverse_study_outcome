package a26;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1416c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f1414a, r101.f1414a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1415b, r101.f1415b) == true) goto L15;
        return false;
    L15:
        if (this.f1416c == r101.f1416c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f1414a.hashCode() * 31) + this.f1415b.hashCode()) * 31;
        if (this.f1416c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "RLChannelBundleModel(channel=" + this.f1414a + ", bundlePath=" + this.f1415b + ", valid=" + this.f1416c + ')';
    }

    public final String a() {
        if (this.f1416c == true) goto L7;
        return null;
    L7:
        return this.f1414a;
    }

    public final String b() {
        if (this.f1416c == true) goto L7;
        return null;
    L7:
        return this.f1415b;
    }

    public a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "bundlePath");
        this.f1414a = r100;
        this.f1415b = r101;
        this.f1416c = r102;
    }
}

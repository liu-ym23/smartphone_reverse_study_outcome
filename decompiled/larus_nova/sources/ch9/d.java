package ch9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f23834c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f23832a, r101.f23832a) == true) goto L12;
        return false;
    L12:
        if (this.f23833b == r101.f23833b) goto L15;
        return false;
    L15:
        if (this.f23834c == r101.f23834c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f23832a.hashCode() * 31;
        int r101 = 1231;
        if (this.f23833b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f23834c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceActivityFragmentArgumentPolicy(enterMethod=" + this.f23832a + ", shouldWriteEnterMethod=" + this.f23833b + ", selectVoiceUiMode=" + this.f23834c + ')';
    }

    public d(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        this.f23832a = r100;
        this.f23833b = r101;
        this.f23834c = r102;
    }
}

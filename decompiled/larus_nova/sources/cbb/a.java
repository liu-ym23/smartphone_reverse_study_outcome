package cbb;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f23117c;

    public a() {
        this(false, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f23115a == r101.f23115a) goto L12;
        return false;
    L12:
        if (this.f23116b == r101.f23116b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23117c, r101.f23117c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f23115a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f23116b;
        return (((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f23117c.hashCode();
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "CleanResult(isSuccess=" + this.f23115a + ", cleanSize=" + this.f23116b + ", extra=" + this.f23117c + ')';
    }

    public a(boolean r100, long r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r102 & 4) == 0) goto L11;
        HashMap r103 = new HashMap();
    L12:
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.f23115a = r100;
        this.f23116b = r101;
        this.f23117c = r103;
        return;
    L11:
        r103 = null;
        goto L12
    }
}

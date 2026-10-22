package com.bytedance.android.sdk.bdticketguard.init;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f163793b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f163794a;

    public static final class a {
    }

    static {
    }

    public static final boolean a(long r100) {
        if (r100 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String c(long r100) {
        return "TimePoint(value=" + r100 + ")";
    }

    public final int hashCode() {
        long r100 = this.f163794a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return c(this.f163794a);
    }

    public /* synthetic */ j(long r100) {
        this.f163794a = r100;
    }

    public final boolean equals(Object r100) {
        long r101 = this.f163794a;
        if ((r100 instanceof j) == true) goto L5;
        return false;
    L5:
        if (r101 != ((j) r100).f163794a) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r102 = false;
        goto L8
    }

    public static final long b(long r100, long r101) {
        if (a(r100) == true) goto L5;
    L7:
        return -1;
    L5:
        if (a(r101) == false) goto L7;
        return r101 - r100;
    }
}

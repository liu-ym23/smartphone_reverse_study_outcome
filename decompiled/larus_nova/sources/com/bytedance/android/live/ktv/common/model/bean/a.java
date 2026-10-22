package com.bytedance.android.live.ktv.common.model.bean;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f69993c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f69994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f69995b;

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.model.bean.a$a, reason: collision with other inner class name */
    public static final class C1138a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f69994a == r101.f69994a) goto L8;
        return false;
    L8:
        if (this.f69995b == r101.f69995b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f69994a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f69995b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "CountDownEvent(totalTime=" + this.f69994a + ", leftTime=" + this.f69995b + ")";
    }

    static {
        f69993c = new a(1, 0);
    }

    public a(long r100, long r101) {
        this.f69994a = r100;
        this.f69995b = r101;
    }
}

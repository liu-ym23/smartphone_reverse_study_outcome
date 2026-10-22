package com.bytedance.android.live.revenue.common;

import com.ss.android.download.api.constant.BaseConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u0 implements Comparable<u0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f90995b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f90996c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f90997d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f90998e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u0 f90999f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u0 f91000g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u0 f91001h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u0 f91002i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u0 f91003j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u0 f91004k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f91005l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f91006a;

    public static final class a {
        public a() {
        }

        public static u0 a(long r100) {
            return new u0(r100 * u0.f90995b);
        }
    }

    public /* synthetic */ u0() {
        throw null;
    }

    static {
        f91005l = new a();
        long r100 = 1000;
        f90995b = r100;
        long r101 = 60000;
        f90996c = r101;
        long r102 = BaseConstants.Time.HOUR;
        f90997d = r102;
        long r103 = BaseConstants.Time.DAY;
        f90998e = r103;
        f90999f = new u0(0);
        f91000g = new u0(r100);
        f91001h = new u0(r101);
        f91002i = new u0(r102);
        f91003j = new u0(r103);
        f91004k = new u0(r103 * ((long) 7));
    }

    public final int hashCode() {
        long r100 = this.f91006a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        long r100 = this.f91006a;
        long r101 = 0;
        if (r100 != r101) goto L5;
        return "0s";
    L5:
        long r102 = f90997d;
        if ((r100 % r102) != r101) goto L8;
        StringBuilder r103 = new StringBuilder();
        r103.append(this.f91006a / r102);
        r103.append('h');
        return r103.toString();
    L8:
        long r104 = f90996c;
        if ((r100 % r104) != r101) goto L11;
        StringBuilder r105 = new StringBuilder();
        r105.append(this.f91006a / r104);
        r105.append('m');
        return r105.toString();
    L11:
        long r106 = f90995b;
        if ((r100 % r106) != r101) goto L15;
        StringBuilder r107 = new StringBuilder();
        r107.append(this.f91006a / r106);
        r107.append('s');
        return r107.toString();
    L15:
        return this.f91006a + "ms";
    }

    public u0(long r100) {
        this.f91006a = r100;
    }

    public final int a(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return (this.f91006a > r100.f91006a ? 1 : (this.f91006a == r100.f91006a ? 0 : -1));
    }

    public final u0 b(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, "rhs");
        return new u0(this.f91006a - r100.f91006a);
    }

    public final u0 c(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, "rhs");
        return new u0(this.f91006a + r100.f91006a);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(u0 r100) {
        return a(r100);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof u0) == true) goto L7;
        return super.equals(r100);
    L7:
        if (this.f91006a != ((u0) r100).f91006a) goto L9;
        return true;
    L9:
        return false;
    }
}

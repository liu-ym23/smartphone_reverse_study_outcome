package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
public interface j extends dy0.c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f88897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f88898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f88899c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f88897a == r101.f88897a) goto L8;
            return false;
        L8:
            if (this.f88898b == r101.f88898b) goto L10;
            return false;
        L10:
            if (this.f88899c == r101.f88899c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            boolean r100 = this.f88897a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f88898b;
            if (r104 == true) goto L10;
            r101 = r104;
        L10:
            return ((r103 + r101) * 31) + this.f88899c;
        }

        public final String toString() {
            return "BannerState(isVisible=" + this.f88897a + ", isInRegionB=" + this.f88898b + ", width=" + this.f88899c + ")";
        }

        public a(boolean r100, boolean r101, int r102) {
            this.f88897a = r100;
            this.f88898b = r101;
            this.f88899c = r102;
        }
    }

    Observable<a> l5(long r100);
}

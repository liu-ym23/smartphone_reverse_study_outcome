package com.bytedance.android.shopping.deepfeed.data;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f173101a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f173102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2590b f173103b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f173102a, r101.f173102a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f173103b, r101.f173103b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            View r100 = this.f173102a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            C2590b r104 = this.f173103b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "FragmentPreInflateConsumeResult(view=" + this.f173102a + ", info=" + this.f173103b + ")";
        }

        public a(C2590b r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            this.f173102a = null;
            this.f173103b = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.data.b$b, reason: collision with other inner class name */
    public static final class C2590b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f173104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f173105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f173106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f173107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f173108e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f173109f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C2590b) == false) goto L18;
            C2590b r101 = (C2590b) r100;
            if (this.f173104a == r101.f173104a) goto L8;
            return false;
        L8:
            if (this.f173105b == r101.f173105b) goto L10;
            return false;
        L10:
            if (this.f173106c == r101.f173106c) goto L12;
            return false;
        L12:
            if (this.f173107d == r101.f173107d) goto L14;
            return false;
        L14:
            if (this.f173108e == r101.f173108e) goto L16;
            return false;
        L16:
            if (this.f173109f == r101.f173109f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        public final int hashCode() {
            boolean r100 = this.f173104a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f173105b;
            ?? r105 = r104;
            if (r104 == false) goto L8;
            r105 = 1;
        L8:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f173106c;
            if (r107 == true) goto L12;
            r101 = r107;
        L12:
            int r108 = (r106 + r101) * 31;
            long r109 = this.f173107d;
            int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
            long r111 = this.f173108e;
            int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
            long r113 = this.f173109f;
            return r112 + ((int) (r113 ^ (r113 >>> 32)));
        }

        public final String toString() {
            return "FragmentPreInflateInfo(enabled=" + this.f173104a + ", hasCacheEntry=" + this.f173105b + ", hit=" + this.f173106c + ", requestTime=" + this.f173107d + ", inflateEndTime=" + this.f173108e + ", consumeTime=" + this.f173109f + ")";
        }

        public C2590b(long r100, long r101, long r102) {
            this.f173104a = false;
            this.f173105b = false;
            this.f173106c = false;
            this.f173107d = r100;
            this.f173108e = r101;
            this.f173109f = r102;
        }
    }

    static {
    }
}

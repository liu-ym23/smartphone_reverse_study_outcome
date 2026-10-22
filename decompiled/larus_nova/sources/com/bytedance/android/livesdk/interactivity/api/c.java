package com.bytedance.android.livesdk.interactivity.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f132914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f132915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f132916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f132917d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f132914a, r101.f132914a) == true) goto L8;
            return false;
        L8:
            if (this.f132915b == r101.f132915b) goto L10;
            return false;
        L10:
            if (this.f132916c == r101.f132916c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f132917d, r101.f132917d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        public final int hashCode() {
            String r100 = this.f132914a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((r102 * 31) + this.f132915b) * 31;
            boolean r104 = this.f132916c;
            ?? r105 = r104;
            if (r104 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f132917d;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            return r106 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "AnimParams(path=" + this.f132914a + ", priority=" + this.f132915b + ", forceUsePortrait=" + this.f132916c + ", landscapeScaleType=" + this.f132917d + ")";
        }

        public a(String r100, Integer r101) {
            Intrinsics.checkNotNullParameter(r100, "path");
            this.f132914a = r100;
            this.f132915b = 0;
            this.f132916c = true;
            this.f132917d = r101;
        }
    }

    void a(a r100);

    void release();
}

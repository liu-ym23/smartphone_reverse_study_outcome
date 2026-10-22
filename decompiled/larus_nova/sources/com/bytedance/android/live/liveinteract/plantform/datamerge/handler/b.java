package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f76416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f76417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f76418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f76419d;

        public a() {
            this(0, 0, 0, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f76416a == r101.f76416a) goto L8;
            return false;
        L8:
            if (this.f76417b == r101.f76417b) goto L10;
            return false;
        L10:
            if (this.f76418c == r101.f76418c) goto L12;
            return false;
        L12:
            if (this.f76419d == r101.f76419d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.f76416a * 31) + this.f76417b) * 31) + this.f76418c) * 31) + this.f76419d;
        }

        public final String toString() {
            return "SeiBaseInfo(version=" + this.f76416a + ", uiLayout=" + this.f76417b + ", style=" + this.f76418c + ", subUILayout=" + this.f76419d + ")";
        }

        public a(int r100, int r101, int r102, int r103) {
            this.f76416a = r100;
            this.f76417b = r101;
            this.f76418c = r102;
            this.f76419d = r103;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b$b, reason: collision with other inner class name */
    public static final class C1190b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SeiAppData f76420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SeiAppData f76421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f76422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f76423d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C1190b) == false) goto L14;
            C1190b r101 = (C1190b) r100;
            if (Intrinsics.areEqual(this.f76420a, r101.f76420a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f76421b, r101.f76421b) == true) goto L10;
            return false;
        L10:
            if (this.f76422c == r101.f76422c) goto L12;
            return false;
        L12:
            if (this.f76423d == r101.f76423d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public final int hashCode() {
            SeiAppData r100 = this.f76420a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            SeiAppData r104 = this.f76421b;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            boolean r106 = this.f76422c;
            ?? r107 = 1;
            ?? r108 = r106;
            if (r106 == false) goto L12;
            r108 = 1;
        L12:
            int r109 = (r105 + r108) * 31;
            boolean r110 = this.f76423d;
            if (r110 == true) goto L17;
            r107 = r110;
        L17:
            return r109 + r107;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "SeiDataCompareResult(oldData=" + this.f76420a + ", newData=" + this.f76421b + ", coreDataChanged=" + this.f76422c + ", talkingDataChanged=" + this.f76423d + ")";
        }

        public C1190b(SeiAppData r100, SeiAppData r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "newData");
            this.f76420a = r100;
            this.f76421b = r101;
            this.f76422c = r102;
            this.f76423d = r103;
        }
    }

    public abstract void d(SeiAppData r100);

    public abstract void e(eg6.b r100);

    public b() {
    }
}

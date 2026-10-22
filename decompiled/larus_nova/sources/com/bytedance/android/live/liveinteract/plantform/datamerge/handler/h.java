package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public interface h {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f76438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ch0.e> f76439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ch0.e f76440c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f76438a == r101.f76438a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f76439b, r101.f76439b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f76440c, r101.f76440c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean r100 = this.f76438a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = r101 * 31;
            List<ch0.e> r103 = this.f76439b;
            int r104 = 0;
            if (r103 == null) goto L8;
            int r105 = r103.hashCode();
        L9:
            int r106 = (r102 + r105) * 31;
            ch0.e r107 = this.f76440c;
            if (r107 == null) goto L13;
            r104 = r107.hashCode();
        L13:
            return r106 + r104;
        L8:
            r105 = 0;
            goto L9
        }

        public final String toString() {
            return "UpdateResult(hasModified=" + this.f76438a + ", newMergeDataList=" + this.f76439b + ", newSelfMergeData=" + this.f76440c + ")";
        }

        public a(boolean r100, List<ch0.e> r101, ch0.e r102) {
            Intrinsics.checkNotNullParameter(r101, "newMergeDataList");
            this.f76438a = r100;
            this.f76439b = r101;
            this.f76440c = r102;
        }
    }

    void attach();

    a b(List<ch0.e> r100);

    void detach();
}

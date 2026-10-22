package aq0;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShelfCardInfo f15877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15878b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f15877a, r101.f15877a) == true) goto L8;
        return false;
    L8:
        if (this.f15878b == r101.f15878b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        ShelfCardInfo r100 = this.f15877a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f15878b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ShelfManagementCardInfo(shelfCardInfo=" + this.f15877a + ", isSelected=" + this.f15878b + ")";
    }

    public a(ShelfCardInfo r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "shelfCardInfo");
        this.f15877a = r100;
        this.f15878b = r101;
    }

    public static a a(a r100, boolean r101) {
        ShelfCardInfo r102 = r100.f15877a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "shelfCardInfo");
        return new a(r102, r101);
    }
}

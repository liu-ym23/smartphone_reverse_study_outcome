package ch0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILinkPlayerInfoBridge f23749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23750b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f23749a, r101.f23749a) == true) goto L8;
        return false;
    L8:
        if (this.f23750b == r101.f23750b) goto L16;
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
        ILinkPlayerInfoBridge r100 = this.f23749a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f23750b;
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
        return "SelfDisciplineEndEvent(leavingUser=" + this.f23749a + ", isLeaving=" + this.f23750b + ")";
    }

    public k(ILinkPlayerInfoBridge r100, boolean r101) {
        this.f23749a = r100;
        this.f23750b = r101;
    }
}

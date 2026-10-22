package at;

import com.bytedance.ies.sve_core.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16204b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f16203a, r101.f16203a) == true) goto L8;
        return false;
    L8:
        if (this.f16204b == r101.f16204b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f16203a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f16204b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "ActionMonitorIntent(className=" + this.f16203a + ", actionType=" + this.f16204b + ")";
    }

    public b(String r100, int r101) {
        this.f16203a = r100;
        this.f16204b = r101;
    }
}

package cf;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UpdateLocalViewType f23495b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L10;
        x r101 = (x) r100;
        if (this.f23494a == r101.f23494a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23495b, r101.f23495b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f23494a * 31;
        UpdateLocalViewType r101 = this.f23495b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "UpdateLocalViewArgument(position=" + this.f23494a + ", type=" + this.f23495b + ")";
    }

    public final UpdateLocalViewType getType() {
        return this.f23495b;
    }

    public x(int r100, UpdateLocalViewType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f23494a = r100;
        this.f23495b = r101;
    }
}

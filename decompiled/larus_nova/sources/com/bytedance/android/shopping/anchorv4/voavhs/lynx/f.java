package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends VOIdentifier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<?, ?> f170019c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f170018b, r101.f170018b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170019c, r101.f170019c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f170018b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<?, ?> r104 = this.f170019c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RefreshEpVO(name=" + this.f170018b + ", data=" + this.f170019c + ")";
    }

    public f(String r100, Map<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f170018b = r100;
        this.f170019c = r101;
    }
}

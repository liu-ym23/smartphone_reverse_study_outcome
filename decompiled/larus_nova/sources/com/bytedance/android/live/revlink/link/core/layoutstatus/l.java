package com.bytedance.android.live.revlink.link.core.layoutstatus;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f98305c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f98306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f98307b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (this.f98306a == r101.f98306a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98307b, r101.f98307b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f98306a * 31;
        Map<String, Integer> r101 = this.f98307b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "MinFramesInfo(minFrames=" + this.f98306a + ", positionMap=" + this.f98307b + ")";
    }

    static {
        f98305c = new l(2, null);
    }

    public l(int r100, Map<String, Integer> r101) {
        this.f98306a = r100;
        this.f98307b = r101;
    }
}

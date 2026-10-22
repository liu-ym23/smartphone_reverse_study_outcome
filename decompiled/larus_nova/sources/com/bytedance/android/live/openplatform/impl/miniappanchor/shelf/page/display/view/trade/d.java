package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f84566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f84567b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (this.f84566a == r101.f84566a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f84567b, r101.f84567b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f84566a * 31;
        List<c> r101 = this.f84567b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "TradeUnitList(type=" + this.f84566a + ", list=" + this.f84567b + ")";
    }

    public final int getType() {
        return this.f84566a;
    }

    public d(int r100, List<c> r101) {
        Intrinsics.checkNotNullParameter(r101, "list");
        this.f84566a = r100;
        this.f84567b = r101;
    }
}

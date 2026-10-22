package com.bytedance.android.live.recharge.deal;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final long b(Iterable<d> r100) {
        if (r100 == null) goto L19;
        Iterator<d> r101 = r100.iterator();
        if (r101.hasNext() == true) goto L6;
        d r102 = null;
    L16:
        d r103 = r102;
        if (r103 == null) goto L19;
        return r103.f89712h;
    L6:
        d r104 = r101.next();
        if (r101.hasNext() == true) goto L9;
    L8:
        r102 = r104;
        goto L16
    L9:
        long r105 = r104.f89712h;
    L10:
        d r106 = r101.next();
        long r107 = r106.f89712h;
        if (r105 >= r107) goto L14;
        r104 = r106;
        r105 = r107;
    L14:
        if (r101.hasNext() == true) goto L10;
    L19:
        return 0;
    }

    public static final long c(Iterable<d> r100) {
        if (r100 == null) goto L19;
        Iterator<d> r101 = r100.iterator();
        if (r101.hasNext() == true) goto L6;
        d r102 = null;
    L16:
        d r103 = r102;
        if (r103 == null) goto L19;
        return r103.f89711g;
    L6:
        d r104 = r101.next();
        if (r101.hasNext() == true) goto L9;
    L8:
        r102 = r104;
        goto L16
    L9:
        long r105 = r104.f89711g;
    L10:
        d r106 = r101.next();
        long r107 = r106.f89711g;
        if (r105 <= r107) goto L14;
        r104 = r106;
        r105 = r107;
    L14:
        if (r101.hasNext() == true) goto L10;
    L19:
        return 0;
    }

    public static final d a(Iterable<d> r100, long r101, boolean r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "$this$createCustomDeal");
        Iterator<d> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        d r104 = r103.next();
        d r105 = r104;
        if (r105.f89711g <= r101) goto L8;
    L9:
        if (r110 == false) goto L11;
    L10:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L4;
    L15:
        d r107 = r104;
        if (r107 != null) goto L18;
        return null;
    L18:
        return d.j(r107, r101, r102, 509);
    L11:
        r106 = false;
        goto L12
    L8:
        if (r101 <= r105.f89712h) goto L10;
    L14:
        r104 = null;
        goto L15
    }
}

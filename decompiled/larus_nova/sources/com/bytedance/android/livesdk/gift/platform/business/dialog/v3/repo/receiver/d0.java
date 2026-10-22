package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.j0;
import com.bytedance.android.livesdk.gift.model.t2;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d0 {
    public static final boolean a(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static final List c(List r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rankN");
        int r101 = 3;
        if (3 <= r100.size()) goto L7;
        r101 = r100.size();
    L7:
        return r100.subList(0, r101);
    }

    public static final boolean b(List<h> r100, List<h> r101) {
        Intrinsics.checkNotNullParameter(r100, "lastReceiverList");
        Intrinsics.checkNotNullParameter(r101, "currentReceiverList");
        List r102 = c(r100);
        List r103 = c(r101);
        if (r102.size() == r103.size()) goto L5;
        return true;
    L5:
        Iterator r104 = c(r100).iterator();
        int r105 = 0;
    L7:
        if (r104.hasNext() == false) goto L35;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        h r108 = (h) r106;
        h r109 = (h) CollectionsKt.getOrNull(r103, r105);
        String r110 = r108.f128474a.getIdString();
        String r111 = null;
        if (r109 == null) goto L16;
        IBaseUser r112 = r109.f128474a;
        if (r112 == null) goto L16;
        String r113 = r112.getIdString();
    L18:
        if ((!Intrinsics.areEqual(r110, r113)) == true) goto L19;
        t2 r114 = r108.f128475b;
        if (r114 == null) goto L25;
        j0 r115 = r114.getExtraInfo();
        if (r115 == null) goto L25;
        String r116 = r115.getLabel();
    L26:
        t2 r117 = r109.f128475b;
        if (r117 == null) goto L32;
        j0 r118 = r117.getExtraInfo();
        if (r118 == null) goto L32;
        r111 = r118.getLabel();
    L32:
        if ((!Intrinsics.areEqual(r116, r111)) == true) goto L33;
        r105 = r107;
        goto L7
    L33:
        return true;
    L25:
        r116 = null;
        goto L26
    L19:
        return true;
    L16:
        r113 = null;
        goto L18
    L35:
        return false;
    }
}

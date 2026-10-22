package com.bytedance.android.live.openplatform.api.model.shelf;

import com.bytedance.android.livesdk.utils.r2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class g {
    public static final ShelfCardInfo a(ShelfInfo r100) {
        Object r101 = null;
        if (r100 == null) goto L22;
        List<ShelfCardInfo> r102 = r100.cardInfoList;
        if (r102 == null) goto L23;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        if (((ShelfCardInfo) r104).status != 1) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L8;
        r101 = r104;
        goto L16
    L12:
        r105 = false;
    L16:
        return (ShelfCardInfo) r101;
    L23:
        return null;
    L22:
        return null;
    }

    public static final int b(ShelfInfo r100) {
        int r101 = 0;
        if (r100 == null) goto L19;
        List<ShelfCardInfo> r102 = r100.cardInfoList;
        if (r102 == null) goto L19;
        List<ShelfCardInfo> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L19;
        if (r2.a(((ShelfCardInfo) r104.next()).sellingPoint) == false) goto L13;
        r101 = r101 + 1;
        if (r101 >= 0) goto L13;
        CollectionsKt.throwCountOverflow();
        goto L13
    L9:
        if (r103.isEmpty() == false) goto L11;
    L19:
        return r101;
    }

    public static final boolean c(ShelfInfo r100) {
        if (r100 == null) goto L5;
        int r101 = r100.coexistRoom;
    L6:
        if (r101 == 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    public static final boolean d(ShelfInfo r100) {
        Object r101 = null;
        if (r100 == null) goto L13;
        List<ShelfCardInfo> r102 = r100.cardInfoList;
        if (r102 == null) goto L13;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (((ShelfCardInfo) r104).v0() == false) goto L8;
        r101 = r104;
    L12:
        r101 = (ShelfCardInfo) r101;
    L13:
        if (r101 == null) goto L15;
        return true;
    L15:
        return false;
    }
}

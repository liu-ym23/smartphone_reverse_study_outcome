package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153071a = 0;

    public d() {
    }

    static {
    }

    public static boolean a(String r100, String r101, String r102, Long r103, boolean r104) {
        if (r102 != null) goto L5;
        return true;
    L5:
        if (r103 == null) goto L16;
        r103.longValue();
        int r105 = RoomContextController.f151593h;
        LinkedHashMap r106 = (LinkedHashMap) RoomContextController.a.b(r100, r101).f151596e;
        Long r107 = (Long) r106.get(r102);
        if (r107 == null) goto L9;
        long r108 = r107.longValue();
    L10:
        dm.a.a("AuctionFreq").i("check freq, key=" + r102 + ", limit=" + r103 + ", onlyCheck=" + r104 + ", currentCount=" + r108);
        if (r108 < r103.longValue()) goto L14;
        return false;
    L14:
        if (r104 == true) goto L16;
        r106.put(r102, Long.valueOf(r108 + 1));
        goto L16
    L9:
        r108 = 0;
    L16:
        return true;
    }
}

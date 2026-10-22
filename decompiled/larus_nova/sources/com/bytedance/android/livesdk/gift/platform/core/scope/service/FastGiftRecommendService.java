package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class FastGiftRecommendService implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yz0.k f131254a;

    public static final class a implements wp2.l {
        public a() {
        }
    }

    public static boolean a() {
        wh6.a r100 = (wh6.a) vh6.c.b(wh6.a.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        wh6.a r102 = (wh6.a) vh6.c.b(wh6.a.class);
        if (r102 != null) goto L11;
    L13:
        boolean r103 = false;
    L15:
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().e() == false) goto L20;
        if (r103 == false) goto L21;
        if (r101 == true) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L11:
        if (r102.isPersonalRecommendOn() != true) goto L13;
        r103 = true;
        goto L15
    L5:
        if (r100.isAppInGuestMode() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (a() == true) goto L5;
        return;
    L5:
        ((rq2.a) vh6.c.b(rq2.a.class)).nf(new a());
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        if (a() == true) goto L5;
        return;
    L5:
        ((rq2.a) vh6.c.b(rq2.a.class)).removeFastGiftRecommendCallback();
    }

    public final void c(List<? extends com.bytedance.android.livesdk.gift.model.a2> r110) {
        Intrinsics.checkNotNullParameter(r110, "giftSortStrategyList");
        if (a() == true) goto L5;
        return;
    L5:
        List<? extends com.bytedance.android.livesdk.gift.model.a2> r100 = r110;
        jy0.b.a("Darwin Debug giftSortMessageModel ", CollectionsKt.joinToString$default(r100, null, null, null, 0, null, FastGiftRecommendService$triggerFastGiftAsyncSort$1.INSTANCE, 31, null));
        if ((r100 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r101 = r100.iterator();
    L12:
        if (r101.hasNext() == false) goto L16;
        com.bytedance.android.livesdk.gift.model.a2 r102 = (com.bytedance.android.livesdk.gift.model.a2) r101.next();
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().g().contains(r102.getScene()) == false) goto L12;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L19;
        return;
    L19:
        JSONObject r104 = new JSONObject();
        r104.putOpt("version", 2);
        r104.putOpt("room_id", Long.valueOf(this.f131254a.getRoom().getRoomId()));
        r104.putOpt("gift_sort_strategy", new JSONArray(GsonProtectorUtils.toJson(GsonHelper.get(), r110)));
        jy0.b.a("Darwin Debug triggerFastGiftAsyncSort ", r104.toString());
        ((rq2.a) vh6.c.b(rq2.a.class)).triggerFastGiftAsyncSort(r104);
        return;
    L16:
        r103 = false;
        goto L17
    L8:
        if (r100.isEmpty() == false) goto L10;
        goto L10
    }

    public FastGiftRecommendService(f1 r100, yz0.k r101) {
        Intrinsics.checkNotNullParameter(r100, "giftListSortService");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        this.f131254a = r101;
        new ArrayList();
    }
}

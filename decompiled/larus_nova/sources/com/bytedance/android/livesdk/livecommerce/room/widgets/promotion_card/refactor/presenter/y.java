package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f152499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f152500b;

    public y(z r100, List r101) {
        this.f152499a = r100;
        this.f152500b = r101;
    }

    public final void a() {
        x r100 = this.f152499a.f152501k;
        List r101 = this.f152500b;
        int r102 = x.f152494j;
        r100.getClass();
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L18;
        Map<String, String> r105 = ((ECRitTag) r104.next()).getEventParam();
        if (r105 == null) goto L4;
        Set<Map.Entry<String, String>> r106 = r105.entrySet();
        if (r106 == null) goto L4;
        Iterator<Map.Entry<String, String>> r107 = r106.iterator();
        if (r107 == null) goto L4;
    L12:
        if (r107.hasNext() == false) goto L4;
        Map.Entry<String, String> r108 = r107.next();
        String r109 = r108.getKey();
        if (r103.containsKey(r108.getKey()) == false) goto L16;
        String r110 = ((String) r103.get(r108.getKey())) + ',' + r108.getValue();
    L17:
        r103.put(r109, r110);
        goto L12
    L16:
        r110 = r108.getValue();
        goto L17
    L18:
        RoomContextController r111 = null;
        if ((!r103.isEmpty()) == false) goto L21;
        LinkedHashMap r112 = r103;
    L22:
        if (r112 == null) goto L63;
        int r113 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.f152313a;
        ExplainCardViewModel r114 = r100.f152468e;
        if (r114 == null) goto L28;
        ml.b r115 = r114.getLiveRoomInfo();
        if (r115 == null) goto L28;
        String r116 = r115.roomId();
    L29:
        ExplainCardViewModel r117 = r100.f152468e;
        if (r117 == null) goto L34;
        QLiveData<ECUIPromotion> r118 = r117.getPromotionState();
        if (r118 == null) goto L34;
        ECUIPromotion r119 = r118.a();
    L35:
        ExplainCardViewModel r120 = r100.f152468e;
        if (r120 == null) goto L40;
        Function0<Map<String, Map<String, String>>> r121 = r120.getEventPassthroughParams();
        if (r121 == null) goto L40;
        Map<String, Map<String, String>> r122 = r121.invoke();
    L41:
        ExplainCardViewModel r123 = r100.f152468e;
        if (r123 == null) goto L46;
        cf.c r124 = r123.getBtmInfo();
        if (r124 == null) goto L46;
        String r125 = r124.a();
    L47:
        String r126 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r100.y()));
        ExplainCardViewModel r127 = r100.f152468e;
        if (r127 == null) goto L50;
        r111 = r127.getRoomContextController();
    L50:
        Intrinsics.checkNotNullParameter(r112, "params");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("livesdk_show_product_info", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.p(r119, ControllerExtensionsKt.c(r111, r116), r112, r122, r125, r126));
        return;
    L46:
        r125 = null;
    L40:
        r122 = null;
    L34:
        r119 = null;
    L28:
        r116 = null;
        goto L29
    L63:
        return;
    L21:
        r112 = null;
        goto L22
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

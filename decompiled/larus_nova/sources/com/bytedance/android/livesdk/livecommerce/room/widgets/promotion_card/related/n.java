package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.os.SystemClock;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionCardLoadOptUtils f152601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f152602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.model.e f152603c;

    public n(PromotionCardLoadOptUtils r100, Map r101, p r102) {
        this.f152601a = r100;
        this.f152602b = r101;
        this.f152603c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f152601a.f152545c = Long.valueOf(SystemClock.elapsedRealtime());
        this.f152601a.f152543a = false;
        PromotionCardLoadOptUtils r101 = this.f152601a;
        ECUIPromotion r102 = com.bytedance.android.livesdk.livecommerce.utils.k.e(com.bytedance.android.livesdk.livecommerce.utils.k.c((ECCurrentPromotion) r100), Boolean.TRUE);
        if (r102 == null) goto L8;
        JSONObject r103 = r102.getExtraTransmissibleLogParams();
        if (r103 == null) goto L7;
        int r104 = com.bytedance.android.livesdk.livecommerce.room.controller.w.f151719h;
        r103.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.c(this.f152602b));
        r103.put("anchor_id", this.f152603c.c());
        r103.put("room_id", this.f152603c.roomId());
    L7:
        PromotionCardLoadOptUtils.Companion.b(PromotionCardLoadOptUtils.f152542p, r102);
        Unit r105 = Unit.INSTANCE;
    L9:
        r101.f152546d = r102;
        this.f152601a.f152547e = true;
        Function1<? super ECUIPromotion, Unit> r106 = this.f152601a.f152549g;
        if (r106 == null) goto L12;
        UtilityKotlinExtentionsKt.f153057b.postAtFrontOfQueue(new m(r106, this));
    L12:
        this.f152601a.f152549g = null;
        return;
    L8:
        r102 = null;
        goto L9
    }
}

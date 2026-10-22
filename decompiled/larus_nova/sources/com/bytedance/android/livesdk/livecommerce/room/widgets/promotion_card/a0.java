package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

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
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f152251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f152252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.model.e f152253c;

    public a0(y r100, Map r101, c0 r102) {
        this.f152251a = r100;
        this.f152252b = r101;
        this.f152253c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f152251a.f152730c = Long.valueOf(SystemClock.elapsedRealtime());
        y r101 = this.f152251a;
        r101.f152728a = false;
        ECUIPromotion r102 = com.bytedance.android.livesdk.livecommerce.utils.k.e(com.bytedance.android.livesdk.livecommerce.utils.k.c((ECCurrentPromotion) r100), Boolean.TRUE);
        if (r102 == null) goto L8;
        JSONObject r103 = r102.getExtraTransmissibleLogParams();
        if (r103 == null) goto L7;
        int r104 = com.bytedance.android.livesdk.livecommerce.room.controller.w.f151719h;
        r103.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.c(this.f152252b));
        r103.put("anchor_id", this.f152253c.c());
        r103.put("room_id", this.f152253c.roomId());
    L7:
        y.f152727o.getClass();
        y.a.b(r102);
        Unit r105 = Unit.INSTANCE;
    L9:
        r101.f152731d = r102;
        this.f152251a.f152732e = true;
        Function1<? super ECUIPromotion, Unit> r106 = this.f152251a.f152734g;
        if (r106 == null) goto L12;
        UtilityKotlinExtentionsKt.f153057b.postAtFrontOfQueue(new z(r106, this));
    L12:
        this.f152251a.f152734g = null;
        return;
    L8:
        r102 = null;
        goto L9
    }
}

package com.bytedance.android.livesdk.message.model;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.model.GameIntroduceCardItem;
import com.bytedance.android.livesdkapi.model.GamePropIntroduceCardItem;
import com.bytedance.android.livesdkapi.model.ReserveIntroduceCardItem;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.gamecp.api.GetGameIntroduceCardResponse.Data")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/j5;", "", "Lcom/bytedance/android/livesdkapi/model/GameIntroduceCardItem;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/livesdkapi/model/GameIntroduceCardItem;", "Lcom/bytedance/android/livesdkapi/model/GamePropIntroduceCardItem;", "propItem", "Lcom/bytedance/android/livesdkapi/model/GamePropIntroduceCardItem;", "", "introduceType", "I", "Lcom/bytedance/android/livesdkapi/model/ReserveIntroduceCardItem;", "reserveItem", "Lcom/bytedance/android/livesdkapi/model/ReserveIntroduceCardItem;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j5 implements vh7.h {

    @SerializedName("introduce_type")
    public int introduceType;

    @SerializedName(MapController.ITEM_LAYER_TAG)
    public GameIntroduceCardItem item;

    @SerializedName("prop_item")
    public GamePropIntroduceCardItem propItem;

    @SerializedName("reserve_item")
    public ReserveIntroduceCardItem reserveItem;

    public j5() {
    }

    public j5(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.introduceType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.item = new GameIntroduceCardItem(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.propItem = new GamePropIntroduceCardItem(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.reserveItem = new ReserveIntroduceCardItem(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}

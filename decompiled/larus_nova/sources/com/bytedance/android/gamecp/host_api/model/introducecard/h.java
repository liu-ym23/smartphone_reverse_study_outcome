package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.AnchorIntroduceCardResponse.Data")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/h;", "", "", "hasIntroduceCard", "Z", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/g;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/gamecp/host_api/model/introducecard/g;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/m;", "propItem", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/m;", "", "introduceType", "I", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/v;", "reserveItem", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/v;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/s;", "displayInfo", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/s;", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("card_display_info")
    public s displayInfo;

    @SerializedName("has_introduce_card")
    public boolean hasIntroduceCard;

    @SerializedName("introduce_type")
    public int introduceType;

    @SerializedName(MapController.ITEM_LAYER_TAG)
    public g item;

    @SerializedName("prop_item")
    public m propItem;

    @SerializedName("reserve_item")
    public v reserveItem;

    public h() {
    }

    public h(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.displayInfo = new s(r100);
        goto L3
    L8:
        this.reserveItem = new v(r100);
        goto L3
    L9:
        this.introduceType = r100.i();
        goto L3
    L10:
        this.propItem = new m(r100);
        goto L3
    L11:
        this.item = new g(r100);
        goto L3
    L12:
        this.hasIntroduceCard = am3.h.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}

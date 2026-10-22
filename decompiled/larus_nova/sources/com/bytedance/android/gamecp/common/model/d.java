package com.bytedance.android.gamecp.common.model;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.host_api.model.introducecard.g;
import com.bytedance.android.gamecp.host_api.model.introducecard.m;
import com.bytedance.android.gamecp.host_api.model.introducecard.s;
import com.bytedance.android.gamecp.host_api.model.introducecard.v;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GetGameIntroduceCardResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/d;", "", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/g;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/gamecp/host_api/model/introducecard/g;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/m;", "propItem", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/m;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/s;", "displayInfo", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/s;", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements h {

    @SerializedName("introduce_type")
    protected int _$$introduceType;

    @SerializedName("reserve_item")
    protected v _$$reserveItem;

    @SerializedName("card_display_info")
    public s displayInfo;

    @SerializedName(MapController.ITEM_LAYER_TAG)
    public g item;

    @SerializedName("prop_item")
    public m propItem;

    public d() {
        this._$$introduceType = 0;
        this._$$reserveItem = null;
    }

    public d(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this._$$introduceType = r100.i();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.item = new g(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.propItem = new m(r100);
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this._$$reserveItem = new v(r100);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.displayInfo = new s(r100);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if ((r102 & true) == true) goto L24;
        this._$$introduceType = 0;
    L24:
        if (this._$$reserveItem != null) goto L45;
        this._$$reserveItem = null;
        return;
    }
}

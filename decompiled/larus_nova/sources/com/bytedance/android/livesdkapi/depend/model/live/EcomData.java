package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.EcomData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u0014\u0010\u0019\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u0014\u0010\u001b\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR \u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u0016\u0010 \u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0013¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/EcomData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IEcomData;", "()V", "_introType", "", "get_introType", "()I", "set_introType", "(I)V", "_roomCartV2", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCartV2;", "get_roomCartV2", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCartV2;", "set_roomCartV2", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCartV2;)V", "_shopAuthorHeader", "", "get_shopAuthorHeader", "()Ljava/lang/String;", "set_shopAuthorHeader", "(Ljava/lang/String;)V", "instantType", "getInstantType", "setInstantType", "introType", "getIntroType", "roomCartV2", "getRoomCartV2", "routeRule", "getRouteRule", "setRouteRule", "shopAuthorHeader", "getShopAuthorHeader", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcomData extends FlexModelBase<IEcomData> implements IEcomData, h {

    @SerializedName("intro_type")
    protected int _introType;

    @SerializedName("room_cart_v2")
    protected IRoomCartV2 _roomCartV2;

    @SerializedName("shop_author_header")
    protected String _shopAuthorHeader;

    @SerializedName("instant_type")
    protected int instantType;

    @SerializedName("route_rule")
    protected String routeRule;

    public EcomData() {
        super(IEcomData.class);
    }

    public final int getInstantType() {
        return this.instantType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEcomData
    public int getIntroType() {
        return this._introType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEcomData
    public IRoomCartV2 getRoomCartV2() {
        return this._roomCartV2;
    }

    public final String getRouteRule() {
        return this.routeRule;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEcomData
    public String getShopAuthorHeader() {
        return this._shopAuthorHeader;
    }

    public final int get_introType() {
        return this._introType;
    }

    public final IRoomCartV2 get_roomCartV2() {
        return this._roomCartV2;
    }

    public final String get_shopAuthorHeader() {
        return this._shopAuthorHeader;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoomCartV2, java.lang.Object] */
    public EcomData(g r100) {
        super(IEcomData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this._introType = r100.i();
        goto L3
    L9:
        this._shopAuthorHeader = am3.h.c(r100);
        goto L3
    L10:
        this.routeRule = am3.h.c(r100);
        goto L3
    L11:
        this.instantType = r100.i();
        goto L3
    L12:
        this._roomCartV2 = f.a(r100, IRoomCartV2.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L13:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setInstantType(int r100) {
        this.instantType = r100;
    }

    public final void setRouteRule(String r100) {
        this.routeRule = r100;
    }

    public final void set_introType(int r100) {
        this._introType = r100;
    }

    public final void set_roomCartV2(IRoomCartV2 r100) {
        this._roomCartV2 = r100;
    }

    public final void set_shopAuthorHeader(String r100) {
        this._shopAuthorHeader = r100;
    }
}

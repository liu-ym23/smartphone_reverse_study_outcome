package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleSelfData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0014\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0017\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleSelfDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/u2;", "", "pkCustomDuration$delegate", "Ljava/lang/Object;", "getPkCustomDuration", "()J", "pkCustomDuration", "pkLikeLevel$delegate", "getPkLikeLevel", "pkLikeLevel", "pkGiftValueLevel$delegate", "getPkGiftValueLevel", "pkGiftValueLevel", "pkUVLevel$delegate", "getPkUVLevel", "pkUVLevel", "pkTicketLevel$delegate", "getPkTicketLevel", "pkTicketLevel", "pkVIPLevel$delegate", "getPkVIPLevel", "pkVIPLevel", "", "pkValueType$delegate", "getPkValueType", "()I", "pkValueType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleSelfDataFlexImpl extends FlexModelBase<u2> implements u2, vh7.h {

    @SerializedName("pk_duration_time")
    protected long _$$pkCustomDuration;

    @SerializedName("gift_value_type")
    protected long _$$pkGiftValueLevel;

    @SerializedName("like_type")
    protected long _$$pkLikeLevel;

    @SerializedName("ticket_type")
    protected long _$$pkTicketLevel;

    @SerializedName("gift_uv_type")
    protected long _$$pkUVLevel;

    @SerializedName("subscribe_type")
    protected long _$$pkVIPLevel;

    @SerializedName("pk_value_type")
    protected int _$$pkValueType;

    public IBattleSelfDataFlexImpl() {
        super(u2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.u2
    public final long getPkCustomDuration() {
        return this._$$pkCustomDuration;
    }

    @Override // com.bytedance.android.livesdk.link.model.u2
    public final long getPkGiftValueLevel() {
        return this._$$pkGiftValueLevel;
    }

    @Override // com.bytedance.android.livesdk.link.model.u2
    public final long getPkLikeLevel() {
        return this._$$pkLikeLevel;
    }

    @Override // com.bytedance.android.livesdk.link.model.u2
    public final long getPkTicketLevel() {
        return this._$$pkTicketLevel;
    }

    @Override // com.bytedance.android.livesdk.link.model.u2
    public final long getPkUVLevel() {
        return this._$$pkUVLevel;
    }

    @Override // com.bytedance.android.livesdk.link.model.u2
    public final long getPkVIPLevel() {
        return this._$$pkVIPLevel;
    }

    @Override // com.bytedance.android.livesdk.link.model.u2
    public final int getPkValueType() {
        return this._$$pkValueType;
    }

    public IBattleSelfDataFlexImpl(am3.g r100) {
        super(u2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$pkVIPLevel = r100.j();
        goto L3
    L9:
        this._$$pkTicketLevel = r100.j();
        goto L3
    L10:
        this._$$pkUVLevel = r100.j();
        goto L3
    L11:
        this._$$pkGiftValueLevel = r100.j();
        goto L3
    L12:
        this._$$pkLikeLevel = r100.j();
        goto L3
    L13:
        this._$$pkValueType = r100.i();
        goto L3
    L14:
        this._$$pkCustomDuration = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }
}

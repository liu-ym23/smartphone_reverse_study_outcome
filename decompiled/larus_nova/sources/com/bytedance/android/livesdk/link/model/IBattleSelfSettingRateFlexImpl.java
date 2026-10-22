package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleSelfSettingRate")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0016\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0016\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u0019\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\fR\u001b\u0010\u001c\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleSelfSettingRateFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/v2;", "", "pkSetUid$delegate", "Ljava/lang/Object;", "getPkSetUid", "()Ljava/lang/String;", "pkSetUid", "", "pkValueType$delegate", "getPkValueType", "()J", "pkValueType", "pkLikeRate$delegate", "getPkLikeRate", "pkLikeRate", "pkGiftRate$delegate", "getPkGiftRate", "pkGiftRate", "pkUVRate$delegate", "getPkUVRate", "pkUVRate", "pkTicketRate$delegate", "getPkTicketRate", "pkTicketRate", "pkVIPRate$delegate", "getPkVIPRate", "pkVIPRate", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleSelfSettingRateFlexImpl extends FlexModelBase<v2> implements v2, vh7.h {

    @SerializedName("gift_2_pk_rate")
    protected long _$$pkGiftRate;

    @SerializedName("pk_2_like_rate")
    protected long _$$pkLikeRate;

    @SerializedName("set_open_uid")
    protected String _$$pkSetUid;

    @SerializedName("ticket_2_pk_rate")
    protected long _$$pkTicketRate;

    @SerializedName("gift_uv_2_pk_rate")
    protected long _$$pkUVRate;

    @SerializedName("subscribe_pk_rate")
    protected long _$$pkVIPRate;

    @SerializedName("pk_value_type")
    protected long _$$pkValueType;

    public IBattleSelfSettingRateFlexImpl() {
        super(v2.class);
        this._$$pkSetUid = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.v2
    public final long getPkGiftRate() {
        return this._$$pkGiftRate;
    }

    @Override // com.bytedance.android.livesdk.link.model.v2
    public final long getPkLikeRate() {
        return this._$$pkLikeRate;
    }

    @Override // com.bytedance.android.livesdk.link.model.v2
    public final String getPkSetUid() {
        return this._$$pkSetUid;
    }

    @Override // com.bytedance.android.livesdk.link.model.v2
    public final long getPkTicketRate() {
        return this._$$pkTicketRate;
    }

    @Override // com.bytedance.android.livesdk.link.model.v2
    public final long getPkUVRate() {
        return this._$$pkUVRate;
    }

    @Override // com.bytedance.android.livesdk.link.model.v2
    public final long getPkVIPRate() {
        return this._$$pkVIPRate;
    }

    @Override // com.bytedance.android.livesdk.link.model.v2
    public final long getPkValueType() {
        return this._$$pkValueType;
    }

    public IBattleSelfSettingRateFlexImpl(am3.g r100) {
        super(v2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$pkValueType = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$pkLikeRate = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$pkGiftRate = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$pkUVRate = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._$$pkTicketRate = r100.j();
        goto L3
    L16:
        if (r102 != 7) goto L18;
        this._$$pkVIPRate = r100.j();
        goto L3
    L18:
        if (r102 != 5000) goto L19;
        this._$$pkSetUid = am3.h.c(r100);
        goto L3
    L19:
        am3.h.d(r103, r100);
        goto L3
    L27:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$pkSetUid != null) goto L55;
        this._$$pkSetUid = "";
        return;
    }
}

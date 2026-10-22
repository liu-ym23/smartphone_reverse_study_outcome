package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleAuxiliaryConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig;", "", "operateType$delegate", "Ljava/lang/Object;", "getOperateType", "()J", "operateType", "giftId$delegate", "getGiftId", "giftId", "", "suffixNumberMode$delegate", "getSuffixNumberMode", "()I", "suffixNumberMode", "fixedNumber$delegate", "getFixedNumber", "fixedNumber", "index$delegate", "getIndex", "index", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleAuxiliaryConfigFlexImpl extends FlexModelBase<IBattleAuxiliaryConfig> implements IBattleAuxiliaryConfig, vh7.h {

    @SerializedName("fixed_number")
    protected long _$$fixedNumber;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long _$$giftId;

    @SerializedName("index")
    protected long _$$index;

    @SerializedName("operate_type")
    protected long _$$operateType;

    @SerializedName("suffix_number_mode")
    protected int _$$suffixNumberMode;

    public IBattleAuxiliaryConfigFlexImpl() {
        super(IBattleAuxiliaryConfig.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleAuxiliaryConfig
    public final long getFixedNumber() {
        return this._$$fixedNumber;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleAuxiliaryConfig
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleAuxiliaryConfig
    public final long getIndex() {
        return this._$$index;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleAuxiliaryConfig
    public final long getOperateType() {
        return this._$$operateType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleAuxiliaryConfig
    public final int getSuffixNumberMode() {
        return this._$$suffixNumberMode;
    }

    public IBattleAuxiliaryConfigFlexImpl(am3.g r100) {
        super(IBattleAuxiliaryConfig.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$operateType = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$giftId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$suffixNumberMode = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$fixedNumber = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$index = r100.j();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }
}

package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.AnimeInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnimeInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IAnimeInfo;", "", "normalBarUrl$delegate", "Ljava/lang/Object;", "getNormalBarUrl", "()Ljava/lang/String;", "normalBarUrl", "buffBarUrl$delegate", "getBuffBarUrl", "buffBarUrl", "stealTowerBarUrl$delegate", "getStealTowerBarUrl", "stealTowerBarUrl", "curBarUrl$delegate", "getCurBarUrl", "curBarUrl", "curAuraUrl$delegate", "getCurAuraUrl", "curAuraUrl", "", "barType$delegate", "getBarType", "()I", "barType", "auraType$delegate", "getAuraType", "auraType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnimeInfoFlexImpl extends FlexModelBase<IAnimeInfo> implements IAnimeInfo, vh7.h {

    @SerializedName("aura_type")
    protected int _$$auraType;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE)
    protected int _$$barType;

    @SerializedName("buff_bar_url")
    protected String _$$buffBarUrl;

    @SerializedName("cur_aura_url")
    protected String _$$curAuraUrl;

    @SerializedName("cur_bar_url")
    protected String _$$curBarUrl;

    @SerializedName("normal_bar_url")
    protected String _$$normalBarUrl;

    @SerializedName("steal_tower_bar_url")
    protected String _$$stealTowerBarUrl;

    public IAnimeInfoFlexImpl() {
        super(IAnimeInfo.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IAnimeInfo
    public final int getAuraType() {
        return this._$$auraType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IAnimeInfo
    public final int getBarType() {
        return this._$$barType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IAnimeInfo
    public final String getBuffBarUrl() {
        return this._$$buffBarUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.IAnimeInfo
    public final String getCurAuraUrl() {
        return this._$$curAuraUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.IAnimeInfo
    public final String getCurBarUrl() {
        return this._$$curBarUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.IAnimeInfo
    public final String getNormalBarUrl() {
        return this._$$normalBarUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.IAnimeInfo
    public final String getStealTowerBarUrl() {
        return this._$$stealTowerBarUrl;
    }

    public IAnimeInfoFlexImpl(am3.g r100) {
        super(IAnimeInfo.class);
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
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$curAuraUrl = am3.h.c(r100);
        goto L3
    L9:
        this._$$curBarUrl = am3.h.c(r100);
        goto L3
    L10:
        this._$$stealTowerBarUrl = am3.h.c(r100);
        goto L3
    L11:
        this._$$buffBarUrl = am3.h.c(r100);
        goto L3
    L12:
        this._$$normalBarUrl = am3.h.c(r100);
        goto L3
    L13:
        this._$$auraType = r100.i();
        goto L3
    L14:
        this._$$barType = r100.i();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }
}

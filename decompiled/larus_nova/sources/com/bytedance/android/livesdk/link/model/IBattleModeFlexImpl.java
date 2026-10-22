package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.BattleMode")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleModeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/v1;", "", "mode$delegate", "Ljava/lang/Object;", "getMode", "()I", "mode", "Lcom/bytedance/android/livesdk/link/model/IBattleMode_IStealTowerDataFlexImpl;", "stealTowerData$delegate", "getStealTowerData", "()Lcom/bytedance/android/livesdk/link/model/IBattleMode_IStealTowerDataFlexImpl;", "stealTowerData", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleModeFlexImpl extends FlexModelBase<v1> implements v1, vh7.h {

    @SerializedName("mode")
    protected int _$$mode;

    @SerializedName("steal_tower_data")
    protected IBattleMode_IStealTowerDataFlexImpl _$$stealTowerData;

    public IBattleModeFlexImpl() {
        super(v1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v1
    public /* bridge */ /* synthetic */ v1.c getStealTowerData() {
        return getStealTowerData();
    }

    @Override // com.bytedance.android.livesdk.link.model.v1
    public final int getMode() {
        return this._$$mode;
    }

    @Override // com.bytedance.android.livesdk.link.model.v1
    public final IBattleMode_IStealTowerDataFlexImpl getStealTowerData() {
        return this._$$stealTowerData;
    }

    public IBattleModeFlexImpl(am3.g r100) {
        super(v1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$mode = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$stealTowerData = new IBattleMode_IStealTowerDataFlexImpl(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}

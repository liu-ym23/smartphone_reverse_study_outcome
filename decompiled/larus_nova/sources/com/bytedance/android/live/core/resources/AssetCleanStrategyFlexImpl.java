package com.bytedance.android.live.core.resources;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.CleanStrategy")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/core/resources/AssetCleanStrategyFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/core/resources/b;", "", "cleanType$delegate", "Ljava/lang/Object;", "getCleanType", "()I", "cleanType", "", "assetType$delegate", "getAssetType", "()Ljava/lang/String;", "assetType", "", "keepAliveTime$delegate", "getKeepAliveTime", "()J", "keepAliveTime", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetCleanStrategyFlexImpl extends FlexModelBase<b> implements b, vh7.h {

    @SerializedName("asset_pool_type")
    protected String _$$assetType;

    @SerializedName("clean_type")
    protected int _$$cleanType;

    @SerializedName("keep_alive_time")
    protected long _$$keepAliveTime;

    public AssetCleanStrategyFlexImpl() {
        super(b.class);
        this._$$assetType = "";
    }

    @Override // com.bytedance.android.live.core.resources.b
    public final String getAssetType() {
        return this._$$assetType;
    }

    @Override // com.bytedance.android.live.core.resources.b
    public final int getCleanType() {
        return this._$$cleanType;
    }

    @Override // com.bytedance.android.live.core.resources.b
    public final long getKeepAliveTime() {
        return this._$$keepAliveTime;
    }

    public AssetCleanStrategyFlexImpl(am3.g r100) {
        super(b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$cleanType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$assetType = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$keepAliveTime = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$assetType != null) goto L31;
        this._$$assetType = "";
        return;
    }
}

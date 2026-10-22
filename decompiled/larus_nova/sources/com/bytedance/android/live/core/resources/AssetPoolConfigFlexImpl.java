package com.bytedance.android.live.core.resources;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.gift.AssetPoolConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR+\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/core/resources/AssetPoolConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/core/resources/c;", "", "<set-?>", "maxSize$delegate", "Ljava/lang/Object;", "getMaxSize", "()I", "setMaxSize", "(I)V", "maxSize", "poolSize$delegate", "getPoolSize", "setPoolSize", "poolSize", "cleanStrategy$delegate", "getCleanStrategy", "setCleanStrategy", "cleanStrategy", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetPoolConfigFlexImpl extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName("clean_strategy")
    protected int _$$cleanStrategy;

    @SerializedName(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE)
    protected int _$$maxSize;

    @SerializedName("pool_size")
    protected int _$$poolSize;

    public AssetPoolConfigFlexImpl() {
        super(c.class);
    }

    @Override // com.bytedance.android.live.core.resources.c
    public final int getCleanStrategy() {
        return this._$$cleanStrategy;
    }

    @Override // com.bytedance.android.live.core.resources.c
    public final int getMaxSize() {
        return this._$$maxSize;
    }

    @Override // com.bytedance.android.live.core.resources.c
    public final int getPoolSize() {
        return this._$$poolSize;
    }

    public AssetPoolConfigFlexImpl(am3.g r100) {
        super(c.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$maxSize = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$poolSize = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$cleanStrategy = r100.i();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.core.resources.c
    public final void setCleanStrategy(int r100) {
        this._$$cleanStrategy = r100;
    }

    @Override // com.bytedance.android.live.core.resources.c
    public final void setMaxSize(int r100) {
        this._$$maxSize = r100;
    }

    @Override // com.bytedance.android.live.core.resources.c
    public final void setPoolSize(int r100) {
        this._$$poolSize = r100;
    }
}

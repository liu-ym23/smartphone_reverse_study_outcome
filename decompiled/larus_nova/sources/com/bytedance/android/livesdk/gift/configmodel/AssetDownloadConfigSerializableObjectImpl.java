package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/AssetDownloadConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/d;", "", "downloadShowGiftEnable", "Z", "S2", "()Z", "downloadSpecialRowGiftEnable", "Q1", "", "", "downloadSpecialRowConfig", "Ljava/util/Map;", "g8", "()Ljava/util/Map;", "downloadSpecialRowDefaultSize", "I", "s4", "()I", "downloadInterval", "K5", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetDownloadConfigSerializableObjectImpl implements d {

    @SerializedName("download_interval")
    private final int downloadInterval;

    @SerializedName("download_show_gift_enable")
    private final boolean downloadShowGiftEnable;

    @SerializedName("download_special_row_config")
    private final Map<Integer, Integer> downloadSpecialRowConfig;

    @SerializedName("download_special_row_default_size")
    private final int downloadSpecialRowDefaultSize;

    @SerializedName("download_special_row_gift_enable")
    private final boolean downloadSpecialRowGiftEnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/AssetDownloadConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AssetDownloadConfigSerializableObjectImpl.class);
        }
    }

    public AssetDownloadConfigSerializableObjectImpl() {
        this.downloadShowGiftEnable = false;
        this.downloadSpecialRowGiftEnable = false;
        this.downloadSpecialRowConfig = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.downloadSpecialRowDefaultSize = 32;
        this.downloadInterval = 1000;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.d
    public final int K5() {
        return this.downloadInterval;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.d
    public final boolean Q1() {
        return this.downloadSpecialRowGiftEnable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.d
    public final boolean S2() {
        return this.downloadShowGiftEnable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.d
    public final Map<Integer, Integer> g8() {
        return this.downloadSpecialRowConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.d
    public final int s4() {
        return this.downloadSpecialRowDefaultSize;
    }
}

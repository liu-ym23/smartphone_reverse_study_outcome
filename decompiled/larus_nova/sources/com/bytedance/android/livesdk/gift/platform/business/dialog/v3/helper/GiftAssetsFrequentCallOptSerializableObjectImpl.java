package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftAssetsFrequentCallOptSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/e;", "", "delayDownLoadOpt", "Z", "r2", "()Z", "disableDownloadMonitor", "u0", "effectFilterOpt", "M8", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftAssetsFrequentCallOptSerializableObjectImpl implements e {

    @SerializedName("delay_download_opt")
    private final boolean delayDownLoadOpt;

    @SerializedName("disable_download_monitor")
    private final boolean disableDownloadMonitor;

    @SerializedName("effect_filter_opt")
    private final boolean effectFilterOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftAssetsFrequentCallOptSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftAssetsFrequentCallOptSerializableObjectImpl.class);
        }
    }

    public GiftAssetsFrequentCallOptSerializableObjectImpl() {
        this.delayDownLoadOpt = false;
        this.disableDownloadMonitor = false;
        this.effectFilterOpt = false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e
    public final boolean M8() {
        return this.effectFilterOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e
    public final boolean r2() {
        return this.delayDownLoadOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e
    public final boolean u0() {
        return this.disableDownloadMonitor;
    }
}

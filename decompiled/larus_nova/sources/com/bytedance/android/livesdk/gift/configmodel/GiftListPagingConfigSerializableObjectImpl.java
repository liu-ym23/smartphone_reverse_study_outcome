package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.tencent.connect.common.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftListPagingConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/o0;", "", "enable", "Z", "getEnable", "()Z", "", "", "", "countPerPageMap", "Ljava/util/Map;", DoraObricDeviceHomeViewModel.PRODUCT_CODE_G1, "()Ljava/util/Map;", "enableAutoRequest", "P8", "autoRequestIntervalSecond", "I", "w6", "()I", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftListPagingConfigSerializableObjectImpl implements o0 {

    @SerializedName("auto_request_interval")
    private final int autoRequestIntervalSecond;

    @SerializedName("count_per_page")
    private final Map<String, Integer> countPerPageMap;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_auto_request")
    private final boolean enableAutoRequest;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftListPagingConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftListPagingConfigSerializableObjectImpl.class);
        }
    }

    public GiftListPagingConfigSerializableObjectImpl() {
        this.enable = true;
        this.countPerPageMap = com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to("1", 100), TuplesKt.to(Constants.VIA_REPORT_TYPE_WPA_STATE, 50)});
        this.enableAutoRequest = false;
        this.autoRequestIntervalSecond = 15;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.o0
    public final boolean P8() {
        return this.enableAutoRequest;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.o0
    public final Map<String, Integer> g1() {
        return this.countPerPageMap;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.o0
    public final int w6() {
        return this.autoRequestIntervalSecond;
    }
}

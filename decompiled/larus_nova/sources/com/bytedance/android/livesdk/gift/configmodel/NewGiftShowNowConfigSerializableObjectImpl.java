package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/NewGiftShowNowConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/v1;", "", "enable", "Z", "getEnable", "()Z", "", "", "notSupportGiftType", "Ljava/util/List;", "s3", "()Ljava/util/List;", "notSupportAssetType", "z5", "", "notSupportGiftId", "f2", "optEnable", "b5", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NewGiftShowNowConfigSerializableObjectImpl implements v1 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("not_support_asset_type")
    private final List<Integer> notSupportAssetType;

    @SerializedName("not_support_gift_id")
    private final List<Long> notSupportGiftId;

    @SerializedName("not_support_gift_type")
    private final List<Integer> notSupportGiftType;

    @SerializedName("opt_enable")
    private final boolean optEnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/NewGiftShowNowConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(NewGiftShowNowConfigSerializableObjectImpl.class);
        }
    }

    public NewGiftShowNowConfigSerializableObjectImpl() {
        this.enable = true;
        this.notSupportGiftType = com.bytedance.revenue.platform.api.core.c.a(new Integer[]{13});
        this.notSupportAssetType = com.bytedance.revenue.platform.api.core.c.a(new Integer[]{15});
        this.notSupportGiftId = com.bytedance.revenue.platform.api.core.c.a(new Long[0]);
        this.optEnable = true;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.v1
    public final boolean b5() {
        return this.optEnable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.v1
    public final List<Long> f2() {
        return this.notSupportGiftId;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.v1
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.v1
    public final List<Integer> s3() {
        return this.notSupportGiftType;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.v1
    public final List<Integer> z5() {
        return this.notSupportAssetType;
    }
}

package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/MostlyUsedGiftConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/t1;", "", "enable", "Z", "getEnable", "()Z", "", "introduceDescription", "Ljava/lang/String;", "Q2", "()Ljava/lang/String;", "closeRecommendIntroduceDesc", "V8", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MostlyUsedGiftConfigSerializableObjectImpl implements t1 {

    @SerializedName("close_recommend_introduce_desc")
    private final String closeRecommendIntroduceDesc;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("introduce_desc")
    private final String introduceDescription;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/MostlyUsedGiftConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(MostlyUsedGiftConfigSerializableObjectImpl.class);
        }
    }

    public MostlyUsedGiftConfigSerializableObjectImpl() {
        this.closeRecommendIntroduceDesc = "在热门、发现等栏目均可长按设置";
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.t1
    public final String Q2() {
        return this.introduceDescription;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.t1
    public final String V8() {
        return this.closeRecommendIntroduceDesc;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.t1
    public final boolean getEnable() {
        return this.enable;
    }
}

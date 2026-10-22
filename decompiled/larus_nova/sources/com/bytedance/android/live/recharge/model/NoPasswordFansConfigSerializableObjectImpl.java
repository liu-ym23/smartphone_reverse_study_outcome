package com.bytedance.android.live.recharge.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/recharge/model/NoPasswordFansConfigSerializableObjectImpl;", "Lcom/bytedance/android/live/recharge/model/NoPasswordFansConfig;", "()V", "giftIds", "", "", "getGiftIds", "()Ljava/util/List;", "setGiftIds", "(Ljava/util/List;)V", "type", "", "getType", "()I", "setType", "(I)V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NoPasswordFansConfigSerializableObjectImpl implements NoPasswordFansConfig {

    @SerializedName("gift_ids")
    private List<Long> giftIds;

    @SerializedName("type")
    private int type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/model/NoPasswordFansConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(NoPasswordFansConfigSerializableObjectImpl.class);
        }
    }

    public NoPasswordFansConfigSerializableObjectImpl() {
        this.giftIds = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.recharge.model.NoPasswordFansConfig
    public final List<Long> getGiftIds() {
        return this.giftIds;
    }

    @Override // com.bytedance.android.live.recharge.model.NoPasswordFansConfig
    public final int getType() {
        return this.type;
    }

    @Override // com.bytedance.android.live.recharge.model.NoPasswordFansConfig
    public final void setGiftIds(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.giftIds = r100;
    }

    @Override // com.bytedance.android.live.recharge.model.NoPasswordFansConfig
    public final void setType(int r100) {
        this.type = r100;
    }
}

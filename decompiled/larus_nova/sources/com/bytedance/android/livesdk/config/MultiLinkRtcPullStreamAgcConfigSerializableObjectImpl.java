package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiLinkRtcPullStreamAgcConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/sb1;", "", "open", "Z", "getOpen", "()Z", "", "target_loudness", "I", "t0", "()I", "", "support_scene_list", "Ljava/util/List;", "k1", "()Ljava/util/List;", "support_layout_list", "M0", "<init>", "()V", "Adapter", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkRtcPullStreamAgcConfigSerializableObjectImpl implements sb1 {

    @SerializedName("open")
    private final boolean open;

    @SerializedName("support_layout_list")
    private final List<Integer> support_layout_list;

    @SerializedName("support_scene_list")
    private final List<Integer> support_scene_list;

    @SerializedName("target_loudness")
    private final int target_loudness;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiLinkRtcPullStreamAgcConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(MultiLinkRtcPullStreamAgcConfigSerializableObjectImpl.class);
        }
    }

    public MultiLinkRtcPullStreamAgcConfigSerializableObjectImpl() {
        this.open = false;
        this.target_loudness = -12;
        this.support_scene_list = com.bytedance.revenue.platform.api.core.c.a(new Integer[0]);
        this.support_layout_list = com.bytedance.revenue.platform.api.core.c.a(new Integer[0]);
    }

    @Override // com.bytedance.android.livesdk.config.sb1
    public final List<Integer> M0() {
        return this.support_layout_list;
    }

    @Override // com.bytedance.android.livesdk.config.sb1
    public final boolean getOpen() {
        return this.open;
    }

    @Override // com.bytedance.android.livesdk.config.sb1
    public final List<Integer> k1() {
        return this.support_scene_list;
    }

    @Override // com.bytedance.android.livesdk.config.sb1
    public final int t0() {
        return this.target_loudness;
    }
}

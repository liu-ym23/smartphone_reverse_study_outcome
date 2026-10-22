package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@JsonAdapter(MultiLinkRtcPullStreamAgcConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/config/sb1;", "Lvh7/j;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface sb1 extends vh7.j<sb1> {

    @JsonAdapter(MultiLinkRtcPullStreamAgcConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "support_layout_list")
    List<Integer> M0();

    @FieldName(name = "open")
    boolean getOpen();

    @FieldName(name = "support_scene_list")
    List<Integer> k1();

    @FieldName(name = "target_loudness")
    int t0();
}

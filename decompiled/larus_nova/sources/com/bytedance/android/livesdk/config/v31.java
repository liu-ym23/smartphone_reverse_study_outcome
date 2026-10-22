package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@JsonAdapter(LiveGiftCleanOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/config/v31;", "Lvh7/j;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v31 extends vh7.j<v31> {

    @JsonAdapter(LiveGiftCleanOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "enable_change_use_time")
    boolean q1();
}

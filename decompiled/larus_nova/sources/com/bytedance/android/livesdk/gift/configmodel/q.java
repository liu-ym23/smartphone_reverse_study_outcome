package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(DeviceStorageSettingSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/q;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q extends vh7.j<q> {

    @JsonAdapter(DeviceStorageSettingSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "refresh_interval")
    long L4();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "rank_array")
    List<Long> v0();
}

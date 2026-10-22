package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(CleanStrategyConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/m;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m extends vh7.j<m> {

    @JsonAdapter(CleanStrategyConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "clean_white_list_config")
    k E7();

    @FieldName(name = "download_black_list_config")
    k G6();

    @FieldName(name = "pool_config")
    Map<String, g> K8();

    @FieldName(name = "live_effect_api_add_user_portrait_param")
    q V1();

    @FieldName(name = "live_asset_pool_not_add_black_list")
    List<String> c3();

    @FieldName(name = "asset_expire_duration")
    long d3();

    @FieldName(name = "clean_in_room_enable")
    boolean g0();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "diff_clean_enable")
    boolean k9();

    @FieldName(name = "download_asset_trigger_related_pool_clean_interval")
    long u1();
}

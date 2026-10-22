package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(AssetDownloadConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/d;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.j<d> {

    @JsonAdapter(AssetDownloadConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "download_interval")
    int K5();

    @FieldName(name = "download_special_row_gift_enable")
    boolean Q1();

    @FieldName(name = "download_show_gift_enable")
    boolean S2();

    @FieldName(name = "download_special_row_config")
    Map<Integer, Integer> g8();

    @FieldName(name = "download_special_row_default_size")
    int s4();
}

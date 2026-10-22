package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(AssetServiceOptSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/h;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.j<h> {

    @JsonAdapter(AssetServiceOptSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "async_request_assets")
    boolean N7();

    @FieldName(name = "thread_switch_opt")
    boolean O2();

    @FieldName(name = "prepare_url")
    boolean Z6();

    @FieldName(name = "cancel_record")
    boolean o4();

    @FieldName(name = "task_async")
    boolean p7();

    @FieldName(name = "change_init_order")
    boolean r7();

    @FieldName(name = "async_update_assets_model")
    boolean v3();

    @FieldName(name = "result_log")
    boolean x3();
}

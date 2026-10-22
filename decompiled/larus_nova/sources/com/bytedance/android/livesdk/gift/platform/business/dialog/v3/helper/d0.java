package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(GiftPanelMutateOptSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/d0;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d0 extends vh7.j<d0> {

    @JsonAdapter(GiftPanelMutateOptSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "refresh_select_extra_opt")
    boolean C5();

    @FieldName(name = "gift_show_change_opt")
    boolean E8();

    @FieldName(name = "select_gift_extra_opt")
    boolean L8();

    @FieldName(name = "observe_select_buff_opt")
    boolean R1();

    @FieldName(name = "merge_gift_extra_mutate")
    boolean W7();

    @FieldName(name = "expansion_width_opt")
    boolean e5();

    @FieldName(name = "marketing_info_opt")
    boolean f5();

    @FieldName(name = "above_component_size_opt")
    boolean f8();

    @FieldName(name = "new_batch_reduce_opt")
    boolean g4();

    @FieldName(name = "observe_top_view_mode_opt")
    boolean l0();

    @FieldName(name = "carnival_msg_opt")
    boolean u2();

    @FieldName(name = "series_info_opt")
    boolean w5();
}

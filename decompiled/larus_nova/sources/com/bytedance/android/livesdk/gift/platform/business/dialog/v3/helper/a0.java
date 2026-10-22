package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(GiftPanelFrequentCallOptSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/a0;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a0 extends vh7.j<a0> {

    @JsonAdapter(GiftPanelFrequentCallOptSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "setting_opt")
    boolean G8();

    @FieldName(name = "log_gift_show_opt")
    boolean U5();

    @FieldName(name = "gift_card_sp_opt")
    boolean W2();

    @FieldName(name = "resource_opt")
    boolean a2();

    @FieldName(name = "new_list_opt")
    boolean n3();

    @FieldName(name = "bottom_text_opt")
    boolean p3();

    @FieldName(name = "alog_opt")
    boolean q0();

    @FieldName(name = "wrap_dialog_icon_model_opt")
    boolean w7();
}

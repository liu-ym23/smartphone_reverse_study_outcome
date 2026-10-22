package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(GiftPanelAsyncTaskConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/y;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y extends vh7.j<y> {

    @JsonAdapter(GiftPanelAsyncTaskConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "gift_preview_log")
    boolean B0();

    @FieldName(name = "gift_item_show_log")
    boolean Y1();

    @FieldName(name = "gift_tab_show_log")
    boolean f9();

    @FieldName(name = "profit_check")
    boolean k8();

    @FieldName(name = "gift_show_log")
    boolean y0();
}

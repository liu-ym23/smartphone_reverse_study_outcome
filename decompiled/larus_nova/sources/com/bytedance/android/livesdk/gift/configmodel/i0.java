package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(GiftImageCdnOptSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/i0;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i0 extends vh7.j<i0> {

    @JsonAdapter(GiftImageCdnOptSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "gift_image_tpl")
    String A2();

    @FieldName(name = "asset_cdn")
    boolean C7();

    @FieldName(name = "img_domain_thread")
    boolean D1();

    @FieldName(name = "gift_image_callback_count")
    int M3();

    @FieldName(name = "arraylist_opt")
    boolean T0();

    @FieldName(name = "gift_message_opt")
    boolean Z1();

    @FieldName(name = "gift_image_format")
    String c0();

    @FieldName(name = "asset_cdn_callback_count")
    int q9();

    @FieldName(name = "gift_image")
    boolean w0();
}

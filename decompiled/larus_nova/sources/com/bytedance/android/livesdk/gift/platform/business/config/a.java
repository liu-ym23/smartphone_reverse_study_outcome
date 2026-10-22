package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(BuffAndDiyCardConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/config/a;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.j<a> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.config.a$a, reason: collision with other inner class name */
    @JsonAdapter(BuffAndDiyCardConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C2027a {
    }

    @FieldName(name = "enable_manual_select_locked_card_tabs")
    List<Integer> a5();

    @FieldName(name = "enable_default_select_locked_card_tabs")
    List<Integer> l6();

    @FieldName(name = "enable_show_icon_for_last_send_card")
    boolean u6();
}

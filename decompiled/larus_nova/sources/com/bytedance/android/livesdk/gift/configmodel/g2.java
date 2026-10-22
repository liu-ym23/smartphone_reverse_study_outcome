package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(RevLiveSendGiftPlayNowConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/g2;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g2 extends vh7.j<g2> {

    @JsonAdapter(RevLiveSendGiftPlayNowConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "send_trace")
    boolean J3();

    @FieldName(name = "send_log")
    boolean J4();

    @FieldName(name = "last_consume_duration")
    int S8();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "last_fail_duration")
    int s0();
}

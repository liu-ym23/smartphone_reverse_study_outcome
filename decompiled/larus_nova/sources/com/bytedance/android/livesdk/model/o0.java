package com.bytedance.android.livesdk.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(RevLivePlayerRevSmoothEnterRoomConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/model/o0;", "Lvh7/j;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o0 extends vh7.j<o0> {

    @JsonAdapter(RevLivePlayerRevSmoothEnterRoomConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "smooth_close")
    boolean S4();

    @FieldName(name = "total_switch")
    boolean getTotalSwitch();
}

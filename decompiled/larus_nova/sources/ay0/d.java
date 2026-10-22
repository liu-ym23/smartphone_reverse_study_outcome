package ay0;

import com.bytedance.android.live.revenue.common.settings.RevenueDynamicSwitchesSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(RevenueDynamicSwitchesSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lay0/d;", "Lvh7/j;", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends j<d> {

    @JsonAdapter(RevenueDynamicSwitchesSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "service_center")
    boolean D();

    @FieldName(name = "lucky_box_type")
    int b0();

    @FieldName(name = "delay_time_millis")
    long j8();
}

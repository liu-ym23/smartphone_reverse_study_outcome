package b01;

import com.bytedance.android.live.revenue.platform.settings.api.ClientSettingParamsSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(ClientSettingParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lb01/b;", "Lvh7/j;", "", "getType", "()I", "getType$annotations", "()V", "type", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.foundation.ClientSettingParams")
public interface b extends j<b> {

    @JsonAdapter(ClientSettingParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "key")
    String getKey();

    @FieldName(name = "type")
    int getType();
}

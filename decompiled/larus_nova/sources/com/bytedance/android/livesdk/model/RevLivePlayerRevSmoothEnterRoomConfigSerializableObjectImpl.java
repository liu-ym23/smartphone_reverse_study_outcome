package com.bytedance.android.livesdk.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/model/RevLivePlayerRevSmoothEnterRoomConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/model/o0;", "", "totalSwitch", "Z", "getTotalSwitch", "()Z", "smoothViewMock", "getSmoothViewMock", "smoothClose", "S4", "removeFrameViewMockWhenPause", "getRemoveFrameViewMockWhenPause", "", "removeFrameViewMockTimeOut", "J", "getRemoveFrameViewMockTimeOut", "()J", "<init>", "()V", "Adapter", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLivePlayerRevSmoothEnterRoomConfigSerializableObjectImpl implements o0 {

    @SerializedName("remove_frame_view_mock_time_out")
    private final long removeFrameViewMockTimeOut;

    @SerializedName("remove_frame_view_mock_when_pause")
    private final boolean removeFrameViewMockWhenPause;

    @SerializedName("smooth_close")
    private final boolean smoothClose;

    @SerializedName("smooth_view_mock")
    private final boolean smoothViewMock;

    @SerializedName("total_switch")
    private final boolean totalSwitch;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/model/RevLivePlayerRevSmoothEnterRoomConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevLivePlayerRevSmoothEnterRoomConfigSerializableObjectImpl.class);
        }
    }

    public RevLivePlayerRevSmoothEnterRoomConfigSerializableObjectImpl() {
        this.totalSwitch = false;
        this.smoothViewMock = false;
        this.smoothClose = false;
        this.removeFrameViewMockWhenPause = true;
        this.removeFrameViewMockTimeOut = 10;
    }

    @Override // com.bytedance.android.livesdk.model.o0
    public final boolean S4() {
        return this.smoothClose;
    }

    @Override // com.bytedance.android.livesdk.model.o0
    public final boolean getTotalSwitch() {
        return this.totalSwitch;
    }
}

package com.bytedance.android.livesdkapi.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILiveLinkCameraBackUpConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdkapi/model/ILiveLinkCameraBackUpConfig;", "()V", "audienceCheckLinkerSwitch", "", "getAudienceCheckLinkerSwitch", "()Z", "maxDiffCount", "", "getMaxDiffCount", "()I", "mixStreamSwitch", "getMixStreamSwitch", "msgUpdateSwitch", "getMsgUpdateSwitch", "msgUpdateSwitchForAnchor", "getMsgUpdateSwitchForAnchor", "reportAckMsgSwitch", "getReportAckMsgSwitch", "totalSwitch", "getTotalSwitch", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILiveLinkCameraBackUpConfigSerializableObjectImpl implements ILiveLinkCameraBackUpConfig {

    @SerializedName("audience_check_linkers_switch")
    private final boolean audienceCheckLinkerSwitch;

    @SerializedName("max_diff_count")
    private final int maxDiffCount;

    @SerializedName("mix_stream_switch")
    private final boolean mixStreamSwitch;

    @SerializedName("msg_update_switch")
    private final boolean msgUpdateSwitch;

    @SerializedName("msg_update_switch_for_anchor")
    private final boolean msgUpdateSwitchForAnchor;

    @SerializedName("report_ack_msg_switch")
    private final boolean reportAckMsgSwitch;

    @SerializedName("total_switch")
    private final boolean totalSwitch;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILiveLinkCameraBackUpConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ILiveLinkCameraBackUpConfigSerializableObjectImpl.class);
        }
    }

    public ILiveLinkCameraBackUpConfigSerializableObjectImpl() {
        this.totalSwitch = ILiveLinkCameraBackUpConfig.DefaultImpls.getTotalSwitch(this);
        this.mixStreamSwitch = ILiveLinkCameraBackUpConfig.DefaultImpls.getMixStreamSwitch(this);
        this.msgUpdateSwitch = ILiveLinkCameraBackUpConfig.DefaultImpls.getMsgUpdateSwitch(this);
        this.msgUpdateSwitchForAnchor = ILiveLinkCameraBackUpConfig.DefaultImpls.getMsgUpdateSwitchForAnchor(this);
        this.audienceCheckLinkerSwitch = ILiveLinkCameraBackUpConfig.DefaultImpls.getAudienceCheckLinkerSwitch(this);
        this.reportAckMsgSwitch = ILiveLinkCameraBackUpConfig.DefaultImpls.getReportAckMsgSwitch(this);
        this.maxDiffCount = ILiveLinkCameraBackUpConfig.DefaultImpls.getMaxDiffCount(this);
    }

    @Override // com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig
    public final boolean getAudienceCheckLinkerSwitch() {
        return this.audienceCheckLinkerSwitch;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig
    public final int getMaxDiffCount() {
        return this.maxDiffCount;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig
    public final boolean getMixStreamSwitch() {
        return this.mixStreamSwitch;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig
    public final boolean getMsgUpdateSwitch() {
        return this.msgUpdateSwitch;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig
    public final boolean getMsgUpdateSwitchForAnchor() {
        return this.msgUpdateSwitchForAnchor;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig
    public final boolean getReportAckMsgSwitch() {
        return this.reportAckMsgSwitch;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig
    public final boolean getTotalSwitch() {
        return this.totalSwitch;
    }
}

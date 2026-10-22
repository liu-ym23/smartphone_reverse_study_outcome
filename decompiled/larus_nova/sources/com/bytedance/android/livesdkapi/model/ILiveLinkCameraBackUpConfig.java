package com.bytedance.android.livesdkapi.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(ILiveLinkCameraBackUpConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00178VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILiveLinkCameraBackUpConfig;", "Lvh7/j;", "", "getTotalSwitch", "()Z", "getTotalSwitch$annotations", "()V", "totalSwitch", "getMixStreamSwitch", "getMixStreamSwitch$annotations", "mixStreamSwitch", "getMsgUpdateSwitch", "getMsgUpdateSwitch$annotations", "msgUpdateSwitch", "getMsgUpdateSwitchForAnchor", "getMsgUpdateSwitchForAnchor$annotations", "msgUpdateSwitchForAnchor", "getAudienceCheckLinkerSwitch", "getAudienceCheckLinkerSwitch$annotations", "audienceCheckLinkerSwitch", "getReportAckMsgSwitch", "getReportAckMsgSwitch$annotations", "reportAckMsgSwitch", "", "getMaxDiffCount", "()I", "getMaxDiffCount$annotations", "maxDiffCount", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILiveLinkCameraBackUpConfig extends j<ILiveLinkCameraBackUpConfig> {

    @JsonAdapter(ILiveLinkCameraBackUpConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "audience_check_linkers_switch")
        public static boolean getAudienceCheckLinkerSwitch(ILiveLinkCameraBackUpConfig r100) {
            return true;
        }

        @FieldName(name = "audience_check_linkers_switch")
        public static /* synthetic */ void getAudienceCheckLinkerSwitch$annotations() {
        }

        @FieldName(name = "max_diff_count")
        public static int getMaxDiffCount(ILiveLinkCameraBackUpConfig r100) {
            return 3;
        }

        @FieldName(name = "max_diff_count")
        public static /* synthetic */ void getMaxDiffCount$annotations() {
        }

        @FieldName(name = "mix_stream_switch")
        public static boolean getMixStreamSwitch(ILiveLinkCameraBackUpConfig r100) {
            return true;
        }

        @FieldName(name = "mix_stream_switch")
        public static /* synthetic */ void getMixStreamSwitch$annotations() {
        }

        @FieldName(name = "msg_update_switch")
        public static boolean getMsgUpdateSwitch(ILiveLinkCameraBackUpConfig r100) {
            return true;
        }

        @FieldName(name = "msg_update_switch")
        public static /* synthetic */ void getMsgUpdateSwitch$annotations() {
        }

        @FieldName(name = "msg_update_switch_for_anchor")
        public static boolean getMsgUpdateSwitchForAnchor(ILiveLinkCameraBackUpConfig r100) {
            return true;
        }

        @FieldName(name = "msg_update_switch_for_anchor")
        public static /* synthetic */ void getMsgUpdateSwitchForAnchor$annotations() {
        }

        @FieldName(name = "report_ack_msg_switch")
        public static boolean getReportAckMsgSwitch(ILiveLinkCameraBackUpConfig r100) {
            return true;
        }

        @FieldName(name = "report_ack_msg_switch")
        public static /* synthetic */ void getReportAckMsgSwitch$annotations() {
        }

        @FieldName(name = "total_switch")
        public static boolean getTotalSwitch(ILiveLinkCameraBackUpConfig r100) {
            return true;
        }

        @FieldName(name = "total_switch")
        public static /* synthetic */ void getTotalSwitch$annotations() {
        }
    }

    @FieldName(name = "audience_check_linkers_switch")
    boolean getAudienceCheckLinkerSwitch();

    @FieldName(name = "max_diff_count")
    int getMaxDiffCount();

    @FieldName(name = "mix_stream_switch")
    boolean getMixStreamSwitch();

    @FieldName(name = "msg_update_switch")
    boolean getMsgUpdateSwitch();

    @FieldName(name = "msg_update_switch_for_anchor")
    boolean getMsgUpdateSwitchForAnchor();

    @FieldName(name = "report_ack_msg_switch")
    boolean getReportAckMsgSwitch();

    @FieldName(name = "total_switch")
    boolean getTotalSwitch();
}

package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\u0007\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\u0007\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00100\u001a\u0004\u0018\u00010&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\u0007\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R$\u00107\u001a\u0004\u0018\u0001018&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\u0007\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomOthersData;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomOthersDataEx;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IMorePanelData;", "getMorePanelInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IMorePanelData;", "getMorePanelInfo$annotations", "()V", "morePanelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IDecorationDetail;", "getDecoDetail", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IDecorationDetail;", "getDecoDetail$annotations", "decoDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAppointmentData;", "getAppointmentInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IAppointmentData;", "getAppointmentInfo$annotations", "appointmentInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMatrixData;", "getLiveMatrixData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMatrixData;", "getLiveMatrixData$annotations", "liveMatrixData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorTogetherLive;", "getAnchorTogetherLive", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorTogetherLive;", "setAnchorTogetherLive", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorTogetherLive;)V", "getAnchorTogetherLive$annotations", "anchorTogetherLive", "Lcom/bytedance/android/livesdkapi/depend/model/live/ICloudCollaborateData;", "getCloudCollaborateData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ICloudCollaborateData;", "setCloudCollaborateData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ICloudCollaborateData;)V", "getCloudCollaborateData$annotations", "cloudCollaborateData", "", "getInvitePanelGuideContent", "()Ljava/lang/String;", "setInvitePanelGuideContent", "(Ljava/lang/String;)V", "getInvitePanelGuideContent$annotations", "invitePanelGuideContent", "getParticipantActivity", "setParticipantActivity", "getParticipantActivity$annotations", "participantActivity", "Lcom/bytedance/android/livesdkapi/depend/model/live/IChangeRoomInfo;", "getChangeRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IChangeRoomInfo;", "setChangeRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IChangeRoomInfo;)V", "getChangeRoomInfo$annotations", "changeRoomInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomOthersData extends c<IRoomOthersData>, IRoomOthersDataEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "anchor_together_live")
        public static /* synthetic */ void getAnchorTogetherLive$annotations() {
        }

        @FieldName(name = "appointment_info")
        public static /* synthetic */ void getAppointmentInfo$annotations() {
        }

        @FieldName(name = "change_room_info")
        public static /* synthetic */ void getChangeRoomInfo$annotations() {
        }

        @FieldName(name = "cloud_collaborate_data")
        public static /* synthetic */ void getCloudCollaborateData$annotations() {
        }

        @FieldName(name = "deco_detail")
        public static /* synthetic */ void getDecoDetail$annotations() {
        }

        @FieldName(name = "panel_guidance")
        public static /* synthetic */ void getInvitePanelGuideContent$annotations() {
        }

        @FieldName(name = "live_matrix_info")
        public static /* synthetic */ void getLiveMatrixData$annotations() {
        }

        @FieldName(name = "more_panel_info")
        public static /* synthetic */ void getMorePanelInfo$annotations() {
        }

        @FieldName(name = "participant_activity")
        public static /* synthetic */ void getParticipantActivity$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "anchor_together_live")
    IAnchorTogetherLive getAnchorTogetherLive();

    @FieldName(name = "appointment_info")
    IAppointmentData getAppointmentInfo();

    @FieldName(name = "change_room_info")
    IChangeRoomInfo getChangeRoomInfo();

    @FieldName(name = "cloud_collaborate_data")
    ICloudCollaborateData getCloudCollaborateData();

    @FieldName(name = "deco_detail")
    IDecorationDetail getDecoDetail();

    @FieldName(name = "panel_guidance")
    String getInvitePanelGuideContent();

    @FieldName(name = "live_matrix_info")
    ILiveMatrixData getLiveMatrixData();

    @FieldName(name = "more_panel_info")
    IMorePanelData getMorePanelInfo();

    @FieldName(name = "participant_activity")
    String getParticipantActivity();

    @FieldName(name = "anchor_together_live#setter")
    void setAnchorTogetherLive(IAnchorTogetherLive r100);

    @FieldName(name = "change_room_info#setter")
    void setChangeRoomInfo(IChangeRoomInfo r100);

    @FieldName(name = "cloud_collaborate_data#setter")
    void setCloudCollaborateData(ICloudCollaborateData r100);

    @FieldName(name = "panel_guidance#setter")
    void setInvitePanelGuideContent(String r100);

    @FieldName(name = "participant_activity#setter")
    void setParticipantActivity(String r100);
}

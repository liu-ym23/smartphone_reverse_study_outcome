package com.bytedance.android.livesdk.announcement;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdk.announce.AnnouncementVideoList;
import com.bytedance.android.livesdk.announcement.entities.AnnouncementRandomContent;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0005DEFGHJ$\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'J.\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0002H'J.\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'JL\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0014\u001a\u00020\f2\b\b\u0001\u0010\u0015\u001a\u00020\u000eH'J.\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010\t\u001a\u00020\u0002H'J$\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u000eH'J~\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u000e2\b\b\u0001\u0010 \u001a\u00020\u000e2\b\b\u0001\u0010!\u001a\u00020\u00122\b\b\u0001\u0010\"\u001a\u00020\u000e2\b\b\u0001\u0010#\u001a\u00020\f2\b\b\u0001\u0010$\u001a\u00020\u00022\b\b\u0001\u0010%\u001a\u00020\u00122\b\b\u0001\u0010&\u001a\u00020\u000eH'J¦\u0001\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u000e2\b\b\u0001\u0010 \u001a\u00020\u000e2\b\b\u0001\u0010!\u001a\u00020\u00122\b\b\u0001\u0010\"\u001a\u00020\u000e2\b\b\u0001\u0010#\u001a\u00020\f2\b\b\u0001\u0010$\u001a\u00020\u00022\b\b\u0001\u0010%\u001a\u00020\u00122\b\b\u0001\u0010&\u001a\u00020\u000e2\b\b\u0001\u0010)\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0003\u0010*\u001a\u00020\f2\b\b\u0003\u0010+\u001a\u00020\u000eH'J$\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010.\u001a\u00020\u0012H'J.\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u00100\u001a\u00020\u0012H'JQ\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00070\u00050\u00042\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u00103\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b5\u00106JQ\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00070\u00050\u00042\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u00103\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b7\u00106J$\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u00108\u001a\u00020\u000eH'J.\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u00108\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\fH'J$\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u00108\u001a\u00020\u000eH'J.\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u00108\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\fH'J.\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010=\u001a\u00020\u000e2\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'J8\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0003\u0010@\u001a\u00020\u00122\b\b\u0001\u0010A\u001a\u00020\u0012H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006IÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementApi;", "", "", "from", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "Lcom/bytedance/android/live/base/model/Extra;", "getAnnouncementInfo", "version", "Lcom/bytedance/android/livesdk/announce/a;", "getAnnouncementInfoListV2", "", "appointmentId", "", "anchorId", "Lcom/bytedance/android/livesdk/announce/f;", "sendLiveAppointment", "", "isSend", "conversationShortId", "source", "sendLiveAppointmentDirect", "announcementId", "Lcom/bytedance/android/livesdk/announce/AnnouncementVideoList;", "getAnnouncementVideoList", "currentContent", "Lcom/bytedance/android/livesdk/announcement/entities/AnnouncementRandomContent;", "getRandomRecommendAnnouncementContent", "time", "date", "scheduledWeekdays", "content", "fanGroupSwitch", "fanGroupList", "GroupRemindTime", "AutoPublishSwitch", "modifyBindVideo", "videoItemIds", "Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$ResponseWithMsg;", "submitAnnouncement", "action", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "redPacketOrderNo", "Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$AppointmentActionResponse;", "submitAnnouncementOpt", "open", "switchAnnouncementOpenStatus", "subscribe", "subscribeAnnouncement", "enterFromMerge", "enterMethod", "Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$SubscribeRequestResponse;", "subscribeAnnouncementOpt", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "unSubscribeAnnouncementOpt", "userId", "publishAnnouncement", "publishAnnouncementOpt", "unPublishAnnouncement", "unPublishAnnouncementOpt", "anchorSecUid", "Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$QueryAnnouncementInfoResopnse;", "queryAnnouncementInfo", "withoutDetail", "isCycle", "Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$QueryAnnouncementInfoResoponseOpt;", "queryAnnouncementInfoOpt", "AppointmentActionResponse", "QueryAnnouncementInfoResopnse", "QueryAnnouncementInfoResoponseOpt", "ResponseWithMsg", "SubscribeRequestResponse", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AnnouncementApi {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.announcement.AnnouncementApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getAnnouncementInfo$default(AnnouncementApi r100, int r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = 1;
        L7:
            return r100.getAnnouncementInfo(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnnouncementInfo");
        }

        public static /* synthetic */ Observable getAnnouncementInfoListV2$default(AnnouncementApi r100, int r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = 1;
        L7:
            if ((r103 & 2) == 0) goto L10;
            r102 = 1;
        L10:
            return r100.getAnnouncementInfoListV2(r101, r102);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnnouncementInfoListV2");
        }

        public static /* synthetic */ Observable getAnnouncementVideoList$default(AnnouncementApi r100, long r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = 0;
        L7:
            if ((r103 & 2) == 0) goto L10;
            r102 = 0;
        L10:
            return r100.getAnnouncementVideoList(r101, r102);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnnouncementVideoList");
        }

        public static /* synthetic */ Observable queryAnnouncementInfoOpt$default(AnnouncementApi r100, long r101, boolean r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 2) == 0) goto L7;
            r102 = true;
        L7:
            return r100.queryAnnouncementInfoOpt(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryAnnouncementInfoOpt");
        }

        public static /* synthetic */ Observable subscribeAnnouncementOpt$default(AnnouncementApi r100, Long r101, String r102, String r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = null;
        L7:
            return r100.subscribeAnnouncementOpt(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeAnnouncementOpt");
        }

        public static /* synthetic */ Observable unSubscribeAnnouncementOpt$default(AnnouncementApi r100, Long r101, String r102, String r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = null;
        L7:
            return r100.unSubscribeAnnouncementOpt(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unSubscribeAnnouncementOpt");
        }

        public static /* synthetic */ Observable submitAnnouncementOpt$default(AnnouncementApi r210, int r211, int r212, String r213, String r214, boolean r215, String r216, long r217, int r310, boolean r311, String r312, int r313, long r314, long r315, String r316, int r317, Object r410) {
            if (r410 != null) goto L15;
            if ((r317 & 4096) == 0) goto L7;
            long r110 = 0;
        L9:
            if ((r317 & 8192) == 0) goto L11;
            String r218 = "";
        L13:
            return r210.submitAnnouncementOpt(r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r110, r218);
        L11:
            r218 = r316;
            goto L13
        L7:
            r110 = r315;
            goto L9
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitAnnouncementOpt");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$AppointmentActionResponse;", "", "code", "", "message", "", "appointmentId", "", "(ILjava/lang/String;Ljava/lang/Long;)V", "getAppointmentId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AppointmentActionResponse {

        @SerializedName("appointment_id")
        private final Long appointmentId;

        @SerializedName("code")
        private final int code;

        @SerializedName("message")
        private final String message;

        public AppointmentActionResponse() {
            this(0, null, null, 7, null);
        }

        public final Long getAppointmentId() {
            return this.appointmentId;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public AppointmentActionResponse(int r100, String r101, Long r102) {
            this.code = r100;
            this.message = r101;
            this.appointmentId = r102;
        }

        public /* synthetic */ AppointmentActionResponse(int r100, String r101, Long r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0L;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$QueryAnnouncementInfoResopnse;", "", "hasData", "", "timeText", "", "hasSubscribed", "", "(ILjava/lang/String;Z)V", "getHasData", "()I", "getHasSubscribed", "()Z", "getTimeText", "()Ljava/lang/String;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class QueryAnnouncementInfoResopnse {

        @SerializedName("has_data")
        private final int hasData;

        @SerializedName("has_subscribed")
        private final boolean hasSubscribed;

        @SerializedName("live_time_text")
        private final String timeText;

        public QueryAnnouncementInfoResopnse() {
            this(0, null, false, 7, null);
        }

        public final int getHasData() {
            return this.hasData;
        }

        public final boolean getHasSubscribed() {
            return this.hasSubscribed;
        }

        public final String getTimeText() {
            return this.timeText;
        }

        public QueryAnnouncementInfoResopnse(int r100, String r101, boolean r102) {
            this.hasData = r100;
            this.timeText = r101;
            this.hasSubscribed = r102;
        }

        public /* synthetic */ QueryAnnouncementInfoResopnse(int r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 2;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = false;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$QueryAnnouncementInfoResoponseOpt;", "", "hasSubscribed", "", "(Z)V", "getHasSubscribed", "()Z", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class QueryAnnouncementInfoResoponseOpt {

        @SerializedName("has_subscribe")
        private final boolean hasSubscribed;

        public QueryAnnouncementInfoResoponseOpt() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public final boolean getHasSubscribed() {
            return this.hasSubscribed;
        }

        public QueryAnnouncementInfoResoponseOpt(boolean r100) {
            this.hasSubscribed = r100;
        }

        public /* synthetic */ QueryAnnouncementInfoResoponseOpt(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$ResponseWithMsg;", "", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ResponseWithMsg {

        @SerializedName("code")
        private final int code;

        @SerializedName("message")
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public ResponseWithMsg() {
            int r100 = 0;
            this(r100, null, 3, 0 == true ? 1 : 0);
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public ResponseWithMsg(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "message");
            this.code = r100;
            this.message = r101;
        }

        public /* synthetic */ ResponseWithMsg(int r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "";
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementApi$SubscribeRequestResponse;", "", "()V", "responseStatus", "", "getResponseStatus", "()I", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SubscribeRequestResponse {

        @SerializedName("response_status")
        private final int responseStatus;

        public SubscribeRequestResponse() {
        }

        public final int getResponseStatus() {
            return this.responseStatus;
        }
    }

    @GET("/webcast/anchor/announcement/anchor_get/")
    Observable<BaseResponse<AnnouncementInfo, Extra>> getAnnouncementInfo(@Query("from") int r100);

    @GET("/webcast/appointment/anchor_get/")
    Observable<BaseResponse<com.bytedance.android.livesdk.announce.a, Extra>> getAnnouncementInfoListV2(@Query("from") int r100, @Query("Version") int r101);

    @GET("/webcast/anchor/announcement/video_list/")
    Observable<BaseResponse<AnnouncementVideoList, Extra>> getAnnouncementVideoList(@Query("announcement_id") long r100, @Query("version") int r101);

    @GET("/webcast/anchor/announcement/random_content/")
    Observable<BaseResponse<AnnouncementRandomContent, Extra>> getRandomRecommendAnnouncementContent(@Query("current_content") String r100);

    @POST("/webcast/anchor/appointment/component/publish")
    Observable<BaseResponse<Object, Extra>> publishAnnouncement(@Query("user_id") String r100);

    @POST("/webcast/anchor/appointment/component/publish")
    Observable<BaseResponse<Object, Extra>> publishAnnouncementOpt(@Query("user_id") String r100, @Query("appointment_id") long r101);

    @GET("/webcast/user/announcement/query/")
    Observable<BaseResponse<QueryAnnouncementInfoResopnse, Extra>> queryAnnouncementInfo(@Query("sec_anchor_user_id") String r100, @Query("from") int r101);

    @GET("/webcast/appointment/status/")
    Observable<BaseResponse<QueryAnnouncementInfoResoponseOpt, Extra>> queryAnnouncementInfoOpt(@Query("appointment_id") long r100, @Query("without_detail") boolean r101, @Query("cycle") boolean r102);

    @GET("/webcast/appointment/im/share")
    Observable<BaseResponse<com.bytedance.android.livesdk.announce.f, Extra>> sendLiveAppointment(@Query("appointment_id") long r100, @Query("anchor_id") String r101);

    @GET("/webcast/appointment/im/share")
    Observable<BaseResponse<com.bytedance.android.livesdk.announce.f, Extra>> sendLiveAppointmentDirect(@Query("appointment_id") long r100, @Query("anchor_id") String r101, @Query("is_send_msg") boolean r102, @Query("conv_short_id") long r103, @Query("source") String r104);

    @FormUrlEncoded
    @POST("/webcast/anchor/announcement/submit/")
    Observable<BaseResponse<ResponseWithMsg, Extra>> submitAnnouncement(@Field("scheduled_time") int r100, @Field("scheduled_date") int r101, @Field("scheduled_weekdays_str") String r102, @Field("content") String r103, @Field("group_switch") boolean r104, @Field("group_id_list") String r105, @Field("group_remind_time") long r106, @Field("auto_publish_highlight") int r107, @Field("modify_bind_video") boolean r110, @Field("video_item_ids") String r111);

    @FormUrlEncoded
    @POST("/webcast/anchor/announcement/action/")
    Observable<BaseResponse<AppointmentActionResponse, Extra>> submitAnnouncementOpt(@Field("scheduled_time") int r100, @Field("scheduled_date") int r101, @Field("scheduled_weekdays_str") String r102, @Field("content") String r103, @Field("group_switch") boolean r104, @Field("group_id_list") String r105, @Field("group_remind_time") long r106, @Field("auto_publish_highlight") int r107, @Field("modify_bind_video") boolean r110, @Field("video_item_ids") String r111, @Field("action") int r112, @Field("appointment_id") long r113, @Field("expire_time") long r114, @Field("red_packet_order_no") String r115);

    @POST("/webcast/user/announcement/subscribe/")
    Observable<BaseResponse<Object, Extra>> subscribeAnnouncement(@Query("sec_anchor_user_id") String r100, @Query("subscribed") boolean r101);

    @POST("/webcast/appointment/make/")
    Observable<BaseResponse<SubscribeRequestResponse, Extra>> subscribeAnnouncementOpt(@Query("appointment_id") Long r100, @Query("enter_from_merge") String r101, @Query("enter_method") String r102, @Query("source") String r103);

    @POST("/webcast/anchor/announcement/switch/")
    Observable<BaseResponse<ResponseWithMsg, Extra>> switchAnnouncementOpenStatus(@Query("switch") boolean r100);

    @POST("/webcast/anchor/appointment/component/unpublish")
    Observable<BaseResponse<Object, Extra>> unPublishAnnouncement(@Query("user_id") String r100);

    @POST("/webcast/anchor/appointment/component/unpublish")
    Observable<BaseResponse<Object, Extra>> unPublishAnnouncementOpt(@Query("user_id") String r100, @Query("appointment_id") long r101);

    @POST("/webcast/appointment/cancel/")
    Observable<BaseResponse<SubscribeRequestResponse, Extra>> unSubscribeAnnouncementOpt(@Query("appointment_id") Long r100, @Query("enter_from_merge") String r101, @Query("enter_method") String r102, @Query("source") String r103);
}

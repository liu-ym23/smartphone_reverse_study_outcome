package com.bytedance.android.livesdkapi.calendar;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\u001cJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H&J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager;", "", "hasFullPermission", "", "getHasFullPermission", "()Z", "hasReadPermission", "getHasReadPermission", "hasWritePermission", "getHasWritePermission", "add", "Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$ErrorCode;", "event", "Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$EventParams;", MonitorConstants.CONNECT_TYPE_GET, "Lkotlin/Pair;", "Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$EventRecord;", b.f276361k, "", "remove", "anchorId", "requestPermissionAndAdd", "Lio/reactivex/Single;", "handler", "Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$IPermissionHandler;", "ErrorCode", "EventParams", "EventRecord", "IPermissionHandler", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICalendarManager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$ErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Success", "NoPermission", "ArgumentError", "NoAccount", "NotFound", "AlreadyExists", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ErrorCode extends Enum<ErrorCode> {
        private static final /* synthetic */ ErrorCode[] $VALUES = null;
        public static final ErrorCode AlreadyExists = null;
        public static final ErrorCode ArgumentError = null;
        public static final ErrorCode NoAccount = null;
        public static final ErrorCode NoPermission = null;
        public static final ErrorCode NotFound = null;
        public static final ErrorCode Success = null;
        public static final ErrorCode Unknown = null;
        private final int value;

        static {
            ErrorCode r100 = new ErrorCode("Unknown", 0, -1);
            Unknown = r100;
            ErrorCode r101 = new ErrorCode("Success", 1, 1);
            Success = r101;
            ErrorCode r102 = new ErrorCode("NoPermission", 2, 10000);
            NoPermission = r102;
            ErrorCode r103 = new ErrorCode("ArgumentError", 3, 10001);
            ArgumentError = r103;
            ErrorCode r104 = new ErrorCode("NoAccount", 4, 10002);
            NoAccount = r104;
            ErrorCode r105 = new ErrorCode("NotFound", 5, 10003);
            NotFound = r105;
            ErrorCode r106 = new ErrorCode("AlreadyExists", 6, 10004);
            AlreadyExists = r106;
            $VALUES = new ErrorCode[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static ErrorCode valueOf(String r100) {
            return (ErrorCode) a.a(ErrorCode.class, r100);
        }

        public static ErrorCode[] values() {
            return (ErrorCode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        private ErrorCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$EventParams;", "Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$EventRecord;", "()V", "anchorId", "", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "secAnchorId", "getSecAnchorId", "setSecAnchorId", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EventParams extends EventRecord {

        @SerializedName("anchor_id")
        private String anchorId;

        @SerializedName("sec_anchor_id")
        private String secAnchorId;

        public EventParams() {
            this.anchorId = "";
            this.secAnchorId = "";
        }

        public final String getAnchorId() {
            return this.anchorId;
        }

        public final String getSecAnchorId() {
            return this.secAnchorId;
        }

        public final void setAnchorId(String r100) {
            this.anchorId = r100;
        }

        public final void setSecAnchorId(String r100) {
            this.secAnchorId = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020\u000bH\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R \u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$EventRecord;", "", "()V", "alarmMinutes", "", "getAlarmMinutes", "()Ljava/lang/Integer;", "setAlarmMinutes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "appUrl", "", "getAppUrl", "()Ljava/lang/String;", "setAppUrl", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", b.f276361k, "getEventId", "setEventId", "scheduledWeekDays", "", "getScheduledWeekDays", "()Ljava/util/List;", "setScheduledWeekDays", "(Ljava/util/List;)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "title", "getTitle", d.f25925o, "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class EventRecord {

        @SerializedName("alarm_minutes")
        private Integer alarmMinutes;

        @SerializedName("url")
        private String appUrl;

        @SerializedName("description")
        private String description;

        @SerializedName("end_time")
        private long endTime;

        @SerializedName("event_id")
        private String eventId;

        @SerializedName("scheduled_weekdays")
        private List<Integer> scheduledWeekDays;

        @SerializedName(ILoadStallMonitor.START_TIME)
        private long startTime;

        @SerializedName("title")
        private String title;

        public String toString() {
            return ArraysKt.joinToString$default(EventRecord.class.getDeclaredFields(), null, "EventRecord(", ")", 0, null, new ICalendarManager$EventRecord$toString$1(this), 25, null);
        }

        public EventRecord() {
            this.eventId = "";
            this.appUrl = "";
        }

        public final Integer getAlarmMinutes() {
            return this.alarmMinutes;
        }

        public final String getAppUrl() {
            return this.appUrl;
        }

        public final String getDescription() {
            return this.description;
        }

        public final long getEndTime() {
            return this.endTime;
        }

        public final String getEventId() {
            return this.eventId;
        }

        public final List<Integer> getScheduledWeekDays() {
            return this.scheduledWeekDays;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setAlarmMinutes(Integer r100) {
            this.alarmMinutes = r100;
        }

        public final void setAppUrl(String r100) {
            this.appUrl = r100;
        }

        public final void setDescription(String r100) {
            this.description = r100;
        }

        public final void setEndTime(long r100) {
            this.endTime = r100;
        }

        public final void setEventId(String r100) {
            this.eventId = r100;
        }

        public final void setScheduledWeekDays(List<Integer> r100) {
            this.scheduledWeekDays = r100;
        }

        public final void setStartTime(long r100) {
            this.startTime = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/calendar/ICalendarManager$IPermissionHandler;", "", "requestCalendarPermission", "Lio/reactivex/Single;", "", "requestWriteCalendarPermission", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IPermissionHandler {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static Single<int[]> requestWriteCalendarPermission(IPermissionHandler r100) {
                return Single.fromCallable(ICalendarManager$IPermissionHandler$requestWriteCalendarPermission$1.INSTANCE);
            }
        }

        Single<int[]> requestCalendarPermission();

        Single<int[]> requestWriteCalendarPermission();
    }

    ErrorCode add(EventParams r100);

    Pair<ErrorCode, EventRecord> get(String r100);

    boolean getHasFullPermission();

    boolean getHasReadPermission();

    boolean getHasWritePermission();

    ErrorCode remove(String r100, String r101);

    Single<ErrorCode> requestPermissionAndAdd(EventParams r100, IPermissionHandler r101);
}

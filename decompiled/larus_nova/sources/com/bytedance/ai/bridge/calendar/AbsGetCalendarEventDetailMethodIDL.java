package com.bytedance.ai.bridge.calendar;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$GetCalendarEventDetailParamModel;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$CalendarEventResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetCalendarEventDetailParamModel", "CalendarEventResultModel", "Calendar", "CalendarEvent", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetCalendarEventDetailMethodIDL extends CoreAIBridgeMethod<b, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35231a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$Calendar;", "", CommonConstant.KEY_DISPLAY_NAME, "", "url", "cTag", "syncToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getUrl", "getCTag", "getSyncToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Calendar {

        @SerializedName("cTag")
        private final String cTag;

        @SerializedName(CommonConstant.KEY_DISPLAY_NAME)
        private final String displayName;

        @SerializedName("syncToken")
        private final String syncToken;

        @SerializedName("url")
        private final String url;

        public static /* synthetic */ Calendar copy$default(Calendar r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.displayName;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.url;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.cTag;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.syncToken;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.displayName;
        }

        public final String component2() {
            return this.url;
        }

        public final String component3() {
            return this.cTag;
        }

        public final String component4() {
            return this.syncToken;
        }

        public final Calendar copy(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, CommonConstant.KEY_DISPLAY_NAME);
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, "cTag");
            return new Calendar(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Calendar) == true) goto L8;
            return false;
        L8:
            Calendar r101 = (Calendar) r100;
            if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.cTag, r101.cTag) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.syncToken, r101.syncToken) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = ((((this.displayName.hashCode() * 31) + this.url.hashCode()) * 31) + this.cTag.hashCode()) * 31;
            String r101 = this.syncToken;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "Calendar(displayName=" + this.displayName + ", url=" + this.url + ", cTag=" + this.cTag + ", syncToken=" + this.syncToken + ')';
        }

        public final String getCTag() {
            return this.cTag;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getSyncToken() {
            return this.syncToken;
        }

        public final String getUrl() {
            return this.url;
        }

        public Calendar(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, CommonConstant.KEY_DISPLAY_NAME);
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, "cTag");
            this.displayName = r100;
            this.url = r101;
            this.cTag = r102;
            this.syncToken = r103;
        }

        public /* synthetic */ Calendar(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 8) == 0) goto L5;
            r103 = null;
        L5:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$CalendarEvent;", "", DBDefinition.ETAG, "", "href", "iCalendar", "scheduleTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getETag", "()Ljava/lang/String;", "getHref", "getICalendar", "getScheduleTag", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CalendarEvent {

        @SerializedName(DBDefinition.ETAG)
        private final String eTag;

        @SerializedName("href")
        private final String href;

        @SerializedName("iCalendar")
        private final String iCalendar;

        @SerializedName("scheduleTag")
        private final String scheduleTag;

        public static /* synthetic */ CalendarEvent copy$default(CalendarEvent r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.eTag;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.href;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.iCalendar;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.scheduleTag;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.eTag;
        }

        public final String component2() {
            return this.href;
        }

        public final String component3() {
            return this.iCalendar;
        }

        public final String component4() {
            return this.scheduleTag;
        }

        public final CalendarEvent copy(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "href");
            return new CalendarEvent(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CalendarEvent) == true) goto L8;
            return false;
        L8:
            CalendarEvent r101 = (CalendarEvent) r100;
            if (Intrinsics.areEqual(this.eTag, r101.eTag) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.href, r101.href) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.iCalendar, r101.iCalendar) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.scheduleTag, r101.scheduleTag) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r100 = this.eTag;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.href.hashCode()) * 31;
            String r104 = this.iCalendar;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.scheduleTag;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "CalendarEvent(eTag=" + this.eTag + ", href=" + this.href + ", iCalendar=" + this.iCalendar + ", scheduleTag=" + this.scheduleTag + ')';
        }

        public final String getETag() {
            return this.eTag;
        }

        public final String getHref() {
            return this.href;
        }

        public final String getICalendar() {
            return this.iCalendar;
        }

        public final String getScheduleTag() {
            return this.scheduleTag;
        }

        public CalendarEvent(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "href");
            this.eTag = r100;
            this.href = r101;
            this.iCalendar = r102;
            this.scheduleTag = r103;
        }

        public /* synthetic */ CalendarEvent(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r103 = null;
        L11:
            this(r100, r101, r102, r103);
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
        @AIBridgeParamField(keyPath = "calendarEvents", required = true)
        void setCalendarEvents(List<CalendarEvent> r100);
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "calendar", required = true)
        Calendar getCalendar();

        @AIBridgeParamField(keyPath = "eventUrls", required = true)
        List<String> getEventUrls();

        @AIBridgeParamField(keyPath = "password", required = true)
        String getPassword();

        @AIBridgeParamField(keyPath = "userName", required = true)
        String getUserName();
    }

    public AbsGetCalendarEventDetailMethodIDL() {
        this.f35231a = "applet.calendar.getCalendarEventDetail";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35231a;
    }
}

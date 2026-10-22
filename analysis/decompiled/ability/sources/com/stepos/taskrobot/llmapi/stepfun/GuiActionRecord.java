package com.stepos.taskrobot.llmapi.stepfun;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.reflect.TypeToken;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u001d\b\u0086\b\u0018\u0000 R2\u00020\u0001:\u0001RB\u008f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020!¢\u0006\u0004\b$\u0010#J\r\u0010%\u001a\u00020!¢\u0006\u0004\b%\u0010#J\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010 J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010 J\u0010\u0010(\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b(\u0010 J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010 J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010 J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010 J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010 J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010 J\u0018\u0010.\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b.\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010 J\u0018\u00101\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b1\u0010/J\u009c\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b4\u0010 J\u0010\u00105\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b5\u0010\u001bJ\u001a\u00108\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003¢\u0006\u0004\b8\u00109R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010:\u001a\u0004\b;\u0010 \"\u0004\b<\u0010=R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010:\u001a\u0004\b>\u0010 \"\u0004\b?\u0010=R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010:\u001a\u0004\b@\u0010 R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010:\u001a\u0004\bA\u0010 \"\u0004\bB\u0010=R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010:\u001a\u0004\bC\u0010 \"\u0004\bD\u0010=R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010:\u001a\u0004\bE\u0010 \"\u0004\bF\u0010=R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010:\u001a\u0004\bG\u0010 \"\u0004\bH\u0010=R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010:\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010=R\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010K\u001a\u0004\bL\u0010/R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010:\u001a\u0004\bM\u0010 \"\u0004\bN\u0010=R*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010K\u001a\u0004\bO\u0010/\"\u0004\bP\u0010Q¨\u0006S"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;", "Landroid/os/Parcelable;", "", "actionType", "actionResult", "startTime", "endTime", "screenshotPath", "message", "explain", "value", "", "", "point", AgentBusWakeContract.EXTRA_SOURCE, "Lorg/json/JSONObject;", "regionXmlInfo", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "calculateDuration", "()Ljava/lang/Long;", "calculateDurationFormatted", "()Ljava/lang/String;", "", "isCompleted", "()Z", "isSuccess", "hasScreenshot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "()Ljava/util/List;", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getActionType", "setActionType", "(Ljava/lang/String;)V", "getActionResult", "setActionResult", "getStartTime", "getEndTime", "setEndTime", "getScreenshotPath", "setScreenshotPath", "getMessage", "setMessage", "getExplain", "setExplain", "getValue", "setValue", "Ljava/util/List;", "getPoint", "getSource", "setSource", "getRegionXmlInfo", "setRegionXmlInfo", "(Ljava/util/List;)V", "CREATOR", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GuiActionRecord implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private String actionResult;
    private String actionType;
    private String endTime;
    private String explain;
    private String message;
    private final List<Integer> point;
    private List<? extends JSONObject> regionXmlInfo;
    private String screenshotPath;
    private String source;
    private final String startTime;
    private String value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;", AppAgent.CONSTRUCT, "()V", "TIME_FORMAT", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.GuiActionRecord$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<GuiActionRecord> {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GuiActionRecord createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.k.f(parcel, "parcel");
            return new GuiActionRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GuiActionRecord[] newArray(int size) {
            return new GuiActionRecord[size];
        }
    }

    public GuiActionRecord(String actionType, String str, String startTime, String str2, String str3, String str4, String str5, String str6, List<Integer> list, String str7, List<? extends JSONObject> list2) {
        kotlin.jvm.internal.k.f(actionType, "actionType");
        kotlin.jvm.internal.k.f(startTime, "startTime");
        this.actionType = actionType;
        this.actionResult = str;
        this.startTime = startTime;
        this.endTime = str2;
        this.screenshotPath = str3;
        this.message = str4;
        this.explain = str5;
        this.value = str6;
        this.point = list;
        this.source = str7;
        this.regionXmlInfo = list2;
    }

    public static /* synthetic */ GuiActionRecord copy$default(GuiActionRecord guiActionRecord, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List list, String str9, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiActionRecord.actionType;
        }
        if ((i & 2) != 0) {
            str2 = guiActionRecord.actionResult;
        }
        if ((i & 4) != 0) {
            str3 = guiActionRecord.startTime;
        }
        if ((i & 8) != 0) {
            str4 = guiActionRecord.endTime;
        }
        if ((i & 16) != 0) {
            str5 = guiActionRecord.screenshotPath;
        }
        if ((i & 32) != 0) {
            str6 = guiActionRecord.message;
        }
        if ((i & 64) != 0) {
            str7 = guiActionRecord.explain;
        }
        if ((i & 128) != 0) {
            str8 = guiActionRecord.value;
        }
        if ((i & 256) != 0) {
            list = guiActionRecord.point;
        }
        if ((i & 512) != 0) {
            str9 = guiActionRecord.source;
        }
        if ((i & 1024) != 0) {
            list2 = guiActionRecord.regionXmlInfo;
        }
        String str10 = str9;
        List list3 = list2;
        String str11 = str8;
        List list4 = list;
        String str12 = str6;
        String str13 = str7;
        String str14 = str5;
        String str15 = str3;
        return guiActionRecord.copy(str, str2, str15, str4, str14, str12, str13, str11, list4, str10, list3);
    }

    public final Long calculateDuration() throws ParseException {
        if (this.endTime == null) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault());
            Date date = simpleDateFormat.parse(this.startTime);
            if (date != null) {
                long time = date.getTime();
                Date date2 = simpleDateFormat.parse(this.endTime);
                if (date2 != null) {
                    return Long.valueOf((date2.getTime() - time) / 1000);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final String calculateDurationFormatted() throws ParseException {
        Long lCalculateDuration = calculateDuration();
        if (lCalculateDuration == null) {
            return null;
        }
        long jLongValue = lCalculateDuration.longValue();
        long j5 = 60;
        long j6 = jLongValue / j5;
        long j10 = jLongValue % j5;
        StringBuilder sb = new StringBuilder();
        if (j6 > 0) {
            sb.append(j6 + "分钟");
        }
        if (j10 > 0 || sb.length() == 0) {
            sb.append(j10 + "秒");
        }
        return sb.toString();
    }

    /* renamed from: component1, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* renamed from: component10, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public final List<JSONObject> component11() {
        return this.regionXmlInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getActionResult() {
        return this.actionResult;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component7, reason: from getter */
    public final String getExplain() {
        return this.explain;
    }

    /* renamed from: component8, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final List<Integer> component9() {
        return this.point;
    }

    public final GuiActionRecord copy(String actionType, String actionResult, String startTime, String endTime, String screenshotPath, String message, String explain, String value, List<Integer> point, String source, List<? extends JSONObject> regionXmlInfo) {
        kotlin.jvm.internal.k.f(actionType, "actionType");
        kotlin.jvm.internal.k.f(startTime, "startTime");
        return new GuiActionRecord(actionType, actionResult, startTime, endTime, screenshotPath, message, explain, value, point, source, regionXmlInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiActionRecord)) {
            return false;
        }
        GuiActionRecord guiActionRecord = (GuiActionRecord) other;
        return kotlin.jvm.internal.k.b(this.actionType, guiActionRecord.actionType) && kotlin.jvm.internal.k.b(this.actionResult, guiActionRecord.actionResult) && kotlin.jvm.internal.k.b(this.startTime, guiActionRecord.startTime) && kotlin.jvm.internal.k.b(this.endTime, guiActionRecord.endTime) && kotlin.jvm.internal.k.b(this.screenshotPath, guiActionRecord.screenshotPath) && kotlin.jvm.internal.k.b(this.message, guiActionRecord.message) && kotlin.jvm.internal.k.b(this.explain, guiActionRecord.explain) && kotlin.jvm.internal.k.b(this.value, guiActionRecord.value) && kotlin.jvm.internal.k.b(this.point, guiActionRecord.point) && kotlin.jvm.internal.k.b(this.source, guiActionRecord.source) && kotlin.jvm.internal.k.b(this.regionXmlInfo, guiActionRecord.regionXmlInfo);
    }

    public final String getActionResult() {
        return this.actionResult;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getExplain() {
        return this.explain;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<Integer> getPoint() {
        return this.point;
    }

    public final List<JSONObject> getRegionXmlInfo() {
        return this.regionXmlInfo;
    }

    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean hasScreenshot() {
        String str = this.screenshotPath;
        return !(str == null || str.length() == 0);
    }

    public int hashCode() {
        int iHashCode = this.actionType.hashCode() * 31;
        String str = this.actionResult;
        int iC = B7.a.c((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.startTime);
        String str2 = this.endTime;
        int iHashCode2 = (iC + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.screenshotPath;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.message;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.explain;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.value;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<Integer> list = this.point;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.source;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<? extends JSONObject> list2 = this.regionXmlInfo;
        return iHashCode8 + (list2 != null ? list2.hashCode() : 0);
    }

    public final boolean isCompleted() {
        return this.endTime != null;
    }

    public final boolean isSuccess() {
        String str = this.actionResult;
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
            if (j9.m.h0(lowerCase, "success", false) || j9.m.h0(lowerCase, "成功", false)) {
                return true;
            }
        }
        return false;
    }

    public final void setActionResult(String str) {
        this.actionResult = str;
    }

    public final void setActionType(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        this.actionType = str;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setExplain(String str) {
        this.explain = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setRegionXmlInfo(List<? extends JSONObject> list) {
        this.regionXmlInfo = list;
    }

    public final void setScreenshotPath(String str) {
        this.screenshotPath = str;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        String str = this.actionType;
        String str2 = this.actionResult;
        String str3 = this.startTime;
        String str4 = this.endTime;
        String str5 = this.screenshotPath;
        String str6 = this.message;
        String str7 = this.explain;
        String str8 = this.value;
        List<Integer> list = this.point;
        String str9 = this.source;
        List<? extends JSONObject> list2 = this.regionXmlInfo;
        StringBuilder sbW = B7.a.w("GuiActionRecord(actionType=", str, ", actionResult=", str2, ", startTime=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", endTime=", str4, ", screenshotPath=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", message=", str6, ", explain=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str7, ", value=", str8, ", point=");
        sbW.append(list);
        sbW.append(", source=");
        sbW.append(str9);
        sbW.append(", regionXmlInfo=");
        return androidx.appfunctions.metadata.a.q(sbW, list2, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        kotlin.jvm.internal.k.f(parcel, "parcel");
        parcel.writeString(this.actionType);
        parcel.writeString(this.actionResult);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeString(this.screenshotPath);
        parcel.writeString(this.message);
        parcel.writeString(this.explain);
        parcel.writeString(this.value);
        List<Integer> list = this.point;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeInt(((Number) it.next()).intValue());
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.source);
        List<? extends JSONObject> list2 = this.regionXmlInfo;
        parcel.writeString(list2 != null ? GuiActionRecordKt.gson.toJson(list2) : null);
    }

    public /* synthetic */ GuiActionRecord(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List list, String str9, List list2, int i, kotlin.jvm.internal.e eVar) {
        this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : list, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : list2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GuiActionRecord(Parcel parcel) {
        ArrayList arrayList;
        kotlin.jvm.internal.k.f(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String str2 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        List list = null;
        if (parcel.readByte() == 0) {
            arrayList = null;
        } else {
            int i = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i);
            for (int i6 = 0; i6 < i; i6++) {
                arrayList2.add(Integer.valueOf(parcel.readInt()));
            }
            arrayList = arrayList2;
        }
        String string9 = parcel.readString();
        String string10 = parcel.readString();
        if (string10 != null) {
            try {
                list = (List) GuiActionRecordKt.gson.fromJson(string10, new TypeToken<List<? extends JSONObject>>() { // from class: com.stepos.taskrobot.llmapi.stepfun.GuiActionRecord$2$type$1
                }.getType());
            } catch (Exception unused) {
            }
        }
        this(str, string2, str2, string4, string5, string6, string7, string8, arrayList, string9, list);
    }
}

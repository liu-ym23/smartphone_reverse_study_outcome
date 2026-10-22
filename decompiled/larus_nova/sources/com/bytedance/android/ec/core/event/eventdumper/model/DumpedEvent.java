package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.texturerender.VideoSurfaceTexture;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001aJn\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u000eHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00069"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEvent;", "Ljava/io/Serializable;", "eventName", "", "dumpedDumpedEventParams", "", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventKey;", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventParam;", "stackTrace", VideoSurfaceTexture.KEY_TIME, "", "dumpedClassInfo", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;", "localIndex", "", "eventClassVersion", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;JLcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDumpedClassInfo", "()Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;", "setDumpedClassInfo", "(Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;)V", "getDumpedDumpedEventParams", "()Ljava/util/Map;", "setDumpedDumpedEventParams", "(Ljava/util/Map;)V", "getEventClassVersion", "()Ljava/lang/Integer;", "setEventClassVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "getLocalIndex", "setLocalIndex", "getStackTrace", "setStackTrace", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;JLcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEvent;", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DumpedEvent implements Serializable {

    @SerializedName("event_class_info")
    private DumpedClassInfo dumpedClassInfo;

    @SerializedName("event_params")
    private Map<DumpedEventKey, DumpedEventParam> dumpedDumpedEventParams;

    @SerializedName("event_class_version")
    private Integer eventClassVersion;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private String eventName;

    @SerializedName("local_index")
    private Integer localIndex;

    @SerializedName("stack_trace")
    private String stackTrace;

    @SerializedName("time_stamp")
    private long timeStamp;

    public DumpedEvent() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DumpedEvent copy$default(DumpedEvent r100, String r110, Map r111, String r112, long r113, DumpedClassInfo r114, Integer r115, Integer r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.eventName;
    L7:
        if ((r117 & 2) == 0) goto L9;
        Map r102 = r100.dumpedDumpedEventParams;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = r100.stackTrace;
    L15:
        if ((r117 & 8) == 0) goto L17;
        long r104 = r100.timeStamp;
    L19:
        if ((r117 & 16) == 0) goto L21;
        DumpedClassInfo r105 = r100.dumpedClassInfo;
    L23:
        if ((r117 & 32) == 0) goto L25;
        Integer r106 = r100.localIndex;
    L27:
        if ((r117 & 64) == 0) goto L29;
        Integer r107 = r100.eventClassVersion;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.eventName;
    }

    public final Map<DumpedEventKey, DumpedEventParam> component2() {
        return this.dumpedDumpedEventParams;
    }

    public final String component3() {
        return this.stackTrace;
    }

    public final long component4() {
        return this.timeStamp;
    }

    public final DumpedClassInfo component5() {
        return this.dumpedClassInfo;
    }

    public final Integer component6() {
        return this.localIndex;
    }

    public final Integer component7() {
        return this.eventClassVersion;
    }

    public final DumpedEvent copy(String r110, Map<DumpedEventKey, DumpedEventParam> r111, String r112, long r113, DumpedClassInfo r114, Integer r115, Integer r116) {
        return new DumpedEvent(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DumpedEvent) == false) goto L20;
        DumpedEvent r101 = (DumpedEvent) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dumpedDumpedEventParams, r101.dumpedDumpedEventParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.stackTrace, r101.stackTrace) == true) goto L12;
        return false;
    L12:
        if (this.timeStamp == r101.timeStamp) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.dumpedClassInfo, r101.dumpedClassInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.localIndex, r101.localIndex) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventClassVersion, r101.eventClassVersion) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.eventName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<DumpedEventKey, DumpedEventParam> r104 = this.dumpedDumpedEventParams;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.stackTrace;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.timeStamp;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        DumpedClassInfo r112 = this.dumpedClassInfo;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.localIndex;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.eventClassVersion;
        if (r118 == null) goto L26;
        r101 = r118.hashCode();
    L26:
        return r117 + r101;
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DumpedEvent(eventName=" + this.eventName + ", dumpedDumpedEventParams=" + this.dumpedDumpedEventParams + ", stackTrace=" + this.stackTrace + ", timeStamp=" + this.timeStamp + ", dumpedClassInfo=" + this.dumpedClassInfo + ", localIndex=" + this.localIndex + ", eventClassVersion=" + this.eventClassVersion + ")";
    }

    public final DumpedClassInfo getDumpedClassInfo() {
        return this.dumpedClassInfo;
    }

    public final Map<DumpedEventKey, DumpedEventParam> getDumpedDumpedEventParams() {
        return this.dumpedDumpedEventParams;
    }

    public final Integer getEventClassVersion() {
        return this.eventClassVersion;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Integer getLocalIndex() {
        return this.localIndex;
    }

    public final String getStackTrace() {
        return this.stackTrace;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final void setDumpedClassInfo(DumpedClassInfo r100) {
        this.dumpedClassInfo = r100;
    }

    public final void setDumpedDumpedEventParams(Map<DumpedEventKey, DumpedEventParam> r100) {
        this.dumpedDumpedEventParams = r100;
    }

    public final void setEventClassVersion(Integer r100) {
        this.eventClassVersion = r100;
    }

    public final void setEventName(String r100) {
        this.eventName = r100;
    }

    public final void setLocalIndex(Integer r100) {
        this.localIndex = r100;
    }

    public final void setStackTrace(String r100) {
        this.stackTrace = r100;
    }

    public final void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }

    public DumpedEvent(String r100, Map<DumpedEventKey, DumpedEventParam> r101, String r102, long r103, DumpedClassInfo r104, Integer r105, Integer r106) {
        this.eventName = r100;
        this.dumpedDumpedEventParams = r101;
        this.stackTrace = r102;
        this.timeStamp = r103;
        this.dumpedClassInfo = r104;
        this.localIndex = r105;
        this.eventClassVersion = r106;
    }

    public /* synthetic */ DumpedEvent(String r110, Map r111, String r112, long r113, DumpedClassInfo r114, Integer r115, Integer r116, int r117, DefaultConstructorMarker r118) {
        Integer r100 = null;
        if ((r117 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r117 & 2) == 0) goto L9;
        Map r102 = null;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r117 & 8) == 0) goto L17;
        long r104 = System.currentTimeMillis();
    L19:
        if ((r117 & 16) == 0) goto L21;
        DumpedClassInfo r105 = null;
    L23:
        if ((r117 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r117 & 64) != 0) goto L30;
        r100 = r116;
    L30:
        this(r101, r102, r103, r104, r105, r106, r100);
        return;
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}

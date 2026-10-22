package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.data.MetricTrackerData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0017R,\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MetricTrackerData;", "", "()V", "allRoomTracker", "", "", "getAllRoomTracker", "()Ljava/util/Map;", "setAllRoomTracker", "(Ljava/util/Map;)V", "currentRoomTracker", "getCurrentRoomTracker", "setCurrentRoomTracker", "eventName", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "finalUseTracker", "getFinalUseTracker", "setFinalUseTracker", "isCommonMetric", "", "()Z", "useOnceTracker", "getUseOnceTracker", "setUseOnceTracker", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MetricTrackerData implements h {

    @SerializedName("all_room_tracker")
    protected Map<String, String> allRoomTracker;

    @SerializedName("current_room_tracker")
    protected Map<String, String> currentRoomTracker;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    protected String eventName;
    private Map<String, String> finalUseTracker;

    @SerializedName("is_common_metric")
    protected boolean isCommonMetric;

    @SerializedName("use_once_tracker")
    protected Map<String, String> useOnceTracker;

    public MetricTrackerData() {
        this.eventName = "";
    }

    public final Map<String, String> getAllRoomTracker() {
        return this.allRoomTracker;
    }

    public final Map<String, String> getCurrentRoomTracker() {
        return this.currentRoomTracker;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, String> getFinalUseTracker() {
        return this.finalUseTracker;
    }

    public final Map<String, String> getUseOnceTracker() {
        return this.useOnceTracker;
    }

    public final boolean isCommonMetric() {
        return this.isCommonMetric;
    }

    public MetricTrackerData(g r110) {
        this.currentRoomTracker = new HashMap();
        this.useOnceTracker = new HashMap();
        this.allRoomTracker = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L66;
        if (r101 != 1) goto L8;
        this.eventName = am3.h.c(r110);
        goto L3
    L8:
        if (r101 != 2) goto L9;
        this.isCommonMetric = am3.h.a(r110);
        goto L3
    L9:
        String r102 = null;
        if (r101 == 3) goto L48;
        if (r101 == 4) goto L32;
        if (r101 != 5) goto L15;
        long r111 = r110.c();
        String r103 = null;
    L17:
        int r104 = r110.f();
        if (r104 == (-1)) goto L24;
        if (r104 != 1) goto L20;
        r102 = am3.h.c(r110);
        goto L17
    L20:
        if (r104 != 2) goto L21;
        r103 = am3.h.c(r110);
        goto L17
    L21:
        am3.h.e(r110);
        goto L17
    L24:
        r110.d(r111);
        Map<String, String> r105 = this.allRoomTracker;
        if (r102 == null) goto L31;
        if (r103 == null) goto L29;
    L59:
        r105.put(r102, r103);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L15:
        am3.h.e(r110);
        goto L3
    L32:
        long r112 = r110.c();
        r103 = null;
    L33:
        int r106 = r110.f();
        if (r106 == (-1)) goto L40;
        if (r106 != 1) goto L36;
        r102 = am3.h.c(r110);
        goto L33
    L36:
        if (r106 != 2) goto L37;
        r103 = am3.h.c(r110);
        goto L33
    L37:
        am3.h.e(r110);
        goto L33
    L40:
        r110.d(r112);
        r105 = this.useOnceTracker;
        if (r102 == null) goto L47;
        if (r103 != null) goto L59;
        throw new IllegalStateException("Value must not be null");
    L47:
        throw new IllegalStateException("Key must not be null");
    L48:
        long r113 = r110.c();
        r103 = null;
    L49:
        int r107 = r110.f();
        if (r107 == (-1)) goto L56;
        if (r107 != 1) goto L52;
        r102 = am3.h.c(r110);
        goto L49
    L52:
        if (r107 != 2) goto L53;
        r103 = am3.h.c(r110);
        goto L49
    L53:
        am3.h.e(r110);
        goto L49
    L56:
        r110.d(r113);
        r105 = this.currentRoomTracker;
        if (r102 == null) goto L63;
        if (r103 != null) goto L59;
        throw new IllegalStateException("Value must not be null");
    L63:
        throw new IllegalStateException("Key must not be null");
    L66:
        r110.d(r100);
        if (this.eventName != null) goto L117;
        this.eventName = "";
        return;
    }

    public final void setAllRoomTracker(Map<String, String> r100) {
        this.allRoomTracker = r100;
    }

    public final void setCurrentRoomTracker(Map<String, String> r100) {
        this.currentRoomTracker = r100;
    }

    public final void setEventName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventName = r100;
    }

    public final void setFinalUseTracker(Map<String, String> r100) {
        this.finalUseTracker = r100;
    }

    public final void setUseOnceTracker(Map<String, String> r100) {
        this.useOnceTracker = r100;
    }
}

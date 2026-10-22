package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u001a\u00102\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR\u001a\u00105\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LinkPreviewMonitorData;", "", "()V", "category", "Lorg/json/JSONObject;", "getCategory", "()Lorg/json/JSONObject;", "setCategory", "(Lorg/json/JSONObject;)V", "eventType", "", "getEventType", "()Ljava/lang/String;", "setEventType", "(Ljava/lang/String;)V", "eventTypeValue", "getEventTypeValue", "setEventTypeValue", "extra", "getExtra", "setExtra", "isLiveTypeAudio", "", "()Z", "setLiveTypeAudio", "(Z)V", "metrics", "getMetrics", "setMetrics", "needLinkCommonParams", "getNeedLinkCommonParams", "setNeedLinkCommonParams", "needRoomCommonParams", "getNeedRoomCommonParams", "setNeedRoomCommonParams", "needTalkRoomCommonParams", "getNeedTalkRoomCommonParams", "setNeedTalkRoomCommonParams", "scene", "", "getScene", "()I", "setScene", "(I)V", "serviceName", "getServiceName", "setServiceName", "statusCode", "getStatusCode", "setStatusCode", a.KEY_STATUS_MSG, "getStatusMsg", "setStatusMsg", "syncToTrace", "getSyncToTrace", "setSyncToTrace", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPreviewMonitorData {
    private JSONObject category;
    private String eventType;
    private String eventTypeValue;
    private JSONObject extra;
    private boolean isLiveTypeAudio;
    private JSONObject metrics;
    private boolean needLinkCommonParams;
    private boolean needRoomCommonParams;
    private boolean needTalkRoomCommonParams;
    private int scene;
    private String serviceName;
    private int statusCode;
    private String statusMsg;
    private boolean syncToTrace;

    public LinkPreviewMonitorData() {
        this.serviceName = "";
        this.eventType = "";
        this.eventTypeValue = "";
        this.statusMsg = "";
        this.extra = new JSONObject();
        this.metrics = new JSONObject();
        this.category = new JSONObject();
    }

    public final JSONObject getCategory() {
        return this.category;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final String getEventTypeValue() {
        return this.eventTypeValue;
    }

    public final JSONObject getExtra() {
        return this.extra;
    }

    public final JSONObject getMetrics() {
        return this.metrics;
    }

    public final boolean getNeedLinkCommonParams() {
        return this.needLinkCommonParams;
    }

    public final boolean getNeedRoomCommonParams() {
        return this.needRoomCommonParams;
    }

    public final boolean getNeedTalkRoomCommonParams() {
        return this.needTalkRoomCommonParams;
    }

    public final int getScene() {
        return this.scene;
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final boolean getSyncToTrace() {
        return this.syncToTrace;
    }

    public final boolean isLiveTypeAudio() {
        return this.isLiveTypeAudio;
    }

    public final void setCategory(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.category = r100;
    }

    public final void setEventType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventType = r100;
    }

    public final void setEventTypeValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventTypeValue = r100;
    }

    public final void setExtra(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void setLiveTypeAudio(boolean r100) {
        this.isLiveTypeAudio = r100;
    }

    public final void setMetrics(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.metrics = r100;
    }

    public final void setNeedLinkCommonParams(boolean r100) {
        this.needLinkCommonParams = r100;
    }

    public final void setNeedRoomCommonParams(boolean r100) {
        this.needRoomCommonParams = r100;
    }

    public final void setNeedTalkRoomCommonParams(boolean r100) {
        this.needTalkRoomCommonParams = r100;
    }

    public final void setScene(int r100) {
        this.scene = r100;
    }

    public final void setServiceName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.serviceName = r100;
    }

    public final void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public final void setStatusMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.statusMsg = r100;
    }

    public final void setSyncToTrace(boolean r100) {
        this.syncToTrace = r100;
    }
}

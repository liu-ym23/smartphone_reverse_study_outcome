package com.bytedance.android.livesdkapi.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerTraceLogData;", "", "eventType", "", "businessType", "roomId", "indexes", "", "extras", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;)V", "getBusinessType", "()Ljava/lang/String;", "getEventType", "getExtras", "()Lorg/json/JSONObject;", "getIndexes", "()Ljava/util/Map;", "getRoomId", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerTraceLogData {
    private final String businessType;
    private final String eventType;
    private final JSONObject extras;
    private final Map<String, Object> indexes;
    private final String roomId;

    public final String getBusinessType() {
        return this.businessType;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final JSONObject getExtras() {
        return this.extras;
    }

    public final Map<String, Object> getIndexes() {
        return this.indexes;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public PlayerTraceLogData(String r100, String r101, String r102, Map<String, Object> r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "businessType");
        Intrinsics.checkNotNullParameter(r102, "roomId");
        this.eventType = r100;
        this.businessType = r101;
        this.roomId = r102;
        this.indexes = r103;
        this.extras = r104;
    }
}

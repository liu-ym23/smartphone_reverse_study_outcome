package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/SeiToJsonObject;", "", "message", "", "seiJsonObject", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getMessage", "()Ljava/lang/String;", "getSeiJsonObject", "()Lorg/json/JSONObject;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SeiToJsonObject {
    private final String message;
    private final JSONObject seiJsonObject;

    public final String getMessage() {
        return this.message;
    }

    public final JSONObject getSeiJsonObject() {
        return this.seiJsonObject;
    }

    public SeiToJsonObject(String r100, JSONObject r101) {
        this.message = r100;
        this.seiJsonObject = r101;
    }
}

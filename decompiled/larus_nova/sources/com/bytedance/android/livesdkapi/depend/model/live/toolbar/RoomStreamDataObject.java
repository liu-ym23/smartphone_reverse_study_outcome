package com.bytedance.android.livesdkapi.depend.model.live.toolbar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/RoomStreamDataObject;", "", "streamDataObject", "Lorg/json/JSONObject;", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/JSONObject;", "sdkParasObject", "(Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getSdkParasObject", "()Lorg/json/JSONObject;", "getStreamDataObject", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomStreamDataObject {
    private final JSONObject sdkParasObject;
    private final JSONObject streamDataObject;

    public final JSONObject getSdkParasObject() {
        return this.sdkParasObject;
    }

    public final JSONObject getStreamDataObject() {
        return this.streamDataObject;
    }

    public RoomStreamDataObject(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "streamDataObject");
        Intrinsics.checkNotNullParameter(r101, "sdkParasObject");
        this.streamDataObject = r100;
        this.sdkParasObject = r101;
    }
}

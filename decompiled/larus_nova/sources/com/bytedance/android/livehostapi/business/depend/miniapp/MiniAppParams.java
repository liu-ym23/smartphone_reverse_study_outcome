package com.bytedance.android.livehostapi.business.depend.miniapp;

import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001Be\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bR\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/miniapp/MiniAppParams;", "", "jsonParams", "", "", "Lorg/json/JSONObject;", "stringParams", "logFieldMap", "scene", "launchFrom", "location", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJsonParams", "()Ljava/util/Map;", "getLaunchFrom", "()Ljava/lang/String;", "getLocation", "getLogFieldMap", "getScene", "getStringParams", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppParams {
    private final Map<String, JSONObject> jsonParams;
    private final String launchFrom;
    private final String location;
    private final Map<String, String> logFieldMap;
    private final String scene;
    private final Map<String, String> stringParams;

    public final Map<String, JSONObject> getJsonParams() {
        return this.jsonParams;
    }

    public final String getLaunchFrom() {
        return this.launchFrom;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Map<String, String> getLogFieldMap() {
        return this.logFieldMap;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Map<String, String> getStringParams() {
        return this.stringParams;
    }

    public MiniAppParams(Map<String, JSONObject> r100, Map<String, String> r101, Map<String, String> r102, String r103, String r104, String r105) {
        this.jsonParams = r100;
        this.stringParams = r101;
        this.logFieldMap = r102;
        this.scene = r103;
        this.launchFrom = r104;
        this.location = r105;
    }
}

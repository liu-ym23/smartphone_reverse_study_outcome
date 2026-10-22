package com.obric.appstore.network.entity;

import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/appstore/network/entity/AppDetailResp;", "", "appInfo", "Lcom/google/gson/JsonElement;", "relationApps", "classicsApps", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)V", "getAppInfo", "()Lcom/google/gson/JsonElement;", "getClassicsApps", "getRelationApps", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppDetailResp {

    @SerializedName(ServerElements.APP_INFO)
    @Nullable
    private final JsonElement appInfo;

    @SerializedName(ServerElements.APP_DETAIL_CLASSICS)
    @Nullable
    private final JsonElement classicsApps;

    @SerializedName(ServerElements.APP_DETAIL_RELATION)
    @Nullable
    private final JsonElement relationApps;

    public AppDetailResp(@Nullable JsonElement r10, @Nullable JsonElement r11, @Nullable JsonElement r12) {
        this.appInfo = r10;
        this.relationApps = r11;
        this.classicsApps = r12;
    }

    @Nullable
    public final JsonElement getAppInfo() {
        return this.appInfo;
    }

    @Nullable
    public final JsonElement getClassicsApps() {
        return this.classicsApps;
    }

    @Nullable
    public final JsonElement getRelationApps() {
        return this.relationApps;
    }

    public /* synthetic */ AppDetailResp(JsonElement r10, JsonElement r11, JsonElement r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }
}

package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomStampInfo;", "", "()V", "entrances", "", "getEntrances", "()Ljava/lang/String;", "setEntrances", "(Ljava/lang/String;)V", "id", "getId", "setId", "name", "getName", "setName", "schema", "getSchema", "setSchema", "status", "", "getStatus", "()I", "setStatus", "(I)V", "type", "getType", "setType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomStampInfo {

    @SerializedName("entrances")
    private String entrances;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f162603id;

    @SerializedName("name")
    private String name;

    @SerializedName("schema")
    private String schema;

    @SerializedName("status")
    private int status;

    @SerializedName("type")
    private int type;

    public RoomStampInfo() {
        this.f162603id = "";
        this.name = "";
        this.schema = "";
    }

    public final String getEntrances() {
        return this.entrances;
    }

    public final String getId() {
        return this.f162603id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }

    public final void setEntrances(String r100) {
        this.entrances = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f162603id = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schema = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}

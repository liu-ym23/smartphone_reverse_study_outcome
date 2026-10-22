package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/OpenMicroGameSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "appId", "", "location", "launchFrom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getLaunchFrom", "getLocation", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenMicroGameSchemaModel extends BaseSchemaModel {

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("launch_from")
    private final String launchFrom;

    @SerializedName("location")
    private final String location;

    public OpenMicroGameSchemaModel() {
        this(null, null, null, 7, null);
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.LIVE_MG;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getLaunchFrom() {
        return this.launchFrom;
    }

    public final String getLocation() {
        return this.location;
    }

    public OpenMicroGameSchemaModel(String r100, String r101, String r102) {
        this.appId = r100;
        this.location = r101;
        this.launchFrom = r102;
    }

    public /* synthetic */ OpenMicroGameSchemaModel(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/FastStartKtvVideoModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "enterFrom", "", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "enterFromMerge", "getEnterFromMerge", "enterMethod", "getEnterMethod", "ktvType", "", "getKtvType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "liveScene", "getLiveScene", "liveType", "getLiveType", "scene", "getScene", "uiLayout", "getUiLayout", "getSchemaHost", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastStartKtvVideoModel extends BaseSchemaModel {

    @SerializedName("enter_from")
    private String enterFrom;

    @SerializedName("enter_from_merge")
    private final String enterFromMerge;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("ktv_type")
    private final Integer ktvType;

    @SerializedName("live_scene")
    private final String liveScene;

    @SerializedName("live_type")
    private final String liveType;

    @SerializedName("scene")
    private final Integer scene;

    @SerializedName("uilayout")
    private final Integer uiLayout;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.START_KTV_LIVE;
    }

    public FastStartKtvVideoModel() {
        this.scene = -1;
        this.ktvType = 10;
        this.uiLayout = 0;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Integer getKtvType() {
        return this.ktvType;
    }

    public final String getLiveScene() {
        return this.liveScene;
    }

    public final String getLiveType() {
        return this.liveType;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final Integer getUiLayout() {
        return this.uiLayout;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }
}

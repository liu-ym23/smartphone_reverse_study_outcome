package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/CjH5ModalSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "url", "", "tag", "webBgColor", "webScreenType", "webEnableAnimation", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getTag", "()Ljava/lang/String;", "getUrl", "getWebBgColor", "getWebEnableAnimation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWebScreenType", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CjH5ModalSchemaModel extends BaseSchemaModel {

    @SerializedName("tag")
    private final String tag;

    @SerializedName("url")
    private final String url;

    @SerializedName("web_bg_color")
    private final String webBgColor;

    @SerializedName("web_enable_animation")
    private final Boolean webEnableAnimation;

    @SerializedName("web_screen_type")
    private final String webScreenType;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.CJ_H5_MODAL_VIEW_SCHEMA_HOST;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getWebBgColor() {
        return this.webBgColor;
    }

    public final Boolean getWebEnableAnimation() {
        return this.webEnableAnimation;
    }

    public final String getWebScreenType() {
        return this.webScreenType;
    }

    public CjH5ModalSchemaModel(String r100, String r101, String r102, String r103, Boolean r104) {
        this.url = r100;
        this.tag = r101;
        this.webBgColor = r102;
        this.webScreenType = r103;
        this.webEnableAnimation = r104;
    }
}

package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR \u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R \u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/OpenLiveTakePageSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "banShowClearDialog", "", "getBanShowClearDialog", "()Ljava/lang/Boolean;", "setBanShowClearDialog", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableInitCameraEarly", "getEnableInitCameraEarly", "setEnableInitCameraEarly", "previousPage", "", "getPreviousPage", "()Ljava/lang/String;", "setPreviousPage", "(Ljava/lang/String;)V", "recordTabOnly", "getRecordTabOnly", "setRecordTabOnly", "refer", "getRefer", "setRefer", "shellSourceParams", "getShellSourceParams", "setShellSourceParams", "shootWay", "getShootWay", "setShootWay", "sourceParams", "getSourceParams", "setSourceParams", "getSchemaHost", "toString", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenLiveTakePageSchemaModel extends BaseSchemaModel {

    @SerializedName("ban_show_clear_dialog")
    private Boolean banShowClearDialog;

    @SerializedName("enable_init_camera_early")
    private Boolean enableInitCameraEarly;

    @SerializedName("previous_page")
    private String previousPage;

    @SerializedName("record_tab_only")
    private Boolean recordTabOnly;

    @SerializedName("refer")
    private String refer;

    @SerializedName("shell_source_params")
    private String shellSourceParams;

    @SerializedName(a.KEY_SHOOT_WAY)
    private String shootWay;

    @SerializedName("source_params")
    private String sourceParams;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.WEBCAST_OPEN_LIVE;
    }

    public String toString() {
        return "sourceParams: " + this.sourceParams + ", recordTabOnly: " + this.recordTabOnly + ", refer: " + this.refer + ", previousPage: " + this.previousPage + ", shootWay: " + this.shootWay + ", banShowClearDialog: " + this.banShowClearDialog + ", enableInitCameraEarly: " + this.enableInitCameraEarly;
    }

    public OpenLiveTakePageSchemaModel() {
        this.recordTabOnly = Boolean.FALSE;
        this.refer = "";
        this.previousPage = "";
        this.shootWay = "";
        this.enableInitCameraEarly = Boolean.TRUE;
        this.shellSourceParams = "";
    }

    public final Boolean getBanShowClearDialog() {
        return this.banShowClearDialog;
    }

    public final Boolean getEnableInitCameraEarly() {
        return this.enableInitCameraEarly;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final Boolean getRecordTabOnly() {
        return this.recordTabOnly;
    }

    public final String getRefer() {
        return this.refer;
    }

    public final String getShellSourceParams() {
        return this.shellSourceParams;
    }

    public final String getShootWay() {
        return this.shootWay;
    }

    public final String getSourceParams() {
        return this.sourceParams;
    }

    public final void setBanShowClearDialog(Boolean r100) {
        this.banShowClearDialog = r100;
    }

    public final void setEnableInitCameraEarly(Boolean r100) {
        this.enableInitCameraEarly = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setRecordTabOnly(Boolean r100) {
        this.recordTabOnly = r100;
    }

    public final void setRefer(String r100) {
        this.refer = r100;
    }

    public final void setShellSourceParams(String r100) {
        this.shellSourceParams = r100;
    }

    public final void setShootWay(String r100) {
        this.shootWay = r100;
    }

    public final void setSourceParams(String r100) {
        this.sourceParams = r100;
    }
}

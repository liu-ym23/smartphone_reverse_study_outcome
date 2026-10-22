package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001BU\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fB\u0005¢\u0006\u0002\u0010\rJ\b\u0010%\u001a\u00020\u0003H\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/LiveCertModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", BytedCertConstant.CertKey.FLOW, "", "scene", "ticket", "cert_app_id", BytedCertConstant.CertKey.IDENTITY_NAME, BytedCertConstant.CertKey.IDENTITY_CODE, "face_only", "", "extra_params", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "()V", "getCert_app_id", "()Ljava/lang/String;", "setCert_app_id", "(Ljava/lang/String;)V", "getExtra_params", "setExtra_params", "getFace_only", "()I", "setFace_only", "(I)V", "getFlow", "setFlow", "getIdentity_code", "setIdentity_code", "getIdentity_name", "setIdentity_name", "getScene", "setScene", "getTicket", "setTicket", "uniqueId", "getUniqueId", "setUniqueId", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCertModel extends BaseSchemaModel {

    @SerializedName("cert_app_id")
    private String cert_app_id;

    @SerializedName("extra_params")
    private String extra_params;

    @SerializedName("face_only")
    private int face_only;

    @SerializedName(BytedCertConstant.CertKey.FLOW)
    private String flow;

    @SerializedName(BytedCertConstant.CertKey.IDENTITY_CODE)
    private String identity_code;

    @SerializedName(BytedCertConstant.CertKey.IDENTITY_NAME)
    private String identity_name;

    @SerializedName("scene")
    private String scene;

    @SerializedName("ticket")
    private String ticket;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    private String uniqueId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.START_LIVE_CERT_HOST;
    }

    public LiveCertModel() {
        this.uniqueId = "";
    }

    public final String getCert_app_id() {
        return this.cert_app_id;
    }

    public final String getExtra_params() {
        return this.extra_params;
    }

    public final int getFace_only() {
        return this.face_only;
    }

    public final String getFlow() {
        return this.flow;
    }

    public final String getIdentity_code() {
        return this.identity_code;
    }

    public final String getIdentity_name() {
        return this.identity_name;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setCert_app_id(String r100) {
        this.cert_app_id = r100;
    }

    public final void setExtra_params(String r100) {
        this.extra_params = r100;
    }

    public final void setFace_only(int r100) {
        this.face_only = r100;
    }

    public final void setFlow(String r100) {
        this.flow = r100;
    }

    public final void setIdentity_code(String r100) {
        this.identity_code = r100;
    }

    public final void setIdentity_name(String r100) {
        this.identity_name = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setTicket(String r100) {
        this.ticket = r100;
    }

    public final void setUniqueId(String r100) {
        this.uniqueId = r100;
    }

    public LiveCertModel(String r100, String r101, String r102, String r103, String r104, String r105, int r106, String r107) {
        this();
        this.flow = r100;
        this.scene = r101;
        this.ticket = r102;
        this.cert_app_id = r103;
        this.identity_name = r104;
        this.identity_code = r105;
        this.face_only = r106;
        this.extra_params = r107;
    }
}

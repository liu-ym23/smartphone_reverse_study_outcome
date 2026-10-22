package cg;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcg/a;", "", "", "originType", "Ljava/lang/String;", "getOriginType", "()Ljava/lang/String;", "setOriginType", "(Ljava/lang/String;)V", "originId", "getOriginId", "setOriginId", "comboId", "getComboId", "setComboId", "comboNum", "getComboNum", "setComboNum", "specDesc", "getSpecDesc", "setSpecDesc", "deviceId", "getDeviceId", "setDeviceId", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID)
    private String comboId;

    @SerializedName("combo_num")
    private String comboNum;

    @SerializedName("device_id")
    private String deviceId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID)
    private String originId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE)
    private String originType;

    @SerializedName("spec_desc")
    private String specDesc;

    public a() {
        this.originType = null;
        this.originId = null;
        this.comboId = null;
        this.comboNum = null;
        this.specDesc = null;
        this.deviceId = null;
    }
}

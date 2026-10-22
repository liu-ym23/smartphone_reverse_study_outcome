package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/dk;", "", "", "sceneCode", "I", "getSceneCode", "()I", "setSceneCode", "(I)V", "", "addressLogoUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAddressLogoUrl", "(Ljava/lang/String;)V", "addressText", "b", "setAddressText", "addressTextColor", "c", "setAddressTextColor", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class dk {

    @SerializedName("AddressLogoUrl")
    private String addressLogoUrl;

    @SerializedName("AddressText")
    private String addressText;

    @SerializedName("AddressTextColor")
    private String addressTextColor;

    @SerializedName("SceneCode")
    private int sceneCode;

    public static final class a {
    }

    static {
    }

    public dk() {
    }

    public final String toString() {
        return "RoomIntroPoiStoreData(sceneCode=" + this.sceneCode + ", addressLogoUrl=" + this.addressLogoUrl + ", addressText=" + this.addressText + ", addressTextColor=" + this.addressTextColor + ')';
    }

    public final String a() {
        return this.addressLogoUrl;
    }

    public final String b() {
        return this.addressText;
    }

    public final String c() {
        return this.addressTextColor;
    }
}

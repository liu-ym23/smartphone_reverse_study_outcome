package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/model/n;", "", "", "faceIdentify", "Ljava/lang/String;", "getFaceIdentify", "()Ljava/lang/String;", "setFaceIdentify", "(Ljava/lang/String;)V", "inputInfo", "b", "setInputInfo", "", "artificialEntrance", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setArtificialEntrance", "(Z)V", "", "liveCertificationUseOcr", "I", "c", "()I", "setLiveCertificationUseOcr", "(I)V", "useCertReflection", "d", "setUseCertReflection", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("live_certification_setting_show_artificial_entrance")
    private boolean artificialEntrance;

    @SerializedName("live_certification_setting_face_identify")
    private String faceIdentify;

    @SerializedName("live_certification_setting_info_input")
    private String inputInfo;

    @SerializedName("live_certification_setting_manual_use_ocr")
    private int liveCertificationUseOcr;

    @SerializedName("live_certification_setting_use_reflection")
    private boolean useCertReflection;

    public static final class a {
    }

    static {
    }

    public n() {
        this.faceIdentify = "zhima_app";
        this.inputInfo = "default";
    }

    public final boolean a() {
        return this.artificialEntrance;
    }

    public final String b() {
        return this.inputInfo;
    }

    public final int c() {
        return this.liveCertificationUseOcr;
    }

    public final boolean d() {
        return this.useCertReflection;
    }
}

package com.bytedance.android.ec.hybrid.api.card.mita;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/hybrid/api/card/mita/ECMallMitaCardConvertConfig;", "Lcom/bytedance/android/ec/hybrid/api/card/mita/ECHybridMitaCardConfig;", "()V", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "componentSubType", "", "getComponentSubType", "()Ljava/lang/String;", "setComponentSubType", "(Ljava/lang/String;)V", "supportFeVersion", "getSupportFeVersion", "setSupportFeVersion", "isSupport", "", "feVersion", "ec-hybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallMitaCardConvertConfig extends ECHybridMitaCardConfig {

    @SerializedName(a.KEY_CARD_TYPE)
    private Integer cardType;

    @SerializedName("component_sub_type")
    private String componentSubType;

    @SerializedName("support_fe_version")
    private String supportFeVersion;

    public ECMallMitaCardConvertConfig() {
    }

    public final Integer getCardType() {
        return this.cardType;
    }

    public final String getComponentSubType() {
        return this.componentSubType;
    }

    public final String getSupportFeVersion() {
        return this.supportFeVersion;
    }

    public final boolean isSupport(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        String r103 = getTemplateUrl();
        if (r103 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        return false;
    L20:
        String r105 = this.supportFeVersion;
        if (r105 != null) goto L23;
    L26:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L42;
        return true;
    L42:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L35
        String r108 = this.supportFeVersion;     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L35
        int r109 = CastIntegerProtector.parseInt(r108);     // Catch: Throwable -> L35
        if (CastIntegerProtector.parseInt(r100) >= r109) goto L33;
        r101 = false;
    L33:
        Object r110 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r110) == false) goto L41;
        r110 = null;
    L41:
        return Intrinsics.areEqual((Boolean) r110, Boolean.TRUE);
    L35:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L23:
        if (r105.length() == 0) goto L26;
        r106 = false;
        goto L27
    L14:
        if (r103.length() == 0) goto L17;
        r104 = false;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void setCardType(Integer r100) {
        this.cardType = r100;
    }

    public final void setComponentSubType(String r100) {
        this.componentSubType = r100;
    }

    public final void setSupportFeVersion(String r100) {
        this.supportFeVersion = r100;
    }
}

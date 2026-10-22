package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayLynxDialogExtraData;", "", "id", "", "assetMetaInfo", "Lorg/json/JSONObject;", "commonParams", "", "isBioDegrade", "isFingerprintLocalEnable", "", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/Map;Ljava/lang/String;Z)V", "getAssetMetaInfo", "()Lorg/json/JSONObject;", "getCommonParams", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLynxDialogExtraData {
    private final JSONObject assetMetaInfo;
    private final Map<String, String> commonParams;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f29846id;
    private final String isBioDegrade;
    private final boolean isFingerprintLocalEnable;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPayLynxDialogExtraData copy$default(CJPayLynxDialogExtraData r100, String r101, JSONObject r102, Map r103, String r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f29846id;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.assetMetaInfo;
    L8:
        JSONObject r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.commonParams;
    L11:
        Map r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isBioDegrade;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isFingerprintLocalEnable;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.f29846id;
    }

    public final JSONObject component2() {
        return this.assetMetaInfo;
    }

    public final Map<String, String> component3() {
        return this.commonParams;
    }

    public final String component4() {
        return this.isBioDegrade;
    }

    public final boolean component5() {
        return this.isFingerprintLocalEnable;
    }

    public final CJPayLynxDialogExtraData copy(String r100, JSONObject r101, Map<String, String> r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "commonParams");
        Intrinsics.checkNotNullParameter(r111, "isBioDegrade");
        return new CJPayLynxDialogExtraData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayLynxDialogExtraData) == true) goto L8;
        return false;
    L8:
        CJPayLynxDialogExtraData r101 = (CJPayLynxDialogExtraData) r100;
        if (Intrinsics.areEqual(this.f29846id, r101.f29846id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.assetMetaInfo, r101.assetMetaInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.commonParams, r101.commonParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isBioDegrade, r101.isBioDegrade) == true) goto L21;
        return false;
    L21:
        if (this.isFingerprintLocalEnable == r101.isFingerprintLocalEnable) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.f29846id.hashCode() * 31;
        JSONObject r101 = this.assetMetaInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.commonParams.hashCode()) * 31) + this.isBioDegrade.hashCode()) * 31;
        if (this.isFingerprintLocalEnable == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CJPayLynxDialogExtraData(id='" + this.f29846id + "', assetMetaInfo=" + this.assetMetaInfo + ", feMetrics=" + this.commonParams + ", isBioDegrade=" + this.isBioDegrade + ", isFingerprintLocalEnable=" + this.isFingerprintLocalEnable + ')';
    }

    public final JSONObject getAssetMetaInfo() {
        return this.assetMetaInfo;
    }

    public final Map<String, String> getCommonParams() {
        return this.commonParams;
    }

    public final String getId() {
        return this.f29846id;
    }

    public final String isBioDegrade() {
        return this.isBioDegrade;
    }

    public final boolean isFingerprintLocalEnable() {
        return this.isFingerprintLocalEnable;
    }

    public CJPayLynxDialogExtraData(String r100, JSONObject r101, Map<String, String> r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r102, "commonParams");
        Intrinsics.checkNotNullParameter(r103, "isBioDegrade");
        this.f29846id = r100;
        this.assetMetaInfo = r101;
        this.commonParams = r102;
        this.isBioDegrade = r103;
        this.isFingerprintLocalEnable = r104;
    }

    public /* synthetic */ CJPayLynxDialogExtraData(String r100, JSONObject r101, Map r102, String r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = "platform";
    L5:
        String r103 = r100;
        if ((r112 & 8) == 0) goto L8;
        r110 = "0";
    L8:
        String r104 = r110;
        if ((r112 & 16) == 0) goto L11;
        boolean r105 = false;
    L12:
        this(r103, r101, r102, r104, r105);
        return;
    L11:
        r105 = r111;
        goto L12
    }
}

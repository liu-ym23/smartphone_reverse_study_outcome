package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "Ljava/io/Serializable;", "lynxId", "", "lynxUrl", "lynxData", "Lcom/google/gson/JsonObject;", "config", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;)V", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "setConfig", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;)V", "getLynxData", "()Lcom/google/gson/JsonObject;", "getLynxId", "()Ljava/lang/String;", "getLynxUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderPendantLynx implements Serializable {
    private ConfigMode config;

    @SerializedName("data")
    private final JsonObject lynxData;

    @SerializedName("id")
    private final String lynxId;

    @SerializedName("url")
    private final String lynxUrl;

    public HeaderPendantLynx() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ HeaderPendantLynx copy$default(HeaderPendantLynx r100, String r101, String r102, JsonObject r103, ConfigMode r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.lynxId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.lynxUrl;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.lynxData;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.config;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.lynxId;
    }

    public final String component2() {
        return this.lynxUrl;
    }

    public final JsonObject component3() {
        return this.lynxData;
    }

    public final ConfigMode component4() {
        return this.config;
    }

    public final HeaderPendantLynx copy(String r100, String r101, JsonObject r102, ConfigMode r103) {
        return new HeaderPendantLynx(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderPendantLynx) == false) goto L14;
        HeaderPendantLynx r101 = (HeaderPendantLynx) r100;
        if (Intrinsics.areEqual(this.lynxId, r101.lynxId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.lynxId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.lynxUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JsonObject r107 = this.lynxData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ConfigMode r110 = this.config;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderPendantLynx(lynxId=" + this.lynxId + ", lynxUrl=" + this.lynxUrl + ", lynxData=" + this.lynxData + ", config=" + this.config + ")";
    }

    public final ConfigMode getConfig() {
        return this.config;
    }

    public final JsonObject getLynxData() {
        return this.lynxData;
    }

    public final String getLynxId() {
        return this.lynxId;
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public final void setConfig(ConfigMode r100) {
        this.config = r100;
    }

    public HeaderPendantLynx(String r100, String r101, JsonObject r102, ConfigMode r103) {
        this.lynxId = r100;
        this.lynxUrl = r101;
        this.lynxData = r102;
        this.config = r103;
    }

    public /* synthetic */ HeaderPendantLynx(String r100, String r101, JsonObject r102, ConfigMode r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}

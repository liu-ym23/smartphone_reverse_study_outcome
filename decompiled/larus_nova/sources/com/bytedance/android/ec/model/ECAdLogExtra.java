package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0000J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/ECAdLogExtra;", "Ljava/io/Serializable;", "creativeId", "", "logExtra", "adExtraData", "groupId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdExtraData", "()Ljava/lang/String;", "setAdExtraData", "(Ljava/lang/String;)V", "getCreativeId", "setCreativeId", "getGroupId", "setGroupId", "getLogExtra", "setLogExtra", "component1", "component2", "component3", "component4", "copy", "deepCopy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAdLogExtra implements Serializable {

    @SerializedName("ad_extra_data")
    private String adExtraData;

    @SerializedName("creative_id")
    private String creativeId;

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("log_extra")
    private String logExtra;

    public ECAdLogExtra() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ECAdLogExtra copy$default(ECAdLogExtra r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.creativeId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.logExtra;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.adExtraData;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.groupId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.creativeId;
    }

    public final String component2() {
        return this.logExtra;
    }

    public final String component3() {
        return this.adExtraData;
    }

    public final String component4() {
        return this.groupId;
    }

    public final ECAdLogExtra copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "creativeId");
        Intrinsics.checkNotNullParameter(r101, "logExtra");
        Intrinsics.checkNotNullParameter(r102, "adExtraData");
        Intrinsics.checkNotNullParameter(r103, "groupId");
        return new ECAdLogExtra(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAdLogExtra) == false) goto L14;
        ECAdLogExtra r101 = (ECAdLogExtra) r100;
        if (Intrinsics.areEqual(this.creativeId, r101.creativeId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.adExtraData, r101.adExtraData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.creativeId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.logExtra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.adExtraData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.groupId;
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
        return "ECAdLogExtra(creativeId=" + this.creativeId + ", logExtra=" + this.logExtra + ", adExtraData=" + this.adExtraData + ", groupId=" + this.groupId + ")";
    }

    public final ECAdLogExtra deepCopy() {
        return copy(this.creativeId, this.logExtra, this.adExtraData, this.groupId);
    }

    public final String getAdExtraData() {
        return this.adExtraData;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final void setAdExtraData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adExtraData = r100;
    }

    public final void setCreativeId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.creativeId = r100;
    }

    public final void setGroupId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupId = r100;
    }

    public final void setLogExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logExtra = r100;
    }

    public ECAdLogExtra(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "creativeId");
        Intrinsics.checkNotNullParameter(r101, "logExtra");
        Intrinsics.checkNotNullParameter(r102, "adExtraData");
        Intrinsics.checkNotNullParameter(r103, "groupId");
        this.creativeId = r100;
        this.logExtra = r101;
        this.adExtraData = r102;
        this.groupId = r103;
    }

    public /* synthetic */ ECAdLogExtra(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}

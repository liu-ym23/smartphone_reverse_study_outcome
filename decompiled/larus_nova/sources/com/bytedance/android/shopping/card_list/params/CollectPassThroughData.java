package com.bytedance.android.shopping.card_list.params;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;", "Ljava/io/Serializable;", "secUid", "", "uid", "guestUid", "previousPage", "isFromPersonal", "", "collectExperimentValue", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getCollectExperimentValue", "()I", "setCollectExperimentValue", "(I)V", "getGuestUid", "()Ljava/lang/String;", "()Z", "setFromPersonal", "(Z)V", "getPreviousPage", "setPreviousPage", "(Ljava/lang/String;)V", "getSecUid", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectPassThroughData implements Serializable {

    @SerializedName("collect_experiment_value")
    private int collectExperimentValue;

    @SerializedName("guest_uid")
    private final String guestUid;

    @SerializedName("is_from_personal")
    private boolean isFromPersonal;

    @SerializedName("previous_page")
    private String previousPage;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("uid")
    private final String uid;

    public CollectPassThroughData() {
        this(null, null, null, null, false, 0, 63, null);
    }

    public static /* synthetic */ CollectPassThroughData copy$default(CollectPassThroughData r100, String r101, String r102, String r103, String r104, boolean r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.secUid;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.uid;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.guestUid;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.previousPage;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.isFromPersonal;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.collectExperimentValue;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.secUid;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.guestUid;
    }

    public final String component4() {
        return this.previousPage;
    }

    public final boolean component5() {
        return this.isFromPersonal;
    }

    public final int component6() {
        return this.collectExperimentValue;
    }

    public final CollectPassThroughData copy(String r100, String r110, String r111, String r112, boolean r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "secUid");
        Intrinsics.checkNotNullParameter(r110, "uid");
        Intrinsics.checkNotNullParameter(r111, "guestUid");
        return new CollectPassThroughData(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CollectPassThroughData) == false) goto L18;
        CollectPassThroughData r101 = (CollectPassThroughData) r100;
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.guestUid, r101.guestUid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L14;
        return false;
    L14:
        if (this.isFromPersonal == r101.isFromPersonal) goto L16;
        return false;
    L16:
        if (this.collectExperimentValue == r101.collectExperimentValue) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        String r100 = this.secUid;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.uid;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.guestUid;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.previousPage;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.isFromPersonal;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return ((r111 + r113) * 31) + this.collectExperimentValue;
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
        return "CollectPassThroughData(secUid=" + this.secUid + ", uid=" + this.uid + ", guestUid=" + this.guestUid + ", previousPage=" + this.previousPage + ", isFromPersonal=" + this.isFromPersonal + ", collectExperimentValue=" + this.collectExperimentValue + ")";
    }

    public final int getCollectExperimentValue() {
        return this.collectExperimentValue;
    }

    public final String getGuestUid() {
        return this.guestUid;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getUid() {
        return this.uid;
    }

    public final boolean isFromPersonal() {
        return this.isFromPersonal;
    }

    public final void setCollectExperimentValue(int r100) {
        this.collectExperimentValue = r100;
    }

    public final void setFromPersonal(boolean r100) {
        this.isFromPersonal = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public CollectPassThroughData(String r100, String r101, String r102, String r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "secUid");
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "guestUid");
        this.secUid = r100;
        this.uid = r101;
        this.guestUid = r102;
        this.previousPage = r103;
        this.isFromPersonal = r104;
        this.collectExperimentValue = r105;
    }

    public /* synthetic */ CollectPassThroughData(String r100, String r101, String r102, String r103, boolean r104, int r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r111 & 4) != 0) goto L15;
        r105 = r102;
    L15:
        if ((r111 & 8) == 0) goto L17;
        r103 = null;
    L17:
        String r107 = r103;
        if ((r111 & 16) == 0) goto L20;
        boolean r108 = false;
    L22:
        if ((r111 & 32) == 0) goto L24;
        int r114 = 0;
    L25:
        this(r113, r106, r105, r107, r108, r114);
        return;
    L24:
        r114 = r110;
        goto L25
    L20:
        r108 = r104;
        goto L22
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}

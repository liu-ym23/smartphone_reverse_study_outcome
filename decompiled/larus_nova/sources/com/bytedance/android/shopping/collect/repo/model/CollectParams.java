package com.bytedance.android.shopping.collect.repo.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003Je\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\rHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "Ljava/io/Serializable;", "secUid", "", "uid", "guestUid", "ecomSceneId", "monitorId", "previousPage", "isFromPersonal", "", "session_id", "collectExperimentValue", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "getCollectExperimentValue", "()I", "setCollectExperimentValue", "(I)V", "getEcomSceneId", "()Ljava/lang/String;", "getGuestUid", "()Z", "setFromPersonal", "(Z)V", "getMonitorId", "setMonitorId", "(Ljava/lang/String;)V", "getPreviousPage", "setPreviousPage", "getSecUid", "getSession_id", "setSession_id", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectParams implements Serializable {

    @SerializedName("collect_experiment_value")
    private int collectExperimentValue;

    @SerializedName("ecom_scene_id")
    private final String ecomSceneId;

    @SerializedName("guest_uid")
    private final String guestUid;

    @SerializedName("is_from_personal")
    private boolean isFromPersonal;

    @SerializedName("monitor_id")
    private String monitorId;

    @SerializedName("previous_page")
    private String previousPage;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("session_id")
    private String session_id;

    @SerializedName("uid")
    private final String uid;

    public CollectParams() {
        this(null, null, null, null, null, null, false, null, 0, 511, null);
    }

    public static /* synthetic */ CollectParams copy$default(CollectParams r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117, String r118, int r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.secUid;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.uid;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.guestUid;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.ecomSceneId;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.monitorId;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.previousPage;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.isFromPersonal;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.session_id;
    L35:
        if ((r210 & 256) == 0) goto L37;
        int r108 = r110.collectExperimentValue;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
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
        return this.ecomSceneId;
    }

    public final String component5() {
        return this.monitorId;
    }

    public final String component6() {
        return this.previousPage;
    }

    public final boolean component7() {
        return this.isFromPersonal;
    }

    public final String component8() {
        return this.session_id;
    }

    public final int component9() {
        return this.collectExperimentValue;
    }

    public final CollectParams copy(String r110, String r111, String r112, String r113, String r114, String r115, boolean r116, String r117, int r210) {
        Intrinsics.checkNotNullParameter(r110, "secUid");
        Intrinsics.checkNotNullParameter(r111, "uid");
        Intrinsics.checkNotNullParameter(r112, "guestUid");
        Intrinsics.checkNotNullParameter(r113, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r114, "monitorId");
        Intrinsics.checkNotNullParameter(r115, "previousPage");
        return new CollectParams(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CollectParams) == false) goto L24;
        CollectParams r101 = (CollectParams) r100;
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.guestUid, r101.guestUid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomSceneId, r101.ecomSceneId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.monitorId, r101.monitorId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L18;
        return false;
    L18:
        if (this.isFromPersonal == r101.isFromPersonal) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.session_id, r101.session_id) == true) goto L22;
        return false;
    L22:
        if (this.collectExperimentValue == r101.collectExperimentValue) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v24 */
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
        String r110 = this.ecomSceneId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.monitorId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.previousPage;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.isFromPersonal;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.session_id;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return ((r121 + r101) * 31) + this.collectExperimentValue;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "CollectParams(secUid=" + this.secUid + ", uid=" + this.uid + ", guestUid=" + this.guestUid + ", ecomSceneId=" + this.ecomSceneId + ", monitorId=" + this.monitorId + ", previousPage=" + this.previousPage + ", isFromPersonal=" + this.isFromPersonal + ", session_id=" + this.session_id + ", collectExperimentValue=" + this.collectExperimentValue + ")";
    }

    public final int getCollectExperimentValue() {
        return this.collectExperimentValue;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final String getGuestUid() {
        return this.guestUid;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getSession_id() {
        return this.session_id;
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

    public final void setMonitorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.monitorId = r100;
    }

    public final void setPreviousPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.previousPage = r100;
    }

    public final void setSession_id(String r100) {
        this.session_id = r100;
    }

    public CollectParams(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, int r110) {
        Intrinsics.checkNotNullParameter(r100, "secUid");
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "guestUid");
        Intrinsics.checkNotNullParameter(r103, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r104, "monitorId");
        Intrinsics.checkNotNullParameter(r105, "previousPage");
        this.secUid = r100;
        this.uid = r101;
        this.guestUid = r102;
        this.ecomSceneId = r103;
        this.monitorId = r104;
        this.previousPage = r105;
        this.isFromPersonal = r106;
        this.session_id = r107;
        this.collectExperimentValue = r110;
    }

    public /* synthetic */ CollectParams(String r110, String r111, String r112, String r113, String r114, String r115, boolean r116, String r117, int r118, int r210, DefaultConstructorMarker r211) {
        String r100 = "";
        if ((r210 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r210 & 32) != 0) goto L26;
        r100 = r115;
    L26:
        int r106 = 0;
        if ((r210 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = "none";
    L35:
        if ((r210 & 256) != 0) goto L38;
        r106 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r100, r107, r108, r106);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}

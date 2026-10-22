package com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a;", "", "", "totalReservedNum", "Ljava/lang/Long;", "getTotalReservedNum", "()Ljava/lang/Long;", "", "showReservedTotal", "Ljava/lang/Boolean;", "getShowReservedTotal", "()Ljava/lang/Boolean;", "supportPlatform", "getSupportPlatform", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", "reserveNotice", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("notice")
    private final C0891a reserveNotice;

    @SerializedName("show_reserved_total")
    private final Boolean showReservedTotal;

    @SerializedName("support_platforms")
    private final Long supportPlatform;

    @SerializedName("reserved_total_by_game")
    private final Long totalReservedNum;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", "", "", "title", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "announcementType", "getAnnouncementType", "jumpContent", "b", "gameStage", "getGameStage", "landScapeJumpContent", "c", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0891a {

        @SerializedName("action_type")
        private final Long actionType;

        @SerializedName("announcement_type")
        private final Long announcementType;

        @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE)
        private final Long gameStage;

        @SerializedName("jump_content")
        private final String jumpContent;

        @SerializedName("landscape_jump_content")
        private final String landScapeJumpContent;

        @SerializedName("title")
        private final String title;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C0891a) == false) goto L18;
            C0891a r101 = (C0891a) r100;
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.announcementType, r101.announcementType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.jumpContent, r101.jumpContent) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.gameStage, r101.gameStage) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.landScapeJumpContent, r101.landScapeJumpContent) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r100 = this.title;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Long r104 = this.actionType;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.announcementType;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.jumpContent;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Long r113 = this.gameStage;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.landScapeJumpContent;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
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

        public final String toString() {
            return "GameDetailNotice(title=" + this.title + ", actionType=" + this.actionType + ", announcementType=" + this.announcementType + ", jumpContent=" + this.jumpContent + ", gameStage=" + this.gameStage + ", landScapeJumpContent=" + this.landScapeJumpContent + ")";
        }

        public C0891a() {
            this.title = "";
            this.actionType = -1L;
            this.announcementType = null;
            this.jumpContent = "";
            this.gameStage = null;
            this.landScapeJumpContent = "";
        }

        public final Long a() {
            return this.actionType;
        }

        public final String b() {
            return this.jumpContent;
        }

        public final String c() {
            return this.landScapeJumpContent;
        }

        public final String d() {
            return this.title;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.totalReservedNum, r101.totalReservedNum) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showReservedTotal, r101.showReservedTotal) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.supportPlatform, r101.supportPlatform) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reserveNotice, r101.reserveNotice) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.totalReservedNum;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showReservedTotal;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.supportPlatform;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        C0891a r110 = this.reserveNotice;
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

    public final String toString() {
        return "GameOrderBasicInfoData(totalReservedNum=" + this.totalReservedNum + ", showReservedTotal=" + this.showReservedTotal + ", supportPlatform=" + this.supportPlatform + ", reserveNotice=" + this.reserveNotice + ")";
    }

    public a() {
        Boolean r100 = Boolean.FALSE;
        this.totalReservedNum = null;
        this.showReservedTotal = r100;
        this.supportPlatform = 0L;
        this.reserveNotice = null;
    }

    public final C0891a a() {
        return this.reserveNotice;
    }
}

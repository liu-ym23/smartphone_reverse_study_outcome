package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AnchorColumnPosterInfo;", "", "avatarUrl", "", "anchorUserID", "anchorNickname", "columnTitle", "columnIntroduction", "columnBackgroundUrl", "columnBackgroundColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorNickname", "()Ljava/lang/String;", "getAnchorUserID", "getAvatarUrl", "getColumnBackgroundColor", "getColumnBackgroundUrl", "getColumnIntroduction", "getColumnTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorColumnPosterInfo {
    private final String anchorNickname;
    private final String anchorUserID;
    private final String avatarUrl;
    private final String columnBackgroundColor;
    private final String columnBackgroundUrl;
    private final String columnIntroduction;
    private final String columnTitle;

    public static /* synthetic */ AnchorColumnPosterInfo copy$default(AnchorColumnPosterInfo r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.avatarUrl;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.anchorUserID;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.anchorNickname;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.columnTitle;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.columnIntroduction;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.columnBackgroundUrl;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.columnBackgroundColor;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.avatarUrl;
    }

    public final String component2() {
        return this.anchorUserID;
    }

    public final String component3() {
        return this.anchorNickname;
    }

    public final String component4() {
        return this.columnTitle;
    }

    public final String component5() {
        return this.columnIntroduction;
    }

    public final String component6() {
        return this.columnBackgroundUrl;
    }

    public final String component7() {
        return this.columnBackgroundColor;
    }

    public final AnchorColumnPosterInfo copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "avatarUrl");
        Intrinsics.checkNotNullParameter(r111, "anchorUserID");
        Intrinsics.checkNotNullParameter(r112, "anchorNickname");
        Intrinsics.checkNotNullParameter(r113, "columnTitle");
        Intrinsics.checkNotNullParameter(r114, "columnIntroduction");
        Intrinsics.checkNotNullParameter(r115, "columnBackgroundUrl");
        Intrinsics.checkNotNullParameter(r116, "columnBackgroundColor");
        return new AnchorColumnPosterInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorColumnPosterInfo) == false) goto L20;
        AnchorColumnPosterInfo r101 = (AnchorColumnPosterInfo) r100;
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.anchorUserID, r101.anchorUserID) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.anchorNickname, r101.anchorNickname) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columnTitle, r101.columnTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.columnIntroduction, r101.columnIntroduction) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.columnBackgroundUrl, r101.columnBackgroundUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.columnBackgroundColor, r101.columnBackgroundColor) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.avatarUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.anchorUserID;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.anchorNickname;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.columnTitle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.columnIntroduction;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.columnBackgroundUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.columnBackgroundColor;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "AnchorColumnPosterInfo(avatarUrl=" + this.avatarUrl + ", anchorUserID=" + this.anchorUserID + ", anchorNickname=" + this.anchorNickname + ", columnTitle=" + this.columnTitle + ", columnIntroduction=" + this.columnIntroduction + ", columnBackgroundUrl=" + this.columnBackgroundUrl + ", columnBackgroundColor=" + this.columnBackgroundColor + ")";
    }

    public final String getAnchorNickname() {
        return this.anchorNickname;
    }

    public final String getAnchorUserID() {
        return this.anchorUserID;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getColumnBackgroundColor() {
        return this.columnBackgroundColor;
    }

    public final String getColumnBackgroundUrl() {
        return this.columnBackgroundUrl;
    }

    public final String getColumnIntroduction() {
        return this.columnIntroduction;
    }

    public final String getColumnTitle() {
        return this.columnTitle;
    }

    public AnchorColumnPosterInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "avatarUrl");
        Intrinsics.checkNotNullParameter(r101, "anchorUserID");
        Intrinsics.checkNotNullParameter(r102, "anchorNickname");
        Intrinsics.checkNotNullParameter(r103, "columnTitle");
        Intrinsics.checkNotNullParameter(r104, "columnIntroduction");
        Intrinsics.checkNotNullParameter(r105, "columnBackgroundUrl");
        Intrinsics.checkNotNullParameter(r106, "columnBackgroundColor");
        this.avatarUrl = r100;
        this.anchorUserID = r101;
        this.anchorNickname = r102;
        this.columnTitle = r103;
        this.columnIntroduction = r104;
        this.columnBackgroundUrl = r105;
        this.columnBackgroundColor = r106;
    }
}

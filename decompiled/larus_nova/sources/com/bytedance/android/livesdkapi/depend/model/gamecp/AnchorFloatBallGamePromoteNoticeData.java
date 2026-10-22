package com.bytedance.android.livesdkapi.depend.model.gamecp;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JV\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\b\u0010%\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/gamecp/AnchorFloatBallGamePromoteNoticeData;", "", "promoteText", "", "introduceText", "gameIcon", "gameName", "bizMode", "", "gameId", "tipType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;)V", "getBizMode", "()J", "getGameIcon", "()Ljava/lang/String;", "getGameId", "getGameName", "getIntroduceText", "getPromoteText", "getTipType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/livesdkapi/depend/model/gamecp/AnchorFloatBallGamePromoteNoticeData;", "equals", "", "other", "hashCode", "toString", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorFloatBallGamePromoteNoticeData {
    private final long bizMode;
    private final String gameIcon;
    private final String gameId;
    private final String gameName;
    private final String introduceText;
    private final String promoteText;
    private final Integer tipType;

    public static /* synthetic */ AnchorFloatBallGamePromoteNoticeData copy$default(AnchorFloatBallGamePromoteNoticeData r100, String r110, String r111, String r112, String r113, long r114, String r115, Integer r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.promoteText;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.introduceText;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = r100.gameIcon;
    L15:
        if ((r117 & 8) == 0) goto L17;
        String r104 = r100.gameName;
    L19:
        if ((r117 & 16) == 0) goto L21;
        long r105 = r100.bizMode;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = r100.gameId;
    L27:
        if ((r117 & 64) == 0) goto L29;
        Integer r107 = r100.tipType;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
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

    public final String component1() {
        return this.promoteText;
    }

    public final String component2() {
        return this.introduceText;
    }

    public final String component3() {
        return this.gameIcon;
    }

    public final String component4() {
        return this.gameName;
    }

    public final long component5() {
        return this.bizMode;
    }

    public final String component6() {
        return this.gameId;
    }

    public final Integer component7() {
        return this.tipType;
    }

    public final AnchorFloatBallGamePromoteNoticeData copy(String r110, String r111, String r112, String r113, long r114, String r115, Integer r116) {
        Intrinsics.checkNotNullParameter(r110, "promoteText");
        Intrinsics.checkNotNullParameter(r111, "introduceText");
        Intrinsics.checkNotNullParameter(r112, "gameIcon");
        Intrinsics.checkNotNullParameter(r113, "gameName");
        Intrinsics.checkNotNullParameter(r115, "gameId");
        return new AnchorFloatBallGamePromoteNoticeData(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorFloatBallGamePromoteNoticeData) == false) goto L20;
        AnchorFloatBallGamePromoteNoticeData r101 = (AnchorFloatBallGamePromoteNoticeData) r100;
        if (Intrinsics.areEqual(this.promoteText, r101.promoteText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.introduceText, r101.introduceText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.gameIcon, r101.gameIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.gameName, r101.gameName) == true) goto L14;
        return false;
    L14:
        if (this.bizMode == r101.bizMode) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.gameId, r101.gameId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tipType, r101.tipType) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.promoteText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.introduceText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.gameIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.gameName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.bizMode;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.gameId;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.tipType;
        if (r118 == null) goto L26;
        r101 = r118.hashCode();
    L26:
        return r117 + r101;
    L21:
        r116 = 0;
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
        return "AnchorFloatBallGamePromoteNoticeData(promoteText='" + this.promoteText + "', introduceText='" + this.introduceText + "', gameIcon='" + this.gameIcon + "', gameName='" + this.gameName + "', bizMode=" + this.bizMode + ", gameId='" + this.gameId + "', tipType=" + this.tipType + ')';
    }

    public final long getBizMode() {
        return this.bizMode;
    }

    public final String getGameIcon() {
        return this.gameIcon;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getIntroduceText() {
        return this.introduceText;
    }

    public final String getPromoteText() {
        return this.promoteText;
    }

    public final Integer getTipType() {
        return this.tipType;
    }

    public AnchorFloatBallGamePromoteNoticeData(String r100, String r101, String r102, String r103, long r104, String r105, Integer r106) {
        Intrinsics.checkNotNullParameter(r100, "promoteText");
        Intrinsics.checkNotNullParameter(r101, "introduceText");
        Intrinsics.checkNotNullParameter(r102, "gameIcon");
        Intrinsics.checkNotNullParameter(r103, "gameName");
        Intrinsics.checkNotNullParameter(r105, "gameId");
        this.promoteText = r100;
        this.introduceText = r101;
        this.gameIcon = r102;
        this.gameName = r103;
        this.bizMode = r104;
        this.gameId = r105;
        this.tipType = r106;
    }

    public /* synthetic */ AnchorFloatBallGamePromoteNoticeData(String r110, String r111, String r112, String r113, long r114, String r115, Integer r116, int r117, DefaultConstructorMarker r210) {
        if ((r117 & 64) == 0) goto L5;
        Integer r100 = 0;
    L6:
        this(r110, r111, r112, r113, r114, r115, r100);
        return;
    L5:
        r100 = r116;
        goto L6
    }
}

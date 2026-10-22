package com.bytedance.android.livesdkapi.minigame;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdk.verify.VerifyErrorExtra;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013JF\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/RoomParams;", "Ljava/io/Serializable;", "title", "", "cover", "gameId", "gameName", "liveAgreement", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", "getGameId", "setGameId", "getGameName", "setGameName", "getLiveAgreement", "()Ljava/lang/Boolean;", "setLiveAgreement", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTitle", d.f25925o, "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/android/livesdkapi/minigame/RoomParams;", "equals", "other", "", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomParams implements Serializable {

    @SerializedName("live_cover")
    private String cover;

    @SerializedName("game_id")
    private String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    private String gameName;

    @SerializedName(VerifyErrorExtra.KEY_LIVE_AGREEMENT)
    private Boolean liveAgreement;

    @SerializedName("live_title")
    private String title;

    public static /* synthetic */ RoomParams copy$default(RoomParams r100, String r101, String r102, String r103, String r104, Boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.cover;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.gameId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.gameName;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.liveAgreement;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.cover;
    }

    public final String component3() {
        return this.gameId;
    }

    public final String component4() {
        return this.gameName;
    }

    public final Boolean component5() {
        return this.liveAgreement;
    }

    public final RoomParams copy(String r100, String r101, String r110, String r111, Boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r110, "gameId");
        return new RoomParams(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RoomParams) == false) goto L16;
        RoomParams r101 = (RoomParams) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.gameId, r101.gameId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.gameName, r101.gameName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveAgreement, r101.liveAgreement) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.cover;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.gameId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.gameName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.liveAgreement;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "RoomParams(title=" + this.title + ", cover=" + this.cover + ", gameId=" + this.gameId + ", gameName=" + this.gameName + ", liveAgreement=" + this.liveAgreement + ")";
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final Boolean getLiveAgreement() {
        return this.liveAgreement;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCover(String r100) {
        this.cover = r100;
    }

    public final void setGameId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameId = r100;
    }

    public final void setGameName(String r100) {
        this.gameName = r100;
    }

    public final void setLiveAgreement(Boolean r100) {
        this.liveAgreement = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public RoomParams(String r100, String r101, String r102, String r103, Boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, "gameId");
        this.title = r100;
        this.cover = r101;
        this.gameId = r102;
        this.gameName = r103;
        this.liveAgreement = r104;
    }

    public /* synthetic */ RoomParams(String r100, String r101, String r110, String r111, Boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        Boolean r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}

package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\f\u0012\b\u0010!\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003J¥\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0018HÆ\u0001J\t\u0010*\u001a\u00020)HÖ\u0001J\u0013\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010-\u001a\u0004\b<\u0010/\"\u0004\b=\u00101R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00102\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00102\u001a\u0004\b@\u00104\"\u0004\bA\u00106R\u0019\u0010 \u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b \u0010B\u001a\u0004\bC\u0010DR\u0019\u0010!\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b!\u0010B\u001a\u0004\bE\u0010DR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00102\u001a\u0004\bF\u00104\"\u0004\bG\u00106R\u0019\u0010#\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b#\u0010H\u001a\u0004\bI\u0010JR\u0019\u0010$\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b$\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010%\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b%\u0010N\u001a\u0004\bO\u0010PR\u0019\u0010&\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b&\u0010Q\u001a\u0004\bR\u0010SR\u0019\u0010'\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b'\u0010T\u001a\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeBasic;", "", "", "toString", "", "component1", "component2", "", "component3", "component4", "component5", "component6", "Lpy/k;", "component7", "component8", "component9", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "component10", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeMod;", "component11", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeWatchInfo;", "component12", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;", "component13", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "component14", "episodeID", "seasonId", "collected", "roomID", "title", "currentPeriod", "cover", "background", "selectionUrl", "owner", "mod", "watchInfo", "panelIcon", "giftPanel", "copy", "", "hashCode", "other", "equals", "J", "getEpisodeID", "()J", "setEpisodeID", "(J)V", "Ljava/lang/String;", "getSeasonId", "()Ljava/lang/String;", "setSeasonId", "(Ljava/lang/String;)V", "Z", "getCollected", "()Z", "setCollected", "(Z)V", "getRoomID", "setRoomID", "getTitle", d.f25925o, "getCurrentPeriod", "setCurrentPeriod", "Lpy/k;", "getCover", "()Lpy/k;", "getBackground", "getSelectionUrl", "setSelectionUrl", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOwner", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeMod;", "getMod", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeMod;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeWatchInfo;", "getWatchInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeWatchInfo;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;", "getPanelIcon", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "getGiftPanel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "<init>", "(JLjava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Lpy/k;Lpy/k;Ljava/lang/String;Lcom/bytedance/android/live/base/model/user/IBaseUser;Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeMod;Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeWatchInfo;Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeBasic {
    private final k background;
    private boolean collected;
    private final k cover;
    private String currentPeriod;
    private long episodeID;
    private final VSGiftPannel giftPanel;
    private final EpisodeMod mod;
    private final IBaseUser owner;
    private final VSPanelIcon panelIcon;
    private long roomID;
    private String seasonId;
    private String selectionUrl;
    private String title;
    private final EpisodeWatchInfo watchInfo;

    public static /* synthetic */ EpisodeBasic copy$default(EpisodeBasic r110, long r111, String r112, boolean r210, long r211, String r212, String r213, k r214, k r215, String r216, IBaseUser r217, EpisodeMod r218, EpisodeWatchInfo r310, VSPanelIcon r311, VSGiftPannel r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = r110.episodeID;
    L7:
        if ((r313 & 2) == 0) goto L9;
        String r101 = r110.seasonId;
    L11:
        if ((r313 & 4) == 0) goto L13;
        boolean r102 = r110.collected;
    L15:
        if ((r313 & 8) == 0) goto L17;
        long r103 = r110.roomID;
    L19:
        if ((r313 & 16) == 0) goto L21;
        String r104 = r110.title;
    L23:
        if ((r313 & 32) == 0) goto L25;
        String r105 = r110.currentPeriod;
    L27:
        if ((r313 & 64) == 0) goto L29;
        k r113 = r110.cover;
    L31:
        if ((r313 & 128) == 0) goto L33;
        k r114 = r110.background;
    L35:
        if ((r313 & 256) == 0) goto L37;
        String r115 = r110.selectionUrl;
    L39:
        if ((r313 & 512) == 0) goto L41;
        IBaseUser r116 = r110.owner;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        EpisodeMod r117 = r110.mod;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        EpisodeWatchInfo r118 = r110.watchInfo;
    L50:
        EpisodeWatchInfo r315 = r118;
        if ((r313 & 4096) == 0) goto L53;
        VSPanelIcon r119 = r110.panelIcon;
    L55:
        if ((r313 & 8192) == 0) goto L57;
        VSGiftPannel r106 = r110.giftPanel;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r315, r119, r106);
    L57:
        r106 = r312;
        goto L59
    L53:
        r119 = r311;
        goto L55
    L49:
        r118 = r310;
        goto L50
    L45:
        r117 = r218;
        goto L47
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.episodeID;
    }

    public final IBaseUser component10() {
        return this.owner;
    }

    public final EpisodeMod component11() {
        return this.mod;
    }

    public final EpisodeWatchInfo component12() {
        return this.watchInfo;
    }

    public final VSPanelIcon component13() {
        return this.panelIcon;
    }

    public final VSGiftPannel component14() {
        return this.giftPanel;
    }

    public final String component2() {
        return this.seasonId;
    }

    public final boolean component3() {
        return this.collected;
    }

    public final long component4() {
        return this.roomID;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.currentPeriod;
    }

    public final k component7() {
        return this.cover;
    }

    public final k component8() {
        return this.background;
    }

    public final String component9() {
        return this.selectionUrl;
    }

    public final EpisodeBasic copy(long r110, String r210, boolean r211, long r212, String r213, String r214, k r215, k r216, String r217, IBaseUser r310, EpisodeMod r311, EpisodeWatchInfo r312, VSPanelIcon r313, VSGiftPannel r314) {
        Intrinsics.checkNotNullParameter(r213, "title");
        Intrinsics.checkNotNullParameter(r214, "currentPeriod");
        Intrinsics.checkNotNullParameter(r217, "selectionUrl");
        return new EpisodeBasic(r110, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EpisodeBasic) == false) goto L34;
        EpisodeBasic r101 = (EpisodeBasic) r100;
        if (this.episodeID == r101.episodeID) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.seasonId, r101.seasonId) == true) goto L10;
        return false;
    L10:
        if (this.collected == r101.collected) goto L12;
        return false;
    L12:
        if (this.roomID == r101.roomID) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.currentPeriod, r101.currentPeriod) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.selectionUrl, r101.selectionUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.owner, r101.owner) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.mod, r101.mod) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.watchInfo, r101.watchInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.panelIcon, r101.panelIcon) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.giftPanel, r101.giftPanel) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        long r100 = this.episodeID;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.seasonId;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.collected;
        ?? r107 = r106;
        if (r106 == false) goto L9;
        r107 = 1;
    L9:
        long r108 = this.roomID;
        int r109 = (((r105 + r107) * 31) + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        String r110 = this.title;
        if (r110 == null) goto L12;
        int r111 = r110.hashCode();
    L13:
        int r112 = (r109 + r111) * 31;
        String r113 = this.currentPeriod;
        if (r113 == null) goto L16;
        int r114 = r113.hashCode();
    L17:
        int r115 = (r112 + r114) * 31;
        k r116 = this.cover;
        if (r116 == null) goto L20;
        int r117 = r116.hashCode();
    L21:
        int r118 = (r115 + r117) * 31;
        k r119 = this.background;
        if (r119 == null) goto L24;
        int r120 = r119.hashCode();
    L25:
        int r121 = (r118 + r120) * 31;
        String r122 = this.selectionUrl;
        if (r122 == null) goto L28;
        int r123 = r122.hashCode();
    L29:
        int r124 = (r121 + r123) * 31;
        IBaseUser r125 = this.owner;
        if (r125 == null) goto L32;
        int r126 = r125.hashCode();
    L33:
        int r127 = (r124 + r126) * 31;
        EpisodeMod r128 = this.mod;
        if (r128 == null) goto L36;
        int r129 = r128.hashCode();
    L37:
        int r130 = (r127 + r129) * 31;
        EpisodeWatchInfo r131 = this.watchInfo;
        if (r131 == null) goto L40;
        int r132 = r131.hashCode();
    L41:
        int r133 = (r130 + r132) * 31;
        VSPanelIcon r134 = this.panelIcon;
        if (r134 == null) goto L44;
        int r135 = r134.hashCode();
    L45:
        int r136 = (r133 + r135) * 31;
        VSGiftPannel r137 = this.giftPanel;
        if (r137 == null) goto L49;
        r103 = r137.hashCode();
    L49:
        return r136 + r103;
    L44:
        r135 = 0;
        goto L45
    L40:
        r132 = 0;
        goto L41
    L36:
        r129 = 0;
        goto L37
    L32:
        r126 = 0;
        goto L33
    L28:
        r123 = 0;
        goto L29
    L24:
        r120 = 0;
        goto L25
    L20:
        r117 = 0;
        goto L21
    L16:
        r114 = 0;
        goto L17
    L12:
        r111 = 0;
        goto L13
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "{\"episodeID\":" + this.episodeID + ", \"seasonId\":" + this.seasonId + ", \"collected\":" + this.collected + ", \"roomID\":" + this.roomID + ", \"title\":\"" + this.title + "\", \"currentPeriod\":\"" + this.currentPeriod + "\", \"selectionUrl\":\"" + this.selectionUrl + "\", \"owner\":" + this.owner + ", \"mod\":" + this.mod + ", \"watchInfo\":" + this.watchInfo + '}';
    }

    public final k getBackground() {
        return this.background;
    }

    public final boolean getCollected() {
        return this.collected;
    }

    public final k getCover() {
        return this.cover;
    }

    public final String getCurrentPeriod() {
        return this.currentPeriod;
    }

    public final long getEpisodeID() {
        return this.episodeID;
    }

    public final VSGiftPannel getGiftPanel() {
        return this.giftPanel;
    }

    public final EpisodeMod getMod() {
        return this.mod;
    }

    public final IBaseUser getOwner() {
        return this.owner;
    }

    public final VSPanelIcon getPanelIcon() {
        return this.panelIcon;
    }

    public final long getRoomID() {
        return this.roomID;
    }

    public final String getSeasonId() {
        return this.seasonId;
    }

    public final String getSelectionUrl() {
        return this.selectionUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final EpisodeWatchInfo getWatchInfo() {
        return this.watchInfo;
    }

    public final void setCollected(boolean r100) {
        this.collected = r100;
    }

    public final void setCurrentPeriod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentPeriod = r100;
    }

    public final void setEpisodeID(long r100) {
        this.episodeID = r100;
    }

    public final void setRoomID(long r100) {
        this.roomID = r100;
    }

    public final void setSeasonId(String r100) {
        this.seasonId = r100;
    }

    public final void setSelectionUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectionUrl = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public EpisodeBasic(long r100, String r101, boolean r110, long r111, String r112, String r113, k r114, k r115, String r116, IBaseUser r117, EpisodeMod r118, EpisodeWatchInfo r210, VSPanelIcon r211, VSGiftPannel r212) {
        Intrinsics.checkNotNullParameter(r112, "title");
        Intrinsics.checkNotNullParameter(r113, "currentPeriod");
        Intrinsics.checkNotNullParameter(r116, "selectionUrl");
        this.episodeID = r100;
        this.seasonId = r101;
        this.collected = r110;
        this.roomID = r111;
        this.title = r112;
        this.currentPeriod = r113;
        this.cover = r114;
        this.background = r115;
        this.selectionUrl = r116;
        this.owner = r117;
        this.mod = r118;
        this.watchInfo = r210;
        this.panelIcon = r211;
        this.giftPanel = r212;
    }
}

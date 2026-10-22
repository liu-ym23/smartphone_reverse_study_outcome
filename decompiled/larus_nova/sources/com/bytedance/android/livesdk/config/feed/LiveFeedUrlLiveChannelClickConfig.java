package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedUrlLiveChannelClickConfig;", "", "liveChannel", "", "liveChannelVoice", "liveChannelFm", "liveChannelCity", "liveChannelFollow", "liveChannelChat", "liveChannelGame", "liveChannelShopping", "liveChannelMusic", "liveChannelScience", "liveChannelBook", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLiveChannel", "()Ljava/lang/String;", "setLiveChannel", "(Ljava/lang/String;)V", "getLiveChannelBook", "setLiveChannelBook", "getLiveChannelChat", "setLiveChannelChat", "getLiveChannelCity", "setLiveChannelCity", "getLiveChannelFm", "setLiveChannelFm", "getLiveChannelFollow", "setLiveChannelFollow", "getLiveChannelGame", "setLiveChannelGame", "getLiveChannelMusic", "setLiveChannelMusic", "getLiveChannelScience", "setLiveChannelScience", "getLiveChannelShopping", "setLiveChannelShopping", "getLiveChannelVoice", "setLiveChannelVoice", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedUrlLiveChannelClickConfig {

    @SerializedName("live_channel")
    private String liveChannel;

    @SerializedName("live_channel_book")
    private String liveChannelBook;

    @SerializedName("live_channel_chat")
    private String liveChannelChat;

    @SerializedName("live_channel_city")
    private String liveChannelCity;

    @SerializedName("live_channel_fm")
    private String liveChannelFm;

    @SerializedName("live_channel_follow")
    private String liveChannelFollow;

    @SerializedName("live_channel_game")
    private String liveChannelGame;

    @SerializedName("live_channel_music")
    private String liveChannelMusic;

    @SerializedName("live_channel_science")
    private String liveChannelScience;

    @SerializedName("live_channel_shopping")
    private String liveChannelShopping;

    @SerializedName("live_channel_voice")
    private String liveChannelVoice;

    public LiveFeedUrlLiveChannelClickConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ LiveFeedUrlLiveChannelClickConfig copy$default(LiveFeedUrlLiveChannelClickConfig r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.liveChannel;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.liveChannelVoice;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.liveChannelFm;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.liveChannelCity;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.liveChannelFollow;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.liveChannelChat;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.liveChannelGame;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.liveChannelShopping;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.liveChannelMusic;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.liveChannelScience;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.liveChannelBook;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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
        return this.liveChannel;
    }

    public final String component10() {
        return this.liveChannelScience;
    }

    public final String component11() {
        return this.liveChannelBook;
    }

    public final String component2() {
        return this.liveChannelVoice;
    }

    public final String component3() {
        return this.liveChannelFm;
    }

    public final String component4() {
        return this.liveChannelCity;
    }

    public final String component5() {
        return this.liveChannelFollow;
    }

    public final String component6() {
        return this.liveChannelChat;
    }

    public final String component7() {
        return this.liveChannelGame;
    }

    public final String component8() {
        return this.liveChannelShopping;
    }

    public final String component9() {
        return this.liveChannelMusic;
    }

    public final LiveFeedUrlLiveChannelClickConfig copy(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214) {
        return new LiveFeedUrlLiveChannelClickConfig(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveFeedUrlLiveChannelClickConfig) == false) goto L28;
        LiveFeedUrlLiveChannelClickConfig r101 = (LiveFeedUrlLiveChannelClickConfig) r100;
        if (Intrinsics.areEqual(this.liveChannel, r101.liveChannel) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveChannelVoice, r101.liveChannelVoice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.liveChannelFm, r101.liveChannelFm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveChannelCity, r101.liveChannelCity) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveChannelFollow, r101.liveChannelFollow) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.liveChannelChat, r101.liveChannelChat) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.liveChannelGame, r101.liveChannelGame) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.liveChannelShopping, r101.liveChannelShopping) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.liveChannelMusic, r101.liveChannelMusic) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liveChannelScience, r101.liveChannelScience) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.liveChannelBook, r101.liveChannelBook) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        String r100 = this.liveChannel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.liveChannelVoice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.liveChannelFm;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.liveChannelCity;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.liveChannelFollow;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.liveChannelChat;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.liveChannelGame;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.liveChannelShopping;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.liveChannelMusic;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.liveChannelScience;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.liveChannelBook;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "LiveFeedUrlLiveChannelClickConfig(liveChannel=" + this.liveChannel + ", liveChannelVoice=" + this.liveChannelVoice + ", liveChannelFm=" + this.liveChannelFm + ", liveChannelCity=" + this.liveChannelCity + ", liveChannelFollow=" + this.liveChannelFollow + ", liveChannelChat=" + this.liveChannelChat + ", liveChannelGame=" + this.liveChannelGame + ", liveChannelShopping=" + this.liveChannelShopping + ", liveChannelMusic=" + this.liveChannelMusic + ", liveChannelScience=" + this.liveChannelScience + ", liveChannelBook=" + this.liveChannelBook + ")";
    }

    public final String getLiveChannel() {
        return this.liveChannel;
    }

    public final String getLiveChannelBook() {
        return this.liveChannelBook;
    }

    public final String getLiveChannelChat() {
        return this.liveChannelChat;
    }

    public final String getLiveChannelCity() {
        return this.liveChannelCity;
    }

    public final String getLiveChannelFm() {
        return this.liveChannelFm;
    }

    public final String getLiveChannelFollow() {
        return this.liveChannelFollow;
    }

    public final String getLiveChannelGame() {
        return this.liveChannelGame;
    }

    public final String getLiveChannelMusic() {
        return this.liveChannelMusic;
    }

    public final String getLiveChannelScience() {
        return this.liveChannelScience;
    }

    public final String getLiveChannelShopping() {
        return this.liveChannelShopping;
    }

    public final String getLiveChannelVoice() {
        return this.liveChannelVoice;
    }

    public final void setLiveChannel(String r100) {
        this.liveChannel = r100;
    }

    public final void setLiveChannelBook(String r100) {
        this.liveChannelBook = r100;
    }

    public final void setLiveChannelChat(String r100) {
        this.liveChannelChat = r100;
    }

    public final void setLiveChannelCity(String r100) {
        this.liveChannelCity = r100;
    }

    public final void setLiveChannelFm(String r100) {
        this.liveChannelFm = r100;
    }

    public final void setLiveChannelFollow(String r100) {
        this.liveChannelFollow = r100;
    }

    public final void setLiveChannelGame(String r100) {
        this.liveChannelGame = r100;
    }

    public final void setLiveChannelMusic(String r100) {
        this.liveChannelMusic = r100;
    }

    public final void setLiveChannelScience(String r100) {
        this.liveChannelScience = r100;
    }

    public final void setLiveChannelShopping(String r100) {
        this.liveChannelShopping = r100;
    }

    public final void setLiveChannelVoice(String r100) {
        this.liveChannelVoice = r100;
    }

    public LiveFeedUrlLiveChannelClickConfig(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111) {
        this.liveChannel = r100;
        this.liveChannelVoice = r101;
        this.liveChannelFm = r102;
        this.liveChannelCity = r103;
        this.liveChannelFollow = r104;
        this.liveChannelChat = r105;
        this.liveChannelGame = r106;
        this.liveChannelShopping = r107;
        this.liveChannelMusic = r108;
        this.liveChannelScience = r110;
        this.liveChannelBook = r111;
    }

    public /* synthetic */ LiveFeedUrlLiveChannelClickConfig(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
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
}

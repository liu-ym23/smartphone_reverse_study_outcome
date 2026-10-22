package com.bytedance.android.livesdk.ktvapi.model;

import com.google.gson.annotations.SerializedName;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0002\u0010\u001aJ\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\tHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\tHÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\t\u0010V\u001a\u00020\tHÆ\u0003J\t\u0010W\u001a\u00020\fHÆ\u0003J\t\u0010X\u001a\u00020\fHÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J»\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\tHÆ\u0001J\u0013\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\tHÖ\u0001J\t\u0010_\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001e\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001e\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\u001e\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R\u001e\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&¨\u0006`"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/KtvSeiModel;", "", "id", "", "idStr", "", "anchorId", "anchorIdStr", "cmd", "", "lyricsType", "playTime", "", "duration", "lyricsInfo", "", "Lcom/bytedance/android/livesdk/ktvapi/model/SeiLyricsInfo;", "lyricsOffset", "senderUserId", "senderUserIdStr", "musicPlayStatus", "orderInfo", "Lcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;", "state", "lyricUrl", "needFilterSelf", "(JLjava/lang/String;JLjava/lang/String;IIFFLjava/util/List;IJLjava/lang/String;ILcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;ILjava/lang/String;I)V", "getAnchorId", "()J", "setAnchorId", "(J)V", "getAnchorIdStr", "()Ljava/lang/String;", "setAnchorIdStr", "(Ljava/lang/String;)V", "getCmd", "()I", "setCmd", "(I)V", "getDuration", "()F", "setDuration", "(F)V", "getId", "setId", "getIdStr", "setIdStr", "getLyricUrl", "setLyricUrl", "getLyricsInfo", "()Ljava/util/List;", "setLyricsInfo", "(Ljava/util/List;)V", "getLyricsOffset", "setLyricsOffset", "getLyricsType", "setLyricsType", "getMusicPlayStatus", "setMusicPlayStatus", "getNeedFilterSelf", "setNeedFilterSelf", "getOrderInfo", "()Lcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;", "setOrderInfo", "(Lcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;)V", "getPlayTime", "setPlayTime", "getSenderUserId", "setSenderUserId", "getSenderUserIdStr", "setSenderUserIdStr", "getState", "setState", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvSeiModel {

    @SerializedName("anchor_id")
    private long anchorId;

    @SerializedName("anchor_id_str")
    private String anchorIdStr;

    @SerializedName("cmd")
    private int cmd;

    @SerializedName("duration")
    private float duration;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f142322id;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("lyric_url")
    private String lyricUrl;

    @SerializedName("lyricsInfo")
    private List<SeiLyricsInfo> lyricsInfo;

    @SerializedName("lyrics_offset")
    private int lyricsOffset;

    @SerializedName("lyrics_type")
    private int lyricsType;

    @SerializedName("music_play_status")
    private int musicPlayStatus;

    @SerializedName("need_filter_self")
    private int needFilterSelf;

    @SerializedName("order_info")
    private OrderSongSeiModel orderInfo;

    @SerializedName(HistoryTableOperate.HISTORY_PLAY_TIME)
    private float playTime;

    @SerializedName("sender_user_id")
    private long senderUserId;

    @SerializedName("sender_user_id_str")
    private String senderUserIdStr;

    @SerializedName("state")
    private int state;

    public KtvSeiModel() {
        this(0, null, 0, null, 0, 0, 0.0f, 0.0f, null, 0, 0, null, 0, null, 0, null, 0, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KtvSeiModel copy$default(KtvSeiModel r110, long r111, String r210, long r211, String r212, int r213, int r214, float r215, float r216, List r217, int r218, long r310, String r311, int r312, OrderSongSeiModel r313, int r314, String r315, int r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        long r100 = r110.f142322id;
    L7:
        if ((r317 & 2) == 0) goto L9;
        String r101 = r110.idStr;
    L11:
        if ((r317 & 4) == 0) goto L13;
        long r102 = r110.anchorId;
    L15:
        if ((r317 & 8) == 0) goto L17;
        String r103 = r110.anchorIdStr;
    L19:
        if ((r317 & 16) == 0) goto L21;
        int r104 = r110.cmd;
    L23:
        if ((r317 & 32) == 0) goto L25;
        int r105 = r110.lyricsType;
    L27:
        if ((r317 & 64) == 0) goto L29;
        float r112 = r110.playTime;
    L31:
        if ((r317 & 128) == 0) goto L33;
        float r113 = r110.duration;
    L35:
        if ((r317 & 256) == 0) goto L37;
        List r114 = r110.lyricsInfo;
    L39:
        if ((r317 & 512) == 0) goto L41;
        int r115 = r110.lyricsOffset;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        long r116 = r110.senderUserId;
    L46:
        long r319 = r116;
        if ((r317 & 2048) == 0) goto L49;
        String r117 = r110.senderUserIdStr;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        int r118 = r110.musicPlayStatus;
    L54:
        int r320 = r118;
        if ((r317 & 8192) == 0) goto L57;
        OrderSongSeiModel r119 = r110.orderInfo;
    L58:
        OrderSongSeiModel r321 = r119;
        if ((r317 & 16384) == 0) goto L61;
        int r120 = r110.state;
    L62:
        int r322 = r120;
        if ((r317 & 32768) == 0) goto L65;
        String r121 = r110.lyricUrl;
    L67:
        if ((r317 & 65536) == 0) goto L69;
        int r106 = r110.needFilterSelf;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r112, r113, r114, r115, r319, r117, r320, r321, r322, r121, r106);
    L69:
        r106 = r316;
        goto L71
    L65:
        r121 = r315;
        goto L67
    L61:
        r120 = r314;
        goto L62
    L57:
        r119 = r313;
        goto L58
    L53:
        r118 = r312;
        goto L54
    L49:
        r117 = r311;
        goto L51
    L45:
        r116 = r310;
        goto L46
    L41:
        r115 = r218;
        goto L43
    L37:
        r114 = r217;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.f142322id;
    }

    public final int component10() {
        return this.lyricsOffset;
    }

    public final long component11() {
        return this.senderUserId;
    }

    public final String component12() {
        return this.senderUserIdStr;
    }

    public final int component13() {
        return this.musicPlayStatus;
    }

    public final OrderSongSeiModel component14() {
        return this.orderInfo;
    }

    public final int component15() {
        return this.state;
    }

    public final String component16() {
        return this.lyricUrl;
    }

    public final int component17() {
        return this.needFilterSelf;
    }

    public final String component2() {
        return this.idStr;
    }

    public final long component3() {
        return this.anchorId;
    }

    public final String component4() {
        return this.anchorIdStr;
    }

    public final int component5() {
        return this.cmd;
    }

    public final int component6() {
        return this.lyricsType;
    }

    public final float component7() {
        return this.playTime;
    }

    public final float component8() {
        return this.duration;
    }

    public final List<SeiLyricsInfo> component9() {
        return this.lyricsInfo;
    }

    public final KtvSeiModel copy(long r210, String r211, long r212, String r213, int r214, int r310, float r311, float r312, List<SeiLyricsInfo> r313, int r314, long r315, String r316, int r317, OrderSongSeiModel r318, int r410, String r411, int r412) {
        Intrinsics.checkNotNullParameter(r211, "idStr");
        Intrinsics.checkNotNullParameter(r213, "anchorIdStr");
        Intrinsics.checkNotNullParameter(r313, "lyricsInfo");
        Intrinsics.checkNotNullParameter(r316, "senderUserIdStr");
        Intrinsics.checkNotNullParameter(r411, "lyricUrl");
        return new KtvSeiModel(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof KtvSeiModel) == false) goto L40;
        KtvSeiModel r101 = (KtvSeiModel) r100;
        if (this.f142322id == r101.f142322id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.idStr, r101.idStr) == true) goto L10;
        return false;
    L10:
        if (this.anchorId == r101.anchorId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorIdStr, r101.anchorIdStr) == true) goto L14;
        return false;
    L14:
        if (this.cmd == r101.cmd) goto L16;
        return false;
    L16:
        if (this.lyricsType == r101.lyricsType) goto L18;
        return false;
    L18:
        if (Float.compare(this.playTime, r101.playTime) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.duration, r101.duration) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.lyricsInfo, r101.lyricsInfo) == true) goto L24;
        return false;
    L24:
        if (this.lyricsOffset == r101.lyricsOffset) goto L26;
        return false;
    L26:
        if (this.senderUserId == r101.senderUserId) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.senderUserIdStr, r101.senderUserIdStr) == true) goto L30;
        return false;
    L30:
        if (this.musicPlayStatus == r101.musicPlayStatus) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.orderInfo, r101.orderInfo) == true) goto L34;
        return false;
    L34:
        if (this.state == r101.state) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lyricUrl, r101.lyricUrl) == true) goto L38;
        return false;
    L38:
        if (this.needFilterSelf == r101.needFilterSelf) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public int hashCode() {
        long r100 = this.f142322id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.idStr;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.anchorId;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.anchorIdStr;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (((((((((r106 + r108) * 31) + this.cmd) * 31) + this.lyricsType) * 31) + Float.floatToIntBits(this.playTime)) * 31) + Float.floatToIntBits(this.duration)) * 31;
        List<SeiLyricsInfo> r110 = this.lyricsInfo;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (((r109 + r111) * 31) + this.lyricsOffset) * 31;
        long r113 = this.senderUserId;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.senderUserIdStr;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (((r114 + r116) * 31) + this.musicPlayStatus) * 31;
        OrderSongSeiModel r118 = this.orderInfo;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        int r120 = (((r117 + r119) * 31) + this.state) * 31;
        String r121 = this.lyricUrl;
        if (r121 == null) goto L26;
        r103 = r121.hashCode();
    L26:
        return ((r120 + r103) * 31) + this.needFilterSelf;
    L21:
        r119 = 0;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "KtvSeiModel(id=" + this.f142322id + ", idStr=" + this.idStr + ", anchorId=" + this.anchorId + ", anchorIdStr=" + this.anchorIdStr + ", cmd=" + this.cmd + ", lyricsType=" + this.lyricsType + ", playTime=" + this.playTime + ", duration=" + this.duration + ", lyricsInfo=" + this.lyricsInfo + ", lyricsOffset=" + this.lyricsOffset + ", senderUserId=" + this.senderUserId + ", senderUserIdStr=" + this.senderUserIdStr + ", musicPlayStatus=" + this.musicPlayStatus + ", orderInfo=" + this.orderInfo + ", state=" + this.state + ", lyricUrl=" + this.lyricUrl + ", needFilterSelf=" + this.needFilterSelf + ")";
    }

    public final long getAnchorId() {
        return this.anchorId;
    }

    public final String getAnchorIdStr() {
        return this.anchorIdStr;
    }

    public final int getCmd() {
        return this.cmd;
    }

    public final float getDuration() {
        return this.duration;
    }

    public final long getId() {
        return this.f142322id;
    }

    public final String getIdStr() {
        return this.idStr;
    }

    public final String getLyricUrl() {
        return this.lyricUrl;
    }

    public final List<SeiLyricsInfo> getLyricsInfo() {
        return this.lyricsInfo;
    }

    public final int getLyricsOffset() {
        return this.lyricsOffset;
    }

    public final int getLyricsType() {
        return this.lyricsType;
    }

    public final int getMusicPlayStatus() {
        return this.musicPlayStatus;
    }

    public final int getNeedFilterSelf() {
        return this.needFilterSelf;
    }

    public final OrderSongSeiModel getOrderInfo() {
        return this.orderInfo;
    }

    public final float getPlayTime() {
        return this.playTime;
    }

    public final long getSenderUserId() {
        return this.senderUserId;
    }

    public final String getSenderUserIdStr() {
        return this.senderUserIdStr;
    }

    public final int getState() {
        return this.state;
    }

    public final void setAnchorId(long r100) {
        this.anchorId = r100;
    }

    public final void setAnchorIdStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorIdStr = r100;
    }

    public final void setCmd(int r100) {
        this.cmd = r100;
    }

    public final void setDuration(float r100) {
        this.duration = r100;
    }

    public final void setId(long r100) {
        this.f142322id = r100;
    }

    public final void setIdStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.idStr = r100;
    }

    public final void setLyricUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lyricUrl = r100;
    }

    public final void setLyricsInfo(List<SeiLyricsInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lyricsInfo = r100;
    }

    public final void setLyricsOffset(int r100) {
        this.lyricsOffset = r100;
    }

    public final void setLyricsType(int r100) {
        this.lyricsType = r100;
    }

    public final void setMusicPlayStatus(int r100) {
        this.musicPlayStatus = r100;
    }

    public final void setNeedFilterSelf(int r100) {
        this.needFilterSelf = r100;
    }

    public final void setOrderInfo(OrderSongSeiModel r100) {
        this.orderInfo = r100;
    }

    public final void setPlayTime(float r100) {
        this.playTime = r100;
    }

    public final void setSenderUserId(long r100) {
        this.senderUserId = r100;
    }

    public final void setSenderUserIdStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.senderUserIdStr = r100;
    }

    public final void setState(int r100) {
        this.state = r100;
    }

    public KtvSeiModel(long r100, String r110, long r111, String r112, int r113, int r114, float r115, float r116, List<SeiLyricsInfo> r117, int r210, long r211, String r212, int r213, OrderSongSeiModel r214, int r215, String r216, int r217) {
        Intrinsics.checkNotNullParameter(r110, "idStr");
        Intrinsics.checkNotNullParameter(r112, "anchorIdStr");
        Intrinsics.checkNotNullParameter(r117, "lyricsInfo");
        Intrinsics.checkNotNullParameter(r212, "senderUserIdStr");
        Intrinsics.checkNotNullParameter(r216, "lyricUrl");
        this.f142322id = r100;
        this.idStr = r110;
        this.anchorId = r111;
        this.anchorIdStr = r112;
        this.cmd = r113;
        this.lyricsType = r114;
        this.playTime = r115;
        this.duration = r116;
        this.lyricsInfo = r117;
        this.lyricsOffset = r210;
        this.senderUserId = r211;
        this.senderUserIdStr = r212;
        this.musicPlayStatus = r213;
        this.orderInfo = r214;
        this.state = r215;
        this.lyricUrl = r216;
        this.needFilterSelf = r217;
    }

    public /* synthetic */ KtvSeiModel(long r210, String r211, long r212, String r213, int r214, int r215, float r310, float r311, List r312, int r313, long r314, String r315, int r316, OrderSongSeiModel r317, int r318, String r410, int r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r412 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r412 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r412 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r412 & 16) == 0) goto L21;
        int r110 = KtvCommand.NOTHING.getValue();
    L23:
        if ((r412 & 32) == 0) goto L25;
        int r111 = LyricsType.UNKNOWN.getValue();
    L26:
        float r112 = 0.0f;
        if ((r412 & 64) == 0) goto L29;
        float r113 = 0.0f;
    L31:
        if ((r412 & 128) != 0) goto L35;
        r112 = r311;
    L35:
        if ((r412 & 256) == 0) goto L37;
        List r114 = CollectionsKt.emptyList();
    L38:
        int r115 = 0;
        if ((r412 & 512) == 0) goto L41;
        int r116 = 0;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        long r117 = 0;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        String r104 = "";
    L51:
        if ((r412 & 4096) == 0) goto L53;
        int r105 = MusicPlayStatus.UNKNOWN.getValue();
    L55:
        if ((r412 & 8192) == 0) goto L57;
        OrderSongSeiModel r106 = null;
    L58:
        OrderSongSeiModel r414 = r106;
        if ((r412 & 16384) == 0) goto L61;
        int r107 = KtvRoomStatus.UNKNOWN.getValue();
    L63:
        if ((r412 & 32768) == 0) goto L65;
        String r118 = "";
    L67:
        if ((r412 & 65536) != 0) goto L70;
        r115 = r411;
    L70:
        this(r100, r101, r102, r103, r110, r111, r113, r112, r114, r116, r117, r104, r105, r414, r107, r118, r115);
        return;
    L65:
        r118 = r410;
        goto L67
    L61:
        r107 = r318;
        goto L63
    L57:
        r106 = r317;
        goto L58
    L53:
        r105 = r316;
        goto L55
    L49:
        r104 = r315;
        goto L51
    L45:
        r117 = r314;
        goto L47
    L41:
        r116 = r313;
        goto L43
    L37:
        r114 = r312;
        goto L38
    L29:
        r113 = r310;
        goto L31
    L25:
        r111 = r215;
        goto L26
    L21:
        r110 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}

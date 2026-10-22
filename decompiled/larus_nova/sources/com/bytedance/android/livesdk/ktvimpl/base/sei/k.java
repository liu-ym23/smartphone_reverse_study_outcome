package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001sR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR0\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010\"\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001c\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\rR\u001a\u0010.\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R \u00106\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b6\u0010\u0004\u0012\u0004\b8\u0010\b\u001a\u0004\b7\u0010\u0006R\u001a\u00109\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\rR$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\rR\u001a\u0010D\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010\u001d\u001a\u0004\bE\u0010\u001fR\u001a\u0010F\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010\u000b\u001a\u0004\bG\u0010\rR$\u0010H\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010/\u001a\u0004\bI\u00101\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bM\u0010\rR\u001c\u0010O\u001a\u0004\u0018\u00010N8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bS\u0010\u000b\u001a\u0004\bT\u0010\rR\u001c\u0010U\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010/\u001a\u0004\bV\u00101R$\u0010W\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010/\u001a\u0004\bX\u00101\"\u0004\bY\u0010KR$\u0010Z\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010/\u001a\u0004\b[\u00101\"\u0004\b\\\u0010KR\u001c\u0010]\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R$\u0010a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010^\u001a\u0004\bb\u0010`\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\be\u00103\u001a\u0004\be\u00105R\u001a\u0010f\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\u001d\u001a\u0004\bg\u0010\u001fR\u001a\u0010h\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010/\u001a\u0004\bi\u00101R\u001c\u0010k\u001a\u0004\u0018\u00010j8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\"\u0010o\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\bo\u0010\u0015\u001a\u0004\bp\u0010\u0017R\"\u0010q\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\bq\u0010\u0015\u001a\u0004\br\u0010\u0017¨\u0006t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/k;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "anchorId", "J", "getAnchorId", "()J", "getAnchorId$annotations", "()V", "", "cmd", "I", "d", "()I", "scene", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "lyricsType", OfficeSDKRequestTag.KEY_NEW_USER, "", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/v;", "lyricsInfo", "Ljava/util/List;", "l", "()Ljava/util/List;", "L", "(Ljava/util/List;)V", "getLyricsInfo$annotations", "", "playTime", FaceService.girlLabel, "y", "()F", "id", ce.f26395j, "duration", "h", "lyricsOffset", "m", "", "showScore", "Ljava/lang/Boolean;", "getShowScore", "()Ljava/lang/Boolean;", "mode", "u", "", "coverUrl", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "forceHide", "Z", RXScreenCaptureService.KEY_INDEX, "()Z", "senderUserID", "getSenderUserID", "getSenderUserID$annotations", "state", "C", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;", "orderInfo", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;", "w", "()Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;", "setOrderInfo", "(Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;)V", "playFlag", "x", "start", "B", "musicPlayStatus", BaseSwitches.V, "lyricsUrl", "p", "M", "(Ljava/lang/String;)V", "songType", "getSongType", "Loe2/e;", "ktvRoomState", "Loe2/e;", ce.f26396k, "()Loe2/e;", "sync_index", "getSync_index", "vId", "D", "midiUrl", "t", "N", "vocalUrl", "getVocalUrl", "setVocalUrl", "midiStatus", "Ljava/lang/Integer;", "s", "()Ljava/lang/Integer;", "midiCover", "q", "setMidiCover", "(Ljava/lang/Integer;)V", "isInChorus", "ballPos", "c", "midiDressId", "r", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/x;", "wantListenInfo", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/x;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdk/ktvimpl/base/sei/x;", "copyrightedAppIds", "e", "copyrightedRegionIds", "f", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f143313a;

    @SerializedName("anchor_id")
    private final long anchorId;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f143314b;

    @SerializedName("grid_y")
    private final float ballPos;

    @SerializedName("cmd")
    private final int cmd;

    @SerializedName("copyrighted_app_ids")
    private final List<Integer> copyrightedAppIds;

    @SerializedName("copyrighted_region_ids")
    private final List<String> copyrightedRegionIds;

    @SerializedName("cover_url")
    private final String coverUrl;

    @SerializedName("duration")
    private final float duration;

    @SerializedName("force_hide")
    private final boolean forceHide;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f143315id;

    @SerializedName("is_in_chorus")
    private final boolean isInChorus;

    @SerializedName("roomState")
    private final oe2.e ktvRoomState;

    @SerializedName("lyrics_info")
    private List<v> lyricsInfo;

    @SerializedName("lyrics_offset")
    private final float lyricsOffset;

    @SerializedName("lyrics_type")
    private final int lyricsType;

    @SerializedName("lyric_url")
    private String lyricsUrl;

    @SerializedName("midi_cover")
    private Integer midiCover;

    @SerializedName("midi_dress_id")
    private final String midiDressId;

    @SerializedName("midi_status")
    private final Integer midiStatus;

    @SerializedName("midi_url")
    private String midiUrl;

    @SerializedName("mode")
    private final int mode;

    @SerializedName("music_play_status")
    private final int musicPlayStatus;

    @SerializedName("order_info")
    private q orderInfo;

    @SerializedName("play_flag")
    private final int playFlag;

    @SerializedName("playTime")
    private final float playTime;

    @SerializedName("scene")
    private final int scene;

    @SerializedName("sender_user_id")
    private final long senderUserID;

    @SerializedName("show_score")
    private final Boolean showScore;

    @SerializedName("song_type")
    private final int songType;

    @SerializedName("start")
    private final float start;

    @SerializedName("state")
    private final int state;

    @SerializedName("sync_index")
    private final int sync_index;

    @SerializedName("vid")
    private final String vId;

    @SerializedName("vocal_url")
    private String vocalUrl;

    @SerializedName("want_listen_info")
    private final x wantListenInfo;

    public static final class a {
    }

    static {
    }

    public final void L() {
        this.lyricsInfo = null;
    }

    public final void M() {
        this.lyricsUrl = null;
    }

    public final void N() {
        this.midiUrl = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L74;
        k r101 = (k) r100;
        if (this.anchorId == r101.anchorId) goto L8;
        return false;
    L8:
        if (this.cmd == r101.cmd) goto L10;
        return false;
    L10:
        if (this.scene == r101.scene) goto L12;
        return false;
    L12:
        if (this.lyricsType == r101.lyricsType) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.lyricsInfo, r101.lyricsInfo) == true) goto L16;
        return false;
    L16:
        if (Float.compare(this.playTime, r101.playTime) == 0) goto L18;
        return false;
    L18:
        if (this.f143315id == r101.f143315id) goto L20;
        return false;
    L20:
        if (Float.compare(this.duration, r101.duration) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.lyricsOffset, r101.lyricsOffset) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showScore, r101.showScore) == true) goto L26;
        return false;
    L26:
        if (this.mode == r101.mode) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L30;
        return false;
    L30:
        if (this.forceHide == r101.forceHide) goto L32;
        return false;
    L32:
        if (this.senderUserID == r101.senderUserID) goto L34;
        return false;
    L34:
        if (this.state == r101.state) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.orderInfo, r101.orderInfo) == true) goto L38;
        return false;
    L38:
        if (this.playFlag == r101.playFlag) goto L40;
        return false;
    L40:
        if (Float.compare(this.start, r101.start) == 0) goto L42;
        return false;
    L42:
        if (this.musicPlayStatus == r101.musicPlayStatus) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.lyricsUrl, r101.lyricsUrl) == true) goto L46;
        return false;
    L46:
        if (this.songType == r101.songType) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ktvRoomState, r101.ktvRoomState) == true) goto L50;
        return false;
    L50:
        if (this.sync_index == r101.sync_index) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.vId, r101.vId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.midiUrl, r101.midiUrl) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.vocalUrl, r101.vocalUrl) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.midiStatus, r101.midiStatus) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.midiCover, r101.midiCover) == true) goto L62;
        return false;
    L62:
        if (this.isInChorus == r101.isInChorus) goto L64;
        return false;
    L64:
        if (Float.compare(this.ballPos, r101.ballPos) == 0) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.midiDressId, r101.midiDressId) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.wantListenInfo, r101.wantListenInfo) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.copyrightedAppIds, r101.copyrightedAppIds) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.copyrightedRegionIds, r101.copyrightedRegionIds) == true) goto L112;
        return false;
    L112:
        return true;
    L74:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final int hashCode() {
        long r100 = this.anchorId;
        int r101 = ((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.cmd) * 31) + this.scene) * 31) + this.lyricsType) * 31;
        List<v> r102 = this.lyricsInfo;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (((r101 + r104) * 31) + Float.floatToIntBits(this.playTime)) * 31;
        long r106 = this.f143315id;
        int r107 = (((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + Float.floatToIntBits(this.duration)) * 31) + Float.floatToIntBits(this.lyricsOffset)) * 31;
        Boolean r108 = this.showScore;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (((r107 + r109) * 31) + this.mode) * 31;
        String r111 = this.coverUrl;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.forceHide;
        ?? r115 = 1;
        ?? r116 = r114;
        if (r114 == false) goto L17;
        r116 = 1;
    L17:
        long r117 = this.senderUserID;
        int r118 = (((((r113 + r116) * 31) + ((int) (r117 ^ (r117 >>> 32)))) * 31) + this.state) * 31;
        q r119 = this.orderInfo;
        if (r119 == null) goto L20;
        int r120 = r119.hashCode();
    L21:
        int r121 = (((((((r118 + r120) * 31) + this.playFlag) * 31) + Float.floatToIntBits(this.start)) * 31) + this.musicPlayStatus) * 31;
        String r122 = this.lyricsUrl;
        if (r122 == null) goto L24;
        int r123 = r122.hashCode();
    L25:
        int r124 = (((r121 + r123) * 31) + this.songType) * 31;
        oe2.e r125 = this.ktvRoomState;
        if (r125 == null) goto L28;
        int r126 = r125.hashCode();
    L29:
        int r127 = (((r124 + r126) * 31) + this.sync_index) * 31;
        String r128 = this.vId;
        if (r128 == null) goto L32;
        int r129 = r128.hashCode();
    L33:
        int r130 = (r127 + r129) * 31;
        String r131 = this.midiUrl;
        if (r131 == null) goto L36;
        int r132 = r131.hashCode();
    L37:
        int r133 = (r130 + r132) * 31;
        String r134 = this.vocalUrl;
        if (r134 == null) goto L40;
        int r135 = r134.hashCode();
    L41:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.midiStatus;
        if (r137 == null) goto L44;
        int r138 = r137.hashCode();
    L45:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.midiCover;
        if (r140 == null) goto L48;
        int r141 = r140.hashCode();
    L49:
        int r142 = (r139 + r141) * 31;
        boolean r143 = this.isInChorus;
        if (r143 == true) goto L53;
        r115 = r143;
    L53:
        int r144 = (((r142 + r115) * 31) + Float.floatToIntBits(this.ballPos)) * 31;
        String r145 = this.midiDressId;
        if (r145 == null) goto L56;
        int r146 = r145.hashCode();
    L57:
        int r147 = (r144 + r146) * 31;
        x r148 = this.wantListenInfo;
        if (r148 == null) goto L60;
        int r149 = r148.hashCode();
    L61:
        int r150 = (r147 + r149) * 31;
        List<Integer> r151 = this.copyrightedAppIds;
        if (r151 == null) goto L64;
        int r152 = r151.hashCode();
    L65:
        int r153 = (r150 + r152) * 31;
        List<String> r154 = this.copyrightedRegionIds;
        if (r154 == null) goto L69;
        r103 = r154.hashCode();
    L69:
        return r153 + r103;
    L64:
        r152 = 0;
        goto L65
    L60:
        r149 = 0;
        goto L61
    L56:
        r146 = 0;
        goto L57
    L48:
        r141 = 0;
        goto L49
    L44:
        r138 = 0;
        goto L45
    L40:
        r135 = 0;
        goto L41
    L36:
        r132 = 0;
        goto L37
    L32:
        r129 = 0;
        goto L33
    L28:
        r126 = 0;
        goto L29
    L24:
        r123 = 0;
        goto L25
    L20:
        r120 = 0;
        goto L21
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvSeiModelCompat(anchorId=" + this.anchorId + ", cmd=" + this.cmd + ", scene=" + this.scene + ", lyricsType=" + this.lyricsType + ", lyricsInfo=" + this.lyricsInfo + ", playTime=" + this.playTime + ", id=" + this.f143315id + ", duration=" + this.duration + ", lyricsOffset=" + this.lyricsOffset + ", showScore=" + this.showScore + ", mode=" + this.mode + ", coverUrl=" + this.coverUrl + ", forceHide=" + this.forceHide + ", senderUserID=" + this.senderUserID + ", state=" + this.state + ", orderInfo=" + this.orderInfo + ", playFlag=" + this.playFlag + ", start=" + this.start + ", musicPlayStatus=" + this.musicPlayStatus + ", lyricsUrl=" + this.lyricsUrl + ", songType=" + this.songType + ", ktvRoomState=" + this.ktvRoomState + ", sync_index=" + this.sync_index + ", vId=" + this.vId + ", midiUrl=" + this.midiUrl + ", vocalUrl=" + this.vocalUrl + ", midiStatus=" + this.midiStatus + ", midiCover=" + this.midiCover + ", isInChorus=" + this.isInChorus + ", ballPos=" + this.ballPos + ", midiDressId=" + this.midiDressId + ", wantListenInfo=" + this.wantListenInfo + ", copyrightedAppIds=" + this.copyrightedAppIds + ", copyrightedRegionIds=" + this.copyrightedRegionIds + ")";
    }

    public final String A() {
        if (TextUtils.isEmpty(this.f143314b) == false) goto L6;
        this.f143314b = t.k(this.senderUserID);
    L6:
        return this.f143314b;
    }

    public final boolean F() {
        int r100 = this.scene;
        if (r100 == 3) goto L7;
        if (r100 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean G() {
        if (this.scene == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean H() {
        if (this.scene != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean I() {
        if (this.scene != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean J() {
        List<v> r100 = this.lyricsInfo;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L20;
        String r102 = this.lyricsUrl;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
        goto L17
    L20:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean K() {
        if (this.musicPlayStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f143313a) == false) goto L6;
        this.f143313a = t.k(this.anchorId);
    L6:
        return this.f143313a;
    }

    public final boolean o() {
        int r100 = this.lyricsType;
        if (r100 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    }

    public final float B() {
        return this.start;
    }

    public final int C() {
        return this.state;
    }

    public final String D() {
        return this.vId;
    }

    public final x E() {
        return this.wantListenInfo;
    }

    public final float c() {
        return this.ballPos;
    }

    public final int d() {
        return this.cmd;
    }

    public final List<Integer> e() {
        return this.copyrightedAppIds;
    }

    public final List<String> f() {
        return this.copyrightedRegionIds;
    }

    public final String g() {
        return this.coverUrl;
    }

    public final float h() {
        return this.duration;
    }

    public final boolean i() {
        return this.forceHide;
    }

    public final long j() {
        return this.f143315id;
    }

    public final oe2.e k() {
        return this.ktvRoomState;
    }

    public final List<v> l() {
        return this.lyricsInfo;
    }

    public final float m() {
        return this.lyricsOffset;
    }

    public final int n() {
        return this.lyricsType;
    }

    public final String p() {
        return this.lyricsUrl;
    }

    public final Integer q() {
        return this.midiCover;
    }

    public final String r() {
        return this.midiDressId;
    }

    public final Integer s() {
        return this.midiStatus;
    }

    public final String t() {
        return this.midiUrl;
    }

    public final int u() {
        return this.mode;
    }

    public final int v() {
        return this.musicPlayStatus;
    }

    public final q w() {
        return this.orderInfo;
    }

    public final int x() {
        return this.playFlag;
    }

    public final float y() {
        return this.playTime;
    }

    public final int z() {
        return this.scene;
    }
}

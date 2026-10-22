package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001a\u0010$\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000bR \u0010(\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010\u0013\u0012\u0004\b*\u0010\r\u001a\u0004\b)\u0010\u0015R \u0010+\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b+\u0010\u0013\u0012\u0004\b-\u0010\r\u001a\u0004\b,\u0010\u0015R\u001a\u0010/\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/h;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "avatarThumb", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "userId", "Ljava/lang/Long;", "getUserId", "()Ljava/lang/Long;", "getUserId$annotations", "()V", "secUid", "getSecUid", "nickName", "f", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "J", "getPercentage", "()J", "songTitle", ce.f26395j, "", com.bytedance.android.ec.core.event.a.KEY_SCORE, FaceService.girlLabel, ce.f26391f, "()F", "", "isHighScoreSong", "Z", "l", "()Z", "midiTips", "e", "hitMidiRecordABTest", "d", "songId", RXScreenCaptureService.KEY_INDEX, "anchorId", "getAnchorId", "getAnchorId$annotations", "senderUserID", "getSenderUserID", "getSenderUserID$annotations", "", "highScoreSongThreshold", "D", "c", "()D", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f143309a;

    @SerializedName("anchor_id")
    private final long anchorId;

    @SerializedName("avatar_thumb")
    private final String avatarThumb;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f143310b;

    @SerializedName("threshold")
    private final double highScoreSongThreshold;

    @SerializedName("hit_record_ab")
    private final boolean hitMidiRecordABTest;

    @SerializedName("is_high_score")
    private final boolean isHighScoreSong;

    @SerializedName("midi_tips")
    private final String midiTips;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE)
    private final long percentage;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final float score;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("sender_user_id")
    private final long senderUserID;

    @SerializedName("song_id")
    private final Long songId;

    @SerializedName("song_title")
    private final String songTitle;

    @SerializedName("user_id")
    private final Long userId;

    public static final class a {
    }

    static {
    }

    public h() {
        this(null, null, null, null, 0, null, 0.0f, false, null, false, null, 0, AudioStats.AUDIO_AMPLITUDE_NONE, 16383);
    }

    public final String h() {
        if (TextUtils.isEmpty(this.f143309a) == false) goto L6;
        this.f143309a = t.k(this.senderUserID);
    L6:
        return this.f143309a;
    }

    public final String k() {
        if (TextUtils.isEmpty(this.f143310b) == false) goto L10;
        Long r100 = this.userId;
        if (r100 == null) goto L7;
        long r101 = r100.longValue();
    L8:
        this.f143310b = t.k(r101);
        goto L10
    L7:
        r101 = 0;
    L10:
        return this.f143310b;
    }

    public final String b() {
        return this.avatarThumb;
    }

    public final double c() {
        return this.highScoreSongThreshold;
    }

    public final boolean d() {
        return this.hitMidiRecordABTest;
    }

    public final String e() {
        return this.midiTips;
    }

    public final String f() {
        return this.nickName;
    }

    public final float g() {
        return this.score;
    }

    public final Long i() {
        return this.songId;
    }

    public final String j() {
        return this.songTitle;
    }

    public final boolean l() {
        return this.isHighScoreSong;
    }

    public h(String r210, Long r211, String r212, String r213, long r214, String r215, float r310, boolean r311, String r312, boolean r313, Long r314, long r315, double r316, int r317) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r317 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r317 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r317 & 16) == 0) goto L21;
        long r110 = 0;
    L23:
        if ((r317 & 32) == 0) goto L25;
        String r104 = "";
    L27:
        if ((r317 & 64) == 0) goto L29;
        float r111 = 0.0f;
    L31:
        if ((r317 & 128) == 0) goto L33;
        boolean r112 = false;
    L35:
        if ((r317 & 256) == 0) goto L37;
        String r105 = "";
    L39:
        if ((r317 & 512) == 0) goto L41;
        boolean r113 = false;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        Long r106 = null;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        long r114 = 0;
    L51:
        if ((r317 & 8192) == 0) goto L53;
        double r216 = 0.0d;
    L54:
        this.avatarThumb = r100;
        this.userId = r101;
        this.secUid = r102;
        this.nickName = r103;
        this.percentage = r110;
        this.songTitle = r104;
        this.score = r111;
        this.isHighScoreSong = r112;
        this.midiTips = r105;
        this.hitMidiRecordABTest = r113;
        this.songId = r106;
        this.anchorId = r114;
        this.senderUserID = 0;
        this.highScoreSongThreshold = r216;
        this.f143309a = "";
        this.f143310b = "";
        return;
    L53:
        r216 = r316;
        goto L54
    L49:
        r114 = r315;
        goto L51
    L45:
        r106 = r314;
        goto L47
    L41:
        r113 = r313;
        goto L43
    L37:
        r105 = r312;
        goto L39
    L33:
        r112 = r311;
        goto L35
    L29:
        r111 = r310;
        goto L31
    L25:
        r104 = r215;
        goto L27
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

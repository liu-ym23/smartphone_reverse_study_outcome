package com.bytedance.android.shopping.anchorv4.dto.base;

import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.ec.model.response.u1;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0012\u0012\b\b\u0002\u0010'\u001a\u00020\u0014\u0012\b\b\u0002\u0010(\u001a\u00020\u0014\u0012\b\b\u0002\u0010)\u001a\u00020\u0014\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bX\u0010YJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0012HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0014HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0014HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0014HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003JÐ\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b,\u0010-J\t\u0010.\u001a\u00020\u0002HÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001J\u0013\u00102\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u000100HÖ\u0003R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b4\u00105R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b6\u00105R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\b7\u00105R\u001a\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\b9\u0010:R\u001a\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b;\u0010:R\u001c\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010\nR\u001c\u0010!\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b>\u0010\nR\u001c\u0010\"\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010#\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\bB\u0010\nR\u001c\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u00103\u001a\u0004\bF\u00105R\"\u0010&\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010'\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010(\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010L\u001a\u0004\b(\u0010N\"\u0004\bQ\u0010PR\"\u0010)\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010L\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PR\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u00103\u001a\u0004\bT\u00105R\u001c\u0010+\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010U\u001a\u0004\bV\u0010W¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "component5", "component6", "()Ljava/lang/Integer;", "component7", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component8", "component9", "Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;", "component10", "component11", "", "component12", "", "component13", "component14", "component15", "component16", "Lcom/bytedance/android/ec/model/response/u1;", "component17", "vid", "mainUrl", "backupUrl", "width", "height", "duration", "urlExpire", "posterImage", "sourceType", "playMeta", "posterUrl", "initialStartTimeMs", "autoPlay", "isMute", "autoPlayForBiz", "itemId", "extraInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/Integer;Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;Ljava/lang/String;JZZZLjava/lang/String;Lcom/bytedance/android/ec/model/response/u1;)Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getVid", "()Ljava/lang/String;", "getMainUrl", "getBackupUrl", "I", "getWidth", "()I", "getHeight", "Ljava/lang/Integer;", "getDuration", "getUrlExpire", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getPosterImage", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getSourceType", "Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;", "getPlayMeta", "()Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;", "getPosterUrl", "J", "getInitialStartTimeMs", "()J", "setInitialStartTimeMs", "(J)V", "Z", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "setMute", "getAutoPlayForBiz", "setAutoPlayForBiz", "getItemId", "Lcom/bytedance/android/ec/model/response/u1;", "getExtraInfo", "()Lcom/bytedance/android/ec/model/response/u1;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/Integer;Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;Ljava/lang/String;JZZZLjava/lang/String;Lcom/bytedance/android/ec/model/response/u1;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoModel implements Serializable {

    @SerializedName("auto_play")
    private boolean autoPlay;

    @SerializedName("auto_play_for_biz")
    private boolean autoPlayForBiz;

    @SerializedName(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL)
    private final String backupUrl;

    @SerializedName("duration")
    private final Integer duration;

    @SerializedName("extra_info")
    private final u1 extraInfo;

    @SerializedName("height")
    private final int height;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long initialStartTimeMs;

    @SerializedName("is_mute")
    private boolean isMute;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("main_url")
    private final String mainUrl;

    @SerializedName("play_opt_model")
    private final ECPDPBaseVideo playMeta;

    @SerializedName("poster_image")
    private final ImageModel posterImage;

    @SerializedName("poster_url")
    private final String posterUrl;

    @SerializedName("source_type")
    private final Integer sourceType;

    @SerializedName("url_expire")
    private final Integer urlExpire;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("width")
    private final int width;

    public VideoModel() {
        this(null, null, null, 0, 0, null, null, null, null, null, null, 0, false, false, false, null, null, 131071, null);
    }

    public static /* synthetic */ VideoModel copy$default(VideoModel r110, String r111, String r112, String r210, int r211, int r212, Integer r213, Integer r214, ImageModel r215, Integer r216, ECPDPBaseVideo r217, String r218, long r219, boolean r310, boolean r311, boolean r312, String r313, u1 r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.vid;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.mainUrl;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = r110.backupUrl;
    L15:
        if ((r315 & 8) == 0) goto L17;
        int r103 = r110.width;
    L19:
        if ((r315 & 16) == 0) goto L21;
        int r104 = r110.height;
    L23:
        if ((r315 & 32) == 0) goto L25;
        Integer r105 = r110.duration;
    L27:
        if ((r315 & 64) == 0) goto L29;
        Integer r106 = r110.urlExpire;
    L31:
        if ((r315 & 128) == 0) goto L33;
        ImageModel r107 = r110.posterImage;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Integer r113 = r110.sourceType;
    L39:
        if ((r315 & 512) == 0) goto L41;
        ECPDPBaseVideo r114 = r110.playMeta;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r110.posterUrl;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        long r116 = r110.initialStartTimeMs;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        boolean r117 = r110.autoPlay;
    L54:
        boolean r317 = r117;
        if ((r315 & 8192) == 0) goto L57;
        boolean r118 = r110.isMute;
    L58:
        boolean r318 = r118;
        if ((r315 & 16384) == 0) goto L61;
        boolean r119 = r110.autoPlayForBiz;
    L62:
        boolean r319 = r119;
        if ((r315 & 32768) == 0) goto L65;
        String r120 = r110.itemId;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        u1 r108 = r110.extraInfo;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r317, r318, r319, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L54
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
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

    public final String component1() {
        return this.vid;
    }

    public final ECPDPBaseVideo component10() {
        return this.playMeta;
    }

    public final String component11() {
        return this.posterUrl;
    }

    public final long component12() {
        return this.initialStartTimeMs;
    }

    public final boolean component13() {
        return this.autoPlay;
    }

    public final boolean component14() {
        return this.isMute;
    }

    public final boolean component15() {
        return this.autoPlayForBiz;
    }

    public final String component16() {
        return this.itemId;
    }

    public final u1 component17() {
        return this.extraInfo;
    }

    public final String component2() {
        return this.mainUrl;
    }

    public final String component3() {
        return this.backupUrl;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final Integer component6() {
        return this.duration;
    }

    public final Integer component7() {
        return this.urlExpire;
    }

    public final ImageModel component8() {
        return this.posterImage;
    }

    public final Integer component9() {
        return this.sourceType;
    }

    public final VideoModel copy(String r210, String r211, String r212, int r213, int r214, Integer r215, Integer r216, ImageModel r217, Integer r218, ECPDPBaseVideo r310, String r311, long r312, boolean r313, boolean r314, boolean r315, String r316, u1 r317) {
        return new VideoModel(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VideoModel) == false) goto L40;
        VideoModel r101 = (VideoModel) r100;
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mainUrl, r101.mainUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.backupUrl, r101.backupUrl) == true) goto L12;
        return false;
    L12:
        if (this.width == r101.width) goto L14;
        return false;
    L14:
        if (this.height == r101.height) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.urlExpire, r101.urlExpire) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.posterImage, r101.posterImage) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.sourceType, r101.sourceType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.playMeta, r101.playMeta) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.posterUrl, r101.posterUrl) == true) goto L28;
        return false;
    L28:
        if (this.initialStartTimeMs == r101.initialStartTimeMs) goto L30;
        return false;
    L30:
        if (this.autoPlay == r101.autoPlay) goto L32;
        return false;
    L32:
        if (this.isMute == r101.isMute) goto L34;
        return false;
    L34:
        if (this.autoPlayForBiz == r101.autoPlayForBiz) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        String r100 = this.vid;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.mainUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.backupUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((((r106 + r108) * 31) + this.width) * 31) + this.height) * 31;
        Integer r110 = this.duration;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.urlExpire;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ImageModel r116 = this.posterImage;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.sourceType;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECPDPBaseVideo r122 = this.playMeta;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.posterUrl;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        long r128 = this.initialStartTimeMs;
        int r129 = (r127 + ((int) (r128 ^ (r128 >>> 32)))) * 31;
        boolean r130 = this.autoPlay;
        ?? r131 = 1;
        ?? r132 = r130;
        if (r130 == false) goto L41;
        r132 = 1;
    L41:
        int r133 = (r129 + r132) * 31;
        boolean r134 = this.isMute;
        ?? r135 = r134;
        if (r134 == false) goto L44;
        r135 = 1;
    L44:
        int r136 = (r133 + r135) * 31;
        boolean r137 = this.autoPlayForBiz;
        if (r137 == true) goto L48;
        r131 = r137;
    L48:
        int r138 = (r136 + r131) * 31;
        String r139 = this.itemId;
        if (r139 == null) goto L51;
        int r140 = r139.hashCode();
    L52:
        int r141 = (r138 + r140) * 31;
        u1 r142 = this.extraInfo;
        if (r142 == null) goto L56;
        r101 = r142.hashCode();
    L56:
        return r141 + r101;
    L51:
        r140 = 0;
        goto L52
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
        return "VideoModel(vid=" + this.vid + ", mainUrl=" + this.mainUrl + ", backupUrl=" + this.backupUrl + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", urlExpire=" + this.urlExpire + ", posterImage=" + this.posterImage + ", sourceType=" + this.sourceType + ", playMeta=" + this.playMeta + ", posterUrl=" + this.posterUrl + ", initialStartTimeMs=" + this.initialStartTimeMs + ", autoPlay=" + this.autoPlay + ", isMute=" + this.isMute + ", autoPlayForBiz=" + this.autoPlayForBiz + ", itemId=" + this.itemId + ", extraInfo=" + this.extraInfo + ")";
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final boolean getAutoPlayForBiz() {
        return this.autoPlayForBiz;
    }

    public final String getBackupUrl() {
        return this.backupUrl;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final u1 getExtraInfo() {
        return this.extraInfo;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getInitialStartTimeMs() {
        return this.initialStartTimeMs;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final ECPDPBaseVideo getPlayMeta() {
        return this.playMeta;
    }

    public final ImageModel getPosterImage() {
        return this.posterImage;
    }

    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final Integer getUrlExpire() {
        return this.urlExpire;
    }

    public final String getVid() {
        return this.vid;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isMute() {
        return this.isMute;
    }

    public final void setAutoPlay(boolean r100) {
        this.autoPlay = r100;
    }

    public final void setAutoPlayForBiz(boolean r100) {
        this.autoPlayForBiz = r100;
    }

    public final void setInitialStartTimeMs(long r100) {
        this.initialStartTimeMs = r100;
    }

    public final void setMute(boolean r100) {
        this.isMute = r100;
    }

    public VideoModel(String r100, String r101, String r102, int r103, int r104, Integer r105, Integer r110, ImageModel r111, Integer r112, ECPDPBaseVideo r113, String r114, long r115, boolean r116, boolean r117, boolean r118, String r210, u1 r211) {
        this.vid = r100;
        this.mainUrl = r101;
        this.backupUrl = r102;
        this.width = r103;
        this.height = r104;
        this.duration = r105;
        this.urlExpire = r110;
        this.posterImage = r111;
        this.sourceType = r112;
        this.playMeta = r113;
        this.posterUrl = r114;
        this.initialStartTimeMs = r115;
        this.autoPlay = r116;
        this.isMute = r117;
        this.autoPlayForBiz = r118;
        this.itemId = r210;
        this.extraInfo = r211;
    }

    public /* synthetic */ VideoModel(String r210, String r211, String r212, int r213, int r214, Integer r215, Integer r216, ImageModel r217, Integer r218, ECPDPBaseVideo r219, String r310, long r311, boolean r312, boolean r313, boolean r314, String r315, u1 r316, int r317, DefaultConstructorMarker r318) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r317 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r317 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r317 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r317 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r317 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r317 & 128) == 0) goto L33;
        ImageModel r110 = null;
    L35:
        if ((r317 & 256) == 0) goto L37;
        Integer r111 = null;
    L39:
        if ((r317 & 512) == 0) goto L41;
        ECPDPBaseVideo r112 = null;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        long r114 = 0;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        boolean r107 = false;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        boolean r108 = true;
    L58:
        boolean r115 = r108;
        if ((r317 & 16384) == 0) goto L61;
        boolean r109 = false;
    L63:
        if ((r317 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r317 & 65536) == 0) goto L69;
        u1 r117 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r115, r109, r116, r117);
        return;
    L69:
        r117 = r316;
        goto L70
    L65:
        r116 = r315;
        goto L67
    L61:
        r109 = r314;
        goto L63
    L57:
        r108 = r313;
        goto L58
    L53:
        r107 = r312;
        goto L55
    L49:
        r114 = r311;
        goto L51
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r219;
        goto L43
    L37:
        r111 = r218;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
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

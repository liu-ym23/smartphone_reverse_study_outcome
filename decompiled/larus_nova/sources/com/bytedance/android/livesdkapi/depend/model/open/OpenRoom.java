package com.bytedance.android.livesdkapi.depend.model.open;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IBaseRoom;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0015HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0015HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010C\u001a\u00020\nHÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0003J\t\u0010E\u001a\u00020\nHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010G\u001a\u00020\u0011HÆ\u0003JÊ\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\u00152\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\nHÖ\u0001J\t\u0010M\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010'\"\u0004\b*\u0010+R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/open/OpenRoom;", "", "owner", "Lcom/bytedance/android/livesdkapi/depend/model/open/OpenUser;", "title", "", "contentLabel", "Lcom/bytedance/android/live/base/model/ImageModel;", "operationLabel", "status", "", "coverUrls", "", "audienceCount", "streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "id", "", "resId", "logPb", "enableDislike", "", "type", "adRawString", "isPseudoLiving", "baseRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IBaseRoom;", "(Lcom/bytedance/android/livesdkapi/depend/model/open/OpenUser;Ljava/lang/String;Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/live/base/model/ImageModel;ILjava/util/List;ILcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;ZLcom/bytedance/android/livesdkapi/depend/model/live/abs/IBaseRoom;)V", "getAdRawString", "()Ljava/lang/String;", "getAudienceCount", "()I", "getBaseRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IBaseRoom;", "getContentLabel", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getCoverUrls", "()Ljava/util/List;", "getEnableDislike", "()Z", "getId", "()J", "setPseudoLiving", "(Z)V", "getLogPb", "getOperationLabel", "getOwner", "()Lcom/bytedance/android/livesdkapi/depend/model/open/OpenUser;", "getResId", "getStatus", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "getTitle", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/livesdkapi/depend/model/open/OpenUser;Ljava/lang/String;Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/live/base/model/ImageModel;ILjava/util/List;ILcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;ZLcom/bytedance/android/livesdkapi/depend/model/live/abs/IBaseRoom;)Lcom/bytedance/android/livesdkapi/depend/model/open/OpenRoom;", "equals", "other", "hashCode", "toString", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenRoom {

    @SerializedName("ad")
    private final String adRawString;

    @SerializedName("audience_count")
    private final int audienceCount;
    private final transient IBaseRoom baseRoom;

    @SerializedName("content_label")
    private final ImageModel contentLabel;

    @SerializedName("cover")
    private final List<String> coverUrls;

    @SerializedName("enable_dislike")
    private final boolean enableDislike;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f162627id;

    @SerializedName("is_pseudo_living")
    private boolean isPseudoLiving;

    @SerializedName("log_pb")
    private final String logPb;

    @SerializedName("operation_label")
    private final ImageModel operationLabel;

    @SerializedName("owner")
    private final OpenUser owner;

    @SerializedName("request_id")
    private final String resId;

    @SerializedName("status")
    private final int status;

    @SerializedName("stream_url")
    private final StreamUrl streamUrl;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final Integer type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenRoom copy$default(OpenRoom r110, OpenUser r111, String r112, ImageModel r210, ImageModel r211, int r212, List r213, int r214, StreamUrl r215, long r216, String r217, String r218, boolean r310, Integer r311, String r312, boolean r313, IBaseRoom r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        OpenUser r100 = r110.owner;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r315 & 4) == 0) goto L13;
        ImageModel r102 = r110.contentLabel;
    L15:
        if ((r315 & 8) == 0) goto L17;
        ImageModel r103 = r110.operationLabel;
    L19:
        if ((r315 & 16) == 0) goto L21;
        int r104 = r110.status;
    L23:
        if ((r315 & 32) == 0) goto L25;
        List r105 = r110.coverUrls;
    L27:
        if ((r315 & 64) == 0) goto L29;
        int r106 = r110.audienceCount;
    L31:
        if ((r315 & 128) == 0) goto L33;
        StreamUrl r107 = r110.streamUrl;
    L35:
        if ((r315 & 256) == 0) goto L37;
        long r113 = r110.f162627id;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r114 = r110.resId;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r110.logPb;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        boolean r116 = r110.enableDislike;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        Integer r117 = r110.type;
    L54:
        Integer r317 = r117;
        if ((r315 & 8192) == 0) goto L57;
        String r118 = r110.adRawString;
    L58:
        String r318 = r118;
        if ((r315 & 16384) == 0) goto L61;
        boolean r119 = r110.isPseudoLiving;
    L63:
        if ((r315 & 32768) == 0) goto L65;
        IBaseRoom r108 = r110.baseRoom;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r317, r318, r119, r108);
    L65:
        r108 = r314;
        goto L67
    L61:
        r119 = r313;
        goto L63
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
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

    public final OpenUser component1() {
        return this.owner;
    }

    public final String component10() {
        return this.resId;
    }

    public final String component11() {
        return this.logPb;
    }

    public final boolean component12() {
        return this.enableDislike;
    }

    public final Integer component13() {
        return this.type;
    }

    public final String component14() {
        return this.adRawString;
    }

    public final boolean component15() {
        return this.isPseudoLiving;
    }

    public final IBaseRoom component16() {
        return this.baseRoom;
    }

    public final String component2() {
        return this.title;
    }

    public final ImageModel component3() {
        return this.contentLabel;
    }

    public final ImageModel component4() {
        return this.operationLabel;
    }

    public final int component5() {
        return this.status;
    }

    public final List<String> component6() {
        return this.coverUrls;
    }

    public final int component7() {
        return this.audienceCount;
    }

    public final StreamUrl component8() {
        return this.streamUrl;
    }

    public final long component9() {
        return this.f162627id;
    }

    public final OpenRoom copy(OpenUser r210, String r211, ImageModel r212, ImageModel r213, int r214, List<String> r215, int r216, StreamUrl r217, long r218, String r310, String r311, boolean r312, Integer r313, String r314, boolean r315, IBaseRoom r316) {
        return new OpenRoom(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OpenRoom) == false) goto L38;
        OpenRoom r101 = (OpenRoom) r100;
        if (Intrinsics.areEqual(this.owner, r101.owner) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.contentLabel, r101.contentLabel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.operationLabel, r101.operationLabel) == true) goto L14;
        return false;
    L14:
        if (this.status == r101.status) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.coverUrls, r101.coverUrls) == true) goto L18;
        return false;
    L18:
        if (this.audienceCount == r101.audienceCount) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.streamUrl, r101.streamUrl) == true) goto L22;
        return false;
    L22:
        if (this.f162627id == r101.f162627id) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resId, r101.resId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.logPb, r101.logPb) == true) goto L28;
        return false;
    L28:
        if (this.enableDislike == r101.enableDislike) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.adRawString, r101.adRawString) == true) goto L34;
        return false;
    L34:
        if (this.isPseudoLiving == r101.isPseudoLiving) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.baseRoom, r101.baseRoom) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        OpenUser r100 = this.owner;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageModel r107 = this.contentLabel;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ImageModel r110 = this.operationLabel;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.status) * 31;
        List<String> r113 = this.coverUrls;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + this.audienceCount) * 31;
        StreamUrl r116 = this.streamUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        long r119 = this.f162627id;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        String r121 = this.resId;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.logPb;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        boolean r127 = this.enableDislike;
        ?? r128 = 1;
        ?? r129 = r127;
        if (r127 == false) goto L37;
        r129 = 1;
    L37:
        int r130 = (r126 + r129) * 31;
        Integer r131 = this.type;
        if (r131 == null) goto L40;
        int r132 = r131.hashCode();
    L41:
        int r133 = (r130 + r132) * 31;
        String r134 = this.adRawString;
        if (r134 == null) goto L44;
        int r135 = r134.hashCode();
    L45:
        int r136 = (r133 + r135) * 31;
        boolean r137 = this.isPseudoLiving;
        if (r137 == true) goto L49;
        r128 = r137;
    L49:
        int r138 = (r136 + r128) * 31;
        IBaseRoom r139 = this.baseRoom;
        if (r139 == null) goto L53;
        r101 = r139.hashCode();
    L53:
        return r138 + r101;
    L44:
        r135 = 0;
        goto L45
    L40:
        r132 = 0;
        goto L41
    L33:
        r125 = 0;
        goto L34
    L29:
        r122 = 0;
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
        return "OpenRoom(owner=" + this.owner + ", title=" + this.title + ", contentLabel=" + this.contentLabel + ", operationLabel=" + this.operationLabel + ", status=" + this.status + ", coverUrls=" + this.coverUrls + ", audienceCount=" + this.audienceCount + ", streamUrl=" + this.streamUrl + ", id=" + this.f162627id + ", resId=" + this.resId + ", logPb=" + this.logPb + ", enableDislike=" + this.enableDislike + ", type=" + this.type + ", adRawString=" + this.adRawString + ", isPseudoLiving=" + this.isPseudoLiving + ", baseRoom=" + this.baseRoom + ")";
    }

    public final String getAdRawString() {
        return this.adRawString;
    }

    public final int getAudienceCount() {
        return this.audienceCount;
    }

    public final IBaseRoom getBaseRoom() {
        return this.baseRoom;
    }

    public final ImageModel getContentLabel() {
        return this.contentLabel;
    }

    public final List<String> getCoverUrls() {
        return this.coverUrls;
    }

    public final boolean getEnableDislike() {
        return this.enableDislike;
    }

    public final long getId() {
        return this.f162627id;
    }

    public final String getLogPb() {
        return this.logPb;
    }

    public final ImageModel getOperationLabel() {
        return this.operationLabel;
    }

    public final OpenUser getOwner() {
        return this.owner;
    }

    public final String getResId() {
        return this.resId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final StreamUrl getStreamUrl() {
        return this.streamUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final boolean isPseudoLiving() {
        return this.isPseudoLiving;
    }

    public final void setPseudoLiving(boolean r100) {
        this.isPseudoLiving = r100;
    }

    public OpenRoom(OpenUser r100, String r101, ImageModel r102, ImageModel r103, int r104, List<String> r105, int r110, StreamUrl r111, long r112, String r113, String r114, boolean r115, Integer r116, String r117, boolean r118, IBaseRoom r210) {
        this.owner = r100;
        this.title = r101;
        this.contentLabel = r102;
        this.operationLabel = r103;
        this.status = r104;
        this.coverUrls = r105;
        this.audienceCount = r110;
        this.streamUrl = r111;
        this.f162627id = r112;
        this.resId = r113;
        this.logPb = r114;
        this.enableDislike = r115;
        this.type = r116;
        this.adRawString = r117;
        this.isPseudoLiving = r118;
        this.baseRoom = r210;
    }
}

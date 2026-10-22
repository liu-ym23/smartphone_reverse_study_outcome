package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0012\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0002¢\u0006\u0004\bT\u0010UJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0012HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0012HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0002HÆ\u0003JË\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00122\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u0002HÆ\u0001J\t\u00100\u001a\u00020\u000eHÖ\u0001J\t\u00101\u001a\u00020\u0012HÖ\u0001J\u0013\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b6\u00107R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b8\u00107R\u001c\u0010 \u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00109\u001a\u0004\b:\u0010;R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010$\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bE\u0010DR\u001a\u0010%\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010?\u001a\u0004\bI\u0010AR\u001c\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010?\u001a\u0004\bJ\u0010AR\u001a\u0010(\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\bK\u0010DR\u001a\u0010)\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010F\u001a\u0004\bL\u0010HR\u001a\u0010*\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010B\u001a\u0004\bM\u0010DR\u001c\u0010+\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010?\u001a\u0004\bQ\u0010AR\u001a\u0010-\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010F\u001a\u0004\bR\u0010HR\u001a\u0010.\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010B\u001a\u0004\bS\u0010D¨\u0006V"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "Ljava/io/Serializable;", "", "withPreview", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImageUrl", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "component1", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component3", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaPreviewModel;", "component4", "", "component5", "component6", "component7", "", "component8", "component9", "component10", "component11", "component12", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;", "component14", "component15", "component16", "component17", "video", "previewVideo", "image", "previewList", "previewImageUrl", "supportPreview", "supportThumbList", "previewType", "findSameUrl", "findSameUrlForScreenShot", "supportNavBlur", "previewIndex", "videoButtonNewStyle", "videoInteractor", "imageScaleType", "fillMode", "disableNavDecor", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getPreviewVideo", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getImage", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "Ljava/util/List;", "getPreviewList", "()Ljava/util/List;", "Ljava/lang/String;", "getPreviewImageUrl", "()Ljava/lang/String;", "Z", "getSupportPreview", "()Z", "getSupportThumbList", "I", "getPreviewType", "()I", "getFindSameUrl", "getFindSameUrlForScreenShot", "getSupportNavBlur", "getPreviewIndex", "getVideoButtonNewStyle", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;", "getVideoInteractor", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;", "getImageScaleType", "getFillMode", "getDisableNavDecor", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/util/List;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;ZIZLcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;Ljava/lang/String;IZ)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderMediaModel implements Serializable {

    @SerializedName("disable_nav_decor")
    private final boolean disableNavDecor;

    @SerializedName("fill_mode")
    private final int fillMode;

    @SerializedName("find_same_url")
    private final String findSameUrl;

    @SerializedName("find_same_url_v2")
    private final String findSameUrlForScreenShot;

    @SerializedName("image")
    private final ImageModel image;

    @SerializedName("image_scale_type")
    private final String imageScaleType;

    @SerializedName("pre_image_url")
    private final String previewImageUrl;

    @SerializedName("preview_index")
    private final int previewIndex;

    @SerializedName("preview_list")
    private final List<HeaderMediaPreviewModel> previewList;

    @SerializedName("preview_type")
    private final int previewType;

    @SerializedName("preview_video")
    private final VideoModel previewVideo;

    @SerializedName("support_nav_blur")
    private final boolean supportNavBlur;

    @SerializedName("support_preview")
    private final boolean supportPreview;

    @SerializedName("support_thumb_list")
    private final boolean supportThumbList;

    @SerializedName("video")
    private final VideoModel video;

    @SerializedName("video_button_new_style")
    private final boolean videoButtonNewStyle;

    @SerializedName("video_lynx_interactor")
    private final n videoInteractor;

    public HeaderMediaModel() {
        this(null, null, null, null, null, false, false, 0, null, null, false, 0, false, null, null, 0, false, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderMediaModel copy$default(HeaderMediaModel r110, VideoModel r111, VideoModel r112, ImageModel r210, List r211, String r212, boolean r213, boolean r214, int r215, String r216, String r217, boolean r218, int r219, boolean r310, n r311, String r312, int r313, boolean r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        VideoModel r100 = r110.video;
    L7:
        if ((r315 & 2) == 0) goto L9;
        VideoModel r101 = r110.previewVideo;
    L11:
        if ((r315 & 4) == 0) goto L13;
        ImageModel r102 = r110.image;
    L15:
        if ((r315 & 8) == 0) goto L17;
        List r103 = r110.previewList;
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r104 = r110.previewImageUrl;
    L23:
        if ((r315 & 32) == 0) goto L25;
        boolean r105 = r110.supportPreview;
    L27:
        if ((r315 & 64) == 0) goto L29;
        boolean r106 = r110.supportThumbList;
    L31:
        if ((r315 & 128) == 0) goto L33;
        int r107 = r110.previewType;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r113 = r110.findSameUrl;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r114 = r110.findSameUrlForScreenShot;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        boolean r115 = r110.supportNavBlur;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        int r116 = r110.previewIndex;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        boolean r117 = r110.videoButtonNewStyle;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        n r118 = r110.videoInteractor;
    L58:
        n r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        String r119 = r110.imageScaleType;
    L62:
        String r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        int r120 = r110.fillMode;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        boolean r108 = r110.disableNavDecor;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
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
        goto L55
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

    public final VideoModel component1() {
        return this.video;
    }

    public final String component10() {
        return this.findSameUrlForScreenShot;
    }

    public final boolean component11() {
        return this.supportNavBlur;
    }

    public final int component12() {
        return this.previewIndex;
    }

    public final boolean component13() {
        return this.videoButtonNewStyle;
    }

    public final n component14() {
        return this.videoInteractor;
    }

    public final String component15() {
        return this.imageScaleType;
    }

    public final int component16() {
        return this.fillMode;
    }

    public final boolean component17() {
        return this.disableNavDecor;
    }

    public final VideoModel component2() {
        return this.previewVideo;
    }

    public final ImageModel component3() {
        return this.image;
    }

    public final List<HeaderMediaPreviewModel> component4() {
        return this.previewList;
    }

    public final String component5() {
        return this.previewImageUrl;
    }

    public final boolean component6() {
        return this.supportPreview;
    }

    public final boolean component7() {
        return this.supportThumbList;
    }

    public final int component8() {
        return this.previewType;
    }

    public final String component9() {
        return this.findSameUrl;
    }

    public final HeaderMediaModel copy(VideoModel r210, VideoModel r211, ImageModel r212, List<HeaderMediaPreviewModel> r213, String r214, boolean r215, boolean r216, int r217, String r218, String r219, boolean r310, int r311, boolean r312, n r313, String r314, int r315, boolean r316) {
        return new HeaderMediaModel(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderMediaModel) == false) goto L40;
        HeaderMediaModel r101 = (HeaderMediaModel) r100;
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.previewVideo, r101.previewVideo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewList, r101.previewList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.previewImageUrl, r101.previewImageUrl) == true) goto L16;
        return false;
    L16:
        if (this.supportPreview == r101.supportPreview) goto L18;
        return false;
    L18:
        if (this.supportThumbList == r101.supportThumbList) goto L20;
        return false;
    L20:
        if (this.previewType == r101.previewType) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.findSameUrl, r101.findSameUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.findSameUrlForScreenShot, r101.findSameUrlForScreenShot) == true) goto L26;
        return false;
    L26:
        if (this.supportNavBlur == r101.supportNavBlur) goto L28;
        return false;
    L28:
        if (this.previewIndex == r101.previewIndex) goto L30;
        return false;
    L30:
        if (this.videoButtonNewStyle == r101.videoButtonNewStyle) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.videoInteractor, r101.videoInteractor) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.imageScaleType, r101.imageScaleType) == true) goto L36;
        return false;
    L36:
        if (this.fillMode == r101.fillMode) goto L38;
        return false;
    L38:
        if (this.disableNavDecor == r101.disableNavDecor) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        VideoModel r100 = this.video;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        VideoModel r104 = this.previewVideo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageModel r107 = this.image;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<HeaderMediaPreviewModel> r110 = this.previewList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.previewImageUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.supportPreview;
        ?? r117 = 1;
        ?? r118 = r116;
        if (r116 == false) goto L25;
        r118 = 1;
    L25:
        int r119 = (r115 + r118) * 31;
        boolean r120 = this.supportThumbList;
        ?? r121 = r120;
        if (r120 == false) goto L28;
        r121 = 1;
    L28:
        int r122 = (((r119 + r121) * 31) + this.previewType) * 31;
        String r123 = this.findSameUrl;
        if (r123 == null) goto L31;
        int r124 = r123.hashCode();
    L32:
        int r125 = (r122 + r124) * 31;
        String r126 = this.findSameUrlForScreenShot;
        if (r126 == null) goto L35;
        int r127 = r126.hashCode();
    L36:
        int r128 = (r125 + r127) * 31;
        boolean r129 = this.supportNavBlur;
        ?? r130 = r129;
        if (r129 == false) goto L39;
        r130 = 1;
    L39:
        int r131 = (((r128 + r130) * 31) + this.previewIndex) * 31;
        boolean r132 = this.videoButtonNewStyle;
        ?? r133 = r132;
        if (r132 == false) goto L42;
        r133 = 1;
    L42:
        int r134 = (r131 + r133) * 31;
        n r135 = this.videoInteractor;
        if (r135 == null) goto L45;
        int r136 = r135.hashCode();
    L46:
        int r137 = (r134 + r136) * 31;
        String r138 = this.imageScaleType;
        if (r138 == null) goto L49;
        r101 = r138.hashCode();
    L49:
        int r139 = (((r137 + r101) * 31) + this.fillMode) * 31;
        boolean r140 = this.disableNavDecor;
        if (r140 == true) goto L54;
        r117 = r140;
    L54:
        return r139 + r117;
    L45:
        r136 = 0;
        goto L46
    L35:
        r127 = 0;
        goto L36
    L31:
        r124 = 0;
        goto L32
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
        return "HeaderMediaModel(video=" + this.video + ", previewVideo=" + this.previewVideo + ", image=" + this.image + ", previewList=" + this.previewList + ", previewImageUrl=" + this.previewImageUrl + ", supportPreview=" + this.supportPreview + ", supportThumbList=" + this.supportThumbList + ", previewType=" + this.previewType + ", findSameUrl=" + this.findSameUrl + ", findSameUrlForScreenShot=" + this.findSameUrlForScreenShot + ", supportNavBlur=" + this.supportNavBlur + ", previewIndex=" + this.previewIndex + ", videoButtonNewStyle=" + this.videoButtonNewStyle + ", videoInteractor=" + this.videoInteractor + ", imageScaleType=" + this.imageScaleType + ", fillMode=" + this.fillMode + ", disableNavDecor=" + this.disableNavDecor + ")";
    }

    public final boolean getDisableNavDecor() {
        return this.disableNavDecor;
    }

    public final int getFillMode() {
        return this.fillMode;
    }

    public final String getFindSameUrl() {
        return this.findSameUrl;
    }

    public final String getFindSameUrlForScreenShot() {
        return this.findSameUrlForScreenShot;
    }

    public final ImageModel getImage() {
        return this.image;
    }

    public final String getImageScaleType() {
        return this.imageScaleType;
    }

    public final String getPreviewImageUrl() {
        return this.previewImageUrl;
    }

    public final int getPreviewIndex() {
        return this.previewIndex;
    }

    public final List<HeaderMediaPreviewModel> getPreviewList() {
        return this.previewList;
    }

    public final int getPreviewType() {
        return this.previewType;
    }

    public final VideoModel getPreviewVideo() {
        return this.previewVideo;
    }

    public final boolean getSupportNavBlur() {
        return this.supportNavBlur;
    }

    public final boolean getSupportPreview() {
        return this.supportPreview;
    }

    public final boolean getSupportThumbList() {
        return this.supportThumbList;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public final boolean getVideoButtonNewStyle() {
        return this.videoButtonNewStyle;
    }

    public final n getVideoInteractor() {
        return this.videoInteractor;
    }

    public final ECUrlModel getImageUrl(boolean r100) {
        if (r100 == false) goto L11;
        ImageModel r101 = this.image;
        if (r101 == null) goto L7;
        ECUrlModel r102 = r101.getPreview();
    L8:
        if (r102 == null) goto L11;
        return this.image.getPreview();
    L7:
        r102 = null;
    L11:
        ImageModel r103 = this.image;
        if (r103 != null) goto L20;
        VideoModel r104 = this.video;
        if (r104 == null) goto L21;
        ImageModel r105 = r104.getPosterImage();
        if (r105 != null) goto L19;
        return null;
    L19:
        return r105.getRemote();
    L21:
        return null;
    L20:
        return r103.getRemote();
    }

    public static /* synthetic */ ECUrlModel getImageUrl$default(HeaderMediaModel r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return r100.getImageUrl(r101);
    }

    public HeaderMediaModel(VideoModel r100, VideoModel r101, ImageModel r102, List<HeaderMediaPreviewModel> r103, String r104, boolean r105, boolean r106, int r110, String r111, String r112, boolean r113, int r114, boolean r115, n r116, String r117, int r118, boolean r119) {
        this.video = r100;
        this.previewVideo = r101;
        this.image = r102;
        this.previewList = r103;
        this.previewImageUrl = r104;
        this.supportPreview = r105;
        this.supportThumbList = r106;
        this.previewType = r110;
        this.findSameUrl = r111;
        this.findSameUrlForScreenShot = r112;
        this.supportNavBlur = r113;
        this.previewIndex = r114;
        this.videoButtonNewStyle = r115;
        this.videoInteractor = r116;
        this.imageScaleType = r117;
        this.fillMode = r118;
        this.disableNavDecor = r119;
    }

    public /* synthetic */ HeaderMediaModel(VideoModel r110, VideoModel r210, ImageModel r211, List r212, String r213, boolean r214, boolean r215, int r216, String r217, String r218, boolean r219, int r310, boolean r311, n r312, String r313, int r314, boolean r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        VideoModel r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        VideoModel r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        ImageModel r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r316 & 64) == 0) goto L29;
        boolean r106 = false;
    L31:
        if ((r316 & 128) == 0) goto L33;
        int r111 = 0;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        boolean r114 = false;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        int r115 = 0;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        boolean r116 = false;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        n r107 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        int r117 = 0;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        boolean r109 = false;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r111, r112, r113, r114, r115, r116, r107, r108, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r107 = r312;
        goto L59
    L53:
        r116 = r311;
        goto L55
    L49:
        r115 = r310;
        goto L51
    L45:
        r114 = r219;
        goto L47
    L41:
        r113 = r218;
        goto L43
    L37:
        r112 = r217;
        goto L39
    L33:
        r111 = r216;
        goto L35
    L29:
        r106 = r215;
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
        r100 = r110;
        goto L7
    }
}

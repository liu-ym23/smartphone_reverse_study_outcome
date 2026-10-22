package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.AnchorV4KolEvaluationBusinessMeta;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b<\u0010=J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0099\u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\t\u0010\u001f\u001a\u00020\u000fHÖ\u0001J\t\u0010!\u001a\u00020 HÖ\u0001J\u0013\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b,\u0010+R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b-\u0010+R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b.\u0010+R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u00104R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\b6\u00107R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b8\u00101R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/HeadBusinessMeta;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "component1", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "component2", "component3", "component4", "component5", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component6", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/f;", "component7", "", "", "component8", "component9", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "component10", "video", "link3D", "linkAR", "replayLink", "liveLink", "imageList", "combinationMeta", "accessLabel", "specIdList", "kolMeta", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getLink3D", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getLinkAR", "getReplayLink", "getLiveLink", "Ljava/util/List;", "getImageList", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/f;", "getCombinationMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/f;", "Ljava/util/Map;", "getAccessLabel", "()Ljava/util/Map;", "getSpecIdList", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "getKolMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/f;Ljava/util/Map;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadBusinessMeta implements Serializable {

    @SerializedName("access_label")
    private final Map<String, String> accessLabel;

    @SerializedName("combination_meta")
    private final f combinationMeta;

    @SerializedName("image_list")
    private final List<ImageModel> imageList;

    @SerializedName("kol_meta_struct")
    private final AnchorV4KolEvaluationBusinessMeta kolMeta;

    @SerializedName("entry_3d_link")
    private final Link link3D;

    @SerializedName("entry_ar_link")
    private final Link linkAR;

    @SerializedName("live_link")
    private final Link liveLink;

    @SerializedName("replay_link")
    private final Link replayLink;

    @SerializedName("spec_id_list")
    private final List<String> specIdList;

    @SerializedName("video")
    private final VideoModel video;

    public HeadBusinessMeta() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeadBusinessMeta copy$default(HeadBusinessMeta r110, VideoModel r111, Link r112, Link r113, Link r114, Link r115, List r116, f r117, Map r118, List r210, AnchorV4KolEvaluationBusinessMeta r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        VideoModel r100 = r110.video;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Link r101 = r110.link3D;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Link r102 = r110.linkAR;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Link r103 = r110.replayLink;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Link r104 = r110.liveLink;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r105 = r110.imageList;
    L27:
        if ((r212 & 64) == 0) goto L29;
        f r106 = r110.combinationMeta;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Map r107 = r110.accessLabel;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r119 = r110.specIdList;
    L39:
        if ((r212 & 512) == 0) goto L41;
        AnchorV4KolEvaluationBusinessMeta r108 = r110.kolMeta;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
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

    public final VideoModel component1() {
        return this.video;
    }

    public final AnchorV4KolEvaluationBusinessMeta component10() {
        return this.kolMeta;
    }

    public final Link component2() {
        return this.link3D;
    }

    public final Link component3() {
        return this.linkAR;
    }

    public final Link component4() {
        return this.replayLink;
    }

    public final Link component5() {
        return this.liveLink;
    }

    public final List<ImageModel> component6() {
        return this.imageList;
    }

    public final f component7() {
        return this.combinationMeta;
    }

    public final Map<String, String> component8() {
        return this.accessLabel;
    }

    public final List<String> component9() {
        return this.specIdList;
    }

    public final HeadBusinessMeta copy(VideoModel r110, Link r111, Link r112, Link r113, Link r114, List<ImageModel> r115, f r116, Map<String, String> r210, List<String> r211, AnchorV4KolEvaluationBusinessMeta r212) {
        return new HeadBusinessMeta(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeadBusinessMeta) == false) goto L26;
        HeadBusinessMeta r101 = (HeadBusinessMeta) r100;
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.link3D, r101.link3D) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.linkAR, r101.linkAR) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replayLink, r101.replayLink) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveLink, r101.liveLink) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.imageList, r101.imageList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.combinationMeta, r101.combinationMeta) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.accessLabel, r101.accessLabel) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.specIdList, r101.specIdList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.kolMeta, r101.kolMeta) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        VideoModel r100 = this.video;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Link r104 = this.link3D;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Link r107 = this.linkAR;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Link r110 = this.replayLink;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Link r113 = this.liveLink;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<ImageModel> r116 = this.imageList;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        f r119 = this.combinationMeta;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.accessLabel;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<String> r125 = this.specIdList;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        AnchorV4KolEvaluationBusinessMeta r128 = this.kolMeta;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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
        return "HeadBusinessMeta(video=" + this.video + ", link3D=" + this.link3D + ", linkAR=" + this.linkAR + ", replayLink=" + this.replayLink + ", liveLink=" + this.liveLink + ", imageList=" + this.imageList + ", combinationMeta=" + this.combinationMeta + ", accessLabel=" + this.accessLabel + ", specIdList=" + this.specIdList + ", kolMeta=" + this.kolMeta + ")";
    }

    public final Map<String, String> getAccessLabel() {
        return this.accessLabel;
    }

    public final f getCombinationMeta() {
        return this.combinationMeta;
    }

    public final List<ImageModel> getImageList() {
        return this.imageList;
    }

    public final AnchorV4KolEvaluationBusinessMeta getKolMeta() {
        return this.kolMeta;
    }

    public final Link getLink3D() {
        return this.link3D;
    }

    public final Link getLinkAR() {
        return this.linkAR;
    }

    public final Link getLiveLink() {
        return this.liveLink;
    }

    public final Link getReplayLink() {
        return this.replayLink;
    }

    public final List<String> getSpecIdList() {
        return this.specIdList;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public HeadBusinessMeta(VideoModel r100, Link r101, Link r102, Link r103, Link r104, List<ImageModel> r105, f r106, Map<String, String> r107, List<String> r108, AnchorV4KolEvaluationBusinessMeta r110) {
        this.video = r100;
        this.link3D = r101;
        this.linkAR = r102;
        this.replayLink = r103;
        this.liveLink = r104;
        this.imageList = r105;
        this.combinationMeta = r106;
        this.accessLabel = r107;
        this.specIdList = r108;
        this.kolMeta = r110;
    }

    public /* synthetic */ HeadBusinessMeta(VideoModel r110, Link r111, Link r112, Link r113, Link r114, List r115, f r116, Map r117, List r210, AnchorV4KolEvaluationBusinessMeta r211, int r212, DefaultConstructorMarker r213) {
        AnchorV4KolEvaluationBusinessMeta r100 = null;
        if ((r212 & 1) == 0) goto L5;
        VideoModel r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Link r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Link r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Link r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Link r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        f r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Map r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
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

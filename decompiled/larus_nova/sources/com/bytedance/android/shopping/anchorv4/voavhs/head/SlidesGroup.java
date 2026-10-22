package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.vo.CommentVideoInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0018\u0012\u0012\b\u0002\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u00102\u001a\u00020\u0014\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010!¢\u0006\u0004\bi\u0010jJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\t\u0010 \u001a\u00020\u0014HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003Jæ\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00182\u0012\b\u0002\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\n2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u00102\u001a\u00020\u00142\n\b\u0002\u00103\u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0004\b4\u00105J\t\u00106\u001a\u00020\u0004HÖ\u0001J\t\u00107\u001a\u00020\u0006HÖ\u0001J\u0013\u0010:\u001a\u00020\u00142\b\u00109\u001a\u0004\u0018\u000108HÖ\u0003R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010$\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010%\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010&\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bE\u0010FR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010(\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010J\u001a\u0004\bK\u0010LR\u001c\u0010)\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010*\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010P\u001a\u0004\bQ\u0010RR\u001c\u0010+\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010,\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010V\u001a\u0004\bW\u0010\u0016R\u001c\u0010-\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010>\u001a\u0004\bX\u0010@R\u001c\u0010.\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010Y\u001a\u0004\bZ\u0010[R$\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010G\u001a\u0004\b\\\u0010IR\u001c\u00100\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010]\u001a\u0004\b^\u0010_R\u001c\u00101\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010`\u001a\u0004\ba\u0010bR\u001a\u00102\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010c\u001a\u0004\bd\u0010eR\u001c\u00103\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010f\u001a\u0004\bg\u0010h¨\u0006k"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/SlidesGroup;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "component1", "", "component2", "", "component3", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "component4", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component5", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;", "component6", "component7", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;", "component8", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;", "component9", "", "component10", "()Ljava/lang/Boolean;", "component11", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "component12", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/KolReviewElement;", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "component14", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;", "component15", "component16", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/p;", "component17", "title", "tabTypeName", "type", "video", "images", "combinationElement", "entryIcon", "headCommentInfo", "goodGoodsComment", "supportPreview", "findSameGoodsSchema", "findSameGoodsTab", "pioneerElement", "backgroundControl", "kolAuthorInfo", "supportKolVideoDetail", "slice", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/lang/String;ILcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;ZLcom/bytedance/android/shopping/anchorv4/voavhs/head/p;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/SlidesGroup;", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "Ljava/lang/String;", "getTabTypeName", "()Ljava/lang/String;", "I", "getType", "()I", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;", "getCombinationElement", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getEntryIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;", "getHeadCommentInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;", "getGoodGoodsComment", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;", "Ljava/lang/Boolean;", "getSupportPreview", "getFindSameGoodsSchema", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameGoodsTab", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getPioneerElement", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "getBackgroundControl", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;", "getKolAuthorInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;", "Z", "getSupportKolVideoDetail", "()Z", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/p;", "getSlice", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/p;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/lang/String;ILcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;ZLcom/bytedance/android/shopping/anchorv4/voavhs/head/p;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlidesGroup implements Serializable {

    @SerializedName("gaussian_config")
    private final GaussianBlurConfig backgroundControl;

    @SerializedName("combination_element")
    private final CombinationElement combinationElement;

    @SerializedName("entry_icon")
    private final ImageModel entryIcon;

    @SerializedName("find_same_goods_schema")
    private final String findSameGoodsSchema;

    @SerializedName("find_same_goods_tab")
    private final CommonFindSameElement findSameGoodsTab;

    @SerializedName("good_goods_comment")
    private final h goodGoodsComment;

    @SerializedName("comment_info")
    private final i headCommentInfo;

    @SerializedName("image_list")
    private final List<ImageModel> images;

    @SerializedName("kol_author_info")
    private final CommentVideoInfo kolAuthorInfo;

    @SerializedName("kol_review_list")
    private final List<KolReviewElement> pioneerElement;

    @SerializedName("slice")
    private final p slice;

    @SerializedName("support_kol_video_detail")
    private final boolean supportKolVideoDetail;

    @SerializedName("support_preview")
    private final Boolean supportPreview;

    @SerializedName("tab_type_name")
    private final String tabTypeName;

    @SerializedName("title")
    private final TextElement title;

    @SerializedName("type")
    private final int type;

    @SerializedName("video_player_box")
    private final VideoModel video;

    public SlidesGroup() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlidesGroup copy$default(SlidesGroup r110, TextElement r111, String r112, int r210, VideoModel r211, List r212, CombinationElement r213, ImageModel r214, i r215, h r216, Boolean r217, String r218, CommonFindSameElement r219, List r310, GaussianBlurConfig r311, CommentVideoInfo r312, boolean r313, p r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        TextElement r100 = r110.title;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.tabTypeName;
    L11:
        if ((r315 & 4) == 0) goto L13;
        int r102 = r110.type;
    L15:
        if ((r315 & 8) == 0) goto L17;
        VideoModel r103 = r110.video;
    L19:
        if ((r315 & 16) == 0) goto L21;
        List r104 = r110.images;
    L23:
        if ((r315 & 32) == 0) goto L25;
        CombinationElement r105 = r110.combinationElement;
    L27:
        if ((r315 & 64) == 0) goto L29;
        ImageModel r106 = r110.entryIcon;
    L31:
        if ((r315 & 128) == 0) goto L33;
        i r107 = r110.headCommentInfo;
    L35:
        if ((r315 & 256) == 0) goto L37;
        h r113 = r110.goodGoodsComment;
    L39:
        if ((r315 & 512) == 0) goto L41;
        Boolean r114 = r110.supportPreview;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r110.findSameGoodsSchema;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        CommonFindSameElement r116 = r110.findSameGoodsTab;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        List r117 = r110.pioneerElement;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        GaussianBlurConfig r118 = r110.backgroundControl;
    L58:
        GaussianBlurConfig r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        CommentVideoInfo r119 = r110.kolAuthorInfo;
    L62:
        CommentVideoInfo r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        boolean r120 = r110.supportKolVideoDetail;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        p r108 = r110.slice;
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

    public final TextElement component1() {
        return this.title;
    }

    public final Boolean component10() {
        return this.supportPreview;
    }

    public final String component11() {
        return this.findSameGoodsSchema;
    }

    public final CommonFindSameElement component12() {
        return this.findSameGoodsTab;
    }

    public final List<KolReviewElement> component13() {
        return this.pioneerElement;
    }

    public final GaussianBlurConfig component14() {
        return this.backgroundControl;
    }

    public final CommentVideoInfo component15() {
        return this.kolAuthorInfo;
    }

    public final boolean component16() {
        return this.supportKolVideoDetail;
    }

    public final p component17() {
        return this.slice;
    }

    public final String component2() {
        return this.tabTypeName;
    }

    public final int component3() {
        return this.type;
    }

    public final VideoModel component4() {
        return this.video;
    }

    public final List<ImageModel> component5() {
        return this.images;
    }

    public final CombinationElement component6() {
        return this.combinationElement;
    }

    public final ImageModel component7() {
        return this.entryIcon;
    }

    public final i component8() {
        return this.headCommentInfo;
    }

    public final h component9() {
        return this.goodGoodsComment;
    }

    public final SlidesGroup copy(TextElement r210, String r211, int r212, VideoModel r213, List<ImageModel> r214, CombinationElement r215, ImageModel r216, i r217, h r218, Boolean r219, String r310, CommonFindSameElement r311, List<KolReviewElement> r312, GaussianBlurConfig r313, CommentVideoInfo r314, boolean r315, p r316) {
        return new SlidesGroup(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SlidesGroup) == false) goto L40;
        SlidesGroup r101 = (SlidesGroup) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tabTypeName, r101.tabTypeName) == true) goto L10;
        return false;
    L10:
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.combinationElement, r101.combinationElement) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entryIcon, r101.entryIcon) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.headCommentInfo, r101.headCommentInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.goodGoodsComment, r101.goodGoodsComment) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.supportPreview, r101.supportPreview) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.findSameGoodsSchema, r101.findSameGoodsSchema) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.findSameGoodsTab, r101.findSameGoodsTab) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pioneerElement, r101.pioneerElement) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.backgroundControl, r101.backgroundControl) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.kolAuthorInfo, r101.kolAuthorInfo) == true) goto L36;
        return false;
    L36:
        if (this.supportKolVideoDetail == r101.supportKolVideoDetail) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.slice, r101.slice) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v57 */
    public int hashCode() {
        TextElement r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabTypeName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.type) * 31;
        VideoModel r107 = this.video;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<ImageModel> r110 = this.images;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        CombinationElement r113 = this.combinationElement;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ImageModel r116 = this.entryIcon;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        i r119 = this.headCommentInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        h r122 = this.goodGoodsComment;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.supportPreview;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.findSameGoodsSchema;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        CommonFindSameElement r131 = this.findSameGoodsTab;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        List<KolReviewElement> r134 = this.pioneerElement;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        GaussianBlurConfig r137 = this.backgroundControl;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        CommentVideoInfo r140 = this.kolAuthorInfo;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        boolean r143 = this.supportKolVideoDetail;
        ?? r144 = r143;
        if (r143 == false) goto L61;
        r144 = 1;
    L61:
        int r145 = (r142 + r144) * 31;
        p r146 = this.slice;
        if (r146 == null) goto L65;
        r101 = r146.hashCode();
    L65:
        return r145 + r101;
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
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
        return "SlidesGroup(title=" + this.title + ", tabTypeName=" + this.tabTypeName + ", type=" + this.type + ", video=" + this.video + ", images=" + this.images + ", combinationElement=" + this.combinationElement + ", entryIcon=" + this.entryIcon + ", headCommentInfo=" + this.headCommentInfo + ", goodGoodsComment=" + this.goodGoodsComment + ", supportPreview=" + this.supportPreview + ", findSameGoodsSchema=" + this.findSameGoodsSchema + ", findSameGoodsTab=" + this.findSameGoodsTab + ", pioneerElement=" + this.pioneerElement + ", backgroundControl=" + this.backgroundControl + ", kolAuthorInfo=" + this.kolAuthorInfo + ", supportKolVideoDetail=" + this.supportKolVideoDetail + ", slice=" + this.slice + ")";
    }

    public final GaussianBlurConfig getBackgroundControl() {
        return this.backgroundControl;
    }

    public final CombinationElement getCombinationElement() {
        return this.combinationElement;
    }

    public final ImageModel getEntryIcon() {
        return this.entryIcon;
    }

    public final String getFindSameGoodsSchema() {
        return this.findSameGoodsSchema;
    }

    public final CommonFindSameElement getFindSameGoodsTab() {
        return this.findSameGoodsTab;
    }

    public final h getGoodGoodsComment() {
        return this.goodGoodsComment;
    }

    public final i getHeadCommentInfo() {
        return this.headCommentInfo;
    }

    public final List<ImageModel> getImages() {
        return this.images;
    }

    public final CommentVideoInfo getKolAuthorInfo() {
        return this.kolAuthorInfo;
    }

    public final List<KolReviewElement> getPioneerElement() {
        return this.pioneerElement;
    }

    public final p getSlice() {
        return this.slice;
    }

    public final boolean getSupportKolVideoDetail() {
        return this.supportKolVideoDetail;
    }

    public final Boolean getSupportPreview() {
        return this.supportPreview;
    }

    public final String getTabTypeName() {
        return this.tabTypeName;
    }

    public final TextElement getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public SlidesGroup(TextElement r100, String r101, int r102, VideoModel r103, List<ImageModel> r104, CombinationElement r105, ImageModel r106, i r110, h r111, Boolean r112, String r113, CommonFindSameElement r114, List<KolReviewElement> r115, GaussianBlurConfig r116, CommentVideoInfo r117, boolean r118, p r119) {
        this.title = r100;
        this.tabTypeName = r101;
        this.type = r102;
        this.video = r103;
        this.images = r104;
        this.combinationElement = r105;
        this.entryIcon = r106;
        this.headCommentInfo = r110;
        this.goodGoodsComment = r111;
        this.supportPreview = r112;
        this.findSameGoodsSchema = r113;
        this.findSameGoodsTab = r114;
        this.pioneerElement = r115;
        this.backgroundControl = r116;
        this.kolAuthorInfo = r117;
        this.supportKolVideoDetail = r118;
        this.slice = r119;
    }

    public /* synthetic */ SlidesGroup(TextElement r110, String r210, int r211, VideoModel r212, List r213, CombinationElement r214, ImageModel r215, i r216, h r217, Boolean r218, String r219, CommonFindSameElement r310, List r311, GaussianBlurConfig r312, CommentVideoInfo r313, boolean r314, p r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        TextElement r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r316 & 8) == 0) goto L17;
        VideoModel r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        CombinationElement r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        ImageModel r106 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        i r111 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        h r112 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Boolean r113 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        CommonFindSameElement r115 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        List r116 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        GaussianBlurConfig r107 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        CommentVideoInfo r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        boolean r117 = false;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        p r109 = null;
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

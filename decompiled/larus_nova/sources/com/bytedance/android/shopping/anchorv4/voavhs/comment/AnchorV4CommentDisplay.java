package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000f¢\u0006\u0002\u0010\u001dJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000fHÆ\u0003J\u0013\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003Jû\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000f2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000fHÆ\u0001J\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020OHÖ\u0001J\t\u0010P\u001a\u00020QHÖ\u0001R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R \u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!¨\u0006R"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentDisplay;", "Ljava/io/Serializable;", "commentTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "commentTags", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "commentUser", "commentDesc", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "commentMedias", "Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "buyersShowTitle", "buyersShowMedias", "askAroundTitle", "askAroundItems", "", "otherGoodsReviewTitle", "otherGoodsReviewTags", "kolReviewTitle", "kolReviewUser", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "kolReviewContent", "kolReviewStatistics", "kolReviewVideo", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "kolReviewList", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/KolReviewElement;", "multiComments", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/MultiCommentComponent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;Ljava/util/List;Ljava/util/List;)V", "getAskAroundItems", "()Ljava/util/List;", "getAskAroundTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "getBuyersShowMedias", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "getBuyersShowTitle", "getCommentDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getCommentMedias", "getCommentTags", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getCommentTitle", "getCommentUser", "getKolReviewContent", "getKolReviewList", "getKolReviewStatistics", "getKolReviewTitle", "getKolReviewUser", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getKolReviewVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "getMultiComments", "getOtherGoodsReviewTags", "getOtherGoodsReviewTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentDisplay implements Serializable {

    @SerializedName("ask_around_items")
    private final List<LongContentLabelComponent> askAroundItems;

    @SerializedName("ask_around_title")
    private final LongContentLabelComponent askAroundTitle;

    @SerializedName("buyers_show_medias")
    private final MediaScrollBoxComponent buyersShowMedias;

    @SerializedName("buyers_show_title")
    private final LongContentLabelComponent buyersShowTitle;

    @SerializedName("comment_desc")
    private final TextElement commentDesc;

    @SerializedName("comment_medias")
    private final MediaScrollBoxComponent commentMedias;

    @SerializedName("comment_tags")
    private final TagsScrollBoxComponent commentTags;

    @SerializedName("comment_title")
    private final LongContentLabelComponent commentTitle;

    @SerializedName("comment_user")
    private final TagsScrollBoxComponent commentUser;

    @SerializedName("kol_review_content")
    private final TextElement kolReviewContent;

    @SerializedName("kol_review_list")
    private final List<KolReviewElement> kolReviewList;

    @SerializedName("kol_review_statistics")
    private final List<TextWithOneIconElement> kolReviewStatistics;

    @SerializedName("kol_review_title")
    private final LongContentLabelComponent kolReviewTitle;

    @SerializedName("kol_review_user")
    private final TextWithOneIconElement kolReviewUser;

    @SerializedName("kol_review_video")
    private final MediaBoxElement kolReviewVideo;

    @SerializedName("multi_comments")
    private final List<MultiCommentComponent> multiComments;

    @SerializedName("other_goods_review_tags")
    private final TagsScrollBoxComponent otherGoodsReviewTags;

    @SerializedName("other_goods_review_title")
    private final LongContentLabelComponent otherGoodsReviewTitle;

    public AnchorV4CommentDisplay() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4CommentDisplay copy$default(AnchorV4CommentDisplay r110, LongContentLabelComponent r111, TagsScrollBoxComponent r112, TagsScrollBoxComponent r210, TextElement r211, MediaScrollBoxComponent r212, LongContentLabelComponent r213, MediaScrollBoxComponent r214, LongContentLabelComponent r215, List r216, LongContentLabelComponent r217, TagsScrollBoxComponent r218, LongContentLabelComponent r219, TextWithOneIconElement r310, TextElement r311, List r312, MediaBoxElement r313, List r314, List r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        LongContentLabelComponent r100 = r110.commentTitle;
    L7:
        if ((r316 & 2) == 0) goto L9;
        TagsScrollBoxComponent r101 = r110.commentTags;
    L11:
        if ((r316 & 4) == 0) goto L13;
        TagsScrollBoxComponent r102 = r110.commentUser;
    L15:
        if ((r316 & 8) == 0) goto L17;
        TextElement r103 = r110.commentDesc;
    L19:
        if ((r316 & 16) == 0) goto L21;
        MediaScrollBoxComponent r104 = r110.commentMedias;
    L23:
        if ((r316 & 32) == 0) goto L25;
        LongContentLabelComponent r105 = r110.buyersShowTitle;
    L27:
        if ((r316 & 64) == 0) goto L29;
        MediaScrollBoxComponent r106 = r110.buyersShowMedias;
    L31:
        if ((r316 & 128) == 0) goto L33;
        LongContentLabelComponent r107 = r110.askAroundTitle;
    L35:
        if ((r316 & 256) == 0) goto L37;
        List r113 = r110.askAroundItems;
    L39:
        if ((r316 & 512) == 0) goto L41;
        LongContentLabelComponent r114 = r110.otherGoodsReviewTitle;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        TagsScrollBoxComponent r115 = r110.otherGoodsReviewTags;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        LongContentLabelComponent r116 = r110.kolReviewTitle;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        TextWithOneIconElement r117 = r110.kolReviewUser;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        TextElement r118 = r110.kolReviewContent;
    L58:
        TextElement r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        List r119 = r110.kolReviewStatistics;
    L62:
        List r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        MediaBoxElement r120 = r110.kolReviewVideo;
    L66:
        MediaBoxElement r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        List r121 = r110.kolReviewList;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        List r108 = r110.multiComments;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
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

    public final LongContentLabelComponent component1() {
        return this.commentTitle;
    }

    public final LongContentLabelComponent component10() {
        return this.otherGoodsReviewTitle;
    }

    public final TagsScrollBoxComponent component11() {
        return this.otherGoodsReviewTags;
    }

    public final LongContentLabelComponent component12() {
        return this.kolReviewTitle;
    }

    public final TextWithOneIconElement component13() {
        return this.kolReviewUser;
    }

    public final TextElement component14() {
        return this.kolReviewContent;
    }

    public final List<TextWithOneIconElement> component15() {
        return this.kolReviewStatistics;
    }

    public final MediaBoxElement component16() {
        return this.kolReviewVideo;
    }

    public final List<KolReviewElement> component17() {
        return this.kolReviewList;
    }

    public final List<MultiCommentComponent> component18() {
        return this.multiComments;
    }

    public final TagsScrollBoxComponent component2() {
        return this.commentTags;
    }

    public final TagsScrollBoxComponent component3() {
        return this.commentUser;
    }

    public final TextElement component4() {
        return this.commentDesc;
    }

    public final MediaScrollBoxComponent component5() {
        return this.commentMedias;
    }

    public final LongContentLabelComponent component6() {
        return this.buyersShowTitle;
    }

    public final MediaScrollBoxComponent component7() {
        return this.buyersShowMedias;
    }

    public final LongContentLabelComponent component8() {
        return this.askAroundTitle;
    }

    public final List<LongContentLabelComponent> component9() {
        return this.askAroundItems;
    }

    public final AnchorV4CommentDisplay copy(LongContentLabelComponent r210, TagsScrollBoxComponent r211, TagsScrollBoxComponent r212, TextElement r213, MediaScrollBoxComponent r214, LongContentLabelComponent r215, MediaScrollBoxComponent r216, LongContentLabelComponent r217, List<? extends LongContentLabelComponent> r218, LongContentLabelComponent r310, TagsScrollBoxComponent r311, LongContentLabelComponent r312, TextWithOneIconElement r313, TextElement r314, List<TextWithOneIconElement> r315, MediaBoxElement r316, List<KolReviewElement> r317, List<MultiCommentComponent> r318) {
        return new AnchorV4CommentDisplay(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4CommentDisplay) == false) goto L42;
        AnchorV4CommentDisplay r101 = (AnchorV4CommentDisplay) r100;
        if (Intrinsics.areEqual(this.commentTitle, r101.commentTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commentTags, r101.commentTags) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commentUser, r101.commentUser) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentDesc, r101.commentDesc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.commentMedias, r101.commentMedias) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.buyersShowTitle, r101.buyersShowTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buyersShowMedias, r101.buyersShowMedias) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.askAroundTitle, r101.askAroundTitle) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.askAroundItems, r101.askAroundItems) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.otherGoodsReviewTitle, r101.otherGoodsReviewTitle) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.otherGoodsReviewTags, r101.otherGoodsReviewTags) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.kolReviewTitle, r101.kolReviewTitle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.kolReviewUser, r101.kolReviewUser) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.kolReviewContent, r101.kolReviewContent) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.kolReviewStatistics, r101.kolReviewStatistics) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.kolReviewVideo, r101.kolReviewVideo) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.kolReviewList, r101.kolReviewList) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.multiComments, r101.multiComments) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    public int hashCode() {
        LongContentLabelComponent r100 = this.commentTitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TagsScrollBoxComponent r104 = this.commentTags;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TagsScrollBoxComponent r107 = this.commentUser;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TextElement r110 = this.commentDesc;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        MediaScrollBoxComponent r113 = this.commentMedias;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        LongContentLabelComponent r116 = this.buyersShowTitle;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        MediaScrollBoxComponent r119 = this.buyersShowMedias;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        LongContentLabelComponent r122 = this.askAroundTitle;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<LongContentLabelComponent> r125 = this.askAroundItems;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        LongContentLabelComponent r128 = this.otherGoodsReviewTitle;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        TagsScrollBoxComponent r131 = this.otherGoodsReviewTags;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        LongContentLabelComponent r134 = this.kolReviewTitle;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        TextWithOneIconElement r137 = this.kolReviewUser;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        TextElement r140 = this.kolReviewContent;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        List<TextWithOneIconElement> r143 = this.kolReviewStatistics;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        MediaBoxElement r146 = this.kolReviewVideo;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        List<KolReviewElement> r149 = this.kolReviewList;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        List<MultiCommentComponent> r152 = this.multiComments;
        if (r152 == null) goto L74;
        r101 = r152.hashCode();
    L74:
        return r151 + r101;
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
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
        return "AnchorV4CommentDisplay(commentTitle=" + this.commentTitle + ", commentTags=" + this.commentTags + ", commentUser=" + this.commentUser + ", commentDesc=" + this.commentDesc + ", commentMedias=" + this.commentMedias + ", buyersShowTitle=" + this.buyersShowTitle + ", buyersShowMedias=" + this.buyersShowMedias + ", askAroundTitle=" + this.askAroundTitle + ", askAroundItems=" + this.askAroundItems + ", otherGoodsReviewTitle=" + this.otherGoodsReviewTitle + ", otherGoodsReviewTags=" + this.otherGoodsReviewTags + ", kolReviewTitle=" + this.kolReviewTitle + ", kolReviewUser=" + this.kolReviewUser + ", kolReviewContent=" + this.kolReviewContent + ", kolReviewStatistics=" + this.kolReviewStatistics + ", kolReviewVideo=" + this.kolReviewVideo + ", kolReviewList=" + this.kolReviewList + ", multiComments=" + this.multiComments + ")";
    }

    public final List<LongContentLabelComponent> getAskAroundItems() {
        return this.askAroundItems;
    }

    public final LongContentLabelComponent getAskAroundTitle() {
        return this.askAroundTitle;
    }

    public final MediaScrollBoxComponent getBuyersShowMedias() {
        return this.buyersShowMedias;
    }

    public final LongContentLabelComponent getBuyersShowTitle() {
        return this.buyersShowTitle;
    }

    public final TextElement getCommentDesc() {
        return this.commentDesc;
    }

    public final MediaScrollBoxComponent getCommentMedias() {
        return this.commentMedias;
    }

    public final TagsScrollBoxComponent getCommentTags() {
        return this.commentTags;
    }

    public final LongContentLabelComponent getCommentTitle() {
        return this.commentTitle;
    }

    public final TagsScrollBoxComponent getCommentUser() {
        return this.commentUser;
    }

    public final TextElement getKolReviewContent() {
        return this.kolReviewContent;
    }

    public final List<KolReviewElement> getKolReviewList() {
        return this.kolReviewList;
    }

    public final List<TextWithOneIconElement> getKolReviewStatistics() {
        return this.kolReviewStatistics;
    }

    public final LongContentLabelComponent getKolReviewTitle() {
        return this.kolReviewTitle;
    }

    public final TextWithOneIconElement getKolReviewUser() {
        return this.kolReviewUser;
    }

    public final MediaBoxElement getKolReviewVideo() {
        return this.kolReviewVideo;
    }

    public final List<MultiCommentComponent> getMultiComments() {
        return this.multiComments;
    }

    public final TagsScrollBoxComponent getOtherGoodsReviewTags() {
        return this.otherGoodsReviewTags;
    }

    public final LongContentLabelComponent getOtherGoodsReviewTitle() {
        return this.otherGoodsReviewTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4CommentDisplay(LongContentLabelComponent r100, TagsScrollBoxComponent r101, TagsScrollBoxComponent r102, TextElement r103, MediaScrollBoxComponent r104, LongContentLabelComponent r105, MediaScrollBoxComponent r106, LongContentLabelComponent r110, List<? extends LongContentLabelComponent> r111, LongContentLabelComponent r112, TagsScrollBoxComponent r113, LongContentLabelComponent r114, TextWithOneIconElement r115, TextElement r116, List<TextWithOneIconElement> r117, MediaBoxElement r118, List<KolReviewElement> r119, List<MultiCommentComponent> r210) {
        this.commentTitle = r100;
        this.commentTags = r101;
        this.commentUser = r102;
        this.commentDesc = r103;
        this.commentMedias = r104;
        this.buyersShowTitle = r105;
        this.buyersShowMedias = r106;
        this.askAroundTitle = r110;
        this.askAroundItems = r111;
        this.otherGoodsReviewTitle = r112;
        this.otherGoodsReviewTags = r113;
        this.kolReviewTitle = r114;
        this.kolReviewUser = r115;
        this.kolReviewContent = r116;
        this.kolReviewStatistics = r117;
        this.kolReviewVideo = r118;
        this.kolReviewList = r119;
        this.multiComments = r210;
    }

    public /* synthetic */ AnchorV4CommentDisplay(LongContentLabelComponent r210, TagsScrollBoxComponent r211, TagsScrollBoxComponent r212, TextElement r213, MediaScrollBoxComponent r214, LongContentLabelComponent r215, MediaScrollBoxComponent r216, LongContentLabelComponent r217, List r218, LongContentLabelComponent r219, TagsScrollBoxComponent r310, LongContentLabelComponent r311, TextWithOneIconElement r312, TextElement r313, List r314, MediaBoxElement r315, List r316, List r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        LongContentLabelComponent r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        TagsScrollBoxComponent r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        TagsScrollBoxComponent r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        TextElement r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        MediaScrollBoxComponent r104 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        LongContentLabelComponent r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        MediaScrollBoxComponent r106 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        LongContentLabelComponent r107 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        List r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        LongContentLabelComponent r111 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        TagsScrollBoxComponent r112 = null;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        LongContentLabelComponent r113 = null;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        TextWithOneIconElement r114 = null;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        TextElement r115 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        List r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        MediaBoxElement r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        List r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        List r109 = null;
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
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

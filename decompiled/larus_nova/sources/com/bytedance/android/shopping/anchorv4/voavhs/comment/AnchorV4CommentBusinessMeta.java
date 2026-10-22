package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010 \u001a\u00020\u000f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002¢\u0006\u0004\bI\u0010JJ\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u0010\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003Jå\u0001\u0010'\u001a\u00020\u00002\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00022\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010 \u001a\u00020\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020)HÖ\u0001J\u0013\u0010-\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u00100R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b1\u00100R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u00104R$\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b5\u00100R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b6\u00100R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u00109R\u001a\u0010\u001e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b=\u00109R\u001a\u0010 \u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010@R\u001c\u0010!\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010\"\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\bD\u00109R\u001c\u0010#\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\bE\u00109R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010.\u001a\u0004\bF\u00100R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010.\u001a\u0004\bG\u00100R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010.\u001a\u0004\bH\u00100¨\u0006K"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentTagStruct;", "component1", "component2", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;", "component3", "component4", "", "component5", "component6", "", "component7", "component8", "", "component9", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;", "component10", "component11", "component12", "component13", "component14", "component15", "tagJump", "storeTagJump", "commentMediaJump", "commentMediaJumpList", "buyerShowMediaJump", "kolReviewVideoLink", "kolReviewAuthorId", "kolReviewVideoId", "hasProductComment", "askAroundLink", "kolVideoPlaySchema", "kolVideoListSchema", "kolAwemeIdList", "kolAuthorIdList", "kolVideoTypeList", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/util/List;", "getTagJump", "()Ljava/util/List;", "getStoreTagJump", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;", "getCommentMediaJump", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;", "getCommentMediaJumpList", "getBuyerShowMediaJump", "Ljava/lang/String;", "getKolReviewVideoLink", "()Ljava/lang/String;", "J", "getKolReviewAuthorId", "()J", "getKolReviewVideoId", "Z", "getHasProductComment", "()Z", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;", "getAskAroundLink", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;", "getKolVideoPlaySchema", "getKolVideoListSchema", "getKolAwemeIdList", "getKolAuthorIdList", "getKolVideoTypeList", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;Ljava/util/List;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;ZLcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentBusinessMeta implements Serializable {

    @SerializedName("ask_around_link")
    private final a askAroundLink;

    @SerializedName("buyer_show_media_jump")
    private final List<String> buyerShowMediaJump;

    @SerializedName("comment_media_jump")
    private final AnchorV4CommentMediaMeta commentMediaJump;

    @SerializedName("comment_media_jump_list")
    private final List<AnchorV4CommentMediaMeta> commentMediaJumpList;

    @SerializedName("has_product_comment")
    private final boolean hasProductComment;

    @SerializedName("kol_author_id_list")
    private final List<String> kolAuthorIdList;

    @SerializedName("kol_aweme_id_list")
    private final List<String> kolAwemeIdList;

    @SerializedName("kol_review_author_id")
    private final long kolReviewAuthorId;

    @SerializedName("kol_review_video_id")
    private final String kolReviewVideoId;

    @SerializedName("kol_review_video_link")
    private final String kolReviewVideoLink;

    @SerializedName("kol_video_list_schema")
    private final String kolVideoListSchema;

    @SerializedName("kol_video_play_schema")
    private final String kolVideoPlaySchema;

    @SerializedName("kol_video_type_list")
    private final List<String> kolVideoTypeList;

    @SerializedName("store_tag_jump")
    private final List<AnchorV4CommentTagStruct> storeTagJump;

    @SerializedName("tag_jump")
    private final List<AnchorV4CommentTagStruct> tagJump;

    public AnchorV4CommentBusinessMeta() {
        this(null, null, null, null, null, null, 0, null, false, null, null, null, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4CommentBusinessMeta copy$default(AnchorV4CommentBusinessMeta r110, List r111, List r112, AnchorV4CommentMediaMeta r113, List r210, List r211, String r212, long r213, String r214, boolean r215, a r216, String r217, String r218, List r310, List r311, List r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        List r100 = r110.tagJump;
    L7:
        if ((r313 & 2) == 0) goto L9;
        List r101 = r110.storeTagJump;
    L11:
        if ((r313 & 4) == 0) goto L13;
        AnchorV4CommentMediaMeta r102 = r110.commentMediaJump;
    L15:
        if ((r313 & 8) == 0) goto L17;
        List r103 = r110.commentMediaJumpList;
    L19:
        if ((r313 & 16) == 0) goto L21;
        List r104 = r110.buyerShowMediaJump;
    L23:
        if ((r313 & 32) == 0) goto L25;
        String r105 = r110.kolReviewVideoLink;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r106 = r110.kolReviewAuthorId;
    L31:
        if ((r313 & 128) == 0) goto L33;
        String r114 = r110.kolReviewVideoId;
    L35:
        if ((r313 & 256) == 0) goto L37;
        boolean r115 = r110.hasProductComment;
    L39:
        if ((r313 & 512) == 0) goto L41;
        a r116 = r110.askAroundLink;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        String r117 = r110.kolVideoPlaySchema;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        String r118 = r110.kolVideoListSchema;
    L51:
        if ((r313 & 4096) == 0) goto L53;
        List r119 = r110.kolAwemeIdList;
    L54:
        List r315 = r119;
        if ((r313 & 8192) == 0) goto L57;
        List r120 = r110.kolAuthorIdList;
    L59:
        if ((r313 & 16384) == 0) goto L61;
        List r107 = r110.kolVideoTypeList;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r114, r115, r116, r117, r118, r315, r120, r107);
    L61:
        r107 = r312;
        goto L63
    L57:
        r120 = r311;
        goto L59
    L53:
        r119 = r310;
        goto L54
    L49:
        r118 = r218;
        goto L51
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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

    public final List<AnchorV4CommentTagStruct> component1() {
        return this.tagJump;
    }

    public final a component10() {
        return this.askAroundLink;
    }

    public final String component11() {
        return this.kolVideoPlaySchema;
    }

    public final String component12() {
        return this.kolVideoListSchema;
    }

    public final List<String> component13() {
        return this.kolAwemeIdList;
    }

    public final List<String> component14() {
        return this.kolAuthorIdList;
    }

    public final List<String> component15() {
        return this.kolVideoTypeList;
    }

    public final List<AnchorV4CommentTagStruct> component2() {
        return this.storeTagJump;
    }

    public final AnchorV4CommentMediaMeta component3() {
        return this.commentMediaJump;
    }

    public final List<AnchorV4CommentMediaMeta> component4() {
        return this.commentMediaJumpList;
    }

    public final List<String> component5() {
        return this.buyerShowMediaJump;
    }

    public final String component6() {
        return this.kolReviewVideoLink;
    }

    public final long component7() {
        return this.kolReviewAuthorId;
    }

    public final String component8() {
        return this.kolReviewVideoId;
    }

    public final boolean component9() {
        return this.hasProductComment;
    }

    public final AnchorV4CommentBusinessMeta copy(List<AnchorV4CommentTagStruct> r110, List<AnchorV4CommentTagStruct> r210, AnchorV4CommentMediaMeta r211, List<AnchorV4CommentMediaMeta> r212, List<String> r213, String r214, long r215, String r216, boolean r217, a r218, String r310, String r311, List<String> r312, List<String> r313, List<String> r314) {
        return new AnchorV4CommentBusinessMeta(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4CommentBusinessMeta) == false) goto L36;
        AnchorV4CommentBusinessMeta r101 = (AnchorV4CommentBusinessMeta) r100;
        if (Intrinsics.areEqual(this.tagJump, r101.tagJump) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.storeTagJump, r101.storeTagJump) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commentMediaJump, r101.commentMediaJump) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentMediaJumpList, r101.commentMediaJumpList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.buyerShowMediaJump, r101.buyerShowMediaJump) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.kolReviewVideoLink, r101.kolReviewVideoLink) == true) goto L18;
        return false;
    L18:
        if (this.kolReviewAuthorId == r101.kolReviewAuthorId) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.kolReviewVideoId, r101.kolReviewVideoId) == true) goto L22;
        return false;
    L22:
        if (this.hasProductComment == r101.hasProductComment) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.askAroundLink, r101.askAroundLink) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.kolVideoPlaySchema, r101.kolVideoPlaySchema) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.kolVideoListSchema, r101.kolVideoListSchema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.kolAwemeIdList, r101.kolAwemeIdList) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.kolAuthorIdList, r101.kolAuthorIdList) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.kolVideoTypeList, r101.kolVideoTypeList) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v50 */
    public int hashCode() {
        List<AnchorV4CommentTagStruct> r100 = this.tagJump;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<AnchorV4CommentTagStruct> r104 = this.storeTagJump;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        AnchorV4CommentMediaMeta r107 = this.commentMediaJump;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<AnchorV4CommentMediaMeta> r110 = this.commentMediaJumpList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.buyerShowMediaJump;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.kolReviewVideoLink;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        long r119 = this.kolReviewAuthorId;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        String r121 = this.kolReviewVideoId;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        boolean r124 = this.hasProductComment;
        ?? r125 = r124;
        if (r124 == false) goto L33;
        r125 = 1;
    L33:
        int r126 = (r123 + r125) * 31;
        a r127 = this.askAroundLink;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
    L37:
        int r129 = (r126 + r128) * 31;
        String r130 = this.kolVideoPlaySchema;
        if (r130 == null) goto L40;
        int r131 = r130.hashCode();
    L41:
        int r132 = (r129 + r131) * 31;
        String r133 = this.kolVideoListSchema;
        if (r133 == null) goto L44;
        int r134 = r133.hashCode();
    L45:
        int r135 = (r132 + r134) * 31;
        List<String> r136 = this.kolAwemeIdList;
        if (r136 == null) goto L48;
        int r137 = r136.hashCode();
    L49:
        int r138 = (r135 + r137) * 31;
        List<String> r139 = this.kolAuthorIdList;
        if (r139 == null) goto L52;
        int r140 = r139.hashCode();
    L53:
        int r141 = (r138 + r140) * 31;
        List<String> r142 = this.kolVideoTypeList;
        if (r142 == null) goto L57;
        r101 = r142.hashCode();
    L57:
        return r141 + r101;
    L52:
        r140 = 0;
        goto L53
    L48:
        r137 = 0;
        goto L49
    L44:
        r134 = 0;
        goto L45
    L40:
        r131 = 0;
        goto L41
    L36:
        r128 = 0;
        goto L37
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
        return "AnchorV4CommentBusinessMeta(tagJump=" + this.tagJump + ", storeTagJump=" + this.storeTagJump + ", commentMediaJump=" + this.commentMediaJump + ", commentMediaJumpList=" + this.commentMediaJumpList + ", buyerShowMediaJump=" + this.buyerShowMediaJump + ", kolReviewVideoLink=" + this.kolReviewVideoLink + ", kolReviewAuthorId=" + this.kolReviewAuthorId + ", kolReviewVideoId=" + this.kolReviewVideoId + ", hasProductComment=" + this.hasProductComment + ", askAroundLink=" + this.askAroundLink + ", kolVideoPlaySchema=" + this.kolVideoPlaySchema + ", kolVideoListSchema=" + this.kolVideoListSchema + ", kolAwemeIdList=" + this.kolAwemeIdList + ", kolAuthorIdList=" + this.kolAuthorIdList + ", kolVideoTypeList=" + this.kolVideoTypeList + ")";
    }

    public final a getAskAroundLink() {
        return this.askAroundLink;
    }

    public final List<String> getBuyerShowMediaJump() {
        return this.buyerShowMediaJump;
    }

    public final AnchorV4CommentMediaMeta getCommentMediaJump() {
        return this.commentMediaJump;
    }

    public final List<AnchorV4CommentMediaMeta> getCommentMediaJumpList() {
        return this.commentMediaJumpList;
    }

    public final boolean getHasProductComment() {
        return this.hasProductComment;
    }

    public final List<String> getKolAuthorIdList() {
        return this.kolAuthorIdList;
    }

    public final List<String> getKolAwemeIdList() {
        return this.kolAwemeIdList;
    }

    public final long getKolReviewAuthorId() {
        return this.kolReviewAuthorId;
    }

    public final String getKolReviewVideoId() {
        return this.kolReviewVideoId;
    }

    public final String getKolReviewVideoLink() {
        return this.kolReviewVideoLink;
    }

    public final String getKolVideoListSchema() {
        return this.kolVideoListSchema;
    }

    public final String getKolVideoPlaySchema() {
        return this.kolVideoPlaySchema;
    }

    public final List<String> getKolVideoTypeList() {
        return this.kolVideoTypeList;
    }

    public final List<AnchorV4CommentTagStruct> getStoreTagJump() {
        return this.storeTagJump;
    }

    public final List<AnchorV4CommentTagStruct> getTagJump() {
        return this.tagJump;
    }

    public AnchorV4CommentBusinessMeta(List<AnchorV4CommentTagStruct> r100, List<AnchorV4CommentTagStruct> r101, AnchorV4CommentMediaMeta r102, List<AnchorV4CommentMediaMeta> r103, List<String> r104, String r105, long r110, String r111, boolean r112, a r113, String r114, String r115, List<String> r116, List<String> r117, List<String> r118) {
        this.tagJump = r100;
        this.storeTagJump = r101;
        this.commentMediaJump = r102;
        this.commentMediaJumpList = r103;
        this.buyerShowMediaJump = r104;
        this.kolReviewVideoLink = r105;
        this.kolReviewAuthorId = r110;
        this.kolReviewVideoId = r111;
        this.hasProductComment = r112;
        this.askAroundLink = r113;
        this.kolVideoPlaySchema = r114;
        this.kolVideoListSchema = r115;
        this.kolAwemeIdList = r116;
        this.kolAuthorIdList = r117;
        this.kolVideoTypeList = r118;
    }

    public /* synthetic */ AnchorV4CommentBusinessMeta(List r110, List r111, AnchorV4CommentMediaMeta r112, List r210, List r211, String r212, long r213, String r214, boolean r215, a r216, String r217, String r218, List r310, List r311, List r312, int r313, DefaultConstructorMarker r314) {
        if ((r313 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r313 & 2) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r313 & 4) == 0) goto L13;
        AnchorV4CommentMediaMeta r102 = null;
    L15:
        if ((r313 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r313 & 16) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r313 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r106 = 0;
    L31:
        if ((r313 & 128) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r313 & 256) == 0) goto L37;
        boolean r114 = false;
    L39:
        if ((r313 & 512) == 0) goto L41;
        a r115 = null;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r313 & 4096) == 0) goto L53;
        List r118 = null;
    L55:
        if ((r313 & 8192) == 0) goto L57;
        List r107 = null;
    L59:
        if ((r313 & 16384) == 0) goto L61;
        List r108 = null;
    L62:
        this(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r118, r107, r108);
        return;
    L61:
        r108 = r312;
        goto L62
    L57:
        r107 = r311;
        goto L59
    L53:
        r118 = r310;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r113 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}

package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b1\b\u0086\b\u0018\u0000 a2\u00020\u0001:\u0001bBÅ\u0001\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010'\u001a\u00020\u0010\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0017\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010-\u001a\u00020\u001b\u0012\b\b\u0002\u0010.\u001a\u00020\u001d¢\u0006\u0004\b_\u0010`J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0010HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0012HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0017HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010\u001c\u001a\u00020\u001bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u001dHÆ\u0003JÇ\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010'\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u00122\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00172\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010-\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u001dHÆ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\u001bHÖ\u0001J\u0013\u00104\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b6\u00107R\u001c\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010:R\u001c\u0010!\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010\"\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010#\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010>\u001a\u0004\bA\u0010@R\u001c\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010%\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010>\u001a\u0004\bE\u0010@R\u001c\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010'\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010(\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010)\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010O\u001a\u0004\bP\u0010QR\u001c\u0010*\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010;\u001a\u0004\bR\u0010=R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010,\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010V\u001a\u0004\bW\u0010XR\u001a\u0010-\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010Y\u001a\u0004\bZ\u0010[R\u001a\u0010.\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\\\u001a\u0004\b]\u0010^¨\u0006c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/KolReviewElement;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "component1", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component2", "", "component3", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "component4", "component5", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "component6", "component7", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "component8", "", "component9", "", "component10", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "component11", "component12", "", "component13", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/ScaleFrame;", "component14", "", "component15", "", "component16", "image", "typeIcon", "elementType", "followText", "likeCount", "reviewContent", "kolInfo", "kolInfoFull", "edgePercent", "layoutStyle", "action", "statusId", "states", "scaleFrame", "typeIconStyle", "hasMask", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "getImage", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getTypeIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "Ljava/lang/String;", "getElementType", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getFollowText", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getLikeCount", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getReviewContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getKolInfo", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "getKolInfoFull", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", FaceService.girlLabel, "getEdgePercent", "()F", "J", "getLayoutStyle", "()J", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getStatusId", "Ljava/util/List;", "getStates", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/ScaleFrame;", "getScaleFrame", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/ScaleFrame;", "I", "getTypeIconStyle", "()I", "Z", "getHasMask", "()Z", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;FJLcom/bytedance/android/shopping/anchorv4/dto/base/Action;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/ScaleFrame;IZ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KolReviewElement implements Serializable {
    public static final int CENTER = 0;
    public static final a Companion = null;
    public static final int LEFT_TOP = 1;

    @SerializedName("action")
    private final Action action;

    @SerializedName("edge_percent")
    private final float edgePercent;

    @SerializedName("element_type")
    private final String elementType;

    @SerializedName("follow_text")
    private final TextWithOneIconElement followText;

    @SerializedName("has_mask")
    private final boolean hasMask;

    @SerializedName("image")
    private final MediaBoxElement image;

    @SerializedName("kol_info")
    private final TextWithOneIconElement kolInfo;

    @SerializedName("kol_info_full")
    private final LongContentLabelComponent kolInfoFull;

    @SerializedName("layout_style")
    private final long layoutStyle;

    @SerializedName("like_count")
    private final TextWithOneIconElement likeCount;

    @SerializedName("review_content")
    private final TextElement reviewContent;

    @SerializedName("scale_frame")
    private final ScaleFrame scaleFrame;

    @SerializedName("states")
    private final List<KolReviewElement> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName("type_icon")
    private final ImageModel typeIcon;

    @SerializedName("type_icon_style")
    private final int typeIconStyle;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public KolReviewElement() {
        this(null, null, null, null, null, null, null, null, 0.0f, 0, null, null, null, null, 0, false, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KolReviewElement copy$default(KolReviewElement r110, MediaBoxElement r111, ImageModel r112, String r210, TextWithOneIconElement r211, TextWithOneIconElement r212, TextElement r213, TextWithOneIconElement r214, LongContentLabelComponent r215, float r216, long r217, Action r218, String r310, List r311, ScaleFrame r312, int r313, boolean r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        MediaBoxElement r100 = r110.image;
    L7:
        if ((r315 & 2) == 0) goto L9;
        ImageModel r101 = r110.typeIcon;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = r110.elementType;
    L15:
        if ((r315 & 8) == 0) goto L17;
        TextWithOneIconElement r103 = r110.followText;
    L19:
        if ((r315 & 16) == 0) goto L21;
        TextWithOneIconElement r104 = r110.likeCount;
    L23:
        if ((r315 & 32) == 0) goto L25;
        TextElement r105 = r110.reviewContent;
    L27:
        if ((r315 & 64) == 0) goto L29;
        TextWithOneIconElement r106 = r110.kolInfo;
    L31:
        if ((r315 & 128) == 0) goto L33;
        LongContentLabelComponent r107 = r110.kolInfoFull;
    L35:
        if ((r315 & 256) == 0) goto L37;
        float r113 = r110.edgePercent;
    L39:
        if ((r315 & 512) == 0) goto L41;
        long r114 = r110.layoutStyle;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Action r115 = r110.action;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.statusId;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        List r117 = r110.states;
    L54:
        List r317 = r117;
        if ((r315 & 8192) == 0) goto L57;
        ScaleFrame r118 = r110.scaleFrame;
    L58:
        ScaleFrame r318 = r118;
        if ((r315 & 16384) == 0) goto L61;
        int r119 = r110.typeIconStyle;
    L63:
        if ((r315 & 32768) == 0) goto L65;
        boolean r108 = r110.hasMask;
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

    public final MediaBoxElement component1() {
        return this.image;
    }

    public final long component10() {
        return this.layoutStyle;
    }

    public final Action component11() {
        return this.action;
    }

    public final String component12() {
        return this.statusId;
    }

    public final List<KolReviewElement> component13() {
        return this.states;
    }

    public final ScaleFrame component14() {
        return this.scaleFrame;
    }

    public final int component15() {
        return this.typeIconStyle;
    }

    public final boolean component16() {
        return this.hasMask;
    }

    public final ImageModel component2() {
        return this.typeIcon;
    }

    public final String component3() {
        return this.elementType;
    }

    public final TextWithOneIconElement component4() {
        return this.followText;
    }

    public final TextWithOneIconElement component5() {
        return this.likeCount;
    }

    public final TextElement component6() {
        return this.reviewContent;
    }

    public final TextWithOneIconElement component7() {
        return this.kolInfo;
    }

    public final LongContentLabelComponent component8() {
        return this.kolInfoFull;
    }

    public final float component9() {
        return this.edgePercent;
    }

    public final KolReviewElement copy(MediaBoxElement r210, ImageModel r211, String r212, TextWithOneIconElement r213, TextWithOneIconElement r214, TextElement r215, TextWithOneIconElement r216, LongContentLabelComponent r217, float r218, long r219, Action r310, String r311, List<KolReviewElement> r312, ScaleFrame r313, int r314, boolean r315) {
        return new KolReviewElement(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof KolReviewElement) == false) goto L38;
        KolReviewElement r101 = (KolReviewElement) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.typeIcon, r101.typeIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.elementType, r101.elementType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.followText, r101.followText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.likeCount, r101.likeCount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.reviewContent, r101.reviewContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.kolInfo, r101.kolInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.kolInfoFull, r101.kolInfoFull) == true) goto L22;
        return false;
    L22:
        if (Float.compare(this.edgePercent, r101.edgePercent) == 0) goto L24;
        return false;
    L24:
        if (this.layoutStyle == r101.layoutStyle) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.scaleFrame, r101.scaleFrame) == true) goto L34;
        return false;
    L34:
        if (this.typeIconStyle == r101.typeIconStyle) goto L36;
        return false;
    L36:
        if (this.hasMask == r101.hasMask) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        MediaBoxElement r100 = this.image;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ImageModel r104 = this.typeIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.elementType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TextWithOneIconElement r110 = this.followText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        TextWithOneIconElement r113 = this.likeCount;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        TextElement r116 = this.reviewContent;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        TextWithOneIconElement r119 = this.kolInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        LongContentLabelComponent r122 = this.kolInfoFull;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (((r121 + r123) * 31) + Float.floatToIntBits(this.edgePercent)) * 31;
        long r125 = this.layoutStyle;
        int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
        Action r127 = this.action;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.statusId;
        if (r130 == null) goto L41;
        int r131 = r130.hashCode();
    L42:
        int r132 = (r129 + r131) * 31;
        List<KolReviewElement> r133 = this.states;
        if (r133 == null) goto L45;
        int r134 = r133.hashCode();
    L46:
        int r135 = (r132 + r134) * 31;
        ScaleFrame r136 = this.scaleFrame;
        if (r136 == null) goto L49;
        r101 = r136.hashCode();
    L49:
        int r137 = (((r135 + r101) * 31) + this.typeIconStyle) * 31;
        boolean r138 = this.hasMask;
        ?? r139 = r138;
        if (r138 == false) goto L53;
        r139 = 1;
    L53:
        return r137 + r139;
    L45:
        r134 = 0;
        goto L46
    L41:
        r131 = 0;
        goto L42
    L37:
        r128 = 0;
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
        return "KolReviewElement(image=" + this.image + ", typeIcon=" + this.typeIcon + ", elementType=" + this.elementType + ", followText=" + this.followText + ", likeCount=" + this.likeCount + ", reviewContent=" + this.reviewContent + ", kolInfo=" + this.kolInfo + ", kolInfoFull=" + this.kolInfoFull + ", edgePercent=" + this.edgePercent + ", layoutStyle=" + this.layoutStyle + ", action=" + this.action + ", statusId=" + this.statusId + ", states=" + this.states + ", scaleFrame=" + this.scaleFrame + ", typeIconStyle=" + this.typeIconStyle + ", hasMask=" + this.hasMask + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final float getEdgePercent() {
        return this.edgePercent;
    }

    public final String getElementType() {
        return this.elementType;
    }

    public final TextWithOneIconElement getFollowText() {
        return this.followText;
    }

    public final boolean getHasMask() {
        return this.hasMask;
    }

    public final MediaBoxElement getImage() {
        return this.image;
    }

    public final TextWithOneIconElement getKolInfo() {
        return this.kolInfo;
    }

    public final LongContentLabelComponent getKolInfoFull() {
        return this.kolInfoFull;
    }

    public final long getLayoutStyle() {
        return this.layoutStyle;
    }

    public final TextWithOneIconElement getLikeCount() {
        return this.likeCount;
    }

    public final TextElement getReviewContent() {
        return this.reviewContent;
    }

    public final ScaleFrame getScaleFrame() {
        return this.scaleFrame;
    }

    public final List<KolReviewElement> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final ImageModel getTypeIcon() {
        return this.typeIcon;
    }

    public final int getTypeIconStyle() {
        return this.typeIconStyle;
    }

    public KolReviewElement(MediaBoxElement r100, ImageModel r101, String r102, TextWithOneIconElement r103, TextWithOneIconElement r104, TextElement r105, TextWithOneIconElement r110, LongContentLabelComponent r111, float r112, long r113, Action r114, String r115, List<KolReviewElement> r116, ScaleFrame r117, int r118, boolean r210) {
        this.image = r100;
        this.typeIcon = r101;
        this.elementType = r102;
        this.followText = r103;
        this.likeCount = r104;
        this.reviewContent = r105;
        this.kolInfo = r110;
        this.kolInfoFull = r111;
        this.edgePercent = r112;
        this.layoutStyle = r113;
        this.action = r114;
        this.statusId = r115;
        this.states = r116;
        this.scaleFrame = r117;
        this.typeIconStyle = r118;
        this.hasMask = r210;
    }

    public /* synthetic */ KolReviewElement(MediaBoxElement r110, ImageModel r111, String r210, TextWithOneIconElement r211, TextWithOneIconElement r212, TextElement r213, TextWithOneIconElement r214, LongContentLabelComponent r215, float r216, long r217, Action r218, String r310, List r311, ScaleFrame r312, int r313, boolean r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 1) == 0) goto L5;
        MediaBoxElement r100 = null;
    L7:
        if ((r315 & 2) == 0) goto L9;
        ImageModel r101 = null;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r315 & 8) == 0) goto L17;
        TextWithOneIconElement r103 = null;
    L19:
        if ((r315 & 16) == 0) goto L21;
        TextWithOneIconElement r104 = null;
    L23:
        if ((r315 & 32) == 0) goto L25;
        TextElement r105 = null;
    L27:
        if ((r315 & 64) == 0) goto L29;
        TextWithOneIconElement r106 = null;
    L31:
        if ((r315 & 128) == 0) goto L33;
        LongContentLabelComponent r107 = null;
    L35:
        if ((r315 & 256) == 0) goto L37;
        float r112 = 0.33333334f;
    L39:
        if ((r315 & 512) == 0) goto L41;
        long r113 = 1;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Action r114 = null;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        List r116 = null;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        ScaleFrame r108 = null;
    L58:
        ScaleFrame r317 = r108;
        if ((r315 & 16384) == 0) goto L61;
        int r109 = 0;
    L63:
        if ((r315 & 32768) == 0) goto L65;
        boolean r117 = true;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r317, r109, r117);
        return;
    L65:
        r117 = r314;
        goto L66
    L61:
        r109 = r313;
        goto L63
    L57:
        r108 = r312;
        goto L58
    L53:
        r116 = r311;
        goto L55
    L49:
        r115 = r310;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
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
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}

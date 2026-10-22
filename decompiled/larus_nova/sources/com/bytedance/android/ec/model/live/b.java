package com.bytedance.android.ec.model.live;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u001c\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00103\u001a\u0004\u0018\u0001028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001c\u00108\u001a\u0004\u0018\u0001078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001c\u0010=\u001a\u0004\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010B\u001a\u0004\u0018\u00010A8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010G\u001a\u0004\u0018\u00010F8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010L\u001a\u0004\u0018\u00010K8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010Q\u001a\u0004\u0018\u00010P8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010\u0017\u001a\u0004\bV\u0010\u0019¨\u0006W"}, d2 = {"Lcom/bytedance/android/ec/model/live/b;", "", "", "position", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "", "elementType", "I", "o", "()I", "text", "s", BaseSwitches.V, "textColor", "t", "fontSize", "p", "", CommodityText.BOLD, "Z", "d", "()Z", "Lcom/bytedance/android/ec/model/ECUrlModel;", "avatars", "Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "blankWidth", "b", "image", "q", "Lcom/bytedance/android/ec/model/live/a;", "countDown", "Lcom/bytedance/android/ec/model/live/a;", "f", "()Lcom/bytedance/android/ec/model/live/a;", "Lcom/bytedance/android/ec/model/live/l;", "elementTextV2", "Lcom/bytedance/android/ec/model/live/l;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lcom/bytedance/android/ec/model/live/l;", "Lcom/bytedance/android/ec/model/live/d;", "elementBlank", "Lcom/bytedance/android/ec/model/live/d;", "h", "()Lcom/bytedance/android/ec/model/live/d;", "Lcom/bytedance/android/ec/model/live/g;", "elementCountDown", "Lcom/bytedance/android/ec/model/live/g;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/ec/model/live/g;", "Lcom/bytedance/android/ec/model/live/c;", "elementAvatar", "Lcom/bytedance/android/ec/model/live/c;", ce.f26391f, "()Lcom/bytedance/android/ec/model/live/c;", "Lcom/bytedance/android/ec/model/live/h;", "elementImage", "Lcom/bytedance/android/ec/model/live/h;", ce.f26395j, "()Lcom/bytedance/android/ec/model/live/h;", "Lcom/bytedance/android/ec/model/live/i;", "elementLoopText", "Lcom/bytedance/android/ec/model/live/i;", ce.f26396k, "()Lcom/bytedance/android/ec/model/live/i;", "Lcom/bytedance/android/ec/model/live/e;", "blockGroup", "Lcom/bytedance/android/ec/model/live/e;", "c", "()Lcom/bytedance/android/ec/model/live/e;", "Lcom/bytedance/android/ec/model/live/k;", "elementRichText", "Lcom/bytedance/android/ec/model/live/k;", "m", "()Lcom/bytedance/android/ec/model/live/k;", "Lcom/bytedance/android/ec/model/live/j;", "elementPrice", "Lcom/bytedance/android/ec/model/live/j;", "l", "()Lcom/bytedance/android/ec/model/live/j;", "cartAddDestination", "e", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f47887a;

    @SerializedName("avatars")
    private final ECUrlModel avatars;

    @SerializedName("blank_width")
    private final int blankWidth;

    @SerializedName("block_group")
    private final e blockGroup;

    @SerializedName(CommodityText.BOLD)
    private final boolean bold;

    @SerializedName("cart_add_destination")
    private final boolean cartAddDestination;

    @SerializedName("countdown")
    private final com.bytedance.android.ec.model.live.a countDown;

    @SerializedName("avatars_v2")
    private final c elementAvatar;

    @SerializedName("blank_v2")
    private final d elementBlank;

    @SerializedName("countdown_v2")
    private final g elementCountDown;

    @SerializedName("image_v2")
    private final h elementImage;

    @SerializedName("loop_text")
    private final i elementLoopText;

    @SerializedName("price")
    private final j elementPrice;

    @SerializedName("rich_text")
    private final k elementRichText;

    @SerializedName("text_v2")
    private final l elementTextV2;

    @SerializedName("element_type")
    private final int elementType;

    @SerializedName("font_size")
    private final int fontSize;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName("position")
    private String position;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private final String textColor;

    public static final class a {
    }

    static {
    }

    public b() {
        this(0, null, null, 0, null, 0, null, null, null, null, null, 1048575);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L46;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L8;
        return false;
    L8:
        if (this.elementType == r101.elementType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L14;
        return false;
    L14:
        if (this.fontSize == r101.fontSize) goto L16;
        return false;
    L16:
        if (this.bold == r101.bold) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatars, r101.avatars) == true) goto L20;
        return false;
    L20:
        if (this.blankWidth == r101.blankWidth) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.countDown, r101.countDown) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.elementTextV2, r101.elementTextV2) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.elementBlank, r101.elementBlank) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.elementCountDown, r101.elementCountDown) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.elementAvatar, r101.elementAvatar) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.elementImage, r101.elementImage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.elementLoopText, r101.elementLoopText) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.blockGroup, r101.blockGroup) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.elementRichText, r101.elementRichText) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.elementPrice, r101.elementPrice) == true) goto L44;
        return false;
    L44:
        if (this.cartAddDestination == r101.cartAddDestination) goto L70;
        return false;
    L70:
        return true;
    L46:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.position;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.elementType) * 31;
        String r104 = this.text;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.textColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.fontSize) * 31;
        boolean r110 = this.bold;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        ECUrlModel r114 = this.avatars;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (((r113 + r115) * 31) + this.blankWidth) * 31;
        ECUrlModel r117 = this.image;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        com.bytedance.android.ec.model.live.a r120 = this.countDown;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        l r123 = this.elementTextV2;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        d r126 = this.elementBlank;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        g r129 = this.elementCountDown;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        c r132 = this.elementAvatar;
        if (r132 == null) goto L44;
        int r133 = r132.hashCode();
    L45:
        int r134 = (r131 + r133) * 31;
        h r135 = this.elementImage;
        if (r135 == null) goto L48;
        int r136 = r135.hashCode();
    L49:
        int r137 = (r134 + r136) * 31;
        i r138 = this.elementLoopText;
        if (r138 == null) goto L52;
        int r139 = r138.hashCode();
    L53:
        int r140 = (r137 + r139) * 31;
        e r141 = this.blockGroup;
        if (r141 == null) goto L56;
        int r142 = r141.hashCode();
    L57:
        int r143 = (r140 + r142) * 31;
        k r144 = this.elementRichText;
        if (r144 == null) goto L60;
        int r145 = r144.hashCode();
    L61:
        int r146 = (r143 + r145) * 31;
        j r147 = this.elementPrice;
        if (r147 == null) goto L64;
        r101 = r147.hashCode();
    L64:
        int r148 = (r146 + r101) * 31;
        boolean r149 = this.cartAddDestination;
        if (r149 == true) goto L69;
        r111 = r149;
    L69:
        return r148 + r111;
    L60:
        r145 = 0;
        goto L61
    L56:
        r142 = 0;
        goto L57
    L52:
        r139 = 0;
        goto L53
    L48:
        r136 = 0;
        goto L49
    L44:
        r133 = 0;
        goto L45
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
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

    public final String toString() {
        return "ECCustomizedElement(position=" + this.position + ", elementType=" + this.elementType + ", text=" + this.text + ", textColor=" + this.textColor + ", fontSize=" + this.fontSize + ", bold=" + this.bold + ", avatars=" + this.avatars + ", blankWidth=" + this.blankWidth + ", image=" + this.image + ", countDown=" + this.countDown + ", elementTextV2=" + this.elementTextV2 + ", elementBlank=" + this.elementBlank + ", elementCountDown=" + this.elementCountDown + ", elementAvatar=" + this.elementAvatar + ", elementImage=" + this.elementImage + ", elementLoopText=" + this.elementLoopText + ", blockGroup=" + this.blockGroup + ", elementRichText=" + this.elementRichText + ", elementPrice=" + this.elementPrice + ", cartAddDestination=" + this.cartAddDestination + ")";
    }

    public final ECUrlModel a() {
        return this.avatars;
    }

    public final int b() {
        return this.blankWidth;
    }

    public final e c() {
        return this.blockGroup;
    }

    public final boolean d() {
        return this.bold;
    }

    public final boolean e() {
        return this.cartAddDestination;
    }

    public final com.bytedance.android.ec.model.live.a f() {
        return this.countDown;
    }

    public final c g() {
        return this.elementAvatar;
    }

    public final d h() {
        return this.elementBlank;
    }

    public final g i() {
        return this.elementCountDown;
    }

    public final h j() {
        return this.elementImage;
    }

    public final i k() {
        return this.elementLoopText;
    }

    public final j l() {
        return this.elementPrice;
    }

    public final k m() {
        return this.elementRichText;
    }

    public final l n() {
        return this.elementTextV2;
    }

    public final int o() {
        return this.elementType;
    }

    public final int p() {
        return this.fontSize;
    }

    public final ECUrlModel q() {
        return this.image;
    }

    public final String r() {
        return this.position;
    }

    public final String s() {
        return this.text;
    }

    public final String t() {
        return this.textColor;
    }

    public final void u(String r100) {
        this.position = r100;
    }

    public final void v(String r100) {
        this.text = r100;
    }

    public b(int r100, String r101, String r102, int r103, ECUrlModel r104, int r105, l r110, d r111, c r112, h r113, i r114, int r115) {
        if ((r115 & 2) == 0) goto L6;
        r100 = 3;
    L6:
        if ((r115 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r115 & 16) == 0) goto L15;
        r103 = -1;
    L15:
        if ((r115 & 64) == 0) goto L18;
        r104 = null;
    L18:
        if ((r115 & 128) == 0) goto L21;
        r105 = 0;
    L21:
        if ((r115 & 1024) == 0) goto L24;
        r110 = null;
    L24:
        if ((r115 & 2048) == 0) goto L27;
        r111 = null;
    L27:
        if ((r115 & 8192) == 0) goto L30;
        r112 = null;
    L30:
        if ((r115 & 16384) == 0) goto L33;
        r113 = null;
    L33:
        if ((r115 & 32768) == 0) goto L35;
        r114 = null;
    L35:
        this.position = null;
        this.elementType = r100;
        this.text = r101;
        this.textColor = r102;
        this.fontSize = r103;
        this.bold = false;
        this.avatars = r104;
        this.blankWidth = r105;
        this.image = null;
        this.countDown = null;
        this.elementTextV2 = r110;
        this.elementBlank = r111;
        this.elementCountDown = null;
        this.elementAvatar = r112;
        this.elementImage = r113;
        this.elementLoopText = r114;
        this.blockGroup = null;
        this.elementRichText = null;
        this.elementPrice = null;
        this.cartAddDestination = false;
        this.f47887a = LazyKt.lazy(new ECCustomizedElement$uiCountDown$2(this));
    }
}

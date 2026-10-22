package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b!\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001CB\u0089\u0001\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b@\u0010AJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\nHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0012HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0012HÆ\u0003J\u008b\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0019\u001a\u00020\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0012HÆ\u0001J\t\u0010!\u001a\u00020\u000eHÖ\u0001J\t\u0010\"\u001a\u00020\u0012HÖ\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\u001a\u0010\u0019\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b\u0019\u00103R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b4\u0010+R\u001a\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b5\u00103R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u00108R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010;R\u001a\u0010\u001e\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010\u001f\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\b?\u0010>¨\u0006D"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "component1", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceInfo;", "component3", "Lg73/a;", "component4", "", "component5", "component6", "component7", "", "component8", "", "component9", "", "component10", "component11", "action", "prefix", "priceInfo", LynxResourceModule.FONT_TYPE, "isStrikeThrough", "suffix", "comma", "statusId", "states", "bgType", "priceType", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getPrefix", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceInfo;", "getPriceInfo", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceInfo;", "Lg73/a;", "getFont", "()Lg73/a;", "Z", "()Z", "getSuffix", "getComma", "Ljava/lang/String;", "getStatusId", "()Ljava/lang/String;", "Ljava/util/List;", "getStates", "()Ljava/util/List;", "I", "getBgType", "()I", "getPriceType", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceInfo;Lg73/a;ZLcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;ZLjava/lang/String;Ljava/util/List;II)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceElement implements Serializable {
    public static final int BGType_NoBG = 0;
    public static final int BGType_WithCornerBG = 1;
    public static final a Companion = null;
    public static final int PriceType_Default = 0;
    public static final int PriceType_Range = 0;

    @SerializedName("action")
    private final Action action;

    @SerializedName("bg_type")
    private final int bgType;

    @SerializedName("comma")
    private final boolean comma;

    @SerializedName(LynxResourceModule.FONT_TYPE)
    private final g73.a font;

    @SerializedName("is_strike_through")
    private final boolean isStrikeThrough;

    @SerializedName("prefix")
    private final TextElement prefix;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRICE_INFO)
    private final PriceInfo priceInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRICE_TYPE)
    private final int priceType;

    @SerializedName("states")
    private final List<PriceElement> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName("suffix")
    private final TextElement suffix;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PriceElement() {
        this(null, null, null, null, false, null, false, null, null, 0, 0, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PriceElement copy$default(PriceElement r110, Action r111, TextElement r112, PriceInfo r113, g73.a r114, boolean r115, TextElement r116, boolean r117, String r210, List r211, int r212, int r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r214 & 2) == 0) goto L9;
        TextElement r101 = r110.prefix;
    L11:
        if ((r214 & 4) == 0) goto L13;
        PriceInfo r102 = r110.priceInfo;
    L15:
        if ((r214 & 8) == 0) goto L17;
        g73.a r103 = r110.font;
    L19:
        if ((r214 & 16) == 0) goto L21;
        boolean r104 = r110.isStrikeThrough;
    L23:
        if ((r214 & 32) == 0) goto L25;
        TextElement r105 = r110.suffix;
    L27:
        if ((r214 & 64) == 0) goto L29;
        boolean r106 = r110.comma;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.statusId;
    L35:
        if ((r214 & 256) == 0) goto L37;
        List r118 = r110.states;
    L39:
        if ((r214 & 512) == 0) goto L41;
        int r119 = r110.bgType;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        int r108 = r110.priceType;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final Action component1() {
        return this.action;
    }

    public final int component10() {
        return this.bgType;
    }

    public final int component11() {
        return this.priceType;
    }

    public final TextElement component2() {
        return this.prefix;
    }

    public final PriceInfo component3() {
        return this.priceInfo;
    }

    public final g73.a component4() {
        return this.font;
    }

    public final boolean component5() {
        return this.isStrikeThrough;
    }

    public final TextElement component6() {
        return this.suffix;
    }

    public final boolean component7() {
        return this.comma;
    }

    public final String component8() {
        return this.statusId;
    }

    public final List<PriceElement> component9() {
        return this.states;
    }

    public final PriceElement copy(Action r110, TextElement r111, PriceInfo r112, g73.a r113, boolean r114, TextElement r115, boolean r210, String r211, List<PriceElement> r212, int r213, int r214) {
        return new PriceElement(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PriceElement) == false) goto L28;
        PriceElement r101 = (PriceElement) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.prefix, r101.prefix) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.priceInfo, r101.priceInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.font, r101.font) == true) goto L14;
        return false;
    L14:
        if (this.isStrikeThrough == r101.isStrikeThrough) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.suffix, r101.suffix) == true) goto L18;
        return false;
    L18:
        if (this.comma == r101.comma) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L24;
        return false;
    L24:
        if (this.bgType == r101.bgType) goto L26;
        return false;
    L26:
        if (this.priceType == r101.priceType) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextElement r104 = this.prefix;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        PriceInfo r107 = this.priceInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        g73.a r110 = this.font;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.isStrikeThrough;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        TextElement r117 = this.suffix;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.comma;
        if (r120 == true) goto L29;
        r114 = r120;
    L29:
        int r121 = (r119 + r114) * 31;
        String r122 = this.statusId;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        List<PriceElement> r125 = this.states;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return ((((r124 + r101) * 31) + this.bgType) * 31) + this.priceType;
    L32:
        r123 = 0;
        goto L33
    L24:
        r118 = 0;
        goto L25
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
        return "PriceElement(action=" + this.action + ", prefix=" + this.prefix + ", priceInfo=" + this.priceInfo + ", font=" + this.font + ", isStrikeThrough=" + this.isStrikeThrough + ", suffix=" + this.suffix + ", comma=" + this.comma + ", statusId=" + this.statusId + ", states=" + this.states + ", bgType=" + this.bgType + ", priceType=" + this.priceType + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final int getBgType() {
        return this.bgType;
    }

    public final boolean getComma() {
        return this.comma;
    }

    public final g73.a getFont() {
        return this.font;
    }

    public final TextElement getPrefix() {
        return this.prefix;
    }

    public final PriceInfo getPriceInfo() {
        return this.priceInfo;
    }

    public final int getPriceType() {
        return this.priceType;
    }

    public final List<PriceElement> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final TextElement getSuffix() {
        return this.suffix;
    }

    public final boolean isStrikeThrough() {
        return this.isStrikeThrough;
    }

    public PriceElement(Action r100, TextElement r101, PriceInfo r102, g73.a r103, boolean r104, TextElement r105, boolean r106, String r107, List<PriceElement> r108, int r110, int r111) {
        this.action = r100;
        this.prefix = r101;
        this.priceInfo = r102;
        this.font = r103;
        this.isStrikeThrough = r104;
        this.suffix = r105;
        this.comma = r106;
        this.statusId = r107;
        this.states = r108;
        this.bgType = r110;
        this.priceType = r111;
    }

    public /* synthetic */ PriceElement(Action r110, TextElement r111, PriceInfo r112, g73.a r113, boolean r114, TextElement r115, boolean r116, String r210, List r211, int r212, int r213, int r214, DefaultConstructorMarker r215) {
        List r100 = null;
        if ((r214 & 1) == 0) goto L5;
        Action r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        TextElement r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        PriceInfo r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        g73.a r104 = null;
    L18:
        int r105 = 0;
        if ((r214 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r214 & 32) == 0) goto L25;
        TextElement r107 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        boolean r108 = false;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r117 = null;
    L35:
        if ((r214 & 256) != 0) goto L39;
        r100 = r211;
    L39:
        if ((r214 & 512) == 0) goto L41;
        int r118 = 0;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r105 = r213;
    L46:
        this(r101, r102, r103, r104, r106, r107, r108, r117, r100, r118, r105);
        return;
    L41:
        r118 = r212;
        goto L43
    L33:
        r117 = r210;
        goto L35
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
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

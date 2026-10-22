package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010.\u001a\u00020\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u00105\u001a\u00020\u0005\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u00107\u001a\u00020\u0005¢\u0006\u0004\bd\u0010eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\u0005HÆ\u0003Jî\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010.\u001a\u00020\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010 2\b\b\u0002\u00105\u001a\u00020\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010#2\b\b\u0002\u00107\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b8\u00109J\t\u0010:\u001a\u00020\u0002HÖ\u0001J\t\u0010;\u001a\u00020#HÖ\u0001J\u0013\u0010>\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010<HÖ\u0003R\u001c\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010(\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010E\u001a\u0004\bF\u0010GR(\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010H\u001a\u0004\bI\u0010JR(\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010H\u001a\u0004\bK\u0010JR\u001c\u0010,\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010-\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010O\u001a\u0004\bP\u0010QR\u001a\u0010.\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010R\u001a\u0004\bS\u0010TR\u001c\u0010/\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010U\u001a\u0004\bV\u0010\u001aR\u001c\u00100\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010U\u001a\u0004\bW\u0010\u001aR\u001c\u00101\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010U\u001a\u0004\bX\u0010\u001aR\u001c\u00102\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010U\u001a\u0004\bY\u0010\u001aR\u001c\u00103\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010Z\u001a\u0004\b[\u0010\\R\u001c\u00104\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010]\u001a\u0004\b^\u0010_R\u001a\u00105\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010R\u001a\u0004\b`\u0010TR\u001c\u00106\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010a\u001a\u0004\bb\u0010%R\u001a\u00107\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010R\u001a\u0004\bc\u0010T¨\u0006f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "Ljava/io/Serializable;", "", "getSkuSpecId", "getTrackType", "", "isCommentTest", "half", "", "getWHScale", "(Z)Ljava/lang/Float;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "component1", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "component2", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "component3", "", "component4", "component5", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;", "component6", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;", "component7", "component8", "component9", "()Ljava/lang/Float;", "component10", "component11", "component12", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;", "component14", "component15", "", "component16", "()Ljava/lang/Integer;", "component17", "media", "slice", "clickAction", GXTemplateKey.GAIAX_TRACK, "meta", "config", "lynx", "needShowBar", "whScale", "whScaleHalf", "topPadding", "topPaddingHalf", "style", "multiPreview", "defaultHide", "fixedHeight", "needStatusBarPlace", "copy", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;ZLjava/lang/Integer;Z)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "getMedia", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "getSlice", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getClickAction", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "Ljava/util/Map;", "getTrack", "()Ljava/util/Map;", "getMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;", "getLynx", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;", "Z", "getNeedShowBar", "()Z", "Ljava/lang/Float;", "getWhScale", "getWhScaleHalf", "getTopPadding", "getTopPaddingHalf", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "getStyle", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;", "getMultiPreview", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;", "getDefaultHide", "Ljava/lang/Integer;", "getFixedHeight", "getNeedStatusBarPlace", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;ZLjava/lang/Integer;Z)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderContentModel implements Serializable {

    @SerializedName("click_action")
    private final IAction clickAction;

    @SerializedName("config")
    private final Config config;

    @SerializedName("default_hide")
    private final boolean defaultHide;

    @SerializedName("fixed_height")
    private final Integer fixedHeight;

    @SerializedName("lynx_container")
    private final j lynx;

    @SerializedName("media")
    private final HeaderMediaModel media;

    @SerializedName("meta")
    private final Map<String, String> meta;

    @SerializedName("multi_preview")
    private final r multiPreview;

    @SerializedName("need_show_bar")
    private final boolean needShowBar;

    @SerializedName("need_status_bar_place")
    private final boolean needStatusBarPlace;

    @SerializedName("slice")
    private final HeaderSliceModel slice;

    @SerializedName("style")
    private final i style;

    @SerializedName("top_padding")
    private final Float topPadding;

    @SerializedName("top_padding_half")
    private final Float topPaddingHalf;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final Map<String, String> track;

    @SerializedName("wh_scale")
    private final Float whScale;

    @SerializedName("wh_scale_half")
    private final Float whScaleHalf;

    public HeaderContentModel() {
        this(null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, false, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderContentModel copy$default(HeaderContentModel r110, HeaderMediaModel r111, HeaderSliceModel r112, IAction r210, Map r211, Map r212, Config r213, j r214, boolean r215, Float r216, Float r217, Float r218, Float r219, i r310, r r311, boolean r312, Integer r313, boolean r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        HeaderMediaModel r100 = r110.media;
    L7:
        if ((r315 & 2) == 0) goto L9;
        HeaderSliceModel r101 = r110.slice;
    L11:
        if ((r315 & 4) == 0) goto L13;
        IAction r102 = r110.clickAction;
    L15:
        if ((r315 & 8) == 0) goto L17;
        Map r103 = r110.track;
    L19:
        if ((r315 & 16) == 0) goto L21;
        Map r104 = r110.meta;
    L23:
        if ((r315 & 32) == 0) goto L25;
        Config r105 = r110.config;
    L27:
        if ((r315 & 64) == 0) goto L29;
        j r106 = r110.lynx;
    L31:
        if ((r315 & 128) == 0) goto L33;
        boolean r107 = r110.needShowBar;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Float r113 = r110.whScale;
    L39:
        if ((r315 & 512) == 0) goto L41;
        Float r114 = r110.whScaleHalf;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Float r115 = r110.topPadding;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        Float r116 = r110.topPaddingHalf;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        i r117 = r110.style;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        r r118 = r110.multiPreview;
    L58:
        r r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        boolean r119 = r110.defaultHide;
    L62:
        boolean r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        Integer r120 = r110.fixedHeight;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        boolean r108 = r110.needStatusBarPlace;
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

    public final HeaderMediaModel component1() {
        return this.media;
    }

    public final Float component10() {
        return this.whScaleHalf;
    }

    public final Float component11() {
        return this.topPadding;
    }

    public final Float component12() {
        return this.topPaddingHalf;
    }

    public final i component13() {
        return this.style;
    }

    public final r component14() {
        return this.multiPreview;
    }

    public final boolean component15() {
        return this.defaultHide;
    }

    public final Integer component16() {
        return this.fixedHeight;
    }

    public final boolean component17() {
        return this.needStatusBarPlace;
    }

    public final HeaderSliceModel component2() {
        return this.slice;
    }

    public final IAction component3() {
        return this.clickAction;
    }

    public final Map<String, String> component4() {
        return this.track;
    }

    public final Map<String, String> component5() {
        return this.meta;
    }

    public final Config component6() {
        return this.config;
    }

    public final j component7() {
        return this.lynx;
    }

    public final boolean component8() {
        return this.needShowBar;
    }

    public final Float component9() {
        return this.whScale;
    }

    public final HeaderContentModel copy(HeaderMediaModel r210, HeaderSliceModel r211, IAction r212, Map<String, String> r213, Map<String, String> r214, Config r215, j r216, boolean r217, Float r218, Float r219, Float r310, Float r311, i r312, r r313, boolean r314, Integer r315, boolean r316) {
        return new HeaderContentModel(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderContentModel) == false) goto L40;
        HeaderContentModel r101 = (HeaderContentModel) r100;
        if (Intrinsics.areEqual(this.media, r101.media) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.slice, r101.slice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clickAction, r101.clickAction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynx, r101.lynx) == true) goto L20;
        return false;
    L20:
        if (this.needShowBar == r101.needShowBar) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.whScale, r101.whScale) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.whScaleHalf, r101.whScaleHalf) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.topPadding, r101.topPadding) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.topPaddingHalf, r101.topPaddingHalf) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.multiPreview, r101.multiPreview) == true) goto L34;
        return false;
    L34:
        if (this.defaultHide == r101.defaultHide) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.fixedHeight, r101.fixedHeight) == true) goto L38;
        return false;
    L38:
        if (this.needStatusBarPlace == r101.needStatusBarPlace) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        HeaderMediaModel r100 = this.media;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HeaderSliceModel r104 = this.slice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IAction r107 = this.clickAction;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.track;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.meta;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Config r116 = this.config;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        j r119 = this.lynx;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.needShowBar;
        ?? r123 = 1;
        ?? r124 = r122;
        if (r122 == false) goto L33;
        r124 = 1;
    L33:
        int r125 = (r121 + r124) * 31;
        Float r126 = this.whScale;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        Float r129 = this.whScaleHalf;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        Float r132 = this.topPadding;
        if (r132 == null) goto L44;
        int r133 = r132.hashCode();
    L45:
        int r134 = (r131 + r133) * 31;
        Float r135 = this.topPaddingHalf;
        if (r135 == null) goto L48;
        int r136 = r135.hashCode();
    L49:
        int r137 = (r134 + r136) * 31;
        i r138 = this.style;
        if (r138 == null) goto L52;
        int r139 = r138.hashCode();
    L53:
        int r140 = (r137 + r139) * 31;
        r r141 = this.multiPreview;
        if (r141 == null) goto L56;
        int r142 = r141.hashCode();
    L57:
        int r143 = (r140 + r142) * 31;
        boolean r144 = this.defaultHide;
        ?? r145 = r144;
        if (r144 == false) goto L60;
        r145 = 1;
    L60:
        int r146 = (r143 + r145) * 31;
        Integer r147 = this.fixedHeight;
        if (r147 == null) goto L63;
        r101 = r147.hashCode();
    L63:
        int r148 = (r146 + r101) * 31;
        boolean r149 = this.needStatusBarPlace;
        if (r149 == true) goto L68;
        r123 = r149;
    L68:
        return r148 + r123;
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
        return "HeaderContentModel(media=" + this.media + ", slice=" + this.slice + ", clickAction=" + this.clickAction + ", track=" + this.track + ", meta=" + this.meta + ", config=" + this.config + ", lynx=" + this.lynx + ", needShowBar=" + this.needShowBar + ", whScale=" + this.whScale + ", whScaleHalf=" + this.whScaleHalf + ", topPadding=" + this.topPadding + ", topPaddingHalf=" + this.topPaddingHalf + ", style=" + this.style + ", multiPreview=" + this.multiPreview + ", defaultHide=" + this.defaultHide + ", fixedHeight=" + this.fixedHeight + ", needStatusBarPlace=" + this.needStatusBarPlace + ")";
    }

    public final String getSkuSpecId() {
        Map<String, String> r100 = this.meta;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("spec_id");
    }

    public final String getTrackType() {
        Map<String, String> r100 = this.track;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("type");
    }

    public final boolean isCommentTest() {
        if (Intrinsics.areEqual(getTrackType(), EffectConstants.CHANNEL_TEST) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(getTrackType(), "more_test") == true) goto L8;
        return false;
    }

    public final IAction getClickAction() {
        return this.clickAction;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final boolean getDefaultHide() {
        return this.defaultHide;
    }

    public final Integer getFixedHeight() {
        return this.fixedHeight;
    }

    public final j getLynx() {
        return this.lynx;
    }

    public final HeaderMediaModel getMedia() {
        return this.media;
    }

    public final Map<String, String> getMeta() {
        return this.meta;
    }

    public final r getMultiPreview() {
        return this.multiPreview;
    }

    public final boolean getNeedShowBar() {
        return this.needShowBar;
    }

    public final boolean getNeedStatusBarPlace() {
        return this.needStatusBarPlace;
    }

    public final HeaderSliceModel getSlice() {
        return this.slice;
    }

    public final i getStyle() {
        return this.style;
    }

    public final Float getTopPadding() {
        return this.topPadding;
    }

    public final Float getTopPaddingHalf() {
        return this.topPaddingHalf;
    }

    public final Map<String, String> getTrack() {
        return this.track;
    }

    public final Float getWhScale() {
        return this.whScale;
    }

    public final Float getWhScaleHalf() {
        return this.whScaleHalf;
    }

    public final Float getWHScale(boolean r100) {
        if (r100 == false) goto L7;
        Float r101 = this.whScaleHalf;
        if (r101 != null) goto L12;
        return null;
    L12:
        return Float.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r101.floatValue(), 0.75f), 2.0f));
    L7:
        Float r102 = this.whScale;
        if (r102 != null) goto L10;
        return null;
    L10:
        return Float.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r102.floatValue(), 0.75f), 2.0f));
    }

    public HeaderContentModel(HeaderMediaModel r100, HeaderSliceModel r101, IAction r102, Map<String, String> r103, Map<String, String> r104, Config r105, j r106, boolean r110, Float r111, Float r112, Float r113, Float r114, i r115, r r116, boolean r117, Integer r118, boolean r119) {
        this.media = r100;
        this.slice = r101;
        this.clickAction = r102;
        this.track = r103;
        this.meta = r104;
        this.config = r105;
        this.lynx = r106;
        this.needShowBar = r110;
        this.whScale = r111;
        this.whScaleHalf = r112;
        this.topPadding = r113;
        this.topPaddingHalf = r114;
        this.style = r115;
        this.multiPreview = r116;
        this.defaultHide = r117;
        this.fixedHeight = r118;
        this.needStatusBarPlace = r119;
    }

    public /* synthetic */ HeaderContentModel(HeaderMediaModel r110, HeaderSliceModel r210, IAction r211, Map r212, Map r213, Config r214, j r215, boolean r216, Float r217, Float r218, Float r219, Float r310, i r311, r r312, boolean r313, Integer r314, boolean r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        HeaderMediaModel r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        HeaderSliceModel r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        IAction r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        Map r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        Map r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        Config r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        j r106 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        boolean r107 = false;
    L35:
        if ((r316 & 256) == 0) goto L37;
        Float r111 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Float r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Float r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        Float r114 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        i r115 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        r r108 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        boolean r116 = false;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        Integer r117 = null;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        boolean r109 = false;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r108, r116, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r116 = r313;
        goto L63
    L57:
        r108 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
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

package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\b\u0018\u0000 [2\u00020\u0001:\u0001\\B©\u0001\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0015\u0012\u001c\b\u0002\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u001d\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003J²\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00152\u001c\b\u0002\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00192\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0004\b(\u0010)J\t\u0010+\u001a\u00020*HÖ\u0001J\t\u0010-\u001a\u00020,HÖ\u0001J\u0013\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003R\u001d\u00106\u001a\u0004\u0018\u00010\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u00109R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010<R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\b=\u0010<R\u001c\u0010 \u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010@R\u001c\u0010!\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010D\u001a\u0004\bG\u0010FR\u001c\u0010$\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010H\u001a\u0004\bI\u0010\u0014R\u001c\u0010%\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010J\u001a\u0004\bK\u0010LR<\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b&\u0010M\u0012\u0004\bR\u0010S\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010'\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006]"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonMeta;", "getBottomButtonMetaValue", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getAddCartComponent", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "component1", "", "Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonElement;", "component2", "component3", "Lcom/bytedance/android/shopping/anchorv4/bottom/Divider;", "component4", "component5", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "component6", "component7", "", "component8", "()Ljava/lang/Float;", "Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonConfig;", "component9", "Lrg/a;", "Lfi3/n;", "Lcom/bytedance/android/shopping/anchorv4/bottom/UIAction;", "component10", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "component11", "leftItems", "rightButtons", "rightButtonsSmallMode", "rightButtonDivider", "tipVO", "lynxTip", "superMarketVO", "bottomValidHeightRatio", "bottomButtonConfig", "showSkuAction", "component", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/bottom/Divider;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;Ljava/lang/Float;Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonConfig;Lrg/a;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonVO;", "", "toString", "", "hashCode", "", "other", "", "equals", "bottomButtonMeta$delegate", "Lkotlin/Lazy;", "getBottomButtonMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonMeta;", "bottomButtonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getLeftItems", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "Ljava/util/List;", "getRightButtons", "()Ljava/util/List;", "getRightButtonsSmallMode", "Lcom/bytedance/android/shopping/anchorv4/bottom/Divider;", "getRightButtonDivider", "()Lcom/bytedance/android/shopping/anchorv4/bottom/Divider;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getTipVO", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "getLynxTip", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "getSuperMarketVO", "Ljava/lang/Float;", "getBottomValidHeightRatio", "Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonConfig;", "getBottomButtonConfig", "()Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonConfig;", "Lrg/a;", "getShowSkuAction", "()Lrg/a;", "setShowSkuAction", "(Lrg/a;)V", "getShowSkuAction$annotations", "()V", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "getComponent", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "setComponent", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/bottom/Divider;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;Ljava/lang/Float;Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonConfig;Lrg/a;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomButtonVO implements Serializable {
    public static final a Companion = null;

    @SerializedName("config")
    private final BottomButtonConfig bottomButtonConfig;
    private final Lazy bottomButtonMeta$delegate;

    @SerializedName("bottom_valid_height_ratio")
    private final Float bottomValidHeightRatio;

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private ComponentDTO f165723component;

    @SerializedName("left_items")
    private final TagsScrollBoxComponent leftItems;

    @SerializedName("lynx_tip")
    private final LynxCardComponent lynxTip;

    @SerializedName("right_button_divider")
    private final Divider rightButtonDivider;

    @SerializedName("right_buttons")
    private final List<BottomButtonElement> rightButtons;

    @SerializedName("right_buttons_small_mode")
    private final List<BottomButtonElement> rightButtonsSmallMode;

    @SerializedName("showSkuAction")
    private rg.a<fi3.n> showSkuAction;

    @SerializedName("supermarket")
    private final LynxCardComponent superMarketVO;

    @SerializedName(AppConstants.BUNDLE_TIP)
    private final TextWithOneIconElement tipVO;

    public static final class a {
        public a() {
        }

        public static BottomButtonVO a(ComponentDTO r100) {
            if (r100 != null) goto L14;
            return null;
        L14:
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
            VO r102 = r100.getVo();     // Catch: Throwable -> L11
            if (r102 == null) goto L8;
            JsonObject r103 = r102.getDisplay();     // Catch: Throwable -> L11
        L9:
            Object r104 = u0.a(r103, BottomButtonVO.class);     // Catch: Throwable -> L11
            ((BottomButtonVO) r104).setComponent(r100);     // Catch: Throwable -> L11
            return (BottomButtonVO) r104;
        L8:
            r103 = null;
        L11:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static BottomButtonVO b(ComponentDTO r100, V4NativeParams r101, BottomButtonVO r102) {
            Integer r103 = null;
            Object[] r104 = 0;
            if (r100 != null) goto L31;
            return null;
        L31:
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L28
            VO r106 = r100.getVo();     // Catch: Throwable -> L28
            if (r106 == null) goto L8;
            JsonObject r107 = r106.getDisplay();     // Catch: Throwable -> L28
        L9:
            Object r108 = u0.a(r107, BottomButtonVO.class);     // Catch: Throwable -> L28
            BottomButtonVO r109 = (BottomButtonVO) r108;     // Catch: Throwable -> L28
            int r110 = 0;
            if (r101 == null) goto L12;
            int r111 = r101.getShowSkuPanel();     // Catch: Throwable -> L28
        L13:
            if (r111 <= 0) goto L26;
            if (r102 == null) goto L22;
            rg.a<fi3.n> r112 = r102.getShowSkuAction();     // Catch: Throwable -> L28
            if (r112 == null) goto L22;
            fi3.n r113 = r112.f537663b;     // Catch: Throwable -> L28
            if (r113 == null) goto L22;
            Integer r114 = r113.b();     // Catch: Throwable -> L28
            if (r114 == null) goto L22;
            int r115 = r114.intValue();     // Catch: Throwable -> L28
        L23:
            if (r115 > 0) goto L26;
            if (r101 == null) goto L26;
            r110 = r101.getShowSkuPanel();     // Catch: Throwable -> L28
        L22:
            r115 = 0;
        L26:
            r109.setShowSkuAction(new rg.a(new fi3.n(r103, Integer.valueOf(r110), r104 == true ? 1 : 0, 13)));     // Catch: Throwable -> L28
            r109.setComponent(r100);     // Catch: Throwable -> L28
            return (BottomButtonVO) r108;
        L12:
            r111 = 0;
            goto L13
        L8:
            r107 = null;
        L28:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public BottomButtonVO() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BottomButtonVO copy$default(BottomButtonVO r110, TagsScrollBoxComponent r111, List r112, List r113, Divider r114, TextWithOneIconElement r115, LynxCardComponent r116, LynxCardComponent r117, Float r210, BottomButtonConfig r211, rg.a r212, ComponentDTO r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        TagsScrollBoxComponent r100 = r110.leftItems;
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r101 = r110.rightButtons;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r102 = r110.rightButtonsSmallMode;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Divider r103 = r110.rightButtonDivider;
    L19:
        if ((r214 & 16) == 0) goto L21;
        TextWithOneIconElement r104 = r110.tipVO;
    L23:
        if ((r214 & 32) == 0) goto L25;
        LynxCardComponent r105 = r110.lynxTip;
    L27:
        if ((r214 & 64) == 0) goto L29;
        LynxCardComponent r106 = r110.superMarketVO;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Float r107 = r110.bottomValidHeightRatio;
    L35:
        if ((r214 & 256) == 0) goto L37;
        BottomButtonConfig r118 = r110.bottomButtonConfig;
    L39:
        if ((r214 & 512) == 0) goto L41;
        rg.a r119 = r110.showSkuAction;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        ComponentDTO r108 = r110.f165723component;
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

    @Deprecated(message = "没地方用了，新链路没解析")
    public static /* synthetic */ void getShowSkuAction$annotations() {
    }

    public final TagsScrollBoxComponent component1() {
        return this.leftItems;
    }

    public final rg.a<fi3.n> component10() {
        return this.showSkuAction;
    }

    public final ComponentDTO component11() {
        return this.f165723component;
    }

    public final List<BottomButtonElement> component2() {
        return this.rightButtons;
    }

    public final List<BottomButtonElement> component3() {
        return this.rightButtonsSmallMode;
    }

    public final Divider component4() {
        return this.rightButtonDivider;
    }

    public final TextWithOneIconElement component5() {
        return this.tipVO;
    }

    public final LynxCardComponent component6() {
        return this.lynxTip;
    }

    public final LynxCardComponent component7() {
        return this.superMarketVO;
    }

    public final Float component8() {
        return this.bottomValidHeightRatio;
    }

    public final BottomButtonConfig component9() {
        return this.bottomButtonConfig;
    }

    public final BottomButtonVO copy(TagsScrollBoxComponent r110, List<BottomButtonElement> r111, List<BottomButtonElement> r112, Divider r113, TextWithOneIconElement r114, LynxCardComponent r115, LynxCardComponent r210, Float r211, BottomButtonConfig r212, rg.a<fi3.n> r213, ComponentDTO r214) {
        return new BottomButtonVO(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BottomButtonVO) == false) goto L28;
        BottomButtonVO r101 = (BottomButtonVO) r100;
        if (Intrinsics.areEqual(this.leftItems, r101.leftItems) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rightButtons, r101.rightButtons) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rightButtonsSmallMode, r101.rightButtonsSmallMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightButtonDivider, r101.rightButtonDivider) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tipVO, r101.tipVO) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.lynxTip, r101.lynxTip) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.superMarketVO, r101.superMarketVO) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bottomValidHeightRatio, r101.bottomValidHeightRatio) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bottomButtonConfig, r101.bottomButtonConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showSkuAction, r101.showSkuAction) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f165723component, r101.f165723component) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final BottomButtonMeta getBottomButtonMeta() {
        return (BottomButtonMeta) this.bottomButtonMeta$delegate.getValue();
    }

    public int hashCode() {
        TagsScrollBoxComponent r100 = this.leftItems;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<BottomButtonElement> r104 = this.rightButtons;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<BottomButtonElement> r107 = this.rightButtonsSmallMode;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Divider r110 = this.rightButtonDivider;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        TextWithOneIconElement r113 = this.tipVO;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        LynxCardComponent r116 = this.lynxTip;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        LynxCardComponent r119 = this.superMarketVO;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.bottomValidHeightRatio;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        BottomButtonConfig r125 = this.bottomButtonConfig;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        rg.a<fi3.n> r128 = this.showSkuAction;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        ComponentDTO r131 = this.f165723component;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
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
        return "BottomButtonVO(leftItems=" + this.leftItems + ", rightButtons=" + this.rightButtons + ", rightButtonsSmallMode=" + this.rightButtonsSmallMode + ", rightButtonDivider=" + this.rightButtonDivider + ", tipVO=" + this.tipVO + ", lynxTip=" + this.lynxTip + ", superMarketVO=" + this.superMarketVO + ", bottomValidHeightRatio=" + this.bottomValidHeightRatio + ", bottomButtonConfig=" + this.bottomButtonConfig + ", showSkuAction=" + this.showSkuAction + ", component=" + this.f165723component + ")";
    }

    public final TextWithOneIconElement getAddCartComponent() {
        TagsScrollBoxComponent r100 = this.leftItems;
        if (r100 == null) goto L12;
        List<TextWithOneIconElement> r101 = r100.getButtonList();
        if (r101 == null) goto L17;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        TextWithOneIconElement r103 = (TextWithOneIconElement) r102.next();
        if (Intrinsics.areEqual(r103.getElementId(), "购物车") == false) goto L8;
        return r103;
    L18:
        return null;
    L17:
        return null;
    L12:
        return null;
    }

    public final BottomButtonMeta getBottomButtonMetaValue() {
        return getBottomButtonMeta();
    }

    public final BottomButtonConfig getBottomButtonConfig() {
        return this.bottomButtonConfig;
    }

    public final Float getBottomValidHeightRatio() {
        return this.bottomValidHeightRatio;
    }

    public final ComponentDTO getComponent() {
        return this.f165723component;
    }

    public final TagsScrollBoxComponent getLeftItems() {
        return this.leftItems;
    }

    public final LynxCardComponent getLynxTip() {
        return this.lynxTip;
    }

    public final Divider getRightButtonDivider() {
        return this.rightButtonDivider;
    }

    public final List<BottomButtonElement> getRightButtons() {
        return this.rightButtons;
    }

    public final List<BottomButtonElement> getRightButtonsSmallMode() {
        return this.rightButtonsSmallMode;
    }

    public final rg.a<fi3.n> getShowSkuAction() {
        return this.showSkuAction;
    }

    public final LynxCardComponent getSuperMarketVO() {
        return this.superMarketVO;
    }

    public final TextWithOneIconElement getTipVO() {
        return this.tipVO;
    }

    public final void setComponent(ComponentDTO r100) {
        this.f165723component = r100;
    }

    public final void setShowSkuAction(rg.a<fi3.n> r100) {
        this.showSkuAction = r100;
    }

    public BottomButtonVO(TagsScrollBoxComponent r100, List<BottomButtonElement> r101, List<BottomButtonElement> r102, Divider r103, TextWithOneIconElement r104, LynxCardComponent r105, LynxCardComponent r106, Float r107, BottomButtonConfig r108, rg.a<fi3.n> r110, ComponentDTO r111) {
        this.leftItems = r100;
        this.rightButtons = r101;
        this.rightButtonsSmallMode = r102;
        this.rightButtonDivider = r103;
        this.tipVO = r104;
        this.lynxTip = r105;
        this.superMarketVO = r106;
        this.bottomValidHeightRatio = r107;
        this.bottomButtonConfig = r108;
        this.showSkuAction = r110;
        this.f165723component = r111;
        this.bottomButtonMeta$delegate = LazyKt.lazy(new BottomButtonVO$bottomButtonMeta$2(this));
    }

    public /* synthetic */ BottomButtonVO(TagsScrollBoxComponent r110, List r111, List r112, Divider r113, TextWithOneIconElement r114, LynxCardComponent r115, LynxCardComponent r116, Float r210, BottomButtonConfig r211, rg.a r212, ComponentDTO r213, int r214, DefaultConstructorMarker r215) {
        ComponentDTO r100 = null;
        if ((r214 & 1) == 0) goto L5;
        TagsScrollBoxComponent r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Divider r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        TextWithOneIconElement r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        LynxCardComponent r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        LynxCardComponent r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Float r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        BottomButtonConfig r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        rg.a r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
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

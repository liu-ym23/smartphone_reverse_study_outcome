package com.alibaba.gaiax.template;

import android.content.res.AssetManager;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.bytedance.android.ecom.arch.slice.render.SlcDisplay;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.canvas.KryptonCamera;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import u.d;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\bF\u0010GJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0006J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\nJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\nJ\u0010\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u001aJ\u0010\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010(\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010+\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010.\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010/\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\nJ\u0010\u00100\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006J(\u00108\u001a\u0004\u0018\u0001072\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205J\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\"0;2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001a09J\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001a092\u0006\u0010:\u001a\u00020\u001aJ\u0014\u0010>\u001a\u0002032\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001a09J\u0017\u0010?\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b?\u0010\u0011R\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/alibaba/gaiax/template/GXStyleConvert;", "", "Landroid/content/res/AssetManager;", "assetManager", "", "init", "Lorg/json/JSONObject;", GXTemplateKey.GAIAX_CSS, "", "textDecoration", "(Lorg/json/JSONObject;)Ljava/lang/Integer;", "cssJson", "Lu/d;", "Lcom/alibaba/gaiax/template/GXSize;", GXTemplateKey.FLEXBOX_PADDING, "", "overflow", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "", GXTemplateKey.STYLE_OPACITY, "(Lorg/json/JSONObject;)Ljava/lang/Float;", "Lcom/alibaba/gaiax/template/GXMode;", "mode", "hidden", "Landroid/graphics/Typeface;", "fontWeight", "", "value", "Landroid/text/TextUtils$TruncateAt;", "fontTextOverflow", "fontTextAlign", "fontLines", "fontFamily", LynxResourceModule.FONT_TYPE, "Lcom/alibaba/gaiax/template/GXColor;", "backgroundColor", "Lcom/alibaba/gaiax/template/GXBoxShadow;", "boxShadow", "Lcom/alibaba/gaiax/template/GXBackdropFilter;", "backdropFilter", "fontColor", "Lcom/alibaba/gaiax/template/GXLinearColor;", "backgroundImage", "borderColor", "Lcom/alibaba/gaiax/template/GXRoundedCorner;", "borderRadius", "borderWidth", "display", "fontLineHeight", "width", "height", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "direction", "", "colors", "Landroid/graphics/Shader;", "createLinearGradient", "", "linear", "", "getLinearGradientColors", "getLinearGradient", "getDirection", "fitContent", ChameleonAssertResManager.ASSET_FOLDER, "Landroid/content/res/AssetManager;", "getAssets", "()Landroid/content/res/AssetManager;", "setAssets", "(Landroid/content/res/AssetManager;)V", "<init>", "()V", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class GXStyleConvert {
    public static final Companion Companion = null;
    private static final Lazy<GXStyleConvert> instance$delegate = null;
    public AssetManager assets;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/template/GXStyleConvert$Companion;", "", "()V", "instance", "Lcom/alibaba/gaiax/template/GXStyleConvert;", "getInstance", "()Lcom/alibaba/gaiax/template/GXStyleConvert;", "instance$delegate", "Lkotlin/Lazy;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXStyleConvert getInstance() {
            return (GXStyleConvert) GXStyleConvert.access$getInstance$delegate$cp().getValue();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[GradientDrawable.Orientation.values().length];
            r100[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[GradientDrawable.Orientation.TL_BR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[GradientDrawable.Orientation.TR_BL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[GradientDrawable.Orientation.BR_TL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[GradientDrawable.Orientation.BL_TR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public GXStyleConvert() {
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(GXStyleConvert$Companion$instance$2.INSTANCE);
    }

    public final AssetManager getAssets() {
        AssetManager r100 = this.assets;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ChameleonAssertResManager.ASSET_FOLDER);
        return null;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    public final GXBackdropFilter backdropFilter(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_BACKDROP_FILTER, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return GXBackdropFilter.Companion.create(r101);
    }

    public final GXColor backgroundColor(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_BACKGROUND_COLOR, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return GXColor.Companion.create(r101);
    }

    public final GXLinearColor backgroundImage(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_BACKGROUND_IMAGE, null);
        if (r101 != null) goto L5;
    L12:
        return null;
    L5:
        if (StringsKt.startsWith$default(r101, "linear-gradient", false, 2, null) == false) goto L8;
        List<String> r102 = getLinearGradient(r101);
        List<GXColor> r103 = getLinearGradientColors(r102);
        return new GXLinearColor(getDirection(r102), r103);
    L8:
        GXColor r104 = GXColor.Companion.create(r101);
        if (r104 == null) goto L12;
        ArrayList r105 = new ArrayList();
        r105.add(r104);
        return new GXLinearColor(GradientDrawable.Orientation.LEFT_RIGHT, r105);
    }

    public final GXColor borderColor(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_BORDER_COLOR, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return GXColor.Companion.create(r101);
    }

    public final GXRoundedCorner borderRadius(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_BORDER_RADIUS, null);
        if (r101 == null) goto L5;
        GXSize r102 = GXSize.Companion.create(r101);
        GXRoundedCorner r103 = new GXRoundedCorner(r102, r102, r102, r102);
    L6:
        String r104 = r100.optString(GXTemplateKey.STYLE_BORDER_TOP_LEFT_RADIUS, null);
        if (r104 == null) goto L11;
        if (r103 != null) goto L10;
        r103 = new GXRoundedCorner(null, null, null, null);
    L10:
        r103.setTopLeft(GXSize.Companion.create(r104));
    L11:
        String r105 = r100.optString(GXTemplateKey.STYLE_BORDER_TOP_RIGHT_RADIUS, null);
        if (r105 == null) goto L16;
        if (r103 != null) goto L15;
        r103 = new GXRoundedCorner(null, null, null, null);
    L15:
        r103.setTopRight(GXSize.Companion.create(r105));
    L16:
        String r106 = r100.optString(GXTemplateKey.STYLE_BORDER_BOTTOM_LEFT_RADIUS, null);
        if (r106 == null) goto L21;
        if (r103 != null) goto L20;
        r103 = new GXRoundedCorner(null, null, null, null);
    L20:
        r103.setBottomLeft(GXSize.Companion.create(r106));
    L21:
        String r107 = r100.optString(GXTemplateKey.STYLE_BORDER_BOTTOM_RIGHT_RADIUS, null);
        if (r107 == null) goto L26;
        if (r103 != null) goto L25;
        r103 = new GXRoundedCorner(null, null, null, null);
    L25:
        r103.setBottomRight(GXSize.Companion.create(r107));
    L26:
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    public final GXSize borderWidth(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_BORDER_WIDTH, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return GXSize.Companion.create(r101);
    }

    public final GXBoxShadow boxShadow(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_CSS);
        String r100 = r110.optString(GXTemplateKey.STYLE_BOX_SHADOW, null);
        if (r100 == null) goto L11;
        List r111 = StringsKt.split$default(r100, new String[]{" "}, false, 0, 6, null);
        if (r111.size() != 5) goto L11;
        String r101 = (String) ListProtector.get(r111, 0);
        String r102 = (String) ListProtector.get(r111, 1);
        String r103 = (String) ListProtector.get(r111, 2);
        String r104 = (String) ListProtector.get(r111, 3);
        String r112 = (String) ListProtector.get(r111, 4);
        GXSize.Companion r105 = GXSize.Companion;
        GXSize r106 = r105.create(r101);
        GXSize r107 = r105.create(r102);
        GXSize r108 = r105.create(r103);
        GXSize r109 = r105.create(r104);
        GXColor.Companion r113 = GXColor.Companion;
        GXColor r114 = r113.create(r112);
        if (r114 != null) goto L10;
        r114 = r113.createUndefine();
    L10:
        return new GXBoxShadow(r106, r107, r108, r109, r114);
    L11:
        return null;
    }

    public final Integer display(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString("display");
        if (Intrinsics.areEqual(r101, "none") == false) goto L6;
        return 8;
    L6:
        if (Intrinsics.areEqual(r101, SlcDisplay.FLEX) == true) goto L11;
        return null;
    L11:
        return 0;
    }

    public final Boolean fitContent(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        if (r100.has(GXTemplateKey.STYLE_FIT_CONTENT) == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.optBoolean(GXTemplateKey.STYLE_FIT_CONTENT));
    }

    public final GXSize font(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_FONT_SIZE, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return GXSize.Companion.create(r101);
    }

    public final GXColor fontColor(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString("color", null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return GXColor.Companion.create(r101);
    }

    public final Typeface fontFamily(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fontFamily");
        GXRegisterCenterApi.GXIExtensionStaticProperty r101 = GXRegisterCenter.Companion.getInstance().getExtensionStaticProperty$GaiaX();
        if (r101 == null) goto L12;
        Object r102 = r101.convert(new GXRegisterCenterApi.GXIExtensionStaticProperty.GXParams(GXTemplateKey.STYLE_FONT_FAMILY, r100));
        if (r102 == null) goto L12;
        if ((r102 instanceof Typeface) == false) goto L9;
        Typeface r103 = (Typeface) r102;
    L10:
        if (r103 == null) goto L12;
        return r103;
    L9:
        r103 = null;
    L12:
        return null;
    }

    public final GXSize fontLineHeight(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_FONT_LINE_HEIGHT, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return GXSize.Companion.create(r101);
    }

    public final Integer fontLines(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_FONT_LINES, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(CastIntegerProtector.parseInt(r101));
    }

    public final Integer fontTextAlign(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_FONT_TEXT_ALIGN);
        if (r101 == null) goto L23;
        int r102 = r101.hashCode();
        if (r102 == (-1364013995)) goto L20;
        if (r102 == 3317767) goto L16;
        if (r102 != 108511772) goto L23;
        if (r101.equals("right") == false) goto L23;
        return 5;
    L16:
        if (r101.equals("left") == false) goto L23;
        return 3;
    L20:
        if (r101.equals("center") == false) goto L23;
        return 17;
    L23:
        return null;
    }

    public final TextUtils.TruncateAt fontTextOverflow(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_FONT_TEXT_OVERFLOW);
        if (r101 == null) goto L30;
        int r102 = r101.hashCode();
        if (r102 == (-1074341483)) goto L26;
        if (r102 == 3056464) goto L16;
        if (r102 != 188702929) goto L30;
        if (r101.equals("ellipsis") == false) goto L30;
        return TextUtils.TruncateAt.END;
    L16:
        if (r101.equals("clip") == false) goto L30;
        GXRegisterCenterApi.GXIExtensionStaticProperty r103 = GXRegisterCenter.Companion.getInstance().getExtensionStaticProperty$GaiaX();
        if (r103 == null) goto L24;
        Object r104 = r103.convert(new GXRegisterCenterApi.GXIExtensionStaticProperty.GXParams(GXTemplateKey.STYLE_FONT_TEXT_OVERFLOW, "clip"));
        if (r104 == null) goto L24;
        return (TextUtils.TruncateAt) r104;
    L24:
        return null;
    L26:
        if (r101.equals("middle") == false) goto L30;
        return TextUtils.TruncateAt.MIDDLE;
    L30:
        return TextUtils.TruncateAt.END;
    }

    public final Typeface fontWeight(String r100) {
        if (r100 != null) goto L4;
    L37:
        return null;
    L4:
        switch(r100.hashCode()) {
            case -1078030475: goto L35;
            case -1039745817: goto L31;
            case 48625: goto L28;
            case 49586: goto L25;
            case 50547: goto L22;
            case 51508: goto L19;
            case 52469: goto L16;
            case 53430: goto L13;
            case 54391: goto L10;
            case 3029637: goto L7;
            default: goto L37;
        };
    L7:
        if (r100.equals(CommodityText.BOLD) == false) goto L37;
    L40:
        return Typeface.DEFAULT_BOLD;
    L10:
        if (r100.equals("700") == true) goto L40;
    L13:
        if (r100.equals("600") == true) goto L40;
    L16:
        if (r100.equals("500") == true) goto L40;
    L19:
        if (r100.equals("400") == false) goto L37;
    L39:
        return Typeface.DEFAULT;
    L22:
        if (r100.equals("300") == true) goto L39;
    L25:
        if (r100.equals("200") == true) goto L39;
    L28:
        if (r100.equals("100") == true) goto L39;
    L31:
        if (r100.equals("normal") == true) goto L39;
    L35:
        if (r100.equals(KryptonCamera.Config.RESOLUTION_MEDIUM) == false) goto L37;
        goto L37
    }

    public final GradientDrawable.Orientation getDirection(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "linear");
        if ((!r100.isEmpty()) == false) goto L74;
        String r101 = (String) ListProtector.get(r100, 0);
        switch(r101.hashCode()) {
            case -2080783504: goto L68;
            case -1849920841: goto L64;
            case -1507310228: goto L60;
            case -1486250643: goto L56;
            case -1359525897: goto L52;
            case -1352032154: goto L48;
            case -1213049204: goto L44;
            case -1137407871: goto L40;
            case -1033506462: goto L36;
            case -870406608: goto L32;
            case -868157182: goto L28;
            case -172068863: goto L24;
            case 110550266: goto L20;
            case 810031148: goto L16;
            case 1055841335: goto L12;
            case 1176531318: goto L8;
            default: goto L72;
        };
    L8:
        if (r101.equals("tobottomright") == false) goto L72;
        return GradientDrawable.Orientation.TL_BR;
    L12:
        if (r101.equals("to right") == false) goto L72;
        return GradientDrawable.Orientation.LEFT_RIGHT;
    L16:
        if (r101.equals("to top right") == false) goto L72;
        return GradientDrawable.Orientation.BL_TR;
    L20:
        if (r101.equals("totop") == false) goto L72;
        return GradientDrawable.Orientation.BOTTOM_TOP;
    L24:
        if (r101.equals("totopleft") == false) goto L72;
        return GradientDrawable.Orientation.BR_TL;
    L28:
        if (r101.equals("toleft") == false) goto L72;
        return GradientDrawable.Orientation.RIGHT_LEFT;
    L32:
        if (r101.equals("to top") == false) goto L72;
        return GradientDrawable.Orientation.BOTTOM_TOP;
    L36:
        if (r101.equals("totopright") == false) goto L72;
        return GradientDrawable.Orientation.BL_TR;
    L40:
        if (r101.equals("toright") == false) goto L72;
        return GradientDrawable.Orientation.LEFT_RIGHT;
    L44:
        if (r101.equals("to left") == false) goto L72;
        return GradientDrawable.Orientation.RIGHT_LEFT;
    L48:
        if (r101.equals("tobottom") == false) goto L72;
        return GradientDrawable.Orientation.TOP_BOTTOM;
    L52:
        if (r101.equals("to top left") == false) goto L72;
        return GradientDrawable.Orientation.BR_TL;
    L56:
        if (r101.equals("tobottomleft") == false) goto L72;
        return GradientDrawable.Orientation.TR_BL;
    L60:
        if (r101.equals("to bottom right") == false) goto L72;
        return GradientDrawable.Orientation.TL_BR;
    L64:
        if (r101.equals("to bottom left") == false) goto L72;
        return GradientDrawable.Orientation.TR_BL;
    L68:
        if (r101.equals("to bottom") == false) goto L72;
        return GradientDrawable.Orientation.TOP_BOTTOM;
    L72:
        return GradientDrawable.Orientation.TOP_BOTTOM;
    L74:
        return GradientDrawable.Orientation.TOP_BOTTOM;
    }

    public final List<String> getLinearGradient(String r110) {
        Intrinsics.checkNotNullParameter(r110, "linear");
        ArrayList r100 = new ArrayList();
        String r101 = r110.substring(StringsKt.indexOf$default(r110, "(", 0, false, 6, null) + 1, StringsKt.lastIndexOf$default(r110, ")", 0, false, 6, null));     // Catch: Exception -> L39
        if (StringsKt.contains$default(r101, "rgba", false, 2, null) == false) goto L20;
        Iterator r102 = StringsKt.split$default(r101, new String[]{"rgba"}, false, 0, 6, null).iterator();     // Catch: Exception -> L39
        int r103 = 0;
    L8:
        if (r102.hasNext() == false) goto L41;
        Object r104 = r102.next();     // Catch: Exception -> L39
        int r105 = r103 + 1;     // Catch: Exception -> L39
        if (r103 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L39
    L12:
        String r106 = StringsKt.trim((String) r104).toString();     // Catch: Exception -> L39
        if (StringsKt.endsWith$default(r106, ",", false, 2, null) == false) goto L15;
        r106 = r106.substring(0, r106.length() - 1);     // Catch: Exception -> L39
    L15:
        if (r103 <= 0) goto L17;
        r100.add("rgba" + r106);     // Catch: Exception -> L39
    L18:
        r103 = r105;
        goto L8
    L17:
        r100.add(r106);     // Catch: Exception -> L39
    L41:
        return r100;
    L20:
        if (StringsKt.contains$default(r101, "rgb", false, 2, null) == false) goto L34;
        Iterator r107 = StringsKt.split$default(r101, new String[]{"rgb"}, false, 0, 6, null).iterator();     // Catch: Exception -> L39
        int r108 = 0;
    L23:
        if (r107.hasNext() == false) goto L41;
        Object r109 = r107.next();     // Catch: Exception -> L39
        int r111 = r108 + 1;     // Catch: Exception -> L39
        if (r108 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L39
    L27:
        String r112 = StringsKt.trim((String) r109).toString();     // Catch: Exception -> L39
        if (StringsKt.endsWith$default(r112, ",", false, 2, null) == false) goto L30;
        r112 = r112.substring(0, r112.length() - 1);     // Catch: Exception -> L39
    L30:
        if (r108 <= 0) goto L32;
        r100.add("rgb" + r112);     // Catch: Exception -> L39
    L33:
        r108 = r111;
        goto L23
    L32:
        r100.add(r112);     // Catch: Exception -> L39
        goto L33
    L34:
        Iterator r113 = StringsKt.split$default(r101, new String[]{","}, false, 0, 6, null).iterator();     // Catch: Exception -> L39
    L36:
        if (r113.hasNext() == false) goto L41;
        r100.add(StringsKt.trim((String) r113.next()).toString());     // Catch: Exception -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L41
    }

    public final List<GXColor> getLinearGradientColors(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "linear");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        if (StringsKt.startsWith$default(r103, RemoteMessageConst.TO, false, 2, null) == true) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L16;
        String r106 = (String) r105.next();
        GXColor r107 = GXColor.Companion.create(r106);
        if (r107 == null) goto L15;
        r104.add(r107);
        goto L10
    L15:
        throw new IllegalArgumentException("linearColor create color error");
    L16:
        return r104;
    }

    public final Integer hidden(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString("hidden");
        if (Intrinsics.areEqual(r101, "true") == false) goto L6;
        return 4;
    L6:
        if (Intrinsics.areEqual(r101, "false") == true) goto L11;
        return null;
    L11:
        return 0;
    }

    public final void init(AssetManager r100) {
        Intrinsics.checkNotNullParameter(r100, "assetManager");
        setAssets(r100);
    }

    public final GXMode mode(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        if (r100.has("mode") == false) goto L6;
        String r101 = r100.optString("mode", "scaleToFill");
        return new GXMode(r100.optString(GXTemplateKey.STYLE_MODE_TYPE, "scale"), r101);
    L6:
        return null;
    }

    public final Float opacity(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_OPACITY, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return Float.valueOf(CastFloatProtector.parseFloat(r101));
    }

    public final Boolean overflow(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString("overflow");
        if (Intrinsics.areEqual(r101, "visible") == false) goto L6;
        return Boolean.FALSE;
    L6:
        if (Intrinsics.areEqual(r101, "hidden") == true) goto L11;
        return null;
    L11:
        return Boolean.TRUE;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, com.alibaba.gaiax.template.GXSize] */
    /* JADX WARN: Type inference failed for: r0v13, types: [T, com.alibaba.gaiax.template.GXSize] */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, com.alibaba.gaiax.template.GXSize] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, com.alibaba.gaiax.template.GXSize] */
    public final d<GXSize> padding(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_PADDING, null);
        if (r101 == null) goto L5;
        GXSize r102 = GXSize.Companion.create(r101);
        d<GXSize> r103 = new d(r102, r102, r102, r102);
    L6:
        String r104 = r100.optString(GXTemplateKey.FLEXBOX_PADDING_LEFT, null);
        if (r104 == null) goto L11;
        if (r103 != null) goto L10;
        GXSize.Undefined r105 = GXSize.Undefined.INSTANCE;
        r103 = new d(r105, r105, r105, r105);
    L10:
        r103.f548090a = GXSize.Companion.create(r104);
    L11:
        String r106 = r100.optString(GXTemplateKey.FLEXBOX_PADDING_RIGHT, null);
        if (r106 == null) goto L16;
        if (r103 != null) goto L15;
        GXSize.Undefined r107 = GXSize.Undefined.INSTANCE;
        r103 = new d(r107, r107, r107, r107);
    L15:
        r103.f548091b = GXSize.Companion.create(r106);
    L16:
        String r108 = r100.optString(GXTemplateKey.FLEXBOX_PADDING_TOP, null);
        if (r108 == null) goto L21;
        if (r103 != null) goto L20;
        GXSize.Undefined r109 = GXSize.Undefined.INSTANCE;
        r103 = new d(r109, r109, r109, r109);
    L20:
        r103.f548092c = GXSize.Companion.create(r108);
    L21:
        String r110 = r100.optString(GXTemplateKey.FLEXBOX_PADDING_BOTTOM, null);
        if (r110 == null) goto L26;
        if (r103 != null) goto L25;
        GXSize.Undefined r111 = GXSize.Undefined.INSTANCE;
        r103 = new d(r111, r111, r111, r111);
    L25:
        r103.f548093d = GXSize.Companion.create(r110);
    L26:
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    public final void setAssets(AssetManager r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.assets = r100;
    }

    public final Integer textDecoration(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_FONT_TEXT_DECORATION);
        if (Intrinsics.areEqual(r101, SegmentStyle.LINE_THROUGH) == false) goto L6;
        return 16;
    L6:
        if (Intrinsics.areEqual(r101, SegmentStyle.UNDERLINE) == true) goto L11;
        return null;
    L11:
        return 8;
    }

    public final Typeface fontFamily(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_FONT_FAMILY, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return fontFamily(r101);
    }

    public final Typeface fontWeight(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        String r101 = r100.optString(GXTemplateKey.STYLE_FONT_WEIGHT, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return fontWeight(r101);
    }

    public final Shader createLinearGradient(float r110, float r111, GradientDrawable.Orientation r112, int[] r113) {
        Intrinsics.checkNotNullParameter(r112, "direction");
        Intrinsics.checkNotNullParameter(r113, "colors");
        switch(WhenMappings.$EnumSwitchMapping$0[r112.ordinal()]) {
            case 1: goto L13;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            default: goto L4;
        };
    L4:
        return null;
    L15:
        return new GXLinearColorGradient(0.0f, r111, r110, 0.0f, r113, null, Shader.TileMode.CLAMP);
    L16:
        return new GXLinearColorGradient(r110, r111, 0.0f, 0.0f, r113, null, Shader.TileMode.CLAMP);
    L17:
        return new GXLinearColorGradient(r110, 0.0f, 0.0f, r111, r113, null, Shader.TileMode.CLAMP);
    L18:
        return new GXLinearColorGradient(0.0f, 0.0f, r110, r111, r113, null, Shader.TileMode.CLAMP);
    L19:
        return new GXLinearColorGradient(r110, 0.0f, 0.0f, 0.0f, r113, null, Shader.TileMode.CLAMP);
    L20:
        return new GXLinearColorGradient(0.0f, 0.0f, r110, 0.0f, r113, null, Shader.TileMode.CLAMP);
    L21:
        return new GXLinearColorGradient(0.0f, r111, 0.0f, 0.0f, r113, null, Shader.TileMode.CLAMP);
    L13:
        return new GXLinearColorGradient(0.0f, 0.0f, 0.0f, r111, r113, null, Shader.TileMode.CLAMP);
    }
}

package com.alibaba.gaiax.template;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.utils.GXTemplateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import u.d;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b6\b\u0086\b\u0018\u0000 z2\u00020\u0001:\u0001zB¡\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bx\u0010yJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\rJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\rJ\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b$\u0010\rJ\u000b\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u001aJª\u0002\u0010C\u001a\u00020\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bC\u0010DJ\t\u0010F\u001a\u00020EHÖ\u0001J\t\u0010G\u001a\u00020\u000bHÖ\u0001J\u0013\u0010I\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010,\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b,\u0010J\u001a\u0004\bK\u0010LR\u0019\u0010-\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b-\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010.\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b.\u0010M\u001a\u0004\bP\u0010OR\u0019\u0010/\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b/\u0010Q\u001a\u0004\bR\u0010\rR\u0019\u00100\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b0\u0010S\u001a\u0004\bT\u0010UR\u0019\u00101\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b1\u0010V\u001a\u0004\bW\u0010XR\u0019\u00102\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b2\u0010Q\u001a\u0004\bY\u0010\rR\u0019\u00103\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b3\u0010S\u001a\u0004\bZ\u0010UR\u0019\u00104\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b4\u0010[\u001a\u0004\b\\\u0010]R\u0019\u00105\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b5\u0010^\u001a\u0004\b_\u0010\u0018R\u0019\u00106\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b6\u0010`\u001a\u0004\ba\u0010\u001aR\u0019\u00107\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b7\u0010Q\u001a\u0004\bb\u0010\rR\u0019\u00108\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b8\u0010Q\u001a\u0004\bc\u0010\rR\u001f\u00109\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b9\u0010d\u001a\u0004\be\u0010fR\u0019\u0010:\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b:\u0010J\u001a\u0004\bg\u0010LR\u0019\u0010;\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b;\u0010S\u001a\u0004\bh\u0010UR\u0019\u0010<\u001a\u0004\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b<\u0010i\u001a\u0004\bj\u0010kR\u0019\u0010=\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b=\u0010J\u001a\u0004\bl\u0010LR\u0019\u0010>\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b>\u0010Q\u001a\u0004\bm\u0010\rR\u0019\u0010?\u001a\u0004\u0018\u00010%8\u0006¢\u0006\f\n\u0004\b?\u0010n\u001a\u0004\bo\u0010pR\u0019\u0010@\u001a\u0004\u0018\u00010'8\u0006¢\u0006\f\n\u0004\b@\u0010q\u001a\u0004\br\u0010sR\u0019\u0010A\u001a\u0004\u0018\u00010)8\u0006¢\u0006\f\n\u0004\bA\u0010t\u001a\u0004\bu\u0010vR\u0019\u0010B\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bB\u0010`\u001a\u0004\bw\u0010\u001a¨\u0006{"}, d2 = {"Lcom/alibaba/gaiax/template/GXStyle;", "", "", "isEmpty", "isEmptyStyle", "isInvisible", "Lcom/alibaba/gaiax/template/GXSize;", "component1", "Landroid/graphics/Typeface;", "component2", "component3", "", "component4", "()Ljava/lang/Integer;", "Lcom/alibaba/gaiax/template/GXColor;", "component5", "Landroid/text/TextUtils$TruncateAt;", "component6", "component7", "component8", "Lcom/alibaba/gaiax/template/GXLinearColor;", "component9", "", "component10", "()Ljava/lang/Float;", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "Lu/d;", "component14", "component15", "component16", "Lcom/alibaba/gaiax/template/GXRoundedCorner;", "component17", "component18", "component19", "Lcom/alibaba/gaiax/template/GXMode;", "component20", "Lcom/alibaba/gaiax/template/GXBoxShadow;", "component21", "Lcom/alibaba/gaiax/template/GXBackdropFilter;", "component22", "component23", "fontSize", "fontFamily", "fontWeight", "fontLines", "fontColor", "fontTextOverflow", "fontTextAlign", "backgroundColor", "backgroundImage", GXTemplateKey.STYLE_OPACITY, "overflow", "display", "hidden", GXTemplateKey.FLEXBOX_PADDING, "borderWidth", "borderColor", "borderRadius", "fontLineHeight", "fontTextDecoration", "mode", "boxShadow", "backdropFilter", "fitContent", "copy", "(Lcom/alibaba/gaiax/template/GXSize;Landroid/graphics/Typeface;Landroid/graphics/Typeface;Ljava/lang/Integer;Lcom/alibaba/gaiax/template/GXColor;Landroid/text/TextUtils$TruncateAt;Ljava/lang/Integer;Lcom/alibaba/gaiax/template/GXColor;Lcom/alibaba/gaiax/template/GXLinearColor;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lu/d;Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXColor;Lcom/alibaba/gaiax/template/GXRoundedCorner;Lcom/alibaba/gaiax/template/GXSize;Ljava/lang/Integer;Lcom/alibaba/gaiax/template/GXMode;Lcom/alibaba/gaiax/template/GXBoxShadow;Lcom/alibaba/gaiax/template/GXBackdropFilter;Ljava/lang/Boolean;)Lcom/alibaba/gaiax/template/GXStyle;", "", "toString", "hashCode", "other", "equals", "Lcom/alibaba/gaiax/template/GXSize;", "getFontSize", "()Lcom/alibaba/gaiax/template/GXSize;", "Landroid/graphics/Typeface;", "getFontFamily", "()Landroid/graphics/Typeface;", "getFontWeight", "Ljava/lang/Integer;", "getFontLines", "Lcom/alibaba/gaiax/template/GXColor;", "getFontColor", "()Lcom/alibaba/gaiax/template/GXColor;", "Landroid/text/TextUtils$TruncateAt;", "getFontTextOverflow", "()Landroid/text/TextUtils$TruncateAt;", "getFontTextAlign", "getBackgroundColor", "Lcom/alibaba/gaiax/template/GXLinearColor;", "getBackgroundImage", "()Lcom/alibaba/gaiax/template/GXLinearColor;", "Ljava/lang/Float;", "getOpacity", "Ljava/lang/Boolean;", "getOverflow", "getDisplay", "getHidden", "Lu/d;", "getPadding", "()Lu/d;", "getBorderWidth", "getBorderColor", "Lcom/alibaba/gaiax/template/GXRoundedCorner;", "getBorderRadius", "()Lcom/alibaba/gaiax/template/GXRoundedCorner;", "getFontLineHeight", "getFontTextDecoration", "Lcom/alibaba/gaiax/template/GXMode;", "getMode", "()Lcom/alibaba/gaiax/template/GXMode;", "Lcom/alibaba/gaiax/template/GXBoxShadow;", "getBoxShadow", "()Lcom/alibaba/gaiax/template/GXBoxShadow;", "Lcom/alibaba/gaiax/template/GXBackdropFilter;", "getBackdropFilter", "()Lcom/alibaba/gaiax/template/GXBackdropFilter;", "getFitContent", "<init>", "(Lcom/alibaba/gaiax/template/GXSize;Landroid/graphics/Typeface;Landroid/graphics/Typeface;Ljava/lang/Integer;Lcom/alibaba/gaiax/template/GXColor;Landroid/text/TextUtils$TruncateAt;Ljava/lang/Integer;Lcom/alibaba/gaiax/template/GXColor;Lcom/alibaba/gaiax/template/GXLinearColor;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lu/d;Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXColor;Lcom/alibaba/gaiax/template/GXRoundedCorner;Lcom/alibaba/gaiax/template/GXSize;Ljava/lang/Integer;Lcom/alibaba/gaiax/template/GXMode;Lcom/alibaba/gaiax/template/GXBoxShadow;Lcom/alibaba/gaiax/template/GXBackdropFilter;Ljava/lang/Boolean;)V", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class GXStyle {
    public static final Companion Companion = null;
    private final GXBackdropFilter backdropFilter;
    private final GXColor backgroundColor;
    private final GXLinearColor backgroundImage;
    private final GXColor borderColor;
    private final GXRoundedCorner borderRadius;
    private final GXSize borderWidth;
    private final GXBoxShadow boxShadow;
    private final Integer display;
    private final Boolean fitContent;
    private final GXColor fontColor;
    private final Typeface fontFamily;
    private final GXSize fontLineHeight;
    private final Integer fontLines;
    private final GXSize fontSize;
    private final Integer fontTextAlign;
    private final Integer fontTextDecoration;
    private final TextUtils.TruncateAt fontTextOverflow;
    private final Typeface fontWeight;
    private final Integer hidden;
    private final GXMode mode;
    private final Float opacity;
    private final Boolean overflow;
    private final d<GXSize> padding;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/template/GXStyle$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXStyle;", "lowPriorityStyle", "heightPriorityStyle", GXTemplateKey.GAIAX_CSS, "Lorg/json/JSONObject;", "createByExtend", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXStyle create(JSONObject r210) {
            Intrinsics.checkNotNullParameter(r210, GXTemplateKey.GAIAX_CSS);
            if (r210.length() <= 0) goto L5;
            GXStyleConvert r100 = GXStyleConvert.Companion.getInstance();
            GXSize r101 = r100.font(r210);
            Typeface r102 = r100.fontFamily(r210);
            Typeface r103 = r100.fontWeight(r210);
            Integer r104 = r100.fontLines(r210);
            GXColor r105 = r100.fontColor(r210);
            TextUtils.TruncateAt r106 = r100.fontTextOverflow(r210);
            Integer r107 = r100.fontTextAlign(r210);
            GXColor r110 = r100.backgroundColor(r210);
            GXLinearColor r111 = r100.backgroundImage(r210);
            GXMode r211 = r100.mode(r210);
            Float r112 = r100.opacity(r210);
            GXRoundedCorner r113 = r100.borderRadius(r210);
            return new GXStyle(r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r100.overflow(r210), r100.display(r210), r100.hidden(r210), r100.padding(r210), r100.borderWidth(r210), r100.borderColor(r210), r113, r100.fontLineHeight(r210), r100.textDecoration(r210), r211, r100.boxShadow(r210), r100.backdropFilter(r210), r100.fitContent(r210));
        L5:
            return new GXStyle(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        }

        public final GXStyle createByExtend(JSONObject r210) {
            Intrinsics.checkNotNullParameter(r210, GXTemplateKey.GAIAX_CSS);
            if (r210.length() <= 0) goto L5;
            GXStyleConvert r100 = GXStyleConvert.Companion.getInstance();
            GXSize r101 = r100.font(r210);
            Typeface r102 = r100.fontFamily(r210);
            Typeface r103 = r100.fontWeight(r210);
            Integer r104 = r100.fontLines(r210);
            GXColor r105 = r100.fontColor(r210);
            TextUtils.TruncateAt r106 = r100.fontTextOverflow(r210);
            Integer r107 = r100.fontTextAlign(r210);
            GXColor r110 = r100.backgroundColor(r210);
            GXLinearColor r111 = r100.backgroundImage(r210);
            GXMode r211 = r100.mode(r210);
            Float r112 = r100.opacity(r210);
            GXRoundedCorner r113 = r100.borderRadius(r210);
            Boolean r114 = r100.overflow(r210);
            Integer r115 = r100.display(r210);
            Integer r116 = r100.hidden(r210);
            d<GXSize> r117 = r100.padding(r210);
            GXSize r118 = r100.borderWidth(r210);
            GXColor r119 = r100.borderColor(r210);
            GXSize r212 = r100.fontLineHeight(r210);
            Integer r213 = r100.textDecoration(r210);
            GXBoxShadow r214 = r100.boxShadow(r210);
            GXBackdropFilter r215 = r100.backdropFilter(r210);
            GXRegisterCenter.GXIExtensionCompatibility r108 = GXRegisterCenter.Companion.getInstance().getExtensionCompatibility$GaiaX();
            boolean r216 = false;
            if (r108 == null) goto L11;
            Integer r217 = r116;
            if (r108.isCompatibilityDataBindingFitContent() != true) goto L12;
            r216 = true;
        L12:
            if (r216 == false) goto L14;
            Boolean r109 = r100.fitContent(r210);
        L15:
            Integer r120 = r217;
            return new GXStyle(r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r114, r115, r120, r117, r118, r119, r113, r212, r213, r211, r214, r215, r109);
        L14:
            r109 = null;
            goto L15
        L11:
            r217 = r116;
            goto L12
        L5:
            return new GXStyle(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        }

        public final GXStyle create(GXStyle r210, GXStyle r211) {
            Intrinsics.checkNotNullParameter(r210, "lowPriorityStyle");
            Intrinsics.checkNotNullParameter(r211, "heightPriorityStyle");
            GXSize r100 = r211.getFontSize();
            if (r100 != null) goto L5;
            r100 = r210.getFontSize();
        L5:
            Typeface r101 = r211.getFontFamily();
            if (r101 != null) goto L8;
            r101 = r210.getFontFamily();
        L8:
            Typeface r102 = r211.getFontWeight();
            if (r102 != null) goto L11;
            r102 = r210.getFontWeight();
        L11:
            Integer r103 = r211.getFontLines();
            if (r103 != null) goto L14;
            r103 = r210.getFontLines();
        L14:
            GXColor r104 = r211.getFontColor();
            if (r104 != null) goto L17;
            r104 = r210.getFontColor();
        L17:
            TextUtils.TruncateAt r105 = r211.getFontTextOverflow();
            if (r105 != null) goto L20;
            r105 = r210.getFontTextOverflow();
        L20:
            Integer r106 = r211.getFontTextAlign();
            if (r106 != null) goto L23;
            r106 = r210.getFontTextAlign();
        L23:
            GXColor r107 = r211.getBackgroundColor();
            if (r107 != null) goto L26;
            r107 = r210.getBackgroundColor();
        L26:
            GXLinearColor r110 = r211.getBackgroundImage();
            if (r110 != null) goto L29;
            r110 = r210.getBackgroundImage();
        L29:
            GXMode r111 = r211.getMode();
            if (r111 != null) goto L32;
            r111 = r210.getMode();
        L32:
            GXMode r212 = r111;
            Float r112 = r211.getOpacity();
            if (r112 != null) goto L35;
            r112 = r210.getOpacity();
        L35:
            Boolean r113 = r211.getOverflow();
            if (r113 != null) goto L38;
            r113 = r210.getOverflow();
        L38:
            Integer r114 = r211.getDisplay();
            if (r114 != null) goto L41;
            r114 = r210.getDisplay();
        L41:
            Integer r115 = r211.getHidden();
            if (r115 != null) goto L44;
            r115 = r210.getHidden();
        L44:
            d<GXSize> r116 = GXTemplateUtils.INSTANCE.createRectGXSizeByPriority(r211.getPadding(), r210.getPadding());
            GXSize r108 = r211.getBorderWidth();
            if (r108 != null) goto L47;
            r108 = r210.getBorderWidth();
        L47:
            GXSize r117 = r108;
            GXColor r109 = r211.getBorderColor();
            if (r109 != null) goto L50;
            r109 = r210.getBorderColor();
        L50:
            GXColor r118 = r109;
            GXSize r119 = r211.getFontLineHeight();
            if (r119 != null) goto L53;
            r119 = r210.getFontLineHeight();
        L53:
            GXSize r120 = r119;
            Integer r121 = r211.getFontTextDecoration();
            if (r121 != null) goto L56;
            r121 = r210.getFontTextDecoration();
        L56:
            Integer r213 = r121;
            GXRoundedCorner r122 = r211.getBorderRadius();
            if (r122 != null) goto L59;
            r122 = r210.getBorderRadius();
        L59:
            GXRoundedCorner r123 = r122;
            GXBoxShadow r124 = r211.getBoxShadow();
            if (r124 != null) goto L62;
            r124 = r210.getBoxShadow();
        L62:
            GXBoxShadow r214 = r124;
            GXBackdropFilter r125 = r211.getBackdropFilter();
            if (r125 != null) goto L65;
            r125 = r210.getBackdropFilter();
        L65:
            GXBackdropFilter r215 = r125;
            GXRegisterCenter.GXIExtensionCompatibility r126 = GXRegisterCenter.Companion.getInstance().getExtensionCompatibility$GaiaX();
            if (r126 == null) goto L70;
            boolean r127 = true;
            if (r126.isCompatibilityDataBindingFitContent() != true) goto L70;
        L71:
            if (r127 == true) goto L73;
            Boolean r128 = r211.getFitContent();
            if (r128 != null) goto L83;
            r128 = r210.getFitContent();
        L83:
            GXSize r129 = r100;
            return new GXStyle(r129, r101, r102, r103, r104, r105, r106, r107, r110, r112, r113, r114, r115, r116, r117, r118, r123, r120, r213, r212, r214, r215, r128);
        L73:
            if (Intrinsics.areEqual(r210.getFitContent(), Boolean.TRUE) == true) goto L75;
        L77:
            r128 = r211.getFitContent();
            if (r128 != null) goto L83;
            r128 = r210.getFitContent();
            goto L83
        L75:
            if (Intrinsics.areEqual(r211.getFitContent(), Boolean.FALSE) == false) goto L77;
            r128 = r210.getFitContent();
        L70:
            r127 = false;
            goto L71
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GXStyle() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GXStyle copy$default(GXStyle r110, GXSize r111, Typeface r112, Typeface r210, Integer r211, GXColor r212, TextUtils.TruncateAt r213, Integer r214, GXColor r215, GXLinearColor r216, Float r217, Boolean r218, Integer r219, Integer r310, d r311, GXSize r312, GXColor r313, GXRoundedCorner r314, GXSize r315, Integer r316, GXMode r317, GXBoxShadow r318, GXBackdropFilter r319, Boolean r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        GXSize r100 = r110.fontSize;
    L7:
        if ((r411 & 2) == 0) goto L9;
        Typeface r101 = r110.fontFamily;
    L11:
        if ((r411 & 4) == 0) goto L13;
        Typeface r102 = r110.fontWeight;
    L15:
        if ((r411 & 8) == 0) goto L17;
        Integer r103 = r110.fontLines;
    L19:
        if ((r411 & 16) == 0) goto L21;
        GXColor r104 = r110.fontColor;
    L23:
        if ((r411 & 32) == 0) goto L25;
        TextUtils.TruncateAt r105 = r110.fontTextOverflow;
    L27:
        if ((r411 & 64) == 0) goto L29;
        Integer r106 = r110.fontTextAlign;
    L31:
        if ((r411 & 128) == 0) goto L33;
        GXColor r107 = r110.backgroundColor;
    L35:
        if ((r411 & 256) == 0) goto L37;
        GXLinearColor r113 = r110.backgroundImage;
    L39:
        if ((r411 & 512) == 0) goto L41;
        Float r114 = r110.opacity;
    L43:
        if ((r411 & 1024) == 0) goto L45;
        Boolean r115 = r110.overflow;
    L47:
        if ((r411 & 2048) == 0) goto L49;
        Integer r116 = r110.display;
    L51:
        if ((r411 & 4096) == 0) goto L53;
        Integer r117 = r110.hidden;
    L55:
        if ((r411 & 8192) == 0) goto L57;
        d r118 = r110.padding;
    L58:
        d r320 = r118;
        if ((r411 & 16384) == 0) goto L61;
        GXSize r119 = r110.borderWidth;
    L62:
        GXSize r321 = r119;
        if ((r411 & 32768) == 0) goto L65;
        GXColor r120 = r110.borderColor;
    L66:
        GXColor r322 = r120;
        if ((r411 & 65536) == 0) goto L69;
        GXRoundedCorner r121 = r110.borderRadius;
    L70:
        GXRoundedCorner r323 = r121;
        if ((r411 & 131072) == 0) goto L73;
        GXSize r122 = r110.fontLineHeight;
    L74:
        GXSize r324 = r122;
        if ((r411 & 262144) == 0) goto L77;
        Integer r123 = r110.fontTextDecoration;
    L78:
        Integer r325 = r123;
        if ((r411 & 524288) == 0) goto L81;
        GXMode r124 = r110.mode;
    L82:
        GXMode r326 = r124;
        if ((r411 & 1048576) == 0) goto L85;
        GXBoxShadow r125 = r110.boxShadow;
    L86:
        GXBoxShadow r327 = r125;
        if ((r411 & 2097152) == 0) goto L89;
        GXBackdropFilter r126 = r110.backdropFilter;
    L91:
        if ((r411 & 4194304) == 0) goto L93;
        Boolean r108 = r110.fitContent;
    L95:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r126, r108);
    L93:
        r108 = r410;
        goto L95
    L89:
        r126 = r319;
        goto L91
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
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

    public final GXSize component1() {
        return this.fontSize;
    }

    public final Float component10() {
        return this.opacity;
    }

    public final Boolean component11() {
        return this.overflow;
    }

    public final Integer component12() {
        return this.display;
    }

    public final Integer component13() {
        return this.hidden;
    }

    public final d<GXSize> component14() {
        return this.padding;
    }

    public final GXSize component15() {
        return this.borderWidth;
    }

    public final GXColor component16() {
        return this.borderColor;
    }

    public final GXRoundedCorner component17() {
        return this.borderRadius;
    }

    public final GXSize component18() {
        return this.fontLineHeight;
    }

    public final Integer component19() {
        return this.fontTextDecoration;
    }

    public final Typeface component2() {
        return this.fontFamily;
    }

    public final GXMode component20() {
        return this.mode;
    }

    public final GXBoxShadow component21() {
        return this.boxShadow;
    }

    public final GXBackdropFilter component22() {
        return this.backdropFilter;
    }

    public final Boolean component23() {
        return this.fitContent;
    }

    public final Typeface component3() {
        return this.fontWeight;
    }

    public final Integer component4() {
        return this.fontLines;
    }

    public final GXColor component5() {
        return this.fontColor;
    }

    public final TextUtils.TruncateAt component6() {
        return this.fontTextOverflow;
    }

    public final Integer component7() {
        return this.fontTextAlign;
    }

    public final GXColor component8() {
        return this.backgroundColor;
    }

    public final GXLinearColor component9() {
        return this.backgroundImage;
    }

    public final GXStyle copy(GXSize r210, Typeface r211, Typeface r212, Integer r213, GXColor r310, TextUtils.TruncateAt r311, Integer r312, GXColor r313, GXLinearColor r314, Float r315, Boolean r316, Integer r317, Integer r318, d<GXSize> r319, GXSize r410, GXColor r411, GXRoundedCorner r412, GXSize r413, Integer r414, GXMode r415, GXBoxShadow r416, GXBackdropFilter r417, Boolean r418) {
        return new GXStyle(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXStyle) == true) goto L8;
        return false;
    L8:
        GXStyle r101 = (GXStyle) r100;
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontFamily, r101.fontFamily) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fontLines, r101.fontLines) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontColor, r101.fontColor) == true) goto L24;
        return false;
    L24:
        if (this.fontTextOverflow == r101.fontTextOverflow) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fontTextAlign, r101.fontTextAlign) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.backgroundImage, r101.backgroundImage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.opacity, r101.opacity) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.overflow, r101.overflow) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.display, r101.display) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.hidden, r101.hidden) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.borderWidth, r101.borderWidth) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.borderRadius, r101.borderRadius) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.fontLineHeight, r101.fontLineHeight) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.fontTextDecoration, r101.fontTextDecoration) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.mode, r101.mode) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.boxShadow, r101.boxShadow) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.backdropFilter, r101.backdropFilter) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.fitContent, r101.fitContent) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public int hashCode() {
        GXSize r100 = this.fontSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Typeface r104 = this.fontFamily;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Typeface r107 = this.fontWeight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.fontLines;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        GXColor r113 = this.fontColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        TextUtils.TruncateAt r116 = this.fontTextOverflow;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.fontTextAlign;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        GXColor r122 = this.backgroundColor;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        GXLinearColor r125 = this.backgroundImage;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Float r128 = this.opacity;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.overflow;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.display;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.hidden;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        d<GXSize> r140 = this.padding;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        GXSize r143 = this.borderWidth;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        GXColor r146 = this.borderColor;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        GXRoundedCorner r149 = this.borderRadius;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        GXSize r152 = this.fontLineHeight;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Integer r155 = this.fontTextDecoration;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        GXMode r158 = this.mode;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        GXBoxShadow r161 = this.boxShadow;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        GXBackdropFilter r164 = this.backdropFilter;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        Boolean r167 = this.fitContent;
        if (r167 == null) goto L95;
        r101 = r167.hashCode();
    L95:
        return r166 + r101;
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GXStyle(fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontLines=" + this.fontLines + ", fontColor=" + this.fontColor + ", fontTextOverflow=" + this.fontTextOverflow + ", fontTextAlign=" + this.fontTextAlign + ", backgroundColor=" + this.backgroundColor + ", backgroundImage=" + this.backgroundImage + ", opacity=" + this.opacity + ", overflow=" + this.overflow + ", display=" + this.display + ", hidden=" + this.hidden + ", padding=" + this.padding + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", borderRadius=" + this.borderRadius + ", fontLineHeight=" + this.fontLineHeight + ", fontTextDecoration=" + this.fontTextDecoration + ", mode=" + this.mode + ", boxShadow=" + this.boxShadow + ", backdropFilter=" + this.backdropFilter + ", fitContent=" + this.fitContent + ')';
    }

    public final boolean isEmpty() {
        if (this.fontSize == null) goto L5;
    L47:
        return false;
    L5:
        if (this.fontFamily != null) goto L47;
        if (this.fontWeight != null) goto L47;
        if (this.fontLines != null) goto L47;
        if (this.fontColor != null) goto L47;
        if (this.fontTextOverflow != null) goto L47;
        if (this.fontTextAlign != null) goto L47;
        if (this.backgroundColor != null) goto L47;
        if (this.backgroundImage != null) goto L47;
        if (this.opacity != null) goto L47;
        if (this.overflow != null) goto L47;
        if (this.display != null) goto L47;
        if (this.hidden != null) goto L47;
        if (this.padding != null) goto L47;
        if (this.borderWidth != null) goto L47;
        if (this.borderColor != null) goto L47;
        if (this.borderRadius != null) goto L47;
        if (this.fontLineHeight != null) goto L47;
        if (this.fontTextDecoration != null) goto L47;
        if (this.mode != null) goto L47;
        if (this.fitContent != null) goto L47;
        if (this.boxShadow != null) goto L47;
        return true;
    }

    public final boolean isEmptyStyle() {
        if (this.backgroundColor == null) goto L5;
    L21:
        return false;
    L5:
        if (this.backgroundImage != null) goto L21;
        if (this.opacity != null) goto L21;
        if (this.backdropFilter != null) goto L21;
        if (this.overflow != null) goto L21;
        if (this.borderWidth != null) goto L21;
        if (this.borderColor != null) goto L21;
        if (this.borderRadius != null) goto L21;
        if (this.boxShadow != null) goto L21;
        return true;
    }

    public final boolean isInvisible() {
        Integer r100 = this.display;
        if (r100 != null) goto L6;
    L7:
        Integer r101 = this.display;
        if (r101 != null) goto L11;
    L12:
        Integer r102 = this.hidden;
        if (r102 != null) goto L16;
    L18:
        return false;
    L16:
        if (r102.intValue() != 4) goto L18;
    L19:
        return true;
    L11:
        if (r101.intValue() == 8) goto L19;
    L6:
        if (r100.intValue() == 4) goto L19;
        goto L7
    }

    public final GXBackdropFilter getBackdropFilter() {
        return this.backdropFilter;
    }

    public final GXColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public final GXLinearColor getBackgroundImage() {
        return this.backgroundImage;
    }

    public final GXColor getBorderColor() {
        return this.borderColor;
    }

    public final GXRoundedCorner getBorderRadius() {
        return this.borderRadius;
    }

    public final GXSize getBorderWidth() {
        return this.borderWidth;
    }

    public final GXBoxShadow getBoxShadow() {
        return this.boxShadow;
    }

    public final Integer getDisplay() {
        return this.display;
    }

    public final Boolean getFitContent() {
        return this.fitContent;
    }

    public final GXColor getFontColor() {
        return this.fontColor;
    }

    public final Typeface getFontFamily() {
        return this.fontFamily;
    }

    public final GXSize getFontLineHeight() {
        return this.fontLineHeight;
    }

    public final Integer getFontLines() {
        return this.fontLines;
    }

    public final GXSize getFontSize() {
        return this.fontSize;
    }

    public final Integer getFontTextAlign() {
        return this.fontTextAlign;
    }

    public final Integer getFontTextDecoration() {
        return this.fontTextDecoration;
    }

    public final TextUtils.TruncateAt getFontTextOverflow() {
        return this.fontTextOverflow;
    }

    public final Typeface getFontWeight() {
        return this.fontWeight;
    }

    public final Integer getHidden() {
        return this.hidden;
    }

    public final GXMode getMode() {
        return this.mode;
    }

    public final Float getOpacity() {
        return this.opacity;
    }

    public final Boolean getOverflow() {
        return this.overflow;
    }

    public final d<GXSize> getPadding() {
        return this.padding;
    }

    public GXStyle(GXSize r100, Typeface r101, Typeface r102, Integer r103, GXColor r104, TextUtils.TruncateAt r105, Integer r106, GXColor r110, GXLinearColor r111, Float r112, Boolean r113, Integer r114, Integer r115, d<GXSize> r116, GXSize r117, GXColor r118, GXRoundedCorner r119, GXSize r210, Integer r211, GXMode r212, GXBoxShadow r213, GXBackdropFilter r214, Boolean r215) {
        this.fontSize = r100;
        this.fontFamily = r101;
        this.fontWeight = r102;
        this.fontLines = r103;
        this.fontColor = r104;
        this.fontTextOverflow = r105;
        this.fontTextAlign = r106;
        this.backgroundColor = r110;
        this.backgroundImage = r111;
        this.opacity = r112;
        this.overflow = r113;
        this.display = r114;
        this.hidden = r115;
        this.padding = r116;
        this.borderWidth = r117;
        this.borderColor = r118;
        this.borderRadius = r119;
        this.fontLineHeight = r210;
        this.fontTextDecoration = r211;
        this.mode = r212;
        this.boxShadow = r213;
        this.backdropFilter = r214;
        this.fitContent = r215;
    }

    public /* synthetic */ GXStyle(GXSize r210, Typeface r211, Typeface r212, Integer r213, GXColor r214, TextUtils.TruncateAt r310, Integer r311, GXColor r312, GXLinearColor r313, Float r314, Boolean r315, Integer r316, Integer r317, d r318, GXSize r319, GXColor r410, GXRoundedCorner r411, GXSize r412, Integer r413, GXMode r414, GXBoxShadow r415, GXBackdropFilter r416, Boolean r417, int r418, DefaultConstructorMarker r419) {
        if ((r418 & 1) == 0) goto L5;
        GXSize r100 = null;
    L7:
        if ((r418 & 2) == 0) goto L9;
        Typeface r101 = null;
    L11:
        if ((r418 & 4) == 0) goto L13;
        Typeface r102 = null;
    L15:
        if ((r418 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r418 & 16) == 0) goto L21;
        GXColor r104 = null;
    L23:
        if ((r418 & 32) == 0) goto L25;
        TextUtils.TruncateAt r105 = null;
    L27:
        if ((r418 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r418 & 128) == 0) goto L33;
        GXColor r107 = null;
    L35:
        if ((r418 & 256) == 0) goto L37;
        GXLinearColor r110 = null;
    L39:
        if ((r418 & 512) == 0) goto L41;
        Float r111 = null;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        Boolean r112 = null;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r418 & 4096) == 0) goto L53;
        Integer r114 = null;
    L55:
        if ((r418 & 8192) == 0) goto L57;
        d r115 = null;
    L59:
        if ((r418 & 16384) == 0) goto L61;
        GXSize r108 = null;
    L63:
        if ((r418 & 32768) == 0) goto L65;
        GXColor r116 = null;
    L67:
        if ((r418 & 65536) == 0) goto L69;
        GXRoundedCorner r117 = null;
    L71:
        if ((r418 & 131072) == 0) goto L73;
        GXSize r118 = null;
    L75:
        if ((r418 & 262144) == 0) goto L77;
        Integer r119 = null;
    L79:
        if ((r418 & 524288) == 0) goto L81;
        GXMode r215 = null;
    L83:
        if ((r418 & 1048576) == 0) goto L85;
        GXBoxShadow r216 = null;
    L87:
        if ((r418 & 2097152) == 0) goto L89;
        GXBackdropFilter r217 = null;
    L91:
        if ((r418 & 4194304) == 0) goto L93;
        Boolean r109 = null;
    L94:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r215, r216, r217, r109);
        return;
    L93:
        r109 = r417;
        goto L94
    L89:
        r217 = r416;
        goto L91
    L85:
        r216 = r415;
        goto L87
    L81:
        r215 = r414;
        goto L83
    L77:
        r119 = r413;
        goto L79
    L73:
        r118 = r412;
        goto L75
    L69:
        r117 = r411;
        goto L71
    L65:
        r116 = r410;
        goto L67
    L61:
        r108 = r319;
        goto L63
    L57:
        r115 = r318;
        goto L59
    L53:
        r114 = r317;
        goto L55
    L49:
        r113 = r316;
        goto L51
    L45:
        r112 = r315;
        goto L47
    L41:
        r111 = r314;
        goto L43
    L37:
        r110 = r313;
        goto L39
    L33:
        r107 = r312;
        goto L35
    L29:
        r106 = r311;
        goto L31
    L25:
        r105 = r310;
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

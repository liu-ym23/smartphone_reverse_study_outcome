package com.alibaba.gaiax.render.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.view.basic.GXIImageView;
import com.alibaba.gaiax.render.view.basic.GXIconFont;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.alibaba.gaiax.render.view.drawable.GXColorGradientDrawable;
import com.alibaba.gaiax.render.view.drawable.GXLinearColorGradientDrawable;
import com.alibaba.gaiax.template.GXColor;
import com.alibaba.gaiax.template.GXGridConfig;
import com.alibaba.gaiax.template.GXLinearColor;
import com.alibaba.gaiax.template.GXRoundedCorner;
import com.alibaba.gaiax.template.GXSize;
import com.alibaba.gaiax.template.GXStyle;
import com.alibaba.gaiax.template.GXStyleConvert;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u.b;
import u.d;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a%\u0010\b\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\f\u001a\u00020\u0003*\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u0010\u001a\u00020\u0003*\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u001b\u0010\u001a\u001a\u00020\u0003*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0012\u0010\u001c\u001a\u00020\u0003*\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u001d\u001a\u00020\u0003*\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u001f\u001a\u00020\u0003*\u00020\u00182\u0006\u0010\u001e\u001a\u00020\n\u001a\u0012\u0010 \u001a\u00020\u0003*\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\"\u001a\u00020\u0003*\u00020\u00182\u0006\u0010!\u001a\u00020\u0005\u001a\u001b\u0010$\u001a\u00020\u0003*\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010\u001b\u001a\u0012\u0010%\u001a\u00020\u0003*\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010(\u001a\u00020\u0003*\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010&\u001a\u0012\u0010)\u001a\u00020\u0003*\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001b\u0010+\u001a\u00020\u0003*\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b+\u0010,\u001a\u001a\u00100\u001a\u00020\u0003*\u00020\u00182\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-\u001a\u0014\u00103\u001a\u00020\u0003*\u00020\u00182\b\u00102\u001a\u0004\u0018\u000101\u001a\u001b\u00105\u001a\u00020\u0003*\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b5\u00106\u001a$\u0010=\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010;\u001a\u001c\u0010?\u001a\u00020\u0003*\u00020\u00002\u0006\u0010>\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010;\u001a\u0012\u0010A\u001a\u00020\u0003*\u00020\u00002\u0006\u0010/\u001a\u00020@\u001a\"\u0010D\u001a\u00020\u0003*\u00020\u00002\u0006\u0010/\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005\u001a\u0012\u0010F\u001a\u00020\u0003*\u00020\u00002\u0006\u0010E\u001a\u00020\u0005\u001a\u0012\u0010G\u001a\u00020\u0003*\u00020\u00002\u0006\u0010E\u001a\u00020\u0005\u001a\"\u0010G\u001a\u00020\u0003*\u00020\u00002\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0005\u001a\n\u0010J\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010K\u001a\u00020\u0003*\u00020\u0000¨\u0006L"}, d2 = {"Landroid/view/View;", "Lcom/alibaba/gaiax/template/GXStyle;", "style", "", "setRoundCornerRadiusAndRoundCornerBorder", "", "display", "hidden", "setHidden", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;)V", "", GXTemplateKey.STYLE_OPACITY, "setOpacity", "(Landroid/view/View;Ljava/lang/Float;)V", "", "overflow", "setOverflow", "(Landroid/view/View;Ljava/lang/Boolean;)V", BaseSwitches.V, "overflowOnParents", "Landroid/view/ViewGroup;", "view", "isContainShadowLayout", "setBackgroundColorAndBackgroundImageWithRadius", "Lcom/alibaba/gaiax/render/view/basic/GXText;", "textDecoration", "setFontTextDecoration", "(Lcom/alibaba/gaiax/render/view/basic/GXText;Ljava/lang/Integer;)V", "setFontTextLineHeight", "setFontTextAlign", "lineHeight", "setTextLineHeight", "setFontTextOverflow", GXTemplateKey.GAIAX_LAYER_GRAVITY, "setTextAlign", "fontLiens", "setFontLines", "setFontColor", "Lcom/alibaba/gaiax/template/GXLinearColor;", "backgroundImage", "setFontBackgroundImage", "setFontFamilyAndFontWeight", "fontSize", "setFontSize", "(Lcom/alibaba/gaiax/render/view/basic/GXText;Ljava/lang/Float;)V", "Lu/d;", "Lcom/alibaba/gaiax/template/GXSize;", GXTemplateKey.FLEXBOX_PADDING, "setFontPadding", "Landroid/graphics/Typeface;", "fontFamily", "setTextFontFamily", RemoteMessageConst.Notification.VISIBILITY, "setDisplay", "(Landroid/view/View;Ljava/lang/Integer;)V", "Lcom/alibaba/gaiax/context/GXTemplateContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/alibaba/gaiax/template/GXGridConfig;", "config", "Lu/b;", "layout", "setGridContainerDirection", "direction", "setScrollContainerDirection", "Landroid/graphics/Rect;", "setScrollContainerPadding", "itemSpacing", "rowSpacing", "setGridContainerItemSpacingAndRowSpacing", "lineSpacing", "setVerticalScrollContainerLineSpacing", "setHorizontalScrollContainerLineSpacing", "left", "right", "setSpanSizeLookup", "resetPropAnimation", "GaiaX"}, k = 2, mv = {1, 7, 1})
public final class GXViewExtKt {
    public static /* synthetic */ void a(View r100, boolean r101) {
        setOverflow$lambda$2(r100, r101);
    }

    private static final boolean isContainShadowLayout(ViewGroup r100) {
        int r101 = r100.getChildCount();
        if (r101 < 0) goto L11;
        int r102 = 0;
    L6:
        if ((r100.getChildAt(r102) instanceof GXShadowLayout) == true) goto L7;
        if (r102 == r101) goto L11;
        r102 = r102 + 1;
        goto L6
    L7:
        return true;
    L11:
        return false;
    }

    public static final void resetPropAnimation(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setTranslationX(0.0f);
        r100.setTranslationY(0.0f);
        r100.setScaleX(1.0f);
        r100.setScaleY(1.0f);
        r100.setRotation(0.0f);
    }

    public static final void setSpanSizeLookup(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof RecyclerView) == false) goto L12;
        RecyclerView r101 = (RecyclerView) r100;
        if ((r101.getLayoutManager() instanceof GridLayoutManager) == false) goto L13;
        RecyclerView.Adapter r102 = r101.getAdapter();
        if (r102 == null) goto L9;
        final int r103 = r102.getItemCount();
    L10:
        RecyclerView.LayoutManager r104 = r101.getLayoutManager();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        final int r105 = ((GridLayoutManager) r104).getSpanCount();
        RecyclerView.LayoutManager r106 = r101.getLayoutManager();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r106).setSpanSizeLookup(new AnonymousClass1(r103, r105));
        return;
    L9:
        r103 = 1;
        goto L10
    L13:
        return;
    }

    private static final void overflowOnParents(View r100, boolean r101) {
        Object r102 = r100.getParent();
        if (r102 != null) goto L6;
        return;
    L6:
        if ((r102 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r102).setClipChildren(r101);
    L9:
        if ((r102 instanceof View) == true) goto L11;
        return;
    L11:
        if ((r102 instanceof RecyclerView) == true) goto L15;
        overflowOnParents((View) r102, r101);
        return;
    }

    public static final void setBackgroundColorAndBackgroundImageWithRadius(View r100, GXStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float[] r102 = null;
        if (r101 == null) goto L5;
        GXLinearColor r103 = r101.getBackgroundImage();
    L6:
        if (r103 != null) goto L8;
        if (r101 == null) goto L12;
        GXColor r104 = r101.getBackgroundColor();
    L13:
        if (r104 == null) goto L15;
        r100.setBackground(new GXColorGradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{r101.getBackgroundColor().value(r100.getContext()), r101.getBackgroundColor().value(r100.getContext())}));
    L17:
        if ((r100.getBackground() instanceof GXColorGradientDrawable) == false) goto L19;
    L20:
        Drawable r105 = r100.getBackground();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r106 = (GradientDrawable) r105;
        if (r101 == null) goto L25;
        GXRoundedCorner r107 = r101.getBorderRadius();
        if (r107 == null) goto L25;
        r102 = r107.getValue();
    L25:
        r106.setCornerRadii(r102);
        return;
    L19:
        if ((r100.getBackground() instanceof GXLinearColorGradientDrawable) == true) goto L20;
        return;
    L15:
        r100.setBackground(null);
        goto L17
    L12:
        r104 = null;
        goto L13
    L8:
        if ((r100 instanceof GXText) == true) goto L17;
        r100.setBackground(r101.getBackgroundImage().createDrawable());
        goto L17
    L5:
        r103 = null;
        goto L6
    }

    public static final void setDisplay(View r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        r100.setVisibility(r101.intValue());
        return;
    }

    public static final void setFontBackgroundImage(GXText r100, GXLinearColor r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        r100.setTextColor(-16777216);
        r100.getPaint().setShader(r101.createShader(r100));
        return;
    }

    public static final void setFontColor(GXText r100, GXStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "style");
        if (r101.getFontColor() == null) goto L5;
        r100.setTextColor(r101.getFontColor().value(r100.getContext()));
        return;
    L5:
        r100.setTextColor(-16777216);
    }

    public static final void setFontFamilyAndFontWeight(GXText r100, GXStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "style");
        if (r101.getFontFamily() == null) goto L6;
        r100.setTypeface(r101.getFontFamily());
    L10:
        if ((r100 instanceof GXIconFont) == false) goto L23;
        GXRegisterCenter.GXIExtensionCompatibility r102 = GXRegisterCenter.Companion.getInstance().getExtensionCompatibility$GaiaX();
        boolean r103 = false;
        if (r102 != null) goto L14;
    L16:
        if (r103 == false) goto L19;
        ((GXIconFont) r100).setTypeface(GXStyleConvert.Companion.getInstance().fontFamily("iconfont"));
        return;
    L19:
        if (r101.getFontFamily() == null) goto L22;
        return;
    L22:
        throw new IllegalArgumentException("GXIconFont view must have font family property");
    L14:
        if (r102.isPreventIconFontTypefaceThrowException() != true) goto L16;
        r103 = true;
        goto L16
    L23:
        return;
    L6:
        if (r101.getFontWeight() == null) goto L8;
        r100.setTypeface(r101.getFontWeight());
        goto L10
    L8:
        r100.setTypeface(null);
        goto L10
    }

    public static final void setFontLines(GXText r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
    L11:
        r100.setMaxLines(1);
        return;
    L5:
        if (r101.intValue() == 1) goto L11;
        if (r101.intValue() != 0) goto L10;
        r100.setMaxLines(Integer.MAX_VALUE);
        return;
    L10:
        r100.setMaxLines(r101.intValue());
    }

    public static final void setFontPadding(GXText r100, d<GXSize> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = 0;
        if (r101 == null) goto L7;
        GXSize r103 = r101.f548090a;
        if (r103 == null) goto L7;
        int r104 = r103.getValueInt();
    L8:
        if (r101 == null) goto L12;
        GXSize r105 = r101.f548092c;
        if (r105 == null) goto L12;
        int r106 = r105.getValueInt();
    L13:
        if (r101 == null) goto L17;
        GXSize r107 = r101.f548091b;
        if (r107 == null) goto L17;
        int r108 = r107.getValueInt();
    L18:
        if (r101 == null) goto L22;
        GXSize r109 = r101.f548093d;
        if (r109 == null) goto L22;
        r102 = r109.getValueInt();
    L22:
        r100.setPadding(r104, r106, r108, r102);
        return;
    L17:
        r108 = 0;
    L12:
        r106 = 0;
    L7:
        r104 = 0;
        goto L8
    }

    public static final void setFontSize(GXText r100, Float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.floatValue() < 0.0f) goto L9;
        r100.setTextSize(0, r101.floatValue());
        return;
    }

    public static final void setFontTextAlign(GXText r100, GXStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "style");
        if (r101.getFontTextAlign() == null) goto L5;
        setTextAlign(r100, r101.getFontTextAlign().intValue() | 16);
        return;
    L5:
        setTextAlign(r100, 19);
    }

    public static final void setFontTextDecoration(GXText r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        r100.getPaint().setFlags(r101.intValue());
        return;
    }

    public static final void setFontTextLineHeight(GXText r100, GXStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "style");
        if (r101.getFontLineHeight() == null) goto L12;
        float r102 = r101.getFontLineHeight().getValueFloat();
        GXRegisterCenter.GXIExtensionDynamicProperty r103 = GXRegisterCenter.Companion.getInstance().getExtensionDynamicProperty$GaiaX();
        if (r103 == null) goto L10;
        GXRegisterCenter.GXIExtensionDynamicProperty.GXParams r104 = new GXRegisterCenter.GXIExtensionDynamicProperty.GXParams(GXTemplateKey.STYLE_FONT_LINE_HEIGHT, Float.valueOf(r102));
        r104.setCssStyle(r101);
        Object r105 = r103.convert(r104);
        if (r105 == null) goto L10;
        setTextLineHeight(r100, ((Float) r105).floatValue());
        return;
    L10:
        setTextLineHeight(r100, r102);
        return;
    }

    public static final void setFontTextOverflow(GXText r100, GXStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "style");
        if (r101.getFontTextOverflow() != null) goto L5;
        r100.setEllipsize(null);
        return;
    L5:
        r100.setEllipsize(r101.getFontTextOverflow());
    }

    public static final void setHorizontalScrollContainerLineSpacing(View r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof RecyclerView) == false) goto L9;
        RecyclerView r102 = (RecyclerView) r100;
        if (r102.getItemDecorationCount() <= 0) goto L7;
        return;
    L7:
        r102.addItemDecoration(new GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$1(r101));
        return;
    }

    public static final void setOpacity(View r100, Float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        r101.floatValue();
        r100.setAlpha(r101.floatValue());
        return;
    }

    public static final void setOverflow(final View r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L5;
        final boolean r102 = r101.booleanValue();
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L12;
        if (r102 == true) goto L10;
        ((ViewGroup) r100).setClipChildren(false);
        r100.post(new a(r100, r102));
        return;
    L10:
        ((ViewGroup) r100).setClipChildren(r102);
        return;
    L12:
        return;
    L5:
        r102 = true;
        goto L7
    }

    private static final void setOverflow$lambda$2(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$view");
        ViewGroup r102 = (ViewGroup) r100;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L5;
        ViewGroup r104 = (ViewGroup) r103;
    L6:
        if (r104 == null) goto L10;
        r104.setClipChildren(r101);
    L10:
        if ((r100 instanceof GXIRootView) == true) goto L12;
        return;
    L12:
        if (isContainShadowLayout(r102) == false) goto L16;
        overflowOnParents(r100, r101);
        return;
    L16:
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void setRoundCornerRadiusAndRoundCornerBorder(View r100, GXStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float[] r102 = null;
        if (r101 == null) goto L7;
        GXRoundedCorner r103 = r101.getBorderRadius();
        if (r103 == null) goto L7;
        float[] r104 = r103.getValue();
    L8:
        if (r101 == null) goto L12;
        GXSize r105 = r101.getBorderWidth();
        if (r105 == null) goto L12;
        Float r106 = Float.valueOf(r105.getValueFloat());
    L13:
        if (r101 == null) goto L17;
        GXColor r107 = r101.getBorderColor();
        if (r107 == null) goto L17;
        Integer r108 = Integer.valueOf(r107.value(r100.getContext()));
    L18:
        if (r101 == null) goto L23;
        GXRoundedCorner r109 = r101.getBorderRadius();
        if (r109 == null) goto L23;
        r102 = r109.getValue();
    L23:
        if ((r100 instanceof GXIRoundCorner) == false) goto L77;
        int r110 = 0;
        if ((r100 instanceof GXView) == false) goto L37;
        if (r102 == null) goto L28;
        ((GXIRoundCorner) r100).setRoundCornerRadius(r102);
    L28:
        if (r108 == null) goto L78;
        if (r106 == null) goto L79;
        GXIRoundCorner r111 = (GXIRoundCorner) r100;
        int r112 = r108.intValue();
        float r113 = r106.floatValue();
        if (r104 != null) goto L35;
        r104 = new float[8];
    L33:
        if (r110 >= 8) goto L35;
        r104[r110] = 0.0f;
        r110 = r110 + 1;
    L35:
        r111.setRoundCornerBorder(r112, r113, r104);
        return;
    L79:
        return;
    L78:
        return;
    L37:
        if ((r100 instanceof GXText) == false) goto L49;
        if (r102 == null) goto L40;
        ((GXIRoundCorner) r100).setRoundCornerRadius(r102);
    L40:
        if (r108 == null) goto L81;
        if (r106 == null) goto L82;
        GXIRoundCorner r114 = (GXIRoundCorner) r100;
        int r115 = r108.intValue();
        float r116 = r106.floatValue();
        if (r104 != null) goto L47;
        r104 = new float[8];
    L45:
        if (r110 >= 8) goto L47;
        r104[r110] = 0.0f;
        r110 = r110 + 1;
    L47:
        r114.setRoundCornerBorder(r115, r116, r104);
        return;
    L82:
        return;
    L81:
        return;
    L49:
        if ((r100 instanceof GXIImageView) == false) goto L61;
        if (r102 == null) goto L52;
        ((GXIRoundCorner) r100).setRoundCornerRadius(r102);
    L52:
        if (r108 == null) goto L84;
        if (r106 == null) goto L85;
        GXIRoundCorner r117 = (GXIRoundCorner) r100;
        int r118 = r108.intValue();
        float r119 = r106.floatValue();
        if (r104 != null) goto L59;
        r104 = new float[8];
    L57:
        if (r110 >= 8) goto L59;
        r104[r110] = 0.0f;
        r110 = r110 + 1;
    L59:
        r117.setRoundCornerBorder(r118, r119, r104);
        return;
    L85:
        return;
    L84:
        return;
    L61:
        if ((r100 instanceof GXContainer) == false) goto L87;
        if (r102 == null) goto L64;
        ((GXIRoundCorner) r100).setRoundCornerRadius(r102);
    L64:
        if (r108 == null) goto L88;
        if (r106 == null) goto L89;
        GXIRoundCorner r120 = (GXIRoundCorner) r100;
        int r121 = r108.intValue();
        float r122 = r106.floatValue();
        if (r104 != null) goto L71;
        r104 = new float[8];
    L69:
        if (r110 >= 8) goto L71;
        r104[r110] = 0.0f;
        r110 = r110 + 1;
    L71:
        r120.setRoundCornerBorder(r121, r122, r104);
        return;
    L89:
        return;
    L88:
        return;
    L87:
        return;
    L77:
        return;
    L17:
        r108 = null;
    L12:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    public static final void setScrollContainerPadding(View r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
        if ((r100 instanceof RecyclerView) == false) goto L6;
        r100.setPadding(r101.left, r101.top, r101.right, r101.bottom);
        return;
    }

    public static final void setTextAlign(GXText r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setGravity(r101);
    }

    public static final void setTextFontFamily(GXText r100, Typeface r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setTypeface(r101);
    }

    public static final void setTextLineHeight(GXText r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = r100.getPaint().getFontMetricsInt(null);
        if (((int) r101) == r102) goto L6;
        r100.setLineSpacing(r101 - r102, 1.0f);
        return;
    }

    public static final void setVerticalScrollContainerLineSpacing(View r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof RecyclerView) == false) goto L9;
        RecyclerView r102 = (RecyclerView) r100;
        if (r102.getItemDecorationCount() <= 0) goto L7;
        return;
    L7:
        r102.addItemDecoration(new GXViewExtKt$setVerticalScrollContainerLineSpacing$decoration$1(r101));
        return;
    }

    public static final void setHidden(View r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
        if (r102 == null) goto L25;
        r100.setVisibility(r102.intValue());
        return;
    L25:
        return;
    L5:
        if (r101.intValue() != 0) goto L12;
        if (r102 == null) goto L12;
        if (r102.intValue() != 4) goto L12;
        r100.setVisibility(r102.intValue());
        return;
    L12:
        if (r101.intValue() != 0) goto L18;
        if (r102 == null) goto L18;
        if (r102.intValue() != 0) goto L18;
        r100.setVisibility(r102.intValue());
        return;
    L18:
        r100.setVisibility(r101.intValue());
    }

    public static final void setScrollContainerDirection(View r100, int r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof RecyclerView) == false) goto L20;
        RecyclerView r103 = (RecyclerView) r100;
        RecyclerView.Adapter r104 = r103.getAdapter();
        if ((r104 instanceof GXContainerViewAdapter) == false) goto L7;
        GXContainerViewAdapter r105 = (GXContainerViewAdapter) r104;
    L9:
        if (r105 == null) goto L14;
        if (r102 == null) goto L12;
        float r106 = r102.f548085c;
    L13:
        boolean r107 = r105.isNeedForceRefresh(r106);
    L16:
        if (r103.getLayoutManager() == null) goto L18;
        if (r107 == true) goto L18;
        return;
    L18:
        r103.setLayoutManager(null);
        r103.setLayoutManager(new LinearLayoutManager(r103.getContext(), r101, false));
        return;
    L12:
        r106 = 0.0f;
        goto L13
    L14:
        r107 = false;
        goto L16
    L7:
        r105 = null;
        goto L9
    }

    public static final void setGridContainerDirection(View r100, GXTemplateContext r101, GXGridConfig r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "config");
        final int r104 = r102.getDirection();
        final int r105 = r102.column(r101);
        final boolean r106 = r102.getScrollEnable();
        if ((r100 instanceof RecyclerView) == false) goto L21;
        RecyclerView r107 = (RecyclerView) r100;
        RecyclerView.Adapter r108 = r107.getAdapter();
        if ((r108 instanceof GXContainerViewAdapter) == false) goto L7;
        GXContainerViewAdapter r109 = (GXContainerViewAdapter) r108;
    L8:
        if (r109 == null) goto L13;
        if (r103 == null) goto L11;
        float r110 = r103.f548085c;
    L12:
        boolean r111 = r109.isNeedForceRefresh(r110);
    L15:
        if (r107.getLayoutManager() == null) goto L19;
        if (r111 == true) goto L19;
        RecyclerView.LayoutManager r112 = r107.getLayoutManager();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r112).setSpanCount(r105);
        return;
    L19:
        r107.setLayoutManager(null);
        final Context r113 = r107.getContext();
        r107.setLayoutManager(new GXViewExtKt$setGridContainerDirection$target$1(r105, r104, r106, r113));
        return;
    L11:
        r110 = 0.0f;
        goto L12
    L13:
        r111 = false;
        goto L15
    L7:
        r109 = null;
        goto L8
    }

    public static final void setGridContainerItemSpacingAndRowSpacing(View r100, final Rect r101, final int r102, final int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
        if ((r100 instanceof RecyclerView) == false) goto L9;
        RecyclerView r104 = (RecyclerView) r100;
        if (r104.getItemDecorationCount() <= 0) goto L7;
        r104.removeItemDecorationAt(0);
    L7:
        r104.addItemDecoration(new GXViewExtKt$setGridContainerItemSpacingAndRowSpacing$decoration$1(r101, r102, r103));
        return;
    }

    public static final void setHorizontalScrollContainerLineSpacing(View r100, final int r101, final int r102, final int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof RecyclerView) == false) goto L9;
        RecyclerView r104 = (RecyclerView) r100;
        if (r104.getItemDecorationCount() <= 0) goto L7;
        return;
    L7:
        r104.addItemDecoration(new GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$2(r101, r103, r102));
        return;
    }
}

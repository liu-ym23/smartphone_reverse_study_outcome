package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.drawable.GXBlurBitmapDrawable;
import com.alibaba.gaiax.render.view.drawable.GXRoundCornerBorderGradientDrawable;
import com.alibaba.gaiax.template.GXBackdropFilter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;
import ztc.e;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000H\u0003J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ \u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXView;", "Landroid/widget/AbsoluteLayout;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gxBackdropFilter", "Lcom/alibaba/gaiax/template/GXBackdropFilter;", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "blur", "", "rootView", "Landroid/view/ViewGroup;", "offsetViewBounds", "Landroid/graphics/Rect;", PickerReporterConstants.KEY.TARGET, "getTemplateContext", "onBindData", "data", "Lorg/json/JSONObject;", "onBlurChanged", "gxImageView", "Landroid/view/View;", "setBackdropFilter", "setRoundCornerBorder", "borderColor", "borderWidth", "", "radius", "", "setRoundCornerRadius", "setTemplateContext", "gxContext", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class GXView extends AbsoluteLayout implements GXIViewBindData, GXIRootView, GXIRoundCorner {
    private GXBackdropFilter gxBackdropFilter;
    private GXTemplateContext gxTemplateContext;

    public static /* synthetic */ void a(GXView r100, ViewGroup r101, Rect r102, GXView r103) {
        onBlurChanged$lambda$1(r100, r101, r102, r103);
    }

    public static /* synthetic */ void b(GXView r100, GXView r101, Bitmap r102) {
        blur$lambda$2(r100, r101, r102);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public GXTemplateContext getTemplateContext() {
        return this.gxTemplateContext;
    }

    public GXView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(JSONObject r100) {
        String r101 = null;
        boolean r102 = false;
        if (r100 != null) goto L30;
    L7:
        int r103 = 2;
        if (r101 != null) goto L10;
    L15:
        setImportantForAccessibility(2);     // Catch: Exception -> L5
    L16:
        if (r100 != null) goto L18;
        return;
    L18:
        if (r100.optBoolean(GXTemplateKey.GAIAX_ACCESSIBILITY_ENABLE) == false) goto L20;
        r103 = 1;
    L20:
        setImportantForAccessibility(r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        GXRegisterCenter.GXIExtensionCompatibility r104 = GXRegisterCenter.Companion.getInstance().getExtensionCompatibility$GaiaX();
        if (r104 != null) goto L25;
    L27:
        if (r102 == false) goto L32;
        throw e;
    L32:
        return;
    L25:
        if (r104.isPreventAccessibilityThrowException() == true) goto L27;
        r102 = true;
        goto L27
    L10:
        if (r101.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        setContentDescription(r101);     // Catch: Exception -> L5
        setImportantForAccessibility(1);     // Catch: Exception -> L5
        goto L16
    L12:
        r105 = false;
        goto L13
    L30:
        r101 = r100.optString(GXTemplateKey.GAIAX_ACCESSIBILITY_DESC, null);     // Catch: Exception -> L5
        goto L7
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "radius");
        if (r100.length != 8) goto L24;
        final float r101 = r100[0];
        float r102 = r100[2];
        float r103 = r100[4];
        float r104 = r100[6];
        if (r101 != r102) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L10;
    L22:
        setClipToOutline(false);
        setOutlineProvider(null);
        return;
    L10:
        if (r102 != r103) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L22;
        if (r103 != r104) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L22;
        if (r101 <= 0.0f) goto L22;
        setClipToOutline(true);
        setOutlineProvider(new AnonymousClass1(this, r101));
        return;
    L17:
        r107 = false;
        goto L18
    L12:
        r106 = false;
        goto L13
    L7:
        r105 = false;
        goto L8
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public void setTemplateContext(GXTemplateContext r100) {
        this.gxTemplateContext = r100;
    }

    public GXView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public final void onBlurChanged(GXTemplateContext r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateContext");
        Intrinsics.checkNotNullParameter(r101, "gxImageView");
        View r102 = r100.getRootView();
        if ((r102 instanceof ViewGroup) == false) goto L5;
        final ViewGroup r103 = (ViewGroup) r102;
    L7:
        if (this.gxBackdropFilter == null) goto L17;
        if (r103 == null) goto L18;
        final Rect r104 = new Rect();
        getDrawingRect(r104);
        r103.offsetDescendantRectToMyCoords(this, r104);
        Rect r105 = new Rect();
        r101.getDrawingRect(r105);
        r103.offsetDescendantRectToMyCoords(r101, r105);
        if (r105.contains(r104) == true) goto L12;
        return;
    L12:
        if (isAttachedToWindow() == false) goto L15;
        blur(r103, r104, this);
        return;
    L15:
        post(new c(this, r103, r104, this));
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final void setBackdropFilter(GXTemplateContext r100, GXBackdropFilter r101) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateContext");
        if ((r101 instanceof GXBackdropFilter.Blur) == false) goto L9;
        r100.initBlurViews();
        Set<GXView> r102 = r100.getBlurViews();
        if (r102 == null) goto L7;
        r102.add(this);
    L7:
        this.gxBackdropFilter = r101;
        return;
    L9:
        if ((r101 instanceof GXBackdropFilter.None) == false) goto L16;
        Set<GXView> r103 = r100.getBlurViews();
        if (r103 == null) goto L13;
        r103.remove(this);
    L13:
        setBackground(null);
        this.gxBackdropFilter = null;
        return;
    }

    public GXView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    private final void blur(ViewGroup r100, Rect r101, GXView r102) {
        Context r103 = r102.getContext();
        String r104 = e.f573655a;
        new View(r103).setTag(e.f573655a);
        ztc.b r105 = new ztc.b();
        r105.f573643c = 25;
        r105.f573644d = 8;
        r105.f573646f = r101;
        r105.f573645e = ColorProtector.parseColor("#33FFFFFF");
        d r106 = new d(r102, this);
        r105.f573641a = r100.getMeasuredWidth();
        int r107 = r100.getMeasuredHeight();
        r105.f573642b = r107;
        if (r105.f573641a != 0) goto L6;
        if (r107 != 0) goto L6;
        r105.f573641a = r100.getLayoutParams().width;
        r105.f573642b = r100.getLayoutParams().height;
    L6:
        ztc.d r108 = new ztc.d(r100, r105, r106);
        ztc.d.f573650e.execute(new ztc.c(r108));
    }

    private static final void blur$lambda$2(GXView r100, GXView r101, Bitmap r102) {
        Intrinsics.checkNotNullParameter(r100, "$target");
        Intrinsics.checkNotNullParameter(r101, "this$0");
        if (r102 == null) goto L6;
        r100.setBackground(new GXBlurBitmapDrawable(r101.getResources(), r102));
        return;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int r100, float r101, float[] r102) {
        Intrinsics.checkNotNullParameter(r102, "radius");
        Drawable r103 = getBackground();
        if (r103 != null) goto L6;
        GXRoundCornerBorderGradientDrawable r104 = new GXRoundCornerBorderGradientDrawable();
        r104.setShape(0);
        r104.setCornerRadii(r102);
        r104.setStroke(MathKt.roundToInt(r101), r100);
        setBackground(r104);
        return;
    L6:
        if ((r103 instanceof GradientDrawable) == false) goto L10;
        Drawable r105 = getBackground();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) r105).setStroke(MathKt.roundToInt(r101), r100);
        return;
    }

    private static final void onBlurChanged$lambda$1(GXView r100, ViewGroup r101, Rect r102, GXView r103) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r102, "$targetOffsetViewBounds");
        Intrinsics.checkNotNullParameter(r103, "$target");
        r100.blur(r101, r102, r103);
    }
}

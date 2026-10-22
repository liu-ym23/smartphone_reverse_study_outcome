package com.stepos.widget.toolbar;

import Z8.F;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.internal.HotspotRipple;
import com.stepos.widget.internal.TabIndicatorMover;
import com.stepos.widget.toolbar.StepOSTitleBar;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 ¤\u00012\u00020\u0001:\u0004¥\u0001¤\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010 \u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\u0010J\u0019\u0010&\u001a\u00020\u001c2\b\b\u0001\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\n¢\u0006\u0004\b)\u0010\u000eJ\r\u0010*\u001a\u00020\n¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\n¢\u0006\u0004\b-\u0010\u000eJ\r\u0010.\u001a\u00020\n¢\u0006\u0004\b.\u0010+J\u0017\u00100\u001a\u00020\f2\b\b\u0001\u0010/\u001a\u00020\u0019¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0019H\u0007¢\u0006\u0004\b2\u0010\u001bJ\u001f\u00103\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b3\u00104J)\u00108\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\f2\b\b\u0001\u0010%\u001a\u00020\u0006¢\u0006\u0004\b>\u0010?J\r\u0010A\u001a\u00020@¢\u0006\u0004\bA\u0010BJ\u0013\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\u0006¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\fH\u0014¢\u0006\u0004\bI\u0010\u0010J\u0017\u0010L\u001a\u00020\f2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ/\u0010R\u001a\u00020\f2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0014¢\u0006\u0004\bR\u0010SJ\u001f\u0010V\u001a\u00020\f2\u0006\u0010T\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u0006H\u0014¢\u0006\u0004\bV\u0010WJ7\u0010]\u001a\u00020\f2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u0006H\u0014¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b_\u0010`J\u0017\u0010a\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\ba\u0010`J\u000f\u0010b\u001a\u00020\fH\u0014¢\u0006\u0004\bb\u0010\u0010J\u001f\u0010e\u001a\u00020\f2\u0006\u0010c\u001a\u00020\u00192\u0006\u0010d\u001a\u00020\u0019H\u0016¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020\fH\u0016¢\u0006\u0004\bg\u0010\u0010J\u0017\u0010i\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u001cH\u0016¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\fH\u0014¢\u0006\u0004\bk\u0010\u0010R\u0016\u0010l\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010mR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010v\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010mR\u0016\u0010y\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010mR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0080\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0082\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010mR\u0018\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0088\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0017\u0010\u0090\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0094\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010mR\u0018\u0010\u0095\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010mR\u0018\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R(\u0010\u009a\u0001\u001a\u00020\n2\u0007\u0010\u0099\u0001\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u0010+\"\u0005\b\u009b\u0001\u0010\u000eR*\u0010 \u0001\u001a\u00020o2\u0007\u0010\u0099\u0001\u001a\u00020o8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010£\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\u000e\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0004\b3\u0010\u0015¨\u0006¦\u0001"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSGlassLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "animate", "LY8/t;", "moveIndicator", "(Z)V", "syncChildSelectedState", "()V", "ensureTabRipples", "Landroid/view/View;", "child", "installTabRipple", "(Landroid/view/View;)V", "requestGlassRefresh", "refreshGlass", "releaseGlass", "", "effectiveRadius", "()F", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Canvas;", "canvas", "drawDrawable", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Canvas;)V", "copyDrawable", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "applyDefaultSurface", "color", "createSurfaceDrawable", "(I)Landroid/graphics/drawable/Drawable;", x5.d.EXTRA_ENABLED, "setGlassEnabled", "isGlassEnabled", "()Z", "crossWindow", "setGlassCrossWindow", "isGlassCrossWindow", "radius", "setCornerRadius", "(F)V", "getCornerRadius", "setSelectedChild", "(Landroid/view/View;Z)V", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "setSurfaceBackground", "(Landroid/graphics/drawable/Drawable;)V", "getSurfaceBackground", "()Landroid/graphics/drawable/Drawable;", "setSurfaceColor", "(I)V", "Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "getGlassRenderMode", "()Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "", "", "getGlassActiveIds", "()Ljava/util/Set;", "getGlassActiveCount", "()I", "onAttachedToWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "width", "height", "oldWidth", "oldHeight", "onSizeChanged", "(IIII)V", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "changed", "l", "t", "r", Const.INTENT_KEY_PKGNAME, "onLayout", "(ZIIII)V", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "onDraw", "drawableStateChanged", "x", "y", "drawableHotspotChanged", "(FF)V", "jumpDrawablesToCurrentState", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "onDetachedFromWindow", "glassEnabled", "Z", "glassCrossWindow", "Ly7/o;", "glassEffectValue", "Ly7/o;", "cornerRadius", "F", "surfaceColor", "Ljava/lang/Integer;", "surfaceBackground", "Landroid/graphics/drawable/Drawable;", "usesDefaultSurface", "constructed", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Lcom/stepos/widget/toolbar/StepOSGlassLayout$GlassRequest;", "appliedRequest", "Lcom/stepos/widget/toolbar/StepOSGlassLayout$GlassRequest;", "renderMode", "Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "refreshPosted", "Landroid/graphics/Paint;", "indicatorPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Rect;", "indicatorRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "indicatorRectF", "Landroid/graphics/RectF;", "indicatorTarget", "Lcom/stepos/widget/internal/TabIndicatorMover;", "indicatorMover", "Lcom/stepos/widget/internal/TabIndicatorMover;", "indicatorAnimationDuration", "I", "selectedChildValue", "Landroid/view/View;", "tabRippleEnabled", "pressScaleEnabledValue", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", UxipConstants.f30680s, "isPressScaleEnabled", "setPressScaleEnabled", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "glassEffect", "getSelectedChild", "()Landroid/view/View;", "selectedChild", "Companion", "GlassRequest", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSGlassLayout extends LinearLayout {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "StepOSGlassLayout";
    private GlassRequest appliedRequest;
    private boolean constructed;
    private float cornerRadius;
    private boolean glassCrossWindow;
    private final GlassDelegate glassDelegate;
    private y7.o glassEffectValue;
    private boolean glassEnabled;
    private final int indicatorAnimationDuration;
    private final TabIndicatorMover indicatorMover;
    private final Paint indicatorPaint;
    private final Rect indicatorRect;
    private final RectF indicatorRectF;
    private final Rect indicatorTarget;
    private boolean pressScaleEnabledValue;
    private boolean refreshPosted;
    private final Runnable refreshRunnable;
    private StepOSTitleBar.GlassRenderMode renderMode;
    private View selectedChildValue;
    private Drawable surfaceBackground;
    private Integer surfaceColor;
    private boolean tabRippleEnabled;
    private boolean usesDefaultSurface;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSGlassLayout$Companion;", "", "<init>", "()V", "TAG", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015JB\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u000eJ\u001a\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010\u0013R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010\u0015¨\u0006("}, d2 = {"Lcom/stepos/widget/toolbar/StepOSGlassLayout$GlassRequest;", "", "", "width", "height", "", "radius", "", "crossWindow", "Ly7/o;", "effect", "<init>", "(IIFZLy7/o;)V", "component1", "()I", "component2", "component3", "()F", "component4", "()Z", "component5", "()Ly7/o;", ChatTracker.CLICK_COPY, "(IIFZLy7/o;)Lcom/stepos/widget/toolbar/StepOSGlassLayout$GlassRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getWidth", "getHeight", "F", "getRadius", "Z", "getCrossWindow", "Ly7/o;", "getEffect", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class GlassRequest {
        private final boolean crossWindow;
        private final y7.o effect;
        private final int height;
        private final float radius;
        private final int width;

        public GlassRequest(int i10, int i11, float f10, boolean z10, y7.o effect) {
            kotlin.jvm.internal.p.i(effect, "effect");
            this.width = i10;
            this.height = i11;
            this.radius = f10;
            this.crossWindow = z10;
            this.effect = effect;
        }

        public static /* synthetic */ GlassRequest copy$default(GlassRequest glassRequest, int i10, int i11, float f10, boolean z10, y7.o oVar, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = glassRequest.width;
            }
            if ((i12 & 2) != 0) {
                i11 = glassRequest.height;
            }
            if ((i12 & 4) != 0) {
                f10 = glassRequest.radius;
            }
            if ((i12 & 8) != 0) {
                z10 = glassRequest.crossWindow;
            }
            if ((i12 & 16) != 0) {
                oVar = glassRequest.effect;
            }
            y7.o oVar2 = oVar;
            float f11 = f10;
            return glassRequest.copy(i10, i11, f11, z10, oVar2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: component3, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCrossWindow() {
            return this.crossWindow;
        }

        /* renamed from: component5, reason: from getter */
        public final y7.o getEffect() {
            return this.effect;
        }

        public final GlassRequest copy(int width, int height, float radius, boolean crossWindow, y7.o effect) {
            kotlin.jvm.internal.p.i(effect, "effect");
            return new GlassRequest(width, height, radius, crossWindow, effect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GlassRequest)) {
                return false;
            }
            GlassRequest glassRequest = (GlassRequest) other;
            return this.width == glassRequest.width && this.height == glassRequest.height && Float.compare(this.radius, glassRequest.radius) == 0 && this.crossWindow == glassRequest.crossWindow && kotlin.jvm.internal.p.d(this.effect, glassRequest.effect);
        }

        public final boolean getCrossWindow() {
            return this.crossWindow;
        }

        public final y7.o getEffect() {
            return this.effect;
        }

        public final int getHeight() {
            return this.height;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.radius)) * 31) + Boolean.hashCode(this.crossWindow)) * 31) + this.effect.hashCode();
        }

        public String toString() {
            return "GlassRequest(width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", crossWindow=" + this.crossWindow + ", effect=" + this.effect + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassLayout(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final void applyDefaultSurface() {
        this.usesDefaultSurface = true;
        int color = getContext().getColor(R.color.stepos_titlebar_glass_surface);
        this.surfaceColor = Integer.valueOf(color);
        this.surfaceBackground = createSurfaceDrawable(color);
        invalidate();
    }

    private final Drawable copyDrawable(Drawable drawable) {
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        Drawable drawableMutate;
        if (drawable != null && (constantState = drawable.getConstantState()) != null && (drawableNewDrawable = constantState.newDrawable(getResources())) != null && (drawableMutate = drawableNewDrawable.mutate()) != null) {
            return drawableMutate;
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }

    private final Drawable createSurfaceDrawable(int color) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(effectiveRadius());
        return gradientDrawable;
    }

    private final void drawDrawable(Drawable drawable, Canvas canvas) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.draw(canvas);
    }

    private final float effectiveRadius() {
        float f10 = this.cornerRadius;
        return f10 > 0.0f ? f10 : Math.min(getWidth(), getHeight()) / 2.0f;
    }

    private final void ensureTabRipples() {
        if (this.tabRippleEnabled) {
            return;
        }
        this.tabRippleEnabled = true;
        setClipChildren(false);
        setClipToPadding(false);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            installTabRipple(childAt);
        }
    }

    private final void installTabRipple(View child) {
        HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, child, getContext().getColor(R.color.stepos_titlebar_action_ripple), 0.0f, false, this.pressScaleEnabledValue, 0.0f, 44, null);
    }

    private final void moveIndicator(boolean animate) {
        View view = this.selectedChildValue;
        if (view == null || view.getVisibility() == 8 || view.getWidth() <= 0) {
            this.indicatorMover.cancel$StepOSWidget_release();
            this.indicatorRect.setEmpty();
            invalidate();
        } else {
            this.indicatorTarget.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            this.indicatorMover.move$StepOSWidget_release(this.indicatorRect, this.indicatorTarget, !this.indicatorRect.isEmpty(), animate, this.indicatorAnimationDuration, new InterfaceC5074l() { // from class: com.stepos.widget.toolbar.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSGlassLayout.moveIndicator$lambda$7(this.f31416a, (Rect) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t moveIndicator$lambda$7(StepOSGlassLayout stepOSGlassLayout, Rect it) {
        kotlin.jvm.internal.p.i(it, "it");
        stepOSGlassLayout.invalidate();
        return Y8.t.f7040a;
    }

    private final void refreshGlass() {
        if (getWidth() <= 0 || getHeight() <= 0 || getVisibility() == 8) {
            releaseGlass();
            this.renderMode = this.glassEnabled ? StepOSTitleBar.GlassRenderMode.PENDING : StepOSTitleBar.GlassRenderMode.DISABLED;
            return;
        }
        if (!this.glassEnabled) {
            releaseGlass();
            this.renderMode = StepOSTitleBar.GlassRenderMode.DISABLED;
            invalidate();
            return;
        }
        GlassRequest glassRequest = new GlassRequest(getWidth(), getHeight(), effectiveRadius(), this.glassCrossWindow, getGlassEffectValue());
        if (kotlin.jvm.internal.p.d(this.appliedRequest, glassRequest)) {
            return;
        }
        StepOSTitleBar.GlassRenderMode glassRenderMode = this.glassDelegate.apply$StepOSWidget_release(this.glassCrossWindow ? 1 : 0, effectiveRadius(), getGlassEffectValue()) ? StepOSTitleBar.GlassRenderMode.MOTION_KIT : StepOSTitleBar.GlassRenderMode.PENDING;
        this.renderMode = glassRenderMode;
        this.appliedRequest = glassRequest;
        Log.i(TAG, "Glass layout mode=" + glassRenderMode + " activeIds=" + this.glassDelegate.getActiveIds$StepOSWidget_release());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(StepOSGlassLayout stepOSGlassLayout) {
        stepOSGlassLayout.refreshPosted = false;
        if (stepOSGlassLayout.isAttachedToWindow()) {
            stepOSGlassLayout.refreshGlass();
        }
    }

    private final void releaseGlass() {
        this.glassDelegate.release$StepOSWidget_release();
        this.appliedRequest = null;
        this.renderMode = this.glassEnabled ? StepOSTitleBar.GlassRenderMode.PENDING : StepOSTitleBar.GlassRenderMode.DISABLED;
        invalidate();
    }

    private final void requestGlassRefresh() {
        if (!isAttachedToWindow() || this.refreshPosted) {
            return;
        }
        this.refreshPosted = true;
        post(this.refreshRunnable);
    }

    private final void syncChildSelectedState() {
        View view = this.selectedChildValue;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            childAt.setSelected(childAt == view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        kotlin.jvm.internal.p.i(child, "child");
        super.addView(child, index, params);
        if (this.tabRippleEnabled) {
            installTabRipple(child);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (!this.indicatorRect.isEmpty()) {
            this.indicatorRectF.set(this.indicatorRect);
            float fMin = Math.min(this.indicatorRect.width(), this.indicatorRect.height()) / 2.0f;
            canvas.drawRoundRect(this.indicatorRectF, fMin, fMin, this.indicatorPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float x10, float y10) {
        super.drawableHotspotChanged(x10, y10);
        Drawable drawable = this.surfaceBackground;
        if (drawable != null) {
            drawable.setHotspot(x10, y10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.surfaceBackground;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = drawable.setState(getDrawableState());
        }
        if (state) {
            invalidate();
        }
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getGlassActiveCount() {
        return this.glassDelegate.getActiveIds$StepOSWidget_release().size();
    }

    public final Set<String> getGlassActiveIds() {
        return F.r1(this.glassDelegate.getActiveIds$StepOSWidget_release());
    }

    /* renamed from: getGlassEffect, reason: from getter */
    public final y7.o getGlassEffectValue() {
        return this.glassEffectValue;
    }

    /* renamed from: getGlassRenderMode, reason: from getter */
    public final StepOSTitleBar.GlassRenderMode getRenderMode() {
        return this.renderMode;
    }

    /* renamed from: getSelectedChild, reason: from getter */
    public final View getSelectedChildValue() {
        return this.selectedChildValue;
    }

    public final Drawable getSurfaceBackground() {
        return copyDrawable(this.surfaceBackground);
    }

    /* renamed from: isGlassCrossWindow, reason: from getter */
    public final boolean getGlassCrossWindow() {
        return this.glassCrossWindow;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getGlassEnabled() {
        return this.glassEnabled;
    }

    /* renamed from: isPressScaleEnabled, reason: from getter */
    public final boolean getPressScaleEnabledValue() {
        return this.pressScaleEnabledValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.surfaceBackground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestGlassRefresh();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.usesDefaultSurface) {
            applyDefaultSurface();
        }
        this.indicatorPaint.setColor(getContext().getColor(R.color.stepos_interactive_pressed));
        releaseGlass();
        requestGlassRefresh();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.indicatorMover.cancel$StepOSWidget_release();
        removeCallbacks(this.refreshRunnable);
        this.refreshPosted = false;
        releaseGlass();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        drawDrawable(this.surfaceBackground, canvas);
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l10, int t10, int r10, int b10) {
        super.onLayout(changed, l10, t10, r10, b10);
        moveIndicator(false);
    }

    @Override // android.view.View
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        Integer num = this.surfaceColor;
        if (num != null) {
            this.surfaceBackground = createSurfaceDrawable(num.intValue());
        }
        requestGlassRefresh();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (this.constructed && changedView == this) {
            if (visibility == 8) {
                releaseGlass();
            } else {
                requestGlassRefresh();
            }
        }
    }

    public final void setCornerRadius(float radius) {
        float fMax = Math.max(0.0f, radius);
        if (this.cornerRadius == fMax) {
            return;
        }
        this.cornerRadius = fMax;
        Integer num = this.surfaceColor;
        if (num != null) {
            this.surfaceBackground = createSurfaceDrawable(num.intValue());
        }
        releaseGlass();
        requestGlassRefresh();
        invalidate();
    }

    public final void setGlassCrossWindow(boolean crossWindow) {
        if (this.glassCrossWindow == crossWindow) {
            return;
        }
        this.glassCrossWindow = crossWindow;
        releaseGlass();
        requestGlassRefresh();
    }

    public final void setGlassEffect(y7.o value) {
        kotlin.jvm.internal.p.i(value, "value");
        if (kotlin.jvm.internal.p.d(this.glassEffectValue, value)) {
            return;
        }
        this.glassEffectValue = value;
        releaseGlass();
        requestGlassRefresh();
    }

    public final void setGlassEnabled(boolean enabled) {
        if (this.glassEnabled == enabled) {
            return;
        }
        this.glassEnabled = enabled;
        releaseGlass();
        requestGlassRefresh();
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.pressScaleEnabledValue == z10) {
            return;
        }
        this.pressScaleEnabledValue = z10;
        HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(this, z10);
    }

    public final void setSelectedChild(View view) {
        setSelectedChild(view, true);
    }

    public final void setSurfaceBackground(Drawable drawable) {
        this.usesDefaultSurface = false;
        this.surfaceColor = null;
        this.surfaceBackground = copyDrawable(drawable);
        invalidate();
    }

    public final void setSurfaceColor(int color) {
        this.usesDefaultSurface = false;
        this.surfaceColor = Integer.valueOf(color);
        this.surfaceBackground = createSurfaceDrawable(color);
        invalidate();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        kotlin.jvm.internal.p.i(who, "who");
        return who == this.surfaceBackground || super.verifyDrawable(who);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void setSelectedChild(View child, boolean animate) {
        if (child != null && child.getParent() != this) {
            throw new IllegalArgumentException("selected child must be a direct child of this StepOSGlassLayout");
        }
        boolean z10 = false;
        boolean z11 = this.selectedChildValue != child;
        this.selectedChildValue = child;
        ensureTabRipples();
        if (z11) {
            syncChildSelectedState();
        }
        if (animate && z11) {
            z10 = true;
        }
        moveIndicator(z10);
    }

    public /* synthetic */ StepOSGlassLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSGlassLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.glassEnabled = true;
        this.glassEffectValue = y7.o.INSTANCE.i();
        this.glassDelegate = new GlassDelegate(this);
        this.renderMode = StepOSTitleBar.GlassRenderMode.PENDING;
        Paint paint = new Paint(1);
        this.indicatorPaint = paint;
        this.indicatorRect = new Rect();
        this.indicatorRectF = new RectF();
        this.indicatorTarget = new Rect();
        this.indicatorMover = new TabIndicatorMover();
        this.indicatorAnimationDuration = getResources().getInteger(R.integer.stepos_tabbar_indicator_animation_duration);
        this.pressScaleEnabledValue = true;
        this.refreshRunnable = new Runnable() { // from class: com.stepos.widget.toolbar.q
            @Override // java.lang.Runnable
            public final void run() {
                StepOSGlassLayout.refreshRunnable$lambda$0(this.f31417a);
            }
        };
        setWillNotDraw(false);
        this.surfaceBackground = copyDrawable(getBackground());
        setBackground(null);
        if (this.surfaceBackground == null) {
            applyDefaultSurface();
        }
        paint.setColor(context.getColor(R.color.stepos_interactive_pressed));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSGlassLayout, i10, 0);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        y7.o oVar = GlassEffectResolver.INSTANCE.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSGlassLayout_steposGlassEffect);
        if (oVar != null) {
            setGlassEffect(oVar);
        }
        this.pressScaleEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSGlassLayout_steposPressScaleEnabled, true);
        Y8.t tVar = Y8.t.f7040a;
        typedArrayObtainStyledAttributes.recycle();
        this.constructed = true;
    }
}

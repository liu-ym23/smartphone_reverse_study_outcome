package com.obric.oui.texteffects;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EffectLayer;
import com.obric.oui.texteffects.core.EffectStage;
import com.obric.oui.texteffects.core.EffectValue;
import com.obric.oui.texteffects.core.FillSpec;
import com.obric.oui.texteffects.core.LoopSpec;
import com.obric.oui.texteffects.core.SelectorSpec;
import com.obric.oui.texteffects.core.TextEffectSpec;
import com.obric.oui.texteffects.core.TextSource;
import com.obric.oui.texteffects.render.BlurMaskFilterCache;
import com.obric.oui.texteffects.render.CanvasTextLayerRenderer;
import com.obric.oui.texteffects.render.TextLayoutCache;
import com.obric.oui.texteffects.render.TextLayoutCacheBuilder;
import com.obric.oui.texteffects.runtime.LayerFrame;
import com.obric.oui.texteffects.runtime.TextEffectFrame;
import com.obric.oui.texteffects.runtime.TextEffectTimelineSampler;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u0094\u00012\u00020\u0001:\u0002\u0094\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0014J \u0010:\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020!H\u0014J\u001a\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010=\u001a\u00020!2\u0006\u0010;\u001a\u00020@H\u0014J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020'H\u0014J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020EH\u0004J\b\u0010F\u001a\u000205H\u0004J\b\u0010G\u001a\u00020\u0019H\u0004J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H\u0014J\u0010\u0010J\u001a\u0002052\u0006\u0010K\u001a\u00020LH\u0014J\\\u0010M\u001a\u0002052\u0006\u0010K\u001a\u00020L2\u0006\u00106\u001a\u0002072\u0006\u0010=\u001a\u00020!2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J \u0010X\u001a\u0002052\u0006\u0010K\u001a\u00020L2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0014J\u001a\u0010]\u001a\u0004\u0018\u00010Z2\u0006\u0010^\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\\H\u0004J\b\u0010_\u001a\u000205H\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020\u0019H\u0004J\u0018\u0010c\u001a\u00020)2\u0006\u0010=\u001a\u00020!2\u0006\u0010B\u001a\u00020'H\u0004J\u0018\u0010d\u001a\u00020\u00192\u0006\u0010e\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u0019H\u0014J\b\u0010g\u001a\u000205H\u0014J\u0010\u0010h\u001a\u0002052\u0006\u0010K\u001a\u00020LH\u0014J \u0010i\u001a\u0002052\u0006\u0010j\u001a\u00020\n2\u0006\u00103\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u000fH\u0014J(\u0010k\u001a\u0002052\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u0007H\u0014J*\u0010p\u001a\u0002052\b\u0010B\u001a\u0004\u0018\u00010'2\u0006\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0014J\b\u0010t\u001a\u000205H\u0014J\u0018\u0010u\u001a\u0002052\u0006\u0010j\u001a\u00020\n2\u0006\u0010^\u001a\u00020\u000fH\u0014J\b\u0010v\u001a\u000205H\u0014J\n\u0010w\u001a\u0004\u0018\u00010xH\u0004J\u0010\u0010y\u001a\u00020\u001d2\u0006\u0010z\u001a\u00020\u001dH\u0004J\u0010\u0010{\u001a\u0002052\u0006\u0010|\u001a\u00020\u0019H\u0016J\u0010\u0010}\u001a\u0002052\u0006\u0010^\u001a\u00020\u000fH\u0002JI\u0010~\u001a\u0002052\u0006\u0010^\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\n2\b\b\u0002\u0010\u007f\u001a\u00020)2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010'2\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010'2\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010'H\u0004J\u0014\u0010\u0083\u0001\u001a\u0002052\t\b\u0002\u0010\u0084\u0001\u001a\u00020)H\u0002J\t\u0010\u0085\u0001\u001a\u000205H\u0016J0\u0010\u0086\u0001\u001a\u0002052\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010'2\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010'2\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010'H\u0004J\"\u0010\u0087\u0001\u001a\u00020\u0019*\u00020\\2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u0019H\u0004J(\u0010\u008b\u0001\u001a\u000205*\u00030\u008c\u00012\u0006\u0010K\u001a\u00020L2\u0007\u0010\u008d\u0001\u001a\u00020\u00072\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0002J\u000e\u0010\u008f\u0001\u001a\u00020\u0007*\u00030\u008c\u0001H\u0002J\u000e\u0010\u0090\u0001\u001a\u00020\u0007*\u00030\u008c\u0001H\u0002J\r\u0010\u0091\u0001\u001a\u00020U*\u000209H\u0002J\u0010\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001*\u000209H\u0002R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u0019X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u0019@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020\nX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\rR\u0014\u0010-\u001a\u00020\u0019X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0010\u0010/\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0095\u0001"}, d2 = {"Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "activeEffectName", "getActiveEffectName", "()Ljava/lang/String;", "activeSpec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "animator", "Landroid/animation/ValueAnimator;", "blurFilterCache", "Lcom/obric/oui/texteffects/render/BlurMaskFilterCache;", "getBlurFilterCache", "()Lcom/obric/oui/texteffects/render/BlurMaskFilterCache;", "blurFilterCache$delegate", "Lkotlin/Lazy;", "blurFilterCacheGranularityPx", "", "getBlurFilterCacheGranularityPx", "()F", "currentEffectPlayTimeMs", "", "getCurrentEffectPlayTimeMs", "()J", "currentTextCache", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "debugAnimationDurationScale", "getDebugAnimationDurationScale", "dp", "Lkotlin/Function1;", "finalTextOnEnd", "", "isEffectRunning", "", "()Z", "logTag", "getLogTag", "maxBlurRadiusDp", "getMaxBlurRadiusDp", "newTextCache", "newTextForEffect", "oldTextCache", "oldTextForEffect", "playTimeMs", "applyBlendToPaint", "", "paint", "Landroid/graphics/Paint;", "blend", "Lcom/obric/oui/texteffects/core/BlendSpec;", "applyFillToPaint", "fill", "Lcom/obric/oui/texteffects/core/FillSpec;", "cache", "buildGradientShader", "Landroid/graphics/LinearGradient;", "Lcom/obric/oui/texteffects/core/FillSpec$LinearGradient;", "buildTextCache", "text", "cacheForSource", "source", "Lcom/obric/oui/texteffects/core/TextSource;", "clearTextCaches", "computeContentWidth", "computeStartX", "textWidth", "drawCompoundDrawables", "canvas", "Landroid/graphics/Canvas;", "drawScanLayer", "layerLeft", "layerRight", "drawX", "scanProgress", "selector", "Lcom/obric/oui/texteffects/core/SelectorSpec$ScanWindow;", "originalBlendMode", "Landroid/graphics/BlendMode;", "originalXfermode", "Landroid/graphics/Xfermode;", "drawTextLayer", "layer", "Lcom/obric/oui/texteffects/core/EffectLayer$Text;", "frame", "Lcom/obric/oui/texteffects/runtime/LayerFrame;", "findTextLayer", "spec", "finishEffect", "getBlurMaskFilter", "Landroid/graphics/BlurMaskFilter;", "radiusPx", "isTextCacheReusable", "layerInsetPx", "translationX", "blurPx", "onDetachedFromWindow", "onDraw", "onEffectFrameUpdated", "effectName", "onSizeChanged", "w", "h", "oldw", "oldh", "onTextChanged", "start", "lengthBefore", "lengthAfter", "onTextEffectFinished", "onTextEffectStarted", "onTextEffectStopped", "sampleCurrentEffectFrame", "Lcom/obric/oui/texteffects/runtime/TextEffectFrame;", "scaledDurationMs", "durationMs", "setDebugAnimationDurationScale", "scale", "startAnimator", "startTextEffect", "restart", "finalText", "oldText", "newText", "stopAnimator", "keepFrame", "stopEffect", "updateTextEffectSnapshots", "dimensionPropertyPx", "value", "Lcom/obric/oui/texteffects/core/EffectValue;", "defaultDp", "drawAt", "Landroid/graphics/drawable/Drawable;", "left", "top", "drawableHeight", "drawableWidth", "toAndroidBlendMode", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "Companion", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OProtocolTextEffectTextView extends TextView {
    private static final Companion Companion = null;

    @Deprecated
    public static final String EffectNameNone = "none";
    private String activeEffectName;
    private TextEffectSpec activeSpec;
    private ValueAnimator animator;
    private final Lazy blurFilterCache$delegate;
    private final float blurFilterCacheGranularityPx;
    private TextLayoutCache currentTextCache;
    private float debugAnimationDurationScale;
    private final Function1<Float, Float> dp;
    private CharSequence finalTextOnEnd;
    private final String logTag;
    private final float maxBlurRadiusDp;
    private TextLayoutCache newTextCache;
    private CharSequence newTextForEffect;
    private TextLayoutCache oldTextCache;
    private CharSequence oldTextForEffect;
    private long playTimeMs;

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/OProtocolTextEffectTextView$Companion;", "", "()V", "EffectNameNone", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[TextSource.values().length];
            r0[TextSource.Current.ordinal()] = 1;
            r0[TextSource.Old.ordinal()] = 2;
            r0[TextSource.New.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[BlendSpec.values().length];
            r1[BlendSpec.CLEAR.ordinal()] = 1;
            r1[BlendSpec.SRC.ordinal()] = 2;
            r1[BlendSpec.DST.ordinal()] = 3;
            r1[BlendSpec.SRC_OVER.ordinal()] = 4;
            r1[BlendSpec.DST_OVER.ordinal()] = 5;
            r1[BlendSpec.SRC_IN.ordinal()] = 6;
            r1[BlendSpec.DST_IN.ordinal()] = 7;
            r1[BlendSpec.SRC_OUT.ordinal()] = 8;
            r1[BlendSpec.DST_OUT.ordinal()] = 9;
            r1[BlendSpec.SRC_ATOP.ordinal()] = 10;
            r1[BlendSpec.DST_ATOP.ordinal()] = 11;
            r1[BlendSpec.XOR.ordinal()] = 12;
            r1[BlendSpec.PLUS.ordinal()] = 13;
            r1[BlendSpec.MODULATE.ordinal()] = 14;
            r1[BlendSpec.SCREEN.ordinal()] = 15;
            r1[BlendSpec.OVERLAY.ordinal()] = 16;
            r1[BlendSpec.DARKEN.ordinal()] = 17;
            r1[BlendSpec.LIGHTEN.ordinal()] = 18;
            r1[BlendSpec.COLOR_DODGE.ordinal()] = 19;
            r1[BlendSpec.COLOR_BURN.ordinal()] = 20;
            r1[BlendSpec.HARD_LIGHT.ordinal()] = 21;
            r1[BlendSpec.SOFT_LIGHT.ordinal()] = 22;
            r1[BlendSpec.DIFFERENCE.ordinal()] = 23;
            r1[BlendSpec.EXCLUSION.ordinal()] = 24;
            r1[BlendSpec.MULTIPLY.ordinal()] = 25;
            r1[BlendSpec.HUE.ordinal()] = 26;
            r1[BlendSpec.SATURATION.ordinal()] = 27;
            r1[BlendSpec.COLOR.ordinal()] = 28;
            r1[BlendSpec.LUMINOSITY.ordinal()] = 29;
            $EnumSwitchMapping$1 = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.texteffects.OProtocolTextEffectTextView$buildTextCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Float, Float> {
        AnonymousClass1(Object r8) {
            super(1, r8, OProtocolTextEffectTextView.class, "computeStartX", "computeStartX(F)F", 0);
        }

        public final Float invoke(float r1) {
            return Float.valueOf(((OProtocolTextEffectTextView) this.receiver).computeStartX(r1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float r1) {
            return invoke(r1.floatValue());
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.texteffects.OProtocolTextEffectTextView$drawTextLayer$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OProtocolTextEffectTextView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class C03752 extends FunctionReferenceImpl implements Function1<Float, BlurMaskFilter> {
        C03752(Object r8) {
            super(1, r8, OProtocolTextEffectTextView.class, "getBlurMaskFilter", "getBlurMaskFilter(F)Landroid/graphics/BlurMaskFilter;", 0);
        }

        public final BlurMaskFilter invoke(float r1) {
            return ((OProtocolTextEffectTextView) this.receiver).getBlurMaskFilter(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ BlurMaskFilter invoke(Float r1) {
            return invoke(r1.floatValue());
        }
    }

    public static /* synthetic */ void $r8$lambda$Qze8L_aw86dsOsOB2L0Vq_OMuyc(OProtocolTextEffectTextView r0, TextEffectSpec r1, ValueAnimator r2) {
        m721startAnimator$lambda9$lambda8(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public OProtocolTextEffectTextView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OProtocolTextEffectTextView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    protected void onEffectFrameUpdated(String r1, long r2, TextEffectSpec r4) {
        Intrinsics.checkNotNullParameter(r1, "effectName");
        Intrinsics.checkNotNullParameter(r4, "spec");
    }

    protected void onTextEffectFinished() {
    }

    protected void onTextEffectStarted(String r1, TextEffectSpec r2) {
        Intrinsics.checkNotNullParameter(r1, "effectName");
        Intrinsics.checkNotNullParameter(r2, "spec");
    }

    protected void onTextEffectStopped() {
    }

    public /* synthetic */ OProtocolTextEffectTextView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$finishEffect(OProtocolTextEffectTextView r0) {
        r0.finishEffect();
    }

    public static final /* synthetic */ Function1 access$getDp$p(OProtocolTextEffectTextView r0) {
        return r0.dp;
    }

    public OProtocolTextEffectTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.dp = new OProtocolTextEffectTextView$dp$1(this);
        this.blurFilterCache$delegate = LazyKt.lazy(new OProtocolTextEffectTextView$blurFilterCache$2(this));
        this.activeEffectName = "none";
        this.debugAnimationDurationScale = 1.0f;
        this.logTag = "ProtocolTextEffectView";
        this.maxBlurRadiusDp = 16.0f;
        this.blurFilterCacheGranularityPx = 0.5f;
    }

    private final BlurMaskFilterCache getBlurFilterCache() {
        return (BlurMaskFilterCache) this.blurFilterCache$delegate.getValue();
    }

    protected final String getActiveEffectName() {
        return this.activeEffectName;
    }

    protected final float getDebugAnimationDurationScale() {
        return this.debugAnimationDurationScale;
    }

    public final boolean isEffectRunning() {
        if (this.activeSpec == null) goto L5;
        return true;
    L5:
        return false;
    }

    protected final long getCurrentEffectPlayTimeMs() {
        return this.playTimeMs;
    }

    protected final TextEffectFrame sampleCurrentEffectFrame() {
        TextEffectSpec r0 = this.activeSpec;
        if (r0 != null) goto L7;
        return null;
    L7:
        return TextEffectTimelineSampler.INSTANCE.sample(r0, this.playTimeMs);
    }

    protected String getLogTag() {
        return this.logTag;
    }

    protected float getMaxBlurRadiusDp() {
        return this.maxBlurRadiusDp;
    }

    protected float getBlurFilterCacheGranularityPx() {
        return this.blurFilterCacheGranularityPx;
    }

    public void setDebugAnimationDurationScale(float r3) {
        if (Float.isNaN(r3) == false) goto L5;
    L8:
        float r4 = 1.0f;
    L10:
        if (this.debugAnimationDurationScale != r4) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return;
    L15:
        this.debugAnimationDurationScale = r4;
        TextEffectDebugLog r1 = TextEffectDebugLog.INSTANCE;
        String r2 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r2), Intrinsics.stringPlus("setDebugAnimationDurationScale scale=", Float.valueOf(r4)));
        return;
    L19:
        return;
    L12:
        r0 = false;
        goto L13
    L5:
        if (Float.isInfinite(r3) == true) goto L8;
        r4 = RangesKt.coerceIn(r3, 0.1f, 10.0f);
        goto L10
    }

    public void stopEffect() {
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        String r1 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r1), Intrinsics.stringPlus("stopEffect effect=", getActiveEffectName()));
    L5:
        stopAnimator$default(this, false, 1, null);
        this.activeSpec = null;
        this.activeEffectName = "none";
        this.playTimeMs = 0;
        this.finalTextOnEnd = null;
        this.oldTextForEffect = null;
        this.newTextForEffect = null;
        this.oldTextCache = null;
        this.newTextCache = null;
        onTextEffectStopped();
        invalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        String r1 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r1), "onDetachedFromWindow, clear animator and blur cache");
    L5:
        stopEffect();
        getBlurFilterCache().clear();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        String r1 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r1), "onSizeChanged " + r6 + " x " + r7 + " -> " + r4 + " x " + r5 + ", clear text caches");
    L5:
        clearTextCaches();
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        this.currentTextCache = null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        TextEffectSpec r0 = this.activeSpec;
        if (r0 != null) goto L6;
        super.onDraw(r11);
        return;
    L6:
        TextEffectFrame r1 = TextEffectTimelineSampler.INSTANCE.sample(r0, this.playTimeMs);
        TextEffectDebugLog r2 = TextEffectDebugLog.INSTANCE;
        String r3 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == true) goto L9;
    L11:
        drawCompoundDrawables(r11);
        int r4 = r11.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        Iterator<T> r5 = r1.getLayers().iterator();     // Catch: Throwable -> L22
    L14:
        if (r5.hasNext() == false) goto L20;
        LayerFrame r6 = (LayerFrame) r5.next();     // Catch: Throwable -> L22
        EffectLayer.Text r7 = findTextLayer(r0, r6);     // Catch: Throwable -> L22
        if (r7 == null) goto L14;
        drawTextLayer(r11, r7, r6);     // Catch: Throwable -> L22
        goto L14
    L20:
        r11.restoreToCount(r4);
        return;
    L22:
        th = move-exception;
        r11.restoreToCount(r4);
        throw th;
    L9:
        if (TextEffectDebugLog.getFrameEnabled() == false) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r3), "onDraw effect=" + getActiveEffectName() + ", spec=" + r0.getId() + ", playTime=" + this.playTimeMs + ", layers=" + r1.getLayers().size());
        goto L11
    }

    public static /* synthetic */ void startTextEffect$default(OProtocolTextEffectTextView r7, TextEffectSpec r8, String r9, boolean r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, Object r15) {
        if (r15 != null) goto L21;
        if ((r14 & 4) == 0) goto L6;
        r10 = false;
    L6:
        boolean r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        CharSequence r4 = null;
    L11:
        if ((r14 & 16) == 0) goto L13;
        CharSequence r5 = null;
    L15:
        if ((r14 & 32) == 0) goto L17;
        CharSequence r6 = null;
    L18:
        r7.startTextEffect(r8, r9, r3, r4, r5, r6);
        return;
    L17:
        r6 = r13;
        goto L18
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startTextEffect");
    }

    protected final void startTextEffect(TextEffectSpec r5, String r6, boolean r7, CharSequence r8, CharSequence r9, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "spec");
        Intrinsics.checkNotNullParameter(r6, "effectName");
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        String r1 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r1), "startTextEffect id=" + r5.getId() + ", effect=" + r6 + ", duration=" + r5.getDurationMs() + ", loop=" + r5.getLoop() + ", restart=" + r7 + ", finalText=" + r8);
    L6:
        if (r7 == true) goto L8;
        stopAnimator$default(this, false, 1, null);
    L9:
        this.activeSpec = r5;
        this.activeEffectName = r6;
        this.playTimeMs = 0;
        this.finalTextOnEnd = r8;
        this.oldTextForEffect = r9;
        this.newTextForEffect = r10;
        this.oldTextCache = null;
        this.newTextCache = null;
        onTextEffectStarted(r6, r5);
        startAnimator(r5);
        invalidate();
        return;
    L8:
        stopAnimator(true);
        goto L9
    }

    public static /* synthetic */ void updateTextEffectSnapshots$default(OProtocolTextEffectTextView r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, Object r5) {
        if (r5 != null) goto L15;
        if ((r4 & 1) == 0) goto L7;
        r1 = r0.finalTextOnEnd;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r2 = r0.oldTextForEffect;
    L10:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.newTextForEffect;
    L12:
        r0.updateTextEffectSnapshots(r1, r2, r3);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTextEffectSnapshots");
    }

    protected final void updateTextEffectSnapshots(CharSequence r1, CharSequence r2, CharSequence r3) {
        this.finalTextOnEnd = r1;
        this.oldTextForEffect = r2;
        this.newTextForEffect = r3;
        this.oldTextCache = null;
        this.newTextCache = null;
        invalidate();
    }

    private final void startAnimator(final TextEffectSpec r5) {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(scaledDurationMs(r5.getDurationMs()));
        r1.setInterpolator(new LinearInterpolator());
        if (Intrinsics.areEqual(r5.getLoop(), LoopSpec.Infinite.INSTANCE) == false) goto L5;
        int r2 = -1;
    L6:
        r1.setRepeatCount(r2);
        r1.setRepeatMode(1);
        r1.addUpdateListener(new OProtocolTextEffectTextView$$ExternalSyntheticLambda0(this, r5));
        r1.addListener(new OProtocolTextEffectTextView$startAnimator$1$2(r0, this, r5));
        r1.start();
        this.animator = r1;
        return;
    L5:
        r2 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: startAnimator$lambda-9$lambda-8, reason: not valid java name */
    private static final void m721startAnimator$lambda9$lambda8(OProtocolTextEffectTextView r3, TextEffectSpec r4, ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$spec");
        Intrinsics.checkNotNullParameter(r5, "valueAnimator");
        r3.playTimeMs = (long) (r5.getAnimatedFraction() * r4.getDurationMs());
        TextEffectDebugLog r6 = TextEffectDebugLog.INSTANCE;
        String r7 = r3.getLogTag();
        if (TextEffectDebugLog.getEnabled() == true) goto L5;
    L7:
        r3.onEffectFrameUpdated(r3.activeEffectName, r3.playTimeMs, r4);
        r3.invalidate();
        return;
    L5:
        if (TextEffectDebugLog.getFrameEnabled() == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r7), "animator update spec=" + r4.getId() + ", playTime=" + r3.playTimeMs);
        goto L7
    }

    private final void finishEffect() {
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        String r1 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r1), "finishEffect effect=" + getActiveEffectName() + ", finalText=" + this.finalTextOnEnd);
    L5:
        CharSequence r2 = this.finalTextOnEnd;
        if (r2 == null) goto L9;
        setText(r2);
    L9:
        this.activeSpec = null;
        this.activeEffectName = "none";
        this.playTimeMs = 0;
        this.finalTextOnEnd = null;
        this.oldTextForEffect = null;
        this.newTextForEffect = null;
        this.oldTextCache = null;
        this.newTextCache = null;
        this.animator = null;
        onTextEffectFinished();
        invalidate();
    }

    static /* synthetic */ void stopAnimator$default(OProtocolTextEffectTextView r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.stopAnimator(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopAnimator");
    }

    private final void stopAnimator(boolean r4) {
        if (this.animator == null) goto L7;
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        String r1 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r1), Intrinsics.stringPlus("stopAnimator keepFrame=", Boolean.valueOf(r4)));
    L7:
        ValueAnimator r2 = this.animator;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.animator = null;
        if (r4 == true) goto L15;
        this.playTimeMs = 0;
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8721. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    protected void drawTextLayer(android.graphics.Canvas r39, com.obric.oui.texteffects.core.EffectLayer.Text r40, com.obric.oui.texteffects.runtime.LayerFrame r41) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: INVOKE (r15v0 ?? I:com.obric.oui.texteffects.render.TextLayoutCache) = 
              (r38v0 'this' ?? I:com.obric.oui.texteffects.OProtocolTextEffectTextView A[IMMUTABLE_TYPE, THIS])
              (r3v3 com.obric.oui.texteffects.core.TextSource)
             VIRTUAL call: com.obric.oui.texteffects.OProtocolTextEffectTextView.cacheForSource(com.obric.oui.texteffects.core.TextSource):com.obric.oui.texteffects.render.TextLayoutCache A[DECLARE_VAR, MD:(com.obric.oui.texteffects.core.TextSource):com.obric.oui.texteffects.render.TextLayoutCache (m)] in method: com.obric.oui.texteffects.OProtocolTextEffectTextView.drawTextLayer(android.graphics.Canvas, com.obric.oui.texteffects.core.EffectLayer$Text, com.obric.oui.texteffects.runtime.LayerFrame):void, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.oui.texteffects.OProtocolTextEffectTextView.drawTextLayer(android.graphics.Canvas, com.obric.oui.texteffects.core.EffectLayer$Text, com.obric.oui.texteffects.runtime.LayerFrame):void");
    }

    protected float layerInsetPx(float r2, float r3) {
        return Math.max(this.dp.invoke(Float.valueOf(getMaxBlurRadiusDp())).floatValue(), r3) + Math.abs(r2);
    }

    protected void drawScanLayer(Canvas r16, Paint r17, TextLayoutCache r18, float r19, float r20, float r21, float r22, SelectorSpec.ScanWindow r23, BlendMode r24, Xfermode r25) {
        Intrinsics.checkNotNullParameter(r16, "canvas");
        Intrinsics.checkNotNullParameter(r17, "paint");
        Intrinsics.checkNotNullParameter(r18, "cache");
        Intrinsics.checkNotNullParameter(r23, "selector");
        float r9 = r21 + (r18.getBaseTotalWidth() * r22);
        float r1 = RangesKt.coerceAtLeast(r18.getBaseTotalWidth() * r23.getFeatherRatio(), this.dp.invoke(Float.valueOf(r23.getMinFeatherDp())).floatValue());
        TextEffectDebugLog r7 = TextEffectDebugLog.INSTANCE;
        String r8 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == true) goto L5;
    L7:
        CanvasTextLayerRenderer r0 = CanvasTextLayerRenderer.INSTANCE;
        Paint r10 = CanvasTextLayerRenderer.INSTANCE.buildLayerPaintForCurrentBlend(r17);
        float r11 = getBaseline();
        float r12 = r9 + r1;
        float r13 = getHeight();
        if (r23.getGradientAlphaDirection() == Direction.RightToLeft) goto L10;
        boolean r2 = true;
    L11:
        r0.drawScanGradientAlphaText(r16, r19, r20, r10, r17, r18, r21, r11, r9, r12, r13, r2, r24, r25);
        return;
    L10:
        r2 = false;
        goto L11
    L5:
        if (TextEffectDebugLog.getFrameEnabled() == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r8), "drawScanLayer progress=" + r22 + ", scanX=" + r9 + ", featherWidth=" + r1 + ", direction=" + r23.getDirection());
        goto L7
    }

    protected void applyFillToPaint(Paint r2, FillSpec r3, TextLayoutCache r4) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r3, "fill");
        Intrinsics.checkNotNullParameter(r4, "cache");
        if (Intrinsics.areEqual(r3, FillSpec.TextColor.INSTANCE) == false) goto L6;
        r2.setShader(null);
        r2.setColor(getCurrentTextColor());
        return;
    L6:
        if ((r3 instanceof FillSpec.LinearGradient) == false) goto L10;
        r2.setShader(buildGradientShader(r4, (FillSpec.LinearGradient) r3));
        return;
    }

    protected void applyBlendToPaint(Paint r2, BlendSpec r3) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r3, "blend");
        if (r3 != BlendSpec.SRC_OVER) goto L6;
        r2.setBlendMode(null);
        return;
    L6:
        r2.setBlendMode(toAndroidBlendMode(r3));
    }

    protected final EffectLayer.Text findTextLayer(TextEffectSpec r4, LayerFrame r5) {
        Intrinsics.checkNotNullParameter(r4, "spec");
        Intrinsics.checkNotNullParameter(r5, "frame");
        Iterator<T> r3 = r4.getStages().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r6 = r3.next();
        if (Intrinsics.areEqual(((EffectStage) r6).getId(), r5.getStageId()) == false) goto L4;
    L9:
        EffectStage r7 = (EffectStage) r6;
        if (r7 != null) goto L12;
        return null;
    L12:
        Iterator<T> r8 = r7.getLayers().iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((EffectLayer) r9).getId(), r5.getLayerId()) == false) goto L14;
    L20:
        if ((r9 instanceof EffectLayer.Text) == true) goto L22;
        return null;
    L22:
        return (EffectLayer.Text) r9;
    L18:
        r9 = null;
        goto L20
    L8:
        r6 = null;
        goto L9
    }

    protected final TextLayoutCache cacheForSource(TextSource r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        TextLayoutCache r4 = null;
        if (r7 != 1) goto L5;
        CharSequence r8 = getText();
        if (r8 != null) goto L43;
    L43:
        TextLayoutCache r0 = this.currentTextCache;
        if (r0 != null) goto L47;
    L49:
        if (r4 != null) goto L53;
        r4 = buildTextCache(r8);
        this.currentTextCache = r4;
        TextEffectDebugLog r1 = TextEffectDebugLog.INSTANCE;
        String r5 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L53;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r5), "build current text cache, text=" + r8 + ", width=" + r4.getBaseTotalWidth());
    L53:
        return r4;
    L47:
        if (isTextCacheReusable(r0, r8) == false) goto L49;
        r4 = r0;
        goto L49
    L5:
        if (r7 != 2) goto L7;
        CharSequence r9 = this.oldTextForEffect;
        if (r9 != null) goto L28;
        r9 = getText();
    L28:
        if (r9 != null) goto L30;
    L30:
        TextLayoutCache r2 = this.oldTextCache;
        if (r2 != null) goto L34;
    L36:
        if (r4 != null) goto L53;
        r4 = buildTextCache(r9);
        this.oldTextCache = r4;
        TextEffectDebugLog r3 = TextEffectDebugLog.INSTANCE;
        String r10 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L53;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r10), "build old text cache, text=" + r9 + ", width=" + r4.getBaseTotalWidth());
        goto L53
    L34:
        if (isTextCacheReusable(r2, r9) == false) goto L36;
        r4 = r2;
        goto L36
    L7:
        if (r7 != 3) goto L24;
        CharSequence r11 = this.newTextForEffect;
        if (r11 != null) goto L11;
        r11 = getText();
    L11:
        if (r11 != null) goto L13;
    L13:
        TextLayoutCache r12 = this.newTextCache;
        if (r12 != null) goto L17;
    L19:
        if (r4 != null) goto L53;
        r4 = buildTextCache(r11);
        this.newTextCache = r4;
        TextEffectDebugLog r13 = TextEffectDebugLog.INSTANCE;
        String r14 = getLogTag();
        if (TextEffectDebugLog.getEnabled() == false) goto L53;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", r14), "build new text cache, text=" + r11 + ", width=" + r4.getBaseTotalWidth());
        goto L53
    L17:
        if (isTextCacheReusable(r12, r11) == false) goto L19;
        r4 = r12;
        goto L19
    L24:
        throw new NoWhenBranchMatchedException();
    }

    protected TextLayoutCache buildTextCache(CharSequence r9) {
        Intrinsics.checkNotNullParameter(r9, "text");
        TextLayoutCacheBuilder r1 = TextLayoutCacheBuilder.INSTANCE;
        TextPaint r3 = getPaint();
        Intrinsics.checkNotNullExpressionValue(r3, "paint");
        return r1.build(r9, r3, computeContentWidth(), getEllipsize(), new AnonymousClass1(this), AnonymousClass2.INSTANCE);
    }

    protected final boolean isTextCacheReusable(TextLayoutCache r4, CharSequence r5) {
        Intrinsics.checkNotNullParameter(r4, "cache");
        Intrinsics.checkNotNullParameter(r5, "text");
        if (Intrinsics.areEqual(r4.getText(), r5) == true) goto L5;
        return false;
    L5:
        if (r4.getContentWidth() != computeContentWidth()) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L10;
        return false;
    L10:
        if (r4.getEllipsize() == getEllipsize()) goto L12;
        return false;
    L12:
        if (r4.getTextSizePx() != getPaint().getTextSize()) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L17;
        return false;
    L17:
        return true;
    L14:
        r3 = false;
        goto L15
    L7:
        r6 = false;
        goto L8
    }

    protected float computeStartX(float r4) {
        float r0 = computeContentWidth();
        int r1 = getGravity() & 7;
        float r3 = getCompoundPaddingLeft();
        if (r1 != 1) goto L5;
        float r2 = (r0 - r4) / 2.0f;
    L12:
        return r3 + r2;
    L5:
        if (r1 != 5) goto L7;
    L9:
        r2 = r0 - r4;
        goto L12
    L7:
        if (r1 == 8388613) goto L9;
        return r3;
    }

    protected final float computeContentWidth() {
        return RangesKt.coerceAtLeast((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), 0.0f);
    }

    protected LinearGradient buildGradientShader(TextLayoutCache r9, FillSpec.LinearGradient r10) {
        Intrinsics.checkNotNullParameter(r9, "cache");
        Intrinsics.checkNotNullParameter(r10, "fill");
        if (r9.getBaseTotalWidth() > 0.01f) goto L6;
        return null;
    L6:
        float r1 = r9.getBaseStartX();
        return new LinearGradient(r1, 0.0f, r1 + r9.getBaseTotalWidth(), 0.0f, r10.getColors(), r10.getPositions(), Shader.TileMode.CLAMP);
    }

    protected final BlurMaskFilter getBlurMaskFilter(float r1) {
        return getBlurFilterCache().get(r1);
    }

    protected final void clearTextCaches() {
        this.currentTextCache = null;
        this.oldTextCache = null;
        this.newTextCache = null;
    }

    protected final long scaledDurationMs(long r1) {
        return RangesKt.coerceAtLeast(MathKt.roundToInt(r1 * this.debugAnimationDurationScale), 1);
    }

    protected final float dimensionPropertyPx(LayerFrame r2, EffectValue r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r3 instanceof EffectValue.DimensionDp) == false) goto L6;
        return this.dp.invoke(Float.valueOf(((EffectValue.DimensionDp) r3).getValue())).floatValue();
    L6:
        if ((r3 instanceof EffectValue.FloatValue) == false) goto L9;
        return ((EffectValue.FloatValue) r3).getValue();
    L9:
        return this.dp.invoke(Float.valueOf(r4)).floatValue();
    }

    protected void drawCompoundDrawables(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Drawable[] r0 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r0, "compoundDrawables");
        int r1 = getCompoundPaddingLeft();
        int r2 = getCompoundPaddingTop();
        int r3 = getWidth() - getCompoundPaddingRight();
        int r4 = getHeight() - getCompoundPaddingBottom();
        int r5 = RangesKt.coerceAtLeast(r3 - r1, 0);
        int r6 = RangesKt.coerceAtLeast(r4 - r2, 0);
        Drawable r7 = r0[0];
        if (r7 == null) goto L6;
        drawAt(r7, r10, getPaddingLeft(), ((r6 - drawableHeight(r7)) / 2) + r2);
    L6:
        Drawable r8 = r0[1];
        if (r8 == null) goto L10;
        drawAt(r8, r10, ((r5 - drawableWidth(r8)) / 2) + r1, getPaddingTop());
    L10:
        Drawable r9 = r0[2];
        if (r9 == null) goto L14;
        drawAt(r9, r10, (getWidth() - getPaddingRight()) - drawableWidth(r9), r2 + ((r6 - drawableHeight(r9)) / 2));
    L14:
        Drawable r11 = r0[3];
        if (r11 == null) goto L19;
        drawAt(r11, r10, r1 + ((r5 - drawableWidth(r11)) / 2), (getHeight() - getPaddingBottom()) - drawableHeight(r11));
        return;
    }

    private final void drawAt(Drawable r1, Canvas r2, int r3, int r4) {
        int r0 = r2.save();
        r2.translate(r3, r4);     // Catch: Throwable -> L6
        r1.draw(r2);     // Catch: Throwable -> L6
        r2.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r2.restoreToCount(r0);
        throw th;
    }

    private final int drawableWidth(Drawable r3) {
        Integer r2 = Integer.valueOf(r3.getBounds().width());
        if (r2.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L12;
        return RangesKt.coerceAtLeast(r3.getIntrinsicWidth(), 0);
    L12:
        return r2.intValue();
    L5:
        r0 = false;
        goto L6
    }

    private final int drawableHeight(Drawable r3) {
        Integer r2 = Integer.valueOf(r3.getBounds().height());
        if (r2.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L12;
        return RangesKt.coerceAtLeast(r3.getIntrinsicHeight(), 0);
    L12:
        return r2.intValue();
    L5:
        r0 = false;
        goto L6
    }

    private final BlendMode toAndroidBlendMode(BlendSpec r1) {
        switch(WhenMappings.$EnumSwitchMapping$1[r1.ordinal()]) {
            case 1: goto L35;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L55;
            case 11: goto L54;
            case 12: goto L53;
            case 13: goto L52;
            case 14: goto L51;
            case 15: goto L50;
            case 16: goto L49;
            case 17: goto L48;
            case 18: goto L47;
            case 19: goto L46;
            case 20: goto L45;
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            case 25: goto L40;
            case 26: goto L39;
            case 27: goto L38;
            case 28: goto L37;
            case 29: goto L36;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L36:
        return BlendMode.LUMINOSITY;
    L37:
        return BlendMode.COLOR;
    L38:
        return BlendMode.SATURATION;
    L39:
        return BlendMode.HUE;
    L40:
        return BlendMode.MULTIPLY;
    L41:
        return BlendMode.EXCLUSION;
    L42:
        return BlendMode.DIFFERENCE;
    L43:
        return BlendMode.SOFT_LIGHT;
    L44:
        return BlendMode.HARD_LIGHT;
    L45:
        return BlendMode.COLOR_BURN;
    L46:
        return BlendMode.COLOR_DODGE;
    L47:
        return BlendMode.LIGHTEN;
    L48:
        return BlendMode.DARKEN;
    L49:
        return BlendMode.OVERLAY;
    L50:
        return BlendMode.SCREEN;
    L51:
        return BlendMode.MODULATE;
    L52:
        return BlendMode.PLUS;
    L53:
        return BlendMode.XOR;
    L54:
        return BlendMode.DST_ATOP;
    L55:
        return BlendMode.SRC_ATOP;
    L56:
        return BlendMode.DST_OUT;
    L57:
        return BlendMode.SRC_OUT;
    L58:
        return BlendMode.DST_IN;
    L59:
        return BlendMode.SRC_IN;
    L60:
        return BlendMode.DST_OVER;
    L61:
        return BlendMode.SRC_OVER;
    L62:
        return BlendMode.DST;
    L63:
        return BlendMode.SRC;
    L35:
        return BlendMode.CLEAR;
    }

    private final PorterDuff.Mode toPorterDuffMode(BlendSpec r1) {
        switch(WhenMappings.$EnumSwitchMapping$1[r1.ordinal()]) {
            case 1: goto L24;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L25;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L29;
            case 17: goto L28;
            case 18: goto L27;
            case 19: goto L25;
            case 20: goto L25;
            case 21: goto L25;
            case 22: goto L25;
            case 23: goto L25;
            case 24: goto L25;
            case 25: goto L26;
            case 26: goto L25;
            case 27: goto L25;
            case 28: goto L25;
            case 29: goto L25;
            default: goto L5;
        };
    L25:
        return null;
    L5:
        throw new NoWhenBranchMatchedException();
    L26:
        return PorterDuff.Mode.MULTIPLY;
    L27:
        return PorterDuff.Mode.LIGHTEN;
    L28:
        return PorterDuff.Mode.DARKEN;
    L29:
        return PorterDuff.Mode.OVERLAY;
    L30:
        return PorterDuff.Mode.SCREEN;
    L31:
        return PorterDuff.Mode.MULTIPLY;
    L32:
        return PorterDuff.Mode.ADD;
    L33:
        return PorterDuff.Mode.XOR;
    L34:
        return PorterDuff.Mode.DST_ATOP;
    L35:
        return PorterDuff.Mode.SRC_ATOP;
    L36:
        return PorterDuff.Mode.DST_OUT;
    L37:
        return PorterDuff.Mode.SRC_OUT;
    L38:
        return PorterDuff.Mode.DST_IN;
    L39:
        return PorterDuff.Mode.SRC_IN;
    L40:
        return PorterDuff.Mode.DST_OVER;
    L41:
        return PorterDuff.Mode.DST;
    L42:
        return PorterDuff.Mode.SRC;
    L24:
        return PorterDuff.Mode.CLEAR;
    }
}

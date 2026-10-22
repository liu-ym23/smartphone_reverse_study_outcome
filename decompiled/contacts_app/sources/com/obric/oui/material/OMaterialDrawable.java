package com.obric.oui.material;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oui.R;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.shadow.ShadowConfig;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: OMaterialDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b+\b\u0017\u0018\u0000 \u0097\u00012\u00020\u0001:\u0004\u0097\u0001\u0098\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020<H\u0002J\u0010\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020\u0001H\u0003J\u0010\u0010T\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010U\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0003J\u0006\u0010V\u001a\u00020NJ\n\u0010W\u001a\u0004\u0018\u00010XH\u0016J.\u0010Y\u001a\u00020N2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\f\u0010`\u001a\b\u0018\u00010aR\u00020[H\u0016J\u0010\u0010b\u001a\u00020!2\u0006\u0010c\u001a\u00020>H\u0002J\b\u0010d\u001a\u00020!H\u0016J\b\u0010e\u001a\u00020NH\u0016J\u0010\u0010f\u001a\u00020N2\u0006\u0010Z\u001a\u00020gH\u0014J\u0010\u0010h\u001a\u00020!2\u0006\u0010i\u001a\u000200H\u0014J0\u0010j\u001a\u00020!2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u00102\u0006\u0010i\u001a\u0002002\u0006\u0010p\u001a\u000202H\u0002J\u0010\u0010q\u001a\u00020!2\u0006\u0010i\u001a\u000200H\u0002J\u000e\u0010r\u001a\u00020N2\u0006\u0010s\u001a\u00020!J.\u0010t\u001a\u00020N2\u0006\u0010u\u001a\u0002022\b\b\u0002\u0010v\u001a\u00020\u00102\b\b\u0002\u0010w\u001a\u00020\u00102\b\b\u0002\u0010x\u001a\u00020!H\u0007J;\u0010y\u001a\u00020N2\u000e\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u00132\b\b\u0002\u0010v\u001a\u00020\u00102\b\b\u0002\u0010w\u001a\u00020\u00102\b\b\u0002\u0010x\u001a\u00020!H\u0007¢\u0006\u0002\u0010zJ \u0010{\u001a\u00020N2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u00102\u0006\u0010p\u001a\u000202H\u0002J\u001b\u0010|\u001a\u00020N2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u0013¢\u0006\u0002\u0010}J\u0010\u0010~\u001a\u00020N2\b\u0010C\u001a\u0004\u0018\u00010DJE\u0010~\u001a\u00020N2\u0006\u0010\u007f\u001a\u00020\u00102\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0010J\u0011\u0010\u0085\u0001\u001a\u00020!2\u0006\u0010i\u001a\u000200H\u0016J\u001a\u0010\u0086\u0001\u001a\u00020N2\u0007\u0010\u0087\u0001\u001a\u00020\u00102\b\u0010F\u001a\u0004\u0018\u00010DJO\u0010\u0086\u0001\u001a\u00020N2\u0007\u0010\u0087\u0001\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u00102\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0010JJ\u0010\u0088\u0001\u001a\u00020!2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020!2\u000f\u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\u000f\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0002¢\u0006\u0003\u0010\u008c\u0001JJ\u0010\u008d\u0001\u001a\u00020!2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020!2\u000f\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\u000f\u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0002¢\u0006\u0003\u0010\u008c\u0001J\u001b\u0010\u0090\u0001\u001a\u00020N2\u0007\u0010\u0091\u0001\u001a\u00020\u00102\u0007\u0010\u0092\u0001\u001a\u00020!H\u0002J\u001b\u0010\u0093\u0001\u001a\u00020N2\u0007\u0010\u0091\u0001\u001a\u00020\u00102\u0007\u0010\u0092\u0001\u001a\u00020!H\u0002J@\u0010\u0094\u0001\u001a\u00020!2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020!2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001c2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001cH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u001e\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u001e\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u001e\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020!0\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u00107\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u000e\u0010@\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "()V", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animInterpolator", "Landroid/view/animation/LinearInterpolator;", "getAnimInterpolator", "()Landroid/view/animation/LinearInterpolator;", "setAnimInterpolator", "(Landroid/view/animation/LinearInterpolator;)V", "animatedSolidColor", "", "animatedStrokeColor", "blendAnimatorArray", "", "Landroid/animation/ValueAnimator;", "[Landroid/animation/ValueAnimator;", "colorAnimator", "currentBlendConfigsArray", "Lcom/obric/oui/color/BlendConfig;", "[[Lcom/obric/oui/color/BlendConfig;", "currentOverlayBlendConfigsArray", "currentStrokeConfigArray", "Lcom/obric/oui/color/StrokeConfig;", "[Lcom/obric/oui/color/StrokeConfig;", "drawBlendConfigsArray", "drawOverlayBlendConfigsArray", "enableShadow", "", "enableStateChangeTransition", "getEnableStateChangeTransition", "()Z", "setEnableStateChangeTransition", "(Z)V", "envMaterialApiVersion", "getEnvMaterialApiVersion", "()I", "isCallbackInitArray", "()[Ljava/lang/Boolean;", "setCallbackInitArray", "([Ljava/lang/Boolean;)V", "[Ljava/lang/Boolean;", "lastStateSet", "", "materialConfigs", "Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "materialDrawMode", "materialSrcType", "overlayBlendAnimatorArray", "requireApiVersion", "getRequireApiVersion", "setRequireApiVersion", "(I)V", "shadowClipPath", "Landroid/graphics/Path;", "shadowConfigs", "Lcom/obric/oui/shadow/ShadowConfig;", "[Lcom/obric/oui/shadow/ShadowConfig;", "shadowDrawPath", "shadowPaint", "Landroid/graphics/Paint;", "solidColors", "Landroid/content/res/ColorStateList;", "strokeAnimator", "strokeColors", "strokeWidth", "targetSolidColor", "targetStrokeColor", "tmpRectF", "Landroid/graphics/RectF;", "tmpShadowRectF", "clipOutShadowPath", "", "canvas", "Landroid/graphics/Canvas;", "path", "copyGradientInternalStateFrom", "template", "draw", "drawMultiLayerShadow", "endAnimation", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "inflate", "r", "Landroid/content/res/Resources;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "attrs", "Landroid/util/AttributeSet;", "theme", "Landroid/content/res/Resources$Theme;", "isShadowValid", "config", "isStateful", "jumpToCurrentState", "onBoundsChange", "Landroid/graphics/Rect;", "onStateChange", "stateSet", "processMaterialOnStateChange", "view", "Landroid/view/View;", "effectParams", "", "index", "material", "processSolidAndStrokeOnStateChange", "setEnableShadow", "enable", "setMaterialConfig", "materialConfig", "srcType", "drawMode", "applyImmediately", "setMaterialConfigs", "([Lcom/obric/oui/material/MaterialConfig;IIZ)V", "setMaterialToEffectObjectIfNotInit", "setShadowConfigs", "([Lcom/obric/oui/shadow/ShadowConfig;)V", "setSolidColors", "normal", "pressed", "selected", MaterialConfigFormatNames.CHECKED, MaterialConfigFormatNames.HOVER, "disabled", "setState", "setStrokeConfigs", MaterialConfigFormatNames.WIDTH, "updateBlendConfigs", "enableAnimate", "fromBlendConfigs", "toBlendConfigs", "(Ljava/lang/Object;IZ[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;)Z", "updateOverlayBlendConfigs", "fromOverlayBlendConfigs", "toOverlayBlendConfigs", "updateSolidColor", "toColor", "animate", "updateStrokeColor", "updateStrokeConfig", "fromStrokeConfig", "toStrokeConfig", "Companion", "OMaterialDrawableState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OMaterialDrawable extends GradientDrawable {
    public static final Companion Companion = null;
    public static final boolean DEBUGGABLE = false;
    private static final int MAX_MATERIAL_CONFIG_COUNT = 2;
    public static final String TAG = "OMaterialDrawable";
    private long animDuration;
    private LinearInterpolator animInterpolator;
    private int animatedSolidColor;
    private int animatedStrokeColor;
    private ValueAnimator[] blendAnimatorArray;
    private ValueAnimator colorAnimator;
    private BlendConfig[][] currentBlendConfigsArray;
    private BlendConfig[][] currentOverlayBlendConfigsArray;
    private StrokeConfig[] currentStrokeConfigArray;
    private BlendConfig[][] drawBlendConfigsArray;
    private BlendConfig[][] drawOverlayBlendConfigsArray;
    private boolean enableShadow;
    private boolean enableStateChangeTransition;
    private final int envMaterialApiVersion;
    private Boolean[] isCallbackInitArray;
    private int[] lastStateSet;
    private MaterialConfig[] materialConfigs;
    private int materialDrawMode;
    private int materialSrcType;
    private ValueAnimator[] overlayBlendAnimatorArray;
    private int requireApiVersion;
    private final Path shadowClipPath;
    private ShadowConfig[] shadowConfigs;
    private final Path shadowDrawPath;
    private final Paint shadowPaint;
    private ColorStateList solidColors;
    private ValueAnimator strokeAnimator;
    private ColorStateList strokeColors;
    private int strokeWidth;
    private int targetSolidColor;
    private int targetStrokeColor;
    private final RectF tmpRectF;
    private final RectF tmpShadowRectF;

    /* JADX INFO: compiled from: OMaterialDrawable.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable$Companion;", "", "()V", "DEBUGGABLE", "", "MAX_MATERIAL_CONFIG_COUNT", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OMaterialDrawable.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0002\u0010\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J \u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001dH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable$OMaterialDrawableState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "baseState", "changingConfigurations", "", "enableShadow", "", "solidColors", "Landroid/content/res/ColorStateList;", "strokeWidth", "strokeColors", "animDuration", "", "enableBlendTransition", "materialConfigs", "", "Lcom/obric/oui/material/MaterialConfig;", "materialSrcType", "materialDrawMode", "shadowConfigs", "Lcom/obric/oui/shadow/ShadowConfig;", "requireApiVersion", "(Landroid/graphics/drawable/Drawable$ConstantState;IZLandroid/content/res/ColorStateList;ILandroid/content/res/ColorStateList;JZ[Lcom/obric/oui/material/MaterialConfig;II[Lcom/obric/oui/shadow/ShadowConfig;I)V", "[Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/shadow/ShadowConfig;", "getChangingConfigurations", "newDrawable", "Landroid/graphics/drawable/Drawable;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class OMaterialDrawableState extends Drawable.ConstantState {
        private final long animDuration;
        private final Drawable.ConstantState baseState;
        private final int changingConfigurations;
        private final boolean enableBlendTransition;
        private final boolean enableShadow;
        private final MaterialConfig[] materialConfigs;
        private final int materialDrawMode;
        private final int materialSrcType;
        private final int requireApiVersion;
        private final ShadowConfig[] shadowConfigs;
        private final ColorStateList solidColors;
        private final ColorStateList strokeColors;
        private final int strokeWidth;

        public OMaterialDrawableState(Drawable.ConstantState r1, int r2, boolean r3, ColorStateList r4, int r5, ColorStateList r6, long r7, boolean r9, MaterialConfig[] r10, int r11, int r12, ShadowConfig[] r13, int r14) {
            this.baseState = r1;
            this.changingConfigurations = r2;
            this.enableShadow = r3;
            this.solidColors = r4;
            this.strokeWidth = r5;
            this.strokeColors = r6;
            this.animDuration = r7;
            this.enableBlendTransition = r9;
            this.materialConfigs = r10;
            this.materialSrcType = r11;
            this.materialDrawMode = r12;
            this.shadowConfigs = r13;
            this.requireApiVersion = r14;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.changingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            return newDrawable(r2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r4, Resources.Theme r5) {
            GradientDrawable r0 = null;
            Drawable.ConstantState r1 = this.baseState;     // Catch: Exception -> L12
            if (r1 == null) goto L13;
            if (r5 == null) goto L8;
            Drawable r6 = r1.newDrawable(r4, r5);     // Catch: Exception -> L12
        L14:
            OMaterialDrawable r7 = new OMaterialDrawable();
            if ((r6 instanceof GradientDrawable) == false) goto L17;
            r0 = (GradientDrawable) r6;
        L17:
            if (r0 == null) goto L20;
            OMaterialDrawable.access$copyGradientInternalStateFrom(r7, r0);
        L20:
            OMaterialDrawable.access$setEnableShadow$p(r7, this.enableShadow);
            r7.setAnimDuration(this.animDuration);
            r7.setEnableStateChangeTransition(this.enableBlendTransition);
            r7.setMaterialConfigs(this.materialConfigs, this.materialSrcType, this.materialDrawMode, false);
            r7.setShadowConfigs(this.shadowConfigs);
            r7.setSolidColors(this.solidColors);
            r7.setStrokeConfigs(this.strokeWidth, this.strokeColors);
            r7.setCallbackInitArray(new Boolean[]{false, false});
            r7.setRequireApiVersion(this.requireApiVersion);
            return r7;
        L12:
            Drawable r8 = (Drawable) null;
            goto L13
        L8:
            if (r4 == null) goto L10;
            r6 = r1.newDrawable(r4);     // Catch: Exception -> L12
            goto L14
        L10:
            r6 = r1.newDrawable();     // Catch: Exception -> L12
        L13:
            r6 = null;
            goto L14
        L24:
            Drawable r9 = (Drawable) null;
            goto L13
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$4-Ybn20D67Dr65IVuyS1PpzFrh4, reason: not valid java name */
    public static /* synthetic */ void m555$r8$lambda$4Ybn20D67Dr65IVuyS1PpzFrh4(StrokeConfig r0, StrokeConfig r1, OMaterialDrawable r2, View r3, ValueAnimator r4) {
        m560updateStrokeConfig$lambda29$lambda28(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$7upl_sPPQIRV_g4eN_2QmZYUyEI(BlendConfig[] r0, BlendConfig[] r1, OMaterialDrawable r2, int r3, Object r4, ValueAnimator r5) {
        m556updateBlendConfigs$lambda24$lambda23(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$O6lt34leU5u5jdOU_1o6e8VgJRk(OMaterialDrawable r0, ValueAnimator r1) {
        m558updateSolidColor$lambda31$lambda30(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$V8bbA6Zs_Lp9pPGPhL342cQiYIQ(BlendConfig[] r0, BlendConfig[] r1, Object r2, OMaterialDrawable r3, int r4, ValueAnimator r5) {
        m557updateOverlayBlendConfigs$lambda26$lambda25(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$echdJX86GtaGHTVn5LGD1ta9yTg(OMaterialDrawable r0, ValueAnimator r1) {
        m559updateStrokeColor$lambda33$lambda32(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public final void setMaterialConfig(MaterialConfig r9) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, 0, 0, false, 14, null);
    }

    public final void setMaterialConfig(MaterialConfig r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, r10, 0, false, 12, null);
    }

    public final void setMaterialConfig(MaterialConfig r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, r10, r11, false, 8, null);
    }

    public final void setMaterialConfigs(MaterialConfig[] r8) {
        setMaterialConfigs$default(this, r8, 0, 0, false, 14, null);
    }

    public final void setMaterialConfigs(MaterialConfig[] r8, int r9) {
        setMaterialConfigs$default(this, r8, r9, 0, false, 12, null);
    }

    public final void setMaterialConfigs(MaterialConfig[] r8, int r9, int r10) {
        setMaterialConfigs$default(this, r8, r9, r10, false, 8, null);
    }

    public static final /* synthetic */ void access$copyGradientInternalStateFrom(OMaterialDrawable r0, GradientDrawable r1) {
        r0.copyGradientInternalStateFrom(r1);
    }

    public static final /* synthetic */ void access$setEnableShadow$p(OMaterialDrawable r0, boolean r1) {
        r0.enableShadow = r1;
    }

    public OMaterialDrawable() {
        this.animDuration = Token.Duration.OUI_ANIMATION_DURATION_SHORT_3.getDuration();
        this.animInterpolator = new LinearInterpolator();
        this.materialSrcType = 2;
        this.materialDrawMode = 1;
        Paint r2 = new Paint(1);
        r2.setStyle(Paint.Style.FILL);
        this.shadowPaint = r2;
        this.shadowClipPath = new Path();
        this.shadowDrawPath = new Path();
        this.tmpRectF = new RectF();
        this.tmpShadowRectF = new RectF();
        this.isCallbackInitArray = new Boolean[]{false, false};
        this.requireApiVersion = 1;
        this.envMaterialApiVersion = OMaterialHelper.getMaterialApiVersion();
        this.currentBlendConfigsArray = new BlendConfig[2][];
        this.drawBlendConfigsArray = new BlendConfig[2][];
        this.currentOverlayBlendConfigsArray = new BlendConfig[2][];
        this.drawOverlayBlendConfigsArray = new BlendConfig[2][];
        this.currentStrokeConfigArray = new StrokeConfig[2];
        this.blendAnimatorArray = new ValueAnimator[2];
        this.overlayBlendAnimatorArray = new ValueAnimator[2];
        this.enableStateChangeTransition = true;
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    public final void setAnimDuration(long r1) {
        this.animDuration = r1;
    }

    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    public final void setAnimInterpolator(LinearInterpolator r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.animInterpolator = r2;
    }

    public final Boolean[] isCallbackInitArray() {
        return this.isCallbackInitArray;
    }

    public final void setCallbackInitArray(Boolean[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isCallbackInitArray = r2;
    }

    public final int getRequireApiVersion() {
        return this.requireApiVersion;
    }

    public final void setRequireApiVersion(int r1) {
        this.requireApiVersion = r1;
    }

    public final int getEnvMaterialApiVersion() {
        return this.envMaterialApiVersion;
    }

    public final boolean getEnableStateChangeTransition() {
        return this.enableStateChangeTransition;
    }

    public final void setEnableStateChangeTransition(boolean r1) {
        this.enableStateChangeTransition = r1;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return new OMaterialDrawableState(super.getConstantState(), getChangingConfigurations(), this.enableShadow, this.solidColors, this.strokeWidth, this.strokeColors, this.animDuration, this.enableStateChangeTransition, this.materialConfigs, this.materialSrcType, this.materialDrawMode, this.shadowConfigs, this.requireApiVersion);
    }

    private final void copyGradientInternalStateFrom(GradientDrawable r3) {
        Field r0 = GradientDrawable.class.getDeclaredField("mGradientState");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.set(this, r0.get(r3));     // Catch: Exception -> L4
        return;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources r17, XmlPullParser r18, AttributeSet r19, Resources.Theme r20) {
        Intrinsics.checkNotNullParameter(r17, "r");
        Intrinsics.checkNotNullParameter(r18, "parser");
        Intrinsics.checkNotNullParameter(r19, "attrs");
        if (r20 != null) goto L5;
        TypedArray r7 = null;
    L6:
        if (r7 != null) goto L57;
        r7 = r17.obtainAttributes(r19, R.styleable.OMaterialDrawable);
    L57:
        boolean r9 = true;
        this.requireApiVersion = r7.getInt(R.styleable.OMaterialDrawable_oui_widgetMaterialApiVersion, 1);     // Catch: Throwable -> L54
        ColorStateList r8 = r7.getColorStateList(R.styleable.OMaterialDrawable_oui_solidColor);     // Catch: Throwable -> L54
        ColorStateList r10 = r7.getColorStateList(R.styleable.OMaterialDrawable_oui_strokeColor);     // Catch: Throwable -> L54
        int r11 = r7.getDimensionPixelSize(R.styleable.OMaterialDrawable_oui_strokeWidth, -1);     // Catch: Throwable -> L54
        this.enableShadow = r7.getBoolean(R.styleable.OMaterialDrawable_oui_widgetEnableShadow, false);     // Catch: Throwable -> L54
        String r12 = r7.getString(R.styleable.OMaterialDrawable_oui_widgetMaterial);     // Catch: Throwable -> L54
        int r13 = r7.getInt(R.styleable.OMaterialDrawable_oui_widgetMaterialSrcType, 2);     // Catch: Throwable -> L54
        int r14 = r7.getInt(R.styleable.OMaterialDrawable_oui_widgetMaterialDrawMode, 1);     // Catch: Throwable -> L54
        String r15 = r12;     // Catch: Throwable -> L54
        if (r15 != null) goto L11;
    L14:
        boolean r16 = true;
    L15:
        if (r16 == false) goto L17;
        this.materialSrcType = r13;     // Catch: Throwable -> L54
        this.materialDrawMode = r14;     // Catch: Throwable -> L54
    L42:
        r7.recycle();
        super.inflate(r17, r18, r19, r20);
        if (r8 != null) goto L45;
        r8 = getColor();
    L45:
        if (r8 != null) goto L47;
        r8 = ColorStateList.valueOf(0);
    L47:
        setSolidColors(r8);
        if (r10 != null) goto L50;
        r10 = ColorStateList.valueOf(0);
    L50:
        this.strokeColors = r10;
        if (r11 < 0) goto L58;
        setStrokeConfigs(r11, r10);
        return;
    L58:
        return;
    L17:
        if ((r17.getConfiguration().uiMode & 48) != 32) goto L20;
        r9 = false;
    L20:
        MaterialConfig[] r4 = MaterialToken.parseSet(r12, r9);     // Catch: Throwable -> L54
        if (r4 == null) goto L23;
        setMaterialConfigs(r4, r13, r14, false);     // Catch: Throwable -> L54
    L32:
        if (r8 != null) goto L42;
        MaterialConfig[] r5 = this.materialConfigs;     // Catch: Throwable -> L54
        if (r5 != null) goto L36;
    L35:
        ColorStateList r6 = null;
    L40:
        r8 = r6;
        goto L42
    L36:
        MaterialConfig r21 = (MaterialConfig) ArraysKt.firstOrNull(r5);     // Catch: Throwable -> L54
        if (r21 == null) goto L35;
        r6 = r21.getFallbackBgColor();     // Catch: Throwable -> L54
        goto L40
    L23:
        MaterialConfig r22 = MaterialToken.parse(r12, r9);     // Catch: Throwable -> L54
        if (r22 != null) goto L29;
        Function1<Boolean, MaterialConfig> r23 = MaterialToken.parse(r12);     // Catch: Throwable -> L54
        if (r23 != null) goto L28;
        r22 = null;
        goto L29
    L28:
        r22 = r23.invoke(Boolean.valueOf(r9));     // Catch: Throwable -> L54
    L29:
        if (r22 == null) goto L32;
        setMaterialConfig(r22, r13, r14, false);     // Catch: Throwable -> L54
        goto L32
    L11:
        if (StringsKt.isBlank(r15) == true) goto L14;
        r16 = false;
    L54:
        th = move-exception;
        r7.recycle();
        throw th;
    L5:
        r7 = r20.obtainStyledAttributes(r19, R.styleable.OMaterialDrawable, 0, 0);
        goto L6
    }

    public static /* synthetic */ void setSolidColors$default(OMaterialDrawable r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L26;
        if ((r14 & 2) == 0) goto L6;
        int r2 = r8;
    L8:
        if ((r14 & 4) == 0) goto L10;
        int r3 = r8;
    L12:
        if ((r14 & 8) == 0) goto L14;
        int r4 = r3;
    L16:
        if ((r14 & 16) == 0) goto L18;
        int r5 = r2;
    L20:
        if ((r14 & 32) == 0) goto L22;
        int r6 = r8;
    L23:
        r7.setSolidColors(r8, r2, r3, r4, r5, r6);
        return;
    L22:
        r6 = r13;
        goto L23
    L18:
        r5 = r12;
        goto L20
    L14:
        r4 = r11;
        goto L16
    L10:
        r3 = r10;
        goto L12
    L6:
        r2 = r9;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSolidColors");
    }

    public final void setSolidColors(int r17, int r18, int r19, int r20, int r21, int r22) {
        setSolidColors(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_checked}, new int[]{android.R.attr.state_hovered, android.R.attr.state_checked}, new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_hovered, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed, android.R.attr.state_activated}, new int[]{android.R.attr.state_hovered, android.R.attr.state_activated}, new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_hovered}, new int[]{android.R.attr.state_checked}, new int[]{android.R.attr.state_selected}, new int[]{-16842910}, new int[]{android.R.attr.state_enabled}}, new int[]{r20, r20, r19, r19, r19, r19, r18, r21, r19, r20, r22, r17}));
    }

    public final void setSolidColors(ColorStateList r3) {
        this.solidColors = r3;
        if (r3 == null) goto L11;
        int r4 = r3.getColorForState(getState(), r3.getDefaultColor());
        this.targetSolidColor = r4;
        this.animatedSolidColor = r4;
        ValueAnimator r5 = this.colorAnimator;
        if (r5 == null) goto L9;
        r5.cancel();
    L9:
        setColor(this.targetSolidColor);
        return;
    }

    public static /* synthetic */ void setStrokeConfigs$default(OMaterialDrawable r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
        if (r18 != null) goto L26;
        if ((r17 & 4) == 0) goto L6;
        int r4 = r11;
    L8:
        if ((r17 & 8) == 0) goto L10;
        int r5 = r11;
    L12:
        if ((r17 & 16) == 0) goto L14;
        int r6 = r5;
    L16:
        if ((r17 & 32) == 0) goto L18;
        int r7 = r4;
    L20:
        if ((r17 & 64) == 0) goto L22;
        int r8 = r11;
    L23:
        r9.setStrokeConfigs(r10, r11, r4, r5, r6, r7, r8);
        return;
    L22:
        r8 = r16;
        goto L23
    L18:
        r7 = r15;
        goto L20
    L14:
        r6 = r14;
        goto L16
    L10:
        r5 = r13;
        goto L12
    L6:
        r4 = r12;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStrokeConfigs");
    }

    public final void setStrokeConfigs(int r19, int r20, int r21, int r22, int r23, int r24, int r25) {
        this.strokeWidth = r19;
        ColorStateList r2 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_checked}, new int[]{android.R.attr.state_hovered, android.R.attr.state_checked}, new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_hovered, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed, android.R.attr.state_activated}, new int[]{android.R.attr.state_hovered, android.R.attr.state_activated}, new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_hovered}, new int[]{android.R.attr.state_checked}, new int[]{android.R.attr.state_selected}, new int[]{-16842910}, new int[]{android.R.attr.state_enabled}}, new int[]{r23, r23, r22, r22, r22, r22, r21, r24, r22, r23, r25, r20});
        this.strokeColors = r2;
        setStrokeConfigs(r19, r2);
    }

    public final void setStrokeConfigs(int r1, ColorStateList r2) {
        if (r2 == null) goto L10;
        int r3 = r2.getDefaultColor();
        this.targetStrokeColor = r3;
        this.animatedStrokeColor = r3;
        ValueAnimator r4 = this.strokeAnimator;
        if (r4 == null) goto L8;
        r4.cancel();
    L8:
        setStroke(r1, this.targetStrokeColor);
        return;
    }

    public final void setEnableShadow(boolean r1) {
        this.enableShadow = r1;
        invalidateSelf();
    }

    public final void setShadowConfigs(ShadowConfig[] r1) {
        this.shadowConfigs = r1;
        invalidateSelf();
    }

    private final void drawMultiLayerShadow(Canvas r17) {
        ShadowConfig[] r2 = this.shadowConfigs;
        int r4 = 0;
        if (r2 != null) goto L23;
        MaterialConfig[] r3 = this.materialConfigs;
        if (r3 != null) goto L7;
    L6:
        r2 = null;
    L20:
        if (r2 != null) goto L23;
        return;
    L7:
        int r6 = r3.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L16;
        MaterialConfig r8 = r3[r7];
        if (r8.getShadow() == null) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L17;
        r7 = r7 + 1;
    L17:
        if (r8 == null) goto L6;
        r2 = r8.getShadow();
        goto L20
    L12:
        r9 = false;
        goto L13
    L16:
        r8 = null;
    L23:
        if (r2.length != 0) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
        return;
    L28:
        Rect r11 = getBounds();
        Intrinsics.checkNotNullExpressionValue(r11, "bounds");
        if (r11.isEmpty() == false) goto L31;
        return;
    L31:
        this.tmpRectF.set(r11);
        int r12 = getShape();
        float[] r13 = getCornerRadii();
        float r14 = getCornerRadius();
        this.shadowClipPath.reset();
        if (r12 != 1) goto L34;
        this.shadowClipPath.addOval(this.tmpRectF, Path.Direction.CW);
    L40:
        int r15 = r2.length;
    L41:
        if (r4 >= r15) goto L59;
        ShadowConfig r16 = r2[r4];
        r4 = r4 + 1;
        if (isShadowValid(r16) == false) goto L41;
        int r18 = r17.save();
        clipOutShadowPath(r17, this.shadowClipPath);
        this.tmpShadowRectF.set(this.tmpRectF);
        float r19 = r17.getDensity() / 160.0f;
        this.tmpShadowRectF.offset(OUnitExtensionKt.dp2pxFloat(r16.getX(), r19), OUnitExtensionKt.dp2pxFloat(r16.getY(), r19));
        this.tmpShadowRectF.inset(-r16.getSpread(), -r16.getSpread());
        this.shadowPaint.setColor(r16.getColor());
        Paint r5 = this.shadowPaint;
        if (r16.getBlurRadius() <= 0.0f) goto L48;
        BlurMaskFilter r110 = new BlurMaskFilter(r16.getBlurRadius(), BlurMaskFilter.Blur.NORMAL);
    L49:
        r5.setMaskFilter(r110);
        if (r12 != 1) goto L52;
        r17.drawOval(this.tmpShadowRectF, this.shadowPaint);
    L58:
        r17.restoreToCount(r18);
        goto L41
    L52:
        if (r13 == null) goto L55;
        this.shadowDrawPath.reset();
        this.shadowDrawPath.addRoundRect(this.tmpShadowRectF, r13, Path.Direction.CW);
        r17.drawPath(this.shadowDrawPath, this.shadowPaint);
        goto L58
    L55:
        if (r14 <= 0.0f) goto L57;
        r17.drawRoundRect(this.tmpShadowRectF, r14, r14, this.shadowPaint);
        goto L58
    L57:
        r17.drawRect(this.tmpShadowRectF, this.shadowPaint);
        goto L58
    L48:
        MaskFilter r111 = (MaskFilter) null;
        r110 = null;
        goto L49
    L59:
        return;
    L34:
        if (r13 == null) goto L37;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r13, Path.Direction.CW);
        goto L40
    L37:
        if (r14 <= 0.0f) goto L39;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r14, r14, Path.Direction.CW);
        goto L40
    L39:
        this.shadowClipPath.addRect(this.tmpRectF, Path.Direction.CW);
        goto L40
    L25:
        r10 = false;
        goto L26
    }

    private final boolean isShadowValid(ShadowConfig r4) {
        if (r4.getColor() != 0) goto L6;
        return false;
    L6:
        if (r4.getX() != 0.0f) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L26;
        if (r4.getY() != 0.0f) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L26;
        if (r4.getBlurRadius() != 0.0f) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L26;
        if (r4.getSpread() != 0.0f) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        return false;
    L23:
        r7 = false;
        goto L24
    L18:
        r6 = false;
        goto L19
    L13:
        r5 = false;
    L26:
        return true;
    L8:
        r3 = false;
        goto L9
    }

    private final void clipOutShadowPath(Canvas r1, Path r2) {
        r1.clipOutPath(r2);
    }

    public final void endAnimation() {
        ValueAnimator r0 = this.colorAnimator;
        if (r0 == null) goto L6;
        r0.end();
    L6:
        ValueAnimator r1 = this.strokeAnimator;
        if (r1 == null) goto L10;
        r1.end();
    L10:
        ValueAnimator[] r2 = this.blendAnimatorArray;
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r5 >= r3) goto L17;
        ValueAnimator r6 = r2[r5];
        if (r6 == null) goto L16;
        r6.end();
    L16:
        r5 = r5 + 1;
        goto L11
    L17:
        ValueAnimator[] r7 = this.overlayBlendAnimatorArray;
        int r8 = r7.length;
    L18:
        if (r4 >= r8) goto L24;
        ValueAnimator r9 = r7[r4];
        if (r9 == null) goto L23;
        r9.end();
    L23:
        r4 = r4 + 1;
        goto L18
    }

    public static /* synthetic */ void setMaterialConfig$default(OMaterialDrawable r1, MaterialConfig r2, int r3, int r4, boolean r5, int r6, Object r7) {
        if (r7 != null) goto L15;
        if ((r6 & 2) == 0) goto L7;
        r3 = 2;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = 1;
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = true;
    L12:
        r1.setMaterialConfig(r2, r3, r4, r5);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfig");
    }

    public final void setMaterialConfig(MaterialConfig r3, int r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "materialConfig");
        setMaterialConfigs(new MaterialConfig[]{r3}, r4, r5, r6);
    }

    public static /* synthetic */ void setMaterialConfigs$default(OMaterialDrawable r1, MaterialConfig[] r2, int r3, int r4, boolean r5, int r6, Object r7) {
        if (r7 != null) goto L15;
        if ((r6 & 2) == 0) goto L7;
        r3 = 2;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = 1;
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = true;
    L12:
        r1.setMaterialConfigs(r2, r3, r4, r5);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    public final void setMaterialConfigs(MaterialConfig[] r5, int r6, int r7, boolean r8) {
        this.materialConfigs = r5;
        this.materialSrcType = r6;
        this.materialDrawMode = r7;
        this.currentBlendConfigsArray = new BlendConfig[2][];
        this.currentOverlayBlendConfigsArray = new BlendConfig[2][];
        this.currentStrokeConfigArray = new StrokeConfig[2];
        View r9 = null;
        this.lastStateSet = null;
        ValueAnimator[] r10 = this.blendAnimatorArray;
        int r0 = r10.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        ValueAnimator r3 = r10[r2];
        if (r3 == null) goto L8;
        r3.cancel();
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        ValueAnimator[] r11 = this.overlayBlendAnimatorArray;
        int r4 = r11.length;
    L10:
        if (r1 >= r4) goto L16;
        ValueAnimator r12 = r11[r1];
        if (r12 == null) goto L15;
        r12.cancel();
    L15:
        r1 = r1 + 1;
        goto L10
    L16:
        if (r5 == null) goto L25;
        MaterialConfig r13 = (MaterialConfig) ArraysKt.firstOrNull(r5);
        if (r13 == null) goto L25;
        ColorStateList r14 = r13.getFallbackBgColor();
        if (r14 == null) goto L25;
        setSolidColors(r14);
    L25:
        Drawable.Callback r15 = getCallback();
        if ((r15 instanceof View) == false) goto L28;
        r9 = (View) r15;
    L28:
        if (r8 == false) goto L31;
        if (r9 == null) goto L31;
        int[] r16 = r9.getDrawableState();
        Intrinsics.checkNotNullExpressionValue(r16, "view.drawableState");
        onStateChange(r16);
    L31:
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "r");
        super.onBoundsChange(r2);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.enableShadow == false) goto L5;
        drawMultiLayerShadow(r2);
    L5:
        super.draw(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        endAnimation();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r9) {
        Intrinsics.checkNotNullParameter(r9, "stateSet");
        Drawable.Callback r0 = getCallback();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 == null) goto L49;
        int r3 = 0;
        if (OMaterialHelper.isMaterialEffectEnabled(r1.getContext()) == true) goto L10;
    L31:
        OMaterialHelper.setEffectSrcAndDraw(r1, 0, this.materialDrawMode);
        ColorStateList r2 = this.solidColors;
        if (r2 != null) goto L34;
        int r4 = 0;
    L35:
        ColorStateList r5 = this.solidColors;
        if (r5 != null) goto L38;
        int r6 = 0;
    L39:
        setColor(r6);
        ColorStateList r7 = this.strokeColors;
        if (r7 != null) goto L42;
        int r8 = 0;
    L43:
        int r10 = OUnitExtensionKt.vdp(r1, this.strokeWidth);
        ColorStateList r11 = this.strokeColors;
        if (r11 == null) goto L47;
        r3 = r11.getColorForState(r9, r8);
    L47:
        setStroke(r10, r3);
        goto L49
    L42:
        r8 = r7.getDefaultColor();
        goto L43
    L38:
        r6 = r5.getColorForState(r9, r4);
        goto L39
    L34:
        r4 = r2.getDefaultColor();
        goto L35
    L10:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L31;
        Boolean[] r12 = this.isCallbackInitArray;
        int r13 = r12.length;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L17;
        if (r12[r14].booleanValue() == false) goto L15;
        r14 = r14 + 1;
        goto L12
    L15:
        boolean r15 = false;
    L18:
        if (r15 == true) goto L49;
        MaterialConfig[] r16 = this.materialConfigs;
        if (r16 == null) goto L49;
        int r17 = r16.length;
    L23:
        if (r3 >= r17) goto L49;
        int r18 = r3 + 1;
        MaterialParams r19 = OMaterialHelper.getMaterialParams(r1, r18);
        if (r19 != null) goto L27;
        Object r20 = null;
    L28:
        if (r20 == null) goto L30;
        setMaterialToEffectObjectIfNotInit(r20, r3, r16[r3]);
    L30:
        r3 = r18;
        goto L23
    L27:
        r20 = r19.getProxy();
        goto L28
    L17:
        r15 = true;
    L49:
        return super.setState(r9);
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r14) {
        Intrinsics.checkNotNullParameter(r14, "stateSet");
        Drawable.Callback r0 = getCallback();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L7:
        if (r1 != null) goto L9;
    L39:
        boolean r2 = processSolidAndStrokeOnStateChange(r14);
        if (r2 == false) goto L42;
        invalidateSelf();
    L42:
        if (r2 == false) goto L44;
        return true;
    L44:
        if (super.onStateChange(r14) == false) goto L47;
        return true;
    L47:
        return false;
    L9:
        if (OMaterialHelper.isMaterialEffectEnabled(r1.getContext()) == true) goto L11;
    L38:
        OMaterialHelper.setEffectSrcAndDraw(r1, 0, this.materialDrawMode);
        goto L39
    L11:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L38;
        MaterialConfig[] r10 = this.materialConfigs;
        if (r10 == null) goto L39;
        int r11 = r10.length;
        boolean r3 = false;
        int r6 = 0;
    L16:
        if (r6 >= r11) goto L30;
        int r12 = r6 + 1;
        MaterialParams r4 = OMaterialHelper.getMaterialParams(r1, r12);
        if (r4 != null) goto L20;
        Object r5 = null;
    L21:
        if (r5 == null) goto L29;
        MaterialConfig r8 = r10[r6];
        if (r3 == false) goto L25;
    L28:
        r3 = true;
        goto L29
    L25:
        if (processMaterialOnStateChange(r1, r5, r6, r14, r8) == true) goto L28;
        r3 = false;
    L29:
        r6 = r12;
        goto L16
    L20:
        r5 = r4.getProxy();
        goto L21
    L30:
        if (r3 == false) goto L32;
        invalidateSelf();
    L32:
        if (r3 == false) goto L34;
        return true;
    L34:
        if (super.onStateChange(r14) == false) goto L37;
        return true;
    L37:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    private final void setMaterialToEffectObjectIfNotInit(Object r3, int r4, MaterialConfig r5) {
        if (this.isCallbackInitArray[r4].booleanValue() == true) goto L20;
        OMaterialHelper.setEffectSrcAndDraw(r3, this.materialSrcType, this.materialDrawMode);
        Float r0 = r5.getBlurRadius();
        if (r0 == null) goto L8;
        OMaterialHelper.setNormalBlurEffect(r3, r0.floatValue());
    L8:
        FluidConfig r1 = r5.getFluid();
        if (r1 == null) goto L12;
        OMaterialHelper.setFluidEffect(r3, true, r1.getGlassParams());
    L12:
        ShadowConfig[] r6 = r5.getShadow();
        if (r6 == null) goto L18;
        ShadowConfig r7 = (ShadowConfig) ArraysKt.firstOrNull(r6);
        if (r7 == null) goto L18;
        Paint r8 = this.shadowPaint;
        int[] r9 = ShadowConfig.Companion.getShadowBlendIntArray(r7);
        OMaterialHelper.setBlendEffectToShadow(r8, Arrays.copyOf(r9, r9.length));
    L18:
        this.isCallbackInitArray[r4] = true;
        return;
    }

    private final boolean processMaterialOnStateChange(View r15, Object r16, int r17, int[] r18, MaterialConfig r19) {
        setColor(0);
        this.targetSolidColor = 0;
        int[] r10 = this.lastStateSet;
        if (this.isCallbackInitArray[r17].booleanValue() == true) goto L18;
        OMaterialHelper.setEffectSrcAndDraw(r16, this.materialSrcType, this.materialDrawMode);
        Float r0 = r19.getBlurRadius();
        if (r0 == null) goto L8;
        OMaterialHelper.setNormalBlurEffect(r16, r0.floatValue());
    L8:
        FluidConfig r1 = r19.getFluid();
        if (r1 == null) goto L12;
        OMaterialHelper.setFluidEffect(r16, true, r1.getGlassParams());
    L12:
        ShadowConfig[] r2 = r19.getShadow();
        if (r2 == null) goto L18;
        ShadowConfig r3 = (ShadowConfig) ArraysKt.firstOrNull(r2);
        if (r3 == null) goto L18;
        Paint r4 = this.shadowPaint;
        int[] r5 = ShadowConfig.Companion.getShadowBlendIntArray(r3);
        OMaterialHelper.setBlendEffectToShadow(r4, Arrays.copyOf(r5, r5.length));
    L18:
        BlendConfigStateList r6 = r19.getBlendConfigStateList();
        StrokeConfig r13 = null;
        if (r6 != null) goto L21;
        BlendConfig[] r7 = null;
    L22:
        if (r7 != null) goto L24;
        r7 = r19.getBlendConfig();
    L24:
        BlendConfig[] r8 = r7;
        if (r8 == null) goto L34;
        BlendConfig[] r9 = this.drawBlendConfigsArray[r17];
        if (this.enableStateChangeTransition == false) goto L32;
        if (r6 == null) goto L32;
        if (r10 == null) goto L32;
        if (r9 == null) goto L32;
        boolean r11 = true;
    L33:
        updateBlendConfigs(r16, r17, r11, r9, r8);
    L32:
        r11 = false;
    L34:
        BlendConfigStateList r12 = r19.getOverlayBlendConfigStateList();
        if (r12 != null) goto L37;
        BlendConfig[] r14 = null;
    L38:
        if (r14 == null) goto L46;
        BlendConfig[] r20 = this.drawOverlayBlendConfigsArray[r17];
        if (this.enableStateChangeTransition == false) goto L44;
        if (r10 == null) goto L44;
        if (r20 == null) goto L44;
        boolean r21 = true;
    L45:
        updateOverlayBlendConfigs(r16, r17, r21, r20, r14);
    L44:
        r21 = false;
    L46:
        StrokeStateList r22 = r19.getStrokeStateList();
        if (r22 == null) goto L50;
        r13 = StrokeStateList.getConfigForState$default(r22, r18, null, 2, null);
    L50:
        if (r13 != null) goto L52;
        r13 = r19.getStroke();
    L52:
        if (r13 == null) goto L61;
        StrokeConfig r23 = this.currentStrokeConfigArray[r17];
        if (this.enableStateChangeTransition == false) goto L59;
        if (r22 == null) goto L59;
        if (r10 == null) goto L59;
        if (r23 == null) goto L59;
        boolean r24 = true;
    L60:
        updateStrokeConfig(r15, r16, r17, r24, r23, r13);
    L59:
        r24 = false;
    L61:
        this.lastStateSet = (int[]) r18.clone();
        this.isCallbackInitArray[r17] = true;
        return false;
    L37:
        r14 = BlendConfigStateList.getConfigForState$default(r12, r18, null, 2, null);
        goto L38
    L21:
        r7 = BlendConfigStateList.getConfigForState$default(r6, r18, null, 2, null);
        goto L22
    }

    private final boolean updateBlendConfigs(final Object r10, final int r11, boolean r12, final BlendConfig[] r13, final BlendConfig[] r14) {
        if (r13 != null) goto L5;
    L8:
        ValueAnimator r1 = this.blendAnimatorArray[r11];
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        if (r14 != null) goto L16;
        int[] r15 = OMaterialHelper.transformToBlendIntArray(new BlendConfig[0]);
        OMaterialHelper.setBlendEffect(r10, Arrays.copyOf(r15, r15.length));
        this.currentBlendConfigsArray[r11] = null;
        this.drawBlendConfigsArray[r11] = null;
        return true;
    L16:
        if (r12 == false) goto L18;
        ValueAnimator[] r16 = this.blendAnimatorArray;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(getAnimDuration());
        r0.setInterpolator(getAnimInterpolator());
        r0.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda4(r13, r14, this, r11, r10));
        r0.start();
        Unit r17 = Unit.INSTANCE;
        r16[r11] = r0;
    L19:
        this.currentBlendConfigsArray[r11] = r14;
        this.drawBlendConfigsArray[r11] = r14;
        return true;
    L18:
        int[] r18 = OMaterialHelper.transformToBlendIntArray(r14);
        OMaterialHelper.setBlendEffect(r10, Arrays.copyOf(r18, r18.length));
        goto L19
    L5:
        if (Arrays.equals(r13, r14) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateBlendConfigs$lambda-24$lambda-23, reason: not valid java name */
    private static final void m556updateBlendConfigs$lambda24$lambda23(BlendConfig[] r1, BlendConfig[] r2, OMaterialDrawable r3, int r4, Object r5, ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$effectParams");
        Intrinsics.checkNotNullParameter(r6, "animator");
        Object r7 = r6.getAnimatedValue();
        if (r7 == null) goto L7;
        float r8 = ((Float) r7).floatValue();
        BlendConfigStateList.Companion r0 = BlendConfigStateList.Companion;
        Intrinsics.checkNotNull(r1);
        BlendConfig[] r9 = r0.getConfigForTransition(r1, r2, r8);
        r3.drawBlendConfigsArray[r4] = r9;
        int[] r10 = OMaterialHelper.transformToBlendIntArray(r9);
        OMaterialHelper.setBlendEffect(r5, Arrays.copyOf(r10, r10.length));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final boolean updateOverlayBlendConfigs(final Object r10, final int r11, boolean r12, final BlendConfig[] r13, final BlendConfig[] r14) {
        if (r13 != null) goto L5;
    L8:
        ValueAnimator r1 = this.overlayBlendAnimatorArray[r11];
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        if (r14 != null) goto L16;
        int[] r15 = OMaterialHelper.transformToBlendIntArray(new BlendConfig[0]);
        OMaterialHelper.setOverlayBlendEffect(r10, Arrays.copyOf(r15, r15.length));
        this.currentOverlayBlendConfigsArray[r11] = null;
        this.drawOverlayBlendConfigsArray[r11] = null;
        return true;
    L16:
        if (r12 == false) goto L18;
        ValueAnimator[] r16 = this.overlayBlendAnimatorArray;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(getAnimDuration());
        r0.setInterpolator(getAnimInterpolator());
        r0.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda1(r13, r14, r10, this, r11));
        r0.start();
        Unit r17 = Unit.INSTANCE;
        r16[r11] = r0;
    L19:
        this.currentOverlayBlendConfigsArray[r11] = r14;
        this.drawOverlayBlendConfigsArray[r11] = r14;
        return true;
    L18:
        int[] r18 = OMaterialHelper.transformToBlendIntArray(r14);
        OMaterialHelper.setOverlayBlendEffect(r10, Arrays.copyOf(r18, r18.length));
        goto L19
    L5:
        if (Arrays.equals(r13, r14) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateOverlayBlendConfigs$lambda-26$lambda-25, reason: not valid java name */
    private static final void m557updateOverlayBlendConfigs$lambda26$lambda25(BlendConfig[] r1, BlendConfig[] r2, Object r3, OMaterialDrawable r4, int r5, ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r3, "$effectParams");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r6, "animator");
        Object r7 = r6.getAnimatedValue();
        if (r7 == null) goto L7;
        float r8 = ((Float) r7).floatValue();
        BlendConfigStateList.Companion r0 = BlendConfigStateList.Companion;
        Intrinsics.checkNotNull(r1);
        BlendConfig[] r9 = r0.getConfigForTransition(r1, r2, r8);
        OMaterialHelper.setOverlayBlendEffect(r3, r9[0].getColor(), 1.0f, r9[0].getBlendMode());
        r4.drawOverlayBlendConfigsArray[r5] = r9;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final boolean updateStrokeConfig(final View r3, Object r4, int r5, boolean r6, final StrokeConfig r7, final StrokeConfig r8) {
        if (r7 != null) goto L4;
    L8:
        ValueAnimator r9 = this.strokeAnimator;
        if (r9 == null) goto L12;
        r9.cancel();
    L12:
        if (r6 == false) goto L14;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(getAnimDuration());
        r10.setInterpolator(getAnimInterpolator());
        r10.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda0(r7, r8, this, r3));
        r10.start();
        this.strokeAnimator = r10;
    L15:
        StrokeConfig[] r2 = this.currentStrokeConfigArray;
        Intrinsics.checkNotNull(r8);
        r2[r5] = r8;
        return true;
    L14:
        Intrinsics.checkNotNull(r8);
        setStroke(OUnitExtensionKt.vdp(r3, r8.getWidth()), r8.getColor());
        goto L15
    L4:
        if (r7.equals(r8) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateStrokeConfig$lambda-29$lambda-28, reason: not valid java name */
    private static final void m560updateStrokeConfig$lambda29$lambda28(StrokeConfig r1, StrokeConfig r2, OMaterialDrawable r3, View r4, ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$view");
        Intrinsics.checkNotNullParameter(r5, "animator");
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L10;
        float r7 = ((Float) r6).floatValue();
        StrokeStateList.Companion r0 = StrokeStateList.Companion;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r2);
        StrokeConfig r8 = r0.getConfigForTransition(r1, r2, r7);
        if (r8 == null) goto L11;
        r3.setStroke(OUnitExtensionKt.vdp(r4, r8.getWidth()), r8.getColor());
        return;
    L11:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final boolean processSolidAndStrokeOnStateChange(int[] r6) {
        ColorStateList r0 = this.solidColors;
        boolean r1 = false;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        ColorStateList r3 = this.solidColors;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        if (r4 == this.targetSolidColor) goto L16;
        if (r4 != r2) goto L14;
        boolean r5 = true;
    L15:
        updateSolidColor(r4, r5);
        this.targetSolidColor = r4;
        boolean r7 = true;
    L17:
        ColorStateList r8 = this.strokeColors;
        if (r8 != null) goto L20;
        int r9 = 0;
    L21:
        ColorStateList r10 = this.strokeColors;
        if (r10 != null) goto L24;
        int r11 = 0;
    L26:
        if (r11 == this.targetStrokeColor) goto L31;
        if (r11 != r9) goto L29;
        r1 = true;
    L29:
        updateStrokeColor(r11, r1);
        this.targetStrokeColor = r11;
        return true;
    L31:
        return r7;
    L24:
        r11 = r10.getColorForState(r6, r9);
        goto L26
    L20:
        r9 = r8.getDefaultColor();
        goto L21
    L14:
        r5 = false;
        goto L15
    L16:
        r7 = false;
        goto L17
    L9:
        r4 = r3.getColorForState(r6, r2);
        goto L11
    L5:
        r2 = r0.getDefaultColor();
        goto L6
    }

    private final void updateSolidColor(int r4, boolean r5) {
        ValueAnimator r0 = this.colorAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r5 == false) goto L8;
        int r6 = this.animatedSolidColor;
        ValueAnimator r7 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r6), Integer.valueOf(r4)});
        r7.setDuration(getAnimDuration());
        r7.setInterpolator(getAnimInterpolator());
        r7.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda3(this));
        r7.start();
        this.colorAnimator = r7;
        return;
    L8:
        this.animatedSolidColor = r4;
        setColor(r4);
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-31$lambda-30, reason: not valid java name */
    private static final void m558updateSolidColor$lambda31$lambda30(OMaterialDrawable r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "animator");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        int r4 = ((Integer) r3).intValue();
        r1.animatedSolidColor = r4;
        r1.setColor(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void updateStrokeColor(int r4, boolean r5) {
        ValueAnimator r0 = this.strokeAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r5 == false) goto L8;
        int r6 = this.animatedStrokeColor;
        ValueAnimator r7 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r6), Integer.valueOf(r4)});
        r7.setDuration(getAnimDuration());
        r7.setInterpolator(getAnimInterpolator());
        r7.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda2(this));
        r7.start();
        this.strokeAnimator = r7;
        return;
    L8:
        this.animatedStrokeColor = r4;
        setStroke(this.strokeWidth, r4);
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-33$lambda-32, reason: not valid java name */
    private static final void m559updateStrokeColor$lambda33$lambda32(OMaterialDrawable r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "animator");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        int r4 = ((Integer) r3).intValue();
        r1.animatedStrokeColor = r4;
        r1.setStroke(r1.strokeWidth, r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}

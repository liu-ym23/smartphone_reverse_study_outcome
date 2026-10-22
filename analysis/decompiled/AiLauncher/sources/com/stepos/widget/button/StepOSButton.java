package com.stepos.widget.button;

import Y8.t;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.glass.GlassRebuildScheduler;
import com.stepos.widget.glass.ManualSurfaceLayers;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import x5.d;
import y7.B;
import y7.o;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 b2\u00020\u0001:\u0002cbB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001e\u0010\rJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001f\u0010\rJ/\u0010$\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0014¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*H\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000bH\u0014¢\u0006\u0004\b.\u0010\rJ\u001f\u00102\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u000bH\u0016¢\u0006\u0004\b4\u0010\rJ\u0017\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00162\u0006\u00109\u001a\u000208H\u0014¢\u0006\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR*\u0010P\u001a\u00020\u00162\u0006\u0010O\u001a\u00020\u00168\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bP\u0010F\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010\u0019R*\u0010T\u001a\u00020S2\u0006\u0010O\u001a\u00020S8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R(\u0010`\u001a\u0004\u0018\u0001082\b\u0010O\u001a\u0004\u0018\u0001088V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010Q¨\u0006d"}, d2 = {"Lcom/stepos/widget/button/StepOSButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LY8/t;", "requestGlassRefresh", "()V", "applyGlass", "releaseGlass", "applyDisabledOpacity", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "", d.EXTRA_ENABLED, "setEnabled", "(Z)V", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "onAttachedToWindow", "onDetachedFromWindow", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "drawableStateChanged", "", "x", "y", "drawableHotspotChanged", "(FF)V", "jumpDrawablesToCurrentState", "layoutDirection", "onRtlPropertiesChanged", "(I)V", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "Lcom/stepos/widget/glass/ManualSurfaceLayers;", "manualLayers", "Lcom/stepos/widget/glass/ManualSurfaceLayers;", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Lcom/stepos/widget/button/StepOSButton$GlassRequest;", "appliedRequest", "Lcom/stepos/widget/button/StepOSButton$GlassRequest;", "refreshPosted", "Z", "glassCustomizer", "Lcom/stepos/widget/glass/GlassCustomizer;", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", "glassRebuild", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", UxipConstants.f30680s, "isGlassEnabled", "()Z", "setGlassEnabled", "Ly7/o;", "glassEffect", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "_surfaceDrawable", "Landroid/graphics/drawable/Drawable;", "getSurfaceDrawable", "()Landroid/graphics/drawable/Drawable;", "setSurfaceDrawable", "(Landroid/graphics/drawable/Drawable;)V", "surfaceDrawable", "isGlassActive", "Companion", "GlassRequest", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class StepOSButton extends AppCompatTextView {
    private static final Companion Companion = new Companion(null);
    private static final float DISABLED_ALPHA = 0.3f;
    private Drawable _surfaceDrawable;
    private GlassRequest appliedRequest;
    private GlassCustomizer glassCustomizer;
    private final GlassDelegate glassDelegate;
    private o glassEffect;
    private final GlassRebuildScheduler glassRebuild;
    private boolean isGlassEnabled;
    private ManualSurfaceLayers manualLayers;
    private boolean refreshPosted;
    private final Runnable refreshRunnable;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/widget/button/StepOSButton$Companion;", "", "<init>", "()V", "DISABLED_ALPHA", "", "wrap", "Landroid/content/Context;", "context", "defStyleRes", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context wrap(Context context, int defStyleRes) {
            return defStyleRes == 0 ? context : new ContextThemeWrapper(context, defStyleRes);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015JD\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u000eJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010\u0013R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010\u0015¨\u0006)"}, d2 = {"Lcom/stepos/widget/button/StepOSButton$GlassRequest;", "", "", "width", "height", "", "radius", "Ly7/o;", "effect", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "<init>", "(IIFLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)V", "component1", "()I", "component2", "component3", "()F", "component4", "()Ly7/o;", "component5", "()Lcom/stepos/widget/glass/GlassCustomizer;", ChatTracker.CLICK_COPY, "(IIFLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)Lcom/stepos/widget/button/StepOSButton$GlassRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getWidth", "getHeight", "F", "getRadius", "Ly7/o;", "getEffect", "Lcom/stepos/widget/glass/GlassCustomizer;", "getCustomizer", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class GlassRequest {
        private final GlassCustomizer customizer;
        private final o effect;
        private final int height;
        private final float radius;
        private final int width;

        public GlassRequest(int i10, int i11, float f10, o effect, GlassCustomizer glassCustomizer) {
            p.i(effect, "effect");
            this.width = i10;
            this.height = i11;
            this.radius = f10;
            this.effect = effect;
            this.customizer = glassCustomizer;
        }

        public static /* synthetic */ GlassRequest copy$default(GlassRequest glassRequest, int i10, int i11, float f10, o oVar, GlassCustomizer glassCustomizer, int i12, Object obj) {
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
                oVar = glassRequest.effect;
            }
            if ((i12 & 16) != 0) {
                glassCustomizer = glassRequest.customizer;
            }
            GlassCustomizer glassCustomizer2 = glassCustomizer;
            float f11 = f10;
            return glassRequest.copy(i10, i11, f11, oVar, glassCustomizer2);
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
        public final o getEffect() {
            return this.effect;
        }

        /* renamed from: component5, reason: from getter */
        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final GlassRequest copy(int width, int height, float radius, o effect, GlassCustomizer customizer) {
            p.i(effect, "effect");
            return new GlassRequest(width, height, radius, effect, customizer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GlassRequest)) {
                return false;
            }
            GlassRequest glassRequest = (GlassRequest) other;
            return this.width == glassRequest.width && this.height == glassRequest.height && Float.compare(this.radius, glassRequest.radius) == 0 && p.d(this.effect, glassRequest.effect) && p.d(this.customizer, glassRequest.customizer);
        }

        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final o getEffect() {
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
            int iHashCode = ((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.radius)) * 31) + this.effect.hashCode()) * 31;
            GlassCustomizer glassCustomizer = this.customizer;
            return iHashCode + (glassCustomizer == null ? 0 : glassCustomizer.hashCode());
        }

        public String toString() {
            return "GlassRequest(width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", effect=" + this.effect + ", customizer=" + this.customizer + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSButton(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    private final void applyDisabledOpacity() {
        setAlpha(isEnabled() ? 1.0f : 0.3f);
    }

    private final void applyGlass() {
        if (!getIsGlassEnabled() || getWidth() <= 0 || getHeight() <= 0 || getVisibility() == 8) {
            releaseGlass();
            return;
        }
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        final GlassCustomizer glassCustomizer = this.glassCustomizer;
        GlassRequest glassRequest = new GlassRequest(getWidth(), getHeight(), fMin, getGlassEffect(), glassCustomizer);
        if (p.d(this.appliedRequest, glassRequest)) {
            return;
        }
        if (glassCustomizer != null) {
            this.glassDelegate.applyCustom$StepOSWidget_release(0, fMin, new InterfaceC5074l() { // from class: com.stepos.widget.button.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSButton.applyGlass$lambda$4(glassCustomizer, (B) obj);
                }
            });
        } else {
            this.glassDelegate.apply$StepOSWidget_release(0, fMin, getGlassEffect());
        }
        this.appliedRequest = glassRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyGlass$lambda$4(GlassCustomizer glassCustomizer, B it) {
        p.i(it, "it");
        return glassCustomizer.customize(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t glassRebuild$lambda$1(StepOSButton stepOSButton) {
        stepOSButton.releaseGlass();
        stepOSButton.requestGlassRefresh();
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(StepOSButton stepOSButton) {
        stepOSButton.refreshPosted = false;
        if (stepOSButton.isAttachedToWindow()) {
            stepOSButton.applyGlass();
        }
    }

    private final void releaseGlass() {
        this.glassDelegate.release$StepOSWidget_release();
        this.appliedRequest = null;
    }

    private final void requestGlassRefresh() {
        if (getIsGlassEnabled() && isAttachedToWindow() && !this.refreshPosted) {
            this.refreshPosted = true;
            post(this.refreshRunnable);
        }
    }

    public void applyCustomGlass(GlassCustomizer customizer) {
        p.i(customizer, "customizer");
        this.glassCustomizer = customizer;
        releaseGlass();
        requestGlassRefresh();
    }

    public void clearCustomGlass() {
        if (this.glassCustomizer == null) {
            return;
        }
        this.glassCustomizer = null;
        releaseGlass();
        requestGlassRefresh();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float x10, float y10) {
        super.drawableHotspotChanged(x10, y10);
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.hotspotChanged(x10, y10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers == null || !manualSurfaceLayers.stateChanged()) {
            return;
        }
        invalidate();
    }

    public o getGlassEffect() {
        return this.glassEffect;
    }

    /* renamed from: getSurfaceDrawable, reason: from getter */
    public Drawable get_surfaceDrawable() {
        return this._surfaceDrawable;
    }

    public boolean isGlassActive() {
        return this.glassDelegate.getIsActive();
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestGlassRefresh();
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.glassRebuild.onConfigurationChanged$StepOSWidget_release(newConfig);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.refreshRunnable);
        this.refreshPosted = false;
        this.glassRebuild.cancel$StepOSWidget_release();
        releaseGlass();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.updateLayoutDirection(layoutDirection);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        requestGlassRefresh();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        applyDisabledOpacity();
    }

    public void setGlassEffect(o value) {
        p.i(value, "value");
        boolean z10 = this.glassCustomizer != null;
        this.glassCustomizer = null;
        if (!p.d(this.glassEffect, value) || z10) {
            this.glassEffect = value;
            releaseGlass();
            requestGlassRefresh();
        }
    }

    public void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        if (z10) {
            requestGlassRefresh();
        } else {
            releaseGlass();
        }
    }

    public void setSurfaceDrawable(Drawable drawable) {
        this._surfaceDrawable = drawable;
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.setSurface(drawable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable who) {
        p.i(who, "who");
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        return (manualSurfaceLayers != null && manualSurfaceLayers.verify(who)) || super.verifyDrawable(who);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSButton(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSButton(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposButtonStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_Button : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSButton(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(Companion.wrap(context, i11), attributeSet, i10);
        p.i(context, "context");
        this.glassDelegate = new GlassDelegate(this);
        this.refreshRunnable = new Runnable() { // from class: com.stepos.widget.button.a
            @Override // java.lang.Runnable
            public final void run() {
                StepOSButton.refreshRunnable$lambda$0(this.f31151a);
            }
        };
        this.glassRebuild = new GlassRebuildScheduler(this, new InterfaceC5063a() { // from class: com.stepos.widget.button.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSButton.glassRebuild$lambda$1(this.f31152a);
            }
        });
        this.isGlassEnabled = true;
        this.glassEffect = o.INSTANCE.i();
        this.manualLayers = new ManualSurfaceLayers(this);
        setClickable(true);
        setFocusable(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSButton, i10, i11);
        try {
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSButton_steposGlassEnabled, true));
            GlassEffectResolver glassEffectResolver = GlassEffectResolver.INSTANCE;
            p.f(typedArrayObtainStyledAttributes);
            o oVar = glassEffectResolver.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSButton_steposGlassEffect);
            if (oVar != null) {
                setGlassEffect(oVar);
                t tVar = t.f7040a;
            }
            C4946a.a(typedArrayObtainStyledAttributes, null);
            Drawable background = getBackground();
            setBackground(null);
            setSurfaceDrawable(background);
            applyDisabledOpacity();
        } finally {
        }
    }
}

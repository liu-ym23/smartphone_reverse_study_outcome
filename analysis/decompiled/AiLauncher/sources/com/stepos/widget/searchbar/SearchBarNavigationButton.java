package com.stepos.widget.searchbar;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.C1299l;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassRebuildScheduler;
import com.stepos.widget.glass.GlassThemeKt;
import com.stepos.widget.glass.ManualSurfaceLayers;
import com.stepos.widget.glass.StepOSGlassPresets;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.B;
import y7.o;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001:\u0001bB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0014\u0010\u000bJ/\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\tH\u0014¢\u0006\u0004\b)\u0010\u000bJ\u001f\u0010-\u001a\u00020\t2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u0010\u000bJ\u0017\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0015H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u000203H\u0014¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\t¢\u0006\u0004\b7\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00108R\u0016\u00109\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010:R\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR,\u0010L\u001a\u00020*2\b\b\u0001\u0010K\u001a\u00020*8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010R\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR.\u0010U\u001a\u0004\u0018\u00010T2\b\u0010K\u001a\u0004\u0018\u00010T8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R(\u0010a\u001a\u0004\u0018\u0001032\b\u0010K\u001a\u0004\u0018\u0001038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006c"}, d2 = {"Lcom/stepos/widget/searchbar/SearchBarNavigationButton;", "Landroidx/appcompat/widget/l;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "glassGate", "<init>", "(Landroid/content/Context;Lp9/a;)V", "LY8/t;", "requestGlassRefresh", "()V", "applyGlass", "releaseGlass", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "onAttachedToWindow", "onDetachedFromWindow", "", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "drawableStateChanged", "", "x", "y", "drawableHotspotChanged", "(FF)V", "jumpDrawablesToCurrentState", "layoutDirection", "onRtlPropertiesChanged", "(I)V", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "refreshGlass", "Lp9/a;", "constructed", "Z", "Lcom/stepos/widget/glass/ManualSurfaceLayers;", "manualLayers", "Lcom/stepos/widget/glass/ManualSurfaceLayers;", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Lcom/stepos/widget/searchbar/SearchBarNavigationButton$GlassRequest;", "appliedRequest", "Lcom/stepos/widget/searchbar/SearchBarNavigationButton$GlassRequest;", "refreshPosted", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", "rowGlassRebuild", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", UxipConstants.f30680s, "glassCornerRadius", "F", "getGlassCornerRadius", "()F", "setGlassCornerRadius", "(F)V", "surfaceDrawableValue", "Landroid/graphics/drawable/Drawable;", "Ly7/o;", "glassEffect", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "glassCustomizer", "Lcom/stepos/widget/glass/GlassCustomizer;", "getSurfaceDrawable", "()Landroid/graphics/drawable/Drawable;", "setSurfaceDrawable", "(Landroid/graphics/drawable/Drawable;)V", "surfaceDrawable", "GlassRequest", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SearchBarNavigationButton extends C1299l {
    private GlassRequest appliedRequest;
    private boolean constructed;
    private float glassCornerRadius;
    private GlassCustomizer glassCustomizer;
    private final GlassDelegate glassDelegate;
    private y7.o glassEffect;
    private final InterfaceC5063a<Boolean> glassGate;
    private ManualSurfaceLayers manualLayers;
    private boolean refreshPosted;
    private final Runnable refreshRunnable;
    private final GlassRebuildScheduler rowGlassRebuild;
    private Drawable surfaceDrawableValue;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JP\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0010J\u001a\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u0015R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010\u0019¨\u0006."}, d2 = {"Lcom/stepos/widget/searchbar/SearchBarNavigationButton$GlassRequest;", "", "", "width", "height", "", "cornerRadius", "", "darkMode", "Ly7/o;", "effect", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "<init>", "(IIFZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)V", "component1", "()I", "component2", "component3", "()F", "component4", "()Z", "component5", "()Ly7/o;", "component6", "()Lcom/stepos/widget/glass/GlassCustomizer;", ChatTracker.CLICK_COPY, "(IIFZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)Lcom/stepos/widget/searchbar/SearchBarNavigationButton$GlassRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getWidth", "getHeight", "F", "getCornerRadius", "Z", "getDarkMode", "Ly7/o;", "getEffect", "Lcom/stepos/widget/glass/GlassCustomizer;", "getCustomizer", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class GlassRequest {
        private final float cornerRadius;
        private final GlassCustomizer customizer;
        private final boolean darkMode;
        private final y7.o effect;
        private final int height;
        private final int width;

        public GlassRequest(int i10, int i11, float f10, boolean z10, y7.o oVar, GlassCustomizer glassCustomizer) {
            this.width = i10;
            this.height = i11;
            this.cornerRadius = f10;
            this.darkMode = z10;
            this.effect = oVar;
            this.customizer = glassCustomizer;
        }

        public static /* synthetic */ GlassRequest copy$default(GlassRequest glassRequest, int i10, int i11, float f10, boolean z10, y7.o oVar, GlassCustomizer glassCustomizer, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = glassRequest.width;
            }
            if ((i12 & 2) != 0) {
                i11 = glassRequest.height;
            }
            if ((i12 & 4) != 0) {
                f10 = glassRequest.cornerRadius;
            }
            if ((i12 & 8) != 0) {
                z10 = glassRequest.darkMode;
            }
            if ((i12 & 16) != 0) {
                oVar = glassRequest.effect;
            }
            if ((i12 & 32) != 0) {
                glassCustomizer = glassRequest.customizer;
            }
            y7.o oVar2 = oVar;
            GlassCustomizer glassCustomizer2 = glassCustomizer;
            return glassRequest.copy(i10, i11, f10, z10, oVar2, glassCustomizer2);
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
        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* renamed from: component5, reason: from getter */
        public final y7.o getEffect() {
            return this.effect;
        }

        /* renamed from: component6, reason: from getter */
        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final GlassRequest copy(int width, int height, float cornerRadius, boolean darkMode, y7.o effect, GlassCustomizer customizer) {
            return new GlassRequest(width, height, cornerRadius, darkMode, effect, customizer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GlassRequest)) {
                return false;
            }
            GlassRequest glassRequest = (GlassRequest) other;
            return this.width == glassRequest.width && this.height == glassRequest.height && Float.compare(this.cornerRadius, glassRequest.cornerRadius) == 0 && this.darkMode == glassRequest.darkMode && kotlin.jvm.internal.p.d(this.effect, glassRequest.effect) && kotlin.jvm.internal.p.d(this.customizer, glassRequest.customizer);
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final y7.o getEffect() {
            return this.effect;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            int iHashCode = ((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.cornerRadius)) * 31) + Boolean.hashCode(this.darkMode)) * 31;
            y7.o oVar = this.effect;
            int iHashCode2 = (iHashCode + (oVar == null ? 0 : oVar.hashCode())) * 31;
            GlassCustomizer glassCustomizer = this.customizer;
            return iHashCode2 + (glassCustomizer != null ? glassCustomizer.hashCode() : 0);
        }

        public String toString() {
            return "GlassRequest(width=" + this.width + ", height=" + this.height + ", cornerRadius=" + this.cornerRadius + ", darkMode=" + this.darkMode + ", effect=" + this.effect + ", customizer=" + this.customizer + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarNavigationButton(Context context, InterfaceC5063a<Boolean> glassGate) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(glassGate, "glassGate");
        this.glassGate = glassGate;
        this.glassDelegate = new GlassDelegate(this);
        this.refreshRunnable = new Runnable() { // from class: com.stepos.widget.searchbar.c
            @Override // java.lang.Runnable
            public final void run() {
                SearchBarNavigationButton.refreshRunnable$lambda$0(this.f31336a);
            }
        };
        this.rowGlassRebuild = new GlassRebuildScheduler(this, new InterfaceC5063a() { // from class: com.stepos.widget.searchbar.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SearchBarNavigationButton.rowGlassRebuild$lambda$1(this.f31337a);
            }
        });
        this.manualLayers = new ManualSurfaceLayers(this);
        setBackground(null);
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.stepos.widget.searchbar.SearchBarNavigationButton.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        });
        setClipToOutline(true);
        this.constructed = true;
    }

    private final void applyGlass() {
        if (isAttachedToWindow()) {
            if (getVisibility() != 0 || getWidth() <= 0 || getHeight() <= 0) {
                releaseGlass();
                return;
            }
            float fMin = this.glassCornerRadius;
            if (fMin <= 0.0f) {
                fMin = Math.min(getWidth(), getHeight()) / 2.0f;
            }
            float f10 = fMin;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            boolean zIsVisuallyDark = GlassThemeKt.isVisuallyDark(context);
            if (!this.glassGate.invoke().booleanValue()) {
                releaseGlass();
                return;
            }
            final GlassCustomizer glassCustomizer = this.glassCustomizer;
            y7.o oVarI = this.glassEffect;
            if (oVarI == null) {
                o.Companion companion = y7.o.INSTANCE;
                oVarI = zIsVisuallyDark ? companion.i() : companion.k();
            }
            y7.o oVar = oVarI;
            GlassRequest glassRequest = new GlassRequest(getWidth(), getHeight(), f10, zIsVisuallyDark, oVar, glassCustomizer);
            if (kotlin.jvm.internal.p.d(glassRequest, this.appliedRequest) && this.glassDelegate.getHasHandle$StepOSWidget_release()) {
                return;
            }
            boolean zApplyCustom$StepOSWidget_release = glassCustomizer != null ? this.glassDelegate.applyCustom$StepOSWidget_release(0, f10, new InterfaceC5074l() { // from class: com.stepos.widget.searchbar.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SearchBarNavigationButton.applyGlass$lambda$3(glassCustomizer, (B) obj);
                }
            }) : (this.glassEffect == null && zIsVisuallyDark) ? this.glassDelegate.applyCustom$StepOSWidget_release(0, f10, new InterfaceC5074l() { // from class: com.stepos.widget.searchbar.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SearchBarNavigationButton.applyGlass$lambda$4(this.f31335a, (B) obj);
                }
            }) : this.glassDelegate.apply$StepOSWidget_release(0, f10, oVar);
            ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
            if (manualSurfaceLayers != null) {
                manualSurfaceLayers.setSurface(zApplyCustom$StepOSWidget_release ? null : this.surfaceDrawableValue);
            }
            this.appliedRequest = glassRequest;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyGlass$lambda$3(GlassCustomizer glassCustomizer, B it) {
        kotlin.jvm.internal.p.i(it, "it");
        return glassCustomizer.customize(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyGlass$lambda$4(SearchBarNavigationButton searchBarNavigationButton, B it) {
        kotlin.jvm.internal.p.i(it, "it");
        return StepOSGlassPresets.INSTANCE.DARK_SMALL_BLEND_10(searchBarNavigationButton.getResources().getDisplayMetrics().density).customize(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(SearchBarNavigationButton searchBarNavigationButton) {
        searchBarNavigationButton.refreshPosted = false;
        if (searchBarNavigationButton.isAttachedToWindow()) {
            searchBarNavigationButton.applyGlass();
        }
    }

    private final void releaseGlass() {
        this.glassDelegate.release$StepOSWidget_release();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.setSurface(this.surfaceDrawableValue);
        }
        this.appliedRequest = null;
    }

    private final void requestGlassRefresh() {
        if (isAttachedToWindow() && getVisibility() == 0 && !this.refreshPosted) {
            this.refreshPosted = true;
            post(this.refreshRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t rowGlassRebuild$lambda$1(SearchBarNavigationButton searchBarNavigationButton) {
        searchBarNavigationButton.releaseGlass();
        searchBarNavigationButton.requestGlassRefresh();
        return Y8.t.f7040a;
    }

    public final void applyCustomGlass(GlassCustomizer customizer) {
        kotlin.jvm.internal.p.i(customizer, "customizer");
        this.glassCustomizer = customizer;
        releaseGlass();
        requestGlassRefresh();
    }

    public final void clearCustomGlass() {
        if (this.glassCustomizer == null) {
            return;
        }
        this.glassCustomizer = null;
        releaseGlass();
        requestGlassRefresh();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableHotspotChanged(float x10, float y10) {
        super.drawableHotspotChanged(x10, y10);
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.hotspotChanged(x10, y10);
        }
    }

    @Override // androidx.appcompat.widget.C1299l, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers == null || !manualSurfaceLayers.stateChanged()) {
            return;
        }
        invalidate();
    }

    public final float getGlassCornerRadius() {
        return this.glassCornerRadius;
    }

    public final y7.o getGlassEffect() {
        return this.glassEffect;
    }

    /* renamed from: getSurfaceDrawable, reason: from getter */
    public final Drawable getSurfaceDrawableValue() {
        return this.surfaceDrawableValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.jumpToCurrentState();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.glassDelegate.getIsActive()) {
            return;
        }
        requestGlassRefresh();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.rowGlassRebuild.onConfigurationChanged$StepOSWidget_release(newConfig);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.refreshRunnable);
        this.refreshPosted = false;
        this.rowGlassRebuild.cancel$StepOSWidget_release();
        releaseGlass();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
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
        invalidateOutline();
        requestGlassRefresh();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (this.constructed && changedView == this) {
            if (visibility == 0) {
                requestGlassRefresh();
            } else {
                releaseGlass();
            }
        }
    }

    public final void refreshGlass() {
        releaseGlass();
        requestGlassRefresh();
    }

    public final void setGlassCornerRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.glassCornerRadius == f10) {
            return;
        }
        this.glassCornerRadius = f10;
        invalidateOutline();
        releaseGlass();
        requestGlassRefresh();
    }

    public final void setGlassEffect(y7.o oVar) {
        boolean z10 = this.glassCustomizer != null;
        this.glassCustomizer = null;
        if (!kotlin.jvm.internal.p.d(this.glassEffect, oVar) || z10) {
            this.glassEffect = oVar;
            releaseGlass();
            requestGlassRefresh();
        }
    }

    public final void setSurfaceDrawable(Drawable drawable) {
        this.surfaceDrawableValue = drawable;
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.setSurface(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean verifyDrawable(Drawable who) {
        kotlin.jvm.internal.p.i(who, "who");
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        return (manualSurfaceLayers != null && manualSurfaceLayers.verify(who)) || super.verifyDrawable(who);
    }
}

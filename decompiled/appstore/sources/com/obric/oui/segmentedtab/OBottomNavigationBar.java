package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import bg.h;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.f;
import com.obric.oui.material.o;
import com.obric.oui.utils.log.L;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u000eJ\u0019\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001d\u0010\u0014J\u0015\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0010H\u0014¢\u0006\u0004\b&\u0010\u0014J\u0017\u0010(\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u001eH\u0016¢\u0006\u0004\b(\u0010!J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u001eH\u0016¢\u0006\u0004\b*\u0010!J\u0019\u0010,\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001eH\u0016¢\u0006\u0004\b/\u0010!J\u0017\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u0010\u0012J\u000f\u00102\u001a\u00020\u0010H\u0002¢\u0006\u0004\b2\u0010\u0014R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00104R\u0014\u00107\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u00106R\u0014\u00109\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00108R\u0016\u0010.\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010:R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "getDefaultTargetView", "()Landroid/view/View;", "insetBottom", "", "d", "(I)V", "onAttachedToWindow", "()V", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "getNavigationBar", "()Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "getMaskView", "Landroid/graphics/drawable/Drawable;", "drawable", "setMaskBackground", "(Landroid/graphics/drawable/Drawable;)V", "b", "", "show", "c", "(Z)V", "", "radius", "setMaskBlurRadius", "(F)V", "onFinishInflate", "enable", "applyMaskMaterial", "apply", "applyContentMaterial", "view", "setBackdropTarget", "(Landroid/view/View;)V", "isBackdropView", "updateBackdropTargetType", "srcType", "updateBackdropSrcType", "a", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "rootView", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "bottomNavBar", "Landroid/view/View;", "maskView", "Z", "e", "I", "materialSrcType", "Lzd/d;", "f", "Lzd/d;", "floatingWindowHelper", "Lcom/obric/oui/material/b;", "g", "Lcom/obric/oui/material/b;", "maskMaterialConfig", "h", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomNavigationBar extends OUIFrameLayout implements MaterialOwner, MaskMaterialOwner {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f16585h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f16586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OBottomNavActionBar f16587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f16588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zd.d f16591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.obric.oui.material.b f16592g;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            q.g(r10, "view");
            q.g(r11, "outline");
            r11.setRect(new Rect(0, r10.getHeight() / 2, r10.getWidth(), r10.getHeight()));
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f16585h = new b(null);
    }

    @JvmOverloads
    public OBottomNavigationBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.j() > 1) goto L5;
        return this;
    L5:
        return this.f16586a;
    }

    public final void a() {
        View r10 = getDefaultTargetView();
        this.f16587b.setBackdropTarget(r10);
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        this.f16587b.applyContentMaterial(r10);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void applyMaskMaterial(boolean r10) {
        f.b(this, r10, this.f16589d);
    }

    public final void b() {
    }

    public final void c(boolean r10) {
        View r11 = this.f16588c;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 4;
        goto L6
    }

    public final void d(int r10) {
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        int r13 = getPaddingRight();
        ViewGroup.LayoutParams r14 = this.f16587b.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r14 = null;
    L5:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L8;
        int r16 = r15.bottomMargin;
    L9:
        setPaddingRelative(r11, r12, r13, h.d(0, r10 - r16));
        return;
    L8:
        r16 = 0;
        goto L9
    }

    @NotNull
    public final View getMaskView() {
        return this.f16588c;
    }

    @NotNull
    public final OBottomNavActionBar getNavigationBar() {
        return this.f16587b;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16591f.h();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r10 = this.f16590e;
        if (r10 == (-1)) goto L6;
        OMaterialHelper.F(this, r10);
        this.f16587b.updateBackdropSrcType(r10);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        if (r10 != null) goto L5;
        o.n(this, this);
        a();
        return;
    L5:
        o.n(this, r10);
        this.f16587b.setBackdropTarget(r10);
    }

    @Deprecated(message = "no use")
    public final void setMaskBackground(@Nullable Drawable r10) {
    }

    public final void setMaskBlurRadius(float r10) {
        int r11 = this.f16590e;
        if (r11 != (-1)) goto L6;
        r11 = 2;
    L6:
        pc.a r12 = this.f16592g.d();
        if (r12 == null) goto L10;
        r12.f(r10);
    L10:
        this.f16591f.d(this, this.f16592g, r11);
        if (r10 != 0.0f) goto L13;
        boolean r13 = true;
    L14:
        c(!r13);
        return;
    L13:
        r13 = false;
        goto L14
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.f16590e = r10;
        OMaterialHelper.F(this, r10);
        this.f16587b.updateBackdropSrcType(r10);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.f16589d == r10) goto L9;
        this.f16589d = r10;
        if (this.f16590e == (-1)) goto L7;
        return;
    L7:
        o.q(this, r10);
        this.f16587b.updateBackdropTargetType(r10);
        return;
    }

    @JvmOverloads
    public OBottomNavigationBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OBottomNavigationBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OBottomNavigationBar(@NotNull Context r24, @Nullable AttributeSet r25, int r26) {
        q.g(r24, "context");
        super(r24, r25, r26, null, 8, null);
        this.f16589d = true;
        this.f16590e = -1;
        zd.d r10 = new zd.d(this);
        this.f16591f = r10;
        com.obric.oui.material.b r11 = new com.obric.oui.material.b(null, null, OMaterialHelper.h(getResources(), R$array.oui_bottom_navbar_blend_colors), null, null, null, new pc.a(BlurToken.Blur_Progress_Thin, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        this.f16592g = r11;
        boolean r12 = false;
        setClipToPadding(false);
        setClipChildren(false);
        setOutlineProvider(new a());
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenSelected(false);
        LayoutInflater.from(r24).inflate(R$layout.layout_custom_bottom_navigation, this, true);
        View r13 = findViewById(R$id.bottom_nav_bar_container);
        q.f(r13, "findViewById(R.id.bottom_nav_bar_container)");
        ViewGroup r14 = (ViewGroup) r13;
        this.f16586a = r14;
        ((OUIFrameLayout) r14).setChangeAlphaWhenPress(false);
        ((OUIFrameLayout) r14).setChangeAlphaWhenDisable(false);
        ((OUIFrameLayout) r14).setChangeAlphaWhenSelected(false);
        View r15 = findViewById(R$id.bottom_nav_bar);
        q.f(r15, "findViewById(R.id.bottom_nav_bar)");
        OBottomNavActionBar r16 = (OBottomNavActionBar) r15;
        this.f16587b = r16;
        r16.j(r24, r25);
        r16.setChangeAlphaWhenPress(false);
        r16.setChangeAlphaWhenDisable(false);
        r16.setChangeAlphaWhenSelected(false);
        View r17 = findViewById(R$id.mask_view);
        q.f(r17, "findViewById(R.id.mask_view)");
        this.f16588c = r17;
        int[] r18 = R$styleable.OTabLayout;
        q.f(r18, "OTabLayout");
        TypedArray r19 = r24.obtainStyledAttributes(r25, r18, 0, 0);
        q.f(r19, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.f16590e = r19.getInt(R$styleable.OTabLayout_oui_widgetMaterialSrcType, -1);
        int r20 = R$styleable.OTabLayout_oui_widgetBlurColors;
        if (r19.hasValue(r20) == false) goto L9;
        int r21 = R$styleable.OTabLayout_oui_widgetBlurBlendModes;
        if (r19.hasValue(r21) == false) goto L9;
        r11.l(OMaterialHelper.i(r19.getResources(), r19.getResourceId(r20, R$array.oui_bottom_navbar_blur_colors), r19.getResourceId(r21, R$array.oui_bottom_navbar_blur_blend_modes)));
        if (r11.b() != null) goto L9;
        L.b("OBottomNavigationBar", "init get widget blur colors or modes error");
    L9:
        float r22 = r19.getFloat(R$styleable.OTabLayout_oui_widgetBlurRadius, 0.0f);
        pc.a r23 = r11.d();
        if (r23 == null) goto L14;
        r23.f(r22);
    L14:
        if (r19.getBoolean(R$styleable.OTabLayout_enableDefaultMaskBackground, false) == false) goto L16;
        b();
    L18:
        if (r19.getInt(R$styleable.OTabLayout_oui_bottomActionBarType, 0) != 1) goto L20;
        r12 = true;
    L20:
        r10.j(r12);
        r10.l(r19.getBoolean(R$styleable.OTabLayout_oui_widgetFitInsetBottom, true), new OBottomNavigationBar$2$1(this));
        setMaskBlurRadius(r22);
        r19.recycle();
        a();
        r10.k(81);
        return;
    L16:
        setMaskBackground(r19.getDrawable(R$styleable.OTabLayout_maskBackground));
        goto L18
    }
}

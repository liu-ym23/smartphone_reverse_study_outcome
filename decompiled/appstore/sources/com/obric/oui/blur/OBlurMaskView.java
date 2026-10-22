package com.obric.oui.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.graphics.e;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.b;
import com.obric.oui.material.f;
import com.obric.oui.material.o;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010 J\u0019\u0010#\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001dH\u0016¢\u0006\u0004\b&\u0010 J\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010\u001cJ\u0015\u0010*\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\b¢\u0006\u0004\b*\u0010\u001cJ\u0015\u0010,\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010\u001cJ\u0017\u0010-\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u0010\u0011J\u0017\u00100\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b0\u0010 J\u0017\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b4\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u00109R\u0016\u0010<\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00109R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010>R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010>R\u0016\u0010%\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u00109R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010>R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010C¨\u0006F"}, d2 = {"Lcom/obric/oui/blur/OBlurMaskView;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Lcom/obric/oui/material/MaterialOwner;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "getDefaultTargetView", "()Landroid/view/View;", "", "onFinishInflate", "()V", "", "radius", "setMaskBlurRadius", "(F)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setMaskBackground", "(Landroid/graphics/drawable/Drawable;)V", Style.KEY_HEIGHT, "setMaskHeight", "(I)V", "", "apply", "applyContentMaterial", "(Z)V", "applyMaskMaterial", "view", "setBackdropTarget", "(Landroid/view/View;)V", "isBackdropView", "updateBackdropTargetType", "srcType", "updateBackdropSrcType", "insetTop", "g", "insetBottom", "f", "b", "(Landroid/util/AttributeSet;)V", "d", "e", "child", "i", "(Lcom/obric/oui/material/MaterialOwner;)V", "h", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "materialMask", "Z", "isInflated", "c", "fitInsetTop", "fitInsetBottom", "I", "defaultPaddingTop", "defaultPaddingBottom", "materialSrcType", "Lcom/obric/oui/material/b;", "Lcom/obric/oui/material/b;", "maskMaterialConfig", "j", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBlurMaskView extends FrameLayout implements MaskMaterialOwner, MaterialOwner {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f12460j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f12461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f12469i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12460j = new a(null);
    }

    @JvmOverloads
    public OBlurMaskView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ WindowInsets a(OBlurMaskView r10, View r11, WindowInsets r12) {
        return c(r10, r11, r12);
    }

    public static final WindowInsets c(OBlurMaskView r10, View r11, WindowInsets r12) {
        q.g(r10, "this$0");
        q.g(r11, "$noName_0");
        q.g(r12, "insets");
        e r13 = wd.a.i(r10, r12, true);
        if (r10.f12463c == false) goto L5;
        int r14 = r13.f2557b;
    L6:
        r10.g(r14);
        if (r10.f12464d == false) goto L9;
        int r15 = r13.f2559d;
    L10:
        r10.f(r15);
        return r12;
    L9:
        r15 = r10.f12466f;
        goto L10
    L5:
        r14 = r10.f12465e;
        goto L6
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.j() > 1) goto L5;
        return this;
    L5:
        return this.f12461a;
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        e(r10);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void applyMaskMaterial(boolean r10) {
        int r11 = this.f12468h;
        if (r11 == (-1)) goto L6;
        f.a(this, r10, r11);
        return;
    L6:
        f.b(this, r10, this.f12467g);
    }

    public final void b(AttributeSet r10) {
        Context r11 = getContext();
        q.f(r11, "context");
        int[] r12 = R$styleable.OBlurMaskView;
        q.f(r12, "OBlurMaskView");
        TypedArray r13 = r11.obtainStyledAttributes(r10, r12, 0, 0);
        q.f(r13, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        int r14 = R$styleable.OBlurMaskView_oui_widgetMaterialSrcType;
        if (r13.hasValue(r14) == false) goto L5;
        this.f12468h = r13.getInt(r14, 2);
    L5:
        int r15 = R$styleable.OBlurMaskView_oui_widgetBlurType;
        if (r13.hasValue(r15) == false) goto L11;
        int r16 = r13.getInt(r15, 0);
        pc.a r17 = this.f12469i.d();
        if (r17 == null) goto L11;
        r17.g(r16);
    L11:
        int r18 = R$styleable.OBlurMaskView_oui_widgetBlurColors;
        if (r13.hasValue(r18) == false) goto L18;
        int r19 = R$styleable.OBlurMaskView_oui_widgetBlurBlendModes;
        if (r13.hasValue(r19) == false) goto L18;
        int r20 = r13.getResourceId(r18, R$array.oui_titlebar_blur_colors);
        int r21 = r13.getResourceId(r19, R$array.oui_titlebar_blur_blend_modes);
        this.f12469i.l(OMaterialHelper.i(r13.getResources(), r20, r21));
        if (this.f12469i.b() != null) goto L18;
        L.b("OBlurMaskView", "init get widget blur colors or modes error");
    L18:
        int r22 = R$styleable.OBlurMaskView_oBlurMask_blurRadius;
        if (r13.hasValue(r22) == false) goto L25;
        float r23 = r13.getFloat(r22, BlurToken.Blur_Progress_Thin);
        pc.a r24 = this.f12469i.d();
        if (r24 == null) goto L24;
        r24.f(r23);
    L24:
        setMaskBlurRadius(r23);
    L25:
        int r25 = R$styleable.OBlurMaskView_oBlurMask_maskHeight;
        if (r13.hasValue(r25) == false) goto L30;
        int r26 = r13.getDimensionPixelSize(r25, 0);
        if (r26 <= 0) goto L30;
        setMaskHeight(r26);
    L30:
        boolean r27 = r13.getBoolean(R$styleable.OBlurMaskView_oBlurMask_statusBarImmersion, false);
        this.f12463c = r13.getBoolean(R$styleable.OBlurMaskView_oui_widgetFitInsetTop, r27);
        boolean r28 = r13.getBoolean(R$styleable.OBlurMaskView_oui_widgetFitInsetBottom, false);
        this.f12464d = r28;
        if (this.f12463c == true) goto L33;
        if (r28 == true) goto L33;
    L42:
        r13.recycle();
        return;
    L33:
        e r29 = wd.a.i(this, null, true);
        if (this.f12463c == false) goto L36;
        int r30 = r29.f2557b;
    L37:
        g(r30);
        if (this.f12464d == false) goto L40;
        int r31 = r29.f2559d;
    L41:
        f(r31);
        setOnApplyWindowInsetsListener(new pc.e(this));
        goto L42
    L40:
        r31 = this.f12466f;
        goto L41
    L36:
        r30 = this.f12465e;
        goto L37
    }

    public final void d() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L16;
        int r12 = r11 + 1;
        KeyEvent.Callback r13 = getChildAt(r11);
        if ((r13 instanceof MaterialOwner) == false) goto L8;
        MaterialOwner r14 = (MaterialOwner) r13;
        h(r14);
        i(r14);
    L15:
        r11 = r12;
        goto L3
    L8:
        if ((r13 instanceof ViewGroup) == false) goto L15;
        ViewGroup r15 = (ViewGroup) r13;
        int r16 = r15.getChildCount();
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L15;
        int r18 = r17 + 1;
        KeyEvent.Callback r19 = r15.getChildAt(r17);
        if ((r19 instanceof MaterialOwner) == false) goto L14;
        MaterialOwner r20 = (MaterialOwner) r19;
        h(r20);
        i(r20);
    L14:
        r17 = r18;
        goto L10
    }

    public final void e(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L16;
        int r13 = r12 + 1;
        KeyEvent.Callback r14 = getChildAt(r12);
        if ((r14 instanceof MaterialOwner) == false) goto L8;
        ((MaterialOwner) r14).applyContentMaterial(r10);
    L15:
        r12 = r13;
        goto L3
    L8:
        if ((r14 instanceof ViewGroup) == false) goto L15;
        ViewGroup r15 = (ViewGroup) r14;
        int r16 = r15.getChildCount();
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L15;
        int r18 = r17 + 1;
        KeyEvent.Callback r19 = r15.getChildAt(r17);
        if ((r19 instanceof MaterialOwner) == false) goto L14;
        ((MaterialOwner) r19).applyContentMaterial(r10);
    L14:
        r17 = r18;
        goto L10
    }

    public final void f(int r10) {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), r10);
    }

    public final void g(int r10) {
        setPadding(getPaddingLeft(), r10, getPaddingRight(), getPaddingBottom());
    }

    public final void h(MaterialOwner r10) {
        r10.updateBackdropSrcType(this.f12468h);
    }

    public final void i(MaterialOwner r10) {
        if ((r10 instanceof MaskMaterialOwner) == false) goto L5;
        ((MaskMaterialOwner) r10).applyMaskMaterial(false);
    L5:
        r10.setBackdropTarget(getDefaultTargetView());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        d();
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        if (r10 != null) goto L5;
        o.n(this, this);
        return;
    L5:
        o.n(this, r10);
    }

    public final void setMaskBackground(@NotNull Drawable r10) {
        q.g(r10, "drawable");
        setBackground(r10);
    }

    public final void setMaskBlurRadius(float r10) {
        pc.a r11 = this.f12469i.d();
        if (r11 == null) goto L6;
        r11.f(r10);
    L6:
        OMaterialHelper.D(this, this.f12469i);
        o.n(this, this);
    }

    @Deprecated(message = "")
    public final void setMaskHeight(int r10) {
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.f12468h = r10;
        o.p(this, r10);
        d();
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        this.f12467g = r10;
        o.q(this, r10);
    }

    @JvmOverloads
    public OBlurMaskView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OBlurMaskView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OBlurMaskView(@NotNull Context r20, @Nullable AttributeSet r21, int r22) {
        q.g(r20, "context");
        super(r20, r21, r22);
        this.f12465e = tc.f.r(this, 24);
        this.f12466f = tc.f.r(this, 24);
        this.f12467g = true;
        this.f12468h = 2;
        this.f12469i = new b(null, null, OMaterialHelper.i(getResources(), R$array.oui_titlebar_blur_colors, R$array.oui_titlebar_blur_blend_modes), null, null, null, new pc.a(BlurToken.Blur_Progress_Thin, 1, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        LayoutInflater.from(r20).inflate(R$layout.o_blur_mask_view, this, true);
        View r10 = findViewById(R$id.material_mask);
        q.f(r10, "findViewById(R.id.material_mask)");
        this.f12461a = (ViewGroup) r10;
        setClipChildren(false);
        setClipToPadding(false);
        this.f12462b = true;
        if (r21 == null) goto L6;
        b(r21);
        return;
    }
}

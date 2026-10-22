package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.f;
import com.obric.oui.material.o;
import com.obric.oui.utils.log.L;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B;\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0011H\u0014¢\u0006\u0004\b#\u0010\u0018J\u000f\u0010$\u001a\u00020\u0011H\u0014¢\u0006\u0004\b$\u0010\u0018J\u0017\u0010&\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000bH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000bH\u0016¢\u0006\u0004\b(\u0010'J\u0019\u0010*\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010'J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u0010\u001bJ\u000f\u00100\u001a\u00020\u0011H\u0002¢\u0006\u0004\b0\u0010\u0018R\u0016\u00102\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00104R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00104R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00104R\u0018\u0010:\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00101R\u0016\u0010=\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010?R \u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010BR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "", "enableSetBackDropTarget", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IIZ)V", "", "radius", "", "setBackgroundBlurRadius", "(F)V", "Landroid/view/View;", "getDefaultTargetView", "()Landroid/view/View;", "b", "()V", "insetBottom", "c", "(I)V", "Landroid/view/ViewGroup;", "getActionGroup", "()Landroid/view/ViewGroup;", "", "buttons", "setButtons", "(Ljava/util/List;)V", "onAttachedToWindow", "onFinishInflate", "apply", "applyMaskMaterial", "(Z)V", "applyContentMaterial", "view", "setBackdropTarget", "(Landroid/view/View;)V", "isBackdropView", "updateBackdropTargetType", "srcType", "updateBackdropSrcType", "a", "Landroid/view/ViewGroup;", "rootView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "leftContainer", "centerContainer", "d", "rightContainer", "e", "actionGroup", "f", "F", "backgroundBlurRadius", "g", "I", "defaultPaddingBottom", "h", "Z", "i", "materialSrcType", "Ljava/lang/ref/WeakReference;", "j", "Ljava/lang/ref/WeakReference;", "backdropTarget", "k", "enableBackDropTarget", "Lzd/d;", "l", "Lzd/d;", "floatingWindowHelper", "Lcom/obric/oui/material/b;", "m", "Lcom/obric/oui/material/b;", "maskMaterialConfig", "n", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarFloating extends FrameLayout implements MaterialOwner, MaskMaterialOwner {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f12235n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f12236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f12237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f12238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f12239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f12240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f12241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference f12245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f12246k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f12247l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.obric.oui.material.b f12248m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            q.g(r10, "view");
            q.g(r11, "outline");
            r11.setRect(new Rect(0, r10.getHeight() / 2, r10.getWidth(), r10.getHeight()));
        }
    }

    static {
        f12235n = new a(null);
    }

    @JvmOverloads
    public OBottomActionBarFloating(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 30, null);
    }

    private final void b() {
        if (this.f12246k == true) goto L5;
        return;
    L5:
        View r10 = getDefaultTargetView();
        f.h(new LinearLayout[]{this.f12237b, this.f12238c, this.f12239d}, r10);
        ViewParent r11 = this.f12240e;
        if ((r11 instanceof MaterialOwner) == false) goto L11;
        if (r11 == null) goto L10;
        ((MaterialOwner) r11).setBackdropTarget(r10);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    }

    private final View getDefaultTargetView() {
        WeakReference r10 = this.f12245j;
        if (r10 == null) goto L7;
        q.d(r10);
        return (View) r10.get();
    L7:
        if (OMaterialHelper.j() > 1) goto L9;
        return this;
    L9:
        return this.f12236a;
    }

    private final void setBackgroundBlurRadius(float r10) {
        setOutlineProvider(new b());
        int r11 = this.f12244i;
        if (r11 != (-1)) goto L6;
        r11 = 2;
    L6:
        pc.a r12 = this.f12248m.d();
        if (r12 == null) goto L11;
        r12.f(r10);
        this.f12247l.d(this, this.f12248m, r11);
        return;
    }

    public final void a() {
        this.f12237b.removeAllViews();
        this.f12238c.removeAllViews();
        this.f12239d.removeAllViews();
        this.f12237b.setVisibility(8);
        this.f12238c.setVisibility(8);
        this.f12239d.setVisibility(8);
        this.f12240e = null;
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        f.d(new LinearLayout[]{this.f12237b, this.f12238c, this.f12239d}, r10);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void applyMaskMaterial(boolean r10) {
        int r11 = this.f12244i;
        if (r11 == (-1)) goto L6;
        f.a(this, r10, r11);
        return;
    L6:
        f.b(this, r10, this.f12243h);
    }

    public final void c(int r10) {
        setPaddingRelative(getPaddingLeft(), getPaddingTop(), getPaddingRight(), Math.max(r10, this.f12242g));
    }

    @Nullable
    public final ViewGroup getActionGroup() {
        return this.f12240e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12247l.h();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r10 = this.f12244i;
        if (r10 == (-1)) goto L6;
        o.p(this, r10);
        f.f(new LinearLayout[]{this.f12237b, this.f12238c, this.f12239d}, this.f12244i);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        if (this.f12246k == true) goto L5;
        return;
    L5:
        this.f12245j = new WeakReference(r10);
        f.h(new LinearLayout[]{this.f12237b, this.f12238c, this.f12239d}, r10);
        ViewParent r11 = this.f12240e;
        if ((r11 instanceof MaterialOwner) == false) goto L11;
        if (r11 == null) goto L10;
        ((MaterialOwner) r11).setBackdropTarget(r10);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    }

    public final void setButtons(@NotNull List<? extends View> r10) {
        q.g(r10, "buttons");
        a();
        if (r10.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() != 1) goto L9;
        this.f12238c.addView(r10.get(0));
        this.f12238c.setVisibility(0);
    L11:
        Iterator<T> r11 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L22;
        KeyEvent.Callback r12 = (View) r11.next();
        if ((r12 instanceof MaterialOwner) == false) goto L13;
        if (this.f12246k == false) goto L19;
        ((MaterialOwner) r12).setBackdropTarget(getDefaultTargetView());
    L19:
        int r13 = this.f12244i;
        if (r13 == (-1)) goto L13;
        ((MaterialOwner) r12).updateBackdropSrcType(r13);
        goto L13
    L22:
        return;
    L9:
        if (r10.size() < 2) goto L11;
        this.f12237b.addView(r10.get(0));
        this.f12237b.setVisibility(0);
        this.f12239d.addView(r10.get(1));
        this.f12239d.setVisibility(0);
        goto L11
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.f12244i = r10;
        o.p(this, r10);
        f.f(new LinearLayout[]{this.f12237b, this.f12238c, this.f12239d}, this.f12244i);
        ViewParent r11 = this.f12240e;
        if ((r11 instanceof MaterialOwner) == false) goto L8;
        if (r11 == null) goto L7;
        ((MaterialOwner) r11).updateBackdropSrcType(r10);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.f12243h == r10) goto L16;
        this.f12243h = r10;
        if (this.f12244i == (-1)) goto L8;
        return;
    L8:
        if (this.f12247l.g() == true) goto L10;
        o.q(this, this.f12243h);
    L10:
        f.j(new LinearLayout[]{this.f12237b, this.f12238c, this.f12239d}, r10);
        ViewParent r11 = this.f12240e;
        if ((r11 instanceof MaterialOwner) == false) goto L17;
        if (r11 == null) goto L15;
        ((MaterialOwner) r11).updateBackdropTargetType(this.f12243h);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    L17:
        return;
    }

    @JvmOverloads
    public OBottomActionBarFloating(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 28, null);
    }

    @JvmOverloads
    public OBottomActionBarFloating(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 24, null);
    }

    public /* synthetic */ OBottomActionBarFloating(Context r10, AttributeSet r11, int r12, int r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        r11 = null;
    L5:
        AttributeSet r17 = r11;
        if ((r15 & 4) == 0) goto L8;
        int r18 = 0;
    L10:
        if ((r15 & 8) == 0) goto L12;
        int r19 = 0;
    L14:
        if ((r15 & 16) == 0) goto L16;
        r14 = true;
    L16:
        this(r10, r17, r18, r19, r14);
        return;
    L12:
        r19 = r13;
        goto L14
    L8:
        r18 = r12;
        goto L10
    }

    public OBottomActionBarFloating(Context r27, AttributeSet r28, int r29, int r30, boolean r31) {
        q.g(r27, "context");
        super(r27, r28, r29, r30);
        this.f12243h = true;
        this.f12244i = 2;
        this.f12246k = r31;
        d r10 = new d(this);
        this.f12247l = r10;
        Resources r11 = getResources();
        int r14 = R$array.oui_bottom_actionbar_blur_colors;
        int r13 = R$array.oui_bottom_actionbar_blur_blend_modes;
        com.obric.oui.color.a[] r12 = OMaterialHelper.i(r11, r14, r13);
        float r15 = BlurToken.Blur_Progress_Thin;
        com.obric.oui.material.b r16 = new com.obric.oui.material.b(null, null, r12, null, null, null, new pc.a(r15, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        this.f12248m = r16;
        this.f12241f = r15;
        boolean r17 = false;
        setClipChildren(false);
        setClipToPadding(false);
        this.f12242g = getPaddingBottom();
        FrameLayout.inflate(r27, R$layout.o_widget_bottom_action_bar_v2_floating, this);
        View r18 = findViewById(R$id.bottom_action_bar_root);
        q.f(r18, "findViewById(R.id.bottom_action_bar_root)");
        this.f12236a = (ViewGroup) r18;
        View r19 = findViewById(R$id.action_bar_left_container);
        q.f(r19, "findViewById(R.id.action_bar_left_container)");
        this.f12237b = (LinearLayout) r19;
        View r20 = findViewById(R$id.action_bar_center_container);
        q.f(r20, "findViewById(R.id.action_bar_center_container)");
        this.f12238c = (LinearLayout) r20;
        View r21 = findViewById(R$id.action_bar_right_container);
        q.f(r21, "findViewById(R.id.action_bar_right_container)");
        this.f12239d = (LinearLayout) r21;
        int[] r22 = R$styleable.OBottomActionBar;
        q.f(r22, "OBottomActionBar");
        TypedArray r23 = r27.obtainStyledAttributes(r28, r22, 0, 0);
        q.f(r23, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.f12244i = r23.getInt(R$styleable.OBottomActionBar_oui_widgetMaterialSrcType, 2);
        int r24 = R$styleable.OBottomActionBar_oui_widgetBlurColors;
        if (r23.hasValue(r24) == false) goto L9;
        int r25 = R$styleable.OBottomActionBar_oui_widgetBlurBlendModes;
        if (r23.hasValue(r25) == false) goto L9;
        r16.l(OMaterialHelper.i(r23.getResources(), r23.getResourceId(r24, r14), r23.getResourceId(r25, r13)));
        if (r16.b() != null) goto L9;
        L.b("OBottomActionBarFloating", "init get widget blur colors or modes error");
    L9:
        int r26 = R$styleable.OBottomActionBar_oui_widgetBlurRadius;
        if (r23.hasValue(r26) == false) goto L12;
        this.f12241f = r23.getFloat(r26, r15);
    L12:
        int r32 = R$styleable.OBottomActionBar_oui_bottomActionBarType;
        if (r23.hasValue(r32) == false) goto L18;
        boolean r33 = true;
        if (r23.getInt(r32, 0) != 1) goto L17;
        r17 = true;
    L17:
        r10.j(r17);
    L19:
        r10.l(r23.getBoolean(R$styleable.OBottomActionBar_oui_widgetFitInsetBottom, r33), new OBottomActionBarFloating$1$1(this));
        r23.recycle();
        setBackgroundBlurRadius(this.f12241f);
        b();
        r10.k(81);
        return;
    L18:
        r33 = true;
        goto L19
    }
}

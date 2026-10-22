package com.obric.oui.popover.v2;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.oui.color.i0;
import com.obric.oui.common.style.ODynamicThemeWidget;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u0002:\u0001KB?\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u0013BS\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00152\b\b\u0001\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u001bJ\u0015\u0010\"\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00152\b\b\u0001\u0010$\u001a\u00020 ¢\u0006\u0004\b%\u0010#J\r\u0010&\u001a\u00020 ¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0005¢\u0006\u0004\b(\u0010\u001dJ\u0015\u0010)\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b)\u0010\u001bJ\u0015\u0010+\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\u001bJ\u0015\u0010-\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00052\b\b\u0003\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u0019\u00107\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b7\u00105J\u0017\u0010:\u001a\u00020\u00152\u0006\u00109\u001a\u000208H\u0014¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0015H\u0014¢\u0006\u0004\b<\u0010\u0017J\u000f\u0010=\u001a\u00020\u0015H\u0014¢\u0006\u0004\b=\u0010\u0017J\u001f\u0010@\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0015¢\u0006\u0004\b@\u0010AJ/\u0010E\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u000bH\u0014¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00152\u0006\u00109\u001a\u000208H\u0015¢\u0006\u0004\bG\u0010;J\r\u0010H\u001a\u00020\u000b¢\u0006\u0004\bH\u0010IJ\r\u0010J\u001a\u00020\u000b¢\u0006\u0004\bJ\u0010IR\u0016\u0010M\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010W\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010RR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010YR\u0016\u0010]\u001a\u00020[8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010\\R\u0016\u0010`\u001a\u00020^8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010fR\"\u0010k\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010L\u001a\u0004\bi\u0010'\"\u0004\bj\u0010#R\"\u0010o\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010L\u001a\u0004\bm\u0010'\"\u0004\bn\u0010#R\"\u0010s\u001a\u00020\u000b8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010R\u001a\u0004\bq\u0010I\"\u0004\br\u0010\u001bR\u0016\u0010u\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010RR\u0016\u0010w\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010RR\u0016\u0010y\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010RR\u0018\u0010{\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010\\R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010OR\u0016\u0010~\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010OR,\u0010\u0081\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010R¨\u0006\u0085\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLayout;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "Landroid/content/Context;", "context", "", "enableMaterialByUser", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/b;", "materials", "", "materialSrcType", "<init>", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;I)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;IZLkotlin/jvm/functions/Function1;I)V", "", "j", "()V", "f", "themeStyle", "applyDynamicTheme", "(I)V", "isDarkTheme", "()Z", "color", "setBgColor", "", "cornerRadiusDp", "setCornerRadiusDp", "(F)V", "cornerRadius", "setCornerRadius", "getCornerRadius", "()F", "g", "setBorderColor", Style.KEY_WIDTH, "setBorderWidth", "transparent", "setTransparentBg", "(Z)V", "covered", "h", "(ZI)V", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "event", "onTouchEvent", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "onAttachedToWindow", "onDetachedFromWindow", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "onDraw", "getPadding", "()I", "getArrowHeight", "a", "F", "mCornerRadius", "b", "Z", "coverEnabled", "c", "I", "coverColor", "d", "currentCoverColor", "e", "coverColorOnAnimStart", "Landroid/animation/ArgbEvaluator;", "Landroid/animation/ArgbEvaluator;", "colorEvaluator", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mFillPaint", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "mPath", "Landroid/graphics/Rect;", "i", "Landroid/graphics/Rect;", "mRoundRect", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mRoundRectF", "k", "getMWidth", "setMWidth", "mWidth", "l", "getMHeight", "setMHeight", "mHeight", "m", "getMBgColor", "setMBgColor", "mBgColor", "n", "pressStateColor", "o", "borderWidth", "p", "borderColor", "q", "strokePaint", "r", "s", "enableMaterial", "t", "Lkotlin/jvm/functions/Function1;", "appliedMaterials", "u", "appliedMaterialSrcType", "v", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLayout extends LinearLayout implements ODynamicThemeWidget {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f16249v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f16250w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static float f16251x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f16252y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArgbEvaluator f16258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f16259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f16260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Rect f16261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f16262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f16263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f16264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f16265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f16266n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16267o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16268p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f16269q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f16270r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16271s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function1 f16272t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f16273u;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final float a() {
            return OPopoverLayout.b();
        }

        public a() {
        }
    }

    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OPopoverLayout f16274a;

        public b(OPopoverLayout r10) {
            this.f16274a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            if (r10 == null) goto L9;
            OPopoverLayout r12 = this.f16274a;
            int r13 = (int) (OPopoverLayout.a(r12) / 2.0f);
            OPopoverLayout.d(r12).set(r13, r13, r10.getWidth() - r13, r10.getHeight() - r13);
            OPopoverLayout.e(r12).set(OPopoverLayout.d(r12));
            if (r11 == null) goto L10;
            r11.setRoundRect(OPopoverLayout.d(r12), OPopoverLayout.c(r12));
            return;
        L10:
            return;
        }
    }

    static {
        f16249v = new a(null);
        f16251x = 28.0f;
        f16252y = 36;
    }

    public OPopoverLayout(Context r10, boolean r11, Function1 r12, int r13) {
        q.g(r10, "context");
        q.g(r12, "materials");
        this(r10, null, 0, r11, r12, r13);
    }

    public static final /* synthetic */ int a(OPopoverLayout r10) {
        return r10.f16267o;
    }

    public static final /* synthetic */ float b() {
        return f16251x;
    }

    public static final /* synthetic */ float c(OPopoverLayout r10) {
        return r10.f16253a;
    }

    public static final /* synthetic */ Rect d(OPopoverLayout r10) {
        return r10.f16261i;
    }

    public static final /* synthetic */ RectF e(OPopoverLayout r10) {
        return r10.f16262j;
    }

    public static /* synthetic */ void i(OPopoverLayout r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = Color.parseColor("#20000000");
    L5:
        r10.h(r11, r12);
    }

    private final void j() {
        if (this.f16270r == true) goto L6;
        return;
    L6:
        if (this.f16271s == true) goto L8;
        return;
    L8:
        com.obric.oui.material.b[] r10 = (com.obric.oui.material.b[]) this.f16272t.invoke(Boolean.valueOf(!isDarkTheme()));
        if (r10 == null) goto L13;
        o.j(this, r10, false, this.f16273u, null, 10, null);
        return;
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r10) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.dispatchDraw(r10);
        if (this.f16254b == true) goto L5;
        return;
    L5:
        RectF r11 = this.f16262j;
        Paint r12 = new Paint(1);
        r12.setColor(this.f16256d);
        float r13 = this.f16253a;
        r10.drawRoundRect(r11, r13, r13, r12);
    }

    public final void f(Context r10, AttributeSet r11) {
        q.g(r10, "context");
        this.f16259g = new Paint();
        this.f16260h = new Path();
        Paint r12 = this.f16259g;
        Paint r13 = null;
        if (r12 != null) goto L5;
        q.y("mFillPaint");
        r12 = null;
    L5:
        r12.setStyle(Paint.Style.FILL);
        Paint r14 = this.f16259g;
        if (r14 != null) goto L8;
        q.y("mFillPaint");
        r14 = null;
    L8:
        r14.setStrokeCap(Paint.Cap.BUTT);
        Paint r15 = this.f16259g;
        if (r15 != null) goto L11;
        q.y("mFillPaint");
        r15 = null;
    L11:
        boolean r16 = true;
        r15.setAntiAlias(true);
        Paint r17 = this.f16259g;
        if (r17 != null) goto L14;
        q.y("mFillPaint");
        r17 = null;
    L14:
        r17.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f16265m = ContextCompat.b(r10, R$color.oui_bg_base_3);
    L17:
        Paint r18 = this.f16259g;
        if (r18 != null) goto L20;
        q.y("mFillPaint");
    L21:
        r13.setColor(getMBgColor());
        setClipChildren(false);
        setOutlineProvider(new b(this));
        setClipToOutline(true);
        setBackgroundColor(0);
        if (o.f(this) == true) goto L24;
    L26:
        r16 = false;
    L27:
        this.f16271s = r16;
        j();
        return;
    L24:
        if (OMaterialHelper.w() == false) goto L26;
    L20:
        r13 = r18;
        goto L21
    }

    public final boolean g() {
        if (this.f16271s == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f16270r == false) goto L7;
        return true;
    }

    public final int getArrowHeight() {
        return f16250w;
    }

    public final float getCornerRadius() {
        return this.f16253a;
    }

    public final int getMBgColor() {
        int r10 = this.f16266n;
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return this.f16265m;
    }

    public final float getMHeight() {
        return this.f16264l;
    }

    public final float getMWidth() {
        return this.f16263k;
    }

    public final int getPadding() {
        return f16250w / 2;
    }

    public final void h(boolean r10, int r11) {
        this.f16254b = r10;
        this.f16255c = r11;
        this.f16257e = this.f16256d;
        invalidate();
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public boolean isDarkTheme() {
        if (getMBgColor() != 0) goto L7;
        return i.a(this);
    L7:
        return i0.c(getMBgColor());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OMaterialHelper.F(this, this.f16273u);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OMaterialHelper.F(this, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        Paint r11 = null;
        if (this.f16271s == true) goto L12;
        Paint r12 = this.f16259g;
        if (r12 != null) goto L7;
        q.y("mFillPaint");
        r12 = null;
    L7:
        r12.setColor(getMBgColor());
        RectF r13 = this.f16262j;
        float r14 = this.f16253a;
        Paint r15 = this.f16259g;
        if (r15 != null) goto L10;
        q.y("mFillPaint");
    L11:
        r10.drawRoundRect(r13, r14, r14, r11);
    L17:
        Paint r16 = this.f16269q;
        if (r16 != null) goto L21;
        return;
    L21:
        if (this.f16267o <= 0) goto L24;
        RectF r17 = this.f16262j;
        float r18 = this.f16253a;
        r10.drawRoundRect(r17, r18, r18, r16);
        return;
    L24:
        return;
    L10:
        r11 = r15;
        goto L11
    L12:
        Paint r19 = this.f16259g;
        if (r19 != null) goto L15;
        q.y("mFillPaint");
    L16:
        r11.getAlpha();
        goto L17
    L15:
        r11 = r19;
        goto L16
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f16254b == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        this.f16263k = getMeasuredWidth();
        this.f16264l = getMeasuredHeight();
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.f16254b == false) goto L6;
        return true;
    L6:
        return super.onTouchEvent(r10);
    }

    public final void setBgColor(@ColorInt int r10) {
        if (getMBgColor() != r10) goto L5;
        return;
    L5:
        this.f16265m = r10;
        Paint r11 = this.f16259g;
        if (r11 != null) goto L8;
        q.y("mFillPaint");
        r11 = null;
    L8:
        r11.setColor(getMBgColor());
        j();
    }

    public final void setBorderColor(int r10) {
        this.f16268p = r10;
        if (this.f16269q != null) goto L5;
        this.f16269q = new Paint(1);
    L5:
        Paint r11 = this.f16269q;
        if (r11 == null) goto L10;
        r11.setColor(this.f16268p);
        return;
    }

    public final void setBorderWidth(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f16267o = r10;
        if (this.f16269q != null) goto L7;
        this.f16269q = new Paint(1);
    L7:
        Paint r11 = this.f16269q;
        if (r11 == null) goto L12;
        r11.setStyle(Paint.Style.STROKE);
        r11.setStrokeWidth(this.f16267o);
        r11.setStrokeCap(Paint.Cap.BUTT);
        r11.setStrokeJoin(Paint.Join.MITER);
        r11.setAntiAlias(true);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        r11.setColor(this.f16268p);
        return;
    }

    public final void setCornerRadius(@Px float r10) {
        this.f16253a = r10;
    }

    public final void setCornerRadiusDp(float r10) {
        this.f16253a = tc.f.t(this, r10);
    }

    public final void setMBgColor(int r10) {
        this.f16265m = r10;
    }

    public final void setMHeight(float r10) {
        this.f16264l = r10;
    }

    public final void setMWidth(float r10) {
        this.f16263k = r10;
    }

    public final void setTransparentBg(boolean r10) {
        setClipToOutline(!r10);
        if (r10 == false) goto L5;
        this.f16265m = 0;
    L5:
        invalidateOutline();
        invalidate();
    }

    public OPopoverLayout(@NotNull Context r11, @Nullable AttributeSet r12) {
        q.g(r11, "context");
        int r10 = 0;
        boolean r13 = true;
        Function1 r14 = null;
        int r15 = 0;
        this(r11, r12, r10, r13, r14, r15, 48, null);
    }

    public OPopoverLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16253a = tc.f.t(this, f16251x);
        this.f16255c = Color.parseColor("#20000000");
        this.f16257e = this.f16256d;
        this.f16258f = new ArgbEvaluator();
        this.f16261i = new Rect();
        this.f16262j = new RectF();
        this.f16270r = true;
        this.f16272t = MaterialToken.OUI_Bg_Popup;
        this.f16273u = 3;
        f(r10, r11);
    }

    public /* synthetic */ OPopoverLayout(Context r10, AttributeSet r11, int r12, boolean r13, Function1 r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        r13 = true;
    L5:
        boolean r18 = r13;
        if ((r16 & 16) == 0) goto L8;
        r14 = MaterialToken.OUI_Bg_Popup;
    L8:
        Function1 r19 = r14;
        if ((r16 & 32) == 0) goto L11;
        r15 = 3;
    L11:
        this(r10, r11, r12, r18, r19, r15);
    }

    public OPopoverLayout(Context r10, AttributeSet r11, int r12, boolean r13, Function1 r14, int r15) {
        q.g(r10, "context");
        q.g(r14, "materials");
        super(r10, r11, r12);
        this.f16253a = tc.f.t(this, f16251x);
        this.f16255c = Color.parseColor("#20000000");
        this.f16257e = this.f16256d;
        this.f16258f = new ArgbEvaluator();
        this.f16261i = new Rect();
        this.f16262j = new RectF();
        this.f16270r = true;
        MaterialToken r16 = MaterialToken.INSTANCE;
        this.f16270r = r13;
        this.f16272t = r14;
        this.f16273u = r15;
        f(r10, r11);
    }
}

package com.obric.oui.filter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.l;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 ]2\u00020\u0001:\u00026^B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u000eJ\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u0015J\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\u0015J\u0015\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0014¢\u0006\u0004\b(\u0010)J7\u0010/\u001a\u00020\f2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0014¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\f2\u0006\u00102\u001a\u000201H\u0014¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\fH\u0002¢\u0006\u0004\b5\u0010\u000eJ\u0017\u00106\u001a\u00020\f2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b6\u00104R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00107R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00107R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00107R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00107R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010E\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00107R\u0018\u0010H\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010OR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010Z\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010KR\u0016\u0010\\\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010K¨\u0006_"}, d2 = {"Lcom/obric/oui/filter/OFilter;", "Lcom/obric/oui/filter/DrawableCenterButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "isAlwaysLightByCode", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "", "c", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "selected", "setSelected", "(Z)V", "style", "isAlwaysLight", "e", "(IZ)V", "getStyle", "()I", "d", "setAlwaysLight", "getIsAlwaysLight", "()Z", "enabled", "setEnabled", "Lcom/obric/oui/filter/OFilter$OnFilterSelectChangeListener;", "listener", "setSelectChangeListener", "(Lcom/obric/oui/filter/OFilter$OnFilterSelectChangeListener;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "b", "a", "I", "normalPaddingHorizontal", "normalPaddingVertical", "withIconPaddingHorizontal", "withIconPaddingVertical", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "drawable", "g", "Z", "showIcon", "h", "i", "tintAndTextColor", "j", "Lcom/obric/oui/filter/OFilter$OnFilterSelectChangeListener;", "onFilterSelectChangeListener", "", "k", "F", "paintStrokeWidth", "Landroid/graphics/Paint;", "l", "Landroid/graphics/Paint;", "bgPaint", "m", "strokePaint", "Landroid/graphics/RectF;", "n", "Landroid/graphics/RectF;", "bgRect", "o", "strokeRect", "p", "normalCornerRadiusPx", "q", "highlightCornerRadiusPx", "r", "OnFilterSelectChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OFilter extends DrawableCenterButton {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f14525r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f14531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OnFilterSelectChangeListener f14535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f14536k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f14537l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f14538m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f14539n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f14540o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f14541p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f14542q;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/filter/OFilter$OnFilterSelectChangeListener;", "", "onFilterSelectedChange", "", "filter", "Lcom/obric/oui/filter/OFilter;", "selected", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterSelectChangeListener {
        void onFilterSelectedChange(@NotNull OFilter r10, boolean r11);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f14525r = new a(null);
    }

    @JvmOverloads
    public OFilter(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        boolean r13 = false;
        this(r10, r11, r12, r13, 14, null);
    }

    private final void c() {
        this.f14541p = f.r(this, 4);
        this.f14542q = f.r(this, 8);
    }

    public final void a(Canvas r10) {
        r10.save();
        r10.translate(getScrollX() * 1.0f, getScrollY() * 1.0f);
        if (this.f14530e != 0) goto L5;
        float r11 = this.f14541p;
    L6:
        this.f14539n.set(0.0f, 0.0f, getWidth(), getHeight());
        l.i(r10, this.f14539n, r11, this.f14537l);
        if (this.f14530e != 1) goto L9;
        float r12 = this.f14536k * 0.5f;
        this.f14540o.set(r12, r12, getWidth() - r12, getHeight() - r12);
        l.i(r10, this.f14540o, r11, this.f14538m);
    L9:
        r10.restore();
        return;
    L5:
        r11 = this.f14542q;
        goto L6
    }

    public final void b() {
        if (this.f14532g == true) goto L5;
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        int r10 = this.f14526a;
        int r11 = this.f14527b;
        setPadding(r10, r11, r10, r11);
        setGravity(17);
        return;
    L5:
        if (this.f14531f != null) goto L11;
        Drawable r12 = ContextCompat.d(getContext(), R$drawable.o_arrow_forward_filter);
        if (r12 != null) goto L9;
        Drawable r13 = null;
    L10:
        this.f14531f = r13;
        goto L11
    L9:
        r13 = r12.mutate();
    L11:
        Drawable r14 = this.f14531f;
        q.d(r14);
        Drawable r15 = o.a.l(r14);
        o.a.j(r15, PorterDuff.Mode.SRC_IN);
        o.a.h(r15, ContextCompat.b(getContext(), this.f14534i));
        r15.setBounds(0, 0, r15.getIntrinsicWidth(), r15.getIntrinsicHeight());
        setGravity(8388629);
        setCompoundDrawablesWithIntrinsicBounds(null, null, r15, null);
        int r16 = this.f14528c;
        int r17 = this.f14529d;
        setPadding(r16, r17, r16, r17);
    }

    public final void d() {
        if (isEnabled() == true) goto L6;
        return;
    L6:
        if (this.f14530e != 1) goto L8;
        setMinHeight(f.r(this, 36));
    L10:
        if (isSelected() == false) goto L19;
        if (this.f14533h == false) goto L15;
        int r10 = R$color.primary;
        int r11 = R$color.BGBrand;
        this.f14534i = r10;
        setTypeface(null, 1);
    L26:
        this.f14537l.setColor(ContextCompat.b(getContext(), r11));
        this.f14538m.setColor(ContextCompat.b(getContext(), r10));
        setTextColor(ContextCompat.b(getContext(), this.f14534i));
        b();
        return;
    L15:
        if (this.f14530e != 1) goto L17;
        r10 = R$color.primary;
        this.f14534i = r10;
        r11 = R$color.Transparent;
        setTypeface(null, 1);
        goto L26
    L17:
        r10 = R$color.BGInput;
        this.f14534i = R$color.TextPrimary;
        setTypeface(null, 1);
        r11 = r10;
        goto L26
    L19:
        if (this.f14533h == false) goto L23;
        r10 = R$color.LineReverse2;
        this.f14534i = R$color.TextReverse;
        int r12 = R$color.Transparent;
        setTypeface(null, 0);
    L21:
        r11 = r12;
        goto L26
    L23:
        if (this.f14530e != 1) goto L25;
        r10 = R$color.oui_basic_text_2;
        this.f14534i = r10;
        r12 = R$color.Transparent;
        setTypeface(null, 0);
        goto L21
    L25:
        r10 = R$color.oui_basic_text_2;
        this.f14534i = r10;
        r12 = R$color.oui_basic_text_4;
        setTypeface(null, 0);
        goto L21
    L8:
        setMinHeight(-1);
        goto L10
    }

    public final void e(int r10, boolean r11) {
        this.f14530e = r10;
        this.f14533h = r11;
        d();
    }

    public final boolean getIsAlwaysLight() {
        return this.f14533h;
    }

    public final int getStyle() {
        return this.f14530e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        c();
        invalidate();
    }

    @Override // com.obric.oui.filter.DrawableCenterButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        a(r10);
        super.onDraw(r10);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setAlwaysLight(boolean r10) {
        this.f14533h = r10;
        d();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L5;
        setAlpha(1.0f);
        d();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setSelectChangeListener(@NotNull OnFilterSelectChangeListener r10) {
        q.g(r10, "listener");
        this.f14535j = r10;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        d();
        OnFilterSelectChangeListener r11 = this.f14535j;
        if (r11 == null) goto L7;
        r11.onFilterSelectedChange(this, r10);
        return;
    }

    @JvmOverloads
    public OFilter(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        boolean r13 = false;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OFilter(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        boolean r13 = false;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OFilter(Context r10, AttributeSet r11, int r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = false;
    L11:
        this(r10, r11, r12, r13);
    }

    public OFilter(Context r10, AttributeSet r11, int r12, boolean r13) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f14526a = f.r(this, 12);
        this.f14527b = f.r(this, 5);
        this.f14528c = f.r(this, 16);
        this.f14529d = f.r(this, 7);
        float r14 = f.p(this, 0.5d);
        this.f14536k = r14;
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.FILL);
        this.f14537l = r15;
        Paint r16 = new Paint(1);
        r16.setStyle(Paint.Style.STROKE);
        r16.setStrokeWidth(r14);
        this.f14538m = r16;
        this.f14539n = new RectF();
        this.f14540o = new RectF();
        c();
        TypedArray r17 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OFilter, r12, 0);
        this.f14530e = r17.getInt(R$styleable.OFilter_oui_filterStyle, 0);     // Catch: Throwable -> L6
        this.f14532g = r17.getBoolean(R$styleable.OFilter_showIcon, false);     // Catch: Throwable -> L6
        this.f14533h = r17.getBoolean(R$styleable.OFilter_oui_isAlwaysLight, r13);     // Catch: Throwable -> L6
        r17.recycle();
        setSingleLine();
        setTextSize(0, r10.getResources().getDimension(R$dimen.oui_filter_text_size));
        setCompoundDrawablePadding(r10.getResources().getDimensionPixelSize(R$dimen.oui_filter_drawable_padding));
        setGravity(17);
        d();
        return;
    L6:
        th = move-exception;
        r17.recycle();
        throw th;
    }
}

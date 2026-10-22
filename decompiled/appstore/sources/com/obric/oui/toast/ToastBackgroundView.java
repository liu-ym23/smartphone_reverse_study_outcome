package com.obric.oui.toast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.oui.color.i0;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import td.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 22\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010 R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001dR\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010\u001dR\u0016\u0010/\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.¨\u00063"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", Style.KEY_HEIGHT, "materialSrcType", "Landroid/view/View;", "materialBackdropTarget", "", "c", "(IILandroid/view/View;)V", "getCornerRadius", "()I", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "a", "()Z", "originBgColor", "b", "(Ljava/lang/Integer;)V", "I", "cornerRadius", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rectF", Style.KEY_BG_COLOR, "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "bgPaint", "e", "strokePaint", "f", "borderWidth", "g", "borderColor", "h", "Z", "drawSelf", "i", "enableMaterial", "j", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToastBackgroundView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f17599j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f17601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f17603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f17604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f17608i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f17599j = new a(null);
    }

    @JvmOverloads
    public ToastBackgroundView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void d(ToastBackgroundView r10, int r11, int r12, View r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 3;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = null;
    L8:
        r10.c(r11, r12, r13);
    }

    public final boolean a() {
        int r10 = this.f17602c;
        if (r10 != 0) goto L7;
        return i.a(this);
    L7:
        return i0.c(r10);
    }

    public final void b(Integer r10) {
        if (r10 != null) goto L5;
        int r11 = androidx.core.content.res.a.d(getResources(), R$color.oui_toast_background, getContext().getTheme());
        if (this.f17603d.getColor() == r11) goto L13;
        this.f17603d.setColor(r11);
        this.f17602c = r11;
        L.a("ToastBackgroundView", q.p("resolveColors: bg=", Integer.valueOf(r11)));
        return;
    L13:
        return;
    L5:
        if (this.f17603d.getColor() == r10.intValue()) goto L12;
        this.f17603d.setColor(r10.intValue());
        this.f17602c = r10.intValue();
        L.a("ToastBackgroundView", "resolveColors: bg=" + r10 + " from originBgColor");
        return;
    }

    public final void c(int r10, int r11, View r12) {
        if (this.f17608i == false) goto L7;
        this.f17607h = false;
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(0);
        r13.setCornerRadius(this.f17600a);
        r13.setColor(0);
        setBackground(r13);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        o.j(this, MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!a())), false, r11, null, 10, null);
        o.n(this, r12);
        return;
    L7:
        if (r10 != (this.f17600a * 2)) goto L9;
        setBackground(androidx.core.content.res.a.f(getResources(), R$drawable.o_toast_background_capsule_form, getContext().getTheme()));
        this.f17607h = false;
    L10:
        L.a("ToastBackgroundView", "setupBackground: drawSelf = " + this.f17607h + ", height = " + r10);
        invalidate();
        return;
    L9:
        this.f17607h = true;
        goto L10
    }

    public final int getCornerRadius() {
        return this.f17600a;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        float r11 = this.f17600a * 1.0f;
        this.f17601b.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.f17607h == false) goto L5;
        r10.drawRoundRect(this.f17601b, r11, r11, this.f17603d);
    L5:
        int r12 = this.f17605f;
        if (r12 <= 0) goto L8;
        this.f17604e.setStrokeWidth(r12);
        this.f17604e.setColor(this.f17606g);
        r10.drawRoundRect(this.f17601b, r11, r11, this.f17604e);
    L8:
        super.onDraw(r10);
    }

    @JvmOverloads
    public final void setupBackground(int r10) {
        d(this, r10, 0, null, 6, null);
    }

    @JvmOverloads
    public ToastBackgroundView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ToastBackgroundView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ToastBackgroundView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17600a = f.q(this, 24.0f);
        this.f17601b = new RectF();
        boolean r13 = true;
        Paint r14 = new Paint(1);
        r14.setStyle(Paint.Style.FILL);
        this.f17603d = r14;
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.STROKE);
        this.f17604e = r15;
        if (o.e(r10) == true) goto L5;
    L7:
        r13 = false;
    L8:
        this.f17608i = r13;
        Integer r16 = i.b(this);
        setBackgroundColor(0);
        b(r16);
        return;
    L5:
        if (OMaterialHelper.w() == false) goto L7;
        goto L7
    }
}

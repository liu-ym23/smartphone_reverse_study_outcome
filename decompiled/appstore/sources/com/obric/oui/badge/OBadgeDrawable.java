package com.obric.oui.badge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$color;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.threeten.bp.chrono.HijrahDate;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class OBadgeDrawable extends Drawable {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a f12389J = null;
    public int A;
    public BadgeGravity B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public float H;
    public CharSequence I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f12393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f12394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f12395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12399j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12400k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f12401l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextPaint f12402m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f12403n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f12404o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12405p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12406q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f12407r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f12408s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12409t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12410u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Rect f12411v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f12412w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f12413x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f12414y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f12415z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "", "(Ljava/lang/String;I)V", "TOP_START", "TOP_END", "CENTER", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BadgeGravity extends Enum<BadgeGravity> {
        private static final /* synthetic */ BadgeGravity[] $VALUES = null;
        public static final BadgeGravity CENTER = null;
        public static final BadgeGravity TOP_END = null;
        public static final BadgeGravity TOP_START = null;

        private static final /* synthetic */ BadgeGravity[] $values() {
            return new BadgeGravity[]{TOP_START, TOP_END, CENTER};
        }

        static {
            TOP_START = new BadgeGravity("TOP_START", 0);
            TOP_END = new BadgeGravity("TOP_END", 1);
            CENTER = new BadgeGravity("CENTER", 2);
            $VALUES = $values();
        }

        private BadgeGravity(String r10, int r11) {
            super(r10, r11);
        }

        public static BadgeGravity valueOf(String r10) {
            return (BadgeGravity) Enum.valueOf(BadgeGravity.class, r10);
        }

        public static BadgeGravity[] values() {
            return (BadgeGravity[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final OBadgeDrawable a(Context r10) {
            q.g(r10, "context");
            return new OBadgeDrawable(r10, null);
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12416a = null;

        static {
            int[] r10 = new int[BadgeGravity.values().length];
            r10[BadgeGravity.TOP_START.ordinal()] = 1;
            r10[BadgeGravity.TOP_END.ordinal()] = 2;
            r10[BadgeGravity.CENTER.ordinal()] = 3;
            f12416a = r10;
        }
    }

    static {
        f12389J = new a(null);
    }

    public /* synthetic */ OBadgeDrawable(Context r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public final void a(String r10) {
        if (b() == null) goto L10;
        Integer r11 = b();
        if (r11 != null) goto L8;
    L9:
        this.f12407r = this.f12398i;
        this.f12408s = this.f12399j;
        return;
    L8:
        if (r11.intValue() != 0) goto L9;
    L10:
        if (r10 != null) goto L12;
    L18:
        float r12 = this.f12393d;
        this.f12407r = r12;
        this.f12408s = r12;
        return;
    L12:
        if (r10.length() == 0) goto L18;
        this.f12402m.getTextBounds(r10, 0, r10.length(), this.f12403n);
        float r13 = this.f12403n.width() + this.f12400k;
        float r14 = this.f12391b;
        float r15 = this.f12395f;
        float r16 = h.c(r13 + (2 * r14), r15);
        if (r16 > r15) goto L17;
        float r17 = Math.max(r16, r15);
        this.f12407r = r17;
        this.f12408s = r17;
        return;
    L17:
        this.f12407r = r16;
        this.f12408s = r15;
    }

    public final Integer b() {
        return this.f12415z;
    }

    public final int c() {
        return this.A;
    }

    public final int d() {
        return this.D;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        if (isVisible() == true) goto L6;
        return;
    L6:
        if (this.f12410u == true) goto L9;
        return;
    L9:
        if (this.f12409t == false) goto L12;
        s();
    L12:
        if (this.f12407r > 0.0f) goto L14;
        return;
    L14:
        if (this.f12408s <= 0.0f) goto L34;
        this.f12404o.set(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        float r11 = this.f12408s / 2.0f;
        r10.drawRoundRect(this.f12404o, r11, r11, this.f12401l);
        String r12 = this.f12414y;
        if (r12 == null) goto L23;
        if (r12.length() == 0) goto L23;
        r10.drawText(r12, this.f12404o.centerX(), this.f12404o.centerY() - ((this.f12402m.ascent() + this.f12402m.descent()) / 2.0f), this.f12402m);
    L23:
        if (b() == null) goto L32;
        Integer r13 = b();
        if (r13 != null) goto L28;
    L29:
        float r14 = this.f12404o.centerX();
        float r15 = this.f12404o.centerY();
        float r16 = this.f12396g;
        Paint r17 = new Paint();
        Integer r18 = b();
        q.d(r18);
        r17.setColor(r18.intValue());
        r17.setAntiAlias(true);
        r10.drawCircle(r14, r15, r16, r17);
        r10.drawCircle(r14 - this.f12397h, r15, r16, r17);
        r10.drawCircle(r14 + this.f12397h, r15, r16, r17);
        return;
    L28:
        if (r13.intValue() != 0) goto L29;
        return;
    L32:
        return;
    }

    public final void e() {
        this.f12409t = true;
        invalidateSelf();
        View r10 = this.f12412w;
        if (r10 == null) goto L6;
        q.d(r10);
        r(r10, this.f12413x);
        return;
    }

    public final String f(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L15;
    L13:
        return r10;
    L15:
        Integer r11 = Integer.valueOf(String.valueOf(r10));     // Catch: Exception -> L11
        q.f(r11, "integer");     // Catch: Exception -> L11
        if (r11.intValue() <= this.A) goto L8;
        StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L11
        r12.append(this.A);     // Catch: Exception -> L11
        r12.append('+');     // Catch: Exception -> L11
        r10 = r12.toString();     // Catch: Exception -> L11
    L14:
    L8:
        if (r11.intValue() >= 0) goto L14;
        r10 = "";
    L12:
        throw new IllegalArgumentException(q.p("Excepted a int but get ", this.f12414y));
    }

    public final void g(int r10) {
        if (this.E != r10) goto L5;
        return;
    L5:
        this.E = r10;
        this.f12401l.setColor(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(BadgeGravity r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        if (this.B != r10) goto L5;
        return;
    L5:
        this.B = r10;
        e();
    }

    public final void i(String r10) {
        if (q.b(this.f12414y, r10) == false) goto L5;
        return;
    L5:
        String r11 = f(r10);
        this.f12414y = r11;
        if (r11 == null) goto L10;
        q.d(r11);
        if (r11.length() <= 0) goto L10;
        this.f12415z = null;
    L10:
        e();
    }

    public final void j(int r10) {
        if (this.F != r10) goto L5;
        return;
    L5:
        this.F = r10;
        this.f12402m.setColor(r10);
        invalidateSelf();
    }

    public final void k(CharSequence r10) {
        this.I = r10;
    }

    public final void l(Integer r10) {
        if (q.b(this.f12415z, r10) == false) goto L5;
        return;
    L5:
        this.f12415z = r10;
        this.f12414y = null;
        e();
    }

    public final void m(boolean r10) {
        if (this.G != r10) goto L5;
        return;
    L5:
        this.G = r10;
        DisplayMetrics r11 = this.f12390a.getResources().getDisplayMetrics();
        TextPaint r12 = this.f12402m;
        if (this.G == false) goto L8;
        float r13 = TypedValue.applyDimension(2, this.H, r11);
    L9:
        r12.setTextSize(r13);
        e();
        return;
    L8:
        r13 = TypedValue.applyDimension(1, this.H, r11);
        goto L9
    }

    public final void n(int r10) {
        if (r10 >= 1) goto L6;
        r10 = 1;
    L6:
        if (this.A != r10) goto L8;
        return;
    L8:
        this.A = r10;
        this.f12414y = f(this.f12414y);
        e();
    }

    public final void o(float r10) {
        if (this.H != r10) goto L5;
        return;
    L5:
        this.H = r10;
        DisplayMetrics r11 = this.f12390a.getResources().getDisplayMetrics();
        TextPaint r12 = this.f12402m;
        if (this.G == false) goto L8;
        float r13 = TypedValue.applyDimension(2, this.H, r11);
    L9:
        r12.setTextSize(r13);
        e();
        return;
    L8:
        r13 = TypedValue.applyDimension(1, this.H, r11);
        goto L9
    }

    public final void p(int r10) {
        if (this.D != r10) goto L5;
        return;
    L5:
        this.D = r10;
        e();
    }

    public final void q(View r10) {
        q.g(r10, "anchor");
        r(r10, null);
    }

    public final void r(View r10, View r11) {
        q.g(r10, "anchor");
        this.f12412w = r10;
        this.f12413x = r11;
        Rect r12 = new Rect();
        boolean r13 = false;
        if (r11 == null) goto L5;
        int[] r14 = new int[2];
        int[] r15 = new int[2];
        r10.getLocationInWindow(r14);
        r11.getLocationInWindow(r15);
        int r16 = r14[0] - r15[0];
        int r17 = r14[1] - r15[1];
        r12.set(r16, r17, r10.getWidth() + r16, r10.getHeight() + r17);
    L6:
        this.f12411v = new Rect(r12);
        if (ViewCompat.A(r10) != 1) goto L9;
        r13 = true;
    L9:
        BadgeGravity r18 = this.B;
        int[] r19 = b.f12416a;
        int r20 = r19[r18.ordinal()];
        if (r20 == 1) goto L19;
        if (r20 == 2) goto L16;
        if (r20 != 3) goto L15;
        int r21 = r12.right;
        int r22 = r21 - ((r21 - r12.left) / 2);
    L23:
        if (r19[this.B.ordinal()] != 3) goto L25;
        int r23 = r12.bottom;
        int r24 = r23 - ((r23 - r12.top) / 2);
    L26:
        this.f12405p = r22 + this.C;
        this.f12406q = r24 + this.D;
        this.f12410u = true;
        this.f12409t = true;
        s();
        return;
    L25:
        r24 = r12.top;
        goto L26
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r13 == false) goto L18;
        r22 = r12.left;
        goto L23
    L18:
        r22 = r12.right;
        goto L23
    L19:
        if (r13 == false) goto L21;
        r22 = r12.right;
        goto L23
    L21:
        r22 = r12.left;
        goto L23
    L5:
        r10.getDrawingRect(r12);
        goto L6
    }

    public final void s() {
        if (this.f12410u == true) goto L5;
        return;
    L5:
        a(this.f12414y);
        float r10 = this.f12407r / 2.0f;
        float r11 = this.f12408s / 2.0f;
        int r12 = yf.b.b(this.f12405p - r10);
        int r13 = yf.b.b(this.f12406q - r11);
        int r14 = yf.b.b(this.f12405p + r10);
        int r15 = yf.b.b(this.f12406q + r11);
        Rect r16 = this.f12411v;
        if (r16 == null) goto L21;
        float r17 = this.f12394e;
        int r18 = b.f12416a[this.B.ordinal()];
        if (r18 != 1) goto L10;
        float r19 = r16.left - r12;
        if (r19 <= r17) goto L18;
        int r20 = yf.b.b(r19 - r17);
        r12 = r12 + r20;
        r14 = r14 + r20;
    L18:
        float r21 = r16.top - r13;
        if (r21 <= r17) goto L21;
        int r22 = yf.b.b(r21 - r17);
        r13 = r13 + r22;
        r15 = r15 + r22;
        goto L21
    L10:
        if (r18 != 2) goto L18;
        float r23 = r14 - r16.right;
        if (r23 <= r17) goto L18;
        int r24 = yf.b.b(r23 - r17);
        r12 = r12 - r24;
        r14 = r14 - r24;
    L21:
        setBounds(r12, r13, r14, r15);
        this.f12409t = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.f12401l.setAlpha(r10);
        this.f12402m.setAlpha(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.f12401l.setColorFilter(r10);
        this.f12402m.setColorFilter(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        boolean r12 = super.setVisible(r10, r11);
        if (r12 == false) goto L5;
        invalidateSelf();
    L5:
        return r12;
    }

    public OBadgeDrawable(Context r10) {
        this.f12390a = r10;
        this.f12391b = f.d(r10, 4.0f);
        this.f12392c = f.d(r10, 4.0f);
        this.f12393d = f.d(r10, 8.0f);
        this.f12394e = f.d(r10, 5.0f);
        this.f12395f = f.d(r10, 18.0f);
        this.f12396g = f.c(r10, 1.5d);
        this.f12397h = f.e(r10, 5);
        this.f12398i = f.d(r10, 23.0f);
        this.f12399j = f.d(r10, 18.0f);
        this.f12400k = f.d(r10, 1.0f);
        Paint r11 = new Paint(1);
        r11.setStyle(Paint.Style.FILL);
        int r12 = R$color.oui_red_6;
        r11.setColor(ContextCompat.b(r10, r12));
        this.f12401l = r11;
        TextPaint r13 = new TextPaint(1);
        r13.setTextAlign(Paint.Align.CENTER);
        r13.setTypeface(Typeface.create(r13.getTypeface(), 500, false));
        int r14 = R$color.white;
        r13.setColor(ContextCompat.b(r10, r14));
        r13.setTextSize(f.f(r10, 12.0f));
        this.f12402m = r13;
        this.f12403n = new Rect();
        this.f12404o = new RectF();
        this.f12409t = true;
        this.A = HijrahDate.MAX_VALUE_OF_ERA;
        this.B = BadgeGravity.TOP_END;
        this.E = ContextCompat.b(r10, r12);
        this.F = ContextCompat.b(r10, r14);
        this.G = true;
        this.H = 12.0f;
    }
}

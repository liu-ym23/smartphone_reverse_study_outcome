package ac1;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f2550h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f2551i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f2552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f2553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StaticLayout f2554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Layout.Alignment f2555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f2556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f2557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f2558g;

    static {
        f2550h = new int[]{R.attr.textAppearance};
        f2551i = new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor};
    }

    public final void a() {
        StaticLayout r110 = new StaticLayout(this.f2558g, this.f2553b, (int) Math.ceil(Layout.getDesiredWidth(this.f2558g, this.f2553b)), this.f2555d, 1.0f, 0.0f, true);
        this.f2554c = r110;
        this.f2557f.set(0, 0, r110.getWidth(), this.f2554c.getHeight());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        if (this.f2557f.isEmpty() == false) goto L6;
        return -1;
    L6:
        Rect r100 = this.f2557f;
        return r100.bottom - r100.top;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        if (this.f2557f.isEmpty() == false) goto L6;
        return -1;
    L6:
        Rect r100 = this.f2557f;
        return r100.right - r100.left;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f2553b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f2556e.isStateful();
    }

    public a(Context r110) {
        this.f2555d = Layout.Alignment.ALIGN_NORMAL;
        this.f2558g = "";
        Resources r100 = r110.getResources();
        this.f2552a = r100;
        this.f2557f = new Rect();
        boolean r101 = true;
        TextPaint r102 = new TextPaint(1);
        this.f2553b = r102;
        r102.density = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        r102.setDither(true);
        TypedArray r103 = r110.getTheme().obtainStyledAttributes(f2550h);
        int r104 = r103.getResourceId(0, -1);
        r103.recycle();
        Typeface r105 = null;
        if (r104 == (-1)) goto L5;
        TypedArray r111 = r110.obtainStyledAttributes(r104, f2551i);
    L6:
        int r106 = 15;
        ColorStateList r112 = null;
        if (r111 == null) goto L23;
        int r107 = 0;
        int r108 = -1;
        int r113 = -1;
    L10:
        if (r107 >= r111.getIndexCount()) goto L22;
        int r114 = r111.getIndex(r107);
        if (r114 == 0) goto L20;
        if (r114 == 1) goto L19;
        if (r114 == 2) goto L18;
        if (r114 != 3) goto L21;
        r112 = r103.getColorStateList(r114);
    L21:
        r107 = r107 + 1;
        goto L10
    L18:
        r113 = r103.getInt(r114, r113);
        goto L21
    L19:
        r108 = r103.getInt(r114, r108);
        goto L21
    L20:
        r106 = r103.getDimensionPixelSize(r114, r106);
        goto L21
    L22:
        r111.recycle();
    L24:
        if (r112 != null) goto L27;
        r112 = ColorStateList.valueOf(-16777216);
    L27:
        this.f2556e = r112;
        int r115 = this.f2556e.getColorForState(getState(), -1);
        if (this.f2553b.getColor() == r115) goto L30;
        this.f2553b.setColor(r115);
    L30:
        float r116 = r106;
        if (r116 == this.f2553b.getTextSize()) goto L33;
        this.f2553b.setTextSize(r116);
        a();
    L33:
        if (r108 == 1) goto L39;
        if (r108 == 2) goto L38;
        if (r108 != 3) goto L40;
        r105 = Typeface.MONOSPACE;
    L40:
        float r117 = 0.0f;
        if (r113 <= 0) goto L57;
        if (r105 != null) goto L44;
        Typeface r109 = Typeface.defaultFromStyle(r113);
    L45:
        b(r109);
        if (r109 == null) goto L48;
        int r118 = r109.getStyle();
    L49:
        int r119 = (~r118) & r113;
        TextPaint r120 = this.f2553b;
        if ((r119 & 1) != 0) goto L53;
        r101 = false;
    L53:
        r120.setFakeBoldText(r101);
        TextPaint r121 = this.f2553b;
        if ((r119 & 2) == 0) goto L56;
        r117 = -0.25f;
    L56:
        r121.setTextSkewX(r117);
        return;
    L48:
        r118 = 0;
        goto L49
    L44:
        r109 = Typeface.create(r105, r113);
        goto L45
    L57:
        this.f2553b.setFakeBoldText(false);
        this.f2553b.setTextSkewX(0.0f);
        b(r105);
        return;
    L38:
        r105 = Typeface.SERIF;
        goto L40
    L39:
        r105 = Typeface.SANS_SERIF;
        goto L40
    L23:
        r108 = -1;
        r113 = -1;
        goto L24
    L5:
        r111 = null;
        goto L6
    }

    public final void b(Typeface r100) {
        if (this.f2553b.getTypeface() == r100) goto L6;
        this.f2553b.setTypeface(r100);
        a();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Rect r101 = getBounds();
        int r102 = r100.save();
        r100.translate(r101.left, r101.top);
        this.f2554c.draw(r100);
        r100.restoreToCount(r102);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        this.f2557f.set(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r100) {
        int r101 = this.f2556e.getColorForState(r100, -1);
        if (this.f2553b.getColor() == r101) goto L5;
        this.f2553b.setColor(r101);
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        if (this.f2553b.getAlpha() == r100) goto L6;
        this.f2553b.setAlpha(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        if (this.f2553b.getColorFilter() == r100) goto L6;
        this.f2553b.setColorFilter(r100);
        return;
    }
}

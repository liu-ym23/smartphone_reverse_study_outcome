package ed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0246a f19392m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f19394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f19395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f19397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f19399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f19400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f19401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f19402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f19403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f19404l;

    /* JADX INFO: renamed from: ed.a$a, reason: collision with other inner class name */
    public static final class C0246a {
        public /* synthetic */ C0246a(DefaultConstructorMarker r10) {
            this();
        }

        public C0246a() {
        }
    }

    static {
        f19392m = new C0246a(null);
    }

    public /* synthetic */ a(Context r10, Drawable r11, Integer r12, int r13, float r14, boolean r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        r12 = null;
    L5:
        Integer r18 = r12;
        if ((r16 & 8) == 0) goto L8;
        r13 = r10.getColor(R$color.oui_line_1);
    L8:
        int r19 = r13;
        if ((r16 & 16) == 0) goto L11;
        r14 = r10.getResources().getDimension(R$dimen.oui_image_stroke_width);
    L11:
        float r20 = r14;
        if ((r16 & 32) == 0) goto L14;
        r15 = false;
    L14:
        this(r10, r11, r18, r19, r20, r15);
    }

    public final void a(Canvas r10) {
        if (this.f19402j.isEmpty() == false) goto L6;
        Log.w("OImageAppIcon", "draw skipped mask because maskPath is empty");
        this.f19394b.draw(r10);
        return;
    L6:
        int r11 = r10.save();
        r10.clipPath(this.f19402j);
        b(r10);
        this.f19394b.draw(r10);
        float r12 = this.f19397e;
        if (r12 > 0.0f) goto L10;
        Log.d("OImageAppIcon", q.p("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r12)));
        r10.restoreToCount(r11);
        return;
    L10:
        this.f19399g.setStrokeWidth(r12 * 2);
        this.f19399g.setStrokeJoin(Paint.Join.ROUND);
        this.f19399g.setStrokeCap(Paint.Cap.ROUND);
        r10.drawPath(this.f19402j, this.f19399g);
        r10.restoreToCount(r11);
    }

    public final void b(Canvas r10) {
        if (this.f19395c != null) goto L6;
        return;
    L6:
        if (this.f19402j.isEmpty() == false) goto L10;
        Log.w("OImageAppIcon", "draw skipped background because maskPath is empty");
        return;
    L10:
        if (this.f19401i == false) goto L12;
        Path r11 = this.f19403k;
    L13:
        r10.drawPath(r11, this.f19400h);
        return;
    L12:
        r11 = this.f19402j;
        goto L13
    }

    public final void c(Canvas r10) {
        b(r10);
        this.f19394b.draw(r10);
        if (this.f19402j.isEmpty() == false) goto L6;
        Log.w("OImageAppIcon", "draw skipped stroke because maskPath is empty");
        return;
    L6:
        float r11 = this.f19397e;
        if (r11 > 0.0f) goto L10;
        Log.d("OImageAppIcon", q.p("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r11)));
        return;
    L10:
        int r12 = r10.save();
        r10.clipPath(this.f19402j);
        this.f19399g.setStrokeWidth(this.f19397e * 2);
        this.f19399g.setStrokeJoin(Paint.Join.ROUND);
        this.f19399g.setStrokeCap(Paint.Cap.ROUND);
        r10.drawPath(this.f19402j, this.f19399g);
        r10.restoreToCount(r12);
    }

    public final void d() {
        this.f19402j.reset();
        this.f19403k.reset();
        if (getBounds().isEmpty() == false) goto L6;
        Log.w("OImageAppIcon", "refreshMaskPath skipped because bounds is empty, check if in whitelist");
        return;
    L6:
        Path r10 = new AdaptiveIconDrawable(null, null, null).getIconMask();
        if (r10.isEmpty() == false) goto L10;
        Log.w("OImageAppIcon", "refreshMaskPath found empty icon mask");
        return;
    L10:
        float r11 = getBounds().width();
        float r12 = getBounds().height();
        float r13 = Math.min(r11, r12);
        float r14 = 0.0f;
        if (r11 <= r12) goto L13;
        float r15 = (r11 - r12) / 2.0f;
    L15:
        if (r12 <= r11) goto L17;
        r14 = (r12 - r11) / 2.0f;
    L17:
        this.f19404l.reset();
        float r16 = r13 / 100.0f;
        this.f19404l.setScale(r16, r16);
        this.f19402j.set(r10);
        this.f19402j.transform(this.f19404l);
        this.f19402j.offset(getBounds().left + r15, getBounds().top + r14);
        float r17 = this.f19397e + 1;
        this.f19404l.reset();
        float r18 = (r13 - (2.0f * r17)) / 100.0f;
        this.f19404l.setScale(r18, r18);
        this.f19403k.set(r10);
        this.f19403k.transform(this.f19404l);
        this.f19403k.offset((getBounds().left + r15) + r17, (getBounds().top + r14) + r17);
        return;
    L13:
        r15 = 0.0f;
        goto L15
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        if (this.f19398f == true) goto L6;
        c(r10);
        return;
    L6:
        a(r10);
    }

    public final void e(boolean r10) {
        if (this.f19398f != r10) goto L5;
        return;
    L5:
        this.f19398f = r10;
        invalidateSelf();
    }

    public final void f(Integer r10) {
        if (q.b(this.f19395c, r10) == false) goto L5;
        return;
    L5:
        this.f19395c = r10;
        if (r10 == null) goto L8;
        boolean r11 = true;
    L9:
        this.f19401i = r11;
        Log.d("OImageAppIcon", q.p("backgroundAvoidsStroke =  ", Boolean.valueOf(r11)));
        if (r10 == null) goto L13;
        int r12 = r10.intValue();
        this.f19400h.setColor(r12);
    L13:
        invalidateSelf();
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void g(int r10) {
        if (this.f19396d != r10) goto L5;
        return;
    L5:
        this.f19396d = r10;
        this.f19399g.setColor(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f19394b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r10) {
        q.g(r10, "bounds");
        super.onBoundsChange(r10);
        this.f19394b.setBounds(r10);
        d();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.f19394b.setAlpha(r10);
        this.f19400h.setAlpha(r10);
        this.f19399g.setAlpha(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.f19394b.setColorFilter(r10);
        this.f19400h.setColorFilter(r10);
        this.f19399g.setColorFilter(r10);
        invalidateSelf();
    }

    public a(Context r10, Drawable r11, Integer r12, int r13, float r14, boolean r15) {
        q.g(r10, "context");
        q.g(r11, ServerElements.ICON);
        this.f19393a = r10;
        this.f19394b = r11;
        this.f19395c = r12;
        this.f19396d = r13;
        this.f19397e = r14;
        this.f19398f = r15;
        Paint r16 = new Paint(1);
        r16.setStyle(Paint.Style.STROKE);
        r16.setColor(this.f19396d);
        this.f19399g = r16;
        Paint r17 = new Paint(1);
        r17.setStyle(Paint.Style.FILL);
        this.f19400h = r17;
        this.f19402j = new Path();
        this.f19403k = new Path();
        this.f19404l = new Matrix();
        Integer r18 = this.f19395c;
        if (r18 == null) goto L6;
        r17.setColor(r18.intValue());
    L6:
        d();
    }
}

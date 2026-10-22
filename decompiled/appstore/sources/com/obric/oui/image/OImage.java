package com.obric.oui.image;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import bg.h;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import ed.b;
import ed.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010&\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010,R\u0014\u00106\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010,R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/obric/oui/image/OImage;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/image/OImageShape;", "shape", "", "setImageShape", "(Lcom/obric/oui/image/OImageShape;)V", "", "radiusDp", "setRadiusDp", "(F)V", "radiusPx", "setRadiusPx", "getImageShape", "()Lcom/obric/oui/image/OImageShape;", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Path;", "a", "Landroid/graphics/Path;", "clipPath", "Landroid/graphics/RectF;", "b", "Landroid/graphics/RectF;", "clipRect", "c", "contentRect", "d", "strokeRect", "Led/b;", "e", "Led/b;", "styleConfig", "f", "F", "roundedRadiusPx", "g", "styleRadiusPx", "h", "Lcom/obric/oui/image/OImageShape;", "imageShape", "i", "effectiveRadiusPx", "j", "strokeWidthPx", "Landroid/graphics/Paint;", "k", "Landroid/graphics/Paint;", "strokePaint", "l", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OImage extends AppCompatImageView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f14851l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f14852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f14853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f14854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f14855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f14856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f14857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f14858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OImageShape f14859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f14860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f14861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f14862k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f14851l = new a(null);
    }

    @JvmOverloads
    public OImage(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @NotNull
    public final OImageShape getImageShape() {
        return this.f14859h;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        float r11 = getWidth();
        float r12 = getHeight();
        if (r11 > 0.0f) goto L5;
    L31:
        Log.w("OImage", "Skip draw due to invalid size width=" + r11 + " height=" + r12);
        return;
    L5:
        if (r12 <= 0.0f) goto L31;
        this.f14853b.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.f14853b.isEmpty() == false) goto L11;
        Log.w("OImage", q.p("Skip draw due to empty clip bounds rect=", this.f14853b));
        return;
    L11:
        boolean r13 = this.f14856e.e();
        if (r13 == false) goto L14;
        float r14 = h.c(this.f14860i - this.f14861j, 0.0f);
    L15:
        if (r13 == false) goto L21;
        this.f14854c.set(this.f14853b);
        RectF r15 = this.f14854c;
        float r16 = this.f14861j;
        r15.inset(r16, r16);
        if (this.f14854c.isEmpty() == false) goto L20;
        Log.w("OImage", q.p("Stroke ON but skip content draw due to empty content bounds rect=", this.f14854c));
        return;
    L20:
        RectF r17 = this.f14854c;
    L22:
        this.f14852a.reset();
        this.f14852a.addRoundRect(r17, r14, r14, Path.Direction.CW);
        int r18 = r10.save();
        r10.clipPath(this.f14852a);
        super.onDraw(r10);
        r10.restoreToCount(r18);
        if (r13 == true) goto L25;
        return;
    L25:
        this.f14855d.set(this.f14853b);
        float r19 = this.f14861j / 2.0f;
        this.f14855d.inset(r19, r19);
        if (this.f14855d.isEmpty() == false) goto L29;
        Log.w("OImage", q.p("Stroke ON but skip due to empty stroke bounds rect=", this.f14855d));
        return;
    L29:
        float r20 = h.c(this.f14860i - r19, 0.0f);
        r10.drawRoundRect(this.f14855d, r20, r20, this.f14862k);
        return;
    L21:
        r17 = this.f14853b;
        goto L22
    L14:
        r14 = this.f14860i;
        goto L15
    }

    public final void setImageShape(@NotNull OImageShape r10) {
        q.g(r10, "shape");
        if (r10 != this.f14859h) goto L6;
        Log.d("OImage", q.p("Skip setImageShape because shape is unchanged: ", r10));
        return;
    L6:
        this.f14859h = r10;
        this.f14860i = c.a(r10, this.f14858g, this.f14857f);
        Log.i("OImage", "Image shape changed to " + r10 + ", effectiveRadiusPx=" + this.f14860i);
        invalidate();
    }

    public final void setRadiusDp(float r10) {
        setRadiusPx(r10 * getContext().getResources().getDisplayMetrics().density);
    }

    public final void setRadiusPx(float r10) {
        if (this.f14858g != r10) goto L5;
        return;
    L5:
        this.f14858g = r10;
        this.f14860i = c.a(this.f14859h, r10, this.f14857f);
        invalidate();
    }

    @JvmOverloads
    public OImage(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OImage(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OImage(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f14852a = new Path();
        this.f14853b = new RectF();
        this.f14854c = new RectF();
        this.f14855d = new RectF();
        this.f14856e = b.a.b(b.f19405f, r10, r11, r12, 0, 8, null);
        this.f14857f = r10.getResources().getDimension(R$dimen.oui_image_rounded_radius);
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L6
        TypedArray r14 = r10.obtainStyledAttributes(r11, new int[]{R.attr.radius}, r12, 0);     // Catch: Throwable -> L6
        float r15 = r14.getDimension(0, 0.0f);     // Catch: Throwable -> L8
        r14.recycle();     // Catch: Throwable -> L6
        Object r16 = Result.m35constructorimpl(Float.valueOf(r15));     // Catch: Throwable -> L6
    L12:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 == null) goto L16;
        Log.w("OImage", "Failed to parse android:radius; fallback to 0", r17);
        r16 = Float.valueOf(0.0f);
    L16:
        this.f14858g = ((Number) r16).floatValue();
        OImageShape r18 = this.f14856e.c();
        this.f14859h = r18;
        this.f14860i = c.a(r18, this.f14858g, this.f14857f);
        float r19 = r10.getResources().getDimension(R$dimen.oui_image_stroke_width);
        this.f14861j = r19;
        Paint r110 = new Paint(1);
        r110.setStyle(Paint.Style.STROKE);
        r110.setColor(ContextCompat.b(r10, R$color.oui_line_1));
        r110.setStrokeWidth(r19);
        this.f14862k = r110;
        return;
    L8:
        th = move-exception;
        r14.recycle();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.a r111 = Result.Companion;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L12
    }
}

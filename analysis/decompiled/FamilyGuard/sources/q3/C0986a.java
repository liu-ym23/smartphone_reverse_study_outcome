package q3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import j4.k;
import kotlin.ranges.l;

/* renamed from: q3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0986a {

    /* renamed from: a, reason: collision with root package name */
    private int f19934a;

    /* renamed from: b, reason: collision with root package name */
    private int f19935b;

    /* renamed from: c, reason: collision with root package name */
    private int f19936c;

    /* renamed from: d, reason: collision with root package name */
    private int f19937d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f19938e = new Paint(1);

    public static /* synthetic */ void c(C0986a c0986a, Canvas canvas, float f5, int i5, int i6, float f6, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            f6 = 1.0f;
        }
        c0986a.b(canvas, f5, i5, i6, f6);
    }

    public final void a(Canvas canvas, float f5, int i5, int i6, int i7, float f6) {
        k.g(canvas, "canvas");
        if (this.f19934a <= 0) {
            return;
        }
        boolean z5 = i7 == 1;
        int i8 = i5 + (z5 ? this.f19937d : this.f19936c);
        int i9 = i6 - (z5 ? this.f19936c : this.f19937d);
        if (i9 <= i8) {
            return;
        }
        this.f19938e.setColor(this.f19935b);
        if (f6 < 1.0f) {
            this.f19938e.setAlpha(l.h((int) (Color.alpha(this.f19935b) * f6), 0, 255));
        }
        canvas.drawRect(i8, f5, i9, f5 + this.f19934a, this.f19938e);
    }

    public final void b(Canvas canvas, float f5, int i5, int i6, float f6) {
        k.g(canvas, "canvas");
        a(canvas, f5, 0, i5, i6, f6);
    }

    public final int d() {
        return this.f19937d;
    }

    public final int e() {
        return this.f19936c;
    }

    public final int f() {
        return this.f19934a;
    }

    public final void g(int i5) {
        this.f19935b = i5;
    }

    public final void h(int i5) {
        this.f19937d = i5;
    }

    public final void i(int i5) {
        this.f19936c = i5;
    }

    public final void j(int i5) {
        this.f19934a = i5;
    }
}

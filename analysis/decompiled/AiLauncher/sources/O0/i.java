package O0;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public class i {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<P0.a> f5149d = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final int f5150a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.f f5151b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f5152c = 0;

    public i(androidx.emoji2.text.f fVar, int i10) {
        this.f5151b = fVar;
        this.f5150a = i10;
    }

    public void a(Canvas canvas, float f10, float f11, Paint paint) {
        Typeface typefaceG = this.f5151b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f5151b.c(), this.f5150a * 2, 2, f10, f11, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i10) {
        return g().h(i10);
    }

    public int c() {
        return g().i();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int d() {
        return this.f5152c & 3;
    }

    public int e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public final P0.a g() {
        ThreadLocal<P0.a> threadLocal = f5149d;
        P0.a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new P0.a();
            threadLocal.set(aVar);
        }
        this.f5151b.d().j(aVar, this.f5150a);
        return aVar;
    }

    public short h() {
        return g().m();
    }

    public int i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public boolean k() {
        return (this.f5152c & 4) > 0;
    }

    public void l(boolean z10) {
        int iD = d();
        if (z10) {
            this.f5152c = iD | 4;
        } else {
            this.f5152c = iD;
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void m(boolean z10) {
        int i10 = this.f5152c & 4;
        this.f5152c = z10 ? i10 | 2 : i10 | 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(f()));
        sb2.append(", codepoints:");
        int iC = c();
        for (int i10 = 0; i10 < iC; i10++) {
            sb2.append(Integer.toHexString(b(i10)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}

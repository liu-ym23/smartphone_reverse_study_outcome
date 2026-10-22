package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public class o {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<Q.a> f10377d = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    private final int f10378a;

    /* renamed from: b, reason: collision with root package name */
    private final m f10379b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f10380c = 0;

    o(m mVar, int i5) {
        this.f10379b = mVar;
        this.f10378a = i5;
    }

    private Q.a g() {
        ThreadLocal<Q.a> threadLocal = f10377d;
        Q.a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new Q.a();
            threadLocal.set(aVar);
        }
        this.f10379b.d().j(aVar, this.f10378a);
        return aVar;
    }

    public void a(Canvas canvas, float f5, float f6, Paint paint) {
        Typeface typefaceG = this.f10379b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f10379b.c(), this.f10378a * 2, 2, f5, f6, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i5) {
        return g().h(i5);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f10380c & 3;
    }

    public int e() {
        return g().k();
    }

    public int f() {
        return g().l();
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
        return (this.f10380c & 4) > 0;
    }

    public void l(boolean z5) {
        int iD = d();
        if (z5) {
            this.f10380c = iD | 4;
        } else {
            this.f10380c = iD;
        }
    }

    public void m(boolean z5) {
        int i5 = this.f10380c & 4;
        this.f10380c = z5 ? i5 | 2 : i5 | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i5 = 0; i5 < iC; i5++) {
            sb.append(Integer.toHexString(b(i5)));
            sb.append(" ");
        }
        return sb.toString();
    }
}

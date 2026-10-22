package Bc;

import Cc.c;
import Cc.h;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import rc.a1;
import rc.a1.b;
import rc.c1;

/* loaded from: classes5.dex */
public class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final c1 f1578a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1579b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f1580c;

    /* renamed from: d, reason: collision with root package name */
    public final Cc.a f1581d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1582e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1583f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f1584a;

        /* renamed from: b, reason: collision with root package name */
        public float f1585b;

        /* renamed from: c, reason: collision with root package name */
        public int f1586c = -16777216;

        /* renamed from: d, reason: collision with root package name */
        public int f1587d;

        /* renamed from: e, reason: collision with root package name */
        public Drawable f1588e;

        /* renamed from: f, reason: collision with root package name */
        public h f1589f;

        public a(String str) {
            this.f1584a = str;
        }

        public a g(int i10) {
            this.f1587d = i10;
            return this;
        }

        public b h() {
            return new b(this);
        }

        public a i(int i10) {
            this.f1586c = i10;
            return this;
        }

        public a j(float f10) {
            this.f1585b = f10;
            return this;
        }
    }

    public b(a aVar) {
        c1 c1VarA = new a1(aVar.f1584a).new b().b(new c(aVar.f1586c)).c(aVar.f1585b).d(0).a();
        this.f1578a = c1VarA;
        if (aVar.f1589f != null) {
            c1VarA.e(aVar.f1589f);
        }
        this.f1579b = aVar.f1587d;
        this.f1580c = aVar.f1588e;
        this.f1581d = new Cc.a();
        int iB = c1VarA.b();
        this.f1582e = iB;
        int iA = c1VarA.a();
        this.f1583f = iA;
        setBounds(0, 0, iB, iA);
    }

    public static a a(String str) {
        return new a(str);
    }

    public c1 b() {
        return this.f1578a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int iSave = canvas.save();
        try {
            Drawable drawable = this.f1580c;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            int iWidth = bounds.width();
            int iHeight = bounds.height();
            int i10 = this.f1582e;
            float fMin = (i10 > iWidth || this.f1583f > iHeight) ? Math.min(iWidth / i10, iHeight / this.f1583f) : 1.0f;
            int i11 = (int) ((this.f1582e * fMin) + 0.5f);
            int i12 = (iHeight - ((int) ((this.f1583f * fMin) + 0.5f))) / 2;
            int i13 = this.f1579b;
            int i14 = i13 == 1 ? (iWidth - i11) / 2 : i13 == 2 ? iWidth - i11 : 0;
            if (i12 != 0 || i14 != 0) {
                canvas.translate(i14, i12);
            }
            if (Float.compare(fMin, 1.0f) != 0) {
                canvas.scale(fMin, fMin);
            }
            this.f1581d.w(canvas);
            this.f1578a.c(null, this.f1581d, 0, 0);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1583f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1582e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Drawable drawable = this.f1580c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}

package e3;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: e3.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1419h extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public p f4345a;
    public C1409C b;
    public Z2.a c;
    public ColorStateList d;
    public ColorStateList e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public Rect h;
    public final float i;

    /* renamed from: j, reason: collision with root package name */
    public float f4346j;
    public float k;
    public int l;
    public float m;
    public float n;
    public int o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f4347q;

    /* renamed from: r, reason: collision with root package name */
    public final Paint.Style f4348r;

    public C1419h(p pVar) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.h = null;
        this.i = 1.0f;
        this.f4346j = 1.0f;
        this.l = 255;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.f4347q = 0;
        this.f4348r = Paint.Style.FILL_AND_STROKE;
        this.f4345a = pVar;
        this.c = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        k kVar = new k(this);
        kVar.f = true;
        kVar.g = true;
        return kVar;
    }

    public C1419h(C1419h c1419h) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.h = null;
        this.i = 1.0f;
        this.f4346j = 1.0f;
        this.l = 255;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.f4347q = 0;
        this.f4348r = Paint.Style.FILL_AND_STROKE;
        this.f4345a = c1419h.f4345a;
        this.b = c1419h.b;
        this.c = c1419h.c;
        this.k = c1419h.k;
        this.d = c1419h.d;
        this.e = c1419h.e;
        this.g = c1419h.g;
        this.f = c1419h.f;
        this.l = c1419h.l;
        this.i = c1419h.i;
        this.f4347q = c1419h.f4347q;
        this.o = c1419h.o;
        this.f4346j = c1419h.f4346j;
        this.m = c1419h.m;
        this.n = c1419h.n;
        this.p = c1419h.p;
        this.f4348r = c1419h.f4348r;
        if (c1419h.h != null) {
            this.h = new Rect(c1419h.h);
        }
    }
}

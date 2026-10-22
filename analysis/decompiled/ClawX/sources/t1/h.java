package t1;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class h extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public n f5457a;

    /* renamed from: b, reason: collision with root package name */
    public z f5458b;

    /* renamed from: c, reason: collision with root package name */
    public o1.a f5459c;
    public ColorStateList d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f5460e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f5461f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f5462g;

    /* renamed from: h, reason: collision with root package name */
    public Rect f5463h;

    /* renamed from: i, reason: collision with root package name */
    public final float f5464i;

    /* renamed from: j, reason: collision with root package name */
    public float f5465j;

    /* renamed from: k, reason: collision with root package name */
    public float f5466k;

    /* renamed from: l, reason: collision with root package name */
    public int f5467l;

    /* renamed from: m, reason: collision with root package name */
    public float f5468m;

    /* renamed from: n, reason: collision with root package name */
    public float f5469n;

    /* renamed from: o, reason: collision with root package name */
    public int f5470o;

    /* renamed from: p, reason: collision with root package name */
    public int f5471p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint.Style f5472q;

    public h(n nVar) {
        this.d = null;
        this.f5460e = null;
        this.f5461f = null;
        this.f5462g = PorterDuff.Mode.SRC_IN;
        this.f5463h = null;
        this.f5464i = 1.0f;
        this.f5465j = 1.0f;
        this.f5467l = 255;
        this.f5468m = 0.0f;
        this.f5469n = 0.0f;
        this.f5470o = 0;
        this.f5471p = 0;
        this.f5472q = Paint.Style.FILL_AND_STROKE;
        this.f5457a = nVar;
        this.f5459c = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        j jVar = new j(this);
        jVar.f5478f = true;
        jVar.f5479g = true;
        return jVar;
    }

    public h(h hVar) {
        this.d = null;
        this.f5460e = null;
        this.f5461f = null;
        this.f5462g = PorterDuff.Mode.SRC_IN;
        this.f5463h = null;
        this.f5464i = 1.0f;
        this.f5465j = 1.0f;
        this.f5467l = 255;
        this.f5468m = 0.0f;
        this.f5469n = 0.0f;
        this.f5470o = 0;
        this.f5471p = 0;
        this.f5472q = Paint.Style.FILL_AND_STROKE;
        this.f5457a = hVar.f5457a;
        this.f5458b = hVar.f5458b;
        this.f5459c = hVar.f5459c;
        this.f5466k = hVar.f5466k;
        this.d = hVar.d;
        this.f5460e = hVar.f5460e;
        this.f5462g = hVar.f5462g;
        this.f5461f = hVar.f5461f;
        this.f5467l = hVar.f5467l;
        this.f5464i = hVar.f5464i;
        this.f5471p = hVar.f5471p;
        this.f5465j = hVar.f5465j;
        this.f5468m = hVar.f5468m;
        this.f5469n = hVar.f5469n;
        this.f5470o = hVar.f5470o;
        this.f5472q = hVar.f5472q;
        if (hVar.f5463h != null) {
            this.f5463h = new Rect(hVar.f5463h);
        }
    }
}

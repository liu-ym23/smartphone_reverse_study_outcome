package y1;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.stepos.alphame.utils.Property;
import u1.C0938a;

/* loaded from: classes.dex */
public class h extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public n f16203a;

    /* renamed from: b, reason: collision with root package name */
    public B f16204b;

    /* renamed from: c, reason: collision with root package name */
    public C0938a f16205c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f16206d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f16207e;

    /* renamed from: f, reason: collision with root package name */
    public final ColorStateList f16208f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f16209g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f16210h;

    /* renamed from: i, reason: collision with root package name */
    public Rect f16211i;

    /* renamed from: j, reason: collision with root package name */
    public final float f16212j;

    /* renamed from: k, reason: collision with root package name */
    public float f16213k;

    /* renamed from: l, reason: collision with root package name */
    public float f16214l;

    /* renamed from: m, reason: collision with root package name */
    public int f16215m;

    /* renamed from: n, reason: collision with root package name */
    public float f16216n;

    /* renamed from: o, reason: collision with root package name */
    public float f16217o;

    /* renamed from: p, reason: collision with root package name */
    public final float f16218p;

    /* renamed from: q, reason: collision with root package name */
    public final int f16219q;

    /* renamed from: r, reason: collision with root package name */
    public int f16220r;

    /* renamed from: s, reason: collision with root package name */
    public int f16221s;

    /* renamed from: t, reason: collision with root package name */
    public final int f16222t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f16223u;

    /* renamed from: v, reason: collision with root package name */
    public final Paint.Style f16224v;

    public h(n nVar) {
        this.f16206d = null;
        this.f16207e = null;
        this.f16208f = null;
        this.f16209g = null;
        this.f16210h = PorterDuff.Mode.SRC_IN;
        this.f16211i = null;
        this.f16212j = 1.0f;
        this.f16213k = 1.0f;
        this.f16215m = 255;
        this.f16216n = Property.DEFAULT_FLOAT_VALUE;
        this.f16217o = Property.DEFAULT_FLOAT_VALUE;
        this.f16218p = Property.DEFAULT_FLOAT_VALUE;
        this.f16219q = 0;
        this.f16220r = 0;
        this.f16221s = 0;
        this.f16222t = 0;
        this.f16223u = false;
        this.f16224v = Paint.Style.FILL_AND_STROKE;
        this.f16203a = nVar;
        this.f16205c = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        j jVar = new j(this);
        jVar.f16238f = true;
        jVar.f16239g = true;
        return jVar;
    }

    public h(h hVar) {
        this.f16206d = null;
        this.f16207e = null;
        this.f16208f = null;
        this.f16209g = null;
        this.f16210h = PorterDuff.Mode.SRC_IN;
        this.f16211i = null;
        this.f16212j = 1.0f;
        this.f16213k = 1.0f;
        this.f16215m = 255;
        this.f16216n = Property.DEFAULT_FLOAT_VALUE;
        this.f16217o = Property.DEFAULT_FLOAT_VALUE;
        this.f16218p = Property.DEFAULT_FLOAT_VALUE;
        this.f16219q = 0;
        this.f16220r = 0;
        this.f16221s = 0;
        this.f16222t = 0;
        this.f16223u = false;
        this.f16224v = Paint.Style.FILL_AND_STROKE;
        this.f16203a = hVar.f16203a;
        this.f16204b = hVar.f16204b;
        this.f16205c = hVar.f16205c;
        this.f16214l = hVar.f16214l;
        this.f16206d = hVar.f16206d;
        this.f16207e = hVar.f16207e;
        this.f16210h = hVar.f16210h;
        this.f16209g = hVar.f16209g;
        this.f16215m = hVar.f16215m;
        this.f16212j = hVar.f16212j;
        this.f16221s = hVar.f16221s;
        this.f16219q = hVar.f16219q;
        this.f16223u = hVar.f16223u;
        this.f16213k = hVar.f16213k;
        this.f16216n = hVar.f16216n;
        this.f16217o = hVar.f16217o;
        this.f16218p = hVar.f16218p;
        this.f16220r = hVar.f16220r;
        this.f16222t = hVar.f16222t;
        this.f16208f = hVar.f16208f;
        this.f16224v = hVar.f16224v;
        if (hVar.f16211i != null) {
            this.f16211i = new Rect(hVar.f16211i);
        }
    }
}

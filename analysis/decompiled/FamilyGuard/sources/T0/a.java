package T0;

import T0.a;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import z0.C1342h;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f5308a;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f5312e;

    /* renamed from: f, reason: collision with root package name */
    private int f5313f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f5314g;

    /* renamed from: h, reason: collision with root package name */
    private int f5315h;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5320m;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f5322o;

    /* renamed from: p, reason: collision with root package name */
    private int f5323p;

    /* renamed from: t, reason: collision with root package name */
    private boolean f5327t;

    /* renamed from: u, reason: collision with root package name */
    private Resources.Theme f5328u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f5329v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5330w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f5331x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f5333z;

    /* renamed from: b, reason: collision with root package name */
    private float f5309b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    private C0.j f5310c = C0.j.f398e;

    /* renamed from: d, reason: collision with root package name */
    private v0.g f5311d = v0.g.NORMAL;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5316i = true;

    /* renamed from: j, reason: collision with root package name */
    private int f5317j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f5318k = -1;

    /* renamed from: l, reason: collision with root package name */
    private InterfaceC1340f f5319l = W0.a.c();

    /* renamed from: n, reason: collision with root package name */
    private boolean f5321n = true;

    /* renamed from: q, reason: collision with root package name */
    private C1342h f5324q = new C1342h();

    /* renamed from: r, reason: collision with root package name */
    private Map<Class<?>, z0.k<?>> f5325r = new X0.b();

    /* renamed from: s, reason: collision with root package name */
    private Class<?> f5326s = Object.class;

    /* renamed from: y, reason: collision with root package name */
    private boolean f5332y = true;

    private boolean H(int i5) {
        return I(this.f5308a, i5);
    }

    private static boolean I(int i5, int i6) {
        return (i5 & i6) != 0;
    }

    private T P() {
        return this;
    }

    private T Q() {
        if (this.f5327t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) P();
    }

    public final Resources.Theme A() {
        return this.f5328u;
    }

    public final Map<Class<?>, z0.k<?>> B() {
        return this.f5325r;
    }

    public final boolean C() {
        return this.f5333z;
    }

    public final boolean D() {
        return this.f5330w;
    }

    public final boolean E() {
        return this.f5316i;
    }

    public final boolean F() {
        return H(8);
    }

    boolean G() {
        return this.f5332y;
    }

    public final boolean J() {
        return this.f5320m;
    }

    public final boolean K() {
        return X0.k.s(this.f5318k, this.f5317j);
    }

    public T L() {
        this.f5327t = true;
        return (T) P();
    }

    public T M(int i5) {
        return (T) N(i5, i5);
    }

    public T N(int i5, int i6) {
        if (this.f5329v) {
            return (T) clone().N(i5, i6);
        }
        this.f5318k = i5;
        this.f5317j = i6;
        this.f5308a |= 512;
        return (T) Q();
    }

    public T O(v0.g gVar) {
        if (this.f5329v) {
            return (T) clone().O(gVar);
        }
        this.f5311d = (v0.g) X0.j.d(gVar);
        this.f5308a |= 8;
        return (T) Q();
    }

    public T R(InterfaceC1340f interfaceC1340f) {
        if (this.f5329v) {
            return (T) clone().R(interfaceC1340f);
        }
        this.f5319l = (InterfaceC1340f) X0.j.d(interfaceC1340f);
        this.f5308a |= 1024;
        return (T) Q();
    }

    public T S(float f5) {
        if (this.f5329v) {
            return (T) clone().S(f5);
        }
        if (f5 < 0.0f || f5 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f5309b = f5;
        this.f5308a |= 2;
        return (T) Q();
    }

    public T T(boolean z5) {
        if (this.f5329v) {
            return (T) clone().T(true);
        }
        this.f5316i = !z5;
        this.f5308a |= 256;
        return (T) Q();
    }

    <Y> T U(Class<Y> cls, z0.k<Y> kVar, boolean z5) {
        if (this.f5329v) {
            return (T) clone().U(cls, kVar, z5);
        }
        X0.j.d(cls);
        X0.j.d(kVar);
        this.f5325r.put(cls, kVar);
        int i5 = this.f5308a;
        this.f5321n = true;
        this.f5308a = 67584 | i5;
        this.f5332y = false;
        if (z5) {
            this.f5308a = i5 | 198656;
            this.f5320m = true;
        }
        return (T) Q();
    }

    public T V(z0.k<Bitmap> kVar) {
        return (T) W(kVar, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    T W(z0.k<Bitmap> kVar, boolean z5) {
        if (this.f5329v) {
            return (T) clone().W(kVar, z5);
        }
        K0.j jVar = new K0.j(kVar, z5);
        U(Bitmap.class, kVar, z5);
        U(Drawable.class, jVar, z5);
        U(BitmapDrawable.class, jVar.c(), z5);
        U(O0.c.class, new O0.f(kVar), z5);
        return (T) Q();
    }

    public T X(boolean z5) {
        if (this.f5329v) {
            return (T) clone().X(z5);
        }
        this.f5333z = z5;
        this.f5308a |= 1048576;
        return (T) Q();
    }

    public T b(a<?> aVar) {
        if (this.f5329v) {
            return (T) clone().b(aVar);
        }
        if (I(aVar.f5308a, 2)) {
            this.f5309b = aVar.f5309b;
        }
        if (I(aVar.f5308a, 262144)) {
            this.f5330w = aVar.f5330w;
        }
        if (I(aVar.f5308a, 1048576)) {
            this.f5333z = aVar.f5333z;
        }
        if (I(aVar.f5308a, 4)) {
            this.f5310c = aVar.f5310c;
        }
        if (I(aVar.f5308a, 8)) {
            this.f5311d = aVar.f5311d;
        }
        if (I(aVar.f5308a, 16)) {
            this.f5312e = aVar.f5312e;
            this.f5313f = 0;
            this.f5308a &= -33;
        }
        if (I(aVar.f5308a, 32)) {
            this.f5313f = aVar.f5313f;
            this.f5312e = null;
            this.f5308a &= -17;
        }
        if (I(aVar.f5308a, 64)) {
            this.f5314g = aVar.f5314g;
            this.f5315h = 0;
            this.f5308a &= -129;
        }
        if (I(aVar.f5308a, 128)) {
            this.f5315h = aVar.f5315h;
            this.f5314g = null;
            this.f5308a &= -65;
        }
        if (I(aVar.f5308a, 256)) {
            this.f5316i = aVar.f5316i;
        }
        if (I(aVar.f5308a, 512)) {
            this.f5318k = aVar.f5318k;
            this.f5317j = aVar.f5317j;
        }
        if (I(aVar.f5308a, 1024)) {
            this.f5319l = aVar.f5319l;
        }
        if (I(aVar.f5308a, RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT)) {
            this.f5326s = aVar.f5326s;
        }
        if (I(aVar.f5308a, 8192)) {
            this.f5322o = aVar.f5322o;
            this.f5323p = 0;
            this.f5308a &= -16385;
        }
        if (I(aVar.f5308a, 16384)) {
            this.f5323p = aVar.f5323p;
            this.f5322o = null;
            this.f5308a &= -8193;
        }
        if (I(aVar.f5308a, 32768)) {
            this.f5328u = aVar.f5328u;
        }
        if (I(aVar.f5308a, 65536)) {
            this.f5321n = aVar.f5321n;
        }
        if (I(aVar.f5308a, 131072)) {
            this.f5320m = aVar.f5320m;
        }
        if (I(aVar.f5308a, RecyclerView.ItemAnimator.FLAG_MOVED)) {
            this.f5325r.putAll(aVar.f5325r);
            this.f5332y = aVar.f5332y;
        }
        if (I(aVar.f5308a, 524288)) {
            this.f5331x = aVar.f5331x;
        }
        if (!this.f5321n) {
            this.f5325r.clear();
            int i5 = this.f5308a;
            this.f5320m = false;
            this.f5308a = i5 & (-133121);
            this.f5332y = true;
        }
        this.f5308a |= aVar.f5308a;
        this.f5324q.d(aVar.f5324q);
        return (T) Q();
    }

    public T d() {
        if (this.f5327t && !this.f5329v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f5329v = true;
        return (T) L();
    }

    @Override // 
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t5 = (T) super.clone();
            C1342h c1342h = new C1342h();
            t5.f5324q = c1342h;
            c1342h.d(this.f5324q);
            X0.b bVar = new X0.b();
            t5.f5325r = bVar;
            bVar.putAll(this.f5325r);
            t5.f5327t = false;
            t5.f5329v = false;
            return t5;
        } catch (CloneNotSupportedException e6) {
            throw new RuntimeException(e6);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (Float.compare(aVar.f5309b, this.f5309b) == 0 && this.f5313f == aVar.f5313f && X0.k.d(this.f5312e, aVar.f5312e) && this.f5315h == aVar.f5315h && X0.k.d(this.f5314g, aVar.f5314g) && this.f5323p == aVar.f5323p && X0.k.d(this.f5322o, aVar.f5322o) && this.f5316i == aVar.f5316i && this.f5317j == aVar.f5317j && this.f5318k == aVar.f5318k && this.f5320m == aVar.f5320m && this.f5321n == aVar.f5321n && this.f5330w == aVar.f5330w && this.f5331x == aVar.f5331x && this.f5310c.equals(aVar.f5310c) && this.f5311d == aVar.f5311d && this.f5324q.equals(aVar.f5324q) && this.f5325r.equals(aVar.f5325r) && this.f5326s.equals(aVar.f5326s) && X0.k.d(this.f5319l, aVar.f5319l) && X0.k.d(this.f5328u, aVar.f5328u)) {
                return true;
            }
        }
        return false;
    }

    public T g(Class<?> cls) {
        if (this.f5329v) {
            return (T) clone().g(cls);
        }
        this.f5326s = (Class) X0.j.d(cls);
        this.f5308a |= RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
        return (T) Q();
    }

    public T h(C0.j jVar) {
        if (this.f5329v) {
            return (T) clone().h(jVar);
        }
        this.f5310c = (C0.j) X0.j.d(jVar);
        this.f5308a |= 4;
        return (T) Q();
    }

    public int hashCode() {
        return X0.k.n(this.f5328u, X0.k.n(this.f5319l, X0.k.n(this.f5326s, X0.k.n(this.f5325r, X0.k.n(this.f5324q, X0.k.n(this.f5311d, X0.k.n(this.f5310c, X0.k.o(this.f5331x, X0.k.o(this.f5330w, X0.k.o(this.f5321n, X0.k.o(this.f5320m, X0.k.m(this.f5318k, X0.k.m(this.f5317j, X0.k.o(this.f5316i, X0.k.n(this.f5322o, X0.k.m(this.f5323p, X0.k.n(this.f5314g, X0.k.m(this.f5315h, X0.k.n(this.f5312e, X0.k.m(this.f5313f, X0.k.k(this.f5309b)))))))))))))))))))));
    }

    public final C0.j i() {
        return this.f5310c;
    }

    public final int j() {
        return this.f5313f;
    }

    public final Drawable k() {
        return this.f5312e;
    }

    public final Drawable l() {
        return this.f5322o;
    }

    public final int n() {
        return this.f5323p;
    }

    public final boolean p() {
        return this.f5331x;
    }

    public final C1342h q() {
        return this.f5324q;
    }

    public final int s() {
        return this.f5317j;
    }

    public final int t() {
        return this.f5318k;
    }

    public final Drawable u() {
        return this.f5314g;
    }

    public final int v() {
        return this.f5315h;
    }

    public final v0.g w() {
        return this.f5311d;
    }

    public final Class<?> x() {
        return this.f5326s;
    }

    public final InterfaceC1340f y() {
        return this.f5319l;
    }

    public final float z() {
        return this.f5309b;
    }
}

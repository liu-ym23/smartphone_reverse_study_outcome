package W;

import android.animation.ValueAnimator;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import com.stepos.activeview.graphicsanim.renderable.Renderable;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m implements b {

    /* renamed from: p, reason: collision with root package name */
    public static final f f1954p = new f(Renderable.ATTR_TRANSLATION_X, 5);

    /* renamed from: q, reason: collision with root package name */
    public static final f f1955q = new f(Renderable.ATTR_TRANSLATION_Y, 6);

    /* renamed from: r, reason: collision with root package name */
    public static final f f1956r = new f("scaleX", 8);

    /* renamed from: s, reason: collision with root package name */
    public static final f f1957s = new f("scaleY", 9);

    /* renamed from: t, reason: collision with root package name */
    public static final f f1958t = new f("rotation", 10);

    /* renamed from: u, reason: collision with root package name */
    public static final f f1959u = new f(ViewTweenItem.ROTATION_X, 11);

    /* renamed from: v, reason: collision with root package name */
    public static final f f1960v = new f(ViewTweenItem.ROTATION_Y, 12);

    /* renamed from: w, reason: collision with root package name */
    public static final f f1961w = new f(ViewTweenItem.ALPHA, 2);

    /* renamed from: a, reason: collision with root package name */
    public float f1962a;

    /* renamed from: b, reason: collision with root package name */
    public float f1963b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1964c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1965d;

    /* renamed from: e, reason: collision with root package name */
    public final I.h f1966e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1967f;

    /* renamed from: g, reason: collision with root package name */
    public final float f1968g;

    /* renamed from: h, reason: collision with root package name */
    public final float f1969h;

    /* renamed from: i, reason: collision with root package name */
    public long f1970i;

    /* renamed from: j, reason: collision with root package name */
    public float f1971j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1972k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f1973l;

    /* renamed from: m, reason: collision with root package name */
    public n f1974m;

    /* renamed from: n, reason: collision with root package name */
    public float f1975n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1976o;

    public m(l lVar) {
        this.f1962a = Property.DEFAULT_FLOAT_VALUE;
        this.f1963b = Float.MAX_VALUE;
        this.f1964c = false;
        this.f1967f = false;
        this.f1968g = Float.MAX_VALUE;
        this.f1969h = -3.4028235E38f;
        this.f1970i = 0L;
        this.f1972k = new ArrayList();
        this.f1973l = new ArrayList();
        this.f1965d = null;
        this.f1966e = new g(lVar);
        this.f1971j = 1.0f;
        this.f1974m = null;
        this.f1975n = Float.MAX_VALUE;
        this.f1976o = false;
    }

    public static e e() {
        ThreadLocal threadLocal = e.f1940i;
        if (threadLocal.get() == null) {
            threadLocal.set(new e(new B0.c(3)));
        }
        return (e) threadLocal.get();
    }

    public final void a(i iVar) {
        ArrayList arrayList = this.f1972k;
        if (arrayList.contains(iVar)) {
            return;
        }
        arrayList.add(iVar);
    }

    public final void b(j jVar) {
        if (this.f1967f) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        ArrayList arrayList = this.f1973l;
        if (arrayList.contains(jVar)) {
            return;
        }
        arrayList.add(jVar);
    }

    public final void c() {
        if (!e().a()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        }
        if (this.f1967f) {
            d(true);
        }
        float f4 = this.f1975n;
        if (f4 != Float.MAX_VALUE) {
            n nVar = this.f1974m;
            if (nVar == null) {
                this.f1974m = new n(f4);
            } else {
                nVar.f1985i = f4;
            }
            this.f1975n = Float.MAX_VALUE;
        }
    }

    public final void d(boolean z4) {
        ArrayList arrayList;
        int i4 = 0;
        this.f1967f = false;
        e eVarE = e();
        eVarE.f1941a.remove(this);
        ArrayList arrayList2 = eVarE.f1942b;
        int iIndexOf = arrayList2.indexOf(this);
        if (iIndexOf >= 0) {
            arrayList2.set(iIndexOf, null);
            eVarE.f1946f = true;
        }
        this.f1970i = 0L;
        this.f1964c = false;
        while (true) {
            arrayList = this.f1972k;
            if (i4 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i4) != null) {
                ((i) arrayList.get(i4)).a(z4);
            }
            i4++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final void f(float f4) {
        ArrayList arrayList;
        this.f1966e.g(this.f1965d, f4);
        int i4 = 0;
        while (true) {
            arrayList = this.f1973l;
            if (i4 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i4) != null) {
                ((j) arrayList.get(i4)).a(this.f1963b);
            }
            i4++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final void g(float f4) {
        this.f1963b = f4;
        this.f1964c = true;
    }

    public final void h() {
        if (this.f1974m.f1978b <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (!e().a()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f1967f) {
            this.f1976o = true;
        }
    }

    public final void i() {
        n nVar = this.f1974m;
        if (nVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d4 = (float) nVar.f1985i;
        if (d4 > this.f1968g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d4 < this.f1969h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(this.f1971j * 0.75f);
        nVar.f1980d = dAbs;
        nVar.f1981e = dAbs * 62.5d;
        if (!e().a()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z4 = this.f1967f;
        if (z4 || z4) {
            return;
        }
        this.f1967f = true;
        if (!this.f1964c) {
            this.f1963b = this.f1966e.e(this.f1965d);
        }
        float f4 = this.f1963b;
        if (f4 > this.f1968g || f4 < this.f1969h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        e eVarE = e();
        ArrayList arrayList = eVarE.f1942b;
        if (arrayList.size() == 0) {
            ((Choreographer) eVarE.f1945e.f136a).postFrameCallback(new d(0, eVarE.f1944d));
            eVarE.f1947g = ValueAnimator.getDurationScale();
            if (eVarE.f1948h == null) {
                m3.i iVar = new m3.i();
                iVar.f13621b = eVarE;
                eVarE.f1948h = iVar;
            }
            final m3.i iVar2 = eVarE.f1948h;
            if (((ValueAnimator.DurationScaleChangeListener) iVar2.f13620a) == null) {
                ValueAnimator.DurationScaleChangeListener durationScaleChangeListener = new ValueAnimator.DurationScaleChangeListener() { // from class: W.c
                    @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                    public final void onChanged(float f5) {
                        ((e) iVar2.f13621b).f1947g = f5;
                    }
                };
                iVar2.f13620a = durationScaleChangeListener;
                ValueAnimator.registerDurationScaleChangeListener(durationScaleChangeListener);
            }
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public m(Object obj, I.h hVar) {
        this.f1962a = Property.DEFAULT_FLOAT_VALUE;
        this.f1963b = Float.MAX_VALUE;
        this.f1964c = false;
        this.f1967f = false;
        this.f1968g = Float.MAX_VALUE;
        this.f1969h = -3.4028235E38f;
        this.f1970i = 0L;
        this.f1972k = new ArrayList();
        this.f1973l = new ArrayList();
        this.f1965d = obj;
        this.f1966e = hVar;
        if (hVar != f1958t && hVar != f1959u && hVar != f1960v) {
            if (hVar == f1961w) {
                this.f1971j = 0.00390625f;
            } else if (hVar != f1956r && hVar != f1957s) {
                this.f1971j = 1.0f;
            } else {
                this.f1971j = 0.002f;
            }
        } else {
            this.f1971j = 0.1f;
        }
        this.f1974m = null;
        this.f1975n = Float.MAX_VALUE;
        this.f1976o = false;
    }
}

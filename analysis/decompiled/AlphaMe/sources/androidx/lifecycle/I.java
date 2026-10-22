package androidx.lifecycle;

import b3.C0369C;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import l.C0744b;
import m.C0767a;

/* loaded from: classes.dex */
public final class I extends AbstractC0328z {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3869b;

    /* renamed from: c, reason: collision with root package name */
    public C0767a f3870c;

    /* renamed from: d, reason: collision with root package name */
    public EnumC0327y f3871d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f3872e;

    /* renamed from: f, reason: collision with root package name */
    public int f3873f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3874g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3875h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f3876i;

    /* renamed from: j, reason: collision with root package name */
    public final C0369C f3877j;

    public I(G provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f3989a = new AtomicReference();
        this.f3869b = true;
        this.f3870c = new C0767a();
        EnumC0327y enumC0327y = EnumC0327y.f3984b;
        this.f3871d = enumC0327y;
        this.f3876i = new ArrayList();
        this.f3872e = new WeakReference(provider);
        this.f3877j = new C0369C(enumC0327y);
    }

    @Override // androidx.lifecycle.AbstractC0328z
    public final void a(F object) {
        E c0317n;
        G g4;
        Intrinsics.checkNotNullParameter(object, "observer");
        d("addObserver");
        EnumC0327y enumC0327y = this.f3871d;
        EnumC0327y initialState = EnumC0327y.f3983a;
        if (enumC0327y != initialState) {
            initialState = EnumC0327y.f3984b;
        }
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        H h4 = new H();
        Intrinsics.checkNotNull(object);
        HashMap map = K.f3879a;
        Intrinsics.checkNotNullParameter(object, "object");
        boolean z4 = object instanceof E;
        boolean z5 = object instanceof InterfaceC0315l;
        if (z4 && z5) {
            c0317n = new C0317n((InterfaceC0315l) object, (E) object);
        } else if (z5) {
            c0317n = new C0317n((InterfaceC0315l) object, (E) null);
        } else if (z4) {
            c0317n = (E) object;
        } else {
            Class<?> cls = object.getClass();
            if (K.c(cls) == 2) {
                Object obj = K.f3880b.get(cls);
                Intrinsics.checkNotNull(obj);
                List list = (List) obj;
                if (list.size() == 1) {
                    K.a((Constructor) list.get(0), object);
                    c0317n = new C0312i();
                } else {
                    int size = list.size();
                    r[] rVarArr = new r[size];
                    for (int i4 = 0; i4 < size; i4++) {
                        K.a((Constructor) list.get(i4), object);
                        rVarArr[i4] = null;
                    }
                    c0317n = new C0312i(rVarArr);
                }
            } else {
                c0317n = new C0317n(object);
            }
        }
        h4.f3868b = c0317n;
        h4.f3867a = initialState;
        if (((H) this.f3870c.d(object, h4)) == null && (g4 = (G) this.f3872e.get()) != null) {
            boolean z6 = this.f3873f != 0 || this.f3874g;
            EnumC0327y enumC0327yC = c(object);
            this.f3873f++;
            while (h4.f3867a.compareTo(enumC0327yC) < 0 && this.f3870c.f13507e.containsKey(object)) {
                this.f3876i.add(h4.f3867a);
                C0324v c0324v = EnumC0326x.Companion;
                EnumC0327y enumC0327y2 = h4.f3867a;
                c0324v.getClass();
                EnumC0326x enumC0326xB = C0324v.b(enumC0327y2);
                if (enumC0326xB == null) {
                    throw new IllegalStateException("no event up from " + h4.f3867a);
                }
                h4.a(g4, enumC0326xB);
                ArrayList arrayList = this.f3876i;
                arrayList.remove(arrayList.size() - 1);
                enumC0327yC = c(object);
            }
            if (!z6) {
                h();
            }
            this.f3873f--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0328z
    public final void b(F observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        d("removeObserver");
        this.f3870c.c(observer);
    }

    public final EnumC0327y c(F f4) {
        H h4;
        HashMap map = this.f3870c.f13507e;
        m.c cVar = map.containsKey(f4) ? ((m.c) map.get(f4)).f13512d : null;
        EnumC0327y state1 = (cVar == null || (h4 = (H) cVar.f13510b) == null) ? null : h4.f3867a;
        ArrayList arrayList = this.f3876i;
        EnumC0327y enumC0327y = arrayList.isEmpty() ^ true ? (EnumC0327y) arrayList.get(arrayList.size() - 1) : null;
        EnumC0327y state12 = this.f3871d;
        Intrinsics.checkNotNullParameter(state12, "state1");
        if (state1 == null || state1.compareTo(state12) >= 0) {
            state1 = state12;
        }
        Intrinsics.checkNotNullParameter(state1, "state1");
        return (enumC0327y == null || enumC0327y.compareTo(state1) >= 0) ? state1 : enumC0327y;
    }

    public final void d(String str) {
        if (this.f3869b && !C0744b.g0().h0()) {
            throw new IllegalStateException(B0.g.n("Method ", str, " must be called on the main thread").toString());
        }
    }

    public final void e(EnumC0326x event) {
        Intrinsics.checkNotNullParameter(event, "event");
        d("handleLifecycleEvent");
        f(event.a());
    }

    public final void f(EnumC0327y enumC0327y) {
        EnumC0327y enumC0327y2 = this.f3871d;
        if (enumC0327y2 == enumC0327y) {
            return;
        }
        EnumC0327y enumC0327y3 = EnumC0327y.f3984b;
        EnumC0327y enumC0327y4 = EnumC0327y.f3983a;
        if (enumC0327y2 == enumC0327y3 && enumC0327y == enumC0327y4) {
            throw new IllegalStateException(("no event down from " + this.f3871d + " in component " + this.f3872e.get()).toString());
        }
        this.f3871d = enumC0327y;
        if (this.f3874g || this.f3873f != 0) {
            this.f3875h = true;
            return;
        }
        this.f3874g = true;
        h();
        this.f3874g = false;
        if (this.f3871d == enumC0327y4) {
            this.f3870c = new C0767a();
        }
    }

    public final void g() {
        EnumC0327y state = EnumC0327y.f3985c;
        Intrinsics.checkNotNullParameter(state, "state");
        d("setCurrentState");
        f(state);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r8.f3875h = false;
        r8.f3877j.b(r8.f3871d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.I.h():void");
    }
}

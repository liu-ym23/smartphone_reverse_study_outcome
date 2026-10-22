package v0;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public c f13299a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final n0.b f13300a;

        /* renamed from: b, reason: collision with root package name */
        public final n0.b f13301b;

        public a(WindowInsetsAnimation.Bounds bounds) {
            this.f13300a = n0.b.b(bounds.getLowerBound());
            this.f13301b = n0.b.b(bounds.getUpperBound());
        }

        public final String toString() {
            return "Bounds{lower=" + this.f13300a + " upper=" + this.f13301b + "}";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f13302a;

        public b(int i10) {
            this.f13302a = i10;
        }

        public abstract void a(l0 l0Var);

        public abstract void b();

        public abstract m0 c(m0 m0Var, List<l0> list);

        public abstract a d(l0 l0Var, a aVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends d {

        /* renamed from: a, reason: collision with root package name */
        public final WindowInsetsAnimation f13303a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class a extends WindowInsetsAnimation.Callback {

            /* renamed from: a, reason: collision with root package name */
            public final b f13304a;

            /* renamed from: b, reason: collision with root package name */
            public List<l0> f13305b;

            /* renamed from: c, reason: collision with root package name */
            public ArrayList<l0> f13306c;

            /* renamed from: d, reason: collision with root package name */
            public final HashMap<WindowInsetsAnimation, l0> f13307d;

            public a(b bVar) {
                super(bVar.f13302a);
                this.f13307d = new HashMap<>();
                this.f13304a = bVar;
            }

            public final l0 a(WindowInsetsAnimation windowInsetsAnimation) {
                HashMap<WindowInsetsAnimation, l0> map = this.f13307d;
                l0 l0Var = map.get(windowInsetsAnimation);
                if (l0Var != null) {
                    return l0Var;
                }
                l0 l0Var2 = new l0();
                l0Var2.f13299a = new c(new WindowInsetsAnimation(0, null, 0L));
                l0Var2.f13299a = new c(windowInsetsAnimation);
                map.put(windowInsetsAnimation, l0Var2);
                return l0Var2;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f13304a.a(a(windowInsetsAnimation));
                this.f13307d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                a(windowInsetsAnimation);
                this.f13304a.b();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<l0> arrayList = this.f13306c;
                if (arrayList == null) {
                    ArrayList<l0> arrayList2 = new ArrayList<>(list.size());
                    this.f13306c = arrayList2;
                    this.f13305b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    l0 l0VarA = a(windowInsetsAnimation);
                    l0VarA.f13299a.f13303a.setFraction(windowInsetsAnimation.getFraction());
                    this.f13306c.add(l0VarA);
                }
                m0 m0VarH = m0.h(null, windowInsets);
                this.f13304a.c(m0VarH, this.f13305b);
                return m0VarH.g();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                l0 l0VarA = a(windowInsetsAnimation);
                a aVar = new a(bounds);
                this.f13304a.d(l0VarA, aVar);
                return new WindowInsetsAnimation.Bounds(aVar.f13300a.c(), aVar.f13301b.c());
            }
        }

        public c(WindowInsetsAnimation windowInsetsAnimation) {
            this.f13303a = windowInsetsAnimation;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {
    }
}

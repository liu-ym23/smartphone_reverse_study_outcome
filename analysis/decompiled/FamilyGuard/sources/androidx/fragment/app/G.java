package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0533m;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class G {

    /* renamed from: a, reason: collision with root package name */
    private final C0520o f10428a;

    /* renamed from: b, reason: collision with root package name */
    private final ClassLoader f10429b;

    /* renamed from: d, reason: collision with root package name */
    int f10431d;

    /* renamed from: e, reason: collision with root package name */
    int f10432e;

    /* renamed from: f, reason: collision with root package name */
    int f10433f;

    /* renamed from: g, reason: collision with root package name */
    int f10434g;

    /* renamed from: h, reason: collision with root package name */
    int f10435h;

    /* renamed from: i, reason: collision with root package name */
    boolean f10436i;

    /* renamed from: k, reason: collision with root package name */
    String f10438k;

    /* renamed from: l, reason: collision with root package name */
    int f10439l;

    /* renamed from: m, reason: collision with root package name */
    CharSequence f10440m;

    /* renamed from: n, reason: collision with root package name */
    int f10441n;

    /* renamed from: o, reason: collision with root package name */
    CharSequence f10442o;

    /* renamed from: p, reason: collision with root package name */
    ArrayList<String> f10443p;

    /* renamed from: q, reason: collision with root package name */
    ArrayList<String> f10444q;

    /* renamed from: s, reason: collision with root package name */
    ArrayList<Runnable> f10446s;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<a> f10430c = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    boolean f10437j = true;

    /* renamed from: r, reason: collision with root package name */
    boolean f10445r = false;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f10447a;

        /* renamed from: b, reason: collision with root package name */
        ComponentCallbacksC0511f f10448b;

        /* renamed from: c, reason: collision with root package name */
        boolean f10449c;

        /* renamed from: d, reason: collision with root package name */
        int f10450d;

        /* renamed from: e, reason: collision with root package name */
        int f10451e;

        /* renamed from: f, reason: collision with root package name */
        int f10452f;

        /* renamed from: g, reason: collision with root package name */
        int f10453g;

        /* renamed from: h, reason: collision with root package name */
        AbstractC0533m.b f10454h;

        /* renamed from: i, reason: collision with root package name */
        AbstractC0533m.b f10455i;

        a() {
        }

        a(int i5, ComponentCallbacksC0511f componentCallbacksC0511f) {
            this.f10447a = i5;
            this.f10448b = componentCallbacksC0511f;
            this.f10449c = false;
            AbstractC0533m.b bVar = AbstractC0533m.b.RESUMED;
            this.f10454h = bVar;
            this.f10455i = bVar;
        }

        a(int i5, ComponentCallbacksC0511f componentCallbacksC0511f, boolean z5) {
            this.f10447a = i5;
            this.f10448b = componentCallbacksC0511f;
            this.f10449c = z5;
            AbstractC0533m.b bVar = AbstractC0533m.b.RESUMED;
            this.f10454h = bVar;
            this.f10455i = bVar;
        }

        a(int i5, ComponentCallbacksC0511f componentCallbacksC0511f, AbstractC0533m.b bVar) {
            this.f10447a = i5;
            this.f10448b = componentCallbacksC0511f;
            this.f10449c = false;
            this.f10454h = componentCallbacksC0511f.f10622U;
            this.f10455i = bVar;
        }
    }

    G(C0520o c0520o, ClassLoader classLoader) {
        this.f10428a = c0520o;
        this.f10429b = classLoader;
    }

    public G b(int i5, ComponentCallbacksC0511f componentCallbacksC0511f) {
        o(i5, componentCallbacksC0511f, null, 1);
        return this;
    }

    public G c(int i5, ComponentCallbacksC0511f componentCallbacksC0511f, String str) {
        o(i5, componentCallbacksC0511f, str, 1);
        return this;
    }

    G d(ViewGroup viewGroup, ComponentCallbacksC0511f componentCallbacksC0511f, String str) {
        componentCallbacksC0511f.f10612H = viewGroup;
        return c(viewGroup.getId(), componentCallbacksC0511f, str);
    }

    public G e(ComponentCallbacksC0511f componentCallbacksC0511f, String str) {
        o(0, componentCallbacksC0511f, str, 1);
        return this;
    }

    void f(a aVar) {
        this.f10430c.add(aVar);
        aVar.f10450d = this.f10431d;
        aVar.f10451e = this.f10432e;
        aVar.f10452f = this.f10433f;
        aVar.f10453g = this.f10434g;
    }

    public G g(String str) {
        if (!this.f10437j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f10436i = true;
        this.f10438k = str;
        return this;
    }

    public G h(ComponentCallbacksC0511f componentCallbacksC0511f) {
        f(new a(7, componentCallbacksC0511f));
        return this;
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    public G m(ComponentCallbacksC0511f componentCallbacksC0511f) {
        f(new a(6, componentCallbacksC0511f));
        return this;
    }

    public G n() {
        if (this.f10436i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f10437j = false;
        return this;
    }

    void o(int i5, ComponentCallbacksC0511f componentCallbacksC0511f, String str, int i6) {
        String str2 = componentCallbacksC0511f.f10621T;
        if (str2 != null) {
            T.c.f(componentCallbacksC0511f, str2);
        }
        Class<?> cls = componentCallbacksC0511f.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = componentCallbacksC0511f.f10657z;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + componentCallbacksC0511f + ": was " + componentCallbacksC0511f.f10657z + " now " + str);
            }
            componentCallbacksC0511f.f10657z = str;
        }
        if (i5 != 0) {
            if (i5 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + componentCallbacksC0511f + " with tag " + str + " to container view with no id");
            }
            int i7 = componentCallbacksC0511f.f10655x;
            if (i7 != 0 && i7 != i5) {
                throw new IllegalStateException("Can't change container ID of fragment " + componentCallbacksC0511f + ": was " + componentCallbacksC0511f.f10655x + " now " + i5);
            }
            componentCallbacksC0511f.f10655x = i5;
            componentCallbacksC0511f.f10656y = i5;
        }
        f(new a(i6, componentCallbacksC0511f));
    }

    public G p(ComponentCallbacksC0511f componentCallbacksC0511f) {
        f(new a(4, componentCallbacksC0511f));
        return this;
    }

    public abstract boolean q();

    public G r(ComponentCallbacksC0511f componentCallbacksC0511f) {
        f(new a(3, componentCallbacksC0511f));
        return this;
    }

    public G s(int i5, ComponentCallbacksC0511f componentCallbacksC0511f) {
        return t(i5, componentCallbacksC0511f, null);
    }

    public G t(int i5, ComponentCallbacksC0511f componentCallbacksC0511f, String str) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        o(i5, componentCallbacksC0511f, str, 2);
        return this;
    }

    public G u(ComponentCallbacksC0511f componentCallbacksC0511f, AbstractC0533m.b bVar) {
        f(new a(10, componentCallbacksC0511f, bVar));
        return this;
    }

    public G v(boolean z5) {
        this.f10445r = z5;
        return this;
    }

    public G w(ComponentCallbacksC0511f componentCallbacksC0511f) {
        f(new a(5, componentCallbacksC0511f));
        return this;
    }
}

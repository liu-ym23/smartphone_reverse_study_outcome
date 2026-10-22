package androidx.fragment.app;

import android.view.Lifecycle;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class K {

    /* renamed from: a, reason: collision with root package name */
    public final v f13993a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassLoader f13994b;

    /* renamed from: d, reason: collision with root package name */
    public int f13996d;

    /* renamed from: e, reason: collision with root package name */
    public int f13997e;

    /* renamed from: f, reason: collision with root package name */
    public int f13998f;

    /* renamed from: g, reason: collision with root package name */
    public int f13999g;

    /* renamed from: h, reason: collision with root package name */
    public int f14000h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14001i;

    /* renamed from: k, reason: collision with root package name */
    public String f14003k;

    /* renamed from: l, reason: collision with root package name */
    public int f14004l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f14005m;

    /* renamed from: n, reason: collision with root package name */
    public int f14006n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f14007o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<String> f14008p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<String> f14009q;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<Runnable> f14011s;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<a> f13995c = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public boolean f14002j = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14010r = false;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f14012a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f14013b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14014c;

        /* renamed from: d, reason: collision with root package name */
        public int f14015d;

        /* renamed from: e, reason: collision with root package name */
        public int f14016e;

        /* renamed from: f, reason: collision with root package name */
        public int f14017f;

        /* renamed from: g, reason: collision with root package name */
        public int f14018g;

        /* renamed from: h, reason: collision with root package name */
        public Lifecycle.State f14019h;

        /* renamed from: i, reason: collision with root package name */
        public Lifecycle.State f14020i;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f14012a = i10;
            this.f14013b = fragment;
            this.f14014c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f14019h = state;
            this.f14020i = state;
        }

        public a(int i10, Fragment fragment, boolean z10) {
            this.f14012a = i10;
            this.f14013b = fragment;
            this.f14014c = z10;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f14019h = state;
            this.f14020i = state;
        }

        public a(int i10, Fragment fragment, Lifecycle.State state) {
            this.f14012a = i10;
            this.f14013b = fragment;
            this.f14014c = false;
            this.f14019h = fragment.mMaxState;
            this.f14020i = state;
        }
    }

    public K(v vVar, ClassLoader classLoader) {
        this.f13993a = vVar;
        this.f13994b = classLoader;
    }

    public K b(int i10, Fragment fragment, String str) {
        l(i10, fragment, str, 1);
        return this;
    }

    public final K c(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        fragment.mInDynamicContainer = true;
        return b(viewGroup.getId(), fragment, str);
    }

    public K d(Fragment fragment, String str) {
        l(0, fragment, str, 1);
        return this;
    }

    public void e(a aVar) {
        this.f13995c.add(aVar);
        aVar.f14015d = this.f13996d;
        aVar.f14016e = this.f13997e;
        aVar.f14017f = this.f13998f;
        aVar.f14018g = this.f13999g;
    }

    public K f(String str) {
        if (!this.f14002j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f14001i = true;
        this.f14003k = str;
        return this;
    }

    public abstract int g();

    public abstract int h();

    public abstract void i();

    public abstract void j();

    public K k() {
        if (this.f14001i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f14002j = false;
        return this;
    }

    public void l(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i12 = fragment.mFragmentId;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i10);
            }
            fragment.mFragmentId = i10;
            fragment.mContainerId = i10;
        }
        e(new a(i11, fragment));
    }

    public K m(Fragment fragment) {
        e(new a(4, fragment));
        return this;
    }

    public abstract boolean n();

    public K o(Fragment fragment) {
        e(new a(3, fragment));
        return this;
    }

    public K p(int i10, Fragment fragment) {
        return q(i10, fragment, null);
    }

    public K q(int i10, Fragment fragment, String str) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        l(i10, fragment, str, 2);
        return this;
    }

    public K r(boolean z10, Runnable runnable) {
        if (!z10) {
            k();
        }
        if (this.f14011s == null) {
            this.f14011s = new ArrayList<>();
        }
        this.f14011s.add(runnable);
        return this;
    }

    public K s(int i10, int i11) {
        return t(i10, i11, 0, 0);
    }

    public K t(int i10, int i11, int i12, int i13) {
        this.f13996d = i10;
        this.f13997e = i11;
        this.f13998f = i12;
        this.f13999g = i13;
        return this;
    }

    public K u(Fragment fragment, Lifecycle.State state) {
        e(new a(10, fragment, state));
        return this;
    }

    public K v(boolean z10) {
        this.f14010r = z10;
        return this;
    }
}

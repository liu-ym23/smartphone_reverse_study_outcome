package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f2095a;

    /* renamed from: b, reason: collision with root package name */
    public int f2096b;

    /* renamed from: c, reason: collision with root package name */
    public int f2097c;

    /* renamed from: d, reason: collision with root package name */
    public int f2098d;

    /* renamed from: e, reason: collision with root package name */
    public int f2099e;

    /* renamed from: f, reason: collision with root package name */
    public int f2100f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2101g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public String f2102i;

    /* renamed from: j, reason: collision with root package name */
    public int f2103j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f2104k;

    /* renamed from: l, reason: collision with root package name */
    public int f2105l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f2106m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<String> f2107n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<String> f2108o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2109p;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f2110a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f2111b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2112c;

        /* renamed from: d, reason: collision with root package name */
        public int f2113d;

        /* renamed from: e, reason: collision with root package name */
        public int f2114e;

        /* renamed from: f, reason: collision with root package name */
        public int f2115f;

        /* renamed from: g, reason: collision with root package name */
        public int f2116g;
        public Lifecycle.State h;

        /* renamed from: i, reason: collision with root package name */
        public Lifecycle.State f2117i;

        public a() {
        }

        public a(Fragment fragment, int i10) {
            this.f2110a = i10;
            this.f2111b = fragment;
            this.f2112c = false;
            Lifecycle.State state = Lifecycle.State.f2218e;
            this.h = state;
            this.f2117i = state;
        }

        public a(int i10, Fragment fragment, int i11) {
            this.f2110a = i10;
            this.f2111b = fragment;
            this.f2112c = true;
            Lifecycle.State state = Lifecycle.State.f2218e;
            this.h = state;
            this.f2117i = state;
        }
    }

    public final void b(a aVar) {
        this.f2095a.add(aVar);
        aVar.f2113d = this.f2096b;
        aVar.f2114e = this.f2097c;
        aVar.f2115f = this.f2098d;
        aVar.f2116g = this.f2099e;
    }

    public final void c() {
        if (!this.h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f2101g = true;
        this.f2102i = null;
    }

    public abstract void d(int i10, Fragment fragment, String str, int i11);

    public final void e(Fragment fragment, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        d(i10, fragment, null, 2);
    }
}

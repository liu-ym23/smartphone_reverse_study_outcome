package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentTransaction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f3243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassLoader f3244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f3245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f3253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f3255m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3256n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f3257o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f3258p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f3259q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3260r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList f3261s;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f3263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3267f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3268g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Lifecycle.State f3269h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Lifecycle.State f3270i;

        public a() {
        }

        public a(int r10, Fragment r11) {
            this.f3262a = r10;
            this.f3263b = r11;
            this.f3264c = false;
            Lifecycle.State r12 = Lifecycle.State.RESUMED;
            this.f3269h = r12;
            this.f3270i = r12;
        }

        public a(int r10, Fragment r11, boolean r12) {
            this.f3262a = r10;
            this.f3263b = r11;
            this.f3264c = r12;
            Lifecycle.State r13 = Lifecycle.State.RESUMED;
            this.f3269h = r13;
            this.f3270i = r13;
        }

        public a(int r10, Fragment r11, Lifecycle.State r12) {
            this.f3262a = r10;
            this.f3263b = r11;
            this.f3264c = false;
            this.f3269h = r11.mMaxState;
            this.f3270i = r12;
        }

        public a(a r10) {
            this.f3262a = r10.f3262a;
            this.f3263b = r10.f3263b;
            this.f3264c = r10.f3264c;
            this.f3265d = r10.f3265d;
            this.f3266e = r10.f3266e;
            this.f3267f = r10.f3267f;
            this.f3268g = r10.f3268g;
            this.f3269h = r10.f3269h;
            this.f3270i = r10.f3270i;
        }
    }

    public FragmentTransaction(p r10, ClassLoader r11) {
        this.f3245c = new ArrayList();
        this.f3252j = true;
        this.f3260r = false;
        this.f3243a = r10;
        this.f3244b = r11;
    }

    public FragmentTransaction A(Fragment r10) {
        f(new a(5, r10));
        return this;
    }

    public FragmentTransaction a(int r10, Fragment r11) {
        q(r10, r11, null, 1);
        return this;
    }

    public FragmentTransaction b(int r10, Fragment r11, String r12) {
        q(r10, r11, r12, 1);
        return this;
    }

    public final FragmentTransaction c(int r10, Class r11, Bundle r12, String r13) {
        return b(r10, n(r11, r12), r13);
    }

    public FragmentTransaction d(ViewGroup r10, Fragment r11, String r12) {
        r11.mContainer = r10;
        return b(r10.getId(), r11, r12);
    }

    public FragmentTransaction e(Fragment r10, String r11) {
        q(0, r10, r11, 1);
        return this;
    }

    public void f(a r10) {
        this.f3245c.add(r10);
        r10.f3265d = this.f3246d;
        r10.f3266e = this.f3247e;
        r10.f3267f = this.f3248f;
        r10.f3268g = this.f3249g;
    }

    public FragmentTransaction g(View r10, String r11) {
        if (d0.f() == false) goto L20;
        String r12 = ViewCompat.J(r10);
        if (r12 == null) goto L19;
        if (this.f3258p != null) goto L10;
        this.f3258p = new ArrayList();
        this.f3259q = new ArrayList();
    L13:
        this.f3258p.add(r12);
        this.f3259q.add(r11);
        goto L20
    L10:
        if (this.f3259q.contains(r11) == true) goto L17;
        if (this.f3258p.contains(r12) == false) goto L13;
        throw new IllegalArgumentException("A shared element with the source name '" + r12 + "' has already been added to the transaction.");
    L17:
        throw new IllegalArgumentException("A shared element with the target name '" + r11 + "' has already been added to the transaction.");
    L19:
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
    L20:
        return this;
    }

    public FragmentTransaction h(String r10) {
        if (this.f3252j == false) goto L7;
        this.f3251i = true;
        this.f3253k = r10;
        return this;
    L7:
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public FragmentTransaction i(Fragment r10) {
        f(new a(7, r10));
        return this;
    }

    public abstract int j();

    public abstract int k();

    public abstract void l();

    public abstract void m();

    public final Fragment n(Class r10, Bundle r11) {
        p r12 = this.f3243a;
        if (r12 == null) goto L13;
        ClassLoader r13 = this.f3244b;
        if (r13 == null) goto L11;
        Fragment r14 = r12.a(r13, r10.getName());
        if (r11 == null) goto L9;
        r14.setArguments(r11);
    L9:
        return r14;
    L11:
        throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
    L13:
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    public FragmentTransaction o(Fragment r10) {
        f(new a(6, r10));
        return this;
    }

    public FragmentTransaction p() {
        if (this.f3251i == true) goto L7;
        this.f3252j = false;
        return this;
    L7:
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void q(int r10, Fragment r11, String r12, int r13) {
        String r14 = r11.mPreviousWho;
        if (r14 == null) goto L5;
        FragmentStrictMode.h(r11, r14);
    L5:
        Class<?> r15 = r11.getClass();
        int r16 = r15.getModifiers();
        if (r15.isAnonymousClass() == true) goto L38;
        if (Modifier.isPublic(r16) == false) goto L38;
        if (r15.isMemberClass() == false) goto L14;
        if (Modifier.isStatic(r16) == false) goto L38;
    L14:
        if (r12 == null) goto L23;
        String r17 = r11.mTag;
        if (r17 != null) goto L18;
    L22:
        r11.mTag = r12;
        goto L23
    L18:
        if (r12.equals(r17) == true) goto L22;
        throw new IllegalStateException("Can't change tag of fragment " + r11 + ": was " + r11.mTag + " now " + r12);
    L23:
        if (r10 != 0) goto L25;
    L35:
        f(new a(r13, r11));
        return;
    L25:
        if (r10 == (-1)) goto L34;
        int r18 = r11.mFragmentId;
        if (r18 == 0) goto L32;
        if (r18 == r10) goto L32;
        throw new IllegalStateException("Can't change container ID of fragment " + r11 + ": was " + r11.mFragmentId + " now " + r10);
    L32:
        r11.mFragmentId = r10;
        r11.mContainerId = r10;
        goto L35
    L34:
        throw new IllegalArgumentException("Can't add fragment " + r11 + " with tag " + r12 + " to container view with no id");
    L38:
        throw new IllegalStateException("Fragment " + r15.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public FragmentTransaction r(Fragment r10) {
        f(new a(4, r10));
        return this;
    }

    public boolean s() {
        return this.f3245c.isEmpty();
    }

    public FragmentTransaction t(Fragment r10) {
        f(new a(3, r10));
        return this;
    }

    public FragmentTransaction u(int r10, Fragment r11) {
        return v(r10, r11, null);
    }

    public FragmentTransaction v(int r10, Fragment r11, String r12) {
        if (r10 == 0) goto L6;
        q(r10, r11, r12, 2);
        return this;
    L6:
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public FragmentTransaction w(int r10, int r11, int r12, int r13) {
        this.f3246d = r10;
        this.f3247e = r11;
        this.f3248f = r12;
        this.f3249g = r13;
        return this;
    }

    public FragmentTransaction x(Fragment r10, Lifecycle.State r11) {
        f(new a(10, r10, r11));
        return this;
    }

    public FragmentTransaction y(Fragment r10) {
        f(new a(8, r10));
        return this;
    }

    public FragmentTransaction z(boolean r10) {
        this.f3260r = r10;
        return this;
    }

    public FragmentTransaction(p r10, ClassLoader r11, FragmentTransaction r12) {
        this(r10, r11);
        Iterator r13 = r12.f3245c.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        a r14 = (a) r13.next();
        this.f3245c.add(new a(r14));
        goto L4
    L6:
        this.f3246d = r12.f3246d;
        this.f3247e = r12.f3247e;
        this.f3248f = r12.f3248f;
        this.f3249g = r12.f3249g;
        this.f3250h = r12.f3250h;
        this.f3251i = r12.f3251i;
        this.f3252j = r12.f3252j;
        this.f3253k = r12.f3253k;
        this.f3256n = r12.f3256n;
        this.f3257o = r12.f3257o;
        this.f3254l = r12.f3254l;
        this.f3255m = r12.f3255m;
        if (r12.f3258p == null) goto L10;
        ArrayList r15 = new ArrayList();
        this.f3258p = r15;
        r15.addAll(r12.f3258p);
    L10:
        if (r12.f3259q == null) goto L12;
        ArrayList r16 = new ArrayList();
        this.f3259q = r16;
        r16.addAll(r12.f3259q);
    L12:
        this.f3260r = r12.f3260r;
    }
}

package androidx.fragment.app;

import android.view.ViewGroup;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransaction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentFactory f1824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f1825b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<a> f1826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1827e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    boolean k;
    String l;
    int m;
    CharSequence n;
    int o;
    CharSequence p;
    ArrayList<String> q;
    ArrayList<String> r;
    boolean s;
    ArrayList<Runnable> t;

    /* JADX INFO: compiled from: FragmentTransaction.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Fragment f1829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1830c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1831d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1832e;
        int f;
        androidx.lifecycle.i.b g;
        androidx.lifecycle.i.b h;

        a() {
        }

        a(int r1, Fragment r2) {
            this.f1828a = r1;
            this.f1829b = r2;
            this.g = androidx.lifecycle.i.b.f2058e;
            this.h = androidx.lifecycle.i.b.f2058e;
        }

        a(int r1, Fragment r2, androidx.lifecycle.i.b r3) {
            this.f1828a = r1;
            this.f1829b = r2;
            this.g = r2.mMaxState;
            this.h = r3;
        }
    }

    public abstract int b();

    public abstract int c();

    public abstract void d();

    public abstract void e();

    m(FragmentFactory r2, ClassLoader r3) {
        this.f1826d = new ArrayList();
        this.k = true;
        this.s = false;
        this.f1824a = r2;
        this.f1825b = r3;
    }

    void a(a r2) {
        this.f1826d.add(r2);
        r2.f1830c = this.f1827e;
        r2.f1831d = this.f;
        r2.f1832e = this.g;
        r2.f = this.h;
    }

    public m a(Fragment r3, String r4) {
        a(0, r3, r4, 1);
        return this;
    }

    public m a(int r3, Fragment r4) {
        a(r3, r4, null, 1);
        return this;
    }

    public m a(int r2, Fragment r3, String r4) {
        a(r2, r3, r4, 1);
        return this;
    }

    m a(ViewGroup r1, Fragment r2, String r3) {
        r2.mContainer = r1;
        return a(r1.getId(), r2, r3);
    }

    void a(int r4, Fragment r5, String r6, int r7) {
        Class<?> r0 = r5.getClass();
        int r1 = r0.getModifiers();
        if (r0.isAnonymousClass() == true) goto L36;
        if (Modifier.isPublic(r1) == false) goto L36;
        if (r0.isMemberClass() == false) goto L11;
        if (Modifier.isStatic(r1) == false) goto L36;
    L11:
        if (r6 != null) goto L13;
    L20:
        if (r4 != 0) goto L22;
    L33:
        a(new a(r7, r5));
        return;
    L22:
        if (r4 == (-1)) goto L32;
        if (r5.mFragmentId != 0) goto L26;
    L30:
        r5.mFragmentId = r4;
        r5.mContainerId = r4;
        goto L33
    L26:
        if (r5.mFragmentId == r4) goto L30;
        throw new IllegalStateException("Can't change container ID of fragment " + r5 + ": was " + r5.mFragmentId + " now " + r4);
    L32:
        throw new IllegalArgumentException("Can't add fragment " + r5 + " with tag " + r6 + " to container view with no id");
    L13:
        if (r5.mTag != null) goto L15;
    L19:
        r5.mTag = r6;
        goto L20
    L15:
        if (r6.equals(r5.mTag) == true) goto L19;
        throw new IllegalStateException("Can't change tag of fragment " + r5 + ": was " + r5.mTag + " now " + r6);
    L36:
        throw new IllegalStateException("Fragment " + r0.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public m b(int r2, Fragment r3) {
        return b(r2, r3, null);
    }

    public m b(int r2, Fragment r3, String r4) {
        if (r2 == 0) goto L6;
        a(r2, r3, r4, 2);
        return this;
    L6:
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public m a(Fragment r3) {
        a(new a(3, r3));
        return this;
    }

    public m b(Fragment r3) {
        a(new a(4, r3));
        return this;
    }

    public m c(Fragment r3) {
        a(new a(5, r3));
        return this;
    }

    public m d(Fragment r3) {
        a(new a(6, r3));
        return this;
    }

    public m e(Fragment r3) {
        a(new a(7, r3));
        return this;
    }

    public m a(Fragment r3, androidx.lifecycle.i.b r4) {
        a(new a(10, r3, r4));
        return this;
    }

    public boolean i() {
        return this.f1826d.isEmpty();
    }

    public m j() {
        if (this.j == true) goto L7;
        this.k = false;
        return this;
    L7:
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public m c(boolean r1) {
        this.s = r1;
        return this;
    }
}

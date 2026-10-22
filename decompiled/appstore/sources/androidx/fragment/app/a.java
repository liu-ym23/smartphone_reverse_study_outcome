package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FragmentManager f3294t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3295u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3296v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3297w;

    public a(FragmentManager r10) {
        p r11 = r10.v0();
        if (r10.y0() == null) goto L5;
        ClassLoader r12 = r10.y0().e().getClassLoader();
    L6:
        super(r11, r12);
        this.f3296v = -1;
        this.f3297w = false;
        this.f3294t = r10;
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction A(Fragment r10) {
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L10;
        if (r11 == this.f3294t) goto L10;
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.A(r10);
    }

    public void B(int r10) {
        if (this.f3251i == true) goto L6;
        return;
    L6:
        if (FragmentManager.L0(2) == false) goto L8;
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + r10);
    L8:
        int r11 = this.f3245c.size();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L16;
        FragmentTransaction.a r13 = (FragmentTransaction.a) this.f3245c.get(r12);
        Fragment r14 = r13.f3263b;
        if (r14 == null) goto L15;
        r14.mBackStackNesting += r10;
        if (FragmentManager.L0(2) == false) goto L15;
        Log.v("FragmentManager", "Bump nesting of " + r13.f3263b + " to " + r13.f3263b.mBackStackNesting);
    L15:
        r12 = r12 + 1;
        goto L9
    }

    public void C() {
        int r10 = this.f3245c.size() - 1;
    L3:
        if (r10 < 0) goto L19;
        FragmentTransaction.a r11 = (FragmentTransaction.a) this.f3245c.get(r10);
        if (r11.f3264c == false) goto L18;
        if (r11.f3262a != 8) goto L10;
        r11.f3264c = false;
        this.f3245c.remove(r10 - 1);
        r10 = r10 - 1;
        goto L18
    L10:
        int r12 = r11.f3263b.mContainerId;
        r11.f3262a = 2;
        r11.f3264c = false;
        int r13 = r10 - 1;
    L11:
        if (r13 < 0) goto L18;
        FragmentTransaction.a r14 = (FragmentTransaction.a) this.f3245c.get(r13);
        if (r14.f3264c == false) goto L17;
        if (r14.f3263b.mContainerId != r12) goto L17;
        this.f3245c.remove(r13);
        r10 = r10 - 1;
    L17:
        r13 = r13 - 1;
    L18:
        r10 = r10 - 1;
        goto L3
    }

    public int D(boolean r10) {
        if (this.f3295u == true) goto L14;
        if (FragmentManager.L0(2) == false) goto L7;
        Log.v("FragmentManager", "Commit: " + this);
        PrintWriter r11 = new PrintWriter(new g0("FragmentManager"));
        E("  ", r11);
        r11.close();
    L7:
        this.f3295u = true;
        if (this.f3251i == false) goto L10;
        this.f3296v = this.f3294t.l();
    L11:
        this.f3294t.Y(this, r10);
        return this.f3296v;
    L10:
        this.f3296v = -1;
        goto L11
    L14:
        throw new IllegalStateException("commit already called");
    }

    public void E(String r10, PrintWriter r11) {
        F(r10, r11, true);
    }

    public void F(String r10, PrintWriter r11, boolean r12) {
        if (r12 == false) goto L27;
        r11.print(r10);
        r11.print("mName=");
        r11.print(this.f3253k);
        r11.print(" mIndex=");
        r11.print(this.f3296v);
        r11.print(" mCommitted=");
        r11.println(this.f3295u);
        if (this.f3250h == 0) goto L7;
        r11.print(r10);
        r11.print("mTransition=#");
        r11.print(Integer.toHexString(this.f3250h));
    L7:
        if (this.f3246d == 0) goto L9;
    L10:
        r11.print(r10);
        r11.print("mEnterAnim=#");
        r11.print(Integer.toHexString(this.f3246d));
        r11.print(" mExitAnim=#");
        r11.println(Integer.toHexString(this.f3247e));
    L12:
        if (this.f3248f == 0) goto L14;
    L15:
        r11.print(r10);
        r11.print("mPopEnterAnim=#");
        r11.print(Integer.toHexString(this.f3248f));
        r11.print(" mPopExitAnim=#");
        r11.println(Integer.toHexString(this.f3249g));
    L17:
        if (this.f3254l == 0) goto L19;
    L20:
        r11.print(r10);
        r11.print("mBreadCrumbTitleRes=#");
        r11.print(Integer.toHexString(this.f3254l));
        r11.print(" mBreadCrumbTitleText=");
        r11.println(this.f3255m);
    L22:
        if (this.f3256n == 0) goto L24;
    L25:
        r11.print(r10);
        r11.print("mBreadCrumbShortTitleRes=#");
        r11.print(Integer.toHexString(this.f3256n));
        r11.print(" mBreadCrumbShortTitleText=");
        r11.println(this.f3257o);
        goto L27
    L24:
        if (this.f3257o == null) goto L27;
    L19:
        if (this.f3255m == null) goto L22;
    L14:
        if (this.f3249g == 0) goto L17;
    L9:
        if (this.f3247e == 0) goto L12;
    L27:
        if (this.f3245c.isEmpty() == true) goto L57;
        r11.print(r10);
        r11.println("Operations:");
        int r13 = this.f3245c.size();
        int r14 = 0;
    L29:
        if (r14 >= r13) goto L62;
        FragmentTransaction.a r15 = (FragmentTransaction.a) this.f3245c.get(r14);
        switch(r15.f3262a) {
            case 0: goto L43;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            default: goto L32;
        };
    L32:
        String r16 = "cmd=" + r15.f3262a;
    L44:
        r11.print(r10);
        r11.print("  Op #");
        r11.print(r14);
        r11.print(": ");
        r11.print(r16);
        r11.print(" ");
        r11.println(r15.f3263b);
        if (r12 == false) goto L56;
        if (r15.f3265d == 0) goto L49;
    L50:
        r11.print(r10);
        r11.print("enterAnim=#");
        r11.print(Integer.toHexString(r15.f3265d));
        r11.print(" exitAnim=#");
        r11.println(Integer.toHexString(r15.f3266e));
    L52:
        if (r15.f3267f == 0) goto L54;
    L55:
        r11.print(r10);
        r11.print("popEnterAnim=#");
        r11.print(Integer.toHexString(r15.f3267f));
        r11.print(" popExitAnim=#");
        r11.println(Integer.toHexString(r15.f3268g));
        goto L56
    L54:
        if (r15.f3268g == 0) goto L56;
    L49:
        if (r15.f3266e == 0) goto L52;
    L56:
        r14 = r14 + 1;
        goto L29
    L33:
        r16 = "OP_SET_MAX_LIFECYCLE";
        goto L44
    L34:
        r16 = "UNSET_PRIMARY_NAV";
        goto L44
    L35:
        r16 = "SET_PRIMARY_NAV";
        goto L44
    L36:
        r16 = "ATTACH";
        goto L44
    L37:
        r16 = "DETACH";
        goto L44
    L38:
        r16 = "SHOW";
        goto L44
    L39:
        r16 = "HIDE";
        goto L44
    L40:
        r16 = "REMOVE";
        goto L44
    L41:
        r16 = "REPLACE";
        goto L44
    L42:
        r16 = "ADD";
        goto L44
    L43:
        r16 = "NULL";
        goto L44
    L62:
        return;
    }

    public void G() {
        int r10 = this.f3245c.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        FragmentTransaction.a r12 = (FragmentTransaction.a) this.f3245c.get(r11);
        Fragment r13 = r12.f3263b;
        if (r13 == null) goto L8;
        r13.mBeingSaved = this.f3297w;
        r13.setPopDirection(false);
        r13.setNextTransition(this.f3250h);
        r13.setSharedElementNames(this.f3258p, this.f3259q);
    L8:
        switch(r12.f3262a) {
            case 1: goto L19;
            case 2: goto L10;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        this.f3294t.C1(r13, r12.f3270i);
    L20:
        r11 = r11 + 1;
        goto L3
    L12:
        this.f3294t.D1(null);
        goto L20
    L13:
        this.f3294t.D1(r13);
        goto L20
    L14:
        r13.setAnimations(r12.f3265d, r12.f3266e, r12.f3267f, r12.f3268g);
        this.f3294t.B1(r13, false);
        this.f3294t.n(r13);
        goto L20
    L15:
        r13.setAnimations(r12.f3265d, r12.f3266e, r12.f3267f, r12.f3268g);
        this.f3294t.w(r13);
        goto L20
    L16:
        r13.setAnimations(r12.f3265d, r12.f3266e, r12.f3267f, r12.f3268g);
        this.f3294t.B1(r13, false);
        this.f3294t.F1(r13);
        goto L20
    L17:
        r13.setAnimations(r12.f3265d, r12.f3266e, r12.f3267f, r12.f3268g);
        this.f3294t.I0(r13);
        goto L20
    L18:
        r13.setAnimations(r12.f3265d, r12.f3266e, r12.f3267f, r12.f3268g);
        this.f3294t.o1(r13);
        goto L20
    L19:
        r13.setAnimations(r12.f3265d, r12.f3266e, r12.f3267f, r12.f3268g);
        this.f3294t.B1(r13, false);
        this.f3294t.j(r13);
        goto L20
    L10:
        throw new IllegalArgumentException("Unknown cmd: " + r12.f3262a);
    }

    public void H() {
        int r10 = this.f3245c.size() - 1;
    L3:
        if (r10 < 0) goto L21;
        FragmentTransaction.a r11 = (FragmentTransaction.a) this.f3245c.get(r10);
        Fragment r12 = r11.f3263b;
        if (r12 == null) goto L8;
        r12.mBeingSaved = this.f3297w;
        r12.setPopDirection(true);
        r12.setNextTransition(FragmentManager.v1(this.f3250h));
        r12.setSharedElementNames(this.f3259q, this.f3258p);
    L8:
        switch(r11.f3262a) {
            case 1: goto L19;
            case 2: goto L10;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        this.f3294t.C1(r12, r11.f3269h);
    L20:
        r10 = r10 - 1;
        goto L3
    L12:
        this.f3294t.D1(r12);
        goto L20
    L13:
        this.f3294t.D1(null);
        goto L20
    L14:
        r12.setAnimations(r11.f3265d, r11.f3266e, r11.f3267f, r11.f3268g);
        this.f3294t.B1(r12, true);
        this.f3294t.w(r12);
        goto L20
    L15:
        r12.setAnimations(r11.f3265d, r11.f3266e, r11.f3267f, r11.f3268g);
        this.f3294t.n(r12);
        goto L20
    L16:
        r12.setAnimations(r11.f3265d, r11.f3266e, r11.f3267f, r11.f3268g);
        this.f3294t.B1(r12, true);
        this.f3294t.I0(r12);
        goto L20
    L17:
        r12.setAnimations(r11.f3265d, r11.f3266e, r11.f3267f, r11.f3268g);
        this.f3294t.F1(r12);
        goto L20
    L18:
        r12.setAnimations(r11.f3265d, r11.f3266e, r11.f3267f, r11.f3268g);
        this.f3294t.j(r12);
        goto L20
    L19:
        r12.setAnimations(r11.f3265d, r11.f3266e, r11.f3267f, r11.f3268g);
        this.f3294t.B1(r12, true);
        this.f3294t.o1(r12);
        goto L20
    L10:
        throw new IllegalArgumentException("Unknown cmd: " + r11.f3262a);
    }

    public Fragment I(ArrayList r17, Fragment r18) {
        Fragment r10 = r18;
        int r11 = 0;
    L4:
        if (r11 >= this.f3245c.size()) goto L36;
        FragmentTransaction.a r12 = (FragmentTransaction.a) this.f3245c.get(r11);
        int r13 = r12.f3262a;
        if (r13 != 1) goto L8;
    L34:
        r17.add(r12.f3263b);
    L35:
        r11 = r11 + 1;
        goto L4
    L8:
        if (r13 == 2) goto L21;
        if (r13 != 3) goto L11;
    L18:
        r17.remove(r12.f3263b);
        Fragment r14 = r12.f3263b;
        if (r14 != r10) goto L35;
        this.f3245c.add(r11, new FragmentTransaction.a(9, r14));
        r11 = r11 + 1;
        r10 = null;
        goto L35
    L11:
        if (r13 == 6) goto L18;
        if (r13 == 7) goto L34;
        if (r13 != 8) goto L35;
        this.f3245c.add(r11, new FragmentTransaction.a(9, r10, true));
        r12.f3264c = true;
        r11 = r11 + 1;
        r10 = r12.f3263b;
        goto L35
    L21:
        Fragment r15 = r12.f3263b;
        int r16 = r15.mContainerId;
        int r19 = r17.size() - 1;
        boolean r110 = false;
    L22:
        if (r19 < 0) goto L31;
        Fragment r111 = (Fragment) r17.get(r19);
        if (r111.mContainerId != r16) goto L30;
        if (r111 != r15) goto L27;
        r110 = true;
        goto L30
    L27:
        if (r111 != r10) goto L29;
        this.f3245c.add(r11, new FragmentTransaction.a(9, r111, true));
        r11 = r11 + 1;
        r10 = null;
    L29:
        FragmentTransaction.a r112 = new FragmentTransaction.a(3, r111, true);
        r112.f3265d = r12.f3265d;
        r112.f3267f = r12.f3267f;
        r112.f3266e = r12.f3266e;
        r112.f3268g = r12.f3268g;
        this.f3245c.add(r11, r112);
        r17.remove(r111);
        r11 = r11 + 1;
    L30:
        r19 = r19 - 1;
        goto L22
    L31:
        if (r110 == false) goto L33;
        this.f3245c.remove(r11);
        r11 = r11 - 1;
        goto L35
    L33:
        r12.f3262a = 1;
        r12.f3264c = true;
        r17.add(r15);
        goto L35
    L36:
        return r10;
    }

    public void J() {
        if (this.f3261s == null) goto L11;
        int r10 = 0;
    L6:
        if (r10 >= this.f3261s.size()) goto L8;
        ((Runnable) this.f3261s.get(r10)).run();
        r10 = r10 + 1;
        goto L6
    L8:
        this.f3261s = null;
        return;
    }

    public Fragment K(ArrayList r10, Fragment r11) {
        int r12 = this.f3245c.size() - 1;
    L3:
        if (r12 < 0) goto L16;
        FragmentTransaction.a r13 = (FragmentTransaction.a) this.f3245c.get(r12);
        int r14 = r13.f3262a;
        if (r14 != 1) goto L7;
    L14:
        r10.remove(r13.f3263b);
    L15:
        r12 = r12 - 1;
        goto L3
    L7:
        if (r14 == 3) goto L13;
        switch(r14) {
            case 6: goto L13;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            default: goto L15;
        };
    L10:
        r13.f3270i = r13.f3269h;
        goto L15
    L11:
        r11 = r13.f3263b;
        goto L15
    L12:
        r11 = null;
    L13:
        r10.add(r13.f3263b);
        goto L15
    L16:
        return r11;
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean generateOps(ArrayList r10, ArrayList r11) {
        if (FragmentManager.L0(2) == false) goto L5;
        Log.v("FragmentManager", "Run: " + this);
    L5:
        r10.add(this);
        r11.add(Boolean.FALSE);
        if (this.f3251i == false) goto L10;
        this.f3294t.i(this);
        return true;
    L10:
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbShortTitle() {
        if (this.f3256n == 0) goto L7;
        return this.f3294t.y0().e().getText(this.f3256n);
    L7:
        return this.f3257o;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.f3256n;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbTitle() {
        if (this.f3254l == 0) goto L7;
        return this.f3294t.y0().e().getText(this.f3254l);
    L7:
        return this.f3255m;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.f3254l;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.f3296v;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public String getName() {
        return this.f3253k;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int j() {
        return D(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int k() {
        return D(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void l() {
        p();
        this.f3294t.b0(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void m() {
        p();
        this.f3294t.b0(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction o(Fragment r10) {
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L10;
        if (r11 == this.f3294t) goto L10;
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.o(r10);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void q(int r10, Fragment r11, String r12, int r13) {
        super.q(r10, r11, r12, r13);
        r11.mFragmentManager = this.f3294t;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction r(Fragment r10) {
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L10;
        if (r11 == this.f3294t) goto L10;
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.r(r10);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean s() {
        return this.f3245c.isEmpty();
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction t(Fragment r10) {
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L10;
        if (r11 == this.f3294t) goto L10;
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.t(r10);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("BackStackEntry{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3296v < 0) goto L6;
        r10.append(" #");
        r10.append(this.f3296v);
    L6:
        if (this.f3253k == null) goto L8;
        r10.append(" ");
        r10.append(this.f3253k);
    L8:
        r10.append("}");
        return r10.toString();
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction x(Fragment r10, Lifecycle.State r11) {
        if (r10.mFragmentManager != this.f3294t) goto L18;
        if (r11 != Lifecycle.State.INITIALIZED) goto L12;
        if (r10.mState <= (-1)) goto L12;
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r11 + " after the Fragment has been created");
    L12:
        if (r11 == Lifecycle.State.DESTROYED) goto L16;
        return super.x(r10, r11);
    L16:
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r11 + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    L18:
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f3294t);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction y(Fragment r10) {
        if (r10 == null) goto L11;
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L11;
        if (r11 == this.f3294t) goto L11;
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L11:
        return super.y(r10);
    }

    public a(a r10) {
        p r11 = r10.f3294t.v0();
        if (r10.f3294t.y0() == null) goto L5;
        ClassLoader r12 = r10.f3294t.y0().e().getClassLoader();
    L6:
        super(r11, r12, r10);
        this.f3296v = -1;
        this.f3297w = false;
        this.f3294t = r10.f3294t;
        this.f3295u = r10.f3295u;
        this.f3296v = r10.f3296v;
        this.f3297w = r10.f3297w;
        return;
    L5:
        r12 = null;
        goto L6
    }
}

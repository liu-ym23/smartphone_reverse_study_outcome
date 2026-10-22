package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BackStackRecord.java */
/* JADX INFO: loaded from: classes.dex */
final class a extends m implements FragmentManager.e {
    private static final String TAG = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final FragmentManager f1766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f1767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1768c;

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("BackStackEntry{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1768c < 0) goto L6;
        r0.append(" #");
        r0.append(this.f1768c);
    L6:
        if (this.l == null) goto L8;
        r0.append(" ");
        r0.append(this.l);
    L8:
        r0.append("}");
        return r0.toString();
    }

    public void a(String r2, PrintWriter r3) {
        a(r2, r3, true);
    }

    public void a(String r6, PrintWriter r7, boolean r8) {
        if (r8 == false) goto L27;
        r7.print(r6);
        r7.print("mName=");
        r7.print(this.l);
        r7.print(" mIndex=");
        r7.print(this.f1768c);
        r7.print(" mCommitted=");
        r7.println(this.f1767b);
        if (this.i == 0) goto L7;
        r7.print(r6);
        r7.print("mTransition=#");
        r7.print(Integer.toHexString(this.i));
    L7:
        if (this.f1827e == 0) goto L9;
    L10:
        r7.print(r6);
        r7.print("mEnterAnim=#");
        r7.print(Integer.toHexString(this.f1827e));
        r7.print(" mExitAnim=#");
        r7.println(Integer.toHexString(this.f));
    L12:
        if (this.g == 0) goto L14;
    L15:
        r7.print(r6);
        r7.print("mPopEnterAnim=#");
        r7.print(Integer.toHexString(this.g));
        r7.print(" mPopExitAnim=#");
        r7.println(Integer.toHexString(this.h));
    L17:
        if (this.m == 0) goto L19;
    L20:
        r7.print(r6);
        r7.print("mBreadCrumbTitleRes=#");
        r7.print(Integer.toHexString(this.m));
        r7.print(" mBreadCrumbTitleText=");
        r7.println(this.n);
    L22:
        if (this.o == 0) goto L24;
    L25:
        r7.print(r6);
        r7.print("mBreadCrumbShortTitleRes=#");
        r7.print(Integer.toHexString(this.o));
        r7.print(" mBreadCrumbShortTitleText=");
        r7.println(this.p);
        goto L27
    L24:
        if (this.p == null) goto L27;
    L19:
        if (this.n == null) goto L22;
    L14:
        if (this.h == 0) goto L17;
    L9:
        if (this.f == 0) goto L12;
    L27:
        if (this.f1826d.isEmpty() == true) goto L57;
        r7.print(r6);
        r7.println("Operations:");
        int r0 = this.f1826d.size();
        int r1 = 0;
    L29:
        if (r1 >= r0) goto L62;
        m.a r2 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r1), m.a.class, "com.obric.aiagent.plugin");
        switch(r2.f1828a) {
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
        String r3 = "cmd=" + r2.f1828a;
    L44:
        r7.print(r6);
        r7.print("  Op #");
        r7.print(r1);
        r7.print(": ");
        r7.print(r3);
        r7.print(" ");
        r7.println(r2.f1829b);
        if (r8 == false) goto L56;
        if (r2.f1830c == 0) goto L49;
    L50:
        r7.print(r6);
        r7.print("enterAnim=#");
        r7.print(Integer.toHexString(r2.f1830c));
        r7.print(" exitAnim=#");
        r7.println(Integer.toHexString(r2.f1831d));
    L52:
        if (r2.f1832e == 0) goto L54;
    L55:
        r7.print(r6);
        r7.print("popEnterAnim=#");
        r7.print(Integer.toHexString(r2.f1832e));
        r7.print(" popExitAnim=#");
        r7.println(Integer.toHexString(r2.f));
        goto L56
    L54:
        if (r2.f == 0) goto L56;
    L49:
        if (r2.f1831d == 0) goto L52;
    L56:
        r1 = r1 + 1;
        goto L29
    L33:
        r3 = "OP_SET_MAX_LIFECYCLE";
        goto L44
    L34:
        r3 = "UNSET_PRIMARY_NAV";
        goto L44
    L35:
        r3 = "SET_PRIMARY_NAV";
        goto L44
    L36:
        r3 = "ATTACH";
        goto L44
    L37:
        r3 = "DETACH";
        goto L44
    L38:
        r3 = "SHOW";
        goto L44
    L39:
        r3 = "HIDE";
        goto L44
    L40:
        r3 = "REMOVE";
        goto L44
    L41:
        r3 = "REPLACE";
        goto L44
    L42:
        r3 = "ADD";
        goto L44
    L43:
        r3 = "NULL";
        goto L44
    L62:
        return;
    }

    a(FragmentManager r5) {
        FragmentFactory r0 = r5.D();
        if (r5.l() == null) goto L5;
        ClassLoader r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.l().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getClassLoader();
    L6:
        super(r0, r1);
        this.f1768c = -1;
        this.f1766a = r5;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.fragment.app.m
    void a(int r1, Fragment r2, String r3, int r4) {
        super.a(r1, r2, r3, r4);
        r2.mFragmentManager = this.f1766a;
    }

    @Override // androidx.fragment.app.m
    public m a(Fragment r3) {
        if (r3.mFragmentManager == null) goto L10;
        if (r3.mFragmentManager == this.f1766a) goto L10;
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.a(r3);
    }

    @Override // androidx.fragment.app.m
    public m b(Fragment r3) {
        if (r3.mFragmentManager == null) goto L10;
        if (r3.mFragmentManager == this.f1766a) goto L10;
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.b(r3);
    }

    @Override // androidx.fragment.app.m
    public m c(Fragment r3) {
        if (r3.mFragmentManager == null) goto L10;
        if (r3.mFragmentManager == this.f1766a) goto L10;
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.c(r3);
    }

    @Override // androidx.fragment.app.m
    public m d(Fragment r3) {
        if (r3.mFragmentManager == null) goto L10;
        if (r3.mFragmentManager == this.f1766a) goto L10;
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.d(r3);
    }

    @Override // androidx.fragment.app.m
    public m a(Fragment r4, androidx.lifecycle.i.b r5) {
        if (r4.mFragmentManager != this.f1766a) goto L18;
        if (r5 != androidx.lifecycle.i.b.f2055b) goto L12;
        if (r4.mState <= (-1)) goto L12;
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r5 + " after the Fragment has been created");
    L12:
        if (r5 == androidx.lifecycle.i.b.f2054a) goto L16;
        return super.a(r4, r5);
    L16:
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r5 + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    L18:
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f1766a);
    }

    void a(int r8) {
        if (this.j == true) goto L6;
        return;
    L6:
        if (FragmentManager.a(2) == false) goto L8;
        a(TAG, "Bump nesting in " + this + " by " + r8);
    L8:
        int r1 = this.f1826d.size();
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L16;
        m.a r4 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r3), m.a.class, "com.obric.aiagent.plugin");
        if (r4.f1829b == null) goto L15;
        r4.f1829b.mBackStackNesting += r8;
        if (FragmentManager.a(2) == false) goto L15;
        a(TAG, "Bump nesting of " + r4.f1829b + " to " + r4.f1829b.mBackStackNesting);
    L15:
        r3 = r3 + 1;
        goto L9
    }

    public void a() {
        if (this.t == null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= this.t.size()) goto L8;
        ((Runnable) ZeusTransformUtils.preCheckCast(this.t.get(r0), Runnable.class, "com.obric.aiagent.plugin")).run();
        r0 = r0 + 1;
        goto L6
    L8:
        this.t = null;
        return;
    }

    @Override // androidx.fragment.app.m
    public int b() {
        return a(false);
    }

    @Override // androidx.fragment.app.m
    public int c() {
        return a(true);
    }

    @Override // androidx.fragment.app.m
    public void d() {
        j();
        this.f1766a.b(this, false);
    }

    @Override // androidx.fragment.app.m
    public void e() {
        j();
        this.f1766a.b(this, true);
    }

    int a(boolean r3) {
        if (this.f1767b == true) goto L14;
        if (FragmentManager.a(2) == false) goto L7;
        a(TAG, "Commit: " + this);
        PrintWriter r1 = new PrintWriter(new s(TAG));
        a("  ", r1);
        r1.close();
    L7:
        this.f1767b = true;
        if (this.j == false) goto L10;
        this.f1768c = this.f1766a.j();
    L11:
        this.f1766a.a(this, r3);
        return this.f1768c;
    L10:
        this.f1768c = -1;
        goto L11
    L14:
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.FragmentManager.e
    public boolean a(ArrayList<a> r3, ArrayList<Boolean> r4) {
        if (FragmentManager.a(2) == false) goto L5;
        a(TAG, "Run: " + this);
    L5:
        r3.add(this);
        r4.add(false);
        if (this.j == false) goto L10;
        this.f1766a.a(this);
        return true;
    L10:
        return true;
    }

    boolean b(int r7) {
        int r0 = this.f1826d.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        m.a r3 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r2), m.a.class, "com.obric.aiagent.plugin");
        if (r3.f1829b == null) goto L7;
        int r4 = r3.f1829b.mContainerId;
    L8:
        if (r4 == 0) goto L12;
        if (r4 != r7) goto L12;
        return true;
    L12:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = 0;
        goto L8
    L13:
        return false;
    }

    boolean a(ArrayList<a> r12, int r13, int r14) {
        if (r14 != r13) goto L5;
        return false;
    L5:
        int r1 = this.f1826d.size();
        int r2 = -1;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L28;
        m.a r4 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r3), m.a.class, "com.obric.aiagent.plugin");
        if (r4.f1829b == null) goto L10;
        int r5 = r4.f1829b.mContainerId;
    L11:
        if (r5 == 0) goto L27;
        if (r5 == r2) goto L27;
        int r6 = r13;
    L14:
        if (r6 >= r14) goto L26;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r12.get(r6), a.class, "com.obric.aiagent.plugin");
        int r8 = r7.f1826d.size();
        int r9 = 0;
    L16:
        if (r9 >= r8) goto L25;
        m.a r10 = (m.a) ZeusTransformUtils.preCheckCast(r7.f1826d.get(r9), m.a.class, "com.obric.aiagent.plugin");
        if (r10.f1829b == null) goto L20;
        int r11 = r10.f1829b.mContainerId;
    L21:
        if (r11 == r5) goto L22;
        r9 = r9 + 1;
        goto L16
    L22:
        return true;
    L20:
        r11 = 0;
        goto L21
    L25:
        r6 = r6 + 1;
        goto L14
    L26:
        r2 = r5;
    L27:
        r3 = r3 + 1;
        goto L6
    L10:
        r5 = 0;
        goto L11
    L28:
        return false;
    }

    void f() {
        int r0 = this.f1826d.size();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L31;
        m.a r4 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r2), m.a.class, "com.obric.aiagent.plugin");
        Fragment r5 = r4.f1829b;
        if (r5 == null) goto L9;
        r5.setPopDirection(false);
        r5.setNextTransition(this.i);
        r5.setSharedElementNames(this.q, this.r);
    L9:
        switch(r4.f1828a) {
            case 1: goto L20;
            case 2: goto L11;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        this.f1766a.a(r5, r4.h);
    L22:
        if (this.s == true) goto L29;
        if (r4.f1828a == 1) goto L29;
        if (r5 == null) goto L29;
        if (FragmentManager.f1731a == true) goto L29;
        this.f1766a.h(r5);
    L29:
        r2 = r2 + 1;
        goto L4
    L13:
        this.f1766a.p(null);
        goto L22
    L14:
        this.f1766a.p(r5);
        goto L22
    L15:
        r5.setAnimations(r4.f1830c, r4.f1831d, r4.f1832e, r4.f);
        this.f1766a.a(r5, false);
        this.f1766a.o(r5);
        goto L22
    L16:
        r5.setAnimations(r4.f1830c, r4.f1831d, r4.f1832e, r4.f);
        this.f1766a.n(r5);
        goto L22
    L17:
        r5.setAnimations(r4.f1830c, r4.f1831d, r4.f1832e, r4.f);
        this.f1766a.a(r5, false);
        this.f1766a.m(r5);
        goto L22
    L18:
        r5.setAnimations(r4.f1830c, r4.f1831d, r4.f1832e, r4.f);
        this.f1766a.l(r5);
        goto L22
    L19:
        r5.setAnimations(r4.f1830c, r4.f1831d, r4.f1832e, r4.f);
        this.f1766a.k(r5);
        goto L22
    L20:
        r5.setAnimations(r4.f1830c, r4.f1831d, r4.f1832e, r4.f);
        this.f1766a.a(r5, false);
        this.f1766a.j(r5);
        goto L22
    L11:
        throw new IllegalArgumentException("Unknown cmd: " + r4.f1828a);
    L31:
        if (this.s == false) goto L33;
        return;
    L33:
        if (FragmentManager.f1731a == true) goto L44;
        FragmentManager r10 = this.f1766a;
        r10.a(r10.f1734c, true);
        return;
    }

    void b(boolean r9) {
        int r0 = this.f1826d.size() - 1;
    L3:
        if (r0 < 0) goto L30;
        m.a r2 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r0), m.a.class, "com.obric.aiagent.plugin");
        Fragment r3 = r2.f1829b;
        if (r3 == null) goto L8;
        r3.setPopDirection(true);
        r3.setNextTransition(FragmentManager.d(this.i));
        r3.setSharedElementNames(this.r, this.q);
    L8:
        switch(r2.f1828a) {
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
        this.f1766a.a(r3, r2.g);
    L21:
        if (this.s == true) goto L28;
        if (r2.f1828a == 3) goto L28;
        if (r3 == null) goto L28;
        if (FragmentManager.f1731a == true) goto L28;
        this.f1766a.h(r3);
    L28:
        r0 = r0 - 1;
        goto L3
    L12:
        this.f1766a.p(r3);
        goto L21
    L13:
        this.f1766a.p(null);
        goto L21
    L14:
        r3.setAnimations(r2.f1830c, r2.f1831d, r2.f1832e, r2.f);
        this.f1766a.a(r3, true);
        this.f1766a.n(r3);
        goto L21
    L15:
        r3.setAnimations(r2.f1830c, r2.f1831d, r2.f1832e, r2.f);
        this.f1766a.o(r3);
        goto L21
    L16:
        r3.setAnimations(r2.f1830c, r2.f1831d, r2.f1832e, r2.f);
        this.f1766a.a(r3, true);
        this.f1766a.l(r3);
        goto L21
    L17:
        r3.setAnimations(r2.f1830c, r2.f1831d, r2.f1832e, r2.f);
        this.f1766a.m(r3);
        goto L21
    L18:
        r3.setAnimations(r2.f1830c, r2.f1831d, r2.f1832e, r2.f);
        this.f1766a.j(r3);
        goto L21
    L19:
        r3.setAnimations(r2.f1830c, r2.f1831d, r2.f1832e, r2.f);
        this.f1766a.a(r3, true);
        this.f1766a.k(r3);
        goto L21
    L10:
        throw new IllegalArgumentException("Unknown cmd: " + r2.f1828a);
    L30:
        if (this.s == true) goto L43;
        if (r9 == true) goto L33;
        return;
    L33:
        if (FragmentManager.f1731a == true) goto L45;
        FragmentManager r8 = this.f1766a;
        r8.a(r8.f1734c, true);
        return;
    L45:
        return;
    }

    Fragment a(ArrayList<Fragment> r17, Fragment r18) {
        Fragment r3 = r18;
        int r4 = 0;
    L4:
        if (r4 >= this.f1826d.size()) goto L36;
        m.a r5 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r4), m.a.class, "com.obric.aiagent.plugin");
        int r6 = r5.f1828a;
        if (r6 != 1) goto L8;
    L34:
        r17.add(r5.f1829b);
    L35:
        r4 = r4 + 1;
        goto L4
    L8:
        if (r6 == 2) goto L21;
        if (r6 != 3) goto L11;
    L18:
        r17.remove(r5.f1829b);
        if (r5.f1829b != r3) goto L35;
        this.f1826d.add(r4, new m.a(9, r5.f1829b));
        r4 = r4 + 1;
        r3 = null;
        goto L35
    L11:
        if (r6 == 6) goto L18;
        if (r6 == 7) goto L34;
        if (r6 != 8) goto L35;
        this.f1826d.add(r4, new m.a(9, r3));
        r4 = r4 + 1;
        r3 = r5.f1829b;
        goto L35
    L21:
        Fragment r7 = r5.f1829b;
        int r10 = r7.mContainerId;
        int r13 = r17.size() - 1;
        boolean r14 = false;
    L22:
        if (r13 < 0) goto L31;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(r17.get(r13), Fragment.class, "com.obric.aiagent.plugin");
        if (r2.mContainerId != r10) goto L30;
        if (r2 != r7) goto L27;
        r14 = true;
        goto L30
    L27:
        if (r2 != r3) goto L29;
        this.f1826d.add(r4, new m.a(9, r2));
        r4 = r4 + 1;
        r3 = null;
    L29:
        m.a r15 = new m.a(3, r2);
        r15.f1830c = r5.f1830c;
        r15.f1832e = r5.f1832e;
        r15.f1831d = r5.f1831d;
        r15.f = r5.f;
        this.f1826d.add(r4, r15);
        r17.remove(r2);
        r4 = r4 + 1;
    L30:
        r13 = r13 - 1;
        goto L22
    L31:
        if (r14 == false) goto L33;
        this.f1826d.remove(r4);
        r4 = r4 - 1;
        goto L35
    L33:
        r5.f1828a = 1;
        r17.add(r7);
        goto L35
    L36:
        return r3;
    }

    Fragment b(ArrayList<Fragment> r6, Fragment r7) {
        int r0 = this.f1826d.size() - 1;
    L3:
        if (r0 < 0) goto L16;
        m.a r2 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r0), m.a.class, "com.obric.aiagent.plugin");
        int r3 = r2.f1828a;
        if (r3 != 1) goto L7;
    L14:
        r6.remove(r2.f1829b);
    L15:
        r0 = r0 - 1;
        goto L3
    L7:
        if (r3 == 3) goto L13;
        switch(r3) {
            case 6: goto L13;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            default: goto L15;
        };
    L10:
        r2.h = r2.g;
        goto L15
    L11:
        r7 = r2.f1829b;
        goto L15
    L12:
        r7 = null;
    L13:
        r6.add(r2.f1829b);
        goto L15
    L16:
        return r7;
    }

    boolean g() {
        int r1 = 0;
    L4:
        if (r1 >= this.f1826d.size()) goto L10;
        if (b((m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r1), m.a.class, "com.obric.aiagent.plugin")) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    void a(Fragment.d r5) {
        Fragment.d r6 = (Fragment.d) ZeusTransformUtils.wrapperContextForParams(r5, Fragment.d.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= this.f1826d.size()) goto L9;
        m.a r2 = (m.a) ZeusTransformUtils.preCheckCast(this.f1826d.get(r0), m.a.class, "com.obric.aiagent.plugin");
        if (b(r2) == false) goto L8;
        r2.f1829b.setOnStartEnterTransitionListener(r6);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private static boolean b(m.a r1) {
        Fragment r2 = r1.f1829b;
        if (r2 != null) goto L5;
    L15:
        return false;
    L5:
        if (r2.mAdded == false) goto L15;
        if (r2.mView == null) goto L15;
        if (r2.mDetached == true) goto L15;
        if (r2.mHidden == true) goto L15;
        if (r2.isPostponed() == false) goto L15;
        return true;
    }

    public String h() {
        return this.l;
    }

    @Override // androidx.fragment.app.m
    public boolean i() {
        return this.f1826d.isEmpty();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}

package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.G;
import androidx.fragment.app.x;
import androidx.lifecycle.AbstractC0533m;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0506a extends G implements x.m {

    /* renamed from: t, reason: collision with root package name */
    final x f10516t;

    /* renamed from: u, reason: collision with root package name */
    boolean f10517u;

    /* renamed from: v, reason: collision with root package name */
    int f10518v;

    /* renamed from: w, reason: collision with root package name */
    boolean f10519w;

    C0506a(x xVar) {
        super(xVar.q0(), xVar.s0() != null ? xVar.s0().f().getClassLoader() : null);
        this.f10518v = -1;
        this.f10519w = false;
        this.f10516t = xVar;
    }

    public void A(String str, PrintWriter printWriter, boolean z5) {
        String str2;
        if (z5) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f10438k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f10518v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f10517u);
            if (this.f10435h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f10435h));
            }
            if (this.f10431d != 0 || this.f10432e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f10431d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f10432e));
            }
            if (this.f10433f != 0 || this.f10434g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f10433f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f10434g));
            }
            if (this.f10439l != 0 || this.f10440m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f10439l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f10440m);
            }
            if (this.f10441n != 0 || this.f10442o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f10441n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f10442o);
            }
        }
        if (this.f10430c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f10430c.size();
        for (int i5 = 0; i5 < size; i5++) {
            G.a aVar = this.f10430c.get(i5);
            switch (aVar.f10447a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f10447a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i5);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f10448b);
            if (z5) {
                if (aVar.f10450d != 0 || aVar.f10451e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f10450d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f10451e));
                }
                if (aVar.f10452f != 0 || aVar.f10453g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f10452f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f10453g));
                }
            }
        }
    }

    void B() {
        int size = this.f10430c.size();
        for (int i5 = 0; i5 < size; i5++) {
            G.a aVar = this.f10430c.get(i5);
            ComponentCallbacksC0511f componentCallbacksC0511f = aVar.f10448b;
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.f10645n = this.f10519w;
                componentCallbacksC0511f.L1(false);
                componentCallbacksC0511f.K1(this.f10435h);
                componentCallbacksC0511f.N1(this.f10443p, this.f10444q);
            }
            switch (aVar.f10447a) {
                case 1:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.h1(componentCallbacksC0511f, false);
                    this.f10516t.h(componentCallbacksC0511f);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f10447a);
                case 3:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.a1(componentCallbacksC0511f);
                    break;
                case 4:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.C0(componentCallbacksC0511f);
                    break;
                case 5:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.h1(componentCallbacksC0511f, false);
                    this.f10516t.l1(componentCallbacksC0511f);
                    break;
                case 6:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.u(componentCallbacksC0511f);
                    break;
                case 7:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.h1(componentCallbacksC0511f, false);
                    this.f10516t.l(componentCallbacksC0511f);
                    break;
                case 8:
                    this.f10516t.j1(componentCallbacksC0511f);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    this.f10516t.j1(null);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    this.f10516t.i1(componentCallbacksC0511f, aVar.f10455i);
                    break;
            }
        }
    }

    void C() {
        for (int size = this.f10430c.size() - 1; size >= 0; size--) {
            G.a aVar = this.f10430c.get(size);
            ComponentCallbacksC0511f componentCallbacksC0511f = aVar.f10448b;
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.f10645n = this.f10519w;
                componentCallbacksC0511f.L1(true);
                componentCallbacksC0511f.K1(x.e1(this.f10435h));
                componentCallbacksC0511f.N1(this.f10444q, this.f10443p);
            }
            switch (aVar.f10447a) {
                case 1:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.h1(componentCallbacksC0511f, true);
                    this.f10516t.a1(componentCallbacksC0511f);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f10447a);
                case 3:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.h(componentCallbacksC0511f);
                    break;
                case 4:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.l1(componentCallbacksC0511f);
                    break;
                case 5:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.h1(componentCallbacksC0511f, true);
                    this.f10516t.C0(componentCallbacksC0511f);
                    break;
                case 6:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.l(componentCallbacksC0511f);
                    break;
                case 7:
                    componentCallbacksC0511f.F1(aVar.f10450d, aVar.f10451e, aVar.f10452f, aVar.f10453g);
                    this.f10516t.h1(componentCallbacksC0511f, true);
                    this.f10516t.u(componentCallbacksC0511f);
                    break;
                case 8:
                    this.f10516t.j1(null);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    this.f10516t.j1(componentCallbacksC0511f);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    this.f10516t.i1(componentCallbacksC0511f, aVar.f10454h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.ComponentCallbacksC0511f D(java.util.ArrayList<androidx.fragment.app.ComponentCallbacksC0511f> r17, androidx.fragment.app.ComponentCallbacksC0511f r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList<androidx.fragment.app.G$a> r5 = r0.f10430c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList<androidx.fragment.app.G$a> r5 = r0.f10430c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.G$a r5 = (androidx.fragment.app.G.a) r5
            int r6 = r5.f10447a
            r7 = 1
            if (r6 == r7) goto Lb6
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L5a
            if (r6 == r10) goto L43
            r8 = 6
            if (r6 == r8) goto L43
            r8 = 7
            if (r6 == r8) goto Lb6
            r8 = 8
            if (r6 == r8) goto L31
            goto Lbb
        L31:
            java.util.ArrayList<androidx.fragment.app.G$a> r6 = r0.f10430c
            androidx.fragment.app.G$a r8 = new androidx.fragment.app.G$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.f10449c = r7
            int r4 = r4 + 1
            androidx.fragment.app.f r3 = r5.f10448b
            goto Lbb
        L43:
            androidx.fragment.app.f r6 = r5.f10448b
            r1.remove(r6)
            androidx.fragment.app.f r5 = r5.f10448b
            if (r5 != r3) goto Lbb
            java.util.ArrayList<androidx.fragment.app.G$a> r3 = r0.f10430c
            androidx.fragment.app.G$a r6 = new androidx.fragment.app.G$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.f r6 = r5.f10448b
            int r8 = r6.f10656y
            int r12 = r1.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.f r14 = (androidx.fragment.app.ComponentCallbacksC0511f) r14
            int r15 = r14.f10656y
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = r7
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList<androidx.fragment.app.G$a> r3 = r0.f10430c
            androidx.fragment.app.G$a r15 = new androidx.fragment.app.G$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.G$a r15 = new androidx.fragment.app.G$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.f10450d
            r15.f10450d = r2
            int r2 = r5.f10452f
            r15.f10452f = r2
            int r2 = r5.f10451e
            r15.f10451e = r2
            int r2 = r5.f10453g
            r15.f10453g = r2
            java.util.ArrayList<androidx.fragment.app.G$a> r2 = r0.f10430c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList<androidx.fragment.app.G$a> r2 = r0.f10430c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f10447a = r7
            r5.f10449c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.f r2 = r5.f10448b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0506a.D(java.util.ArrayList, androidx.fragment.app.f):androidx.fragment.app.f");
    }

    public String E() {
        return this.f10438k;
    }

    public void F() {
        if (this.f10446s != null) {
            for (int i5 = 0; i5 < this.f10446s.size(); i5++) {
                this.f10446s.get(i5).run();
            }
            this.f10446s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.ComponentCallbacksC0511f G(java.util.ArrayList<androidx.fragment.app.ComponentCallbacksC0511f> r6, androidx.fragment.app.ComponentCallbacksC0511f r7) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.fragment.app.G$a> r0 = r5.f10430c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList<androidx.fragment.app.G$a> r2 = r5.f10430c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.G$a r2 = (androidx.fragment.app.G.a) r2
            int r3 = r2.f10447a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.m$b r3 = r2.f10454h
            r2.f10455i = r3
            goto L32
        L22:
            androidx.fragment.app.f r7 = r2.f10448b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.f r2 = r2.f10448b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.f r2 = r2.f10448b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0506a.G(java.util.ArrayList, androidx.fragment.app.f):androidx.fragment.app.f");
    }

    @Override // androidx.fragment.app.x.m
    public boolean a(ArrayList<C0506a> arrayList, ArrayList<Boolean> arrayList2) {
        if (x.F0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f10436i) {
            return true;
        }
        this.f10516t.g(this);
        return true;
    }

    @Override // androidx.fragment.app.G
    public int i() {
        return y(false);
    }

    @Override // androidx.fragment.app.G
    public int j() {
        return y(true);
    }

    @Override // androidx.fragment.app.G
    public void k() {
        n();
        this.f10516t.Z(this, false);
    }

    @Override // androidx.fragment.app.G
    public void l() {
        n();
        this.f10516t.Z(this, true);
    }

    @Override // androidx.fragment.app.G
    public G m(ComponentCallbacksC0511f componentCallbacksC0511f) {
        x xVar = componentCallbacksC0511f.f10651t;
        if (xVar == null || xVar == this.f10516t) {
            return super.m(componentCallbacksC0511f);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + componentCallbacksC0511f.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.G
    void o(int i5, ComponentCallbacksC0511f componentCallbacksC0511f, String str, int i6) {
        super.o(i5, componentCallbacksC0511f, str, i6);
        componentCallbacksC0511f.f10651t = this.f10516t;
    }

    @Override // androidx.fragment.app.G
    public G p(ComponentCallbacksC0511f componentCallbacksC0511f) {
        x xVar = componentCallbacksC0511f.f10651t;
        if (xVar == null || xVar == this.f10516t) {
            return super.p(componentCallbacksC0511f);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + componentCallbacksC0511f.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.G
    public boolean q() {
        return this.f10430c.isEmpty();
    }

    @Override // androidx.fragment.app.G
    public G r(ComponentCallbacksC0511f componentCallbacksC0511f) {
        x xVar = componentCallbacksC0511f.f10651t;
        if (xVar == null || xVar == this.f10516t) {
            return super.r(componentCallbacksC0511f);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + componentCallbacksC0511f.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f10518v >= 0) {
            sb.append(" #");
            sb.append(this.f10518v);
        }
        if (this.f10438k != null) {
            sb.append(" ");
            sb.append(this.f10438k);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.G
    public G u(ComponentCallbacksC0511f componentCallbacksC0511f, AbstractC0533m.b bVar) {
        if (componentCallbacksC0511f.f10651t != this.f10516t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f10516t);
        }
        if (bVar == AbstractC0533m.b.INITIALIZED && componentCallbacksC0511f.f10628a > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + " after the Fragment has been created");
        }
        if (bVar != AbstractC0533m.b.DESTROYED) {
            return super.u(componentCallbacksC0511f, bVar);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    @Override // androidx.fragment.app.G
    public G w(ComponentCallbacksC0511f componentCallbacksC0511f) {
        x xVar = componentCallbacksC0511f.f10651t;
        if (xVar == null || xVar == this.f10516t) {
            return super.w(componentCallbacksC0511f);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + componentCallbacksC0511f.toString() + " is already attached to a FragmentManager.");
    }

    void x(int i5) {
        if (this.f10436i) {
            if (x.F0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i5);
            }
            int size = this.f10430c.size();
            for (int i6 = 0; i6 < size; i6++) {
                G.a aVar = this.f10430c.get(i6);
                ComponentCallbacksC0511f componentCallbacksC0511f = aVar.f10448b;
                if (componentCallbacksC0511f != null) {
                    componentCallbacksC0511f.f10650s += i5;
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f10448b + " to " + aVar.f10448b.f10650s);
                    }
                }
            }
        }
    }

    int y(boolean z5) {
        if (this.f10517u) {
            throw new IllegalStateException("commit already called");
        }
        if (x.F0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new L("FragmentManager"));
            z("  ", printWriter);
            printWriter.close();
        }
        this.f10517u = true;
        if (this.f10436i) {
            this.f10518v = this.f10516t.j();
        } else {
            this.f10518v = -1;
        }
        this.f10516t.W(this, z5);
        return this.f10518v;
    }

    public void z(String str, PrintWriter printWriter) {
        A(str, printWriter, true);
    }
}

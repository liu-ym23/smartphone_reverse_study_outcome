package androidx.fragment.app;

import android.util.Log;
import android.view.Lifecycle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.K;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1363a extends K implements FragmentManager.m {

    /* renamed from: t, reason: collision with root package name */
    public final FragmentManager f14083t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14084u;

    /* renamed from: v, reason: collision with root package name */
    public int f14085v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14086w;

    public C1363a(FragmentManager fragmentManager) {
        super(fragmentManager.x0(), fragmentManager.A0() != null ? fragmentManager.A0().getContext().getClassLoader() : null);
        this.f14085v = -1;
        this.f14086w = false;
        this.f14083t = fragmentManager;
    }

    public void A(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f14003k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f14085v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f14084u);
            if (this.f14000h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f14000h));
            }
            if (this.f13996d != 0 || this.f13997e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f13996d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f13997e));
            }
            if (this.f13998f != 0 || this.f13999g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f13998f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f13999g));
            }
            if (this.f14004l != 0 || this.f14005m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f14004l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f14005m);
            }
            if (this.f14006n != 0 || this.f14007o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f14006n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f14007o);
            }
        }
        if (this.f13995c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f13995c.size();
        for (int i10 = 0; i10 < size; i10++) {
            K.a aVar = this.f13995c.get(i10);
            switch (aVar.f14012a) {
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
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f14012a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f14013b);
            if (z10) {
                if (aVar.f14015d != 0 || aVar.f14016e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f14015d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f14016e));
                }
                if (aVar.f14017f != 0 || aVar.f14018g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f14017f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f14018g));
                }
            }
        }
    }

    public void B() {
        int size = this.f13995c.size();
        for (int i10 = 0; i10 < size; i10++) {
            K.a aVar = this.f13995c.get(i10);
            Fragment fragment = aVar.f14013b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f14086w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f14000h);
                fragment.setSharedElementNames(this.f14008p, this.f14009q);
            }
            switch (aVar.f14012a) {
                case 1:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.v1(fragment, false);
                    this.f14083t.j(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f14012a);
                case 3:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.m1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.K0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.v1(fragment, false);
                    this.f14083t.z1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.z(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.v1(fragment, false);
                    this.f14083t.p(fragment);
                    break;
                case 8:
                    this.f14083t.x1(fragment);
                    break;
                case 9:
                    this.f14083t.x1(null);
                    break;
                case 10:
                    aVar.f14019h = fragment.mMaxState;
                    this.f14083t.w1(fragment, aVar.f14020i);
                    break;
            }
        }
    }

    public void C() {
        for (int size = this.f13995c.size() - 1; size >= 0; size--) {
            K.a aVar = this.f13995c.get(size);
            Fragment fragment = aVar.f14013b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f14086w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.r1(this.f14000h));
                fragment.setSharedElementNames(this.f14009q, this.f14008p);
            }
            switch (aVar.f14012a) {
                case 1:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.v1(fragment, true);
                    this.f14083t.m1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f14012a);
                case 3:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.z1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.v1(fragment, true);
                    this.f14083t.K0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.p(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f14015d, aVar.f14016e, aVar.f14017f, aVar.f14018g);
                    this.f14083t.v1(fragment, true);
                    this.f14083t.z(fragment);
                    break;
                case 8:
                    this.f14083t.x1(null);
                    break;
                case 9:
                    this.f14083t.x1(fragment);
                    break;
                case 10:
                    aVar.f14020i = fragment.mMaxState;
                    this.f14083t.w1(fragment, aVar.f14019h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.Fragment D(java.util.ArrayList<androidx.fragment.app.Fragment> r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList<androidx.fragment.app.K$a> r5 = r0.f13995c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList<androidx.fragment.app.K$a> r5 = r0.f13995c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.K$a r5 = (androidx.fragment.app.K.a) r5
            int r6 = r5.f14012a
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
            java.util.ArrayList<androidx.fragment.app.K$a> r6 = r0.f13995c
            androidx.fragment.app.K$a r8 = new androidx.fragment.app.K$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.f14014c = r7
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.f14013b
            goto Lbb
        L43:
            androidx.fragment.app.Fragment r6 = r5.f14013b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f14013b
            if (r5 != r3) goto Lbb
            java.util.ArrayList<androidx.fragment.app.K$a> r3 = r0.f13995c
            androidx.fragment.app.K$a r6 = new androidx.fragment.app.K$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.Fragment r6 = r5.f14013b
            int r8 = r6.mContainerId
            int r12 = r1.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.mContainerId
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = r7
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList<androidx.fragment.app.K$a> r3 = r0.f13995c
            androidx.fragment.app.K$a r15 = new androidx.fragment.app.K$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.K$a r15 = new androidx.fragment.app.K$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.f14015d
            r15.f14015d = r2
            int r2 = r5.f14017f
            r15.f14017f = r2
            int r2 = r5.f14016e
            r15.f14016e = r2
            int r2 = r5.f14018g
            r15.f14018g = r2
            java.util.ArrayList<androidx.fragment.app.K$a> r2 = r0.f13995c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList<androidx.fragment.app.K$a> r2 = r0.f13995c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f14012a = r7
            r5.f14014c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.Fragment r2 = r5.f14013b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C1363a.D(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public String E() {
        return this.f14003k;
    }

    public void F() {
        if (this.f14011s != null) {
            for (int i10 = 0; i10 < this.f14011s.size(); i10++) {
                this.f14011s.get(i10).run();
            }
            this.f14011s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.Fragment G(java.util.ArrayList<androidx.fragment.app.Fragment> r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.fragment.app.K$a> r0 = r5.f13995c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList<androidx.fragment.app.K$a> r2 = r5.f13995c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.K$a r2 = (androidx.fragment.app.K.a) r2
            int r3 = r2.f14012a
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
            androidx.lifecycle.Lifecycle$State r3 = r2.f14019h
            r2.f14020i = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f14013b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f14013b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f14013b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C1363a.G(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentManager.m
    public boolean a(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f14001i) {
            return true;
        }
        this.f14083t.i(this);
        return true;
    }

    @Override // androidx.fragment.app.K
    public int g() {
        return y(false, true);
    }

    @Override // androidx.fragment.app.K
    public int h() {
        return y(true, true);
    }

    @Override // androidx.fragment.app.K
    public void i() {
        k();
        this.f14083t.e0(this, false);
    }

    @Override // androidx.fragment.app.K
    public void j() {
        k();
        this.f14083t.e0(this, true);
    }

    @Override // androidx.fragment.app.K
    public void l(int i10, Fragment fragment, String str, int i11) {
        super.l(i10, fragment, str, i11);
        fragment.mFragmentManager = this.f14083t;
    }

    @Override // androidx.fragment.app.K
    public K m(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f14083t) {
            return super.m(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.K
    public boolean n() {
        return this.f13995c.isEmpty();
    }

    @Override // androidx.fragment.app.K
    public K o(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f14083t) {
            return super.o(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f14085v >= 0) {
            sb2.append(" #");
            sb2.append(this.f14085v);
        }
        if (this.f14003k != null) {
            sb2.append(" ");
            sb2.append(this.f14003k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // androidx.fragment.app.K
    public K u(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f14083t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f14083t);
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.u(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    public void w(int i10) {
        if (this.f14001i) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.f13995c.size();
            for (int i11 = 0; i11 < size; i11++) {
                K.a aVar = this.f13995c.get(i11);
                Fragment fragment = aVar.f14013b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i10;
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f14013b + " to " + aVar.f14013b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void x() {
        int size = this.f13995c.size() - 1;
        while (size >= 0) {
            K.a aVar = this.f13995c.get(size);
            if (aVar.f14014c) {
                if (aVar.f14012a == 8) {
                    aVar.f14014c = false;
                    this.f13995c.remove(size - 1);
                    size--;
                } else {
                    int i10 = aVar.f14013b.mContainerId;
                    aVar.f14012a = 2;
                    aVar.f14014c = false;
                    for (int i11 = size - 1; i11 >= 0; i11--) {
                        K.a aVar2 = this.f13995c.get(i11);
                        if (aVar2.f14014c && aVar2.f14013b.mContainerId == i10) {
                            this.f13995c.remove(i11);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public int y(boolean z10, boolean z11) {
        if (this.f14084u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new P("FragmentManager"));
            z("  ", printWriter);
            printWriter.close();
        }
        this.f14084u = true;
        if (this.f14001i) {
            this.f14085v = this.f14083t.n();
        } else {
            this.f14085v = -1;
        }
        if (z11) {
            this.f14083t.b0(this, z10);
        }
        return this.f14085v;
    }

    public void z(String str, PrintWriter printWriter) {
        A(str, printWriter, true);
    }
}

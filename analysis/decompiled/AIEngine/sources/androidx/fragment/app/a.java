package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.d0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.preference.PreferenceHeaderFragmentCompat;
import com.stepos.core.common.util.TraceIdKeys;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends d0 implements FragmentManager.j, FragmentManager.m {

    /* renamed from: q, reason: collision with root package name */
    public final FragmentManager f2075q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public int f2076s;

    public a(FragmentManager fragmentManager) {
        fragmentManager.D();
        t<?> tVar = fragmentManager.f2031u;
        if (tVar != null) {
            tVar.f2194b.getClassLoader();
        }
        this.f2095a = new ArrayList<>();
        this.h = true;
        this.f2109p = false;
        this.f2076s = -1;
        this.f2075q = fragmentManager;
    }

    @Override // androidx.fragment.app.FragmentManager.m
    public final boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2101g) {
            return true;
        }
        FragmentManager fragmentManager = this.f2075q;
        if (fragmentManager.f2016d == null) {
            fragmentManager.f2016d = new ArrayList<>();
        }
        fragmentManager.f2016d.add(this);
        return true;
    }

    @Override // androidx.fragment.app.d0
    public final void d(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.d(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                StringBuilder sb2 = new StringBuilder("Can't change tag of fragment ");
                sb2.append(fragment);
                sb2.append(": was ");
                throw new IllegalStateException(ai.onnxruntime.a.p(sb2, fragment.mTag, " now ", str));
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
        b(new d0.a(fragment, i11));
        fragment.mFragmentManager = this.f2075q;
    }

    public final void f(int i10) {
        ArrayList<d0.a> arrayList = this.f2095a;
        if (this.f2101g) {
            if (FragmentManager.G(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                d0.a aVar = arrayList.get(i11);
                Fragment fragment = aVar.f2111b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i10;
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f2111b + " to " + aVar.f2111b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final int g(boolean z) {
        if (this.r) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new l0());
            h("  ", printWriter, true);
            printWriter.close();
        }
        this.r = true;
        boolean z3 = this.f2101g;
        FragmentManager fragmentManager = this.f2075q;
        if (z3) {
            this.f2076s = fragmentManager.f2020i.getAndIncrement();
        } else {
            this.f2076s = -1;
        }
        fragmentManager.v(this, z);
        return this.f2076s;
    }

    @Override // androidx.fragment.app.FragmentManager.j
    public final int getId() {
        return this.f2076s;
    }

    public final void h(String str, PrintWriter printWriter, boolean z) {
        String str2;
        ArrayList<d0.a> arrayList = this.f2095a;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2102i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2076s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f2100f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2100f));
            }
            if (this.f2096b != 0 || this.f2097c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2096b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2097c));
            }
            if (this.f2098d != 0 || this.f2099e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2098d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2099e));
            }
            if (this.f2103j != 0 || this.f2104k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2103j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2104k);
            }
            if (this.f2105l != 0 || this.f2106m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2105l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2106m);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            d0.a aVar = arrayList.get(i10);
            switch (aVar.f2110a) {
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
                    str2 = "cmd=" + aVar.f2110a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f2111b);
            if (z) {
                if (aVar.f2113d != 0 || aVar.f2114e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2113d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2114e));
                }
                if (aVar.f2115f != 0 || aVar.f2116g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2115f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2116g));
                }
            }
        }
    }

    public final a i(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
        FragmentManager fragmentManager = preferenceHeaderFragmentCompat.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f2075q) {
            b(new d0.a(preferenceHeaderFragmentCompat, 8));
            return this;
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + preferenceHeaderFragmentCompat.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(TraceIdKeys.MAX_LENGTH);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2076s >= 0) {
            sb2.append(" #");
            sb2.append(this.f2076s);
        }
        if (this.f2102i != null) {
            sb2.append(" ");
            sb2.append(this.f2102i);
        }
        sb2.append("}");
        return sb2.toString();
    }
}

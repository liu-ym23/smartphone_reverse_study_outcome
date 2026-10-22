package androidx.fragment.app;

import android.util.Log;
import b0.AbstractC0357c;
import ch.qos.logback.core.joran.action.ActionConst;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0279a implements W {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3688a;

    /* renamed from: b, reason: collision with root package name */
    public int f3689b;

    /* renamed from: c, reason: collision with root package name */
    public int f3690c;

    /* renamed from: d, reason: collision with root package name */
    public int f3691d;

    /* renamed from: e, reason: collision with root package name */
    public int f3692e;

    /* renamed from: f, reason: collision with root package name */
    public int f3693f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3694g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3695h;

    /* renamed from: i, reason: collision with root package name */
    public String f3696i;

    /* renamed from: j, reason: collision with root package name */
    public int f3697j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f3698k;

    /* renamed from: l, reason: collision with root package name */
    public int f3699l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f3700m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f3701n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f3702o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3703p;

    /* renamed from: q, reason: collision with root package name */
    public final Y f3704q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3705r;

    /* renamed from: s, reason: collision with root package name */
    public int f3706s;

    public C0279a(Y y4) {
        y4.D();
        L l4 = y4.f3682u;
        if (l4 != null) {
            l4.f3626b.getClassLoader();
        }
        this.f3688a = new ArrayList();
        this.f3695h = true;
        this.f3703p = false;
        this.f3706s = -1;
        this.f3704q = y4;
    }

    @Override // androidx.fragment.app.W
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f3694g) {
            return true;
        }
        Y y4 = this.f3704q;
        if (y4.f3665d == null) {
            y4.f3665d = new ArrayList();
        }
        y4.f3665d.add(this);
        return true;
    }

    public final void b(e0 e0Var) {
        this.f3688a.add(e0Var);
        e0Var.f3738d = this.f3689b;
        e0Var.f3739e = this.f3690c;
        e0Var.f3740f = this.f3691d;
        e0Var.f3741g = this.f3692e;
    }

    public final void c(int i4) {
        if (this.f3694g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i4);
            }
            int size = this.f3688a.size();
            for (int i5 = 0; i5 < size; i5++) {
                e0 e0Var = (e0) this.f3688a.get(i5);
                D d4 = e0Var.f3736b;
                if (d4 != null) {
                    d4.mBackStackNesting += i4;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Bump nesting of " + e0Var.f3736b + " to " + e0Var.f3736b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final int d(boolean z4) {
        if (this.f3705r) {
            throw new IllegalStateException("commit already called");
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new o0());
            f("  ", printWriter, true);
            printWriter.close();
        }
        this.f3705r = true;
        boolean z5 = this.f3694g;
        Y y4 = this.f3704q;
        if (z5) {
            this.f3706s = y4.f3670i.getAndIncrement();
        } else {
            this.f3706s = -1;
        }
        y4.v(this, z4);
        return this.f3706s;
    }

    public final void e(int i4, D d4, String str, int i5) {
        String str2 = d4.mPreviousWho;
        if (str2 != null) {
            AbstractC0357c.d(d4, str2);
        }
        Class<?> cls = d4.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = d4.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + d4 + ": was " + d4.mTag + " now " + str);
            }
            d4.mTag = str;
        }
        if (i4 != 0) {
            if (i4 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + d4 + " with tag " + str + " to container view with no id");
            }
            int i6 = d4.mFragmentId;
            if (i6 != 0 && i6 != i4) {
                throw new IllegalStateException("Can't change container ID of fragment " + d4 + ": was " + d4.mFragmentId + " now " + i4);
            }
            d4.mFragmentId = i4;
            d4.mContainerId = i4;
        }
        b(new e0(d4, i5));
        d4.mFragmentManager = this.f3704q;
    }

    public final void f(String str, PrintWriter printWriter, boolean z4) {
        String str2;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3696i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3706s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3705r);
            if (this.f3693f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3693f));
            }
            if (this.f3689b != 0 || this.f3690c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3689b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3690c));
            }
            if (this.f3691d != 0 || this.f3692e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3691d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3692e));
            }
            if (this.f3697j != 0 || this.f3698k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3697j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3698k);
            }
            if (this.f3699l != 0 || this.f3700m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3699l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3700m);
            }
        }
        if (this.f3688a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f3688a.size();
        for (int i4 = 0; i4 < size; i4++) {
            e0 e0Var = (e0) this.f3688a.get(i4);
            switch (e0Var.f3735a) {
                case 0:
                    str2 = ActionConst.NULL;
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
                    str2 = "cmd=" + e0Var.f3735a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i4);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(AwarenessDataItem.PERMISSION_SPLITTER);
            printWriter.println(e0Var.f3736b);
            if (z4) {
                if (e0Var.f3738d != 0 || e0Var.f3739e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(e0Var.f3738d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(e0Var.f3739e));
                }
                if (e0Var.f3740f != 0 || e0Var.f3741g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(e0Var.f3740f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(e0Var.f3741g));
                }
            }
        }
    }

    public final void g(D d4, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        e(i4, d4, null, 2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3706s >= 0) {
            sb.append(" #");
            sb.append(this.f3706s);
        }
        if (this.f3696i != null) {
            sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
            sb.append(this.f3696i);
        }
        sb.append("}");
        return sb.toString();
    }
}

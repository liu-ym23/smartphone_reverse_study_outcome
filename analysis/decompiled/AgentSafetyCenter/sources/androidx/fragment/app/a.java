package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1232a;

    /* renamed from: b, reason: collision with root package name */
    public int f1233b;

    /* renamed from: c, reason: collision with root package name */
    public int f1234c;

    /* renamed from: d, reason: collision with root package name */
    public int f1235d;

    /* renamed from: e, reason: collision with root package name */
    public int f1236e;

    /* renamed from: f, reason: collision with root package name */
    public int f1237f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1238g;

    /* renamed from: h, reason: collision with root package name */
    public String f1239h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f1240j;

    /* renamed from: k, reason: collision with root package name */
    public int f1241k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f1242l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f1243m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f1244n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1245o;

    /* renamed from: p, reason: collision with root package name */
    public u f1246p;

    /* renamed from: q, reason: collision with root package name */
    public int f1247q;

    public final void a(int i) {
        ArrayList arrayList = this.f1232a;
        if (this.f1238g) {
            if (u.h(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((b0) arrayList.get(i3)).getClass();
            }
        }
    }

    public final void b(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        ArrayList arrayList = this.f1232a;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1239h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1247q);
            printWriter.print(" mCommitted=");
            printWriter.println(false);
            if (this.f1237f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1237f));
            }
            if (this.f1233b != 0 || this.f1234c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1233b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1234c));
            }
            if (this.f1235d != 0 || this.f1236e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1235d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1236e));
            }
            if (this.i != 0 || this.f1240j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1240j);
            }
            if (this.f1241k != 0 || this.f1242l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1241k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1242l);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            b0 b0Var = (b0) arrayList.get(i);
            switch (b0Var.f1265a) {
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
                    str2 = "cmd=" + b0Var.f1265a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println((Object) null);
            if (z10) {
                if (b0Var.f1267c != 0 || b0Var.f1268d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(b0Var.f1267c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(b0Var.f1268d));
                }
                if (b0Var.f1269e != 0 || b0Var.f1270f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(b0Var.f1269e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(b0Var.f1270f));
                }
            }
        }
    }

    public final void c(ArrayList arrayList, ArrayList arrayList2) {
        if (u.h(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f1238g) {
            u uVar = this.f1246p;
            if (uVar.f1308d == null) {
                uVar.f1308d = new ArrayList();
            }
            uVar.f1308d.add(this);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1247q >= 0) {
            sb2.append(" #");
            sb2.append(this.f1247q);
        }
        if (this.f1239h != null) {
            sb2.append(" ");
            sb2.append(this.f1239h);
        }
        sb2.append("}");
        return sb2.toString();
    }
}

package androidx.fragment.app;

import android.content.DialogInterface;
import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class e extends f implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: l, reason: collision with root package name */
    public final d f662l;

    /* renamed from: m, reason: collision with root package name */
    public int f663m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f664n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f665o;

    public e() {
        new b(0, this);
        this.f662l = new d();
        this.f663m = -1;
        new t1.f(this);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        String str;
        if (this.f664n) {
            return;
        }
        if (k.f(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        if (this.f665o) {
            return;
        }
        this.f665o = true;
        this.f664n = true;
        if (this.f663m >= 0) {
            k kVarE = e();
            int i8 = this.f663m;
            if (i8 < 0) {
                throw new IllegalArgumentException(a8.b.j(i8, "Bad id: "));
            }
            synchronized (kVarE.f678a) {
            }
            this.f663m = -1;
            return;
        }
        a aVar = new a(e());
        m mVar = new m();
        mVar.f683a = 3;
        mVar.f684b = this;
        ((ArrayList) aVar.d).add(mVar);
        mVar.f685c = 0;
        mVar.d = 0;
        mVar.f686e = 0;
        mVar.f687f = 0;
        k kVar = (k) aVar.f659e;
        if (aVar.f658c) {
            throw new IllegalStateException("commit already called");
        }
        if (k.f(2)) {
            Log.v("FragmentManager", "Commit: " + aVar);
            PrintWriter printWriter = new PrintWriter(new n());
            ArrayList arrayList = (ArrayList) aVar.d;
            printWriter.print("  ");
            printWriter.print("mName=");
            printWriter.print((String) null);
            printWriter.print(" mIndex=");
            printWriter.print(aVar.f657b);
            printWriter.print(" mCommitted=");
            printWriter.println(aVar.f658c);
            if (!arrayList.isEmpty()) {
                printWriter.print("  ");
                printWriter.println("Operations:");
                int size = arrayList.size();
                for (int i9 = 0; i9 < size; i9++) {
                    m mVar2 = (m) arrayList.get(i9);
                    switch (mVar2.f683a) {
                        case 0:
                            str = "NULL";
                            break;
                        case 1:
                            str = "ADD";
                            break;
                        case 2:
                            str = "REPLACE";
                            break;
                        case 3:
                            str = "REMOVE";
                            break;
                        case 4:
                            str = "HIDE";
                            break;
                        case 5:
                            str = "SHOW";
                            break;
                        case 6:
                            str = "DETACH";
                            break;
                        case 7:
                            str = "ATTACH";
                            break;
                        case 8:
                            str = "SET_PRIMARY_NAV";
                            break;
                        case 9:
                            str = "UNSET_PRIMARY_NAV";
                            break;
                        case 10:
                            str = "OP_SET_MAX_LIFECYCLE";
                            break;
                        default:
                            str = "cmd=" + mVar2.f683a;
                            break;
                    }
                    printWriter.print("  ");
                    printWriter.print("  Op #");
                    printWriter.print(i9);
                    printWriter.print(": ");
                    printWriter.print(str);
                    printWriter.print(" ");
                    printWriter.println(mVar2.f684b);
                    if (mVar2.f685c != 0 || mVar2.d != 0) {
                        printWriter.print("  ");
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(mVar2.f685c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(mVar2.d));
                    }
                    if (mVar2.f686e != 0 || mVar2.f687f != 0) {
                        printWriter.print("  ");
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(mVar2.f686e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(mVar2.f687f));
                    }
                }
            }
            printWriter.close();
        }
        aVar.f658c = true;
        aVar.f657b = -1;
        synchronized (kVar.f678a) {
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}

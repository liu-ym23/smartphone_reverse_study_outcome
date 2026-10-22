package androidx.fragment.app;

import android.os.Looper;
import android.util.Log;
import androidx.activity.e0;
import androidx.activity.f0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class u {
    public boolean A;
    public ArrayList B;
    public ArrayList C;
    public ArrayList D;
    public y E;
    public r F;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1305a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1306b;

    /* renamed from: c, reason: collision with root package name */
    public a0 f1307c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f1308d;

    /* renamed from: e, reason: collision with root package name */
    public m f1309e;

    /* renamed from: f, reason: collision with root package name */
    public e0 f1310f;

    /* renamed from: g, reason: collision with root package name */
    public f0 f1311g;

    /* renamed from: h, reason: collision with root package name */
    public AtomicInteger f1312h;
    public Map i;

    /* renamed from: j, reason: collision with root package name */
    public Map f1313j;

    /* renamed from: k, reason: collision with root package name */
    public CopyOnWriteArrayList f1314k;

    /* renamed from: l, reason: collision with root package name */
    public n f1315l;

    /* renamed from: m, reason: collision with root package name */
    public n f1316m;

    /* renamed from: n, reason: collision with root package name */
    public n f1317n;

    /* renamed from: o, reason: collision with root package name */
    public n f1318o;

    /* renamed from: p, reason: collision with root package name */
    public p f1319p;

    /* renamed from: q, reason: collision with root package name */
    public int f1320q;

    /* renamed from: r, reason: collision with root package name */
    public i f1321r;

    /* renamed from: s, reason: collision with root package name */
    public i f1322s;

    /* renamed from: t, reason: collision with root package name */
    public q f1323t;

    /* renamed from: u, reason: collision with root package name */
    public d.e f1324u;

    /* renamed from: v, reason: collision with root package name */
    public d.e f1325v;

    /* renamed from: w, reason: collision with root package name */
    public d.e f1326w;

    /* renamed from: x, reason: collision with root package name */
    public ArrayDeque f1327x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1328y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1329z;

    public static boolean h(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public final void a() {
        this.f1306b = false;
        this.C.clear();
        this.B.clear();
    }

    public final HashSet b() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1307c.b().iterator();
        if (!it.hasNext()) {
            return hashSet;
        }
        w2.c.d(it.next());
        throw null;
    }

    public final void c(int i) {
        try {
            this.f1306b = true;
            Iterator it = this.f1307c.f1249b.values().iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
            }
            i(i, false);
            Iterator it2 = b().iterator();
            if (it2.hasNext()) {
                ((d0) it2.next()).a();
                throw null;
            }
            this.f1306b = false;
            e(true);
        } catch (Throwable th) {
            this.f1306b = false;
            throw th;
        }
    }

    public final void d(boolean z10) {
        if (this.f1306b) {
            od.f.e("FragmentManager is already executing transactions");
            return;
        }
        if (this.f1321r == null) {
            if (this.A) {
                od.f.e("FragmentManager has been destroyed");
                return;
            } else {
                od.f.e("FragmentManager has not been attached to a host.");
                return;
            }
        }
        if (Looper.myLooper() != this.f1321r.f1284f.getLooper()) {
            od.f.e("Must be called from main thread of fragment host");
            return;
        }
        if (!z10 && (this.f1328y || this.f1329z)) {
            od.f.e("Can not perform this action after onSaveInstanceState");
        } else if (this.B == null) {
            this.B = new ArrayList();
            this.C = new ArrayList();
        }
    }

    public final boolean e(boolean z10) {
        boolean z11;
        ArrayList arrayList;
        d(z10);
        boolean z12 = false;
        while (true) {
            ArrayList arrayList2 = this.B;
            ArrayList arrayList3 = this.C;
            synchronized (this.f1305a) {
                if (this.f1305a.isEmpty()) {
                    z11 = false;
                } else {
                    try {
                        int size = this.f1305a.size();
                        int i = 0;
                        z11 = false;
                        while (true) {
                            arrayList = this.f1305a;
                            if (i >= size) {
                                break;
                            }
                            ((a) arrayList.get(i)).c(arrayList2, arrayList3);
                            i++;
                            z11 = true;
                        }
                        arrayList.clear();
                        this.f1321r.f1284f.removeCallbacks(this.F);
                    } finally {
                    }
                }
            }
            if (!z11) {
                k();
                this.f1307c.f1249b.values().removeAll(Collections.singleton(null));
                return z12;
            }
            this.f1306b = true;
            try {
                j(this.B, this.C);
                a();
                z12 = true;
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.util.ArrayList r19, java.util.ArrayList r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.u.f(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final void g() {
        a0 a0Var = this.f1307c;
        ArrayList arrayList = a0Var.f1248a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) != null) {
                od.f.j();
                return;
            }
        }
        Iterator it = a0Var.f1249b.values().iterator();
        while (it.hasNext()) {
            w2.c.d(it.next());
        }
    }

    public final void i(int i, boolean z10) {
        a0 a0Var = this.f1307c;
        if (this.f1321r == null && i != -1) {
            od.f.e("No activity");
            return;
        }
        if (z10 || i != this.f1320q) {
            this.f1320q = i;
            Iterator it = a0Var.f1248a.iterator();
            if (it.hasNext()) {
                throw androidx.activity.b.g(it);
            }
            Iterator it2 = a0Var.f1249b.values().iterator();
            while (it2.hasNext()) {
                if (it2.next() != null) {
                    od.f.j();
                    return;
                }
            }
            Iterator it3 = a0Var.b().iterator();
            if (it3.hasNext()) {
                w2.c.d(it3.next());
                throw null;
            }
        }
    }

    public final void j(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            od.f.e("Internal error with the back stack records");
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (i < size) {
            if (!((a) arrayList.get(i)).f1245o) {
                if (i3 != i) {
                    f(arrayList, arrayList2, i3, i);
                }
                i3 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((a) arrayList.get(i3)).f1245o) {
                        i3++;
                    }
                }
                f(arrayList, arrayList2, i, i3);
                i = i3 - 1;
            }
            i++;
        }
        if (i3 != size) {
            f(arrayList, arrayList2, i3, size);
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [xb.a, yb.i] */
    /* JADX WARN: Type inference failed for: r3v8, types: [xb.a, yb.i] */
    public final void k() {
        synchronized (this.f1305a) {
            try {
                if (!this.f1305a.isEmpty()) {
                    f0 f0Var = this.f1311g;
                    f0Var.f699a = true;
                    ?? r32 = f0Var.f701c;
                    if (r32 != 0) {
                        r32.invoke();
                    }
                    return;
                }
                f0 f0Var2 = this.f1311g;
                ArrayList arrayList = this.f1308d;
                f0Var2.f699a = (arrayList != null ? arrayList.size() : 0) > 0;
                ?? r33 = f0Var2.f701c;
                if (r33 != 0) {
                    r33.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        i iVar = this.f1321r;
        if (iVar != null) {
            sb2.append(iVar.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f1321r)));
            sb2.append("}");
        } else {
            sb2.append("null");
        }
        sb2.append("}}");
        return sb2.toString();
    }
}

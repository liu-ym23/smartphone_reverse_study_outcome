package androidx.lifecycle;

import android.os.Bundle;
import android.view.View;
import com.stepos.agentbus.R;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final s9.d f1001a = new s9.d(2);

    /* renamed from: b, reason: collision with root package name */
    public static final s9.d f1002b = new s9.d(3);

    /* renamed from: c, reason: collision with root package name */
    public static final s9.d f1003c = new s9.d(4);

    /* renamed from: d, reason: collision with root package name */
    public static final s9.d f1004d = new s9.d(7);

    public static final void a(p0 p0Var, q6.b bVar, x xVar) throws NoSuchMethodException, SecurityException {
        AutoCloseable autoCloseable;
        q7.k.e(bVar, "registry");
        q7.k.e(xVar, "lifecycle");
        c3.a aVar = p0Var.f1019a;
        if (aVar != null) {
            synchronized (aVar.f1891a) {
                autoCloseable = (AutoCloseable) aVar.f1892b.get("androidx.lifecycle.savedstate.vm.tag");
            }
        } else {
            autoCloseable = null;
        }
        h0 h0Var = (h0) autoCloseable;
        if (h0Var == null || h0Var.f1000h) {
            return;
        }
        h0Var.g(xVar, bVar);
        q qVar = xVar.f1035c;
        if (qVar == q.f1021g || qVar.compareTo(q.f1023i) >= 0) {
            bVar.N0();
        } else {
            xVar.a(new h(xVar, bVar));
        }
    }

    public static g0 b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = bundle2;
        }
        if (bundle == null) {
            g0 g0Var = new g0();
            new LinkedHashMap();
            g0Var.f994a = new a3.b(d7.a0.f2944f);
            return g0Var;
        }
        ClassLoader classLoader = g0.class.getClassLoader();
        q7.k.b(classLoader);
        bundle.setClassLoader(classLoader);
        e7.g gVar = new e7.g(bundle.size());
        for (String str : bundle.keySet()) {
            q7.k.b(str);
            gVar.put(str, bundle.get(str));
        }
        e7.g gVarC = gVar.c();
        g0 g0Var2 = new g0();
        new LinkedHashMap();
        g0Var2.f994a = new a3.b(gVarC);
        return g0Var2;
    }

    public static final v c(View view) {
        q7.k.e(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
            v vVar = tag instanceof v ? (v) tag : null;
            if (vVar != null) {
                return vVar;
            }
            Object objO = n7.o.o(view);
            view = objO instanceof View ? (View) objO : null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ca A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #2 {all -> 0x008c, blocks: (B:16:0x0078, B:18:0x0086, B:21:0x008e, B:22:0x00a2, B:28:0x00bb, B:30:0x00ca, B:24:0x00a9, B:26:0x00b2), top: B:39:0x0078, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.lifecycle.m0 d(androidx.lifecycle.t0 r7) {
        /*
            androidx.lifecycle.i0 r0 = new androidx.lifecycle.i0
            r0.<init>()
            boolean r1 = r7 instanceof androidx.lifecycle.k
            if (r1 == 0) goto L59
            r1 = r7
            androidx.lifecycle.k r1 = (androidx.lifecycle.k) r1
            c.i r1 = (c.i) r1
            b3.c r2 = new b3.c
            b3.a r3 = b3.a.f1482b
            java.lang.String r4 = "initialExtras"
            q7.k.e(r3, r4)
            java.util.LinkedHashMap r3 = r3.f1483a
            q7.k.e(r3, r4)
            r2.<init>()
            java.util.LinkedHashMap r4 = r2.f1483a
            r4.putAll(r3)
            android.app.Application r3 = r1.getApplication()
            if (r3 == 0) goto L35
            s9.d r3 = androidx.lifecycle.q0.f1027j
            android.app.Application r4 = r1.getApplication()
            java.util.LinkedHashMap r5 = r2.f1483a
            r5.put(r3, r4)
        L35:
            s9.d r3 = androidx.lifecycle.j0.f1001a
            java.util.LinkedHashMap r4 = r2.f1483a
            r4.put(r3, r1)
            s9.d r3 = androidx.lifecycle.j0.f1002b
            java.util.LinkedHashMap r4 = r2.f1483a
            r4.put(r3, r1)
            android.content.Intent r1 = r1.getIntent()
            if (r1 == 0) goto L4e
            android.os.Bundle r1 = r1.getExtras()
            goto L4f
        L4e:
            r1 = 0
        L4f:
            if (r1 == 0) goto L5b
            s9.d r3 = androidx.lifecycle.j0.f1003c
            java.util.LinkedHashMap r4 = r2.f1483a
            r4.put(r3, r1)
            goto L5b
        L59:
            b3.a r2 = b3.a.f1482b
        L5b:
            java.lang.String r1 = "extras"
            q7.k.e(r2, r1)
            c.i r7 = (c.i) r7
            androidx.lifecycle.s0 r7 = r7.c()
            s9.d r1 = new s9.d
            r3 = 10
            r1.<init>(r3)
            java.lang.String r3 = "androidx.lifecycle.internal.SavedStateHandlesVM"
            java.lang.Class<androidx.lifecycle.m0> r4 = androidx.lifecycle.m0.class
            q7.x r5 = q7.w.f8821a
            w7.d r4 = r5.b(r4)
            monitor-enter(r1)
            java.util.LinkedHashMap r5 = r7.f1030a     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r5 = r5.get(r3)     // Catch: java.lang.Throwable -> L8c
            androidx.lifecycle.p0 r5 = (androidx.lifecycle.p0) r5     // Catch: java.lang.Throwable -> L8c
            boolean r6 = r4.r(r5)     // Catch: java.lang.Throwable -> L8c
            if (r6 == 0) goto L8e
            java.lang.String r7 = "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.internal.ViewModelProviderImpl.getViewModel"
            q7.k.c(r5, r7)     // Catch: java.lang.Throwable -> L8c
            goto Lcd
        L8c:
            r7 = move-exception
            goto Ld1
        L8e:
            java.lang.String r5 = "initialExtras"
            java.util.LinkedHashMap r2 = r2.f1483a     // Catch: java.lang.Throwable -> L8c
            q7.k.e(r2, r5)     // Catch: java.lang.Throwable -> L8c
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap     // Catch: java.lang.Throwable -> L8c
            r5.<init>()     // Catch: java.lang.Throwable -> L8c
            r5.putAll(r2)     // Catch: java.lang.Throwable -> L8c
            s9.d r2 = androidx.lifecycle.j0.f1004d     // Catch: java.lang.Throwable -> L8c
            r5.put(r2, r3)     // Catch: java.lang.Throwable -> L8c
            androidx.lifecycle.m0 r2 = new androidx.lifecycle.m0     // Catch: java.lang.Throwable -> L8c java.lang.AbstractMethodError -> La9
            r2.<init>()     // Catch: java.lang.Throwable -> L8c java.lang.AbstractMethodError -> La9
            r5 = r2
            goto Lbb
        La9:
            java.lang.Class r2 = nb.i.t(r4)     // Catch: java.lang.Throwable -> L8c java.lang.AbstractMethodError -> Lb2
            androidx.lifecycle.p0 r0 = r0.b(r2)     // Catch: java.lang.Throwable -> L8c java.lang.AbstractMethodError -> Lb2
            goto Lba
        Lb2:
            java.lang.Class r2 = nb.i.t(r4)     // Catch: java.lang.Throwable -> L8c
            androidx.lifecycle.p0 r0 = r0.b(r2)     // Catch: java.lang.Throwable -> L8c
        Lba:
            r5 = r0
        Lbb:
            java.lang.String r0 = "viewModel"
            q7.k.e(r5, r0)     // Catch: java.lang.Throwable -> L8c
            java.util.LinkedHashMap r7 = r7.f1030a     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r7 = r7.put(r3, r5)     // Catch: java.lang.Throwable -> L8c
            androidx.lifecycle.p0 r7 = (androidx.lifecycle.p0) r7     // Catch: java.lang.Throwable -> L8c
            if (r7 == 0) goto Lcd
            r7.a()     // Catch: java.lang.Throwable -> L8c
        Lcd:
            monitor-exit(r1)
            androidx.lifecycle.m0 r5 = (androidx.lifecycle.m0) r5
            return r5
        Ld1:
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.j0.d(androidx.lifecycle.t0):androidx.lifecycle.m0");
    }
}

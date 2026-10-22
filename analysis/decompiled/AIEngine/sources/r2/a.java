package r2;

import androidx.work.impl.WorkDatabase;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11689a = h2.j.f("EnqueueRunnable");

    public static void a(i2.n nVar) {
        boolean z;
        androidx.work.impl.b bVar = nVar.f9476a;
        HashSet hashSet = new HashSet();
        hashSet.addAll(nVar.f9480e);
        HashSet hashSetB = i2.n.b(nVar);
        Iterator it = hashSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                hashSet.removeAll(nVar.f9480e);
                z = false;
                break;
            } else if (hashSetB.contains((String) it.next())) {
                z = true;
                break;
            }
        }
        if (z) {
            throw new IllegalStateException("WorkContinuation has cycles (" + nVar + ")");
        }
        WorkDatabase workDatabase = bVar.f2879c;
        androidx.work.a aVar = bVar.f2878b;
        workDatabase.c();
        try {
            b.a(workDatabase, aVar, nVar);
            boolean zB = b(nVar);
            workDatabase.p();
            if (zB) {
                i2.j.b(aVar, bVar.f2879c, bVar.f2881e);
            }
        } finally {
            workDatabase.k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0185  */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(i2.n r64) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.a.b(i2.n):boolean");
    }
}

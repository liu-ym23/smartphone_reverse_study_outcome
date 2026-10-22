package g0;

import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f4460a;
    public static d b;
    public static final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public static h0.d d;

    public static void a() {
        Printer printer;
        if (f4460a) {
            return;
        }
        f4460a = true;
        b = new d(0);
        if (!D2.b.e) {
            D2.b.e = true;
            D2.a aVar = new D2.a(0);
            aVar.b = new ArrayList();
            new ArrayList();
            aVar.c = new ArrayList();
            aVar.d = false;
            D2.b.d = aVar;
            try {
                Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
                declaredField.setAccessible(true);
                printer = (Printer) declaredField.get(Looper.getMainLooper());
            } catch (Exception unused) {
                printer = null;
            }
            if (printer != null) {
                D2.b.d.b.add(printer);
            }
            Looper.getMainLooper().setMessageLogging(D2.b.d);
        }
        d dVar = b;
        if (dVar == null || D2.b.d.c.contains(dVar)) {
            return;
        }
        D2.b.d.c.add(dVar);
        D2.b.d.d = true;
    }

    public static void b(String str, boolean z10) {
        h0.d dVar;
        h0.d dVar2;
        if (z10 && (dVar2 = d) != null && dVar2.b.f4538a) {
            d.b(str);
        }
        Iterator it = c.iterator();
        while (it.hasNext()) {
            h0.d dVar3 = (h0.d) it.next();
            if (dVar3.b.f4538a) {
                if (z10) {
                    if (!dVar3.f4536a) {
                        dVar3.b(str);
                    }
                } else if (dVar3.f4536a) {
                    dVar3.a();
                }
            } else if (!z10 && dVar3.f4536a) {
                dVar3.a();
            }
        }
        if (z10 || (dVar = d) == null || !dVar.b.f4538a) {
            return;
        }
        d.a();
    }
}

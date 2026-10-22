package z2;

import android.util.Printer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class h {
    public static h d;

    /* renamed from: a, reason: collision with root package name */
    public long f6930a = -1;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();

    public static h a() {
        if (d == null) {
            synchronized (h.class) {
                try {
                    if (d == null) {
                        d = new h();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public static void b(String str, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Printer printer = (Printer) list.get(i);
                if (printer == null) {
                    return;
                }
                printer.println(str);
            }
        } catch (Throwable th) {
            S0.b.R(th);
        }
    }
}

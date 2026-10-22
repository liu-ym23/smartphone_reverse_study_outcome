package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.o1;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f21625a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o1 f21626b = null;

    static {
        r r10 = new r();
        f21625a = r10;
        c0.f("kotlinx.coroutines.fast.service.loader", true);
        f21626b = r10.a();
    }

    public r() {
    }

    public final o1 a() {
        List r10 = SequencesKt___SequencesKt.w(SequencesKt__SequencesKt.c(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));     // Catch: Throwable -> L20
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L20
        if (r11.hasNext() == true) goto L6;
        Object r12 = null;
    L15:
        MainDispatcherFactory r13 = (MainDispatcherFactory) r12;     // Catch: Throwable -> L20
        if (r13 == null) goto L22;
        o1 r14 = s.e(r13, r10);     // Catch: Throwable -> L20
        if (r14 == null) goto L22;
        return r14;
    L22:
        return s.b(null, null, 3, null);
    L6:
        r12 = r11.next();     // Catch: Throwable -> L20
        if (r11.hasNext() == false) goto L15;
        int r15 = ((MainDispatcherFactory) r12).getLoadPriority();     // Catch: Throwable -> L20
    L10:
        Object r16 = r11.next();     // Catch: Throwable -> L20
        int r17 = ((MainDispatcherFactory) r16).getLoadPriority();     // Catch: Throwable -> L20
        if (r15 >= r17) goto L14;
        r12 = r16;
        r15 = r17;
    L14:
        if (r11.hasNext() == true) goto L10;
    L20:
        th = move-exception;
        return s.b(th, null, 2, null);
    }
}

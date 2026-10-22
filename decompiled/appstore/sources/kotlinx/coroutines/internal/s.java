package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.o1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s {
    static {
    }

    public static final t a(Throwable r10, String r11) {
        if (r10 == null) goto L4;
        throw r10;
    L4:
        d();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ t b(Throwable r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = null;
    L9:
        return a(r10, r11);
    }

    public static final boolean c(o1 r10) {
        return r10.e() instanceof t;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final o1 e(MainDispatcherFactory r10, List r11) {
        return r10.createDispatcher(r11);
    L4:
        th = move-exception;
        return a(th, r10.hintOnError());
    }
}

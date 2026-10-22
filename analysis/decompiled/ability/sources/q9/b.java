package q9;

import S7.n;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.channels.BufferOverflow;
import s9.AbstractC1921a;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final H7.c[] f5623a = new H7.c[0];
    public static final a5.d b;
    public static final a5.d c;
    public static final a5.d d;

    static {
        int i = 6;
        b = new a5.d("NULL", i);
        c = new a5.d("UNINITIALIZED", i);
        d = new a5.d("DONE", i);
    }

    public static /* synthetic */ p9.c a(g gVar, H7.h hVar, int i, BufferOverflow bufferOverflow, int i6) {
        if ((i6 & 1) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        if ((i6 & 2) != 0) {
            i = -3;
        }
        if ((i6 & 4) != 0) {
            bufferOverflow = BufferOverflow.f5184a;
        }
        return gVar.c(hVar, i, bufferOverflow);
    }

    public static final Object b(H7.h hVar, Object obj, Object obj2, n nVar, H7.c frame) {
        Object objInvoke;
        Object objL = AbstractC1921a.l(hVar, obj2);
        try {
            k kVar = new k(hVar, frame);
            if (nVar == null) {
                objInvoke = U7.a.b0(nVar, obj, kVar);
            } else {
                p.e(2, nVar);
                objInvoke = nVar.invoke(obj, kVar);
            }
            AbstractC1921a.g(hVar, objL);
            if (objInvoke == CoroutineSingletons.f4909a) {
                kotlin.jvm.internal.k.f(frame, "frame");
            }
            return objInvoke;
        } catch (Throwable th) {
            AbstractC1921a.g(hVar, objL);
            throw th;
        }
    }
}

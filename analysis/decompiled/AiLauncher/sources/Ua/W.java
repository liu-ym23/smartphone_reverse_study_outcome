package Ua;

import Za.C1188h;
import Za.C1189i;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000e\"\u0018\u0010\u0011\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0013\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/f;", "", "mode", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lkotlinx/coroutines/f;I)V", "Le9/c;", "delegate", "", "undispatched", Const.INTENT_KEY_UMID, "(Lkotlinx/coroutines/f;Le9/c;Z)V", "e", "(Lkotlinx/coroutines/f;)V", Const.INTENT_KEY_PKGNAME, "(I)Z", "isCancellableMode", "c", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class W {
    public static final <T> void a(kotlinx.coroutines.f<? super T> fVar, int i10) {
        InterfaceC4014c<? super T> interfaceC4014cC = fVar.c();
        boolean z10 = i10 == 4;
        if (z10 || !(interfaceC4014cC instanceof C1188h) || b(i10) != b(fVar.resumeMode)) {
            d(fVar, interfaceC4014cC, z10);
            return;
        }
        C1188h c1188h = (C1188h) interfaceC4014cC;
        I i11 = c1188h.dispatcher;
        kotlin.coroutines.d context = c1188h.getContext();
        if (C1189i.d(i11, context)) {
            C1189i.c(i11, context, fVar);
        } else {
            e(fVar);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final <T> void d(kotlinx.coroutines.f<? super T> fVar, InterfaceC4014c<? super T> interfaceC4014c, boolean z10) {
        Object objE;
        Object objI = fVar.i();
        Throwable thD = fVar.d(objI);
        if (thD != null) {
            Result.Companion companion = Result.INSTANCE;
            objE = C4849c.a(thD);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objE = fVar.e(objI);
        }
        Object objB = Result.b(objE);
        if (!z10) {
            interfaceC4014c.resumeWith(objB);
            return;
        }
        kotlin.jvm.internal.p.g(interfaceC4014c, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C1188h c1188h = (C1188h) interfaceC4014c;
        InterfaceC4014c<T> interfaceC4014c2 = c1188h.continuation;
        Object obj = c1188h.countOrElement;
        kotlin.coroutines.d context = interfaceC4014c2.getContext();
        Object objI2 = Za.J.i(context, obj);
        S0<?> s0M = objI2 != Za.J.f7710a ? G.m(interfaceC4014c2, context, objI2) : null;
        try {
            c1188h.continuation.resumeWith(objB);
            Y8.t tVar = Y8.t.f7040a;
            if (s0M == null || s0M.c1()) {
                Za.J.f(context, objI2);
            }
        } catch (Throwable th) {
            if (s0M == null || s0M.c1()) {
                Za.J.f(context, objI2);
            }
            throw th;
        }
    }

    public static final void e(kotlinx.coroutines.f<?> fVar) {
        AbstractC1053e0 abstractC1053e0B = O0.f6339a.b();
        if (abstractC1053e0B.B1()) {
            abstractC1053e0B.x1(fVar);
            return;
        }
        abstractC1053e0B.z1(true);
        try {
            d(fVar, fVar.c(), true);
            do {
            } while (abstractC1053e0B.E1());
        } finally {
            try {
            } finally {
            }
        }
    }
}

package ab;

import Ua.C1091z;
import Ua.x0;
import Za.J;
import Za.y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.f;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.TimeoutCancellationException;
import p9.p;

@Metadata(d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001aQ\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\b\u0010\t\u001aS\u0010\f\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0005\u001a\u00028\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000¢\u0006\u0004\b\f\u0010\r\u001aS\u0010\u000e\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0005\u001a\u00028\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a[\u0010\u0011\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00028\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0015\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0019\u001a\u00020\u0018*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\f\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Le9/c;", "", "receiver", "completion", "LY8/t;", "c", "(Lp9/p;Ljava/lang/Object;Le9/c;)V", "LZa/y;", "block", "e", "(LZa/y;Ljava/lang/Object;Lp9/p;)Ljava/lang/Object;", "f", "", "alwaysRethrow", Const.INTENT_KEY_UMID, "(LZa/y;ZLjava/lang/Object;Lp9/p;)Ljava/lang/Object;", "", "cause", Const.INTENT_KEY_PKGNAME, "(LZa/y;Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/DispatchException;", "", Const.INTENT_KEY_APIKEY, "(LZa/y;Lkotlinx/coroutines/DispatchException;)Ljava/lang/Void;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: ab.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1279b {
    public static final Void a(y<?> yVar, DispatchException dispatchException) throws Throwable {
        yVar.p0(new C1091z(dispatchException.getCause(), false, 2, null));
        throw dispatchException.getCause();
    }

    public static final boolean b(y<?> yVar, Throwable th) {
        return ((th instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th).coroutine == yVar) ? false : true;
    }

    public static final <R, T> void c(p<? super R, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, R r10, InterfaceC4014c<? super T> interfaceC4014c) {
        InterfaceC4014c interfaceC4014cA = f.a(interfaceC4014c);
        try {
            d context = interfaceC4014cA.getContext();
            Object objI = J.i(context, null);
            try {
                f.b(interfaceC4014cA);
                Object objE = !(pVar instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.e(pVar, r10, interfaceC4014cA) : ((p) z.g(pVar, 2)).invoke(r10, interfaceC4014cA);
                J.f(context, objI);
                if (objE != C4063a.g()) {
                    interfaceC4014cA.resumeWith(Result.b(objE));
                }
            } catch (Throwable th) {
                J.f(context, objI);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (th instanceof DispatchException) {
                th = ((DispatchException) th).getCause();
            }
            Result.Companion companion = Result.INSTANCE;
            interfaceC4014cA.resumeWith(Result.b(C4849c.a(th)));
        }
    }

    public static final <T, R> Object d(y<? super T> yVar, boolean z10, R r10, p<? super R, ? super InterfaceC4014c<? super T>, ? extends Object> pVar) throws Throwable {
        Object c1091z;
        Object objQ0;
        try {
            c1091z = !(pVar instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.e(pVar, r10, yVar) : ((p) z.g(pVar, 2)).invoke(r10, yVar);
        } catch (DispatchException e10) {
            a(yVar, e10);
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            c1091z = new C1091z(th, false, 2, null);
        }
        if (c1091z != C4063a.g() && (objQ0 = yVar.q0(c1091z)) != x0.f6403b) {
            yVar.Z0();
            if (!(objQ0 instanceof C1091z)) {
                return x0.h(objQ0);
            }
            if (z10 || b(yVar, ((C1091z) objQ0).cause)) {
                throw ((C1091z) objQ0).cause;
            }
            if (c1091z instanceof C1091z) {
                throw ((C1091z) c1091z).cause;
            }
            return c1091z;
        }
        return C4063a.g();
    }

    public static final <T, R> Object e(y<? super T> yVar, R r10, p<? super R, ? super InterfaceC4014c<? super T>, ? extends Object> pVar) {
        return d(yVar, true, r10, pVar);
    }

    public static final <T, R> Object f(y<? super T> yVar, R r10, p<? super R, ? super InterfaceC4014c<? super T>, ? extends Object> pVar) {
        return d(yVar, false, r10, pVar);
    }
}

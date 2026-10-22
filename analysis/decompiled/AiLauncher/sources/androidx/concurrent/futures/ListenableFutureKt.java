package androidx.concurrent.futures;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g3.InterfaceFutureC4095a;
import g9.f;
import java.util.concurrent.ExecutionException;
import k0.RunnableC4798b;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.c;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lg3/a;", Const.INTENT_KEY_PKGNAME, "(Lg3/a;Le9/c;)Ljava/lang/Object;", "Ljava/util/concurrent/ExecutionException;", "", "c", "(Ljava/util/concurrent/ExecutionException;)Ljava/lang/Throwable;", "concurrent-futures-ktx"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListenableFutureKt {
    public static final <T> Object b(final InterfaceFutureC4095a<T> interfaceFutureC4095a, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        try {
            if (interfaceFutureC4095a.isDone()) {
                return AbstractResolvableFuture.k(interfaceFutureC4095a);
            }
            c cVar = new c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
            interfaceFutureC4095a.a(new RunnableC4798b(interfaceFutureC4095a, cVar), DirectExecutor.INSTANCE);
            cVar.q(new InterfaceC5074l<Throwable, t>() { // from class: androidx.concurrent.futures.ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1
                {
                    super(1);
                }

                public final void a(Throwable th) {
                    interfaceFutureC4095a.cancel(false);
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                    a(th);
                    return t.f7040a;
                }
            });
            Object objC = cVar.C();
            if (objC == C4063a.g()) {
                f.c(interfaceC4014c);
            }
            return objC;
        } catch (ExecutionException e10) {
            throw c(e10);
        }
    }

    public static final Throwable c(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        if (cause == null) {
            p.u();
        }
        return cause;
    }
}

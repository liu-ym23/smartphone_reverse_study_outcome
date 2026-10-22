package androidx.camera.camera2.adapter;

import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.t;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import g3.InterfaceFutureC4095a;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001aE\u0010\u0013\u001a\u00020\r\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0017\u001a\u00020\r\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001aO\u0010\u0019\u001a\u00020\r\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001c\u001a\u00020\r\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u001b\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001d\u001a(\u0010!\u001a\u00020 \"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086@¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lkotlinx/coroutines/g;", "", "tag", "Lg3/a;", "Ljava/lang/Void;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/coroutines/g;Ljava/lang/Object;)Lg3/a;", ExifInterface.GPS_DIRECTION_TRUE, "LUa/Q;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LUa/Q;Ljava/lang/Object;)Lg3/a;", "LUa/u;", "destination", "LY8/t;", "s", "(LUa/Q;LUa/u;)V", "R", "Lkotlin/Function1;", "transform", "t", "(LUa/Q;LUa/u;Lp9/l;)V", "", "completionCause", "q", "(LUa/Q;LUa/u;Ljava/lang/Throwable;)V", "r", "(LUa/Q;LUa/u;Ljava/lang/Throwable;Lp9/l;)V", "cause", "p", "(LUa/u;Ljava/lang/Throwable;)V", "", "timeoutMillis", "", "o", "(LUa/Q;JLe9/c;)Ljava/lang/Object;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoroutineAdaptersKt {
    public static final <T> InterfaceFutureC4095a<T> g(final Q<? extends T> q10, final Object obj) {
        p.i(q10, "<this>");
        InterfaceFutureC4095a<T> interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: o.u
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return CoroutineAdaptersKt.m(q10, obj, aVar);
            }
        });
        p.h(interfaceFutureC4095aA, "getFuture(...)");
        return interfaceFutureC4095aA;
    }

    public static final InterfaceFutureC4095a<Void> h(final g gVar, final Object obj) {
        p.i(gVar, "<this>");
        InterfaceFutureC4095a<Void> interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: o.s
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return CoroutineAdaptersKt.k(gVar, obj, aVar);
            }
        });
        p.h(interfaceFutureC4095aA, "getFuture(...)");
        return interfaceFutureC4095aA;
    }

    public static /* synthetic */ InterfaceFutureC4095a i(Q q10, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return g(q10, obj);
    }

    public static /* synthetic */ InterfaceFutureC4095a j(g gVar, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = "Job.asListenableFuture";
        }
        return h(gVar, obj);
    }

    public static final Object k(g gVar, Object obj, final CallbackToFutureAdapter.a completer) {
        p.i(completer, "completer");
        gVar.J(new InterfaceC5074l() { // from class: o.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return CoroutineAdaptersKt.l(completer, (Throwable) obj2);
            }
        });
        return obj;
    }

    public static final t l(CallbackToFutureAdapter.a aVar, Throwable th) {
        if (th == null) {
            aVar.c(null);
        } else if (th instanceof CancellationException) {
            aVar.d();
        } else {
            aVar.f(th);
        }
        return t.f7040a;
    }

    public static final Object m(final Q q10, Object obj, final CallbackToFutureAdapter.a completer) {
        p.i(completer, "completer");
        q10.J(new InterfaceC5074l() { // from class: o.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return CoroutineAdaptersKt.n(completer, q10, (Throwable) obj2);
            }
        });
        return obj;
    }

    public static final t n(CallbackToFutureAdapter.a aVar, Q q10, Throwable th) {
        if (th == null) {
            aVar.c(q10.m());
        } else if (th instanceof CancellationException) {
            aVar.d();
        } else {
            aVar.f(th);
        }
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object o(Ua.Q<? extends T> r4, long r5, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$1 r0 = (androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$1) r0
            int r1 = r0.f9321b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9321b = r1
            goto L18
        L13:
            androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$1 r0 = new androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f9320a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9321b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r7)
            androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$2 r7 = new androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$2
            r2 = 0
            r7.<init>(r4, r2)
            r0.f9321b = r3
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.e(r5, r7, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            if (r7 == 0) goto L46
            goto L47
        L46:
            r3 = 0
        L47:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.adapter.CoroutineAdaptersKt.o(Ua.Q, long, e9.c):java.lang.Object");
    }

    public static final <T> void p(InterfaceC1083u<T> interfaceC1083u, Throwable cause) {
        p.i(interfaceC1083u, "<this>");
        p.i(cause, "cause");
        if (cause instanceof CancellationException) {
            interfaceC1083u.i((CancellationException) cause);
        } else {
            interfaceC1083u.e(cause);
        }
    }

    public static final <T> void q(Q<? extends T> q10, InterfaceC1083u<T> destination, Throwable th) {
        p.i(q10, "<this>");
        p.i(destination, "destination");
        if (th != null) {
            p(destination, th);
        } else {
            destination.complete(q10.m());
        }
    }

    public static final <T, R> void r(Q<? extends T> q10, InterfaceC1083u<R> destination, Throwable th, InterfaceC5074l<? super T, ? extends R> transform) {
        p.i(q10, "<this>");
        p.i(destination, "destination");
        p.i(transform, "transform");
        if (th != null) {
            p(destination, th);
        } else {
            destination.complete(transform.invoke(q10.m()));
        }
    }

    public static final <T> void s(final Q<? extends T> q10, final InterfaceC1083u<T> destination) {
        p.i(q10, "<this>");
        p.i(destination, "destination");
        q10.J(new InterfaceC5074l() { // from class: o.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CoroutineAdaptersKt.u(q10, destination, (Throwable) obj);
            }
        });
    }

    public static final <T, R> void t(final Q<? extends T> q10, final InterfaceC1083u<R> destination, final InterfaceC5074l<? super T, ? extends R> transform) {
        p.i(q10, "<this>");
        p.i(destination, "destination");
        p.i(transform, "transform");
        q10.J(new InterfaceC5074l() { // from class: o.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CoroutineAdaptersKt.v(q10, destination, transform, (Throwable) obj);
            }
        });
    }

    public static final t u(Q q10, InterfaceC1083u interfaceC1083u, Throwable th) {
        q(q10, interfaceC1083u, th);
        return t.f7040a;
    }

    public static final t v(Q q10, InterfaceC1083u interfaceC1083u, InterfaceC5074l interfaceC5074l, Throwable th) {
        r(q10, interfaceC1083u, th, interfaceC5074l);
        return t.f7040a;
    }
}

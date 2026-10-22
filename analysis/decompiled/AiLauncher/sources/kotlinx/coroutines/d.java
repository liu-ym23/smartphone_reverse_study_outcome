package kotlinx.coroutines;

import Ua.C1063j0;
import Ua.C1086v0;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Za.CoroutineScope;
import Za.y;
import ab.C1279b;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001aG\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0017\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0011\u0010\u0019\u001a\u00020\u0011*\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001a\"\u001b\u0010\u001f\u001a\u00020\u001b*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"LUa/M;", Const.INTENT_KEY_PKGNAME, "()LUa/M;", "R", "Lkotlin/Function2;", "Le9/c;", "", "block", "f", "(Lp9/p;Le9/c;)Ljava/lang/Object;", "Lkotlin/coroutines/d;", "context", Const.INTENT_KEY_APIKEY, "(Lkotlin/coroutines/d;)LUa/M;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "LY8/t;", Const.INTENT_KEY_UMID, "(LUa/M;Ljava/util/concurrent/CancellationException;)V", "", "message", "", "c", "(LUa/M;Ljava/lang/String;Ljava/lang/Throwable;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LUa/M;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LUa/M;)Z", "isActive$annotations", "isActive", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d {
    public static final M a(kotlin.coroutines.d dVar) {
        if (dVar.get(g.INSTANCE) == null) {
            dVar = dVar.plus(JobKt__JobKt.b(null, 1, null));
        }
        return new CoroutineScope(dVar);
    }

    public static final M b() {
        return new CoroutineScope(L0.b(null, 1, null).plus(Y.c()));
    }

    public static final void c(M m10, String str, Throwable th) {
        d(m10, C1063j0.a(str, th));
    }

    public static final void d(M m10, CancellationException cancellationException) {
        g gVar = (g) m10.getCoroutineContext().get(g.INSTANCE);
        if (gVar != null) {
            gVar.i(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + m10).toString());
    }

    public static /* synthetic */ void e(M m10, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        d(m10, cancellationException);
    }

    public static final <R> Object f(p<? super M, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        y yVar = new y(interfaceC4014c.getContext(), interfaceC4014c);
        Object objE = C1279b.e(yVar, yVar, pVar);
        if (objE == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objE;
    }

    public static final void g(M m10) {
        C1086v0.m(m10.getCoroutineContext());
    }

    public static final boolean h(M m10) {
        g gVar = (g) m10.getCoroutineContext().get(g.INSTANCE);
        if (gVar != null) {
            return gVar.b();
        }
        return true;
    }
}

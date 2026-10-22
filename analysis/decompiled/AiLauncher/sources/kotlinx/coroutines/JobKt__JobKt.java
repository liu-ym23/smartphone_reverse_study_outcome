package kotlinx.coroutines;

import Ka.j;
import Ua.AbstractC1088w0;
import Ua.C1049c0;
import Ua.C1063j0;
import Ua.C1084u0;
import Ua.C1086v0;
import Ua.InterfaceC1045a0;
import Ua.InterfaceC1089x;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\r\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0015\u001a\u00020\u000f*\u00020\u00002\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0018\u001a\u00020\u000f*\u00020\u00172\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0011\u0010\u001a\u001a\u00020\u000f*\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001c\u001a\u00020\u000f*\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001d\u001a%\u0010!\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\u00020\u000f*\u00020\u00172\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b#\u0010\u0019\"\u0015\u0010&\u001a\u00020\u0001*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u0015\u0010)\u001a\u00020\u0000*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lkotlinx/coroutines/g;", "", "invokeImmediately", "LUa/w0;", "handler", "LUa/a0;", "p", "(Lkotlinx/coroutines/g;ZLUa/w0;)LUa/a0;", "parent", "LUa/x;", Const.INTENT_KEY_APIKEY, "(Lkotlinx/coroutines/g;)LUa/x;", "handle", "l", "(Lkotlinx/coroutines/g;LUa/a0;)LUa/a0;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlinx/coroutines/g;Le9/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lkotlinx/coroutines/g;Ljava/util/concurrent/CancellationException;)V", "Lkotlin/coroutines/d;", "c", "(Lkotlin/coroutines/d;Ljava/util/concurrent/CancellationException;)V", "n", "(Lkotlinx/coroutines/g;)V", "m", "(Lkotlin/coroutines/d;)V", "", "message", "", Const.INTENT_KEY_UMID, "(Lkotlinx/coroutines/g;Ljava/lang/String;Ljava/lang/Throwable;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "r", "(Lkotlin/coroutines/d;)Z", "isActive", "o", "(Lkotlin/coroutines/d;)Lkotlinx/coroutines/g;", "job", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class JobKt__JobKt {
    public static final InterfaceC1089x a(g gVar) {
        return new C1084u0(gVar);
    }

    public static /* synthetic */ InterfaceC1089x b(g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = null;
        }
        return C1086v0.a(gVar);
    }

    public static final void c(kotlin.coroutines.d dVar, CancellationException cancellationException) {
        g gVar = (g) dVar.get(g.INSTANCE);
        if (gVar != null) {
            gVar.i(cancellationException);
        }
    }

    public static final void d(g gVar, String str, Throwable th) {
        gVar.i(C1063j0.a(str, th));
    }

    public static /* synthetic */ void e(kotlin.coroutines.d dVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        C1086v0.c(dVar, cancellationException);
    }

    public static /* synthetic */ void f(g gVar, String str, Throwable th, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th = null;
        }
        C1086v0.d(gVar, str, th);
    }

    public static final Object g(g gVar, InterfaceC4014c<? super t> interfaceC4014c) {
        g.Y0(gVar, null, 1, null);
        Object objT0 = gVar.T0(interfaceC4014c);
        return objT0 == C4063a.g() ? objT0 : t.f7040a;
    }

    public static final void h(kotlin.coroutines.d dVar, CancellationException cancellationException) {
        j<g> children;
        g gVar = (g) dVar.get(g.INSTANCE);
        if (gVar == null || (children = gVar.getChildren()) == null) {
            return;
        }
        Iterator<g> it = children.iterator();
        while (it.hasNext()) {
            it.next().i(cancellationException);
        }
    }

    public static final void i(g gVar, CancellationException cancellationException) {
        Iterator<g> it = gVar.getChildren().iterator();
        while (it.hasNext()) {
            it.next().i(cancellationException);
        }
    }

    public static /* synthetic */ void j(kotlin.coroutines.d dVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        C1086v0.h(dVar, cancellationException);
    }

    public static /* synthetic */ void k(g gVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        C1086v0.i(gVar, cancellationException);
    }

    public static final InterfaceC1045a0 l(g gVar, InterfaceC1045a0 interfaceC1045a0) {
        return q(gVar, false, new C1049c0(interfaceC1045a0), 1, null);
    }

    public static final void m(kotlin.coroutines.d dVar) {
        g gVar = (g) dVar.get(g.INSTANCE);
        if (gVar != null) {
            C1086v0.n(gVar);
        }
    }

    public static final void n(g gVar) {
        if (!gVar.b()) {
            throw gVar.G();
        }
    }

    public static final g o(kotlin.coroutines.d dVar) {
        g gVar = (g) dVar.get(g.INSTANCE);
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + dVar).toString());
    }

    public static final InterfaceC1045a0 p(g gVar, boolean z10, AbstractC1088w0 abstractC1088w0) {
        return gVar instanceof JobSupport ? ((JobSupport) gVar).j0(z10, abstractC1088w0) : gVar.I0(abstractC1088w0.u(), z10, new JobKt__JobKt$invokeOnCompletion$1(abstractC1088w0));
    }

    public static /* synthetic */ InterfaceC1045a0 q(g gVar, boolean z10, AbstractC1088w0 abstractC1088w0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return C1086v0.p(gVar, z10, abstractC1088w0);
    }

    public static final boolean r(kotlin.coroutines.d dVar) {
        g gVar = (g) dVar.get(g.INSTANCE);
        if (gVar != null) {
            return gVar.b();
        }
        return true;
    }
}

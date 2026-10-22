package kotlinx.coroutines;

import Ka.j;
import Ua.InterfaceC1045a0;
import Ua.InterfaceC1081t;
import Ua.r;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.d;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 ,2\u00020\u0001:\u0001\u001fJ\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nH¦@¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u00182\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\n0\u0014j\u0002`\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ=\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\n0\u0014j\u0002`\u0016H'¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\bR\u0014\u0010\"\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\bR\u0014\u0010#\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\bR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00000$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006-À\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/g;", "Lkotlin/coroutines/d$b;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "G", "()Ljava/util/concurrent/CancellationException;", "", "start", "()Z", "cause", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/concurrent/CancellationException;)V", "LUa/t;", "child", "LUa/r;", "N0", "(LUa/t;)LUa/r;", "T0", "(Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "LUa/a0;", "J", "(Lp9/l;)LUa/a0;", "onCancelling", "invokeImmediately", "I0", "(ZZLp9/l;)LUa/a0;", Const.INTENT_KEY_PKGNAME, "isActive", Const.INTENT_KEY_BACKGROUND_COMMAND, "isCompleted", "isCancelled", "LKa/j;", "getChildren", "()LKa/j;", "children", "Lcb/d;", "R0", "()Lcb/d;", "onJoin", "s0", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface g extends d.b {

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f36770a;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static <R> R b(g gVar, R r10, p<? super R, ? super d.b, ? extends R> pVar) {
            return (R) d.b.a.a(gVar, r10, pVar);
        }

        public static <E extends d.b> E c(g gVar, d.c<E> cVar) {
            return (E) d.b.a.b(gVar, cVar);
        }

        public static kotlin.coroutines.d e(g gVar, d.c<?> cVar) {
            return d.b.a.c(gVar, cVar);
        }

        public static kotlin.coroutines.d f(g gVar, kotlin.coroutines.d dVar) {
            return d.b.a.d(gVar, dVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/g$b;", "Lkotlin/coroutines/d$c;", "Lkotlinx/coroutines/g;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.g$b, reason: from kotlin metadata */
    public static final class Companion implements d.c<g> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f36770a = new Companion();
    }

    static /* synthetic */ void Y0(g gVar, CancellationException cancellationException, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        gVar.i(cancellationException);
    }

    static /* synthetic */ InterfaceC1045a0 b1(g gVar, boolean z10, boolean z11, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return gVar.I0(z10, z11, interfaceC5074l);
    }

    CancellationException G();

    InterfaceC1045a0 I0(boolean onCancelling, boolean invokeImmediately, InterfaceC5074l<? super Throwable, t> handler);

    InterfaceC1045a0 J(InterfaceC5074l<? super Throwable, t> handler);

    r N0(InterfaceC1081t child);

    cb.d R0();

    Object T0(InterfaceC4014c<? super t> interfaceC4014c);

    boolean b();

    boolean g();

    j<g> getChildren();

    void i(CancellationException cause);

    boolean isCancelled();

    boolean start();
}

package kotlinx.coroutines.flow.internal;

import La.w;
import Ua.C1086v0;
import Xa.c;
import Y8.t;
import Ya.e;
import Ya.i;
import Ya.n;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4111c;
import g9.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.SafeCollector;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020(8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010'R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lg9/c;", "collector", "Lkotlin/coroutines/d;", "collectContext", "<init>", "(LXa/c;Lkotlin/coroutines/d;)V", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "LY8/t;", "releaseIntercepted", "()V", UxipConstants.f30680s, "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Le9/c;", "uCont", "n", "(Le9/c;Ljava/lang/Object;)Ljava/lang/Object;", "currentContext", "previousContext", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlin/coroutines/d;Lkotlin/coroutines/d;Ljava/lang/Object;)V", "LYa/e;", "exception", "y", "(LYa/e;Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "LXa/c;", Const.INTENT_KEY_PKGNAME, "Lkotlin/coroutines/d;", "", "c", "I", "collectContextSize", Const.INTENT_KEY_UMID, "lastEmissionContext", "e", "Le9/c;", "completion_", "getCallerFrame", "()Lg9/c;", "callerFrame", "getContext", "()Lkotlin/coroutines/d;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SafeCollector<T> extends ContinuationImpl implements c<T>, InterfaceC4111c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final c<T> collector;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final d collectContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int collectContextSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public d lastEmissionContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public InterfaceC4014c<? super t> completion_;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(c<? super T> cVar, d dVar) {
        super(i.f7048a, EmptyCoroutineContext.f34779a);
        this.collector = cVar;
        this.collectContext = dVar;
        this.collectContextSize = ((Number) dVar.fold(0, new p() { // from class: Ya.l
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(SafeCollector.i(((Integer) obj).intValue(), (d.b) obj2));
            }
        })).intValue();
    }

    public static final int i(int i10, d.b bVar) {
        return i10 + 1;
    }

    @Override // Xa.c
    public Object emit(T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        try {
            Object objN = n(interfaceC4014c, t10);
            if (objN == C4063a.g()) {
                f.c(interfaceC4014c);
            }
            return objN == C4063a.g() ? objN : t.f7040a;
        } catch (Throwable th) {
            this.lastEmissionContext = new e(th, interfaceC4014c.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, g9.InterfaceC4111c
    public InterfaceC4111c getCallerFrame() {
        InterfaceC4014c<? super t> interfaceC4014c = this.completion_;
        if (interfaceC4014c instanceof InterfaceC4111c) {
            return (InterfaceC4111c) interfaceC4014c;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, e9.InterfaceC4014c
    public d getContext() {
        d dVar = this.lastEmissionContext;
        return dVar == null ? EmptyCoroutineContext.f34779a : dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h(d currentContext, d previousContext, T value) {
        if (previousContext instanceof e) {
            y((e) previousContext, value);
        }
        n.b(this, currentContext);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object result) {
        Throwable thE = Result.e(result);
        if (thE != null) {
            this.lastEmissionContext = new e(thE, getContext());
        }
        InterfaceC4014c<? super t> interfaceC4014c = this.completion_;
        if (interfaceC4014c != null) {
            interfaceC4014c.resumeWith(result);
        }
        return C4063a.g();
    }

    public final Object n(InterfaceC4014c<? super t> uCont, T value) {
        d context = uCont.getContext();
        C1086v0.m(context);
        d dVar = this.lastEmissionContext;
        if (dVar != context) {
            h(context, dVar, value);
            this.lastEmissionContext = context;
        }
        this.completion_ = uCont;
        q qVar = SafeCollectorKt.f36761a;
        c<T> cVar = this.collector;
        kotlin.jvm.internal.p.g(cVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = qVar.invoke(cVar, value, this);
        if (!kotlin.jvm.internal.p.d(objInvoke, C4063a.g())) {
            this.completion_ = null;
        }
        return objInvoke;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    public final void y(e exception, Object value) {
        throw new IllegalStateException(w.n("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + exception.e + ", but then emission attempt of value '" + value + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }
}

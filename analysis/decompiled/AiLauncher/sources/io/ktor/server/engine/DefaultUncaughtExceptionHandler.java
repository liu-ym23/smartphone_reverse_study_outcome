package io.ktor.server.engine;

import Ua.CoroutineName;
import Ua.J;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.d;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0015\b\u0016\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/server/engine/DefaultUncaughtExceptionHandler;", "LUa/J;", "Lkotlin/Function0;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "logger", "<init>", "(Lp9/a;)V", "(Lvc/c;)V", "Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", "handleException", "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "Lp9/a;", "Lkotlin/coroutines/d$c;", "getKey", "()Lkotlin/coroutines/d$c;", "key", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultUncaughtExceptionHandler implements J {
    private final InterfaceC5063a<vc.c> logger;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultUncaughtExceptionHandler(InterfaceC5063a<? extends vc.c> logger) {
        kotlin.jvm.internal.p.i(logger, "logger");
        this.logger = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vc.c _init_$lambda$0(vc.c cVar) {
        return cVar;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r10, p9.p<? super R, ? super d.b, ? extends R> pVar) {
        return (R) J.a.a(this, r10, pVar);
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public <E extends d.b> E get(d.c<E> cVar) {
        return (E) J.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.d.b
    public d.c<?> getKey() {
        return J.INSTANCE;
    }

    @Override // Ua.J
    public void handleException(kotlin.coroutines.d context, Throwable exception) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(exception, "exception");
        if ((exception instanceof CancellationException) || (exception instanceof IOException)) {
            return;
        }
        Object string = (CoroutineName) context.get(CoroutineName.INSTANCE);
        if (string == null) {
            string = context.toString();
        }
        this.logger.invoke().error("Unhandled exception caught for " + string, exception);
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d minusKey(d.c<?> cVar) {
        return J.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d plus(kotlin.coroutines.d dVar) {
        return J.a.d(this, dVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultUncaughtExceptionHandler(final vc.c logger) {
        this((InterfaceC5063a<? extends vc.c>) new InterfaceC5063a() { // from class: io.ktor.server.engine.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DefaultUncaughtExceptionHandler._init_$lambda$0(logger);
            }
        });
        kotlin.jvm.internal.p.i(logger, "logger");
    }
}

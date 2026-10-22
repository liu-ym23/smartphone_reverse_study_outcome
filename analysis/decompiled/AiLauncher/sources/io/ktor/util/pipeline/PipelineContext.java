package io.ktor.util.pipeline;

import Ua.M;
import e9.InterfaceC4014c;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@KtorDsl
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H¦@¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H @¢\u0006\u0004\b\u0011\u0010\rR\u0017\u0010\u0005\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "TSubject", "TContext", "LUa/M;", "context", "<init>", "(Ljava/lang/Object;)V", "LY8/t;", "finish", "()V", "subject", "proceedWith", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "proceed", "(Le9/c;)Ljava/lang/Object;", "initial", "execute$ktor_utils", "execute", "Ljava/lang/Object;", "getContext", "()Ljava/lang/Object;", "getSubject", "setSubject", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PipelineContext<TSubject, TContext> implements M {
    private final TContext context;

    public PipelineContext(TContext context) {
        p.i(context, "context");
        this.context = context;
    }

    public abstract Object execute$ktor_utils(TSubject tsubject, InterfaceC4014c<? super TSubject> interfaceC4014c);

    public abstract void finish();

    public final TContext getContext() {
        return this.context;
    }

    @Override // Ua.M
    public abstract /* synthetic */ d getCoroutineContext();

    public abstract TSubject getSubject();

    public abstract Object proceed(InterfaceC4014c<? super TSubject> interfaceC4014c);

    public abstract Object proceedWith(TSubject tsubject, InterfaceC4014c<? super TSubject> interfaceC4014c);

    public abstract void setSubject(TSubject tsubject);
}

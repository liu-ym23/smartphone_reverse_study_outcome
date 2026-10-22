package androidx.datastore.core;

import androidx.datastore.core.c;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import lb.n;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SimpleActor<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f1594a;

    /* renamed from: b, reason: collision with root package name */
    public final p<T, qb.b<? super n>, Object> f1595b;

    /* renamed from: c, reason: collision with root package name */
    public final Channel<T> f1596c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f1597d;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleActor(CoroutineScope coroutineScope, final l<? super Throwable, n> lVar, final p<? super T, ? super Throwable, n> onUndeliveredElement, p<? super T, ? super qb.b<? super n>, ? extends Object> pVar) {
        g.f(onUndeliveredElement, "onUndeliveredElement");
        this.f1594a = coroutineScope;
        this.f1595b = pVar;
        this.f1596c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f1597d = new AtomicInteger(0);
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job == null) {
            return;
        }
        job.invokeOnCompletion(new l<Throwable, n>() { // from class: androidx.datastore.core.SimpleActor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // zb.l
            public final n invoke(Throwable th) {
                n nVar;
                Throwable th2 = th;
                lVar.invoke(th2);
                SimpleActor<T> simpleActor = this;
                simpleActor.f1596c.close(th2);
                do {
                    Object objM156getOrNullimpl = ChannelResult.m156getOrNullimpl(simpleActor.f1596c.mo148tryReceivePtdJZtk());
                    if (objM156getOrNullimpl == null) {
                        nVar = null;
                    } else {
                        onUndeliveredElement.invoke(objM156getOrNullimpl, th2);
                        nVar = n.f10413a;
                    }
                } while (nVar != null);
                return n.f10413a;
            }
        });
    }

    public final void a(c.a aVar) {
        Object objMo149trySendJP2dKIU = this.f1596c.mo149trySendJP2dKIU(aVar);
        if (objMo149trySendJP2dKIU instanceof ChannelResult.Closed) {
            Throwable thM155exceptionOrNullimpl = ChannelResult.m155exceptionOrNullimpl(objMo149trySendJP2dKIU);
            if (thM155exceptionOrNullimpl != null) {
                throw thM155exceptionOrNullimpl;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!ChannelResult.m160isSuccessimpl(objMo149trySendJP2dKIU)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f1597d.getAndIncrement() == 0) {
            BuildersKt__Builders_commonKt.launch$default(this.f1594a, null, null, new SimpleActor$offer$2(this, null), 3, null);
        }
    }
}

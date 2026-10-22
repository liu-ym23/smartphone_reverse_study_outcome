package androidx.datastore.core;

import Ua.C1060i;
import Ua.M;
import Wa.g;
import Wa.j;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bh\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\t\u0012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R3\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/datastore/core/SimpleActor;", ExifInterface.GPS_DIRECTION_TRUE, "", "LUa/M;", "scope", "Lkotlin/Function1;", "", "LY8/t;", "onComplete", "Lkotlin/Function2;", "onUndeliveredElement", "Le9/c;", "consumeMessage", "<init>", "(LUa/M;Lp9/l;Lp9/p;Lp9/p;)V", "msg", "e", "(Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "LUa/M;", Const.INTENT_KEY_PKGNAME, "Lp9/p;", "LWa/g;", "c", "LWa/g;", "messageQueue", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_UMID, "Ljava/util/concurrent/atomic/AtomicInteger;", "remainingMessages", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SimpleActor<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final p<T, InterfaceC4014c<? super t>, Object> consumeMessage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final g<T> messageQueue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final AtomicInteger remainingMessages;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleActor(M scope, final InterfaceC5074l<? super Throwable, t> onComplete, final p<? super T, ? super Throwable, t> onUndeliveredElement, p<? super T, ? super InterfaceC4014c<? super t>, ? extends Object> consumeMessage) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(onComplete, "onComplete");
        kotlin.jvm.internal.p.i(onUndeliveredElement, "onUndeliveredElement");
        kotlin.jvm.internal.p.i(consumeMessage, "consumeMessage");
        this.scope = scope;
        this.consumeMessage = consumeMessage;
        this.messageQueue = j.b(Integer.MAX_VALUE, null, null, 6, null);
        this.remainingMessages = new AtomicInteger(0);
        kotlinx.coroutines.g gVar = (kotlinx.coroutines.g) scope.getCoroutineContext().get(kotlinx.coroutines.g.INSTANCE);
        if (gVar == null) {
            return;
        }
        gVar.J(new InterfaceC5074l<Throwable, t>() { // from class: androidx.datastore.core.SimpleActor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void a(Throwable th) {
                t tVar;
                onComplete.invoke(th);
                this.messageQueue.close(th);
                do {
                    Object objF = a.f(this.messageQueue.s());
                    if (objF == null) {
                        tVar = null;
                    } else {
                        onUndeliveredElement.invoke(objF, th);
                        tVar = t.f7040a;
                    }
                } while (tVar != null);
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                a(th);
                return t.f7040a;
            }
        });
    }

    public final void e(T msg) {
        Object objMo0trySendJP2dKIU = this.messageQueue.mo0trySendJP2dKIU(msg);
        if (objMo0trySendJP2dKIU instanceof a.Closed) {
            Throwable thE = a.e(objMo0trySendJP2dKIU);
            if (thE != null) {
                throw thE;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!a.j(objMo0trySendJP2dKIU)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.remainingMessages.getAndIncrement() == 0) {
            C1060i.d(this.scope, null, null, new SimpleActor$offer$2(this, null), 3, null);
        }
    }
}

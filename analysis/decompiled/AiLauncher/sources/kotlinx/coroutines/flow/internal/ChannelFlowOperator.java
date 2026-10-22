package kotlinx.coroutines.flow.internal;

import Ua.G;
import Xa.b;
import Xa.c;
import Y8.t;
import Ya.o;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH¤@¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0015\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0094@¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0096@¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001c\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "LXa/b;", "flow", "Lkotlin/coroutines/d;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(LXa/b;Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)V", "LXa/c;", "collector", "LY8/t;", "r", "(LXa/c;Le9/c;)Ljava/lang/Object;", "LWa/p;", "scope", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LWa/p;Le9/c;)Ljava/lang/Object;", "collect", "", "toString", "()Ljava/lang/String;", "newContext", "q", "(LXa/c;Lkotlin/coroutines/d;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "LXa/b;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final b<S> flow;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(b<? extends S> bVar, d dVar, int i10, BufferOverflow bufferOverflow) {
        super(dVar, i10, bufferOverflow);
        this.flow = bVar;
    }

    public static /* synthetic */ <S, T> Object o(ChannelFlowOperator<S, T> channelFlowOperator, c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        if (channelFlowOperator.capacity == -3) {
            d context = interfaceC4014c.getContext();
            d dVarK = G.k(context, channelFlowOperator.context);
            if (p.d(dVarK, context)) {
                Object objR = channelFlowOperator.r(cVar, interfaceC4014c);
                return objR == C4063a.g() ? objR : t.f7040a;
            }
            c.Companion companion = kotlin.coroutines.c.INSTANCE;
            if (p.d(dVarK.get(companion), context.get(companion))) {
                Object objQ = channelFlowOperator.q(cVar, dVarK, interfaceC4014c);
                return objQ == C4063a.g() ? objQ : t.f7040a;
            }
        }
        Object objCollect = super.collect(cVar, interfaceC4014c);
        return objCollect == C4063a.g() ? objCollect : t.f7040a;
    }

    public static /* synthetic */ <S, T> Object p(ChannelFlowOperator<S, T> channelFlowOperator, Wa.p<? super T> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objR = channelFlowOperator.r(new o(pVar), interfaceC4014c);
        return objR == C4063a.g() ? objR : t.f7040a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, Xa.b
    public Object collect(Xa.c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return o(this, cVar, interfaceC4014c);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(Wa.p<? super T> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return p(this, pVar, interfaceC4014c);
    }

    public final Object q(Xa.c<? super T> cVar, d dVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ChannelFlowKt.c(dVar, ChannelFlowKt.d(cVar, interfaceC4014c.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), interfaceC4014c, 4, null);
    }

    public abstract Object r(Xa.c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}

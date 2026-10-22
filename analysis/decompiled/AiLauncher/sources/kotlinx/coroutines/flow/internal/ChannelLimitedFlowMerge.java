package kotlinx.coroutines.flow.internal;

import Ua.C1060i;
import Ua.M;
import Wa.p;
import Wa.r;
import Xa.b;
import Y8.t;
import Ya.o;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0017\u001a\u00020\u00162\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0094@¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "", "LXa/b;", "flows", "Lkotlin/coroutines/d;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Ljava/lang/Iterable;Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "LUa/M;", "scope", "LWa/r;", "n", "(LUa/M;)LWa/r;", "LWa/p;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LWa/p;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "Ljava/lang/Iterable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Iterable<b<T>> flows;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge(Iterable<? extends b<? extends T>> iterable, d dVar, int i10, BufferOverflow bufferOverflow) {
        super(dVar, i10, bufferOverflow);
        this.flows = iterable;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(p<? super T> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        o oVar = new o(pVar);
        Iterator<b<T>> it = this.flows.iterator();
        while (it.hasNext()) {
            C1060i.d(pVar, null, null, new ChannelLimitedFlowMerge$collectTo$2$1(it.next(), oVar, null), 3, null);
        }
        return t.f7040a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<T> j(d context, int capacity, BufferOverflow onBufferOverflow) {
        return new ChannelLimitedFlowMerge(this.flows, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public r<T> n(M scope) {
        return ProduceKt.c(scope, this.context, this.capacity, l());
    }

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, d dVar, int i10, BufferOverflow bufferOverflow, int i11, i iVar) {
        this(iterable, (i11 & 2) != 0 ? EmptyCoroutineContext.f34779a : dVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }
}

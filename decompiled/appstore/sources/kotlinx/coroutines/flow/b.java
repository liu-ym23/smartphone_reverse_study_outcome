package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends ChannelFlow {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2 f21508d;

    public b(Function2 r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r11, r12, r13);
        this.f21508d = r10;
    }

    public static /* synthetic */ Object i(b r10, ProducerScope r11, Continuation r12) {
        Object r13 = r10.f21508d.mo0invoke(r11, r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object c(ProducerScope r10, Continuation r11) {
        return i(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.f21508d + "] -> " + super.toString();
    }
}

package Wa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010 \u001a\u00020\u00032\u0014\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00030\u001eH\u0096\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b\"\u0010#J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096A¢\u0006\u0004\b$\u0010#J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096\u0001¢\u0006\u0004\b%\u0010&J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0096\u0003¢\u0006\u0004\b(\u0010)R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b.\u0010-R\u0014\u00100\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b2\u00101R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000038\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00105R \u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018038\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00105¨\u00069"}, d2 = {"LWa/h;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/a;", "LY8/t;", "LWa/g;", "Lkotlin/coroutines/d;", "parentContext", "_channel", "", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/d;LWa/g;ZZ)V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/concurrent/CancellationException;)V", "", "I", "(Ljava/lang/Throwable;)V", "element", "send", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/a;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "invokeOnClose", "(Lp9/l;)V", "receive", "(Le9/c;)Ljava/lang/Object;", "u", "s", "()Ljava/lang/Object;", "LWa/i;", "iterator", "()LWa/i;", Const.INTENT_KEY_UMID, "LWa/g;", "Z0", "()LWa/g;", "getChannel", "channel", "isClosedForSend", "()Z", "isEmpty", "Lcb/f;", "p", "()Lcb/f;", "onReceive", "r", "onReceiveCatching", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class h<E> extends kotlinx.coroutines.a<Y8.t> implements g<E> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final g<E> _channel;

    public h(kotlin.coroutines.d dVar, g<E> gVar, boolean z10, boolean z11) {
        super(dVar, z10, z11);
        this._channel = gVar;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void I(Throwable cause) {
        CancellationException cancellationExceptionK0 = JobSupport.K0(this, cause, null, 1, null);
        this._channel.i(cancellationExceptionK0);
        F(cancellationExceptionK0);
    }

    public final g<E> Z0() {
        return this._channel;
    }

    @Override // Wa.s
    public boolean close(Throwable cause) {
        return this._channel.close(cause);
    }

    public final g<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.g, Wa.r
    public final void i(CancellationException cause) {
        if (isCancelled()) {
            return;
        }
        if (cause == null) {
            cause = new JobCancellationException(M(), null, this);
        }
        I(cause);
    }

    @Override // Wa.s
    public void invokeOnClose(InterfaceC5074l<? super Throwable, Y8.t> handler) {
        this._channel.invokeOnClose(handler);
    }

    @Override // Wa.s
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // Wa.r
    public boolean isEmpty() {
        return this._channel.isEmpty();
    }

    @Override // Wa.r
    public i<E> iterator() {
        return this._channel.iterator();
    }

    @Override // Wa.r
    public cb.f<E> p() {
        return this._channel.p();
    }

    @Override // Wa.r
    public cb.f<kotlinx.coroutines.channels.a<E>> r() {
        return this._channel.r();
    }

    @Override // Wa.r
    public Object receive(InterfaceC4014c<? super E> interfaceC4014c) {
        return this._channel.receive(interfaceC4014c);
    }

    @Override // Wa.r
    public Object s() {
        return this._channel.s();
    }

    @Override // Wa.s
    public Object send(E e10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return this._channel.send(e10, interfaceC4014c);
    }

    @Override // Wa.s
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo0trySendJP2dKIU(E element) {
        return this._channel.mo0trySendJP2dKIU(element);
    }

    @Override // Wa.r
    public Object u(InterfaceC4014c<? super kotlinx.coroutines.channels.a<? extends E>> interfaceC4014c) {
        Object objU = this._channel.u(interfaceC4014c);
        C4063a.g();
        return objU;
    }
}

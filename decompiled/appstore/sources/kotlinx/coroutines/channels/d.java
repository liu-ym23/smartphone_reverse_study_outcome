package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends kotlinx.coroutines.a implements Channel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Channel f21359d;

    public d(CoroutineContext r10, Channel r11, boolean r12, boolean r13) {
        super(r10, r12, r13);
        this.f21359d = r11;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException r10) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        r10 = new JobCancellationException(JobSupport.a(this), null, this);
    L7:
        m(r10);
    }

    public boolean close(Throwable r10) {
        return this.f21359d.close(r10);
    }

    public final Channel getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceive() {
        return this.f21359d.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceiveCatching() {
        return this.f21359d.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceiveOrNull() {
        return this.f21359d.getOnReceiveOrNull();
    }

    public SelectClause2 getOnSend() {
        return this.f21359d.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1 r10) {
        this.f21359d.invokeOnClose(r10);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this.f21359d.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.f21359d.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.f21359d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator iterator() {
        return this.f21359d.iterator();
    }

    @Override // kotlinx.coroutines.JobSupport
    public void m(Throwable r10) {
        CancellationException r11 = JobSupport.g0(this, r10, null, 1, null);
        this.f21359d.cancel(r11);
        k(r11);
    }

    public boolean offer(Object r10) {
        return this.f21359d.offer(r10);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object poll() {
        return this.f21359d.poll();
    }

    public final Channel r0() {
        return this.f21359d;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation r10) {
        return this.f21359d.receive(r10);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public Object mo51receiveCatchingJP2dKIU(Continuation r10) {
        Object r11 = this.f21359d.mo51receiveCatchingJP2dKIU(r10);
        kotlin.coroutines.intrinsics.a.d();
        return r11;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receiveOrNull(Continuation r10) {
        return this.f21359d.receiveOrNull(r10);
    }

    public Object send(Object r10, Continuation r11) {
        return this.f21359d.send(r10, r11);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public Object mo52tryReceivePtdJZtk() {
        return this.f21359d.mo52tryReceivePtdJZtk();
    }

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo53trySendJP2dKIU(Object r10) {
        return this.f21359d.mo53trySendJP2dKIU(r10);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        m(new JobCancellationException(JobSupport.a(this), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final /* synthetic */ boolean cancel(Throwable r10) {
        m(new JobCancellationException(JobSupport.a(this), null, this));
        return true;
    }
}

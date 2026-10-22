package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a0;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends d implements ProducerScope {
    public j(CoroutineContext r10, Channel r11) {
        super(r10, r11, true, true);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public /* bridge */ /* synthetic */ SendChannel getChannel() {
        return getChannel();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.a
    public void o0(Throwable r10, boolean r11) {
        if (r0().close(r10) == true) goto L7;
        if (r11 == true) goto L8;
        a0.a(getContext(), r10);
        return;
    L8:
        return;
    }

    @Override // kotlinx.coroutines.a
    public /* bridge */ /* synthetic */ void p0(Object r10) {
        s0((Unit) r10);
    }

    public void s0(Unit r10) {
        SendChannel.a.a(r0(), null, 1, null);
    }
}

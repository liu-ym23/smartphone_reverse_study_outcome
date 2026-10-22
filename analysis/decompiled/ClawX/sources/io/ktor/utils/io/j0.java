package io.ktor.utils.io;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f3210a;

    public j0(Throwable th) {
        this.f3210a = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Throwable a(p5.l lVar) {
        Throwable th = this.f3210a;
        if (th == 0) {
            return null;
        }
        if (th instanceof a6.x) {
            return ((a6.x) th).a();
        }
        if (!(th instanceof CancellationException)) {
            return (Throwable) lVar.invoke(th);
        }
        CancellationException cancellationException = new CancellationException(((CancellationException) th).getMessage());
        cancellationException.initCause(th);
        return cancellationException;
    }
}

package bytekn.foundation.utils;

import bytekn.foundation.concurrent.scheduler.SchedulersKt;
import bytekn.foundation.concurrent.scheduler.i;

/* JADX INFO: loaded from: classes3.dex */
public final class Transmitter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i.a f21805a = null;

    static {
        f21805a = SchedulersKt.f21736a.f21899a.get().getValue().a();
    }

    public static void a(final Runnable r100) {
        f21805a.a(0, new Transmitter$transmitToMainThread$1(r100));
    }
}

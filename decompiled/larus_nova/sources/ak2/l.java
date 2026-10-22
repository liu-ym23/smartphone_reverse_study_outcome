package ak2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3990b;

    public final void b() {
        Object r100 = this.f3990b;
        if ((r100 instanceof fe.c) == false) goto L6;
        ((fe.c) r100).release();
        return;
    L6:
        if ((r100 instanceof vlc.d) == false) goto L10;
        ((vlc.d) r100).release();
        return;
    }

    public final void c() {
        Object r100 = this.f3990b;
        if ((r100 instanceof fe.c) == false) goto L6;
        ((fe.c) r100).startMessage();
        return;
    L6:
        if ((r100 instanceof vlc.d) == false) goto L10;
        ((vlc.d) r100).startMessage();
        return;
    }

    public final void a(com.bytedance.android.livesdk.livecommerce.messagev2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = this.f3990b;
        if ((r101 instanceof fe.c) == false) goto L6;
        ((fe.c) r101).a();
        return;
    L6:
        if ((r101 instanceof vlc.d) == false) goto L10;
        ((vlc.d) r101).addMessageListener(1003, new k(this, r100));
        return;
    }

    public l(long r100, vlc.d r101) {
        this.f3989a = r100;
        this.f3990b = r101;
    }
}

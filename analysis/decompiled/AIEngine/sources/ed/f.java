package ed;

import okhttp3.internal.ws.RealWebSocket;
import sd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends RealWebSocket.c {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f8648c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, sd.g gVar, d dVar) {
        super(hVar, gVar);
        this.f8648c = dVar;
    }

    public final void a() {
        this.f8648c.f8636d.cancel();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8648c.a(-1L, true, true, null);
    }
}

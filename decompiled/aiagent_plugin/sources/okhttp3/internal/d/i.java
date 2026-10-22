package okhttp3.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.IOException;

/* JADX INFO: compiled from: RouteException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IOException f39905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f39906b;

    public final IOException a() {
        return this.f39905a;
    }

    public i(IOException r3) {
        o.e(r3, "firstConnectException");
        super((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        this.f39905a = r3;
        this.f39906b = r3;
    }

    public final IOException b() {
        return this.f39906b;
    }

    public final void a(IOException r4) {
        o.e(r4, "e");
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(this.f39905a, Throwable.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
        this.f39906b = r4;
    }
}

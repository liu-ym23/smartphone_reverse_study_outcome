package okhttp3.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import okhttp3.ad;
import okhttp3.w;

/* JADX INFO: compiled from: ConnectInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39855a = null;

    static {
        f39855a = new a();
    }

    private a() {
    }

    @Override // okhttp3.w
    public ad intercept(w.a r11) {
        w.a r10 = (w.a) ZeusTransformUtils.wrapperContextForParams(r11, w.a.class, "com.obric.aiagent.plugin");
        o.e(r10, "chain");
        okhttp3.internal.e.g r12 = (okhttp3.internal.e.g) ZeusTransformUtils.preCheckCast(r10, okhttp3.internal.e.g.class, "com.obric.aiagent.plugin");
        return okhttp3.internal.e.g.a(r12, 0, r12.c().a((okhttp3.internal.e.g) ZeusTransformUtils.preCheckCast(r10, okhttp3.internal.e.g.class, "com.obric.aiagent.plugin")), null, 0, 0, 0, 61, null).a(r12.e());
    }
}

package Ua;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"LUa/O0;", "", "<init>", "()V", "LUa/e0;", Const.INTENT_KEY_APIKEY, "()LUa/e0;", "LY8/t;", "c", "eventLoop", Const.INTENT_KEY_UMID, "(LUa/e0;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/ThreadLocal;", "ref", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class O0 {

    /* renamed from: a, reason: collision with root package name */
    public static final O0 f6339a = new O0();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final ThreadLocal<AbstractC1053e0> ref = Za.M.a(new Za.C("ThreadLocalEventLoop"));

    public final AbstractC1053e0 a() {
        return ref.get();
    }

    public final AbstractC1053e0 b() {
        ThreadLocal<AbstractC1053e0> threadLocal = ref;
        AbstractC1053e0 abstractC1053e0 = threadLocal.get();
        if (abstractC1053e0 != null) {
            return abstractC1053e0;
        }
        AbstractC1053e0 abstractC1053e0A = C1059h0.a();
        threadLocal.set(abstractC1053e0A);
        return abstractC1053e0A;
    }

    public final void c() {
        ref.set(null);
    }

    public final void d(AbstractC1053e0 eventLoop) {
        ref.set(eventLoop);
    }
}

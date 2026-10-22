package E0;

import C0.o;
import Z2.C0125f0;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final o f400a;

    /* renamed from: b, reason: collision with root package name */
    public final C0125f0 f401b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f402c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public final b f403d = new b(this);

    public c(ExecutorService executorService) {
        o oVar = new o(executorService);
        this.f400a = oVar;
        this.f401b = new C0125f0(oVar);
    }
}

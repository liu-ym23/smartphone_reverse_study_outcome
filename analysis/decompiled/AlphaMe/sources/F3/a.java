package F3;

import A3.d;
import A3.h;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference f455d = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final h f456a;

    /* renamed from: b, reason: collision with root package name */
    public final d f457b;

    /* renamed from: c, reason: collision with root package name */
    public final v3.d f458c;

    public a() {
        E3.h.f420f.e().getClass();
        this.f456a = new h(new B3.h("RxComputationScheduler-"));
        this.f457b = new d(new B3.h("RxIoScheduler-"));
        this.f458c = new v3.d(2, new B3.h("RxNewThreadScheduler-"));
    }
}

package b7;

import com.stepos.base.model.ModelReleaseReason;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.model.manager.ModelInstanceWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final String f3107a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3108b;

    /* renamed from: c, reason: collision with root package name */
    public final ModelInstanceWrapper f3109c;

    /* renamed from: d, reason: collision with root package name */
    public final t f3110d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3111e;
    public final AtomicBoolean h;

    public n(String modelId, int i10, ModelInstanceWrapper modelInstanceWrapper, ModelCacheImpl cache, String str) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(cache, "cache");
        this.f3107a = modelId;
        this.f3108b = i10;
        this.f3109c = modelInstanceWrapper;
        this.f3110d = cache;
        this.f3111e = str;
        this.h = new AtomicBoolean(false);
    }

    public final void a(ModelReleaseReason reason) {
        kotlin.jvm.internal.g.f(reason, "reason");
        if (this.h.compareAndSet(false, true)) {
            this.f3110d.releaseHandle(this.f3107a, this.f3108b, this.f3109c, this.f3111e, reason);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        a(ModelReleaseReason.f6321b);
    }
}

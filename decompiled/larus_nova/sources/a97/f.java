package a97;

import com.bytedance.reparo.core.l;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f2292c;

    @Override // a97.a
    public final void d() {
        this.f2292c.incrementAndGet();
    }

    public f(l.b r100, AtomicInteger r101) {
        this.f2292c = r101;
        super(r100);
    }
}

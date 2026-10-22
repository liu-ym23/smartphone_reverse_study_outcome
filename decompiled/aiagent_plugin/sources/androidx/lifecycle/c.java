package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlinx.coroutines.ce;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable, kotlinx.coroutines.am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.g f2045a;

    public c(d.c.g r3) {
        d.c.g r4 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        this.f2045a = r4;
    }

    @Override // kotlinx.coroutines.am
    public d.c.g a() {
        return this.f2045a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ce.a(a(), null, 1, null);
    }
}

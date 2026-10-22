package D;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class q0 extends androidx.camera.core.g {

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f2162d;

    public q0(androidx.camera.core.i iVar) {
        super(iVar);
        this.f2162d = new AtomicBoolean(false);
    }

    @Override // androidx.camera.core.g, androidx.camera.core.i, java.lang.AutoCloseable
    public void close() {
        if (this.f2162d.getAndSet(true)) {
            return;
        }
        super.close();
    }
}

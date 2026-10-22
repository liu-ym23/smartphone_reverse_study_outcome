package bt3;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PthreadThreadV2 f20543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue<Runnable> f20544b;

    public e() {
        this.f20544b = new LinkedTransferQueue();
        this.f20543a = new PthreadThreadV2(new d(this), "looper_monitor");
    }

    public final void a(Runnable r100) {
        ((LinkedTransferQueue) this.f20544b).offer(r100);
    }
}

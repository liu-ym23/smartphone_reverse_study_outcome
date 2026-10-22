package bb;

import Ua.AbstractC1067l0;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J/\u0010\u0017\u001a\u00020\u00102\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\n\u0010\f\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lbb/e;", "LUa/l0;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlin/coroutines/d;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LY8/t;", "h1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "k1", "", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "w1", "(Ljava/lang/Runnable;ZZ)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "v1", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "c", "I", Const.INTENT_KEY_UMID, "e", "J", "f", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "Ljava/util/concurrent/Executor;", "u1", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: bb.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1470e extends AbstractC1067l0 {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int corePoolSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int maxPoolSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final long idleWorkerKeepAliveNs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String schedulerName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public CoroutineScheduler coroutineScheduler = v1();

    public C1470e(int i10, int i11, long j10, String str) {
        this.corePoolSize = i10;
        this.maxPoolSize = i11;
        this.idleWorkerKeepAliveNs = j10;
        this.schedulerName = str;
    }

    @Override // Ua.I
    public void h1(kotlin.coroutines.d context, Runnable block) {
        CoroutineScheduler.A(this.coroutineScheduler, block, false, false, 6, null);
    }

    @Override // Ua.I
    public void k1(kotlin.coroutines.d context, Runnable block) {
        CoroutineScheduler.A(this.coroutineScheduler, block, false, true, 2, null);
    }

    @Override // Ua.AbstractC1067l0
    public Executor u1() {
        return this.coroutineScheduler;
    }

    public final CoroutineScheduler v1() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    public final void w1(Runnable block, boolean context, boolean fair) {
        this.coroutineScheduler.n(block, context, fair);
    }
}

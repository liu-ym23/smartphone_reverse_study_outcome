package bb;

import Ua.AbstractC1067l0;
import Ua.I;
import Za.D;
import Za.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import v9.C5685n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\u0005j\u0002`\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\u0005j\u0002`\u0013H\u0017¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lbb/a;", "LUa/l0;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "Ljava/lang/Runnable;", "command", "LY8/t;", "execute", "(Ljava/lang/Runnable;)V", "", "parallelism", "", "name", "LUa/I;", "s1", "(ILjava/lang/String;)LUa/I;", "Lkotlin/coroutines/d;", "context", "Lkotlinx/coroutines/Runnable;", "block", "h1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "k1", "close", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "LUa/I;", "default", "u1", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: bb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ExecutorC1466a extends AbstractC1067l0 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static final ExecutorC1466a f15370c = new ExecutorC1466a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final I default = I.t1(C1475j.f15388b, F.e("kotlinx.coroutines.io.parallelism", C5685n.f(64, D.a()), 0, 0, 12, null), null, 2, null);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        h1(EmptyCoroutineContext.f34779a, command);
    }

    @Override // Ua.I
    public void h1(kotlin.coroutines.d context, Runnable block) {
        default.h1(context, block);
    }

    @Override // Ua.I
    public void k1(kotlin.coroutines.d context, Runnable block) {
        default.k1(context, block);
    }

    @Override // Ua.I
    public I s1(int parallelism, String name) {
        return C1475j.f15388b.s1(parallelism, name);
    }

    @Override // Ua.I
    /* renamed from: toString */
    public String getName() {
        return "Dispatchers.IO";
    }

    @Override // Ua.AbstractC1067l0
    /* renamed from: u1 */
    public Executor getExecutor() {
        return this;
    }
}

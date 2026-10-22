package b8;

import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Supplier;
import reactor.core.scheduler.Scheduler;
import reactor.util.retry.RetryBackoffSpec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class q0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2012c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2013f;

    public /* synthetic */ q0(int i) {
        this.f2012c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f2012c;
        Object obj = this.f2013f;
        switch (i) {
            case 0:
                return ((w7.l) obj).d();
            case 1:
                return ((JsonRecyclerPools.BoundedPool) obj).lambda$readResolve$0();
            case 2:
                return ((JsonNodeCreator) obj).arrayNode();
            case 3:
                return ((McpStreamableServerSession) obj).lambda$closeGracefully$8();
            case 4:
                return RetryBackoffSpec.lambda$scheduler$3((Scheduler) obj);
            default:
                return ((String) obj).toString();
        }
    }
}

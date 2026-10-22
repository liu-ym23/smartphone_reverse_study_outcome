package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Supplier;
import reactor.core.scheduler.Scheduler;
import reactor.util.retry.RetryBackoffSpec;
import u3.i;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2268a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f2268a = i;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f2268a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((JsonRecyclerPools.BoundedPool) obj).lambda$readResolve$0();
            case 1:
                return ((JsonNodeCreator) obj).arrayNode();
            case 2:
                return ((McpStreamableServerSession) obj).lambda$closeGracefully$8();
            case 3:
                return RetryBackoffSpec.lambda$scheduler$3((Scheduler) obj);
            case 4:
                return ((String) obj).toString();
            default:
                return ((i) obj).d();
        }
    }
}

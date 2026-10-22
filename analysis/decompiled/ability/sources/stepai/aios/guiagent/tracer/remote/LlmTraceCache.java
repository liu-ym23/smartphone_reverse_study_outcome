package stepai.aios.guiagent.tracer.remote;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lstepai/aios/guiagent/tracer/remote/LlmTraceCache;", "", AppAgent.CONSTRUCT, "()V", "", AgentBusWakeContract.EXTRA_TRACE_ID, "Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;", "requestAndResponse", "LC7/r;", "put", "(Ljava/lang/String;Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;)V", "get", "(Ljava/lang/String;)Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;", "remove", "(Ljava/lang/String;)V", "", "traceIds", "removeAll", "(Ljava/util/Collection;)V", "", "size", "()I", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LlmTraceCache {
    public static final LlmTraceCache INSTANCE = new LlmTraceCache();
    private static final ConcurrentHashMap<String, RequestAndResponse> cache = new ConcurrentHashMap<>();

    private LlmTraceCache() {
    }

    public final RequestAndResponse get(String traceId) {
        k.f(traceId, "traceId");
        return cache.get(traceId);
    }

    public final void put(String traceId, RequestAndResponse requestAndResponse) {
        k.f(traceId, "traceId");
        k.f(requestAndResponse, "requestAndResponse");
        cache.put(traceId, requestAndResponse);
    }

    public final void remove(String traceId) {
        k.f(traceId, "traceId");
        cache.remove(traceId);
    }

    public final void removeAll(Collection<String> traceIds) {
        k.f(traceIds, "traceIds");
        Iterator<T> it = traceIds.iterator();
        while (it.hasNext()) {
            cache.remove((String) it.next());
        }
    }

    public final int size() {
        return cache.size();
    }
}

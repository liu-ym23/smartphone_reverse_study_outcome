package stepai.aios.guiagent.llm.parser;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.llm.Message;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lstepai/aios/guiagent/llm/parser/ModelRequestPayload;", "", "messages", "", "Lstepai/aios/guiagent/llm/Message;", "metadata", "", "", AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/util/Map;)V", "getMessages", "()Ljava/util/List;", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ModelRequestPayload {
    private final List<Message> messages;
    private final Map<String, Object> metadata;

    public ModelRequestPayload(List<Message> messages, Map<String, ? extends Object> metadata) {
        k.f(messages, "messages");
        k.f(metadata, "metadata");
        this.messages = messages;
        this.metadata = metadata;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelRequestPayload copy$default(ModelRequestPayload modelRequestPayload, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelRequestPayload.messages;
        }
        if ((i & 2) != 0) {
            map = modelRequestPayload.metadata;
        }
        return modelRequestPayload.copy(list, map);
    }

    public final List<Message> component1() {
        return this.messages;
    }

    public final Map<String, Object> component2() {
        return this.metadata;
    }

    public final ModelRequestPayload copy(List<Message> messages, Map<String, ? extends Object> metadata) {
        k.f(messages, "messages");
        k.f(metadata, "metadata");
        return new ModelRequestPayload(messages, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelRequestPayload)) {
            return false;
        }
        ModelRequestPayload modelRequestPayload = (ModelRequestPayload) other;
        return k.b(this.messages, modelRequestPayload.messages) && k.b(this.metadata, modelRequestPayload.metadata);
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        return this.metadata.hashCode() + (this.messages.hashCode() * 31);
    }

    public String toString() {
        return "ModelRequestPayload(messages=" + this.messages + ", metadata=" + this.metadata + ")";
    }

    public /* synthetic */ ModelRequestPayload(List list, Map map, int i, e eVar) {
        this(list, (i & 2) != 0 ? a.M() : map);
    }
}

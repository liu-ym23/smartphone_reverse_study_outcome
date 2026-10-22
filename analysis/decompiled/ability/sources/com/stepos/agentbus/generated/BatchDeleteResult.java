package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentbus/generated/BatchDeleteResult;", "", "items", "", "Lcom/stepos/agentbus/generated/BatchDeleteItem;", "error", "Lcom/stepos/agentbus/generated/ErrorShape;", AppAgent.CONSTRUCT, "(Ljava/util/List;Lcom/stepos/agentbus/generated/ErrorShape;)V", "getItems", "()Ljava/util/List;", "getError", "()Lcom/stepos/agentbus/generated/ErrorShape;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BatchDeleteResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorShape error;
    private final List<BatchDeleteItem> items;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/stepos/agentbus/generated/BatchDeleteResult$Companion;", "", AppAgent.CONSTRUCT, "()V", "error", "Lcom/stepos/agentbus/generated/BatchDeleteResult;", "code", "", "message", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final BatchDeleteResult error(String code, String message) {
            k.f(code, "code");
            k.f(message, "message");
            return new BatchDeleteResult(EmptyList.f4893a, new ErrorShape(code, message));
        }

        private Companion() {
        }
    }

    public BatchDeleteResult() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchDeleteResult copy$default(BatchDeleteResult batchDeleteResult, List list, ErrorShape errorShape, int i, Object obj) {
        if ((i & 1) != 0) {
            list = batchDeleteResult.items;
        }
        if ((i & 2) != 0) {
            errorShape = batchDeleteResult.error;
        }
        return batchDeleteResult.copy(list, errorShape);
    }

    public final List<BatchDeleteItem> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final ErrorShape getError() {
        return this.error;
    }

    public final BatchDeleteResult copy(List<BatchDeleteItem> items, ErrorShape error) {
        k.f(items, "items");
        return new BatchDeleteResult(items, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchDeleteResult)) {
            return false;
        }
        BatchDeleteResult batchDeleteResult = (BatchDeleteResult) other;
        return k.b(this.items, batchDeleteResult.items) && k.b(this.error, batchDeleteResult.error);
    }

    public final ErrorShape getError() {
        return this.error;
    }

    public final List<BatchDeleteItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        ErrorShape errorShape = this.error;
        return iHashCode + (errorShape == null ? 0 : errorShape.hashCode());
    }

    public String toString() {
        return "BatchDeleteResult(items=" + this.items + ", error=" + this.error + ")";
    }

    public BatchDeleteResult(List list, ErrorShape errorShape, int i, e eVar) {
        this((i & 1) != 0 ? EmptyList.f4893a : list, (i & 2) != 0 ? null : errorShape);
    }

    public BatchDeleteResult(List<BatchDeleteItem> items, ErrorShape errorShape) {
        k.f(items, "items");
        this.items = items;
        this.error = errorShape;
    }
}

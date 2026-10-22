package com.stepos.agentbus.generated;

import C7.r;
import H7.c;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\b\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H¦@¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentbus/generated/InvocationContext;", "", "LC7/r;", "ensureActive", "(LH7/c;)Ljava/lang/Object;", "", "", "progress", "reportProgress", "(Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "getInvocationId", "()Ljava/lang/String;", "invocationId", "getNodeId", "nodeId", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface InvocationContext {
    Object ensureActive(c<? super r> cVar);

    String getInvocationId();

    String getNodeId();

    Object reportProgress(Map<String, ? extends Object> map, c<? super r> cVar);
}

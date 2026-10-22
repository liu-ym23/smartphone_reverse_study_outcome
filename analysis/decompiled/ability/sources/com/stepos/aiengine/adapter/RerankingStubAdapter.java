package com.stepos.aiengine.adapter;

import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.reranking.IReranking;
import com.stepos.aiengine.data.IntMatrix;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J0\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0016¨\u0006\u0015"}, d2 = {"Lcom/stepos/aiengine/adapter/RerankingStubAdapter;", "Lcom/stepos/aiengine/algorithm/reranking/IReranking;", AppAgent.CONSTRUCT, "()V", "cancel", "", "identity", "", "getMaxTokenLimit", "", "reranking", "", "query", "", "candidates", "", "maxResults", "minScore", "", "calculateTokenLengthLimit", "Lcom/stepos/aiengine/data/IntMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RerankingStubAdapter implements IReranking {
    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public IntMatrix calculateTokenLengthLimit(String query, List<String> candidates) {
        k.f(query, "query");
        k.f(candidates, "candidates");
        return null;
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public boolean cancel(long identity) {
        return false;
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public int getMaxTokenLimit() {
        return 512;
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public float[] reranking(String query, List<String> candidates, int maxResults, double minScore) {
        k.f(query, "query");
        k.f(candidates, "candidates");
        Log.w("RerankingStub", "Reranking: not implemented yet");
        return null;
    }
}

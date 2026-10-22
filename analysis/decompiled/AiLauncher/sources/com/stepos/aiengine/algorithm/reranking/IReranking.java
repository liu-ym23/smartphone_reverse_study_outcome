package com.stepos.aiengine.algorithm.reranking;

import android.os.Bundle;
import com.stepos.aiengine.data.IntMatrix;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J0\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J:\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH&¨\u0006\u0015"}, d2 = {"Lcom/stepos/aiengine/algorithm/reranking/IReranking;", "", "cancel", "", e.f30860s, "", "getMaxTokenLimit", "", "reranking", "", "query", "", "candidates", "", "maxResults", "minScore", "", "args", "Landroid/os/Bundle;", "calculateTokenLengthLimit", "Lcom/stepos/aiengine/data/IntMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IReranking {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static float[] reranking(IReranking iReranking, String query, List<String> candidates, int i10, double d10, Bundle bundle) {
            p.i(query, "query");
            p.i(candidates, "candidates");
            return iReranking.reranking(query, candidates, i10, d10);
        }
    }

    IntMatrix calculateTokenLengthLimit(String query, List<String> candidates);

    boolean cancel(long identity);

    int getMaxTokenLimit();

    float[] reranking(String query, List<String> candidates, int maxResults, double minScore);

    float[] reranking(String query, List<String> candidates, int maxResults, double minScore, Bundle args);
}

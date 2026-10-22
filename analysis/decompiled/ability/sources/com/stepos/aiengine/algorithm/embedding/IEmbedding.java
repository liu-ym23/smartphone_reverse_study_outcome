package com.stepos.aiengine.algorithm.embedding;

import com.stepos.aiengine.data.FloatMatrix;
import com.stepos.aiengine.data.IntMatrix;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH&¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/algorithm/embedding/IEmbedding;", "", "cancel", "", "identity", "", "embed", "", "text", "", "embedAll", "Lcom/stepos/aiengine/data/FloatMatrix;", "texts", "", "getMaxTokenLimit", "", "calculateTokenLength", "calculateTokenLengthLimit", "Lcom/stepos/aiengine/data/IntMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IEmbedding {
    int calculateTokenLength(String text);

    IntMatrix calculateTokenLengthLimit(List<String> texts);

    boolean cancel(long identity);

    float[] embed(String text);

    FloatMatrix embedAll(List<String> texts);

    int getMaxTokenLimit();
}

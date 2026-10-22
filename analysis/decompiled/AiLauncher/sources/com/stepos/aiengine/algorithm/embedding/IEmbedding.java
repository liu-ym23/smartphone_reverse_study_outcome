package com.stepos.aiengine.algorithm.embedding;

import android.os.Bundle;
import com.stepos.aiengine.data.FloatMatrix;
import com.stepos.aiengine.data.IntMatrix;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH&J\"\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH&¨\u0006\u0015"}, d2 = {"Lcom/stepos/aiengine/algorithm/embedding/IEmbedding;", "", "cancel", "", e.f30860s, "", "embed", "", "text", "", "args", "Landroid/os/Bundle;", "embedAll", "Lcom/stepos/aiengine/data/FloatMatrix;", "texts", "", "getMaxTokenLimit", "", "calculateTokenLength", "calculateTokenLengthLimit", "Lcom/stepos/aiengine/data/IntMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IEmbedding {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static float[] embed(IEmbedding iEmbedding, String text, Bundle bundle) {
            p.i(text, "text");
            return iEmbedding.embed(text);
        }

        public static FloatMatrix embedAll(IEmbedding iEmbedding, List<String> texts, Bundle bundle) {
            p.i(texts, "texts");
            return iEmbedding.embedAll(texts);
        }
    }

    int calculateTokenLength(String text);

    IntMatrix calculateTokenLengthLimit(List<String> texts);

    boolean cancel(long identity);

    float[] embed(String text);

    float[] embed(String text, Bundle args);

    FloatMatrix embedAll(List<String> texts);

    FloatMatrix embedAll(List<String> texts, Bundle args);

    int getMaxTokenLimit();
}

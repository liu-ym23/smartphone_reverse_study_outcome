package com.stepos.aiengine.adapter;

import D7.v;
import D7.w;
import H4.o;
import Q4.f;
import Q4.g;
import Q4.h;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.embedding.IEmbedding;
import com.stepos.aiengine.data.FloatMatrix;
import com.stepos.aiengine.data.IntMatrix;
import com.stepos.core.c;
import com.stepos.core.data.TextContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/aiengine/adapter/EmbeddingAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/embedding/IEmbedding;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "", "identity", "", "cancel", "(J)Z", "", "text", "", "embed", "(Ljava/lang/String;)[F", "", "texts", "Lcom/stepos/aiengine/data/FloatMatrix;", "embedAll", "(Ljava/util/List;)Lcom/stepos/aiengine/data/FloatMatrix;", "", "getMaxTokenLimit", "()I", "calculateTokenLength", "(Ljava/lang/String;)I", "Lcom/stepos/aiengine/data/IntMatrix;", "calculateTokenLengthLimit", "(Ljava/util/List;)Lcom/stepos/aiengine/data/IntMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmbeddingAbilityAdapter implements IEmbedding {

    /* renamed from: a, reason: collision with root package name */
    public final c f3459a;

    public EmbeddingAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3459a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public int calculateTokenLength(String text) {
        k.f(text, "text");
        return text.length() / 4;
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public IntMatrix calculateTokenLengthLimit(List<String> texts) {
        k.f(texts, "texts");
        if (texts.isEmpty()) {
            return IntMatrix.INSTANCE.empty();
        }
        int maxTokenLimit = getMaxTokenLimit();
        int size = texts.size();
        int[][] iArr = new int[size][];
        for (int i = 0; i < size; i++) {
            int iCalculateTokenLength = calculateTokenLength(texts.get(i));
            iArr[i] = new int[]{i, iCalculateTokenLength, iCalculateTokenLength > maxTokenLimit ? 1 : 0};
        }
        return new IntMatrix(iArr);
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public boolean cancel(long identity) {
        return this.f3459a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public float[] embed(String text) throws Exception {
        k.f(text, "text");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.h(this.f3459a, new TextContent(text), new f(ref$ObjectRef, countDownLatch, 1), new g(ref$ObjectRef2, countDownLatch, 1), new h(countDownLatch, 1));
        countDownLatch.await(30L, TimeUnit.SECONDS);
        Exception exc = (Exception) ref$ObjectRef2.f4920a;
        if (exc == null) {
            return (float[]) ref$ObjectRef.f4920a;
        }
        throw exc;
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public FloatMatrix embedAll(List<String> texts) throws Exception {
        k.f(texts, "texts");
        if (texts.isEmpty()) {
            return FloatMatrix.INSTANCE.empty();
        }
        List<String> list = texts;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            float[] fArrEmbed = embed((String) it.next());
            if (fArrEmbed == null) {
                return null;
            }
            arrayList.add(fArrEmbed);
        }
        FloatMatrix floatMatrix = new FloatMatrix(arrayList.size(), ((float[]) v.A0(arrayList)).length, null, 4, null);
        int i = 0;
        for (Object obj : arrayList) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            float[] fArr = (float[]) obj;
            int length = fArr.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                floatMatrix.set(i, i11, fArr[i10]);
                i10++;
                i11++;
            }
            i = i6;
        }
        return floatMatrix;
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public int getMaxTokenLimit() {
        return 512;
    }
}

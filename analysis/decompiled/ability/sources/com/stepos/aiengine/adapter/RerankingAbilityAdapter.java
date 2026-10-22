package com.stepos.aiengine.adapter;

import Ca.C0203b;
import H4.o;
import Q4.f;
import Q4.h;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.reranking.IReranking;
import com.stepos.aiengine.data.IntMatrix;
import com.stepos.core.c;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import d5.g;
import d5.i;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/adapter/RerankingAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/reranking/IReranking;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "", "identity", "", "cancel", "(J)Z", "", "getMaxTokenLimit", "()I", "", "query", "", "candidates", "maxResults", "", "minScore", "", "reranking", "(Ljava/lang/String;Ljava/util/List;ID)[F", "Lcom/stepos/aiengine/data/IntMatrix;", "calculateTokenLengthLimit", "(Ljava/lang/String;Ljava/util/List;)Lcom/stepos/aiengine/data/IntMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RerankingAbilityAdapter implements IReranking {

    /* renamed from: a, reason: collision with root package name */
    public final c f3473a;

    public RerankingAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3473a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public IntMatrix calculateTokenLengthLimit(String query, List<String> candidates) {
        k.f(query, "query");
        k.f(candidates, "candidates");
        if (candidates.isEmpty()) {
            return IntMatrix.INSTANCE.empty();
        }
        ListBuilder listBuilderY = o.y();
        listBuilderY.add(new TextContent(query));
        Iterator<T> it = candidates.iterator();
        while (it.hasNext()) {
            listBuilderY.add(new TextContent((String) it.next()));
        }
        Content contentC = this.f3473a.c("calculateTokenLength", new MixedContent(o.q(listBuilderY)));
        if (contentC != null) {
            PrimitiveContent primitiveContent = contentC instanceof PrimitiveContent ? (PrimitiveContent) contentC : null;
            Object value = primitiveContent != null ? primitiveContent.getValue() : null;
            int[] iArr = value instanceof int[] ? (int[]) value : null;
            if (iArr != null) {
                int length = iArr.length / 3;
                if (length == 0) {
                    return IntMatrix.INSTANCE.empty();
                }
                int[][] iArr2 = new int[length][];
                for (int i = 0; i < length; i++) {
                    int i6 = i * 3;
                    iArr2[i] = new int[]{iArr[i6], iArr[i6 + 1], iArr[i6 + 2]};
                }
                return new IntMatrix(iArr2);
            }
        }
        return null;
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public boolean cancel(long identity) {
        return this.f3473a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public int getMaxTokenLimit() {
        return 512;
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public float[] reranking(String query, List<String> candidates, int maxResults, double minScore) throws InterruptedException {
        k.f(query, "query");
        k.f(candidates, "candidates");
        if (candidates.isEmpty()) {
            return new float[0];
        }
        ListBuilder listBuilderY = o.y();
        listBuilderY.add(new TextContent(query));
        Iterator<T> it = candidates.iterator();
        while (it.hasNext()) {
            listBuilderY.add(new TextContent((String) it.next()));
        }
        MixedContent mixedContent = new MixedContent(o.q(listBuilderY));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("maxResults", new i(maxResults));
        linkedHashMap.put("minScore", new g((float) minScore));
        mixedContent.setParams(new ContentParams(a.Y(linkedHashMap), null));
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.h(this.f3473a, mixedContent, new f(ref$ObjectRef, countDownLatch, 4), new C0203b(countDownLatch, 1), new h(countDownLatch, 7));
        countDownLatch.await(30L, TimeUnit.SECONDS);
        return (float[]) ref$ObjectRef.f4920a;
    }
}

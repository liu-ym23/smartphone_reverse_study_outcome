package com.stepos.aiengine.adapter;

import Y8.t;
import Z8.C1172u;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.RerankingAbilityAdapter;
import com.stepos.aiengine.algorithm.reranking.IReranking;
import com.stepos.aiengine.data.IntMatrix;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0016\u0010\u001aJ'\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/aiengine/adapter/RerankingAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/reranking/IReranking;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "", e.f30860s, "", "cancel", "(J)Z", "", "getMaxTokenLimit", "()I", "", "query", "", "candidates", "maxResults", "", "minScore", "", "reranking", "(Ljava/lang/String;Ljava/util/List;ID)[F", "Landroid/os/Bundle;", "args", "(Ljava/lang/String;Ljava/util/List;IDLandroid/os/Bundle;)[F", "Lcom/stepos/aiengine/data/IntMatrix;", "calculateTokenLengthLimit", "(Ljava/lang/String;Ljava/util/List;)Lcom/stepos/aiengine/data/IntMatrix;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RerankingAbilityAdapter implements IReranking {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public RerankingAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
    public static final t d(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, PrimitiveContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        ref$ObjectRef.f34820a = r10.getValue();
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t e(CountDownLatch countDownLatch, String str, int i10, String str2) {
        p.i(str, "<unused var>");
        p.i(str2, "<unused var>");
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t f(CountDownLatch countDownLatch, String str) {
        p.i(str, "<unused var>");
        countDownLatch.countDown();
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public IntMatrix calculateTokenLengthLimit(String query, List<String> candidates) {
        p.i(query, "query");
        p.i(candidates, "candidates");
        if (candidates.isEmpty()) {
            return IntMatrix.INSTANCE.empty();
        }
        List listC = C1172u.c();
        listC.add(new TextContent(query));
        Iterator<T> it = candidates.iterator();
        while (it.hasNext()) {
            listC.add(new TextContent((String) it.next()));
        }
        Content contentExecute = this.handle.execute("calculateTokenLength", new MixedContent((List<? extends Content>) C1172u.a(listC)));
        if (contentExecute == null) {
            return null;
        }
        PrimitiveContent primitiveContent = contentExecute instanceof PrimitiveContent ? (PrimitiveContent) contentExecute : null;
        Object value = primitiveContent != null ? primitiveContent.getValue() : null;
        int[] iArr = value instanceof int[] ? (int[]) value : null;
        if (iArr == null) {
            return null;
        }
        int length = iArr.length / 3;
        if (length == 0) {
            return IntMatrix.INSTANCE.empty();
        }
        int[][] iArr2 = new int[length][];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 3;
            iArr2[i10] = new int[]{iArr[i11], iArr[i11 + 1], iArr[i11 + 2]};
        }
        return new IntMatrix(iArr2);
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public int getMaxTokenLimit() {
        return 512;
    }

    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public float[] reranking(String query, List<String> candidates, int maxResults, double minScore) {
        p.i(query, "query");
        p.i(candidates, "candidates");
        return reranking(query, candidates, maxResults, minScore, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.aiengine.algorithm.reranking.IReranking
    public float[] reranking(String query, List<String> candidates, int maxResults, double minScore, Bundle args) throws InterruptedException {
        p.i(query, "query");
        p.i(candidates, "candidates");
        if (candidates.isEmpty()) {
            return new float[0];
        }
        List listC = C1172u.c();
        listC.add(new TextContent(query));
        Iterator<T> it = candidates.iterator();
        while (it.hasNext()) {
            listC.add(new TextContent((String) it.next()));
        }
        MixedContent mixedContent = new MixedContent((List<? extends Content>) C1172u.a(listC));
        ContentParams.Builder builderPutFloat = new ContentParams.Builder().putInt("maxResults", maxResults).putFloat("minScore", (float) minScore);
        TaskPriorityArg.INSTANCE.applyTo(builderPutFloat, args);
        mixedContent.setParams(builderPutFloat.build());
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbilityHandle.infer$default(this.handle, mixedContent, new p9.p() { // from class: O4.h0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return RerankingAbilityAdapter.d(ref$ObjectRef, countDownLatch, (String) obj, (PrimitiveContent) obj2);
            }
        }, new q() { // from class: O4.i0
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RerankingAbilityAdapter.e(countDownLatch, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.j0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RerankingAbilityAdapter.f(countDownLatch, (String) obj);
            }
        }, null, null, 48, null);
        countDownLatch.await(30L, TimeUnit.SECONDS);
        return (float[]) ref$ObjectRef.f34820a;
    }
}

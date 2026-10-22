package com.stepos.aiengine.adapter;

import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.EmbeddingAbilityAdapter;
import com.stepos.aiengine.algorithm.embedding.IEmbedding;
import com.stepos.aiengine.data.FloatMatrix;
import com.stepos.aiengine.data.IntMatrix;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.TextContent;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u000e\u0010\u0012J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/aiengine/adapter/EmbeddingAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/embedding/IEmbedding;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "", e.f30860s, "", "cancel", "(J)Z", "", "text", "", "embed", "(Ljava/lang/String;)[F", "Landroid/os/Bundle;", "args", "(Ljava/lang/String;Landroid/os/Bundle;)[F", "", "texts", "Lcom/stepos/aiengine/data/FloatMatrix;", "embedAll", "(Ljava/util/List;)Lcom/stepos/aiengine/data/FloatMatrix;", "(Ljava/util/List;Landroid/os/Bundle;)Lcom/stepos/aiengine/data/FloatMatrix;", "", "getMaxTokenLimit", "()I", "calculateTokenLength", "(Ljava/lang/String;)I", "Lcom/stepos/aiengine/data/IntMatrix;", "calculateTokenLengthLimit", "(Ljava/util/List;)Lcom/stepos/aiengine/data/IntMatrix;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EmbeddingAbilityAdapter implements IEmbedding {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public EmbeddingAbilityAdapter(AbilityHandle handle) {
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

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.RuntimeException] */
    public static final t e(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        ref$ObjectRef.f34820a = new RuntimeException("[" + i10 + "] " + msg);
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t f(CountDownLatch countDownLatch, String str) {
        p.i(str, "<unused var>");
        countDownLatch.countDown();
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public int calculateTokenLength(String text) {
        p.i(text, "text");
        return text.length() / 4;
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public IntMatrix calculateTokenLengthLimit(List<String> texts) {
        p.i(texts, "texts");
        if (texts.isEmpty()) {
            return IntMatrix.INSTANCE.empty();
        }
        int maxTokenLimit = getMaxTokenLimit();
        int size = texts.size();
        int[][] iArr = new int[size][];
        for (int i10 = 0; i10 < size; i10++) {
            int iCalculateTokenLength = calculateTokenLength(texts.get(i10));
            iArr[i10] = new int[]{i10, iCalculateTokenLength, iCalculateTokenLength > maxTokenLimit ? 1 : 0};
        }
        return new IntMatrix(iArr);
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public float[] embed(String text) {
        p.i(text, "text");
        return embed(text, null);
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public FloatMatrix embedAll(List<String> texts) {
        p.i(texts, "texts");
        return embedAll(texts, null);
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public int getMaxTokenLimit() {
        return 512;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public float[] embed(String text, Bundle args) throws Exception {
        p.i(text, "text");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        TextContent textContent = new TextContent(text);
        ContentParams.Builder builder = new ContentParams.Builder();
        if (TaskPriorityArg.INSTANCE.applyTo(builder, args)) {
            textContent.setParams(builder.build());
        }
        AbilityHandle.infer$default(this.handle, textContent, new p9.p() { // from class: O4.w
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return EmbeddingAbilityAdapter.d(ref$ObjectRef, countDownLatch, (String) obj, (PrimitiveContent) obj2);
            }
        }, new q() { // from class: O4.x
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return EmbeddingAbilityAdapter.e(ref$ObjectRef2, countDownLatch, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EmbeddingAbilityAdapter.f(countDownLatch, (String) obj);
            }
        }, null, null, 48, null);
        countDownLatch.await(30L, TimeUnit.SECONDS);
        Exception exc = (Exception) ref$ObjectRef2.f34820a;
        if (exc == null) {
            return (float[]) ref$ObjectRef.f34820a;
        }
        throw exc;
    }

    @Override // com.stepos.aiengine.algorithm.embedding.IEmbedding
    public FloatMatrix embedAll(List<String> texts, Bundle args) throws Exception {
        p.i(texts, "texts");
        if (texts.isEmpty()) {
            return FloatMatrix.INSTANCE.empty();
        }
        List<String> list = texts;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            float[] fArrEmbed = embed((String) it.next(), args);
            if (fArrEmbed == null) {
                return null;
            }
            arrayList.add(fArrEmbed);
        }
        FloatMatrix floatMatrix = new FloatMatrix(arrayList.size(), ((float[]) F.q0(arrayList)).length, null, 4, null);
        int i10 = 0;
        for (Object obj : arrayList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            float[] fArr = (float[]) obj;
            int length = fArr.length;
            int i12 = 0;
            int i13 = 0;
            while (i12 < length) {
                floatMatrix.set(i10, i13, fArr[i12]);
                i12++;
                i13++;
            }
            i10 = i11;
        }
        return floatMatrix;
    }
}

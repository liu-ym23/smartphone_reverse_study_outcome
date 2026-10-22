package com.stepos.datacenter.api;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.HybridSearchHit;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/datacenter/api/VectorOps;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/datacenter/vector/HybridSearchRequest;", "request", "", "Lcom/stepos/datacenter/vector/HybridSearchHit;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/datacenter/vector/HybridSearchRequest;Le9/c;)Ljava/lang/Object;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VectorOps {

    /* renamed from: a, reason: collision with root package name */
    public static final VectorOps f29937a = new VectorOps();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((Integer) ((Pair) t10).f(), (Integer) ((Pair) t11).f());
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Float.valueOf(((HybridSearchHit) t11).getCombinedScore()), Float.valueOf(((HybridSearchHit) t10).getCombinedScore()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(android.content.Context r24, com.stepos.datacenter.vector.HybridSearchRequest r25, e9.InterfaceC4014c<? super java.util.List<com.stepos.datacenter.vector.HybridSearchHit>> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.VectorOps.a(android.content.Context, com.stepos.datacenter.vector.HybridSearchRequest, e9.c):java.lang.Object");
    }
}

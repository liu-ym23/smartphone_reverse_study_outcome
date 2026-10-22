package com.bytedance.android.shopping.store.home.preload.data;

import android.util.LruCache;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements com.bytedance.android.chunkstreamprediction.network.a<ECStoreHomeTabResponseTabkit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECStoreHomeTabResponseTabkit f183815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f183816b;

    @Override // com.bytedance.android.chunkstreamprediction.network.a
    public final void onComplete() {
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.a
    public final void onFailed(Throwable r100) {
    }

    public c(d r100) {
        this.f183816b = r100;
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.a
    public final void onNext(ECStoreHomeTabResponseTabkit r100) {
        ECStoreHomeTabResponseTabkit r101 = r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getStatusCode() != 0) goto L20;
        Integer r102 = r101.getChunkIndex();
        if (r102 != null) goto L10;
    L12:
        Integer r103 = r101.getChunkIndex();
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.intValue() != 1) goto L22;
        d r104 = this.f183816b;
        LruCache<String, Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b>> r105 = r104.f183817a.f183810c;
        String r106 = r104.f183818b;
        ECStoreHomeTabResponseTabkit r107 = this.f183815a;
        Intrinsics.checkNotNull(r107);
        r105.put(r106, new Triple(new ECStoreHomeTabResponseTabkit[]{r107, r101}, Long.valueOf(System.currentTimeMillis()), this.f183816b.f183819c));
        return;
    L22:
        return;
    L10:
        if (r102.intValue() != 0) goto L12;
        this.f183815a = r101;
        return;
    }
}

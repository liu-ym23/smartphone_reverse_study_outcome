package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import kotlin.Triple;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements com.bytedance.android.chunkstreamprediction.network.b.InterfaceC0776b<ECStoreHomeTabResponseTabkit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Triple f183811a;

    public a(Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b> r100) {
        this.f183811a = r100;
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.b.InterfaceC0776b
    public void call(com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit> r100, com.bytedance.android.chunkstreamprediction.network.a<ECStoreHomeTabResponseTabkit> r101) {
        if (r101 == null) goto L4;
        r101.onNext(((ECStoreHomeTabResponseTabkit[]) this.f183811a.getFirst())[0]);
    L4:
        if (r101 == null) goto L7;
        r101.onNext(((ECStoreHomeTabResponseTabkit[]) this.f183811a.getFirst())[1]);
        return;
    }
}

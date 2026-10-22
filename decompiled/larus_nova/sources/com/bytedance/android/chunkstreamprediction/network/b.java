package com.bytedance.android.chunkstreamprediction.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f42520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0776b<T> f42521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.chunkstreamprediction.network.a<T>> f42522c;

    public class a implements com.bytedance.android.chunkstreamprediction.network.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.chunkstreamprediction.network.a f42523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f42524b;

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onComplete() {
            Iterator r100 = ((ArrayList) this.f42524b.f42522c).iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((com.bytedance.android.chunkstreamprediction.network.a) r100.next()).onComplete();
            goto L4
        L6:
            this.f42523a.onComplete();
        }

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onFailed(Throwable r100) {
            HashMap r101 = new HashMap();
            this.f42524b.getClass();
            ChunkDataException r102 = new ChunkDataException(r100, r101);
            Iterator r103 = ((ArrayList) this.f42524b.f42522c).iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((com.bytedance.android.chunkstreamprediction.network.a) r103.next()).onFailed(r102);
            goto L4
        L6:
            this.f42523a.onFailed(r102);
        }

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onNext(T r100) {
            Iterator r101 = ((ArrayList) this.f42524b.f42522c).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((com.bytedance.android.chunkstreamprediction.network.a) r101.next()).onNext(r100);
            goto L4
        L6:
            this.f42523a.onNext(r100);
        }

        public a(b r100, com.bytedance.android.chunkstreamprediction.network.a r101) {
            this.f42524b = r100;
            this.f42523a = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.chunkstreamprediction.network.b$b, reason: collision with other inner class name */
    public interface InterfaceC0776b<T> {
        void call(b<T> r100, com.bytedance.android.chunkstreamprediction.network.a<T> r101);
    }

    public b(InterfaceC0776b<T> r100) {
        this.f42520a = new j();
        this.f42522c = new ArrayList();
        this.f42521b = r100;
    }

    public final void a(com.bytedance.android.chunkstreamprediction.network.a<T> r100) {
        if (this.f42521b == null) goto L5;
        this.f42520a.getClass();
        this.f42521b.call(this, new a(this, r100));
    L5:
        this.f42521b = null;
    }
}

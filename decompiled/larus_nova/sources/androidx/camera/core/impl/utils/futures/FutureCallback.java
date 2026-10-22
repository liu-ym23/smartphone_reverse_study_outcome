package androidx.camera.core.impl.utils.futures;

/* JADX INFO: loaded from: classes2.dex */
public interface FutureCallback<V> {
    void onFailure(Throwable r100);

    void onSuccess(V r100);
}

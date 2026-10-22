package androidx.camera.core.processing;

import androidx.core.util.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class Edge<T> implements Consumer<T> {
    private Consumer<T> mListener;

    public Edge() {
    }

    @Override // androidx.core.util.Consumer
    public void accept(T r100) {
        Intrinsics.checkNotNull(this.mListener, "Listener is not set.");
        this.mListener.accept(r100);
    }

    public void setListener(Consumer<T> r100) {
        this.mListener = r100;
    }
}

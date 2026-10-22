package androidx.camera.core.processing;

/* JADX INFO: loaded from: classes2.dex */
public interface Node<I, O> {
    void release();

    O transform(I r100);
}

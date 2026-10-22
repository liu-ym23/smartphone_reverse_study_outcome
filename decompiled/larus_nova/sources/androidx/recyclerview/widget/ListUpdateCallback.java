package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes17.dex */
public interface ListUpdateCallback {
    void onChanged(int r100, int r101, Object r102);

    void onInserted(int r100, int r101);

    void onMoved(int r100, int r101);

    void onRemoved(int r100, int r101);
}

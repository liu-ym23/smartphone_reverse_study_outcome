package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i5, int i6, Object obj);

    void onInserted(int i5, int i6);

    void onMoved(int i5, int i6);

    void onRemoved(int i5, int i6);
}

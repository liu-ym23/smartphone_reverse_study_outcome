package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int r10, int r11, @Nullable Object r12);

    void onInserted(int r10, int r11);

    void onMoved(int r10, int r11);

    void onRemoved(int r10, int r11);
}

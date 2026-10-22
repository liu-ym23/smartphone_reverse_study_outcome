package androidx.recyclerview.widget;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int r10, int r11);

        @SuppressLint({"UnknownNullness"})
        void recycleTile(o r10);

        void refresh(int r10);

        void updateRange(int r10, int r11, int r12, int r13, int r14);
    }

    public interface MainThreadCallback<T> {
        @SuppressLint({"UnknownNullness"})
        void addTile(int r10, o r11);

        void removeTile(int r10, int r11);

        void updateItemCount(int r10, int r11);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> r10);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> r10);
}

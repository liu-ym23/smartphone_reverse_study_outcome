package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes17.dex */
interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int r100, int r101);

        void recycleTile(TileList.Tile<T> r100);

        void refresh(int r100);

        void updateRange(int r100, int r101, int r102, int r103, int r104);
    }

    public interface MainThreadCallback<T> {
        void addTile(int r100, TileList.Tile<T> r101);

        void removeTile(int r100, int r101);

        void updateItemCount(int r100, int r101);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> r100);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> r100);
}

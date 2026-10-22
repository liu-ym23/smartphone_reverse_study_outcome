package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes17.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        Loader<D> onCreateLoader(int r100, Bundle r101);

        void onLoadFinished(Loader<D> r100, D r101);

        void onLoaderReset(Loader<D> r100);
    }

    public abstract void destroyLoader(int r100);

    public abstract void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103);

    public abstract <D> Loader<D> getLoader(int r100);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract <D> Loader<D> initLoader(int r100, Bundle r101, LoaderCallbacks<D> r102);

    public abstract void markForRedelivery();

    public abstract <D> Loader<D> restartLoader(int r100, Bundle r101, LoaderCallbacks<D> r102);

    public LoaderManager() {
    }

    public static void enableDebugLogging(boolean r100) {
        LoaderManagerImpl.DEBUG = r100;
    }

    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(T r100) {
        return new LoaderManagerImpl(r100, r100.getViewModelStore());
    }
}

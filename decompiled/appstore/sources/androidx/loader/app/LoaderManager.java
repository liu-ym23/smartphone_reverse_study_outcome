package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        @NonNull
        @MainThread
        Loader onCreateLoader(int r10, @Nullable Bundle r11);

        @MainThread
        void onLoadFinished(@NonNull Loader r10, D r11);

        @MainThread
        void onLoaderReset(@NonNull Loader r10);
    }

    public LoaderManager() {
    }

    public static LoaderManager b(LifecycleOwner r10) {
        return new a(r10, ((ViewModelStoreOwner) r10).getViewModelStore());
    }

    public abstract void a(String r10, FileDescriptor r11, PrintWriter r12, String[] r13);

    public abstract void c();
}

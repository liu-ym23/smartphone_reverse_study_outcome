package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.content.Loader;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.Objects;
import tb2.c;

/* JADX INFO: loaded from: classes17.dex */
class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    private final LifecycleOwner mLifecycleOwner;
    private final LoaderViewModel mLoaderViewModel;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;
        private Loader<D> mPriorLoader;

        public void markForRedelivery() {
            LifecycleOwner r100 = this.mLifecycleOwner;
            LoaderObserver<D> r101 = this.mObserver;
            if (r100 == null) goto L7;
            if (r101 == null) goto L8;
            super.removeObserver(r101);
            observe(r100, r101);
            return;
        L8:
            return;
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            toString();
        L5:
            this.mLoader.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            toString();
        L5:
            this.mLoader.stopLoading();
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder(64);
            r100.append("LoaderInfo{");
            r100.append(Integer.toHexString(System.identityHashCode(this)));
            r100.append(" #");
            r100.append(this.mId);
            r100.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, r100);
            r100.append("}}");
            return r100.toString();
        }

        public boolean isCallbackWaitingForData() {
            if (hasActiveObservers() == true) goto L5;
            return false;
        L5:
            LoaderObserver<D> r100 = this.mObserver;
            if (r100 != null) goto L8;
            return false;
        L8:
            if (r100.hasDeliveredData() == true) goto L12;
            return true;
        L12:
            return false;
        }

        public Loader<D> getLoader() {
            return this.mLoader;
        }

        public Loader<D> destroy(boolean r100) {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            toString();
        L5:
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> r101 = this.mObserver;
            if (r101 == null) goto L10;
            removeObserver(r101);
            if (r100 == false) goto L10;
            r101.reset();
        L10:
            this.mLoader.unregisterListener(this);
            if (r101 != null) goto L13;
        L14:
            if (r100 == false) goto L18;
        L15:
            this.mLoader.reset();
            return this.mPriorLoader;
        L18:
            return this.mLoader;
        L13:
            if (r101.hasDeliveredData() == false) goto L15;
            goto L14
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(Observer<? super D> r100) {
            super.removeObserver(r100);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D r100) {
            super.setValue(r100);
            Loader<D> r101 = this.mPriorLoader;
            if (r101 == null) goto L6;
            r101.reset();
            this.mPriorLoader = null;
            return;
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(Loader<D> r100, D r101) {
            if (LoaderManagerImpl.DEBUG == false) goto L6;
            toString();
        L6:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
            setValue(r101);
            return;
        L8:
            postValue(r101);
        }

        public Loader<D> setCallback(LifecycleOwner r100, LoaderManager.LoaderCallbacks<D> r101) {
            LoaderObserver<D> r102 = new LoaderObserver(this.mLoader, r101);
            observe(r100, r102);
            LoaderObserver<D> r103 = this.mObserver;
            if (r103 == null) goto L5;
            removeObserver(r103);
        L5:
            this.mLifecycleOwner = r100;
            this.mObserver = r102;
            return this.mLoader;
        }

        public LoaderInfo(int r100, Bundle r101, Loader<D> r102, Loader<D> r103) {
            this.mId = r100;
            this.mArgs = r101;
            this.mLoader = r102;
            this.mPriorLoader = r103;
            r102.registerListener(r100, this);
        }

        public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
            r102.print(r100);
            r102.print("mId=");
            r102.print(this.mId);
            r102.print(" mArgs=");
            r102.println(this.mArgs);
            r102.print(r100);
            r102.print("mLoader=");
            r102.println(this.mLoader);
            this.mLoader.dump(r100 + c.DEFAULT_TEXT, r101, r102, r103);
            if (this.mObserver == null) goto L5;
            r102.print(r100);
            r102.print("mCallbacks=");
            r102.println(this.mObserver);
            this.mObserver.dump(r100 + c.DEFAULT_TEXT, r102);
        L5:
            r102.print(r100);
            r102.print("mData=");
            r102.println(getLoader().dataToString(getValue()));
            r102.print(r100);
            r102.print("mStarted=");
            r102.println(hasActiveObservers());
        }
    }

    public static class LoaderObserver<D> implements Observer<D> {
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData;
        private final Loader<D> mLoader;

        public void reset() {
            if (this.mDeliveredData == true) goto L5;
            return;
        L5:
            if (LoaderManagerImpl.DEBUG == false) goto L7;
            Objects.toString(this.mLoader);
        L7:
            this.mCallback.onLoaderReset(this.mLoader);
        }

        public String toString() {
            return this.mCallback.toString();
        }

        public boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(D r100) {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Objects.toString(this.mLoader);
            this.mLoader.dataToString(r100);
        L5:
            this.mCallback.onLoadFinished(this.mLoader, r100);
            this.mDeliveredData = true;
        }

        public LoaderObserver(Loader<D> r100, LoaderManager.LoaderCallbacks<D> r101) {
            this.mDeliveredData = false;
            this.mLoader = r100;
            this.mCallback = r101;
        }

        public void dump(String r100, PrintWriter r101) {
            r101.print(r100);
            r101.print("mDeliveredData=");
            r101.println(this.mDeliveredData);
        }
    }

    public static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory FACTORY = null;
        private boolean mCreatingLoader;
        private SparseArrayCompat<LoaderInfo> mLoaders;

        public void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        public void startCreatingLoader() {
            this.mCreatingLoader = true;
        }

        static {
            FACTORY = new AnonymousClass1();
        }

        public boolean hasRunningLoaders() {
            int r100 = this.mLoaders.size();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L9;
            if (this.mLoaders.valueAt(r101).isCallbackWaitingForData() == true) goto L6;
            r101 = r101 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        public void markForRedelivery() {
            int r100 = this.mLoaders.size();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L5;
            this.mLoaders.valueAt(r101).markForRedelivery();
            r101 = r101 + 1;
            goto L3
        }

        public LoaderViewModel() {
            this.mLoaders = new SparseArrayCompat();
            this.mCreatingLoader = false;
        }

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int r100 = this.mLoaders.size();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L5;
            this.mLoaders.valueAt(r101).destroy(true);
            r101 = r101 + 1;
            goto L3
        L5:
            this.mLoaders.clear();
        }

        public boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        public static LoaderViewModel getInstance(ViewModelStore r100) {
            return (LoaderViewModel) new ViewModelProvider(r100, FACTORY).get(LoaderViewModel.class);
        }

        public <D> LoaderInfo<D> getLoader(int r100) {
            return this.mLoaders.get(r100);
        }

        public void removeLoader(int r100) {
            this.mLoaders.remove(r100);
        }

        public void putLoader(int r100, LoaderInfo r101) {
            this.mLoaders.put(r100, r101);
        }

        public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
            if (this.mLoaders.size() <= 0) goto L8;
            r102.print(r100);
            r102.println("Loaders:");
            String r104 = r100 + LineContent.FOUR_SPACE;
            int r105 = 0;
        L6:
            if (r105 >= this.mLoaders.size()) goto L10;
            LoaderInfo r106 = this.mLoaders.valueAt(r105);
            r102.print(r100);
            r102.print("  #");
            r102.print(this.mLoaders.keyAt(r105));
            r102.print(": ");
            r102.println(r106.toString());
            r106.dump(r104, r101, r102, r103);
            r105 = r105 + 1;
            goto L6
        L10:
            return;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder(128);
        r100.append("LoaderManager{");
        r100.append(Integer.toHexString(System.identityHashCode(this)));
        r100.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, r100);
        r100.append("}}");
        return r100.toString();
    }

    @Override // androidx.loader.app.LoaderManager
    public void destroyLoader(int r100) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L16;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L14;
        if (DEBUG == false) goto L9;
        toString();
    L9:
        LoaderInfo r101 = this.mLoaderViewModel.getLoader(r100);
        if (r101 == null) goto L17;
        r101.destroy(true);
        this.mLoaderViewModel.removeLoader(r100);
        return;
    L17:
        return;
    L14:
        throw new IllegalStateException("destroyLoader must be called on the main thread");
    L16:
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> getLoader(int r100) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L10;
        LoaderInfo<D> r101 = this.mLoaderViewModel.getLoader(r100);
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.getLoader();
    L10:
        throw new IllegalStateException("Called while creating a loader");
    }

    public LoaderManagerImpl(LifecycleOwner r100, ViewModelStore r101) {
        this.mLifecycleOwner = r100;
        this.mLoaderViewModel = LoaderViewModel.getInstance(r101);
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> initLoader(int r100, Bundle r101, LoaderManager.LoaderCallbacks<D> r102) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L20;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L18;
        LoaderInfo<D> r103 = this.mLoaderViewModel.getLoader(r100);
        if (DEBUG == false) goto L9;
        toString();
        Objects.toString(r101);
    L9:
        if (r103 != null) goto L13;
        return createAndInstallLoader(r100, r101, r102, null);
    L13:
        if (DEBUG == false) goto L16;
        r103.toString();
    L16:
        return r103.setCallback(this.mLifecycleOwner, r102);
    L18:
        throw new IllegalStateException("initLoader must be called on the main thread");
    L20:
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> restartLoader(int r100, Bundle r101, LoaderManager.LoaderCallbacks<D> r102) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L18;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L16;
        if (DEBUG == false) goto L9;
        toString();
        Objects.toString(r101);
    L9:
        LoaderInfo<D> r103 = this.mLoaderViewModel.getLoader(r100);
        if (r103 == null) goto L12;
        Loader<D> r104 = r103.destroy(false);
    L14:
        return createAndInstallLoader(r100, r101, r102, r104);
    L12:
        r104 = null;
        goto L14
    L16:
        throw new IllegalStateException("restartLoader must be called on the main thread");
    L18:
        throw new IllegalStateException("Called while creating a loader");
    }

    private <D> Loader<D> createAndInstallLoader(int r100, Bundle r101, LoaderManager.LoaderCallbacks<D> r102, Loader<D> r103) {
        this.mLoaderViewModel.startCreatingLoader();     // Catch: Throwable -> L20
        Loader<D> r104 = r102.onCreateLoader(r100, r101);     // Catch: Throwable -> L20
        if (r104 == null) goto L19;
        if (r104.getClass().isMemberClass() == true) goto L8;
    L12:
        LoaderInfo r105 = new LoaderInfo(r100, r101, r104, r103);     // Catch: Throwable -> L20
        if (DEBUG == false) goto L15;
        r105.toString();     // Catch: Throwable -> L20
    L15:
        this.mLoaderViewModel.putLoader(r100, r105);     // Catch: Throwable -> L20
        this.mLoaderViewModel.finishCreatingLoader();
        return r105.setCallback(this.mLifecycleOwner, r102);
    L8:
        if (Modifier.isStatic(r104.getClass().getModifiers()) == true) goto L12;
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + r104);     // Catch: Throwable -> L20
    L19:
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        this.mLoaderViewModel.finishCreatingLoader();
        throw th;
    }

    @Override // androidx.loader.app.LoaderManager
    public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        this.mLoaderViewModel.dump(r100, r101, r102, r103);
    }
}

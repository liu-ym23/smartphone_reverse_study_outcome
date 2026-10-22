package com.bumptech.glide.load.model.stream;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import f06.b;
import f06.c;
import f06.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {
    private final Context context;
    private final Class<DataT> dataClass;
    private final ModelLoader<File, DataT> fileDelegate;
    private final ModelLoader<Uri, DataT> uriDelegate;

    public static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {
        private final Context context;
        private final Class<DataT> dataClass;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, DataT> build(MultiModelLoaderFactory r100) {
            return new QMediaStoreUriLoader(this.context, r100.build(File.class, this.dataClass), r100.build(Uri.class, this.dataClass), this.dataClass);
        }

        public Factory(Context r100, Class<DataT> r101) {
            this.context = r100;
            this.dataClass = r101;
        }
    }

    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context r100) {
            super(r100, ParcelFileDescriptor.class);
        }
    }

    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context r100) {
            super(r100, InputStream.class);
        }
    }

    public static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {
        private static final String[] PROJECTION = null;
        private final Context context;
        private final Class<DataT> dataClass;
        private volatile DataFetcher<DataT> delegate;
        private final ModelLoader<File, DataT> fileDelegate;
        private final int height;
        private volatile boolean isCancelled;
        private final Options options;
        private final Uri uri;
        private final ModelLoader<Uri, DataT> uriDelegate;
        private final int width;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            DataFetcher<DataT> r100 = this.delegate;
            if (r100 == null) goto L6;
            r100.cancel();
            return;
        }

        static {
            PROJECTION = new String[]{"_data"};
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataFetcher<DataT> r100 = this.delegate;
            if (r100 == null) goto L6;
            r100.cleanup();
            return;
        }

        private ModelLoader.LoadData<DataT> buildDelegateData() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy() == true) goto L5;
            Uri r100 = this.uri;
            return this.uriDelegate.buildLoadData(r100, this.width, this.height, this.options);
        L5:
            return this.fileDelegate.buildLoadData(queryForFilePath(this.uri), this.width, this.height, this.options);
        }

        private DataFetcher<DataT> buildDelegateFetcher() throws FileNotFoundException {
            ModelLoader.LoadData<DataT> r100 = buildDelegateData();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.fetcher;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<DataT> getDataClass() {
            return this.dataClass;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        private File queryForFilePath(Uri r110) throws FileNotFoundException {
            Cursor r100 = null;
            Cursor r101 = com_bumptech_glide_load_model_stream_QMediaStoreUriLoader$QMediaStoreUriFetcher_android_content_ContentResolver_query(this.context.getContentResolver(), r110, PROJECTION, null, null, null);     // Catch: Throwable -> L16
            if (r101 == null) goto L15;
            if (r101.moveToFirst() == false) goto L15;
            String r102 = r101.getString(r101.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L16
            if (TextUtils.isEmpty(r102) == true) goto L13;
            PolarisFileWrapper r111 = new PolarisFileWrapper(r102);     // Catch: Throwable -> L16
            r101.close();
            return r111;
        L13:
            throw new FileNotFoundException("File path was empty in media store for: " + r110);     // Catch: Throwable -> L16
        L15:
            throw new FileNotFoundException("Failed to media store entry for: " + r110);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            if (0 == 0) goto L19;
            r100.close();
        L19:
            throw th;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r100, DataFetcher.DataCallback<? super DataT> r101) {
            DataFetcher<DataT> r102 = buildDelegateFetcher();     // Catch: FileNotFoundException -> L12
            if (r102 != null) goto L7;
            r101.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.uri));     // Catch: FileNotFoundException -> L12
            return;
        L7:
            this.delegate = r102;     // Catch: FileNotFoundException -> L12
            if (this.isCancelled == false) goto L10;
            cancel();     // Catch: FileNotFoundException -> L12
            return;
        L10:
            r102.loadData(r100, r101);     // Catch: FileNotFoundException -> L12
            return;
        L12:
            e = move-exception;
            r101.onLoadFailed(e);
        }

        private static Cursor com_bumptech_glide_load_model_stream_QMediaStoreUriLoader$QMediaStoreUriFetcher_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) throws FileNotFoundException {
            c r100 = new c();
            Object[] r101 = {r111, r112, r113, r114, r115};
            b r116 = new b();
            d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
            if (r117.f474982a == false) goto L6;
            r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
            return (Cursor) r117.f474983b;
        L6:
            Cursor r118 = r110.query(r111, r112, r113, r114, r115);
            r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
            return r118;
        }

        public QMediaStoreUriFetcher(Context r100, ModelLoader<File, DataT> r101, ModelLoader<Uri, DataT> r102, Uri r103, int r104, int r105, Options r106, Class<DataT> r107) {
            this.context = r100.getApplicationContext();
            this.fileDelegate = r101;
            this.uriDelegate = r102;
            this.uri = r103;
            this.width = r104;
            this.height = r105;
            this.options = r106;
            this.dataClass = r107;
        }
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
    L7:
        return false;
    L5:
        if (MediaStoreUtil.isMediaStoreUri(r100) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Uri r100) {
        return handles2(r100);
    }

    public QMediaStoreUriLoader(Context r100, ModelLoader<File, DataT> r101, ModelLoader<Uri, DataT> r102, Class<DataT> r103) {
        this.context = r100.getApplicationContext();
        this.fileDelegate = r101;
        this.uriDelegate = r102;
        this.dataClass = r103;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<DataT> buildLoadData2(Uri r110, int r111, int r112, Options r113) {
        return new ModelLoader.LoadData(new ObjectKey(r110), new QMediaStoreUriFetcher(this.context, this.fileDelegate, this.uriDelegate, r110, r111, r112, r113, this.dataClass));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(Uri r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}

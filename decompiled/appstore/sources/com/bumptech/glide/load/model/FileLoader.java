package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {
    private static final String TAG = "FileLoader";
    private final FileOpener<Data> fileOpener;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {
        private final FileOpener<Data> opener;

        public Factory(FileOpener<Data> r10) {
            this.opener = r10;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public final ModelLoader<File, Data> build(@NonNull MultiModelLoaderFactory r10) {
            return new FileLoader(this.opener);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory() {
            super(new AnonymousClass1());
        }
    }

    public static final class FileFetcher<Data> implements DataFetcher<Data> {
        private Data data;
        private final File file;
        private final FileOpener<Data> opener;

        public FileFetcher(File r10, FileOpener<Data> r11) {
            this.file = r10;
            this.opener = r11;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Data r10 = this.data;
            if (r10 == null) goto L9;
            this.opener.close(r10);     // Catch: IOException -> L6
            return;
        L10:
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> getDataClass() {
            return this.opener.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority r10, @NonNull DataFetcher.DataCallback<? super Data> r11) {
            Data r12 = this.opener.open(this.file);     // Catch: FileNotFoundException -> L5
            this.data = r12;     // Catch: FileNotFoundException -> L5
            r11.onDataReady(r12);
            return;
        L5:
            e = move-exception;
            if (Log.isLoggable(FileLoader.TAG, 3) == false) goto L9;
            Log.d(FileLoader.TAG, "Failed to open file", e);
        L9:
            r11.onLoadFailed(e);
        }
    }

    public interface FileOpener<Data> {
        void close(Data r10) throws IOException;

        Class<Data> getDataClass();

        Data open(File r10) throws FileNotFoundException;
    }

    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new AnonymousClass1());
        }
    }

    public FileLoader(FileOpener<Data> r10) {
        this.fileOpener = r10;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(@NonNull File r10, int r11, int r12, @NonNull Options r13) {
        return buildLoadData2(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull File r10) {
        return true;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<Data> buildLoadData2(@NonNull File r10, int r11, int r12, @NonNull Options r13) {
        return new ModelLoader.LoadData(new ObjectKey(r10), new FileFetcher(r10, this.fileOpener));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(@NonNull File r10) {
        return handles2(r10);
    }
}

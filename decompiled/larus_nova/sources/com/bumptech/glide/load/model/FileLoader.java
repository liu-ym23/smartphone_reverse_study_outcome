package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.GlideLogUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {
    private static final String TAG = "FileLoader";
    private final FileOpener<Data> fileOpener;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {
        private final FileOpener<Data> opener;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        public Factory(FileOpener<Data> r100) {
            this.opener = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<File, Data> build(MultiModelLoaderFactory r100) {
            return new FileLoader(this.opener);
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

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Data r100 = this.data;
            if (r100 == null) goto L9;
            this.opener.close(r100);     // Catch: IOException -> L6
            return;
        L10:
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> getDataClass() {
            return this.opener.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public FileFetcher(File r100, FileOpener<Data> r101) {
            this.file = r100;
            this.opener = r101;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r100, DataFetcher.DataCallback<? super Data> r101) {
            Data r102 = this.opener.open(this.file);     // Catch: FileNotFoundException -> L5
            this.data = r102;     // Catch: FileNotFoundException -> L5
            r101.onDataReady(r102);
            return;
        L5:
            e = move-exception;
            GlideLogUtil.e(FileLoader.TAG, "Failed to open file", e);
            r101.onLoadFailed(e);
        }
    }

    public interface FileOpener<Data> {
        void close(Data r100) throws IOException;

        Class<Data> getDataClass();

        Data open(File r100) throws FileNotFoundException;
    }

    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(File r100) {
        return true;
    }

    public FileLoader(FileOpener<Data> r100) {
        this.fileOpener = r100;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(File r100) {
        return handles2(r100);
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<Data> buildLoadData2(File r100, int r101, int r102, Options r103) {
        return new ModelLoader.LoadData(new ObjectKey(r100), new FileFetcher(r100, this.fileOpener));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(File r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}

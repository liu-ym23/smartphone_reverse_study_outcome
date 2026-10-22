package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
    private static final String BASE64_TAG = ";base64";
    private static final String DATA_SCHEME_IMAGE = "data:image";
    private final DataDecoder<Data> dataDecoder;

    public interface DataDecoder<Data> {
        void close(Data r100) throws IOException;

        Data decode(String r100) throws IllegalArgumentException;

        Class<Data> getDataClass();
    }

    public static final class DataUriFetcher<Data> implements DataFetcher<Data> {
        private Data data;
        private final String dataUri;
        private final DataDecoder<Data> reader;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            this.reader.close(this.data);     // Catch: IOException -> L4
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> getDataClass() {
            return this.reader.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public DataUriFetcher(String r100, DataDecoder<Data> r101) {
            this.dataUri = r100;
            this.reader = r101;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r100, DataFetcher.DataCallback<? super Data> r101) {
            Data r102 = this.reader.decode(this.dataUri);     // Catch: IllegalArgumentException -> L4
            this.data = r102;     // Catch: IllegalArgumentException -> L4
            r101.onDataReady(r102);     // Catch: IllegalArgumentException -> L4
            return;
        L4:
            e = move-exception;
            r101.onLoadFailed(e);
        }
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {
        private final DataDecoder<InputStream> opener;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public StreamFactory() {
            this.opener = new AnonymousClass1(this);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Model, InputStream> build(MultiModelLoaderFactory r100) {
            return new DataUrlLoader(this.opener);
        }
    }

    public DataUrlLoader(DataDecoder<Data> r100) {
        this.dataDecoder = r100;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Model r100) {
        return r100.toString().startsWith(DATA_SCHEME_IMAGE);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(Model r100, int r101, int r102, Options r103) {
        return new ModelLoader.LoadData(new ObjectKey(r100), new DataUriFetcher(r100.toString(), this.dataDecoder));
    }
}

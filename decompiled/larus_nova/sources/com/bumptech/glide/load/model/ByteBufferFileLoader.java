package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.GlideLogUtil;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {
    private static final String TAG = "ByteBufferFileLoader";

    public static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {
        private final File file;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public ByteBufferFetcher(File r100) {
            this.file = r100;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r100, DataFetcher.DataCallback<? super ByteBuffer> r101) {
            r101.onDataReady(ByteBufferUtil.fromFile(this.file));
            return;
        L5:
            e = move-exception;
            GlideLogUtil.e(ByteBufferFileLoader.TAG, "Failed to obtain ByteBuffer for file", e);
            r101.onLoadFailed(e);
        }
    }

    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        public Factory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<File, ByteBuffer> build(MultiModelLoaderFactory r100) {
            return new ByteBufferFileLoader();
        }
    }

    public ByteBufferFileLoader() {
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(File r100) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(File r100) {
        return handles2(r100);
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<ByteBuffer> buildLoadData2(File r100, int r101, int r102, Options r103) {
        return new ModelLoader.LoadData(new ObjectKey(r100), new ByteBufferFetcher(r100));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<ByteBuffer> buildLoadData(File r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}

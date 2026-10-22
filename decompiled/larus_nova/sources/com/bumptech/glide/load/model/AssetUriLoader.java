package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.signature.ObjectKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final String ASSET_PATH_SEGMENT = "android_asset";
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH = 22;
    private final AssetManager assetManager;
    private final AssetFetcherFactory<Data> factory;

    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> buildFetcher(AssetManager r100, String r101);
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, AssetFetcherFactory<ParcelFileDescriptor> {
        private final AssetManager assetManager;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public FileDescriptorFactory(AssetManager r100) {
            this.assetManager = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, ParcelFileDescriptor> build(MultiModelLoaderFactory r100) {
            return new AssetUriLoader(this.assetManager, this);
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public DataFetcher<ParcelFileDescriptor> buildFetcher(AssetManager r100, String r101) {
            return new FileDescriptorAssetPathFetcher(r100, r101);
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {
        private final AssetManager assetManager;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public StreamFactory(AssetManager r100) {
            this.assetManager = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory r100) {
            return new AssetUriLoader(this.assetManager, this);
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public DataFetcher<InputStream> buildFetcher(AssetManager r100, String r101) {
            return new StreamAssetPathFetcher(r100, r101);
        }
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r100) {
        if ("file".equals(r100.getScheme()) == true) goto L5;
        return false;
    L5:
        if (r100.getPathSegments().isEmpty() == false) goto L7;
        return false;
    L7:
        if (ASSET_PATH_SEGMENT.equals(ListProtector.get(r100.getPathSegments(), 0)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Uri r100) {
        return handles2(r100);
    }

    public AssetUriLoader(AssetManager r100, AssetFetcherFactory<Data> r101) {
        this.assetManager = r100;
        this.factory = r101;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<Data> buildLoadData2(Uri r100, int r101, int r102, Options r103) {
        String r104 = r100.toString().substring(ASSET_PREFIX_LENGTH);
        return new ModelLoader.LoadData(new ObjectKey(r100), this.factory.buildFetcher(this.assetManager, r104));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(Uri r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}

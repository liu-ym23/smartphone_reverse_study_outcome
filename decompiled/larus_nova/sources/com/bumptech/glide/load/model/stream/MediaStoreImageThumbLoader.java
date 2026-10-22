package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(Context r100) {
            this.context = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory r100) {
            return new MediaStoreImageThumbLoader(this.context);
        }
    }

    public MediaStoreImageThumbLoader(Context r100) {
        this.context = r100.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Uri r100) {
        return handles2(r100);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r100) {
        return MediaStoreUtil.isMediaStoreImageUri(r100);
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<InputStream> buildLoadData2(Uri r100, int r101, int r102, Options r103) {
        if (MediaStoreUtil.isThumbnailSize(r101, r102) == true) goto L5;
        return null;
    L5:
        return new ModelLoader.LoadData(new ObjectKey(r100), ThumbFetcher.buildImageFetcher(this.context, r100));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<InputStream> buildLoadData(Uri r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}

package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context context;

        public Factory(Context r10) {
            this.context = r10;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory r10) {
            return new MediaStoreVideoThumbLoader(this.context);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public MediaStoreVideoThumbLoader(Context r10) {
        this.context = r10.getApplicationContext();
    }

    private boolean isRequestingDefaultFrame(Options r10) {
        Long r11 = (Long) r10.get(VideoDecoder.TARGET_FRAME);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.longValue() != (-1)) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @Nullable
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Uri r10, int r11, int r12, @NonNull Options r13) {
        return buildLoadData2(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(@NonNull Uri r10) {
        return handles2(r10);
    }

    @Nullable
    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<InputStream> buildLoadData2(@NonNull Uri r10, int r11, int r12, @NonNull Options r13) {
        if (MediaStoreUtil.isThumbnailSize(r11, r12) == true) goto L5;
        return null;
    L5:
        if (isRequestingDefaultFrame(r13) == true) goto L7;
        return null;
    L7:
        return new ModelLoader.LoadData(new ObjectKey(r10), ThumbFetcher.buildVideoFetcher(this.context, r10));
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull Uri r10) {
        return MediaStoreUtil.isMediaStoreVideoUri(r10);
    }
}

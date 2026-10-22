package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.GlideLogUtil;
import f06.b;
import f06.c;
import f06.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri mediaStoreImageUri;
    private final ThumbnailStreamOpener opener;

    public static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = null;
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
        private final ContentResolver contentResolver;

        static {
            PATH_PROJECTION = new String[]{"_data"};
        }

        public ImageThumbnailQuery(ContentResolver r100) {
            this.contentResolver = r100;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri r100) {
            String r101 = r100.getLastPathSegment();
            return com_bumptech_glide_load_data_mediastore_ThumbFetcher$ImageThumbnailQuery_android_content_ContentResolver_query(this.contentResolver, MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{r101}, null);
        }

        private static Cursor com_bumptech_glide_load_data_mediastore_ThumbFetcher$ImageThumbnailQuery_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
    }

    public static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = null;
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
        private final ContentResolver contentResolver;

        static {
            PATH_PROJECTION = new String[]{"_data"};
        }

        public VideoThumbnailQuery(ContentResolver r100) {
            this.contentResolver = r100;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri r100) {
            String r101 = r100.getLastPathSegment();
            return com_bumptech_glide_load_data_mediastore_ThumbFetcher$VideoThumbnailQuery_android_content_ContentResolver_query(this.contentResolver, MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{r101}, null);
        }

        private static Cursor com_bumptech_glide_load_data_mediastore_ThumbFetcher$VideoThumbnailQuery_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    private InputStream openThumbInputStream() throws FileNotFoundException {
        InputStream r100 = this.opener.open(this.mediaStoreImageUri);
        if (r100 == null) goto L5;
        int r101 = this.opener.getOrientation(this.mediaStoreImageUri);
    L6:
        if (r101 != (-1)) goto L8;
        return r100;
    L8:
        return new ExifOrientationStream(r100, r101);
    L5:
        r101 = -1;
        goto L6
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream r100 = this.inputStream;
        if (r100 == null) goto L9;
        r100.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public ThumbFetcher(Uri r100, ThumbnailStreamOpener r101) {
        this.mediaStoreImageUri = r100;
        this.opener = r101;
    }

    public static ThumbFetcher buildImageFetcher(Context r100, Uri r101) {
        return build(r100, r101, new ImageThumbnailQuery(r100.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context r100, Uri r101) {
        return build(r100, r101, new VideoThumbnailQuery(r100.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority r100, DataFetcher.DataCallback<? super InputStream> r101) {
        InputStream r102 = openThumbInputStream();     // Catch: FileNotFoundException -> L5
        this.inputStream = r102;     // Catch: FileNotFoundException -> L5
        r101.onDataReady(r102);
        return;
    L5:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to find thumbnail file", e);
        r101.onLoadFailed(e);
    }

    private static ThumbFetcher build(Context r100, Uri r101, ThumbnailQuery r102) {
        ArrayPool r103 = Glide.get(r100).getArrayPool();
        return new ThumbFetcher(r101, new ThumbnailStreamOpener(Glide.get(r100).getRegistry().getImageHeaderParsers(), r102, r103, r100.getContentResolver()));
    }
}

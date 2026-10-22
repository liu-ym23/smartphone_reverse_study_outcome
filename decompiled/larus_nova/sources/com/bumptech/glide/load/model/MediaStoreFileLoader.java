package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.signature.ObjectKey;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import f06.b;
import f06.c;
import f06.d;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes39.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context context;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(Context r100) {
            this.context = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, File> build(MultiModelLoaderFactory r100) {
            return new MediaStoreFileLoader(this.context);
        }
    }

    public static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] PROJECTION = null;
        private final Context context;
        private final Uri uri;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        static {
            PROJECTION = new String[]{"_data"};
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public FilePathFetcher(Context r100, Uri r101) {
            this.context = r100;
            this.uri = r101;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r100, DataFetcher.DataCallback<? super File> r101) {
            Cursor r102 = com_bumptech_glide_load_model_MediaStoreFileLoader$FilePathFetcher_android_content_ContentResolver_query(this.context.getContentResolver(), this.uri, PROJECTION, null, null, null);
            String r103 = null;
            if (r102 == null) goto L12;
        L8:
            th = move-exception;
            r102.close();
            throw th;
        L5:
            if (r102.moveToFirst() == false) goto L7;
            r103 = r102.getString(r102.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L8
        L7:
            r102.close();
        L12:
            if (TextUtils.isEmpty(r103) == false) goto L14;
            r101.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.uri));
            return;
        L14:
            r101.onDataReady(new PolarisFileWrapper(r103));
        }

        private static Cursor com_bumptech_glide_load_model_MediaStoreFileLoader$FilePathFetcher_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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

    public MediaStoreFileLoader(Context r100) {
        this.context = r100;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Uri r100) {
        return handles2(r100);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r100) {
        return MediaStoreUtil.isMediaStoreUri(r100);
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<File> buildLoadData2(Uri r100, int r101, int r102, Options r103) {
        return new ModelLoader.LoadData(new ObjectKey(r100), new FilePathFetcher(this.context, r100));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<File> buildLoadData(Uri r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}

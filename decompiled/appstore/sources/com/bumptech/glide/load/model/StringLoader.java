package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StringLoader<Data> implements ModelLoader<String, Data> {
    private final ModelLoader<Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
        public AssetFileDescriptorFactory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, AssetFileDescriptor> build(@NonNull MultiModelLoaderFactory r10) {
            return new StringLoader(r10.build(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        public FileDescriptorFactory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<String, ParcelFileDescriptor> build(@NonNull MultiModelLoaderFactory r10) {
            return new StringLoader(r10.build(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        public StreamFactory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<String, InputStream> build(@NonNull MultiModelLoaderFactory r10) {
            return new StringLoader(r10.build(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StringLoader(ModelLoader<Uri, Data> r10) {
        this.uriLoader = r10;
    }

    @Nullable
    private static Uri parseUri(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        if (r10.charAt(0) == '/') goto L14;
        Uri r11 = Uri.parse(r10);
        if (r11.getScheme() != null) goto L13;
        return toFileUri(r10);
    L13:
        return r11;
    L14:
        return toFileUri(r10);
    }

    private static Uri toFileUri(String r10) {
        return Uri.fromFile(new File(r10));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(@NonNull String r10, int r11, int r12, @NonNull Options r13) {
        return buildLoadData2(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull String r10) {
        return true;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<Data> buildLoadData2(@NonNull String r10, int r11, int r12, @NonNull Options r13) {
        Uri r14 = parseUri(r10);
        if (r14 != null) goto L5;
        return null;
    L5:
        if (this.uriLoader.handles(r14) == true) goto L8;
        return null;
    L8:
        return this.uriLoader.buildLoadData(r14, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(@NonNull String r10) {
        return handles2(r10);
    }
}

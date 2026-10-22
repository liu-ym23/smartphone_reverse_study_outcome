package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class StringLoader<Data> implements ModelLoader<String, Data> {
    private final ModelLoader<Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
        public AssetFileDescriptorFactory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, AssetFileDescriptor> build(MultiModelLoaderFactory r100) {
            return new StringLoader(r100.build(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        public FileDescriptorFactory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, ParcelFileDescriptor> build(MultiModelLoaderFactory r100) {
            return new StringLoader(r100.build(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        public StreamFactory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, InputStream> build(MultiModelLoaderFactory r100) {
            return new StringLoader(r100.build(Uri.class, InputStream.class));
        }
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(String r100) {
        return true;
    }

    public StringLoader(ModelLoader<Uri, Data> r100) {
        this.uriLoader = r100;
    }

    private static Uri parseUri(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        if (r100.charAt(0) == '/') goto L14;
        Uri r101 = UriProtector.parse(r100);
        if (r101.getScheme() != null) goto L13;
        return toFileUri(r100);
    L13:
        return r101;
    L14:
        return toFileUri(r100);
    }

    private static Uri toFileUri(String r100) {
        return Uri.fromFile(new PolarisFileWrapper(r100));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(String r100) {
        return handles2(r100);
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<Data> buildLoadData2(String r100, int r101, int r102, Options r103) {
        Uri r104 = parseUri(r100);
        if (r104 != null) goto L5;
        return null;
    L5:
        if (this.uriLoader.handles(r104) == true) goto L8;
        return null;
    L8:
        return this.uriLoader.buildLoadData(r104, r101, r102, r103);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(String r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}

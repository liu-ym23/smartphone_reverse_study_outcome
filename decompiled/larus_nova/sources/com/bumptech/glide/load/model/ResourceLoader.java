package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public AssetFileDescriptorFactory(Resources r100) {
            this.resources = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory r100) {
            return new ResourceLoader(this.resources, r100.build(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public FileDescriptorFactory(Resources r100) {
            this.resources = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, ParcelFileDescriptor> build(MultiModelLoaderFactory r100) {
            return new ResourceLoader(this.resources, r100.build(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public StreamFactory(Resources r100) {
            this.resources = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory r100) {
            return new ResourceLoader(this.resources, r100.build(Uri.class, InputStream.class));
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public UriFactory(Resources r100) {
            this.resources = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, Uri> build(MultiModelLoaderFactory r100) {
            return new ResourceLoader(this.resources, UnitModelLoader.getInstance());
        }
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Integer r100) {
        return true;
    }

    private Uri getResourceUri(Integer r100) {
        return UriProtector.parse("android.resource://" + this.resources.getResourcePackageName(r100.intValue()) + '/' + this.resources.getResourceTypeName(r100.intValue()) + '/' + this.resources.getResourceEntryName(r100.intValue()));
    L5:
        e = move-exception;
        GlideLogUtil.e(TAG, "Received invalid resource id: " + r100, e);
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Integer r100) {
        return handles2(r100);
    }

    public ResourceLoader(Resources r100, ModelLoader<Uri, Data> r101) {
        this.resources = r100;
        this.uriLoader = r101;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<Data> buildLoadData2(Integer r100, int r101, int r102, Options r103) {
        Uri r104 = getResourceUri(r100);
        if (r104 != null) goto L6;
        return null;
    L6:
        return this.uriLoader.buildLoadData(r104, r101, r102, r103);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(Integer r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}

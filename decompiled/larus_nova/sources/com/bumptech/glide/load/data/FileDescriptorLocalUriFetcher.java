package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public class FileDescriptorLocalUriFetcher extends LocalUriFetcher<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ void close(ParcelFileDescriptor r100) throws IOException {
        close2(r100);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    public void close2(ParcelFileDescriptor r100) throws IOException {
        r100.close();
    }

    public FileDescriptorLocalUriFetcher(ContentResolver r100, Uri r101) {
        super(r100, r101);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public ParcelFileDescriptor loadResource(Uri r100, ContentResolver r101) throws FileNotFoundException {
        AssetFileDescriptor r102 = ContentResolverWrapper.openAssetFileDescriptor(r101, r100, "r");
        if (r102 == null) goto L7;
        return r102.getParcelFileDescriptor();
    L7:
        throw new FileNotFoundException("FileDescriptor is null for: " + r100);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ ParcelFileDescriptor loadResource(Uri r100, ContentResolver r101) throws FileNotFoundException {
        return loadResource(r100, r101);
    }
}

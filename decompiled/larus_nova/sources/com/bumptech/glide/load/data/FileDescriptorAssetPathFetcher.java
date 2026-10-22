package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public /* bridge */ /* synthetic */ void close(ParcelFileDescriptor r100) throws IOException {
        close2(r100);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    public void close2(ParcelFileDescriptor r100) throws IOException {
        r100.close();
    }

    public FileDescriptorAssetPathFetcher(AssetManager r100, String r101) {
        super(r100, r101);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public ParcelFileDescriptor loadResource(AssetManager r100, String r101) throws IOException {
        return r100.openFd(r101).getParcelFileDescriptor();
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public /* bridge */ /* synthetic */ ParcelFileDescriptor loadResource(AssetManager r100, String r101) throws IOException {
        return loadResource(r100, r101);
    }
}

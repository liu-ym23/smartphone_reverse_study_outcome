package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<ParcelFileDescriptor> {
    public FileDescriptorAssetPathFetcher(AssetManager r10, String r11) {
        super(r10, r11);
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public /* bridge */ /* synthetic */ void close(ParcelFileDescriptor r10) throws IOException {
        close2(r10);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public /* bridge */ /* synthetic */ ParcelFileDescriptor loadResource(AssetManager r10, String r11) throws IOException {
        return loadResource(r10, r11);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    public void close2(ParcelFileDescriptor r10) throws IOException {
        r10.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public ParcelFileDescriptor loadResource(AssetManager r10, String r11) throws IOException {
        return r10.openFd(r11).getParcelFileDescriptor();
    }
}

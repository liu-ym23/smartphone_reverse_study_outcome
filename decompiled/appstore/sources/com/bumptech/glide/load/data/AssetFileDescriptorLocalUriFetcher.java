package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class AssetFileDescriptorLocalUriFetcher extends LocalUriFetcher<AssetFileDescriptor> {
    public AssetFileDescriptorLocalUriFetcher(ContentResolver r10, Uri r11) {
        super(r10, r11);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ void close(AssetFileDescriptor r10) throws IOException {
        close2(r10);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<AssetFileDescriptor> getDataClass() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ AssetFileDescriptor loadResource(Uri r10, ContentResolver r11) throws FileNotFoundException {
        return loadResource(r10, r11);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    public void close2(AssetFileDescriptor r10) throws IOException {
        r10.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public AssetFileDescriptor loadResource(Uri r10, ContentResolver r11) throws FileNotFoundException {
        AssetFileDescriptor r12 = r11.openAssetFileDescriptor(r10, "r");
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new FileNotFoundException("FileDescriptor is null for: " + r10);
    }
}

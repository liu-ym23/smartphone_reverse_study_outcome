package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileDescriptorLocalUriFetcher extends LocalUriFetcher<ParcelFileDescriptor> {
    public FileDescriptorLocalUriFetcher(ContentResolver r10, Uri r11) {
        super(r10, r11);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ void close(ParcelFileDescriptor r10) throws IOException {
        close2(r10);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ ParcelFileDescriptor loadResource(Uri r10, ContentResolver r11) throws FileNotFoundException {
        return loadResource(r10, r11);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    public void close2(ParcelFileDescriptor r10) throws IOException {
        r10.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public ParcelFileDescriptor loadResource(Uri r10, ContentResolver r11) throws FileNotFoundException {
        AssetFileDescriptor r12 = r11.openAssetFileDescriptor(r10, "r");
        if (r12 == null) goto L7;
        return r12.getParcelFileDescriptor();
    L7:
        throw new FileNotFoundException("FileDescriptor is null for: " + r10);
    }
}

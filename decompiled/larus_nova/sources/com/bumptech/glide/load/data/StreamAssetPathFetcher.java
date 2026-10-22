package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public /* bridge */ /* synthetic */ void close(InputStream r100) throws IOException {
        close2(r100);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    public void close2(InputStream r100) throws IOException {
        r100.close();
    }

    public StreamAssetPathFetcher(AssetManager r100, String r101) {
        super(r100, r101);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public InputStream loadResource(AssetManager r100, String r101) throws IOException {
        return r100.open(r101);
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public /* bridge */ /* synthetic */ InputStream loadResource(AssetManager r100, String r101) throws IOException {
        return loadResource(r100, r101);
    }
}

package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: AssetFileDescriptorLocalUriFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends l<AssetFileDescriptor> {
    @Override // com.bumptech.glide.load.a.l
    public /* synthetic */ void a(AssetFileDescriptor r3) {
        a2((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r3, AssetFileDescriptor.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.load.a.l
    public /* synthetic */ AssetFileDescriptor b(Uri r1, ContentResolver r2) {
        return a(r1, r2);
    }

    public a(ContentResolver r1, Uri r2) {
        super(r1, r2);
    }

    public AssetFileDescriptor a(Uri r2, ContentResolver r3) {
        AssetFileDescriptor r1 = r3.openAssetFileDescriptor(r2, DownloadFileUtils.MODE_READ);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new FileNotFoundException("FileDescriptor is null for: " + r2);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(AssetFileDescriptor r1) {
        r1.close();
    }

    @Override // com.bumptech.glide.load.a.d
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }
}

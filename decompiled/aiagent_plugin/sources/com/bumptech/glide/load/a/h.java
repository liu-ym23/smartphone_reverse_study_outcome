package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FileDescriptorAssetPathFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends b<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.a.b
    public /* synthetic */ ParcelFileDescriptor a(AssetManager r1, String r2) {
        return b(r1, r2);
    }

    @Override // com.bumptech.glide.load.a.b
    public /* synthetic */ void a(ParcelFileDescriptor r3) {
        a2((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.class, "com.obric.aiagent.plugin"));
    }

    public h(AssetManager r1, String r2) {
        super(r1, r2);
    }

    public ParcelFileDescriptor b(AssetManager r1, String r2) {
        return r1.openFd(r2).getParcelFileDescriptor();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(ParcelFileDescriptor r1) {
        r1.close();
    }

    @Override // com.bumptech.glide.load.a.d
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}

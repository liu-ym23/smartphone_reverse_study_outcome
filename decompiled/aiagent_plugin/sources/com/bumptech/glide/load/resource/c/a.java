package com.bumptech.glide.load.resource.c;

import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: FileDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements k<File, File> {
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(File r1, i r2) {
        return true;
    }

    public a() {
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ v<File> a(File r3, int r4, int r5, i r6) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(File r3, i r4) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"), r4);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public v<File> a2(File r1, int r2, int r3, i r4) {
        return new b(r1);
    }
}

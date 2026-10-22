package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import java.io.File;
import java.io.FileFilter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1593a;

    public /* synthetic */ i(int i8) {
        this.f1593a = i8;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        switch (this.f1593a) {
            case 0:
                return EmbeddingStorage.AnonymousClass2.invokeSuspend$lambda$0(file);
            case 1:
                return EmbeddingStorage.loadRecent$lambda$0(file);
            default:
                return file.isDirectory();
        }
    }
}

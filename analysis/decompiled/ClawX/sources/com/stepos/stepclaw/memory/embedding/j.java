package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import java.io.File;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f1595b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Exception f1596c;

    public /* synthetic */ j(File file, Exception exc, int i8) {
        this.f1594a = i8;
        this.f1595b = file;
        this.f1596c = exc;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1594a) {
            case 0:
                return EmbeddingStorage.AnonymousClass2.invokeSuspend$lambda$3(this.f1595b, this.f1596c);
            default:
                return EmbeddingStorage.loadBinFile$lambda$1(this.f1595b, this.f1596c);
        }
    }
}

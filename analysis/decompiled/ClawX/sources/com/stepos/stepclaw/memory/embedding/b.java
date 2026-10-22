package com.stepos.stepclaw.memory.embedding;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1579a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f1580b;

    public /* synthetic */ b(Exception exc, int i8) {
        this.f1579a = i8;
        this.f1580b = exc;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1579a;
        Exception exc = this.f1580b;
        switch (i8) {
            case 0:
                return EmbeddingStorage.writeFormatVersion$lambda$0(exc);
            case 1:
                return EmbeddingStorage.wipeAll$lambda$1(exc);
            default:
                return EmbeddingStorage.peekFormatVersion$lambda$0(exc);
        }
    }
}

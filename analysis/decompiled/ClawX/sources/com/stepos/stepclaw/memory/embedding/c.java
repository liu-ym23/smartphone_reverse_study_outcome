package com.stepos.stepclaw.memory.embedding;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1581a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1582b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Exception f1583c;

    public /* synthetic */ c(String str, Exception exc, int i8) {
        this.f1581a = i8;
        this.f1582b = str;
        this.f1583c = exc;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1581a) {
            case 0:
                return EmbeddingStorage.rewriteTombstones$lambda$0(this.f1582b, this.f1583c);
            case 1:
                return EmbeddingStorage.appendTombstones$lambda$0(this.f1582b, this.f1583c);
            default:
                return EmbeddingStorage.loadTombstones$lambda$1(this.f1582b, this.f1583c);
        }
    }
}

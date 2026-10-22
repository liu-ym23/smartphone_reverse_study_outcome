package com.stepos.stepclaw.memory;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1672a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1673b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1674c;

    public /* synthetic */ o(String str, String str2, int i8) {
        this.f1672a = i8;
        this.f1673b = str;
        this.f1674c = str2;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1672a) {
            case 0:
                return MemoryEngine.beforeSendMessage$lambda$0(this.f1673b, this.f1674c);
            case 1:
                return MemoryEngine.beforeToolCall$lambda$0(this.f1673b, this.f1674c);
            default:
                return MemoryEngine.switchEmbeddingProvider$lambda$0$1(this.f1673b, this.f1674c);
        }
    }
}

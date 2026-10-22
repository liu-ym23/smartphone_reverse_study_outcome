package com.stepos.stepclaw.memory.lightmem;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1622a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1623b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1624c;
    public final /* synthetic */ int d;

    public /* synthetic */ a(int i8, int i9, String str, String str2) {
        this.f1622a = i9;
        this.f1623b = str;
        this.f1624c = str2;
        this.d = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1622a) {
            case 0:
                return LightMemClient.postOfflineTrigger$lambda$0(this.f1623b, this.f1624c, this.d);
            default:
                return LightMemClient.postOfflineUpdate$lambda$1(this.f1623b, this.f1624c, this.d);
        }
    }
}

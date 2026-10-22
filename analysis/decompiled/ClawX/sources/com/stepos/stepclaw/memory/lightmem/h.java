package com.stepos.stepclaw.memory.lightmem;

import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1666a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LightMemClient f1667b;

    public /* synthetic */ h(LightMemClient lightMemClient, int i8) {
        this.f1666a = i8;
        this.f1667b = lightMemClient;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        int i8 = this.f1666a;
        LightMemClient lightMemClient = this.f1667b;
        switch (i8) {
            case 0:
                return LightMemClient.httpClient$lambda$0(lightMemClient, (t3.d) obj);
            default:
                return LightMemClient.httpClient$lambda$0$0(lightMemClient, (b4.c) obj);
        }
    }
}

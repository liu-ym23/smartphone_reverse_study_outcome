package com.stepos.stepclaw;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1550a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GatewayRuntime f1551b;

    public /* synthetic */ b(GatewayRuntime gatewayRuntime, int i8) {
        this.f1550a = i8;
        this.f1551b = gatewayRuntime;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1550a;
        GatewayRuntime gatewayRuntime = this.f1551b;
        switch (i8) {
            case 0:
                return gatewayRuntime.resolveMainSessionKey();
            case 1:
                return Boolean.valueOf(GatewayRuntime.connectionManager$lambda$0(gatewayRuntime));
            case 2:
                return GatewayRuntime.gatewaySession$lambda$3(gatewayRuntime);
            default:
                return GatewayRuntime.networkRecoveryMonitor$lambda$0(gatewayRuntime);
        }
    }
}

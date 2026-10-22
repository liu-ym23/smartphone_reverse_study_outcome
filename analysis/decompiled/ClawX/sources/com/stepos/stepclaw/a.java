package com.stepos.stepclaw;

import com.stepos.stepclaw.gateway.GatewayEndpoint;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1547a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GatewayRuntime f1548b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GatewayEndpoint f1549c;

    public /* synthetic */ a(GatewayRuntime gatewayRuntime, GatewayEndpoint gatewayEndpoint, int i8) {
        this.f1547a = i8;
        this.f1548b = gatewayRuntime;
        this.f1549c = gatewayEndpoint;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1547a) {
            case 0:
                return GatewayRuntime.triggerChrootOtaSelfHeal$lambda$0(this.f1548b, this.f1549c);
            case 1:
                return GatewayRuntime.maybeAutoStartGateway$lambda$0$0(this.f1548b, this.f1549c);
            default:
                return GatewayRuntime.gatewaySession$lambda$3$0(this.f1548b, this.f1549c);
        }
    }
}

package com.stepos.stepclaw.gateway;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import h5.i;
import java.io.IOException;
import kotlin.Metadata;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID}, k = 3, mv = {2, 2, 0}, xi = 48)
@h5.e(c = "com.stepos.stepclaw.gateway.GatewayAutoStart$startGateway$3$currentLauncher$1$3", f = "GatewayAutoStart.kt", l = {115}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GatewayAutoStart$startGateway$3$currentLauncher$1$3 extends i implements l {
    final /* synthetic */ OpenClawRuntimeConfig $runtimeConfig;
    final /* synthetic */ GatewayAutoStart $this_run;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayAutoStart$startGateway$3$currentLauncher$1$3(GatewayAutoStart gatewayAutoStart, OpenClawRuntimeConfig openClawRuntimeConfig, f5.c cVar) {
        super(1, cVar);
        this.$this_run = gatewayAutoStart;
        this.$runtimeConfig = openClawRuntimeConfig;
    }

    @Override // h5.a
    public final f5.c create(f5.c cVar) {
        return new GatewayAutoStart$startGateway$3$currentLauncher$1$3(this.$this_run, this.$runtimeConfig, cVar);
    }

    @Override // p5.l
    public final Object invoke(f5.c cVar) {
        return ((GatewayAutoStart$startGateway$3$currentLauncher$1$3) create(cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) throws IOException {
        g5.a aVar = g5.a.f2984a;
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return obj;
        }
        a.a.c0(obj);
        GatewayAutoStart gatewayAutoStart = this.$this_run;
        OpenClawRuntimeConfig openClawRuntimeConfig = this.$runtimeConfig;
        this.label = 1;
        Object objCheckGatewayHealth = gatewayAutoStart.checkGatewayHealth(openClawRuntimeConfig, this);
        return objCheckGatewayHealth == aVar ? aVar : objCheckGatewayHealth;
    }
}

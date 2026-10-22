package com.stepos.stepclaw.gateway;

import android.content.Context;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.config.JsonConfigStore;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import com.stepos.stepclaw.runtime.SystemChrootRuntimeController;
import h5.i;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID}, k = 3, mv = {2, 2, 0}, xi = 48)
@h5.e(c = "com.stepos.stepclaw.gateway.GatewayAutoStart$startGateway$3$currentLauncher$1$6", f = "GatewayAutoStart.kt", l = {120}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GatewayAutoStart$startGateway$3$currentLauncher$1$6 extends i implements l {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ JsonConfigStore $jsonStore;
    final /* synthetic */ l $onLog;
    final /* synthetic */ OpenClawRuntimeConfig $runtimeConfig;
    final /* synthetic */ SystemChrootRuntimeController $runtimeController;
    final /* synthetic */ GatewayAutoStart $this_run;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayAutoStart$startGateway$3$currentLauncher$1$6(GatewayAutoStart gatewayAutoStart, Context context, OpenClawRuntimeConfig openClawRuntimeConfig, SystemChrootRuntimeController systemChrootRuntimeController, l lVar, JsonConfigStore jsonConfigStore, f5.c cVar) {
        super(1, cVar);
        this.$this_run = gatewayAutoStart;
        this.$appContext = context;
        this.$runtimeConfig = openClawRuntimeConfig;
        this.$runtimeController = systemChrootRuntimeController;
        this.$onLog = lVar;
        this.$jsonStore = jsonConfigStore;
    }

    @Override // h5.a
    public final f5.c create(f5.c cVar) {
        return new GatewayAutoStart$startGateway$3$currentLauncher$1$6(this.$this_run, this.$appContext, this.$runtimeConfig, this.$runtimeController, this.$onLog, this.$jsonStore, cVar);
    }

    @Override // p5.l
    public final Object invoke(f5.c cVar) {
        return ((GatewayAutoStart$startGateway$3$currentLauncher$1$6) create(cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        GatewayAutoStart$startGateway$3$currentLauncher$1$6 gatewayAutoStart$startGateway$3$currentLauncher$1$6;
        g5.a aVar = g5.a.f2984a;
        int i8 = this.label;
        if (i8 == 0) {
            a.a.c0(obj);
            GatewayAutoStart gatewayAutoStart = this.$this_run;
            Context context = this.$appContext;
            p.b(context);
            OpenClawRuntimeConfig openClawRuntimeConfig = this.$runtimeConfig;
            SystemChrootRuntimeController systemChrootRuntimeController = this.$runtimeController;
            l lVar = this.$onLog;
            this.label = 1;
            gatewayAutoStart$startGateway$3$currentLauncher$1$6 = this;
            obj = gatewayAutoStart.runOtaCheck(context, openClawRuntimeConfig, systemChrootRuntimeController, lVar, gatewayAutoStart$startGateway$3$currentLauncher$1$6);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            gatewayAutoStart$startGateway$3$currentLauncher$1$6 = this;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (zBooleanValue) {
            gatewayAutoStart$startGateway$3$currentLauncher$1$6.$this_run.enforceGatewayConfig(gatewayAutoStart$startGateway$3$currentLauncher$1$6.$jsonStore, gatewayAutoStart$startGateway$3$currentLauncher$1$6.$onLog);
        }
        return Boolean.valueOf(zBooleanValue);
    }
}

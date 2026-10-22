package com.stepos.cpuset;

import android.os.SystemClock;
import com.stepos.core.common.device.OaidResolver;
import com.stepos.core.common.memory.NativeMemoryBridge;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.model.ModelLifecycleImpl;
import com.stepos.core.ota.download.control.StepOsThermalBridge;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.cpuset.NeoDispatchers;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import lb.n;
import tc.p0;
import tc.r0;
import uc.u;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7620a;

    public /* synthetic */ c(int i10) {
        this.f7620a = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7620a) {
            case 0:
                return NeoDispatchers.IO.POWER_LOWEST_delegate$lambda$1();
            case 1:
                return StepOsThermalBridge.shellZones_delegate$lambda$0();
            case 2:
                return Long.valueOf(SystemClock.elapsedRealtime());
            case 3:
                return Long.valueOf(EngineRuntimeConfig.INSTANCE.getSnapshot().getCameraResumeDelayMs());
            case 4:
                return RemoteModelsRepository.httpClient_delegate$lambda$2();
            case 5:
                return MMKV.o("ota_models_version");
            case 6:
                return n.f10413a;
            case 7:
                return Long.valueOf(SystemClock.elapsedRealtime());
            case 8:
                return Call.pool$lambda$9();
            case 9:
                return Callback.pool$lambda$7();
            case 10:
                return Reply.pool$lambda$6();
            case 11:
                return MethodWrapper.pool$lambda$5();
            case 12:
                return ParameterWrapper.pool$lambda$6();
            case 13:
                return ServiceWrapper.pool$lambda$6();
            case 14:
                return OaidResolver.kv_delegate$lambda$2();
            case 15:
                return p0.c(new ArrayList(0));
            case 16:
                return Long.valueOf(SystemClock.elapsedRealtime());
            case 17:
                return u.f13228b;
            case 18:
                return uc.n.f13217b;
            case 19:
                return uc.c.f13199b;
            case 20:
                return NativeMemoryBridge.purgeHandler_delegate$lambda$1();
            case 21:
                return Boolean.valueOf(ModelLifecycleImpl.close$lambda$5$lambda$4());
            default:
                return Boolean.valueOf(ModelLifecycleImpl.init$lambda$2$lambda$0());
        }
    }

    public /* synthetic */ c(r0 r0Var) {
        this.f7620a = 15;
    }
}

package com.stepos.core.ota.process;

import android.content.Context;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.OtaDispatcher;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.bridge.CallbackSubscriber;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.process.OtaAbilityMappingCache;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.StateFlow;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaRuntime {
    public static final OtaRuntime INSTANCE = new OtaRuntime();
    private static volatile Context appContext;

    private OtaRuntime() {
    }

    private final boolean useIpc() {
        Context context = appContext;
        return (context == null || !OtaProcessConfig.INSTANCE.getEnabled() || OtaProcess.INSTANCE.isOtaProcess(context)) ? false : true;
    }

    public final CallbackSubscriber callbacks() {
        return useIpc() ? OtaProcessClient.INSTANCE.callbacks() : OtaContainer.INSTANCE.getCallbacks();
    }

    public final OtaDispatcher dispatcher() {
        return useIpc() ? RemoteDispatcher.INSTANCE : OtaContainer.INSTANCE.getDispatcher();
    }

    public final void init(Context context) {
        g.f(context, "context");
        appContext = context.getApplicationContext();
        OtaProcessConfig otaProcessConfig = OtaProcessConfig.INSTANCE;
        otaProcessConfig.init(context);
        if (!otaProcessConfig.getEnabled() || OtaProcess.INSTANCE.isOtaProcess(context)) {
            return;
        }
        OtaProcessClient otaProcessClient = OtaProcessClient.INSTANCE;
        otaProcessClient.ensureCallbackBridge();
        otaProcessClient.reconcileInterruptedAsync(context, "main_process_start");
    }

    public final Context requireAppContext() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("OtaRuntime not initialized");
    }

    public final void setOnRemoteConnected(zb.a<n> aVar) {
        if (useIpc()) {
            OtaProcessClient.INSTANCE.setOnConnected(aVar);
        }
    }

    public final Map<String, OtaStateSnapshot> snapshot() {
        return useIpc() ? OtaProcessClient.INSTANCE.snapshot() : OtaContainer.INSTANCE.snapshot();
    }

    public final void syncAbilityMappings(List<OtaAbilityMappingCache.Row> rows, String framework) {
        g.f(rows, "rows");
        g.f(framework, "framework");
        OtaAbilityMappingCache otaAbilityMappingCache = OtaAbilityMappingCache.INSTANCE;
        otaAbilityMappingCache.persist(rows);
        otaAbilityMappingCache.persistFramework(framework);
        if (useIpc()) {
            OtaProcessClient.INSTANCE.syncMappings();
        } else {
            OtaEngine.INSTANCE.rebuildMappingsFromCache();
        }
    }

    public final StateFlow<Map<String, OtaStateSnapshot>> taskStateFlow() {
        return useIpc() ? OtaProcessClient.INSTANCE.getIpcState() : OtaContainer.INSTANCE.getState();
    }
}

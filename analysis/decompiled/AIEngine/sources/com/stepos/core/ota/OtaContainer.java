package com.stepos.core.ota;

import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.device.OaidResolver;
import com.stepos.core.common.net.HttpTransport;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.adapter.AndroidOtaLogger;
import com.stepos.core.ota.adapter.DigestIntegrityVerifier;
import com.stepos.core.ota.adapter.Fetch2ModelDownloadPort;
import com.stepos.core.ota.adapter.FileSystemModelStorage;
import com.stepos.core.ota.adapter.ManifestSourceAdapter;
import com.stepos.core.ota.adapter.SandboxModelActivator;
import com.stepos.core.ota.adapter.SystemOtaClock;
import com.stepos.core.ota.adapter.ZipArchiveExtractor;
import com.stepos.core.ota.bridge.CallbackSubscriber;
import com.stepos.core.ota.bridge.NotificationSubscriber;
import com.stepos.core.ota.crypto.AtRestSealer;
import com.stepos.core.ota.crypto.InMemoryFekCipherCache;
import com.stepos.core.ota.crypto.KeyCenterClient;
import com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar;
import com.stepos.core.ota.crypto.KeyCenterFekCipherSource;
import com.stepos.core.ota.crypto.KeystoreAtRestKeyStore;
import com.stepos.core.ota.crypto.KeystoreEcdhDecryptProvider;
import com.stepos.core.ota.crypto.ModelCryptoImpl;
import com.stepos.core.ota.crypto.ModelDecryptProviderRegistry;
import com.stepos.core.ota.crypto.ModelDistributionManager;
import com.stepos.core.ota.crypto.ModelKeystoreManager;
import com.stepos.core.ota.domain.OtaAction;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.OtaStore;
import com.stepos.core.ota.domain.install.ActivateStage;
import com.stepos.core.ota.domain.install.CleanupStage;
import com.stepos.core.ota.domain.install.DecryptStage;
import com.stepos.core.ota.domain.install.ExtractStage;
import com.stepos.core.ota.domain.install.InstallPipeline;
import com.stepos.core.ota.domain.install.PromoteStage;
import com.stepos.core.ota.domain.install.RegisterVersionStage;
import com.stepos.core.ota.domain.install.SealAtRestStage;
import com.stepos.core.ota.domain.install.VerifyInstalledStage;
import com.stepos.core.ota.domain.install.VerifyStage;
import com.stepos.core.ota.domain.model.ModelManifest;
import com.stepos.core.ota.domain.port.ModelActivator;
import com.stepos.core.ota.download.control.DownloadControlCenter;
import com.stepos.core.ota.downloader.DownloadEngine;
import com.stepos.core.ota.storage.InstalledDisplayMetaRecorder;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlow;
import lb.n;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaContainer {
    private static volatile CallbackSubscriber callbackBridge;
    private static volatile DownloadControlCenter controlCenter;
    private static volatile OtaStore coordinator;
    private static volatile StoreDispatcher dispatcherImpl;
    private static volatile ModelDownloadNotifier notifierImpl;
    public static final OtaContainer INSTANCE = new OtaContainer();
    private static CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));

    private OtaContainer() {
    }

    private final String deviceId(Context context) {
        Object objA;
        try {
            objA = OaidResolver.INSTANCE.get(context);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str = (String) objA;
        return str == null ? "" : str;
    }

    public static /* synthetic */ void init$default(OtaContainer otaContainer, Context context, DownloadEngine downloadEngine, ModelDownloadNotifier modelDownloadNotifier, ModelActivator modelActivator, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            modelActivator = new SandboxModelActivator();
        }
        otaContainer.init(context, downloadEngine, modelDownloadNotifier, modelActivator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String init$lambda$1(Context context) {
        OtaContainer otaContainer = INSTANCE;
        g.c(context);
        return otaContainer.deviceId(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String init$lambda$11(String otaId) {
        g.f(otaId, "otaId");
        return ModelPathStore.INSTANCE.getPath(otaId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String init$lambda$2(Context context) {
        OtaContainer otaContainer = INSTANCE;
        g.c(context);
        return otaContainer.deviceId(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String init$lambda$3(Context context) {
        OtaContainer otaContainer = INSTANCE;
        g.c(context);
        return otaContainer.deviceId(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$4(String modelId) {
        g.f(modelId, "modelId");
        return EngineRuntimeConfig.INSTANCE.shouldEncryptModel(modelId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$5() {
        return EngineRuntimeConfig.INSTANCE.getSnapshot().getModelEncryptionEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final n init$lambda$7() {
        OtaStore otaStore = coordinator;
        if (otaStore != null) {
            otaStore.submit(new OtaAction.ConditionsChanged(null, 1, 0 == true ? 1 : 0));
        }
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n init$lambda$9(Context context, ModelManifest it) {
        g.f(it, "it");
        InstalledDisplayMetaRecorder installedDisplayMetaRecorder = InstalledDisplayMetaRecorder.INSTANCE;
        g.c(context);
        installedDisplayMetaRecorder.record(context, it);
        return n.f10413a;
    }

    public final CallbackSubscriber getCallbacks() {
        CallbackSubscriber callbackSubscriber = callbackBridge;
        if (callbackSubscriber != null) {
            return callbackSubscriber;
        }
        throw new IllegalStateException("OtaContainer not initialized");
    }

    public final OtaDispatcher getDispatcher() {
        StoreDispatcher storeDispatcher = dispatcherImpl;
        if (storeDispatcher != null) {
            return storeDispatcher;
        }
        throw new IllegalStateException("OtaContainer not initialized");
    }

    public final ModelDownloadNotifier getNotifier() {
        ModelDownloadNotifier modelDownloadNotifier = notifierImpl;
        if (modelDownloadNotifier != null) {
            return modelDownloadNotifier;
        }
        throw new IllegalStateException("OtaContainer not initialized");
    }

    public final StateFlow<Map<String, OtaStateSnapshot>> getState() {
        OtaStore otaStore = coordinator;
        if (otaStore != null) {
            return otaStore.getState();
        }
        throw new IllegalStateException("OtaContainer not initialized");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init(Context context, DownloadEngine engine, ModelDownloadNotifier notifier, ModelActivator activator) {
        g.f(context, "context");
        g.f(engine, "engine");
        g.f(notifier, "notifier");
        g.f(activator, "activator");
        if (coordinator != null) {
            return;
        }
        int i10 = 1;
        HttpTransport httpTransport = null;
        Object[] objArr = 0;
        if (!CoroutineScopeKt.isActive(scope)) {
            scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        }
        Context applicationContext = context.getApplicationContext();
        AndroidOtaLogger androidOtaLogger = new AndroidOtaLogger();
        FileSystemModelStorage fileSystemModelStorage = new FileSystemModelStorage();
        ModelKeystoreManager modelKeystoreManager = new ModelKeystoreManager(androidOtaLogger);
        int i11 = 2;
        KeyCenterClient keyCenterClient = new KeyCenterClient(androidOtaLogger, httpTransport, i11, objArr == true ? 1 : 0);
        ModelDistributionManager modelDistributionManager = new ModelDistributionManager(new ModelCryptoImpl(), modelKeystoreManager, new ModelDecryptProviderRegistry(b1.P(new KeystoreEcdhDecryptProvider(modelKeystoreManager, new ModelCryptoImpl(), androidOtaLogger))), new KeyCenterFekCipherSource(new KeyCenterDeviceRegistrar(modelKeystoreManager, keyCenterClient, new c(applicationContext, 0), androidOtaLogger), keyCenterClient, modelKeystoreManager, new com.stepos.core.cta.c(applicationContext, i10), androidOtaLogger), new InMemoryFekCipherCache(), new c(applicationContext, i10), androidOtaLogger, null, TraceIdKeys.MAX_LENGTH, null);
        VerifyStage verifyStage = new VerifyStage(new DigestIntegrityVerifier(), fileSystemModelStorage);
        DecryptStage decryptStage = new DecryptStage(modelDistributionManager);
        ExtractStage extractStage = new ExtractStage(new ZipArchiveExtractor(), fileSystemModelStorage, false, 4, null);
        SealAtRestStage sealAtRestStage = new SealAtRestStage(new AtRestSealer(new KeystoreAtRestKeyStore(androidOtaLogger), new ModelCryptoImpl(), androidOtaLogger, new com.stepos.core.common.telemetry.b(4), null, 16, null), new a9.a(14), androidOtaLogger);
        PromoteStage promoteStage = new PromoteStage(fileSystemModelStorage);
        VerifyInstalledStage verifyInstalledStage = new VerifyInstalledStage(fileSystemModelStorage);
        ActivateStage activateStage = new ActivateStage(activator);
        RegisterVersionStage registerVersionStage = new RegisterVersionStage(fileSystemModelStorage);
        CleanupStage cleanupStage = new CleanupStage(fileSystemModelStorage, modelDistributionManager);
        int i12 = 5;
        InstallPipeline installPipeline = new InstallPipeline(m.b0(verifyStage, decryptStage, extractStage, sealAtRestStage, promoteStage, verifyInstalledStage, activateStage, registerVersionStage, cleanupStage), fileSystemModelStorage, androidOtaLogger);
        g.c(applicationContext);
        int i13 = 15;
        DownloadControlCenter downloadControlCenter = new DownloadControlCenter(applicationContext, new a9.b(i13), new a9.a(i13));
        OtaStore otaStore = new OtaStore(scope, new ManifestSourceAdapter(applicationContext), new Fetch2ModelDownloadPort(engine, null, i11, 0 == true ? 1 : 0), installPipeline, fileSystemModelStorage, new SystemOtaClock(), downloadControlCenter.getController(), new b6.g(downloadControlCenter, i12), androidOtaLogger, 0, new androidx.compose.runtime.g(applicationContext, 11), VadSessionManager.FRAME_BYTES, null);
        otaStore.start();
        callbackBridge = new CallbackSubscriber(scope, otaStore.getState(), new com.stepos.core.common.telemetry.b(i12));
        new NotificationSubscriber(scope, otaStore.getState(), notifier, applicationContext);
        notifierImpl = notifier;
        coordinator = otaStore;
        dispatcherImpl = new StoreDispatcher(otaStore);
        controlCenter = downloadControlCenter;
        downloadControlCenter.start();
    }

    public final void restorePausedFromDisk() {
        OtaStore otaStore = coordinator;
        if (otaStore == null) {
            return;
        }
        for (OtaTaskSnapshotStore.PausedRestoreEntry pausedRestoreEntry : OtaTaskSnapshotStore.INSTANCE.loadPausedRestoreEntries()) {
            otaStore.submit(new OtaAction.RestorePaused(pausedRestoreEntry.getOtaId(), pausedRestoreEntry.getReason(), pausedRestoreEntry.getProgress(), pausedRestoreEntry.getSources(), pausedRestoreEntry.getCellularAllowed()));
        }
    }

    public final Map<String, OtaStateSnapshot> snapshot() {
        return getState().getValue();
    }

    public final void stop() {
        if (coordinator == null) {
            return;
        }
        CoroutineScopeKt.cancel$default(scope, null, 1, null);
        DownloadControlCenter downloadControlCenter = controlCenter;
        if (downloadControlCenter != null) {
            downloadControlCenter.stop();
        }
        controlCenter = null;
        coordinator = null;
        dispatcherImpl = null;
        callbackBridge = null;
        notifierImpl = null;
    }
}

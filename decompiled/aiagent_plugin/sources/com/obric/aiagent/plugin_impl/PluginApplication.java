package com.obric.aiagent.plugin_impl;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.obric.aiagent.PluginLaunch;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin_api.PluginService;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.aiagent.real.KeepAliveService;
import com.obric.aiagent.real.KeepAliveServiceKt;
import com.obric.autoaction.foundation.AutoActionFoundation;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusApplication;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PluginApplication extends ZeusApplication {
    private static final String AUTHORITY_SVA = "com.obric.sva.sdk.ipc.provider";
    private static final String AUTHORITY_TRANSFER = "com.obric.aiagent.transfer";
    private static final String KEY_STATUS = "status";
    private static final String METHOD_GET_BREATH_DATA_UPLOAD_STATUS = "method_get_breath_data_upload_status";
    private static final String METHOD_GET_BREATH_WAKEUP_STATUS = "method_get_breath_wakeup_status";
    private static final String METHOD_GET_SVA_BREATH_STATUS = "breath-get-status";
    private static final String METHOD_GET_SVA_BREATH_UPLOAD_STATUS = "breath-upload-get-status";
    private static final String METHOD_GET_SVA_WAKEUP_STATUS = "wakeup-get-status";
    private static final String METHOD_GET_VOICE_WAKEUP_STATUS = "method_get_voice_wakeup_status";
    private static final String METHOD_SET_SVA_BREATH_STATUS = "breath-set-status";
    private static final String METHOD_SET_SVA_BREATH_UPLOAD_STATUS = "breath-upload-set-status";
    private static final String METHOD_SET_SVA_WAKEUP_STATUS = "wakeup-set-status";
    private static final String OLD_PACKAGE_NAME = "com.obric.assistantaiagent";
    private static final String PLUGIN_PKG_NAME = "com.obric.aiagent.plugin";
    private static final String TAG = "PluginApplication";
    private static final Uri URI_SVA = null;
    private static final Uri URI_TRANSFER = null;
    public static PluginApplication instance;
    public static Context pluginContext;
    private final Handler mainHandler;

    public PluginApplication() {
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ void access$000(PluginApplication r2) {
        ((PluginApplication) ZeusTransformUtils.wrapperContextForParams(r2, PluginApplication.class, PLUGIN_PKG_NAME)).tryMigrateWakeupStatus();
    }

    static /* synthetic */ void access$100(PluginApplication r2) {
        ((PluginApplication) ZeusTransformUtils.wrapperContextForParams(r2, PluginApplication.class, PLUGIN_PKG_NAME)).init();
    }

    static {
        URI_TRANSFER = Uri.parse("content://com.obric.aiagent.transfer");
        URI_SVA = Uri.parse("content://com.obric.sva.sdk.ipc.provider");
    }

    public void attachBaseContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, PLUGIN_PKG_NAME);
        instance = this;
        pluginContext = r4;
        super.attachBaseContext(r4);
        ILogDepend.Companion.i(TAG, "attachBaseContext completed, process: " + Application.getProcessName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super.onCreate();
        boolean r0 = com.obric.aiagent.utils.shared_state.a.a(this);
        ILogDepend.Companion.i(TAG, " default assistant, isEnabled = " + r0 + ", process: " + Application.getProcessName());
        if (r0 == true) goto L6;
        ILogDepend.Companion.e(TAG, "AIagent is NOT the default assistant, disabling components and killing process " + Application.getProcessName());
        com.obric.aiagent.utils.shared_state.a.b(this, PluginService.EXTERNAL_COMPONENTS);
        Process.killProcess(Process.myPid());
        return;
    L6:
        com.obric.aiagent.utils.shared_state.a.a(this, PluginService.EXTERNAL_COMPONENTS);
        initPlatform();
        initTaskApp();
        com.obric.aiagent.a.f16090a.a(pluginContext);
        this.mainHandler.post(new AnonymousClass1(this));
    }

    private void init() {
        ILogDepend.Companion.i(TAG, "plugin init start, process: " + Application.getProcessName());
        initPluginApi();
        initShareState();
        PluginLaunch.initAllAfterCreate(pluginContext, (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), PLUGIN_PKG_NAME), Application.class, PLUGIN_PKG_NAME));
        initOAuto();
        registerActivityStateListener();
        ILogDepend.Companion.i(TAG, "onCreate completed, process: " + Application.getProcessName());
    }

    private void startKeepAliveService() {
        ILogDepend.Companion.i(TAG, "startKeepAliveService, productName = " + ObricProductSdk.INSTANCE.featureService().getObricProductName());     // Catch: Throwable -> L12
        boolean r0 = ObricProductSdk.INSTANCE.featureService().isFeatureEnable(IFeatureServiceKt.FEATURE_KEY_KEEP_ALIVE_HIGH_LEVEL);     // Catch: Throwable -> L12
        ILogDepend.Companion.i(TAG, "startKeepAliveService, keepAliveHighLevel = $keepAliveHighLevel");     // Catch: Throwable -> L12
        if (r0 == false) goto L6;
        return;
    L6:
        Intent r1 = new Intent(pluginContext, KeepAliveService.class);     // Catch: Throwable -> L12
        if (KeepAliveServiceKt.shouldUseForegroundServiceStart() == false) goto L10;
        ZeusTransformUtils.startService(pluginContext, r1, PLUGIN_PKG_NAME);     // Catch: Throwable -> L12
    L15:
        return;
    L10:
        ZeusTransformUtils.startService(pluginContext, r1, PLUGIN_PKG_NAME);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to start KeepAliveService", th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initTaskApp() {
        b.f18756a.a(this);     // Catch: Throwable -> L5
        ILogDepend.Companion.i(TAG, "TaskApp initialized");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to init TaskApp", th);
    }

    private void initPlatform() {
        IAIAgentPlatform.Companion.setCommonParams("base", pluginContext);     // Catch: Exception -> L5
        ILogDepend.Companion.i(TAG, "AIAgentPlatform initialized");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to init AIAgentPlatform", e);
    }

    private void initPluginApi() {
        PluginService.api = new c();     // Catch: Exception -> L5
        ILogDepend.Companion.i(TAG, "PluginService.api initialized");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to init PluginService.api", e);
    }

    private void initShareState() {
        int r1 = Zeus.getPlugin(PLUGIN_PKG_NAME).getVersion();     // Catch: Exception -> L5
        com.obric.aiagent.utils.shared_state.b.f22344a.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), PLUGIN_PKG_NAME), Application.class, PLUGIN_PKG_NAME), r1);     // Catch: Exception -> L5
        ILogDepend.Companion.i(TAG, "SharedStateManager initialized");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to init SharedStateManager", e);
    }

    private void initOAuto() {
        AutoActionFoundation.create(pluginContext);     // Catch: Exception -> L5
        ILogDepend.Companion.i(TAG, "OAuto initialized");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to init OAuto", e);
    }

    private void registerActivityStateListener() {
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), PLUGIN_PKG_NAME), Application.class, PLUGIN_PKG_NAME)).registerActivityLifecycleCallbacks(new AIAgentActivityObserver());     // Catch: Exception -> L5
        ILogDepend.Companion.i(TAG, "register AIAgentActivityObserver success");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to register AIAgentActivityObserver", e);
    }

    private boolean isComponentEnabled() {
        int r0 = pluginContext.getPackageManager().getApplicationEnabledSetting("com.obric.assistantaiagent");     // Catch: Throwable -> L9
        if (r0 == 1) goto L8;
        if (r0 == 0) goto L8;
        return false;
    L8:
        return true;
    L9:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "check enabled state failed for com.obric.assistantaiagent", e);
        return false;
    }

    private static ProviderInfo resolveContentProvider(Context r3, String r4) {
        PackageManager r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, PLUGIN_PKG_NAME)).getPackageManager();
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "resolveContentProvider failed, authority=" + r4, th);
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 33) goto L8;
        return r5.resolveContentProvider(r4, PackageManager.ComponentInfoFlags.of(0));
    L8:
        return r5.resolveContentProvider(r4, 0);
    }

    private static void logResolvedProvider(Context r4, String r5) {
        ProviderInfo r6 = resolveContentProvider((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, PLUGIN_PKG_NAME), r5);
        if (r6 != null) goto L6;
        ILogDepend.Companion.e(TAG, "ContentProvider NOT found, authority=" + r5);
        return;
    L6:
        ILogDepend.Companion.d(TAG, "ContentProvider found, authority=" + r5 + ", pkg=" + r6.packageName + ", name=" + r6.name + ", process=" + r6.processName + ", exported=" + r6.exported + ", readPermission=" + r6.readPermission + ", writePermission=" + r6.writePermission);
    }

    private static Bundle callProvider(Context r11, Uri r12, String r13, Bundle r14) {
        boolean r4 = true;
        Bundle r15 = ZeusProviderTransform.call(((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, PLUGIN_PKG_NAME)).getContentResolver(), r12, r13, null, r14, PLUGIN_PKG_NAME);     // Catch: Throwable -> L10
        ILogDepend.Companion r16 = ILogDepend.Companion;
        StringBuilder r17 = new StringBuilder().append("ContentResolver.call uri=").append(r12).append(", method=").append(r13).append(", resultNull=");
        if (r15 == null) goto L8;
        r4 = false;
    L8:
        r16.d(TAG, r17.append(r4).append("").toString());
        return r15;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ILogDepend.Companion.d(TAG, "ContentResolver.call uri=" + r12 + ", method=" + r13 + ", resultNull=true" + (", error=" + th.getClass().getSimpleName() + ":" + th.getMessage()));
        throw th;
    }

    private static Bundle callProviderViaClient(Context r6, Uri r7, String r8, Bundle r9) {
        ContentProviderClient r10 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, PLUGIN_PKG_NAME)).getContentResolver().acquireUnstableContentProviderClient(r7);     // Catch: Throwable -> L19
        if (r10 != null) goto L9;
        ILogDepend.Companion.e(TAG, "acquireUnstableContentProviderClient returned null, uri=" + r7);     // Catch: Throwable -> L17
        if (r10 != null) goto L38;
    L8:
        return null;
    L38:
        r10.close();     // Catch: Throwable -> L29
        goto L8
    L9:
        Bundle r11 = r10.call(r8, null, r9);     // Catch: Throwable -> L17
        ILogDepend.Companion r3 = ILogDepend.Companion;     // Catch: Throwable -> L17
        StringBuilder r4 = new StringBuilder().append("ContentProviderClient.call uri=").append(r7).append(", method=").append(r8).append(", resultNull=");     // Catch: Throwable -> L17
        if (r11 != null) goto L12;
        boolean r5 = true;
    L13:
        r3.d(TAG, r4.append(r5).toString());     // Catch: Throwable -> L17
        if (r10 != null) goto L44;
    L16:
        return r11;
    L44:
        r10.close();     // Catch: Throwable -> L30
        goto L16
    L12:
        r5 = false;
    L17:
        th = th;
    L42:
        ILogDepend.Companion.e(TAG, "ContentProviderClient.call failed, uri=" + r7 + ", method=" + r8, th);     // Catch: Throwable -> L25
        if (r10 != null) goto L40;
    L24:
        return null;
    L40:
        r10.close();     // Catch: Throwable -> L31
    L25:
        th = move-exception;
        if (r10 != null) goto L33;
    L28:
        throw th;
    L33:
        r10.close();     // Catch: Throwable -> L32
    L19:
        th = th;
        r10 = null;
        goto L42
    }

    private static Bundle callProviderReliably(Context r5, Uri r6, String r7, Bundle r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, PLUGIN_PKG_NAME);
        int r0 = 0;
    L4:
        if (r0 >= 3) goto L19;
        Bundle r1 = callProviderViaClient(r9, r6, r7, r8);
        if (r1 != null) goto L7;
        r0 = r0 + 1;
        Thread.sleep(((long) r0) * 50);     // Catch: InterruptedException -> L11
    L11:
        Thread.currentThread().interrupt();
        goto L19
    L7:
        return r1;
    L19:
        return callProvider(r9, r6, r7, r8);
    L14:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "callProviderReliably failed, uri=" + r6 + ", method=" + r7, th);
        return null;
    }

    private static boolean readStatus(Context r2, Uri r3, String r4, boolean r5) {
        Bundle r6 = callProviderReliably((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, PLUGIN_PKG_NAME), r3, r4, Bundle.EMPTY);
        if (r6 != null) goto L5;
    L7:
        return false;
    L5:
        if (r6.getBoolean("status", r5) == false) goto L7;
        return true;
    }

    private static void writeStatus(Context r2, Uri r3, String r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, PLUGIN_PKG_NAME);
        Bundle r0 = new Bundle();
        r0.putBoolean("status", r5);
        callProviderReliably(r6, r3, r4, r0);
    }

    private void tryMigrateWakeupStatus() {
        if (isComponentEnabled() == true) goto L6;
        ILogDepend.Companion.e(TAG, "no need to migrate, just return");
        return;
    L6:
        logResolvedProvider(pluginContext, AUTHORITY_TRANSFER);
        logResolvedProvider(pluginContext, AUTHORITY_SVA);
        boolean r1 = readStatus(pluginContext, URI_TRANSFER, METHOD_GET_VOICE_WAKEUP_STATUS, false);     // Catch: Throwable -> L9
        ILogDepend.Companion.d(TAG, "method_get_voice_wakeup_status => " + r1);     // Catch: Throwable -> L9
    L12:
        if (r1 == true) goto L46;
    L40:
        boolean r2 = readStatus(pluginContext, URI_TRANSFER, METHOD_GET_BREATH_WAKEUP_STATUS, false);     // Catch: Throwable -> L19
        ILogDepend.Companion.d(TAG, "method_get_breath_wakeup_status => " + r2);     // Catch: Throwable -> L19
    L21:
        if (r2 == true) goto L44;
    L38:
        boolean r3 = readStatus(pluginContext, URI_TRANSFER, METHOD_GET_BREATH_DATA_UPLOAD_STATUS, false);     // Catch: Throwable -> L28
        ILogDepend.Companion.d(TAG, "method_get_breath_data_upload_status => " + r3);     // Catch: Throwable -> L28
    L30:
        if (r3 == false) goto L48;
        Context r4 = pluginContext;     // Catch: Throwable -> L33
        Uri r5 = URI_SVA;     // Catch: Throwable -> L33
        writeStatus(r4, r5, METHOD_SET_SVA_BREATH_UPLOAD_STATUS, true);     // Catch: Throwable -> L33
        ILogDepend.Companion.d(TAG, "breath-upload-get-status after set => " + readStatus(pluginContext, r5, METHOD_GET_SVA_BREATH_UPLOAD_STATUS, false));     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "breath data upload status migrate failed", th);
        return;
    L48:
        return;
    L28:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "method_get_breath_data_upload_status call failed", th);
        r3 = false;
        goto L30
    L44:
        Context r6 = pluginContext;     // Catch: Throwable -> L24
        Uri r7 = URI_SVA;     // Catch: Throwable -> L24
        writeStatus(r6, r7, METHOD_SET_SVA_BREATH_STATUS, true);     // Catch: Throwable -> L24
        ILogDepend.Companion.d(TAG, "breath-get-status after set => " + readStatus(pluginContext, r7, METHOD_GET_SVA_BREATH_STATUS, false));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "breath status migrate failed", th);
    L19:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "method_get_breath_wakeup_status call failed", th);
        r2 = false;
        goto L21
    L46:
        Context r8 = pluginContext;     // Catch: Throwable -> L15
        Uri r9 = URI_SVA;     // Catch: Throwable -> L15
        writeStatus(r8, r9, METHOD_SET_SVA_WAKEUP_STATUS, true);     // Catch: Throwable -> L15
        ILogDepend.Companion.d(TAG, "voice-get-status after set => " + readStatus(pluginContext, r9, METHOD_GET_SVA_WAKEUP_STATUS, false));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "wakeup status migrate failed", th);
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "method_get_voice_wakeup_status call failed", th);
        r1 = false;
        goto L12
    }
}

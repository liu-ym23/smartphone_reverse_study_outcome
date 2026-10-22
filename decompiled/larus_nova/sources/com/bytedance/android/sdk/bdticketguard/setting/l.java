package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends BaseTicketGuardSettings {
    public static final m A = null;
    public static final m B = null;
    public static final m C = null;
    public static final m D = null;
    public static final m E = null;
    public static final m F = null;
    public static final m G = null;
    public static final m H = null;
    public static final m I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final m f163994J = null;
    public static final m K = null;
    public static final m L = null;
    public static final m M = null;
    public static final m N = null;
    public static final m O = null;
    public static final c P = null;
    public static final c Q = null;
    public static final c R = null;
    public static final c S = null;
    public static final m T = null;
    public static final m U = null;
    public static final m V = null;
    public static final m W = null;
    public static final m X = null;
    public static final m Y = null;
    public static final m Z = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final m f163995a0 = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final m f163996b0 = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final m f163997c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163998d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final m f163999d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f164000e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final m f164001e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f164002f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final m f164003f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f164004g = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final m f164005g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f164006h = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final m f164007h0 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f164008i = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final m f164009i0 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f164010j = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final m f164011j0 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f164012k = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final m f164013k0 = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f164014l = null;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final l f164015l0 = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final m f164016m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final m f164017n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final m f164018o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m f164019p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final m f164020q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final m f164021r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final m f164022s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final m f164023t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final m f164024u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final m f164025v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final m f164026w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final m f164027x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final m f164028y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final m f164029z = null;

    static {
        f163998d = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "useStandardizedHmacAlgorithm", "getUseStandardizedHmacAlgorithm()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "ticketGuardConfigVersion", "getTicketGuardConfigVersion()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableInitOpt", "getEnableInitOpt()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableTeeReeParallelInit", "getEnableTeeReeParallelInit()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableHighThreadPriorityInit", "getEnableHighThreadPriorityInit()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableInitRefactor", "getEnableInitRefactor()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableHmacCache", "getEnableHmacCache()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableTeePubKeyHeaderPathPrefix", "getEnableTeePubKeyHeaderPathPrefix()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableKeyAttestation", "getEnableKeyAttestation()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableLoginAttestation", "getEnableLoginAttestation()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "keyAttestationInitialDelay", "getKeyAttestationInitialDelay()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "keyAttestationRetryInterval", "getKeyAttestationRetryInterval()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "keyAttestationMaxAttempts", "getKeyAttestationMaxAttempts()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "keyAttestationDetectKeyChange", "getKeyAttestationDetectKeyChange()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "keyAttestationEnableWaitForSettings", "getKeyAttestationEnableWaitForSettings()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enablePrioritizeAccountInitParam", "getEnablePrioritizeAccountInitParam()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableAttestationSnapshotReport", "getEnableAttestationSnapshotReport()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableAttestationRegenKeyIfFailed", "getEnableAttestationRegenKeyIfFailed()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableAttestationMonitorSuccessIfHasReport", "getEnableAttestationMonitorSuccessIfHasReport()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "needAttestationSnapshotLocalErrorCodes", "getNeedAttestationSnapshotLocalErrorCodes()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "needAttestationSnapshotRemoteErrorCodes", "getNeedAttestationSnapshotRemoteErrorCodes()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableHuaweiAttestationAdapter", "getEnableHuaweiAttestationAdapter()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableHuaweiAdapterUpgrade", "getEnableHuaweiAdapterUpgrade()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableHonorAttestationAdapter", "getEnableHonorAttestationAdapter()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableHonorAdapterUpgrade", "getEnableHonorAdapterUpgrade()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "attestationAdapterOverride", "getAttestationAdapterOverride()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableAttestationTriggerInit", "getEnableAttestationTriggerInit()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "attestationWaitForCertRequestTimeoutSeconds", "getAttestationWaitForCertRequestTimeoutSeconds()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "honorSdkAppId", "getHonorSdkAppId()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "useOldHuaweiAttestRestriction", "getUseOldHuaweiAttestRestriction()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableAttestSignFix", "getEnableAttestSignFix()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableAttestationAdapterCompensate", "getEnableAttestationAdapterCompensate()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableTeeRegenKeyOnFail", "getEnableTeeRegenKeyOnFail()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "teeRegenKeyOnFailThreshold", "getTeeRegenKeyOnFailThreshold()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableAndroidKeystoreFix", "getEnableAndroidKeystoreFix()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableHighPriorityTeeLoad", "getEnableHighPriorityTeeLoad()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableKeyStorePreload", "getEnableKeyStorePreload()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "attestSignMinRefreshInterval", "getAttestSignMinRefreshInterval()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "staticSignRefreshThreshold", "getStaticSignRefreshThreshold()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "staticSignExpireTime", "getStaticSignExpireTime()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableStaticSignFeedReadyOpt", "getEnableStaticSignFeedReadyOpt()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableKeyGuardStatusMonitor", "getEnableKeyGuardStatusMonitor()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableEnsureManager", "getEnableEnsureManager()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "ensureSampleRate", "getEnsureSampleRate()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enablePubKeyRecovery", "getEnablePubKeyRecovery()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "pubKeyRecoveryMethods", "getPubKeyRecoveryMethods()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "pubKeyRecoveryMethodsVerify", "getPubKeyRecoveryMethodsVerify()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableTeeBackupKeyProbe", "getEnableTeeBackupKeyProbe()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableEnsureCrashTest", "getEnableEnsureCrashTest()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "crashTestIntervalSeconds", "getCrashTestIntervalSeconds()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableCertVerifyFailLocally", "getEnableCertVerifyFailLocally()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enablePublicKeyCertCompare", "getEnablePublicKeyCertCompare()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableNewTeeLoadKeyProc", "getEnableNewTeeLoadKeyProc()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableKeyGenExplicitNotRequireAuth", "getEnableKeyGenExplicitNotRequireAuth()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enableKeystoreLazyInit", "getEnableKeystoreLazyInit()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "enablePreinitFlipped", "getEnablePreinitFlipped()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "attestationEnableInvalidateQuery", "getAttestationEnableInvalidateQuery()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "attestationInvalidateQueryMinIntervalSeconds", "getAttestationInvalidateQueryMinIntervalSeconds()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(l.class), "attestationEnableInvalidateQueryDelayMs", "getAttestationEnableInvalidateQueryDelayMs()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;"))};
        l r100 = new l();
        f164015l0 = r100;
        f164000e = new c(Boolean.TRUE);
        f164002f = r100.d("ticket_guard_config_version", "<default>");
        Boolean r101 = Boolean.FALSE;
        f164004g = new c(r101);
        f164006h = new c(r101);
        f164008i = new c(r101);
        f164010j = new c(r101);
        f164012k = new c(r101);
        f164014l = new c(SetsKt.emptySet());
        f164016m = r100.b("enable_key_attestation", false);
        f164017n = r100.b("enable_login_attestation", true);
        f164018o = r100.c("key_attestation_initial_delay", 30);
        f164019p = r100.c("key_attestation_retry_delay", 30);
        f164020q = new m(new f("key_attestation_max_attempts", 3, new BaseTicketGuardSettings$ticketSettingInt$1(r100)));
        f164021r = r100.b("key_attestation_enable_detect_key_change", true);
        f164022s = r100.b("key_attestation_enable_wait_for_settings", true);
        f164023t = r100.b("enable_prioritize_account_init_param", true);
        f164024u = r100.b("enable_attestation_snapshot_report", false);
        f164025v = r100.b("enable_attestation_regen_key_if_failed", false);
        f164026w = r100.b("enable_attestation_monitor_success_if_has_report", false);
        f164027x = r100.d("need_attestation_snapshot_local_error_codes", "");
        f164028y = r100.d("need_attestation_snapshot_remote_error_codes", "");
        f164029z = r100.b("enable_huawei_attestation_adapter", false);
        A = r100.b("enable_huawei_adapter_upgrade", true);
        B = r100.b("enable_honor_attestation_adapter", false);
        C = r100.b("enable_honor_adapter_upgrade", true);
        D = r100.d("attestation_adapter_override", "");
        E = r100.b("enable_attestation_trigger_init", true);
        F = r100.c("attestation_wait_for_cert_request_timeout_seconds", 10);
        G = r100.d("honor_sdk_app_id", "");
        H = r100.b("use_old_huawei_attest_restriction", false);
        I = r100.b("enable_attest_sign_fix", true);
        f163994J = r100.b("enable_attestation_adapter_compensate", false);
        K = r100.b("enable_tee_regen_key_on_fail", false);
        L = new m(new f("tee_regen_key_on_fail_threshold", 3, new BaseTicketGuardSettings$ticketSettingInt$1(r100)));
        M = r100.b("enable_android_keystore_fix", false);
        N = r100.b("enable_high_priority_tee_load", false);
        O = r100.b("enable_key_store_preload", false);
        P = new c(540L);
        Q = new c(600L);
        R = new c(86400L);
        S = new c(r101);
        T = r100.b("enable_key_guard_status_monitor", true);
        U = r100.b("enable_ensure_manager", true);
        V = new m(new f("ensure_sample_rate", 1, new BaseTicketGuardSettings$ticketSettingInt$1(r100)));
        W = r100.b("bd_ticket_guard_enable_pubkey_recovery", true);
        X = new m(new j(CollectionsKt.listOf(new String[]{"reflect", "storage", "keystore2_reflect"}), new BaseTicketGuardSettings$ticketSettingStringList$1(r100)));
        Y = new m(new h(new BaseTicketGuardSettings$ticketSettingObject$1(r100)));
        Z = r100.b("enable_tee_backup_key_probe", false);
        f163995a0 = r100.b("enable_ensure_crash_test", false);
        f163996b0 = r100.c("crash_test_interval", 86400);
        f163997c0 = r100.b("enable_cert_verify_fail_locally", true);
        f163999d0 = r100.b("enable_public_key_cert_compare", true);
        f164001e0 = r100.b("enable_new_tee_load_key_proc", true);
        f164003f0 = r100.b("enable_keygen_explicit_notrequire_auth", true);
        f164005g0 = r100.b("enable_keystore_lazy_init", true);
        f164007h0 = r100.b("enable_preinit_flipped", false);
        f164009i0 = r100.b("key_attestation_enable_invalidate_query", false);
        f164011j0 = r100.c("key_attestation_invalidate_query_min_interval_seconds", 604800);
        f164013k0 = r100.c("key_attestation_enable_invalidate_query_delay_ms", 3000);
    }

    public static a f() {
        m r100 = f164016m;
        KProperty r101 = f163998d[8];
        return r100.f164030a;
    }

    public static a g() {
        m r100 = f164020q;
        KProperty r101 = f163998d[12];
        return r100.f164030a;
    }

    public l() {
    }
}

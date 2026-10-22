package com.bytedance.android.ec.hybrid;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ECMallConfigs;", "", "()V", "DEFAULT_LEGOU_OPT", "", "KEY_LEGOU_BUILTIN_RESOURCE_ENABLE", "", "KEY_LEGOU_OPT", "KEY_LEGOU_RESTRICT_CDN_VERSION_ENABLE", "LEGOU_OPT_FULL", "LEGOU_OPT_GECKO_PRELOAD", "LEGOU_OPT_PREFETCH_FLOW", "legouBuiltinResourceEnable", "", "getLegouBuiltinResourceEnable", "()Z", "legouBuiltinResourceEnable$delegate", "Lkotlin/Lazy;", "legouPrefetchFlowOptEnable", "getLegouPrefetchFlowOptEnable", "legouPrefetchFlowOptEnable$delegate", "legouRestrictCDNVersionEnable", "getLegouRestrictCDNVersionEnable", "legouRestrictCDNVersionEnable$delegate", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallConfigs {
    private static final int DEFAULT_LEGOU_OPT = 3;
    public static final ECMallConfigs INSTANCE = null;
    private static final String KEY_LEGOU_BUILTIN_RESOURCE_ENABLE = "ec_mall_legou_builtin_resource_enable";
    private static final String KEY_LEGOU_OPT = "ec_mall_legou_opt";
    private static final String KEY_LEGOU_RESTRICT_CDN_VERSION_ENABLE = "ec_mall_legou_restrict_cdn_version_enable";
    private static final int LEGOU_OPT_FULL = 3;
    private static final int LEGOU_OPT_GECKO_PRELOAD = 1;
    private static final int LEGOU_OPT_PREFETCH_FLOW = 2;
    private static final Lazy legouBuiltinResourceEnable$delegate = null;
    private static final Lazy legouPrefetchFlowOptEnable$delegate = null;
    private static final Lazy legouRestrictCDNVersionEnable$delegate = null;

    private ECMallConfigs() {
    }

    public final boolean getLegouBuiltinResourceEnable() {
        return ((Boolean) legouBuiltinResourceEnable$delegate.getValue()).booleanValue();
    }

    public final boolean getLegouPrefetchFlowOptEnable() {
        return ((Boolean) legouPrefetchFlowOptEnable$delegate.getValue()).booleanValue();
    }

    public final boolean getLegouRestrictCDNVersionEnable() {
        return ((Boolean) legouRestrictCDNVersionEnable$delegate.getValue()).booleanValue();
    }

    static {
        INSTANCE = new ECMallConfigs();
        legouPrefetchFlowOptEnable$delegate = LazyKt.lazy(ECMallConfigs$legouPrefetchFlowOptEnable$2.INSTANCE);
        legouBuiltinResourceEnable$delegate = LazyKt.lazy(ECMallConfigs$legouBuiltinResourceEnable$2.INSTANCE);
        legouRestrictCDNVersionEnable$delegate = LazyKt.lazy(ECMallConfigs$legouRestrictCDNVersionEnable$2.INSTANCE);
    }
}

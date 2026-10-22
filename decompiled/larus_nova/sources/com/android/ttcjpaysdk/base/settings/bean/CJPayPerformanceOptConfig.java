package com.android.ttcjpaysdk.base.settings.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fBU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayPerformanceOptConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "optV1", "", "mergeActivity", "retryRequestDelayMs", "", "waitTokenTimeout", "hideLoading", "isGuideToLogin", "withoutToken", "redpacketFixType", "", "(ZZJJZZZI)V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPerformanceOptConfig implements CJPayObject, Serializable {
    public static final String CJPAY_AB_OUTER_PERFORM_CONFIG = "cjpay_ab_outer_perform_config";
    public static final Companion Companion = null;
    public static final String TAG = "===CJOptConfig===";
    private static final Lazy<CJHostService> hostService$delegate = null;
    private static final Lazy<CJPayPerformanceOptConfig> performanceOptConfig$delegate = null;
    public boolean hideLoading;
    public boolean isGuideToLogin;
    public boolean mergeActivity;
    public boolean optV1;
    public int redpacketFixType;
    public long retryRequestDelayMs;
    public long waitTokenTimeout;
    public boolean withoutToken;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\rH\u0002J\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayPerformanceOptConfig$Companion;", "", "()V", "CJPAY_AB_OUTER_PERFORM_CONFIG", "", "TAG", "hostService", "Lcom/bytedance/caijing/sdk/infra/base/api/env/CJHostService;", "getHostService", "()Lcom/bytedance/caijing/sdk/infra/base/api/env/CJHostService;", "hostService$delegate", "Lkotlin/Lazy;", "performanceOptConfig", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayPerformanceOptConfig;", "getPerformanceOptConfig", "()Lcom/android/ttcjpaysdk/base/settings/bean/CJPayPerformanceOptConfig;", "performanceOptConfig$delegate", MonitorConstants.CONNECT_TYPE_GET, "getOptConfig", "getOptOptions", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final CJHostService getHostService() {
            return (CJHostService) CJPayPerformanceOptConfig.access$getHostService$delegate$cp().getValue();
        }

        private final CJPayPerformanceOptConfig getOptConfig() {
            String r100 = getHostService().getStringFromHostRepo(CJPayPerformanceOptConfig.CJPAY_AB_OUTER_PERFORM_CONFIG, "");
            CJLogger.a(CJPayPerformanceOptConfig.TAG, "from keva, config is " + r100);
            if (TextUtils.isEmpty(r100) == true) goto L7;
            CJPayPerformanceOptConfig r101 = (CJPayPerformanceOptConfig) CJPayJsonParser.fromJson(KtSafeMethodExtensionKt.safeCreate(r100), CJPayPerformanceOptConfig.class);
            if (r101 == null) goto L7;
            return r101;
        L7:
            CJLogger.a(CJPayPerformanceOptConfig.TAG, "get config from settings");
            return CJPaySettingsManager.getInstance().getCJPayPerformanceOptConfig();
        }

        private final CJPayPerformanceOptConfig getPerformanceOptConfig() {
            return (CJPayPerformanceOptConfig) CJPayPerformanceOptConfig.access$getPerformanceOptConfig$delegate$cp().getValue();
        }

        public final CJPayPerformanceOptConfig get() {
            return getPerformanceOptConfig();
        }

        public final String getOptOptions() {
            CJPayPerformanceOptConfig r100 = get();
            return "v1" + r100.optV1 + "_mergeActivity" + r100.mergeActivity + "_retryRequestDelayMs" + r100.retryRequestDelayMs + "_waitTokenTimeout" + r100.waitTokenTimeout + "_hideLoading" + r100.hideLoading + "_isGuideToLogin" + r100.isGuideToLogin + "_withoutToken" + r100.withoutToken;
        }

        public static final /* synthetic */ CJPayPerformanceOptConfig access$getOptConfig(Companion r100) {
            return r100.getOptConfig();
        }
    }

    public CJPayPerformanceOptConfig() {
        this(false, false, 0, 0, false, false, false, 0, 255, null);
    }

    static {
        Companion = new Companion(null);
        performanceOptConfig$delegate = LazyKt.lazy(CJPayPerformanceOptConfig$Companion$performanceOptConfig$2.INSTANCE);
        hostService$delegate = LazyKt.lazy(CJPayPerformanceOptConfig$Companion$hostService$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getHostService$delegate$cp() {
        return hostService$delegate;
    }

    public static final /* synthetic */ Lazy access$getPerformanceOptConfig$delegate$cp() {
        return performanceOptConfig$delegate;
    }

    public CJPayPerformanceOptConfig(boolean r100, boolean r101, long r102, long r103, boolean r104, boolean r105, boolean r106, int r110) {
        this.optV1 = r100;
        this.mergeActivity = r101;
        this.retryRequestDelayMs = r102;
        this.waitTokenTimeout = r103;
        this.hideLoading = r104;
        this.isGuideToLogin = r105;
        this.withoutToken = r106;
        this.redpacketFixType = r110;
    }

    public /* synthetic */ CJPayPerformanceOptConfig(boolean r110, boolean r111, long r112, long r113, boolean r114, boolean r115, boolean r210, int r211, int r212, DefaultConstructorMarker r213) {
        int r100 = 1;
        if ((r212 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r103 = 300;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r104 = 5000;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r116 = false;
    L31:
        if ((r212 & 128) != 0) goto L34;
        r100 = r211;
    L34:
        this(r101, r102, r103, r104, r105, r106, r116, r100);
        return;
    L29:
        r116 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}

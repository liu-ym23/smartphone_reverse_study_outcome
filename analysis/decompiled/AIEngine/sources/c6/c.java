package c6;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.ActionDebouncer;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ActionDebouncer f3292a;

    static {
        new Handler(Looper.getMainLooper());
        f3292a = new ActionDebouncer(0L, 1, null);
    }

    public static void a(Context context, String viewerTitle) {
        kotlin.jvm.internal.g.f(viewerTitle, "viewerTitle");
        if (!f3292a.tryAcquire("pp")) {
            AIEngineLogger.d(LogModule.SERVICE, "PolicyOpener", "open policy: pp ignored (debounce)");
            return;
        }
        boolean zIsNetworkAvailable = PolicySdkNetworkUtil.isNetworkAvailable(context);
        boolean zHasCTAPermission = CTAPermissionManager.INSTANCE.hasCTAPermission();
        AIEngineLogger.d(LogModule.SERVICE, "PolicyOpener", "open policy: pp hasNetwork=" + zIsNetworkAvailable + " ctaGranted=" + zHasCTAPermission);
        if (zIsNetworkAvailable && zHasCTAPermission) {
            PolicySdk.getOnlinePolicyMethod(context, PolicySdkToolsUtils.Companion.getLanguage(), "pp", "", Boolean.TRUE, new a0.a(19));
        } else {
            PolicySdk.openPolicyByMethod(context, Boolean.TRUE, "", "pp");
        }
    }
}

package com.obric.autogui.platforms.obric.c;

import android.content.Context;
import android.provider.Settings;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.obric.autogui.common.api.platform.strategy.SensitiveOperation;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.n;

/* JADX INFO: compiled from: ObricPlatformStrategies.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.platforms.tools.platstrategy.b {
    private static final String TAG = "Std/PlatStrategies";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0793a f30078a = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricPlatformStrategies.kt */
    public static final class C0793a {
        public /* synthetic */ C0793a(h r1) {
            this();
        }

        private C0793a() {
        }
    }

    /* JADX INFO: compiled from: ObricPlatformStrategies.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30079a = null;

        static {
            int[] r0 = new int[SensitiveOperation.values().length];
            r0[SensitiveOperation.ACCESS_FOR_COARSE_LOCATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SensitiveOperation.ACCESS_FINE_LOCATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SensitiveOperation.ACCESS_FOR_FULL_APP_LIST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f30079a = r0;
        }
    }

    static {
        f30078a = new C0793a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.platforms.tools.platstrategy.b, com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi
    public IAutoActionPlatformStrategyApi.SensitiveOpStrategy checkSensitiveOp(Context r6, SensitiveOperation r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r7, "op");
        int r9 = b.f30079a[r7.ordinal()];
        if (r9 != 1) goto L5;
        IAutoActionPermissionApi.PermissionCheckResult r5 = AssistantAbilityHelper.INSTANCE.checkAssistantPermission(r8, "android.permission.ACCESS_COARSE_LOCATION");
        if (r5.getSuccess() == true) goto L35;
    L39:
        Loog.INSTANCE.e(TAG, " - [SensitiveOp] (ACCESS_COARSE_LOCATION) --> failed (" + r5.getReason() + ')');
        return new IAutoActionPlatformStrategyApi.SensitiveOpStrategy(false, 1, r5.getReason());
    L35:
        if (r5.isGranted() == false) goto L39;
        return IAutoActionPlatformStrategyApi.SensitiveOpStrategy.Companion.getALLOWED();
    L5:
        if (r9 != 2) goto L7;
        IAutoActionPermissionApi.PermissionCheckResult r10 = AssistantAbilityHelper.INSTANCE.checkAssistantPermission(r8, "android.permission.ACCESS_FINE_LOCATION");
        if (r10.getSuccess() == true) goto L26;
    L30:
        Loog.INSTANCE.e(TAG, " - [SensitiveOp] (ACCESS_FINE_LOCATION) --> failed (" + r10.getReason() + ')');
        return new IAutoActionPlatformStrategyApi.SensitiveOpStrategy(false, 1, r10.getReason());
    L26:
        if (r10.isGranted() == false) goto L30;
        return IAutoActionPlatformStrategyApi.SensitiveOpStrategy.Companion.getALLOWED();
    L7:
        if (r9 != 3) goto L22;
        if (a(r8) == true) goto L12;
        Loog.INSTANCE.i(TAG, " - [SensitiveOp] (GET_INSTALLED_APPS) --> skipped because the OEM permission is unsupported");
        return IAutoActionPlatformStrategyApi.SensitiveOpStrategy.Companion.getALLOWED();
    L12:
        IAutoActionPermissionApi.PermissionCheckResult r11 = AssistantAbilityHelper.INSTANCE.checkAssistantPermission(r8, "com.android.permission.GET_INSTALLED_APPS");
        if (r11.getSuccess() == true) goto L15;
    L19:
        Loog.INSTANCE.e(TAG, " - [SensitiveOp] (GET_INSTALLED_APPS) --> failed (" + r11.getReason() + ')');
        return new IAutoActionPlatformStrategyApi.SensitiveOpStrategy(false, 1, r11.getReason());
    L15:
        if (r11.isGranted() == false) goto L19;
        return IAutoActionPlatformStrategyApi.SensitiveOpStrategy.Companion.getALLOWED();
    L22:
        throw new k();
    }

    private final boolean a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L9
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        int r9 = Settings.Secure.getInt(r8.getContentResolver(), "oem_installed_apps_runtime_permission_enable", 0);     // Catch: Throwable -> L9
        boolean r10 = true;
        if (r9 == 1) goto L7;
        r10 = false;
    L7:
        Object r11 = n.f(Boolean.valueOf(r10));     // Catch: Throwable -> L9
    L12:
        if (n.a(r11) == false) goto L14;
        Loog.INSTANCE.i(TAG, " - [SensitiveOp] OEM app-list permission supported=" + ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
    L14:
        Throwable r12 = n.c(r11);
        if (r12 == null) goto L18;
        Loog.INSTANCE.w(TAG, " - [SensitiveOp] failed to read OEM app-list capability", r12);
    L18:
        if (n.b(r11) == false) goto L21;
        r11 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L9:
        th = move-exception;
        n.a r13 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L12
    }

    @Override // com.obric.autogui.platforms.tools.platstrategy.b, com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi
    public e applyForSensitiveOp(Context r2, SensitiveOperation r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r3, "op");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        AOPlatformTools.INSTANCE.permission().openAllPermissionSettings(r1, AssistantAbilityHelper.INSTANCE.getAssistantPkg());
        return e.f29014b.a();
    }
}

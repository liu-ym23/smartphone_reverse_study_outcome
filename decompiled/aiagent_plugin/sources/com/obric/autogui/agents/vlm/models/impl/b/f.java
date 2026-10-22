package com.obric.autogui.agents.vlm.models.impl.b;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PermissionFeedbackUpdater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements b {
    private static final String TAG = "ModelEnv/Perm";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27598a = null;

    /* JADX INFO: compiled from: PermissionFeedbackUpdater.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f27598a = new a(null);
    }

    public f() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.b
    public void a(com.obric.autogui.agents.vlm.b.C0677b r9, com.obric.autogui.agents.vlm.models.c.b r10, com.obric.autogui.agents.vlm.models.impl.b.a r11) {
        com.obric.autogui.agents.vlm.models.impl.b.a r12 = (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
        o.e(r9, SensitiveType.SESSION);
        o.e(r10, "preparation");
        o.e(r12, "requestEnvironment");
        com.obric.autogui.session.b.C0834b r13 = r9.a().E().a();
        if (r13 == null) goto L5;
        String r0 = r13.a();
    L6:
        boolean r2 = false;
        if (r13 == null) goto L20;
        a(r12, r13.a());
        String r5 = r13.b();
        if (o.a(r13.a(), "computer_control_apply_app_permission") == false) goto L19;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L19;
        r12.a("computer_control_apply_app_name", (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(r5), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L19
    L13:
        if (d.o.o.d(r6) == true) goto L16;
        r7 = false;
    L19:
        Loog.INSTANCE.i(TAG, "event=client_risky_operation_applied value=" + r13.a() + " computer_control_apply_app_name=" + r5 + " source=CLIENT");
    L20:
        DisplayedAppInfo r14 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        if (r14 != null) goto L24;
        Loog.INSTANCE.d(TAG, "[Perm-Hp] - skipping as no top app.");
        return;
    L24:
        if (r0 != null) goto L26;
        a(r12, r14);
    L26:
        if (r0 != null) goto L28;
        r2 = true;
    L28:
        a(r9, r12, r14, r2);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final void a(com.obric.autogui.agents.vlm.models.impl.b.a r4, DisplayedAppInfo r5) {
        com.obric.autogui.agents.vlm.models.impl.b.a r6 = (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
        DisplayedAppInfo r7 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r5, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        IAutoActionSecurityApi r0 = AOPlatformTools.INSTANCE.security();
        if (r0 == null) goto L5;
        IAutoActionSecurityApi.PermissionStrategy r1 = r0.acquirePermissionStrategy(r7);
    L7:
        if (r1 != null) goto L10;
        Loog.INSTANCE.d(TAG, "[Perm-Hp-Dangerous] - skipping as no strategy (topApp=" + r7 + ')');
        return;
    L10:
        String r8 = r1.getPermName();
        String r2 = "";
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        a(r6, r8);
        Loog r3 = Loog.INSTANCE;
        StringBuilder r9 = new StringBuilder().append("[Perm-Hp-Dangerous] - marked client_risky_operation=");
        String r10 = r1.getPermName();
        if (r10 == null) goto L17;
        r2 = r10;
    L17:
        r3.d(TAG, r9.append(r2).toString());
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final void a(com.obric.autogui.agents.vlm.b.C0677b r7, com.obric.autogui.agents.vlm.models.impl.b.a r8, DisplayedAppInfo r9, boolean r10) {
        com.obric.autogui.agents.vlm.models.impl.b.a r11 = (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
        ComponentName r12 = ((DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r9, DisplayedAppInfo.class, "com.obric.aiagent.plugin")).getTopActivity();
        if (r12 != null) goto L6;
        Loog.INSTANCE.d(TAG, "[Perm-Hp-Sensitive] - skipping as no top app component.");
        return;
    L6:
        IAutoActionSecurityApi r2 = AOPlatformTools.INSTANCE.security();
        IAutoActionSecurityApi.PageOperationPolicy r3 = null;
        if (r2 == null) goto L9;
        IAutoActionSecurityApi.SensitiveOperation r4 = r2.acquireSensitiveOperation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12);
    L10:
        if (r4 != null) goto L12;
    L17:
        IAutoActionSecurityApi r6 = AOPlatformTools.INSTANCE.security();
        if (r6 == null) goto L20;
        r3 = r6.acquirePageOperationPolicy((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12);
    L20:
        if (r3 == null) goto L23;
        r11.c(r3.getPolicyForModel());
        return;
    L23:
        return;
    L12:
        if (r4.getUserOperateNeeded() == false) goto L16;
        if (r10 == false) goto L15;
        a(r11, "sensitive_execution");
        Loog.INSTANCE.d(TAG, "[Perm-Hp-Sensitive] - marked client_risky_operation=sensitive_execution, operation=" + r4.getOperation());
        goto L17
    L15:
        Loog.INSTANCE.d(TAG, "[Perm-Hp-Sensitive] - keeping client-maintained risky marker, operation=" + r4.getOperation());
        goto L17
    L16:
        Loog.INSTANCE.d(TAG, "[Perm-Hp-Sensitive] - skipping risky marker as user operation is not needed, operation=" + r4.getOperation());
        goto L17
    L9:
        r4 = null;
        goto L10
    }

    private final void a(com.obric.autogui.agents.vlm.models.impl.b.a r2, String r3) {
        ((com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin")).a("client_risky_operation", (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(r3), JsonElement.class, "com.obric.aiagent.plugin"));
    }
}

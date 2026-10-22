package com.obric.autogui.agents.vlm.models.impl.e.c;

import android.content.ComponentName;
import android.content.Context;
import com.obric.autogui.agents.vlm.models.impl.applist.black.g;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.RobotsScreenshotBlockReason;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.o;
import d.x;

/* JADX INFO: compiled from: SecurityPolicyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements e {
    private static final String TAG = "Script-SecurityPolicy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27843a = null;

    /* JADX INFO: compiled from: SecurityPolicyImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SecurityPolicyImpl.kt */
    @d.c.b.a.f(b = "SecurityPolicyImpl.kt", c = {56}, d = "checkExecutionAllowed", e = "com.obric.autogui.agents.vlm.models.impl.script.policy.SecurityPolicyImpl")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f27848e;
        int f;

        b(f r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27848e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27847d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f27848e.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27843a = new a(null);
    }

    public f() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.c.e
    public Object a(Context r9, com.obric.autogui.session.a r10, String r11, d.c.d<? super x> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f & Integer.MIN_VALUE) == 0) goto L7;
        r15.f -= Integer.MIN_VALUE;
    L8:
        Object r8 = r15.f27847d;
        Object r16 = d.c.a.b.a();
        int r0 = r15.f;
        IAutoActionSecurityApi.SuggestedGrantStrategy r1 = null;
        boolean r2 = true;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        ComponentName r17 = (ComponentName) ZeusTransformUtils.preCheckCast(r15.f27846c, ComponentName.class, "com.obric.aiagent.plugin");
        DisplayedAppInfo r18 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r15.f27845b, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        Context r19 = (Context) ZeusTransformUtils.preCheckCast(r15.f27844a, Context.class, "com.obric.aiagent.plugin");
        o.a(r8);
        ComponentName r3 = r17;
        r13 = r19;
    L46:
        AppBlackListState r20 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r8, AppBlackListState.class, "com.obric.aiagent.plugin");
        if (r20 != AppBlackListState.Usable) goto L49;
    L53:
        IAutoActionSecurityApi.SensitiveOperation r21 = AOPlatformTools.INSTANCE.security().acquireSensitiveOperation(r13, r3);
        if (r21 != null) goto L56;
    L58:
        r2 = false;
    L59:
        if (r2 == true) goto L68;
        IAutoActionSecurityApi.PermissionStrategy r22 = AOPlatformTools.INSTANCE.security().acquirePermissionStrategy(r18);
        if (r22 == null) goto L63;
        r1 = r22.getSuggestedGrantStrategy();
    L63:
        if (r1 == null) goto L65;
        Loog.INSTANCE.w(TAG, "security check failed: permission grant needed");
        throw new d("permission grant needed");
    L65:
        return x.f38692a;
    L68:
        Loog.INSTANCE.w(TAG, "security check failed: sensitive operation needs user operate");
        throw new d("sensitive operation needs user operate");
    L56:
        if (r21.getUserOperateNeeded() != true) goto L58;
    L49:
        if (r20 == AppBlackListState.CannotObtain) goto L53;
        Loog.INSTANCE.w(TAG, "security check failed: app in blacklist, state=" + r20);
        throw new d("app in blacklist, state=" + r20);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        DisplayedAppInfo r23 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        if (r23 == null) goto L17;
        r3 = r23.getTopActivity();
        if (r3 == null) goto L21;
        AOOperatingSpace r4 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r4 != null) goto L72;
    L29:
        if (r4 == null) goto L31;
        RobotsScreenshotBlockReason r5 = r4.getRobotsScreenshotBlockReason();     // Catch: Exception -> L25 d -> L27
    L32:
        if (r5 == null) goto L41;
        if (r5 == RobotsScreenshotBlockReason.None) goto L41;
        Loog.INSTANCE.w(TAG, "Early Return: robots policy check failed; blockReason=" + r5 + ", top=" + r3.getPackageName() + '/' + r3.getClassName());     // Catch: Exception -> L25 d -> L27
        throw new d("robots policy check failed");     // Catch: Exception -> L25 d -> L27
    L27:
        e = move-exception;
        throw e;
    L25:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "robots policy check exception", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L41:
        if (AOPlatformTools.INSTANCE.security().acquirePageOperationPolicy(r13, r3) != null) goto L70;
        g r6 = g.f27362a;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r24 = r3.getPackageName();
        d.h.b.o.c(r24, "getPackageName(...)");
        r15.f27844a = r13;
        r15.f27845b = r23;
        r15.f27846c = r3;
        r15.f = 1;
        Object r110 = r6.a(r7, r24, r15);
        if (r110 != r16) goto L45;
        return r16;
    L45:
        r18 = r23;
        r8 = r110;
        goto L46
    L70:
        Loog.INSTANCE.w(TAG, "security check failed: sensitivePage found");
        throw new d("sensitivePage found");
    L31:
        r5 = null;
        goto L32
    L72:
        r4.updateRobotsPolicyCache(r3);     // Catch: Exception -> L25 d -> L27
        goto L29
    L21:
        return x.f38692a;
    L17:
        return x.f38692a;
    L7:
        r15 = new b(this, r14);
        goto L8
    }
}

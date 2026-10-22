package com.obric.autogui.platforms.tools.security;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.securityguardkit.SecurityGuardKitManager;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: SecurityPolicyManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "SecurityPolicyManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30541a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile d f30542c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f30543b;

    /* JADX INFO: compiled from: SecurityPolicyManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final d a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            d r0 = d.c();
            if (r0 == null) goto L5;
            return r0;
        L5:
            monitor-enter(this);
            d r1 = d.c();     // Catch: Throwable -> L12
            if (r1 != null) goto L9;
            r1 = new d(r4, null);     // Catch: Throwable -> L12
        L9:
            a r5 = d.f30541a;     // Catch: Throwable -> L12
            d.a(r1);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r1;
        L12:
            th = move-exception;
            throw th;
        }
    }

    static {
        f30541a = new a(null);
    }

    public /* synthetic */ d(Context r2, h r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private static final String d() {
        return "getPromptRiskType";
    }

    private static final String e() {
        return "inferPromptRiskType";
    }

    /* JADX INFO: renamed from: lambda$DSG4I60SAb-tVBKQDEvrpTARv_Y, reason: not valid java name */
    public static /* synthetic */ String m875lambda$DSG4I60SAbtVBKQDEvrpTARv_Y(String r0, Set r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$Q5JbjQJyLkbOD6YBPYptssXxRUY() {
        return e();
    }

    public static /* synthetic */ String lambda$S3WSOy5rEXc80ShZbwjwb6VcUqw() {
        return d();
    }

    public static /* synthetic */ String lambda$TadCG_b4FOok_MbHrLdA5SJwF5o(String r0, Set r1) {
        return b(r0, r1);
    }

    private d(Context r3) {
        this.f30543b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(d r0) {
        f30542c = r0;
    }

    public static final /* synthetic */ d c() {
        return f30542c;
    }

    public final Context getContext() {
        return this.f30543b;
    }

    public final int a(ComponentName r4) {
        o.e(r4, "vdTopApp");
        c r3 = c.f30540a;
        String r0 = r4.getPackageName();
        o.c(r0, "getPackageName(...)");
        String r1 = r4.getClassName();
        o.c(r1, "getClassName(...)");
        Integer r5 = r3.a(r0, r1, null);
        Loog.INSTANCE.d(TAG, "getActivityRiskType: " + r4 + ", " + r5);
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.intValue();
    }

    public final int a(final String r5) {
        o.e(r5, Params.PROMPT);
        SecurityGuardKitManager r4 = SecurityGuardKitManager.getInstance(this.f30543b);
        if (r4 != null) goto L5;
        return 0;
    L5:
        final Set<String> r6 = r4.findSensitiveCategories(r5);
        Loog.INSTANCE.dp(TAG, new $$Lambda$d$DSG4I60SAbtVBKQDEvrpTARv_Y(r5, r6), $$Lambda$d$S3WSOy5rEXc80ShZbwjwb6VcUqw.INSTANCE);
        if (r6 != null) goto L8;
    L10:
        return 0;
    L8:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L10;
        return 1;
    }

    private static final String a(String r2, Set r3) {
        return "getPromptRiskType: " + r2 + ", " + ((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
    }

    public final void a() {
        SecurityGuardKitManager r0 = SecurityGuardKitManager.getInstance(this.f30543b);
        if (r0 == null) goto L6;
        r0.getSecurityContentModel();
        return;
    }

    public final int b(final String r7) {
        o.e(r7, Params.PROMPT);
        SecurityGuardKitManager r0 = SecurityGuardKitManager.getInstance(this.f30543b);
        if (r0 != null) goto L5;
        return 0;
    L5:
        final Set<String> r1 = r0.inferSensitiveContent(r7);
        Loog.INSTANCE.dp(TAG, new $$Lambda$d$TadCG_b4FOok_MbHrLdA5SJwF5o(r7, r1), $$Lambda$d$Q5JbjQJyLkbOD6YBPYptssXxRUY.INSTANCE);
        boolean r3 = true;
        if (r1 != null) goto L8;
    L10:
        r3 = false;
    L11:
        if (r3 == true) goto L13;
        Loog.INSTANCE.w(TAG, "inferPromptRiskType fail, then try sensitive word");
        return a(r7);
    L13:
        if (o.a(p.e((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")), "security") == true) goto L19;
        return 3;
    L19:
        return 0;
    L8:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L10;
        goto L10
    }

    private static final String b(String r2, Set r3) {
        return "inferPromptRiskType: " + r2 + ", " + ((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
    }

    public final void a(com.bytedance.securityguardkit.settingsevent.b r2) {
        com.bytedance.securityguardkit.settingsevent.b r1 = (com.bytedance.securityguardkit.settingsevent.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.securityguardkit.settingsevent.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        com.bytedance.securityguardkit.settingsevent.a.a().a(r1);
    }

    public final void b() {
        com.bytedance.securityguardkit.settingsevent.a.a().b();
    }

    public final boolean c(String r4) {
        o.e(r4, "pkgName");
        com.bytedance.securityguardkit.settingsevent.a r3 = com.bytedance.securityguardkit.settingsevent.a.a();
        if (r3 == null) goto L5;
        boolean r5 = r3.a(r4);
    L6:
        Loog.INSTANCE.d(TAG, "checkSettingsEvent: " + r4 + ", " + r5);
        return r5;
    L5:
        r5 = false;
        goto L6
    }
}

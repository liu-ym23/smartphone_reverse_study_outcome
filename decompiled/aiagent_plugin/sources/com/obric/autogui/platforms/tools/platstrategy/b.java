package com.obric.autogui.platforms.tools.platstrategy;

import android.content.Context;
import android.content.pm.PackageManager;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.obric.autogui.common.api.platform.strategy.SensitiveOperation;
import com.obric.autogui.common.e;
import com.obric.livecard.api.impl.IslandImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: StandardPlatformStrategies.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b implements IAutoActionPlatformStrategyApi {
    private static final String TAG = "StdPlatStrategies";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f30516b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f30517d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f30518a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f30519c;

    /* JADX INFO: compiled from: StandardPlatformStrategies.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.platstrategy.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardPlatformStrategies.kt */
    public /* synthetic */ class C0821b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30520a = null;

        static {
            int[] r0 = new int[SensitiveOperation.values().length];
            r0[SensitiveOperation.ACCESS_FOR_COARSE_LOCATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SensitiveOperation.ACCESS_FINE_LOCATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SensitiveOperation.ACCESS_FOR_FULL_APP_LIST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f30520a = r0;
        }
    }

    /* JADX INFO: compiled from: StandardPlatformStrategies.kt */
    @f(b = "StandardPlatformStrategies.kt", c = {136}, d = "isGloballyWhitelistedPackage$suspendImpl", e = "com.obric.autogui.platforms.tools.platstrategy.StandardPlatformStrategies")
    static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f30523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30524d;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30523c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30522b = r3;
            this.f30524d |= Integer.MIN_VALUE;
            return b.a(this.f30523c, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi
    public Object isGloballyWhitelistedPackage(Context r3, String r4, Collection<OpenableAppInfo> r5, d.c.d<? super Boolean> r6) {
        return a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public b() {
    }

    static {
        f30516b = new a(null);
        f30517d = ax.a(new String[]{"android", IslandImpl.LIVE_CARD_HOST});
    }

    public final String a(Context r3, SensitiveOperation r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "op");
        int r6 = C0821b.f30520a[r4.ordinal()];
        if (r6 != 1) goto L5;
        return "android.permission.ACCESS_COARSE_LOCATION";
    L5:
        if (r6 != 2) goto L7;
        return "android.permission.ACCESS_FINE_LOCATION";
    L7:
        if (r6 != 3) goto L10;
        return a(r5);
    L10:
        throw new k();
    }

    private final String a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (this.f30518a == true) goto L10;
        boolean r2 = false;
        r7.getPackageManager().getPermissionInfo("com.android.permission.GET_INSTALLED_APPS", 0);     // Catch: PackageManager.NameNotFoundException -> L7
        r2 = true;
    L8:
        this.f30519c = r2;
        this.f30518a = true;
    L7:
        Loog.INSTANCE.e(TAG, "This isn't a CTA-compatible ROM; using QUERY_ALL_PACKAGES permission globally.");
    L10:
        if (this.f30519c == true) goto L16;
        return "android.permission.QUERY_ALL_PACKAGES";
    L16:
        return "com.android.permission.GET_INSTALLED_APPS";
    }

    @Override // com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi
    public IAutoActionPlatformStrategyApi.SensitiveOpStrategy checkSensitiveOp(Context r4, SensitiveOperation r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "op");
        String r3 = a(r6, r5);
        if (r3 == null) goto L13;
        IAutoActionPermissionApi.PermissionCheckResult r7 = AOPlatformTools.INSTANCE.permission().checkPermission(r6, r3);
        if (r7.isGranted() == true) goto L14;
        String r8 = r7.getReason();
        if (r8 != null) goto L11;
        r8 = "Permission " + r3 + " not granted";
    L11:
        return new IAutoActionPlatformStrategyApi.SensitiveOpStrategy(false, 1, r8);
    L14:
        return IAutoActionPlatformStrategyApi.SensitiveOpStrategy.Companion.getALLOWED();
    L13:
        return IAutoActionPlatformStrategyApi.SensitiveOpStrategy.Companion.getALLOWED();
    }

    @Override // com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi
    public e applyForSensitiveOp(Context r3, SensitiveOperation r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "op");
        String r2 = a(r5, r4);
        if (r2 == null) goto L5;
        StandardPermissionAcquiringActivity.Companion.a(r5, r2, null);
        return e.f29014b.a();
    L5:
        return e.f29014b.b();
    }

    static /* synthetic */ Object a(b r8, Context r9, String r10, Collection<OpenableAppInfo> r11, d.c.d<? super Boolean> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.wrapperContextForParams(r11, Collection.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.aiagent.plugin");
        if ((r0.f30524d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30524d -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f30522b;
        Object r17 = d.c.a.b.a();
        int r2 = r0.f30524d;
        boolean r5 = false;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r0.f30521a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L14
    L42:
        r14 = (Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        String r19 = r18;
    L48:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r20, Collection.class) == true) goto L51;
    L53:
        Iterator r21 = r20.iterator();
    L55:
        if (r21.hasNext() == false) goto L59;
        if (o.a(((OpenableAppInfo) ZeusTransformUtils.preCheckCast(r21.next(), OpenableAppInfo.class, "com.obric.aiagent.plugin")).getAppPackageName(), r19) == false) goto L55;
        r5 = true;
    L59:
        boolean r22 = !r5;
        if (r22 == false) goto L63;
        Loog.INSTANCE.i(TAG, "[AuthWL] pkg=" + r19 + " (not in openable apps)");
    L63:
        return d.c.b.a.b.a(r22);
    L51:
        if (((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L53;
    L14:
        Throwable th = th;
    L46:
        Loog.INSTANCE.e(TAG, "getOpenableApps failed; pkg=" + r18 + ", err=" + th, th);
        return d.c.b.a.b.a(false);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r16);
        if (r10 == null) goto L21;
        r19 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L22:
        if (r19 != null) goto L25;
        r19 = "";
    L25:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L29;
        return d.c.b.a.b.a(false);
    L29:
        if (f30517d.contains(r19) == false) goto L33;
        Loog.INSTANCE.i(TAG, "[AuthWL] pkg=" + r19 + " (hardcoded)");
        return d.c.b.a.b.a(true);
    L33:
        if (o.a(r19, "com.obric.feedback") == true) goto L65;
        if (o.a(r19, "com.obric.feedbackserviceproject") == true) goto L65;
        if (r14 != null) goto L48;
        AOPackagesTools r110 = AOPackagesTools.INSTANCE;     // Catch: Throwable -> L44
        r0.f30521a = r19;     // Catch: Throwable -> L44
        r0.f30524d = 1;     // Catch: Throwable -> L44
        Object r23 = r110.getOpenableApps(r13, r0);     // Catch: Throwable -> L44
        if (r23 != r17) goto L41;
        return r17;
    L41:
        r18 = r19;
        r16 = r23;
    L44:
        th = move-exception;
        r18 = r19;
        th = th;
    L65:
        return d.c.b.a.b.a(false);
    L21:
        r19 = null;
    L7:
        r0 = new c(r8, r15);
        goto L8
    }
}

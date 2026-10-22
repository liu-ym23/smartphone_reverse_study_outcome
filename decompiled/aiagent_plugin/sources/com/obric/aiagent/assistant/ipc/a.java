package com.obric.aiagent.assistant.ipc;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import com.obric.aiagent.assistant.idl.IAgentIDL;
import com.obric.aiagent.ipc.control.c;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.IBuildContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;

/* JADX INFO: compiled from: AssistantFeature.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AssistantFeature";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16298a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f16299b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f16300c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f16301d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f16302e = null;
    private static final f f = null;

    public static /* synthetic */ ApplicationInfo lambda$HeORksPQW0VPoeWr8O6qm4jLEkE() {
        return h();
    }

    /* JADX INFO: renamed from: lambda$L5jQf8cguuT4kmSH-KP_XpOaFkY, reason: not valid java name */
    public static /* synthetic */ Intent m151lambda$L5jQf8cguuT4kmSHKP_XpOaFkY() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$LPB6kNpQ0xdLKJz-V0pKFf_Kdrk, reason: not valid java name */
    public static /* synthetic */ Context m152lambda$LPB6kNpQ0xdLKJzV0pKFf_Kdrk() {
        return f();
    }

    public static /* synthetic */ String lambda$Uk35tUAg57Xcds5OHe_k8UTXvDs() {
        return j();
    }

    /* JADX INFO: renamed from: lambda$hjjqK3vH-lfOUKGnoG9S0hEbYkI, reason: not valid java name */
    public static /* synthetic */ Integer m153lambda$hjjqK3vHlfOUKGnoG9S0hEbYkI() {
        return i();
    }

    public final String c() {
        return "pacific";
    }

    private a() {
    }

    static {
        f16298a = new a();
        f16299b = g.a($$Lambda$a$LPB6kNpQ0xdLKJzV0pKFf_Kdrk.INSTANCE);
        f16300c = g.a($$Lambda$a$L5jQf8cguuT4kmSHKP_XpOaFkY.INSTANCE);
        f16301d = g.a($$Lambda$a$HeORksPQW0VPoeWr8O6qm4jLEkE.INSTANCE);
        f16302e = g.a($$Lambda$a$hjjqK3vHlfOUKGnoG9S0hEbYkI.INSTANCE);
        f = g.a($$Lambda$a$Uk35tUAg57Xcds5OHe_k8UTXvDs.INSTANCE);
    }

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(f16299b.b(), Context.class, "com.obric.aiagent.plugin");
    }

    private static final Context f() {
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L13;
        Object r1 = IAIAgentPlatform.Companion.getCommonParams("base");
        o.a(r1, "null cannot be cast to non-null type android.content.Context");
        return (Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.aiagent.plugin");
    L13:
        return (Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin");
    L5:
        r2 = false;
        goto L6
    }

    private final Intent d() {
        return (Intent) ZeusTransformUtils.preCheckCast(f16300c.b(), Intent.class, "com.obric.aiagent.plugin");
    }

    private static final Intent g() {
        return c.f18632b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f16298a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new Intent(IAgentIDL.ACTION_BIND_IPC));
    }

    private final ApplicationInfo e() {
        return (ApplicationInfo) ZeusTransformUtils.preCheckCast(f16301d.b(), ApplicationInfo.class, "com.obric.aiagent.plugin");
    }

    private static final ApplicationInfo h() {
        a r0 = f16298a;
        Intent r1 = r0.d();
        if (r1 == null) goto L7;
        String r2 = r1.getPackage();
        if (r2 == null) goto L7;
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationInfo(r2, 128);
    L7:
        return null;
    }

    private static final Integer i() {
        ApplicationInfo r0 = f16298a.e();
        if (r0 == null) goto L7;
        Bundle r1 = r0.metaData;
        if (r1 == null) goto L7;
        return Integer.valueOf(r1.getInt(IAgentIDL.META_UPDATEVERSION, 0));
    L7:
        return null;
    }

    private static final String j() {
        ApplicationInfo r0 = f16298a.e();
        if (r0 == null) goto L7;
        Bundle r1 = r0.metaData;
        if (r1 == null) goto L7;
        return r1.getString(IAgentIDL.META_PRODUCT, "");
    L7:
        return null;
    }

    public final boolean a() {
        return d.o.o.b(IBuildContext.Companion.getBuildVariant(), "obric", false, 2, null);
    }

    public final String b() {
        if (a() == true) goto L6;
        return null;
    L6:
        String r3 = IBuildContext.Companion.getBuildVariant() + '_' + c() + '_' + Build.MODEL;
        ILogDepend.Companion.d(TAG, "appVariant: " + r3);
        return r3;
    }
}

package com.obric.capabilitykit.entity.memory;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32135a = null;

    static {
        f32135a = new a();
    }

    private a() {
    }

    private final b a(Context r8, String r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        PackageManager r1 = r11.getPackageManager();
        Intent r3 = new Intent(r9);
        boolean r4 = false;
    L11:
        e = e;
        StringBuilder r5 = new StringBuilder();
        String r6 = "No permission to query ";
    L13:
        a("MemoryServiceChecker", r5.append(r6).append(r10).append(" services").toString(), e);
        List<ResolveInfo> r2 = p.b();
    L15:
        if (r2.isEmpty() == false) goto L19;
        a("MemoryServiceChecker", "No " + r10 + " services found for action: " + r9);
        return b.f32137b;
    L19:
        if (r2.isEmpty() == true) goto L37;
        Iterator<T> r7 = r2.iterator();
    L23:
        if (r7.hasNext() == false) goto L37;
        ServiceInfo r12 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r7.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo;
        if (r12 == null) goto L34;
        o.c(r12, "serviceInfo");
        if (PackageUtils.INSTANCE.checkSignature(r12.packageName) == true) goto L29;
        a("MemoryServiceChecker", r10 + " service pkg not trusted: " + r12.packageName);
        goto L34
    L29:
        boolean r13 = com.obric.capabilitykit.common.b.f32043a.a(r11, new ComponentName(r12.packageName, r12.name));
        if (r13 == false) goto L32;
        StringBuilder r14 = new StringBuilder();
        StringBuilder r15 = r14.append(r10);
        String r16 = " service is available: ";
    L33:
        b("MemoryServiceChecker", r15.append(r16).append(r12.packageName).append('/').append(r12.name).toString());
    L35:
        if (r13 == false) goto L23;
        r4 = true;
        goto L37
    L32:
        r14 = new StringBuilder();
        r15 = r14.append(r10);
        r16 = " service is disabled: ";
    L34:
        r13 = false;
    L37:
        if (r4 == false) goto L40;
        return b.f32136a;
    L40:
        return b.f32137b;
    L9:
        e = e;
        r5 = new StringBuilder();
        r6 = "Failed to query ";
        goto L13
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r2 = r1.queryIntentServices(r3, UiType.FLAG_PHONE_CARD);     // Catch: RuntimeException -> L9 SecurityException -> L11
    L7:
        o.c(r2, "{\n            if (Build.…)\n            }\n        }");     // Catch: RuntimeException -> L9 SecurityException -> L11
    L6:
        r2 = r1.queryIntentServices(r3, 0);     // Catch: RuntimeException -> L9 SecurityException -> L11
        goto L7
    }

    public final b a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        return a(r4, "com.obric.memorydata.action.SEARCH_SERVICE", "Search");
    }

    public final b b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        return a(r4, "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE", "GlobalSearch");
    }

    public final b c(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        PackageManager r0 = r7.getPackageManager();
        ProviderInfo r1 = null;
    L13:
        e = e;
        String r2 = "No permission to resolve provider";
    L15:
        a("MemoryServiceChecker", r2, e);
    L16:
        if (r1 != null) goto L20;
        a("MemoryServiceChecker", "No provider found for authority: com.obric.memorydata.personalcontext.EntityProvider");
        return b.f32137b;
    L20:
        if (com.obric.capabilitykit.common.b.f32043a.a(r7, new ComponentName(r1.packageName, r1.name)) == false) goto L22;
        c("MemoryServiceChecker", "Provider is available: " + r1.packageName + '/' + r1.name);
        return b.f32136a;
    L22:
        a("MemoryServiceChecker", "Provider is disabled: " + r1.packageName + '/' + r1.name);
        return b.f32137b;
    L11:
        e = e;
        r2 = "Failed to resolve provider";
        goto L15
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        ProviderInfo r3 = r0.resolveContentProvider("com.obric.memorydata.personalcontext.EntityProvider", 0);     // Catch: RuntimeException -> L11 SecurityException -> L13
    L8:
        r1 = r3;
        goto L16
    L7:
        r3 = r0.resolveContentProvider("com.obric.memorydata.personalcontext.EntityProvider", UiType.FLAG_PHONE_CARD);     // Catch: RuntimeException -> L11 SecurityException -> L13
        goto L8
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}

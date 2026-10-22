package com.obric.aiagent.interaction.impl;

import android.app.ActivityManager;
import android.app.ActivityManagerEx;
import android.app.ActivityTaskManager;
import com.obric.aiagent.interaction.api.IPlatformApi;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.n;
import d.o;
import java.util.List;

/* JADX INFO: compiled from: PlatformApiImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlatformApiImpl implements IPlatformApi {
    public PlatformApiImpl() {
    }

    @Override // com.obric.aiagent.interaction.api.IPlatformApi
    public boolean moveTaskToDisplay(int r11, int r12, boolean r13) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        PlatformApiImpl r3 = (PlatformApiImpl) ZeusTransformUtils.preCheckCast(this, PlatformApiImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(Boolean.valueOf(ObricProductSdk.INSTANCE.platformService().activityManager().moveTaskToDisplay(r11, r12, r13)));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L10;
        ILogDepend.Companion.w("PlatformApiImpl", "product ActivityManager moveTaskToDisplay failed: " + r5.getMessage(), r5);
        boolean r6 = true;
    L12:
        if (n.a(r4) == false) goto L15;
        ILogDepend.Companion.i("PlatformApiImpl", "product ActivityManager moveTaskToDisplay succeed. result: " + ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
    L15:
        if (n.b(r4) == false) goto L17;
        r4 = false;
    L17:
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r6 == true) goto L35;
        return r7;
    L35:
        n.a r8 = n.f38560a;     // Catch: Throwable -> L22
        PlatformApiImpl r10 = (PlatformApiImpl) ZeusTransformUtils.preCheckCast(this, PlatformApiImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        Object r14 = n.f(Boolean.valueOf(ActivityManagerEx.getInstance().moveTaskToDisplay(r11, r12, r13)));     // Catch: Throwable -> L22
    L24:
        Throwable r15 = n.c(r14);
        if (r15 == null) goto L28;
        ILogDepend.Companion.w("PlatformApiImpl", "ActivityManagerEx moveTaskToDisplay failed: " + r15.getMessage(), r15);
    L28:
        if (n.a(r14) == false) goto L31;
        ILogDepend.Companion.i("PlatformApiImpl", "ActivityManagerEx moveTaskToDisplay succeed. result: " + ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
    L31:
        if (n.b(r14) == false) goto L34;
        r14 = false;
    L34:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L22:
        th = move-exception;
        n.a r16 = n.f38560a;
        r14 = n.f(o.a(th));
        goto L24
    L10:
        r6 = false;
    L5:
        th = move-exception;
        n.a r9 = n.f38560a;
        r4 = n.f(o.a(th));
        goto L7
    }

    @Override // com.obric.aiagent.interaction.api.IPlatformApi
    public List<ActivityManager.RunningTaskInfo> getTasks(int r2, boolean r3, boolean r4, int r5) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L7
        List<ActivityManager.RunningTaskInfo> r6 = ActivityTaskManager.getInstance().getTasks(r2, r3, r4, r5);     // Catch: Throwable -> L7
        if (r6 != null) goto L5;
        r6 = p.b();     // Catch: Throwable -> L7
    L5:
        Object r7 = n.f(r6);     // Catch: Throwable -> L7
    L9:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L13;
        ILogDepend.Companion.w("PlatformApiImpl", "getTasks failed: " + r8.getMessage(), r8);
    L13:
        if (n.a(r7) == false) goto L15;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i("PlatformApiImpl", "getTasks succeed.");
    L15:
        List r10 = p.b();
        if (n.b(r7) == false) goto L19;
        r7 = r10;
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        n.a r11 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L9
    }
}

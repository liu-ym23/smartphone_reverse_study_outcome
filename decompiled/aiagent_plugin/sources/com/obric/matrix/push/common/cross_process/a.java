package com.obric.matrix.push.common.cross_process;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.obric.matrix.push.common.cross_process.a.b;
import com.obric.matrix.push.common.cross_process.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: CrossProcessService.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f33758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f33759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, ICrossProcessInterface> f33760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, ServiceConnection> f33761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f33762e;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "mContext");
        this.f33758a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f33759b = "CrossProcessService";
        this.f33760c = new ConcurrentHashMap();
        this.f33761d = new ConcurrentHashMap();
        this.f33762e = new ConcurrentHashMap();
    }

    public static final /* synthetic */ String a(a r0) {
        return r0.f33759b;
    }

    public static final /* synthetic */ void a(a r2, ICrossProcessInterface r3, String r4, ArrayList r5, com.obric.matrix.push.common.cross_process.a.a r6) {
        r2.a((ICrossProcessInterface) ZeusTransformUtils.wrapperContextForParams(r3, ICrossProcessInterface.class, "com.obric.aiagent.plugin"), r4, r5, (com.obric.matrix.push.common.cross_process.a.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.matrix.push.common.cross_process.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ConcurrentHashMap b(a r0) {
        return r0.f33761d;
    }

    public static final /* synthetic */ ConcurrentHashMap c(a r0) {
        return r0.f33760c;
    }

    @Override // com.obric.matrix.push.common.cross_process.a.c
    public void a(b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        o.e(r6, "method");
        com.obric.matrix.push.common.a.c.a(this.f33759b, "register cross process method: " + r6);
        ((Map) ZeusTransformUtils.preCheckCast(this.f33762e, Map.class, "com.obric.aiagent.plugin")).put(r6.a(), r6);
    }

    @Override // com.obric.matrix.push.common.cross_process.a.c
    public void a(String r7, final String r8, final ArrayList<Object> r9, com.obric.matrix.push.common.cross_process.a.a r10) {
        final com.obric.matrix.push.common.cross_process.a.a r11 = (com.obric.matrix.push.common.cross_process.a.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.matrix.push.common.cross_process.a.a.class, "com.obric.aiagent.plugin");
        o.e(r7, "targetPkg");
        o.e(r8, "method");
        com.obric.matrix.push.common.a.c.a(this.f33759b, "try invoke " + r8 + " method");
        ICrossProcessInterface r0 = (ICrossProcessInterface) ZeusTransformUtils.preCheckCast(this.f33760c.get(r7), ICrossProcessInterface.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        com.obric.matrix.push.common.a.c.a(this.f33759b, "binder of  " + r7 + " is not null , invoke internal");
        a(r0, r8, r9, r11);
        x r1 = x.f38692a;
    L6:
        if (r1 != null) goto L9;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        com.obric.matrix.push.common.a.c.a(this.f33759b, "binder of  " + r7 + " is null , bind target service");
        a(r7, false, (ServiceConnection) ZeusTransformUtils.preCheckCast(new CrossProcessService$invoke$2$1(this, r8, r9, r11), ServiceConnection.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.matrix.push.common.cross_process.a.c
    public void a(String r5, String r6, List<Object> r7, ICrossProcessCallbackInterface r8) {
        List<Object> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        ICrossProcessCallbackInterface r10 = (ICrossProcessCallbackInterface) ZeusTransformUtils.wrapperContextForParams(r8, ICrossProcessCallbackInterface.class, "com.obric.aiagent.plugin");
        o.e(r5, "method");
        o.e(r6, "originPkgName");
        com.obric.matrix.push.common.a.c.a(this.f33759b, r5 + " be invoked");
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.f33762e.get(r5), b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r4.a(r6, r9, r10);
        return;
    }

    private final void a(String r5, boolean r6, ServiceConnection r7) {
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r7, ServiceConnection.class, "com.obric.aiagent.plugin");
        Intent r0 = new Intent();
        r0.setPackage(r5);
        r0.setAction(r5 + ".action.CROSS_PROCESS");
        r0.putExtra("origin_package_name", this.f33758a.getPackageName());
        r0.putExtra("is_from_on_bind", r6);
        com.obric.matrix.push.common.a.c.a(this.f33759b, "bind " + r5 + "'s CrossProcessService");
        ZeusTransformUtils.bindService(this.f33758a, r0, r8, 1, "com.obric.aiagent.plugin");
    }

    private final void a(ICrossProcessInterface r6, final String r7, ArrayList<Object> r8, com.obric.matrix.push.common.cross_process.a.a r9) {
        ICrossProcessInterface r10 = (ICrossProcessInterface) ZeusTransformUtils.wrapperContextForParams(r6, ICrossProcessInterface.class, "com.obric.aiagent.plugin");
        final com.obric.matrix.push.common.cross_process.a.a r11 = (com.obric.matrix.push.common.cross_process.a.a) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.matrix.push.common.cross_process.a.a.class, "com.obric.aiagent.plugin");
        com.obric.matrix.push.common.a.c.a(this.f33759b, "invoke " + r7 + " method internal");
        r10.invoke(r7, this.f33758a.getPackageName(), (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), (ICrossProcessCallbackInterface) ZeusTransformUtils.preCheckCast(new CrossProcessService$invokeInternal$1(this, r7, r11), ICrossProcessCallbackInterface.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.push.common.a.c.a(this.f33759b, "invoke " + r7 + " method internal error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        if (r11 == null) goto L12;
        r11.a(null);
        return;
    }
}

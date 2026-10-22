package com.obric.capabilitykit;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.corecommon.BinderExceptionHandlerProxy;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Proxy;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.obric.capabilitykit.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ICapabilityManager f32075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32076c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }
    }

    static {
        f32074a = new a(null);
    }

    public d(ICapabilityManager r7) {
        ICapabilityManager r8 = (ICapabilityManager) ZeusTransformUtils.wrapperContextForParams(r7, ICapabilityManager.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "api");
        Object r1 = Proxy.newProxyInstance(ICapabilityManager.class.getClassLoader(), new Class[]{ICapabilityManager.class}, new BinderExceptionHandlerProxy(r8, "CapabilityManagerClient", ICapabilityManager.class));     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        r8 = (ICapabilityManager) ZeusTransformUtils.preCheckCast(r1, ICapabilityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    L12:
        ICapabilityManager r9 = (ICapabilityManager) ZeusTransformUtils.preCheckCast(r8, ICapabilityManager.class, "com.obric.aiagent.plugin");
        this.f32075b = r9;
        int r10 = r9.getVersion();
        Logger.INSTANCE.i("CapabilityManagerClient", "ICapabilityManager version: " + r10);
        this.f32076c = r10;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilityManager");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Throwable r2 = d.n.c(d.n.f(d.o.a(th)));
        if (r2 == null) goto L12;
        a("CapabilityManagerClient", "BinderExceptionHandlerProxy createProxyInstance for " + r8.getClass() + " fail", r2);
        goto L12
    }

    @Override // com.obric.capabilitykit.a
    public PendingIntent a(long r2, Intent r4, FloatingIntentParams r5) {
        d.h.b.o.e(r4, MemorySourceLinkType.INTENT);
        d.h.b.o.e(r5, "params");
        return this.f32075b.getFloatingPendingIntent(r2, r4, r5);
    }

    @Override // com.obric.capabilitykit.a
    public void a(long r1) {
        this.f32075b.hideIntentResultCard(r1);
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r2, String r3) {
        d.h.b.o.e(r2, "uri");
        d.h.b.o.e(r3, "packageName");
        this.f32075b.requestCloseFile(r3, r2);
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r7, String r8, IUriFileReceiver r9) {
        IUriFileReceiver r10 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r9, IUriFileReceiver.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "uri");
        d.h.b.o.e(r8, "packageName");
        d.h.b.o.e(r10, "requester");
        if (this.f32075b.requestOpenFile(r10, r7, r8) == true) goto L6;
        r10.onSessionReady(new UriFileAccessSession(1, "无权限或无法访问 URI。", null, 4, null));
        return;
    }

    @Override // com.obric.capabilitykit.a
    public void a(ErrorCodeCallback r2) {
        d.h.b.o.e(r2, "listener");
        this.f32075b.registerResultCallback(r2);
    }

    @Override // com.obric.capabilitykit.a
    public void a(IMAppAction r2) {
        d.h.b.o.e(r2, "result");
        this.f32075b.sendActionExecuteResult(com.obric.capabilitykit.common.a.a().toJson(r2));
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult<?> r7, long r8, boolean r10, Map<String, String> r11) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "result");
        this.f32075b.updateIntentResult(r7, r8, r10, r5);
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult<?> r2, IMAppAction r3) {
        d.h.b.o.e(r2, "intentResult");
        d.h.b.o.e(r3, "oldResult");
        this.f32075b.sendIntentExecutionResult(r2, com.obric.capabilitykit.common.a.a().toJson(r3));
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r8, TaskStateInfo r9, TaskStateChangeCallback r10, Long r11) {
        d.h.b.o.e(r8, DbHelper.COL_ID);
        d.h.b.o.e(r9, "stateInfo");
        ICapabilityManager r1 = this.f32075b;
        if (r11 == null) goto L5;
        long r2 = r11.longValue();
    L6:
        r1.requestStateChanged(r8, r9, r10, r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r2, String r3) {
        d.h.b.o.e(r2, "name");
        d.h.b.o.e(r3, "implClassName");
        this.f32075b.unregisterIntent(r2, r3);
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r2, String r3, String r4) {
        d.h.b.o.e(r2, "name");
        d.h.b.o.e(r3, "implClassName");
        this.f32075b.registerIntent(r2, r3, r4);
    }

    @Override // com.obric.capabilitykit.a
    public boolean a() {
        return this.f32075b.isKeyguardReallyLocked();
    }

    @Override // com.obric.capabilitykit.a
    public void b(long r1) {
        this.f32075b.finishFloatingActivity(r1);
    }

    @Override // com.obric.capabilitykit.a
    public void b(ErrorCodeCallback r2) {
        d.h.b.o.e(r2, "listener");
        this.f32075b.unregisterResultCallback(r2);
    }

    @Override // com.obric.capabilitykit.a
    public Boolean c(long r1) {
        return Boolean.valueOf(this.f32075b.isCardViewVisible(r1));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}

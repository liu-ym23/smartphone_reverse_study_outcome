package com.obric.aiagent.apm.impl;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: NpthAttachUserDataImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f16112b;

    /* JADX INFO: compiled from: NpthAttachUserDataImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f16111a = new a(null);
    }

    public d() {
        this.f16112b = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.crash.AttachUserData
    public Map<? extends String, String> getUserData(CrashType r3) {
        o.e(r3, "type");
        b();
        a();
        ILogDepend.Companion.i("NpthAttachUserDataImpl", "getUserData, npthUserData: " + this.f16112b);
        return this.f16112b;
    }

    private final void a() {
        Object r2 = "";
        if (this.f16112b.containsKey("curDeviceId") == true) goto L20;
        Map<String, String> r0 = this.f16112b;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L13
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r4 == null) goto L8;
        String r5 = r4.getFlowDid();     // Catch: Throwable -> L13
    L9:
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        Object r6 = n.f(r5);     // Catch: Throwable -> L13
    L16:
        if (n.b(r6) == false) goto L18;
        r6 = "";
    L18:
        r0.put("curDeviceId", (String) r6);
        goto L20
    L8:
        r5 = null;
    L13:
        th = move-exception;
        n.a r7 = n.f38560a;
        r6 = n.f(d.o.a(th));
    L20:
        if (this.f16112b.containsKey("curUserId") == true) goto L36;
        Map<String, String> r8 = this.f16112b;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L24
        Object r9 = n.f(ITraceDepend.Companion.getUserID());     // Catch: Throwable -> L24
    L27:
        if (n.b(r9) == true) goto L30;
        r2 = r9;
    L30:
        r8.put("curUserId", (String) r2);
        return;
    L24:
        th = move-exception;
        n.a r10 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L27
    }

    private final void b() {
        Map<String, String> r0 = this.f16112b;
        String r1 = Arrays.toString(com.bytedance.librarian.a.a());
        o.c(r1, "toString(...)");
        r0.put("librarian", r1);
        Map<String, String> r2 = this.f16112b;
        ClassLoader r3 = getClass().getClassLoader();
        if (r3 == null) goto L6;
        String r4 = r3.toString();
        if (r4 == null) goto L6;
    L7:
        r2.put("class_loader", r4);
        return;
    L6:
        r4 = "No ClassLoader information";
        goto L7
    }
}

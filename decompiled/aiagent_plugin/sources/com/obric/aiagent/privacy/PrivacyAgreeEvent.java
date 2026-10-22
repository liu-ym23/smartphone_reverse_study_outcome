package com.obric.aiagent.privacy;

import android.content.Intent;
import android.os.Process;
import com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: PrivacyAgreeEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyAgreeEvent implements IAgentIPCLifecycleDispatchSPI {
    private static final a Companion = null;
    private static final String TAG = "PrivacyAgreeEvent";

    /* JADX INFO: compiled from: PrivacyAgreeEvent.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PrivacyAgreeEvent.kt */
    @f(b = "PrivacyAgreeEvent.kt", c = {33}, d = "invokeSuspend", e = "com.obric.aiagent.privacy.PrivacyAgreeEvent$onAppReset$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18761a;

        b(d<? super b> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new b((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18761a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            ILogDepend.Companion.d(PrivacyAgreeEvent.TAG, "onAppReset killProcess");
            Process.killProcess(Process.myPid());
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d r7 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f18761a = 1;
            if (ax.a(2000, r7) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public PrivacyAgreeEvent() {
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onUnbind(String r1, Intent r2) {
        IAgentIPCLifecycleDispatchSPI.a.a(this, r1, r2);
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onBind(String r1, Intent r2) {
        d.h.b.o.e(r1, "pkg");
        d.h.b.o.e(r2, MemorySourceLinkType.INTENT);
        ILogDepend.Companion.i(TAG, "onBind");
        IPrivacyService r0 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.markAgree();
        return;
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onAppReset(String r7, Intent r8) {
        d.h.b.o.e(r7, "pkg");
        d.h.b.o.e(r8, MemorySourceLinkType.INTENT);
        if (d.h.b.o.a(r7, com.obric.aiagent.ipc.a.f18601a.a().a()) == false) goto L9;
        IPrivacyService r6 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L7;
        r6.clearAgree();
    L7:
        i.a(an.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }
}

package com.obric.autogui.agents.vlm.models.omni.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: PrewarmBackend.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: compiled from: PrewarmBackend.kt */
    @d.c.b.a.f(b = "PrewarmBackend.kt", c = {68}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.PrewarmBackend$awaitReady$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super r.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f28319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DisplayOperatingSpace f28320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r.b f28321d;

        a(DisplayOperatingSpace r3, r.b r4, d.c.d<? super a> r5) {
            DisplayOperatingSpace r6 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28320c = r6;
            this.f28321d = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super r.c> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f28320c, this.f28321d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super r.c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28319b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            r.c r2 = (r.c) ZeusTransformUtils.preCheckCast(this.f28318a, r.c.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
        L9:
            if (r2 != null) goto L30;
            if (this.f28320c.isValid() == false) goto L30;
            ce.b(getContext());
            DisplayedAppInfo r13 = this.f28320c.fetchTopDisplayed();
            if (r13 == null) goto L18;
            ComponentName r5 = r13.getTopActivity();
            if (r5 == null) goto L18;
            String r6 = r5.getPackageName();
            if (r6 == null) goto L18;
        L23:
            if (r13 == null) goto L27;
            if (d.h.b.o.a(r6, this.f28321d.a()) == false) goto L27;
            r2 = new r.c(this.f28321d.a(), this.f28321d.b(), SystemClock.elapsedRealtime());
        L27:
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28318a = r2;
            this.f28319b = 1;
            if (ax.a(100, r14) != r0) goto L9;
            return r0;
        L18:
            if (r13 == null) goto L22;
            ComponentName r7 = r13.getRealActivity();
            if (r7 == null) goto L22;
            r6 = r7.getPackageName();
        L22:
            r6 = null;
        L30:
            return r2;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            r2 = null;
            goto L9
        }
    }

    public q() {
    }

    public final Intent a(Context r2, com.obric.autogui.agents.vlm.models.omni.c.a r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r3, "candidate");
        return AOPackagesTools.INSTANCE.getLaunchIntent(r1, r3.b());
    }

    public final r a(Context r5, DisplayOperatingSpace r6, com.obric.autogui.agents.vlm.models.omni.c.a r7, Intent r8) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        DisplayOperatingSpace r9 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r6, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        d.h.b.o.e(r9, "display");
        d.h.b.o.e(r7, "candidate");
        d.h.b.o.e(r8, MemorySourceLinkType.INTENT);
        long r1 = SystemClock.elapsedRealtime();
        if (AOPlatformTools.INSTANCE.packages().startActivity(r4, r8, (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r9, AOOperatingSpace.class, "com.obric.aiagent.plugin")).getOk() == false) goto L6;
        return (r) ZeusTransformUtils.preCheckCast(new r.b(r7.b(), r1), r.class, "com.obric.aiagent.plugin");
    L6:
        return (r) ZeusTransformUtils.preCheckCast(new r.a("open_in_vd_failed"), r.class, "com.obric.aiagent.plugin");
    }

    public final Object a(DisplayOperatingSpace r3, r.b r4, long r5, d.c.d<? super r.c> r7) {
        DisplayOperatingSpace r2 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(r5, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r2, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }
}

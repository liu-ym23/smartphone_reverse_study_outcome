package com.obric.autogui.session.state;

import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.b.h;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: AADebugSessionStateReceiverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AADebugSessionStateReceiverImpl extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31156a = null;

    /* JADX INFO: compiled from: AADebugSessionStateReceiverImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AADebugSessionStateReceiverImpl.kt */
    @d.c.b.a.f(b = "AADebugSessionStateReceiverImpl.kt", c = {71}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AADebugSessionStateReceiverImpl$changeStateTo$1")
    static final class b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f31158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BizStatus f31159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f31160d;

        b(com.obric.autogui.session.a r3, BizStatus r4, String r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31158b = r3;
            this.f31159c = r4;
            this.f31160d = r5;
            super(1, r7);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f31158b, this.f31159c, this.f31160d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31157a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            com.obric.autogui.common.e r8 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            if (r8.g() == true) goto L15;
            Loog.INSTANCE.i("AO-SesS-DbgRcvr", "cannot change state to " + this.f31160d + "; error=" + r8);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.autogui.session.state.b r9 = this.f31158b.m();
            BizStatus r2 = this.f31159c;
            BizStatus.StatusChangedReasonStruct r4 = BizStatus.StatusChangedReasonStruct.Companion.getDEFAULT();
            d.c.d<? super com.obric.autogui.common.e> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31157a = 1;
            r7 = r9.a(r2, r4, r5);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AADebugSessionStateReceiverImpl.kt */
    @d.c.b.a.f(b = "AADebugSessionStateReceiverImpl.kt", c = {191, 195, 198, 201}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AADebugSessionStateReceiverImpl$mockUiEvents$1")
    static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f31163c;

        c(String r3, Intent r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31162b = r3;
            this.f31163c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f31162b, this.f31163c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31161a;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            o.a(r11);
        L43:
            com.obric.autogui.common.e r12 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        L45:
            Loog.INSTANCE.i("AO-SesS-DbgRcvr", "event `" + this.f31162b + "` ret = " + r12);
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            o.a(r11);
        L36:
            r12 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            goto L45
        L12:
            o.a(r11);
        L23:
            r12 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            goto L45
        L13:
            o.a(r11);
        L29:
            r12 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            goto L45
        L14:
            o.a(r11);
            Loog.INSTANCE.i("AO-SesS-DbgRcvr", "event `" + this.f31162b + "` started.");
            String r13 = this.f31162b;
            switch(r13.hashCode()) {
                case 788306567: goto L38;
                case 1084984897: goto L31;
                case 1558243039: goto L25;
                case 1738956837: goto L18;
                default: goto L44;
            };
        L44:
            r12 = null;
            goto L45
        L18:
            if (r13.equals("exitUserAddition") == false) goto L44;
            String r14 = this.f31163c.getStringExtra("value");
            AutoActionAgent r2 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31161a = 2;
            r11 = r2.exitUserAddition(r14, r4);
            if (r11 != r0) goto L23;
            return r0;
        L25:
            if (r13.equals("enterUserAddition") == false) goto L44;
            AutoActionAgent r15 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31161a = 1;
            r11 = r15.enterUserAddition(r3);
            if (r11 != r0) goto L29;
            return r0;
        L31:
            if (r13.equals("enterCallUser") == false) goto L44;
            AutoActionAgent r16 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31161a = 3;
            r11 = r16.enterCallUser(r5);
            if (r11 != r0) goto L36;
            return r0;
        L38:
            if (r13.equals("exitCallUser") == false) goto L44;
            AutoActionAgent r17 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31161a = 4;
            r11 = r17.exitCallUser(r6);
            if (r11 != r0) goto L43;
            return r0;
        }
    }

    static {
        f31156a = new a(null);
    }

    public AADebugSessionStateReceiverImpl() {
    }

    public void onReceive(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        d.h.b.o.e(r4, MemorySourceLinkType.INTENT);
        if (a(r5, r4) == true) goto L6;
        return;
    L6:
        if (d.h.b.o.a(r4.getAction(), "com.obric.autogui.ACTION_CHANGE_STATE_TO") == false) goto L9;
        a(r4);
        return;
    L9:
        if (d.h.b.o.a(r4.getAction(), "com.obric.autogui.ACTION_VD_EVENTS") == false) goto L12;
        b(r4);
        return;
    L12:
        if (d.h.b.o.a(r4.getAction(), "com.obric.autogui.ACTION_QUEUE_EVENTS") == false) goto L15;
        c(r4);
        return;
    L15:
        if (d.h.b.o.a(r4.getAction(), "com.obric.autogui.ACTION_UI_EVENTS") == false) goto L21;
        d(r4);
        return;
    }

    private final void a(Intent r6) {
        String r5 = r6.getStringExtra("state");
        if (r5 != null) goto L22;
        return;
    L22:
        n.a r7 = n.f38560a;     // Catch: Throwable -> L7
        Object r8 = n.f(BizStatus.valueOf(r5));     // Catch: Throwable -> L7
    L10:
        if (n.b(r8) == false) goto L12;
        r8 = null;
    L12:
        BizStatus r9 = (BizStatus) ZeusTransformUtils.preCheckCast(r8, BizStatus.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L16;
        Loog.INSTANCE.e("AO-SesS-DbgRcvr", "invalid state: " + r5);
        return;
    L16:
        com.obric.autogui.session.a r3 = com.obric.autogui.session.c.f30777a.b();
        if (r3 != null) goto L20;
        Loog.INSTANCE.e("AO-SesS-DbgRcvr", "no ongoing session; cannot change state.");
        return;
    L20:
        r3.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r3, r9, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        th = move-exception;
        n.a r0 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L10
    }

    private final void b(Intent r10) {
        String r9 = r10.getStringExtra("event");
        if (r9 != null) goto L5;
        return;
    L5:
        IAutoActionVDListener r0 = (IAutoActionVDListener) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionVDListener.class), IAutoActionVDListener.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        String r1 = r10.getStringExtra("package");
        if (r1 != null) goto L11;
        VDTrackingApp r6 = null;
    L13:
        switch(r9.hashCode()) {
            case -1449843669: goto L51;
            case -1081351763: goto L46;
            case 248191483: goto L41;
            case 248191762: goto L36;
            case 1185242594: goto L30;
            case 1496872434: goto L25;
            case 1546685414: goto L21;
            case 2035327878: goto L16;
            default: goto L68;
        };
    L68:
        return;
    L16:
        if (r9.equals("trackingAppMovedToMdThenVd") == false) goto L69;
        if (r6 == null) goto L55;
        r0.trackingAppMovedToMd(r6);
        r0.trackingAppMovedToVd(r6);
        return;
    L55:
        return;
    L69:
        return;
    L21:
        if (r9.equals("vdOperatingAppChanged") == false) goto L70;
        r0.vdOperatingAppChanged(r6);
        return;
    L70:
        return;
    L25:
        if (r9.equals("appMovedToMdBackground") == false) goto L71;
        if (r1 == null) goto L58;
        r0.appMovedToMdBackground(r1);
        return;
    L58:
        return;
    L71:
        return;
    L30:
        if (r9.equals("moveMdAppToVd") == false) goto L72;
        int r11 = r10.getIntExtra(DBDefinition.TASK_ID, -1);
        if (r11 == (-1)) goto L60;
        Loog.INSTANCE.i("AO-SesS-DbgRcvr", "[moveMdAppToVd] ret=" + AutoActionVirtualDisplay.INSTANCE.bringMdAppToVd(r11));
        return;
    L60:
        return;
    L72:
        return;
    L36:
        if (r9.equals("trackingAppMovedToVd") == false) goto L73;
        if (r6 == null) goto L62;
        r0.trackingAppMovedToVd(r6);
        return;
    L62:
        return;
    L73:
        return;
    L41:
        if (r9.equals("trackingAppMovedToMd") == false) goto L74;
        if (r6 == null) goto L64;
        r0.trackingAppMovedToMd(r6);
        return;
    L64:
        return;
    L74:
        return;
    L46:
        if (r9.equals("trackingAppTerminated") == false) goto L75;
        if (r6 == null) goto L66;
        r0.trackingAppTerminated(r6);
        return;
    L66:
        return;
    L75:
        return;
    L51:
        if (r9.equals("fetchMdTopAppInfo") == false) goto L76;
        Loog.INSTANCE.i("AO-SesS-DbgRcvr", "[fetchMdTopAppInfo] ret=" + IAutoActionVDApi.DefaultImpls.fetchMdTopAppInfo$default((IAutoActionVDApi) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE, IAutoActionVDApi.class, "com.obric.aiagent.plugin"), 0, false, 3, null));
        return;
    L76:
        return;
    L11:
        r6 = new VDTrackingApp(0, null, 3, null);
        r6.setPackageName(r1);
        goto L13
    }

    private final boolean a(Context r2, Intent r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L12;
        if (r1 == null) goto L12;
        if (IAppContext.Companion.isDebug() == true) goto L10;
        Loog.INSTANCE.e("AO-SesS-DbgRcvr", "task-evaluating is only available in debug build.");
        return false;
    L10:
        return true;
    L12:
        return false;
    }

    private final void c(Intent r4) {
        int r3 = r4.getIntExtra("remaining", 0);
        if (r3 >= 0) goto L5;
        return;
    L5:
        boolean r5 = r4.getBooleanExtra("completed", false);
        if (ZeusTransformUtils.instanceOf((IAutoActionRemoteAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionRemoteAgentApi.class), IAutoActionRemoteAgentApi.class, "com.obric.aiagent.plugin"), com.obric.autogui.session.state.a.a.class) == false) goto L9;
        new IAutoActionRemoteAgentApi.QueueStateUpdation(r5, r3);
        return;
    }

    private final void d(Intent r4) {
        String r3 = r4.getStringExtra("event");
        if (r3 != null) goto L5;
        return;
    L5:
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 != null) goto L9;
        Loog.INSTANCE.e("AO-SesS-DbgRcvr", "no ongoing session; cannot mock UI events.");
        return;
    L9:
        r0.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r3, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }
}

package com.obric.autogui.ipc;

import android.content.Context;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskType;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autogui.agents.vlm.models.impl.applist.black.g;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.session.d.i;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.k;
import d.x;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;

/* JADX INFO: compiled from: OpeartorSessionPrecreator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "OpeartorSessionPrecreator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f29126b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f29127c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f29128d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final C0733a f29129e = null;

    /* JADX INFO: renamed from: com.obric.autogui.ipc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpeartorSessionPrecreator.kt */
    public static final class C0733a implements com.obric.assistant.dm.api.statemachine.core.b {
        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(DMState r1) {
            o.e(r1, "status");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r1, State r2, DMEvent r3, Exception r4) {
            o.e(r1, "taskInfo");
            o.e(r2, "currentState");
            o.e(r4, "exception");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r1, State r2, State r3, DMEvent r4) {
            o.e(r1, "taskInfo");
            o.e(r3, "newState");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void b(TaskInfo r1) {
            o.e(r1, "taskInfo");
        }

        C0733a() {
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r2) {
            o.e(r2, "taskInfo");
            if (r2.getTaskType() == TaskType.COMPLEX) goto L5;
            return;
        L5:
            IMMessage r1 = r2.getMessage();
            if (r1 == null) goto L9;
            String r3 = r1.getMessageId();
            if (r3 == null) goto L9;
        L10:
            a.a(a.f29125a, r3, "dialog_state_manager");
            return;
        L9:
            r3 = r2.getQueryId();
            goto L10
        }
    }

    /* JADX INFO: compiled from: OpeartorSessionPrecreator.kt */
    public static final class b implements com.obric.agent.im.d {
        public static /* synthetic */ x lambda$d3GFHEKk_PXqHYir52waA4sfXd0(String r0, r r1) {
            return a(r0, r1);
        }

        @Override // com.obric.agent.im.d
        public void onRegenMessage(IMMessage r1) {
            o.e(r1, "message");
        }

        @Override // com.obric.agent.im.d
        public void onUpdateMessage(IMMessage r1) {
            o.e(r1, "message");
        }

        b() {
        }

        @Override // com.obric.agent.im.d
        public void onInsertMessageList(List<IMMessage> r3) {
            com.obric.agent.im.d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.agent.im.d
        public void onSendMessage(IMMessage r1) {
            o.e(r1, "message");
            a.a(a.f29125a);
        }

        @Override // com.obric.agent.im.d
        public void onReceiveMessage(IMMessage r2) {
            o.e(r2, "message");
            Map<String, String> r1 = r2.getExt();
            if (r1 == null) goto L17;
            final String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get("inner_log_id"), String.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L7;
            return;
        L7:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
            r3 = null;
        L10:
            if (r3 == null) goto L19;
            com.obric.autogui.session.a r4 = com.obric.autogui.session.c.f30777a.b();
            if (r4 != null) goto L15;
            return;
        L15:
            r4.a(new $$Lambda$a$b$d3GFHEKk_PXqHYir52waA4sfXd0(r3));
            return;
        L19:
            return;
        }

        private static final x a(String r1, r r2) {
            o.e(r2, "omniSession");
            r2.a(r1);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: OpeartorSessionPrecreator.kt */
    @f(b = "OpeartorSessionPrecreator.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.ipc.OpeartorSessionPrecreator$preCreateSession$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f29131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f29132c;

        c(String r3, String r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29131b = r3;
            this.f29132c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f29131b, this.f29132c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f29130a != 0) goto L21;
            d.o.a(r8);
            i.a r9 = i.f30907a.a();
            if (ZeusTransformUtils.instanceOf(r9, i.a.C0842a.class) == false) goto L8;
            Loog.INSTANCE.i(a.TAG, "preCreateSession created pending key=" + ((i.a.C0842a) ZeusTransformUtils.preCheckCast(r9, i.a.C0842a.class, "com.obric.aiagent.plugin")).a().a() + ", msgId=" + this.f29131b + ", source=" + this.f29132c);
        L17:
            return x.f38692a;
        L8:
            if (ZeusTransformUtils.instanceOf(r9, i.a.d.class) == false) goto L11;
            Loog.INSTANCE.i(a.TAG, "preCreateSession reused pending key=" + ((i.a.d) ZeusTransformUtils.preCheckCast(r9, i.a.d.class, "com.obric.aiagent.plugin")).a().a() + ", msgId=" + this.f29131b + ", source=" + this.f29132c);
            goto L17
        L11:
            if (ZeusTransformUtils.instanceOf(r9, i.a.b.class) == false) goto L14;
            Loog.INSTANCE.i(a.TAG, "preCreateSession skipped: feature disabled, msgId=" + this.f29131b + ", source=" + this.f29132c);
            goto L17
        L14:
            if (ZeusTransformUtils.instanceOf(r9, i.a.c.class) == false) goto L19;
            Loog.INSTANCE.e(a.TAG, "preCreateSession failed: " + ((i.a.c) ZeusTransformUtils.preCheckCast(r9, i.a.c.class, "com.obric.aiagent.plugin")).a() + ", msgId=" + this.f29131b + ", source=" + this.f29132c);
            goto L17
        L19:
            throw new k();
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OpeartorSessionPrecreator.kt */
    @f(b = "OpeartorSessionPrecreator.kt", c = {95}, d = "invokeSuspend", e = "com.obric.autogui.ipc.OpeartorSessionPrecreator$preloadRes$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29133a;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29133a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            if (com.obric.autogui.common.a.d.f28974a.q() == false) goto L14;
            Loog.INSTANCE.i(a.TAG, "preloadRes");
            g r7 = g.f27362a;
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.c.d<? super Set<String>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29133a = 1;
            if (r7.a(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0) {
        r0.b();
    }

    public static final /* synthetic */ void a(a r0, String r1, String r2) {
        r0.a(r1, r2);
    }

    static {
        f29125a = new a();
        f29126b = new AtomicBoolean(false);
        f29127c = new AtomicBoolean(false);
        f29128d = new b();
        f29129e = new C0733a();
    }

    private final void b() {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new d(null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void a(String r5, String r6) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L13;
        Loog.INSTANCE.w(TAG, "preCreateSession skipped: blank messageId, source=" + r6);
        return;
    L13:
        Loog.INSTANCE.i(TAG, "pre create session start " + r5 + ", source=" + r6);
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new c(r5, r6, null), m.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (d.o.o.d(r4) == true) goto L8;
        r7 = false;
        goto L10
    }

    public final void a() {
        if (f29126b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        c();
        com.obric.agent.im.a.f14573a.a((com.obric.agent.im.d) ZeusTransformUtils.preCheckCast(f29128d, com.obric.agent.im.d.class, "com.obric.aiagent.plugin"));
    }

    private final void c() {
        AtomicBoolean r4 = f29127c;
        if (r4.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        IDialogStateManager r1 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L9;
        r4.set(false);
        Loog.INSTANCE.e(TAG, "registerDMStateListener failed: dialog state manager is null");
        return;
    L9:
        r1.registerDMStateListener((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(f29129e, com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.i(TAG, "register DialogStateManager listener for complex task only");
    }
}

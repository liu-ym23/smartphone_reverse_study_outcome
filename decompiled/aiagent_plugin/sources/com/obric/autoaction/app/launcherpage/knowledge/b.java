package com.obric.autoaction.app.launcherpage.knowledge;

import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.event.task.base.report.k;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.eventkit.g;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: KnowledgeViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends aj {
    private static final String TAG = "KnowledgeViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<String> f23933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x<Boolean> f23934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23936e;

    /* JADX INFO: compiled from: KnowledgeViewModel.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.knowledge.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KnowledgeViewModel.kt */
    @f(b = "KnowledgeViewModel.kt", c = {50, 51}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeViewModel$init$1")
    static final class C0541b extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f23938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f23939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23940d;

        C0541b(b r3, String r4, d.c.d<? super C0541b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23939c = r3;
            this.f23940d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((C0541b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0541b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0541b(this.f23939c, this.f23940d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23938b;
            boolean r3 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            x<Boolean> r8 = (x) ZeusTransformUtils.preCheckCast(this.f23937a, x.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L25:
            r3 = ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            x<Boolean> r10 = r8;
        L26:
            r10.b(d.c.b.a.b.a(r3));
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            x<String> r2 = (x) ZeusTransformUtils.preCheckCast(this.f23937a, x.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L15:
            String r11 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        L17:
            if (r11 != null) goto L19;
            r11 = "";
        L19:
            r2.b(r11);
            r10 = this.f23939c.c();
            ITaskManagerApi r4 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L26;
            String r5 = this.f23940d;
            d.c.d<? super Boolean> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23937a = r10;
            this.f23938b = 2;
            Object r12 = r4.isKnowledgeLearningSwitchOn(r5, r6);
            if (r12 != r0) goto L24;
            return r0;
        L24:
            r9 = r12;
            r8 = r10;
            goto L25
        L10:
            o.a(r9);
            r2 = this.f23939c.b();
            ITaskManagerApi r13 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L16;
            String r7 = this.f23940d;
            d.c.d<? super String> r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23937a = r2;
            this.f23938b = 1;
            r9 = r13.getKnowledge(r7, r14);
            if (r9 != r0) goto L15;
            return r0;
        L16:
            r11 = null;
            goto L17
        }
    }

    /* JADX INFO: compiled from: KnowledgeViewModel.kt */
    @f(b = "KnowledgeViewModel.kt", c = {ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeViewModel$sendKnowledgeAction$2")
    static final class c extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f23942b;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23942b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23942b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23941a;
            boolean r4 = true;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            o.a(r19);
            Object r3 = r19;
        L13:
            g r5 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin");
        L16:
            if (r5 != null) goto L18;
        L20:
            boolean r6 = false;
        L21:
            if (r6 == false) goto L23;
            this.f23942b.b().b("");
        L23:
            k r0 = k.f32860a;
            if (r5 != null) goto L26;
        L28:
            r4 = false;
        L29:
            r0.a(r4);
            return d.x.f38692a;
        L26:
            if (r5.a() != true) goto L28;
        L18:
            if (r5.a() != true) goto L20;
            r6 = true;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r19);
            ITaskManagerApi r7 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            String r8 = b.a(this.f23942b);
            int r9 = b.b(this.f23942b);
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23941a = 1;
            r3 = ITaskManagerApi.b.a(r7, r8, r9, null, "", null, false, null, null, true, r15, 80, null);
            if (r3 != r1) goto L13;
            return r1;
        L14:
            r5 = null;
            goto L16
        }
    }

    /* JADX INFO: compiled from: KnowledgeViewModel.kt */
    @f(b = "KnowledgeViewModel.kt", c = {99}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeViewModel$sendKnowledgeAction$3")
    static final class d extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f23944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.knowledge.a f23945c;

        d(b r3, com.obric.autoaction.app.launcherpage.knowledge.a r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23944b = r3;
            this.f23945c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23944b, this.f23945c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23943a;
            String r5 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L13:
            g r12 = (g) ZeusTransformUtils.preCheckCast(r11, g.class, "com.obric.aiagent.plugin");
        L15:
            Loog r2 = Loog.INSTANCE;
            StringBuilder r3 = new StringBuilder().append("user toggle autoLearn result: taskId=").append(b.a(this.f23944b)).append(", enabled=").append(((com.obric.autoaction.app.launcherpage.knowledge.a.C0540a) ZeusTransformUtils.preCheckCast(this.f23945c, com.obric.autoaction.app.launcherpage.knowledge.a.C0540a.class, "com.obric.aiagent.plugin")).a()).append(", ok=");
            if (r12 == null) goto L18;
            Boolean r4 = d.c.b.a.b.a(r12.a());
        L19:
            StringBuilder r6 = r3.append(r4).append(", msg=");
            if (r12 == null) goto L22;
            r5 = r12.b();
        L22:
            r2.i(b.TAG, r6.append(r5).toString());
            this.f23944b.c().b(d.c.b.a.b.a(((com.obric.autoaction.app.launcherpage.knowledge.a.C0540a) ZeusTransformUtils.preCheckCast(this.f23945c, com.obric.autoaction.app.launcherpage.knowledge.a.C0540a.class, "com.obric.aiagent.plugin")).a()));
            return d.x.f38692a;
        L18:
            r4 = null;
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            Loog.INSTANCE.i(b.TAG, "user toggle autoLearn switch: taskId=" + b.a(this.f23944b) + ", taskType=" + b.b(this.f23944b) + ", enabled=" + ((com.obric.autoaction.app.launcherpage.knowledge.a.C0540a) ZeusTransformUtils.preCheckCast(this.f23945c, com.obric.autoaction.app.launcherpage.knowledge.a.C0540a.class, "com.obric.aiagent.plugin")).a());
            ITaskManagerApi r13 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L14;
            String r7 = b.a(this.f23944b);
            int r8 = b.b(this.f23944b);
            boolean r9 = ((com.obric.autoaction.app.launcherpage.knowledge.a.C0540a) ZeusTransformUtils.preCheckCast(this.f23945c, com.obric.autoaction.app.launcherpage.knowledge.a.C0540a.class, "com.obric.aiagent.plugin")).a();
            d.c.d<? super g> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23943a = 1;
            r11 = r13.setKnowledgeLearningSwitch(r7, r8, r9, r10);
            if (r11 != r0) goto L13;
            return r0;
        L14:
            r12 = null;
            goto L15
        }
    }

    static {
        f23932a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-OrurRv6LnR-sR4Nkwnr34svlM0, reason: not valid java name */
    public static /* synthetic */ d.x m530lambda$OrurRv6LnRsR4Nkwnr34svlM0(d.h.a.a r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$hF4jEb-1j0hahEgzNe0n4O2pYzc, reason: not valid java name */
    public static /* synthetic */ void m531lambda$hF4jEb1j0hahEgzNe0n4O2pYzc(Context r0, d.h.a.a r1) {
        b(r0, r1);
    }

    public static /* synthetic */ d.x lambda$rP4P17EZj_2DFz3PVRvKIbN4QoM(DialogInterface r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$weMYRf5zieowMulkuM0LaBC36RE(b r0) {
        return c(r0);
    }

    public b() {
        this.f23933b = kotlinx.coroutines.b.am.a("");
        this.f23934c = kotlinx.coroutines.b.am.a(true);
        this.f23935d = "";
    }

    public static final /* synthetic */ String a(b r0) {
        return r0.f23935d;
    }

    public static final /* synthetic */ int b(b r0) {
        return r0.f23936e;
    }

    public final x<String> b() {
        return this.f23933b;
    }

    public final x<Boolean> c() {
        return this.f23934c;
    }

    public final void a(String r8, int r9) {
        d.h.b.o.e(r8, DBDefinition.TASK_ID);
        this.f23935d = r8;
        this.f23936e = r9;
        i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new C0541b(this, r8, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(com.obric.autoaction.app.launcherpage.knowledge.a r10) {
        d.h.b.o.e(r10, "action");
        if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.knowledge.a.b.class) == false) goto L11;
        if (((com.obric.autoaction.app.launcherpage.knowledge.a.b) ZeusTransformUtils.preCheckCast(r10, com.obric.autoaction.app.launcherpage.knowledge.a.b.class, "com.obric.aiagent.plugin")).a() == false) goto L9;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((com.obric.autoaction.app.launcherpage.knowledge.a.b) ZeusTransformUtils.preCheckCast(r10, com.obric.autoaction.app.launcherpage.knowledge.a.b.class, "com.obric.aiagent.plugin")).b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        a(r11, new $$Lambda$b$weMYRf5zieowMulkuM0LaBC36RE(this));
        return;
    L19:
        return;
    L9:
        i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.knowledge.a.c.class) == false) goto L14;
        this.f23933b.b(((com.obric.autoaction.app.launcherpage.knowledge.a.c) ZeusTransformUtils.preCheckCast(r10, com.obric.autoaction.app.launcherpage.knowledge.a.c.class, "com.obric.aiagent.plugin")).a());
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.knowledge.a.C0540a.class) == false) goto L18;
        i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L18:
        throw new d.k();
    }

    private static final d.x c(b r4) {
        r4.a((com.obric.autoaction.app.launcherpage.knowledge.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.knowledge.a.b(false, null, 2, null), com.obric.autoaction.app.launcherpage.knowledge.a.class, "com.obric.aiagent.plugin"));
        return d.x.f38692a;
    }

    private final void a(Context r2, d.h.a.a<d.x> r3) {
        final Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        final d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.util.d.a.a(new $$Lambda$b$hF4jEb1j0hahEgzNe0n4O2pYzc(r1, r4));
    }

    private static final void b(Context r7, d.h.a.a r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        final d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.oui.dialog.v2.alert.a r0 = com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a(r9).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_confirm_delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_confirm_delete")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_delete_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_delete_tips")), CharSequence.class, "com.obric.aiagent.plugin")).a().a(true);
        String r2 = r9.getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_delete"));
        d.h.b.o.c(r2, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r11 = r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$b$OrurRv6LnRsR4Nkwnr34svlM0(r10));
        String r12 = r9.getString(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_cancel"));
        d.h.b.o.c(r12, "getString(...)");
        ((OAlertDialog) ZeusTransformUtils.preCheckCast(r11.b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$b$rP4P17EZj_2DFz3PVRvKIbN4QoM.INSTANCE).g(), OAlertDialog.class, "com.obric.aiagent.plugin")).show();
    }

    private static final d.x a(d.h.a.a r1, DialogInterface r2, int r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "dialog");
        r4.invoke();
        r5.dismiss();
        return d.x.f38692a;
    }

    private static final d.x a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "dialog");
        r3.dismiss();
        return d.x.f38692a;
    }
}

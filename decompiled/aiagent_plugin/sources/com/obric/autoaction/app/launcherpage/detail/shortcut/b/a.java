package com.obric.autoaction.app.launcherpage.detail.shortcut.b;

import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.autoaction.app.launcherpage.detail.base.a.c;
import com.obric.autoaction.app.launcherpage.detail.base.h;
import com.obric.autoaction.app.launcherpage.detail.base.j;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.e;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ShortcutDetailViewModelV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autoaction.app.launcherpage.detail.base.b.a<ShortcutTask, ShortcutTaskSpec> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AssistRemoteCardUIParams f23521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23522c;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.shortcut.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShortcutDetailViewModelV2.kt */
    @f(b = "ShortcutDetailViewModelV2.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.viewmodel.ShortcutDetailViewModelV2$onSaveSuccess$1$1")
    static final class C0521a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AssistRemoteCardUIParams f23524b;

        C0521a(AssistRemoteCardUIParams r3, d<? super C0521a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f23524b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0521a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0521a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0521a(this.f23524b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            b.a();
            if (this.f23523a != 0) goto L10;
            o.a(r3);
            IAutoActionPresentationApi r4 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L8;
            r4.notifyAssistCardUpdate(this.f23524b);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ EventTask a(h r3, EventTask r4) {
        return (EventTask) ZeusTransformUtils.preCheckCast(a((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"), (ShortcutTask) ZeusTransformUtils.preCheckCast(r4, ShortcutTask.class, "com.obric.aiagent.plugin")), EventTask.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ EventTaskSpec a(EventTask r3, boolean r4) {
        return (EventTaskSpec) ZeusTransformUtils.preCheckCast(a((ShortcutTask) ZeusTransformUtils.preCheckCast(r3, ShortcutTask.class, "com.obric.aiagent.plugin"), r4), EventTaskSpec.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ void a(EventTask r11, EventTask r12, boolean r13, int r14, String r15, long r16) {
        a((ShortcutTask) ZeusTransformUtils.preCheckCast(r11, ShortcutTask.class, "com.obric.aiagent.plugin"), (ShortcutTask) ZeusTransformUtils.preCheckCast(r12, ShortcutTask.class, "com.obric.aiagent.plugin"), r13, r14, r15, r16);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ void a(EventTask r3, boolean r4, EventTaskResult r5) {
        a((ShortcutTask) ZeusTransformUtils.preCheckCast(r3, ShortcutTask.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ boolean a(EventTask r3) {
        return c((ShortcutTask) ZeusTransformUtils.preCheckCast(r3, ShortcutTask.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ boolean a(EventTask r3, EventTask r4) {
        return a((ShortcutTask) ZeusTransformUtils.preCheckCast(r3, ShortcutTask.class, "com.obric.aiagent.plugin"), (ShortcutTask) ZeusTransformUtils.preCheckCast(r4, ShortcutTask.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ EventTask d(EventTask r3) {
        return (EventTask) ZeusTransformUtils.preCheckCast(a((ShortcutTask) ZeusTransformUtils.preCheckCast(r3, ShortcutTask.class, "com.obric.aiagent.plugin")), EventTask.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ String e(EventTask r3) {
        return b((ShortcutTask) ZeusTransformUtils.preCheckCast(r3, ShortcutTask.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(com.obric.autoaction.app.launcherpage.detail.base.a.b r3, com.obric.autoaction.app.launcherpage.detail.base.a.a r4, int r5, d.h.b.h r6) {
        com.obric.autoaction.app.launcherpage.detail.base.a.b r7 = (com.obric.autoaction.app.launcherpage.detail.base.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        c r1 = null;
        Object[] r2 = 0 == true ? 1 : 0;
        r7 = (com.obric.autoaction.app.launcherpage.detail.base.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.shortcut.a.a(r1, r2, 3, 0 == true ? 1 : 0), com.obric.autoaction.app.launcherpage.detail.base.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = new com.obric.autoaction.app.launcherpage.detail.base.a.a();
    L8:
        this(r7, r4);
    }

    public a(com.obric.autoaction.app.launcherpage.detail.base.a.b<ShortcutTask, ShortcutTaskSpec> r3, com.obric.autoaction.app.launcherpage.detail.base.a.a r4) {
        com.obric.autoaction.app.launcherpage.detail.base.a.b r5 = (com.obric.autoaction.app.launcherpage.detail.base.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "repository");
        d.h.b.o.e(r4, "reporter");
        super(r5, r4);
        this.f23522c = true;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public boolean s() {
        return this.f23522c;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public void a(AssistRemoteCardUIParams r1) {
        this.f23521b = r1;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public Object a(EventTask r8, String r9, d<? super ShortcutTask> r10) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ShortcutTask.class) == false) goto L5;
        ShortcutTask r11 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r8, ShortcutTask.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 == null) goto L8;
        String r12 = e.a(r11, r9);
    L9:
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        if (ZeusTransformUtils.instanceOf(r8, ShortcutTask.class) == false) goto L14;
        ShortcutTask r1 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r8, ShortcutTask.class, "com.obric.aiagent.plugin");
    L15:
        boolean r13 = false;
        if (r1 == null) goto L27;
        ShortcutTask r14 = e.a(r1, r12, null, false, 6, null);
        if (r14 == null) goto L27;
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getOmniModel(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L22;
    L23:
        r13 = true;
    L24:
        if (r13 == false) goto L28;
        r14.setOmniModel(IOmniModelService.Companion.a().eventTaskDefaultDisplayModel());
        return r14;
    L28:
        return r14;
    L22:
        if (d.o.o.d(r15) == false) goto L24;
    L27:
        return e.a(r12, 0, 2, null);
    L14:
        r1 = null;
        goto L15
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    public ShortcutTask a(ShortcutTask r7) {
        d.h.b.o.e(r7, "task");
        return e.a(r7, null, null, false, 7, null);
    }

    public String b(ShortcutTask r2) {
        d.h.b.o.e(r2, "task");
        return e.a(r2, null, 1, null);
    }

    public boolean c(ShortcutTask r3) {
        d.h.b.o.e(r3, "draft");
        return !d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(e.a(r3, null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public ShortcutTask a(h r8, ShortcutTask r9) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "action");
        d.h.b.o.e(r9, "current");
        if (ZeusTransformUtils.instanceOf(r7, j.h.class) == false) goto L6;
        return e.a(r9, ((j.h) ZeusTransformUtils.preCheckCast(r7, j.h.class, "com.obric.aiagent.plugin")).a(), null, false, 6, null);
    L6:
        if (ZeusTransformUtils.instanceOf(r7, j.C0509j.class) == false) goto L9;
        return e.a(r9, null, ((j.C0509j) ZeusTransformUtils.preCheckCast(r7, j.C0509j.class, "com.obric.aiagent.plugin")).a(), ((j.C0509j) ZeusTransformUtils.preCheckCast(r7, j.C0509j.class, "com.obric.aiagent.plugin")).b(), 1, null);
    L9:
        if (ZeusTransformUtils.instanceOf(r7, j.g.class) == false) goto L11;
        ShortcutTask r10 = e.a(r9, null, null, false, 7, null);
        r10.setOmniModel(((j.g) ZeusTransformUtils.preCheckCast(r7, j.g.class, "com.obric.aiagent.plugin")).a());
        return r10;
    L11:
        return null;
    }

    public ShortcutTaskSpec a(ShortcutTask r1, boolean r2) {
        d.h.b.o.e(r1, "draft");
        return e.a(r1);
    }

    public boolean a(ShortcutTask r3, ShortcutTask r4) {
        d.h.b.o.e(r3, "initial");
        d.h.b.o.e(r4, "current");
        if (d.h.b.o.a(e.a(r3, null, 1, null), e.a(r4, null, 1, null)) == true) goto L5;
        return true;
    L5:
        if (d.h.b.o.a(r3.getShortInstruct(), r4.getShortInstruct()) == true) goto L7;
        return true;
    L7:
        if (r3.isShortInstructEnable() == r4.isShortInstructEnable()) goto L9;
        return true;
    L9:
        if (d.h.b.o.a(r3.getOmniModel(), r4.getOmniModel()) == false) goto L16;
        return false;
    L16:
        return true;
    }

    public void a(ShortcutTask r7, boolean r8, EventTaskResult r9) {
        if (r8 == true) goto L4;
        return;
    L4:
        if (com.obric.autoaction.app.launcherpage.detail.base.e.a(r9) == false) goto L10;
        AssistRemoteCardUIParams r10 = this.f23521b;
        if (r10 == null) goto L11;
        i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new C0521a(r10, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    L11:
        return;
    }

    public void a(ShortcutTask r14, ShortcutTask r15, boolean r16, int r17, String r18, long r19) {
        d.h.b.o.e(r14, "current");
        com.obric.autoaction.app.launcherpage.detail.base.a.a r1 = c();
        String r4 = h();
        String r6 = i();
        EventTask r0 = m();
        if (r0 == null) goto L5;
        String r2 = r0.getTemplateId();
    L6:
        r1.a(r14, r15, r4, r16, r6, r17, r18, r19, r2, u());
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final String u() {
        if (d.h.b.o.a(i(), "enter_from_discovery_add_instruct") == true) goto L5;
        return null;
    L5:
        EventTask r0 = m();
        if (ZeusTransformUtils.instanceOf(r0, ShortcutTask.class) == false) goto L8;
        ShortcutTask r1 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r0, ShortcutTask.class, "com.obric.aiagent.plugin");
    L9:
        if (r1 != null) goto L11;
        return null;
    L11:
        String r4 = e.a(r1, i());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        return null;
    L17:
        return r4;
    L14:
        r2 = false;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public void a(String r1, Integer r2) {
        c().b(r1, r2);
    }
}

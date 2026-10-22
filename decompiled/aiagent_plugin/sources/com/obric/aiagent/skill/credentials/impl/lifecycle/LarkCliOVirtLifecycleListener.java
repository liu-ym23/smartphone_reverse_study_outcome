package com.obric.aiagent.skill.credentials.impl.lifecycle;

import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.h;
import d.n;
import d.o;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LarkCliOVirtLifecycleListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LarkCliOVirtLifecycleListener implements OVirtLifecycleListener {
    private static final a Companion = null;

    @Deprecated
    public static final String LARK_CLI_AUTH_GUIDANCE = "当前 lark-cli 未登录；如要继续，需执行 Office_LarkCLICheckLogin 来检查登录状态，并使用 Office_LarkCLIEnsureAuth 来请求用户登录。";

    @Deprecated
    public static final String LISTENER_ID = "lark-cli-sidecar-session";

    @Deprecated
    public static final String SIDECAR_BLOCKED_MARKER = "blocked by sidecar";
    private final String id;

    /* JADX INFO: compiled from: LarkCliOVirtLifecycleListener.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LarkCliOVirtLifecycleListener.kt */
    @f(b = "LarkCliOVirtLifecycleListener.kt", c = {30}, d = "beforeShellStart-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.lifecycle.LarkCliOVirtLifecycleListener")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LarkCliOVirtLifecycleListener f19082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19083c;

        b(LarkCliOVirtLifecycleListener r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19082b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19081a = r3;
            this.f19083c |= Integer.MIN_VALUE;
            Object r2 = this.f19082b.mo251beforeShellStartgIAlus(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: LarkCliOVirtLifecycleListener.kt */
    @f(b = "LarkCliOVirtLifecycleListener.kt", c = {21}, d = "onSkillLoaded-BWLJW6A", e = "com.obric.aiagent.skill.credentials.impl.lifecycle.LarkCliOVirtLifecycleListener")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LarkCliOVirtLifecycleListener f19085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19086c;

        c(LarkCliOVirtLifecycleListener r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19085b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19084a = r3;
            this.f19086c |= Integer.MIN_VALUE;
            Object r2 = this.f19085b.mo252onSkillLoadedBWLJW6A(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: LarkCliOVirtLifecycleListener.kt */
    @f(b = "LarkCliOVirtLifecycleListener.kt", c = {46}, d = "onTaskClosing-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.lifecycle.LarkCliOVirtLifecycleListener")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LarkCliOVirtLifecycleListener f19088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19089c;

        d(LarkCliOVirtLifecycleListener r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19088b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19087a = r3;
            this.f19089c |= Integer.MIN_VALUE;
            Object r2 = this.f19088b.mo253onTaskClosinggIAlus(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    static {
        Companion = new a(null);
    }

    public LarkCliOVirtLifecycleListener() {
        this.id = LISTENER_ID;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener
    public String getId() {
        return this.id;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener
    /* JADX INFO: renamed from: onSkillLoaded-BWLJW6A, reason: not valid java name */
    public Object mo252onSkillLoadedBWLJW6A(String r4, String r5, List<String> r6, d.c.d<? super n<x>> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r10.f19086c & Integer.MIN_VALUE) == 0) goto L7;
        r10.f19086c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r10.f19084a;
        Object r0 = d.c.a.b.a();
        int r1 = r10.f19086c;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        o.a(r11);
        return ((n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        if (r8.contains("lark-cli") == true) goto L18;
        n.a r3 = n.f38560a;
        return n.f(x.f38692a);
    L18:
        ISkillCredentialService.e r12 = credentialService().getTaskSessions();
        com.obric.aiagent.skill.credentials.api.f r13 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r10.f19086c = 1;
        Object r14 = r12.a(r13, "lark-cli", r10);
        if (r14 != r0) goto L22;
        return r0;
    L22:
        return r14;
    L7:
        r10 = new c(this, r9);
        goto L8
    }

    @Override // com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener
    /* JADX INFO: renamed from: beforeShellStart-gIAlu-s, reason: not valid java name */
    public Object mo251beforeShellStartgIAlus(String r6, d.c.d<? super n<? extends Map<String, String>>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f19083c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19083c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f19081a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19083c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r9);
        return ((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        ISkillCredentialService.e r5 = credentialService().getTaskSessions();
        r0.f19083c = 1;
        Object r10 = r5.a(r6, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new b(this, r8);
        goto L8
    }

    @Override // com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener
    /* JADX INFO: renamed from: afterShellReturn-gIAlu-s, reason: not valid java name */
    public Object mo250afterShellReturngIAlus(com.obric.aiagent.skill.ovirt.api.b.b.a r7, d.c.d<? super n<com.obric.aiagent.skill.ovirt.api.b.b.a>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.api.b.b.c r10 = r7.a();
        Integer r0 = r10.g();
        if (r0 == null) goto L8;
        if (r0.intValue() != 0) goto L8;
    L16:
        n.a r6 = n.f38560a;
        return n.f(r7);
    L8:
        if (isLarkCliCommand(r10.c()) == false) goto L16;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r10.e(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(SIDECAR_BLOCKED_MARKER, CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L14;
        n.a r11 = n.f38560a;
        return n.f(r7);
    L14:
        n.a r12 = n.f38560a;
        return n.f(com.obric.aiagent.skill.ovirt.api.b.b.a.a(r7, null, null, LARK_CLI_AUTH_GUIDANCE, 3, null));
    }

    @Override // com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener
    /* JADX INFO: renamed from: onTaskClosing-gIAlu-s, reason: not valid java name */
    public Object mo253onTaskClosinggIAlus(String r6, d.c.d<? super n<x>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");
        if ((r0.f19089c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19089c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f19087a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19089c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r9);
        return ((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        ISkillCredentialService.e r5 = credentialService().getTaskSessions();
        r0.f19089c = 1;
        Object r10 = r5.b(r6, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new d(this, r8);
        goto L8
    }

    private final ISkillCredentialService credentialService() {
        ISkillCredentialService r1 = ISkillCredentialService.Companion.a();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("ISkillCredentialService is unavailable.".toString());
    }

    private final boolean isLarkCliCommand(String r4) {
        String r3 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return false;
    L5:
        int r5 = r3.length();
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L12;
        if ((!d.o.a.a(r3.charAt(r1))) == false) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        r3 = r3.substring(0, r1);
        d.h.b.o.c(r3, "substring(...)");
    L12:
        return d.h.b.o.a(d.o.o.a(r3, new char[]{'\"', '\''}), "lark-cli");
    }
}

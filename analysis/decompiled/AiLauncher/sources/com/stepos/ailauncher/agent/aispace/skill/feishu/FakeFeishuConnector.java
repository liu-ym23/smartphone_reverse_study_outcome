package com.stepos.ailauncher.agent.aispace.skill.feishu;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b;
import com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository;
import com.stepos.ailauncher.agent.aispace.skill.feishu.o0;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.utils.C3197a;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0096@¢\u0006\u0004\b\u0015\u0010\u0011J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096@¢\u0006\u0004\b\u0017\u0010\u0014J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0096@¢\u0006\u0004\b\u0019\u0010\u0014J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0096@¢\u0006\u0004\b\u001a\u0010\u0014J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0096@¢\u0006\u0004\b\u001d\u0010\u0014J!\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0004\b&\u0010\u0014J<\u0010+\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0082@¢\u0006\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FakeFeishuConnector;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", "<init>", "()V", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "", "serverStatus", "", "n", "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/n0;", "LY8/t;", "onProgress", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/l;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Le9/c;)Ljava/lang/Object;", "e", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/a;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;", "f", "c", "", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;", "stage", "failReason", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$h;", "k", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;Ljava/lang/String;)Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;)Ljava/lang/String;", "l", "", "stepBase", "title", "subtitle", "m", "(ILjava/lang/String;Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FakeFeishuConnector implements h0 {
    private volatile AbstractC2306b state = AbstractC2306b.i.INSTANCE;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FailStage.values().length];
            try {
                iArr[FailStage.Install.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FailStage.CreateBot.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FailStage.Authorize.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FailStage.Review.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.stepos.ailauncher.agent.aispace.skill.feishu.h0
    /* renamed from: a, reason: from getter */
    public AbstractC2306b getState() {
        return this.state;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.aispace.skill.feishu.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.aispace.skill.feishu.AuthorizeLaunch> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchAuthorizeUrl$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchAuthorizeUrl$1 r0 = (com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchAuthorizeUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchAuthorizeUrl$1 r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchAuthorizeUrl$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.l(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            r4 = 0
            if (r5 == 0) goto L49
            com.stepos.ailauncher.agent.aispace.skill.feishu.a r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.a
            r1 = 2
            r0.<init>(r5, r4, r1, r4)
            return r0
        L49:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector.b(e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.agent.aispace.skill.feishu.h0
    public Object c(InterfaceC4014c<? super o0<AbstractC2306b>> interfaceC4014c) {
        FeishuCliRepository.G(FeishuCliRepository.INSTANCE, null, null, 3, null);
        AbstractC2306b abstractC2306b = this.state;
        if (!(abstractC2306b instanceof AbstractC2306b.Connected) && !(abstractC2306b instanceof AbstractC2306b.Failed)) {
            return new o0.Continue(null);
        }
        return new o0.Done(abstractC2306b);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.stepos.ailauncher.agent.aispace.skill.feishu.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.agent.aispace.skill.feishu.RecommendedTask>> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector.d(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.ailauncher.agent.aispace.skill.feishu.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(p9.InterfaceC5074l<? super com.stepos.ailauncher.agent.aispace.skill.feishu.InstallProgress, Y8.t> r8, e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startCreateBot$1
            if (r0 == 0) goto L14
            r0 = r9
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startCreateBot$1 r0 = (com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startCreateBot$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startCreateBot$1 r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startCreateBot$1
            r0.<init>(r7, r9)
            goto L12
        L1a:
            java.lang.Object r9 = r6.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r8 = r6.L$0
            p9.l r8 = (p9.InterfaceC5074l) r8
            kotlin.C4849c.b(r9)
            r1 = r7
            goto L75
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.C4849c.b(r9)
            com.stepos.ailauncher.agent.aispace.skill.feishu.b$g r9 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.g.INSTANCE
            r7.state = r9
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository r9 = com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository.INSTANCE
            r1 = 0
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository.i(r9, r1, r2, r1)
            com.stepos.ailauncher.common.utils.a r9 = com.stepos.ailauncher.common.utils.C3197a.INSTANCE
            android.app.Application r1 = r9.a()
            int r3 = com.stepos.ailauncher.agent.R$string.feishu_cli_progress_creating_bot_title
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.p.h(r3, r1)
            android.app.Application r9 = r9.a()
            int r4 = com.stepos.ailauncher.agent.R$string.feishu_cli_progress_creating_bot_subtitle
            java.lang.String r4 = r9.getString(r4)
            kotlin.jvm.internal.p.h(r4, r1)
            java.lang.Object r9 = g9.h.a(r8)
            r6.L$0 = r9
            r6.label = r2
            r2 = 1
            r1 = r7
            r5 = r8
            java.lang.Object r7 = r1.m(r2, r3, r4, r5, r6)
            if (r7 != r0) goto L75
            return r0
        L75:
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.j r7 = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE
            Xa.t r7 = r7.i()
            java.lang.Object r7 = r7.getValue()
            java.lang.String r8 = "awaiting_authorize"
            boolean r7 = kotlin.jvm.internal.p.d(r7, r8)
            if (r7 == 0) goto L8a
            com.stepos.ailauncher.agent.aispace.skill.feishu.b$b r7 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.C0262b.INSTANCE
            goto L8c
        L8a:
            com.stepos.ailauncher.agent.aispace.skill.feishu.b$g r7 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.g.INSTANCE
        L8c:
            r1.state = r7
            com.stepos.ailauncher.agent.aispace.skill.feishu.b r7 = r1.state
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector.e(p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.aispace.skill.feishu.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.aispace.skill.feishu.o0<com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b>> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$pollAuthorizeStatus$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$pollAuthorizeStatus$1 r0 = (com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$pollAuthorizeStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$pollAuthorizeStatus$1 r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$pollAuthorizeStatus$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository r5 = com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository.INSTANCE
            r2 = 0
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository.i(r5, r2, r3, r2)
            r0.label = r3
            r2 = 200(0xc8, double:9.9E-322)
            java.lang.Object r5 = Ua.U.a(r2, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            com.stepos.ailauncher.agent.aispace.skill.feishu.b$m r5 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.m.INSTANCE
            r4.state = r5
            com.stepos.ailauncher.agent.aispace.skill.feishu.o0$b r5 = new com.stepos.ailauncher.agent.aispace.skill.feishu.o0$b
            com.stepos.ailauncher.agent.aispace.skill.feishu.b r4 = r4.state
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector.f(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.ailauncher.agent.aispace.skill.feishu.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(p9.InterfaceC5074l<? super com.stepos.ailauncher.agent.aispace.skill.feishu.InstallProgress, Y8.t> r8, e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startInstall$1
            if (r0 == 0) goto L14
            r0 = r9
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startInstall$1 r0 = (com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startInstall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startInstall$1 r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$startInstall$1
            r0.<init>(r7, r9)
            goto L12
        L1a:
            java.lang.Object r9 = r6.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r8 = r6.L$0
            p9.l r8 = (p9.InterfaceC5074l) r8
            kotlin.C4849c.b(r9)
            r1 = r7
            goto L75
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.C4849c.b(r9)
            com.stepos.ailauncher.agent.aispace.skill.feishu.b$l r9 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.l.INSTANCE
            r7.state = r9
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository r9 = com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository.INSTANCE
            r1 = 0
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository.E(r9, r1, r2, r1)
            com.stepos.ailauncher.common.utils.a r9 = com.stepos.ailauncher.common.utils.C3197a.INSTANCE
            android.app.Application r1 = r9.a()
            int r3 = com.stepos.ailauncher.agent.R$string.feishu_cli_progress_installing_title
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.p.h(r3, r1)
            android.app.Application r9 = r9.a()
            int r4 = com.stepos.ailauncher.agent.R$string.feishu_cli_progress_installing_subtitle
            java.lang.String r4 = r9.getString(r4)
            kotlin.jvm.internal.p.h(r4, r1)
            java.lang.Object r9 = g9.h.a(r8)
            r6.L$0 = r9
            r6.label = r2
            r2 = 0
            r1 = r7
            r5 = r8
            java.lang.Object r7 = r1.m(r2, r3, r4, r5, r6)
            if (r7 != r0) goto L75
            return r0
        L75:
            com.stepos.ailauncher.agent.aispace.skill.feishu.b r7 = r1.state
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector.g(p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.aispace.skill.feishu.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.aispace.skill.feishu.CreateBotLaunch> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchCreateBotUrl$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchCreateBotUrl$1 r0 = (com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchCreateBotUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchCreateBotUrl$1 r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$fetchCreateBotUrl$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.l(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            r4 = 0
            if (r5 == 0) goto L49
            com.stepos.ailauncher.agent.aispace.skill.feishu.c r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.c
            r1 = 2
            r0.<init>(r5, r4, r1, r4)
            return r0
        L49:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector.h(e9.c):java.lang.Object");
    }

    public final String j(FailStage stage) {
        int i10 = a.$EnumSwitchMapping$0[stage.ordinal()];
        if (i10 == 1) {
            String string = C3197a.INSTANCE.a().getString(R$string.feishu_cli_fail_install_short);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        if (i10 == 2) {
            String string2 = C3197a.INSTANCE.a().getString(R$string.feishu_cli_fail_create_bot_short);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return string2;
        }
        if (i10 == 3) {
            String string3 = C3197a.INSTANCE.a().getString(R$string.feishu_cli_fail_authorize_short);
            kotlin.jvm.internal.p.h(string3, "getString(...)");
            return string3;
        }
        if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        String string4 = C3197a.INSTANCE.a().getString(R$string.feishu_cli_fail_review_short);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        return string4;
    }

    public final AbstractC2306b.Failed k(FailStage stage, String failReason) {
        return new AbstractC2306b.Failed((failReason == null || kotlin.jvm.internal.p.d(failReason, "")) ? j(stage) : failReason, stage, (failReason == null || !La.H.g0(failReason, "timeout", false, 2, null)) ? FailKind.Failed : FailKind.Timeout, failReason);
    }

    public final Object l(InterfaceC4014c<? super String> interfaceC4014c) {
        String value = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.g().getValue();
        if (value != null && !La.H.x0(value)) {
            return value;
        }
        FeishuCliRepository.G(FeishuCliRepository.INSTANCE, null, null, 3, null);
        return TimeoutKt.e(4000L, new FakeFeishuConnector$fetchNextActionUrl$2(null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006c -> B:20:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(int r10, java.lang.String r11, java.lang.String r12, p9.InterfaceC5074l<? super com.stepos.ailauncher.agent.aispace.skill.feishu.InstallProgress, Y8.t> r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$runProgress$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$runProgress$1 r0 = (com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$runProgress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$runProgress$1 r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector$runProgress$1
            r0.<init>(r9, r14)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r14 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L45
            if (r1 != r2) goto L3d
            int r10 = r0.I$1
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$2
            p9.l r12 = (p9.InterfaceC5074l) r12
            java.lang.Object r13 = r0.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r1 = r0.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.C4849c.b(r9)
            r4 = r11
            r7 = r13
            r6 = r1
            r13 = r12
            goto L6f
        L3d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L45:
            kotlin.C4849c.b(r9)
            r9 = 0
            r4 = r10
            r6 = r11
            r7 = r12
            r10 = r9
        L4d:
            r9 = 4
            if (r10 >= r9) goto L71
            com.stepos.ailauncher.agent.aispace.skill.feishu.n0 r3 = new com.stepos.ailauncher.agent.aispace.skill.feishu.n0
            r5 = 4
            r8 = 0
            r3.<init>(r4, r5, r6, r7, r8)
            r13.invoke(r3)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r13
            r0.I$0 = r4
            r0.I$1 = r10
            r0.label = r2
            r11 = 800(0x320, double:3.953E-321)
            java.lang.Object r9 = Ua.U.a(r11, r0)
            if (r9 != r14) goto L6f
            return r14
        L6f:
            int r10 = r10 + r2
            goto L4d
        L71:
            com.stepos.ailauncher.agent.aispace.skill.feishu.n0 r3 = new com.stepos.ailauncher.agent.aispace.skill.feishu.n0
            r5 = 4
            r8 = 1
            r3.<init>(r4, r5, r6, r7, r8)
            r13.invoke(r3)
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector.m(int, java.lang.String, java.lang.String, p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r15.equals("cli_check_failed") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        if (r15.equals("installing") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        if (r15.equals("review_failed") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r1 = k(com.stepos.ailauncher.agent.aispace.skill.feishu.FailStage.Review, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if (r15.equals("authorizing") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        if (r15.equals("reviewing") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (r15.equals("bot_create_success") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        if (r15.equals("under_review") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
    
        if (r15.equals("authorize_success") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
    
        r1 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.m.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0093, code lost:
    
        if (r15.equals("idle") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009d, code lost:
    
        if (r15.equals("") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ee, code lost:
    
        if (r15.equals("logout") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x014e, code lost:
    
        if (r15.equals("install_success") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0151, code lost:
    
        r1 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.l.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x015a, code lost:
    
        if (r15.equals("bot_creating") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015d, code lost:
    
        r1 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.g.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0166, code lost:
    
        if (r15.equals("authorize_failed") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016f, code lost:
    
        if (r15.equals("authorize_denied") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018e, code lost:
    
        r1 = k(com.stepos.ailauncher.agent.aispace.skill.feishu.FailStage.Authorize, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector.n(java.lang.String):boolean");
    }
}

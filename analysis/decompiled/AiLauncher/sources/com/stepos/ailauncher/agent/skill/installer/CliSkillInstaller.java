package com.stepos.ailauncher.agent.skill.installer;

import Xa.j;
import Xa.o;
import Xa.p;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.installer.SkillInstaller;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001\u0010B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\r\u0010\u000bJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000e\u0010\u000bJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000f\u0010\u000bJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0010\u0010\u000bJ'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR&\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R,\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u001e0!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/CliSkillInstaller;", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller;", "Lcom/stepos/ailauncher/agent/skill/installer/a;", "cliClient", "<init>", "(Lcom/stepos/ailauncher/agent/skill/installer/a;)V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "Lkotlin/Result;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", "c", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Le9/c;)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "", "slug", "op", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "k", "Lcom/stepos/ailauncher/agent/skill/installer/a;", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", "statusModel", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", "LXa/j;", "", "_statusFlow", "LXa/j;", "LXa/o;", "statusFlow", "LXa/o;", Const.INTENT_KEY_UMID, "()LXa/o;", "Companion", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CliSkillInstaller implements SkillInstaller {
    private static final String TAG = "CliSkillInstaller";
    private final j<Map<String, SkillItem>> _statusFlow;
    private final a cliClient;
    private final o<Map<String, SkillItem>> statusFlow;
    private final SkillInstaller.StatusModel statusModel;

    /* JADX WARN: Multi-variable type inference failed */
    public CliSkillInstaller() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$uninstall$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$uninstall$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$uninstall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$uninstall$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$uninstall$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.a r4 = (com.stepos.ailauncher.agent.skill.installer.a) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L7e
            goto L70
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.installer.a r6 = r4.cliClient
            if (r6 != 0) goto L50
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "uninstall"
            java.lang.Object r4 = r4.k(r5, r6)
            return r4
        L50:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r2 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L7e
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L7e
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L7e
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L7e
            r4 = 0
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L7e
            r0.label = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r4 = r6.e(r5, r0)     // Catch: java.lang.Throwable -> L7e
            if (r4 != r1) goto L70
            return r1
        L70:
            com.stepos.ailauncher.agent.skill.installer.b$b r4 = new com.stepos.ailauncher.agent.skill.installer.b$b     // Catch: java.lang.Throwable -> L7e
            com.stepos.ailauncher.agent.skill.SkillStatus r5 = com.stepos.ailauncher.agent.skill.SkillStatus.UNINSTALLED     // Catch: java.lang.Throwable -> L7e
            r6 = 2
            r0 = 0
            r4.<init>(r5, r0, r6, r0)     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L7e
            return r4
        L7e:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller.a(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    public /* bridge */ Object b(SkillItem skillItem, InterfaceC4014c<? super Result<? extends b>> interfaceC4014c) {
        return super.b(skillItem, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$install$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$install$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$install$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$install$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$install$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.a r4 = (com.stepos.ailauncher.agent.skill.installer.a) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L7d
            goto L6f
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.installer.a r6 = r4.cliClient
            if (r6 != 0) goto L4f
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "install"
            java.lang.Object r4 = r4.k(r5, r6)
            return r4
        L4f:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r2 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L7d
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L7d
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L7d
            r4 = 0
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L7d
            r0.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = r6.a(r5, r0)     // Catch: java.lang.Throwable -> L7d
            if (r4 != r1) goto L6f
            return r1
        L6f:
            com.stepos.ailauncher.agent.skill.installer.b$b r4 = new com.stepos.ailauncher.agent.skill.installer.b$b     // Catch: java.lang.Throwable -> L7d
            com.stepos.ailauncher.agent.skill.SkillStatus r5 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED_ENABLED     // Catch: java.lang.Throwable -> L7d
            r6 = 2
            r0 = 0
            r4.<init>(r5, r0, r6, r0)     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L7d
            return r4
        L7d:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller.c(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    public o<Map<String, SkillItem>> d() {
        return this.statusFlow;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$enable$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$enable$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$enable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$enable$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$enable$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.a r4 = (com.stepos.ailauncher.agent.skill.installer.a) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L7d
            goto L6f
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.installer.a r6 = r4.cliClient
            if (r6 != 0) goto L4f
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "enable"
            java.lang.Object r4 = r4.k(r5, r6)
            return r4
        L4f:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r2 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L7d
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L7d
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L7d
            r4 = 0
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L7d
            r0.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = r6.b(r5, r0)     // Catch: java.lang.Throwable -> L7d
            if (r4 != r1) goto L6f
            return r1
        L6f:
            com.stepos.ailauncher.agent.skill.installer.b$b r4 = new com.stepos.ailauncher.agent.skill.installer.b$b     // Catch: java.lang.Throwable -> L7d
            com.stepos.ailauncher.agent.skill.SkillStatus r5 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED_ENABLED     // Catch: java.lang.Throwable -> L7d
            r6 = 2
            r0 = 0
            r4.<init>(r5, r0, r6, r0)     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L7d
            return r4
        L7d:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller.e(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<Y8.t>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$cancel$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$cancel$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$cancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$cancel$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$cancel$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.a r4 = (com.stepos.ailauncher.agent.skill.installer.a) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L76
            goto L6f
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.installer.a r6 = r4.cliClient
            if (r6 != 0) goto L4f
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "cancel"
            java.lang.Object r4 = r4.j(r5, r6)
            return r4
        L4f:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L76
            java.lang.Object r2 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L76
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L76
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L76
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L76
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L76
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L76
            r4 = 0
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L76
            r0.label = r3     // Catch: java.lang.Throwable -> L76
            java.lang.Object r4 = r6.d(r5, r0)     // Catch: java.lang.Throwable -> L76
            if (r4 != r1) goto L6f
            return r1
        L6f:
            Y8.t r4 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L76
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L76
            return r4
        L76:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller.g(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$disable$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$disable$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$disable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$disable$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller$disable$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.a r4 = (com.stepos.ailauncher.agent.skill.installer.a) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L7d
            goto L6f
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.installer.a r6 = r4.cliClient
            if (r6 != 0) goto L4f
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "disable"
            java.lang.Object r4 = r4.k(r5, r6)
            return r4
        L4f:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r2 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L7d
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L7d
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L7d
            r4 = 0
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L7d
            r0.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = r6.c(r5, r0)     // Catch: java.lang.Throwable -> L7d
            if (r4 != r1) goto L6f
            return r1
        L6f:
            com.stepos.ailauncher.agent.skill.installer.b$b r4 = new com.stepos.ailauncher.agent.skill.installer.b$b     // Catch: java.lang.Throwable -> L7d
            com.stepos.ailauncher.agent.skill.SkillStatus r5 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED_DISABLED     // Catch: java.lang.Throwable -> L7d
            r6 = 2
            r0 = 0
            r4.<init>(r5, r0, r6, r0)     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L7d
            return r4
        L7d:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller.h(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /* renamed from: i, reason: from getter */
    public SkillInstaller.StatusModel getStatusModel() {
        return this.statusModel;
    }

    public final Object j(String slug, String op) {
        C4148a.u(TAG, "CliSkillInstaller." + op + "(slug=" + slug + ") skipped: cliClient not wired", false, 4, null);
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new NotImplementedError("CLI client not wired")));
    }

    public final Object k(String slug, String op) {
        C4148a.u(TAG, "CliSkillInstaller." + op + "(slug=" + slug + ") skipped: cliClient not wired", false, 4, null);
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new NotImplementedError("CLI client not wired")));
    }

    public CliSkillInstaller(a aVar) {
        this.cliClient = aVar;
        this.statusModel = SkillInstaller.StatusModel.PUSH;
        j<Map<String, SkillItem>> jVarA = p.a(0, 64, BufferOverflow.DROP_OLDEST);
        this._statusFlow = jVarA;
        this.statusFlow = Xa.d.b(jVarA);
    }

    public /* synthetic */ CliSkillInstaller(a aVar, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : aVar);
    }
}

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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001\u0016B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0013\u0010\u0012J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0014\u0010\u0012J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0015\u0010\u0012J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0016\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR&\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R,\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u001f0\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/LocalSkillInstaller;", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller;", "Lcom/stepos/ailauncher/agent/skill/installer/d;", "localSdk", "<init>", "(Lcom/stepos/ailauncher/agent/skill/installer/d;)V", "", "slug", "op", "Lkotlin/Result;", "LY8/t;", "l", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", "m", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "c", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "k", "Lcom/stepos/ailauncher/agent/skill/installer/d;", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", "statusModel", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", "LXa/j;", "", "_statusFlow", "LXa/j;", "LXa/o;", "statusFlow", "LXa/o;", Const.INTENT_KEY_UMID, "()LXa/o;", "Companion", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalSkillInstaller implements SkillInstaller {
    private static final String TAG = "LocalSkillInstaller";
    private final j<Map<String, SkillItem>> _statusFlow;
    private final d localSdk;
    private final o<Map<String, SkillItem>> statusFlow;
    private final SkillInstaller.StatusModel statusModel;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalSkillInstaller() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final Object l(String slug, String op) {
        C4148a.u(TAG, "LocalSkillInstaller." + op + "(slug=" + slug + ") skipped: SDK not wired", false, 4, null);
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new NotImplementedError("Local SDK not wired")));
    }

    private final Object m(String slug, String op) {
        C4148a.u(TAG, "LocalSkillInstaller." + op + "(slug=" + slug + ") skipped: SDK not wired", false, 4, null);
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new NotImplementedError("Local SDK not wired")));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$uninstall$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$uninstall$1 r0 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$uninstall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$uninstall$1 r0 = new com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$uninstall$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.d r4 = (com.stepos.ailauncher.agent.skill.installer.d) r4
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
            com.stepos.ailauncher.agent.skill.installer.d r6 = r4.localSdk
            if (r6 != 0) goto L50
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "uninstall"
            java.lang.Object r4 = r4.m(r5, r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller.a(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    public /* bridge */ Object b(SkillItem skillItem, InterfaceC4014c<? super Result<? extends b>> interfaceC4014c) {
        return super.b(skillItem, interfaceC4014c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ac, code lost:
    
        if (r2.a(r3, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(com.stepos.ailauncher.agent.skill.SkillItem r7, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$install$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$install$1 r0 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$install$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$install$1 r0 = new com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$install$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L5c
            if (r2 == r3) goto L45
            if (r2 != r4) goto L3d
            java.lang.Object r6 = r0.L$3
            com.stepos.ailauncher.agent.skill.SkillItem r6 = (com.stepos.ailauncher.agent.skill.SkillItem) r6
            java.lang.Object r6 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller r6 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller) r6
            java.lang.Object r6 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.d r6 = (com.stepos.ailauncher.agent.skill.installer.d) r6
            java.lang.Object r6 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r6 = (com.stepos.ailauncher.agent.skill.SkillItem) r6
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> Lbc
            goto Laf
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller r7 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller) r7
            java.lang.Object r2 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.d r2 = (com.stepos.ailauncher.agent.skill.installer.d) r2
            java.lang.Object r3 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r3 = (com.stepos.ailauncher.agent.skill.SkillItem) r3
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> Lbc
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r5
            goto L8a
        L5c:
            kotlin.C4849c.b(r8)
            com.stepos.ailauncher.agent.skill.installer.d r2 = r6.localSdk
            if (r2 != 0) goto L6e
            java.lang.String r7 = r7.getSlug()
            java.lang.String r8 = "install"
            java.lang.Object r6 = r6.m(r7, r8)
            return r6
        L6e:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r8 = g9.h.a(r7)     // Catch: java.lang.Throwable -> Lbc
            r0.L$0 = r8     // Catch: java.lang.Throwable -> Lbc
            r0.L$1 = r2     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r8 = g9.h.a(r6)     // Catch: java.lang.Throwable -> Lbc
            r0.L$2 = r8     // Catch: java.lang.Throwable -> Lbc
            r8 = 0
            r0.I$0 = r8     // Catch: java.lang.Throwable -> Lbc
            r0.label = r3     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r3 = r6.k(r7, r0)     // Catch: java.lang.Throwable -> Lbc
            if (r3 != r1) goto L8a
            goto Lae
        L8a:
            com.stepos.ailauncher.agent.skill.SkillItem r3 = (com.stepos.ailauncher.agent.skill.SkillItem) r3     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> Lbc
            r0.L$0 = r7     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r7 = g9.h.a(r2)     // Catch: java.lang.Throwable -> Lbc
            r0.L$1 = r7     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> Lbc
            r0.L$2 = r6     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r6 = g9.h.a(r3)     // Catch: java.lang.Throwable -> Lbc
            r0.L$3 = r6     // Catch: java.lang.Throwable -> Lbc
            r0.I$0 = r8     // Catch: java.lang.Throwable -> Lbc
            r0.label = r4     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r6 = r2.a(r3, r0)     // Catch: java.lang.Throwable -> Lbc
            if (r6 != r1) goto Laf
        Lae:
            return r1
        Laf:
            com.stepos.ailauncher.agent.skill.installer.b$b r6 = new com.stepos.ailauncher.agent.skill.installer.b$b     // Catch: java.lang.Throwable -> Lbc
            com.stepos.ailauncher.agent.skill.SkillStatus r7 = com.stepos.ailauncher.agent.skill.SkillStatus.INSTALLED_ENABLED     // Catch: java.lang.Throwable -> Lbc
            r8 = 0
            r6.<init>(r7, r8, r4, r8)     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> Lbc
            return r6
        Lbc:
            r6 = move-exception
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller.c(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
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
    public java.lang.Object e(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$enable$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$enable$1 r0 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$enable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$enable$1 r0 = new com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$enable$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.d r4 = (com.stepos.ailauncher.agent.skill.installer.d) r4
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
            com.stepos.ailauncher.agent.skill.installer.d r6 = r4.localSdk
            if (r6 != 0) goto L4f
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "enable"
            java.lang.Object r4 = r4.m(r5, r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller.e(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
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
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$cancel$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$cancel$1 r0 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$cancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$cancel$1 r0 = new com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$cancel$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.d r4 = (com.stepos.ailauncher.agent.skill.installer.d) r4
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
            com.stepos.ailauncher.agent.skill.installer.d r6 = r4.localSdk
            if (r6 != 0) goto L4f
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "cancel"
            java.lang.Object r4 = r4.l(r5, r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller.g(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
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
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$disable$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$disable$1 r0 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$disable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$disable$1 r0 = new com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$disable$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller r4 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller) r4
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.agent.skill.installer.d r4 = (com.stepos.ailauncher.agent.skill.installer.d) r4
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
            com.stepos.ailauncher.agent.skill.installer.d r6 = r4.localSdk
            if (r6 != 0) goto L4f
            java.lang.String r5 = r5.getSlug()
            java.lang.String r6 = "disable"
            java.lang.Object r4 = r4.m(r5, r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller.h(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /* renamed from: i, reason: from getter */
    public SkillInstaller.StatusModel getStatusModel() {
        return this.statusModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(com.stepos.ailauncher.agent.skill.SkillItem r46, e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.skill.SkillItem> r47) throws java.lang.Throwable {
        /*
            r45 = this;
            r0 = r46
            r1 = r47
            boolean r2 = r1 instanceof com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$ensureLocalZip$1
            if (r2 == 0) goto L17
            r2 = r1
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$ensureLocalZip$1 r2 = (com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$ensureLocalZip$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1e
        L17:
            com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$ensureLocalZip$1 r2 = new com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller$ensureLocalZip$1
            r3 = r45
            r2.<init>(r3, r1)
        L1e:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = f9.C4063a.g()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3c
            if (r4 != r5) goto L34
            java.lang.Object r0 = r2.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r0 = (com.stepos.ailauncher.agent.skill.SkillItem) r0
            kotlin.C4849c.b(r1)
        L32:
            r4 = r0
            goto L67
        L34:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3c:
            kotlin.C4849c.b(r1)
            java.lang.String r1 = r0.getLocalZipAbsolutePath()
            if (r1 == 0) goto L4d
            int r1 = r1.length()
            if (r1 != 0) goto L4c
            goto L4d
        L4c:
            return r0
        L4d:
            java.lang.String r1 = r0.getRemoteZipUrl()
            if (r1 == 0) goto Lb3
            int r1 = r1.length()
            if (r1 != 0) goto L5a
            goto Lb3
        L5a:
            com.stepos.ailauncher.agent.skill.installer.SkillZipCache r1 = com.stepos.ailauncher.agent.skill.installer.SkillZipCache.INSTANCE
            r2.L$0 = r0
            r2.label = r5
            java.lang.Object r1 = r1.k(r0, r2)
            if (r1 != r3) goto L32
            return r3
        L67:
            java.io.File r1 = (java.io.File) r1
            java.lang.String r32 = r1.getAbsolutePath()
            r43 = 15
            r44 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = -67108865(0xfffffffffbffffff, float:-2.6584558E36)
            com.stepos.ailauncher.agent.skill.SkillItem r0 = com.stepos.ailauncher.agent.skill.SkillItem.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller.k(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    public LocalSkillInstaller(d dVar) {
        this.localSdk = dVar;
        this.statusModel = SkillInstaller.StatusModel.PUSH;
        j<Map<String, SkillItem>> jVarA = p.a(0, 64, BufferOverflow.DROP_OLDEST);
        this._statusFlow = jVarA;
        this.statusFlow = Xa.d.b(jVarA);
    }

    public /* synthetic */ LocalSkillInstaller(d dVar, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : dVar);
    }
}

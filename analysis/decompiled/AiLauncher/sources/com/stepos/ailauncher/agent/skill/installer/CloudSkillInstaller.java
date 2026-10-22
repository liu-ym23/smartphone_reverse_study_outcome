package com.stepos.ailauncher.agent.skill.installer;

import Xa.o;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.installer.SkillInstaller;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import e9.InterfaceC4014c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\r\u0010\u000bJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000e\u0010\u000bJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000f\u0010\u000bJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0010\u0010\u000bJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0011\u0010\u000bJ*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/CloudSkillInstaller;", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller;", "Lcom/stepos/ailauncher/agent/skill/repository/e;", "repository", "<init>", "(Lcom/stepos/ailauncher/agent/skill/repository/e;)V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "Lkotlin/Result;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", "c", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Le9/c;)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "", DidiCardProvider.KEY_ITEMS, "", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/repository/e;", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", "statusModel", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller$StatusModel;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CloudSkillInstaller implements SkillInstaller {
    private final com.stepos.ailauncher.agent.skill.repository.e repository;
    private final SkillInstaller.StatusModel statusModel;

    public CloudSkillInstaller(com.stepos.ailauncher.agent.skill.repository.e repository) {
        p.i(repository, "repository");
        this.repository = repository;
        this.statusModel = SkillInstaller.StatusModel.PULL;
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
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$uninstall$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$uninstall$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$uninstall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$uninstall$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$uninstall$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.getValue()
            return r4
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.repository.e r4 = r4.repository
            java.lang.Object r6 = g9.h.a(r5)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.a(r5, r0)
            if (r4 != r1) goto L4f
            return r1
        L4f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller.a(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$update$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$update$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$update$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$update$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$update$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.getValue()
            return r4
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.repository.e r4 = r4.repository
            java.lang.Object r6 = g9.h.a(r5)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.h(r5, r3, r0)
            if (r4 != r1) goto L4f
            return r1
        L4f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller.b(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(com.stepos.ailauncher.agent.skill.SkillItem r5, e9.InterfaceC4014c<? super kotlin.Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$install$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$install$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$install$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$install$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$install$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.getValue()
            return r4
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.repository.e r4 = r4.repository
            java.lang.Object r6 = g9.h.a(r5)
            r0.L$0 = r6
            r0.label = r3
            r6 = 0
            java.lang.Object r4 = r4.h(r5, r6, r0)
            if (r4 != r1) goto L50
            return r1
        L50:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller.c(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    public /* bridge */ o<Map<String, SkillItem>> d() {
        return super.d();
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
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$enable$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$enable$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$enable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$enable$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$enable$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.getValue()
            return r4
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.repository.e r4 = r4.repository
            java.lang.Object r6 = g9.h.a(r5)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.b(r5, r0)
            if (r4 != r1) goto L4f
            return r1
        L4f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller.e(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
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
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$cancel$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$cancel$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$cancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$cancel$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$cancel$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.getValue()
            return r4
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.repository.e r4 = r4.repository
            java.lang.Object r6 = g9.h.a(r5)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.f(r5, r0)
            if (r4 != r1) goto L4f
            return r1
        L4f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller.g(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
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
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$disable$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$disable$1 r0 = (com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$disable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$disable$1 r0 = new com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller$disable$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.agent.skill.SkillItem r4 = (com.stepos.ailauncher.agent.skill.SkillItem) r4
            kotlin.C4849c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.getValue()
            return r4
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.agent.skill.repository.e r4 = r4.repository
            java.lang.Object r6 = g9.h.a(r5)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.d(r5, r0)
            if (r4 != r1) goto L4f
            return r1
        L4f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller.h(com.stepos.ailauncher.agent.skill.SkillItem, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.SkillInstaller
    /* renamed from: i, reason: from getter */
    public SkillInstaller.StatusModel getStatusModel() {
        return this.statusModel;
    }

    public Object j(List<SkillItem> list, InterfaceC4014c<? super Map<String, SkillItem>> interfaceC4014c) {
        return list.isEmpty() ? kotlin.collections.a.i() : this.repository.e(list, interfaceC4014c);
    }

    public /* synthetic */ CloudSkillInstaller(com.stepos.ailauncher.agent.skill.repository.e eVar, int i10, i iVar) {
        this((i10 & 1) != 0 ? com.stepos.ailauncher.agent.skill.repository.g.INSTANCE.d() : eVar);
    }
}

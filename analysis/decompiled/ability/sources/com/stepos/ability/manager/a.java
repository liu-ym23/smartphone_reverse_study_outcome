package com.stepos.ability.manager;

import android.content.Context;
import com.stepos.ability.api.agentbus.IAbilityCatalog;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements IAbilityCatalog {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3114a;
    public final IAbilityManager b;

    public a(Context appContext, IAbilityManager abilityManager) {
        k.f(appContext, "appContext");
        k.f(abilityManager, "abilityManager");
        this.f3114a = appContext;
        this.b = abilityManager;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
    
        if (r1 == r3) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c2, code lost:
    
        if (r1 == r3) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00af -> B:29:0x00b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x014c -> B:48:0x0151). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.util.List r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.a.a(java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        if (r2 == r4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
        if (r2 == r4) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable b(java.util.List r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.a.b(java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ability.api.agentbus.IAbilityCatalog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object listAbilities(android.content.Context r5, java.util.List r6, H7.c r7) {
        /*
            r4 = this;
            boolean r5 = r7 instanceof com.stepos.ability.manager.AbilityCatalogImpl$listAbilities$1
            if (r5 == 0) goto L13
            r5 = r7
            com.stepos.ability.manager.AbilityCatalogImpl$listAbilities$1 r5 = (com.stepos.ability.manager.AbilityCatalogImpl$listAbilities$1) r5
            int r0 = r5.d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.d = r0
            goto L18
        L13:
            com.stepos.ability.manager.AbilityCatalogImpl$listAbilities$1 r5 = new com.stepos.ability.manager.AbilityCatalogImpl$listAbilities$1
            r5.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r5.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r5.d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            java.util.List r4 = r5.f3101a
            java.util.List r4 = (java.util.List) r4
            kotlin.b.b(r7)
            return r7
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            java.util.List r6 = r5.f3101a
            java.util.List r6 = (java.util.List) r6
            kotlin.b.b(r7)
            goto L4f
        L3e:
            kotlin.b.b(r7)
            r7 = r6
            java.util.List r7 = (java.util.List) r7
            r5.f3101a = r7
            r5.d = r3
            java.io.Serializable r7 = r4.b(r6, r5)
            if (r7 != r0) goto L4f
            goto L66
        L4f:
            java.util.List r7 = (java.util.List) r7
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L5b
            return r7
        L5b:
            r7 = 0
            r5.f3101a = r7
            r5.d = r2
            java.lang.Object r4 = r4.a(r6, r5)
            if (r4 != r0) goto L67
        L66:
            return r0
        L67:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.a.listAbilities(android.content.Context, java.util.List, H7.c):java.lang.Object");
    }
}

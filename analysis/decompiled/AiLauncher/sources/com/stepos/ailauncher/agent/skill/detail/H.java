package com.stepos.ailauncher.agent.skill.detail;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.InstallSource;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/F;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/agent/skill/detail/F;)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "", HomeGestureEligibilityContract.EXTRA_SCENE, "Lcom/stepos/ailauncher/agent/skill/InstallSource;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Integer;)Lcom/stepos/ailauncher/agent/skill/InstallSource;", "agent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H {
    public static final InstallSource a(Integer num) {
        return (num != null && num.intValue() == 1) ? InstallSource.LOCAL : InstallSource.CLOUD;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[PHI: r0
      0x0021: PHI (r0v13 java.lang.String) = (r0v2 java.lang.String), (r0v15 java.lang.String) binds: [B:14:0x0027, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[PHI: r2
      0x0043: PHI (r2v8 java.lang.String) = (r2v1 java.lang.String), (r2v9 java.lang.String) binds: [B:29:0x0049, B:25:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.stepos.ailauncher.agent.skill.SkillItem b(com.stepos.ailauncher.agent.skill.detail.SkillDetailDto r45) {
        /*
            java.lang.String r0 = "<this>"
            r1 = r45
            kotlin.jvm.internal.p.i(r1, r0)
            java.lang.String r0 = r1.getId()
            r2 = 0
            java.lang.String r3 = ""
            if (r0 == 0) goto L23
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L23
            boolean r4 = La.H.x0(r0)
            if (r4 != 0) goto L1d
            goto L1e
        L1d:
            r0 = r2
        L1e:
            if (r0 != 0) goto L21
            goto L23
        L21:
            r5 = r0
            goto L2a
        L23:
            java.lang.String r0 = r1.getName()
            if (r0 != 0) goto L21
            r5 = r3
        L2a:
            java.lang.String r0 = r1.getName()
            if (r0 != 0) goto L32
            r6 = r3
            goto L33
        L32:
            r6 = r0
        L33:
            java.lang.String r0 = r1.getDisplayName()
            if (r0 == 0) goto L45
            boolean r4 = La.H.x0(r0)
            if (r4 != 0) goto L40
            r2 = r0
        L40:
            if (r2 != 0) goto L43
            goto L45
        L43:
            r7 = r2
            goto L4c
        L45:
            java.lang.String r2 = r1.getName()
            if (r2 != 0) goto L43
            r7 = r3
        L4c:
            java.lang.String r0 = r1.getDescription()
            if (r0 != 0) goto L54
            r8 = r3
            goto L55
        L54:
            r8 = r0
        L55:
            java.lang.String r17 = r1.getVersion()
            java.lang.String r18 = r1.getVersion()
            java.lang.String r22 = r1.getCategory()
            java.lang.String r23 = r1.getCategory()
            java.lang.Long r0 = r1.getDownloadCount()
            if (r0 == 0) goto L72
            long r2 = r0.longValue()
        L6f:
            r24 = r2
            goto L75
        L72:
            r2 = 0
            goto L6f
        L75:
            int r26 = r1.getNeedUpdate()
            java.lang.String r27 = r1.getInstallVersion()
            java.lang.Integer r0 = r1.getNecessary()
            r2 = 0
            if (r0 == 0) goto L8b
            int r0 = r0.intValue()
            r29 = r0
            goto L8d
        L8b:
            r29 = r2
        L8d:
            java.lang.String r0 = r1.getSkillMd()
            r3 = 1
            if (r0 == 0) goto L9a
            boolean r0 = La.H.x0(r0)
            if (r0 == 0) goto L9b
        L9a:
            r2 = r3
        L9b:
            r0 = r2 ^ 1
            java.lang.Boolean r31 = java.lang.Boolean.valueOf(r0)
            com.stepos.ailauncher.agent.skill.SkillStatus r37 = r1.getStatus()
            java.lang.Integer r0 = r1.getScene()
            com.stepos.ailauncher.agent.skill.InstallSource r39 = a(r0)
            com.stepos.ailauncher.agent.skill.InstallKind r40 = com.stepos.ailauncher.agent.skill.InstallKind.SKILL
            com.stepos.ailauncher.agent.skill.SkillItem r4 = new com.stepos.ailauncher.agent.skill.SkillItem
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r41 = 0
            r42 = 2101465072(0x7d41cff0, float:1.6101292E37)
            r43 = 9
            r44 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.H.b(com.stepos.ailauncher.agent.skill.detail.F):com.stepos.ailauncher.agent.skill.SkillItem");
    }
}

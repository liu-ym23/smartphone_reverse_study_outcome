package com.stepos.ailauncher.agent.skill.repository;

import La.D;
import La.K;
import O6.l;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.detail.SkillHubResponse;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0010\u0010\u0011JA\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/repository/SkillOpsAudit;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/repository/SkillOpsAudit$Op;", "op", "", "skillName", "Lcom/stepos/ailauncher/agent/skill/api/SkillEnvelope;", UxipConstants.f30685x, "", "error", "", "startMs", "extra", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/skill/repository/SkillOpsAudit$Op;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/api/SkillEnvelope;Ljava/lang/Throwable;JLjava/lang/String;)V", "Lcom/stepos/ailauncher/agent/skill/detail/l0;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/agent/skill/repository/SkillOpsAudit$Op;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/detail/l0;Ljava/lang/Throwable;J)V", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/agent/skill/repository/SkillOpsAudit$Op;Ljava/lang/String;Ljava/lang/Throwable;J)V", "s", "e", "(Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "Op", "Result", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillOpsAudit {
    public static final SkillOpsAudit INSTANCE = new SkillOpsAudit();
    private static final String TAG = "SkillOpsAudit";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/repository/SkillOpsAudit$Op;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALL", "UNINSTALL", "ENABLE", "DISABLE", "UPDATE", "CANCEL_INSTALL", "QUERY_STATUS", "GET_SKILL", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Op {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Op[] $VALUES;
        public static final Op INSTALL = new Op("INSTALL", 0);
        public static final Op UNINSTALL = new Op("UNINSTALL", 1);
        public static final Op ENABLE = new Op("ENABLE", 2);
        public static final Op DISABLE = new Op("DISABLE", 3);
        public static final Op UPDATE = new Op("UPDATE", 4);
        public static final Op CANCEL_INSTALL = new Op("CANCEL_INSTALL", 5);
        public static final Op QUERY_STATUS = new Op("QUERY_STATUS", 6);
        public static final Op GET_SKILL = new Op("GET_SKILL", 7);

        private static final /* synthetic */ Op[] $values() {
            return new Op[]{INSTALL, UNINSTALL, ENABLE, DISABLE, UPDATE, CANCEL_INSTALL, QUERY_STATUS, GET_SKILL};
        }

        static {
            Op[] opArr$values = $values();
            $VALUES = opArr$values;
            $ENTRIES = kotlin.enums.a.a(opArr$values);
        }

        private Op(String str, int i10) {
        }

        public static InterfaceC4149a<Op> getEntries() {
            return $ENTRIES;
        }

        public static Op valueOf(String str) {
            return (Op) Enum.valueOf(Op.class, str);
        }

        public static Op[] values() {
            return (Op[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/repository/SkillOpsAudit$Result;", "", "<init>", "(Ljava/lang/String;I)V", AMapLocationStaticsEntity.SUCCESS_STATUS, "FAILED", "EXCEPTION", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Result {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Result[] $VALUES;
        public static final Result SUCCESS = new Result(AMapLocationStaticsEntity.SUCCESS_STATUS, 0);
        public static final Result FAILED = new Result("FAILED", 1);
        public static final Result EXCEPTION = new Result("EXCEPTION", 2);

        private static final /* synthetic */ Result[] $values() {
            return new Result[]{SUCCESS, FAILED, EXCEPTION};
        }

        static {
            Result[] resultArr$values = $values();
            $VALUES = resultArr$values;
            $ENTRIES = kotlin.enums.a.a(resultArr$values);
        }

        private Result(String str, int i10) {
        }

        public static InterfaceC4149a<Result> getEntries() {
            return $ENTRIES;
        }

        public static Result valueOf(String str) {
            return (Result) Enum.valueOf(Result.class, str);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit.Op r7, java.lang.String r8, com.stepos.ailauncher.agent.skill.api.SkillEnvelope<?> r9, java.lang.Throwable r10, long r11, java.lang.String r13) {
        /*
            r6 = this;
            java.lang.String r0 = "op"
            kotlin.jvm.internal.p.i(r7, r0)
            if (r10 == 0) goto Lb
            com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit$Result r0 = com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit.Result.EXCEPTION
            goto L18
        Lb:
            if (r9 == 0) goto L16
            boolean r0 = r9.isSuccess()
            if (r0 == 0) goto L16
            com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit$Result r0 = com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit.Result.SUCCESS
            goto L18
        L16:
            com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit$Result r0 = com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit.Result.FAILED
        L18:
            r1 = -1
            if (r10 == 0) goto L1c
            goto L22
        L1c:
            if (r9 == 0) goto L22
            int r1 = r9.getCode()
        L22:
            r2 = 0
            if (r10 == 0) goto L34
            java.lang.String r3 = r10.getMessage()
            if (r3 != 0) goto L3c
            java.lang.Class r10 = r10.getClass()
            java.lang.String r3 = r10.getSimpleName()
            goto L3c
        L34:
            if (r9 == 0) goto L3b
            java.lang.String r3 = r9.getMessage()
            goto L3c
        L3b:
            r3 = r2
        L3c:
            java.lang.String r10 = r6.e(r3)
            java.lang.String r6 = "-"
            if (r9 == 0) goto L4a
            java.lang.String r9 = r9.getTraceId()
            if (r9 != 0) goto L4b
        L4a:
            r9 = r6
        L4b:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r11
            if (r13 == 0) goto L78
            boolean r11 = La.H.x0(r13)
            if (r11 != 0) goto L59
            goto L5a
        L59:
            r13 = r2
        L5a:
            if (r13 == 0) goto L78
            com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit r11 = com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit.INSTANCE
            java.lang.String r11 = r11.e(r13)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = " "
            r12.append(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            if (r11 != 0) goto L76
            goto L78
        L76:
            r13 = r11
            goto L7b
        L78:
            java.lang.String r11 = ""
            goto L76
        L7b:
            kotlin.jvm.internal.y r11 = kotlin.jvm.internal.y.f34840a
            java.lang.String r7 = r7.name()
            if (r8 != 0) goto L84
            r8 = r6
        L84:
            java.lang.String r6 = r0.name()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
            java.lang.Long r12 = java.lang.Long.valueOf(r3)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            r5 = r11
            r11 = r9
            r9 = r5
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7, r8, r9, r10, r11, r12, r13}
            r7 = 8
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)
            java.lang.String r7 = "op=%s skill=%s result=%s code=%d msg=%s trace=%s costMs=%d%s"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            java.lang.String r7 = "format(...)"
            kotlin.jvm.internal.p.h(r6, r7)
            r7 = 0
            r8 = 4
            java.lang.String r9 = "SkillOpsAudit"
            h8.C4148a.k(r9, r6, r7, r8, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit.a(com.stepos.ailauncher.agent.skill.repository.SkillOpsAudit$Op, java.lang.String, com.stepos.ailauncher.agent.skill.api.SkillEnvelope, java.lang.Throwable, long, java.lang.String):void");
    }

    public final void b(Op op, String skillName, SkillHubResponse<?> response, Throwable error, long startMs) {
        String msg;
        String traceId;
        Integer code;
        p.i(op, "op");
        Result result = error != null ? Result.EXCEPTION : (response == null || !response.e()) ? Result.FAILED : Result.SUCCESS;
        int iIntValue = -1;
        if (error == null && response != null && (code = response.getCode()) != null) {
            iIntValue = code.intValue();
        }
        if (error != null) {
            msg = error.getMessage();
            if (msg == null) {
                msg = error.getClass().getSimpleName();
            }
        } else {
            msg = response != null ? response.getMsg() : null;
        }
        String strE = e(msg);
        if (response == null || (traceId = response.getTraceId()) == null) {
            traceId = l.DATE_SEPARATOR;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - startMs;
        y yVar = y.f34840a;
        String strName = op.name();
        if (skillName == null) {
            skillName = l.DATE_SEPARATOR;
        }
        String str = String.format("op=%s skill=%s result=%s code=%d msg=%s trace=%s costMs=%d", Arrays.copyOf(new Object[]{strName, skillName, result.name(), Integer.valueOf(iIntValue), strE, traceId, Long.valueOf(jCurrentTimeMillis)}, 7));
        p.h(str, "format(...)");
        C4148a.k(TAG, str, false, 4, null);
    }

    public final void d(Op op, String skillName, Throwable error, long startMs) {
        p.i(op, "op");
        p.i(error, "error");
        String message = error.getMessage();
        if (message == null) {
            message = error.getClass().getSimpleName();
        }
        String strE = e(message);
        long jCurrentTimeMillis = System.currentTimeMillis() - startMs;
        y yVar = y.f34840a;
        String strName = op.name();
        if (skillName == null) {
            skillName = l.DATE_SEPARATOR;
        }
        String str = String.format("op=%s skill=%s result=%s code=%d msg=%s trace=%s costMs=%d", Arrays.copyOf(new Object[]{strName, skillName, "EXCEPTION", -1, strE, l.DATE_SEPARATOR, Long.valueOf(jCurrentTimeMillis)}, 7));
        p.h(str, "format(...)");
        C4148a.k(TAG, str, false, 4, null);
    }

    public final String e(String s10) {
        if (s10 == null) {
            s10 = l.DATE_SEPARATOR;
        }
        return D.S(D.T(D.T(K.R1(s10, 200), "\r", "", false, 4, null), "\n", "\\n", false, 4, null), ' ', '_', false, 4, null);
    }
}

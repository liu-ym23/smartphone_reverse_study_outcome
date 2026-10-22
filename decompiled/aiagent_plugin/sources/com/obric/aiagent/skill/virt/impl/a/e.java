package com.obric.aiagent.skill.virt.impl.a;

import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.bytedance.safetyguard.lxc.api.AttemptedOutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.bytedance.safetyguard.lxc.api.SensitiveCategoryInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: EgressResultJsonSerializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f22042a = null;

    static {
        f22042a = new e();
    }

    private e() {
    }

    public final String a(ActionEgressResult r12) {
        o.e(r12, "result");
        StringBuilder r11 = new StringBuilder();
        r11.append('{');
        e r1 = f22042a;
        r1.a(r11, "status", r12.getStatus().name());
        r11.append(',');
        r1.a(r11, "approvedCategories", r12.getApprovedCategories());
        r11.append(',');
        r1.a(r11, "unapprovedCategories", r12.getUnapprovedCategories());
        r11.append(',');
        r1.a(r11, "deniedCategories", r12.getDeniedCategories());
        r11.append(',');
        r11.append("\"attemptedTargets\":[");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.getAttemptedTargets(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L12;
        Object r5 = r2.next();
        int r7 = r3 + 1;
        if (r3 >= 0) goto L8;
        p.c();
    L8:
        AttemptedOutboundTarget r6 = (AttemptedOutboundTarget) ZeusTransformUtils.preCheckCast(r5, AttemptedOutboundTarget.class, "com.obric.aiagent.plugin");
        if (r3 <= 0) goto L11;
        r11.append(',');
    L11:
        OutboundTarget r4 = r6.getTarget();
        r11.append('{');
        e r8 = f22042a;
        r8.a(r11, "host", r4.getHost());
        r11.append(',').append("\"port\":").append(r4.getPort());
        r11.append(',');
        r8.a(r11, "type", r4.getType().name());
        r11.append(',');
        r8.a(r11, "ingressProxy", r4.getIngressProxy().name());
        r11.append(',').append("\"count\":").append(r6.getCount());
        r11.append('}');
        r3 = r7;
        goto L4
    L12:
        r11.append(']');
        r11.append(',').append("\"attemptedTargetsTruncated\":").append(r12.getAttemptedTargetsTruncated());
        r11.append(',').append("\"unreportedAttemptCount\":").append(r12.getUnreportedAttemptCount());
        r11.append(',').append("\"hasBlockedEgress\":").append(r12.getHasBlockedEgress());
        r11.append(',').append("\"canClarify\":").append(r12.getCanClarify());
        r11.append('}');
        String r13 = r11.toString();
        o.c(r13, "toString(...)");
        return r13;
    }

    private final void a(StringBuilder r6, String r7, List<SensitiveCategoryInfo> r8) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        r6.append('\"').append(r7).append("\":[");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r10 = 0;
    L4:
        if (r9.hasNext() == false) goto L12;
        Object r11 = r9.next();
        int r1 = r10 + 1;
        if (r10 >= 0) goto L8;
        p.c();
    L8:
        SensitiveCategoryInfo r12 = (SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r11, SensitiveCategoryInfo.class, "com.obric.aiagent.plugin");
        if (r10 <= 0) goto L11;
        r6.append(',');
    L11:
        r6.append('{');
        e r13 = f22042a;
        r13.a(r6, "sensitiveCategory", r12.getSensitiveCategory());
        r6.append(',');
        r13.b(r6, "categoryDesc", r12.getCategoryDesc());
        r6.append('}');
        r10 = r1;
        goto L4
    L12:
        r6.append(']');
    }

    private final void a(StringBuilder r2, String r3, String r4) {
        r2.append('\"').append(r3).append("\":");
        a(r2, r4);
    }

    private final void b(StringBuilder r2, String r3, String r4) {
        r2.append('\"').append(r3).append("\":");
        if (r4 != null) goto L5;
        r2.append("null");
        return;
    L5:
        a(r2, r4);
    }

    private final void a(StringBuilder r6, String r7) {
        r6.append('\"');
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        int r1 = 0;
    L4:
        if (r1 >= r8.length()) goto L25;
        char r2 = r8.charAt(r1);
        if (r2 != '\f') goto L8;
        r6.append("\\f");
    L24:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2 == '\r') goto L22;
        if (r2 != '\"') goto L11;
        r6.append("\\\"");
        goto L24
    L11:
        if (r2 == '\\') goto L20;
        switch(r2) {
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L14;
        };
    L17:
        r6.append("\\n");
        goto L24
    L18:
        r6.append("\\t");
        goto L24
    L19:
        r6.append("\\b");
        goto L24
    L14:
        if (r2 >= ' ') goto L16;
        String r3 = String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(r2)}, 1));
        o.c(r3, "format(...)");
        r6.append(r3);
        goto L24
    L16:
        r6.append(r2);
        goto L24
    L20:
        r6.append("\\\\");
        goto L24
    L22:
        r6.append("\\r");
        goto L24
    L25:
        r6.append('\"');
    }
}

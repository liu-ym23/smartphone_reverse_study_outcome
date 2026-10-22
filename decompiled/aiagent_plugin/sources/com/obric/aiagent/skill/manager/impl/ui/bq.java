package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.aiagent.skill.manager.impl.dr;
import com.obric.aiagent.skill.manager.impl.ds;
import com.obric.aiagent.skill.manager.impl.dt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SkillPageTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bq f20661a = null;

    static {
        f20661a = new bq();
    }

    private bq() {
    }

    public final bp a(dr r5, String r6) {
        d.h.b.o.e(r5, "currentPage");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L14
        bq r4 = (bq) ZeusTransformUtils.preCheckCast(this, bq.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Object r7 = d.n.f(new JSONObject(r6));     // Catch: Throwable -> L14
    L17:
        if (d.n.c(r7) != null) goto L58;
        JSONObject r8 = (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin");
        Object r9 = r8.opt("previous_page");
        if (r9 != null) goto L21;
    L24:
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L27;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    L28:
        String r11 = "";
        if (r10 != null) goto L31;
        r10 = "";
    L31:
        String r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L34;
        Object r13 = r8.opt("enter_method");
        if (r13 == null) goto L42;
        if (ZeusTransformUtils.instanceOf(r13, String.class) == true) goto L42;
        return (bp) ZeusTransformUtils.preCheckCast(new bp.a("invalid_enter_method"), bp.class, "com.obric.aiagent.plugin");
    L42:
        if (ZeusTransformUtils.instanceOf(r13, String.class) == false) goto L44;
        r3 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
    L44:
        if (r3 == null) goto L47;
        r11 = r3;
    L47:
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L50;
        ds r15 = ds.f19765a.a(r14);
        if (r15 != null) goto L56;
        return (bp) ZeusTransformUtils.preCheckCast(new bp.a("unsupported_enter_method"), bp.class, "com.obric.aiagent.plugin");
    L56:
        return (bp) ZeusTransformUtils.preCheckCast(new bp.b(new dt(r5, r12, r15)), bp.class, "com.obric.aiagent.plugin");
    L50:
        return (bp) ZeusTransformUtils.preCheckCast(new bp.a("missing_enter_method"), bp.class, "com.obric.aiagent.plugin");
    L34:
        return (bp) ZeusTransformUtils.preCheckCast(new bp.a("missing_previous_page"), bp.class, "com.obric.aiagent.plugin");
    L27:
        r10 = null;
        goto L28
    L21:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == true) goto L24;
        return (bp) ZeusTransformUtils.preCheckCast(new bp.a("invalid_previous_page"), bp.class, "com.obric.aiagent.plugin");
    L58:
        return (bp) ZeusTransformUtils.preCheckCast(new bp.a("invalid_log_extras"), bp.class, "com.obric.aiagent.plugin");
    L14:
        th = move-exception;
        d.n.a r16 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L17
    L11:
        return (bp) ZeusTransformUtils.preCheckCast(new bp.a("missing_log_extras"), bp.class, "com.obric.aiagent.plugin");
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}

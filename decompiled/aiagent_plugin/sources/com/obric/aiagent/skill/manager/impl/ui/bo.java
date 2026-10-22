package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Intent;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.skill.manager.impl.dr;
import com.obric.aiagent.skill.manager.impl.du;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SkillPageTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bo {
    public static final String a(String r3, du r4) {
        d.h.b.o.e(r4, DBHelper.BATTERY_COL_SOURCE);
        if (r3 == null) goto L20;
        Object r2 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L20;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L11
        Object r5 = d.n.f(new JSONObject(r3));     // Catch: Throwable -> L11
    L14:
        if (d.n.b(r5) == true) goto L17;
        r2 = r5;
    L17:
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L20;
    L21:
        r6.put("previous_page", r4.a().a());
        r6.put("enter_method", r4.b().a());
        String r7 = r6.toString();
        d.h.b.o.c(r7, "toString(...)");
        return r7;
    L11:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
    L20:
        r6 = new JSONObject();
        goto L21
    }

    public static final bp a(Intent r2, dr r3) {
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r3, "currentPage");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r4 = d.n.f(r2.getStringExtra("log_extras"));     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r4) != null) goto L12;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        return bq.f20661a.a(r3, r5);
    L12:
        return (bp) ZeusTransformUtils.preCheckCast(new bp.a("invalid_log_extras_type"), bp.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    public static final Intent a(Intent r4, du r5) {
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r2 = d.n.f(r4.getStringExtra("log_extras"));     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r2) == false) goto L10;
        r2 = null;
    L10:
        Intent r6 = r4.putExtra("log_extras", a((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), r5));
        d.h.b.o.c(r6, "putExtra(...)");
        return r6;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L8
    }
}

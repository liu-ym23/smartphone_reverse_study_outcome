package com.obric.autogui.agents.vlm.models.omni;

import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import java.util.Map;

/* JADX INFO: compiled from: OmniUserInteractionProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f28887a = null;

    static {
        f28887a = new w();
    }

    private w() {
    }

    public final boolean a(String r1, Boolean r2) {
        if (d.h.b.o.a(r1, "ai_proactive") == true) goto L5;
        return false;
    L5:
        if (d.h.b.o.a(r2, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean a(Bundle r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.containsKey("allow_user_interaction") == true) goto L7;
        return false;
    L7:
        return a(r3.getString("caller_source"), Boolean.valueOf(r3.getBoolean("allow_user_interaction")));
    }

    public static /* synthetic */ ac a(w r0, int r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final ac a(int r2, String r3, String r4) {
        d.h.b.o.e(r3, "endReason");
        Map r1 = ao.a();
        r1.put("end_reason", r3);
        if (r4 == null) goto L5;
        r1.put("trigger_reason", r4);
    L5:
        d.x r5 = d.x.f38692a;
        return new ac(r2, ao.a(r1));
    }

    public final ac a(int r7, String r8) {
        switch(r7) {
            case 1200: goto L8;
            case 1201: goto L12;
            case 1202: goto L11;
            case 1203: goto L10;
            default: goto L9;
        };
    L9:
        return a(this, 109000, SensitiveType.UNKNOWN, null, 4, null);
    L10:
        return a(this, 109004, "manual_operation", null, 4, null);
    L11:
        return a(109003, "clarify", a(r8));
    L12:
        return a(this, 109002, "user_addition", null, 4, null);
    L8:
        return a(109001, "call_user", a(r8));
    }

    public final boolean a(int r3) {
        return ax.a(new Integer[]{109000, 109001, 109002, 109003, 109004, 109006}).contains(Integer.valueOf(r3));
    }

    private final String a(String r2) {
        if (r2 != null) goto L4;
    L8:
        return SensitiveType.UNKNOWN;
    L4:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L8;
        return r2;
    }
}

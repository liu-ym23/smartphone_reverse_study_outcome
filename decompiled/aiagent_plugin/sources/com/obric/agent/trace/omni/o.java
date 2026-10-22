package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: PrivacyGrantAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f15698a = null;

    static {
        f15698a = new o();
    }

    private o() {
    }

    public final n a(boolean r4, String r5, int r6, Map<String, String> r7) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r4 == false) goto L30;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == true) goto L31;
        if (r6 != 1) goto L32;
        if (r3 != null) goto L16;
        return null;
    L16:
        if (d.h.b.o.a(r3.get("send_message_scene"), "o_user_selection_button") == true) goto L19;
        return null;
    L19:
        if (r3.containsKey("o_user_selection_type") == true) goto L21;
    L23:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_user_selection_button_result"), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r10, "allow") == false) goto L27;
        return new n(r5, "grant", true);
    L27:
        if (d.h.b.o.a(r10, "reject") == true) goto L29;
        return null;
    L29:
        return new n(r5, "deny", false);
    L21:
        if (d.h.b.o.a(r3.get("o_user_selection_type"), "ai_operate_phone_confirmation") == true) goto L23;
        return null;
    L32:
        return null;
    L31:
        return null;
    L7:
        if (d.o.o.d(r8) == true) goto L10;
        r9 = false;
        goto L11
    L30:
        return null;
    }
}

package com.obric.autoaction.app.launcherpage.condition.config.condition;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;
import java.util.List;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final com.obric.oui.picker.reels.a.c.b a(String r8) {
        if (r8 != null) goto L23;
        return null;
    L23:
        List r9 = o.b((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{":"}, false, 0, 6, null);     // Catch: Exception -> L22
        int r3 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r9.get(0), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L22
        boolean r4 = true;
        int r10 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r9.get(1), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L22
        if (r3 >= 0) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L25;
        if (r10 >= 0) goto L14;
    L16:
        r4 = false;
    L17:
        if (r4 == false) goto L26;
        return new com.obric.oui.picker.reels.a.c.b(r3, r10, 0);
    L26:
        return null;
    L14:
        if (r10 >= 60) goto L16;
    L25:
        return null;
    L8:
        if (r3 >= 24) goto L10;
        r0 = true;
    L27:
        return null;
    }

    public static final String a(com.obric.oui.picker.reels.a.c.b r4) {
        d.h.b.o.e(r4, "<this>");
        return o.a(String.valueOf(r4.a()), 2, '0') + ':' + o.a(String.valueOf(r4.b()), 2, '0');
    }
}

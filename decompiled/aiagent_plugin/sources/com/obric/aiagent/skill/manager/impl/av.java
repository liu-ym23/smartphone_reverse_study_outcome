package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: SkillCoverStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class av {
    public static final Set<String> a(String r1, String r2, boolean r3) {
        d.h.b.o.e(r1, "oldUrl");
        d.h.b.o.e(r2, "newUrl");
        if (d.h.b.o.a(r1, r2) == true) goto L5;
        if (r3 == true) goto L9;
        r1 = r2;
    L9:
        Set<String> r4 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        r4 = d.a.ax.a(r1);
    L15:
        if (r4 == null) goto L17;
        return r4;
    L17:
        return d.a.ax.b();
    L5:
        return d.a.ax.b();
    }
}

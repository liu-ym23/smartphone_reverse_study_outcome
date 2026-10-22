package com.obric.autogui.agents.a.e.a;

import android.content.ComponentName;
import com.obric.autogui.agents.a.l.c;
import com.obric.autogui.agents.vlm.models.impl.b;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectPreExecutionEvidenceResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26367a = null;

    static {
        f26367a = new a();
    }

    private a() {
    }

    public final c a(e r12) {
        o.e(r12, "step");
        com.obric.autogui.agents.a.d.c r0 = null;
        if (ZeusTransformUtils.instanceOf(r12, g.class) == false) goto L5;
        g r11 = (g) ZeusTransformUtils.preCheckCast(r12, g.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        long r1 = AOSystemTools.INSTANCE.nowTimeMillis();
        com.obric.autogui.agents.vlm.models.impl.f.a r13 = r11.e(r1);
        b r14 = r11.f(r1);
        if (r13 != null) goto L13;
        if (r14 != null) goto L13;
        return null;
    L13:
        if (r14 == null) goto L15;
        ComponentName r2 = r14.b();
    L16:
        if (r13 == null) goto L18;
        List<ViewHierarchyDump> r3 = r13.a();
    L19:
        if (r14 == null) goto L22;
        r0 = r14.a();
    L22:
        return new c(r2, r3, r0, null, false, 0, 56, null);
    L18:
        r3 = null;
        goto L19
    L15:
        r2 = null;
        goto L16
    L5:
        r11 = null;
        goto L6
    }
}

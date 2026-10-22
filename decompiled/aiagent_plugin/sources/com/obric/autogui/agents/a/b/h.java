package com.obric.autogui.agents.a.b;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PageComponentDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f26281a = null;

    static {
        f26281a = new h();
    }

    private h() {
    }

    @Override // com.obric.autogui.agents.a.b.a
    public Object a(b r9, d.c.d<? super com.obric.autogui.agents.a.f.b> r10) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        ComponentName r11 = r9.a().c().a();
        ComponentName r12 = r9.b().a();
        boolean r0 = true;
        if (r11 == null) goto L11;
        if (r12 == null) goto L11;
        String r5 = "before_component_hash=" + r11.hashCode() + ", before_component=" + r11.getClassName() + ", after_component_hash=" + r12.hashCode() + ", after_component=" + r12.getClassName() + ", package_changed=" + (!o.a(r11.getPackageName(), r12.getPackageName())) + ", class_changed=" + (true ^ o.a(r11.getClassName(), r12.getClassName()));
        if (o.a(r11, r12) == true) goto L10;
        return d.a(r9, com.obric.autogui.agents.a.f.k.f26442a, "top component changed", null, r5, 4, null);
    L10:
        return d.a(r9, com.obric.autogui.agents.a.f.k.f26444c, "top component unchanged", null, r5, 4, null);
    L11:
        com.obric.autogui.agents.a.f.k r1 = com.obric.autogui.agents.a.f.k.f;
        StringBuilder r2 = new StringBuilder().append("before_available=");
        if (r11 == null) goto L14;
        boolean r13 = true;
    L15:
        StringBuilder r14 = r2.append(r13).append(", after_available=");
        if (r12 != null) goto L20;
        r0 = false;
    L20:
        return d.a(r9, r1, "top component unavailable", null, r14.append(r0).toString(), 4, null);
    L14:
        r13 = false;
        goto L15
    }
}

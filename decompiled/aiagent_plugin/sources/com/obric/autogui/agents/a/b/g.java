package com.obric.autogui.agents.a.b;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.o;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: OpenAppForegroundDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f26280a = null;

    static {
        f26280a = new g();
    }

    public final boolean a(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L6;
        if (r2 == false) goto L6;
        if (r3 == false) goto L6;
        return true;
    L6:
        return false;
    }

    private g() {
    }

    @Override // com.obric.autogui.agents.a.b.a
    public Object a(b r12, d.c.d<? super com.obric.autogui.agents.a.f.b> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.a.a.a r15 = r12.a().d();
        if (ZeusTransformUtils.instanceOf(r15, com.obric.autogui.agents.a.a.a.h.class) == true) goto L5;
        r15 = null;
    L5:
        com.obric.autogui.agents.a.a.a.h r16 = (com.obric.autogui.agents.a.a.a.h) ZeusTransformUtils.preCheckCast((com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast((com.obric.autogui.agents.a.a.a.h) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.agents.a.a.a.h.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.a.a.a.h.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L8;
        ComponentName r0 = r12.b().a();
        if (r0 == null) goto L12;
        String r2 = r16.b();
        if (r2 == null) goto L18;
        Set<String> r3 = ax.a(r2);
        if (r3 == null) goto L18;
    L20:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L32;
        if (r3.contains(r0.getPackageName()) == false) goto L26;
        return d.a(r12, com.obric.autogui.agents.a.f.k.f26442a, "resolved target is foreground", null, null, 12, null);
    L26:
        if (a(r0) == false) goto L30;
        return a(r12, r16, r3);
    L30:
        return d.a(r12, com.obric.autogui.agents.a.f.k.f26444c, "resolved target is not foreground, candidate_count=" + r3.size(), null, null, 12, null);
    L32:
        if (a(r0) == true) goto L34;
        ComponentName r1 = r12.a().c().a();
        if (r1 == null) goto L38;
        boolean r17 = r16.c();
        boolean r4 = !o.a(r1, r0);
        if (a(r17, true, r4) == false) goto L43;
        return d.a(r12, com.obric.autogui.agents.a.f.k.f26442a, "deep-link open callback succeeded and foreground changed", null, "callback_succeeded=true, foreground_changed=true", 4, null);
    L43:
        return d.a(r12, com.obric.autogui.agents.a.f.k.f26444c, "open target package unresolved", null, "callback_succeeded=" + r17 + ", foreground_changed=" + r4, 4, null);
    L38:
        return d.a(r12, com.obric.autogui.agents.a.f.k.f, "baseline foreground component unavailable", null, null, 12, null);
    L34:
        return d.a(r12, com.obric.autogui.agents.a.f.k.f, "open target package unresolved on permission page", null, a(r16.c(), r12.b().d(), ax.b()), 4, null);
    L18:
        r3 = r16.a();
        goto L20
    L12:
        return d.a(r12, com.obric.autogui.agents.a.f.k.f, "foreground component unavailable", null, null, 12, null);
    L8:
        return d.a(r12, com.obric.autogui.agents.a.f.k.f, "open app action evidence unavailable", null, null, 12, null);
    }

    private final com.obric.autogui.agents.a.f.b a(b r10, com.obric.autogui.agents.a.a.a.h r11, Set<String> r12) {
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.l.b r0 = r10.b().d();
        String r6 = a(r11.c(), r0, r13);
        if (r11.c() == false) goto L5;
        if (r0 == null) goto L23;
        if (r0.c() == null) goto L23;
        if (r13.contains(r0.c()) == true) goto L15;
        return d.a(r10, com.obric.autogui.agents.a.f.k.f26444c, "permission page task owner does not match target", null, r6, 4, null);
    L15:
        if (r0.d() == null) goto L21;
        if (r13.contains(r0.d()) == true) goto L21;
        return d.a(r10, com.obric.autogui.agents.a.f.k.f, "permission page task ownership inconsistent", null, r6, 4, null);
    L21:
        return d.a(r10, com.obric.autogui.agents.a.f.k.f26442a, "resolved target owns foreground permission request", null, r6, 4, null);
    L23:
        return d.a(r10, com.obric.autogui.agents.a.f.k.f, "permission page task ownership unavailable", null, r6, 4, null);
    L5:
        return d.a(r10, com.obric.autogui.agents.a.f.k.f26444c, "open callback failed on permission page", null, r6, 4, null);
    }

    private final String a(boolean r8, com.obric.autogui.agents.a.l.b r9, Set<String> r10) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin");
        String r11 = null;
        if (r9 == null) goto L5;
        String r0 = r9.c();
    L6:
        boolean r1 = true;
        if (r0 == null) goto L9;
        boolean r2 = true;
    L10:
        if (r9 == null) goto L16;
        String r3 = r9.c();
        if (r3 == null) goto L16;
        if (r7.contains(r3) != true) goto L16;
        boolean r4 = true;
    L17:
        if (r9 == null) goto L19;
        r11 = r9.d();
    L19:
        if (r11 == null) goto L21;
        boolean r12 = true;
    L22:
        if (r9 == null) goto L28;
        String r5 = r9.d();
        if (r5 == null) goto L28;
        if (r7.contains(r5) != true) goto L28;
        boolean r13 = true;
    L29:
        if (r4 == false) goto L33;
        if (r12 == false) goto L32;
        if (r13 == false) goto L33;
    L32:
        boolean r6 = true;
    L34:
        StringBuilder r14 = new StringBuilder().append("permission_page=true, callback_succeeded=").append(r8).append(", task_facts_available=");
        if (r9 != null) goto L39;
        r1 = false;
    L39:
        return r14.append(r1).append(", real_owner_available=").append(r2).append(", real_owner_matches=").append(r4).append(", base_owner_available=").append(r12).append(", base_owner_matches=").append(r13).append(", owner_consistent=").append(r6).toString();
    L33:
        r6 = false;
    L28:
        r13 = false;
        goto L29
    L21:
        r12 = false;
    L16:
        r4 = false;
        goto L17
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    private final boolean a(ComponentName r2) {
        if (o.a(r2.getPackageName(), "com.android.permissioncontroller") == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r2.getClassName(), "com.android.permissioncontroller.permission.ui.GrantPermissionsActivity") == false) goto L7;
        return true;
    }
}

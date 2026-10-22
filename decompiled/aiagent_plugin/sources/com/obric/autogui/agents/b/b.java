package com.obric.autogui.agents.b;

import android.content.ComponentName;
import com.bytedance.security.zenmobile.io.SensitiveType;
import d.h.b.o;

/* JADX INFO: compiled from: CCApplicationAccessUiReadyJudge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final boolean a(ComponentName r2) {
        String r0 = null;
        if (r2 == null) goto L5;
        String r1 = r2.getPackageName();
    L6:
        if (r2 == null) goto L9;
        r0 = r2.getClassName();
    L9:
        return a(r1, r0);
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean a(String r1, String r2) {
        if (o.a(r1, "com.android.virtualdevicemanager") == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r2, "com.android.virtualdevicemanager.RequestComputerControlAccessActivity") == false) goto L7;
        return true;
    }

    public static final boolean a(boolean r2, ComponentName r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getPackageName();
    L6:
        if (r3 == null) goto L9;
        r0 = r3.getClassName();
    L9:
        return a(r2, r1, r0);
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean a(boolean r0, String r1, String r2) {
        if (r0 == true) goto L4;
    L6:
        return false;
    L4:
        if (a(r1, r2) == true) goto L6;
        return true;
    }

    public static final boolean a(com.obric.autogui.session.a r1) {
        o.e(r1, SensitiveType.SESSION);
        com.obric.autogui.session.b.C0834b r2 = r1.E().a();
        if (r2 == null) goto L5;
        String r3 = r2.a();
    L7:
        return o.a(r3, "computer_control_apply_app_permission");
    L5:
        r3 = null;
        goto L7
    }
}

package com.obric.autogui.util;

import com.obric.autogui.common.api.platform.AOPlatformTools;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoReportCMHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f31548a = null;

    static {
        f31548a = new f();
    }

    private f() {
    }

    public final void a() {
        AOPlatformTools.INSTANCE.special().reportOAutoEventToCM(6, 1, -1, null);
    }

    public final void b() {
        AOPlatformTools.INSTANCE.special().reportOAutoEventToCM(6, 0, -1, null);
    }

    public final void a(boolean r4) {
        AOPlatformTools.INSTANCE.special().reportOAutoEventToCM(7, r4 ? 1 : 0, -1, null);
    }

    public final void a(String r4) {
        o.e(r4, "name");
        AOPlatformTools.INSTANCE.special().reportOAutoEventToCM(8, 2, -1, r4);
    }
}

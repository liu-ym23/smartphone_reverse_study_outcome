package com.obric.autoaction.app.launcherpage.module.view;

import android.content.Context;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final String TAG = "LcPage-Util";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f24296a = null;

    static {
        f24296a = new f();
    }

    private f() {
    }

    public static /* synthetic */ void a(f r9, Context r10, String r11, String r12, String r13, String r14, boolean r15, int r16, int r17, Object r18) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if ((r17 & 2) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r17 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r17 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r17 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r17 & 32) == 0) goto L21;
        boolean r7 = false;
    L22:
        r9.a(r2, r3, r4, r5, r6, r7, r16);
        return;
    L21:
        r7 = r15;
        goto L22
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final void a(Context r13, String r14, String r15, String r16, String r17, boolean r18, int r19) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        com.obric.autogui.util.ui.a.a(com.obric.autogui.util.ui.a.f31573a, r2, r14, r15, r16, r17, r18, r19, null, 128, null);
    }

    public final boolean a() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_share", false);
    }
}

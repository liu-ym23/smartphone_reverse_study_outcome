package com.obric.autogui.util.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AutoAgentAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionQueryInitiator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "AA-UIUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f31574b;

    static {
        f31573a = new a();
    }

    private a() {
    }

    private final boolean a() {
        long r0 = f31574b;
        f31574b = com.obric.autogui.util.e.a.a();
        if (r0 <= 0) goto L8;
        long r2 = com.obric.autogui.util.e.a.a() - r0;
        if (r2 >= 800) goto L10;
        Loog.INSTANCE.e(TAG, "openQueryWindow - too frequent! it's only " + r2 + " before last request.");
        return false;
    L10:
        return true;
    L8:
        return true;
    }

    public static /* synthetic */ void a(a r9, Context r10, String r11, String r12, String r13, String r14, boolean r15, int r16, Bundle r17, int r18, Object r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        Bundle r3 = null;
        if ((r18 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r18 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r18 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r18 & 32) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r18 & 64) == 0) goto L25;
        int r8 = 1;
    L27:
        if ((r18 & 128) != 0) goto L30;
        r3 = r17;
    L30:
        r9.a(r1, r2, r4, r5, r6, r7, r8, r3);
        return;
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = r15;
        goto L23
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
        r2 = r11;
        goto L7
    }

    public final void a(Context r3, String r4, String r5, String r6, String r7, boolean r8, int r9, Bundle r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        if (a() == true) goto L5;
        return;
    L5:
        Intent r2 = new Intent();
        r2.setClassName(r11, "com.obric.autoaction.presentation.FloatingWindowService");
        r2.setAction(AutoAgentAction.ACTION_SHOW_INPUT_WINDOW);
        if (r4 == null) goto L8;
        r2.putExtra("preset_query", r4);
        r2.putExtra("start_at_once", r8);
    L8:
        if (r6 == null) goto L11;
        if (r7 == null) goto L11;
        r2.putExtra("preset_query_prefix", r6);
        r2.putExtra("preset_query_prefix_tag", r7);
    L11:
        r2.putExtra("launched_origin", r9);
        r2.putExtra("preset_query_hint", r5);
        if (r10 == null) goto L14;
        r2.putExtra("task_extras", r10);
    L14:
        ZeusTransformUtils.startService(r11, r2, "com.obric.aiagent.plugin");
    }
}

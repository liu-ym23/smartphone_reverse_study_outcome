package com.obric.autoaction.app.launcherpage.b;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LauncherFloatingTransition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final void a(OFloatingTitleBar r1) {
        o.e(r1, "<this>");
        r1.setFloatingTransitionEnabled(true);
    }

    public static final Activity a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
    L4:
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == true) goto L8;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L4
    L8:
        return (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin");
    L10:
        return null;
    }
}

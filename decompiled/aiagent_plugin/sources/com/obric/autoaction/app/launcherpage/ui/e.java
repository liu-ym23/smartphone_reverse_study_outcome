package com.obric.autoaction.app.launcherpage.ui;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.ComponentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PowerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final ComponentActivity a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
    L4:
        if (r4 == null) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, ComponentActivity.class) == true) goto L8;
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L12;
        ContextWrapper r5 = (ContextWrapper) ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.aiagent.plugin");
    L13:
        if (r5 != null) goto L14;
        r4 = null;
        goto L4
    L14:
        r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L4
    L12:
        r5 = null;
        goto L13
    L8:
        return (ComponentActivity) ZeusTransformUtils.preCheckCast(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
    L16:
        return null;
    }
}

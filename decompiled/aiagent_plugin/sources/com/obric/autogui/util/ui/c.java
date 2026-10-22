package com.obric.autogui.util.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ContextExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == true) goto L9;
        r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "getBaseContext(...)");
        goto L6
    L9:
        return true;
    L11:
        return false;
    }
}

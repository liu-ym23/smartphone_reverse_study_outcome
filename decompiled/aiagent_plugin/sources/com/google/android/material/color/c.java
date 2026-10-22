package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    static void a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        r5.getTheme().applyStyle(r4, true);
        if (ZeusTransformUtils.instanceOf(r5, Activity.class) == false) goto L8;
        Resources.Theme r6 = a((Activity) ZeusTransformUtils.preCheckCast(r5, Activity.class, "com.obric.aiagent.plugin"));
        if (r6 == null) goto L9;
        r6.applyStyle(r4, true);
        return;
    L9:
        return;
    }

    private static Resources.Theme a(Activity r2) {
        Window r3 = ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r3 == null) goto L10;
        View r4 = r3.peekDecorView();
        if (r4 == null) goto L12;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.getTheme();
    L12:
        return null;
    L10:
        return null;
    }
}

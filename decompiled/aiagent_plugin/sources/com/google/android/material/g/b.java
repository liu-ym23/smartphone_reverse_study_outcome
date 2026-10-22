package com.google.android.material.g;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MaterialAttributes.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static TypedValue a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        TypedValue r0 = new TypedValue();
        if (r4.getTheme().resolveAttribute(r3, r0, true) == false) goto L5;
        return r0;
    L5:
        return null;
    }

    public static int a(Context r4, int r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        TypedValue r0 = a(r7, r5);
        if (r0 == null) goto L7;
        return r0.data;
    L7:
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{r6, ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getResourceName(r5)}));
    }

    public static int a(View r3, int r4) {
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r3.getClass().getCanonicalName());
    }

    public static boolean a(Context r2, int r3, boolean r4) {
        TypedValue r5 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
        if (r5 != null) goto L5;
        return r4;
    L5:
        if (r5.type == 18) goto L7;
        return r4;
    L7:
        if (r5.data == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int a(Context r2, int r3, int r4) {
        TypedValue r5 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
        if (r5 != null) goto L5;
        return r4;
    L5:
        if (r5.type == 16) goto L7;
        return r4;
    L7:
        return r5.data;
    }
}

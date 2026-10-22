package com.bumptech.glide.load.resource.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.b.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DrawableDecoderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f3777a = true;

    static {
    }

    public static Drawable a(Context r2, Context r3, int r4) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, null);
    }

    public static Drawable a(Context r2, int r3, Resources.Theme r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return a(r5, r5, r3, r4);
    }

    private static Drawable a(Context r2, Context r3, int r4, Resources.Theme r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
    L7:
        e = move-exception;
        if (r6.getPackageName().equals(r7.getPackageName()) == false) goto L11;
        throw e;
    L11:
        return androidx.core.content.a.a(r7, r4);
    L13:
        f3777a = false;
        goto L14
    L4:
        if (f3777a == false) goto L14;
        return b(r7, r4, r5);
    L14:
        if (r5 != null) goto L18;
        r5 = r7.getTheme();
    L18:
        return c(r7, r4, r5);
    }

    private static Drawable b(Context r2, int r3, Resources.Theme r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r5 = new ContextThemeWrapper(r5, r4);
    L6:
        return androidx.appcompat.a.a.a.b(r5, r3);
    }

    private static Drawable c(Context r2, int r3, Resources.Theme r4) {
        return h.a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin"), r3, r4);
    }
}

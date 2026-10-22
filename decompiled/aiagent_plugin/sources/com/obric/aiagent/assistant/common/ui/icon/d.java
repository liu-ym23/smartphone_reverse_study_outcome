package com.obric.aiagent.assistant.common.ui.icon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskIconResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16141a = null;

    static {
        f16141a = new d();
    }

    private d() {
    }

    public static final e a(String r1) {
        e r0 = e.f16143a.a(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r2 = c.a(r1, null, r1);
        e r3 = e.f16143a.a(r2);
        if (r3 == null) goto L8;
        return r3;
    L8:
        return e.f16146d;
    }

    public static final e a(String r1, String r2) {
        e r3 = e.f16143a.a(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        String r4 = c.a("general", null, r2);
        e r5 = e.f16143a.a(r4);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return e.f16146d;
    }

    public static final int b(String r0) {
        return a(r0).b();
    }

    public static final Drawable a(Context r2, String r3, String r4, Integer r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        int r7 = b(r3);
        if (r5 == null) goto L6;
        return TaskIconGradientTintDrawable.a(r6, r7, r5.intValue());
    L6:
        return a.a(r6, r7, r4);
    }

    public static final void a(ImageView r3, String r4, String r5, Integer r6) {
        o.e(r3, "imageView");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "getContext(...)");
        r3.setImageDrawable(a(r0, r4, r5, r6));
        r3.setImageTintList(null);
        r3.clearColorFilter();
    }

    public static final void a(ImageView r2, String r3, String r4, String r5) {
        o.e(r2, "imageView");
        int r6 = a(r3, r5).b();
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "getContext(...)");
        r2.setImageDrawable(a.a(r7, r6, r4));
        r2.clearColorFilter();
    }
}

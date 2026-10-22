package com.bytedance.apm.perf.memory.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.apm.h.e;
import com.bytedance.apm.m.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActivityLeakFixer.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "ActivityLeakFixer";

    public static void a(String r10) {
        boolean r0 = c.b("activity_leak_event");
        if (com.bytedance.apm.c.i() == false) goto L5;
        e.c(TAG, new String[]{"activity_leak_event : " + r0});
    L5:
        if (r0 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L17;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L11
        r7.put(r10, 1);     // Catch: Exception -> L11
        com.bytedance.apm.d.a.a.c().a(new com.bytedance.apm.d.b.c("activity_leak_event", 0, null, r7, null, null));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void a(Activity r9) {
        Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r9, Activity.class, "com.obric.aiagent.plugin");
        long r2 = System.currentTimeMillis();
        if (r10 == null) goto L26;
        if (ZeusTransformUtils.getWindow(r10, "com.obric.aiagent.plugin") == null) goto L26;
        if (ZeusTransformUtils.getWindow(r10, "com.obric.aiagent.plugin").peekDecorView() == null) goto L26;
    L21:
        th = move-exception;
        if (com.bytedance.apm.c.i() == false) goto L29;
        e.b(TAG, new String[]{"caught unexpected exception when unbind drawables.", th.getMessage()});
    L29:
        if (com.bytedance.apm.c.i() == false) goto L34;
        e.c(TAG, new String[]{"unbindDrawables done, cost: " + (System.currentTimeMillis() - r2) + " ms."});
        return;
    L34:
        return;
    L9:
        if (Build.VERSION.SDK_INT <= 16) goto L14;
        if (r10.isDestroyed() == true) goto L14;
        return;
    L14:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ZeusTransformUtils.getWindow(r10, "com.obric.aiagent.plugin").getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != r10) goto L29;
        View r6 = ZeusTransformUtils.getWindow(r10, "com.obric.aiagent.plugin").peekDecorView().getRootView();     // Catch: Throwable -> L21
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6.findViewById(R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r7.getChildCount() <= 0) goto L29;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getChildAt(0).getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != r10) goto L29;
        a(r6, r10);     // Catch: Throwable -> L21
    L26:
        if (com.bytedance.apm.c.i() == false) goto L29;
        e.c(TAG, new String[]{"unbindDrawables, ui or ui's window is null, skip rest works."});
        goto L29
    }

    private static void a(View r3, Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L9;
        return;
    L9:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != r5) goto L17;
        a(r3);
        if (ZeusTransformUtils.instanceOf(r3, ImageView.class) == false) goto L14;
        a((ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.aiagent.plugin"));
    L14:
        if (ZeusTransformUtils.instanceOf(r3, TextView.class) == false) goto L17;
        a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin"));
    L17:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L20;
        a((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin"), r5);
        return;
    }

    private static void a(View r2) {
        if (r2.getBackground() == null) goto L9;
        r2.getBackground().setCallback(null);     // Catch: Throwable -> L6
        r2.setBackgroundDrawable(null);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    private static void a(ImageView r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Drawable r0 = r2.getDrawable();
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        r2.setImageDrawable(null);
    }

    private static void a(TextView r5) {
        Drawable[] r0 = r5.getCompoundDrawables();
        int r1 = r0.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        Drawable r4 = r0[r2];
        if (r4 == null) goto L8;
        r4.setCallback(null);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        r5.setCompoundDrawables(null, null, null, null);
    }

    private static void a(ViewGroup r3, Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        int r0 = r3.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(r3.getChildAt(r1), r5);
        r1 = r1 + 1;
        goto L3
    }
}

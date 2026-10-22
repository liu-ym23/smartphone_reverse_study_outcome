package com.bytedance.bdturing.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.bdturing.e;
import com.bytedance.bdturing.g;
import com.bytedance.common.utility.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.t;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final StringBuilder a(StringBuilder r1, String r2, int r3) {
        o.d(r1, "$this$appendParams");
        o.d(r2, "key");
        return a(r1, r2, String.valueOf(r3));
    }

    public static final StringBuilder a(StringBuilder r1, String r2, String r3) {
        o.d(r1, "$this$appendParams");
        o.d(r2, "key");
        if (r3 != null) goto L10;
        return r1;
    L10:
        r1.append("&").append(r2).append("=").append(URLEncoder.encode(r3, "utf-8"));     // Catch: UnsupportedEncodingException -> L7
    L9:
        return r1;
    L7:
        e = move-exception;
        g.a((Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.aiagent.plugin"));
        goto L9
    }

    public static final StringBuilder b(StringBuilder r1, String r2, String r3) {
        o.d(r1, "$this$appendFirstParam");
        o.d(r2, "key");
        if (r3 != null) goto L10;
        return r1;
    L10:
        r1.append(r2).append("=").append(URLEncoder.encode(r3, "utf-8"));     // Catch: UnsupportedEncodingException -> L7
    L9:
        return r1;
    L7:
        e = move-exception;
        g.a((Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.aiagent.plugin"));
        goto L9
    }

    public static final Activity a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.d(r4, "context");
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L16;
        Object r5 = ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.aiagent.plugin");
    L6:
        ContextWrapper r6 = (ContextWrapper) r5;
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == true) goto L13;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ContextWrapper.class) == false) goto L10;
        r5 = ZeusTransformUtils.preCheckCast(r7, ContextWrapper.class, "com.obric.aiagent.plugin");
        goto L6
    L10:
        return null;
    L13:
        return (Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.aiagent.plugin");
    L16:
        return null;
    }

    public static final StringBuilder a(String r9, JSONObject r10) {
        o.d(r9, "url");
        o.d(r10, "params");
        StringBuilder r0 = new StringBuilder(r9);
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), '?', 0, false, 6, null) >= 0) goto L5;
        r0.append("?");
    L6:
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<String> r1 = r10.keys();
    L8:
        if (r1.hasNext() == false) goto L15;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
        r4 = r10.getString(r3);     // Catch: Exception -> L12
    L14:
        r11.add(new Pair(r3, r4));
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L15:
        r0.append(i.a(r11, "UTF-8"));
        return r0;
    L5:
        r0.append("&");
        goto L6
    }

    public static final StringBuilder a(JSONObject r7) {
        o.d(r7, "params");
        StringBuilder r0 = new StringBuilder();
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<String> r2 = r7.keys();
    L4:
        if (r2.hasNext() == false) goto L11;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
        r5 = r7.getString(r4);     // Catch: Exception -> L8
    L10:
        r1.add(new Pair(r4, r5));
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        r0.append(i.a(r1, "UTF-8"));
        return r0;
    }

    public static final int a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return 0;
    L5:
        WindowManager r5 = r4.getWindowManager();
        o.b(r5, "activity.windowManager");
        Display r6 = r5.getDefaultDisplay();
        o.b(r6, "activity.windowManager.defaultDisplay");
        int r7 = r6.getRotation();
        g.a("AbstractRequest", "rotation current " + r7);
        int r1 = 2;
        if (r7 == 0) goto L13;
        if (r7 == 1) goto L12;
        if (r7 == 2) goto L13;
        if (r7 == 3) goto L12;
        return 0;
    L12:
        r1 = 1;
    L13:
        e.b(r1);
        return r1;
    }

    public static final String b(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        Resources r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin");
        o.b(r4, "activity.resources");
        DisplayMetrics r5 = r4.getDisplayMetrics();
        int r0 = r5.widthPixels;
        int r6 = r5.heightPixels;
        return new StringBuilder().append(r0).append('*').append(r6).toString();
    }

    public static final float b(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.d(r6, "context");
        Method r0 = DisplayMetrics.class.getDeclaredMethod("getDeviceDensity", new Class[0]);     // Catch: Exception -> L8
        o.b(r0, "method");     // Catch: Exception -> L8
        r0.setAccessible(true);     // Catch: Exception -> L8
        Object r1 = r0.invoke(null, new Object[0]);     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.aiagent.plugin")).intValue() / 160.0f;
    L7:
        throw new t("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.b(r7, "context.applicationContext");
        Resources r8 = ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin");
        o.b(r8, "context.applicationContext.resources");
        return r8.getDisplayMetrics().density;
    }
}

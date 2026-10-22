package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f13304b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f13305c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, a> f13306d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, a> f13307e = null;

    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final com.google.android.material.color.a dynamicColorsOptions;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        DynamicColorsActivityLifecycleCallbacks(com.google.android.material.color.a r1) {
            this.dynamicColorsOptions = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity r2, Bundle r3) {
            DynamicColors.a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), this.dynamicColorsOptions.a(), this.dynamicColorsOptions.b(), this.dynamicColorsOptions.c());
        }
    }

    private interface a {
        boolean a();
    }

    public interface b {
        void a(Activity r1);
    }

    public interface c {
        boolean a(Activity r1, int r2);
    }

    static /* synthetic */ void a(Activity r2, int r3, c r4, b r5) {
        b((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), r3, (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin"));
    }

    static {
        f13303a = new int[]{ZeusTransformUtils.mapRes(R.attr.dynamicColorThemeOverlay, "attr", "dynamicColorThemeOverlay")};
        a r0 = new AnonymousClass1();
        f13304b = r0;
        a r1 = new AnonymousClass2();
        f13305c = r1;
        HashMap r2 = new HashMap();
        r2.put("google", r0);
        r2.put("hmd global", r0);
        r2.put("infinix", r0);
        r2.put("infinix mobility limited", r0);
        r2.put("itel", r0);
        r2.put("kyocera", r0);
        r2.put("lenovo", r0);
        r2.put("lge", r0);
        r2.put("motorola", r0);
        r2.put("nothing", r0);
        r2.put("oneplus", r0);
        r2.put("oppo", r0);
        r2.put("realme", r0);
        r2.put("robolectric", r0);
        r2.put("samsung", r1);
        r2.put("sharp", r0);
        r2.put("sony", r0);
        r2.put("tcl", r0);
        r2.put("tecno", r0);
        r2.put("tecno mobile limited", r0);
        r2.put("vivo", r0);
        r2.put("xiaomi", r0);
        f13306d = Collections.unmodifiableMap(r2);
        HashMap r3 = new HashMap();
        r3.put("asus", r0);
        r3.put("jio", r0);
        f13307e = Collections.unmodifiableMap(r3);
    }

    private static void b(Activity r2, int r3, c r4, b r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        if (a() == true) goto L5;
        return;
    L5:
        if (r3 != 0) goto L7;
        r3 = a(r6);
    L7:
        if (r3 != 0) goto L9;
        return;
    L9:
        if (r7.a(r6, r3) == false) goto L13;
        com.google.android.material.color.c.a(r6, r3);
        r8.a(r6);
        return;
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return false;
    L5:
        a r0 = (a) ZeusTransformUtils.preCheckCast(f13306d.get(Build.MANUFACTURER.toLowerCase()), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        r0 = (a) ZeusTransformUtils.preCheckCast(f13307e.get(Build.BRAND.toLowerCase()), a.class, "com.obric.aiagent.plugin");
    L8:
        if (r0 != null) goto L10;
        return false;
    L10:
        if (r0.a() == false) goto L14;
        return true;
    L14:
        return false;
    }

    private static int a(Context r2) {
        TypedArray r3 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(f13303a);
        int r0 = r3.getResourceId(0, 0);
        r3.recycle();
        return r0;
    }
}

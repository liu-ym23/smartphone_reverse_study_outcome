package com.bytedance.bdinstall.d;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.crash.general.HardwareInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: compiled from: DisplayLoader.java */
/* JADX INFO: loaded from: classes.dex */
class o extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6232e;

    o(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(true, false);
        this.f6232e = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r3) {
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this.f6232e, "com.obric.aiagent.plugin").getDisplayMetrics();
        b(r3, r0);
        a(r3, r0);
        return true;
    }

    private void a(JSONObject r5, DisplayMetrics r6) {
        int r7 = r6.densityDpi;
        if (r7 > 120) goto L6;
        String r8 = "ldpi";
    L21:
        r5.put("display_density_v2", r8);
        int[] r4 = a();
        r5.put("resolution_v2", r4[1] + "x" + r4[0]);
        if (com.bytedance.bdinstall.t.a() == false) goto L25;
        com.bytedance.bdinstall.t.a("resolution " + r4[1] + "x" + r4[0]);
        return;
    L25:
        return;
    L6:
        if (r7 > 160) goto L9;
        r8 = "mdpi";
        goto L21
    L9:
        if (r7 > 240) goto L12;
        r8 = "hdpi";
        goto L21
    L12:
        if (r7 > 320) goto L15;
        r8 = "xhdpi";
        goto L21
    L15:
        if (r7 > 480) goto L18;
        r8 = "xxhdpi";
        goto L21
    L18:
        if (r7 > 640) goto L20;
        r8 = "xxxhdpi";
        goto L21
    L20:
        r8 = "xxxxhdpi";
        goto L21
    }

    private void b(JSONObject r3, DisplayMetrics r4) {
        int r2 = r4.densityDpi;     // Catch: Exception -> L14
        if (r2 != 120) goto L5;
        String r0 = "ldpi";
    L12:
        r3.put(HardwareInfo.KEY_HW_DENSITY_DPI, r2);     // Catch: Exception -> L14
        r3.put(HardwareInfo.KEY_HW_DISPLAY_DENSITY, r0);     // Catch: Exception -> L14
        r3.put(HardwareInfo.KEY_HW_DISPLAY_RESOLUTION, r4.heightPixels + "x" + r4.widthPixels);     // Catch: Exception -> L14
        return;
    L5:
        if (r2 != 240) goto L7;
        r0 = "hdpi";
        goto L12
    L7:
        if (r2 == 320) goto L9;
        r0 = "mdpi";
        goto L12
    L9:
        r0 = "xhdpi";
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    private int[] a() {
        WindowManager r6 = (WindowManager) ZeusTransformUtils.preCheckCast(this.f6232e.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        DisplayMetrics r2 = new DisplayMetrics();     // Catch: Throwable -> L34
        Display r7 = r6.getDefaultDisplay();     // Catch: Throwable -> L34
        int r3 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L34
        if (r3 < 17) goto L39;
        r7.getRealMetrics(r2);     // Catch: Throwable -> L34
        int r8 = r2.widthPixels;     // Catch: Throwable -> L34
        int r0 = r2.heightPixels;     // Catch: Throwable -> L8
    L38:
        return new int[]{r8, r0};
    L8:
        th = th;
    L40:
    L36:
        th.printStackTrace();
        r0 = 0;
        goto L38
    L39:
        Method r4 = Display.class.getMethod("getRawHeight", new Class[0]);     // Catch: Throwable -> L34
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(Display.class.getMethod("getRawWidth", new Class[0]).invoke(r7, new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L25 IllegalArgumentException -> L28 Throwable -> L34
    L47:
        r0 = ((Integer) ZeusTransformUtils.preCheckCast(r4.invoke(r7, new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16 IllegalArgumentException -> L18 Throwable -> L32
    L24:
        r8 = r5;
        goto L38
    L16:
        e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L32
    L23:
        r0 = 0;
    L18:
        e = e;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L32
    L14:
        e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L32
    L25:
        e = e;
        r5 = 0;
    L28:
        e = e;
        r5 = 0;
    L20:
        e = e;
        r5 = 0;
    L32:
        th = th;
        r8 = r3;
    L34:
        th = th;
        r8 = 0;
        goto L36
    }
}

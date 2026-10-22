package com.bytedance.memory.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.math.BigDecimal;

/* JADX INFO: compiled from: MemoryUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f8774a = -1;

    static {
    }

    public static float a() {
        float r0 = ((float) new BigDecimal(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()).divide(new BigDecimal(b()), 4, 4).doubleValue()) * 100.0f;
        c.a("currentRate %f", new Object[]{Float.valueOf(r0)});
        return r0;
    }

    private static long b() {
        long r0 = f8774a;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        long r1 = Runtime.getRuntime().maxMemory();
        f8774a = r1;
        return r1;
    }

    public static void a(File r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == true) goto L7;
        return;
    L7:
        if (r5.isDirectory() == false) goto L17;
        File[] r0 = r5.listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L17;
        File r3 = r0[r2];
        if (r3.isFile() == false) goto L14;
        r3.delete();
    L16:
        r2 = r2 + 1;
        goto L9
    L14:
        if (r5.isDirectory() == false) goto L16;
        a(r3);
    L17:
        r5.delete();
    }

    public static boolean a(Context r2) {
        if ((((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static void a(Context r2, Class<?> r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L10;
        ComponentName r0 = new ComponentName(r5, r3);
        PackageManager r6 = r5.getPackageManager();
        if (r4 == false) goto L7;
        int r7 = 1;
    L8:
        ZeusTransformUtils.setComponentEnabledSetting(r6, r0, r7, 1);
        return;
    L7:
        r7 = 2;
        goto L8
    }
}

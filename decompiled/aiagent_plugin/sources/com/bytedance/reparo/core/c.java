package com.bytedance.reparo.core;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: DexCacheCleaner.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f9160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet f9161b;

    public c() {
        this.f9161b = new HashSet();
    }

    static {
        Field r0 = Class.class.getDeclaredField("dexCache");     // Catch: NoSuchFieldException -> L4
        f9160a = r0;     // Catch: NoSuchFieldException -> L4
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void a(Class r2) {
        this.f9161b.add(f9160a.get(r2));
    }

    private void a(Object r10) {
        if (r10 == null) goto L21;
        Object r9 = com.bytedance.reparo.core.i.j.a(r10, "resolvedTypes").get(r10);
        int r4 = 0;
        if (Build.VERSION.SDK_INT < 24) goto L6;
        int r11 = com.bytedance.reparo.core.i.j.a(r10, "numResolvedTypes").getInt(r10);
        Method r1 = com.bytedance.reparo.core.i.j.a(r10, "setResolvedType", new Class[]{Integer.TYPE, Class.class});
        int r5 = 0;
    L16:
        if (r5 >= r11) goto L18;
        r1.invoke(r10, new Object[]{Integer.valueOf(r5), null});
        r5 = r5 + 1;
        goto L16
    L18:
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveTypes:" + r11);
        return;
    L6:
        if ((r9 instanceof Class[]) == false) goto L14;
        Class[] r12 = (Class[]) ZeusTransformUtils.preCheckCast((Class[]) ZeusTransformUtils.preCheckCast(r9, Class[].class, "com.obric.aiagent.plugin"), Class[].class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L10;
    L12:
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveTypes:" + r12.length);
        return;
    L10:
        if (r4 >= r12.length) goto L12;
        r12[r4] = null;
        r4 = r4 + 1;
        goto L10
    L14:
        throw new Exception("DexCache resolvedTypes is not Class[] type!");
    L21:
        throw new Exception("DexCache is null!");
    }

    private void b(Object r8) {
        if (r8 == null) goto L37;
        if (Build.VERSION.SDK_INT >= 24) goto L30;
        Object r9 = com.bytedance.reparo.core.i.j.a(r8, "resolvedFields").get(r8);
        if (r9 != null) goto L9;
        return;
    L9:
        int r2 = 0;
        if ((r9 instanceof Object[]) == false) goto L17;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r9, Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
    L13:
        if (r2 >= r7.length) goto L15;
        r7[r2] = null;
        r2 = r2 + 1;
        goto L13
    L15:
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveFields:" + r7.length);
        return;
    L17:
        if ((r9 instanceof int[]) == false) goto L24;
        int[] r10 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r9, int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
        int r11 = 0;
    L20:
        if (r11 >= r10.length) goto L22;
        r10[r11] = 0;
        r11 = r11 + 1;
        goto L20
    L22:
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveFields:" + r10.length);
        return;
    L24:
        if ((r9 instanceof long[]) == false) goto L43;
        long[] r12 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r9, long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
    L27:
        if (r2 >= r12.length) goto L29;
        r12[r2] = 0;
        r2 = r2 + 1;
        goto L27
    L29:
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveFields:" + r12.length);
        return;
    L43:
        return;
    L30:
        long r0 = com.bytedance.reparo.core.i.j.a(r8, "resolvedFields").getLong(r8);
        int r13 = com.bytedance.reparo.core.i.j.a(r8, "numResolvedFields").getInt(r8);
        if (r0 == 0) goto L45;
        if (r13 == 0) goto L46;
        WandTrick.b().clearPointerArrayMemory(r0, r13);
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveFields:" + r13);
        return;
    L46:
        return;
    L45:
        return;
    L37:
        throw new Exception("DexCache is null!");
    }

    private void c(Object r8) {
        if (r8 == null) goto L37;
        if (Build.VERSION.SDK_INT >= 24) goto L30;
        Object r9 = com.bytedance.reparo.core.i.j.a(r8, "resolvedMethods").get(r8);
        if (r9 != null) goto L9;
        return;
    L9:
        int r2 = 0;
        if ((r9 instanceof Object[]) == false) goto L17;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r9, Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
    L13:
        if (r2 >= r7.length) goto L15;
        r7[r2] = null;
        r2 = r2 + 1;
        goto L13
    L15:
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveMethods:" + r7.length);
        return;
    L17:
        if ((r9 instanceof int[]) == false) goto L24;
        int[] r10 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r9, int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
        int r11 = 0;
    L20:
        if (r11 >= r10.length) goto L22;
        r10[r11] = 0;
        r11 = r11 + 1;
        goto L20
    L22:
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveMethods:" + r10.length);
        return;
    L24:
        if ((r9 instanceof long[]) == false) goto L43;
        long[] r12 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r9, long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
    L27:
        if (r2 >= r12.length) goto L29;
        r12[r2] = 0;
        r2 = r2 + 1;
        goto L27
    L29:
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveMethods:" + r12.length);
        return;
    L43:
        return;
    L30:
        long r0 = com.bytedance.reparo.core.i.j.a(r8, "resolvedMethods").getLong(r8);
        int r13 = com.bytedance.reparo.core.i.j.a(r8, "numResolvedMethods").getInt(r8);
        if (r0 == 0) goto L45;
        if (r13 == 0) goto L46;
        WandTrick.b().clearPointerArrayMemory(r0, r13);
        com.bytedance.reparo.core.f.a.a("clearDexCacheResolveMethods:" + r13);
        return;
    L46:
        return;
    L45:
        return;
    L37:
        throw new Exception("DexCache is null!");
    }

    public void a() {
        Iterator r0 = this.f9161b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Object r1 = r0.next();
        a(r1);
        b(r1);
        c(r1);
        goto L4
    L6:
        this.f9161b.clear();
    }
}

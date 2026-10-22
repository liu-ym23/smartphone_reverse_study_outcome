package com.bytedance.reparo.core.c;

import android.os.Build;
import com.bytedance.reparo.core.i.j;
import com.obric.capabilitykit.entity.ResultCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SoLibraryHooker.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "SoLibraryHooker";

    /* JADX INFO: renamed from: com.bytedance.reparo.core.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SoLibraryHooker.java */
    private static final class C0211a {
        static /* synthetic */ void a(ClassLoader r0, File r1) {
            b(r0, r1);
        }

        private static void b(ClassLoader r8, File r9) {
            Object r10 = j.a(r8, "pathList").get(r8);
            Field r0 = j.a(r10, "nativeLibraryDirectories");
            File[] r1 = (File[]) ZeusTransformUtils.preCheckCast((File[]) ZeusTransformUtils.preCheckCast(r0.get(r10), File[].class, "com.obric.aiagent.plugin"), File[].class, "com.obric.aiagent.plugin");
            ArrayList r2 = new ArrayList(r1.length + 1);
            r2.add(r9);
            int r3 = r1.length;
            int r5 = 0;
        L3:
            if (r5 >= r3) goto L8;
            File r6 = r1[r5];
            if (r9.equals(r6) == true) goto L7;
            r2.add(r6);
        L7:
            r5 = r5 + 1;
            goto L3
        L8:
            r0.set(r10, r2.toArray(new File[0]));
        }
    }

    /* JADX INFO: compiled from: SoLibraryHooker.java */
    private static final class b {
        static /* synthetic */ void a(ClassLoader r0, File r1) {
            b(r0, r1);
        }

        private static void b(ClassLoader r7, File r8) {
            Object r9 = j.a(r7, "pathList").get(r7);
            List r0 = (List) ZeusTransformUtils.preCheckCast(j.a(r9, "nativeLibraryDirectories").get(r9), List.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            r0 = new ArrayList(2);
        L5:
            Iterator r3 = r0.iterator();
        L7:
            if (r3.hasNext() == false) goto L11;
            if (r8.equals((File) ZeusTransformUtils.preCheckCast(r3.next(), File.class, "com.obric.aiagent.plugin")) == false) goto L7;
            r3.remove();
        L11:
            r0.add(0, r8);
            List r10 = (List) ZeusTransformUtils.preCheckCast(j.a(r9, "systemNativeLibraryDirectories").get(r9), List.class, "com.obric.aiagent.plugin");
            if (r10 != null) goto L14;
            r10 = new ArrayList(2);
        L14:
            ArrayList r4 = new ArrayList((r0.size() + r10.size()) + 1);
            r4.addAll(r0);
            r4.addAll(r10);
            j.a(r9, "nativeLibraryPathElements").set(r9, (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(j.a(r9, "makePathElements", new Class[]{List.class, File.class, List.class}).invoke(r9, new Object[]{r4, null, new ArrayList()}), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SoLibraryHooker.java */
    private static final class c {
        static /* synthetic */ void a(ClassLoader r0, File r1) {
            b(r0, r1);
        }

        private static void b(ClassLoader r6, File r7) {
            Object r8 = j.a(r6, "pathList").get(r6);
            List r0 = (List) ZeusTransformUtils.preCheckCast(j.a(r8, "nativeLibraryDirectories").get(r8), List.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            r0 = new ArrayList(2);
        L5:
            Iterator r3 = r0.iterator();
        L7:
            if (r3.hasNext() == false) goto L11;
            if (r7.equals((File) ZeusTransformUtils.preCheckCast(r3.next(), File.class, "com.obric.aiagent.plugin")) == false) goto L7;
            r3.remove();
        L11:
            r0.add(0, r7);
            List r9 = (List) ZeusTransformUtils.preCheckCast(j.a(r8, "systemNativeLibraryDirectories").get(r8), List.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L14;
            r9 = new ArrayList(2);
        L14:
            ArrayList r1 = new ArrayList((r0.size() + r9.size()) + 1);
            r1.addAll(r0);
            r1.addAll(r9);
            j.a(r8, "nativeLibraryPathElements").set(r8, (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(j.a(r8, "makePathElements", new Class[]{List.class}).invoke(r8, new Object[]{r1}), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SoLibraryHooker.java */
    private static final class d {
        static /* synthetic */ void a(ClassLoader r0, File r1) {
            b(r0, r1);
        }

        private static void b(ClassLoader r9, File r10) {
            String r11 = r10.getPath();
            Field r0 = j.a(r9, "libPath");
            String[] r1 = ((String) ZeusTransformUtils.preCheckCast(r0.get(r9), String.class, "com.obric.aiagent.plugin")).split(":");
            StringBuilder r2 = new StringBuilder(r11);
            int r4 = r1.length;
            int r6 = 0;
        L3:
            if (r6 >= r4) goto L11;
            String r7 = r1[r6];
            if (r7 == null) goto L10;
            if (r11.equals(r7) == true) goto L10;
            r2.append(':').append(r7);
        L10:
            r6 = r6 + 1;
            goto L3
        L11:
            r0.set(r9, r2.toString());
            Field r3 = j.a(r9, "libraryPathElements");
            List r5 = (List) ZeusTransformUtils.preCheckCast(r3.get(r9), List.class, "com.obric.aiagent.plugin");
            Iterator r8 = r5.iterator();
        L13:
            if (r8.hasNext() == false) goto L17;
            if (r11.equals((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L13;
            r8.remove();
        L17:
            r5.add(0, r11);
            r3.set(r9, r5);
        }
    }

    public a() {
    }

    public void a(File r8) {
        if (com.bytedance.reparo.core.a.b.b.b(r8) == true) goto L6;
        com.bytedance.reparo.core.j.d(TAG, String.format("library dir %s not exist, hook failed.", new Object[]{r8.getAbsolutePath()}));
        return;
    L6:
        ClassLoader r7 = a.class.getClassLoader();
        if (Build.VERSION.SDK_INT <= 25) goto L18;
        c.a(r7, r8);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        com.bytedance.reparo.core.j.d(TAG, String.format("installNativeLibraryPath, v25 fail, sdk: %s, error: %s, try to fallback to V23", new Object[]{String.valueOf(Build.VERSION.SDK_INT), th.getMessage()}));
        b.a(r7, r8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw new com.bytedance.reparo.core.b.j("hook so library path failed, sdk: " + Build.VERSION.SDK_INT, th, 302);
    L18:
        if (Build.VERSION.SDK_INT < 23) goto L29;
        b.a(r7, r8);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        com.bytedance.reparo.core.j.d(TAG, String.format("installNativeLibraryPath, v23 fail, sdk: %s, error: %s, try to fallback to V14", new Object[]{String.valueOf(Build.VERSION.SDK_INT), th.getMessage()}));
        C0211a.a(r7, r8);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw new com.bytedance.reparo.core.b.j("hook so library path failed, sdk: " + Build.VERSION.SDK_INT, th, 303);
    L29:
        if (Build.VERSION.SDK_INT >= 14) goto L48;
        d.a(r7, r8);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        throw new com.bytedance.reparo.core.b.j("hook so library path failed, sdk: " + Build.VERSION.SDK_INT, th, ResultCode.ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED);
    L48:
        C0211a.a(r7, r8);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw new com.bytedance.reparo.core.b.j("hook so library path failed, sdk: " + Build.VERSION.SDK_INT, th, ResultCode.ERROR_MULTI_DETAIL);
    }
}

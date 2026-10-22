package com.bytedance.android.live.saas.middleware.utils;

import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public class SoDirInstaller {
    private static final String TAG = "Tinker.LoadLibrary";

    public static final class V14 {
        private V14() {
        }

        public static /* synthetic */ void access$200(ClassLoader r100, File r101) throws Throwable {
            install(r100, r101);
        }

        private static void install(ClassLoader r100, File r101) throws Throwable {
            Object r102 = SoReflectUtil.findField(r100, "pathList").get(r100);
            Field r103 = SoReflectUtil.findField(r102, "nativeLibraryDirectories");
            File[] r104 = (File[]) r103.get(r102);
            ArrayList r105 = new ArrayList(r104.length + 1);
            r105.add(r101);
            int r106 = r104.length;
            int r107 = 0;
        L3:
            if (r107 >= r106) goto L8;
            File r108 = r104[r107];
            if (r101.equals(r108) == true) goto L7;
            r105.add(r108);
        L7:
            r107 = r107 + 1;
            goto L3
        L8:
            r103.set(r102, r105.toArray(new File[0]));
        }
    }

    public static final class V23 {
        private V23() {
        }

        public static /* synthetic */ void access$100(ClassLoader r100, File r101) throws Throwable {
            install(r100, r101);
        }

        private static void install(ClassLoader r100, File r101) throws Throwable {
            Object r102 = SoReflectUtil.findField(r100, "pathList").get(r100);
            List r103 = (List) SoReflectUtil.findField(r102, "nativeLibraryDirectories").get(r102);
            if (r103 != null) goto L5;
            r103 = new ArrayList(2);
        L5:
            Iterator r104 = r103.iterator();
        L7:
            if (r104.hasNext() == false) goto L11;
            if (r101.equals((File) r104.next()) == false) goto L7;
            r104.remove();
        L11:
            ListProtector.add(r103, 0, r101);
            List r105 = (List) SoReflectUtil.findField(r102, "systemNativeLibraryDirectories").get(r102);
            if (r105 != null) goto L14;
            r105 = new ArrayList(2);
        L14:
            ArrayList r106 = new ArrayList((r103.size() + r105.size()) + 1);
            r106.addAll(r103);
            r106.addAll(r105);
            SoReflectUtil.findField(r102, "nativeLibraryPathElements").set(r102, (Object[]) SoReflectUtil.findMethod(r102, "makePathElements", new Class[]{List.class, File.class, List.class}).invoke(r102, new Object[]{r106, null, new ArrayList()}));
        }
    }

    public static final class V25 {
        private V25() {
        }

        public static /* synthetic */ void access$000(ClassLoader r100, File r101) throws Throwable {
            install(r100, r101);
        }

        private static void install(ClassLoader r100, File r101) throws Throwable {
            Object r102 = SoReflectUtil.findField(r100, "pathList").get(r100);
            List r103 = (List) SoReflectUtil.findField(r102, "nativeLibraryDirectories").get(r102);
            if (r103 != null) goto L5;
            r103 = new ArrayList(2);
        L5:
            Iterator r104 = r103.iterator();
        L7:
            if (r104.hasNext() == false) goto L11;
            if (r101.equals((File) r104.next()) == false) goto L7;
            r104.remove();
        L11:
            ListProtector.add(r103, 0, r101);
            List r105 = (List) SoReflectUtil.findField(r102, "systemNativeLibraryDirectories").get(r102);
            if (r105 != null) goto L14;
            r105 = new ArrayList(2);
        L14:
            ArrayList r106 = new ArrayList((r103.size() + r105.size()) + 1);
            r106.addAll(r103);
            r106.addAll(r105);
            SoReflectUtil.findField(r102, "nativeLibraryPathElements").set(r102, (Object[]) SoReflectUtil.findMethod(r102, "makePathElements", new Class[]{List.class}).invoke(r102, new Object[]{r106}));
        }
    }

    public static final class V4 {
        private V4() {
        }

        public static /* synthetic */ void access$300(ClassLoader r100, File r101) throws Throwable {
            install(r100, r101);
        }

        private static void install(ClassLoader r100, File r101) throws Throwable {
            String r102 = r101.getPath();
            Field r103 = SoReflectUtil.findField(r100, "libPath");
            String[] r104 = ((String) r103.get(r100)).split(":");
            StringBuilder r105 = new StringBuilder(r102);
            int r106 = r104.length;
            int r107 = 0;
        L3:
            if (r107 >= r106) goto L11;
            String r108 = r104[r107];
            if (r108 == null) goto L10;
            if (r102.equals(r108) == true) goto L10;
            r105.append(':');
            r105.append(r108);
        L10:
            r107 = r107 + 1;
            goto L3
        L11:
            r103.set(r100, r105.toString());
            Field r109 = SoReflectUtil.findField(r100, "libraryPathElements");
            List r110 = (List) r109.get(r100);
            Iterator r111 = r110.iterator();
        L13:
            if (r111.hasNext() == false) goto L17;
            if (r102.equals((String) r111.next()) == false) goto L13;
            r111.remove();
        L17:
            ListProtector.add(r110, 0, r102);
            r109.set(r100, r110);
        }
    }

    public SoDirInstaller() {
    }

    public static void installNativeLibraryPath(ClassLoader r100, File r101) throws Throwable {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.exists() == false) goto L30;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 == 25) goto L9;
    L10:
        if (r102 <= 25) goto L16;
    L23:
        V25.access$000(r100, r101);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.getMessage();
        V23.access$100(r100, r101);
        return;
    L16:
        if (r102 >= 23) goto L25;
        V14.access$200(r100, r101);
        return;
    L25:
        V23.access$100(r100, r101);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        th.getMessage();
        V14.access$200(r100, r101);
        return;
    L9:
        if (Build.VERSION.PREVIEW_SDK_INT != 0) goto L23;
    }
}

package com.bytedance.android.alog;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Alog f38378a;

    public static void a() {
        Alog r100 = f38378a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public static String b() {
        Alog r100 = f38378a;
        if (r100 != null) goto L5;
        return "default log instance is null";
    L5:
        if (Alog.f38333q == true) goto L8;
        return "not inited";
    L8:
        if (r100.f38339f != null) goto L10;
        r100.f38339f = g.a();
    L10:
        String r101 = r100.f38339f;
        if (r101 != null) goto L13;
        return "get process name failed";
    L13:
        String r102 = r101.replace(':', '-');
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100.f38336c);
        if (r103.exists() == true) goto L16;
        return "cache dir not exists";
    L16:
        File[] r104 = r103.listFiles();
        if (r104 != null) goto L19;
        return "cache dir is empty";
    L19:
        String r105 = r102 + "__" + r100.f38340g + ".alog.cache.guard";
        Pattern r106 = PatternProtector.compile("^" + Pattern.quote(r102) + "__" + Pattern.quote(r100.f38340g) + "__\\d{5}\\.alog\\.cache$");
        int r107 = r104.length;
        int r108 = 0;
        int r109 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
    L20:
        if (r108 >= r107) goto L37;
        File r113 = r104[r108];
        if (r113.getName().equals(r105) == false) goto L27;
        r109 = r109 + 1;
        if (r113.length() < 24576) goto L26;
        r110 = r110 + 1;
    L26:
        File[] r114 = r104;
    L34:
        String r115 = r105;
    L35:
        r108 = r108 + 1;
        r105 = r115;
        r104 = r114;
        goto L20
    L27:
        String r116 = r113.getName();
        StringBuilder r117 = new StringBuilder();
        r117.append(r102);
        r117.append("__");
        r114 = r104;
        r117.append(r100.f38340g);
        r117.append("__");
        if (r116.startsWith(r117.toString()) == false) goto L34;
        if (r106.matcher(r113.getName()).find() == false) goto L34;
        r111 = r111 + 1;
        r115 = r105;
        if (r113.length() < r100.f38337d) goto L35;
        r112 = r112 + 1;
        goto L35
    L37:
        if (r109 >= 1) goto L39;
        r103.getAbsolutePath();
        return "cache guard not exists";
    L39:
        if (r110 >= 1) goto L41;
        return "cache guard size insufficiently";
    L41:
        int r118 = r100.f38338e;
        if (r111 >= r118) goto L44;
        return "cache block count insufficiently";
    L44:
        if (r112 >= r118) goto L46;
        return "cache block size insufficiently";
    L46:
        PolarisFileWrapper r119 = new PolarisFileWrapper(r100.f38335b);
        if (r119.exists() == true) goto L49;
        return "log dir not exists";
    L49:
        File[] r120 = r119.listFiles(new a(r100, PatternProtector.compile("^\\d{4}_\\d{2}_\\d{2}_\\d+__" + Pattern.quote(r102) + "__" + Pattern.quote(r100.f38340g) + "\\.alog\\.hot$")));
        if (r120 != null) goto L52;
    L55:
        return "no log file for current process and instance";
    L52:
        if (r120.length == 0) goto L55;
        return "OK";
    }

    public static void c(int r100, String r101, String r102) {
        Alog r103 = f38378a;
        if (r103 == null) goto L6;
        r103.n(r100, r101, r102);
        return;
    }

    public static void d(int r100, String r101, String r102) {
        Alog r103 = f38378a;
        if (r103 == null) goto L6;
        r103.n(r100, r101, r102);
        return;
    }
}

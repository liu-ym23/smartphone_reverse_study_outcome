package com.amap.api.col.jmsl;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.amap.api.col.jmsl.b1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1536b1 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile l6 f16532a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f16533b = new AtomicBoolean(false);

    /* renamed from: com.amap.api.col.jmsl.b1$a */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (C1536b1.class) {
                if (C1536b1.f16532a == null) {
                    try {
                        l6 unused = C1536b1.f16532a = C1536b1.g();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }
    }

    public static l6 a() {
        if (f16532a == null && f16533b.compareAndSet(false, true)) {
            new Thread(new a(), "RI").start();
        }
        return f16532a;
    }

    public static l6 c(String str) throws Throwable {
        if (str == null || str.length() <= 0) {
            return l6.Other;
        }
        l6 l6Var = l6.MIUI;
        if (!str.equalsIgnoreCase(l6Var.f())) {
            l6 l6Var2 = l6.Flyme;
            if (str.equalsIgnoreCase(l6Var2.f())) {
                String strF = f("ro.flyme.published");
                String strF2 = f("ro.meizu.setupwizard.flyme");
                if (!TextUtils.isEmpty(strF) || !TextUtils.isEmpty(strF2)) {
                    String strF3 = f("ro.build.display.id");
                    d(l6Var2, strF3);
                    l6Var2.b(strF3);
                    return l6Var2;
                }
            } else {
                l6 l6Var3 = l6.RH;
                if (str.equalsIgnoreCase(l6Var3.f())) {
                    String strF4 = f("ro.build.version.emui");
                    if (!TextUtils.isEmpty(strF4)) {
                        d(l6Var3, strF4);
                        l6Var3.b(strF4);
                        return l6Var3;
                    }
                } else {
                    l6 l6Var4 = l6.ColorOS;
                    if (str.equalsIgnoreCase(l6Var4.f())) {
                        String strF5 = f("ro.build.version.opporom");
                        if (!TextUtils.isEmpty(strF5)) {
                            d(l6Var4, strF5);
                            l6Var4.b(strF5);
                            return l6Var4;
                        }
                    } else {
                        l6 l6Var5 = l6.FuntouchOS;
                        if (str.equalsIgnoreCase(l6Var5.f())) {
                            String strF6 = f("ro.vivo.os.build.display.id");
                            if (!TextUtils.isEmpty(strF6)) {
                                d(l6Var5, strF6);
                                l6Var5.b(strF6);
                                return l6Var5;
                            }
                        } else {
                            l6 l6Var6 = l6.SmartisanOS;
                            if (str.equalsIgnoreCase(l6Var6.f())) {
                                String strF7 = f("ro.smartisan.version");
                                if (!TextUtils.isEmpty(strF7)) {
                                    d(l6Var6, strF7);
                                    l6Var6.b(strF7);
                                    return l6Var6;
                                }
                            } else {
                                l6 l6Var7 = l6.AmigoOS;
                                if (str.equalsIgnoreCase(l6Var7.f())) {
                                    String strF8 = f("ro.build.display.id");
                                    if (!TextUtils.isEmpty(strF8) && strF8.matches("amigo([\\d.]+)[a-zA-Z]*")) {
                                        d(l6Var7, strF8);
                                        l6Var7.b(strF8);
                                        return l6Var7;
                                    }
                                } else {
                                    l6 l6Var8 = l6.EUI;
                                    if (str.equalsIgnoreCase(l6Var8.f())) {
                                        String strF9 = f("ro.letv.release.version");
                                        if (!TextUtils.isEmpty(strF9)) {
                                            d(l6Var8, strF9);
                                            l6Var8.b(strF9);
                                            return l6Var8;
                                        }
                                    } else {
                                        l6 l6Var9 = l6.Sense;
                                        if (str.equalsIgnoreCase(l6Var9.f())) {
                                            String strF10 = f("ro.build.sense.version");
                                            if (!TextUtils.isEmpty(strF10)) {
                                                d(l6Var9, strF10);
                                                l6Var9.b(strF10);
                                                return l6Var9;
                                            }
                                        } else {
                                            l6 l6Var10 = l6.LG;
                                            if (str.equalsIgnoreCase(l6Var10.f())) {
                                                String strF11 = f("sys.lge.lgmdm_version");
                                                if (!TextUtils.isEmpty(strF11)) {
                                                    d(l6Var10, strF11);
                                                    l6Var10.b(strF11);
                                                    return l6Var10;
                                                }
                                            } else {
                                                l6 l6Var11 = l6.Google;
                                                if (!str.equalsIgnoreCase(l6Var11.f())) {
                                                    l6 l6Var12 = l6.NubiaUI;
                                                    if (str.equalsIgnoreCase(l6Var12.f())) {
                                                        String strF12 = f("ro.build.nubia.rom.code");
                                                        if (!TextUtils.isEmpty(strF12)) {
                                                            d(l6Var12, strF12);
                                                            l6Var12.b(strF12);
                                                            return l6Var12;
                                                        }
                                                    }
                                                } else if ("android-google".equals(f("ro.com.google.clientidbase"))) {
                                                    String strF13 = f("ro.build.version.release");
                                                    l6Var11.a(Build.VERSION.SDK_INT);
                                                    l6Var11.b(strF13);
                                                    return l6Var11;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (!TextUtils.isEmpty(f("ro.miui.ui.version.name"))) {
            String strF14 = f("ro.build.version.incremental");
            d(l6Var, strF14);
            l6Var.b(strF14);
            return l6Var;
        }
        return l6.Other;
    }

    public static void d(l6 l6Var, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String strGroup = matcher.group(1);
                l6Var.a(strGroup);
                l6Var.a(Integer.parseInt(strGroup.split("\\.")[0]));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static String f(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (!TextUtils.isEmpty(null)) {
            throw null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(str)).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return line;
            } catch (IOException unused2) {
                if (bufferedReader == null) {
                    return null;
                }
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException unused3) {
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ l6 g() throws Throwable {
        l6 l6VarC = c(Build.MANUFACTURER);
        if (!"".equals(l6VarC.f())) {
            return l6VarC;
        }
        Iterator it = Arrays.asList(l6.MIUI.f(), l6.Flyme.f(), l6.RH.f(), l6.ColorOS.f(), l6.FuntouchOS.f(), l6.SmartisanOS.f(), l6.AmigoOS.f(), l6.Sense.f(), l6.LG.f(), l6.Google.f(), l6.NubiaUI.f()).iterator();
        while (it.hasNext()) {
            l6 l6VarC2 = c((String) it.next());
            if (!"".equals(l6VarC2.f())) {
                return l6VarC2;
            }
        }
        return l6.Other;
    }
}

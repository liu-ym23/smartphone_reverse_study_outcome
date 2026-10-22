package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.jmsl.a1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1532a1 {

    /* renamed from: a, reason: collision with root package name */
    public static C1532a1 f16513a;

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, String> f16514b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f16515c = false;

    public C1532a1(Context context) {
        if (f16515c) {
            return;
        }
        synchronized (C1532a1.class) {
            f16514b.clear();
            try {
                b(context);
                f16515c = true;
            } catch (Exception e10) {
                C1541c2.b(e10, "DynamicHostManager", "Init error)");
            }
        }
    }

    public static void b(Context context) throws IOException {
        String str;
        if (context == null) {
            return;
        }
        try {
            try {
                InputStream inputStreamOpen = context.getAssets().open(C1567j0.o() ? C1567j0.m() ? "Localizable/servers/oversea/de/Localizable.url" : "Localizable/servers/oversea/Localizable.url" : "Localizable/servers/Localizable.url");
                byte[] bArr = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr);
                str = new String(bArr, "UTF-8");
            } catch (Exception e10) {
                C1541c2.b(e10, "DynamicHostManager", "readAssetsFile error)");
                str = null;
            }
            for (String str2 : str.split("\";")) {
                if (str2.length() > 0) {
                    int iIndexOf = str2.indexOf("\"");
                    int iIndexOf2 = str2.indexOf("\"=\"");
                    if (iIndexOf >= 0 && iIndexOf2 >= 0) {
                        String strSubstring = str2.substring(iIndexOf + 1, iIndexOf2);
                        String strSubstring2 = str2.substring(iIndexOf2 + 3);
                        if (!TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strSubstring2)) {
                            f16514b.put(Integer.valueOf(Integer.parseInt(strSubstring)), strSubstring2);
                        }
                    }
                }
            }
        } catch (Exception e11) {
            C1541c2.b(e11, "DynamicHostManager", "preloadConfigData error)");
        }
    }

    public static C1532a1 c(Context context) {
        if (f16513a == null) {
            f16513a = new C1532a1(context);
        }
        return f16513a;
    }

    public String a(int i10) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = f16514b;
        if (concurrentHashMap.isEmpty()) {
            return null;
        }
        return concurrentHashMap.get(Integer.valueOf(i10));
    }
}

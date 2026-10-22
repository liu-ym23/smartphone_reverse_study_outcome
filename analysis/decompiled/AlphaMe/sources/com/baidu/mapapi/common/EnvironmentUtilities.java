package com.baidu.mapapi.common;

import android.content.Context;
import androidx.room.AbstractC0351g;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import java.io.File;

/* loaded from: classes.dex */
public class EnvironmentUtilities {

    /* renamed from: a, reason: collision with root package name */
    static String f5995a;

    /* renamed from: b, reason: collision with root package name */
    static String f5996b;

    /* renamed from: c, reason: collision with root package name */
    static String f5997c;

    /* renamed from: d, reason: collision with root package name */
    static int f5998d;

    /* renamed from: e, reason: collision with root package name */
    static int f5999e;

    /* renamed from: f, reason: collision with root package name */
    static int f6000f;

    /* renamed from: g, reason: collision with root package name */
    static int f6001g;

    /* renamed from: h, reason: collision with root package name */
    private static e f6002h;

    public static String getAppCachePath() {
        return f5996b;
    }

    public static String getAppSDCardPath() {
        String strP = AbstractC0351g.p(f5995a, "/BaiduMapSDKNew");
        if (strP.length() != 0) {
            File file = new File(strP);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return strP;
    }

    public static String getAppSecondCachePath() {
        return f5997c;
    }

    public static int getDomTmpStgMax() {
        return f5999e;
    }

    public static int getItsTmpStgMax() {
        return f6000f;
    }

    public static int getMapTmpStgMax() {
        return f5998d;
    }

    public static String getSDCardPath() {
        return f5995a;
    }

    public static int getSsgTmpStgMax() {
        return f6001g;
    }

    public static void initAppDirectory(Context context) {
        if (f6002h == null) {
            e eVarB = e.b();
            f6002h = eVarB;
            eVarB.b(context);
        }
        String str = f5995a;
        if (str != null && str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(f5995a);
            String str2 = File.separator;
            sb.append(str2);
            sb.append("BaiduMapSDKNew");
            sb.append(str2);
            sb.append("cache");
            f5996b = sb.toString();
        } else if (f6002h.a() != null) {
            f5995a = f6002h.a().c();
            f5996b = f6002h.a().b();
        }
        if (f6002h.a() != null) {
            f5997c = f6002h.a().d();
        }
        f5998d = 52428800;
        f5999e = 52428800;
        f6000f = BmLocated.ALIGN_LEFT_TOP;
        f6001g = 52428800;
    }

    public static void setSDCardPath(String str) {
        f5995a = str;
    }
}

package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.ServiceSettings;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.jmsl.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1562i {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f16658a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f16659b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f16660c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Context f16661d;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b();
        String str2 = f16658a.get(str);
        return (TextUtils.isEmpty(str2) || !str2.contains("\\n")) ? str2 : str2.replace("\\n", "\n");
    }

    public static void b() {
        String str;
        switch (C1567j0.j()) {
            case 0:
                str = ServiceSettings.CHINESE;
                break;
            case 1:
                str = "zh-Hant-HK";
                break;
            case 2:
            default:
                str = "en";
                break;
            case 3:
                str = "es";
                break;
            case 4:
                str = "pt";
                break;
            case 5:
                str = Const.SP_KEY_FIRSTLOC_RELOC;
                break;
            case 6:
                str = "de";
                break;
            case 7:
                str = "th";
                break;
            case 8:
                str = "ja";
                break;
            case 9:
                str = "ko";
                break;
            case 10:
                str = "ar";
                break;
            case 11:
                str = "tr";
                break;
            case 12:
                str = "he";
                break;
            case 13:
                str = "it";
                break;
            case 14:
                str = "ru";
                break;
            case 15:
                str = Const.SP_KEY_GSM_UPLOAD_MXSIZE;
                break;
            case 16:
                str = "id";
                break;
            case 17:
                str = "vi";
                break;
            case 18:
                str = "pl";
                break;
            case 19:
                str = "cs";
                break;
            case 20:
                str = "uk";
                break;
            case 21:
                str = "az";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f16659b && str.equals(f16660c)) {
            return;
        }
        synchronized (C1562i.class) {
            try {
                if (f16659b && str.equals(f16660c)) {
                    return;
                }
                f16659b = false;
                f16658a.clear();
                try {
                    if (c(str)) {
                        f16660c = str;
                        f16659b = true;
                    }
                } catch (Exception e10) {
                    C1541c2.b(e10, "DynamicStringManager", "loadLanguage error");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean c(String str) throws IOException {
        String str2;
        try {
            try {
                InputStream inputStreamOpen = f16661d.getAssets().open("Localizable/strings/" + str + "/Localizable_location.strings");
                byte[] bArr = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr);
                str2 = new String(bArr, "UTF-8");
            } catch (IOException e10) {
                e10.printStackTrace();
                str2 = null;
            }
            for (String str3 : str2.split("\";")) {
                if (!str3.isEmpty()) {
                    int iIndexOf = str3.indexOf("\"");
                    int iIndexOf2 = str3.indexOf("\"=\"");
                    if (iIndexOf >= 0 && iIndexOf2 >= 0) {
                        String strSubstring = str3.substring(iIndexOf + 1, iIndexOf2);
                        String strSubstring2 = str3.substring(iIndexOf2 + 3);
                        if (!TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strSubstring2)) {
                            f16658a.put(strSubstring, strSubstring2);
                        }
                    }
                }
            }
            return true;
        } catch (Exception e11) {
            C1541c2.b(e11, "DynamicStringManager", "loadLanguageFile error)");
            return false;
        }
    }
}

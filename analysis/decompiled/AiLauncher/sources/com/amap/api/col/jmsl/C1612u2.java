package com.amap.api.col.jmsl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.jmsl.u2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1612u2 {

    /* renamed from: d, reason: collision with root package name */
    public static C1612u2 f16971d = null;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f16972e = true;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, List<String>>> f16973a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f16974b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final List<String> f16975c = new ArrayList();

    public static synchronized C1612u2 a() {
        try {
            if (f16971d == null) {
                f16971d = new C1612u2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f16971d;
    }

    public boolean b(String str) {
        int i10;
        String str2;
        a aVar;
        int i11;
        if (str == null || str.length() == 0) {
            return false;
        }
        a aVar2 = null;
        try {
            aVar = new a(new URL(str));
        } catch (MalformedURLException unused) {
            if (str.contains("://")) {
                aVar = null;
            } else {
                while (str.startsWith("/")) {
                    str = str.substring(1);
                }
                String[] strArrSplit = str.split("/");
                if (strArrSplit[0].contains(".")) {
                    str2 = strArrSplit[0];
                    i10 = 1;
                } else {
                    i10 = 0;
                    str2 = null;
                }
                StringBuilder sb2 = new StringBuilder();
                while (i10 < strArrSplit.length) {
                    if (sb2.length() > 0) {
                        sb2.append("/");
                    }
                    sb2.append(strArrSplit[i10]);
                    i10++;
                }
                if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '/') {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
                aVar = new a(str2, sb2.toString());
            }
        }
        if (aVar != null) {
            String str3 = aVar.f16978c;
            if (str3 != null && str3.length() != 0) {
                while (true) {
                    String str4 = aVar.f16978c;
                    if (str4.charAt(str4.length() - 1) != '/') {
                        break;
                    }
                    String str5 = aVar.f16978c;
                    aVar.f16978c = str5.substring(0, str5.length() - 1);
                }
                while (aVar.f16978c.charAt(0) == '/') {
                    aVar.f16978c = aVar.f16978c.substring(1);
                }
            }
            aVar2 = aVar;
        }
        if (aVar2 == null) {
            return false;
        }
        synchronized (this) {
            try {
                if (aVar2.f16978c.length() != 0) {
                    Map<String, List<String>> map = this.f16974b;
                    String str6 = aVar2.f16976a;
                    if (str6 != null && this.f16973a.containsKey(str6)) {
                        map = this.f16973a.get(aVar2.f16976a);
                    }
                    List<String> list = this.f16975c;
                    boolean z10 = f16972e;
                    if (!z10 && map == null) {
                        throw new AssertionError();
                    }
                    String str7 = aVar2.f16977b;
                    if (str7 != null && map.containsKey(str7)) {
                        list = map.get(aVar2.f16977b);
                    }
                    if (!z10 && list == null) {
                        throw new AssertionError();
                    }
                    for (String str8 : list) {
                        String str9 = aVar2.f16978c;
                        String[] strArrSplit2 = str8.split("/");
                        String[] strArrSplit3 = str9.split("/");
                        if (strArrSplit3.length >= strArrSplit2.length) {
                            for (0; i11 < strArrSplit2.length; i11 + 1) {
                                i11 = (strArrSplit2[i11].equals("*") || strArrSplit2[i11].equals(strArrSplit3[i11])) ? i11 + 1 : 0;
                            }
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.u2$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f16976a;

        /* renamed from: b, reason: collision with root package name */
        public String f16977b;

        /* renamed from: c, reason: collision with root package name */
        public String f16978c;

        public a(URL url) {
            this.f16976a = url.getProtocol();
            this.f16977b = url.getHost();
            this.f16978c = url.getPath();
        }

        public a(String str, String str2) {
            this.f16976a = null;
            this.f16977b = str;
            this.f16978c = str2;
        }
    }
}

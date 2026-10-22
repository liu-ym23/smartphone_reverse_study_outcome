package com.amap.api.col.jmsl;

import android.content.Context;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: classes.dex */
public class Q {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16291a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16292b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f16293c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f16294d;

    public Q(Uri uri, Map<String, String> map, Context context, String str) {
        this.f16291a = context;
        this.f16292b = str;
        this.f16293c = uri;
        this.f16294d = map;
    }

    public String a(String str) {
        String str2 = this.f16292b;
        if (str.contains(str2)) {
            return str;
        }
        if (str.contains("key=6ac9403db386283ef864c164683a6980")) {
            return str.replace("key=6ac9403db386283ef864c164683a6980", "key=" + str2);
        }
        if (str.contains("?")) {
            return str + "&key=" + str2;
        }
        return str + "?key=" + str2;
    }

    public void b() {
        String str;
        String str2;
        String string = this.f16293c.toString();
        if (string != null) {
            try {
                if (string.contains("v=nativeJSVersion")) {
                    string = string.replace("v=nativeJSVersion", "v=2.0");
                }
                string = a(string);
                String query = new URL(string).getQuery();
                Hashtable hashtable = new Hashtable(16);
                if (query != null) {
                    if (string.contains("restapi.amap.com/v3/log/init")) {
                        query = URLDecoder.decode(query, "utf-8");
                    }
                    try {
                        for (String str3 : query.split(Const.STR_MART_ADD)) {
                            String[] strArrSplit = str3.split("=");
                            if (strArrSplit.length == 2) {
                                str = strArrSplit[0];
                                str2 = strArrSplit[1];
                            } else {
                                str = null;
                                str2 = null;
                            }
                            if (str != null && str2 != null) {
                                hashtable.put(str, str2);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                String strB = J0.b();
                String strD = J0.d(this.f16291a, strB, C1604s2.c(hashtable));
                string = query != null ? string + "&ts=" + strB + "&scode=" + strD : string + "?ts=" + strB + "&scode=" + strD;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        this.f16293c = Uri.parse(string);
    }

    public void c() {
        this.f16293c = Uri.parse(this.f16293c.toString());
    }

    public Map<String, String> d() {
        return this.f16294d;
    }

    public Uri e() {
        return this.f16293c;
    }
}

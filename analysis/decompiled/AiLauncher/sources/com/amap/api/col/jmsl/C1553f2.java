package com.amap.api.col.jmsl;

import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Hashtable;
import java.util.Iterator;

/* renamed from: com.amap.api.col.jmsl.f2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1553f2 {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f16625b = false;

    /* renamed from: c, reason: collision with root package name */
    public static volatile C1553f2 f16626c;

    /* renamed from: a, reason: collision with root package name */
    public Hashtable<String, String> f16627a = new Hashtable<>();

    public static C1553f2 a() {
        if (f16626c == null) {
            synchronized (C1553f2.class) {
                try {
                    if (f16626c == null) {
                        f16626c = new C1553f2();
                    }
                } finally {
                }
            }
        }
        return f16626c;
    }

    public static void c(boolean z10) {
        f16625b = z10;
    }

    public static boolean d() {
        return f16625b;
    }

    public void b(LatLng latLng, String str, String str2) {
        Hashtable<String, String> hashtable;
        if (!f16625b) {
            this.f16627a.clear();
            return;
        }
        if (latLng == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Const.STR_MART_JSON_BEGIN);
        stringBuffer.append("\"lon\":");
        stringBuffer.append(latLng.longitude);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append("\"lat\":");
        stringBuffer.append(latLng.latitude);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append("\"title\":");
        stringBuffer.append("\"");
        stringBuffer.append(str);
        stringBuffer.append("\"");
        stringBuffer.append(Const.STR_MART_COMMA);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        stringBuffer.append("\"snippet\":");
        stringBuffer.append("\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        stringBuffer.append("}");
        String string = stringBuffer.toString();
        if (string == null || (hashtable = this.f16627a) == null) {
            return;
        }
        synchronized (hashtable) {
            try {
                String strC = L1.c(string);
                Hashtable<String, String> hashtable2 = this.f16627a;
                if (hashtable2 != null && !hashtable2.contains(strC)) {
                    this.f16627a.put(strC, string);
                }
                Hashtable<String, String> hashtable3 = this.f16627a;
                if (hashtable3 != null && hashtable3.size() > 20) {
                    e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        if (!f16625b) {
            this.f16627a.clear();
            return;
        }
        if (this.f16627a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int size = this.f16627a.size();
            if (size > 0) {
                stringBuffer.append("[");
                Iterator<String> it = this.f16627a.values().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    i10++;
                    stringBuffer.append(it.next());
                    if (i10 < size) {
                        stringBuffer.append(Const.STR_MART_COMMA);
                    }
                }
                stringBuffer.append("]");
                TextUtils.isEmpty(stringBuffer.toString());
            }
            this.f16627a.clear();
        }
    }
}

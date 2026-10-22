package com.amap.api.col.jmsl;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class Z extends X1 {

    /* renamed from: E, reason: collision with root package name */
    public String f16494E;

    /* renamed from: F, reason: collision with root package name */
    public final Q f16495F;

    public Z(Context context, Q q10) {
        super(context, q10);
        this.f16494E = null;
        this.f16495F = q10;
        this.f16468D = true;
        this.f16469y = false;
    }

    @Override // com.amap.api.col.jmsl.X1
    public Object c(C1577l2 c1577l2) throws C1599r1 {
        if (c1577l2 == null) {
            return null;
        }
        try {
            Map<String, String> mapL = l(c1577l2.f16720b);
            C1591p0 c1591p0 = new C1591p0(k(c1577l2.f16720b, "Content-Type"), k(c1577l2.f16720b, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h), new ByteArrayInputStream(c1577l2.f16719a));
            c1591p0.setResponseHeaders(mapL);
            c1591p0.a(200);
            c1591p0.b("OK");
            return new a(c1591p0, c1577l2.f16719a);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.X1
    public /* bridge */ /* synthetic */ Object d(byte[] bArr) throws C1599r1 {
        return null;
    }

    @Override // com.amap.api.col.jmsl.X1, com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        Map<String, String> requestHead = super.getRequestHead();
        Map<String, String> mapD = this.f16495F.d();
        if (mapD != null) {
            for (String str : mapD.keySet()) {
                String str2 = mapD.get(str);
                if (str != null && str2 != null) {
                    ((Hashtable) requestHead).put(str, str2);
                    if (str.contains(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h)) {
                        this.f16494E = mapD.get(str);
                    }
                }
            }
        }
        return requestHead;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return this.f16495F.e().toString();
    }

    public final String k(Map<String, List<String>> map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getKey().equals(str)) {
                List<String> value = entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                int i10 = 0;
                if (value.size() == 1) {
                    sb2.append(value.get(0));
                } else {
                    Iterator<String> it = value.iterator();
                    while (it.hasNext()) {
                        sb2.append(it.next());
                        i10++;
                        if (i10 != value.size()) {
                            sb2.append(Const.STR_MART_COMMA);
                        }
                    }
                }
                return sb2.toString();
            }
        }
        return null;
    }

    public final Map<String, String> l(Map<String, List<String>> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey() != null && (entry.getKey() == null || !entry.getKey().equals("Content-Type"))) {
                    List<String> value = entry.getValue();
                    StringBuilder sb2 = new StringBuilder();
                    int i10 = 0;
                    if (value.size() == 1) {
                        sb2.append(value.get(0));
                    } else {
                        Iterator<String> it = value.iterator();
                        while (it.hasNext()) {
                            sb2.append(it.next());
                            i10++;
                            if (i10 != value.size()) {
                                sb2.append(Const.STR_MART_COMMA);
                            }
                        }
                    }
                    map2.put(entry.getKey(), sb2.toString());
                }
            }
        }
        map2.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h, this.f16494E);
        if (!getURL().contains("vdata") && !getURL().contains("webapi.amap.com/maps")) {
            return map2;
        }
        map2.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h, "gzip");
        return map2;
    }

    public a m() throws C1599r1 {
        if (this.f16470z != null) {
            try {
                return (a) g();
            } catch (g5 e10) {
                if (304 == e10.g()) {
                    Map<String, String> mapL = l(e10.l());
                    C1591p0 c1591p0 = new C1591p0(k(e10.l(), "Content-Type"), k(e10.l(), com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h), null);
                    c1591p0.setResponseHeaders(mapL);
                    c1591p0.a(e10.g());
                    c1591p0.b(e10.m());
                    return new a(c1591p0);
                }
                C1570k.j(e10);
            } catch (C1599r1 e11) {
                C1570k.j(e11);
                throw e11;
            } catch (Exception e12) {
                C1570k.j(e12);
            }
        }
        return null;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final C1591p0 f16496a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f16497b;

        public a(C1591p0 c1591p0) {
            this.f16496a = c1591p0;
        }

        public a(C1591p0 c1591p0, byte[] bArr) {
            this.f16496a = c1591p0;
            this.f16497b = bArr;
        }
    }
}

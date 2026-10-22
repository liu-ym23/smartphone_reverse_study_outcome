package X6;

import F9.x;
import F9.y;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import com.volcengine.tos.TosClientException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public K1.a f1519a;
    public String b;
    public String c;
    public int d;
    public int e;

    public static n a(c cVar, String str, InputStream inputStream) {
        try {
            n nVarA = cVar.a(inputStream, str);
            K1.a aVar = cVar.f1506a;
            if (aVar != null) {
                HashMap mapO = aVar.o(nVarA);
                for (String str2 : mapO.keySet()) {
                    nVarA.m.put(str2, mapO.get(str2));
                }
            }
            return nVarA;
        } catch (IOException e) {
            throw new TosClientException("build tos request failed", e);
        }
    }

    public static n b(c cVar, String str, String str2) {
        String string;
        String str3 = null;
        try {
            n nVarA = cVar.a(null, "PUT");
            HashMap map = nVarA.m;
            HashMap map2 = nVarA.n;
            if (map2 != null) {
                String str4 = (String) map2.get("versionId");
                nVarA.n.remove("versionId");
                str3 = str4;
            }
            try {
                if (AbstractC0291a.x(str3)) {
                    StringBuilder sbV = B7.a.v("/", str, "/");
                    sbV.append(URLEncoder.encode(str2, "UTF-8"));
                    string = sbV.toString();
                } else {
                    StringBuilder sbV2 = B7.a.v("/", str, "/");
                    sbV2.append(URLEncoder.encode(str2, "UTF-8"));
                    sbV2.append("?versionId=");
                    sbV2.append(str3);
                    string = sbV2.toString();
                }
                map.put("X-Tos-Copy-Source", string);
                K1.a aVar = cVar.f1506a;
                if (aVar != null) {
                    HashMap mapO = aVar.o(nVarA);
                    for (String str5 : mapO.keySet()) {
                        map.put(str5, mapO.get(str5));
                    }
                }
                return nVarA;
            } catch (UnsupportedEncodingException e) {
                throw new TosClientException("object key encode exception", e);
            }
        } catch (IOException e6) {
            throw new TosClientException("build tos request failed", e6);
        }
    }

    public final c c(String str, String str2, Map map) {
        String str3 = this.b;
        String str4 = this.c;
        K1.a aVar = this.f1519a;
        c cVar = new c();
        cVar.g = 0;
        cVar.i = new HashMap(1);
        cVar.k = true;
        Objects.requireNonNull(str3, "scheme is null");
        Objects.requireNonNull(str4, "host is null");
        cVar.e = str;
        cVar.f = str2;
        cVar.b = str3;
        cVar.c = str4;
        cVar.f1506a = aVar;
        cVar.c("User-Agent", a7.f.f1651a);
        if (map != null) {
            map.forEach(new m(cVar, 1));
        }
        cVar.g = this.e;
        cVar.d = this.d;
        return cVar;
    }

    public final void d(String str) throws NumberFormatException, UnknownHostException {
        int iIndexOf;
        int i;
        ArrayList arrayListD = AbstractC0307c.d(str);
        this.b = (String) arrayListD.get(0);
        String str2 = (String) arrayListD.get(1);
        this.c = str2;
        if (AbstractC0291a.x(str2)) {
            return;
        }
        try {
            String str3 = "https://" + str2;
            kotlin.jvm.internal.k.f(str3, "<this>");
            y yVarD = null;
            try {
                x xVar = new x(0);
                xVar.j(null, str3);
                yVarD = xVar.d();
            } catch (IllegalArgumentException unused) {
            }
            if (yVarD != null && !AbstractC0291a.x(yVarD.d)) {
                InetAddress byName = InetAddress.getByName(yVarD.d);
                if (!AbstractC0291a.s(byName.getHostAddress(), yVarD.d) && !AbstractC0291a.s(yVarD.d, "localhost")) {
                    if (!(byName instanceof Inet6Address) || !byName.getHostAddress().matches("^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}|:((:[\\da−fA−F]1,4)1,6|:)|:((:[\\da−fA−F]1,4)1,6|:)|^[\\da-fA-F]{1,4}:((:[\\da-fA-F]{1,4}){1,5}|:)|([\\da−fA−F]1,4:)2((:[\\da−fA−F]1,4)1,4|:)|([\\da−fA−F]1,4:)2((:[\\da−fA−F]1,4)1,4|:)|^([\\da-fA-F]{1,4}:){3}((:[\\da-fA-F]{1,4}){1,3}|:)|([\\da−fA−F]1,4:)4((:[\\da−fA−F]1,4)1,2|:)|([\\da−fA−F]1,4:)4((:[\\da−fA−F]1,4)1,2|:)|^([\\da-fA-F]{1,4}:){5}:([\\da-fA-F]{1,4})?|([\\da−fA−F]1,4:)6:|([\\da−fA−F]1,4:)6:")) {
                        return;
                    }
                    if (!yVarD.d.matches("^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}|:((:[\\da−fA−F]1,4)1,6|:)|:((:[\\da−fA−F]1,4)1,6|:)|^[\\da-fA-F]{1,4}:((:[\\da-fA-F]{1,4}){1,5}|:)|([\\da−fA−F]1,4:)2((:[\\da−fA−F]1,4)1,4|:)|([\\da−fA−F]1,4:)2((:[\\da−fA−F]1,4)1,4|:)|^([\\da-fA-F]{1,4}:){3}((:[\\da-fA-F]{1,4}){1,3}|:)|([\\da−fA−F]1,4:)4((:[\\da−fA−F]1,4)1,2|:)|([\\da−fA−F]1,4:)4((:[\\da−fA−F]1,4)1,2|:)|^([\\da-fA-F]{1,4}:){5}:([\\da-fA-F]{1,4})?|([\\da−fA−F]1,4:)6:|([\\da−fA−F]1,4:)6:")) {
                        return;
                    }
                }
                this.e = 1;
                String str4 = this.c;
                if (AbstractC0291a.x(str4) || (iIndexOf = str4.indexOf(":")) == -1) {
                    i = 0;
                } else {
                    String strSubstring = (!str4.contains(".") && str4.contains("]:")) ? str4.split("]:")[1] : str4.substring(iIndexOf + 1);
                    try {
                        i = Integer.parseInt(strSubstring);
                    } catch (NumberFormatException unused2) {
                    }
                }
                this.d = i;
                if (i != 0) {
                    this.c = this.c.substring(0, (this.c.length() - String.valueOf(this.d).length()) - 1);
                }
            }
        } catch (UnknownHostException unused3) {
        }
    }
}

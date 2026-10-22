package X6;

import a.AbstractC0291a;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public K1.a f1506a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public int g;
    public long h;
    public HashMap i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap f1507j;
    public boolean k;

    public final n a(InputStream inputStream, String str) throws NumberFormatException {
        n nVarB = b(inputStream, str);
        if (nVarB.k != null) {
            HashMap map = this.i;
            long j5 = this.h;
            if (j5 > 0) {
                nVarB.f = j5;
            } else if (AbstractC0291a.y((String) map.get(HttpHeaders.CONTENT_LENGTH))) {
                try {
                    long j6 = Long.parseLong((String) map.get(HttpHeaders.CONTENT_LENGTH));
                    if (j6 <= 0) {
                        j6 = -1;
                    }
                    nVarB.f = j6;
                } catch (NumberFormatException e) {
                    a7.f.e.debug("tos: try to get content length from header failed, ", e);
                    nVarB.f = -1L;
                }
            } else {
                nVarB.f = -1L;
            }
            InputStream inputStream2 = nVarB.k;
            if ((inputStream2 instanceof FileInputStream) && nVarB.f <= 0) {
                try {
                    nVarB.f = ((FileInputStream) inputStream2).getChannel().size();
                } catch (IOException e6) {
                    a7.f.e.debug("tos: try to get content length from file failed, ", e6);
                    nVarB.f = -1L;
                }
            }
        }
        HashMap map2 = nVarB.m;
        if (map2 != null && map2.size() > 0) {
            HashMap map3 = new HashMap();
            Iterator it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (AbstractC0291a.y(str2) && str2.startsWith("X-Tos-Meta-")) {
                    map3.put(a7.f.e(str2), a7.f.e(str3));
                    it.remove();
                } else if (AbstractC0291a.s(str2, "Content-Disposition")) {
                    map3.put(str2, a7.f.e(str3));
                    it.remove();
                }
            }
            map2.putAll(map3);
        }
        return nVarB;
    }

    public final n b(InputStream inputStream, String str) {
        String str2 = this.e;
        String str3 = this.f;
        String[] strArr = {"", ""};
        int i = this.g;
        if (i == 2) {
            strArr[0] = this.c;
            strArr[1] = B7.a.k("/", str3);
        } else if (i == 1) {
            strArr[0] = this.c;
            strArr[1] = B7.a.n("/", str2, "/", str3);
        } else if (AbstractC0291a.x(str2)) {
            strArr[0] = this.c;
            strArr[1] = "/";
        } else {
            StringBuilder sbX = androidx.appfunctions.metadata.a.x(str2, ".");
            sbX.append(this.c);
            strArr[0] = sbX.toString();
            strArr[1] = B7.a.k("/", str3);
        }
        String str4 = this.b;
        String str5 = strArr[0];
        String str6 = strArr[1];
        HashMap map = this.f1507j;
        HashMap map2 = this.i;
        n nVar = new n();
        Map map3 = Collections.EMPTY_MAP;
        nVar.o = new byte[0];
        nVar.f1517a = str4;
        nVar.b = str;
        nVar.c = str5;
        nVar.d = str6;
        nVar.k = inputStream;
        nVar.n = map;
        nVar.m = map2;
        nVar.g = true;
        nVar.h = true;
        int i6 = this.d;
        if (i6 != 0) {
            nVar.e = i6;
        }
        return nVar;
    }

    public final void c(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.i.put(str, str2);
    }

    public final void d(String str, String str2) {
        if (AbstractC0291a.x(str) || str2 == null) {
            return;
        }
        if (this.f1507j == null) {
            this.f1507j = new HashMap(1);
        }
        this.f1507j.put(str, str2);
    }
}

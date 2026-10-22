package F9;

import android.util.StateSet;
import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes4.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f658a;
    public int b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;

    public x(C0223a c0223a, h2.d routeDatabase, J9.i iVar, t eventListener) {
        List listJ;
        this.f658a = 1;
        kotlin.jvm.internal.k.f(routeDatabase, "routeDatabase");
        kotlin.jvm.internal.k.f(eventListener, "eventListener");
        this.d = c0223a;
        this.e = routeDatabase;
        this.f = iVar;
        this.g = eventListener;
        EmptyList emptyList = EmptyList.f4893a;
        this.h = emptyList;
        this.i = emptyList;
        this.c = new ArrayList();
        y url = c0223a.i;
        Proxy proxy = c0223a.g;
        kotlin.jvm.internal.k.f(url, "url");
        if (proxy != null) {
            listJ = H4.o.M(proxy);
        } else {
            URI uriI = url.i();
            if (uriI.getHost() == null) {
                listJ = G9.b.j(Proxy.NO_PROXY);
            } else {
                List<Proxy> proxiesOrNull = c0223a.h.select(uriI);
                List<Proxy> list = proxiesOrNull;
                if (list == null || list.isEmpty()) {
                    listJ = G9.b.j(Proxy.NO_PROXY);
                } else {
                    kotlin.jvm.internal.k.e(proxiesOrNull, "proxiesOrNull");
                    listJ = G9.b.w(proxiesOrNull);
                }
            }
        }
        this.h = listJ;
        this.b = 0;
    }

    public void a(String encodedName, String str) {
        kotlin.jvm.internal.k.f(encodedName, "encodedName");
        if (((ArrayList) this.i) == null) {
            this.i = new ArrayList();
        }
        ArrayList arrayList = (ArrayList) this.i;
        kotlin.jvm.internal.k.c(arrayList);
        arrayList.add(C0237o.c(encodedName, 0, true, " \"'<>#&=", 0, 211));
        ArrayList arrayList2 = (ArrayList) this.i;
        kotlin.jvm.internal.k.c(arrayList2);
        arrayList2.add(str != null ? C0237o.c(str, 0, true, " \"'<>#&=", 0, 211) : null);
    }

    public void b(String name, String str) {
        kotlin.jvm.internal.k.f(name, "name");
        if (((ArrayList) this.i) == null) {
            this.i = new ArrayList();
        }
        ArrayList arrayList = (ArrayList) this.i;
        kotlin.jvm.internal.k.c(arrayList);
        arrayList.add(C0237o.c(name, 0, false, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", 0, 219));
        ArrayList arrayList2 = (ArrayList) this.i;
        kotlin.jvm.internal.k.c(arrayList2);
        arrayList2.add(str != null ? C0237o.c(str, 0, false, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", 0, 219) : null);
    }

    public void c(int[] iArr, e3.p pVar) {
        int i = this.b;
        if (i == 0 || iArr.length == 0) {
            this.d = pVar;
        }
        int[][] iArr2 = (int[][]) this.e;
        if (i >= iArr2.length) {
            int i6 = i + 10;
            int[][] iArr3 = new int[i6][];
            System.arraycopy(iArr2, 0, iArr3, 0, i);
            this.e = iArr3;
            e3.p[] pVarArr = new e3.p[i6];
            System.arraycopy((e3.p[]) this.f, 0, pVarArr, 0, i);
            this.f = pVarArr;
        }
        int[][] iArr4 = (int[][]) this.e;
        int i10 = this.b;
        iArr4[i10] = iArr;
        ((e3.p[]) this.f)[i10] = pVar;
        this.b = i10 + 1;
    }

    public y d() {
        ArrayList arrayList;
        String str = (String) this.d;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        String strF = C0237o.f((String) this.e, 0, 0, 7);
        String strF2 = C0237o.f((String) this.f, 0, 0, 7);
        String str2 = (String) this.g;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iE = e();
        ArrayList arrayList2 = (ArrayList) this.c;
        ArrayList arrayList3 = new ArrayList(D7.w.c0(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(C0237o.f((String) it.next(), 0, 0, 7));
        }
        ArrayList<String> arrayList4 = (ArrayList) this.i;
        if (arrayList4 != null) {
            ArrayList arrayList5 = new ArrayList(D7.w.c0(arrayList4, 10));
            for (String str3 : arrayList4) {
                arrayList5.add(str3 != null ? C0237o.f(str3, 0, 0, 3) : null);
            }
            arrayList = arrayList5;
        } else {
            arrayList = null;
        }
        String str4 = (String) this.h;
        return new y(str, strF, strF2, str2, iE, arrayList3, arrayList, str4 != null ? C0237o.f(str4, 0, 0, 7) : null, toString());
    }

    public int e() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        String str = (String) this.d;
        kotlin.jvm.internal.k.c(str);
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return WebSocketImpl.DEFAULT_WSS_PORT;
        }
        return -1;
    }

    public void f(String str) {
        this.i = str != null ? C0237o.g(C0237o.c(str, 0, true, " \"'<>#", 0, 211)) : null;
    }

    public boolean g() {
        return this.b < ((List) this.h).size() || !((ArrayList) this.c).isEmpty();
    }

    public void h(String host) {
        kotlin.jvm.internal.k.f(host, "host");
        String strN = com.stepos.statsrpk.d.N(C0237o.f(host, 0, 0, 7));
        if (strN == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(host));
        }
        this.g = strN;
    }

    public void i() {
        this.d = new e3.p();
        this.e = new int[10][];
        this.f = new e3.p[10];
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(F9.y r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F9.x.j(F9.y, java.lang.String):void");
    }

    public void k(int i) {
        if (1 > i || i >= 65536) {
            throw new IllegalArgumentException(B7.a.h(i, "unexpected port: ").toString());
        }
        this.b = i;
    }

    public void l(String str, int i, int i6, boolean z10, boolean z11) {
        ArrayList arrayList = (ArrayList) this.c;
        String strC = C0237o.c(str, i, z11, " \"<>^`{}|/\\?#", i6, 240);
        if (strC.equals(".") || strC.equalsIgnoreCase("%2e")) {
            return;
        }
        if (strC.equals("..") || strC.equalsIgnoreCase("%2e.") || strC.equalsIgnoreCase(".%2e") || strC.equalsIgnoreCase("%2e%2e")) {
            if (((String) arrayList.remove(arrayList.size() - 1)).length() != 0 || arrayList.isEmpty()) {
                arrayList.add("");
                return;
            } else {
                arrayList.set(arrayList.size() - 1, "");
                return;
            }
        }
        if (((CharSequence) arrayList.get(arrayList.size() - 1)).length() == 0) {
            arrayList.set(arrayList.size() - 1, strC);
        } else {
            arrayList.add(strC);
        }
        if (z10) {
            arrayList.add("");
        }
    }

    public void m(String scheme) {
        kotlin.jvm.internal.k.f(scheme, "scheme");
        if (scheme.equalsIgnoreCase("http")) {
            this.d = "http";
        } else {
            if (!scheme.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(scheme));
            }
            this.d = "https";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F9.x.toString():java.lang.String");
    }

    public x(e3.p pVar) {
        this.f658a = 2;
        i();
        c(StateSet.WILD_CARD, pVar);
    }

    public x(int i) {
        this.f658a = i;
        switch (i) {
            case 2:
                break;
            default:
                this.e = "";
                this.f = "";
                this.b = -1;
                ArrayList arrayList = new ArrayList();
                this.c = arrayList;
                arrayList.add("");
                break;
        }
    }
}

package N9;

import D7.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Protocol;

/* loaded from: classes4.dex */
public final class l {
    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Protocol) obj) != Protocol.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Protocol) it.next()).f5464a);
        }
        return arrayList2;
    }

    public static byte[] b(List list) {
        V9.g gVar = new V9.g();
        Iterator it = a(list).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            gVar.L(str.length());
            gVar.R(str);
        }
        return gVar.E(gVar.b);
    }

    public static boolean c() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }
}

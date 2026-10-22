package id;

import ad.x;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {
    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((x) obj) != x.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kb.m.m0(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((x) obj2).f630c);
        }
        return arrayList2;
    }

    public static byte[] b(List list) {
        od.i iVar = new od.i();
        ArrayList arrayListA = a(list);
        int size = arrayListA.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListA.get(i);
            i++;
            String str = (String) obj;
            iVar.b0(str.length());
            iVar.g0(str);
        }
        return iVar.O(iVar.f9454f);
    }

    public static boolean c() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }
}

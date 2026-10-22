package j4;

import D7.w;
import H4.o;
import android.util.Log;
import j9.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

/* renamed from: j4.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1598c {

    /* renamed from: a, reason: collision with root package name */
    public Object f4774a;
    public Object b;
    public int c;
    public double d;
    public Object e;
    public Object f;

    public static ArrayList b(String str) {
        List listM;
        ArrayList arrayList = new ArrayList();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        List listG = new Regex("[^a-z0-9\\u4e00-\\u9fff]+").g(lowerCase);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listG) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            arrayList.add(str2);
            k.f(str2, "<this>");
            int length = str2.length();
            int i = 0;
            if (length == 0) {
                listM = EmptyList.f4893a;
            } else if (length != 1) {
                listM = new ArrayList(str2.length());
                m.Q0(str2, listM);
            } else {
                listM = o.M(Character.valueOf(str2.charAt(0)));
            }
            List list = listM;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    char cCharValue = ((Character) it2.next()).charValue();
                    if (19968 <= cCharValue && cCharValue < 40960) {
                        int size = listM.size() - 1;
                        while (i < size) {
                            Object obj2 = listM.get(i);
                            i++;
                            Object obj3 = listM.get(i);
                            StringBuilder sb = new StringBuilder();
                            sb.append(obj2);
                            sb.append(obj3);
                            arrayList.add(sb.toString());
                        }
                        Iterator it3 = listM.iterator();
                        while (it3.hasNext()) {
                            char cCharValue2 = ((Character) it3.next()).charValue();
                            if (19968 <= cCharValue2 && cCharValue2 < 40960) {
                                arrayList.add(String.valueOf(cCharValue2));
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object, java.util.Map] */
    public final synchronized void a(List tools) {
        try {
            k.f(tools, "tools");
            List list = tools;
            int iP = kotlin.collections.a.P(w.c0(list, 10));
            if (iP < 16) {
                iP = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
            for (Object obj : list) {
                linkedHashMap.put(((J3.a) obj).b, obj);
            }
            this.f = linkedHashMap;
            int size = tools.size();
            this.c = size;
            if (size == 0) {
                this.f4774a = kotlin.collections.a.M();
                this.b = kotlin.collections.a.M();
                this.e = kotlin.collections.a.M();
                this.d = 0.0d;
                return;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            Iterator it = tools.iterator();
            long size2 = 0;
            while (it.hasNext()) {
                J3.a aVar = (J3.a) it.next();
                ArrayList arrayListB = b(aVar.b + " " + aVar.e);
                linkedHashMap3.put(aVar.b, Integer.valueOf(arrayListB.size()));
                size2 += (long) arrayListB.size();
                for (Map.Entry entry : M.a.Q(new C1597b(arrayListB)).entrySet()) {
                    String str = (String) entry.getKey();
                    int iIntValue = ((Number) entry.getValue()).intValue();
                    Object arrayList = linkedHashMap2.get(str);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap2.put(str, arrayList);
                    }
                    ((List) arrayList).add(new C1596a(aVar.b, iIntValue));
                }
            }
            int i = this.c;
            this.d = i > 0 ? size2 / i : 1.0d;
            this.e = linkedHashMap3;
            this.f4774a = linkedHashMap2;
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(kotlin.collections.a.P(linkedHashMap2.size()));
            for (Object obj2 : linkedHashMap2.entrySet()) {
                linkedHashMap4.put(((Map.Entry) obj2).getKey(), Integer.valueOf(((List) ((Map.Entry) obj2).getValue()).size()));
            }
            this.b = linkedHashMap4;
            Log.i("BM25Index", "rebuild: docs=" + this.c + " terms=" + this.f4774a.size() + " avgDocLen=" + String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(this.d)}, 1)));
        } catch (Throwable th) {
            throw th;
        }
    }
}

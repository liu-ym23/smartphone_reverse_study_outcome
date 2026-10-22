package F0;

import H.h;
import android.app.Application;
import android.text.TextUtils;
import ca.AbstractC0897f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m0.C1669c;
import m0.C1672f;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class a {
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public Application f515a;

    public final void a(long j5, long j6, boolean z10) {
        C1672f c1672f;
        int i;
        Iterator it;
        String str;
        int size;
        Iterator it2;
        c cVar;
        String str2;
        C1669c c1669c;
        if (j5 <= 0 || j6 <= 0 || j6 < j5) {
            return;
        }
        if ((!z10 || AbstractC0897f.p(this.f515a)) && AbstractC0897f.h(this.f515a) && h.g()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strE = androidx.constraintlayout.core.dsl.a.e(j5 + j6, "", new StringBuilder());
            if (TextUtils.isEmpty(strE)) {
                c1672f = null;
            } else {
                ConcurrentHashMap concurrentHashMap = b;
                if (concurrentHashMap.containsKey(strE)) {
                    c1672f = (C1672f) concurrentHashMap.get(strE);
                } else {
                    C1672f c1672f2 = new C1672f();
                    c1672f2.f5297a = 0L;
                    concurrentHashMap.put(strE, c1672f2);
                    c1672f = c1672f2;
                }
            }
            if (c1672f != null && jCurrentTimeMillis - c1672f.f5297a >= 600000) {
                c1672f.f5297a = jCurrentTimeMillis;
                List list = c.f517D;
                c cVar2 = b.f516a;
                cVar2.getClass();
                if (J2.c.f865a.g) {
                    try {
                        HashMap map = new HashMap(2);
                        List<String> list2 = cVar2.f520B;
                        if (list2 == null) {
                            return;
                        }
                        for (String str3 : list2) {
                            map.put(str3, c.m(str3));
                        }
                        Iterator it3 = map.entrySet().iterator();
                        int i6 = 0;
                        while (it3.hasNext()) {
                            Map.Entry entry = (Map.Entry) it3.next();
                            List list3 = (List) entry.getValue();
                            String str4 = (String) entry.getKey();
                            List list4 = list3;
                            long j10 = j6;
                            long j11 = j5;
                            while (true) {
                                List<C1669c> listI = cVar2.i(i6, list4, j11, j10);
                                i = i6;
                                List list5 = list4;
                                if (S0.b.a0(listI)) {
                                    it = it3;
                                    str = str4;
                                    size = 0;
                                } else {
                                    size = listI.size();
                                    JSONArray jSONArray = new JSONArray();
                                    LinkedList linkedList = new LinkedList();
                                    JSONArray jSONArray2 = jSONArray;
                                    long j12 = -1;
                                    for (C1669c c1669c2 : listI) {
                                        try {
                                            if (j12 == -1) {
                                                j12 = c1669c2.e;
                                                c1669c = c1669c2;
                                                str2 = str4;
                                            } else {
                                                String str5 = str4;
                                                try {
                                                    if (c1669c2.e != j12) {
                                                        c1669c = c1669c2;
                                                        str2 = str5;
                                                        try {
                                                            if (cVar2.l(str2, jSONArray2, null, j12, true)) {
                                                                c.h(linkedList);
                                                                linkedList.clear();
                                                            }
                                                            j12 = c1669c.e;
                                                            jSONArray2 = new JSONArray();
                                                        } catch (Exception unused) {
                                                            it2 = it3;
                                                            cVar = cVar2;
                                                            it3 = it2;
                                                            str4 = str2;
                                                            cVar2 = cVar;
                                                        }
                                                    } else {
                                                        c1669c = c1669c2;
                                                        str2 = str5;
                                                    }
                                                } catch (Exception unused2) {
                                                    str2 = str5;
                                                }
                                            }
                                            it2 = it3;
                                            cVar = cVar2;
                                            try {
                                                long j13 = c1669c.f5294a;
                                                linkedList.add(c1669c);
                                                jSONArray2.put(c1669c.d);
                                            } catch (Exception unused3) {
                                            }
                                        } catch (Exception unused4) {
                                            it2 = it3;
                                            cVar = cVar2;
                                            str2 = str4;
                                        }
                                        it3 = it2;
                                        str4 = str2;
                                        cVar2 = cVar;
                                    }
                                    it = it3;
                                    str = str4;
                                    if (!cVar2.l(str, jSONArray2, null, j12, true) || c.h(linkedList) <= 0) {
                                        i += 400;
                                    }
                                }
                                if (size != 400) {
                                    break;
                                }
                                it3 = it;
                                str4 = str;
                                list4 = list5;
                                i6 = i;
                                j11 = j5;
                                j10 = j6;
                            }
                            it3 = it;
                            i6 = i;
                        }
                    } catch (Throwable unused5) {
                    }
                }
            }
        }
    }
}

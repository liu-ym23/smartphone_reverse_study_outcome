package F5;

import D7.p;
import D7.v;
import H4.o;
import g1.AbstractC1451a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f554a = new g();
    public static final SimpleDateFormat b = new SimpleDateFormat("HH:mm:ss", Locale.US);
    public static volatile long c = 60000;
    public static final p d = new p();
    public static f e;

    public static void a(long j5) {
        f fVar = e;
        if (fVar == null) {
            return;
        }
        while (j5 - fVar.f553a >= c) {
            long j6 = fVar.f553a + c;
            f fVar2 = e;
            if (fVar2 != null) {
                SimpleDateFormat fmt = b;
                k.f(fmt, "fmt");
                ArrayList arrayList = (ArrayList) fVar2.c;
                LinkedHashMap linkedHashMap = (LinkedHashMap) fVar2.d;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("time", fmt.format(new Date(fVar2.f553a)) + "-" + fmt.format(new Date(j6)));
                linkedHashMap2.put("charging", Boolean.FALSE);
                ArrayList arrayList2 = (ArrayList) fVar2.b;
                if (!arrayList2.isEmpty()) {
                    Iterator it = arrayList2.iterator();
                    int iIntValue = 0;
                    double dIntValue = 0.0d;
                    int i = 0;
                    while (it.hasNext()) {
                        dIntValue += ((Number) it.next()).intValue();
                        i++;
                        if (i < 0) {
                            o.W();
                            throw null;
                        }
                    }
                    Pair pair = new Pair("avg", Integer.valueOf((int) (i == 0 ? Double.NaN : dIntValue / i)));
                    Integer num = (Integer) v.M0(arrayList2);
                    Pair pair2 = new Pair("max", Integer.valueOf(num != null ? num.intValue() : 0));
                    if (!arrayList2.isEmpty()) {
                        List listY0 = v.Y0(arrayList2);
                        iIntValue = ((Number) listY0.get(AbstractC1451a.u((int) Math.ceil(listY0.size() * 0.95d), 1, listY0.size()) - 1)).intValue();
                    }
                    linkedHashMap2.put("cpu", kotlin.collections.a.O(pair, pair2, new Pair("p95", Integer.valueOf(iIntValue))));
                }
                if (!linkedHashMap.isEmpty()) {
                    linkedHashMap2.put("temp", new LinkedHashMap(linkedHashMap));
                }
                if (!arrayList.isEmpty()) {
                    linkedHashMap2.put("events", new ArrayList(arrayList));
                }
                e eVar = new e(fVar2.f553a, j6, linkedHashMap2);
                p pVar = d;
                pVar.addLast(eVar);
                if (pVar.size() > 10) {
                    pVar.removeFirst();
                }
                ExecutorService executorService = d.f551a;
                StringBuilder sb = new StringBuilder(128);
                o.i(linkedHashMap2, sb);
                k.e(sb.toString(), "toString(...)");
                e = new f(j6);
            }
            fVar = e;
            if (fVar == null) {
                return;
            }
        }
    }
}

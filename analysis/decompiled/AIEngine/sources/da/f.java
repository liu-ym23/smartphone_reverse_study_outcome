package da;

import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import dc.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import mb.k;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f8419a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f8420b = new SimpleDateFormat("HH:mm:ss", Locale.US);

    /* renamed from: c, reason: collision with root package name */
    public static volatile long f8421c = HysteresisStrategy.DEFAULT_DWELL_MS;

    /* renamed from: d, reason: collision with root package name */
    public static final k<a> f8422d = new k<>();

    /* renamed from: e, reason: collision with root package name */
    public static b f8423e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f8424a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8425b;

        /* renamed from: c, reason: collision with root package name */
        public final LinkedHashMap<String, Object> f8426c;

        public a(long j10, long j11, LinkedHashMap<String, Object> linkedHashMap) {
            this.f8424a = j10;
            this.f8425b = j11;
            this.f8426c = linkedHashMap;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8424a == aVar.f8424a && this.f8425b == aVar.f8425b && g.b(this.f8426c, aVar.f8426c);
        }

        public final int hashCode() {
            return this.f8426c.hashCode() + a0.a.c(Long.hashCode(this.f8424a) * 31, this.f8425b, 31);
        }

        public final String toString() {
            StringBuilder sbQ = ai.onnxruntime.a.q(this.f8424a, "BucketRecord(startMs=", ", endMs=");
            sbQ.append(this.f8425b);
            sbQ.append(", json=");
            sbQ.append(this.f8426c);
            sbQ.append(")");
            return sbQ.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long f8427a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<Integer> f8428b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public final LinkedHashMap<String, Integer> f8429c = new LinkedHashMap<>();

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<Map<String, Object>> f8430d = new ArrayList<>();

        public b(long j10) {
            this.f8427a = j10;
        }
    }

    public static void a(long j10) {
        b bVar = f8423e;
        if (bVar == null) {
            return;
        }
        while (j10 - bVar.f8427a >= f8421c) {
            long j11 = bVar.f8427a + f8421c;
            b bVar2 = f8423e;
            if (bVar2 != null) {
                SimpleDateFormat fmt = f8420b;
                g.f(fmt, "fmt");
                ArrayList<Map<String, Object>> arrayList = bVar2.f8430d;
                LinkedHashMap<String, Integer> linkedHashMap = bVar2.f8429c;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("time", fmt.format(new Date(bVar2.f8427a)) + "-" + fmt.format(new Date(j11)));
                linkedHashMap2.put("charging", Boolean.FALSE);
                ArrayList<Integer> arrayList2 = bVar2.f8428b;
                if (!arrayList2.isEmpty()) {
                    int size = arrayList2.size();
                    int iIntValue = 0;
                    double dIntValue = 0.0d;
                    int i10 = 0;
                    int i11 = 0;
                    do {
                        Integer num = null;
                        if (i11 < size) {
                            Integer num2 = arrayList2.get(i11);
                            i11++;
                            dIntValue += num2.intValue();
                            i10++;
                        } else {
                            Pair pair = new Pair("avg", Integer.valueOf((int) (i10 == 0 ? Double.NaN : dIntValue / i10)));
                            Iterator<Integer> it = arrayList2.iterator();
                            if (it.hasNext()) {
                                Integer next = it.next();
                                while (true) {
                                    num = next;
                                    while (it.hasNext()) {
                                        next = it.next();
                                        if (num.compareTo(next) < 0) {
                                            break;
                                        }
                                    }
                                }
                            }
                            Integer num3 = num;
                            Pair pair2 = new Pair("max", Integer.valueOf(num3 != null ? num3.intValue() : 0));
                            if (!arrayList2.isEmpty()) {
                                List listH0 = kotlin.collections.a.H0(arrayList2);
                                iIntValue = ((Number) listH0.get(h.a0((int) Math.ceil(listH0.size() * 0.95d), 1, listH0.size()) - 1)).intValue();
                            }
                            linkedHashMap2.put("cpu", kotlin.collections.b.f0(pair, pair2, new Pair("p95", Integer.valueOf(iIntValue))));
                        }
                    } while (i10 >= 0);
                    m.e0();
                    throw null;
                }
                if (!linkedHashMap.isEmpty()) {
                    linkedHashMap2.put("temp", new LinkedHashMap(linkedHashMap));
                }
                if (!arrayList.isEmpty()) {
                    linkedHashMap2.put("events", new ArrayList(arrayList));
                }
                a aVar = new a(bVar2.f8427a, j11, linkedHashMap2);
                k<a> kVar = f8422d;
                kVar.addLast(aVar);
                if (kVar.f10558c > 10) {
                    kVar.removeFirst();
                }
                ExecutorService executorService = e.f8418a;
                StringBuilder sb2 = new StringBuilder(TraceIdKeys.MAX_LENGTH);
                c.a(sb2, linkedHashMap2);
                g.e(sb2.toString(), "toString(...)");
                f8423e = new b(j11);
            }
            bVar = f8423e;
            if (bVar == null) {
                return;
            }
        }
    }
}

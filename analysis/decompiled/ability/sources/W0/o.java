package W0;

import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f1484a = new AtomicInteger(0);
    public static final List b = Arrays.asList("tracing");
    public static final ArrayList c;
    public static final l d;
    public static final l e;
    public static final m f;

    static {
        l lVar = new l(0);
        d = lVar;
        l lVar2 = new l(1);
        e = lVar2;
        m mVar = new m();
        f = mVar;
        ArrayList arrayList = new ArrayList();
        c = arrayList;
        arrayList.add(lVar);
        arrayList.add(lVar2);
        arrayList.add(mVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x013f A[Catch: all -> 0x01bc, TryCatch #7 {all -> 0x01bc, blocks: (B:3:0x0004, B:4:0x0015, B:6:0x001b, B:8:0x002f, B:9:0x003b, B:10:0x0049, B:12:0x0055, B:14:0x005b, B:16:0x005e, B:17:0x0070, B:19:0x0076, B:23:0x0088, B:25:0x008e, B:27:0x0096, B:29:0x009a, B:30:0x00a4, B:32:0x00b0, B:35:0x00b6, B:38:0x00c6, B:40:0x00d4, B:45:0x00e4, B:47:0x00e8, B:49:0x00ee, B:55:0x0104, B:57:0x0108, B:59:0x0113, B:61:0x0132, B:64:0x0139, B:66:0x013f, B:68:0x0153, B:70:0x015b, B:71:0x0163, B:73:0x016b, B:74:0x0173, B:76:0x0183, B:41:0x00d7, B:43:0x00df, B:44:0x00e2, B:78:0x0194, B:79:0x01a1, B:81:0x01a7), top: B:105:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015b A[Catch: all -> 0x01bc, TryCatch #7 {all -> 0x01bc, blocks: (B:3:0x0004, B:4:0x0015, B:6:0x001b, B:8:0x002f, B:9:0x003b, B:10:0x0049, B:12:0x0055, B:14:0x005b, B:16:0x005e, B:17:0x0070, B:19:0x0076, B:23:0x0088, B:25:0x008e, B:27:0x0096, B:29:0x009a, B:30:0x00a4, B:32:0x00b0, B:35:0x00b6, B:38:0x00c6, B:40:0x00d4, B:45:0x00e4, B:47:0x00e8, B:49:0x00ee, B:55:0x0104, B:57:0x0108, B:59:0x0113, B:61:0x0132, B:64:0x0139, B:66:0x013f, B:68:0x0153, B:70:0x015b, B:71:0x0163, B:73:0x016b, B:74:0x0173, B:76:0x0183, B:41:0x00d7, B:43:0x00df, B:44:0x00e2, B:78:0x0194, B:79:0x01a1, B:81:0x01a7), top: B:105:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016b A[Catch: all -> 0x01bc, TryCatch #7 {all -> 0x01bc, blocks: (B:3:0x0004, B:4:0x0015, B:6:0x001b, B:8:0x002f, B:9:0x003b, B:10:0x0049, B:12:0x0055, B:14:0x005b, B:16:0x005e, B:17:0x0070, B:19:0x0076, B:23:0x0088, B:25:0x008e, B:27:0x0096, B:29:0x009a, B:30:0x00a4, B:32:0x00b0, B:35:0x00b6, B:38:0x00c6, B:40:0x00d4, B:45:0x00e4, B:47:0x00e8, B:49:0x00ee, B:55:0x0104, B:57:0x0108, B:59:0x0113, B:61:0x0132, B:64:0x0139, B:66:0x013f, B:68:0x0153, B:70:0x015b, B:71:0x0163, B:73:0x016b, B:74:0x0173, B:76:0x0183, B:41:0x00d7, B:43:0x00df, B:44:0x00e2, B:78:0x0194, B:79:0x01a1, B:81:0x01a7), top: B:105:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.HashMap a(java.util.ArrayList r22, int r23) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.o.a(java.util.ArrayList, int):java.util.HashMap");
    }

    public static void b(HashMap map) {
        if (AbstractC1451a.f4467a) {
            H4.o.f(S0.a.f1163a, "sendLog: input sendList merged into " + map.size() + " group(s)");
            int i = 0;
            for (Long l : map.keySet()) {
                List list = (List) map.get(l);
                H4.o.f(S0.a.f1163a, "----------------");
                U0.a aVarA = U0.b.b().a(String.valueOf(l));
                String str = S0.a.f1163a;
                StringBuilder sb = new StringBuilder("group ");
                int i6 = i + 1;
                sb.append(i);
                sb.append(" header:");
                sb.append(aVarA);
                H4.o.f(str, sb.toString());
                for (int i10 = 0; i10 < list.size(); i10++) {
                    String str2 = S0.a.f1163a;
                    StringBuilder sbU = B7.a.u(i10, "  log[", "]=");
                    sbU.append(((V0.b) list.get(i10)).toString());
                    H4.o.f(str2, sbU.toString());
                }
                H4.o.f(S0.a.f1163a, "----------------");
                i = i6;
            }
        }
    }
}

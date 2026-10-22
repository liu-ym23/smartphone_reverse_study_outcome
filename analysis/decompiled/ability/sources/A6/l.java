package A6;

import android.util.Log;
import c0.C0868b;
import c0.C0869c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m0.C1668b;

/* loaded from: classes3.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f151a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l(Object obj, int i) {
        this.f151a = i;
        this.b = obj;
    }

    private final void a() {
        LinkedList linkedList;
        boolean zD;
        C0868b c0868b = (C0868b) this.b;
        if (H.h.g()) {
            C0869c c0869c = new C0869c();
            c0869c.c = 0L;
            c0869c.d = 0L;
            c0869c.e = 0L;
            c0869c.f = 0L;
            c0869c.g = 0L;
            c0869c.h = 0L;
            c0869c.i = 0L;
            c0869c.f2071j = 0L;
            c0869c.k = 0L;
            c0869c.l = 0L;
            c0869c.m = true;
            List listA = c0868b.a(0L, true);
            if (!S0.b.a0(listA)) {
                try {
                    zD = C0868b.d(c0869c, listA);
                } catch (Exception unused) {
                    zD = false;
                }
                C1668b c1668b = (C1668b) listA.get(listA.size() - 1);
                long j5 = c1668b.f5292a;
                long j6 = c1668b.c;
                try {
                    if (zD) {
                        if (H.h.b) {
                            Log.i("<monitor><battery>", U7.a.e(new String[]{"report main process data over, begin handle other process data"}));
                        }
                        List<C1668b> listA2 = c0868b.a(j6, false);
                        HashMap map = new HashMap(4);
                        for (C1668b c1668b2 : listA2) {
                            String str = c1668b2.f5293j;
                            List list = (List) map.get(str);
                            if (list != null) {
                                list.add(c1668b2);
                            } else {
                                LinkedList linkedList2 = new LinkedList();
                                linkedList2.add(c1668b2);
                                map.put(str, linkedList2);
                            }
                        }
                        try {
                            Iterator it = map.values().iterator();
                            while (it.hasNext()) {
                                C0868b.d(c0869c, (List) it.next());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        c0869c.f = c0869c.f2073r;
                        c0869c.c = c0869c.u;
                        c0869c.d = c0869c.f2074s;
                        c0869c.g = c0869c.f2076v;
                        c0869c.e = c0869c.f2075t;
                        c0869c.f2070a = c0869c.p;
                        c0869c.k = c0869c.f2077w;
                        c0869c.h = c0869c.f2079z;
                        c0869c.i = c0869c.f2078x;
                        c0869c.l = c0869c.f2069A;
                        c0869c.f2071j = c0869c.y;
                        c0869c.b = c0869c.f2072q;
                        c0869c.m = false;
                        c0869c.n = "all_process";
                        try {
                            c0869c.b(false);
                        } catch (Exception unused2) {
                        }
                        c0868b.b().l(j5);
                    } else {
                        if (H.h.b) {
                            Log.w("<monitor><battery>", U7.a.e(new String[]{"report main process data failed, clean data and stop calc data of other process"}));
                        }
                        c0868b.b().l(j5);
                    }
                } catch (Exception unused3) {
                }
            }
        }
        ((C0868b) this.b).f2068a = true;
        synchronized (((LinkedList) ((C0868b) this.b).e)) {
            linkedList = new LinkedList((LinkedList) ((C0868b) this.b).e);
            ((LinkedList) ((C0868b) this.b).e).clear();
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            ((C0868b) this.b).c((C1668b) it2.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:289:0x068e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1974
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A6.l.run():void");
    }
}

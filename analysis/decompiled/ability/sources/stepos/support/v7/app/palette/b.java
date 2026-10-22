package stepos.support.v7.app.palette;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import v2.RunnableC2056a;

/* loaded from: classes4.dex */
public final class b {
    public static b b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f6328a;

    public static b a(Context context, Handler handler) {
        b bVar = new b();
        ArrayList arrayList = new ArrayList(3);
        bVar.f6328a = arrayList;
        if (com.stepos.statsrpk.d.l(context)) {
            arrayList.add(new RunnableC2056a(handler, 1, 15000L));
        }
        return bVar;
    }

    public static synchronized b c() {
        try {
            if (b == null) {
                b bVar = new b();
                bVar.f6328a = new ArrayList();
                b = bVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public void b() {
        StringBuilder sb = new StringBuilder("[ScheduleTaskManager] execute, task size=");
        ArrayList arrayList = this.f6328a;
        sb.append(arrayList.size());
        S0.b.N(sb.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RunnableC2056a runnableC2056a = (RunnableC2056a) it.next();
            try {
                runnableC2056a.f6767a.post(runnableC2056a);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(int i) {
        Iterator it = this.f6328a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i);
        }
    }
}

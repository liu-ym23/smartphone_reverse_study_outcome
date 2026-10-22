package w2;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import h2.RunnableC1484b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import z2.r;

/* loaded from: classes2.dex */
public final class l {
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public static final HashMap e = new HashMap();
    public static volatile l f;
    public volatile boolean b = false;
    public final RunnableC1484b c = new RunnableC1484b(this, 8);

    /* renamed from: a, reason: collision with root package name */
    public final r f6839a = z2.l.i();

    public static l a() {
        if (f == null) {
            synchronized (l.class) {
                try {
                    if (f == null) {
                        f = new l();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public static void b(Object obj, n2.d dVar) {
        String string;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Handler handler = z2.l.i().d;
        if (handler == null || handler.getLooper() != Looper.myLooper()) {
            z2.l.i().a(new A.a(23, obj, false, dVar));
            return;
        }
        if (obj == null) {
            obj = com.apm.insight.f.b;
        }
        if (z2.k.f6933a) {
            int i = z2.b.f6926a;
            String strF = n2.c.f(obj);
            if (!(strF != null ? z2.d.d(strF) : false)) {
                AbstractC2095a.i();
            }
            e();
            try {
                string = dVar.f5345a.getString("log_type");
            } catch (JSONException e6) {
                e6.printStackTrace();
                string = null;
            }
            if (TextUtils.isEmpty(string) || !z2.b.d(obj)) {
                S0.b.c0("EventUploadQueue", "logType " + string + " not sampled");
                return;
            }
            S0.b.c0("EventUploadQueue", "logType " + string + " enqueued");
            c(obj, dVar);
            return;
        }
        S0.b.c0("EventUploadQueue", "enqueue before init.");
        try {
            String string2 = dVar.f5345a.getString("log_type");
            HashMap map = e;
            synchronized (map) {
                try {
                    HashMap map2 = (HashMap) map.get(string2);
                    if (map2 == null) {
                        map2 = new HashMap();
                        map.put(obj, map2);
                    }
                    concurrentLinkedQueue = (ConcurrentLinkedQueue) map2.get(string2);
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue();
                        map2.put(string2, concurrentLinkedQueue);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            concurrentLinkedQueue.add(dVar);
            if (concurrentLinkedQueue.size() > 100) {
                concurrentLinkedQueue.poll();
            }
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
    }

    public static void c(Object obj, n2.d dVar) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (obj) {
            try {
                concurrentHashMap = d;
                concurrentLinkedQueue = (ConcurrentLinkedQueue) concurrentHashMap.get(obj);
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    concurrentHashMap.put(obj, concurrentLinkedQueue);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        concurrentLinkedQueue.add(dVar);
        int size = concurrentHashMap.size();
        boolean z10 = size >= 30;
        S0.b.t0("[enqueue] size=" + size);
        if (z10 && z2.k.f6933a && !Npth.isStopUpload()) {
            try {
                z2.l.i().a(new A1.a(20));
            } catch (Throwable unused) {
            }
        }
    }

    public static void e() {
        HashMap map;
        HashMap map2 = e;
        synchronized (map2) {
            map = new HashMap(map2);
            map2.clear();
        }
        int i = z2.b.f6926a;
        if (!z2.k.f6933a) {
            S0.b.c0("EventUploadQueue", "ApmConfig not inited, clear cache.");
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            for (Map.Entry entry2 : ((HashMap) entry.getValue()).entrySet()) {
                String str = (String) entry2.getKey();
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) entry2.getValue();
                if (concurrentLinkedQueue == null || (z2.k.f6933a && !z2.b.d(entry.getKey()))) {
                    S0.b.c0("EventUploadQueue", "logType " + str + " not sampled");
                } else {
                    while (!concurrentLinkedQueue.isEmpty()) {
                        try {
                            n2.d dVar = (n2.d) concurrentLinkedQueue.poll();
                            if (dVar != null) {
                                c(entry.getKey(), dVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f6839a) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                LinkedList linkedList = new LinkedList();
                for (Map.Entry entry : d.entrySet()) {
                    ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) entry.getValue();
                    Object key = entry.getKey();
                    while (!concurrentLinkedQueue.isEmpty()) {
                        for (int i = 0; i < 30; i++) {
                            try {
                                if (concurrentLinkedQueue.isEmpty()) {
                                    break;
                                }
                                linkedList.add(concurrentLinkedQueue.poll());
                            } catch (Throwable th) {
                                S0.b.p0(th);
                            }
                        }
                        if (linkedList.isEmpty()) {
                            break;
                        }
                        u1.d dVarS = u1.d.s();
                        ConcurrentLinkedQueue concurrentLinkedQueue2 = n2.c.f5346a;
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = n2.c.f5346a.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            com.apm.insight.f fVar = (com.apm.insight.f) it.next();
                            if (fVar != null) {
                                if (fVar.f2159a == key) {
                                    jSONArray.put(fVar.c(CrashType.JAVA, null, true));
                                    break;
                                }
                            }
                        }
                        n2.a aVarQ = dVarS.q(linkedList, jSONArray);
                        if (aVarQ != null) {
                            S0.b.N("upload events");
                            i.a().b(aVarQ.f5345a);
                        }
                        linkedList.clear();
                    }
                }
                this.b = false;
            } finally {
            }
        }
    }
}

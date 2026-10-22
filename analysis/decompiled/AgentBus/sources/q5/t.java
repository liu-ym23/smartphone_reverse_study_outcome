package q5;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f8775a;

    public t(int i2) {
        switch (i2) {
            case 1:
                this.f8775a = new ConcurrentHashMap();
                break;
            case 2:
                this.f8775a = new ConcurrentHashMap(16);
                break;
            case 3:
                this.f8775a = new ConcurrentHashMap();
                break;
            case 4:
                this.f8775a = new ConcurrentHashMap();
                break;
            default:
                this.f8775a = new ConcurrentHashMap();
                break;
        }
    }

    public void a(String str, String str2) {
        q7.k.e(str, "runId");
        q7.k.e(str2, "rawJson");
        if (str.length() == 0 || str2.length() == 0) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = this.f8775a;
        concurrentHashMap.put(str, str2);
        if (concurrentHashMap.size() <= 512) {
            return;
        }
        int size = concurrentHashMap.size() - 512;
        Set setKeySet = concurrentHashMap.keySet();
        q7.k.d(setKeySet, "<get-keys>(...)");
        Iterator it = d7.r.k1(setKeySet, size).iterator();
        while (it.hasNext()) {
            concurrentHashMap.remove((String) it.next());
        }
    }

    public void b(d5.e eVar) {
        q7.k.e(eVar, "originConnection");
        ConcurrentHashMap concurrentHashMap = this.f8775a;
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            String str = (String) entry.getKey();
            s sVar = (s) entry.getValue();
            if (sVar.f8773a == eVar) {
                q7.k.e(str, "requestId");
                concurrentHashMap.remove(str, sVar);
            }
        }
    }
}

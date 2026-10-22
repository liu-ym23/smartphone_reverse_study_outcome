package c1;

import com.bytedance.apm.battery.hook.IHookService;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f6028a;

    public a() {
        this.f6028a = new HashMap();
    }

    public void a(String r10, IHookService r11) {
        this.f6028a.put(r10, r11);
    }

    public void b() {
        if (this.f6028a.size() != 0) goto L5;
        return;
    L5:
        Class<?> r10 = Class.forName("android.app.SystemServiceRegistry");
        Field r11 = r10.getDeclaredField("SYSTEM_SERVICE_FETCHERS");
        r11.setAccessible(true);
        Map r12 = (Map) r11.get(null);
        Iterator r13 = this.f6028a.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        IHookService r16 = (IHookService) r14.getValue();
        Object r17 = r12.get(r15);
        r12.put(r15, Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{Class.forName("android.app.SystemServiceRegistry$ServiceFetcher")}, new b(r17, r16)));
        goto L7
    }
}

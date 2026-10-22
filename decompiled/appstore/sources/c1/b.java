package c1;

import android.text.TextUtils;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class b implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f6029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IHookService f6030b;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f6031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f6032b;

        public a(b r10, Object r11) {
            this.f6032b = r10;
            this.f6031a = r11;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) {
            b.a(this.f6032b).invoke(r10, r11, r12);     // Catch: Throwable -> L4
        L7:
            return r11.invoke(this.f6031a, r12);
        L4:
            th = move-exception;
            s1.a.a(Constants.TAG_BATTERY, "hookServiceImpl invoke failed: " + th.getMessage());
            goto L7
        }
    }

    public b(Object r10, IHookService r11) {
        this.f6029a = r10;
        this.f6030b = r11;
    }

    public static /* synthetic */ IHookService a(b r10) {
        return r10.f6030b;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r10, Method r11, Object[] r12) {
    L11:
        th = move-exception;
        s1.a.a(Constants.TAG_BATTERY, "ServiceFetcher getService hook failed: " + th.getMessage());
    L16:
        return r11.invoke(this.f6029a, r12);
    L3:
        if ("getService".equals(r11.getName()) == false) goto L16;
        Object r13 = r11.invoke(this.f6029a, r12);     // Catch: Throwable -> L11
        Field r14 = r13.getClass().getDeclaredField("mService");     // Catch: Throwable -> L11
        r14.setAccessible(true);     // Catch: Throwable -> L11
        Object r15 = r14.get(r13);     // Catch: Throwable -> L11
        String r16 = r15.getClass().getName();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r16) == false) goto L7;
    L13:
        return r13;
    L7:
        if (r16.startsWith(this.f6030b.getInterfaceName()) == false) goto L13;
        r14.set(r13, Proxy.newProxyInstance(r15.getClass().getClassLoader(), new Class[]{Class.forName(this.f6030b.getInterfaceName())}, new a(this, r15)));     // Catch: Throwable -> L11
        return r13;
    }
}

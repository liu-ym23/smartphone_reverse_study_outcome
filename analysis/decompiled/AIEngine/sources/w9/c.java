package w9;

import androidx.appcompat.widget.z0;
import androidx.lifecycle.q;
import com.stepos.deepbinder.core.handler.BaseInvocationHandler;
import com.stepos.deepbinder.core.log.IPCLog;
import java.lang.ref.Cleaner;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import x9.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f13608a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Cleaner f13609b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f13610c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public final c a() {
            c cVar;
            c cVar2 = c.f13610c;
            if (cVar2 != null) {
                return cVar2;
            }
            synchronized (this) {
                cVar = c.f13610c;
                if (cVar == null) {
                    cVar = new c();
                    c.f13610c = cVar;
                }
            }
            return cVar;
        }
    }

    static {
        Cleaner cleanerCreate = Cleaner.create();
        kotlin.jvm.internal.g.e(cleanerCreate, "create(...)");
        f13609b = cleanerCreate;
    }

    public static void a(Object obj) {
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
        BaseInvocationHandler baseInvocationHandler = invocationHandler instanceof BaseInvocationHandler ? (BaseInvocationHandler) invocationHandler : null;
        if (baseInvocationHandler == null) {
            return;
        }
        baseInvocationHandler.updateCleanable(f13609b.register(obj, new z0(baseInvocationHandler, 22)));
    }

    public final void b(final long j10, Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Object obj2;
        kotlin.jvm.internal.g.f(obj, "obj");
        Object obj3 = null;
        try {
            LinkedList linkedList = new LinkedList();
            h.c(obj, linkedList, 1);
            while (true) {
                if (linkedList.isEmpty()) {
                    break;
                }
                x9.b bVar = (x9.b) linkedList.poll();
                Field field = bVar.f13763b;
                try {
                    field.setAccessible(true);
                    obj2 = field.get(bVar.f13762a);
                } catch (Exception unused) {
                    obj2 = null;
                }
                if (obj2 instanceof q) {
                    obj3 = obj2;
                    break;
                } else {
                    int i10 = bVar.f13764c;
                    if (i10 < 1) {
                        h.c(obj2, linkedList, i10 + 1);
                    }
                }
            }
        } catch (Exception e10) {
            IPCLog.INSTANCE.w("TypeUtils", "[getExternalClass] exception: " + e10, new Object[0]);
        }
        if (obj3 != null) {
            final q qVar = (q) obj3;
            e.f13612e.b(new Runnable(this) { // from class: w9.b
                @Override // java.lang.Runnable
                public final void run() {
                    qVar.getLifecycle().a(new d(j10));
                }
            }, true, false);
        }
    }
}

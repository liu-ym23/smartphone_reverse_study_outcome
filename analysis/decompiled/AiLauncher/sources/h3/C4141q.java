package h3;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import m3.C4894a;
import m3.InterfaceC4895b;
import m3.InterfaceC4896c;
import m3.InterfaceC4897d;

/* renamed from: h3.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4141q implements InterfaceC4897d, InterfaceC4896c {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, ConcurrentHashMap<InterfaceC4895b<Object>, Executor>> f32937a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Queue<C4894a<?>> f32938b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final Executor f32939c;

    public C4141q(Executor executor) {
        this.f32939c = executor;
    }

    public void a() {
        Queue<C4894a<?>> queue;
        synchronized (this) {
            try {
                queue = this.f32938b;
                if (queue != null) {
                    this.f32938b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator<C4894a<?>> it = queue.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    public final synchronized Set<Map.Entry<InterfaceC4895b<Object>, Executor>> b(C4894a<?> c4894a) {
        ConcurrentHashMap<InterfaceC4895b<Object>, Executor> concurrentHashMap;
        try {
            concurrentHashMap = this.f32937a.get(c4894a.a());
        } catch (Throwable th) {
            throw th;
        }
        return concurrentHashMap == null ? Collections.EMPTY_SET : concurrentHashMap.entrySet();
    }

    public void d(C4894a<?> c4894a) {
        w.b(c4894a);
        synchronized (this) {
            try {
                Queue<C4894a<?>> queue = this.f32938b;
                if (queue != null) {
                    queue.add(c4894a);
                    return;
                }
                for (Map.Entry<InterfaceC4895b<Object>, Executor> entry : b(c4894a)) {
                    entry.getValue().execute(RunnableC4140p.a(entry, c4894a));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

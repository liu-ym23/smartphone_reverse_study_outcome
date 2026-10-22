package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f2722a;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f2723b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2724c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2725d = new LinkedHashMap();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @SuppressLint({"NewApi"})
    public static final class a implements Consumer<WindowLayoutInfo> {

        /* renamed from: a, reason: collision with root package name */
        public final Activity f2726a;

        /* renamed from: c, reason: collision with root package name */
        public m f2728c;

        /* renamed from: b, reason: collision with root package name */
        public final ReentrantLock f2727b = new ReentrantLock();

        /* renamed from: d, reason: collision with root package name */
        public final LinkedHashSet f2729d = new LinkedHashSet();

        public a(Activity activity) {
            this.f2726a = activity;
        }

        public final void a(androidx.fragment.app.m mVar) {
            ReentrantLock reentrantLock = this.f2727b;
            reentrantLock.lock();
            try {
                m mVar2 = this.f2728c;
                if (mVar2 != null) {
                    mVar.accept(mVar2);
                }
                this.f2729d.add(mVar);
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.function.Consumer
        public final void accept(WindowLayoutInfo windowLayoutInfo) {
            WindowLayoutInfo value = windowLayoutInfo;
            kotlin.jvm.internal.g.f(value, "value");
            ReentrantLock reentrantLock = this.f2727b;
            reentrantLock.lock();
            try {
                this.f2728c = e.b(this.f2726a, value);
                Iterator it = this.f2729d.iterator();
                while (it.hasNext()) {
                    ((u0.a) it.next()).accept(this.f2728c);
                }
                lb.n nVar = lb.n.f10413a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public d(WindowLayoutComponent windowLayoutComponent) {
        this.f2722a = windowLayoutComponent;
    }

    @Override // androidx.window.layout.k
    public final void a(u0.a<m> callback) {
        kotlin.jvm.internal.g.f(callback, "callback");
        ReentrantLock reentrantLock = this.f2723b;
        reentrantLock.lock();
        try {
            Activity activity = (Activity) this.f2725d.get(callback);
            if (activity == null) {
                reentrantLock.unlock();
                return;
            }
            a aVar = (a) this.f2724c.get(activity);
            if (aVar == null) {
                reentrantLock.unlock();
                return;
            }
            LinkedHashSet linkedHashSet = aVar.f2729d;
            ReentrantLock reentrantLock2 = aVar.f2727b;
            reentrantLock2.lock();
            try {
                linkedHashSet.remove(callback);
                reentrantLock2.unlock();
                if (linkedHashSet.isEmpty()) {
                    this.f2722a.removeWindowLayoutInfoListener(aVar);
                }
                lb.n nVar = lb.n.f10413a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // androidx.window.layout.k
    public final void b(Activity activity, t1.b bVar, androidx.fragment.app.m mVar) {
        lb.n nVar;
        LinkedHashMap linkedHashMap = this.f2724c;
        ReentrantLock reentrantLock = this.f2723b;
        reentrantLock.lock();
        try {
            a aVar = (a) linkedHashMap.get(activity);
            LinkedHashMap linkedHashMap2 = this.f2725d;
            if (aVar == null) {
                nVar = null;
            } else {
                aVar.a(mVar);
                linkedHashMap2.put(mVar, activity);
                nVar = lb.n.f10413a;
            }
            if (nVar == null) {
                a aVar2 = new a(activity);
                linkedHashMap.put(activity, aVar2);
                linkedHashMap2.put(mVar, activity);
                aVar2.a(mVar);
                this.f2722a.addWindowLayoutInfoListener(activity, aVar2);
            }
            lb.n nVar2 = lb.n.f10413a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}

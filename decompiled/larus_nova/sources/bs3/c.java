package bs3;

import com.bytedance.apm.core.ActivityLifeObserver;
import cs3.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes14.dex */
public abstract class c<T extends cs3.b> implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f20239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f20240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f20241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, T> f20242e;

    public abstract void j(T r100, long r101, long r102);

    public String getType() {
        return this.f20238a;
    }

    public c(String r100) {
        this.f20242e = new ConcurrentHashMap();
        this.f20238a = r100;
        this.f20240c = ActivityLifeObserver.getInstance().isForeground();
        this.f20239b = System.currentTimeMillis();
        this.f20241d = ds3.a.c(com.bytedance.apm.d.getContext());
    }

    @Override // bs3.l
    public final void b(boolean r100) {
        long r101 = System.currentTimeMillis();
        if (this.f20242e.size() == 0) goto L5;
        k(this.f20239b, r101, r100);
    L5:
        this.f20239b = r101;
    }

    @Override // bs3.l
    public void f(boolean r100) {
        this.f20240c = false;
    }

    @Override // bs3.l
    public void h(boolean r100) {
        this.f20240c = true;
    }

    public void k(long r100, long r110, boolean r111) {
        Iterator<Map.Entry<Integer, T>> r112 = this.f20242e.entrySet().iterator();
    L4:
        if (r112.hasNext() == false) goto L19;
        T r101 = r112.next().getValue();
        long r102 = r101.f465172b;
        if (0 >= r102) goto L11;
        if (r102 >= r101.f465171a) goto L11;
        r112.remove();
    L11:
        if (0 >= r102) goto L16;
        if (r102 >= r100) goto L16;
        r112.remove();
    L16:
        if (r110 < r101.f465171a) goto L4;
        j(r101, r100, r110);
        goto L4
    }
}

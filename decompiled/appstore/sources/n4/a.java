package n4;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IRequest, Runnable, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f22386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f22387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22389d;

    public a() {
        this.f22386a = new AtomicBoolean(false);
        this.f22387b = new AtomicBoolean(false);
        this.f22388c = 0;
    }

    public int a() {
        return this.f22388c;
    }

    public boolean b() {
        return this.f22387b.get();
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public abstract a e(int r10);
}

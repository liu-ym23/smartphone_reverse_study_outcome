package ar1;

import android.os.Looper;
import com.bytedance.android.livesdk.log.filter.o;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T> implements o<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f16001b;

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void setData(T r100) {
    }

    public a() {
        this.f16001b = Collections.synchronizedMap(new HashMap());
    }

    public final boolean H() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final Map<String, String> getMap() {
        return this.f16001b;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void a(Map<String, String> r100) {
        if (H() == true) goto L5;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L5:
        r100.putAll(this.f16001b);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void putAll(Map<String, String> r100) {
        if (H() == true) goto L5;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L5:
        this.f16001b.putAll(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void remove(String r100) {
        this.f16001b.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void c(String r100, String r101) {
        if (H() == true) goto L5;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L5:
        this.f16001b.put(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void u(Map<String, String> r100, T r101) {
        if (H() == true) goto L5;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L5:
        r100.putAll(this.f16001b);
    }
}

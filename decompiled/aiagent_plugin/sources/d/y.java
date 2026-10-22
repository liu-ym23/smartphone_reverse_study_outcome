package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class y<T> implements f<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.h.a.a<? extends T> f38693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f38694b;

    public y(d.h.a.a<? extends T> r3) {
        d.h.a.a<? extends T> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "initializer");
        this.f38693a = r4;
        this.f38694b = v.f38691a;
    }

    @Override // d.f
    public T b() {
        if (this.f38694b != v.f38691a) goto L6;
        d.h.a.a<? extends T> r0 = this.f38693a;
        d.h.b.o.a(r0);
        this.f38694b = r0.invoke();
        this.f38693a = null;
    L6:
        return (T) this.f38694b;
    }

    public boolean a() {
        if (this.f38694b == v.f38691a) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (a() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(b());
    }
}

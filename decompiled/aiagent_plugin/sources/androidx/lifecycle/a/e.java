package androidx.lifecycle.a;

import androidx.lifecycle.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InitializerViewModelFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e<T extends aj> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f1970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<a, T> f1971b;

    public e(Class<T> r3, d.h.a.b<? super a, ? extends T> r4) {
        d.h.a.b<a, T> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "clazz");
        o.e(r5, "initializer");
        this.f1970a = r3;
        this.f1971b = r5;
    }

    public final Class<T> a() {
        return this.f1970a;
    }

    public final d.h.a.b<a, T> b() {
        return this.f1971b;
    }
}

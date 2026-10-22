package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b.a f1943b;

    ReflectiveGenericLifecycleObserver(Object r2) {
        this.f1942a = r2;
        this.f1943b = b.f2038a.b(r2.getClass());
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r3, i.a r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        this.f1943b.a(r5, r4, this.f1942a);
    }
}

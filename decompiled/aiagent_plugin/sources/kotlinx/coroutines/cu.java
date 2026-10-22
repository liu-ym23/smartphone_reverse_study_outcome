package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes4.dex */
final class cu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ai f39213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n<d.x> f39214b;

    public cu(ai r3, n<? super d.x> r4) {
        n<d.x> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        this.f39213a = r3;
        this.f39214b = r5;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f39214b.a(this.f39213a, d.x.f38692a);
    }
}

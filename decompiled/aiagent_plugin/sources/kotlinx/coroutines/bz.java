package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
final class bz extends ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bw f39178a;

    public bz(bw r3) {
        this.f39178a = (bw) ZeusTransformUtils.wrapperContextForParams(r3, bw.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.bw
    public void a(Throwable r1) {
        this.f39178a.a(r1);
    }
}

package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class bh extends ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bf f39150a;

    public bh(bf r3) {
        this.f39150a = (bf) ZeusTransformUtils.wrapperContextForParams(r3, bf.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.bw
    public void a(Throwable r1) {
        this.f39150a.dispose();
    }
}

package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes4.dex */
final class bg implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bf f39149a;

    public bg(bf r3) {
        this.f39149a = (bf) ZeusTransformUtils.wrapperContextForParams(r3, bf.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable r1) {
        this.f39149a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f39149a + ']';
    }
}

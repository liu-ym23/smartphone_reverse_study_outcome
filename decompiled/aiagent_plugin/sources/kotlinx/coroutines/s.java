package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<?> f39441a;

    public s(o<?> r1) {
        this.f39441a = r1;
    }

    @Override // kotlinx.coroutines.bw
    public void a(Throwable r3) {
        o<?> r4 = this.f39441a;
        r4.c(r4.a((ca) ZeusTransformUtils.preCheckCast(c(), ca.class, "com.obric.aiagent.plugin")));
    }
}

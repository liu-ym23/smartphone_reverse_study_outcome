package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface m extends cq {

    /* JADX INFO: compiled from: CancellableContinuationImpl.kt */
    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.h.a.b<Throwable, d.x> f39434a;

        public a(d.h.a.b<? super Throwable, d.x> r3) {
            this.f39434a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // kotlinx.coroutines.m
        public void a(Throwable r1) {
            this.f39434a.invoke(r1);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + ar.b(this.f39434a) + '@' + ar.a(this) + ']';
        }
    }

    void a(Throwable r1);
}

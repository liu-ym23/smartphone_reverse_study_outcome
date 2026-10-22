package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CompletionHandler.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface bw {

    /* JADX INFO: compiled from: CompletionHandler.common.kt */
    public static final class a implements bw {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.h.a.b<Throwable, d.x> f39172a;

        public a(d.h.a.b<? super Throwable, d.x> r3) {
            this.f39172a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // kotlinx.coroutines.bw
        public void a(Throwable r1) {
            this.f39172a.invoke(r1);
        }

        public String toString() {
            return "InternalCompletionHandler.UserSupplied[" + ar.b(this.f39172a) + '@' + ar.a(this) + ']';
        }
    }

    void a(Throwable r1);
}

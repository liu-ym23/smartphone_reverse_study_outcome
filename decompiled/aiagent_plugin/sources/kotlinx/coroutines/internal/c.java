package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
final class c extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f39388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f39389b = null;

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    public static final class a extends ClassValue<d.h.a.b<? super Throwable, ? extends Throwable>> {
        a() {
        }

        @Override // java.lang.ClassValue
        public /* synthetic */ d.h.a.b<? super Throwable, ? extends Throwable> computeValue(Class r1) {
            return a(r1);
        }

        public d.h.a.b<Throwable, Throwable> a(Class<?> r1) {
            d.h.b.o.a(r1, "null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
            return p.a(r1);
        }
    }

    private c() {
    }

    static {
        f39388a = new c();
        f39389b = new a();
    }

    @Override // kotlinx.coroutines.internal.k
    public d.h.a.b<Throwable, Throwable> a(Class<? extends Throwable> r2) {
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(f39389b.get(r2), d.h.a.b.class, "com.obric.aiagent.plugin");
    }
}

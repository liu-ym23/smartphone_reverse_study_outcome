package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bp extends ai implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39166a = null;

    /* JADX INFO: compiled from: Executors.kt */
    public static final class a extends d.c.b<ai, bp> {

        /* JADX INFO: renamed from: kotlinx.coroutines.bp$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Executors.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<d.c.g.b, bp> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final AnonymousClass1 f39167a = null;

            static {
                f39167a = new AnonymousClass1();
            }

            AnonymousClass1() {
                super(1);
            }

            public final bp a(d.c.g.b r2) {
                d.c.g.b r1 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.b.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r1, bp.class) == true) goto L7;
                return null;
            L7:
                return (bp) ZeusTransformUtils.preCheckCast(r1, bp.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ bp invoke(d.c.g.b r3) {
                return a((d.c.g.b) ZeusTransformUtils.preCheckCast(r3, d.c.g.b.class, "com.obric.aiagent.plugin"));
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
            super((d.c.g.c) ZeusTransformUtils.preCheckCast(ai.f38837c, d.c.g.c.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(AnonymousClass1.f39167a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f39166a = new a(null);
    }

    public abstract Executor a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public bp() {
    }
}

package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f2101a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadFactory f2102c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f2103d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Executor f2104e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f2105b;
    private volatile b f;

    private static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(r3.obj, a.class, "com.obric.aiagent.plugin");
            int r4 = r3.what;
            if (r4 != 1) goto L5;
            r2.f2107a.c(r2.f2108b[0]);
            return;
        L5:
            if (r4 != 2) goto L11;
            r2.f2107a.a(r2.f2108b);
            return;
        }
    }

    private static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ModernAsyncTask f2107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Data[] f2108b;
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f2109a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f2110b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f2111c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f2112d = null;

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f2112d.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("PENDING", 0);
            f2109a = r0;
            b r1 = new b("RUNNING", 1);
            f2110b = r1;
            b r3 = new b("FINISHED", 2);
            f2111c = r3;
            f2112d = new b[]{r0, r1, r3};
        }
    }

    public void a() {
    }

    public void a(Result r1) {
    }

    public void a(Progress... r1) {
    }

    static {
        ThreadFactory r7 = new AnonymousClass1();
        f2102c = r7;
        LinkedBlockingQueue r6 = new LinkedBlockingQueue(10);
        f2103d = r6;
        ThreadPoolExecutor r8 = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, r6, r7);
        f2101a = r8;
        f2104e = r8;
    }

    public void b(Result r1) {
        a();
    }

    public final boolean b() {
        return this.f2105b.get();
    }

    void c(Result r2) {
        if (b() == false) goto L5;
        b(r2);
    L6:
        this.f = b.f2111c;
        return;
    L5:
        a(r2);
        goto L6
    }
}

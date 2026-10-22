package d.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: d.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    private static final class C1037a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1037a f38428a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f38429b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f38430c = null;

        private C1037a() {
        }

        static {
            f38428a = new C1037a();
            Method[] r1 = Throwable.class.getMethods();
            o.a(r1);
            int r2 = r1.length;
            int r3 = 0;
            int r4 = 0;
        L3:
            Method r5 = null;
            if (r4 >= r2) goto L14;
            Method r6 = r1[r4];
            if (o.a(r6.getName(), "addSuppressed") == false) goto L10;
            Class<?>[] r7 = r6.getParameterTypes();
            o.c(r7, "getParameterTypes(...)");
            if (o.a(i.d((Object[]) ZeusTransformUtils.preCheckCast(r7, Object[].class, "com.obric.aiagent.plugin")), Throwable.class) == false) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == true) goto L15;
            r4 = r4 + 1;
        L15:
            f38429b = r6;
            int r0 = r1.length;
        L16:
            if (r3 >= r0) goto L21;
            Method r9 = r1[r3];
            if (o.a(r9.getName(), "getSuppressed") == true) goto L19;
            r3 = r3 + 1;
            goto L16
        L19:
            r5 = r9;
        L21:
            f38430c = r5;
            return;
        L10:
            r8 = false;
            goto L11
        L14:
            r6 = null;
            goto L15
        }
    }

    public a() {
    }

    public void a(Throwable r3, Throwable r4) {
        o.e(r3, "cause");
        o.e(r4, "exception");
        Method r2 = C1037a.f38429b;
        if (r2 == null) goto L6;
        r2.invoke(r3, new Object[]{r4});
        return;
    }

    public d.k.c a() {
        return (d.k.c) ZeusTransformUtils.preCheckCast(new d.k.b(), d.k.c.class, "com.obric.aiagent.plugin");
    }
}

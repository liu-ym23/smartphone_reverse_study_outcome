package uf;

import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.collections.n;
import kotlin.jvm.internal.q;
import kotlin.random.Random;
import kotlin.text.e;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: uf.a$a, reason: collision with other inner class name */
    public static final class C0390a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0390a f24934a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f24935b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f24936c = null;

        static {
            f24934a = new C0390a();
            Method[] r10 = Throwable.class.getMethods();
            q.d(r10);
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            Method r14 = null;
            if (r13 >= r11) goto L11;
            Method r15 = r10[r13];
            if (q.b(r15.getName(), "addSuppressed") == false) goto L10;
            Class<?>[] r16 = r15.getParameterTypes();
            q.f(r16, "getParameterTypes(...)");
            if (q.b(n.E(r16), Throwable.class) == false) goto L10;
        L12:
            f24935b = r15;
            int r17 = r10.length;
        L13:
            if (r12 >= r17) goto L18;
            Method r18 = r10[r12];
            if (q.b(r18.getName(), "getSuppressed") == true) goto L16;
            r12 = r12 + 1;
            goto L13
        L16:
            r14 = r18;
        L18:
            f24936c = r14;
            return;
        L10:
            r13 = r13 + 1;
            goto L3
        L11:
            r15 = null;
            goto L12
        }

        public C0390a() {
        }
    }

    public a() {
    }

    public void a(Throwable r10, Throwable r11) {
        q.g(r10, "cause");
        q.g(r11, "exception");
        Method r12 = C0390a.f24935b;
        if (r12 == null) goto L6;
        r12.invoke(r10, new Object[]{r11});
        return;
    }

    public Random b() {
        return new kotlin.random.b();
    }

    public abstract e c(MatchResult r10, String r11);
}

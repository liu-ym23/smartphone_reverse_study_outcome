package wf;

import bg.c;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.q;
import kotlin.random.Random;
import kotlin.text.e;

/* JADX INFO: loaded from: classes4.dex */
public class a extends vf.a {

    /* JADX INFO: renamed from: wf.a$a, reason: collision with other inner class name */
    public static final class C0403a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0403a f25404a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f25405b = null;

        static {
            f25404a = new C0403a();
            Integer r10 = null;
            Object r11 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L14
            if ((r11 instanceof Integer) == false) goto L7;
            Integer r12 = (Integer) r11;     // Catch: Throwable -> L14
        L8:
            if (r12 != null) goto L10;
        L12:
            f25405b = r10;
            return;
        L10:
            if (r12.intValue() <= 0) goto L12;
            r10 = r12;
        L7:
            r12 = null;
            goto L8
        }

        public C0403a() {
        }
    }

    public a() {
    }

    @Override // uf.a
    public Random b() {
        if (d(34) == false) goto L6;
        return new ag.a();
    L6:
        return super.b();
    }

    @Override // uf.a
    public e c(MatchResult r10, String r11) {
        q.g(r10, "matchResult");
        q.g(r11, "name");
        if ((r10 instanceof Matcher) == false) goto L5;
        Matcher r12 = (Matcher) r10;
    L6:
        if (r12 == null) goto L12;
        c r13 = new c(r12.start(r11), r12.end(r11) - 1);
        if (r13.i().intValue() < 0) goto L13;
        String r14 = r12.group(r11);
        q.f(r14, "group(...)");
        return new e(r14, r13);
    L13:
        return null;
    L12:
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    L5:
        r12 = null;
        goto L6
    }

    public final boolean d(int r10) {
        Integer r11 = C0403a.f25405b;
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.intValue() >= r10) goto L8;
        return false;
    }
}

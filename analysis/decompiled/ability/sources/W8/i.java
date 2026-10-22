package W8;

import j9.m;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import u1.C2031a;

/* loaded from: classes4.dex */
public class i implements l {
    public static final String d = m.M0(i.class.getCanonicalName(), "");
    public static final b e = new b("NO_LOCKS", a.f1493a);

    /* renamed from: a, reason: collision with root package name */
    public final k f1495a;
    public final a b;
    public final String c;

    public i(String str) {
        this(str, new C2031a(new ReentrantLock()));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W8.i.a(int):void");
    }

    public static void f(AssertionError assertionError) {
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!stackTrace[i].getClassName().startsWith(d)) {
                break;
            } else {
                i++;
            }
        }
        List listSubList = Arrays.asList(stackTrace).subList(i, length);
        assertionError.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
    }

    public final h b(S7.a aVar) {
        return new h(this, aVar);
    }

    public final e c(S7.k kVar) {
        return new e(this, new ConcurrentHashMap(3, 1.0f, 2), kVar, 1);
    }

    public final kotlin.reflect.jvm.internal.impl.storage.b d(S7.k kVar) {
        return new kotlin.reflect.jvm.internal.impl.storage.b(this, new ConcurrentHashMap(3, 1.0f, 2), kVar);
    }

    public C4.a e(Object obj, String str) {
        StringBuilder sb = new StringBuilder("Recursion detected ");
        sb.append(str);
        sb.append(obj == null ? "" : androidx.appfunctions.metadata.a.j(obj, "on input: "));
        sb.append(" under ");
        sb.append(this);
        AssertionError assertionError = new AssertionError(sb.toString());
        f(assertionError);
        throw assertionError;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" (");
        return B7.a.q(sb, this.c, ")");
    }

    public i(String str, k kVar) {
        a aVar = a.b;
        this.f1495a = kVar;
        this.b = aVar;
        this.c = str;
    }
}

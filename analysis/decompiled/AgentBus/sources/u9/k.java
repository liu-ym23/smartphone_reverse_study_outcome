package u9;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import o4.d0;

/* loaded from: classes.dex */
public class k implements n {

    /* renamed from: d, reason: collision with root package name */
    public static final String f10206d = ga.k.K0(k.class.getCanonicalName(), ".", "");

    /* renamed from: e, reason: collision with root package name */
    public static final b f10207e = new b("NO_LOCKS", a.f10192f);

    /* renamed from: a, reason: collision with root package name */
    public final m f10208a;

    /* renamed from: b, reason: collision with root package name */
    public final a f10209b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10210c;

    public k(String str) {
        this(str, new d0(11, new ReentrantLock()));
    }

    public static void e(AssertionError assertionError) {
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (!stackTrace[i2].getClassName().startsWith(f10206d)) {
                break;
            } else {
                i2++;
            }
        }
        List listSubList = Arrays.asList(stackTrace).subList(i2, length);
        assertionError.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
    }

    public final i a(p7.a aVar) {
        return new i(this, aVar);
    }

    public final e b(p7.k kVar) {
        return new e(this, new ConcurrentHashMap(3, 1.0f, 2), kVar, 1);
    }

    public final b0.e c(p7.k kVar) {
        return new b0.e(this, new ConcurrentHashMap(3, 1.0f, 2), kVar, 2);
    }

    public a7.c d(Object obj, String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder("Recursion detected ");
        sb2.append(str);
        if (obj == null) {
            str2 = "";
        } else {
            str2 = "on input: " + obj;
        }
        sb2.append(str2);
        sb2.append(" under ");
        sb2.append(this);
        AssertionError assertionError = new AssertionError(sb2.toString());
        e(assertionError);
        throw assertionError;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        sb2.append(" (");
        return a1.a.m(sb2, this.f10210c, ")");
    }

    public k(String str, m mVar) {
        a aVar = a.f10193g;
        this.f10208a = mVar;
        this.f10209b = aVar;
        this.f10210c = str;
    }
}

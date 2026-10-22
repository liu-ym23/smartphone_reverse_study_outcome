package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38560a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f38561b;

    /* JADX INFO: compiled from: Result.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Result.kt */
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f38562a;

        public b(Throwable r2) {
            d.h.b.o.e(r2, "exception");
            this.f38562a = r2;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (d.h.b.o.a(this.f38562a, ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).f38562a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.f38562a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f38562a + ')';
        }
    }

    static {
        f38560a = new a(null);
    }

    public static boolean a(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, n.class) == true) goto L6;
        return false;
    L6:
        if (d.h.b.o.a(r3, ((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin")).a()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static int e(Object r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.hashCode();
    }

    public static <T> Object f(Object r0) {
        return r0;
    }

    public static final /* synthetic */ n g(Object r1) {
        return new n(r1);
    }

    public final /* synthetic */ Object a() {
        return this.f38561b;
    }

    public boolean equals(Object r1) {
        return a(this.f38561b, r1);
    }

    public int hashCode() {
        return e(this.f38561b);
    }

    private /* synthetic */ n(Object r1) {
        this.f38561b = r1;
    }

    public static final boolean a(Object r1) {
        return !ZeusTransformUtils.instanceOf(r1, b.class);
    }

    public static final boolean b(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, b.class);
    }

    public static final Throwable c(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L7;
        return null;
    L7:
        return ((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin")).f38562a;
    }

    public String toString() {
        return d(this.f38561b);
    }

    public static String d(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L6;
        return r2.toString();
    L6:
        return "Success(" + r2 + ')';
    }
}

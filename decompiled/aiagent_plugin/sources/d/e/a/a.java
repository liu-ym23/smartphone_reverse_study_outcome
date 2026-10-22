package d.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes4.dex */
public class a extends d.e.a {

    /* JADX INFO: renamed from: d.e.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
    private static final class C1038a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1038a f38431a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f38432b = null;

        private C1038a() {
        }

        static {
            f38431a = new C1038a();
            Integer r1 = null;
            Object r2 = ZeusTransformUtils.forName("android.os.Build$VERSION", "com.obric.aiagent.plugin").getField("SDK_INT").get(null);     // Catch: Throwable -> L17
            if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L7;
            Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        L8:
            if (r3 != null) goto L10;
        L15:
            f38432b = r1;
            return;
        L10:
            if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L12;
            boolean r0 = true;
        L13:
            if (r0 == false) goto L15;
            r1 = r3;
            goto L15
        L12:
            r0 = false;
        L7:
            r3 = null;
            goto L8
        }
    }

    public a() {
    }

    private final boolean a(int r1) {
        if (C1038a.f38432b != null) goto L5;
    L8:
        return true;
    L5:
        if (C1038a.f38432b.intValue() >= r1) goto L8;
        return false;
    }

    @Override // d.e.a
    public void a(Throwable r2, Throwable r3) {
        o.e(r2, "cause");
        o.e(r3, "exception");
        if (a(19) == false) goto L5;
        r2.addSuppressed(r3);
        return;
    L5:
        super.a(r2, r3);
    }
}

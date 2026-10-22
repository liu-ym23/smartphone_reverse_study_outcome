package d.e.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.k.c;

/* JADX INFO: compiled from: JDK8PlatformImplementations.kt */
/* JADX INFO: loaded from: classes4.dex */
public class a extends d.e.a.a {

    /* JADX INFO: renamed from: d.e.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JDK8PlatformImplementations.kt */
    private static final class C1039a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1039a f38434a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f38435b = null;

        private C1039a() {
        }

        static {
            f38434a = new C1039a();
            Integer r1 = null;
            Object r2 = ZeusTransformUtils.forName("android.os.Build$VERSION", "com.obric.aiagent.plugin").getField("SDK_INT").get(null);     // Catch: Throwable -> L17
            if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L7;
            Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        L8:
            if (r3 != null) goto L10;
        L15:
            f38435b = r1;
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
        if (C1039a.f38435b != null) goto L5;
    L8:
        return true;
    L5:
        if (C1039a.f38435b.intValue() >= r1) goto L8;
        return false;
    }

    @Override // d.e.a
    public c a() {
        if (a(34) == false) goto L6;
        return (c) ZeusTransformUtils.preCheckCast(new d.k.a.a(), c.class, "com.obric.aiagent.plugin");
    L6:
        return super.a();
    }
}

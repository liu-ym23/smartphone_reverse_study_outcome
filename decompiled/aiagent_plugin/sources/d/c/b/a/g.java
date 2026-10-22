package d.c.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static final StackTraceElement a(a r4) {
        o.e(r4, "<this>");
        f r0 = b(r4);
        if (r0 != null) goto L6;
        return null;
    L6:
        a(1, r0.a());
        int r1 = c(r4);
        if (r1 >= 0) goto L9;
        int r2 = -1;
    L10:
        String r5 = i.f38410a.a(r4);
        if (r5 != null) goto L13;
        String r6 = r0.e();
    L15:
        return new StackTraceElement(r6, r0.d(), r0.b(), r2);
    L13:
        r6 = r5 + '/' + r0.e();
        goto L15
    L9:
        r2 = r0.c()[r1];
        goto L10
    }

    private static final f b(a r2) {
        return (f) ZeusTransformUtils.preCheckCast(r2.getClass().getAnnotation(f.class), f.class, "com.obric.aiagent.plugin");
    }

    private static final int c(a r3) {
        Field r0 = r3.getClass().getDeclaredField("label");     // Catch: Exception -> L11
        r0.setAccessible(true);     // Catch: Exception -> L11
        Object r4 = r0.get(r3);     // Catch: Exception -> L11
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L5;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
    L6:
        if (r5 == null) goto L9;
        int r6 = r5.intValue();     // Catch: Exception -> L11
    L15:
        return r6 - 1;
    L9:
        r6 = 0;
        goto L15
    L5:
        r5 = null;
    L11:
        return -1;
    }

    private static final void a(int r3, int r4) {
        if (r4 > r3) goto L5;
        return;
    L5:
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + r3 + ", got " + r4 + ". Please update the Kotlin standard library.").toString());
    }
}

package tf;

import com.bytedanceos.common.toolbox.ServerElements;
import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final void a(int r10, int r11) {
        if (r11 > r10) goto L5;
        return;
    L5:
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + r10 + ", got " + r11 + ". Please update the Kotlin standard library.").toString());
    }

    public static final DebugMetadata b(BaseContinuationImpl r10) {
        return (DebugMetadata) r10.getClass().getAnnotation(DebugMetadata.class);
    }

    public static final int c(BaseContinuationImpl r10) {
        Field r11 = r10.getClass().getDeclaredField(ServerElements.LABEL);     // Catch: Exception -> L11
        r11.setAccessible(true);     // Catch: Exception -> L11
        Object r12 = r11.get(r10);     // Catch: Exception -> L11
        if ((r12 instanceof Integer) == false) goto L5;
        Integer r13 = (Integer) r12;     // Catch: Exception -> L11
    L6:
        if (r13 == null) goto L9;
        int r14 = r13.intValue();     // Catch: Exception -> L11
    L15:
        return r14 - 1;
    L9:
        r14 = 0;
        goto L15
    L5:
        r13 = null;
    L11:
        return -1;
    }

    public static final StackTraceElement d(BaseContinuationImpl r10) {
        q.g(r10, "<this>");
        DebugMetadata r11 = b(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        a(1, r11.v());
        int r12 = c(r10);
        if (r12 >= 0) goto L9;
        int r13 = -1;
    L10:
        String r14 = e.f24805a.b(r10);
        if (r14 != null) goto L13;
        String r15 = r11.c();
    L15:
        return new StackTraceElement(r15, r11.m(), r11.f(), r13);
    L13:
        r15 = r14 + '/' + r11.c();
        goto L15
    L9:
        r13 = r11.l()[r12];
        goto L10
    }
}

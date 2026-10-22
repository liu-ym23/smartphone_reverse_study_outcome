package e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import e.x;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final int a(int[] r2, int r3, int r4, int r5) {
        o.e(r2, "<this>");
        int r6 = r5 - 1;
    L3:
        if (r4 > r6) goto L11;
        int r0 = (r4 + r6) >>> 1;
        int r1 = r2[r0];
        if (r1 < r3) goto L6;
        if (r1 <= r3) goto L9;
        r6 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return (-r4) - 1;
    }

    public static final int a(x r3, int r4) {
        o.e(r3, "<this>");
        int r5 = a(r3.p(), r4 + 1, 0, ((Object[]) ZeusTransformUtils.preCheckCast(r3.o(), Object[].class, "com.obric.aiagent.plugin")).length);
        if (r5 < 0) goto L6;
        return r5;
    L6:
        return ~r5;
    }
}

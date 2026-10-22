package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes4.dex */
class x extends w {
    public static final /* synthetic */ int a(List r2, int r3) {
        return d((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3);
    }

    public static final /* synthetic */ int b(List r2, int r3) {
        return e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3);
    }

    public static final /* synthetic */ int c(List r2, int r3) {
        return f((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3);
    }

    private static final int d(List<?> r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        return p.b(r6) - r5;
    L12:
        throw new IndexOutOfBoundsException("Element index " + r5 + " must be in range [" + new d.l.j(0, p.b(r6)) + "].");
    L5:
        if (r5 > p.b(r6)) goto L7;
        r1 = true;
        goto L8
    }

    private static final int e(List<?> r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        return r6.size() - r5;
    L12:
        throw new IndexOutOfBoundsException("Position index " + r5 + " must be in range [" + new d.l.j(0, r6.size()) + "].");
    L5:
        if (r5 > r6.size()) goto L7;
        r1 = true;
        goto L8
    }

    private static final int f(List<?> r2, int r3) {
        return p.b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")) - r3;
    }

    public static final <T> List<T> h(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (List) ZeusTransformUtils.preCheckCast(new av(r3), List.class, "com.obric.aiagent.plugin");
    }

    public static final <T> List<T> i(List<T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (List) ZeusTransformUtils.preCheckCast(new au(r3), List.class, "com.obric.aiagent.plugin");
    }
}

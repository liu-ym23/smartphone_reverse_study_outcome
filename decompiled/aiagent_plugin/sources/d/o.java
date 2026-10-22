package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {
    public static final Object a(Throwable r1) {
        d.h.b.o.e(r1, "exception");
        return new n.b(r1);
    }

    public static final void a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, n.b.class) == true) goto L6;
        return;
    L6:
        throw ((n.b) ZeusTransformUtils.preCheckCast(r2, n.b.class, "com.obric.aiagent.plugin")).f38562a;
    }
}
